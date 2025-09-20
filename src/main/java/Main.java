import abstractClasses.ListModel;
import models.ImageListModel;
import models.ParagraphListModel;
import models.PostListModel;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ParagraphListModel paragraphListModel = new ParagraphListModel();
        PostListModel postListModel = new PostListModel();
        ImageListModel imageListModel = new ImageListModel();

        ArrayList<ListModel> listModels = new ArrayList<>();

        fetchData.fetch(paragraphListModel, postListModel, imageListModel);

        listModels.add(paragraphListModel);
        listModels.add(postListModel);
        listModels.add(imageListModel);


        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();

        String jsonString = gson.toJson(listModels);



        String filePath = "outputFolder/scrapedData.json";



        try (FileWriter wrt = new FileWriter(filePath)) {
            wrt.write(jsonString);
        }


        catch (IOException e) {
            System.out.println("\nFile name/directory error!\n");
        }
        catch (Exception e) {
            System.out.println("\nSome unknown error occurred\n");
        }


    }
}
