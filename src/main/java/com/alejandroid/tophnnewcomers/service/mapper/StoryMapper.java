package com.alejandroid.tophnnewcomers.service.mapper;

import com.alejandroid.tophnnewcomers.domain.Story;
import com.alejandroid.tophnnewcomers.resource.dto.StoryDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class StoryMapper {

    public StoryDTO storyToStoryDTO(Story story) {
        StoryDTO storyDTO = new StoryDTO();
        BeanUtils.copyProperties(story, storyDTO);
        storyDTO.setAuthor(story.getBy())
                .setCommentsCount(story.getKids().size())
                .setCreationDate(new Date(story.getTime() * 1000));
        return storyDTO;
    }

    public List<StoryDTO> storiesToStoryDTOs(List<Story> stories) {
        return stories.stream().map(this::storyToStoryDTO).collect(Collectors.toList());
    }

}
