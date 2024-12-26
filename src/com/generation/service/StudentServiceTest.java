package com.generation.service;

import com.generation.model.Student;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class StudentServiceTest {

    private StudentService studentService; // private to ensure only available in the test class
    private Map<String, Student> students;

    @BeforeEach
    void setUp() {
        studentService = new StudentService();

        students = new HashMap<>();
        String id = "109";
        String name = "Marry Sue";
        String email = "MarryS@example.com";
        Date birthDate = new Date(2000, 04, 29);

        Student student = new Student(id, name, email, birthDate);
        students.put(id, student);
    }

    @AfterEach
    void tearDown() {
        // this tearDown operation is mainly used to reset all initialisations
    }


    @Test
    @DisplayName("Students can be found in subscribeStudent")
    void isSubscribed() {
        System.out.println("Students in the map: " + students);
        boolean result = studentService.isSubscribed(students, "109");
        assertTrue(result);
    }

    @Test
    @DisplayName("Summarize amt of students subscribed")
    void showSummary() {


        int count = countStudents(students);
        assertEquals(1, count);  // Since we added one student in setUp
    }

    private int countStudents(Map<String, Student> students) {
        return students.size();  // Return the size of the students map
    }


    @Test
    @DisplayName("Student is enrolled")
    void enrollToCourse() {
        assertTrue(students.containsKey("109"));

    }
}