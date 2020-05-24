package dao;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectingToDb {
	
	static public Connection getConnected()
	{
		Connection connect=null;
	    Statement stmt = null;

		try {
	    	connect = DriverManager.getConnection("jdbc:derby:myDB"); 

	    	}catch(Exception except) {
	  	            except.printStackTrace();
	 	       }
	    	
		
				if(connect!=null) {
		         try {
				stmt = connect.createStatement();
				
		         String sqlPersonnel = "CREATE TABLE Personnel(nom VARCHAR(100) PRIMARY KEY, prenom VARCHAR(100), dateNais Date, numtel varchar(100) [], fonctions varchar(100) [])";
		         
		         String sqlGroupe = "CREATE TABLE GroupePersonnel " +
	                     "(id VARCHAR(100) PRIMARY KEY,"+
	                     " listePers varchar(100) [])";
		        
		         
			       DatabaseMetaData dbm = connect.getMetaData();
			      // check if "FORME" table is there
			      ResultSet tables = dbm.getTables(null, null, "Personnel", null);
			      if (!tables.next()) 
			      {
			    	  PreparedStatement pstmt = connect.prepareStatement(sqlPersonnel);
				    	 	    	 
			    	  pstmt.executeUpdate();
			      }
			    
			      tables = dbm.getTables(null, null, "GroupePersonnel", null);
			      if (!tables.next()) {
			    	  PreparedStatement pstmt = connect.prepareStatement(sqlGroupe);
				    	 	    	 
			    	  pstmt.executeUpdate();
				    	
				      }  
				} catch(Exception e){
					e.printStackTrace();
				}finally{
				      //finally block used to close resources
				      try{
				         if(stmt!=null)
				            connect.close();
				      }catch(SQLException se){
				      }// do nothing
				      try{
				         if(connect!=null)
				            connect.close();
				      }catch(SQLException se){
				         se.printStackTrace();
				      }//end finally try
				   }//end try	
			      
		        
		         
			
				}else
				{
					System.out.println("Not Connected to DB");
				}
		return connect;
	}

}
