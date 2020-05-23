package dao;

import Exo.pglp4_1.GroupePersonnel;
import Exo.pglp4_1.Personnel;

public class DAOFactory {
	
	public DAO<Personnel> getPersonnelDAO() {
		return new PersonnelSerialDAO();
	}
	
	public DAO<GroupePersonnel> getPersonnelGroupeDAO() {
		return new GroupePersonnelSerialDAO();
	}

}
