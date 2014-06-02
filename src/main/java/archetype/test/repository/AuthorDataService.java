package archetype.test.repository;

import archetype.test.domain.Author;
import org.motechproject.mds.annotations.Lookup;
import org.motechproject.mds.annotations.LookupField;
import org.motechproject.mds.service.MotechDataService;

public interface AuthorDataService extends MotechDataService<Author> {
    @Lookup
    Author findAuthorByName(@LookupField(name = "name") String authorName);
}
