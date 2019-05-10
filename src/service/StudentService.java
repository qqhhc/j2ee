package service;



import entity.Student;

import java.util.List;

/**
 * @Author: qhc
 * @Date: 2019/4/9 16:23
 */
public interface StudentService {
    public boolean save(Student student);

    public boolean update(Student student);

    public boolean delete(Integer id);

    public List<Student> findAll();

    public List<Student> findByName(String stuName);

    public int count();

    public Student findById(Integer id);
}
