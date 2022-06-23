# Jetpack Compose

[![State in Jetpack Compose](https://img.youtube.com/vi/PMMY23F0CFg/0.jpg)](https://www.youtube.com/watch?v=PMMY23F0CFg)


## State Hoisting

Anytime you expand one composable into having multiple children which are stateless, that's what is called hoisting. A stateless composable lacks stateful data. In most cases this is the way a stateless composable looks

```
@Composable
fun myStatelessWidget(value: T, onValueChanged: (T)-> Unit) {
{
	Button(onClick = { onValueChanged(T("nextValue")) } ) {
		Text("on display $value")
	}	
}
```


> The pattern where the state goes down, and events go up is called Unidirectional Data Flow (UDF), and state hoisting is how we implement this architecture in Compose. You can learn more about this in the [Compose Architecture documentation](https://developer.android.com/jetpack/compose/architecture#udf-compose).


