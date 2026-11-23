import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;
import static org.junit.Assert.assertEquals;
import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;
@RunWith(Parameterized.class)
public class IngredientTest {
    private final IngredientType type;
    private final String name;
    private final float price;
    public IngredientTest(IngredientType type, String name, float price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }
    @Parameterized.Parameters(name = "Тип = {0}, название = {1}, цена = {2}")
    public static Object[][] getIngredientData() {
        return new Object[][]{
                {SAUCE, "hot sauce", 100f},
                {FILLING, "cutlet", 250.5f},
                {SAUCE, "", 0f},
                {null, null, -10f}
        };
    }
    @Test
    public void getTypeReturnsCorrectType() {
        Ingredient ingredient = new Ingredient(type, name, price);
        assertEquals(type, ingredient.getType());
    }
    @Test
    public void getNameReturnsCorrectName() {
        Ingredient ingredient = new Ingredient(type, name, price);
        assertEquals(name, ingredient.getName());
    }
    @Test
    public void getPriceReturnsCorrectPrice() {
        Ingredient ingredient = new Ingredient(type, name, price);
        assertEquals(price, ingredient.getPrice(), 0.001f);
    }
}
