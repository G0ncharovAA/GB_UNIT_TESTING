import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

public class BookServiceTest {
    
    private BookRepository bookRepository;

    private BookService bookService;

    @Before
    public void setUp() {
        bookRepository = mock(BookRepository.class);
        
        when(bookRepository.findById("1"))
                .thenReturn(new Book("1", "Book1", "Author1"));
        when(bookRepository.findAll())
                .thenReturn(Arrays.asList(
                        new Book("1", "Book1", "Author1"),
                        new Book("2", "Book2", "Author2")
                ));

        bookService = new BookService(bookRepository);
    }

    @Test
    public void testFindBookById() {
        Book book = new Book("1", "Book1", "Author1");
        
        when(bookRepository.findById("1")).thenReturn(book);
        
        Book result = bookService.findBookById("1");
        assertEquals(book, result);
        
        verify(bookRepository, times(1)).findById("1");
    }

    @Test
    public void testFindAllBooks() {
        
        List<Book> books = Arrays.asList(
                new Book("1", "Book1", "Author1"),
                new Book("2", "Book2", "Author2")
        );
        
        
        when(bookRepository.findAll()).thenReturn(books);
        
        List<Book> result = bookService.findAllBooks();
        assertEquals(books, result);
        
        verify(bookRepository, times(1)).findAll();
    }
}
