package org.motechproject.sample.service.it;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.motechproject.sample.domain.Author;
import org.motechproject.sample.domain.Book;
import org.motechproject.sample.repository.AuthorDataService;
import org.motechproject.sample.repository.BookDataService;
import org.motechproject.sample.service.AuthorService;

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
public class BookServiceIT extends BasePaxIT {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Inject
    private BookDataService bookDataService;

    @Test
    public void testBookService() throws Exception {

        logger.info("testBookService");

        bookDataService.deleteAll();

        Book testBook1 = bookDataService.create(new Book("Book, the one", "book description"));
        Book testBook2 = bookDataService.create(new Book("Book two, the return", "book description"));
        List<Book> books = new ArrayList<>(Arrays.asList(testBook1, testBook2));
    }
}
