package GMTester;

import org.junit.jupiter.api.Test;

public class TextTest extends BaseTest {

    @Test
    void textTest(){
        page.navigate("http://localhost:7080/notification_message_rendered");   }
}
