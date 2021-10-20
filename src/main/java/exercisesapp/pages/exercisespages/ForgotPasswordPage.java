package exercisesapp.pages.exercisespages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import exercisesapp.pages.BasePage;

public class ForgotPasswordPage extends BasePage {

    @FindBy (id = "email")
    private WebElement inputField;

    @FindBy (id = "form_submit")
    private WebElement submitButton;

    @FindBy (tagName = "h1")
    private WebElement result;

    public ForgotPasswordPage(WebDriver driver) {
        super(driver);
    }

    public String getResultText() {
        return result.getText();
    }

    public ForgotPasswordPage inputAndSubmitEmail(String email) {
        inputField.sendKeys(email);
        submitButton.click();
        return this;
    }
}
