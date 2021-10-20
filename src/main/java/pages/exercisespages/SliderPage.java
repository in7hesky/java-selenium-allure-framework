package pages.exercisespages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

public class SliderPage extends BasePage {
    private static final String PAGE_URL = "https://the-internet.herokuapp.com/horizontal_slider";

    @FindBy (tagName = "input")
    private WebElement slider;

    @FindBy (tagName = "span")
    private WebElement selectedValue;

    public SliderPage(WebDriver driver) {
        super(driver);
    }

    public double getSelectedValue() {
        return Double.parseDouble(selectedValue.getText());
    }

    /**
     * @param value from 0.5 to 5 inclusive with step = 0.5
     * @return returns page with labeled chosen value
     */
    public SliderPage setValue(double value) {
        if (value <= 0 || value % 0.5 != 0 || value > 5)
            throw new IllegalArgumentException();

        int timesToDrag = (int) (value * 2);

        for (int i = 0; i < timesToDrag; i++) {
            slider.sendKeys(Keys.ARROW_RIGHT);
        }

        return this;
    }

    public SliderPage openPage() {
        driver.get(PAGE_URL);
        return this;
    }


}
