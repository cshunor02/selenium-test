import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver){
        super(driver);
        
         if (!driver.getTitle().equals("My account - StringyDingDing")) {
          throw new IllegalStateException("This is not Sign In Page," +
                " current page is: " + driver.getCurrentUrl());
        }
    }

    // // Fill input (text,radio,check...) - 2 points
    public WebDriver logInToPage(String userName, String password) {
        WebElement usernameInput = this.driver.findElement(By.xpath("//input[@name='username' and @id='username' and @type='text']"));
        usernameInput.sendKeys(userName);

        WebElement passwordInput = this.driver.findElement(By.xpath("//input[@name='password' and @id='password' and @type='password']"));
        passwordInput.sendKeys(password);

        WebElement loginButton = this.driver.findElement(By.xpath("//button[@name='login' and @type='submit']"));
        loginButton.click();

        return this.driver;
    }

    public WebDriver logOutFromPage() {
        WebElement logoutLink = this.driver.findElement(By.xpath("//a[contains(text(), 'Log out')]"));
        logoutLink.click();

        return this.driver;
    }

    // // Fill input (text,radio,check...) - 1 point
    public SearchPage sendFormWithUser(String searchKey) {
        WebElement inputField = this.driver.findElement(By.xpath("//input[@type='search' and @name='s']"));
        inputField.sendKeys(searchKey);

        WebElement searchButton = this.driver.findElement(By.xpath("//input[@type='submit' and @class='search-submit']"));
        searchButton.click();

        waitVisibiiltyAndFindElement(bodyLocator);

        return new SearchPage(driver, searchKey);
    }
}