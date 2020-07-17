package com.myfoxit.springframework.spring5webapp.bootstrap;

import com.myfoxit.springframework.spring5webapp.domain.Author;
import com.myfoxit.springframework.spring5webapp.domain.Book;
import com.myfoxit.springframework.spring5webapp.domain.Publisher;
import com.myfoxit.springframework.spring5webapp.repositories.AuthorRepository;
import com.myfoxit.springframework.spring5webapp.repositories.BookRepository;
import com.myfoxit.springframework.spring5webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class BootStrapData  implements CommandLineRunner {
  private final AuthorRepository authorRepository;
  private final BookRepository bookRepository;
  private final PublisherRepository publisherRepository;


  public BootStrapData(
      AuthorRepository authorRepository,
      BookRepository bookRepository,
      PublisherRepository publisherRepository) {
    this.authorRepository = authorRepository;
    this.bookRepository = bookRepository;
    this.publisherRepository = publisherRepository;
  }

  @Override
  public void run(String... args) throws Exception {

    Author eric = new Author("Erik", "Wasmir");
    Book helpMe = new Book("Help me to succeed", "A556H443");
    eric.getBooks().add(helpMe);
    helpMe.getAuthors().add(eric);

    authorRepository.save(eric);
    bookRepository.save(helpMe);

    Author hans = new Author("Hans", "Kaster");
    Book ddd= new Book("Domain driven development", "7776H443");
    hans.getBooks().add(ddd);
    ddd.getAuthors().add(hans);

    authorRepository.save(hans);
    bookRepository.save(ddd);

    Publisher oreily = new Publisher("Oreily", "Sebastol, California");

    ddd.setPublisher(oreily);
    oreily.getBooks().add(ddd);
    publisherRepository.save(oreily);

    helpMe.setPublisher(oreily);
    oreily.getBooks().add(helpMe);

    System.out.println("Started in Bootstrap");
    System.out.printf("Number of books: %d\n",bookRepository.count());
    System.out.printf("Publisher number of books %d\n", oreily.getBooks().size());





  }
}
