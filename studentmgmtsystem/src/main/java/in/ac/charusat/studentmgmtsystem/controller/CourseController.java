package in.ac.charusat.studentmgmtsystem.controller;

import in.ac.charusat.studentmgmtsystem.model.Course;
import in.ac.charusat.studentmgmtsystem.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CourseController {

    @Autowired
    CourseRepository courseRepository;

    @GetMapping("/course/{id}")
    public Course getCourse(@PathVariable Integer cId) {
        return courseRepository.findById(cId).get();
    }

    @GetMapping("/listCourses")
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    @PostMapping("course")
    public List<Course> addCourse(@RequestBody Course course) {
        courseRepository.save(course);
        return courseRepository.findAll();
    }
    @PutMapping("/course/{id}")
    public List<Course> updateCourse(@RequestBody Course course, @PathVariable Integer Id) {
        Course courseObj= courseRepository.findById(Id).get();
        courseObj.setTitle(course.getTitle());
        courseObj.setDescription(course.getDescription());
        courseRepository.save(course);
        return courseRepository.findAll();
    }

    @DeleteMapping("/course/{id}")
    public List<Course> deleteCourse(@PathVariable Integer Id) {
        courseRepository.delete(courseRepository.findById(Id).get());
        return courseRepository.findAll();
    }
}
