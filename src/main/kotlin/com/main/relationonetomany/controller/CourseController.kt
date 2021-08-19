package com.main.relationonetomany.controller

import com.main.relationonetomany.entity.Course
import com.main.relationonetomany.entity.Student
import com.main.relationonetomany.model.request.ReqCourse
import com.main.relationonetomany.repository.CourseRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/course")
class CourseController {
    @Autowired
    private  lateinit var courseRepository:CourseRepository
    @PostMapping("/createCourse")
    fun createCourse(@ModelAttribute request:ReqCourse):ResponseEntity<*>{
        val newCourse= Course(title = request.title,abbreviation = request.abbreviation,fee = request.fee)
        val newStudent=Student()
        newCourse.student.add(newStudent)
        courseRepository.save(newCourse)
        return ResponseEntity("",HttpStatus.OK)
    }
}