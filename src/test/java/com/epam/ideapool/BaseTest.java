package com.epam.ideapool;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.junit.ScreenShooter;
import org.junit.BeforeClass;
import org.junit.Rule;

public abstract class BaseTest {
    @Rule
    public ScreenShooter makeScreenshotOnFailure = ScreenShooter.failedTests();

    @BeforeClass
    public static void setup() {
        Configuration.headless = false;
        Configuration.startMaximized = true;
        Configuration.screenshots = true;
        Configuration.reportsFolder = "target/surefire-reports";
        Configuration.pageLoadStrategy = "normal";
    }
}
