package GMTesterPlaywrightActionsAndElements;

import com.microsoft.playwright.Page;
import org.junit.jupiter.api.Test;

public class _2InputTest extends BaseTest {

    @Test
    void inputTest(){

        page.navigate("http://localhost:7080/login");
        page.fill("#username", "Lukasz"); //# oznacza id; wkleja cały tekst
        page.type("#password", "123456"); // wpisuje literke po literce, testy wyszukiwarki

        page.fill("", "wartosc", new Page.FillOptions().setForce(true)); //omijanie pewnego sprawdzenia DMYSLNIE FALSE
        //umozliwia wpisanie wartosci do inputa, ktory jest przykryty przez inny obiekt na froncie

    }
}
