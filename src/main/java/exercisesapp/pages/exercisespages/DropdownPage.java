package exercisesapp.pages.exercisespages;

import exercisesapp.pages.BasePage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class DropdownPage extends BasePage {

    public static final String PAGE_URL = BASE_URL + "/dropdown";

    @FindBy(id = "dropdown")
    private WebElement dropdown;

    public DropdownPage(WebDriver driver) {
        super(driver);
    }

    public int getSelectedOptionsAmount(){
        return new Select(dropdown).getAllSelectedOptions().size();
    }

    public DropdownPage selectConsequentOptions(int optionsAmount) {
        Select dropdownInterface = new Select(dropdown);
        for (int i = 0; i < optionsAmount; i++) {
            dropdownInterface.selectByIndex(i+1);
        }
        return this;
    }

    public DropdownPage makeDropdownMultiple() {
        ((JavascriptExecutor)driver).executeScript(
                "document.querySelector(\"#dropdown\").setAttribute(\"multiple\", \"\")");
        return this;
    }

    public DropdownPage openPage() {
        driver.get(PAGE_URL);
        return this;
    }
}
