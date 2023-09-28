package GMTesterPlaywrightActionsAndElements;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import org.junit.jupiter.api.Test;

public class _18TracingTest extends BaseTest {

    // DOC - https://playwright.dev/java/docs/trace-viewer-intro
    // TRACE - https://trace.playwright.dev/
    // TERMINAL - mvn exec:java -e -D exec.mainClass=com.microsoft.playwright.CLI -D exec.args="show-trace traces/trace.zip"

    @Test
    void tracingTest() {
        page.navigate("http://localhost:7080/");
        page.getByText("Form Authentication").click();
        page.fill("#username", "demouser");
        page.fill("#password", "haslo123");
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Login")).click();
    }

}
