import java.util.ArrayList;

import abstractClasses.ListModel;
import models.listModels.ImageListModel;
import models.listModels.ParagraphListModel;
import models.listModels.PostListModel;

import java.util.Scanner;


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
        
        Scanner sc = new Scanner(System.in);

        System.out.print("Pls enter a string: ");
        String value = sc.nextLine();
        System.out.println(value);
    }
}
