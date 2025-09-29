package org.skypro.skyshop.article;
import java.util.Objects;

public class Article implements Searchable {
    private final String title;
    private final String content;

    public Article(String title, String content) {
        this.title = title;
        this.content = content;
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
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Article article = (Article) obj;
        return Objects.equals(title, article.title); // Сравниваем только по названию статьи
    }

    @Override
    public int hashCode() {
        return Objects.hash(title); // Генерация хэш-кода основана только на названии статьи
    }
}