import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class SignUpPageTest {
    WebDriver driver;
    SignUpPage signUpPage;

    @Before
    public  void setUp(){
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\admin\\IdeaProjects\\pageobjectseleniumtest\\drivers\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://github.com/join?source=header-home");
        signUpPage  = new SignUpPage (driver);
    }

    @Test
    public void signUpTakenUserName(){
        SignUpPage sp = signUpPage.typeUserName("user");
        String error = sp.getUserNameErrorText();
        Assert.assertEquals("Username is already taken.", error);
    }
    @Test
    public void getHeadingTest(){
        String heading = signUpPage.getHeadingText();
        Assert.assertEquals("Join GitHub", heading);
    }

    @After
    public void tearDown(){
        driver.quit();
    }
}
