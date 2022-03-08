package entitiesTest;

import com.example.TransactionServiceApplication.entities.Gender;
import com.example.TransactionServiceApplication.entities.MccCode;
import org.junit.Assert;
import org.junit.Test;

public class MccCodeTest {
    MccCode mccCode = new MccCode(1, "ыыы");
    @Test
    public void testGender() {
        Assert.assertNotNull(mccCode);
    }

    @Test
    public void testGetCode() {
        Assert.assertEquals(1, mccCode.getMccCode());
    }

    @Test
    public void testGetDescription() {
        Assert.assertEquals("ыыы", mccCode.getDescription());
    }

    @Test
    public void testSetCode() {
        mccCode.setMccCode(2);
        Assert.assertEquals(2, mccCode.getMccCode());
    }

    @Test
    public void testSetDescription() {
        mccCode.setDescription("sss");
        Assert.assertEquals("sss", mccCode.getDescription());
    }

    @Test
    public void testToString() {
        mccCode.setMccCode(10).setDescription("s");
        Assert.assertEquals("Transaction mcc code[mcc_code = 10, mcc_description = s]", mccCode.toString());
    }

}
