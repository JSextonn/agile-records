package script

import users.students.Course
import users.students.Grade
import users.students.Student
import database.Populator
import util.MathUtil

/**
 * Class containing tests involving Populator script.
 */
class PopulatorTests extends GroovyTestCase {
    // Passed
    void testGetRandomInt() {
        int min = 0
        int max = 10
        int randomInt = MathUtil.getRandomInt(min, max)
        // println(randomInt)
        assertTrue(randomInt >= min && randomInt <= max)

    }

    // Passed
    void testGetRandomDouble() {
        int min = 0.0
        int max = 100.5
        double randomDouble = MathUtil.getRandomDouble(min, max)
        // println(randomDouble)
        assertTrue(randomDouble >= min && randomDouble <= max)

    }

    // Passed
    void testGenerateGrade() {
        Grade testGrade = Populator.generateGrade()
        // println(testGrade.getScore())
        assertTrue(testGrade.getScore() >= 50 && testGrade.getScore() <= 100)
    }

    // Passed
    void testGenerateCourse() {
        Course testCourse = Populator.generateCourse()
        def grades = testCourse.getGrades()
        // grades.forEach { grade -> println(grade.getScore()) }
        assertTrue(grades.size() >= 0 && grades.size() <= 20)
        assertTrue(testCourse.getCRN() >= 10000 && testCourse.getCRN() <= 99999)
    }

    // Passed
    void testGenerateStudent() {
        Student testStudent = Populator.generateStudent()
        // println(testStudent.firstName)
        // println(testStudent.lastName)
        def courses = testStudent.getCourses()
        // courses.forEach { course -> println(course.getName())}
        assertTrue(courses.size() >= 1 && courses.size() <= 5)
    }

    // Passed
    void testGetRandomElement() {
        def intList = [1, 2, 3, 4, 5, 6, 7, 8, 9]
        100.times {
            // println(Populator.getRandomElement(intList))
        }
    }
}
