package atm;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DepositStep {

    private ProductCatalog catalog;
    private Order order;

    @Before
    public void setup() {
        account = new Account(); 
    }

    @Given("Money in account is (.+) Baht")
    public void money_in_account(double money) {
        account.addMoney(money);
    }

    @When("I deposit (.+) Baht into account")
    public void i_deposit(int money) {
        account.deposit(money);
    }

    @Then("Money in account should be (.+) Baht")
    public void total_money(double total) {
        assertEquals(total, account.getTotal());
    }
}