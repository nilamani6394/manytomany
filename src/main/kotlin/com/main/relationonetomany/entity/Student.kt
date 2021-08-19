package com.main.relationonetomany.entity


import javax.persistence.*

@Entity
data class Student(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id:Long=-1,
    val  name:String?="",
    val age:Int=0,
    val grade:String?="",

    @ManyToMany(fetch = FetchType.LAZY, cascade = [CascadeType.PERSIST])
    @JoinTable(name = "students_courses",
        joinColumns = [JoinColumn(
            name = "student_id", referencedColumnName = "id",
            nullable = false, updatable = false
        )],
        inverseJoinColumns = [
            JoinColumn(
                name = "course_id", referencedColumnName = "id",
                nullable = false, updatable = false
            )
        ])
    val courses: MutableSet<Course> = HashSet()
)
