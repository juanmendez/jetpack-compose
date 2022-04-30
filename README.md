# Jetpack Compose

- We learned how a custom composable should follow the same pattern as the standard ones starting with a modifier.
- Chaining modifiers matter how they are ordered

The order of chained modifiers in a factory pattern matter.

```
Row(
  modifier
  .padding(16.dp)
  .clickable(onClick = clickable) 
) {...}
```
![clickable_after_padding](https://user-images.githubusercontent.com/3371622/166115451-4c681c75-6a80-4340-a4ac-b49c203a51e8.gif)

```
Row(
    modifier
        .clickable(onClick = clickable)
        .padding(16.dp)
) {...}
```
![clickable_before_padding](https://user-images.githubusercontent.com/3371622/166115536-e5322f2a-2368-4979-8193-c78f263849fe.gif)