import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BunTest {
    private final String name;
    private final float price;

    public BunTest(String name, float price)
    {
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters(name = "Тестовые данные: название = {0}, цена = {1}")
    public static Object[][] getBunData(){
        return new Object[][]
        {
            {"Чёрная булка", 187.5f },
            {"Светлая булка", 200f},
            {"", 0f},
            {null, -23f}
        };
    }

    @Test
    public void getNameReturnsCorrectName()
    {
        Bun bun = new Bun(name, price);
        assertEquals(name, bun.getName());
    }

    @Test
    public void getPriceReturnsCorrectPrice()
    {
        Bun bun = new Bun(name, price);
        assertEquals(price, bun.getPrice(), 0.00f);
    }
}
