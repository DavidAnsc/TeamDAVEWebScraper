package models;

public class ImageModel {
    private String url;
    private String description;
    private int[] widthAndHeight = new int[2];

    public String getUrl() {
        return this.url;
    }

    public String toString() {
        return this.description + ", url: " + this.url + ", width and height value: " + this.widthAndHeight[0] + " and " + this.widthAndHeight[1];
    }




    public void setUrl(String newUrl) {
        this.url = newUrl;
    }

    public void setDescription(String newDescription) {
        this.description = newDescription;
    }

    public void setWidthAndHeight(int newWidth, int newHeight) {
        this.widthAndHeight[0] = newWidth;
        this.widthAndHeight[1] = newHeight;
    }



    public ImageModel(String url, String description) {
        this.url = url;
        this.description = description;
    }
}
