package org.motechproject.sample.service;

import java.util.List;

import org.motechproject.sample.domain.Author;

/**
 * Service interface for CRUD on simple repository authors.
 */
public interface AuthorService {

    void create(String name, String message);

    void add(Author author);

    Author findAuthorByName(String authorName);

    List<Author> getAuthors();

    void delete(Author author);

    void update(Author author);
}
