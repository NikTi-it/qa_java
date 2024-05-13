import com.example.Feline;
import com.example.Lion;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;

import java.util.List;

@RunWith(Parameterized.class)
public class LionTest {

    private Lion lion;
    private Feline felineMock;

    private final Boolean hasMane;
    private final String lionSex;

    public LionTest(String lionSex, Boolean hasMane) {
        this.lionSex = lionSex;
        this.hasMane = hasMane;
    }

    @Parameterized.Parameters
    public static Object[][] testData() {
        return new Object[][] {
                {"Самка", false},
                {"Самец", true},
                {"Bobr Kurwa", true}
        };
    }

    @Before
    public void felineMock() {
        felineMock = Mockito.mock(Feline.class);
    }

    @Test
    public void doesHaveManeCheck() {
        try {
            lion = new Lion(lionSex, felineMock);
            Assert.assertEquals(hasMane, lion.doesHaveMane());
        } catch (Exception exception) {
            Assert.assertEquals("Используйте допустимые значения пола животного - самец или самка", exception.getMessage());
        }
    }

    @Test
    public void getKittensCheck() {
        try {
            lion = new Lion(lionSex, felineMock);
            Mockito.when(felineMock.getKittens()).thenReturn(1);
            Assert.assertEquals(1, lion.getKittens());
        } catch (Exception exception) {
            Assert.assertEquals("Используйте допустимые значения пола животного - самец или самка", exception.getMessage());
        }
    }

    @Test
    public void getFoodCheck() {
        try {
            lion = new Lion(lionSex, felineMock);
            Mockito.when(felineMock.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));
            Assert.assertEquals(List.of("Животные", "Птицы", "Рыба"), lion.getFood());
        } catch (Exception exception) {
            Assert.assertEquals("Используйте допустимые значения пола животного - самец или самка", exception.getMessage());
        }
    }
}
