package com.alejandroid.tophnnewcomers.service;

import com.alejandroid.tophnnewcomers.domain.Story;
import com.google.common.collect.Lists;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class StoryServiceUnitTest {

    @InjectMocks
    private StoryService storyService;

    @Mock
    private HackerNewsService hackerNewsServiceMock;

    private List<Long> newStories;
    private Long newStory;

    @Before
    public void setup() {
        newStories = this.createNewStoriesList();
        newStory = 1000000L;
        when(hackerNewsServiceMock.getNewStories())
                .thenReturn(newStories)
                .thenReturn(newStories)
                .thenReturn(Lists.newArrayList(newStory));
        when(hackerNewsServiceMock.findStory(anyLong(), anyLong()))
                .thenAnswer(i -> this.createStory((Long) i.getArguments()[0],(Long) i.getArguments()[1]));
    }

    @Test
    public void testUpdateLists() {
        storyService.updateLists();
        List<Story> top10NewComers = storyService.getTop10NewComers(System.currentTimeMillis() / 1000L);
        List<Story> updatedtop10NewComers = storyService.getTop10NewComers(System.currentTimeMillis() / 1000L);
        assertThat(updatedtop10NewComers).hasSize(10);
        assertThat(updatedtop10NewComers).isSortedAccordingTo(Comparator.naturalOrder());
        assertThat(updatedtop10NewComers.get(0).getId()).isEqualTo(newStory);
        assertThat(updatedtop10NewComers.get(1).getId()).isEqualTo(top10NewComers.get(0).getId());
    }

    @Test
    public void testGetTop10Newcomers() {
        List<Story> top10NewComers = storyService.getTop10NewComers(System.currentTimeMillis() / 1000L);
        assertThat(top10NewComers).hasSize(10);
        assertThat(top10NewComers).isSortedAccordingTo(Comparator.naturalOrder());
    }

    private List<Long> createNewStoriesList() {
        long leftLimit = 100L;
        long rightLimit = 100000L;
        List<Long> newStories = new ArrayList<>();
        for (int i = 1; i <= 100; i++) {
            Long generatedLong = leftLimit + (long) (Math.random() * (rightLimit - leftLimit));
            newStories.add(generatedLong);
        }
        return newStories;
    }

    private Story createStory(Long id, Long currentTime) {
        return new Story()
                .setId(id)
                .setRank((double) id / (double) currentTime);
    }

}
