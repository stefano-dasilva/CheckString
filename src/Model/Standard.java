package Model;
import Dao.Interface.Bean;
import com.sun.istack.NotNull;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity

@Table (name = "standard")

public class Standard  {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "code", unique = true)
   private String code;
	@Column(name = "value", unique = true)
	@NotNull
   private String value;
	@Column(name = "num_ricerche")
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
	return "Model.Standard [code=" + code + ", value=" + value + "]";
}

	

}
