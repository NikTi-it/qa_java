import com.example.Animal;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.List;

@RunWith(Parameterized.class)
public class ParamAnimalTest {

    private final String animalKind;
    private final List<String> food;

    public ParamAnimalTest(String animalKind, List<String> food) {
        this.animalKind = animalKind;
        this.food = food;
    }

    @Parameterized.Parameters
    public static Object[][] testData() {
        return new Object[][] {
                {"Травоядное", List.of("Трава", "Различные растения")},
                {"Хищник", List.of("Животные", "Птицы", "Рыба")},
                {"Космические жуки", List.of("Неизвестный вид животного, используйте значение Травоядное или Хищник")}
        };
    }


    @Test
    public void getFoodCheck() {
        Animal animal = new Animal();
        try {
            Assert.assertEquals(food, animal.getFood(animalKind));
        } catch (Exception exception) {
            Assert.assertEquals(food.get(0), exception.getMessage());
        }
    }
}
