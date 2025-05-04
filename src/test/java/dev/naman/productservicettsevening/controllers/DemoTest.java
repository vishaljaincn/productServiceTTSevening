package dev.naman.productservicettsevening.controllers;

import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;

public class DemoTest {
    @Test
    void testStringAssertions() {
//        assertThat("hello").isEqualTo("hello");
//        assertThat("hello").isNotEqualTo("hi");
        SoftAssertions softAssertions = new SoftAssertions();
        softAssertions.assertThat("hello").isEqualTo("hllo");
        softAssertions.assertThat("hello").isNotEqualTo("hi");
        softAssertions.assertAll();
    }
}
