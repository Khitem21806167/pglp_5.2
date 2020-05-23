package Exo.pglp4_1;

public interface Itertaor<TypePErsonnel>{
	
	public TypePersonnel next() ;/*Returns the next element in the iteration.
	**if the iteration has no more elements it throws
	*NoSuchElementException 
	*
	*/
public boolean hasnext() ;//Returns true if the iteration has more elements.


}
