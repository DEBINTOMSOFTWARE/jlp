package com.example.jlp.presentation.screens

import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.semantics.SemanticsActions
import androidx.compose.ui.test.assertTextContains
import androidx.compose.ui.test.isDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onChildAt
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.performSemanticsAction
import androidx.test.core.app.ActivityScenario
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.jlp.MainActivity
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@ExperimentalComposeUiApi
@RunWith(AndroidJUnit4::class)
class ProductScreenIntegrationTest {

    @get:Rule
    val rule = createComposeRule()

    @Test
    fun testProductScreenLoadingAndProductsDisplay() {
        val activityScenario = ActivityScenario.launch(MainActivity::class.java)

        rule.waitForIdle()
        rule.onNodeWithContentDescription("Loading Progress").isDisplayed()
        rule.waitUntil(5000) {
            rule.onNodeWithContentDescription("Product List").isDisplayed()
        }
        rule.onNodeWithContentDescription("Product List").onChildAt(0)
            .assertTextContains("Bosch Serie 2 SMV40C30GB Fully Integrated Dishwasher")
        rule.onNodeWithContentDescription("Product List").onChildAt(1)
            .assertTextContains("Bosch Serie 2 SMS24AW01G Freestanding Dishwasher, White")
        rule.onNodeWithContentDescription("Product List").onChildAt(2)
            .assertTextContains("Bosch Serie 2 SPV2HKX39G Fully Integrated Slimline Dishwasher")
        rule.onNodeWithContentDescription("Product List").onChildAt(3)
            .assertTextContains("Bosch Serie 4 SMV46NX00G Fully Integrated Dishwasher")
        rule.onNodeWithContentDescription("Product List").onChildAt(4)
            .assertTextContains("Bosch Serie 2 SMS2HVW66G Freestanding Dishwasher, White")
        rule.onNodeWithContentDescription("Product List").onChildAt(5)
            .assertTextContains("Beko DFS05020W Freestanding Slimline Dishwasher, White")
        activityScenario.close()
    }

    @Test
    fun testProductScreenDisplayAndPerformClick() {
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

        activityScenario.close()
    }


}