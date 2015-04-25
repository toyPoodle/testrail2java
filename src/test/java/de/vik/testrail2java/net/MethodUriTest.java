package de.vik.testrail2java.net;

import org.junit.Test;

import de.vik.testrail2java.types.primitive.Id;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.*;

public class MethodUriTest {

    @Test
    public void parameterIsReplacedAtTheEnd() throws Exception {
        assertThat(target("method_name/:parameter", 5).insertParameters(), equalTo("method_name/5"));
    }

    @Test
    public void parameterIsReplacedInTheMiddle() throws Exception {
        assertThat(target("method_name/:parameter/other", 5).insertParameters(), equalTo("method_name/5/other"));
    }

    @Test
    public void twoParametersAreReplaced() throws Exception {
        assertThat(target("method_name/:parameter/:second_parameter", 5, 6).insertParameters(), equalTo("method_name/5/6"));
    }

    @Test
    public void twoParametersWithSameNameAreReplaced() throws Exception {
        assertThat(target("method_name/:parameter/:parameter", 5, 6).insertParameters(), equalTo("method_name/5/6"));
    }

    @Test
    public void noParameters() throws Exception {
        assertThat(target("method_name/other").insertParameters(), equalTo("method_name/other"));
    }

    @Test
    public void noParametersInUri() throws Exception {
        assertThat(target("method_name/other").insertParameters(), equalTo("method_name/other"));
    }

    @Test
    public void idParameterIsReplacedWithItsValue() throws Exception {
        assertThat(target("method_name/:param", id(8)).insertParameters(), equalTo("method_name/8"));
    }

    @Test
    public void FilterParameterIsReplacedWithItsValue() throws Exception {
        assertThat(target(Filters.filterBy(new Filter("anotherParam", "10")), "method_name/:param", 9).insertParameters(), equalTo("method_name/9&anotherParam=10"));
    }

    private Id id(int value) {
        return new Id(value) {};
    }

    private MethodUri target(Filters filters, String uri, Object... parameters) {
        return new MethodUri(uri, parameters, filters);
    }

    private MethodUri target(String uri, Object... parameters) {
        return new MethodUri(uri, parameters);
    }
}