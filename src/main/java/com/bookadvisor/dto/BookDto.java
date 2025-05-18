package com.bookadvisor.dto;

public class BookDto {
    private String title;
    private String author;
    private String coverUrl;
    private String publishDate;
    private String key;

    public BookDto() {}

    public BookDto(String title, String author, String coverUrl, String publishDate, String key) {
        this.title = title;
        this.author = author;
        this.coverUrl = coverUrl;
        this.publishDate = publishDate;
        this.key = key;
    }

    // Getters and setters
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }

    public String getCoverUrl() { return coverUrl; }
    public void setCoverUrl(String coverUrl) { this.coverUrl = coverUrl; }

    public String getPublishDate() { return publishDate; }
    public void setPublishDate(String publishDate) { this.publishDate = publishDate; }

    public String getKey() { return key; }
    public void setKey(String key) { this.key = key; }
}