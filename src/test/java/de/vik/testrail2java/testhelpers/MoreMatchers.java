package de.vik.testrail2java.testhelpers;

import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;
import org.mockito.ArgumentMatcher;

import de.vik.testrail2java.net.MethodUri;
import de.vik.testrail2java.net.Filter;

import static org.mockito.Matchers.argThat;

public class MoreMatchers {
    public static MethodUri uri(final String uri) {
        return argThat(new ArgumentMatcher<MethodUri>() {
            @Override
            public boolean matches(Object argument) {
                return argument instanceof MethodUri
                        && uri.equals(((MethodUri)argument).insertParameters());
            }
        });
    }

    public static FilterMatcher asStringIs(String representation) {
        return new FilterMatcher(representation);
    }

    public static class FilterMatcher extends BaseMatcher<Filter<?>> {
        private final String representation;

        public FilterMatcher(String representation) {
            this.representation = representation;
        }

        public boolean matches(Object actual) {
            return actual != null && ((Filter<?>) actual).asString().equals(representation);
        }

        public void describeTo(Description description) {
            description.appendText("is represented by string (\"" + representation + "\")");
        }

        @Override
        public void describeMismatch(Object item, Description description) {
            super.describeMismatch(((Filter<?>) item).asString(), description);
        }
    }

}
