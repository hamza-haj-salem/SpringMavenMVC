package tn.enig.dao;

import java.util.List;

import tn.enig.model.Livre;

public interface ILivreDao {
	public void saveLivre(Livre l);
	public void updateLivre(Livre l);
	public void deleteLivre(int id);
	public List<Livre> getAllLires();
	public Livre getLivreById(int id);

}
