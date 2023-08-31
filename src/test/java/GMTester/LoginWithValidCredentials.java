package GMTester;

import GMTester.BaseTest;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.assertions.PlaywrightAssertions;
import com.microsoft.playwright.options.AriaRole;
import org.junit.jupiter.api.Test;

public class LoginWithValidCredentials extends BaseTest {

    @Test
    void should_login_with_valid_credentials() {

        page.navigate("http://localhost:7080/login");
        page.fill("#username", "tomsmith"); //# oznacza "id="
        page.fill("id=password", "SuperSecretPassword!");
        page.click("text=Login");
        //page.locator("text=Login").last().click(); // wielkosc liter nie brana pod uwage
        //page.locator("'Login'").last().click(); // ten sam zapis co na gorze (wielkosc liter brana pod uwage)
        PlaywrightAssertions.assertThat(page.locator("id=flash")).containsText("You logged into a secure area!");
        PlaywrightAssertions.assertThat(page.locator("text=You logged into a secure area!")).isVisible();
        page.click("//i[contains(text(), 'Logout')]");
        PlaywrightAssertions.assertThat(page.locator("id=flash")).containsText("You logged out of the secure area!");

        page.navigate("http://localhost:7080/login");
        page.getByLabel("Username").fill("tomsmith");
        page.getByLabel("password").fill("SuperSecretPassword!");
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Login")).click();
        PlaywrightAssertions.assertThat(page.getByText("You logged into a secure area!")).isVisible();
        page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Logout")).click();
        PlaywrightAssertions.assertThat(page.getByText("You logged out of the secure area!")).isVisible();

    }
}
