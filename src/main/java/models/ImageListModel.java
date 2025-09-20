package models;
import abstractClasses.ListModel;

import java.util.ArrayList;
import java.util.Arrays;

public class ImageListModel implements ListModel {
    public ArrayList<ImageModel> imageList = new ArrayList<>();

    @Override
    public String toString() {
        return Arrays.toString(this.imageList.toArray());
    }
}
