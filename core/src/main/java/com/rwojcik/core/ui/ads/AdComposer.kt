package com.rwojcik.core.ui.ads

import androidx.compose.runtime.Composable
import com.rwojcik.core.model.Ad

interface AdComposer {

    @Composable
    fun composeNativeAd(ad: Ad)
}