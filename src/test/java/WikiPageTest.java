import core.BaseTestCase;
import core.Page;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pageObjects.WikiHomePage;
import pageObjects.WikiSearchResultsPage;

public class WikiPageTest extends BaseTestCase {

    /**
     * @author Rajaraman Mahalingam
     *
     */
    @Before
    public void openWikiPageAndSelectTextAndLanguage() {
        System.out.println("Given > Navigate to the Wikipedia home page, http://www.wikipedia.org/");
        Page.open(WikiHomePage.pageURL);
    }

    /**
     * Validate that the ﬁrst heading of the search results page matches the search string (ignoring case).
     */

    @Test
    public void verifyIfSearchResultsDisplayedCorrectlyForEnglish() {
        System.out.println("When > Type in a string given as parameter in the search input field - e.g Dinosaur");
        WikiHomePage.enterSearchTextInTheSearchField("Dinosaur");

        System.out.println("And > Select English as the search language");
        WikiHomePage.selectLanguageFromLanguageSelector("English");

        System.out.println("And > Click the search button");
        WikiHomePage.clickSearchButton();

        System.out.println("Then > the first heading of the search results page matches the search string (ignoring case)");
        Assert.assertTrue(WikiSearchResultsPage.verifyIfSearchCriteriaIsDisplayedCorrectly());
    }

    /**
     *  Verify that the search results page is available in a language given as parameter
     *  Validate that the search results page in the new language includes a link to the version in English
     */
    @Test
    public void verifyIfSearchCriteriaIsDisplayedCorrectlyInChosenLanguage() {
        System.out.println("When > user enters a text in the search field");
        WikiHomePage.enterSearchTextInTheSearchField("Tamil");

        System.out.println("And > Click the Select language dropdown - EUSKARA");
        WikiHomePage.selectLanguageFromLanguageSelector("Euskara");

        System.out.println("And > Search button is clicked");
        WikiHomePage.clickSearchButton();

        System.out.println("Then > the search results page is available in the language given as parameter.");
        Assert.assertTrue(WikiSearchResultsPage.verifyIfSearchCriteriaIsDisplayedCorrectly());

        System.out.println("And > the search results page in the new language includes a link to the version in English");
        Assert.assertTrue(WikiSearchResultsPage.verifyIfEnglishLinkIsAvailable());
    }
}
