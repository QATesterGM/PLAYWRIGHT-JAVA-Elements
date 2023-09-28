package GMTesterPlaywrightActionsAndElements;

import com.microsoft.playwright.assertions.PlaywrightAssertions;
import org.junit.jupiter.api.Test;

import java.nio.file.Path;
import java.nio.file.Paths;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.*;

public class _15UploadFileTest extends BaseTest {

    @Test
    void uploadSingleFileTest() {
        page.navigate("http://localhost:7080/upload");
        page.setInputFiles("#file-upload", Paths.get("screenshots/Premier.jpg"));
        page.locator("#file-submit").click();
        assertThat(page.locator("#uploaded-files")).hasText("Premier.jpg");
    }

    @Test
    void uploadMultipleFilesTest() {
        page.navigate("https://davidwalsh.name/demo/multiple-file-upload.php");
        page.setInputFiles("#filesToUpload", new Path[]{
                Paths.get("screenshots/Premier.jpg"),
                Paths.get("screenshots/firefox.png")
        });

        page.waitForTimeout(3000);
        PlaywrightAssertions.assertThat(page.locator("#fileList")).hasText("Premier.jpg" + "firefox.png");

    }
}
