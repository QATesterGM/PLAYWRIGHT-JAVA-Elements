package GMTester;

import com.microsoft.playwright.options.AriaRole;
import org.junit.jupiter.api.Test;

public class _4DropDownTest extends BaseTest {
    @Test
    void dropDownTest() {
        page.navigate("http://localhost:7080/dropdown");
        //page.selectOption("#dropdown", "Option 2"); // wartosc
        page.selectOption("#dropdown", "1"); // wartosc
    }

    @Test
    void multiselectTest() {
        page.navigate("https://testpages.herokuapp.com/styled/basic-html-form-test.html");
        page.getByRole(AriaRole.LISTBOX).selectOption(new String[]{"ms1", "ms3"});
        page.waitForTimeout(3000); // chwilowe opóźnienie, ale zla praktyka, roboczo dozwolone
    }
}
