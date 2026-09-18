import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BankAccountTest {

    BankAccount myAccount;
    BankAccount yourAccount;

    @BeforeEach
    void setUp() {
        //arrange
        myAccount = new BankAccount("Josh", 100.0);
        yourAccount = new BankAccount("You", 1000.0);
    }

    @AfterEach
    void tearDown() {
        myAccount = null;
        yourAccount = null;
    }

    @Test
    void testCloseAccount() {

    }

    @Test
    void testDeposit() {
        //act
        myAccount.deposit(10.0);
        //assert
        double expectedBehavior = 110.0;
        double actualBehavior = myAccount.getBalance();
        assertEquals(expectedBehavior, actualBehavior, 0.001);
    }

    @Test
    void testGetBalance() {

    }

    @Test
    void testGetOwner() {

    }

    @Test
    void testIsActive() {

    }

    @Test
    void testTransferTo() {

    }

    @Test
    void testWithdraw() {
        //act
        myAccount.withdraw(10.0);
        //assert
        double expectedBehavior = 90.0;
        double actualBehavior = myAccount.getBalance();
        assertEquals(expectedBehavior, actualBehavior, 0.001);
    }
}
