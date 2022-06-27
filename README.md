# Jetpack Compose

[![State in Jetpack Compose](https://img.youtube.com/vi/PMMY23F0CFg/0.jpg)](https://www.youtube.com/watch?v=PMMY23F0CFg)


## View Model

Earlier in this codelab we learned how a mutable state is the key to refresh a composable. How such behavior also prevents the mutable object to be reset as it is hosted in the composable. In this chapter we let our mutable state is now moved into a ViewModel. The ViewModel handles the business logic, so it is capable of updating the mutable state, which causes the root composable to update. That root composable is stateful, while its children are stateless. They are refreshed with data, but can also signal events all the way back to the ViewModel.


```
class WellnessViewModel : ViewModel() {
    // this approach is similar with what's been used in MutableLiveData vs LiveData
    private val _tasks = getWellnessTasks().toMutableStateList()
    val tasks: List<WellnessTask>
        get() = _tasks

    fun remove(item: WellnessTask) = _tasks.remove(item)

    // stateless composables can request changes. As views, they have no contract 
    // with the ViewModel, so they are only provided with a callback reference to
    // request having the task checked. Same case for the remove function.
    fun onCheckedTask(item: WellnessTask, checked: Boolean) {
        tasks.find { it.id == item.id }?.let { task ->
            task.checked = checked
        }
    }
}
```
