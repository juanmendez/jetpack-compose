# [Text Style](https://developer.android.com/codelabs/jetpack-compose-theming#5)

Text styling as mentioned in the previous chapter is based on the Typography class.
There you can stylize different text types based on Material design.

Compose is based on imutability so rather than updating one text style for example, one can be copied and then modified.

```
val tagStyle = MaterialTheme.typography.overline.toSpanStyle().copy(
 background = MaterialTheme.colors.primary.copy(alpha = 0.1f)
)
```

Where in Android we cannot have multiple styles for the text in a TextView unless there is some tweak around using HTML. In Compose we can break the text appart and then apply styles

```
val text = buildAnnotatedString {
  append("This is some unstyled text\n")
  withStyle(SpanStyle(color = Color.Red)) {
    append("Red text\n")
  }
  withStyle(SpanStyle(fontSize = 24.sp)) {
    append("Large text")
  }
}

Text(text)

```