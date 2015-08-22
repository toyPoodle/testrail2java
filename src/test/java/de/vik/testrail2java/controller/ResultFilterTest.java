package de.vik.testrail2java.controller;

import org.junit.Test;

import static de.vik.testrail2java.testhelpers.MoreMatchers.asStringIs;
import static de.vik.testrail2java.types.primitive.Primitives.statusId;
import static de.vik.testrail2java.types.primitive.Primitives.timestamp;
import static de.vik.testrail2java.types.primitive.Primitives.userId;
import static org.junit.Assert.*;

public class ResultFilterTest {

    @Test
    public void filterKeys() throws Exception {
        assertThat(Results.ResultFilter.byCreatedAfter(timestamp(123L)), asStringIs("created_after=123"));
        assertThat(Results.ResultFilter.byCreatedBefore(timestamp(234L)), asStringIs("created_before=234"));
        assertThat(Results.ResultFilter.byCreatedBy(userId(1)), asStringIs("created_by=1"));
        assertThat(Results.ResultFilter.byLimit(2), asStringIs("limit=2"));
        assertThat(Results.ResultFilter.byOffset(3), asStringIs("offset=3"));
        assertThat(Results.ResultFilter.byStatusId(statusId(4)), asStringIs("status_id=4"));
        assertThat(Results.ResultFilter.byStatusId(statusId(5), statusId(6)), asStringIs("status_id=5%2C6"));
    }
}