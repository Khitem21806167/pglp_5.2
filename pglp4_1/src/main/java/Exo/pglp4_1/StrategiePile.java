package Exo.pglp4_1;
import java.util.Stack;

public class StrategiePile extends TypePersonnalIterator {
	
	public StrategiePile(GroupePersonnel pg) {
		super(pg, new Stack<TypePersonnel>());
	}

	@Override
	protected TypePersonnel getFromCollection() {
		return ((Stack<TypePersonnel>) collection).pop();
	}

}
