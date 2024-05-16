import com.example.Feline;
import com.example.Lion;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class LionTest {

    private Feline felineMock;

    @Before
    public void felineMock() {
        felineMock = Mockito.mock(Feline.class);
    }

    @Test
    public void wrongSexExceptionCheck()  {
        String expected = "Используйте допустимые значения пола животного - самец или самка";
        Exception exception = assertThrows(Exception.class, () -> new Lion("Wrong sex", felineMock));
        assertEquals(expected, exception.getMessage());
    }
}
