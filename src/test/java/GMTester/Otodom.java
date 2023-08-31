package GMTester;

import GMTester.BaseTest;
import org.junit.jupiter.api.Test;

public class Otodom extends BaseTest {

    @Test
    void should_login_with_valid_credentials() {
        page.navigate("https://www.otodom.pl/");

    }
}
