package archetype.test.service.impl;

import archetype.test.domain.Author;
import archetype.test.repository.AuthorDataService;
import archetype.test.service.AuthorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Implementation of the {@link archetype.test.service.AuthorService} interface. Uses
 * {@link archetype.test.repository.AuthorDataService} in order to retrieve and persist authors.
 */
@Service("helloWorldAuthorService")
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    private AuthorDataService authorDataService;

    @Override
    public void create(String name, String bio) {
        authorDataService.create(
                new Author(name, bio)
        );
    }

    @Override
    public void add(Author author) {
        authorDataService.create(author);
    }

    @Override
    public Author findAuthorByName(String authorName) {
        Author author = authorDataService.findAuthorByName(authorName);
        if (null == author) {
            return null;
        }
        return author;
    }

    @Override
    public List<Author> getAuthors() {
        return authorDataService.retrieveAll();
    }

    @Override
    public void update(Author author) {
        authorDataService.update(author);
    }

    @Override
    public void delete(Author author) {
        authorDataService.delete(author);
    }
}
