package GMTesterPlaywrightActionsAndElements;

import com.microsoft.playwright.*;
import org.junit.jupiter.api.Test;

public class _20WindowsHandlingTest {
    private Playwright pw = Playwright.create();
    private Browser browser = pw.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(1000));

    @Test
    void should_open_multiple_windows_test() {
        BrowserContext browserContext = browser.newContext();
        Page page = browserContext.newPage();

        page.navigate("http://localhost:7080/login");
        page.locator("#username").fill("tomsmith");
        page.locator("id=password").fill("SuperSecretPassword!");
        page.locator("text=Login").last().click();

        BrowserContext browserContext1 = browser.newContext();
        Page page1 = browserContext1.newPage();

        page1.navigate("http://localhost:7080/login");
        page1.locator("#username").fill("wronglogin");
        page1.locator("id=password").fill("wrongpass");
        page1.locator("text=Login").last().click();
    }
}
