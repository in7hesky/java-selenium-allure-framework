import app.pages.BasePage;
import app.pages.TopicsPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

@Execution(ExecutionMode.CONCURRENT)
public class TopicsTest extends BaseTest {

    @Test
    public void shouldGetToHomePageAfterClickingOnLogo() {
        var topicsPage = app.topicsPage.openPage();

        String currentUrl = topicsPage.clickOnNasaLogo().getCurrentUrl();

        Assertions.assertEquals(BasePage.BASE_URL, currentUrl);
    }


    @Test
    public void shouldVerifyCorrectMenuLettersPointing() {
        var topicsPage = app.topicsPage.openPage();
        char[] menuLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();

        for (Character letter: menuLetters) {
            topicsPage.clickOnMenuLetter(letter);

            Assertions.assertEquals((BasePage.BASE_URL + TopicsPage.PAGE_URL + "/#letter-" + letter),
                    topicsPage.getCurrentUrl());
        }

    }

}
