package com.course.courseApi.controller;

import com.course.courseApi.entity.Course;
import com.course.courseApi.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CourseRestController {
    @Autowired
    private CourseService courseService;
    @PostMapping("/course")
    public ResponseEntity<String> createCourse(@RequestBody Course course){
        String status = courseService.upSert(course);
        return new ResponseEntity<>(status, HttpStatus.CREATED);
    }
    @GetMapping("/course/{cid}")
    public ResponseEntity<Course> getCourse(@PathVariable Integer cid){
        Course course = courseService.getById(cid);
        return new ResponseEntity<>(course,HttpStatus.OK);
    }
    @GetMapping("/courses")
    public ResponseEntity<List<Course>> getAllCourses(){
        List<Course> allCourse = courseService.getAllCourse();
        return new ResponseEntity<>(allCourse,HttpStatus.OK);
    }

    @PutMapping("/course/{cid}")
    public ResponseEntity<String> updateCourse(@PathVariable Integer cid, @RequestBody Course course) {
        course.setCid(cid);
        String s = courseService.upSert(course);
        return new ResponseEntity<>(s, HttpStatus.OK);
    }

    @DeleteMapping("/course/{cid}")
    public ResponseEntity<String> deleteCourse(@PathVariable Integer cid){
        String s = courseService.deleteById(cid);
        return new ResponseEntity<>(s,HttpStatus.OK);
    }

}
