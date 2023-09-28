package GMTesterPlaywrightActionsAndElements;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.options.AriaRole;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

public class _10TablesTest extends BaseTest {

    @Test
    void should_return_all_text_from_the_table() {
        page.navigate("http://localhost:7080/tables");
        List<String> strings = page.locator("table#table1 td").allInnerTexts();

        strings.stream()
                .map(String::trim)
                .map(String::toUpperCase)
                .forEach(System.out::println);

    }

    @Test
    void should_return_list_of_users_from_the_table() {
        page.navigate("http://localhost:7080/tables");
        List<Locator> trs = page.locator("table#table1 tbody tr").all(); //tworzymy liste wszystkich linijek z tabeli

        List<TableUser> users = trs.stream()
                .map(tr -> {
                    List<Locator> tds = tr.getByRole(AriaRole.CELL).all(); //tworzymy liste komórek
                    String lastName = tds.get(0).innerText();// dla kazdej linijki wchodzimy do poszczegolnych komorek
                    String firstName = tds.get(1).innerText();
                    String email = tds.get(2).innerText();
                    String due = tds.get(3).innerText();
                    String website = tds.get(4).innerText();
                    Locator action = tds.get(5); // wyciagamy pojedyncze dane
                    return new TableUser(firstName, lastName, email, due, website, action); //zwracamy nowy obiekt utworzony z danych z tabeli
                }).collect(Collectors.toList()); //zbieramy liste utworzonych obiektow


        TableUser frank = users.stream()
                .filter(user -> user.getFirstName().startsWith("Frank"))
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("User not found"));

        frank.getAction().getByText("edit").click();

        page.waitForTimeout(2000);
    }
}
