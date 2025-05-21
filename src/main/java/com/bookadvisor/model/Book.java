package com.bookadvisor.model;

/**
 * Represents a book with details such as title, author, cover URL, publish date, key, and year.
 * <p>
 * This class provides constructors for different combinations of book information,
 * as well as getter and setter methods for each field.
 * </p>
 *
 * Fields:
 * <ul>
 *   <li>title - The title of the book.</li>
 *   <li>author - The author of the book.</li>
 *   <li>coverUrl - The URL to the book's cover image.</li>
 *   <li>publishDate - The publish date of the book.</li>
 *   <li>key - A unique key or identifier for the book.</li>
 *   <li>year - The year the book was published.</li>
 * </ul>
 *
 * Example usage:
 * <pre>
 *     Book book = new Book("Title", "Author", "http://cover.url", "2020-01-01", "key123");
 *     book.setYear(2020);
 * </pre>
 * 
 * @param title The title of the book.
 * @param author The author of the book.
 * @param coverUrl The URL to the book's cover image.
 * @param publishDate The publish date of the book.
 * @param key A unique key or identifier for the book.
 * @param year The year the book was published.
 *
 * @author Luca Santomassimo
 */
public class Book {
    private String title;
    private String author;
    private String coverUrl;
    private String publishDate;
    private String key;
    public int year;

    public void setYear(int year) {
        this.year = year;
    }

    public Book() {
    }

    public Book(String title, String author, String coverUrl, String publishDate, String key) {
        this.title = title;
        this.author = author;
        this.coverUrl = coverUrl;
        this.publishDate = publishDate;
        this.key = key;
    }

    public Book(String title, String author, int year) {
        this.title = title;
        this.author = author;
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCoverUrl() {
        return coverUrl;
    }

    public void setCoverUrl(String coverUrl) {
        this.coverUrl = coverUrl;
    }

    public String getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(String publishDate) {
        this.publishDate = publishDate;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public int getYear() {
        return year;
    }
}
