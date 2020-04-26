package com.havelisolutions.mvipractice.generics

import kotlinx.coroutines.*

object Coroutines {
    // not many used case for running somework on main thread
//    fun main(work: suspend (() -> Unit)) =
//        CoroutineScope(Dispatchers.Main).launch {
//            work()
//        }

    //Use to run work on background thread and than get result on main thread used for perfoming
    //retrofit requests
    fun <T : Any?> ioThenMain(work: suspend () -> T, callback: (T?) -> Unit) =
        CoroutineScope(Dispatchers.Main).launch {
            val data = CoroutineScope(Dispatchers.IO).async rt@{
                return@rt work()
            }.await()
            callback(data)
        }


    //Used for running heavy computational works for running on background thread and get result on main thread.
    // Many more used cases like loops and heavy processor works data parsing etc
    fun <T : Any?> defaultThenMain(work: suspend () -> T, callback: (T?) -> Unit) =
        CoroutineScope(Dispatchers.Main).launch {
            val data = CoroutineScope(Dispatchers.Default).async rt@{
                return@rt work()
            }.await()
            callback(data)
        }

}