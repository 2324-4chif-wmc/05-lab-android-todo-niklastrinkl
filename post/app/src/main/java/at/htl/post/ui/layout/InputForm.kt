package at.htl.post.ui.layout

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun InputForm() {
    var test = "";
    Column (modifier = Modifier) {
        TextField(modifier = Modifier.fillMaxWidth(), value = "Test", onValueChange = { test = it } )
    }
}