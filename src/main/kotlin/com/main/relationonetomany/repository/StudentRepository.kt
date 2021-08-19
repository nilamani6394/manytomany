package com.main.relationonetomany.repository

import com.main.relationonetomany.entity.Student
import org.springframework.data.jpa.repository.JpaRepository

interface StudentRepository:JpaRepository<Student,Long> {
}