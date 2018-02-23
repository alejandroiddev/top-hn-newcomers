package com.alejandroid.tophnnewcomers.resource.dto;

import java.time.ZonedDateTime;

public class StoryDTO {

    private Long id;

    private String title;
    private Long score;
    private String author;
    private Long commentsCount;
    private ZonedDateTime creationDate;
    private Long lifeTime;

    public Long getId() {
        return id;
    }

    public StoryDTO setId(Long id) {
        this.id = id;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public StoryDTO setTitle(String title) {
        this.title = title;
        return this;
    }

    public Long getScore() {
        return score;
    }

    public StoryDTO setScore(Long score) {
        this.score = score;
        return this;
    }

    public String getAuthor() {
        return author;
    }

    public StoryDTO setAuthor(String author) {
        this.author = author;
        return this;
    }

    public Long getCommentsCount() {
        return commentsCount;
    }

    public StoryDTO setCommentsCount(Long commentsCount) {
        this.commentsCount = commentsCount;
        return this;
    }

    public ZonedDateTime getCreationDate() {
        return creationDate;
    }

    public StoryDTO setCreationDate(ZonedDateTime creationDate) {
        this.creationDate = creationDate;
        return this;
    }

    public Long getLifeTime() {
        return lifeTime;
    }

    public StoryDTO setLifeTime(Long lifeTime) {
        this.lifeTime = lifeTime;
        return this;
    }

    @Override
    public String toString() {
        return "StoryDTO{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", score=" + score +
                ", author='" + author + '\'' +
                ", commentsCount=" + commentsCount +
                ", creationDate=" + creationDate +
                ", lifeTime=" + lifeTime +
                '}';
    }
}
