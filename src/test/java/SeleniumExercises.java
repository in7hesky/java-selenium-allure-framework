import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


public class SeleniumExercises extends BaseTest {
    public static final String TESTING_EMAIL = "helloworld@gmail.com";
    public static final double SLIDER_TARGET = 2.0;
    public static final int EXPECTED_OPTIONS_AMOUNT = 5;

    @Test
    public void testFindingWebElements() {
        var homePage =  app.homePage.openPage();

        int optionsAmount = homePage.clickShiftingContentLink().
                        chooseMenuExample().getOptionsAmount();

        Assert.assertEquals(optionsAmount, EXPECTED_OPTIONS_AMOUNT);
    }

    @Test
    public void testInteractingWith() {
        var forgotPasswordPage = app.homePage.openPage().clickForgotPasswordLink();

        String resultMessage = forgotPasswordPage.inputAndSubmitEmail(TESTING_EMAIL).getResultText();

        Assert.assertTrue(resultMessage.contains("Error"));
    }

    @Test
    public void testAdditionalKeys() {
        var sliderPage = app.sliderPage.openPage();

        double selectedValue = sliderPage.setValue(SLIDER_TARGET).getSelectedValue();

        Assert.assertEquals(selectedValue, SLIDER_TARGET);

    }

    @Test
    public void testModals() {
        var contextMenuPage = app.contextMenuPage.openPage();

        String alertsText = contextMenuPage.callContextMenuOnTarget().getAlertsText();

        Assert.assertTrue(alertsText.contains("selected"));
    }

    @Test
    public void testFrames() {
        var softAssert = new SoftAssert();
        var nestedFramesPage = app.nestedFramesPage.openPage();

        String bottomFrameText = nestedFramesPage.chooseFrameToGetText(1);
        String leftFrameText = nestedFramesPage.chooseFrameToGetText(0, 0);

        softAssert.assertTrue(bottomFrameText.equalsIgnoreCase("bottom"));
        softAssert.assertTrue(leftFrameText.equalsIgnoreCase("left"));
        softAssert.assertAll();
    }

    @Test
    public void testWaitStrategies() {
        var dynamicLoadingPage = app.dynamicLoadingPage.openPage();

        String loadedText = dynamicLoadingPage.clickToLoadContent().getLoadedText();

        Assert.assertEquals(loadedText, "Hello World!");
    }
}
