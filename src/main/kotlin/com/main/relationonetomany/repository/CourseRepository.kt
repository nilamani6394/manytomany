package com.main.relationonetomany.repository

import com.main.relationonetomany.entity.Course
import org.springframework.data.jpa.repository.JpaRepository

interface CourseRepository:JpaRepository<Course,Long> {
}