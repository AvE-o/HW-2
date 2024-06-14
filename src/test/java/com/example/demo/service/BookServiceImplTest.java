package com.example.demo.service;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import com.example.demo.model.Book;
import com.example.demo.model.Book;
import com.example.demo.repository.BookRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@ExtendWith(MockitoExtension.class)
class BookServiceImplTest {

    @Mock
    private BookRepository bookRepository;

    @InjectMocks
    private BookServiceImpl bookService;

    @Test
    void testSaveBook() {

        Book book = new Book(1L, "Test Book");
        when(bookRepository.save(any(Book.class))).thenReturn(book);

        List<Long> list = new ArrayList<>();
        list.add(1L);
        Book savedBook = bookService.addBook(new Book(),list);
        assertNotNull(savedBook);
        assertEquals("Test Book", savedBook.getTitle());
    }
}
