package edu.depaul.email;

import org.jsoup.nodes.Document;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class PageFetcherTest {



    @Test
    void getReturnsDocument(){
        PageFetcher page_f = new PageFetcher();
        Document doc =  page_f.get("http://www.google.com");
        assertTrue(doc instanceof Document);

    }

    @Test
    @DisplayName("getString should throw an exception when given a bad URL")
    void testGetStringExceptions() {
        assertThrows(EmailFinderException.class, () -> new PageFetcher().getString("http://www.googlecom"));
    }
    @Test

    void testGetExceptions() {
        assertThrows(EmailFinderException.class, () -> new PageFetcher().get("http://www.googlecom"));
    }

    @Test
    void getStringReturnsDocumentType(){
        PageFetcher page_f = new PageFetcher();
        String doc =  page_f.getString("http://cdm.depaul.edu");
        assertTrue(doc instanceof String);
    }



}