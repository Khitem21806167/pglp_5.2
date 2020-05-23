package Exo.pglp4_1;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDate;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.stream.Collectors;
import java.util.List;

public class Personnel extends TypePersonnel implements Serializable {
	private String nom;
	private String prenom; 
	private LocalDate dateNais;
	private Vector<TypeTelephone> numtel=new Vector<TypeTelephone>();
	private List<String> fonctions;
	
	
	public static class Builder {
		
		private String nom;
		private String prenom; 
		private LocalDate dateNais;
		private Vector<TypeTelephone> numtel=new Vector<TypeTelephone>();
		private List<String>  fonctions;
		
		
		/*public Builder (String nom ,String prenom){
			this.nom=nom;
			this.prenom=prenom ;
			}*/
		public Builder (String nom ,String prenom/*, List<String> fonctions*/){
			this.nom=nom;
			this.prenom=prenom ;
			fonctions = new ArrayList<>();		
			}
		
		public Builder dateNais(int annee, int mois, int jour) {
		      dateNais = LocalDate.of(annee, mois, jour);
		   
		      return this;
		    }
		
		
		public Builder numtel(TypeTelephone nt) {
			
			
			numtel.addElement(nt);
			
			return this;
		}
		
		public Builder fonctions(String f) {
			fonctions.add(f) ;
			return this ;
		}
			
		public Personnel build(){
			return new Personnel(this);
			
		}
		}

	
	//les getters et les setters des attributs
	
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public LocalDate getDateNais() {
		return dateNais;
	}

	public void setDateNais(LocalDate dateNais) {
		this.dateNais = dateNais;
	}

	public Vector<TypeTelephone> getNumtel() {
		return numtel;
	}

	public void setNumtel(Vector<TypeTelephone> numtel) {
		this.numtel = numtel;
	}

	public List<String> getFonctions() {
		return fonctions;
	}

	public void setFonctions(List<String> fonctions) {
		this.fonctions = fonctions;
	}

	//Constructeur Personnel(Builder b)	
	private Personnel(Builder b)
	{
		this.nom=b.nom;
		this.prenom= b.prenom;
		this.dateNais=b.dateNais;
		this.fonctions=b.fonctions;
		this.numtel=b.numtel;
	}

	//affichage les informations:
	//affiche le numero téléphone par une collection d’un type (TypeTelephone(type: perso, fix..) + le numero) 
	public String toString(){
		String s="";
		s="Nom: " + nom + " prenom:  " + prenom + " fonction:  " + fonctions + " date de naissance "
				+ dateNais.format(DateTimeFormatter.ISO_DATE) + " numero de telephone ";
		for(int i=0; i<numtel.size();i++)
		{
			s+=numtel.get(i).getType()+": "+numtel.get(i).getNumero()+" - ";
		}
		return s;
				//+numtel.stream()
				//.map(TypeTelephone::toString);
				//.collect(Collectors.toList());
	}

	@Override
	public boolean pers() {
		// TODO Auto-generated method stub
		return false;
	}
	//DEVELOPPONS EN JAVA (source)
	public void serialiser(String FileDestination) {
		
	  ObjectOutputStream oos = null;

	    try {
	      final FileOutputStream fichier = new FileOutputStream("mon_objet.ser");
	      if (fichier==null)
	      {
	    	  System.out.println("le fichier est nul");
	      }
	      oos = new ObjectOutputStream(fichier);
	      oos.writeObject(this);
	      
	    } catch (final java.io.IOException e) {
	      e.printStackTrace();
	    } finally {
	      try {
	        if (oos != null) {
	          oos.flush();
	          oos.close();
	        }
	      } catch (final IOException ex) {
	        ex.printStackTrace();
	      }
	    }
	}
	
	public static Personnel deserialiser(String FileSource)
	{
		Personnel e=null;
		try {
	         FileInputStream fileIn = new FileInputStream(FileSource);
	         ObjectInputStream in = new ObjectInputStream(fileIn);
	         e = (Personnel) in.readObject();
	         in.close();
	         fileIn.close();
	         return e;
	      } catch (IOException i) {
	         i.printStackTrace();
	         return null;
	      } catch (ClassNotFoundException c) {
	         c.printStackTrace();
	         return null;
	      }
	    
	}
	

}
