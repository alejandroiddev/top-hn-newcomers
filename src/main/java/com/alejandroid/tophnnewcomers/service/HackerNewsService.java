package com.alejandroid.tophnnewcomers.service;

import com.alejandroid.tophnnewcomers.domain.Story;
import com.google.common.collect.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class HackerNewsService {

    private final static Logger log = LoggerFactory.getLogger(HackerNewsService.class);

    private final static String NEW_STORIES_URL = "https://hacker-news.firebaseio.com/v0/newstories.json";
    private final static String ITEM_RETRIEVER = "https://hacker-news.firebaseio.com/v0/item/{id}.json";

    @Autowired
    public HackerNewsService() {

    }

    public List<Long> getNewStories() {
        RestTemplate restTemplate = new RestTemplate();
        return Lists.newArrayList(restTemplate.getForObject(NEW_STORIES_URL, Long[].class));
    }

    public Story findStory(Long id, Long currentTime) {
        RestTemplate restTemplate = new RestTemplate();
        Story result = restTemplate.getForObject(ITEM_RETRIEVER.replace("{id}", id.toString()), Story.class);
        return result.setLifeTime(currentTime - result.getTime());
    }

}
