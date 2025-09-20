package models;

public class PostModel {
    private String post;

    public void setPost(String newPost) {
        if (!newPost.isBlank()) {
            this.post = newPost;
        }
    }


    public String toString() {
        return this.post;
    }




    public PostModel(String post) {
        this.post = post;
    }
}
