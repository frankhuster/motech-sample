package org.motechproject.sample.service.it;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.motechproject.sample.domain.Author;
import org.motechproject.sample.repository.AuthorDataService;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

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

        Map<String, String> map1 = new HashMap<>();
        map1.put("m1k1", "m1v1");
        map1.put("m1k2", "m1v2");

        Map<String, Author.Map2Enum> map2 = new HashMap<>();
        map2.put("m2k1", Author.Map2Enum.FOO);
        map2.put("m2k2", Author.Map2Enum.BAR);

        Map<String, String> map3 = new HashMap<>();
        map1.put("m3k1", "m3v1");
        map1.put("m3k2", "m3v2");


        Author ernest = authorDataService.create(new Author("Ernest", "This is Ernest's biography.", map1, map2, map3));

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

    @Test(expected = JDOException.class)
    public void shouldNotCreateDuplicates() throws Exception {

        logger.info("shouldNotCreateDuplicates");

        authorDataService.deleteAll();

        Author ernest = authorDataService.create(new Author("Ernest"));

        Author ernestAlso = authorDataService.create(new Author("Ernest"));
    }
}
