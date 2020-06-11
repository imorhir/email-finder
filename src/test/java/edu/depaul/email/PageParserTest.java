package edu.depaul.email;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Set;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class PageParserTest {


    @ParameterizedTest
    @MethodSource("provideExpectedAndInput")
    @DisplayName("Test pageParser for existing links")
    public void testPageParserFindLinks(int expected, String input) {
        Document doc = Jsoup.parse(input);
        PageParser find = new PageParser();
        assertEquals(expected, find.findLinks(doc).size());
    }

    private static Stream<Arguments> provideExpectedAndInput() {
        return Stream.of(
                Arguments.of(1,    "<html><a href='https://www.google.com'>my link</a></body></html>"),
                Arguments.of(2,    "<html><a href='/some/other/file.html'>my link</a><a href='/some/other/file2.html'>my link</a></body></html>"),
                Arguments.of(0,    "<html> <p>Hello</p></html>"),
                Arguments.of(1,    "<html><a href='/some/other/file.html'>my link</a></body></html>")

        );
    }
}