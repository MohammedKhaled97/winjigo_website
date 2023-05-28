package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class AddingCoursesPage extends BasePage
{
    public AddingCoursesPage(WebDriver driver) {
        super(driver);
    }
    public static String CoursesData_Sheet = "Sheet2";
    public static String NewCoursesName_Sheet = "Sheet3";

    @FindBy(id = "btnListAddCourse")
    public WebElement AddCoursesBTN;

//-----------Courses_Basic_Attributes------------------
    @FindBy(id = "txtCourseName")
    public WebElement CourseName;

    @FindBy(id = "courseGrade")
    public WebElement CourseGrade;

    @FindBy(xpath = "//*[@id=\"teacherOnBehalf\"]/div[1]/span/span[1]")
    public WebElement CourseTeacher;

    @FindBy(xpath = "//*[@id=\"ui-select-choices-row-0-0\"]/span")
    public WebElement CourseTeacherName;

    @FindBy(xpath = "//*[@id=\"divCompletionCriteria\"]/div[2]/div/label/em")
    public WebElement CourseCompletionCriteria;

    @FindBy(id = "btnSaveAsDraftCourse")
    public WebElement Create_BTN;

//-----------------------------------------------------

    public void Navigate2AddCourse()
    {
        AddCoursesBTN.click();
    }


}
