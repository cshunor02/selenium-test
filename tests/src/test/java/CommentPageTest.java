import java.net.MalformedURLException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class CommentPageTest extends BasePageTest {
    
    private CommentPage commentPage;

    @Before
    @Override
    public void setup() throws MalformedURLException {
        super.setup();

        this.driver.get("https://stringydingding.com/bat-amigurumi-garland-free-crochet-pattern/");
        waitVisibiiltyAndFindElement(By.tagName("body"));
        commentPage = new CommentPage(driver);
    }

    // Filling or reading textarea content - 1 point
    @Test
    public void testCommentForm() {
        WebElement textArea = waitVisibiiltyAndFindElement(By.xpath("//textarea[@id='comment' and @name='comment']"));
        Assert.assertEquals(textArea.getAttribute("value"), "");

        String expectedText = "This is a test comment.";
        commentPage.fillTextArea(textArea, expectedText);

        Assert.assertEquals(textArea.getAttribute("value"), expectedText);
    }

    @Test
    public void testCommentFormWithEmptyText() {
        WebElement textArea = waitVisibiiltyAndFindElement(By.xpath("//textarea[@id='comment' and @name='comment']"));
        Assert.assertEquals(textArea.getAttribute("value"), "");

        commentPage.fillTextArea(textArea, "");

        Assert.assertEquals(textArea.getAttribute("value"), "");
    }

    // File upload - 6 points
    @Test
    public void testUploadImage() {
        WebElement uploadButton = waitVisibiiltyAndFindElement(By.xpath("//input[@type='file' and @id='attachment' and @name='attachment']"));
        String imagePath = "/home/seluser/uploadImage/bouquet.png";

        Assert.assertTrue(uploadButton.getAttribute("value").isEmpty());
        commentPage.uploadImage(uploadButton, imagePath);
        Assert.assertFalse(uploadButton.getAttribute("value").isEmpty());
    }
    
}
