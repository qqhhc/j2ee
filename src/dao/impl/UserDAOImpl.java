package dao.impl;

import dao.UserDAO;
import entity.User;
import utils.DBUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAOImpl  implements UserDAO {
    private DBUtil dbUtil;
    @Override
    public int save(User user) {
    String sql="insert into tbl_user(username,password,realname,phone)values(?,?,?,?)";
    dbUtil=new DBUtil();
    int i=dbUtil.update(sql,user.getUsername(),user.getPassword(),user.getRealname(),user.getPhone());
    return i;
    }

    @Override
    public int countByUsernameAndPassword(String username, String password) {
       String sql="select count(*) from tbl_user  where username=? and password=?";
       dbUtil=new DBUtil();
        ResultSet resultSet=dbUtil.query(sql,username,password);
        int count=0;
        try {
            while(resultSet.next()){
                count=resultSet.getInt(1);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if (resultSet!=null){
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return count;
    }

    @Override
    public User findByUsername(String username) {
        String sql="select * from  tbl_user where username=?";
        dbUtil=new DBUtil();
        User user=null;
        ResultSet resultSet=dbUtil.query(sql,username);
        try{
            while(resultSet.next()){
             int id=resultSet.getInt("id");
             String usernamel=resultSet.getString("username");
            String password=resultSet.getString("password");
            String realname=resultSet.getString("realname");
            String phone=resultSet.getString("phone");
            user=new User(id,usernamel,password,realname,phone);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if (resultSet!=null){
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return user;
    }
}
