package dao;

import java.sql.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Exo.pglp4_1.GroupePersonnel;
import Exo.pglp4_1.TypePersonnel;

public class GroupePersonnelSerialDAO implements DAO<GroupePersonnel> {
	//private List<TypePersonnel> ListedePersonnel= new ArrayList<TypePersonnel>();
	Connection c=ConnectingToDb.getConnected();
	GroupePersonnelSerialDAO(){}
	
	@Override
	public GroupePersonnel create(GroupePersonnel obj) {
		// TODO Auto-generated method stub
		try {
			PreparedStatement prepare = c.prepareStatement("INSERT INTO GroupePersonnel(id ,listePers) VALUES( ?, ?)");
			prepare.setString(1, obj.getId());

			 Object liste[] = new Object[obj.getListedePersonnel().size()]; 
			  
		        // ArrayList to Array Conversion 
		        for (int j = 0; j < obj.getListedePersonnel().size(); j++) { 
		  
		            // Assign each value to String array 
		            liste[j] = obj.getListedePersonnel().get(j); 
		        } 
		        Array array = c.createArrayOf("VARCHAR", liste);
				prepare.setArray(2, array);
			
			int result = prepare.executeUpdate();
			assert result == 1;
			System.out.println("GroupePersonnel ajoutée dans la BDD");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return obj;		}

	@Override
	public GroupePersonnel read(String id) {
		// TODO Auto-generated method stub
		GroupePersonnel obj = null;
		try {
			PreparedStatement prepare = c.prepareStatement("SELECT * FROM Carre WHERE id=?");
			prepare.setString(1, id);
			ResultSet result = prepare.executeQuery();
			while(result.next()) {
				System.out.println("uu");
				obj = new GroupePersonnel(id, result.getArray("listePers"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return obj;
	}

	@Override
	public GroupePersonnel update(GroupePersonnel obj) {
		// TODO Auto-generated method stub
		try {										
			PreparedStatement prepare = c.prepareStatement("UPDATE GroupePersonnel SET id = ?, listePers = ? WHERE nom = ?");
			prepare.setString(1, obj.getId());

			 Object liste[] = new Object[obj.getListedePersonnel().size()]; 
			  
		        // ArrayList to Array Conversion 
		        for (int j = 0; j < obj.getListedePersonnel().size(); j++) { 
		  
		            // Assign each value to String array 
		            liste[j] = obj.getListedePersonnel().get(j); 
		        } 
		        Array array = c.createArrayOf("VARCHAR", liste);
				prepare.setArray(2, array);
			int result = prepare.executeUpdate();
			assert result == 1;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return obj;
	}

	@Override
	public void delete(GroupePersonnel obj) {
		// TODO Auto-generated method stub
		try {
			PreparedStatement prepare = c.prepareStatement("DELETE GroupePersonnel WHERE id = ?");
			prepare.setString(1, obj.getId());
			int result = prepare.executeUpdate();
			assert result == 1;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
