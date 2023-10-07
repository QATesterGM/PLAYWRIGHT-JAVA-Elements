package PatternObjectProject;

import GMTesterPlaywrightActionsAndElements.BaseTest;
import PatternObjectProject.pages.ContactUsPage;
import PatternObjectProject.pages.HomePage;
import com.microsoft.playwright.assertions.PlaywrightAssertions;
import org.junit.jupiter.api.Test;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.*;

public class SendContactUsFormTest extends BaseTest {

    @Test
    void should_show_an_error_when_trying_to_send_empty_form_test() {
        page.navigate("http://www.automationpractice.pl/");
        HomePage homePage = new HomePage(page);
        ContactUsPage contactUsPage = new ContactUsPage(page);

        homePage.getTopMenuSection().clickOnContactUsLink();
        contactUsPage.getContactUsFormSection().clickSendButton();
        assertThat(contactUsPage.getContactUsFormSection().getErrorMessage()).isVisible();

    }
}
