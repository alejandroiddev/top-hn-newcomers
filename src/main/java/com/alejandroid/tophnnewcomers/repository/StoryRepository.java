package com.alejandroid.tophnnewcomers.repository;

import com.alejandroid.tophnnewcomers.domain.Story;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoryRepository  extends JpaRepository<Story, Long>{
}
