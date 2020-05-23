package Exo.pglp4_1;
import java.time.LocalDate;

import java.time.format.DateTimeFormatter;

import Exo.pglp4_1.Personnel.Builder;

//pour l'execution mvn package exec:java

public enum ImmuablePersonnel {
ENVIRONNEMENT;
	

	private GroupePersonnel init() {
		Builder pb = new Builder("khamari", "nor el khitem")
				.fonctions("etudiante")
				.fonctions("agent de production")
				.fonctions("agent de tri")
				.dateNais(1997,4,11)
				.numtel(new TypeTelephone("fix1","05521852"))
				.numtel(new TypeTelephone("fix2","014785632"))
				.numtel(new TypeTelephone("Fax", "0612345678"));
		
		Personnel p1 = pb.build(),
				  p2 = pb.build();
		Personnel p3 = pb.build(), 
				  p4 = pb.build();
		
		GroupePersonnel pg1 = new GroupePersonnel();
		GroupePersonnel pg2 = new GroupePersonnel();
		GroupePersonnel pg3 = new GroupePersonnel();
		
		
		pg1.addP(p1);
		pg2.addP(p2);
		pg1.addP(pg2);
		pg1.addP(p3);
		pg3.addP(p3);
		
		pg1.serialiser("./serialisation.txt");
		p1.serialiser("./serialisationpersonnel.txt");
		System.out.println(p1);
		return pg1;
	}	
	
	private void afficherParcours(TypePersonnalIterator pti) {
		System.out.println("-" + pti.getRacine().typeString());
		while (pti.hasNext()) {
			TypePersonnel personnelType = (TypePersonnel) pti.next();
			System.out.println("-" + personnelType.typeString());
		}
	}
	
	private void run(String[] args) {
		GroupePersonnel pg = init();
		
		System.out.println("Strategie en utilisant Vecteur : ");
		afficherParcours(new StrategieVecteur(pg));
		
		System.out.println("Strategie en utilisant unePile : ");
		afficherParcours(new StrategiePile(pg));

	}
	
	public static void main(String[] args) {
		ENVIRONNEMENT.run(args);
	}

}
