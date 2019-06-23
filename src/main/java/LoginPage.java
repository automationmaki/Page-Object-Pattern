import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    WebDriver driver;

    public LoginPage (WebDriver driver){
            this.driver = driver;
        }

        private By loginField = By.xpath("//*[@id=\"login_field\"]");
        private By passwordField = By.xpath("//*[@id=\"password\"]");
        private By signInButton = By.xpath("//*[@id=\"login\"]/form/div[3]/input[4]");
        private By heading = By.xpath("//*[@id=\"login\"]/form/div[1]/h1");
        private By error = By.xpath("//div[@id='js-flash-container']//div[@class='container']");
        private By createAccLink = By.xpath("//*[@id=\"login\"]/p/a");



        public LoginPage typeLogin(String username){
           driver.findElement(loginField).sendKeys(username);
           return this;
        }
        public LoginPage typePassword(String password){
            driver.findElement(passwordField).sendKeys(password);
            return this;
    }

    public LoginPage loginWithInvalidCreds(String username, String password){
            this.typeLogin(username);
            this.typePassword(password);
            driver.findElement(signInButton).click();
            return new LoginPage(driver);
    }


    public String getHeadingText(){
            return driver.findElement(heading).getText();
    }

    public String getErrorText (){
            return driver.findElement(error).getText();
    }
    public SignUpPage createAccount (){
        driver.findElement(createAccLink).click();
        return new SignUpPage(driver);
    }

}
