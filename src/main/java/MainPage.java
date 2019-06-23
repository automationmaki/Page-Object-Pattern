import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage {
    private WebDriver driver;

    public MainPage(WebDriver driver){
        this.driver = driver;
    }



    @FindBy(xpath = "/html/body/div[1]/header/div/div[2]/div[2]/a[1]")
    private WebElement signInButton;
    @FindBy(xpath = "/html/body/div[1]/header/div/div[2]/div[2]/a[2]")
    private WebElement signUpButton;
    @FindBy(xpath = "//*[@id=\"user[login]\"]")
    private WebElement userNameField;
    @FindBy(xpath = "//*[@id=\"user[email]\"]")
    private WebElement emailField;
    @FindBy(xpath = "//*[@id=\"user[password]\"]")
    private WebElement passwordField;
    @FindBy(xpath = "/html/body/div[4]/main/div[1]/div/div/div[2]/div/form/button")
    private WebElement signUpFormButton;

    public LoginPage clickSignIn(){
        signInButton.click();
        return new LoginPage(driver);
    }

    public SignUpPage clickSignUpButton(){
        signUpButton.click();
        return new SignUpPage(driver);
    }
    public SignUpPage clickSignUpFormButton(){
        signUpFormButton.click();
        return new SignUpPage(driver);
    }


    public MainPage typeUserName (String username){
        userNameField.sendKeys(username);
        return this;
    }
    public MainPage typePassword (String password){
        passwordField.sendKeys(password);
        return this;
    }
    public MainPage typeEmail (String email){
        emailField.sendKeys(email);
        return this;
    }


    public SignUpPage register (String username, String email, String password){
        this.typeUserName(username);
        this.typeEmail(email);
        this.typePassword(password);
        this.clickSignUpFormButton();
        return new SignUpPage(driver);
    }


}
