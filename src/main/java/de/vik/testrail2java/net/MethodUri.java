package de.vik.testrail2java.net;

import de.vik.testrail2java.TestRailException;
import de.vik.testrail2java.types.primitive.AsString;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MethodUri {
    private static final Object[] NO_PARAMETERS = {};

    private final String uri;
    private final Filters<?> filters;
    private final List<Object> parameters;

    public MethodUri(String uri, Object[] parameters) {
        this(uri, parameters, Filters.none());
    }

    public MethodUri(String uri, Filters<?> filters) {
        this(uri, NO_PARAMETERS, filters);
    }

    public MethodUri(String uri) {
        this(uri, NO_PARAMETERS, Filters.none());
    }

    public MethodUri(String uri, Object[] parameters, Filters<?> filters) {
        this.uri = uri;
        this.filters = filters;
        this.parameters = new ArrayList<>(Arrays.asList(parameters));
    }

    public String insertParameters() {
        String result = uri;
        for(Object parameter : parameters) {
            Pattern p = Pattern.compile("([:][a-z_]+)");
            Matcher m = p.matcher(result);
            if (!m.find()) {
                throw new TestRailException("supplied more parameters as there are placeholders in uri");
            }
            for (int i = 0; i < m.groupCount(); i++) {
                result = m.replaceFirst(parameterValue(parameter));
            }
        }

        if (filters.any()) {
            result += filters.asString();
        }
        return result;
    }

    private String parameterValue(Object parameter) {
        final String parameterAsString;
        if (parameter instanceof AsString) {
            parameterAsString = ((AsString) parameter).asString();
            return parameterAsString;
        }
        parameterAsString = String.valueOf(parameter);
        try {
            return URLEncoder.encode(parameterAsString, StandardCharsets.UTF_8.name());
        } catch (UnsupportedEncodingException e) {
            // by definition UTF-8 should be supported by every Java VM
            // http://docs.oracle.com/javase/8/docs/api/java/nio/charset/Charset.html
            // so just repackage the exception to make compiler happy
            throw new TestRailException(e);
        }
    }

    public MethodUri withParameters(Object... parameters) {
        return new MethodUri(this.uri, parameters, this.filters);
    }

    @Override
    @SuppressWarnings({"ControlFlowStatementWithoutBraces", "SimplifiableIfStatement"})
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MethodUri methodUri = (MethodUri) o;

        if (!uri.equals(methodUri.uri)) return false;
        if (!filters.equals(methodUri.filters)) return false;
        return parameters.equals(methodUri.parameters);

    }

    @Override
    public int hashCode() {
        int result = uri.hashCode();
        result = 31 * result + filters.hashCode();
        result = 31 * result + parameters.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return insertParameters();
    }
}
