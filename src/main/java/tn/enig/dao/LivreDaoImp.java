package tn.enig.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.mysql.jdbc.PreparedStatement;

import tn.enig.model.Livre;

@Repository //tt les class fl dao lezem ykounou annote par @reposiory -- ces sont des repertoire de données
//@reposotory ninjectou fihom des src de données 
public class LivreDaoImp implements ILivreDao{
	
	@Autowired  //injection d'un bean -- inj par modif wla par construc--autowired te5dem par modif donc lezem ykoun 3ndi setter 3l data---
	//l injection à partir class wala à partir fich xml --si mn xml lezem tkoun qualifier --sinnon mch lezem qualifier
	@Qualifier ("dataSource")  //5ater jey mn xml -- datasource  jebneh ml container xml
	//acce 3l base de donne mwjoud fl xml
	DataSource data; //lezemha  set 
	
	public void setData(DataSource data) {
		this.data = data;
	}
	

	public void saveLivre(Livre l) {
		try {
			Connection con = data.getConnection();
			PreparedStatement pre =(PreparedStatement) con.prepareStatement("insert into livre values(null,?)"); 
			pre.setString(1, l.getTitre());
			// 3ndi: 1/insert 2/select 3/update 4/delete --- 1+3+4: reqs de modif==> executeUpdate --  2 req selection==> executeQuery --> hathi lezem n7otha f vbl de type resulteSet
			pre.executeUpdate();
		}catch (Exception e) {
		// TODO: handle exception
		}
	}

	public void updateLivre(Livre l) {
		try {
			Connection con = data.getConnection();
			PreparedStatement pre = (PreparedStatement) con.prepareStatement("update Livre set titre=? where id=?");
			pre.setString(1, l.getTitre());
			pre.setInt(2, l.getId());
			pre.executeUpdate();
		}catch (Exception e) {
		// TODO: handle exception
		}
		
	}

	public void deleteLivre(int id) {
		try {
			Connection con = data.getConnection();
			PreparedStatement pre = (PreparedStatement) con.prepareStatement("delete from  livre where id=?");
			pre.setInt(1,id);
			pre.executeUpdate();
		}catch (Exception e) {
		// TODO: handle exception
		}
		
	}

	public List<Livre> getAllLires() {
		List<Livre> liste=null;
		try {
			liste= new ArrayList<Livre>();
			Connection con = data.getConnection();
			PreparedStatement pre =(PreparedStatement) con.prepareStatement("select * from livre"); 
			ResultSet rs= pre.executeQuery();
			while(rs.next()) {
				Livre lv = new Livre(rs.getInt("id"),rs.getString("titre"));
				liste.add(lv);
			}
		}catch (Exception e) {
		// TODO: handle exception
		}
		
		return liste;
	}

	public Livre getLivreById(int id) {
		Livre lv=null;
		try {
			
			Connection con = data.getConnection();
			PreparedStatement pre =(PreparedStatement) con.prepareStatement("select * from livre where id=?"); 
			pre.setInt(1, id);
			ResultSet rs= pre.executeQuery();
			if(rs.next()) {
				lv = new Livre(rs.getInt("id"),rs.getString("titre"));
				
			}
		}catch (Exception e) {
		
		}
		return lv;
	}

}
