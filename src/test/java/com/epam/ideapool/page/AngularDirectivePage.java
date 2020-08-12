package com.epam.ideapool.page;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.WebDriverRunner.url;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

public class AngularDirectivePage extends Page {
    private final SelenideElement title = $("#directive");

    public String getUrl() {
        return url();
    }

    public SelenideElement getTitle() {
        return title.waitUntil(Condition.visible, TIMEOUT_MILLISECONDS);
    }
}
