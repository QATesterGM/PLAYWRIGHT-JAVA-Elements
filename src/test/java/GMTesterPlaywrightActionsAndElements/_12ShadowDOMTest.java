package GMTesterPlaywrightActionsAndElements;

import org.junit.jupiter.api.Test;

class _12ShadowDOMTest extends BaseTest {

    @Test
    void shadowDOMTest() {
        page.navigate("http://localhost:7080/shadowdom");
        System.out.println(page.locator("span[slot=my-text]").innerText());
    }

    @Test
    void shadowDOMTest1() {
        page.navigate("https://bugs.chromium.org/p/chromium/issues/list");
        page.selectOption("#can", "New issues");
    }
}
