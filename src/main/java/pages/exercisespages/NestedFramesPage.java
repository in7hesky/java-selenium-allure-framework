package pages.exercisespages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

public class NestedFramesPage extends BasePage {

    private static final String PAGE_URL = "http://the-internet.herokuapp.com/nested_frames";

    @FindBy(tagName = "body")
    private WebElement textContainer;

    public NestedFramesPage(WebDriver driver) {
        super(driver);
    }

    public String chooseFrameToGetText(int... indexes) {
        switchToFrameByIndex(indexes);
        String frameText = textContainer.getText();
        switchToParentFrame(indexes.length);
        return frameText;
    }

    /**
     *
     * @param indexes pass consequent indexes of frames to switch to
     */
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
