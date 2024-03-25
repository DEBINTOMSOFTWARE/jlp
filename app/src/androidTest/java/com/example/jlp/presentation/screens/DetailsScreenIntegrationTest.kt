package com.example.jlp.presentation.screens

import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.semantics.SemanticsActions
import androidx.compose.ui.test.assertTextContains
import androidx.compose.ui.test.isDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onChildAt
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performSemanticsAction
import androidx.test.core.app.ActivityScenario
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.jlp.MainActivity
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@ExperimentalComposeUiApi
@RunWith(AndroidJUnit4::class)
class DetailsScreenIntegrationTest {

    @get:Rule
    val rule = createComposeRule()

    @Test
    fun launchDetailsScreenOnProductClicked() {
        val activityScenario = ActivityScenario.launch(MainActivity::class.java)
        rule.waitForIdle()
        rule.onNodeWithContentDescription("Loading Progress").isDisplayed()
        rule.waitUntil(5000) {
            rule.onNodeWithContentDescription("Product List").isDisplayed()
        }
        rule.onNodeWithContentDescription("Product List").onChildAt(0)
            .assertTextContains("Bosch Serie 2 SMV40C30GB Fully Integrated Dishwasher")
        rule.onNodeWithContentDescription("Product List").onChildAt(0)
            .performSemanticsAction(SemanticsActions.OnClick)
        rule.onNodeWithContentDescription("Details Screen").isDisplayed()
        rule.onNodeWithContentDescription("AppBar").isDisplayed()
        rule.onNodeWithContentDescription("Horizontal Pager").isDisplayed()
        rule.onNodeWithContentDescription("Image 1 0f 5").isDisplayed()
        rule.onNodeWithContentDescription("Horizontal Pager Indicators").isDisplayed()
        rule.onNodeWithTag("pager_indicator_1").isDisplayed()
        rule.onNodeWithTag("pager_indicator_2").isDisplayed()
        rule.onNodeWithTag("pager_indicator_3").isDisplayed()
        rule.onNodeWithTag("pager_indicator_4").isDisplayed()
        rule.onNodeWithTag("pager_indicator_5").isDisplayed()
        rule.onNodeWithContentDescription("Product Information").isDisplayed()
        rule.onNodeWithContentDescription("Product Specification").isDisplayed()
        activityScenario.close()
    }
}