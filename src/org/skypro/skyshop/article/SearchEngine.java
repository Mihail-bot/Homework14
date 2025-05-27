package org.skypro.skyshop.article;

import java.util.ArrayList;
import java.util.List;

public class SearchEngine {
    private List<Searchable> items;

    public SearchEngine(int size) {
        this.items = new ArrayList<>();

    }

    // Добавление нового объекта для поиска
    public void add(Searchable item) {
        items.add(item);
    }

    // Поиск по строке и возврат максимум 5 результатов
    public List<Searchable> search(String query) {
        List<Searchable> results = new ArrayList<>();
        for (Searchable item : items) {
            if (item.getSearchTerm().toLowerCase().contains(query.toLowerCase())) {
                results.add(item);
                if (results.size() >= 5) {
                    break;
                }
            }
        }
        return results;
    }
}
