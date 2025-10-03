import abstractClasses.ListModel;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class DataWriter<T> {
    public void write(ArrayList<T> array, ListModel listmodel) {

        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();

        String jsonString = gson.toJson(array);

        String filePath = "TeamDAVEWebScraper/scraped" + listmodel.toText() + "Data.json";

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

    public DataWriter() {
    }

    
}
