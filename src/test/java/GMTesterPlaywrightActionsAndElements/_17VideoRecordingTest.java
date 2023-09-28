package GMTesterPlaywrightActionsAndElements;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import org.junit.jupiter.api.Test;

public class _17VideoRecordingTest extends BaseTest {

    @Test
    void videoTest(){
        page.navigate("http://localhost:7080/login");
        page.fill("#username", "demouser");
        page.fill("#password", "haslo123");
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Login")).click();
    }
}
