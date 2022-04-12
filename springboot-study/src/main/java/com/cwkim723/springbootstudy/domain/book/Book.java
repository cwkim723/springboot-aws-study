package com.cwkim723.springbootstudy.domain.book;

import com.cwkim723.springbootstudy.exception.NotEnoughStockException;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
@Builder
@AllArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 500, nullable = false)
    private String title;

    @Column(length = 100, nullable = false)
    private String author;

    @Column(nullable = false)
    private int stockQuantity;

    //==비즈니스 로직==//
    /**
     * 책 정보 업데이트
     * @param title
     * @param author
     * @param stockQuantity
     */
    public void update(String title, String author, int stockQuantity){
        this.title = title;
        this.author = author;
        this.stockQuantity = stockQuantity;
    }

    /**
     * stock 증가
     */
    public void addStock(int quantity){
        this.stockQuantity += quantity;
    }

    /**
     * stock 감소
     */
    public void removeStock(int quantity){
        int restStock = this.stockQuantity - quantity;
        if(restStock < 0){
            throw new NotEnoughStockException("가능한 대출 권수가 부족합니다.");
        }
        this.stockQuantity = restStock;
    }
}
