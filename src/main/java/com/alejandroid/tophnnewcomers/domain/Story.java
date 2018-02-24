package com.alejandroid.tophnnewcomers.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Story implements Comparable<Story> {

    @Id
    private Long id;

    private String by;
    @Transient
    private List<Long> kids = new ArrayList<>();
    private Long score;
    private Long time;
    private String title;
    private String type;
    private String url;
    private Double rank;
    private Long lifeTime;

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

    public Double getRank() {
        if (rank == null) {
            rank = score.doubleValue() / lifeTime.doubleValue();
        }
        return rank;
    }

    public Story setRank(Double rank) {
        this.rank = rank;
        return this;
    }

    public Long getLifeTime() {
        return lifeTime;
    }

    public Story setLifeTime(Long lifeTime) {
        this.lifeTime = lifeTime;
        return this;
    }

    @Override
    public String toString() {
        return "Story{" +
                "id=" + id +
                ", by='" + by + '\'' +
                ", kids=" + kids +
                ", score=" + score +
                ", time=" + time +
                ", title='" + title + '\'' +
                ", type='" + type + '\'' +
                ", url='" + url + '\'' +
                ", rank=" + rank +
                ", lifeTime=" + lifeTime +
                '}';
    }

    @Override
    public int compareTo(Story o) {
        double result = (o.getRank() - this.getRank());
        return result > 0.0 ? 1 : -1;
    }
}
