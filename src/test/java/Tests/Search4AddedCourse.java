package Tests;

import Pages.AddingCoursesPage;
import Pages.CoursesListPage;
import Pages.LoginPage;
import Utilities.HelperFunc;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;

public class Search4AddedCourse extends BaseTest
{
    CoursesListPage CLO;
    AddingCoursesPage CPO;

    @Test(priority = 0)
    public void Navigate_2_Courses_List_Page()
    {
        CLO = new CoursesListPage(driver);
        CLO.Navigate_2_Courses_List_Page();
    }

    @Test(priority = 1,dataProvider = "ReadCourseName")
    public void Search_4_Added_Course(String CourseName)
    {
        CLO = new CoursesListPage(driver);
        CLO.SearchField.sendKeys(CourseName);
        CLO.SearchField.sendKeys(Keys.ENTER);
//        System.out.println(CourseName);
//        System.out.println(CLO.ResultField.getText());
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(CLO.ResultField));
        Assert.assertTrue(CLO.ResultField.getText().contains(CourseName));

    }

    @DataProvider
    public Object[][] ReadCourseName() throws IOException {
        HFob = new HelperFunc(driver);
        CPO = new AddingCoursesPage(driver);
        Lob = new LoginPage(driver);
        return HFob.ReadData(Lob.FileName,CPO.NewCoursesName_Sheet);
    }
}
