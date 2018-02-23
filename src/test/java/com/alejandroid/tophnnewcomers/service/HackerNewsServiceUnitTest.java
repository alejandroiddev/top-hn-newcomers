package com.alejandroid.tophnnewcomers.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
public class HackerNewsServiceUnitTest {

    @Test
    public void testGetNewStories() {
        HackerNewsService hackerNewsService = new HackerNewsService();
        System.out.println(hackerNewsService.getNewStories());
    }

    @Test
    public void testFindStory() {
        HackerNewsService hackerNewsService = new HackerNewsService();
        System.out.println(hackerNewsService.findStory(16447230L));
    }
}
