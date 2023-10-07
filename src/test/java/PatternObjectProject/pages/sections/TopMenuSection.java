package PatternObjectProject.pages.sections;

import PatternObjectProject.pages.BasePage;
import PatternObjectProject.pages.ContactUsPage;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class TopMenuSection extends BasePage {

    private Locator contactUsLink;

    public TopMenuSection(Page page) {
        super(page);
        this.contactUsLink = page.locator("#contact-link");
    }

    public ContactUsPage clickOnContactUsLink() {
        contactUsLink.click();
        return new ContactUsPage(page);
    }
}
