package lk.ijse.hostelManagementSystem.bo.custom.impl;

import lk.ijse.hostelManagementSystem.bo.custom.StudentBO;
import lk.ijse.hostelManagementSystem.dao.DAOFactory;
import lk.ijse.hostelManagementSystem.dao.custom.StudentDAO;
import lk.ijse.hostelManagementSystem.dao.custom.impl.StudentDAOImpl;
import lk.ijse.hostelManagementSystem.dto.StudentDTO;
import lk.ijse.hostelManagementSystem.entity.Student;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StudentBOImpl implements StudentBO {
    private final StudentDAO studentDAO = (StudentDAO) DAOFactory.getDaoFactory().getDao(DAOFactory.DAOType.STUDENT);

    @Override
    public boolean saveStudent(StudentDTO dto) throws IOException {
        return studentDAO.save(new Student(
                dto.getSid(), dto.getName(), dto.getAddress(), dto.getContact(), dto.getDob(), dto.getGender(), dto.getRegisterDate()));
    }

    @Override
    public StudentDTO searchStudent(String id) throws IOException {
        Student student = studentDAO.search(id);
        return new StudentDTO(
                student.getSid(),
                student.getName(),
                student.getAddress(),
                student.getContact(),
                student.getDob(),
                student.getGender(),
                student.getRegisterDate());
    }

    @Override
    public boolean updateStudent(StudentDTO dto) throws IOException {
        return studentDAO.update(new Student(
                dto.getSid(), dto.getName(), dto.getAddress(), dto.getContact(), dto.getDob(), dto.getGender(), dto.getRegisterDate()));
    }

    @Override
    public boolean deleteStudent(String id) throws IOException {
        return studentDAO.delete(id);
    }

    @Override
    public List<StudentDTO> getAllStudent() throws IOException {
        List<StudentDTO> allStudent = new ArrayList<>();
        List<Student> all = studentDAO.getAll();
        for (Student student : all) {
            allStudent.add(new StudentDTO(student.getSid(),
                    student.getName(),
                    student.getAddress(),
                    student.getContact(),
                    student.getDob(),
                    student.getGender(),
                    student.getRegisterDate()));
        }
        return allStudent;
    }
}
