package pageObjects;

import core.Element;
import core.Page;

public class WikiHomePage extends Page {
    public static String pageURL = "https://www.wikipedia.org/";
    public static String searchText="";

    public static void enterSearchTextInTheSearchField(String text) {
        Element.typeIn(Locators.searchText,text);
        searchText=text;
    }

    public static void selectLanguageFromLanguageSelector(String language) {
        Element.select(Locators.languageSelector,language);
    }

    public static void clickSearchButton() {
        Element.click(Locators.searchButton);
    }

    private class Locators {
        private static final String languageSelector="xpath=//SELECT[@id='searchLanguage']";
        private static final String searchText="xpath=//INPUT[@id='searchInput']";
        private static final String searchButton="xpath=//BUTTON[@class='pure-button pure-button-primary-progressive']";
    }
}
