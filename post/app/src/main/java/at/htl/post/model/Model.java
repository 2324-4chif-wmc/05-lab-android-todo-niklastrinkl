package at.htl.post.model;

public class Model {
    public Post[] posts = new Post[0];
    public Album[] albums = new Album[0];

    public static class UIState {
        public int selectedTab = 0;
    }

    public UIState uiState = new UIState();

    public Album selectedAlbum = null;
}
