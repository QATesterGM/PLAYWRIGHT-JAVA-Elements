package GMTester;

import com.microsoft.playwright.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import java.nio.file.Paths;

public class BaseTest {

    private static Playwright pw;
    private static Browser browser;
    private BrowserContext context;
    protected Page page;

    @BeforeAll
    static void beforeAll() {
        pw = Playwright.create();
        browser = pw.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(1000).setTimeout(5000));
    }

    @BeforeEach
    void beforeEach() {
        context = browser.newContext();

        //USTAWIENIA TRACINGU
        context.tracing().start(new Tracing.StartOptions()
                .setScreenshots(true)
                .setSnapshots(true)
                .setSources(true));

        //NAGRYWANIE FILMOW Z TESTU
//        context = browser.newContext(new Browser.NewContextOptions()
//                .setViewportSize(1920, 1080)
//                .setRecordVideoDir(Paths.get("videos/"))
//                .setRecordVideoSize(1920,1080));

        page = context.newPage();
    }

    @AfterEach
    void afterEach() {
        context.tracing().stop(new Tracing.StopOptions().setPath(Paths.get("traces/trace.zip"))); //zamykanie tracingu
        context.close();
    }

    @AfterAll
    static void afterAll() {
        pw.close();
    }

}
