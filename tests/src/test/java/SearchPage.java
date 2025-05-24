import org.openqa.selenium.WebDriver;

public class SearchPage extends BasePage {

    public SearchPage(WebDriver driver, String title){
        super(driver);

         if (!driver.getTitle().equals("You searched for " + title + " - StringyDingDing")) {
          throw new IllegalStateException("This is not a valid search page," +
                " current page is: " + driver.getCurrentUrl());
        }
    }

    public String getPageTitle() {
        waitVisibiiltyAndFindElement(bodyLocator);
        return this.driver.getTitle();
    }

}