import com.example.Cat;
import com.example.Feline;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class CatTest {

    private Cat cat;

    @Mock
    Feline felineMock;

    @Before
    public void createCatWithMock() {
        this.cat = new Cat(felineMock);
    }

    @Test
    public void getSoundCheck() {
        Assert.assertEquals("Мяу", cat.getSound());
    }

    @Test
    public void getFoodCheck() throws Exception {
        Mockito.when(felineMock.eatMeat()).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        Assert.assertEquals(List.of("Животные", "Птицы", "Рыба"),cat.getFood());
    }
}
