package PatternObjectProject.pages.sections;

import PatternObjectProject.dto.ContactUsDTO;
import PatternObjectProject.pages.BasePage;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import lombok.Getter;

import java.nio.file.Paths;

@Getter
public class ContactUsFormSection extends BasePage {

    private final Locator errorMessage;
    private final Locator sendMessageButton;
    private final Locator subjectHeading;
    private final Locator emailAddressInput;
    private final Locator orderReferenceInput;
    private final Locator fileUploadInput;
    private final Locator messageText;
    private final Locator confirmationMessage;

    public ContactUsFormSection(Page page) {
        super(page);
        this.sendMessageButton = page.locator("#submitMessage");
        this.errorMessage = page.getByText("Invalid email address.");
        this.subjectHeading = page.locator("#id_contact");
        this.emailAddressInput = page.getByLabel("Email address");
        this.orderReferenceInput = page.locator("#id_order");
        this.fileUploadInput = page.locator("#fileUpload");
        this.messageText = page.locator("#message");
        this.confirmationMessage = page.getByText("Your message has been successfully sent to our team.");
    }

    public ContactUsFormSection clickOnSendMessageButton() {
        sendMessageButton.click();
        return this;
    }

    private ContactUsFormSection selectSubjectHeading(String option) {
        subjectHeading.selectOption(option);
        return this;
    }

    private ContactUsFormSection enterEmailAddress(String email) {
        emailAddressInput.fill(email);
        return this;
    }

    private ContactUsFormSection enterOrderReference(String orderReference) {
        orderReferenceInput.fill(orderReference);
        return this;
    }

    private ContactUsFormSection selectFileToUpload(String filePath) {
        fileUploadInput.setInputFiles(Paths.get(filePath));
        return this;
    }

    private ContactUsFormSection enterMessage(String message) {
        messageText.fill(message);
        return this;
    }

    public ContactUsFormSection sendContactUsForm(ContactUsDTO contactUsDTO) {
        selectSubjectHeading(contactUsDTO.getSubjectHeading())
                .enterEmailAddress(contactUsDTO.getEmailAddress())
                .enterOrderReference(contactUsDTO.getOrderReference())
                .selectFileToUpload(contactUsDTO.getFileUploadInput())
                .enterMessage(contactUsDTO.getMessage())
                .clickOnSendMessageButton();
        return this;
    }
}
