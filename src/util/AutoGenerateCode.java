
package util;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Types;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.Test;

public class AutoGenerateCode {
	@Test
	public void table2javaBean() throws SQLException{
		Connection conn=DbUtils.getConn();
		String table="T_WORK_ORDER_DESIGN";
		PreparedStatement ps=conn.prepareStatement("select * from "+table);
		ResultSet rs=ps.executeQuery();
		ResultSetMetaData rsmd=rs.getMetaData();
		int size=rsmd.getColumnCount();
	    rs=conn.getMetaData().getPrimaryKeys(conn.getCatalog(), null, table);
	    
//	    while(rs.next()){
//	    	System.err.println(rs.getString("COLUMN_NAME"));
//	    	System.err.println(rs.getString("PK_NAME"));
//	    	System.err.println(rs.getString("TABLE_CAT"));
//	    	System.err.println(rs.getString("TABLE_SCHEM"));
//	    	System.err.println(rs.getString("TABLE_NAME"));
//	    }
		System.err.println("-------------------java---------------------");
		for (int i = 0; i < size; i++) {
			int type=rsmd.getColumnType(i+1);
			String javaType=null;
			javaType = getType(type);
			System.err.println("private"+"\t"+javaType+"\t"+transfer(rsmd.getColumnName(i+1))+";");
		}
		System.err.println("-------------------flex---------------------");
		for (int i = 0; i < size; i++) {
			int type=rsmd.getColumnType(i+1);
			String javaType=null;
			javaType = getType(type);
			System.err.println("public"+"\t"+"var"+"  "+transfer(rsmd.getColumnName(i+1))+":"+javaType+";");
		}
		System.err.println("------------------SELECT---------------------");
		System.err.println("SELECT");
		StringBuffer sb=new StringBuffer();
		String[] simpleTblNm=table.split("_");
		for (String string : simpleTblNm) {
			sb.append(string.charAt(0));
		}
		for (int i = 0; i < size; i++) {
			System.err.println("   "+sb.substring(1)+"."+rsmd.getColumnName(i+1)+"\t"+transfer(rsmd.getColumnName(i+1))+"\t"+",");
		}
		System.err.println("FROM");
		System.err.println("   "+table);
		System.err.println("-------------------INSERT------------------------");
		System.err.println("INSERT INTO "+table);
		System.err.println("  (");
		for (int i = 0; i < size; i++) {
			System.err.println("   "+rsmd.getColumnName(i+1)+" "+",");
		}
		System.err.println("  )");
		System.err.println("VALUES");
		System.err.println("  (");
		for (int i = 0; i < size; i++) {
			//echo("'" + fkCheckNo + "',");
			System.err.println("   "+"echo(\"'\" + "+transfer(rsmd.getColumnName(i+1))+" + \"',\");");
		}
		for (int i = 0; i < size; i++) {
			//#assetsId#,
			System.err.println("   "+"#"+transfer(rsmd.getColumnName(i+1))+"#,");
		}
		System.err.println("  )");
		System.err.println("---------------------update------------------------");
		System.err.println("UPDATE");
		System.err.println("\t"+table);
		System.err.println("SET");
		for (int i = 0; i < size; i++) {
			//			echo("ORDER_NUM='" + order_num + "',");
			System.err.println("   "+"echo(\""+rsmd.getColumnName(i+1)+"='\" + "+transfer(rsmd.getColumnName(i+1))+" + \"',\");");
		}
		System.err.println("   "+"echo(\" WHERE \");");
		while(rs.next()){
			String pk=rs.getString("COLUMN_NAME");
			System.err.println("   "+"echo(\" AND "+pk+"='\" + "+transfer(pk)+" + \"'\");");
		}
		
	}
	/**
	 *   WM.FK_CHECK_NO --->WM.FK_CHECK_NO fkCheckNo ,
	 */
	@Test
	public void column2JavaBean() {
		String src=readXML();
		String[] columns=src.split(",");
		
		for (int i = 0; i < columns.length; i++) {
			String col = columns[i];
			String before=col;
				
				String property=transfer(col.substring(col.indexOf(".")+1));
				System.err.println(before +"\t"+property+",");
			
		}
	}
	/**
	 *  WM.FK_CHECK_NO fkCheckNo---> private String	fkCheckNo;,
	 */
	@Test
	public void column2JavaBean4() {
		String src=readXML();
		String[] columns=src.split(",");
		
		for (int i = 0; i < columns.length; i++) {
			String col = columns[i];
			
			String property=col.replaceAll("\\w+\\.\\w+", "").trim();
			System.err.println("private String" +"\t"+property+";");
			
		}
	}
	/**
	 *   WM.FK_CHECK_NO ---->private String	fkCheckNo ;
	 */
	@Test
	public void column2JavaBean2() {
		String src=readXML();
  
		String[] columns=src.split(",");
		
		for (int i = 0; i < columns.length; i++) {
			String col = columns[i];
			String property=transfer(col.substring(col.indexOf(".")+1));
			System.err.println("private String" +"\t"+property+";");
			
		}
	}
	@Test
	public void testsssss(){
		String res="D.CASE_SIZE_WIDTH	caseSizeWidth,".replaceAll("\\w+\\.\\w+", "").trim();
		System.err.println(res);
	}
	/**
	 *   WM.FK_CHECK_NO ---->${bean.fkCheckNo};
	 */
	@Test
	public void column2JavaBean3() {
		Class clazz=null;
		while(!clazz.equals(Object.class)){
			Field[] fields=clazz.getDeclaredFields();
			for (Field field : fields) {
				System.err.println("name='"+field.getName()+"'  "+"value='${bean."+field.getName()+"}'");
			
				
			}
			clazz=clazz.getSuperclass();
		}
	}
	
	

	private String getType(int type) {
		String javaType="";
		switch(type){
		 case Types.VARCHAR:
			 javaType="String";
			 break;
		 case Types.CHAR:
			 javaType="String";
			 break;
		 case Types.DOUBLE:
			 javaType="double";
			 break;
		 case Types.NUMERIC:
			 javaType="double";
			 break;
		 case Types.DATE:
			 javaType="Date";
			 break;
		 case Types.TIMESTAMP:
			 javaType="Date";
			 break;
		 case Types.INTEGER:
			 javaType="int";
		}
		return javaType;
	}
	/**
	 *  USER_ID --->userId
	 * @param column
	 * @return
	 */
	private String transfer(String column){
		String[] temp=column.split("_");
		StringBuffer res=new StringBuffer();
		for (int i = 0; i < temp.length; i++) {
			String string = temp[i];
			res.append(string.substring(0,1).toUpperCase());
			res.append(string.substring(1).toLowerCase());
		}
		return res.toString().substring(0,1).toLowerCase()+res.toString().substring(1);
	}
	
	public String readXML(){
		String s="";
      try {
    	  SAXReader reader = new SAXReader();  
    	  Document   document =  reader.read(this.getClass().getClassLoader().getResourceAsStream("input.xml"));
    	  Element root=document.getRootElement();
    	  s=root.getStringValue();
//    	  System.err.println(s.replaceAll("\\s+", " "));
//    	  System.err.println(s);
    	 
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return s.replaceAll(",\\s+", ",").trim();
	}

}
