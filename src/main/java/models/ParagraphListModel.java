package models;
import abstractClasses.ListModel;

import java.util.ArrayList;
import java.util.Arrays;


public class ParagraphListModel implements ListModel {
    public ArrayList<ParagraphModel> paraList = new ArrayList<>();

    @Override
    public String toString() {
        return Arrays.toString(this.paraList.toArray());
    }

}
