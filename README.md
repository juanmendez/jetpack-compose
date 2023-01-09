# Material Theming

[From Material Theming with Jetpack Compose](https://www.youtube.com/watch?v=TREPYpUvGRM)

## Colors

In the definition of colors

```

    The primary color is the color displayed most frequently across your app's screens and components.
    The secondary color provides more ways to accent and distinguish your app.
    The surface color affects surfaces of components, such as cards, sheets, and menus.
    The background color appears behind scrollable content.
    The on color elements appear on top of other colors in the palette, and are primarily applied to text, iconography, and strokes. In our color palette, we have an onSurface color, which appears on top of the surface color, and an onPrimary color, which appears on top of the primary color.
```

It is very interesting how the prefix `on` is used to be on top and contrast with any other color suchas `onPrimary` contrasts with `primary` color.


## Shapes

To find out more about advance features visit [Shape customization tool](https://m2.material.io/design/shape/about-shape.html#shape-customization-tool)


I like to keep each composable in its own file. So that I can add a preview. It is interesting how easy is to refresh and get quick updates of the current progress.

<img width="800" alt="using Composable preview makes life easy" src="https://user-images.githubusercontent.com/114011052/211212942-ff2a8be7-62de-4293-a839-45f719b86918.png">

One we wrap the DogRow Composable's content inside a card we begin adding inheritance
of Material design. So our row's text content doesn't have to be explicit of what color to have since it is going to go by `onSurface` color. The card is going to apply `surface` color by inheritance, so no need to imply background color anymore within its row. The card also inherits `Shape.medium` having rounded corner shape of `16.dp`.

<img width="595" alt="image" src="https://user-images.githubusercontent.com/114011052/211213458-7e5ac459-afef-4f3c-b651-bfc01d91e546.png">

It is always imperative to apply simplicity by making use of inheritance through out our application. What it is very important is to find where this information resides so we can also use a reference to how components inherit from Theme such as the case of the card.


Speaking of which, there is a site having valuable information about components, check out [JetpackCompose.net](https://www.jetpackcompose.net/jetpack-compose-card)