import models.listModels.ImageListModel; 
import models.listModels.ParagraphListModel;
import models.listModels.PostListModel;
import models.ParagraphModel;
import models.ImageModel;
import models.PostModel;


public class Main {
    public static void main(String[] args) {
        DataWriter<ParagraphModel> dataWriterPara = new DataWriter<>();
        DataWriter<ImageModel> dataWriterImage = new DataWriter<>();
        DataWriter<PostModel> dataWriterPost = new DataWriter<>();

        ParagraphListModel paragraphListModel = new ParagraphListModel();
        PostListModel postListModel = new PostListModel();
        ImageListModel imageListModel = new ImageListModel();

        // listModels.add(paragraphListModel); listModels.add(postListModel); listModels.add(imageListModel);

        // fetch data:::::::
        fetchData.fetch(paragraphListModel, postListModel, imageListModel);
        //           :::::::

        
        // write data:::::::
        dataWriterPara.write(paragraphListModel.paraList, paragraphListModel);
        dataWriterImage.write(imageListModel.imageList, imageListModel);
        dataWriterPost.write(postListModel.postList, postListModel);
        //           :::::::
        
    }
}
