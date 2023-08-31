package GMTester.modul_4;

import GMTester.common.BaseTest;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import com.microsoft.playwright.options.MouseButton;
import org.junit.jupiter.api.Test;

public class Otodom extends BaseTest {

    @Test
    void should_login_with_valid_credentials() {
        page.navigate("https://www.otodom.pl/");

    }
}
