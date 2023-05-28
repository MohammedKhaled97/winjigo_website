package Tests;

import Pages.LoginPage;
import org.testng.annotations.Test;

import java.time.Duration;

public class CoursesExpand extends BaseTest
{
    LoginPage LPO;

    @Test
    public void CoursesExpand() throws InterruptedException {
        LPO = new LoginPage(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        LPO.BurgerIcon.click();
        LPO.CoursesButton.click();
    }
}
