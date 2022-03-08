package entitiesTest;

import com.example.TransactionServiceApplication.entities.Gender;
import org.junit.Assert;
import org.junit.Test;

public class GenderTest {
    Gender gender = new Gender(1, 3);
    @Test
    public void testGender() {
        Assert.assertNotNull(gender);
    }

    @Test
    public void testGetCustomerId() {
        Assert.assertEquals(1, gender.getCustomerId());
    }

    @Test
    public void testGetGender() {
        Assert.assertEquals(3, gender.getGender());
    }

    @Test
    public void testSetGender() {
        gender.setGender(2);
        Assert.assertEquals(2, gender.getGender());
    }

    @Test
    public void testSetCustomerId() {
        gender.setCustomer_id(10);
        Assert.assertEquals(10, gender.getCustomerId());
    }

    @Test
    public void testToString() {
        gender.setGender(2);
        gender.setCustomer_id(4);
        Assert.assertEquals("Gender[customer_id = 4, gender = 2]", gender.toString());
    }
}
