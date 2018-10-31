package com.taniel.udemyWebApp.repositories;

import com.taniel.udemyWebApp.model.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
