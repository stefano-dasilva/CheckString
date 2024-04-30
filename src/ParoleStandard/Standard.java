package ParoleStandard;

public class Standard {
	// QUESTO ATTRIBUTO ID DEV'ESSERE UTILIZZATO DA HIBERNATE
	private int id;
   private String code;
   private String value;
   private int numRicerche;
public String getCode() {
	return code;
}
public void setCode(String code) {
	this.code = code;
}
public String getValue() {
	return value;
}
public void setValue(String value) {
	this.value = value;
}

// HIBERNATE HA BISOGNO DI UN COSTRUTTORE VUOTO DI DEFAULT QUANDO VA A RECUPERARE ED ISTANZIARE DAL DATABASE
public Standard(){

}
public Standard(int id,String code, String value,int numRicerche ) {

	this.code = code;
	this.value = value;
	this.numRicerche = numRicerche;
	this.id = id;
}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNumRicerche() {
		return numRicerche;
	}

	public void setNumRicerche(int numRicerche) {
		this.numRicerche = numRicerche;
	}

	@Override
public String toString() {
	return "ParoleStandard.Standard [code=" + code + ", value=" + value + "]";
}

	

}
