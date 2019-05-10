package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.ResourceBundle;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;


public class DBUtil {

    // 驱动名字
    private static String driverName;
    // 数据库连接地址
    private static String url;
    // 数据用户名
    private static String username;
    // 密码
    private static String password;

    private Connection connection = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;

    static{

        ResourceBundle resourceBundle=ResourceBundle.getBundle("db");
        driverName=resourceBundle.getString("drivername");
        url=resourceBundle.getString("url");
        username=resourceBundle.getString("username");
        password=resourceBundle.getString("password");

//		Properties properties=new Properties();
//		try {
//			properties.load(new FileInputStream(new File("db.properties")));
//			driverName=properties.getProperty("drivername");
//			url=properties.getProperty("url");
//			username=properties.getProperty("username");
//			password=properties.getProperty("password");
//		} catch (IOException e) {
//			e.printStackTrace();
//		}

    }

    // 更新数据库操作->insert/update/delete
    public int update(String sql, Object... params) {

        int r = 0;

        try {

            getConnection();

            preparedStatement = connection.prepareStatement(sql);
            // 设置参数
            if (params != null) {
                // 不定参数是被当成数组使用
                for (int i = 0; i < params.length; i++) {
                    preparedStatement.setObject(i + 1, params[i]);
                }
            }

            // i为受该条sql语句影响的记录条数。
            r = preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null)
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        return r;

    }

    public CachedRowSet query(String sql, Object... params) {
        CachedRowSet cachedRowSet = null;

        try {
            getConnection();
            // 不推荐直接new
            // cachedRowSet =new CachedRowSetImpl();

            RowSetFactory factory = RowSetProvider.newFactory();
            cachedRowSet = factory.createCachedRowSet();

            // 通过sql语句生成预编译的操作语句
            preparedStatement = connection.prepareStatement(sql);
            // 设置参数
            if (params != null) {
                // 不定参数是被当成数组使用
                for (int i = 0; i < params.length; i++) {
                    preparedStatement.setObject(i + 1, params[i]);
                }
            }

            // 设置参数(参数位置，参数值)
            resultSet = preparedStatement.executeQuery();
            cachedRowSet.populate(resultSet);

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close();
        }
        return cachedRowSet;
    }

    // 分页查询
    public CachedRowSet queryByPage(String sql, int pageSize, int page, Object... params) {

        getConnection();
        CachedRowSet cachedRowSet = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            if (params != null) {
                for (int i = 0; i < params.length; i++) {
                    preparedStatement.setObject(i + 1, params[i]);
                }
            }
            resultSet = preparedStatement.executeQuery();
            // RowSet进行分页
            RowSetFactory factory = RowSetProvider.newFactory();
            cachedRowSet = factory.createCachedRowSet();
            // 参数判断
            if (pageSize < 1)
                pageSize = 1;
            if (page < 1)
                page = 1;
            cachedRowSet.setPageSize(pageSize);
            // 生成cacheRowSet，然后指定的条数开始。
            cachedRowSet.populate(resultSet, (page - 1) * pageSize + 1);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close();
        }
        return cachedRowSet;

    }

    public void close() {
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (preparedStatement != null) {
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public Connection getConnection() {
        // 不要使用单例
        // Connection资源是最宝贵的，一般来说会占用大多数的操作时间，所以Connection一定要关闭回收。
        try {
            Class.forName(driverName);
            connection = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

}
