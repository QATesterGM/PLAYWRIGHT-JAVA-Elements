package GMTester;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.assertions.PlaywrightAssertions;
import org.junit.jupiter.api.Test;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.*;

public class _7RadiobuttonTest extends BaseTest {

    @Test
    void radioButtonTest() {
        page.navigate("https://testpages.herokuapp.com/styled/basic-html-form-test.html");

        Locator radio2 = page.locator("input[value=rd2]");
        assertThat(radio2).isChecked();

        Locator radio1 = page.locator("input[value=rd1]");
        assertThat(radio1).not().isChecked();
        radio1.check();
        assertThat(radio1).isChecked();
        assertThat(radio2).not().isChecked();
    }
}
