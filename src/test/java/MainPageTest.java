import net.bytebuddy.build.ToStringPlugin;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class MainPageTest {
    private WebDriver driver;
    private MainPage mainPage;

    @Before
    public void setUp(){
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\admin\\IdeaProjects\\pageobjectseleniumtest\\drivers\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("http://github.com");
        mainPage = new MainPage(driver);
    }

    @Test
    public void signInTest(){
        LoginPage loginPage = mainPage.clickSignIn();
        String heading = loginPage.getHeadingText();
        Assert.assertEquals("Sign in to GitHub", heading);
    }

    @Test
    public void registerFailTest(){
        SignUpPage signUpPage = mainPage.register("testuser", "yandex@com.com", "testpass");
        String error = signUpPage.getMainErrorText();
        Assert.assertEquals("There were problems creating your account.", error);

    }
    @Test
    public void signUpEmptyUsernameText(){
        SignUpPage signUpPage = mainPage.register("", "mail", "password");
        String error = signUpPage.getUserNameErrorText();
        Assert.assertEquals("Login can't be blank", error);
    }
    @Test
    public void signUnInvalidEmailTest(){
        SignUpPage signUpPage = mainPage.register("gegwe", "mail", "password");
        String error = signUpPage.getMailText();
        Assert.assertEquals("Email is invalid or already taken", error);
    }

    @After
    public void tearDown(){
        driver.quit();
    }

}
