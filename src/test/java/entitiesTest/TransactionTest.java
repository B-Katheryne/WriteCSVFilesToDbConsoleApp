package entitiesTest;
import com.example.TransactionServiceApplication.entities.Transaction;
import org.junit.Assert;
import org.junit.Test;

public class TransactionTest {
    Transaction transaction = new Transaction(1, "10.10.22", 2, 3, 1.2, "6B");
    @Test
    public void testGender() {
        Assert.assertNotNull(transaction);
    }

    @Test
    public void testGetId() {
        Assert.assertEquals(1, transaction.getId());
    }

    @Test
    public void testGetDatetime() {
        Assert.assertEquals("10.10.22", transaction.getDatetime());
    }

    @Test
    public void testGetMccCode() {
        Assert.assertEquals(2, transaction.getMccCode());
    }

    @Test
    public void testGetType() {
        Assert.assertEquals(3, transaction.getType());
    }

    @Test
    public void testGetAmount() {
        Assert.assertEquals(1.2, transaction.getAmount(), 0);
    }

    @Test
    public void testGetTermId() {
        Assert.assertEquals("6B", transaction.getTermId());
    }

    @Test
    public void testToString() {
        Assert.assertEquals("Transaction[customer_id = 1, datetime = 10.10.22, mcc_code = 2, tr_type = 3, amount = 1,2, term_id = 6B]", transaction.toString());
    }
}
