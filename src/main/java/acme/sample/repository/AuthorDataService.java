package acme.sample.repository;

import acme.sample.domain.Author;
import org.motechproject.mds.annotations.Lookup;
import org.motechproject.mds.annotations.LookupField;
import org.motechproject.mds.service.MotechDataService;

public interface AuthorDataService extends MotechDataService<Author> {
    @Lookup
    Author findByName(@LookupField(name = "name") String authorName);
}
