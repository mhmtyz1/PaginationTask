package PaginationHelperTests;
import PaginationHelper.PaginationHelper;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;

public class PaginationHelperTest {
    private PaginationHelper helper;
    Logger log=Logger.getLogger(Logger.class);
    @BeforeMethod
    public void setup() {

        helper = new PaginationHelper(Arrays.asList("x", "y", "z", "k", "t", "m","p", "r"), 3);
    }

    @Test(priority = 1, description = "Item count testing", enabled = true)
    public void getItemCount() {
        log.debug("Checking itemcount is not null");
        Assert.assertNotNull(helper.itemCount());
        log.debug("item count should match 8");
        Assert.assertEquals(8, helper.itemCount());
        log.debug("Checking item count should not be equal to a string value");
        Assert.assertNotEquals("a", helper.itemCount());
        log.debug("Checking item count is equal or higher than 0");
        Assert.assertTrue(helper.itemCount()>=0);
    }

    @Test(priority = 2, description = "Testing Page count", enabled = true)
    public void getPageCount() {
        log.debug("Checking page count is not null");
        Assert.assertNotNull(helper.pageCount());
        log.debug("Page count should match 3 based on item numbers");
        Assert.assertEquals(3, helper.pageCount());
        log.debug("Checking page count should not be equal to a string value");
        Assert.assertNotEquals("a", helper.pageCount());
        log.debug("Checking if page count is equal or higher than 0");
        Assert.assertTrue(helper.pageCount()>=0);
    }

    @Test(priority = 3, description = "Test for page item count with different scenarios", enabled = true)
    public void getPageItemCount() {
        log.debug("Checking if first page has only 3 items based on given requirement");
        Assert.assertEquals(3, helper.pageItemCount(0));
        log.debug("Checking if second page has only 3 items");
        Assert.assertEquals(3, helper.pageItemCount(1));
        log.debug("Checking if third page has only 2 items");
        Assert.assertEquals(2, helper.pageItemCount(2));
        //These tests are negative test cases with different scenarios
        Assert.assertNotEquals(-1, helper.pageItemCount(2));
        Assert.assertNotEquals(-1, helper.pageItemCount(0));
        Assert.assertNotEquals("s", helper.pageItemCount(0));
        Assert.assertNotEquals(30, helper.pageItemCount(0));
        Assert.assertNotEquals(60, helper.pageItemCount(0));
        Assert.assertNotEquals(90, helper.pageItemCount(0));
        Assert.assertTrue(Integer.valueOf(helper.pageItemCount(0))!= null);
    }
    /**
     * Pages are zero based index
     */
    @Test(priority = 1, description = "Test for page index with different scenarios", enabled = true)
    public void getPageIndex() {

        Assert.assertEquals(-1, helper.pageIndex(0));
        Assert.assertEquals(0, helper.pageIndex(2));
        Assert.assertEquals(1, helper.pageIndex(3));
        Assert.assertEquals(2, helper.pageIndex(7));
        Assert.assertEquals(-1, helper.pageIndex(-1));
        Assert.assertEquals(-1,helper.pageIndex(9));
        Assert.assertEquals(-1, helper.pageIndex(25));
        Assert.assertEquals(-1,helper.pageIndex(70));
        Assert.assertNotEquals("b",helper.pageIndex(5));
        Assert.assertNotNull(helper.pageIndex(3));
    }

    @AfterMethod
    public void tearDown(){
        helper=null;
    }

}