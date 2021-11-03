package com.claim.services;

import com.claim.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class StudentService {
    private ArrayList<Student> students;

    public StudentService() {
        students = new ArrayList<Student>();
    }

   public void saveStudent(Student student) {
       students.add(student);
   }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public boolean authenticate(Student student) {
        ArrayList<Student> students = getStudents();

        String email = student.getEmail();
        String password = student.getPassword();

        boolean validCredentials = false;

        for (Student loopedStudent: students) {
            if (loopedStudent.getEmail().equals(email) && loopedStudent.getPassword().equals(password)) {
                validCredentials = true;
                break;
            }
        }

        return validCredentials;
    }
}
