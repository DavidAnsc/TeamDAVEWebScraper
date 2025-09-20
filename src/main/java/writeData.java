import abstractClasses.ListModel;
import models.ImageListModel;
import models.ParagraphListModel;
import models.PostListModel;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class writeData {
    public static void write(ArrayList<ListModel> listModels) {

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
