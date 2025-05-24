import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebElement;

public class StaticPageTest extends BasePageTest {

    class Link {
        String title;
        String url;
        public Link(String title, String url) {
            this.title = title;
            this.url = url;
        }
    }

    private Link[] links = {
            new Link("Classic Winnie the Pooh Amigurumi Bundle - 4 Free Crochet Patterns", "https://stringydingding.com/classic-winnie-the-pooh-amigurumi-bundle-free-crochet-patterns/"),
            new Link("Kitty Cats Amigurumi - Free Crochet Pattern - StringyDingDing", "https://stringydingding.com/kitty-cats-amigurumi-free-crochet-pattern/"),
            new Link("Owl & Snow Owl Amigurumi - Free Crochet Pattern - StringyDingDing", "https://stringydingding.com/owl-snow-owl-amigurumi-free-crochet-pattern/"),
    };

    // Static Page test - 2 points
    @Test
    public void testSingleStaticPage() {
        StaticPage staticPage = new StaticPage(driver);
        this.driver = staticPage.staticPageRender(links[0].url);
        Assert.assertEquals(links[0].title, driver.getTitle());
        WebElement resultElement = waitVisibiiltyAndFindElement(bodyLocator);
        Assert.assertTrue(resultElement.getText().contains("Leave A Reply"));
    }

    // Multiple page test from array (easily extendable static page tests) - 3 points
    @Test
    public void testMultipleStaticPages() {
        StaticPage staticPage = new StaticPage(driver);
        for (Link link : links) {
            this.driver = staticPage.staticPageRender(link.url);
            Assert.assertEquals(link.title, driver.getTitle());
            WebElement resultElement = waitVisibiiltyAndFindElement(bodyLocator);
            Assert.assertTrue(resultElement.getText().contains("Leave A Reply"));
        }
    }
}
