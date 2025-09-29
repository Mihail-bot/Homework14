package org.skypro.skyshop.article;

import java.util.*;


public class SearchEngine {
    private Set<Searchable> data = new HashSet<>();

    public void addItem(Searchable item) {
        data.add(item); // Автоматически удаляются дубликаты
    }

    public SortedSet<Searchable> search(String term) {
        Comparator<Searchable> lengthComparator = new ArticleLengthComparator();
        SortedSet<Searchable> results = new TreeSet<>(lengthComparator);

        for (Searchable s : data) {
            if (s.getSearchTerm().toLowerCase().contains(term.toLowerCase())) {
                results.add(s);
            }
        }
        return results;
    }


}

