package tn.enig.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.enig.dao.ILivreDao;
import tn.enig.model.Livre;

@Service //5ater hatha bch ninjectouh 
public class LivreServiceImp implements ILivreService {  // service juste ynathem ben controleur wl dao 
														// f versionet o5rin njmou ninjectou ml reposotory fl controlleur
	
	//hna src jetna ml dao mch ml dispatcher l howa contaainer
	@Autowired  // ma8er qualification 5ater jeya mn class 
	private ILivreDao dao;  // kn n7ottou LivreDaoImp nwalli rbatet dao b classe ywalli couplage fort
	
	public void setDao(ILivreDao dao) {
		this.dao = dao;
	}

	public void saveLivre(Livre l) {
		dao.saveLivre(l);
		
	}

	public void updateLivre(Livre l) {
		dao.updateLivre(l);
		
	}

	public void deleteLivre(int id) {
		dao.deleteLivre(id);
		
	}

	public List<Livre> getAllLires() {
		// TODO Auto-generated method stub
		return dao.getAllLires();
	}

	public Livre getLivreById(int id) {
		// TODO Auto-generated method stub
		return dao.getLivreById(id);
	}
	
	

}
