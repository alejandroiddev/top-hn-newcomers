package com.alejandroid.tophnnewcomers.resource;

import com.alejandroid.tophnnewcomers.resource.dto.StoryDTO;
import com.alejandroid.tophnnewcomers.service.StoryService;
import com.alejandroid.tophnnewcomers.service.mapper.StoryMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StoryResource {

    private final static Logger log = LoggerFactory.getLogger(StoryResource.class);

    private final StoryService storyService;
    private final StoryMapper storyMapper;

    public StoryResource(StoryService storyService, StoryMapper storyMapper) {
        this.storyService = storyService;
        this.storyMapper = storyMapper;
    }

    /**
     *  GET /top-ten-newcomers : Gets a list with the top ten newcomers.
     *
     * @return The list with the top ten newcomers
     */
    @GetMapping("/top-ten-newcomers")
    public ResponseEntity<List<StoryDTO>> getTop10Newcomers() {
        Long currentTime = System.currentTimeMillis() / 1000L;
        log.info("Accessed top-ten-newcomers endpoint");
        return new ResponseEntity<>(storyMapper.storiesToStoryDTOs(
                storyService.getTop10NewComers(currentTime)), HttpStatus.OK);
    }

}
