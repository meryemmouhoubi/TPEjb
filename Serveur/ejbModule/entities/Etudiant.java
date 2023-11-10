package entities;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;

@Entity
public class Etudiant extends User implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String firstName;
	private String lastName;
	private String telephone;
	@ManyToOne
	private Filiere filiere;

	public Etudiant() {
		super();
	}
	


	public Etudiant(String login, String mdp, String firstName, String lastName, String telephone, Filiere filiere) {
		super(mdp, login);
		this.firstName = firstName;
		this.lastName = lastName;
		this.telephone = telephone;
		this.filiere = filiere;
	}



	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getTelephone() {
		return telephone;
	}


	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}


	public Filiere getFiliere() {
		return filiere;
	}


	public void setFiliere(Filiere filiere) {
		this.filiere = filiere;
	}



	@Override
	public String toString() {
		return "Etudiant [firstName=" + firstName + ", lastName=" + lastName + ", telephone=" + telephone + ", filiere="
				+ filiere + ", id=" + id + ", password=" + password + ", login=" + login + "]"+ "Roles :" + getRoles();
	}
	
	

	
	

}
