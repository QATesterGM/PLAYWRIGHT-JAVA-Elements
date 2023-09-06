package GMTester;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.assertions.PlaywrightAssertions;
import com.microsoft.playwright.options.AriaRole;
import org.junit.jupiter.api.Test;

public class _6AssertionsTest extends BaseTest {

    @Test
    void assertionTest() {

        page.navigate("http://localhost:7080/checkboxes");

        Locator firstCheckbox = page.getByRole(AriaRole.CHECKBOX).first();
        PlaywrightAssertions.assertThat(firstCheckbox).not().isChecked();
        firstCheckbox.check();
        PlaywrightAssertions.assertThat(firstCheckbox).isChecked();


    }
}
