# Jetpack Compose

[![State in Jetpack Compose](https://img.youtube.com/vi/PMMY23F0CFg/0.jpg)](https://www.youtube.com/watch?v=PMMY23F0CFg)

- Keeping states for composables requires those states to be based on `State<T>`
	- if you need integration for LiveData, RxJava, Coroutines there are extensions available in Android libraries. [Check for references](https://developer.android.com/jetpack/compose/libraries#streams).  
- State flow in composables
![composition](https://developer.android.com/codelabs/jetpack-compose-state/img/7d3509d136280b6c.png)
- What a nice way to inspect the composable tree!
	There is description when glasses are equal to zero
<img width="800" alt="image" src="https://user-images.githubusercontent.com/3371622/174690416-eebdb4fb-9ffe-4d98-b41c-58404abd090e.png">

	After pressing the button, then there is at least one glass, then we show the description
<img width="800" alt="image" src="https://user-images.githubusercontent.com/3371622/174690476-137cd30c-0c04-4279-81c6-ece3d2eebaf6.png">