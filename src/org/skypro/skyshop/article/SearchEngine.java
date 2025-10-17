package org.skypro.skyshop.article;

import java.util.*;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class SearchEngine {
    private Set<Searchable> data = new HashSet<>();

    public void addItem(Searchable item) {
        data.add(item); // Автоматически удаляются дубликаты
    }

    public TreeSet<String> search(List<String> documents, String keyword) {
        return documents.stream()                // Преобразование списка в поток
                .filter(doc -> doc.contains(keyword))   // Фильтрация документов по ключу
                .collect(Collectors.toCollection(() -> new TreeSet<>())); // Сбор результата в TreeSet с компаратором
    }


}

