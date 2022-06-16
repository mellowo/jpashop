package jpabook.jpashop;


import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class BookRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public Long save(Book book) {
        entityManager.persist(book);
        return book.getIndex();
    }


}
