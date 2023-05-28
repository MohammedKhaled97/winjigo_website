Feature: Adding Course
  I want to Check That User is able to Add new Course Successfully and search for it
 Scenario Outline: Adding New Course Successfully
    Given User Logged-In Successfully
    When Enter Courses basic data "<CourseName>" , "<CourseGrade>"
    And  Click on Create Course Button
    Then Course Created Successfully,User Can Search for Created Course "<CourseName>"
   Examples:
     |CourseName               |CourseGrade|
     |Test1                    |3          |



