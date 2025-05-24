import java.net.MalformedURLException;
import java.io.File;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class CartPageTest extends BasePageTest {
    private LoginPage loginPage;
    private CartPage cartPage;

    @Before
    @Override
    public void setup() throws MalformedURLException {
        super.setup();
        
        this.driver.get("https://stringydingding.com/my-account/");
        loginPage = new LoginPage(driver);

        this.driver = loginPage.logInToPage("Pelda Bela", "k23zC!hZ9DHUbLY");
        waitVisibiiltyAndFindElement(By.tagName("body"));

        this.driver.get("https://stringydingding.com/cart/");
        cartPage = new CartPage(driver);
        
        waitVisibiiltyAndFindElement(By.tagName("body"));
    }

    // Download multiple files to a folder from an user protected page - 12 points
    @Test
    public void testDownloadCartElementsImages() {
        String outputDir = "src/images/";
        cartPage.downloadCartImages(outputDir);

        File folder = new File(outputDir);
        File[] imageFiles = folder.listFiles((d, name) -> name.toLowerCase().endsWith(".png"));

        Assert.assertTrue(imageFiles.length == 3);
    }
}
