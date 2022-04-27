# Jetpack Compose

<img width="480" src="https://developer.android.com/codelabs/jetpack-compose-basics/img/e3914108b7082ac0.gif">

Compose apps transform data into UI by calling composable functions. If your data changes, Compose re-executes these functions with the new data, creating an updated UI—this is called recomposition. Compose also looks at what data is needed by an individual composable so that it only needs to recompose components whose data has changed and skip recomposing those that are not affected.

As mentioned in [Thinking in Compose](https://developer.android.com/jetpack/compose/mental-model#recomposition):
Composable functions can execute frequently and in any order, you must not rely on the ordering in which the code is executed, or on how many times this function will be recomposed.
