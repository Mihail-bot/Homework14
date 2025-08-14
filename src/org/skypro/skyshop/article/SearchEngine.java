package org.skypro.skyshop.article;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class SearchEngine {
    private List<String> searchResults = new ArrayList<>();

    private List<Searchable> items = new ArrayList<>();

    public SearchEngine(int size) {
        this.items = new ArrayList<>();

    }

    // Поиск всех совпадений
    public List<String> findAll(String keyword) {
        // Пример простой реализации, возвращает все строки, содержащие указанный ключ
        List<String> results = new ArrayList<>();
        for (String result : searchResults) {
            if (result.contains(keyword)) {
                results.add(result);
            }
        }
        return results;
    }


    // Добавление нового объекта для поиска
    public void add(Searchable item) {
        items.add(item);
    }

    public Searchable findMostRelevant(List<Searchable> items, String searchQuery) throws BestResultNotFound {
        Searchable bestMatch = null;
        int maxCount = -1;

        for (Searchable item : items) {
            int count = countOccurrences(item.getSearchTerm(), searchQuery);

            if (count > maxCount) {
                maxCount = count;
                bestMatch = item;
            }
        }

        if (bestMatch == null) {
            throw new BestResultNotFound("Не найдено подходящих элементов для '" + searchQuery + "'");
        }

        return bestMatch;
    }

    // Вспомогательная функция подсчета количества вхождений подстроки
    private int countOccurrences(String text, String subStr) {
        int count = 0;
        int startIndex = 0;

        while ((startIndex = text.indexOf(subStr, startIndex)) >= 0) {
            count++;
            startIndex += subStr.length();
        }

        return count;
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
   // class SearchEngine {
   //     private List<Searchable> items = new ArrayList<>();

        /** * Возвращает отсортированный по именам результат поиска. */
        public Map<String, Searchable> searchByNameSorted(String name) {
            TreeMap<String, Searchable> results = new TreeMap<>();
            for (Searchable item : items) {
                if (item.getName().contains(name)) {
                    results.put(item.getName(), item); // помещаем объекты в карту, ключи автоматически сортируются
                }
            }
            return results;
        }
    }

