package com.course.courseApi.service;

import com.course.courseApi.entity.Course;

import java.util.List;

public interface CourseService {
    public String upSert(Course course); // for insert and update
    public Course getById(Integer cid); // fetch course by id
    public List<Course> getAllCourse();
    public String deleteById(Integer cid);
}
