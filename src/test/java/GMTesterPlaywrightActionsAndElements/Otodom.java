package GMTesterPlaywrightActionsAndElements;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import org.junit.jupiter.api.Test;

public class Otodom extends BaseTest {

    @Test
    void should_login_with_valid_credentials() {
        page.navigate("https://www.otomoto.pl/");
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Akceptuję")).click();
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Wyszukiwanie zaawansowane")).click();
        page.getByPlaceholder("Cena od").click();
        page.getByPlaceholder("Cena od").fill("120000");
        page.getByPlaceholder("Cena do").click();
        page.getByPlaceholder("Cena do").fill("150000");
        page.getByPlaceholder("Rok produkcji od").click();
        page.getByPlaceholder("Rok produkcji od").fill("2018");
        page.getByPlaceholder("Rok produkcji do").click();
        page.getByPlaceholder("Rok produkcji do").fill("2020");
        //page.getByTestId("filter_enum_damaged").getByTestId("dropdown-expand-button").click();
        page.getByTestId("filter_enum_damaged").getByTestId("dropdown-expand-button").click();
        //page.locator("input[data-testid=dropdown-head-input]").first().click();
        page.locator("a").filter(new Locator.FilterOptions().setHasText("Nieuszkodzony")).click();
//        page.getByTestId("group-06740f18-530f-11ee-a77c-7e6da7ef4ee5").getByTestId("modal-toggler").click();
//        page.getByLabel("Bezwypadkowy").check();
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Pokaż wyniki")).click();

        page.pause();

    }
}
