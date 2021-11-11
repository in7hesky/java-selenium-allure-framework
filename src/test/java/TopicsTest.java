import app.pages.HomePage;
import app.pages.TopicsPage;
import io.qameta.allure.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Topics Page Links")
public class TopicsTest extends BaseTest {
    private static final char [] MENU_LETTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();

    @Test
    @Description("Clicks on top-left NASA logo to assure correct linking to the Home Page")
    public void shouldGetToHomePageAfterClickingOnLogo() {
        var topicsPage = app.toTopicsPage();

        String currentUrl = topicsPage.clickOnNasaLogo().getCurrentUrl();

        assertThat(HomePage.PAGE_URL).isEqualTo(currentUrl);
    }

    @Test
    @Description("Checks each time if url path now contains a link to an appropriate section of a page")
    public void shouldVerifyCorrectMenuLettersPointing() {
        var topicsPage = app.toTopicsPage();


        for (Character letter: MENU_LETTERS) {
            topicsPage.clickOnMenuLetter(letter);

            assertThat(TopicsPage.PAGE_URL + "/#letter-" + letter).isEqualTo(topicsPage.getCurrentUrl());
        }

    }

}
