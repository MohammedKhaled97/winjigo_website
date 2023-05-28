package StepDefinition;

import Pages.AddingCoursesPage;
import Pages.CoursesListPage;
import Pages.LoginPage;
import Tests.BaseTest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class AddingCourseCucumber extends BaseTest
{
    LoginPage Lob;
    AddingCoursesPage CPO;
    CoursesListPage CLO;

    @Given("User Logged-In Successfully")
    public void User_LoggedIn()
    {
        Lob = new LoginPage(driver);
        Lob.Email.sendKeys("testregister@aaa.com");
        Lob.Password.sendKeys("Wakram_123");
        Lob.LoginBTN.click();
    }

    @When("Enter Courses basic data {string} , {string}")
    public void Enter_CourseData(String CourseName , String CourseGrade)
    {
        CPO = new AddingCoursesPage(driver);
        Lob = new LoginPage(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        Lob.BurgerIcon.click();
        Lob.CoursesButton.click();

        CPO.AddCoursesBTN.click();

        CPO.CourseName.sendKeys(CourseName);

        Select GradeDrop = new Select(CPO.CourseGrade);
        GradeDrop.selectByVisibleText(CourseGrade);

        CPO.CourseTeacher.click();
        CPO.CourseTeacherName.click();

        CPO.CourseCompletionCriteria.click();
    }

    @When("Click on Create Course Button")
    public void Click_ON_Create() throws InterruptedException {
        CPO = new AddingCoursesPage(driver);
        CPO.Create_BTN.click();
        Thread.sleep(2000);
    }

    @Then("Course Created Successfully,User Can Search for Created Course {string}")
    public void Search4Course(String CourseName)
    {
        CLO = new CoursesListPage(driver);
        CLO.Navigate_2_Courses_List_Page();

        CLO.SearchField.sendKeys(CourseName);
        CLO.SearchField.sendKeys(Keys.ENTER);

        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(CLO.ResultField));
        Assert.assertTrue(CLO.ResultField.getText().contains(CourseName));
    }

}
