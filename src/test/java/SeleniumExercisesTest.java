import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

@Execution(ExecutionMode.CONCURRENT)
public class SeleniumExercisesTest extends BaseTest {
    public static final String TESTING_EMAIL = "helloworld@gmail.com";
    public static final double SLIDER_TARGET = 2.0;
    public static final int EXPECTED_OPTIONS_AMOUNT = 5;

    @Test
    public void testFindingWebElements() {
        var homePage =  app.homePage.openPage();

        int optionsAmount = homePage.clickShiftingContentLink().
                        chooseMenuExample().getOptionsAmount();

        Assertions.assertEquals(optionsAmount, EXPECTED_OPTIONS_AMOUNT);
    }

    @Test
    public void testInteractingWith() {
        var forgotPasswordPage = app.homePage.openPage().clickForgotPasswordLink();

        String resultMessage = forgotPasswordPage.inputAndSubmitEmail(TESTING_EMAIL).getResultText();

        Assertions.assertTrue(resultMessage.contains("Error"));
    }

    @Test
    public void testAdditionalKeys() {
        var sliderPage = app.sliderPage.openPage();

        double selectedValue = sliderPage.setValue(SLIDER_TARGET).getSelectedValue();

        Assertions.assertEquals(selectedValue, SLIDER_TARGET, 0.1);

    }

    @Test
    public void testModals() {
        var contextMenuPage = app.contextMenuPage.openPage();

        String alertsText = contextMenuPage.callContextMenuOnTarget().getAlertsText();

        Assertions.assertTrue(alertsText.contains("selected"));
    }

    @Test
    public void testFrames() {
        var nestedFramesPage = app.nestedFramesPage.openPage();

        String bottomFrameText = nestedFramesPage.chooseFrameToGetText(1);
        String leftFrameText = nestedFramesPage.chooseFrameToGetText(0, 0);

        Assertions.assertTrue(bottomFrameText.equalsIgnoreCase("bottom"));
        Assertions.assertTrue(leftFrameText.equalsIgnoreCase("left"));
    }

    @Test
    public void testWaitStrategies() {
        var dynamicLoadingPage = app.dynamicLoadingPage.openPage();

        String loadedText = dynamicLoadingPage.clickToLoadContent().getLoadedText();

        Assertions.assertEquals(loadedText, "Hello World!");
    }

    @Test
    public void testUsingJavaScript() {
        int optionsToChooseAmount = 2;
        var dropdownPage = app.dropdownPage.openPage();

        int selectedOptionsAmount = dropdownPage.
                makeDropdownMultiple().selectConsequentOptions(optionsToChooseAmount).
                getSelectedOptionsAmount();

        Assertions.assertEquals(optionsToChooseAmount, selectedOptionsAmount);
    }

    @Test
    public void testApplicationNavigation() {
        var loadedChoicePage = app.loadedChoicePage.openPage();

        var hiddenLoadedPageInNewTab = loadedChoicePage.openHiddenLoadedInNewTab();

        Assertions.assertTrue(hiddenLoadedPageInNewTab.buttonIsVisible());
    }
}
