package PatternObjectProject.pages;

import PatternObjectProject.pages.sections.ContactUsFormSection;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import lombok.Getter;

public class ContactUsPage extends BasePage{

    @Getter
    private ContactUsFormSection contactUsFormSection;

    public ContactUsPage(Page page) {
        super(page);
        this.contactUsFormSection = new ContactUsFormSection(page);
    }

    public ContactUsFormSection getContactUsFormSection() {
        return contactUsFormSection;
    }
}
