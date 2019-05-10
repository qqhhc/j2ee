package dao;



import entity.Student;

import java.util.List;

/**
 * @Author: qhc
 * @Date: 2019/4/9 15:38
 */
public interface StudentDAO {
    //保存学生
    public int save(Student student);

    //修改学生
    public int update(Student student);

    //删除学生，通过id
    public int delete(Integer id);

    //通过学号删除
    public int deleteByStuNo(String stuNo);

    //返回单个学生信息
    public Student findById(Integer id);

    //通过学生编号返回学生信息
    public Student findByStuNo(String stuNo);

    //返回所有同学信息
    public List<Student> findAll();

    //根据名字，模糊查找，返回学生信息
    public List<Student> findByStuName(String stuName);

    //多少条记录
    public int count();
    //分页
    public List<Student> findByPage(int pageSize, int page);
}
