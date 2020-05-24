package dao;

import java.sql.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import Exo.pglp4_1.Personnel;

public class PersonnelSerialDAO implements DAO<Personnel> {
	Connection c=ConnectingToDb.getConnected();
	PersonnelSerialDAO(){}

	@Override
	public Personnel create(Personnel obj) {
		// TODO Auto-generated method stub
		try {
			PreparedStatement prepare = c.prepareStatement("INSERT INTO Personnel(nom, prenom, dateNais, numtel, fonctions) VALUES(?, ?, ?, ?, ?)");
			prepare.setString(1, obj.getNom());
			prepare.setString(2, obj.getPrenom());
			prepare.setDate(3, java.sql.Date.valueOf(obj.getDateNais()));

			 Object tel[] = new Object[ obj.getNumtel().size()]; 
			  
		        // ArrayList to Array Conversion 
		        for (int j = 0; j < obj.getNumtel().size(); j++) { 
		  
		            // Assign each value to String array 
		            tel[j] =  obj.getNumtel().get(j); 
		        } 
		        Array array = c.createArrayOf("VARCHAR", tel);
				prepare.setArray(4, array);
			
			// declaration and initialise String Array 
	        Object str[] = new Object[ obj.getFonctions().size()]; 
	  
	        // ArrayList to Array Conversion 
	        for (int j = 0; j < obj.getFonctions().size(); j++) { 
	  
	            // Assign each value to String array 
	            str[j] =  obj.getFonctions().get(j); 
	        } 
	        
			Array array2 = c.createArrayOf("VARCHAR", str);
			prepare.setArray(5, array2);
			
			int result = prepare.executeUpdate();
			assert result == 1;
			System.out.println("Personnel ajoutée dans la BDD");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return obj;	
	}

	@Override
	public Personnel read(String nom) {
		// TODO Auto-generated method stub
		Personnel obj = null;
		try {
			PreparedStatement prepare = c.prepareStatement("SELECT * FROM Personnel WHERE nom=?");
			prepare.setString(1, nom);
			ResultSet result = prepare.executeQuery();
			while(result.next()) {
				System.out.println("uu");
				obj = new Personnel(nom,result.getString("prenom"),result.getDate("dateNais"),result.getArray("numtel"),result.getArray("fonctions"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return obj;	}

	@Override
	public Personnel update(Personnel obj) {
		// TODO Auto-generated method stub
		try {
			PreparedStatement prepare = c.prepareStatement("UPDATE Personnel SET nom = ?, prenom = ?, dateNais = ?, numtel = ?, fonctions = ? WHERE nom = ?");
			prepare.setString(1, obj.getNom());
			prepare.setString(2, obj.getPrenom());
			prepare.setDate(3, java.sql.Date.valueOf(obj.getDateNais()));

			 Object tel[] = new Object[ obj.getNumtel().size()]; 
			  
		        // ArrayList to Array Conversion 
		        for (int j = 0; j < obj.getNumtel().size(); j++) { 
		  
		            // Assign each value to String array 
		            tel[j] =  obj.getNumtel().get(j); 
		        } 
		        Array array = c.createArrayOf("VARCHAR", tel);
				prepare.setArray(4, array);
			
			// declaration and initialise String Array 
	        Object str[] = new Object[ obj.getFonctions().size()]; 
	  
	        // ArrayList to Array Conversion 
	        for (int j = 0; j < obj.getFonctions().size(); j++) { 
	  
	            // Assign each value to String array 
	            str[j] =  obj.getFonctions().get(j); 
	        } 
	        
			Array array2 = c.createArrayOf("VARCHAR", str);
			prepare.setArray(5, array2);
			int result = prepare.executeUpdate();
			assert result == 1;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return obj;
	}

	@Override
	public void delete(Personnel obj) {
		// TODO Auto-generated method stub
		try {
			PreparedStatement prepare = c.prepareStatement("DELETE Personnel WHERE nom = ?");
			prepare.setString(1, obj.getNom());
			int result = prepare.executeUpdate();
			assert result == 1;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
