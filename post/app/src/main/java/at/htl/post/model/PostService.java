package at.htl.post.model;

import android.app.VoiceInteractor;
import android.util.Log;

import java.util.concurrent.CompletableFuture;

import javax.inject.Inject;
import javax.inject.Singleton;

import at.htl.post.util.resteasy.RestApiClientBuilder;
import io.reactivex.rxjava3.internal.operators.completable.CompletableError;

@Singleton
public class PostService {
    static final String TAG = PostService.class.getSimpleName();
    public static String JSON_PLACEHOLDER_BASE_URL = "https://jsonplaceholder.typicode.com";
    public final PostClient postClient;
    public final ModelStore store;

    @Inject
    PostService(RestApiClientBuilder builder, ModelStore store) {
        postClient = builder.build(PostClient.class, JSON_PLACEHOLDER_BASE_URL);
        this.store = store;
    }

    public void getAll() {
        CompletableFuture
                .supplyAsync(postClient::all)
                .thenAccept(store::setPosts)
                .exceptionally((e) -> {
                    Log.e(TAG, "Error loading posts", e);
                    return null;
                });
    }
}
