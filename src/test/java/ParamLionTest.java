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
public class ParamLionTest {

    private Lion lion;
    private Feline felineMock;

    private final Boolean hasMane;
    private final String lionSex;

    public ParamLionTest(String lionSex, Boolean hasMane) {
        this.lionSex = lionSex;
        this.hasMane = hasMane;
    }

    @Parameterized.Parameters
    public static Object[][] testData() {
        return new Object[][] {
                {"Самка", false},
                {"Самец", true}
        };
    }

    @Before
    public void felineMock() {
        felineMock = Mockito.mock(Feline.class);
    }

    @Test
    public void doesHaveManeCheck() throws Exception {
            lion = new Lion(lionSex, felineMock);
            Assert.assertEquals(hasMane, lion.doesHaveMane());
    }

    @Test
    public void getKittensCheck() throws Exception {
            lion = new Lion(lionSex, felineMock);
            Mockito.when(felineMock.getKittens()).thenReturn(1);
            Assert.assertEquals(1, lion.getKittens());
    }

    @Test
    public void getFoodCheck() throws Exception {
            lion = new Lion(lionSex, felineMock);
            Mockito.when(felineMock.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));
            Assert.assertEquals(List.of("Животные", "Птицы", "Рыба"), lion.getFood());
    }
}
