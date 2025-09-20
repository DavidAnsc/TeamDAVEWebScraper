import abstractClasses.ListModel;
import models.ImageListModel;
import models.ParagraphListModel;
import models.PostListModel;

import java.util.ArrayList;


public class Main {
    public static void main(String[] args) {
        ParagraphListModel paragraphListModel = new ParagraphListModel();
        PostListModel postListModel = new PostListModel();
        ImageListModel imageListModel = new ImageListModel();

        ArrayList<ListModel> listModels = new ArrayList<>();
        listModels.add(paragraphListModel); listModels.add(postListModel); listModels.add(imageListModel);

        // fetch data:::::::
        fetchData.fetch(paragraphListModel, postListModel, imageListModel);
        //           :::::::


        // write data:::::::
        writeData.write(listModels);
        //           :::::::
    }
}
