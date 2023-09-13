package GMTester;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.assertions.PlaywrightAssertions;
import org.junit.jupiter.api.Test;

public class _11IFrameTest extends BaseTest {

    @Test
    void should_enter_text_into_the_iframe() {
        page.navigate("http://localhost:7080/iframe");
        //Jeżeli nie ma nazwy to uzywamy page.frameLocator
        page.frameLocator("#mce_0_ifr").locator("#tinymce").fill("CosTam");
    }

    @Test
    void should_get_text_from_nested_frames(){
        page.navigate("http://localhost:7080/nested_frames");
        //Jeżeli jest nazwa/name to uzywamy page.frame
        PlaywrightAssertions.assertThat(page.frame("frame-middle").locator("#content")).hasText("MIDDLE");

    }
}
