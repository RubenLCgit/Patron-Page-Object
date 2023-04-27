package org.selenium.patronPageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ListProduct extends Base{

    By cookies = By.xpath("//button[@class='cookie-alert-extended-button']");
    By searchProduct = By.cssSelector("input#mainsearch-input");
    By acceptSearch = By.cssSelector("button.primary");

    By listElements = By.cssSelector("div[class='plp-product-grid-box-tile__title']");


    public ListProduct(WebDriver driver) {
        super(driver);
    }

    public List<WebElement> ListProducts() throws InterruptedException {
        enterPage("https://www.lidl.es/");
        Thread.sleep(2000);
        click(cookies);
        enterText("maleta",searchProduct);
        Thread.sleep(2000);
        click(acceptSearch);
        List<WebElement> products = searchElements(listElements);
        for(WebElement countProducts : products){
            System.out.println("Producto = "+countProducts.getText());
        }
        return products;
    }



}
