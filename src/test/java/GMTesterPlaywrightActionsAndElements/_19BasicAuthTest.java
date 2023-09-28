package GMTesterPlaywrightActionsAndElements;

import org.junit.jupiter.api.Test;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

class _19BasicAuthTest extends BaseTest {

    @Test
    void basicAuthTest(){
        page.navigate("http://localhost:7080/basic_auth");
        assertThat(page.getByText("Congratulations! You must have the proper credentials.")).isVisible();
    }
}
