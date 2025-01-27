package dev.jorgecastillo.compose.app

import androidx.activity.ComponentActivity
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.layout.layout
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.test.assert
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onRoot
import androidx.compose.ui.test.printToLog
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.jorgecastillo.compose.app.ui.theme.ComposeAndInternalsTheme
import org.junit.Rule
import org.junit.Test

/**
 * ### Exercise 5 👩🏾‍💻
 *
 * In this exercise we must create a custom [Modifier.layout] using the function
 * [Modifier.alignToCorner] defined in this same test class.
 *
 * To complete this exercise:
 *
 * 1. Use [Modifier.layout] to place the modified node (FloatingActionButton) at the corresponding
 *    corner given by its single argument. Remember to use [Pleaceable.placeRelative] in order to
 *    place the node (once measured) in x and y coordinates relative to its parent.
 *
 * 2. Run the test.
 */
class Exercise5Test {

    @get:Rule
    val composeTestRule = createAndroidComposeRule(ComponentActivity::class.java)

    @Test
    fun composable_aligned_top_left() {
        // Start the app
        composeTestRule.setContent {
            ComposeAndInternalsTheme {
                Box(Modifier.fillMaxSize()) {
                    FloatingActionButton(
                        modifier = Modifier
                            .alignToCorner(Corner.TopStart)
                            .testTag("FAB"),
                        onClick = { /*TODO*/ }
                    ) {
                        Icon(
                            painter = rememberVectorPainter(image = Icons.Default.Add),
                            contentDescription = ""
                        )
                    }
                }
            }
        }

        composeTestRule.onNodeWithTag("FAB").assert(isAlignedToCorner(Corner.TopStart))
        composeTestRule.onRoot().printToLog("Exercise 5")
    }

    @Test
    fun composable_aligned_top_right() {
        // Start the app
        composeTestRule.setContent {
            ComposeAndInternalsTheme {
                Box(Modifier.fillMaxSize()) {
                    FloatingActionButton(
                        modifier = Modifier
                            .alignToCorner(Corner.TopEnd)
                            .testTag("FAB"),
                        onClick = { /*TODO*/ }
                    ) {
                        Icon(
                            painter = rememberVectorPainter(image = Icons.Default.Add),
                            contentDescription = ""
                        )
                    }
                }
            }
        }

        composeTestRule.onNodeWithTag("FAB").assert(isAlignedToCorner(Corner.TopEnd))
        composeTestRule.onRoot().printToLog("Exercise 5")
    }

    @Test
    fun composable_aligned_bottom_left() {
        // Start the app
        composeTestRule.setContent {
            ComposeAndInternalsTheme {
                Box(Modifier.fillMaxSize()) {
                    FloatingActionButton(
                        modifier = Modifier
                            .alignToCorner(Corner.BottomStart)
                            .testTag("FAB"),
                        onClick = { /*TODO*/ }
                    ) {
                        Icon(
                            painter = rememberVectorPainter(image = Icons.Default.Add),
                            contentDescription = ""
                        )
                    }
                }
            }
        }

        composeTestRule.onNodeWithTag("FAB").assert(isAlignedToCorner(Corner.BottomStart))
        composeTestRule.onRoot().printToLog("Exercise 5")
    }

    @Test
    fun composable_aligned_bottom_right() {
        // Start the app
        composeTestRule.setContent {
            ComposeAndInternalsTheme {
                Box(Modifier.fillMaxSize()) {
                    FloatingActionButton(
                        modifier = Modifier
                            .alignToCorner(Corner.BottomEnd)
                            .testTag("FAB"),
                        onClick = { /*TODO*/ }
                    ) {
                        Icon(
                            painter = rememberVectorPainter(image = Icons.Default.Add),
                            contentDescription = ""
                        )
                    }
                }
            }
        }

        composeTestRule.onNodeWithTag("FAB").assert(isAlignedToCorner(Corner.BottomEnd))
        composeTestRule.onRoot().printToLog("Exercise 5")
    }
}

enum class Corner {
    TopStart,
    TopEnd,
    BottomStart,
    BottomEnd
}

fun Modifier.alignToCorner(corner: Corner) = layout { measurable, constraints ->
    // Measure the composable
    val placeable = measurable.measure(constraints)
    layout(constraints.maxWidth, constraints.maxHeight) {
        // Where the composable gets placed
        when (corner) {
            Corner.TopStart -> {
                placeable.placeRelative(
                    x = 0,
                    y = 0
                )
            }
            Corner.TopEnd -> {
                placeable.placeRelative(
                    x = constraints.maxWidth - placeable.width,
                    y = 0
                )
            }
            Corner.BottomStart -> {
                placeable.placeRelative(
                    x = 0,
                    y = constraints.maxHeight - placeable.height
                )
            }
            Corner.BottomEnd -> {
                placeable.placeRelative(
                    x = constraints.maxWidth - placeable.width,
                    y = constraints.maxHeight - placeable.height
                )
            }
        }
    }
}

@Preview(
    locale = "ar", // Arabic (RTL)
    name = "Arabic (RTL)"
)
@Preview(
    locale = "en", // English (LTR)
    name = "English (LTR)"
)
@Composable
fun Exercise5Preview() = ComposeAndInternalsTheme {
    ComposeAndInternalsTheme {
        Box(Modifier.fillMaxSize()) {
            FloatingActionButton(
                modifier = Modifier
                    .alignToCorner(Corner.TopStart),
                onClick = { /*TODO*/ }
            ) {
                Text(
                    modifier = Modifier.padding(10.dp),
                    text = Corner.TopStart.name
                )
            }
            FloatingActionButton(
                modifier = Modifier
                    .alignToCorner(Corner.TopEnd),
                onClick = { /*TODO*/ }
            ) {
                Text(
                    modifier = Modifier.padding(10.dp),
                    text = Corner.TopEnd.name
                )
            }
            FloatingActionButton(
                modifier = Modifier
                    .alignToCorner(Corner.BottomEnd),
                onClick = { /*TODO*/ }
            ) {
                Text(
                    modifier = Modifier.padding(10.dp),
                    text = Corner.BottomEnd.name
                )
            }
            FloatingActionButton(
                modifier = Modifier
                    .alignToCorner(Corner.BottomStart),
                onClick = { /*TODO*/ }
            ) {
                Text(
                    modifier = Modifier.padding(10.dp),
                    text = Corner.BottomStart.name
                )
            }
        }
    }
}