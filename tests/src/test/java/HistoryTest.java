import java.net.MalformedURLException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HistoryTest extends BasePageTest {
    
    @Before
    @Override
    public void setup() throws MalformedURLException {
        super.setup();

        this.driver.get("https://stringydingding.com/");
        waitVisibiiltyAndFindElement(By.tagName("body"));
    }

    // History test (browser back button) - 4 points
    @Test
    public void testHistory() throws InterruptedException {
        wait.until(ExpectedConditions.titleIs("Home of Free Amigurumi Crochet Patterns - StringyDingDing"));
        Assert.assertTrue(this.driver.getTitle().equals("Home of Free Amigurumi Crochet Patterns - StringyDingDing"));
        
        this.driver.get("https://stringydingding.com/cart/");
        wait.until(ExpectedConditions.titleIs("Cart - StringyDingDing"));
        Assert.assertTrue(this.driver.getTitle().equals("Cart - StringyDingDing"));
        
        this.driver.get("https://stringydingding.com/cart/");
        wait.until(ExpectedConditions.titleIs("Cart - StringyDingDing"));
        Assert.assertEquals(driver.getTitle(), "Cart - StringyDingDing");
        
        Thread.sleep(2000);
        this.driver.navigate().back();
        wait.until(ExpectedConditions.titleIs("Home of Free Amigurumi Crochet Patterns - StringyDingDing"));
        Assert.assertTrue(this.driver.getTitle().equals("Home of Free Amigurumi Crochet Patterns - StringyDingDing"));
    }
}
