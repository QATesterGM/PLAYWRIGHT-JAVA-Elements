package PatternObjectProject;

import GMTesterPlaywrightActionsAndElements.BaseTest;
import PatternObjectProject.dto.CreateAccountDTO;
import PatternObjectProject.pages.HomePage;
import PatternObjectProject.pages.SignInPage;
import com.microsoft.playwright.assertions.PlaywrightAssertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CreateAnAccountTest extends BaseTest {

    private HomePage homePage;

    @BeforeEach
    void beforeEach() {
        homePage = new HomePage(page);
        page.navigate("http://www.automationpractice.pl/");
    }
    @Test
    void should_create_new_account(){
        SignInPage signInPage = homePage.getTopMenuSection().clickOnSingIn();
        signInPage.getCreateAccountSection().createAccount(CreateAccountDTO.getDefaultCreateAccount().getMail());
        signInPage.getCreateAccountFormSection().sendCreateAccountForm(CreateAccountDTO.getDefaultCreateAccount());
        PlaywrightAssertions.assertThat(signInPage.getCreateAccountFormSection().getAccountCreatedMessage()).isVisible();
    }
}
