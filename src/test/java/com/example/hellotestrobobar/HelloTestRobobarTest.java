package com.example.hellotestrobobar;// Generated by Selenium IDE

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class HelloTestRobobarTest {
    private WebDriver driver;
    private Map<String, Object> vars;
    JavascriptExecutor js;

    private By RoboColaIncrementButton = By.cssSelector(".ng-scope:nth-child(1) > td .input-group-append > .btn");
    private By RoboBeerIncrementButton = By.cssSelector(".ng-scope:nth-child(2) > td .input-group-append > .btn");
    private By RobWineIncrementButton = By.cssSelector(".ng-scope:nth-child(3) .input-group-append > .btn");
    private By TotalText = By.cssSelector("tr:nth-child(4) > .ng-binding");
    private By AgeInput = By.id("ageInput");
    private By SuccessButton = By.cssSelector(".btn-success");
    private By AgeAlert = By.cssSelector(".alert > .ng-binding");


    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        js = (JavascriptExecutor) driver;
        vars = new HashMap<String, Object>();
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void onexRobwine() {
        driver.get("http://localhost:3000/");
        driver.manage().window().setSize(new Dimension(1847, 935));
        driver.findElement(RobWineIncrementButton).click();
        assertThat(driver.findElement(TotalText).getText(), is("€3.00"));
    }

    @Test
    public void twoxRoboColaCheckout() {
        driver.get("http://localhost:3000/");
        driver.manage().window().setSize(new Dimension(1847, 935));
        driver.findElement(RoboColaIncrementButton).click();
        driver.findElement(SuccessButton).click();
        {
            WebElement element = driver.findElement(SuccessButton);
            Actions builder = new Actions(driver);
            builder.moveToElement(element).perform();
        }
        driver.findElement(SuccessButton).click();
    }

    @Test
    public void onexRoboCola1xRoboBeer() {
        driver.get("http://localhost:3000/");
        driver.manage().window().setSize(new Dimension(1847, 935));
        driver.findElement(RoboColaIncrementButton).click();
        driver.findElement(RoboBeerIncrementButton).click();
        assertThat(driver.findElement(TotalText).getText(), is("€3.25"));
    }

    @Test
    public void onexRoboCola1xRoboBeer1xRobwine() {
        driver.get("http://localhost:3000/");
        driver.manage().window().setSize(new Dimension(1847, 935));
        driver.findElement(RoboColaIncrementButton).click();
        driver.findElement(RoboBeerIncrementButton).click();
        driver.findElement(RobWineIncrementButton).click();
        assertThat(driver.findElement(TotalText).getText(), is("€6.25"));
    }

    @Test
    public void onexRoboBeer() {
        driver.get("http://localhost:3000/");
        driver.manage().window().setSize(new Dimension(1847, 935));
        driver.findElement(RoboBeerIncrementButton).click();
        assertThat(driver.findElement(TotalText).getText(), is("€2.00"));
    }

    @Test
    public void onexRoboBeerCheckoutLess18() {
        driver.get("http://localhost:3000/");
        driver.manage().window().setSize(new Dimension(1847, 935));
        driver.findElement(RoboBeerIncrementButton).click();
        driver.findElement(SuccessButton).click();
        driver.findElement(AgeInput).click();
        driver.findElement(AgeInput).sendKeys("17");
        driver.findElement(SuccessButton).click();
        assertThat(driver.findElement(AgeAlert).getText(), is("Only adults can buy alcohol!"));
    }

    @Test
    public void onexRoboBeerCheckoutGreater18() {
        driver.get("http://localhost:3000/");
        driver.manage().window().setSize(new Dimension(1847, 935));
        driver.findElement(RoboBeerIncrementButton).click();
        driver.findElement(SuccessButton).click();
        driver.findElement(AgeInput).click();
        driver.findElement(AgeInput).sendKeys("21");
        driver.findElement(SuccessButton).click();
    }

    @Test
    public void onexRoboCola() {
        driver.get("http://localhost:3000/");
        driver.manage().window().setSize(new Dimension(1847, 935));
        driver.findElement(RoboColaIncrementButton).click();
        assertThat(driver.findElement(TotalText).getText(), is("€1.25"));
    }

    @Test
    public void twoxRobwine() {
        driver.get("http://localhost:3000/");
        driver.manage().window().setSize(new Dimension(1847, 935));
        driver.findElement(RobWineIncrementButton).click();
        driver.findElement(RobWineIncrementButton).click();
        assertThat(driver.findElement(TotalText).getText(), is("€6.00"));
    }

    @Test
    public void twoxRoboBeer() {
        driver.get("http://localhost:3000/");
        driver.manage().window().setSize(new Dimension(1847, 935));
        driver.findElement(RoboBeerIncrementButton).click();
        driver.findElement(RoboBeerIncrementButton).click();
        assertThat(driver.findElement(TotalText).getText(), is("€4.00"));
    }

    @Test
    public void twoxRoboCola() {
        driver.get("http://localhost:3000/");
        driver.manage().window().setSize(new Dimension(1847, 935));
        driver.findElement(RoboColaIncrementButton).click();
        driver.findElement(RoboColaIncrementButton).click();
        assertThat(driver.findElement(TotalText).getText(), is("€2.50"));
    }
}
