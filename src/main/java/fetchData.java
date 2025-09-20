import models.*;
import org.jsoup.*;
import org.jsoup.nodes.*;
import org.jsoup.select.*;

import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;

public class fetchData {
    public static void fetch(ParagraphListModel paragraphListModel,
                             PostListModel postListModel, ImageListModel imageListModel) {


        try {
            Elements paraItems;
            Elements postItems;
            Elements imageItems;

            Document content = Jsoup.connect("https://www.teamdave.ca/").get();

            paraItems = content.select("div[class*='entry-content']");
            postItems = content.select("div[class*='entry-su']");
            imageItems = content.select("img");


            for (Element paragraph : paraItems) {
                int index = -1;

                for (Element item : paragraph.select("p")) {
                    index ++;
                    ParagraphModel paragraphTemp = new ParagraphModel(index);

                    paragraphTemp.setParagraph(item.text());
                    paragraphListModel.paraList.add(paragraphTemp);
                }

            }


            for (Element post : postItems) {
                int index2 = -1;

                for (Element item : post.select("p")) {
                    index2 ++;
                    PostModel postTemp = new PostModel(item.text());

                    postListModel.postList.add(postTemp);
                }
            }
            int index3 = -1;
            for (Element image : imageItems) {
                index3 ++;

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
        catch(Exception e) {
            System.out.println("Error \nERROR MESSAGE: " + e);
        }
    }
}
