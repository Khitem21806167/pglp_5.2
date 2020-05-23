package Exo.pglp4_1;
import java.util.Vector;

public class StrategieVecteur extends TypePersonnalIterator {
	public StrategieVecteur(GroupePersonnel gp) {
		super(gp, new Vector<TypePersonnel>());
	}
	
	@Override
	protected TypePersonnel getFromCollection() {
		return ((Vector<TypePersonnel>) collection).remove(collection.size()-1);
	}

}
