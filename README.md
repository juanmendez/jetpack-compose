# Jetpack Compose Navigation

Each learning chapter is stored in its own branch.

- `codelab-basics/*` has all chapters which are part of [Jetpack Compose basics in Codelabs](https://developer.android.com/codelabs/jetpack-compose-basics).
- `codelab-layouts/*` has all chapters which are part of [Layouts in Jetpack Compose](https://developer.android.com/codelabs/jetpack-compose-layouts)
- `codelab-states/*` has all chapters which are part of [State in Jetpack Compose](https://developer.android.com/codelabs/jetpack-compose-state)
- `codelab-states-advanced/*` has all chapters which are part of [Advanced State and Side Effects in Jetpack Compose](https://developer.android.com/codelabs/jetpack-compose-advanced-state-side-effects)
- `codelab-theming/*` has all chapters which are part of [Jetpack Compose theming](https://developer.android.com/codelabs/jetpack-compose-theming)
- `codelabs-material-theming/*` has all chapters which are part of [Material Theming with Jetpack Compose](https://developer.android.com/codelabs/basic-android-kotlin-compose-material-theming)
- `codelab-migration/*` learn how to migrate to Compose incrementally from a layout designed application, [Migrating to Jetpack Compose](https://developer.android.com/codelabs/jetpack-compose-migration) 
- `codelab-espresso/*` how to work with Espresso using Jetpack Compose, [Testing in Jetpack Compose](https://developer.android.com/codelabs/jetpack-compose-testing)
- `codelab-navigation/*` Learn how to use Jetpack Compose with Jetpack Navigation, [Navigation in Compose](https://developer.android.com/codelabs/jetpack-compose-navigation)

## Applying native navigation to Jetpack Compose

This app has been also found in `codelabs-espresso/*`. Based on re-composition we can populate the same hosting composable multiple times without leaving to another screen. In this demo we will learn how to use Compose with Navigation, which is another library in Jetpack. 
[read more](https://developer.android.com/guide/navigation)

The basic migration to Jetpack Compose follows several steps:

1. Add the latest Compose Navigation dependency
2. Set up the NavController
3. Add a NavHost and create the navigation graph
4. Prepare routes for navigating between different app destinations
5. Replace the current navigation mechanism with Compose Navigation


DeepLinking

In order to test `codelab-navigation/04.deep-link` run the following at the terminal
```
adb shell am start -d "rally://single_account/Checking" -a android.intent.action.VIEW
```



