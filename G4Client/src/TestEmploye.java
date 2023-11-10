import java.util.Hashtable;



import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sound.midi.Soundbank;

import dao.IDao;
import entities.Etudiant;
import entities.Filiere;

public class TestEmploye {
	public static IDao<Etudiant> lookUpStudentRemote() throws NamingException {
		final Hashtable jndiProperties = new Hashtable();
		jndiProperties.put(Context.INITIAL_CONTEXT_FACTORY, "org.wildfly.naming.client.WildFlyInitialContextFactory");
		jndiProperties.put(Context.PROVIDER_URL, "http-remoting://localhost:8080");
		final Context context = new InitialContext(jndiProperties);

		return (IDao<Etudiant>) context.lookup("ejb:EARProjet/Serveur/EtudiantService!dao.IDao");

	}

	
	
	public static IDao<Filiere> lookUpFiliereRemote() throws NamingException {
		final Hashtable jndiProperties = new Hashtable();
		jndiProperties.put(Context.INITIAL_CONTEXT_FACTORY, "org.wildfly.naming.client.WildFlyInitialContextFactory");
		jndiProperties.put(Context.PROVIDER_URL, "http-remoting://localhost:8080");
		final Context context = new InitialContext(jndiProperties);

		return (IDao<Filiere>) context.lookup("ejb:/G4Serveur/FiliereDao!dao.IDao");

	}
	
	public static void main(String[] args) {
		try {
			IDao<Etudiant> dao = lookUpStudentRemote();
			IDao<Filiere> daof = lookUpFiliereRemote();
			Filiere f1=daof.create(new Filiere(1,"IIR"));
			Filiere f2=daof.create(new Filiere(2,"GC"));
			dao.create(new Eudiant("pass1","naja","Mohamed","Naja",f1));
			dao.create(new Eudiant("pass2","meryem","mouhoubi","Polan",f1));
			dao.create(new Eudiant("pass3","sana","Soufiane","latex",f1));
			dao.create(new Eudiant("pass4","laila","Inssaf","Daln",f2));
			
			for(Eudiant e: dao.findAll())
				System.out.println(e.getFirstName()+"-> filiere : "+e.getFiliere().getName());
			
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
