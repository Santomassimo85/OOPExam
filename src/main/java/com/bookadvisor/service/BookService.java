package com.bookadvisor.service;

import com.bookadvisor.dto.BookDto;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {

    private final RestTemplate restTemplate = new RestTemplate();

    public List<BookDto> searchBooks(String query) {
        String url = "https://openlibrary.org/search.json?q=" + query.replace(" ", "+");
        String response = restTemplate.getForObject(url, String.class);

        List<BookDto> results = new ArrayList<>();

        JSONObject json = new JSONObject(response);
        JSONArray docs = json.getJSONArray("docs");

        for (int i = 0; i < Math.min(docs.length(), 20); i++) {
            JSONObject book = docs.getJSONObject(i);

            String title = book.optString("title");
            String author = book.has("author_name") ? book.getJSONArray("author_name").optString(0) : "N/A";
            String publishDate = book.has("first_publish_year") ? String.valueOf(book.getInt("first_publish_year")) : "Unknown";
            String coverId = book.optString("cover_i");
            String coverUrl = coverId.isEmpty() ? "" : "https://covers.openlibrary.org/b/id/" + coverId + "-M.jpg";
            String key = book.optString("key");

            results.add(new BookDto(title, author, coverUrl, publishDate, key));
        }

        return results;
    }
}
