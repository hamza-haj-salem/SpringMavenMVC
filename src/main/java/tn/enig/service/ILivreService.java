package tn.enig.service;

import java.util.List;

import tn.enig.model.Livre;

public interface ILivreService {
	
	//elli mwjoud fl interface dao lezem ykoun mwjoud fl int service 
	// si on a 2 int fl dao fl service njm nlemhom 
	public void saveLivre(Livre l);
	public void updateLivre(Livre l);
	public void deleteLivre(int id);
	public List<Livre> getAllLires();
	public Livre getLivreById(int id);

}
