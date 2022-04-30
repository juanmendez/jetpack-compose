# Jetpack Compose - Slot apis

Rather than modifying a widget in a decorated pattern, from the inside out. In Jetpack compose we can decorate within.
We have been accustomed when dealing with xml layouts to stylize buttons with a drawable to define background, corners, and strokes.
We also do the same with adding text styles, and limited ways to add icons either at the start or end.

Similarly with what Flutter does with wrapping widgets with other widgets, we are giving room within a composable to substitute 
its content. 

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