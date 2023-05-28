package Tests;

import Pages.LoginPage;
import Utilities.HelperFunc;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class ValidLogin extends BaseTest
{
    HelperFunc HFob;
    LoginPage Lob;

    @Test(dataProvider = "ReadValidCredentials")
    public void ValidLogin(String UserID, String Pass) throws InterruptedException {
        Lob = new LoginPage(driver);
        Lob.Email.sendKeys(UserID);
        Lob.Password.sendKeys(Pass);
        Lob.LoginBTN.click();
    }

    @DataProvider
    public Object[][] ReadValidCredentials() throws IOException {
        HFob = new HelperFunc(driver);
        return HFob.ReadData(Lob.FileName, Lob.Login_Sheet);
    }
}
