package org.skypro.skyshop.article;

public class Article implements Searchable {
    private final String title;
    private final String content;

    public Article(String title, String content){
        this.title=title;
        this.content=content;
    }


    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    //@Override
    public String getSearchTerm() {
        return title + " " + content;
    }

    @Override
    public String getContentType() {
        return "ARTICLE";
    }

    @Override
    public String getName() {
        return title;
    }


    @Override
    public String toString() {
        return title + "\n" + content;

    }
}
