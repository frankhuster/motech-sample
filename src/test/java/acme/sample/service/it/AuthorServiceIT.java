package acme.sample.service.it;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import acme.sample.domain.Author;
import acme.sample.domain.Book;
import acme.sample.repository.AuthorDataService;
import acme.sample.repository.BookDataService;
import acme.sample.service.AuthorService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.ops4j.pax.exam.junit.PaxExam;
import org.ops4j.pax.exam.spi.reactors.ExamReactorStrategy;
import org.motechproject.testing.osgi.container.MotechNativeTestContainerFactory;
import org.ops4j.pax.exam.ExamFactory;
import org.motechproject.testing.osgi.BasePaxIT;
import org.ops4j.pax.exam.spi.reactors.PerSuite;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

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

    @Test
    public void testAuthorService() throws Exception {

        logger.info("testAuthorService");

        authorDataService.deleteAll();

        Author ernest = authorDataService.create(new Author("Ernest", "This is Ernest's biography."));

        logger.info("Created author id {}", authorDataService.getDetachedField(ernest, "id"));

        Author author = authorService.findAuthorByName(ernest.getName());
        logger.info("Found author id {} : {}", authorDataService.getDetachedField(author, "id"), author.toString());

        assertEquals(ernest, author);


        List<Author> authors = authorService.getAuthors();
        assertTrue(authors.contains(ernest));

        authorService.delete(ernest);
        author = authorService.findAuthorByName(ernest.getName());
        assertNull(author);
    }
}
