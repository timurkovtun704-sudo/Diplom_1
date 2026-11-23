import org.junit.Before;
import org.junit.Test;
import praktikum.Bun;
import praktikum.Database;
import praktikum.Ingredient;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class DatabaseTest {

    private Database database;

    @Before
    public void setUp() {
        database = new Database();
    }
    @Test
    public void availableBunsReturnsDefaultBunsList() {
        List<Bun> buns = database.availableBuns();
        assertFalse(buns.isEmpty());
        assertEquals(3, buns.size());
        assertEquals("black bun", buns.get(0).getName());
    }
    @Test
    public void availableIngredientsReturnsDefaultIngredientsList() {
        List<Ingredient> ingredients = database.availableIngredients();
        assertFalse(ingredients.isEmpty());
        assertEquals(6, ingredients.size());
        assertEquals("hot sauce", ingredients.get(0).getName());
    }
}
