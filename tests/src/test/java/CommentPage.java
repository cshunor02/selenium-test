import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CommentPage extends BasePage {

    public CommentPage(WebDriver driver) {
        super(driver);
    }

    public void fillTextArea(WebElement textArea, String commentText) {
        textArea.clear();
        textArea.sendKeys(commentText);
    }

    public void uploadImage(WebElement uploadButton, String imagePath) {
        uploadButton.sendKeys(imagePath);
    }
    
}
