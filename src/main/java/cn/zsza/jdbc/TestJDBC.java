package cn.zsza.jdbc;


import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by user on 2015/5/22.
 */
public class TestJDBC {
    Connection conn = null;
    PreparedStatement st = null;
    ResultSet rs = null;

    /**
     * 插入操作是在事务提交的时候，进行插库操作
     * @throws SQLException
     */
    @Test
    public void testInsert() throws SQLException {
        String sql = "INSERT INTO  tx_person (pname,age) VALUES (?,?)";

        try {
            conn = JdbcTools.getConnection();
            conn.setAutoCommit(false);
            st  = conn.prepareStatement(sql);
            st.setString(1, "小8");
            st.setInt(2,18);
            st.executeUpdate();
            conn.commit();
        } catch (SQLException e) {
            conn.rollback();
            e.printStackTrace();
        }finally {
            JdbcTools.free(rs,st,conn);
        }
    }

    /**
     * 查询操作，不等事务提交立即执行
     * @throws SQLException
     */
    @Test
    public void testSelectOneById() throws SQLException {
        String sql = "SELECT * FROM tx_person WHERE pid = ?";

        try {
            conn = JdbcTools.getConnection();
            conn.setAutoCommit(false);
            st  = conn.prepareStatement(sql);
            st.setInt(1,1);
            ResultSet rs = st.executeQuery();
            if (rs.next()){
                System.out.println("name=" +rs.getString(2));
            }
            System.out.println("事务提交之前");
            conn.commit();
        } catch (SQLException e) {
            conn.rollback();
            e.printStackTrace();
        }finally {
            JdbcTools.free(rs,st,conn);
        }
    }
    /**
     * 更新操作,也是在事务提交的时候进行的
     * @throws SQLException
     */
    @Test
    public void updatetPerson() throws SQLException {
        String sql = "UPDATE tx_person SET pname = ? WHERE pid = ?";
        try {
            conn = JdbcTools.getConnection();
            conn.setAutoCommit(false);
            st = conn.prepareStatement(sql);
            st.setString(1,"小三");
            st.setInt(2,1);
            st.executeUpdate();
            conn.commit();
        } catch (SQLException e) {
            conn.rollback();
            e.printStackTrace();
        }finally {
            JdbcTools.free(rs,st,conn);
        }

    }
}
