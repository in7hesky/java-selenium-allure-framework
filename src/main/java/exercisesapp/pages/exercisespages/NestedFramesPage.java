package exercisesapp.pages.exercisespages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import exercisesapp.pages.BasePage;

public class NestedFramesPage extends BasePage {

    private static final String PAGE_URL = BASE_URL + "/nested_frames";

    @FindBy(tagName = "body")
    private WebElement textContainer;

    public NestedFramesPage(WebDriver driver) {
        super(driver);
    }

    /**
     * @param indexes pass consequent indexes of frames to switch to
     */
    public String chooseFrameToGetText(int... indexes) {
        switchToFrameByIndex(indexes);
        String frameText = textContainer.getText();
        switchToParentFrame(indexes.length);
        return frameText;
    }

    private void switchToFrameByIndex(int... indexes) {
        for (Integer index: indexes) {
            driver.switchTo().frame(index);
        }
    }

    private void switchToParentFrame(int levelsUp) {
        while (levelsUp > 0) {
            driver.switchTo().parentFrame();
            levelsUp--;
        }
    }

    public NestedFramesPage openPage() {
        driver.get(PAGE_URL);
        return this;
    }
}
