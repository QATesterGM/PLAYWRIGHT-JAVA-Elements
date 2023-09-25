package GMTester;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import org.junit.jupiter.api.Test;

import java.nio.file.Paths;

public class _16ScreenshotsTest extends BaseTest {

    @Test
    void screenshotPageTest() {
        page.navigate("http://localhost:7080/");
        page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("screenshots/home.jpg")));
    }

    @Test
    void screenshotElementTest() {
        page.navigate("http://localhost:7080/login");
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Login")).click();
        page.locator("#flash-messages").screenshot(new Locator.ScreenshotOptions().setPath(Paths.get("screenshots/element.jpg")));
    }
}
