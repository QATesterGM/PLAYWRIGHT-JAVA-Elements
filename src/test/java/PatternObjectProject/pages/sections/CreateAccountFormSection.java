package PatternObjectProject.pages.sections;

import PatternObjectProject.dto.CreateAccountDTO;
import PatternObjectProject.pages.BasePage;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import lombok.Getter;

@Getter
public class CreateAccountFormSection extends BasePage {

    private Locator titleMrRadioButton;
    private Locator titleMrsRadioButton;
    private Locator firstNameInput;
    private Locator lastNameInput;
    private Locator emailInput;
    private Locator passwordInput;
    private Locator dateOfBirthDDSelecet;
    private Locator dateOfBirthMMSelecet;
    private Locator dateOfBirthYYYYSelecet;
    private Locator submitButton;
    private Locator accountCreatedMessage;

    public CreateAccountFormSection(Page page) {
        super(page);
        this.titleMrRadioButton = page.locator("#id_gender1");
        this.titleMrsRadioButton = page.locator("#id_gender2");
        this.firstNameInput = page.locator("#customer_firstname");
        this.lastNameInput = page.locator("#customer_lastname");
        this.emailInput = page.locator("#email");
        this.passwordInput = page.locator("#passwd");
        this.dateOfBirthDDSelecet = page.locator("#days");
        this.dateOfBirthMMSelecet = page.locator("#months");
        this.dateOfBirthYYYYSelecet = page.locator("#years");
        this.submitButton = page.locator("#submitAccount");
        this.accountCreatedMessage = page.getByText("Your account has been created.");
    }

    private CreateAccountFormSection selectMrTitle() {
        titleMrRadioButton.click();
        return this;
    }

    private CreateAccountFormSection fillFirstName(String firstName) {
        firstNameInput.fill(firstName);
        return this;
    }

    private CreateAccountFormSection fillLastName(String lastName) {
        lastNameInput.fill(lastName);
        return this;
    }

    private CreateAccountFormSection fillAddressMail(String mail) {
        emailInput.fill(mail);
        return this;
    }

    private CreateAccountFormSection fillPassword(String password) {
        passwordInput.fill(password);
        return this;
    }

    private CreateAccountFormSection setDayOfBirth(String dayOfBirth) {
        dateOfBirthDDSelecet.selectOption(dayOfBirth);
        return this;
    }

    private CreateAccountFormSection setMonthOfBirth(String monthOfBirth) {
        dateOfBirthMMSelecet.selectOption(monthOfBirth);
        return this;
    }

    private CreateAccountFormSection setYearOfBirth(String yearOfBirth) {
        dateOfBirthYYYYSelecet.selectOption(yearOfBirth);
        return this;
    }

    private CreateAccountFormSection clickOnRegisterButton() {
        submitButton.click();
        return this;
    }

    public CreateAccountFormSection sendCreateAccountForm(CreateAccountDTO createAccountDTO) {
        selectMrTitle();
        fillFirstName(createAccountDTO.getFirstName())
                .fillLastName(CreateAccountDTO.getDefaultCreateAccount().getLastName())
                .fillAddressMail(CreateAccountDTO.getDefaultCreateAccount().getMail())
                .fillPassword(CreateAccountDTO.getDefaultCreateAccount().getPassword())
                .setDayOfBirth(CreateAccountDTO.getDefaultCreateAccount().getDayOfBirth())
                .setMonthOfBirth(CreateAccountDTO.getDefaultCreateAccount().getMonthOfBirth())
                .setYearOfBirth(CreateAccountDTO.getDefaultCreateAccount().getYearOfBirth())
                .clickOnRegisterButton();
        return this;
    }
}
