package at.htl.post;

import android.os.Bundle;
import androidx.activity.ComponentActivity;

import android.os.Bundle;
import android.util.Log;

import androidx.activity.ComponentActivity;
import javax.inject.Inject;

import at.htl.post.model.PostService;
import at.htl.post.util.Config;
import at.htl.todo.ui.layout.MainView;
import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class MainActivity extends ComponentActivity {

    static final String TAG = MainActivity.class.getSimpleName();

    @Inject
    MainView mainView;

    @Inject
    PostService postService;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Config.load(this);
        var base_url = Config.getProperty("json.placeholder.baseurl");
        Log.i(TAG, "onCreate: " + base_url);
        mainView.buildContent(this);
    }
}