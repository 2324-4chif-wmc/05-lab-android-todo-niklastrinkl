package at.htl.todo.ui.layout

import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rxjava3.subscribeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import at.htl.post.model.AlbumService
import at.htl.post.model.Model
import at.htl.post.model.ModelStore
import at.htl.post.model.PostService
import at.htl.post.ui.layout.TabScreen
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MainView @Inject constructor() {

    @Inject
    lateinit var store: ModelStore

    @Inject
    lateinit var postService: PostService

    @Inject
    lateinit var albumService: AlbumService

    fun buildContent(activity: ComponentActivity) {
        activity.setContent {
            val viewModel = store
                .pipe
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeAsState(initial = Model())
                .value
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = MaterialTheme.colorScheme.background
            ) {
                TabScreen(
                    viewModel,
                    store,
                    postService,
                    albumService
                )
            }
        }
    }
}

@Composable
fun HomeScreen(model: Model, postService: PostService?, albumService: AlbumService?, store: ModelStore?) {
    val posts = model.posts
    val albums = model.albums
    Column {
        Row {
            Text(text = "Welcome to HomeScreen", fontSize = 20.sp)
        }
        Row(Modifier.align(Alignment.CenterHorizontally)) {
            Text("${posts.size} Posts have been loaded")
        }
        Row(Modifier.align(Alignment.CenterHorizontally)) {
            Button(modifier = Modifier.padding(16.dp),
                onClick = { postService?.getAll() }) {
                Text("load all Posts now")
            }
        }
        Row(Modifier.align(Alignment.CenterHorizontally)) {
            Text("${albums.size} Albums have been loaded")
        }
        Row(Modifier.align(Alignment.CenterHorizontally)) {
            Button(modifier = Modifier.padding(16.dp),
                onClick = { albumService?.getAll() }) {
                Text("load all Albums now")
            }
        }
    }
}