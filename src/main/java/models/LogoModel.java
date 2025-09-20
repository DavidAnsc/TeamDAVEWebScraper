package models;

public class LogoModel {
    private String imageUrl;
    private int width;
    private int length;

    public void setDimension(Integer newWidth) {
        if (newWidth >= 1) {
            this.width = newWidth;
        } else {
            System.out.println("You can't assign the width to be less than 1!");
        }
    }

    public void setDimension(Integer newWidth, Integer newLength) {
        if (newWidth >= 1 && newLength >= 1) {
            this.width = newWidth;
            this.length = newLength;
        } else {
            System.out.println("You can't assign the width or length to be less than 1!");
        }
    }



    LogoModel(String imageUrl, int width, int length) {
        this.imageUrl = imageUrl;
        this.width = width;
        this.length = length;
    }
}
