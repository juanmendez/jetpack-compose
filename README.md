# Jetpack Compose

> ~ hey Jetpack Compose, remember to hold this value in my variable.
> ~ Ok, got it!


[![State in Jetpack Compose](https://img.youtube.com/vi/PMMY23F0CFg/0.jpg)](https://www.youtube.com/watch?v=PMMY23F0CFg)

After seeing a bit of stateful composables in the previous codelab courses. We are going to emphasize more how we manage composables driven by data.

We can rely on mutable states, wrapped in a `remember` delegate which keeps in memory the current state even if its hosting composable is refreshed or as it is called *recomposed*.

<img width="800" alt="image" src="https://user-images.githubusercontent.com/3371622/173200703-f37a5827-4bdf-48eb-bfb0-53d17a4b1ceb.png">


After seeing how a mutable state is kept in memory, we can use this shortcut.

<img width="800" alt="image" src="https://user-images.githubusercontent.com/3371622/173200713-332d5edd-bbec-439e-888a-9c956cec82e1.png">

How easy is to set conditions to display the text if the value is greater than zero. Also how to disable the button when counter reaches 10!

<img width="800" alt="image" src="https://user-images.githubusercontent.com/3371622/173201047-f07d7d30-85e7-4830-bae4-099c6807dc42.png">

Wow, there is also a layout inspector in Android Studio!

<img width="300" alt="image" src="https://user-images.githubusercontent.com/3371622/173201098-777dfe0e-9c3e-4519-ac33-0901384cc550.png">

If we rotate the device, then our composable starts from scratch. So in order to save the state upon rotation, we use instead

```kotlin
var count by rememberSaveable { mutableListOf(0) }
```

`rememberSaveable` can be used for configuration changes, but also whenever our composable leaves the current ui three, and comes back such as the case of ListView rows.

 ### Key Concepts

A **stateful** composable owns state

a **stateless** composable doesn't hold any state.

**State hoisting** is a patter of moving state to a composable's caller to make a composable stateless. It simply means brekaing apart a stateful composable into other composables which receive the state, but in order to modify it, they require to do it through a callback which in Kotlin would be a lambda.

**unidirection of data flow** means a state goes down, events go up.


At one point in this demo there is list-view which has its rows able to use `rememberSaveable` but the list in itself is not. That's how the demo shows after the rotation is a brand new list, [watch](https://youtu.be/PMMY23F0CFg?t=2200). So one solution is to host the list in a `ViewModel` as it is known for keeping data persistent upon device configuration changes.


This is our ViewModel:

<img width="800" alt="image" src="https://user-images.githubusercontent.com/3371622/173205809-52ed40ce-c32c-4b8b-a6fe-ce5ebc28eb95.png">

And here is our composable accessing the list from the ViewModel, and it delegates the close task to it as well.


<img width="781" alt="image" src="https://user-images.githubusercontent.com/3371622/173205850-4d786283-2809-49fc-89c9-9e4bbf67ab18.png">

Now our ViewModel hosting the list can retain it upon rotation, [watch](https://youtu.be/PMMY23F0CFg?t=2485).

MVVM is a great pattern used in Android, and this demo shows an application can hold onto it, but just have the View be based on Compose instead of Android component and XML layout.