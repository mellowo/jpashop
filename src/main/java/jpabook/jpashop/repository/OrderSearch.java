package jpabook.jpashop.repository;

import jpabook.jpashop.domain.OrderStatus;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class OrderSearch {
    private String memeberName;
    private OrderStatus orderStatus;

    public CharSequence getMemberName() {
    }
}
