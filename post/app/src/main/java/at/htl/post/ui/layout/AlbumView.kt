package at.htl.post.ui.layout

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import at.htl.post.model.Album
import at.htl.post.model.Model
import at.htl.post.model.ModelStore
import at.htl.post.model.Post

@Composable
fun Albums(model: Model, store: ModelStore?, modifier: Modifier = Modifier) {
    val albums = model.albums

    if (model.selectedAlbum != null) {
        AlbumDetailView(model = model) {
            store?.setSelectedAlbum(null)
        }
    } else {
        LazyColumn(
            modifier = modifier.padding(16.dp)
        ) {
            items(albums.size) { index ->
                AlbumRow(album = albums[index], onShowDetails = { store?.setSelectedAlbum(it) })
                HorizontalDivider()
            }
        }
    }
}

@Composable
fun AlbumRow(album: Album, onShowDetails: (Album) -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = album.id.toString(),
            style = MaterialTheme.typography.bodySmall
        )
        Spacer(modifier = Modifier.width(8.dp))
        Button(onClick = { onShowDetails(album) }) {
            Text(text = "Show Details")
        }
    }
}