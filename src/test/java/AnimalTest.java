import com.example.Animal;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class AnimalTest {

    @Test
    public void getFamilyCheck() {
        Animal animal = new Animal();
        Assert.assertEquals("Существует несколько семейств: заячьи, беличьи, мышиные, кошачьи, псовые, медвежьи, куньи", animal.getFamily());
    }

    @Test
    public void wrongAnimalTypeExceptionCheck()  {
        String expected = "Неизвестный вид животного, используйте значение Травоядное или Хищник";
        Exception exception = assertThrows(Exception.class, () -> new Animal().getFood("Wrong animal type"));
        assertEquals(expected, exception.getMessage());
    }
}
