import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;


public class HomePage extends BasePage {
    public HomePage(WebDriver driver){
        super(driver);
        
        if (!driver.getTitle().equals("Home of Free Amigurumi Crochet Patterns - StringyDingDing")) {
        throw new IllegalStateException("This is not Home Page!" +
                " Current page is: " + driver.getCurrentUrl());
        }
    }

    public void hoverOverMenu(WebElement categoriesMenu) {
        Actions builder = new Actions(this.driver);
        builder.moveToElement(categoriesMenu).perform();
    }

    public void fillEmailInput(String email, WebElement emailInput) {
        emailInput.sendKeys(email);
    }

    public void signUpToNewsLetter(WebElement submitButton) {
        submitButton.click();
    }
}
