package dao;

import entity.User;

public interface UserDAO {
    public int save(User user);
    //ͨ���û������������ͳ��
    public  int countByUsernameAndPassword(String username,String password);
   //ͨ���û�����ȡ�û�
    public  User findByUsername(String username);
}
