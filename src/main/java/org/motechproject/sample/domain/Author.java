package org.motechproject.sample.domain;

import org.motechproject.mds.annotations.Entity;
import org.motechproject.mds.annotations.Field;

import javax.jdo.annotations.Unique;
import java.util.Map;

/**
 * Models data for simple records in a portable manner.
 */
@Entity
public class Author {

    @Field(required = true)
    @Unique
    private String name;

    @Field
    private String bio;

    @Field
    private Map<String, String> mapOne;

    @Field
    private Map<String, String> mapTwo;

    @Field
    private Map<String, String> mapThree;

    public Author(String name) {
        this(name, null, null, null, null);
    }

    public Author(String name, String bio, Map<String, String> mapOne, Map<String, String> mapTwo, Map<String, String> mapThree) {
        this.name = name;
        this.bio = bio;
        this.mapOne = mapOne;
        this.mapTwo = mapTwo;
        this.mapThree = mapThree;
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

    public Map<String, String> getMapOne() {
        return mapOne;
    }

    public void setMapOne(Map<String, String> mapOne) {
        this.mapOne = mapOne;
    }

    public Map<String, String> getMapTwo() {
        return mapTwo;
    }

    public void setMapTwo(Map<String, String> mapTwo) {
        this.mapTwo = mapTwo;
    }

    public Map<String, String> getMapThree() {
        return mapThree;
    }

    public void setMapThree(Map<String, String> mapThree) {
        this.mapThree = mapThree;
    }

    @Override
    public String toString() {
        return "Author{" +
                "name='" + name + '\'' +
                ", bio='" + bio + '\'' +
                ", mapOne=" + mapOne +
                ", mapTwo=" + mapTwo +
                ", mapThree=" + mapThree +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Author author = (Author) o;

        return this.toString().equals(author.toString());
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + (bio != null ? bio.hashCode() : 0);
        result = 31 * result + (mapOne != null ? mapOne.hashCode() : 0);
        result = 31 * result + (mapTwo != null ? mapTwo.hashCode() : 0);
        result = 31 * result + (mapThree != null ? mapThree.hashCode() : 0);
        return result;
    }
}