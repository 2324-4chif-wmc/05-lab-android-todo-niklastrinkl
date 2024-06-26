package at.htl.post.ui.layout

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Checkbox
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import at.htl.post.model.Model
import at.htl.post.model.Post

@Composable
fun Posts(model: Model, modifier: Modifier = Modifier) {
    val posts = model.posts
    LazyColumn(
        modifier = modifier.padding(16.dp)
    ) {
        items(posts.size) { index ->
            PostRow(post = posts[index])
            HorizontalDivider()
        }
    }
}

@Composable
fun PostRow(post: Post) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = post.title,
            style = MaterialTheme.typography.bodySmall
        )
    }
}