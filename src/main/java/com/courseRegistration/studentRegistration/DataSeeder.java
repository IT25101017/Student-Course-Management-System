package com.courseRegistration.studentRegistration;

import com.courseRegistration.studentRegistration.model.Admin;
import com.courseRegistration.studentRegistration.model.Course;
import com.courseRegistration.studentRegistration.repository.AdminRepository;
import com.courseRegistration.studentRegistration.repository.CourseRepository;
import java.math.BigDecimal;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataSeeder implements CommandLineRunner {
    private final AdminRepository adminRepository;
    private final CourseRepository courseRepository;

    public DataSeeder(AdminRepository adminRepository, CourseRepository courseRepository) {
        this.adminRepository = adminRepository;
        this.courseRepository = courseRepository;
    }

    @Override
    public void run(String... args) {
        if (!adminRepository.existsByEmail("admin@site.com")) {
            adminRepository.save(new Admin("Default Admin", "admin@site.com", "admin123"));
        }

        seedCourse("SE101", "Java Programming Basics",
                "Learn object oriented programming, classes, objects, inheritance, and simple Java projects.",
                "OOP Concepts, Java Classes, Inheritance, Mini Project",
                "8 weeks", 30, "15000.00");
        seedCourse("WD201", "Web Development with Bootstrap",
                "Build responsive websites using HTML, CSS, JavaScript, and Bootstrap components.",
                "HTML, CSS, JavaScript, Bootstrap UI",
                "6 weeks", 25, "12000.00");
        seedCourse("DB110", "Database Design with SQL",
                "Practice table design, relationships, CRUD operations, and SQL queries.",
                "ER Diagrams, SQL CRUD, Joins, H2 Database",
                "5 weeks", 20, "10000.00");
    }

    private void seedCourse(String code, String title, String description, String subjects, String duration,
                            int capacity, String price) {
        if (!courseRepository.existsByCourseCode(code)) {
            courseRepository.save(new Course(code, title, description, subjects, duration, capacity,
                    new BigDecimal(price)));
        }
    }
}
