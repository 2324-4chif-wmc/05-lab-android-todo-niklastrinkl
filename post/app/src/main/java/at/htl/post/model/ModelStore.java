package at.htl.post.model;

import android.view.Display;

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
}
