# [Material Theming](https://developer.android.com/codelabs/jetpack-compose-theming#2)

Jetpack Compose is based on [Material Theming](https://m3.material.io/).

Material theming is technology agnostic, so I am very familiar with it from native Android.
Here it talks about colors (primar, secondary, and accent. Interact with [Color Tool](https://material.io/resources/color/)!!


This is so far what the application looks like

<img width="250" alt="initial work" src="https://user-images.githubusercontent.com/3371622/208263738-bb8111e5-db9f-41e7-80c2-9e50760199e5.png">


In terms of shapes, there is already a cut off in the upper left corner in the imagine within the card above.

So for this tutorial the emphasis is to modify it so it will use a theme for day and night.
See

<img width="250" alt="final work" src="https://developer.android.com/static/codelabs/jetpack-compose-theming/img/93f55b5d4cffb076_1440.png">

As I am starting to look how a theme gets a color dictionary assigned, then I see the typogragphy, and blows my mind how this theming applies direct connection with Material design.

See the definition of Typography.

```
Constructor to create a Typography. For information on the types of style defined in this constructor, see the property documentation for Typography.
Params:
defaultFontFamily - the default FontFamily to be used for TextStyles provided in this constructor. This default will be used if the FontFamily on the TextStyle is null.
h1 - h1 is the largest headline, reserved for short, important text or numerals.
h2 - h2 is the second largest headline, reserved for short, important text or numerals.
h3 - h3 is the third largest headline, reserved for short, important text or numerals.
h4 - h4 is the fourth largest headline, reserved for short, important text or numerals.
h5 - h5 is the fifth largest headline, reserved for short, important text or numerals.
h6 - h6 is the sixth largest headline, reserved for short, important text or numerals.
subtitle1 - subtitle1 is the largest subtitle, and is typically reserved for medium-emphasis text that is shorter in length.
subtitle2 - subtitle2 is the smallest subtitle, and is typically reserved for medium-emphasis text that is shorter in length.
body1 - body1 is the largest body, and is typically used for long-form writing as it works well for small text sizes.
body2 - body2 is the smallest body, and is typically used for long-form writing as it works well for small text sizes.
button - button text is a call to action used in different types of buttons (such as text, outlined and contained buttons) and in tabs, dialogs, and cards.
caption - caption is one of the smallest font sizes. It is used sparingly to annotate imagery or to introduce a headline.
overline - overline is one of the smallest font sizes. It is used sparingly to annotate imagery or to introduce a headline.
```

We don't have any built in definition of Typography like that in native Android. That's so nice.

Same case with coloring

```
Material Design color system.
The Material Design color system can help you create a color theme that reflects your brand or style.
!Color image 
To create a light set of colors using the baseline values, use lightColors To create a dark set of colors using the baseline values, use darkColors
Properties:
primary - The primary color is the color displayed most frequently across your app’s screens and components.
primaryVariant - The primary variant color is used to distinguish two elements of the app using the primary color, such as the top app bar and the system bar.
secondary -
The secondary color provides more ways to accent and distinguish your product. Secondary colors are best for:
Floating action buttons
Selection controls, like checkboxes and radio buttons
Highlighting selected text
Links and headlines
secondaryVariant - The secondary variant color is used to distinguish two elements of the app using the secondary color.
background - The background color appears behind scrollable content.
surface - The surface color is used on surfaces of components, such as cards, sheets and menus.
error - The error color is used to indicate error within components, such as text fields.
onPrimary - Color used for text and icons displayed on top of the primary color.
onSecondary - Color used for text and icons displayed on top of the secondary color.
onBackground - Color used for text and icons displayed on top of the background color.
onSurface - Color used for text and icons displayed on top of the surface color.
onError - Color used for text and icons displayed on top of the error color.
isLight - Whether this Colors is considered as a 'light' or 'dark' set of colors. This affects default behavior for some components: for example, in a light theme a TopAppBar will use primary by default for its background color, when in a dark theme it will use surface.
```

I am really starting to like this theme definition.

In Android we apply the theme via the Android component whereas in here the same composable is the Theme.. That's so nice also seeing how composables are used in top to bottom levels and having in this case JetNewsTheme as top level composable embedding lower level ones such as FeaturedPost. See screenshot about a preview applying directly the night theme.

<img width="1000" alt="dark theme preview" src="https://user-images.githubusercontent.com/3371622/208264670-7dc0f9c6-75c1-43e0-9f2d-e0ecb487ba9b.png">

