package com.taniel.udemyWebApp.repositories;

import com.taniel.udemyWebApp.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
