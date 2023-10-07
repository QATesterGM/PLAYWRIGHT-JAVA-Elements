package PatternObjectProject.pages;

import PatternObjectProject.pages.sections.TopMenuSection;
import com.microsoft.playwright.Page;
import lombok.Getter;

public class HomePage {

    @Getter
    private TopMenuSection topMenuSection;


    public HomePage(Page page) {
        this.topMenuSection = new TopMenuSection(page);

    }

    public TopMenuSection getTopMenuSection() {
        return topMenuSection;
    }
}
