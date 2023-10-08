package com.example.students_journal.service;
import com.example.students_journal.entity.Student;
import com.example.students_journal.entity.StudentData;
import com.example.students_journal.entity.StudentDelete;
import com.example.students_journal.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepository repository;

    public Student saveStudent(Student student) {
        return repository.save(student);
    }

    public List<Student> saveStudents(List<Student> students) {
        return repository.saveAll(students);
    }

    public StudentData getStudents(
            String studentName,
            String lastname,
            String studentFrom,
            String semester,
            String email,
            String phone,
            String gender,
            String faculty,
            String assessment,
            String educationStartYear,
            String educationEndYear,
            int page,
            int count) {
        StudentData data = new StudentData();
        Pageable pageable = PageRequest.of(page-1, count);
        ArrayList<Student> lists = new ArrayList<Student>();
        Page<Student> namesList = repository.findStudentsByStudentName(studentName, pageable);
        Page<Student> lastnamesList = repository.findStudentsByLastname(lastname, pageable);
        Page<Student> studentsFromList = repository.findStudentsByStudentFrom(studentFrom, pageable);
        Page<Student> semestersList = repository.findStudentsBySemester(semester, pageable);
        Page<Student> emailsList = repository.findStudentsByEmail(email, pageable);
        Page<Student> phonesList = repository.findStudentsByPhone(phone, pageable);
        Page<Student> gendersList = repository.findStudentsByGender(gender, pageable);
        Page<Student> facultiesList = repository.findStudentsByFaculty(faculty, pageable);
        Page<Student> assessmentsList = repository.findStudentsByAssessment(assessment, pageable);
        Page<Student> startDatesList = repository.findStudentsByEducationStartYear(educationStartYear, pageable);
        Page<Student> endDatesList = repository.findStudentsByEducationEndYear(educationEndYear, pageable);
        List<Student> listByName = namesList.getContent();
        List<Student> listByLastname = lastnamesList.getContent();
        List<Student> listByFrom = studentsFromList.getContent();
        List<Student> listBySemester = semestersList.getContent();
        List<Student> listByEmail = emailsList.getContent();
        List<Student> listByPhone = phonesList.getContent();
        List<Student> listByGender = gendersList.getContent();
        List<Student> listByFaculty = facultiesList.getContent();
        List<Student> listByAssessment = assessmentsList.getContent();
        List<Student> listByStartDate = startDatesList.getContent();
        List<Student> listByEndDate = endDatesList.getContent();

        if(listByName.size() > 0) {
            lists.addAll(listByName);
            data.setTotal(namesList.getTotalElements());
        }
        if(listByLastname.size() > 0) {
            lists.addAll(listByLastname);
            data.setTotal(lastnamesList.getTotalElements());
        }
        if (listByFrom.size() > 0) {
            lists.addAll(listByFrom);
            data.setTotal(studentsFromList.getTotalElements());
        }
        if (listBySemester.size() > 0) {
            lists.addAll(listBySemester);
            data.setTotal(semestersList.getTotalElements());
        }
        if (listByEmail.size() > 0) {
            lists.addAll(listByEmail);
            data.setTotal(emailsList.getTotalElements());
        }
        if (listByPhone.size() > 0) {
            lists.addAll(listByPhone);
            data.setTotal(phonesList.getTotalElements());
        }
        if (listByGender.size() > 0) {
            lists.addAll(listByGender);
            data.setTotal(gendersList.getTotalElements());
        }
        if (listByFaculty.size() > 0) {
            lists.addAll(listByFaculty);
            data.setTotal(facultiesList.getTotalElements());
        }
        if (listByAssessment.size() > 0) {
            lists.addAll(listByAssessment);
            data.setTotal(assessmentsList.getTotalElements());
        }
        if (listByStartDate.size() > 0) {
            lists.addAll(listByStartDate);
            data.setTotal(startDatesList.getTotalElements());
        }
        if (listByEndDate.size() > 0) {
            lists.addAll(listByEndDate);
            data.setTotal(endDatesList.getTotalElements());
        }
        if(listByName.size() <= 0
           && listByLastname.size() <= 0
           && listByFrom.size() <= 0
           && listBySemester.size() <= 0
           && listByEmail.size() <= 0
           && listByPhone.size() <= 0
           && listByGender.size() <= 0
           && listByFaculty.size() <= 0
           && listByAssessment.size() <= 0
           && listByStartDate.size() <= 0
           && listByEndDate.size() <= 0) {
          if(studentName != null
                  || lastname != null
                  || studentFrom != null
                  || semester != null
                  || email != null
                  || phone != null
                  || gender != null
                  || faculty != null
                  || assessment != null
                  || educationStartYear != null
                  || educationEndYear != null) {
                lists.addAll(new ArrayList<>());
              data.setTotal(0L);
          } else {
              Page<Student> studentList = repository.findAll(pageable);
              List<Student> studentsListWithPage = studentList.getContent();
              lists.addAll(studentsListWithPage);
              data.setTotal(studentList.getTotalElements());
          }
        }
        data.setData(lists);
        return data;
    }

    public Student getStudentById(int id) {
        return repository.findById(id).orElse(null);
    }

    public StudentDelete deleteStudent(int id) {
        repository.deleteById(id);
        StudentDelete deletedStudent = new StudentDelete();
        deletedStudent.setStatus("Successfully deleted");
        deletedStudent.setStudentName("${id}");
        return deletedStudent;
    }

    public Student updateStudent(Student student) {
        Student existingStudent = repository.findById(student.getId()).orElse(null);
        existingStudent.setStudentName(student.getStudentName());
        existingStudent.setLastname(student.getLastname());
        existingStudent.setStudentFrom(student.getStudentFrom());
        existingStudent.setSemester(student.getSemester());
        existingStudent.setEmail(student.getEmail());
        existingStudent.setPhone(student.getPhone());
        existingStudent.setGender(student.getGender());
        existingStudent.setFaculty(student.getFaculty());
        existingStudent.setAssessment(student.getAssessment());
        existingStudent.setEducationStartYear(student.getEducationStartYear());
        existingStudent.setEducationEndYear(student.getEducationEndYear());

        return repository.save(existingStudent);
    }
}
