package at.htl.post.ui.layout

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import at.htl.post.model.Album
import at.htl.post.model.AlbumService
import at.htl.post.model.ModelStore

@Composable
fun InputForm(store: ModelStore, albumService: AlbumService) {
    var text by remember { mutableStateOf("") }
    Column (modifier = Modifier) {
        TextField(
            value = text,
            onValueChange = { text = it },
            label = { Text("New Album") })
        Button(
            modifier = Modifier.padding(16.dp),
            onClick = {
                var album =  Album(1L, 1L, text)
                albumService.createAlbum(album)
            }) {
            Text("Submit new Album")
        }
    }
}