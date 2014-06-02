package archetype.test.domain;

import org.motechproject.mds.annotations.Entity;
import org.motechproject.mds.annotations.Field;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/**
 * Models data for simple records in a portable manner.
 */
@Entity
public class Author {

    @Field(required = true)
    private String name;

    @Field
    private String bio;

    @Field
    private List<Book> books;

    public Author() {
    }

    public Author(String name, String bio) {
        this.name = name;
        this.bio = bio;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Author)) return false;

        Author author = (Author) o;

        if (bio != null ? !bio.equals(author.bio) : author.bio != null) return false;
        if (!name.equals(author.name)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + (bio != null ? bio.hashCode() : 0);
        return result;
    }
}