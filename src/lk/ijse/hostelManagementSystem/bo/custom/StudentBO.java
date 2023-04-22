package lk.ijse.hostelManagementSystem.bo.custom;

import lk.ijse.hostelManagementSystem.bo.SuperBO;
import lk.ijse.hostelManagementSystem.dto.StudentDTO;
import lk.ijse.hostelManagementSystem.entity.Student;

import java.io.IOException;
import java.util.List;

public interface StudentBO extends SuperBO {
    boolean saveStudent(StudentDTO dto) throws IOException;

    StudentDTO searchStudent(String id) throws IOException;

    boolean updateStudent(StudentDTO dto) throws IOException;

    boolean deleteStudent(String id) throws IOException;

    List<StudentDTO> getAllStudent() throws IOException;
}
