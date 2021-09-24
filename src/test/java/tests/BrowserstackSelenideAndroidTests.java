package tests;

import com.codeborne.selenide.Condition;
import com.google.gson.internal.bind.util.ISO8601Utils;
import io.appium.java_client.MobileBy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

@Tag("selenide_android")
public class BrowserstackSelenideAndroidTests extends TestBase {

    @Test
    @DisplayName("Successful search in wikipedia android app")
    void searchTest() {
        step("Type search", () -> {
            $(MobileBy.AccessibilityId("Search Wikipedia")).click();
            $(MobileBy.id("org.wikipedia.alpha:id/search_src_text")).val("BrowserStack");
        });
        step("Verify content found", () ->
                $$(MobileBy.id("org.wikipedia.alpha:id/page_list_item_container"))
                        .shouldHave(sizeGreaterThan(0)));
    }

    @Test
    @Tag("selenide_android_bs2")
    @DisplayName("Check settings menu navigation")
    void settingsTest() {
        step("push '...' and 'Settings'", () -> {
            $(MobileBy.id("org.wikipedia.alpha:id/menu_overflow_button")).click();
            $(MobileBy.id("org.wikipedia.alpha:id/explore_overflow_settings")).click();
        });
        step("Verify that first title is 'Wikipedia languagejr'", () ->
                $(MobileBy.id("android:id/title")).shouldHave(Condition.text("Wikipedia language")));
    }

}

