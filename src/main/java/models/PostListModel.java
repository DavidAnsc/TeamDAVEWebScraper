package models;
import abstractClasses.ListModel;
import org.jsoup.nodes.Element;
import org.jsoup.select.*;
import java.util.ArrayList;
import java.util.Arrays;

public class PostListModel implements ListModel {
    public ArrayList<PostModel> postList = new ArrayList<>();

    @Override
    public String toString() {
        return Arrays.toString(this.postList.toArray());
    }

    public void getPosts(Elements postItems, PostListModel postListModel) {
        for (Element post : postItems) {
            for (Element item : post.select("p")) {
                PostModel postTemp = new PostModel(item.text());

                postListModel.postList.add(postTemp);
            }
        }
    }
}
