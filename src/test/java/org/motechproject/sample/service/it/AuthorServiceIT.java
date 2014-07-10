package org.motechproject.sample.service.it;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.motechproject.sample.domain.Author;
import org.motechproject.sample.repository.AuthorDataService;
import org.motechproject.sample.repository.BookDataService;
import org.motechproject.sample.repository.SecretDataService;
import org.motechproject.sample.repository.SpyDataService;
import org.motechproject.sample.service.AuthorService;
import org.motechproject.testing.osgi.BasePaxIT;
import org.motechproject.testing.osgi.container.MotechNativeTestContainerFactory;
import org.ops4j.pax.exam.ExamFactory;
import org.ops4j.pax.exam.junit.PaxExam;
import org.ops4j.pax.exam.spi.reactors.ExamReactorStrategy;
import org.ops4j.pax.exam.spi.reactors.PerSuite;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.jdo.JDOException;

import static org.junit.Assert.assertEquals;

/**
 * Verify that HelloWorldAuthorService present, functional.
 */
@RunWith(PaxExam.class)
@ExamReactorStrategy(PerSuite.class)
@ExamFactory(MotechNativeTestContainerFactory.class)
public class AuthorServiceIT extends BasePaxIT {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Inject
    private AuthorService authorService;
    @Inject
    private AuthorDataService authorDataService;
    @Inject
    private BookDataService bookDataService;
    @Inject
    private SpyDataService spyDataService;
    @Inject
    private SecretDataService secretDataService;

    @Before
    public void clearDatabase() {
        logger.info("clearDatabase");

        secretDataService.deleteAll();
        spyDataService.deleteAll();
        bookDataService.deleteAll();
        authorDataService.deleteAll();
    }

    @Test
    public void verifyCreatingSimpleAuthor() throws Exception {

        logger.info("verifyCreatingSimpleAuthor");

        Author ernest = authorDataService.create(new Author("Ernest"));
        logger.info("created {}", ernest);

        Author author = authorService.findAuthorByName(ernest.getName());
        logger.info("found {}", author);

        assertEquals(author, ernest);
    }

    @Test
    public void verifyCreatingComplexAuthor() throws Exception {

        logger.info("verifyCreatingComplexAuthor");

        Author ernest = authorDataService.create(new Author("Ernest"));
        logger.info("created {}", ernest);

        Author author = authorService.findAuthorByName(ernest.getName());
        logger.info("found {}", author);

        assertEquals(author, ernest);
    }

    @Test
    public void testCascadeDeletes() throws Exception {

        logger.info("testCascadeDeletes");

//        Book b1 = bookDataService.create(new Book("The old man and the sea", "A man goes fishing"));
//        Book b2 = bookDataService.create(new Book("For whom the bell tolls", "The Spanish war"));
//        Author ernest = authorDataService.create(new Author("Ernest",
//                Arrays.asList(b1, b2), "This is Ernest's biography."));
//
//        Author author = authorService.findAuthorByName(ernest.getName());
//        assertEquals(ernest, author);
//
//        authorService.delete(author);
//        List<Book> books = bookDataService.retrieveAll();
//        assertEquals(0, books.size());
    }

    @Test(expected = JDOException.class)
    public void shouldNotCreateDuplicates() throws Exception {

        logger.info("shouldNotCreateDuplicates");

        Author ernest = authorDataService.create(new Author("Ernest"));
        Author ernestAlso = authorDataService.create(new Author("Ernest"));
    }
}
