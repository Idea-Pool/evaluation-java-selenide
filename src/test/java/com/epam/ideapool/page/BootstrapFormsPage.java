package com.epam.ideapool.page;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.executeJavaScript;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.title;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

public class BootstrapFormsPage extends Page {
    private final SelenideElement readonlyInput = $("input[readonly].form-control");
    private final SelenideElement defaultCheckbox = $("#defaultCheck1");
    private final SelenideElement disabledCheckbox = $("#defaultCheck2");
    private final SelenideElement selectedRadio = $("#exampleRadios1");
    private final SelenideElement unSelectedRadio = $("#exampleRadios2");
    private final SelenideElement disabledRadio = $("#exampleRadios3");
    private final SelenideElement disabledButton = $("main > div:nth-child(43) > button.btn.btn-lg.btn-primary");
    private final SelenideElement activeButton = $(".btn-primary.active");
    private final SelenideElement select = $("#exampleFormControlSelect1");
    private final ElementsCollection selectOptions = $$("#exampleFormControlSelect1 option");
    private final SelenideElement multiSelect = $("#exampleFormControlSelect2");

    public BootstrapFormsPage openPage(final String url) {
        open(url);
        return this;
    }

    public String getTitle() {
        return title();
    }

    public SelenideElement getReadonlyInput() {
        return readonlyInput;
    }

    public BootstrapFormsPage scrollToReadonlyInput() {
        readonlyInput.scrollIntoView("{behavior: \"instant\", block: \"center\", inline: \"nearest\"}");
        return this;
    }

    public boolean isReadonlyInputInViewport() {
        return isVisibleInViewport(readonlyInput);
    }

    private Boolean isVisibleInViewport(SelenideElement element) {
        return (Boolean) executeJavaScript(
                "var elem = arguments[0],                 " +
                        "  box = elem.getBoundingClientRect(),    " +
                        "  cx = box.left + box.width / 2,         " +
                        "  cy = box.top + box.height / 2,         " +
                        "  e = document.elementFromPoint(cx, cy); " +
                        "for (; e; e = e.parentElement) {         " +
                        "  if (e === elem)                        " +
                        "    return true;                         " +
                        "}                                        " +
                        "return false;                            "
                , element);
    }

    public BootstrapFormsPage waitUntilCheckboxIsVisible() {
        defaultCheckbox.waitUntil(Condition.visible, TIMEOUT_MILLISECONDS);
        return this;
    }

    public SelenideElement getDefaultCheckbox() {
        return defaultCheckbox;
    }

    public SelenideElement getDisabledCheckbox() {
        return disabledCheckbox;
    }

    public BootstrapFormsPage checkDefaultCheckbox() {
        defaultCheckbox.click();
        return this;
    }

    public SelenideElement getSelectedRadio() {
        return selectedRadio;
    }

    public SelenideElement getUnSelectedRadio() {
        return unSelectedRadio;
    }

    public SelenideElement getDisabledRadio() {
        return disabledRadio;
    }

    public BootstrapFormsPage waitUntilRadioIsVisible() {
        $("#exampleRadios1").waitUntil(Condition.visible, TIMEOUT_MILLISECONDS);
        return this;
    }

    public BootstrapFormsPage selectTheUnselectedRadio() {
        unSelectedRadio.click();
        return this;
    }

    public BootstrapFormsPage waintUntilButtonIsDisabled() {
        disabledButton.waitUntil(Condition.visible, TIMEOUT_MILLISECONDS);
        return this;
    }

    public SelenideElement getDisabledButton() {
        return disabledButton;
    }

    public SelenideElement getActiveButton() {
        return activeButton;
    }

    public BootstrapFormsPage scrollPageDown() {
        executeJavaScript("window.scroll(0, window.innerHeight)");
        return this;
    }

    public SelenideElement getSelect() {
        return select;
    }

    public SelenideElement getMultiSelect() {
        return multiSelect;
    }

    public SelenideElement getSelectedOption() {
        return select.getSelectedOption();
    }

    public BootstrapFormsPage selectOption(final String option) {
        select.selectOption(option);
        return this;
    }

    public ElementsCollection getSelectOptions() {
        return selectOptions;
    }
}
