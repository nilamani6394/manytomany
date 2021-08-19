package com.main.relationonetomany.entity

import javax.persistence.*

@Entity
data class Course(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id:Long=-1,
    val title:String="",
    val abbreviation:String?="",
    val fee:Double=0.0,
    @ManyToMany(mappedBy = "courses",fetch = FetchType.LAZY)
    val student: MutableSet<Student> = HashSet()
)
