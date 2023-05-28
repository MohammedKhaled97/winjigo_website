package Tests;

import Pages.AddingCoursesPage;
import Pages.LoginPage;
import Utilities.HelperFunc;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;

public class AddCourse extends BaseTest
{

    AddingCoursesPage CPO;

    @Test(priority = 1)
    public void Navigate_2_Adding_Courses()
    {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        CPO = new AddingCoursesPage(driver);
        CPO.Navigate2AddCourse();
    }

    @Test(priority = 2,dataProvider = "ReadCourseData")
    public void Fill_Course_Data(String CoursName, String CoursGrade ) throws InterruptedException, IOException {

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        CPO = new AddingCoursesPage(driver);
        Lob = new LoginPage(driver);
        HFob =new HelperFunc(driver);

///---------To Pass TC Every Time while adding Course Cause Course Name is Unique------
     String NewCourseName =CoursName+randomAlphabetic(5);
        CPO.CourseName.sendKeys(NewCourseName);
        System.out.println(NewCourseName);

//----------To Save Added Course Name into Excel Sheet For Assertion -------------------
        HFob.WriteDataToSheet(Lob.FileName,CPO.NewCoursesName_Sheet,NewCourseName);
//--------------------------------------------------------------------------------------

        Select GradeDrop = new Select(CPO.CourseGrade);
        GradeDrop.selectByVisibleText(CoursGrade);

        CPO.CourseTeacher.click();
        CPO.CourseTeacherName.click();

        CPO.CourseCompletionCriteria.click();
         CPO.Create_BTN.click();
         Thread.sleep(2000);
    }

    @DataProvider
    public Object[][] ReadCourseData() throws IOException {
        HFob = new HelperFunc(driver);
        Lob = new LoginPage(driver);
        CPO = new AddingCoursesPage(driver);
        return HFob.ReadData(Lob.FileName, CPO.CoursesData_Sheet);
    }

}
