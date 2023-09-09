package GMTester;

import com.microsoft.playwright.Locator;
import lombok.Getter;
import lombok.ToString;

public class TableUser {

    private String firstName;
    private String lastName;
    private String email;
    private String due;
    private String website;
    private Locator action;


    public TableUser(String firstName, String lastName, String email, String due, String website, Locator action) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.due = due;
        this.website = website;
        this.action = action;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDue() {
        return due;
    }

    public void setDue(String due) {
        this.due = due;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public Locator getAction() {
        return action;
    }

    public void setAction(Locator action) {
        this.action = action;
    }

    @Override
    public String toString() {
        return "TableUser{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", due='" + due + '\'' +
                ", website='" + website + '\'' +
                ", action=" + action +
                '}';
    }
}
