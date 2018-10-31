package com.taniel.udemyWebApp.bootstrap;

import com.taniel.udemyWebApp.model.Author;
import com.taniel.udemyWebApp.model.Book;
import com.taniel.udemyWebApp.model.Publisher;
import com.taniel.udemyWebApp.repositories.AuthorRepository;
import com.taniel.udemyWebApp.repositories.BookRepository;
import com.taniel.udemyWebApp.repositories.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository=publisherRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData() {
        //Eric
        Author eric = new Author("Eric", "Evans");
        Publisher publisher1 = new Publisher();
        publisher1.setName("asd");
        Book  ddd = new Book("Domain Driven Design", "1234", publisher1);
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);
        publisherRepository.save(publisher1);
        authorRepository.save(eric);
        bookRepository.save(ddd);



        //Rod
        Author rod = new Author("Rod", "Johnson");
        Publisher publisher2 = new Publisher();
        publisher2.setName("das");
        Book noEJB = new Book("J2EE Development without EJB", "23444", publisher2);
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);

        publisherRepository.save(publisher2);
        authorRepository.save(rod);
        bookRepository.save(noEJB);

    }
}
