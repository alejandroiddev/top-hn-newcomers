package com.alejandroid.tophnnewcomers.resource;

import com.alejandroid.tophnnewcomers.resource.dto.StoryDTO;
import com.alejandroid.tophnnewcomers.service.StoryService;
import com.alejandroid.tophnnewcomers.service.mapper.StoryMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StoryResource {

    private final StoryService storyService;
    private final StoryMapper storyMapper;

    public StoryResource(StoryService storyService, StoryMapper storyMapper) {
        this.storyService = storyService;
        this.storyMapper = storyMapper;
    }

    @GetMapping("/top-ten-newcomers")
    public ResponseEntity<List<StoryDTO>> getTop10Newcomers() {
        return new ResponseEntity<>(storyMapper.storiesToStoryDTOs(storyService.getTop10NewComers()), HttpStatus.OK);
    }

}
