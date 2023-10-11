package PatternObjectProject.pages;

import PatternObjectProject.pages.sections.CreateAccountFormSection;
import PatternObjectProject.pages.sections.CreateAccountSection;
import com.microsoft.playwright.Page;
import lombok.Getter;

@Getter
public class SignInPage extends BasePage {

    private CreateAccountSection createAccountSection;
    private CreateAccountFormSection createAccountFormSection;

    public SignInPage(Page page) {
        super(page);
        this.createAccountSection = new CreateAccountSection(page);
        this.createAccountFormSection = new CreateAccountFormSection(page);
    }
}
