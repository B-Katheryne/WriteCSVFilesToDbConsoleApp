package entitiesTest;

import com.example.TransactionServiceApplication.entities.MccCode;
import com.example.TransactionServiceApplication.entities.TransactionType;
import org.junit.Assert;
import org.junit.Test;

public class TransactionTypeTest {
    TransactionType type = new TransactionType(1, "ыыы");
    @Test
    public void testTransactionType() {
        Assert.assertNotNull(type);
    }

    @Test
    public void testGetType() {
        Assert.assertEquals(1, type.getType());
    }

    @Test
    public void testGetDescription() {
        Assert.assertEquals("ыыы", type.getDescription());
    }

    @Test
    public void testSetType() {
        type.setType(2);
        Assert.assertEquals(2, type.getType());
    }

    @Test
    public void testSetDescription() {
        type.setDescription("sss");
        Assert.assertEquals("sss", type.getDescription());
    }

    @Test
    public void testToString() {
        type.setType(10).setDescription("s");
        Assert.assertEquals("TransactionType[tr_type = 10, tr_description = s]", type.toString());
    }
}
