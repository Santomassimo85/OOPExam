package com.bookadvisor.composite;

import java.util.ArrayList;
import java.util.List;
import com.bookadvisor.dto.BookDto;


/**
 * The BookGroup class represents a composite node in the Composite design pattern.
 * It can contain multiple BookComponent objects, which can be either leaf nodes (BookLeaf)
 * or other composite nodes (BookGroup).
 * 
 * This class provides methods to add, remove, and retrieve child components, as well as to display
 * the group and convert it to a list of BookDto objects.
 * 
 * @author: Luca Santomassimo
 */

public class BookGroup extends BookComponent {

    // Name of the group
    private String groupName;
    // List of child components (can be BookLeaf or BookGroup)
    private List<BookComponent> children = new ArrayList<>();

    /**
     * Constructs a BookGroup with the specified group name.
     * @param groupName the name of the group
     */

    public BookGroup(String groupName) {
        this.groupName = groupName;
    }

    /**
     * Adds a child BookComponent to this group.
     * @param component the BookComponent to add
     */

    @Override
    public void add(BookComponent component) {
        children.add(component);
    }

    /**
     * Removes a child BookComponent from this group.
     * @param component the BookComponent to remove
     */

    @Override
    public void remove(BookComponent component) {
        children.remove(component);
    }

    /**
     * Retrieves the child BookComponent at the specified index.
     * @param i the index of the child to retrieve
     * @return the BookComponent at the specified index
     */

    @Override
    public BookComponent getChild(int i) {
        return children.get(i);
    }

    /**
     * Displays the group name and recursively displays all child components.
     */

    @Override
    public void display() {
        System.out.println("Gruppo: " + groupName);
        for (BookComponent component : children) {
            component.display();
        }
    }

    /**
     * Converts all child components to a list of BookDto objects.
     * @return a list of BookDto objects representing all books in this group
     */
    
    @Override
    public List<BookDto> toBookDtoList() {
        List<BookDto> result = new ArrayList<>();
        for (BookComponent component : children) {
            result.addAll(component.toBookDtoList());
        }
        return result;
    }
}