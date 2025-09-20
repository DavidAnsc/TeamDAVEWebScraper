package models;
import abstractClasses.ListModel;

import java.util.ArrayList;
import java.util.Arrays;

public class PostListModel implements ListModel {
    public ArrayList<PostModel> postList = new ArrayList<>();

    @Override
    public String toString() {
        return Arrays.toString(this.postList.toArray());
    }
}
