package cn.zsza.jdbc;

import java.sql.*;

/**
 * Created by user on 2015/5/22.
 */
public class JdbcTools {
    private static String url = "jdbc:mysql://localhost:3306/testidea";
    private static String username = "root";
    private static String password = "123456";

    static {
        try {
            Class.forName("org.gjt.mm.mysql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url,username,password);
    }

    public static void free(ResultSet rs, PreparedStatement st, Connection conn){
        if(rs != null)
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }finally{
                if(st != null)
                    try {
                        st.close();
                    } catch (SQLException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }finally{
                        if(conn != null)
                            try {
                                conn.close();
                            } catch (SQLException e) {
                                // TODO Auto-generated catch block
                                e.printStackTrace();
                            }

                    }
            }
    }
}
