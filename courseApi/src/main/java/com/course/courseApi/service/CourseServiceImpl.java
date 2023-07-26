package com.course.courseApi.service;

import com.course.courseApi.entity.Course;
import com.course.courseApi.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepository courseRepo;

    @Override
    public String upSert(Course course) {
        courseRepo.save(course);
        return "Success";
    }

    @Override
    public Course getById(Integer cid) {
        Optional<Course> findById = courseRepo.findById(cid);
        if(findById.isPresent()){
            return findById.get();
        }
        return null;
    }

    @Override
    public List<Course> getAllCourse() {
        return courseRepo.findAll();
    }

    @Override
    public String deleteById(Integer cid) {
        if(courseRepo.existsById(cid)){
            courseRepo.deleteById(cid);
            return "Delete Success";
        }
        else {
            return "no record found";
        }
    }
}

