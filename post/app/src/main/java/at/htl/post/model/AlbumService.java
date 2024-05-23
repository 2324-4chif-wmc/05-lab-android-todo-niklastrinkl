package at.htl.post.model;

import android.app.VoiceInteractor;
import android.util.Log;

import java.util.concurrent.CompletableFuture;

import javax.inject.Inject;
import javax.inject.Singleton;

import at.htl.post.util.resteasy.RestApiClientBuilder;
import io.reactivex.rxjava3.internal.operators.completable.CompletableError;

@Singleton
public class AlbumService {
    static final String TAG = PostService.class.getSimpleName();
    public static String JSON_PLACEHOLDER_BASE_URL = "https://jsonplaceholder.typicode.com";
    public final AlbumClient albumClient;
    public final ModelStore store;

    @Inject
    AlbumService(RestApiClientBuilder builder, ModelStore store) {
        albumClient = builder.build(AlbumClient.class, JSON_PLACEHOLDER_BASE_URL);
        this.store = store;
    }

    public void getAll() {
        CompletableFuture
                .supplyAsync(albumClient::all)
                .thenAccept(store::setAlbums)
                .exceptionally((e) -> {
                    Log.e(TAG, "Error loading albums", e);
                    return null;
                });
    }

    public void createAlbum(Album album) {
        CompletableFuture
                .supplyAsync(() -> albumClient.create(album))
                .thenAccept(createdAlbum -> {
                    store.addAlbum(createdAlbum);
                })
                .exceptionally((e) -> {
                    Log.e(TAG, "Error creating album", e);
                    return null;
                });

    }
}
