package at.htl.post.ui.layout

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Icon
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import at.htl.post.model.AlbumService
import at.htl.post.model.Model
import at.htl.post.model.ModelStore
import at.htl.post.model.PostService
import at.htl.todo.ui.layout.HomeScreen

@Composable
fun TabScreen(model: Model, store: ModelStore?, postService: PostService?, albumService: AlbumService?) {
    var uiState = model.uiState
    val tabIndex = model.uiState.selectedTab
    val tabs = listOf("Home", "Posts", "Albums")
    Column(modifier = Modifier.fillMaxWidth()) {
        TabRow(selectedTabIndex = uiState.selectedTab) {
            tabs.forEachIndexed { index, title ->
                Tab(text = { Text(title) },
                    selected = tabIndex == index,
                    onClick = { store?.selectedTab(index)},
                    icon = {
                        when (index) {
                            0 -> Icon(imageVector = Icons.Default.Home, contentDescription = null)
                            1 -> BadgedBox(badge = { Badge { Text("${model.posts.size}") }}) {
                                Icon(Icons.Filled.Favorite, contentDescription = "Posts")
                            }
                            2 -> BadgedBox(badge = { Badge { Text("${model.albums.size}") }}) {
                                Icon(Icons.Filled.Favorite, contentDescription = "Albums")
                            }
                        }
                    }
                )
            }
        }
        when (tabIndex) {
            0 -> HomeScreen(model, postService, albumService, store)
            1 -> Posts(model)
            2 -> Albums(model, store)
        }
    }
}