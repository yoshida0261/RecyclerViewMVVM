package com.example.recyclerviewmvvm

import android.app.Application
import androidx.databinding.ObservableArrayList
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent

class SampleViewModel(application: Application) : AndroidViewModel(application), LifecycleObserver {

    val adapterItems = ObservableArrayList<SampleAdapter.AdapterItem.SampleItem>()


    fun fetchItems() {
        adapterItems.add(SampleAdapter.AdapterItem.SampleItem("test"))
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun onCreate() {
        if (adapterItems.isEmpty()) fetchItems()
    }
}
