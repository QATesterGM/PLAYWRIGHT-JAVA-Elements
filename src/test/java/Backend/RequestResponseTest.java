package Backend;

import GMTesterPlaywrightActionsAndElements.BaseTest;
import com.microsoft.playwright.Response;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.nio.charset.StandardCharsets;

import static org.assertj.core.api.Assertions.*;

class RequestResponseTest extends BaseTest {

    @Test
    void should_return_status_code_200_ok_test(){
        Response response = page.navigate("http://skleptestera.pl");

        //STATUS CODE
        //System.out.println(response.status());
        //System.out.println(response.ok());

        // BODY
        //Response body w playright zwraca tablice bajtow, wiec musimy zastosowac takie rozwiazanie ponizej
        //System.out.println(new String(response.body(), StandardCharsets.UTF_8));
        //drugi sposob, lepszy by Playright
        //System.out.println(response.text());

        // HEADEARS
        //System.out.println(response.headers());
        //System.out.println(response.headers().get("content-type"));

        //URL
        //System.out.println(response.url());

        assertThat(response.ok()).isTrue();

    }

    @Test
    void should_return_request_method_get_test(){}

    @Test
    void http_handlers_test(){}
}
