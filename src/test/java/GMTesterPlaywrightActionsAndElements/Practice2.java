package GMTesterPlaywrightActionsAndElements;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.junit.jupiter.api.Test;

import java.nio.file.Paths;
import java.util.List;

class Practice2 {

    @Test
    void otodom_site_on_all_browsers_supported() {

        Playwright playwright = Playwright.create();
        List<BrowserType> browsers = List.of(playwright.chromium(), playwright.firefox(), playwright.webkit());

        for (BrowserType browserType : browsers){
            Browser browser = browserType.launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(1000));
            Page page = browser.newPage();
            page.navigate("https://www.otodom.pl/");
            page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("screenshots/" + browserType.name() + ".png")));
        }
    }

}
