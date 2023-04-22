package lk.ijse.hostelManagementSystem.bo;

import lk.ijse.hostelManagementSystem.entity.Student;

import java.io.IOException;
import java.util.List;

public interface StudentBO {
    boolean saveStudent(Student dto) throws IOException;

    Student searchStudent(String id) throws IOException;

    boolean updateStudent(Student dto) throws IOException;

    boolean deleteStudent(String id) throws IOException;

    List<Student> getAllStudent() throws IOException;
}
