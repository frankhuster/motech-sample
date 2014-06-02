package archetype.test.service.it;

import java.util.List;

import archetype.test.domain.Author;
import archetype.test.domain.Book;
import archetype.test.repository.AuthorDataService;
import archetype.test.repository.BookDataService;
import archetype.test.service.AuthorService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.ops4j.pax.exam.junit.PaxExam;
import org.ops4j.pax.exam.spi.reactors.ExamReactorStrategy;
import org.motechproject.testing.osgi.container.MotechNativeTestContainerFactory;
import org.ops4j.pax.exam.ExamFactory;
import org.ops4j.pax.exam.spi.reactors.PerClass;
import org.motechproject.testing.osgi.BasePaxIT;

import javax.inject.Inject;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

/**
 * Verify that HelloWorldAuthorService present, functional.
 */
@RunWith(PaxExam.class)
@ExamReactorStrategy(PerClass.class)
@ExamFactory(MotechNativeTestContainerFactory.class)
public class AuthorServiceIT extends BasePaxIT {

    @Inject
    private AuthorService authorService;
    @Inject
    AuthorDataService authorDataService;
    @Inject
    BookDataService bookDataService;

    @Test
    public void testHelloWorldAuthorService() throws Exception {

        authorDataService.deleteAll();

        Author testAuthor = new Author("testName", "test message");
        authorService.add(testAuthor);

        Book testBook = new Book("bookName", "book description");
        bookDataService.create(testBook);

        Author author = authorService.findAuthorByName(testAuthor.getName());
        assertEquals(testAuthor, author);

        List<Author> authors = authorService.getAuthors();
        assertTrue(authors.contains(testAuthor));

        authorService.delete(testAuthor);
        author = authorService.findAuthorByName(testAuthor.getName());
        assertNull(author);
    }
}
