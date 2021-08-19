package com.main.relationonetomany.controller

import com.main.relationonetomany.entity.Course
import com.main.relationonetomany.entity.Student
import com.main.relationonetomany.model.ResStudent
import com.main.relationonetomany.model.request.ReqStudent
import com.main.relationonetomany.repository.CourseRepository
import com.main.relationonetomany.repository.StudentRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
@RequestMapping("/student")
class StudentController {
    @Autowired
    private lateinit var studentRepository: StudentRepository
    @Autowired
    private lateinit var courseRepository: CourseRepository
    @PostMapping("/createStudent")
    fun createStudent(@ModelAttribute request:ReqStudent):ResponseEntity<*>{
        val newStudent=Student(name = request.name,age = request.age,grade = request.grade)
        val newCourse=Course(title = request.title,abbreviation = request.abbreviation,fee = request.fee)
        val newCourse2=Course(title = request.title,abbreviation = request.abbreviation,fee = request.fee)
        val newCourse3=Course(title = request.title,abbreviation = request.abbreviation,fee = request.fee)
        courseRepository.save(newCourse)
        //add course to the student
        newStudent.courses.addAll(listOf(newCourse,newCourse2,newCourse3))


        //add student in course
       // newCourse.student.add(newStudent)

        //update the student
        studentRepository.save(newStudent)

        val resStudent=ResStudent(request.name,request.grade,request.title)


        return  ResponseEntity(resStudent,HttpStatus.OK)
    }
}