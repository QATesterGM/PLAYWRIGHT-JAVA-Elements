package GMTester;

import GMgajdalukasz.utils.StringUtils;
import com.microsoft.playwright.*;
import org.junit.jupiter.api.*;

import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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
    void afterEach(TestInfo testInfo) {
        context.close();
    }

    //ZAPISYWANIE TRACEsow wraz z wskazaniem sciezki i nadaniu nazwy testu
//    void afterEach(TestInfo testInfo) {
//        String traceName = "traces/trace_"
//                + StringUtils.removeRoundBrackets(testInfo.getDisplayName())
//                + "_" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd_HH_mm-ss")) + ".zip";
//
//
//        context.tracing().stop(new Tracing.StopOptions().setPath(Paths.get(traceName))); //zamykanie tracingu
//        context.close();
//    }

    @AfterAll
    static void afterAll() {
        pw.close();
    }

}
