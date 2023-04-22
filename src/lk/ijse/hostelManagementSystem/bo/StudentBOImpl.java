package lk.ijse.hostelManagementSystem.bo;

import lk.ijse.hostelManagementSystem.dao.custom.StudentDAO;
import lk.ijse.hostelManagementSystem.dao.custom.impl.StudentDAOImpl;
import lk.ijse.hostelManagementSystem.entity.Student;

import java.io.IOException;
import java.util.List;

public class StudentBOImpl {
    private final StudentDAO studentDAO = new StudentDAOImpl();

    public boolean saveStudent(Student dto) throws IOException {
        return studentDAO.save(dto);
    }

    public Student searchStudent(String id) throws IOException {
        return studentDAO.search(id);
    }

    public boolean updateStudent(Student dto) throws IOException {
        return studentDAO.update(dto);
    }

    public boolean deleteStudent(String id) throws IOException {
        return studentDAO.delete(id);
    }

    public List<Student> getAllStudent() throws IOException {
        return studentDAO.getAll();
    }
}
