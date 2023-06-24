package com.jetpack.compose

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainViewModel(
    private val ioDispatcher: CoroutineDispatcher,
) : ViewModel(), LifecycleEventObserver {
    private val _currentStateData = MutableLiveData<String>()
    val currentStateData: LiveData<String> = _currentStateData

    private var _count = mutableStateOf(1)
    val count: State<Int> = _count

    override fun onStateChanged(source: LifecycleOwner, event: Lifecycle.Event) {
        _currentStateData.value = event.name
    }

    fun incrementByFiveWithDelay(ofMillisecionds: Long = 1_000) {
        viewModelScope.launch(ioDispatcher) {
            for(i in _count.value.._count.value + 5) {
                _count.value = i
                delay(ofMillisecionds)
            }
        }
    }
}