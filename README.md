# Jetpack Compose - Slot apis

Rather than modifying a widget in a decorated pattern, from the inside out. In Jetpack compose we can decorate within.
We have been accustomed when dealing with xml layouts to stylize buttons with a drawable to define background, corners, and strokes.
We also do the same with adding text styles, and limited ways to add icons either at the start or end.

In Jetpack Compose we are giving room within a composable to substitute its content. Similarly with what Flutter does with wrapping widgets with other widgets.

How we have been dealing with modifying a button
```kotlin
Button(
    text = "Button",
    icon: Icon? = myIcon,
    textStyle = TextStyle(...),
    spacingBetweenIconAndText = 4.dp,
    ...
)
```

How a slot gives us room to make our own content
```kotlin
Button {
    Row {
        MyImage()
        Spacer(4.dp)
        Text("Button")
    }
}
```

Scaffold is a widget used also in Flutter. So its task is to create a material screen layout. In this demo we worked with adding a Material toolbar.
And since we work with slots, we can substitute some of its content.

<img width="423" alt="Screen Shot 2022-04-30 at 1 49 10 PM" src="https://user-images.githubusercontent.com/3371622/166118778-148f76c9-e606-4952-91da-6109659b1ed2.png">
