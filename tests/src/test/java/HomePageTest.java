import java.net.MalformedURLException;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class HomePageTest extends BasePageTest {
    private HomePage homePage;
    private By categoriesMenuLocator = By.xpath("//div[@class='vertical-navigation-header' and span[text()='Categories']]");

    @Before
    @Override
    public void setup() throws MalformedURLException {
        super.setup();

        this.driver.get("https://stringydingding.com/");
        homePage = new HomePage(this.driver);
        waitVisibiiltyAndFindElement(By.tagName("body"));
    }

    // Reading the page title - 1 point
    @Test
    public void testHomePage() {
        Assert.assertEquals("Home of Free Amigurumi Crochet Patterns - StringyDingDing", this.driver.getTitle());
        
        WebElement subscribe = waitVisibiiltyAndFindElement(By.xpath("//h2[contains(text(),'Love free patterns?')]"));
        Assert.assertTrue(subscribe.isDisplayed());
    }

    // Hover test - 6 points
    @Test
    public void testHoverOverMenu() {
        waitVisibiiltyAndFindElement(categoriesMenuLocator);
        WebElement categoriesMenu = this.driver.findElement(categoriesMenuLocator);
        WebElement verticalMenu = this.driver.findElement(By.xpath("//div[@class='vertical-menu']"));

        Assert.assertFalse(verticalMenu.isDisplayed());

        homePage.hoverOverMenu(categoriesMenu);

        Assert.assertTrue(verticalMenu.isDisplayed());
    }

    // Fill input (text,radio,check...) - 1 point
    @Test
    public void testFillEmailInput() {
        WebElement emailInput = this.driver.findElement(By.xpath("//input[@type='email' and @name='email']"));
        String email = "valami@pelda.com";
        
        Assert.assertEquals(emailInput.getText(), "");
        homePage.fillEmailInput(email, emailInput);
        Assert.assertTrue(emailInput.getAttribute("value").equals(email));
    }

    // Send a form - 1 point
    @Test
    public void testSignUpToNewsLetter() {
        By successLocator = By.xpath("//div[@class='hustle-success']");
        WebElement successElement = this.driver.findElement(successLocator);
        Assert.assertFalse(successElement.isDisplayed());

        WebElement emailInput = this.driver.findElement(By.xpath("//input[@type='email' and @name='email']"));
        String email = "jayib86878@neuraxo.com";

        homePage.fillEmailInput(email, emailInput);

        WebElement submitButton = this.driver.findElement(By.xpath("//button[contains(@class, 'hustle-button-submit')]//span[text()='Submit']"));
        homePage.signUpToNewsLetter(submitButton);

        waitVisibiiltyAndFindElement(successLocator);

        Assert.assertTrue(successElement.isDisplayed());
    }

}
