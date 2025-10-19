package org.skypro.skyshop.article;

import java.util.Comparator;

public class ArticleLengthComparator implements Comparator<Searchable> {
    @Override
    public int compare(Searchable a1, Searchable a2) {
        // Сравниваем по длине имени статьи
        int lenComparison = Integer.compare(a2.getName().length(), a1.getName().length());

        // Если длины различны, возвращаем результат сравнения длин
        if (lenComparison != 0) {
            return lenComparison;
        }

        // Если длины одинаковы, сравниваем сами имена
        return a1.getName().compareTo(a2.getName());
    }
}