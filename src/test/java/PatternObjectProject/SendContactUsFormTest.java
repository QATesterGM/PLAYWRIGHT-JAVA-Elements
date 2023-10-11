package PatternObjectProject;

import GMTesterPlaywrightActionsAndElements.BaseTest;
import PatternObjectProject.dto.ContactUsDTO;
import PatternObjectProject.pages.ContactUsPage;
import PatternObjectProject.pages.HomePage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.*;

public class SendContactUsFormTest extends BaseTest {

    private HomePage homePage;

    @BeforeEach
    void beforeEach() {
        homePage = new HomePage(page);
        page.navigate("http://www.automationpractice.pl/");
    }

    @Test
    void should_show_an_error_when_trying_to_send_empty_form_test() {
        ContactUsPage contactUsPage = homePage.getTopMenuSection().clickOnContactUsLink();
        contactUsPage.getContactUsFormSection().clickOnSendMessageButton();
        assertThat(contactUsPage.getContactUsFormSection().getErrorMessage()).isVisible();
    }

    @Test
    void should_fill_and_send_contact_us_form_test() {
        ContactUsPage contactUsPage = homePage.getTopMenuSection().clickOnContactUsLink();
        contactUsPage.getContactUsFormSection().sendContactUsForm(ContactUsDTO.getDefaultContactUsDTO());
        assertThat(contactUsPage.getContactUsFormSection().getConfirmationMessage()).isVisible();

    }
}

