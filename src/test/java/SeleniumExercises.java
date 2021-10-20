import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.exercisespages.ContextMenuPage;
import pages.exercisespages.HomePage;
import pages.exercisespages.SliderPage;

public class SeleniumExercises {
    public static final String TESTING_EMAIL = "helloworld@gmail.com";
    public static final double SLIDER_TARGET = 2.0;

    protected WebDriver driver;
    protected WebDriverWait wait;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void initDriver() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 10);
    }

    @Test
    public void testFindingWebElements() {
        var homePage = new HomePage(driver).openPage();

        int optionsAmount = homePage.openPage().clickShiftingContentLink().
                        chooseMenuExample().getOptionsAmount();

        Assert.assertEquals(optionsAmount, 5);
    }

    @Test
    public void testInteractingWith() {
        var forgotPasswordPage = new HomePage(driver).openPage().clickForgotPasswordLink();

        String resultMessage = forgotPasswordPage.inputAndSubmitEmail(TESTING_EMAIL).getResultText();

        Assert.assertTrue(resultMessage.contains("Error"));
    }

    @Test
    public void testAdditionalKeys() {
        var sliderPage = new SliderPage(driver).openPage();

        double selectedValue = sliderPage.setValue(SLIDER_TARGET).getSelectedValue();

        Assert.assertEquals(selectedValue, SLIDER_TARGET);
    }

    @Test
    public void testModals() {
        var contextMenuPage = new ContextMenuPage(driver).openPage();

        String alertsText = contextMenuPage.callContextMenuOnTarget().getAlertsText();

        Assert.assertTrue(alertsText.contains("selected"));
    }



    @AfterMethod
    public void tearDown() {
        if (driver != null)
            driver.quit();
    }
}
