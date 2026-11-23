import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;
import static org.junit.Assert.assertEquals;
@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    private Burger burger;
    @Mock
    private Bun bun;
    @Mock
    private Ingredient firstIngredient;
    @Mock
    private Ingredient secondIngredient;
    @Before
    public void setUp() {
        burger = new Burger();
    }
    @Test
    public void setBunsSetsCorrectBun() {
        burger.setBuns(bun);
        assertEquals(bun, burger.bun);
    }
    @Test
    public void addIngredientIncreasesListSize() {
        burger.addIngredient(firstIngredient);
        assertEquals(1, burger.ingredients.size());
    }
    @Test
    public void removeIngredientDeletesElementByIndex() {
        burger.addIngredient(firstIngredient);
        burger.addIngredient(secondIngredient);
        burger.removeIngredient(0);
        assertEquals(1, burger.ingredients.size());
        assertEquals(secondIngredient, burger.ingredients.get(0));
    }

    @Test
    public void moveIngredientSwapsIngredients() {
        burger.addIngredient(firstIngredient);
        burger.addIngredient(secondIngredient);
        burger.moveIngredient(0, 1);
        assertEquals(secondIngredient, burger.ingredients.get(0));
        assertEquals(firstIngredient, burger.ingredients.get(1));
    }

    @Test
    public void getPriceReturnsTotalPrice() {
        Mockito.when(bun.getPrice()).thenReturn(100f);
        Mockito.when(firstIngredient.getPrice()).thenReturn(50f);
        Mockito.when(secondIngredient.getPrice()).thenReturn(150f);
        burger.setBuns(bun);
        burger.addIngredient(firstIngredient);
        burger.addIngredient(secondIngredient);
        assertEquals(400f, burger.getPrice(), 0.001f);
        Mockito.verify(bun, Mockito.times(1)).getPrice();
    }

    @Test
    public void getReceiptReturnsFormattedReceipt() {
        Mockito.when(bun.getName()).thenReturn("black bun");
        Mockito.when(bun.getPrice()).thenReturn(100f);
        Mockito.when(firstIngredient.getType()).thenReturn(IngredientType.SAUCE);
        Mockito.when(firstIngredient.getName()).thenReturn("hot sauce");
        Mockito.when(firstIngredient.getPrice()).thenReturn(50f);
        Mockito.when(secondIngredient.getType()).thenReturn(IngredientType.FILLING);
        Mockito.when(secondIngredient.getName()).thenReturn("cutlet");
        Mockito.when(secondIngredient.getPrice()).thenReturn(200f);
        burger.setBuns(bun);
        burger.addIngredient(firstIngredient);
        burger.addIngredient(secondIngredient);
        String expectedReceipt = String.format(
                "(==== black bun ====)%n" +
                        "= sauce hot sauce =%n" +
                        "= filling cutlet =%n" +
                        "(==== black bun ====)%n" +
                        "%nPrice: %f%n", 450f
        );
        assertEquals(expectedReceipt, burger.getReceipt());
    }
}

