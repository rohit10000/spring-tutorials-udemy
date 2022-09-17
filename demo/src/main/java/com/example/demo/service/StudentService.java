package com.example.demo.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.demo.dao.StudentDao;
import com.example.demo.exceptions.StudentNotFoundException;
import com.example.demo.model.Student;

@Service
public class StudentService {
    private final StudentDao studentDao;

    @Autowired
    public StudentService(@Qualifier("fakeDao") StudentDao studentDao) {
        this.studentDao = studentDao;
    }
    
    public int persistNewStudent(UUID studentId, Student student) {
        UUID studentUid = studentId == null ? UUID.randomUUID(): studentId;
        student.setId(studentUid);
        return studentDao.insertNewStudent(studentUid, student);
    }

    public Student getStudentById(UUID studentId) {
        return studentDao.selectStudentById(studentId);
    }

    public List<Student> getAllStudents() {
        return studentDao.selectAllStudents();
    }

    public int updateStudentById(UUID studentId, Student studentUpdate) {
        studentUpdate.setId(studentId);
        return studentDao.updateStudentById(studentId, studentUpdate);
    }
    public int deleteStudentById(UUID studentId) {
        Student student = getStudentById(studentId);

        if (student == null)
            throw new StudentNotFoundException("Student not found with the ID.");

        return studentDao.deleteStudentById(studentId);
    }

}
