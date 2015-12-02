import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    public WebDriver driver;


    @FindBy (id ="login_field")
    WebElement loginField;

    @FindBy (css = "#password")
    WebElement passwordField;

    @FindBy (xpath = ".//*[@id='login']/form/div[3]/input[3]")
    WebElement signinButton;

    public LoginPage(WebDriver driver){
        this.driver= driver;
        PageFactory.initElements(driver, this);

    }

    public void login (String username, String password){
        loginField.sendKeys(username);
        passwordField.sendKeys(password);
        signinButton.click();
    }

}
