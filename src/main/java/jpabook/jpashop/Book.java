package jpabook.jpashop;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter @Setter
public class Book {
    private String bookname;
    @Id @GeneratedValue
    private Long index;
    private int cost;
}
