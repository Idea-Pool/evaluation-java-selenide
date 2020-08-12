package com.epam.ideapool.page;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.WebDriverRunner.url;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

public class AngularStartPage extends Page {
    private final SelenideElement introduction = $("#introduction-to-the-angular-docs");

    public String getUrl() {
        return url();
    }

    public SelenideElement getIntroduction() {
        return introduction
                .waitUntil(Condition.appears, TIMEOUT_MILLISECONDS);
    }
}
