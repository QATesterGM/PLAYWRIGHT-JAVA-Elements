package PatternObjectProject.pages;

import PatternObjectProject.pages.sections.TopMenuSection;
import com.microsoft.playwright.Page;
import lombok.Getter;

public class HomePage extends BasePage{

    @Getter
    private TopMenuSection topMenuSection;


    public HomePage(Page page) {
        super(page);
        this.topMenuSection = new TopMenuSection(page);

    }

    public TopMenuSection getTopMenuSection() {
        return topMenuSection;
    }
}
