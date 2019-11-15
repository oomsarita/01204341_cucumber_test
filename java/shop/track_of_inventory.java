package shop;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class KeepTrackStep {

    private ProductCatalog catalog;
    private Order order;

    @Before
    public void setup() {
        catalog = new ProductCatalog();
        stock = new ProductStock();
    }

    @Given("product (.+) with quanity (.+) in stock")
    public void a_product_with_quantity_instock(String name, double quant) {
        Product prod = catalog.getProduct(name);
        stock.addProduct(prod, quant);
    }

    @When("customer buy (.+) with quantity (.+)")
    public void customer_buy_with_quantity(String name, int quant) {
        Product prod = catalog.getProduct(name);
        stock.sellItem(prod, quant);
    }

    @Then("product (.+) quanity in stock should be (.+)")
    public void total_should_be(String name, int total) {
        Product prod = catalog.getProduct(name);
        assertEquals(total, stock.getTotal(prod));
    }

    @When("I order (.+) with quantity (.+)")
    public void order_product(String name, int quant) {
        Product prod = catalog.getProduct(name);
        stock.reorederItem(prod, quant);
    }

    @Then("product (.+) quanity in stock should be (.+)")
    public void reorder_total_should_be(String name, int total) {
        Product prod = catalog.getProduct(name);
        assertEquals(total, stock.getTotal(prod));
    }
}