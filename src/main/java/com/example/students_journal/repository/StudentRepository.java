package com.example.students_journal.repository;
import com.example.students_journal.entity.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface StudentRepository extends JpaRepository<Student, Integer> {
    @Query(value = "SELECT * FROM student WHERE student.lastname LIKE %:lastname%", nativeQuery = true)
    Page<Student> findStudentsByLastname(@Param("lastname") String lastname, Pageable pageable);

    @Query(value = "SELECT * FROM student WHERE student.student_name LIKE %:studentName%", nativeQuery = true)
    Page<Student> findStudentsByStudentName(@Param("studentName") String studentName, Pageable pageable);

    @Query(value = "SELECT * FROM student WHERE student.student_from LIKE %:studentFrom%", nativeQuery = true)
    Page<Student> findStudentsByStudentFrom(@Param("studentFrom") String studentFrom, Pageable pageable);

    @Query(value = "SELECT * FROM student WHERE student.semester LIKE %:semester%", nativeQuery = true)
    Page<Student> findStudentsBySemester(@Param("semester")String semester, Pageable pageable);

    @Query(value = "SELECT * FROM student WHERE student.email LIKE %:email%", nativeQuery = true)
    Page<Student> findStudentsByEmail(@Param("email") String email, Pageable pageable);

    @Query(value = "SELECT * FROM student WHERE student.phone LIKE %:phone%", nativeQuery = true)
    Page<Student> findStudentsByPhone(@Param("phone") String phone, Pageable pageable);

    @Query(value = "SELECT * FROM student WHERE student.gender LIKE %:gender%", nativeQuery = true)
    Page<Student> findStudentsByGender(@Param("gender") String gender, Pageable pageable);

    @Query(value = "SELECT * FROM student WHERE student.faculty LIKE %:faculty%", nativeQuery = true)
    Page<Student> findStudentsByFaculty(@Param("faculty") String faculty, Pageable pageable);

    @Query(value = "SELECT * FROM student WHERE student.assessment LIKE %:assessment%", nativeQuery = true)
    Page<Student> findStudentsByAssessment(@Param("assessment") String assessment, Pageable pageable);

    @Query(value = "SELECT * FROM student WHERE student.education_start_year LIKE %:educationStartYear%", nativeQuery = true)
    Page<Student> findStudentsByEducationStartYear(@Param("educationStartYear") String educationStartYear, Pageable pageable);

    @Query(value = "SELECT * FROM student WHERE student.education_end_year LIKE %:educationEndYear%", nativeQuery = true)
    Page<Student> findStudentsByEducationEndYear(@Param("educationEndYear") String educationEndYear, Pageable pageable);
}
