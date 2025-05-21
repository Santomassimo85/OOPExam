// Composite Pattern per BookAdvisor - Dimostrativo

package com.bookadvisor.composite;

import com.bookadvisor.composite.BookComponent;
import com.bookadvisor.dto.BookDto;

import java.util.List;

/**
 * The {@code BookComponent} class defines the interface for all components in the
 * Composite design pattern for representing books and collections of books.
 * <p>
 * This abstract class provides default implementations for all methods, which throw
 * {@link UnsupportedOperationException}. Subclasses should override relevant methods
 * to provide specific behavior for leaf (e.g., Book) or composite (e.g., BookCollection) nodes.
 * </p>
 *
 * <ul>
 *   <li>{@link #add(BookComponent)} and {@link #remove(BookComponent)} are intended for composite nodes.</li>
 *   <li>{@link #getChild(int)} allows access to child components in a composite.</li>
 *   <li>{@link #getTitle()} retrieves the title of the component.</li>
 *   <li>{@link #display()} displays the component's details.</li>
 *   <li>{@link #toBookDtoList()} converts the component and its children to a list of {@code BookDto} objects.</li>
 * </ul>
 *
 * @author  Luca Santomassimo
 * @version 1.0
 */

public abstract class BookComponent {

    public void add(BookComponent component) {
        throw new UnsupportedOperationException();
    }

    public void remove(BookComponent component) {
        throw new UnsupportedOperationException();
    }

    public BookComponent getChild(int i) {
        throw new UnsupportedOperationException();
    }

    public String getTitle() {
        throw new UnsupportedOperationException();
    }

    public void display() {
        throw new UnsupportedOperationException();
    }

    public List<BookDto> toBookDtoList() {
        throw new UnsupportedOperationException();
    }
}
