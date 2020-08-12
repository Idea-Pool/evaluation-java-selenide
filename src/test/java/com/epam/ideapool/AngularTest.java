package com.epam.ideapool;

import static org.junit.Assert.assertEquals;
import com.codeborne.selenide.Condition;
import com.epam.ideapool.page.AngularDirectivePage;
import com.epam.ideapool.page.AngularHomePage;
import com.epam.ideapool.page.AngularStartPage;
import org.junit.Test;

public class AngularTest extends BaseTest {
    private final AngularHomePage homePage = new AngularHomePage();

    @Test
    public void checkingLandingPagesElements() {
        homePage.openPage();
        homePage.getNavBarLogo().shouldBe(Condition.visible);
        homePage.getHeroSectionLogo().shouldBe(Condition.visible);
        homePage.getHeroHeadline().shouldBe(Condition.matchesText("One framework.\nMobile & desktop."));
        AngularStartPage startPage = homePage.clickOnGetStartedButton();
        assertEquals("https://angular.io/docs", startPage.getUrl());
        startPage.getIntroduction().shouldBe(Condition.matchText("Introduction to the Angular Docs"));
    }

    @Test
    public void checkingSearchFieldOnLandingPage() {
        homePage.openPage();
        homePage.getSearchInput().shouldBe(Condition.empty);
        assertEquals("Search", homePage.getPlaceholderAttributeValue());
        AngularDirectivePage directivePage = homePage.setSearchValue("directive")
                .waitUntilSearchResultHeaderVisible()
                .waitUntilSearchResultContainsValue()
                .clickOnDirectiveLink();
        assertEquals("https://angular.io/api/core/Directive", directivePage.getUrl());
        directivePage.getTitle().shouldBe(Condition.matchText("Directive"));
    }
}
