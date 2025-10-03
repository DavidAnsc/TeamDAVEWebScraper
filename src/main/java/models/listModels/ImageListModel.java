package models.listModels;
import abstractClasses.ListModel;
import models.ImageModel;

import org.jsoup.nodes.Element;
import org.jsoup.select.*;
import java.util.ArrayList;
import java.util.Arrays;

public class ImageListModel implements ListModel {
    public ArrayList<ImageModel> imageList = new ArrayList<>();
    public ArrayList<String> imgDownloadPaths = new ArrayList<>();

    @Override
    public String toString() {
        return Arrays.toString(this.imageList.toArray());
    }

    @Override
    public String toText() {
        return "Image";
    }

    public void getImages(Elements imageItems, ImageListModel imageListModel) {
        for (Element image : imageItems) {
            int linkStarts = image.toString().indexOf('/');
            int linkEnds = image.toString().indexOf('"', linkStarts);

            String link = image.toString().substring(linkStarts, linkEnds);
            link = "https://www.teamdave.ca" + link;

            int desStarts = link.lastIndexOf('/') + 1;
            int desEnds = link.lastIndexOf(".png");

            String des = link.substring(desStarts, desEnds);
            des = des.replace("-", " ");


            int widthStarts = image.toString().indexOf("width=") + 7;
            int widthEnds = image.toString().indexOf('"', widthStarts);

            int widthValue = Integer.parseInt(image.toString().substring(widthStarts, widthEnds));


            int heightStarts = image.toString().indexOf("height=") + 8;
            int heightEnds = image.toString().indexOf('"', heightStarts);

            int heightValue = Integer.parseInt(image.toString().substring(heightStarts, heightEnds));



            ImageModel imageTemp = new ImageModel(link, des);
            imageTemp.setWidthAndHeight(widthValue, heightValue);


            imageListModel.imageList.add(imageTemp);
        }
    }
}
