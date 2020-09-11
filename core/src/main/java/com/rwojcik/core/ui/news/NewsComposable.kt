package com.rwojcik.core.ui.news

import androidx.compose.foundation.Icon
import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import com.rwojcik.core.R
import com.rwojcik.core.model.News
import dev.chrisbanes.accompanist.coil.CoilImage

@Composable
fun News(news: News, bookmarked: Boolean, onBookmarkClick: (() -> Unit)? = null) {
    Surface(color = Color.White) {
        Column(Modifier.fillMaxWidth()) {
            CoilImage(
                data = news.imageUrl,
                contentScale = ContentScale.FillWidth,
                modifier = Modifier.fillMaxWidth().aspectRatio(16f / 9f)
            )
            Column(Modifier.fillMaxWidth().padding(16.dp)) {
                Text(
                    text = news.section,
                    style = MaterialTheme.typography.caption.copy(color = Color.Blue)
                )
                Text(text = news.lead, style = MaterialTheme.typography.subtitle2)
                Text(text = news.title, style = MaterialTheme.typography.h4)
            }
            Row(
                Modifier.fillMaxWidth()
                    .padding(top = 8.dp, bottom = 8.dp, start = 16.dp, end = 16.dp),
                verticalGravity = Alignment.CenterVertically
            ) {
                Text(
                    text = news.published,
                    Modifier.weight(1f),
                    style = MaterialTheme.typography.caption
                )
                Comment(news.comments)
                IconButton(
                    icon = {
                        Icon(
                            asset = if (bookmarked) {
                                vectorResource(id = R.drawable.ic_outline_bookmark_24)
                            } else {
                                vectorResource(id = R.drawable.ic_outline_bookmark_border_24)
                            },
                            tint = Color.DarkGray
                        )
                    },
                    onClick = { onBookmarkClick?.invoke() }
                )
                IconButton(
                    icon = {
                        Icon(
                            asset = vectorResource(id = R.drawable.ic_outline_share_24),
                            tint = Color.DarkGray
                        )
                    },
                    onClick = {}
                )
            }
        }
    }
}

@Composable
private fun Comment(count: Int) {
    IconButton(onClick = {}) {
        Row(verticalGravity = Alignment.CenterVertically) {
            Text(text = count.toString(), style = MaterialTheme.typography.caption)
            Spacer(modifier = Modifier.width(4.dp))
            Icon(
                asset = vectorResource(id = R.drawable.ic_outline_mode_comment_24),
                tint = Color.DarkGray
            )
        }
    }
}