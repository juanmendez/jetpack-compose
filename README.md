# Jetpack Compose - State hoisting

In Composable functions, state that is read or modified by multiple functions should live in a common ancestor—this process is called state hoisting. To hoist means to lift or elevate.

![hoistin](https://user-images.githubusercontent.com/3371622/165652978-887584aa-a25c-4cbb-b7c1-98d3e5267678.gif)

Only specific ui elements are redrawn. For example swapping screens take effect. When viewing second screen with a list view, those items are drawn. Every time one cell is expanded or collapsed then that given cell is redrawn while the other cell has no drawing updates.

![redrawing-specific-ui-elements](https://user-images.githubusercontent.com/3371622/165654041-e84b209a-4549-4f85-b92e-279daadce46b.gif)
