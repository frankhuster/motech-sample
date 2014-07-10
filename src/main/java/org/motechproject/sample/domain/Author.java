package org.motechproject.sample.domain;

import org.motechproject.mds.annotations.Entity;
import org.motechproject.mds.annotations.Field;

@Entity
public class Author {

    @Field(required = true)
    private String name;

//    @Field
//    @Cascade(persist = true, update = true, delete = true)
//    private List<Book> books = new ArrayList<>();

    public Author(String name) {
        this.name = name;
    }

//    public Author(String name, List<Book> books) {
//        this.name = name;
//        if (null != books) {
//            this.books = books;
//        }
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    public List<Book> getBooks() {
//        return books;
//    }
//
//    public void setBooks(List<Book> books) {
//        if (null == books) {
//            this.books = new ArrayList<>();
//        } else {
//            this.books = books;
//        }
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Author)) return false;

        Author author = (Author) o;

//        if (books != null ? !books.equals(author.books) : author.books != null) return false;
        if (!name.equals(author.name)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
//        result = 31 * result + (books != null ? books.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Author{" +
                "name='" + name + '\'' +
//                ", books=" + books +
                '}';
    }
}