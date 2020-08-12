package com.epam.ideapool.page;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

public class AngularHomePage extends Page {
    private final SelenideElement navBarLogo = $(".nav-link.home");
    private final SelenideElement heroSectionLogo = $(".hero-logo");
    private final SelenideElement heroHeadline = $(".hero-headline");
    private final SelenideElement getStartedButton = $(".button.hero-cta");
    private final SelenideElement searchInput = $(".search-container > input");
    private final SelenideElement searchResultHeader = $("div.search-area.ng-star-inserted h3");
    private final SelenideElement directive = $x("//h3[contains(@class, 'search-section-header') and contains(text(), 'api')]/..//span[text() = 'Directive']");
    private final SelenideElement directiveLink = $x("//a[contains(@href, 'Directive')]");

    public AngularHomePage openPage() {
        open("https://angular.io");
        return this;
    }

    public AngularStartPage clickOnGetStartedButton() {
        getStartedButton.waitUntil(Condition.visible, TIMEOUT_MILLISECONDS).click();
        getStartedButton.waitUntil(Condition.disappear, TIMEOUT_MILLISECONDS);
        return new AngularStartPage();
    }

    public SelenideElement getSearchInput() {
        return searchInput.waitUntil(Condition.visible, TIMEOUT_MILLISECONDS);
    }

    public String getPlaceholderAttributeValue() {
        return searchInput.getAttribute("placeholder");
    }

    public AngularHomePage setSearchValue(final String text) {
        searchInput.setValue(text);
        return this;
    }

    public SelenideElement getNavBarLogo() {
        return navBarLogo;
    }

    public SelenideElement getHeroSectionLogo() {
        return heroSectionLogo;
    }

    public SelenideElement getHeroHeadline() {
        return heroHeadline;
    }

    public AngularHomePage waitUntilSearchResultHeaderVisible() {
        searchResultHeader.waitUntil(Condition.visible, TIMEOUT_MILLISECONDS);
        return this;
    }

    public AngularHomePage waitUntilSearchResultContainsValue() {
        directive.waitUntil(Condition.visible, TIMEOUT_MILLISECONDS);
        return this;
    }

    public AngularDirectivePage clickOnDirectiveLink() {
        directiveLink.click();
        getStartedButton.waitUntil(Condition.disappear, TIMEOUT_MILLISECONDS);
        return new AngularDirectivePage();
    }
}
