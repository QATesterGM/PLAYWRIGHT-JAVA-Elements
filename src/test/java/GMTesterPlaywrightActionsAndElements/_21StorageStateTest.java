package GMTesterPlaywrightActionsAndElements;

import com.microsoft.playwright.*;
import com.microsoft.playwright.assertions.PlaywrightAssertions;
import org.junit.jupiter.api.Test;

import java.nio.file.Paths;

public class _21StorageStateTest {

    private Playwright pw = Playwright.create();
    private Browser browser = pw.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(1000));

    @Test
    void sould_save_storage_state_after_login(){
        BrowserContext browserContext = browser.newContext();
        Page page = browserContext.newPage();
        page.navigate("http://localhost:7080/login");
        page.locator("#username").fill("tomsmith");
        page.locator("id=password").fill("SuperSecretPassword!");
        page.locator("text=Login").last().click();

        browserContext.storageState(new BrowserContext.StorageStateOptions().setPath(Paths.get("storage/aplogin.json")));

    }

    @Test
    void should_load_storage_state_test(){
        BrowserContext browserContext = browser.newContext(new Browser.NewContextOptions().setStorageStatePath(Paths.get("storage/aplogin.json")));
        Page page = browserContext.newPage();
        page.navigate("http://localhost:7080/login");
        PlaywrightAssertions.assertThat(page.locator("#flash")).hasText("You logged out of the secure area!");
    }
}
