package com.myfoxit.springframework.spring5webapp.domain;

import java.util.HashSet;
import java.util.Set;
import javax.annotation.processing.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class Publisher {

  private String name;
  private String address;

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;


  @OneToMany
  private Set<Book> books = new HashSet<>();

  public Publisher() {
  }

  public Publisher(String name, String address) {
    this.name = name;
    this.address = address;
  }


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public Set<Book> getBooks() {
    return books;
  }

  public void setBooks(Set<Book> books) {
    this.books = books;
  }

  @Override
  public String toString() {
    return "Publisher{" +
        "name='" + name + '\'' +
        ", address='" + address + '\'' +
        ", id=" + id +
        '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    Publisher publisher = (Publisher) o;

    return id == publisher.id;
  }

  @Override
  public int hashCode() {
    return (int) (id ^ (id >>> 32));
  }
}
