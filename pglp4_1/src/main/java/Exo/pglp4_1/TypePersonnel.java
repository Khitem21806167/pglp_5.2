package Exo.pglp4_1;

public abstract class TypePersonnel {
	abstract public boolean pers();
	
	public String typeString() {
		if (pers()) {
				return "je suis personnel" ;}
				else return "je suis un groupe" ;
	}

}
