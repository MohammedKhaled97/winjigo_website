package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.time.Duration;

public class CoursesListPage extends BasePage
{
    public CoursesListPage(WebDriver driver) {
        super(driver);
    }
    LoginPage LPO;
    @FindBy(id = "txtCourseSearch")
    public WebElement SearchField;

    @FindBy(xpath = "//*[@id=\"coursediv\"]/div/div/div/div/div[3]/div/div/div/div[4]/ul")
    public WebElement ResultField;

    public void Navigate_2_Courses_List_Page()
    {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        LPO= new LoginPage(driver);
        LPO.BurgerIcon.click();
        LPO.CoursesButton.click();
    }
}
