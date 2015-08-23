package de.vik.testrail2java.utilities;

import java.util.ArrayList;
import java.util.List;

public class ListUtils {
    public static <T> List<T> copy(List<T> list) {
        if (list == null) {
            return new ArrayList<>();
        }
        return new ArrayList<>(list);
    }
}
