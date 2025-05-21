package com.bookadvisor.service;

import com.bookadvisor.dto.BookDto;
import com.bookadvisor.composite.*;
import com.bookadvisor.factory.BookDtoFactory;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Service for searching books using the OpenLibrary API.
 * Returns a list of {@link BookDto} based on a search query.
 * 
 * @author Luca Santomassimo
 */

@Service
public class BookService {

    // Logger for logging information and errors
    private static final Logger logger = LoggerFactory.getLogger(BookService.class);

    // RestTemplate for making HTTP requests to external APIs
    private final RestTemplate restTemplate = new RestTemplate();

    /**
     * Searches for books using the OpenLibrary API.
     * 
     * @param query the search string to look for books
     * 
     * @throws Exception if an error occurs during the HTTP request
     * @return a list of BookDto objects matching the query
     */

    public List<BookDto> searchBooks(String query) {

        // Build the OpenLibrary API URL with the query, replacing spaces with '+'
        String url = "https://openlibrary.org/search.json?q=" + query.replace(" ", "+");

        logger.info("Ricerca libri per query: " + query);
        String response;

        try {

            // Make the HTTP GET request to the API
            response = restTemplate.getForObject(url, String.class);
        } catch (Exception e) {

            // Log error and return empty list if request fails
            logger.error("Errore durante la richiesta HTTP a OpenLibrary", e);
            return new ArrayList<>();
        }

        // Parse the JSON response
        JSONObject jsonObject = new JSONObject(response);
        JSONArray docs = jsonObject.getJSONArray("docs");

        // Create a BookGroup to collect results
        BookGroup results = new BookGroup("Risultati Ricerca");

        // Iterate over the first 10 results (or less)
        for (int i = 0; i < Math.min(docs.length(), 10); i++) {
            JSONObject obj = docs.getJSONObject(i);

            // Extract book details with fallback/default values
            String title = obj.optString("title");
            String author = obj.has("author_name") ? obj.getJSONArray("author_name").optString(0) : "Sconosciuto";
            String coverUrl = obj.has("cover_i")
                    ? "https://covers.openlibrary.org/b/id/" + obj.getInt("cover_i") + "-M.jpg"
                    : null;
            String publishDate = obj.has("first_publish_year") ? String.valueOf(obj.getInt("first_publish_year"))
                    : "N.D.";
            String key = obj.optString("key");

            // Create BookDto using the factory and add to the group
            BookDto bookDto = BookDtoFactory.create(title, author, coverUrl, publishDate, key);
            results.add(new BookLeaf(bookDto));
        }

        // Convert the BookGroup to a list of BookDto and return
        return results.toBookDtoList();
    }

    // Alternative implementation (commented out)
    // public List<BookDto> searchBooks(String query) {
    // // Build the OpenLibrary API URL with the query
    // String url = "https://openlibrary.org/search.json?q=" + query.replace(" ",
    // "+");
    //
    // logger.info("Ricerca libri per query: " + query);
    // String response;
    // try {
    // // Make the HTTP GET request to the API
    // response = restTemplate.getForObject(url, String.class);
    // } catch (Exception e) {
    // // Log error and return empty list if request fails
    // logger.error("Errore durante la richiesta HTTP a OpenLibrary", e);
    // return new ArrayList<>();
    // }
    //
    // List<BookDto> results = new ArrayList<>();
    //
    // // Parse the JSON response
    // JSONObject json = new JSONObject(response);
    // JSONArray docs = json.getJSONArray("docs");
    //
    // // Iterate over the first 20 results (or less)
    // for (int i = 0; i < Math.min(docs.length(), 20); i++) {
    // JSONObject book = docs.getJSONObject(i);
    //
    // // Extract book details with fallback/default values
    // String title = book.optString("title");
    // String author = book.has("author_name") ?
    // book.getJSONArray("author_name").optString(0) : "N/A";
    // String publishDate = book.has("first_publish_year") ?
    // String.valueOf(book.getInt("first_publish_year"))
    // : "Unknown";
    // String coverId = book.optString("cover_i");
    // String coverUrl = coverId.isEmpty() ? "" :
    // "https://covers.openlibrary.org/b/id/" + coverId + "-M.jpg";
    // String key = book.optString("key");
    //
    // // Create BookDto and add to results
    // results.add(BookDtoFactory.create(title, author, coverUrl, publishDate,
    // key));
    // }
    //
    // return results;
    // }
}
