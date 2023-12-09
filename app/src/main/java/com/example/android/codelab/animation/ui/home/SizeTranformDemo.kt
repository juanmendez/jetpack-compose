package com.example.android.codelab.animation.ui.home

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.SizeTransform
import androidx.compose.animation.core.keyframes
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntSize
import com.example.android.codelab.animation.ui.AnimationCodelabTheme

@OptIn(ExperimentalMaterialApi::class, ExperimentalAnimationApi::class)
@Composable
fun SizeTransformDemo(
    modifier: Modifier = Modifier,
) {

    var expanded by remember { mutableStateOf(false) }
    Box( Modifier.fillMaxSize()) {
        Surface(
            color = MaterialTheme.colors.primary,
            onClick = { expanded = !expanded }
        ) {
            AnimatedContent(
                targetState = expanded,
                transitionSpec = {
                    /**
                     * Just like with TransitionSpec, we need the following
                     * enterAnimation togetherWith exitAnimation.
                     * BUT, we also can tail size transformation
                     * enterAnimation togetherWith exitAnimation using SizeTransform.
                     */
                    fadeIn(animationSpec = tween(150, 150)) togetherWith
                        fadeOut(animationSpec = tween(150)) using
                        SizeTransform { initialSize, targetSize ->
                            if (targetState) {
                                /**
                                 * targetState describes the final state..
                                 * Here we want define the initial dimensions having
                                 * final width with initial height
                                 */
                                keyframes {
                                    // Expand horizontally first.
                                    IntSize(targetSize.width, initialSize.height) at 150
                                    durationMillis = 300
                                }
                            } else {
                                /**
                                 * If we are going back to the initial state
                                 * Here we want to start the animation having
                                 * initial width with final height
                                 */
                                keyframes {
                                    // Shrink vertically first.
                                    IntSize(initialSize.width, targetSize.height) at 150
                                    durationMillis = 300
                                }
                            }
                        }
                }, label = "Size Transform"
            ) { targetExpanded ->
                if (targetExpanded) {
                    Text(
                        "Cupcake ipsum dolor sit amet croissant gingerbread sweet muffin. Candy canes gingerbread lemon drops muffin topping marshmallow jelly. Chocolate cake marshmallow gummies lollipop carrot cake carrot cake fruitcake danish. Oat cake marshmallow icing topping chocolate bar dragée sesame snaps. Caramels bonbon cotton candy sugar plum sweet. Pudding chocolate sweet roll sugar plum oat cake. Powder lollipop marshmallow lemon drops apple pie icing cake. Powder cupcake jujubes gummies cotton candy icing. Tiramisu jujubes wafer powder liquorice sesame snaps oat cake. Shortbread croissant chocolate cake sugar plum gummi bears chupa chups pudding."
                    )
                } else {
                    Text("Cookie.")
                }
            }
        }
    }

}

@Preview
@Composable
fun SizeTransformDemoPreview() {
    AnimationCodelabTheme {
        SizeTransformDemo()
    }
}