package PatternObjectProject.pages.sections;

import PatternObjectProject.pages.BasePage;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class CreateAccountSection extends BasePage {

    private Locator createEmailInput;
    private Locator submitCreateButton;

    public CreateAccountSection(Page page) {
        super(page);
        this.createEmailInput = page.locator("#email_create");
        this.submitCreateButton = page.locator("#SubmitCreate");
    }

    public CreateAccountSection createAccount(String email){
        createEmailInput.fill(email);
        submitCreateButton.click();
        return this;
    }

}
