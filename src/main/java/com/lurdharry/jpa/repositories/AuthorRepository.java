package com.lurdharry.jpa.repositories;

import com.lurdharry.jpa.models.Author;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AuthorRepository extends JpaRepository<Author, Integer>, JpaSpecificationExecutor<Author> {

    @Modifying
    @Transactional
    @Query("update Author a set a.age = :age where a.id = :id")
    void updateAuthor(int age, int id);

    @Modifying
    @Transactional
    @Query("update Author a set a.age = :age")
    void updateAllAuthorAge(int age);

    List<Author> findAllByFirstName(String fn);

    @Query(name = "Author.findByNamedQuery")
    List<Author> findByNamedQuery(@Param("age") int age);
}
