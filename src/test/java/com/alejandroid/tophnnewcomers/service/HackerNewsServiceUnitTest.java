package com.alejandroid.tophnnewcomers.service;

import com.alejandroid.tophnnewcomers.domain.Story;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.assertj.core.api.Assertions.*;

@RunWith(SpringJUnit4ClassRunner.class)
public class HackerNewsServiceUnitTest {

    @Test
    public void testGetNewStories() {
        HackerNewsService hackerNewsService = new HackerNewsService();
        assertThat(hackerNewsService.getNewStories()).hasSize(500);
    }

    @Test
    public void testFindStory() {
        Long currentTime = System.currentTimeMillis() / 1000L;
        HackerNewsService hackerNewsService = new HackerNewsService();
        Long id = hackerNewsService.getNewStories().get(0);
        Story story = hackerNewsService.findStory(id, currentTime);
        assertThat(story.getId()).isEqualTo(id);
        assertThat(story.getLifeTime()).isEqualTo(currentTime - story.getTime());
        assertThat(story.getScore()).isNotNull();
    }
}
