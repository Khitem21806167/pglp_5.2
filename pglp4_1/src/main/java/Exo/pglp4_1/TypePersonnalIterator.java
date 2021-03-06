package Exo.pglp4_1;
import java.util.Iterator;
import java.util.Collection;
import java.util.NoSuchElementException;

public abstract class TypePersonnalIterator implements Iterator<TypePersonnel> {
	
	protected GroupePersonnel racine;
	protected Collection<TypePersonnel> collection;

	public TypePersonnalIterator(GroupePersonnel gp,
			 Collection<TypePersonnel> collection) {
		this.racine = gp;
		this.collection = collection;
		this.collection.addAll(racine.afficherTout());
	}

	@Override
	public boolean hasNext() {
		return !collection.isEmpty();
	}

	@Override
	public TypePersonnel next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        TypePersonnel pt = getFromCollection();
        if(pt.pers()) {
        	collection.addAll(((GroupePersonnel) pt).afficherTout());
        }
		return pt;
	}

	abstract protected TypePersonnel getFromCollection();

	public TypePersonnel getRacine() {
		return racine;
	}


}
