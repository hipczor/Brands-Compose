package com.rwojcik.composebrands.config

import com.rwojcik.composebrands.ads.AwesomeAdComposer
import com.rwojcik.core.configuration.UiConfiguration
import com.rwojcik.core.ui.ads.AdComposer

object AwesomeNewsUiConfiguration: UiConfiguration {

    override val adComposer: AdComposer = AwesomeAdComposer
}