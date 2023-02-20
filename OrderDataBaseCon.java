package com.Ravi.sprintbootRavi;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderDataBaseCon {
	
	@Autowired
	DataSource dataSource;
	
	

//    private static String instemp="insert into employees values((select max(employee_id)+1 from employees),"
//    		+ "FIRST_NAME,LAST_NAME,EMAIL,PHONE,HIRE_DATE,10,JOB_TITLE,SALARY)";
    
//   private static String instemp="insert into orders values((select max(order_id)+1 from orders),"
//    		+ "ORDER_ID,CUSTOMER_ID,STATUS,SALESMAN_ID,ORDER_DATE)";
    
    private static final String udpOrder ="update orders set CUSTOMER_ID=?,STATUS=? where order_id=?";
    private static final String deleteOrder ="delete from orders where order_id=?";

    
    
    public int insertOrders(List<OrderData> ODS) {
    	
    	int result=0;
try {
	for(OrderData OD:ODS) {
		String instemp="insert into orders values((select max(order_id)+1 from orders),"
    		+ "CUSTOMER_ID,STATUS,SALESMAN_ID,ORDER_DATE)";
	    
		instemp =instemp
				.replace("CUSTOMER_ID",Long.toString(OD.getCustomer_id()))
				.replace("STATUS", "'"+OD.getStatus()+"'")
				.replace("SALESMAN_ID",Long.toString(OD.getSalesman_id()))
				.replace("ORDER_DATE","sysdate");
				System.out.println(instemp);
		Statement stmt =  dataSource.getConnection().createStatement();
		result +=  stmt.executeUpdate(instemp);
			
	}
			
} catch (SQLException e) {
	e.printStackTrace();
}	
		return result;
}
    	
    


public int insertOrder(OrderData OD) {

int result=0;
try {
String instemp="insert into orders values((select max(order_id)+1 from orders),"
+ "ORDER_ID,CUSTOMER_ID,STATUS,SALESMAN_ID,ORDER_DATE)";


if(OD!=null) {
instemp =instemp
.replace("CUSTOMER_ID", Long.toString(OD.getCustomer_id()))
.replace("STATUS", "'"+OD.getStatus()+"'")
.replace("SALESMAN_ID", Long.toString(OD.getSalesman_id()))
.replace("ORDER_DATE","sysdate");
System.out.println(instemp);

Statement stmt =  dataSource.getConnection().createStatement();
result =stmt.executeUpdate(instemp);

}

} catch (SQLException e) {
e.printStackTrace();
}	
return result;

}

public int updateOrder(OrderData OD) {
int result=0;
try {
//update employees set first_name=?,last_name=? where empl_id=?
PreparedStatement preparestmt =  dataSource.getConnection().prepareStatement(udpOrder);
//
preparestmt.setInt(1, OD.getCustomer_id());
//	update employees set first_name='microcare' where empl_id=?
preparestmt.setString(2, OD.getStatus());
preparestmt.setInt(3, OD.getOrder_id());
//update employees set first_name='microcare' where empl_id=353523
 result =preparestmt.executeUpdate();



} catch (SQLException e) {
e.printStackTrace();
}
return result;



}

public int deleteOrder(int order_id) {
int result=0;
try {
	PreparedStatement preparestmt =  dataSource.getConnection().prepareStatement(deleteOrder);
	preparestmt.setString(1, "Order_id");
    result =preparestmt.executeUpdate();
} catch (SQLException e) {
	e.printStackTrace();
}
return result;



}


public List<OrderData> getOrders(){
List<OrderData> orders = new ArrayList<OrderData>();
OrderData OD;

try {

Statement stmt = dataSource.getConnection().createStatement();
ResultSet rs =stmt.executeQuery("select * from orders");			
while(rs.next()) {
OD=new OrderData();
OD.setOrder_id(rs.getInt("ORDER_ID"));
OD.setCustomer_id(rs.getInt("CUSTOMER_ID"));
OD.setStatus(rs.getString("STATUS"));
OD.setSalesman_id(rs.getInt("SALESMAN_ID"));
OD.setOrder_Date(rs.getDate("ORDER_DATE").toLocalDate());
orders.add(OD);
}

} catch (SQLException e) {
e.printStackTrace();
}
return orders;

}


public  OrderData getOrder(int order_id) {

	OrderData OD =new OrderData();

try {

Statement stmt = dataSource.getConnection().createStatement();
ResultSet rs =stmt.executeQuery("select * from orders where order_id="+order_id);			
while(rs.next()) {
OD.setOrder_id(rs.getInt("ORDER_ID"));
OD.setCustomer_id(rs.getInt("CUSTOMER_ID"));
OD.setStatus(rs.getString("STATUS"));
OD.setSalesman_id(rs.getInt("SALESMAN_ID"));
OD.setOrder_Date(rs.getDate("ORDER_DATE").toLocalDate());
}

} catch (SQLException e) {
e.printStackTrace();
}
return OD;
}

}

	

