package org.motechproject.sample.service;

import org.motechproject.sample.domain.Author;

import java.util.List;

/**
 * Service interface for CRUD on simple repository authors.
 */
public interface AuthorService {

    void create(String name);

    void add(Author author);

    Author findAuthorByName(String authorName);

    List<Author> getAuthors();

    void delete(Author author);

    void update(Author author);
}
