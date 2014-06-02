package archetype.test.repository;

import archetype.test.domain.Book;
import org.motechproject.mds.annotations.Lookup;
import org.motechproject.mds.annotations.LookupField;
import org.motechproject.mds.service.MotechDataService;

public interface BookDataService extends MotechDataService<Book> {
    @Lookup
    Book findBookByTitle(@LookupField(name = "title") String bookTitle);
}
