package main.java.users.students;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Represents a course that belongs to a student.
 */
public class Course {
    private int CRN;
    private String name;
    private List<Double> grades;
    private int creditHours;
    private LocalDateTime time;

    public Course(String name, int creditHours, int CRN) {
        this.name = name;
        this.creditHours = creditHours;
        this.CRN = CRN;
    }

    public int getAverage() {
        int total = 0;
        for (double grade : grades) {
            total += grade;
        }

        total /= grades.size();
        if (total >= 90) {
            return 4;
        } else if (total >= 80) {
            return 3;
        } else if (total >= 70) {
            return 2;
        } else if (total >= 60) {
            return 1;
        } else {
            return 0;
        }
    }

    public int getCRN() {
        return CRN;
    }

    public void setCRN(int CRN) {
        this.CRN = CRN;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Double> getGrades() {
        return grades;
    }

    public void setGrades(List<Double> grades) {
        this.grades = grades;
    }

    public int getCreditHours() {
        return creditHours;
    }

    public void setCreditHours(int creditHours) {
        this.creditHours = creditHours;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }
}
