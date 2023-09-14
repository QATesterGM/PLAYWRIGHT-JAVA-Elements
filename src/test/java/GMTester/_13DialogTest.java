package GMTester;

import com.microsoft.playwright.assertions.PlaywrightAssertions;
import org.junit.jupiter.api.Test;

public class _13DialogTest extends BaseTest {

    @Test
    void dialogAllertTest() {
        page.navigate("http://localhost:7080/javascript_alerts");

        //HANDLER ZAWSZE PRZED KLIKNIECIEM!
        //page.onDialog(dialog -> dialog.accept()); // mozemy wstrzykiwac kod w klamrach przed i po linijce
        page.onDialog(dialog -> {
            page.waitForTimeout(2000);
            dialog.accept();
        });// bez tego kodu 14-17 linijka tez przjdzie, bo to deafultowy zapis dla tej opcji

        page.locator("text=Click for JS Alert").click();
        PlaywrightAssertions.assertThat(page.locator("#result")).hasText("You successfuly clicked an alert");
    }

    @Test
    void dialogConfirmTest() { //Domyslna opcja - CANCEL/ANULUJ
        page.navigate("http://localhost:7080/javascript_alerts");

        //HANDLER ZAWSZE PRZED KLIKNIECIEM!
        page.onceDialog(dialog -> {
            page.waitForTimeout(2000);
            dialog.accept();
        });

        page.locator("text=Click for JS Confirm").click();
        PlaywrightAssertions.assertThat(page.locator("#result")).hasText("You clicked: Ok");

        page.onceDialog(dialog -> {  //jezeli chcemy wykorzystac dialog kilka razy z innym skutkiem, zmieniamy na onceDialog
            page.waitForTimeout(2000);
            dialog.dismiss();
        });

        page.locator("text=Click for JS Confirm").click();
        PlaywrightAssertions.assertThat(page.locator("#result")).hasText("You clicked: Cancel");
    }

    @Test
    void dialogPromptTest() {
        page.navigate("http://localhost:7080/javascript_alerts");

        //HANDLER ZAWSZE PRZED KLIKNIĘCIEM
        page.onceDialog(dialog -> {
            page.waitForTimeout(3000); // to do wywalenia oczywiscie
            dialog.accept("Cela jest super!!! <3<3<3 ;* ;* ;*  xD");
            page.waitForTimeout(3000); // to do wywalenia oczywiscie
        });

        page.locator("text=Click for JS Prompt").click();
        PlaywrightAssertions.assertThat(page.locator("#result")).hasText("You entered: Cela jest super!!! <3<3<3 ;* ;* ;*  xD");

    }

}
