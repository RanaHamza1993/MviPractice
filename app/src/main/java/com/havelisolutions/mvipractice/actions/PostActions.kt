package com.havelisolutions.mvipractice.actions

import com.havelisolutions.mvipractice.intefaces.Action

sealed class PostActions: Action {

    object getPostAction:PostActions()
}