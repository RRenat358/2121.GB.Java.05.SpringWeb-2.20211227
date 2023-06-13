package com.flamexander.book.store;

import com.flamexander.book.store.dto.OrderItemDto;
import com.flamexander.book.store.entities.Author;
import com.flamexander.book.store.entities.Book;
import com.flamexander.book.store.entities.Genre;
import com.flamexander.book.store.services.BookService;
import com.flamexander.book.store.services.CartService;
import org.checkerframework.checker.units.qual.A;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@SpringBootTest
public class CartTest {
    @Autowired
    private CartService cartService;

    @MockBean
    private BookService bookService;

    @BeforeEach
    public void initCart() {
        cartService.clearCart("test_cart");
    }

    @Test
    public void addToCartTest() {
        Book book = new Book();
        book.setId(5L);
        book.setTitle("X");
        book.setPrice(BigDecimal.valueOf(100.0));

        Genre genre = new Genre();
        genre.setTitle("X");
        Author author = new Author();
        author.setName("X");
        book.setGenre(genre);
        book.setAuthor(author);

        Mockito.doReturn(Optional.of(book)).when(bookService).findById(5L);
        cartService.addToCart("test_cart", 5L);
        cartService.addToCart("test_cart", 5L);
        cartService.addToCart("test_cart", 5L);

        Mockito.verify(bookService, Mockito.times(1)).findById(ArgumentMatchers.eq(5L));
        Assertions.assertEquals(1, cartService.getCurrentCart("test_cart").getItems().size());
    }
}