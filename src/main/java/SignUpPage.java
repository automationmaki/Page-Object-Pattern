import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignUpPage {


    WebDriver driver;

    public SignUpPage(WebDriver driver) {
        this.driver = driver;
    }

    private By heading = By.xpath("/html/body/div[4]/main/div/div/div[1]/h1");
    private By signUpButton = By.xpath("//*[@id=\"signup_button\"]");
    private By userNameField = By.xpath("//*[@id=\"user_login\"]");
    private By emailField = By.xpath("//*[@id=\"user_email\"]");
    private By passwordField = By.xpath("//*[@id=\"user_password\"]");
    private By mainError = By.xpath("//*[@id=\"signup-form\"]/div[1]");
    private By userNameError = By.xpath("//*[@id=\"description_9f8d7c4d65f5\"]");
    private By emailError = By.xpath("//*[@id=\"description_2ca18e7ba6fc\"]");



    public SignUpPage typeUserName (String username){
        driver.findElement(userNameField).sendKeys(username);
        return this;
    }
    public SignUpPage typePassword (String password){
        driver.findElement(passwordField).sendKeys(password);
        return this;
    }
    public SignUpPage typeEmail (String email){
        driver.findElement(emailField).sendKeys(email);
        return this;
    }

    public SignUpPage registerWithInvalidCreds(String username, String email, String password){
        this.typeUserName(username);
        this.typePassword(email);
        this.typeEmail(password);
        driver.findElement(signUpButton).click();
        return new SignUpPage(driver);
    }

    public String getHeadingText(){
        return driver.findElement(heading).getText();
    }

    public String getMainErrorText (){
        return driver.findElement(mainError).getText();
    }
    public String getUserNameErrorText (){
        return driver.findElement(userNameError).getText();
    }
    public String getMailText (){
        return driver.findElement(emailError).getText();
    }

}
