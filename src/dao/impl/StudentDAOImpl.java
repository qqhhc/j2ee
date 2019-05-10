package dao.impl;



import dao.StudentDAO;
import entity.Student;
import utils.DBUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


/**
 * @Author: qhc
 * @Date: 2019/4/9 16:03
 */
public class StudentDAOImpl implements StudentDAO {

    DBUtil dbUtil=new DBUtil();


    @Override
    public int save(Student student) {
        String sql = "insert into tab_student(stu_no,stu_name,stu_birthday,stu_phone,stu_address,stu_height)" +
                "values(?,?,?,?,?,?)";
        int i = dbUtil.update(sql, student.getStuNo(), student.getStuName(), student.getStuBirthday(),
                student.getStuPhone(), student.getStuAddress(), student.getStuHeight());
        return i;
    }

    @Override
    public int update(Student student) {
        String sql = "update tab_student set stu_no=?,stu_name=?,stu_birthday=?,stu_phone=?,stu_address=?,stu_height=? "
                + "where id=?";
        int i = dbUtil.update(sql, student.getStuNo(), student.getStuName(), student.getStuBirthday(),
                student.getStuPhone(), student.getStuAddress(), student.getStuHeight(), student.getId());
        return i;
    }

    @Override
    public int delete(Integer id) {
        String sql = "delete from tab_student where id=?";
        int i = dbUtil.update(sql, id);
        return i;
    }

    @Override
    public int deleteByStuNo(String stuNo) {
        String sql = "delete from tab_student where stu_no=?";
        int i = dbUtil.update(sql, stuNo);
        return i;
    }

    @Override
    public Student findById(Integer id) {
        List<Student> list = new ArrayList<>();
        String sql = "select * from tab_student where id=?";
        ResultSet resultSet = dbUtil.query(sql, id);
        try {
            while (resultSet.next()) {
                handleDate(list, resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dbUtil.close();
            if (!list.isEmpty()) {
                return list.get(0);
            } else {
                return null;
            }
        }
    }

    @Override
    public Student findByStuNo(String stuNo) {
        Student student = null;
        String sql = "select * from tab_student where stu_no=?";
        ResultSet resultSet = dbUtil.query(sql, stuNo);
        try {
            while (resultSet.next()) {
                Integer id = resultSet.getInt("id");
                String stu_no = resultSet.getString("stu_no");
                String stu_name = resultSet.getString("stu_name");
                String stu_birthday = resultSet.getString("stu_birthday");
                String stu_phone = resultSet.getString("stu_phone");
                String stu_address = resultSet.getString("stu_address");
                double stu_height = resultSet.getDouble("stu_height");
                student = new Student(id, stu_no, stu_name, stu_birthday, stu_phone, stu_address, stu_height);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (dbUtil != null)
                dbUtil.close();
        }
        return student;
    }

    @Override
    public List<Student> findAll() {
        List<Student> list = new ArrayList<Student>();
        ResultSet resultSet = dbUtil.query("select * from tab_student");
        try {
            while (resultSet.next()) {
                handleDate(list, resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<Student> findByStuName(String stuName) {
        List<Student> list = new ArrayList<>();
        stuName = "%" + stuName + "%";
        String sql = "select * from tab_student where stu_name like ?";
        ResultSet resultSet = dbUtil.query(sql, stuName);
        try {
            while (resultSet.next()) {
                handleDate(list, resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    private void handleDate(List<Student> list, ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("id");
        String stu_no = resultSet.getString("stu_no");
        String stu_name = resultSet.getString("stu_name");
        String stu_birthday = resultSet.getString("stu_birthday");
        String stu_phone = resultSet.getString("stu_phone");
        String stu_address = resultSet.getString("stu_address");
        double stu_height = resultSet.getDouble("stu_height");
        Student student = new Student(id, stu_no, stu_name, stu_birthday, stu_phone, stu_address, stu_height);
        list.add(student);
    }

    @Override
    public int count() {
        int allCount = 0;
        String sql = "select count(*) from tab_student";  //String sql ="select count(*) c from tab_student";
        ResultSet resultSet = dbUtil.query(sql);
        try {
            while (resultSet.next()) {
                allCount = resultSet.getInt(1);   //allCount=resultSet.getInt("c");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return allCount;
    }

    @Override
    public List<Student> findByPage(int pageSize, int page) {
        List<Student> list = new ArrayList<>();
        String sql = "select *from tab_student";
        ResultSet resultSet = dbUtil.queryByPage(sql, pageSize, page);
        try {
            while (resultSet.next()) {
                handleDate(list, resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
