package edu.depaul.email;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
class PageCrawlerTest {


    @Test
    void testRecursiveCrawl() {
        StorageService store = mock(StorageService.class);
        PageCrawler page = new PageCrawler(store);
        assertDoesNotThrow(() -> page.crawl("recursiveTest1.html"));

}
    @Test
    void maxSize() {
        StorageService store = mock(StorageService.class);
        PageCrawler page = new PageCrawler(store, 3);
        page.crawl("recursiveTest1.html");
        assertEquals(page.getEmails().size(), 3);

}

    @Test
    void testAssertAllReport() {
        StorageService store = mock(StorageService.class);
        PageCrawler page = new PageCrawler(store);
        page.crawl("recursiveTest1.html");

        assertAll("some asserts",
                () -> {

                    assertEquals(page.getEmails().size(), 6);
                },
                () -> {

                    assertEquals(page.getBadLinks().size(), 1);
                },
                () -> {

                    assertEquals(page.getGoodLinks().size(), 2);
                }

      );
    }


}