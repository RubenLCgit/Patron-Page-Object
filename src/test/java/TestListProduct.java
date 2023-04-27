import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.selenium.patronPageObject.ListProduct;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestListProduct {

    private WebDriver driver;
    ListProduct listproduct;

    @BeforeEach
    public void setup(){
        listproduct = new ListProduct(driver);
        driver = listproduct.chromeDriverConnection();
        listproduct.enterPage("https://www.lidl.es/");
    }

    @AfterEach
    public void finishDriver(){
        listproduct.exitPage();
    }

    @Test
    public void testListProducts() throws InterruptedException {
        assertEquals(6,listproduct.ListProducts().size(),"4 products were expected.");
    }
}
