/**
 * 
 */
package intergiciels.forms;

import intergiciels.beans.User;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Jade BOUMAZA
 *
 */
public class SigninForm {
	
	private static final String CHAMP_MAIL = "mail";
	private static final String CHAMP_PASSWORD = "password";
	
	private Map<String, String> erreurs = new HashMap<String, String>(); 
	// Key : le champ correspondant à l'erreur, Value : le message d'erreur correspondant

	public Map<String, String> getErreurs() {
	    return erreurs;
	}

	public User connecterUser(HttpServletRequest request) {
		
	    String mail = getValeurChamp(request, CHAMP_MAIL);
	    String password = getValeurChamp(request, CHAMP_PASSWORD);
	   
	    User user = new User();

	    try {
	        validationMail(mail);
	    } catch (Exception e) {
	        setErreur(CHAMP_MAIL, e.getMessage());
	    }
	    user.setMail(mail);

	    try {
	        validationPassword(password);
	    } catch (Exception e) {
	        setErreur(CHAMP_PASSWORD, e.getMessage());
	    }
	    user.setPassword(password);

	    return user;
	}
	
	
	/**
	 * Vérifier que l'adresse mail entrée dans le champ email est non nulle
	 * et présente dans la BDD
	 * @param mail à valider
	 * @throws Exception
	 */
	private void validationMail(String mail) throws Exception {
		if (mail == null || mail.length() == 0) {
			throw new Exception("Merci de saisir une adresse mail.");
		}
		// A FAIRE : Vérifier présence dans BDD
	}
	
	/**
	 * Vérifier que le mot de passe entré dans le champ password est non vide,
	 * et correspond au mot de passe correspondant au mail dans BDD
	 * @param password
	 */
	private void validationPassword(String password) throws Exception {
		if (password == null || password.length()==0) {
				throw new Exception("Merci de saisir le mot de passe.");
		}
		// A FAIRE : Vérifier correspondance dans BDD avec l'adresse mail		
	}
	
	
	/**
	 * Ajoute un message correspondant au champ à la map des erreurs
	 * @param champ dont on souhaite associer une erreur
	 * @param message d'erreur
	 */
	private void setErreur(String champ, String message) {
	    erreurs.put(champ, message);
	}

	/**
	 * Retourne null si un champ est vide, et son contenu sinon
	 * @param request
	 * @param nomChamp
	 */
	private static String getValeurChamp(HttpServletRequest request, String nomChamp) {
	    String valeur = request.getParameter(nomChamp);
	    if (valeur == null || valeur.length() == 0) {
	        return null;
	    } else {
	        return valeur;
	    }
	}

}
