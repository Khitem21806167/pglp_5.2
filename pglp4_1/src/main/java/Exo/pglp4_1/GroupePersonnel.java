package Exo.pglp4_1;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class GroupePersonnel extends TypePersonnel implements Serializable{
	
	private List<TypePersonnel> ListedePersonnel= new ArrayList<TypePersonnel>();
	
	@Override
	public boolean pers() {
		return true;
	}
	
	public void GroupPersonnel() {
		ListedePersonnel = new ArrayList<TypePersonnel>();
	}
	
	public void addP(TypePersonnel p) {
		ListedePersonnel.add(p);
	}
	
	public void removeP(TypePersonnel p) {
		ListedePersonnel.remove(p);
	}
	
	public List<TypePersonnel> afficherTout(){
		return ListedePersonnel;
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
		
		public static GroupePersonnel deserialiser(String FileSource)
		{
			GroupePersonnel e=null;
			try {
		         FileInputStream fileIn = new FileInputStream(FileSource);
		         ObjectInputStream in = new ObjectInputStream(fileIn);
		         e = (GroupePersonnel) in.readObject();
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
