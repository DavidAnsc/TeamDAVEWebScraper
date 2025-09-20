package models;

public class ParagraphModel {
    private String paragraph;
    private int order;

    public void setParagraph(String newParagraph) {
        if (!newParagraph.isBlank()) {
            this.paragraph = newParagraph;
        }
    }

    public void setOrder(int newOrder) {
        if (newOrder > 0) {
            this.order = newOrder;
        }
    }



    public String toString() {
        return this.paragraph;
    }





    public ParagraphModel(int order) {
        this.paragraph = """
                """;
        this.order = order;
    }

    public ParagraphModel(int order, String paragraph) {
        this.paragraph = paragraph;
        this.order = order;
    }
}
