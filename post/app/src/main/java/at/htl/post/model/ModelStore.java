package at.htl.post.model;

import android.view.Display;

import java.util.Arrays;
import java.util.Comparator;

import javax.inject.Inject;
import javax.inject.Singleton;

import at.htl.post.util.store.Store;

@Singleton
public class ModelStore extends Store<Model> {
    @Inject
    ModelStore() {
        super(Model.class, new Model());
    }

    public void setPosts(Post[] posts) {
        apply(model -> model.posts = posts);
    }

    public void setAlbums(Album[] albums) {
        apply(model -> model.albums = albums);
    }

    public void selectedTab(int tabIndex) {
        apply(model -> model.uiState.selectedTab = tabIndex);
    }

    public void addAlbum(String title) {
        apply(model -> {
            var newAlbum = new Album(1L, Arrays.stream(model.albums).max(Comparator.comparingLong(o -> o.id)).get().id +1, title);
            var newAlbums = Arrays.copyOf(model.albums, model.albums.length +1);
            newAlbums[newAlbums.length -1] = newAlbum;

            model.albums = newAlbums;
        });
    }

    public void setSelectedAlbum(Album album) {
        apply(model -> model.selectedAlbum = album);
    }
}
