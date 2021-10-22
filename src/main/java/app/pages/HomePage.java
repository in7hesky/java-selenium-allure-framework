package app.pages;

import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public HomePage openPage() {
        driver.get(BasePage.BASE_URL);
        return this;
    }
}
