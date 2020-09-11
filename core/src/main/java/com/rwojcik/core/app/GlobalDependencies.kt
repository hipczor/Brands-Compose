package com.rwojcik.core.app

import android.content.Context
import com.rwojcik.core.configuration.UiConfiguration

interface GlobalDependencies {
    val uiConfiguration: UiConfiguration


    companion object {
        fun instance(context: Context): GlobalDependencies {
            return context.applicationContext as? GlobalDependencies
                ?: throw IllegalArgumentException("Application class must implement GlobalDependencies interface")
        }
    }
}