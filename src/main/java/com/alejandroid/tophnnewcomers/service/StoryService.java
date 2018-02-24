package com.alejandroid.tophnnewcomers.service;

import com.alejandroid.tophnnewcomers.domain.Story;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StoryService {

    private final static int SCHEDULER_DELAY = 120000;

    private final static Logger log = LoggerFactory.getLogger(StoryService.class);

    private final HackerNewsService hackerNewsService;

    private List<Long> newStories = new ArrayList<>();
    private List<Story> top40NewComers = new ArrayList<>();

    public StoryService(HackerNewsService hackerNewsService) {
        this.hackerNewsService = hackerNewsService;
        log.info("Starting StoryService, It may take a few minutes...");
        this.updateLists();
        log.info("Started StoryService");
    }

    public List<Story> getTop10NewComers(Long currentTime) {
        List<Long> newestStories = hackerNewsService.getNewStories();
        newestStories.removeAll(newStories);
        List<Story> newcomers = newestStories
                .parallelStream().map(id -> hackerNewsService.findStory(id, currentTime))
                .collect(Collectors.toList());
        List<Story> newestComers = top40NewComers
                .parallelStream().map(story -> hackerNewsService.findStory(story.getId(), currentTime))
                .collect(Collectors.toList());
        newcomers.addAll(newestComers);
        Collections.sort(newcomers);
        return newcomers.subList(0, 10);
    }

    private void updateLists() {
        Long currentTime = System.currentTimeMillis() / 1000L;
        newStories = hackerNewsService.getNewStories();
        List<Story> newcomers = newStories
                .parallelStream().map(id -> hackerNewsService.findStory(id, currentTime))
                .sorted().collect(Collectors.toList());
        top40NewComers = newcomers.subList(0, 30);
    }

    @Scheduled(fixedDelay = SCHEDULER_DELAY, initialDelay = SCHEDULER_DELAY)
    public void reportCurrentTime() {
        log.debug("Updating Top newcomers");
        this.updateLists();
        log.debug("Finished Updating Top newcomers");
    }
}
