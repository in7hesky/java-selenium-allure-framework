package exercisesapp.pages.exercisespages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import exercisesapp.pages.BasePage;

public class HomePage extends BasePage {
    @FindBy (linkText = "Shifting Content")
    private WebElement shiftingContentLink;
    @FindBy (linkText = "Forgot Password")
    private WebElement forgotPasswordLink;


    public HomePage(WebDriver driver) {
        super(driver);
    }

    public ShiftingContentPage clickShiftingContentLink() {
        shiftingContentLink.click();
        return new ShiftingContentPage(driver);
    }

    public ForgotPasswordPage clickForgotPasswordLink() {
        forgotPasswordLink.click();
        return new ForgotPasswordPage(driver);
    }

    public void clickLinkByText(String linkText) {
        driver.findElement(By.linkText(linkText));
    }

    public HomePage openPage() {
        driver.get(BASE_URL);
        return this;
    }
}
