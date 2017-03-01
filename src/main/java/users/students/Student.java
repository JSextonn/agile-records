package main.java.users.students;

import main.java.users.User;
import main.java.util.math.MathUtil;
import main.java.util.security.Hash;

import java.util.ArrayList;
import java.util.List;

/**
 * Class that represents students on the sql server.
 */
public class Student extends User {
    private List<Course> courses;
    private Major major;

    public Student(String userName, Hash password) {
        super(userName, password);
        courses = new ArrayList<>();
    }

    public double getGPA() {
        int totalHours = 0;
        double totalScore = 0;
        for (Course course : this.courses) {
            int hours = course.getCreditHours();
            totalScore += course.getAverage() * hours;
            totalHours += hours;
        }
        return MathUtil.round(totalScore / totalHours, 2);
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public Major getMajor() {
        return major;
    }

    public void setMajor(Major major) {
        this.major = major;
    }
}
