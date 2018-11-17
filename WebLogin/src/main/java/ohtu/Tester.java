package ohtu;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import java.util.Random;


public class Tester {
    public static void simpleLogin(){
        WebDriver driver = new HtmlUnitDriver();
        driver.get("http://localhost:4567");
        
        System.out.println(driver.getPageSource());
        sleep(2);
        
        WebElement element = driver.findElement(By.linkText("login"));
        element.click();

        System.out.println(driver.getPageSource());
        sleep(2);

        element = driver.findElement(By.name("username"));
        element.sendKeys("pekka");
        element = driver.findElement(By.name("password"));
        element.sendKeys("akkep");
        element = driver.findElement(By.name("login"));
        
        System.out.println(driver.getPageSource());
        sleep(2);
        element.submit();

        System.out.println(driver.getPageSource());
        sleep(3);
        
        driver.quit();
    }

    public static void failLoginInvalidPassword(){
        WebDriver driver = new HtmlUnitDriver();
        driver.get("http://localhost:4567");
        
        System.out.println(driver.getPageSource());
        sleep(2);
        
        WebElement element = driver.findElement(By.linkText("login"));
        element.click();

        System.out.println(driver.getPageSource());
        sleep(2);

        element = driver.findElement(By.name("username"));
        element.sendKeys("pekka");
        element = driver.findElement(By.name("password"));
        element.sendKeys("akkep ");
        element = driver.findElement(By.name("login"));
        
        System.out.println(driver.getPageSource());
        sleep(2);
        element.submit();

        System.out.println(driver.getPageSource());
        sleep(3);
        
        driver.quit();
    }

    public static void failLoginInvalidUser(){
        WebDriver driver = new HtmlUnitDriver();
        driver.get("http://localhost:4567");
        
        System.out.println(driver.getPageSource());
        sleep(2);
        
        WebElement element = driver.findElement(By.linkText("login"));
        element.click();

        System.out.println(driver.getPageSource());
        sleep(2);

        element = driver.findElement(By.name("username"));
        element.sendKeys("öÖÖÅÅÄÄäåååÅÅÅÅ");
        element = driver.findElement(By.name("password"));
        element.sendKeys("akkep");
        element = driver.findElement(By.name("login"));
        
        System.out.println(driver.getPageSource());
        sleep(2);
        element.submit();

        System.out.println(driver.getPageSource());
        sleep(3);
        
        driver.quit();
    }


    public static void newUser(){
        WebDriver driver = new HtmlUnitDriver();
        driver.get("http://localhost:4567");
        
        System.out.println(driver.getPageSource());
        sleep(2);
        
        WebElement element = driver.findElement(By.linkText("register new user"));
        element.click();

        System.out.println(driver.getPageSource());
        sleep(2);

        Random r = new Random();
        String username="yhyy "+r.nextInt(100000);
        String password="qwerty";

        element = driver.findElement(By.name("username"));
        element.sendKeys(username);
        element = driver.findElement(By.name("password"));
        element.sendKeys(password);
        element = driver.findElement(By.name("passwordConfirmation"));
        element.sendKeys(password);
        element = driver.findElement(By.name("signup"));
        
        System.out.println(driver.getPageSource());
        sleep(2);
        element.submit();

        System.out.println(driver.getPageSource());
        sleep(3);

        element = driver.findElement(By.linkText("continue to application mainpage"));
        element.click();
        System.out.println(driver.getPageSource());
        sleep(3);

        element = driver.findElement(By.linkText("logout"));
        element.click();
        System.out.println(driver.getPageSource());
        sleep(3);

        driver.quit();
    }
    public static void main(String[] args) {
        /*
        System.out.println("Test login");
        sleep(1);
        simpleLogin();
        System.out.println("Login tested.");
        sleep(5);

        System.out.println("Test fail login invalid password");
        sleep(1);
        failLoginInvalidPassword();
        System.out.println("Fail login invalid password tested.");
        sleep(5);

        System.out.println("Test fail login invalid user");
        sleep(1);
        failLoginInvalidUser();
        System.out.println("Fail login invalid user tested.");
        sleep(5);
        */

        System.out.println("Test create new user");
        sleep(1);
        newUser();
        System.out.println("Test create new user tested.");
        sleep(5);

    }
    
    private static void sleep(int n){
        try{
            Thread.sleep(n*1000);
        } catch(Exception e){}
    }
}
