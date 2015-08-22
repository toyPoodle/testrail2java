package de.vik.testrail2java.net;

import java.util.ArrayList;
import java.util.List;

import de.vik.testrail2java.types.primitive.AsString;

public class Filters <T> implements AsString {
    private final List<Filter<T>> filters;

    protected Filters() {
        filters = new ArrayList<>();
    }

    public static <T> Filters<T> none() {
        return new Filters<>();
    }

    public static <T> Filters<T> filter(Filter<T> filter) {
        final Filters<T> result = new Filters<>();
        result.filters.add(filter);
        return result;
    }

    public Filters<T> and(Filter<T> filter) {
        Filters<T> result = new Filters<>();
        result.filters.addAll(this.filters);
        result.filters.add(filter);
        return result;
    }

    public String asString() {
        String result = "";
        for (Filter filter: filters) {
            result += "&" + filter.asString();
        }
        return result;
    }

    @Override
    @SuppressWarnings("ControlFlowStatementWithoutBraces")
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Filters<?> filters1 = (Filters<?>) o;
        return filters.equals(filters1.filters);
    }

    @Override
    public int hashCode() {
        return filters.hashCode();
    }

    @Override
    public String toString() {
        return "Filters{" +
                "filters=" + filters +
                '}';
    }

    public boolean any() {
        return !filters.isEmpty();
    }
}
