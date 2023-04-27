package org.selenium.patronPageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Base {
    private WebDriver driver;

    public Base(WebDriver driver){
        this.driver=driver;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    public WebDriver chromeDriverConnection(){
        System.setProperty("webdriver.http.factory", "jdk-http-client");
        driver = new ChromeDriver();
        return driver;
    }

    public void enterPage(String url){
        driver.get(url);
    }

    public void exitPage(){
        driver.quit();
    }

    public WebElement searchElement(By locator){
        return driver.findElement(locator);
    }

    public List<WebElement> searchElements(By locator){
        return driver.findElements(locator);
    }

    public String getTextElement(WebElement element){
        return element.getText();
    }

    public String getTextLocator(By locator){
        return driver.findElement(locator).getText();
    }

    public void enterText(String textIn, By locator){
        driver.findElement(locator).sendKeys(textIn);
    }

    public void click(By locator){
        driver.findElement(locator).click();
    }


    public Boolean checkTitle(By locator, String titleExpected){
        return driver.getTitle().equals(titleExpected);
    }


}
