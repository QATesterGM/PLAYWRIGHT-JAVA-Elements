package GMTester;

import com.microsoft.playwright.assertions.PlaywrightAssertions;
import org.junit.jupiter.api.Test;

import java.nio.file.Paths;

public class _15UploadFileTest extends BaseTest {

    @Test
    void uploadSingleFileTest() {
        page.navigate("http://localhost:7080/upload");
        page.setInputFiles("#file-upload", Paths.get("screenshots/Premier.jpg"));
        page.locator("#file-submit").click();
        PlaywrightAssertions.assertThat(page.locator("#uploaded-files")).hasText("Premier.jpg");
    }
}
