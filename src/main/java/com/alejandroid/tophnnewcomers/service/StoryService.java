package com.alejandroid.tophnnewcomers.service;

import com.alejandroid.tophnnewcomers.domain.Story;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StoryService {

    public List<Story> getTop10NewComers() {
        return new ArrayList<>();
    }

}
