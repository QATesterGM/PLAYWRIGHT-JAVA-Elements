package PatternObjectProject.pages.sections;

import PatternObjectProject.pages.BasePage;
import PatternObjectProject.pages.ContactUsPage;
import PatternObjectProject.pages.SignInPage;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class TopMenuSection extends BasePage {

    private Locator contactUsLink;
    private Locator signInLink;

    public TopMenuSection(Page page) {
        super(page);
        this.contactUsLink = page.locator("#contact-link");
        this.signInLink = page.getByText("Sign in");
    }

    public ContactUsPage clickOnContactUsLink() {
        contactUsLink.click();
        return new ContactUsPage(page);
    }

    public SignInPage clickOnSingIn(){
        signInLink.click();
        return new SignInPage(page);
    }
}
