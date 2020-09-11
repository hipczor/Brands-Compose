package com.rwojcik.composebrands

import android.app.Application
import com.rwojcik.composebrands.config.AwesomeNewsUiConfiguration
import com.rwojcik.core.app.GlobalDependencies
import com.rwojcik.core.configuration.UiConfiguration

class AwesomeNewsApp : Application(), GlobalDependencies {

    override val uiConfiguration: UiConfiguration = AwesomeNewsUiConfiguration
}