import java.net.MalformedURLException;
import java.util.Random;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginPageTest extends BasePageTest {
    private LoginPage loginPage;
    private WebElement resultElement;
    private final By errorMesssageLocator = By.xpath("//li[strong[text()='Error:']]");

    // Source: https://stackoverflow.com/questions/20536566/creating-a-random-string-with-a-z-and-0-9-in-java
    protected String generateRandomString(int n) {
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890abcdefghijklmnopqrstuvwxyz";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < n) {
            int index = (int) (rnd.nextFloat() * alphabet.length());
            salt.append(alphabet.charAt(index));
        }
        return salt.toString();
    }

    @Before
    @Override
    public void setup() throws MalformedURLException {
        super.setup();

        this.driver.get("https://stringydingding.com/my-account/");

        loginPage = new LoginPage(driver);
        this.driver = loginPage.logInToPage("Pelda Bela", "k23zC!hZ9DHUbLY");
        resultElement = waitVisibiiltyAndFindElement(bodyLocator);
    }

    // Fill simple form and send (eg. Login) - 3 points
    @Test
    public void testGoodLogin() {
        Assert.assertTrue(resultElement.getText().contains("Hello Pelda Bela"));
        Assert.assertTrue(resultElement.getText().contains("My account"));
        Assert.assertTrue(resultElement.getText().contains("Log out"));
    }

    // Logout - 2 points
    @Test
    public void testLogOut() {
        waitVisibiiltyAndFindElement(bodyLocator);
        this.driver = loginPage.logOutFromPage();

        resultElement = waitVisibiiltyAndFindElement(bodyLocator);
        Assert.assertTrue(resultElement.getText().contains("My account"));
        Assert.assertFalse(resultElement.getText().contains("Hello Pelda Bela"));
        Assert.assertTrue(resultElement.getText().contains("Login"));
    }

    // Test with random data - 8 points
    @Test
    public void testFalseLogin() {
        this.driver = loginPage.logOutFromPage();

        LoginPage loginPage = new LoginPage(driver);
        this.driver = loginPage.logInToPage(generateRandomString(5), generateRandomString(10));

        resultElement = waitVisibiiltyAndFindElement(errorMesssageLocator);
        Assert.assertNotEquals(resultElement.getText(), "");
    }

    // Form sending with user - 3 points
    // Send a form - 1 point
    @Test
    public void testSendFormWithUser() {
        resultElement = waitVisibiiltyAndFindElement(bodyLocator);

        SearchPage searchPage = loginPage.sendFormWithUser("cat");
        Assert.assertTrue(searchPage.getPageTitle().contains("You searched for cat - StringyDingDing"));
    }
}
