import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartPage extends BasePage {
    public CartPage(WebDriver driver){
        super(driver);

        if (!driver.getTitle().equals("Cart - StringyDingDing")) {
        throw new IllegalStateException("This is not Cart Page!" +
                " Current page is: " + driver.getCurrentUrl());
        }
    }

    public void downloadCartImages(String outputPath) {
        List<WebElement> images = driver.findElements(By.xpath("//img[@width='450' and @height='450']"));

        if (images.isEmpty()) {
            System.out.println("No images found");
            return;
        }

        for (WebElement image : images) {
            String imageURL = image.getAttribute("src");
            try (BufferedInputStream in = new BufferedInputStream(new URL(imageURL).openStream());
                FileOutputStream fileOutputStream = new FileOutputStream(outputPath + image.getAttribute("alt") + ".png")) {
                byte dataBuffer[] = new byte[1024];
                int bytesRead;
                while ((bytesRead = in.read(dataBuffer, 0, 1024)) != -1) {
                    fileOutputStream.write(dataBuffer, 0, bytesRead);
                }
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }

}
