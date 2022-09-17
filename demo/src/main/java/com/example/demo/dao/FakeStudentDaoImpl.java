package com.example.demo.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.example.demo.model.Student;

@Repository("fakeDao")
public class FakeStudentDaoImpl implements StudentDao {

    private final Map<UUID, Student> database;

    public FakeStudentDaoImpl() {
        database = new HashMap<>();
        UUID studentId = UUID.randomUUID();

        database.put(
            studentId,
            new Student(studentId, 26, "Rohit", "Singh", "Spring boot")
        );
    }

    @Override
    public int deleteStudentById(UUID studentId) {
        database.remove(studentId);
        return 1;
    }

    @Override
    public int insertNewStudent(UUID studentId, Student student) {
        database.put(studentId, student);
        return 1;
    }

    @Override
    public List<Student> selectAllStudents() {
        return new ArrayList<>(database.values());
    }

    @Override
    public Student selectStudentById(UUID studentId) {
        if (database.containsKey(studentId))
            return database.get(studentId);
        return null;
    }

    @Override
    public int updateStudentById(UUID studentId, Student studentUpdate) {
        if (database.containsKey(studentId)) {
            database.put(studentId, studentUpdate);
            return 1;
        }
        return 0;
    }
    
}
