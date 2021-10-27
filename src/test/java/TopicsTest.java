import app.pages.BasePage;
import app.pages.TopicsPage;
import io.qameta.allure.Description;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Topics Page Links")
public class TopicsTest extends BaseTest {
    private static final char [] MENU_LETTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();

    @Test
    @Description("Clicks on top-left NASA logo to assure correct linking to the Home Page")
    public void shouldGetToHomePageAfterClickingOnLogo() {
        var topicsPage = app.topicsPage.openPage();

        String currentUrl = topicsPage.clickOnNasaLogo().getCurrentUrl();

        Assertions.assertEquals(BasePage.BASE_URL, currentUrl);
    }

    @Test
    @Description("Checks in URL each time if path now contains a link to an appropriate section in of a page")
    public void shouldVerifyCorrectMenuLettersPointing() {
        var topicsPage = app.topicsPage.openPage();

        for (Character letter: MENU_LETTERS) {
            topicsPage.clickOnMenuLetter(letter);

            Assertions.assertEquals((BasePage.BASE_URL + TopicsPage.PAGE_URL + "/#letter-" + letter),
                    topicsPage.getCurrentUrl());
        }

    }

}
