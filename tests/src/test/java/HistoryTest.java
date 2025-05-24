import java.net.MalformedURLException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

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
    public void testHistory() {
        Assert.assertTrue(this.driver.getTitle().equals("Home of Free Amigurumi Crochet Patterns - StringyDingDing"));

        this.driver.get("https://stringydingding.com/cart/");
        waitVisibiiltyAndFindElement(By.tagName("body"));
        Assert.assertTrue(this.driver.getTitle().equals("Cart - StringyDingDing"));

        this.driver.navigate().back();
        waitVisibiiltyAndFindElement(By.tagName("body"));
        Assert.assertTrue(this.driver.getTitle().equals("Home of Free Amigurumi Crochet Patterns - StringyDingDing"));
    }
}
