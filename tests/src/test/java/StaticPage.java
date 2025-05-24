import org.openqa.selenium.WebDriver;

public class StaticPage extends BasePage {

    public StaticPage(WebDriver driver){
        super(driver);
    }

    public WebDriver staticPageRender(String link) {
        this.driver.get(link);
        waitVisibiiltyAndFindElement(bodyLocator);
        
        return this.driver;
    }

}
