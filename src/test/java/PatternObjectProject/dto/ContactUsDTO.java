package PatternObjectProject.dto;

import lombok.Builder;

@Builder
public class ContactUsDTO {

    private String subjectHeading;
    private String emailAddress;
    private String orderReference;
    private String fileUploadInput;
    private String message;

    public static ContactUsDTO getFefaultContactUsDTO(){
        return ContactUsDTO.builder()
                .subjectHeading("Webmaster")
                .emailAddress("demo@demo.com")
                .orderReference("123456")
                .fileUploadInput("screenshots/Premier.jpg")
                .message("Ostatnowio wszystko przeciwko mnie, wszystkie kary na mnie idą")
                .build();
    }
}
