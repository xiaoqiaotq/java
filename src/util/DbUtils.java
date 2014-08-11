package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import org.apache.commons.dbutils.QueryRunner;
import org.logicalcobwebs.proxool.ProxoolDataSource;
import org.logicalcobwebs.proxool.ProxoolException;
import org.logicalcobwebs.proxool.configuration.JAXPConfigurator;

public class DbUtils {
	private static Connection conn;
	private static ProxoolDataSource dataSource;
	private static ThreadLocal<Connection> t=new ThreadLocal<Connection>(){@Override
		protected Connection initialValue() {
			// TODO Auto-generated method stub
			try {
				return dataSource.getConnection();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new RuntimeException();
			}
		}};
	static{
		try {
			JAXPConfigurator.configure("src/proxool.xml", false);
		} catch (ProxoolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	public static Connection getConn(String dbName){
		dataSource=new ProxoolDataSource(dbName);
		return conn=t.get();
		
	}
	public static Connection getConn(){
		return getConn("mysql");
	}
	public static DataSource getDataSource(){
		return dataSource;
	}
	public static void main(String[] args) throws SQLException{
		Connection conn1=getConn();
		Statement st=conn1.createStatement();
		boolean b=st.execute("select * from user");
		b=st.execute("use mysql");
		 b=st.execute("select * from help_category");
		if(b){
			ResultSet rs=st.getResultSet();
			while(rs.next()){
				System.err.println(rs.getString(1)+" "+rs.getString(2));
			}
		}
		System.err.println(b);
	
	}
}
