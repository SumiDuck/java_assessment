package com.generation.service;

import com.generation.model.Course;
import com.generation.model.Student;
import com.generation.model.Module;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CourseServiceTest {

    private CourseService courseService = new CourseService();
    private Student student;
    private Course randomCourse;

    @BeforeEach
    void setUp() {
        // Correctly creating the student object
        Date birthDate = new Date(2000, 04, 29);
        student = new Student("109", "Marry Sue", "MarryS@example.com", birthDate);

        // Create a Module object
        Module module = new Module("INTRO-WEB", "Web Development Fundamentals", "Introduction to fundamentals of web development");

        // Create a random Course object and register it
        randomCourse = new Course("INTRO-WEB-5", "Advanced CSS", 9, module);
        courseService.registerCourse(randomCourse);

        // Enroll the student in the random course
        courseService.enrollStudent(randomCourse.getCode(), student);
    }

    @AfterEach
    void tearDown() {
        // this tearDown operation is mainly used to reset all initialisations
    }




    @Test
    @DisplayName("Course should exist in the created course")
    void enrollStudent() {
        courseService.enrollStudent(randomCourse.getCode(), student);

        Course course = courseService.getCourse(randomCourse.getCode());

        assertNotNull(course, "The course should exist.");
    }

    @Test
    void showSummary() {
        assertTrue(courseService.getCourses().containsKey("INTRO-WEB-5"), "The course with code INTRO-WEB-5 should be registered.");
    }
}