import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class DBnamephonenum {
	 // JDBC driver name and database URL
	
	   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	   static final String DB_URL = "jdbc:mysql://#ipaddress#/#databasename#";

	   //  Database credentials
	   static final String USER = "#username#";
	   static final String PASS = "#Password#";
	
	   
	  public List<agent> getagents()
	  {
		  String id ="";
		  List<agent> listagent = new ArrayList<agent>();
		 // listphonenumber.add("8097272831");
		  //listphonenumber.add("9833452109");
		   Connection conn = null;
		   Statement stmt = null;
		   try{
			      //STEP 2: Register JDBC driver
			      Class.forName("com.mysql.jdbc.Driver");

			      //STEP 3: Open a connection
			      System.out.println("Connecting to database...");
			      conn = DriverManager.getConnection(DB_URL,USER,PASS);

			      //STEP 4: Execute a query
			      System.out.println("Creating statement...");
			      stmt = conn.createStatement();
			      String sql;
			      sql = "SELECT tud.aname,tu.phoneno FROM tbl_users tu JOIN tbl_userdetails tud ON tud.uid=tu.uid";
			      
			      //where tu.uid in (1,29,45)
			      ResultSet rs = stmt.executeQuery(sql);

			      //STEP 5: Extract data from result set
			    int i=0;
			      while(rs.next()){
			         //Retrieve by column name
			    	  agent a=new agent();
			    	  a.setName(rs.getString("aname"));
			    	  a.setNumber(rs.getString("phoneno"));
			     //   id = rs.getString("phoneno");
			    	  listagent.add(a);
			    	  i=i+1;
			    	  System.out.println("-------"+i);
			         //Display values
			       //  System.out.print("ID: " + id);
			     
			      }
			      //STEP 6: Clean-up environment
			      rs.close();
			      stmt.close();
			      conn.close();
				  
			   }catch(SQLException se){
				      //Handle errors for JDBC
				      se.printStackTrace();
				   }catch(Exception e){
				      //Handle errors for Class.forName
				      e.printStackTrace();
				   }finally{
				      //finally block used to close resources
				      try{
				         if(stmt!=null)
				            stmt.close();
				      }catch(SQLException se2){
				      }// nothing we can do
				      try{
				         if(conn!=null)
				            conn.close();
				      }catch(SQLException se){
				         se.printStackTrace();
				      }//end finally try
				   }//end try
				   System.out.println("Goodbye!");
				  
				   return listagent;
	  }
}
