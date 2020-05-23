package Exo.pglp4_1;

public class TypeTelephone {
	private String Type;
	private String numero ;
	
	public String getType() {
		return Type;
	}
	public void setType(String type) {
		Type = type;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	
	public TypeTelephone(String Type, String numero){
		this.Type=Type;
		this.numero=numero;
	}

}
