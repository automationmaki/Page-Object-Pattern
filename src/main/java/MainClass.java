import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class MainClass {

    static WebDriver driver;
    public static void main(String[] args) {
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\admin\\IdeaProjects\\pageobjectseleniumtest\\drivers\\geckodriver.exe");

        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("http://github.com");

//        MainPage mainPage = new MainPage(driver);
        MainPage mainPage = PageFactory.initElements(driver, MainPage.class);



        mainPage.register("testusername", "yandex@ru.com", "test123");
    }
}
