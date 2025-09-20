import models.*;
import org.jsoup.*;
import org.jsoup.nodes.*;
import org.jsoup.select.*;

public class fetchData {
    public static void fetch(ParagraphListModel paragraphListModel,
                             PostListModel postListModel,
                             ImageListModel imageListModel) {

        try {
            Elements paraItems;
            Elements postItems;
            Elements imageItems;

            Document content = Jsoup.connect("https://www.teamdave.ca/").get();
            paraItems = content.select("div[class*='entry-content']");
            postItems = content.select("div[class*='entry-su']");
            imageItems = content.select("img");


            paragraphListModel.getPara(paraItems, paragraphListModel);

            postListModel.getPosts(postItems, postListModel);

            imageListModel.getImages(imageItems, imageListModel);

        }
        catch(Exception e) {
            System.out.println("Error \nERROR MESSAGE: " + e);
        }
    }
}
