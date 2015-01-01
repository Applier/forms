/**
 * 
 */
package intergiciels.forms;

import intergiciels.beans.InfosCV;

import java.util.HashMap;
import java.util.Map;
import java.util.Collection;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Jade BOUMAZA
 *
 */
public class ProfilForm {
	
	private static final String CHAMP_NOM = "nom";
	private static final String CHAMP_PRENOM = "prenom";
	private static final String CHAMP_NUMTEL = "numTel";
	private static final String CHAMP_DATENAISSANCE ="dateNaissance";
	private static final String CHAMP_ADRESSE = "adresse";
	// A FAIRE : Collections de Domaines de compétences, de loisirs, de langues
		
	public InfosCV remplirInfosCV(HttpServletRequest request) {
		
		String nom = getValeurChamp(request, CHAMP_NOM);
		String prenom = getValeurChamp(request, CHAMP_PRENOM);
		//String numTel = getValeurChamp(request, CHAMP_NUMTEL);
		//String dateNaissance = getValeurChamp(request,CHAMP_DATENAISSANCE);
		//String adresse = getValeurChamp(request,CHAMP_ADRESSE);
		
		InfosCV infosCV = new InfosCV();
		
		infosCV.setNom(nom);
		infosCV.setPrenom(prenom);
		//infosCV.setNumTel(numTel);
		//infosCV.setDateNaissance(dateNaissance);
		//infosCV.setAdresse(adresse);
		
		return infosCV;		
		
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
