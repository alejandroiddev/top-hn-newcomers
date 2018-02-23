package com.alejandroid.tophnnewcomers.domain;

import java.util.List;

public class Story {

    private String by;
    private Long id;
    private List<Long> kids;
    private Long score;
    private Long time;
    private String title;
    private String type;
    private String url;

    public String getBy() {
        return by;
    }

    public Story setBy(String by) {
        this.by = by;
        return this;
    }

    public Long getId() {
        return id;
    }

    public Story setId(Long id) {
        this.id = id;
        return this;
    }

    public List<Long> getKids() {
        return kids;
    }

    public Story setKids(List<Long> kids) {
        this.kids = kids;
        return this;
    }

    public Long getScore() {
        return score;
    }

    public Story setScore(Long score) {
        this.score = score;
        return this;
    }

    public Long getTime() {
        return time;
    }

    public Story setTime(Long time) {
        this.time = time;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public Story setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getType() {
        return type;
    }

    public Story setType(String type) {
        this.type = type;
        return this;
    }

    public String getUrl() {
        return url;
    }

    public Story setUrl(String url) {
        this.url = url;
        return this;
    }

    @Override
    public String toString() {
        return "Story{" +
                "by='" + by + '\'' +
                ", id=" + id +
                ", kids=" + kids +
                ", score=" + score +
                ", time=" + time +
                ", title='" + title + '\'' +
                ", type='" + type + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
