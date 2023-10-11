package PatternObjectProject.dto;

import com.github.javafaker.Faker;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class CreateAccountDTO {

    private String firstName;
    private String lastName;
    private String mail;
    private String password;
    private String dayOfBirth;
    private String monthOfBirth;
    private String yearOfBirth;

    public static CreateAccountDTO getDefaultCreateAccount(){
        return CreateAccountDTO.builder()
                .firstName("Lukasz")
                .lastName("Gajda")
                .mail(new Faker().pokemon().name().toString() +"123@o2.com")
                .password("password1223")
                .dayOfBirth("15")
                .monthOfBirth("2")
                .yearOfBirth("2011")
                .build();
    }
}
