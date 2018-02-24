package com.alejandroid.tophnnewcomers.resource;

import com.alejandroid.tophnnewcomers.service.StoryService;
import com.alejandroid.tophnnewcomers.service.mapper.StoryMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StoryResourceIntTest {

    @Autowired
    private StoryService storyService;

    @Autowired
    private StoryMapper storyMapper;

    private MockMvc restStoryMvc;

    @Before
    public void setUp() {
        StoryResource storyResource = new StoryResource(storyService,storyMapper);
        restStoryMvc = MockMvcBuilders.standaloneSetup(storyResource).build();
    }

    @Test
    public void getTopTenNewcomers() throws Exception {
        restStoryMvc.perform(get("/stories/top-ten-newcomers"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(jsonPath("$", hasSize(10)))
                .andExpect(jsonPath("$.[*].id").exists())
                .andExpect(jsonPath("$.[*].title").exists())
                .andExpect(jsonPath("$.[*].score").exists())
                .andExpect(jsonPath("$.[*].author").exists())
                .andExpect(jsonPath("$.[*].commentsCount").exists())
                .andExpect(jsonPath("$.[*].creationDate").exists())
                .andExpect(jsonPath("$.[*].lifeTime").exists());
    }

    @Test
    public void getRecordStory() throws Exception {
        //TODO: Access DB and compare returned object with DB object
        restStoryMvc.perform(get("/stories/record-newcomer"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(jsonPath("$.id").exists())
                .andExpect(jsonPath("$.title").exists())
                .andExpect(jsonPath("$.score").exists())
                .andExpect(jsonPath("$.author").exists())
                .andExpect(jsonPath("$.commentsCount").exists())
                .andExpect(jsonPath("$.creationDate").exists())
                .andExpect(jsonPath("$.lifeTime").exists());
    }

}
