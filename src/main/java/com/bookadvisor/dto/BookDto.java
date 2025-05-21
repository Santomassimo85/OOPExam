package com.bookadvisor.dto;

/**
 * Data Transfer Object (DTO) representing a book.
 * <p>
 * This class is used to transfer book data between different layers of the application.
 * It contains basic information about a book such as title, author, cover image URL,
 * publish date, and a unique key identifier.
 * </p>
 *
 * <p>Example usage:</p>
 * <pre>
 *     BookDto book = new BookDto("Title", "Author", "http://cover.url", "2024-01-01", "unique-key");
 * </pre>
 *
 * @author YourName
 */
/**
 * Represents a Data Transfer Object (DTO) for a book.
 * Contains basic book information for transferring between application layers.
 */
public class BookDto {
    // The title of the book
    private String title;
    // The author of the book
    private String author;
    // The URL of the book's cover image
    private String coverUrl;
    // The publish date of the book (format: YYYY-MM-DD)
    private String publishDate;
    // A unique key identifier for the book
    private String key;

    /**
     * Default constructor.
     */
    public BookDto() {}

    /**
     * Constructs a BookDto with all fields.
     *
     * @param title the title of the book
     * @param author the author of the book
     * @param coverUrl the URL of the book's cover image
     * @param publishDate the publish date of the book
     * @param key the unique key identifier for the book
     */
    
    public BookDto(String title, String author, String coverUrl, String publishDate, String key) {
        this.title = title;
        this.author = author;
        this.coverUrl = coverUrl;
        this.publishDate = publishDate;
        this.key = key;
    }

    /**
     * Gets the title of the book.
     * @return the book title
     */
    public String getTitle() { return title; }

    /**
     * Sets the title of the book.
     * @param title the book title
     */
    public void setTitle(String title) { this.title = title; }

    /**
     * Gets the author of the book.
     * @return the book author
     */
    public String getAuthor() { return author; }

    /**
     * Sets the author of the book.
     * @param author the book author
     */
    public void setAuthor(String author) { this.author = author; }

    /**
     * Gets the cover image URL of the book.
     * @return the cover image URL
     */
    public String getCoverUrl() { return coverUrl; }

    /**
     * Sets the cover image URL of the book.
     * @param coverUrl the cover image URL
     */
    public void setCoverUrl(String coverUrl) { this.coverUrl = coverUrl; }

    /**
     * Gets the publish date of the book.
     * @return the publish date
     */
    public String getPublishDate() { return publishDate; }

    /**
     * Sets the publish date of the book.
     * @param publishDate the publish date
     */
    public void setPublishDate(String publishDate) { this.publishDate = publishDate; }

    /**
     * Gets the unique key identifier for the book.
     * @return the unique key
     */
    public String getKey() { return key; }

    /**
     * Sets the unique key identifier for the book.
     * @param key the unique key
     */
    public void setKey(String key) { this.key = key; }
}