package com.rwojcik.core

import android.os.Bundle
import android.util.SparseBooleanArray
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumnFor
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.unit.dp
import androidx.core.util.set
import com.rwojcik.core.app.GlobalDependencies
import com.rwojcik.core.model.Ad
import com.rwojcik.core.model.News
import com.rwojcik.core.ui.ComposeBrandsTheme
import com.rwojcik.core.ui.news.News

class MainActivity : AppCompatActivity() {

    private val bookmarks = SparseBooleanArray()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val globalDependencies = GlobalDependencies.instance(this)
        val adComposer = globalDependencies.uiConfiguration.adComposer

        setContent {
            ComposeBrandsTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    LazyColumnFor(items = newsList) { item ->
                        val bookmarked = remember { mutableStateOf(bookmarks[item.hashCode()]) }
                        when(item) {
                            is News -> News(news = item, bookmarked.value, onBookmarkClick = {
                                bookmarks[item.hashCode()] = !bookmarked.value
                                bookmarked.value = !bookmarked.value
                            })
                            is Ad -> adComposer.composeNativeAd(ad = item)
                        }
                        Spacer(modifier = Modifier.height(16.dp))
                    }
                }
            }
        }
    }
}