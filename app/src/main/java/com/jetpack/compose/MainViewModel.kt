package com.jetpack.compose

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineDispatcher

class MainViewModel(
    private val ioDispatcher: CoroutineDispatcher,
) : ViewModel(), LifecycleEventObserver {
    private val _currentStateData = MutableLiveData<String>()
    val currentStateData: LiveData<String> = _currentStateData

    private var _count = mutableStateOf(1)
    val count: State<Int>
        get() = _count

    override fun onStateChanged(source: LifecycleOwner, event: Lifecycle.Event) {
        _currentStateData.value = event.name
    }

    fun incrementCount() {
        _count.value++
    }
}