package app.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class TopicsPage extends BasePage {
    public static final String PAGE_URL = "topics";

    @FindBy(xpath = "(//a[@title='Home Page'])[1]")
    private WebElement topLeftLogo;

    public TopicsPage(WebDriver driver) {
        super(driver);
    }


    public void clickOnMenuLetter(Character letter) {
        WebElement menuLetter = driver.findElement(By.xpath(String.format(
                "//div[@id='tag-anchors']//a[contains(., '%c')]", letter)));
        menuLetter.click();
    }

    public HomePage clickOnNasaLogo() {
        topLeftLogo.click();
        return new HomePage(driver);
    }

    public TopicsPage openPage() {
        driver.get(BASE_URL + PAGE_URL);
        wait.until(ExpectedConditions.visibilityOf(topLeftLogo));
        return this;
    }




}
