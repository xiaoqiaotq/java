package sometest;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Map;

import oracle.jdbc.internal.OracleTypes;
import oracle.jdbc.oracore.OracleType;

import org.hamcrest.Condition.Step;
import org.junit.Test;

import com.mysql.jdbc.Statement;

import util.DbUtils;

public class JDBCTest {
	private static final String ORACLE="oracle_test";
	private static final String MYSQL="mysql";
	private static final String SQLSERVER="AFTERSERVICEDB";
	public static void main(String[] args) {
		Connection conn=DbUtils.getConn();
		String sql="select * from m_user where user_id=?";
		try {
			PreparedStatement psmt=conn.prepareStatement(sql);
			psmt.setString(1, "a");
			ResultSet rs=psmt.executeQuery();
			System.err.println(rs.next());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void testScroll() throws SQLException{
		Connection conn=DbUtils.getConn(MYSQL);
		String sql="select * from user";
//		PreparedStatement psmt=conn.prepareStatement(sql, ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
		PreparedStatement psmt=conn.prepareStatement(sql);
//		psmt.setFetchSize(1);
		ResultSet rs=psmt.executeQuery();
		while(rs.next()){
			System.err.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3));
		}
		rs.first();
		rs.last();
		System.err.println(rs.getString(2));
		conn.close();
	}
	@Test
	public void testOrcale() throws SQLException{
		Connection conn=DbUtils.getConn(ORACLE);
		String sql="select * from student";
		PreparedStatement psmt=conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
//		PreparedStatement psmt=conn.prepareStatement(sql);
//		psmt.setFetchSize(1);
		ResultSet rs=psmt.executeQuery();
		while(rs.next()){
			System.err.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3));
		}
		rs.first();
		rs.last();
		System.err.println(rs.getString(2));
		conn.close();
	}
	@Test
	public void testInsertOrcale() throws SQLException{
		Connection conn=DbUtils.getConn(ORACLE);
//		String sql="insert into student values(3,'lisiww',31)";
//		PreparedStatement psmt=conn.prepareStatement(sql);
//		psmt.execute();
		Map map=conn.getTypeMap();
		System.err.println(map);
		conn.close();
	}
	@Test
	public void test() throws SQLException{
		Connection conn=DbUtils.getConn();
		DatabaseMetaData dbmt=conn.getMetaData();
		boolean isSupport=dbmt.supportsResultSetConcurrency(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
		dbmt.supportsResultSetType(ResultSet.TYPE_FORWARD_ONLY);
		System.err.println(isSupport);
	}
	
	@Test
	public void testProcedure() throws SQLException{
		Connection conn=DbUtils.getConn("oracle_test");
		String sql="{call sayhello2(?,?)}";
		CallableStatement statement=conn.prepareCall(sql);
		statement.setString(1, "gege");
		statement.registerOutParameter(2, Types.VARCHAR);
		statement.execute();
		String res=statement.getString(2);
		System.err.println(res);
	}
	@Test
	public void testFuction() throws SQLException{
		Connection conn=DbUtils.getConn("oracle_test");
		String sql="{?=call hello(?,?)}";
		CallableStatement statement=conn.prepareCall(sql);
		statement.registerOutParameter(1, Types.VARCHAR);
		statement.setString(2, "gege");
		statement.registerOutParameter(3, Types.VARCHAR);
		statement.execute();
		String res=statement.getString(1);
		String out=statement.getString(3);
		System.err.println(res);
		System.err.println(out);
	}
	@Test
	public void testFuction2() throws SQLException{
		Connection conn=DbUtils.getConn("oracle_test");
		String sql="{?=call hello_cursor(?,?)}";
		CallableStatement statement=conn.prepareCall(sql);
		statement.registerOutParameter(1, Types.VARCHAR);
		statement.setString(2, "gege");
		statement.registerOutParameter(3, OracleTypes.CURSOR);
		statement.execute();
		String res=statement.getString(1);
		ResultSet rs=(ResultSet) statement.getObject(3);
		while(rs.next()){
			System.err.println(rs.getString(1)+"  "+rs.getString(2)+"  "+rs.getString(3));
		}
		System.err.println(res);
//		System.err.println(out);
	}
	@Test
	public void testGeneratedKeys() throws SQLException{
/*		Connection conn=DbUtils.getConn(MYSQL);
		String sql="insert into t_key(name,age) values (?,?)";*/
		Connection conn=DbUtils.getConn(ORACLE);
		String sql="insert into t_user(name,pass) values (?,?)";
		PreparedStatement pstmt=conn.prepareStatement(sql,new int[]{1});
		pstmt.setString(1, "lisi");
		pstmt.setString(2, "21");
		pstmt.executeUpdate();
		ResultSet rs=pstmt.getGeneratedKeys();
		rs.next();
		String id=rs.getString(1);
		System.err.println(id);
	}
	@Test
	public void testGeneratedKeys2() throws SQLException{
		Connection conn=DbUtils.getConn(MYSQL);
//		String sql="insert into t_user(name,pass) values (?,?)";
		String sql=" update t_user set name=?,pass=? where id=?";
//		Connection conn=DbUtils.getConn(ORACLE);
//		String sql="insert into t_user(name,pass) values (?,?)";
		PreparedStatement pstmt=conn.prepareStatement(sql,new int[]{1});
		pstmt.setString(1, "lisi");
		pstmt.setString(2, "21");
		pstmt.setString(3, "5");
		pstmt.executeUpdate();
		ResultSet rs=pstmt.getGeneratedKeys();
		rs.next();
		String id=rs.getString(1);
		System.err.println(id);
	}
	@Test
	public void testSetNull() throws SQLException{
		/*		Connection conn=DbUtils.getConn(MYSQL);
		String sql="insert into t_key(name,age) values (?,?)";*/
		Connection conn=DbUtils.getConn(ORACLE);
		String sql="insert into t_user(name,pass) values (?,?)";
		PreparedStatement pstmt=conn.prepareStatement(sql);
		pstmt.setString(1, "hello");
		pstmt.setNull(2,Types.VARBINARY);
		pstmt.executeUpdate();
	}
}
