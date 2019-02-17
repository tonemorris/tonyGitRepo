/**
 * 
 */
package dashboard.com.tivo.ui.controller;


import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.MockitoAnnotations.initMocks;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.tivo.ui.controller.BookController;
import com.tivo.ui.domain.Book;
import com.tivo.ui.service.BookService;



/**
 * @author anthonymorris
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class BookControllerTest {
	
	@InjectMocks
	private BookController bookController;
	
	@Mock
	private BookService bookService;
	
	@Test
    public void shouldReturnBooksForAuthor() throws Exception {
		List<Book> books = Arrays.asList(new Book("First", "A"));
		
		//given
        given(bookService.findByName("First")).willReturn(books);

        //when
        List<Book> actualBooks = bookController.findByName("First");

        //then
        assertThat(actualBooks.get(0).getAuthor(), is("A"));
    }

}
