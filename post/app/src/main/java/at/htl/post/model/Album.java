package at.htl.post.model;

public class Album {
    public Long userId;
    public Long id;
    public String title;

    public Album() {
    }

    public Album(Long userId, Long id, String title) {
        this.userId = userId;
        this.id = id;
        this.title = title;
    }
}
