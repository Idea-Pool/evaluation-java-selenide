package com.epam.ideapool;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import com.codeborne.selenide.Condition;
import com.epam.ideapool.page.BootstrapFormsPage;
import org.junit.Test;

public class BootstrapTest extends BaseTest {
    private final BootstrapFormsPage homePage = new BootstrapFormsPage();

    @Test
    public void checkingFormElements() {
        homePage.openPage("https://getbootstrap.com/docs/4.4/components/forms/");
        assertEquals("Forms · Bootstrap", homePage.getTitle());
        assertFalse(homePage.isReadonlyInputInViewport());
        homePage.scrollToReadonlyInput();
        assertTrue(homePage.isReadonlyInputInViewport());
        homePage.getReadonlyInput().shouldBe(Condition.readonly);
    }

    @Test
    public void interactionWithCheckboxFormElements() {
        homePage.openPage("https://getbootstrap.com/docs/4.4/components/forms/#checkboxes-and-radios").waitUntilCheckboxIsVisible();
        homePage.getDisabledCheckbox().shouldBe(Condition.disabled);
        homePage.getDefaultCheckbox().shouldBe(Condition.enabled).shouldNotBe(Condition.checked);
        homePage.checkDefaultCheckbox();
        homePage.getDefaultCheckbox().shouldBe(Condition.checked);
    }

    @Test
    public void interactionWithRadioFormElements() {
        homePage.openPage("https://getbootstrap.com/docs/4.4/components/forms/#checkboxes-and-radios").waitUntilRadioIsVisible();
        homePage.getDisabledRadio().shouldBe(Condition.disabled);
        homePage.getSelectedRadio().shouldBe(Condition.selected);
        homePage.getUnSelectedRadio().shouldNotBe(Condition.selected);
        homePage.selectTheUnselectedRadio();
        homePage.getSelectedRadio().shouldNotBe(Condition.selected);
        homePage.getUnSelectedRadio().shouldBe(Condition.selected);
    }

    @Test
    public void checkingButtonFormElements() throws Exception {
        homePage.openPage("https://getbootstrap.com/docs/4.4/components/buttons/#disabled-state").waintUntilButtonIsDisabled();
        homePage.getDisabledButton().shouldBe(Condition.matchText("Primary button"));
        homePage.getDisabledButton().shouldBe(Condition.disabled);
        homePage.scrollPageDown();
        homePage.getActiveButton().shouldBe(Condition.enabled);
    }

    @Test
    public void checkingSelectFormElements() {
        homePage.openPage("https://getbootstrap.com/docs/4.4/components/forms/#form-controls");
        homePage.getSelect().shouldBe(Condition.visible);
        homePage.getMultiSelect().shouldHave(Condition.attribute("multiple"));
        homePage.getSelectedOption().shouldBe(Condition.matchText("1"));
        homePage.getSelect()
                .shouldNotHave(Condition.matchText("Hello"))
                .shouldHave(Condition.matchText("2"));
        homePage.selectOption("2")
                .getSelectedOption()
                .shouldBe(Condition.matchText("2"));
        homePage.getSelectOptions().shouldHaveSize(5);
    }
}
