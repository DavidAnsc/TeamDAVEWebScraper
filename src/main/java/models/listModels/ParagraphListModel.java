package models.listModels;
import abstractClasses.ListModel;
import models.ParagraphModel;

import org.jsoup.nodes.*;
import org.jsoup.select.*;
import java.util.ArrayList;
import java.util.Arrays;


public class ParagraphListModel implements ListModel {
    public ArrayList<ParagraphModel> paraList = new ArrayList<>();

    @Override
    public String toString() {
        return Arrays.toString(this.paraList.toArray());
    }

    @Override
    public String toText() {
        return "Paragraph";
    }

    public void getPara(Elements paraItems, ParagraphListModel paragraphListModel) {
        for (Element paragraph : paraItems) {
            int index = -1;

            for (Element item : paragraph.select("p")) {
                index ++;
                ParagraphModel paragraphTemp = new ParagraphModel(index);

                paragraphTemp.setParagraph(item.text());
                paragraphListModel.paraList.add(paragraphTemp);
            }

        }
    }

}
