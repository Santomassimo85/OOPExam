package com.bookadvisor;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.List;

import org.junit.jupiter.api.Test;
import com.bookadvisor.dto.BookDto;
import com.bookadvisor.service.BookService;

import org.springframework.boot.test.context.SpringBootTest;

/**
 * Test class for the BookAdvisor Spring Boot application.
 * <p>
 * Contains integration and unit tests to verify the application context loads
 * and that the book search functionality returns expected results.
 * </p>
 *
 * <ul>
 * <li>{@link #contextLoads()} - Verifies that the Spring application context
 * loads successfully.</li>
 * <li>{@link #testSearchBooksReturnsResults()} - Tests the
 * {@code BookService.searchBooks} method to ensure it returns
 * non-empty results for a given query (e.g., "tolkien").</li>
 * </ul>
 * 
 * @author Luca Santomassimo
 */

@SpringBootTest
class BookAdvisorApplicationTests {

    /**
     * Test to verify that the Spring application context loads without errors.
     */
    
    @Test
    void contextLoads() {
        // If the context fails to load, this test will fail.
    }

    /**
     * Tests the BookService.searchBooks method to ensure it returns
     * non-empty results for a given query ("tolkien").
     */
    @Test
    public void testSearchBooksReturnsResults() {
        System.out.println("⚙️ Avvio test: testSearchBooksReturnsResults");

        // Create a new instance of BookService
        BookService service = new BookService();

        // Search for books with the keyword "tolkien"
        List<BookDto> result = service.searchBooks("tolkien");

        // Print the number of results found
        System.out.println("📚 Numero risultati: " + result.size());

        if (!result.isEmpty()) {

            // Print the title of the first book in the results
            System.out.println("✅ Primo titolo: " + result.get(0).getTitle());
        }

        // Assert that the result list is not null
        assertNotNull(result);

        // Assert that the result list is not empty
        assertFalse(result.isEmpty());
    }

}
