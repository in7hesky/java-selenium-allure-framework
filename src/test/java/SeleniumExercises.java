import exercisesapp.ExerciseApp;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import exercisesapp.pages.exercisespages.*;

public class SeleniumExercises {
    public static final String TESTING_EMAIL = "helloworld@gmail.com";
    public static final double SLIDER_TARGET = 2.0;

    protected WebDriver driver;
    protected ExerciseApp app;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void initDriver() {
        driver = new ChromeDriver();
        app = new ExerciseApp(driver);
    }

    @Test
    public void testFindingWebElements() {
        var homePage =  app.homePage.openPage();

        int optionsAmount = homePage.clickShiftingContentLink().
                        chooseMenuExample().getOptionsAmount();

        Assert.assertEquals(optionsAmount, 5);
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



    @AfterMethod
    public void tearDown() {
        if (driver != null)
            driver.quit();
    }
}
