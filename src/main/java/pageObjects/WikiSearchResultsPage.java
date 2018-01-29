package pageObjects;

import core.Element;

public class WikiSearchResultsPage {

    public static boolean verifyIfSearchCriteriaIsDisplayedCorrectly(){
        return Element.getText(Locators.firstHeading).equalsIgnoreCase(WikiHomePage.searchText);
    }

    public static boolean verifyIfEnglishLinkIsAvailable() {
        return Element.isElementDisplayed(Locators.englishLink);
    }

    private class Locators {
        private static final String firstHeading="xpath=//H1[@id='firstHeading']";
        private static final String englishLink="xpath=//*[contains(@class,'interlanguage-link-target')][text()='English']";

    }
}
