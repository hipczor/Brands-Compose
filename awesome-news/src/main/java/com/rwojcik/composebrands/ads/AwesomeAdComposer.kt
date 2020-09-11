package com.rwojcik.composebrands.ads

import androidx.compose.foundation.Box
import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.rwojcik.core.model.Ad
import com.rwojcik.core.ui.ads.AdComposer
import dev.chrisbanes.accompanist.coil.CoilImage

object AwesomeAdComposer : AdComposer {

    @Composable
    override fun composeNativeAd(ad: Ad) {
        Surface(color = AdColors.background) {
            Column(modifier = Modifier.fillMaxWidth()) {
                AdBar()
                CoilImage(
                    data = ad.image,
                    Modifier.fillMaxWidth().aspectRatio(1.91f / 1f),
                    contentScale = ContentScale.FillWidth
                )
                Surface(color = AdColors.background) {
                    Column(
                        modifier = Modifier.padding(
                            top = 8.dp,
                            start = 16.dp,
                            end = 16.dp,
                            bottom = 16.dp
                        )
                    ) {
                        Text(text = ad.title, style = MaterialTheme.typography.subtitle1)
                        Text(
                            text = "External link sponsored by ${ad.consignor}".toUpperCase(),
                            style = MaterialTheme.typography.caption
                        )
                        Box(
                            backgroundColor = AdColors.separator,
                            modifier = Modifier.padding(vertical = 8.dp).height(2.dp).fillMaxWidth()
                        )
                        Text(text = ad.description, style = MaterialTheme.typography.caption)
                    }
                }
            }
        }
    }

    @Composable
    private fun AdBar() {
        Surface(color = AdColors.primary) {
            Text(text = "Advertisement", modifier = Modifier.fillMaxWidth().padding(8.dp), color = Color.White)
        }
    }
}


private object AdColors {
    val primary = Color(0xFF0067B4)
    val background = Color(0xFFE1EEFE)
    val separator = Color(0xFFC2CBD7)
}