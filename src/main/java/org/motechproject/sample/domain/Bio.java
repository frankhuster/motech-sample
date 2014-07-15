package org.motechproject.sample.domain;

import org.motechproject.mds.annotations.Entity;
import org.motechproject.mds.annotations.Field;

@Entity
public class Bio {
    @Field Author author;
    @Field private String text;

    public Bio(Author author, String text) {
        this.author = author;
        this.text = text;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Bio)) return false;

        Bio bio = (Bio) o;

        if (author != null ? !author.equals(bio.author) : bio.author != null) return false;
        if (!text.equals(bio.text)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = author != null ? author.hashCode() : 0;
        result = 31 * result + text.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Bio{" +
                "author=" + author +
                ", text='" + text + '\'' +
                '}';
    }
}
