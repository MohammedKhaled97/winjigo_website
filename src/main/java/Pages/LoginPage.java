package Pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage
{
    public LoginPage(WebDriver driver)
    {
        super(driver);
    }

    public static  String LoginPageURL = "https://swinji.azurewebsites.net/account/login";
    public static String FileName = "Data/Credintials.xlsx";
    public static String Login_Sheet = "Sheet1";


    @FindBy(id = "Email")
    public WebElement Email;

    @FindBy(id = "inputPassword")
    public WebElement Password;

    @FindBy(id = "btnLogin")
    public WebElement LoginBTN;

    @FindBy(xpath = "//*[@id=\"btnMinifyMe\"]/em")
    public WebElement BurgerIcon;

    @FindBy(xpath = "//*[@id=\"btnMyCoursesList\"]/span")
    public WebElement CoursesButton;

}
