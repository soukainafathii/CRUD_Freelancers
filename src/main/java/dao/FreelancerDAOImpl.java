package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Freelancer;
import utils.DBConnectionUtil;


public class FreelancerDAOImpl implements FreelancerDAO {
	
	Connection connection = null;
	ResultSet resultSet = null;
	Statement statement = null;
	PreparedStatement preparedStatement = null;
	
	//fetching freelancers method
	@Override
	public List<Freelancer> get() {
		
		List<Freelancer> list = null;
		Freelancer freelancer = null;
		
		try {
			
			list = new ArrayList<Freelancer>();
			String sql = "SELECT * FROM freelancers";
			connection = DBConnectionUtil.openConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);
			while(resultSet.next()) {
				freelancer = new Freelancer();
				freelancer.setId(resultSet.getInt("id"));
				freelancer.setNom(resultSet.getString("nom"));
				freelancer.setPrenom(resultSet.getString("prenom"));
				freelancer.setEmail(resultSet.getString("email"));
				freelancer.setNb_annees_exp(resultSet.getString("nb_annees_exp"));
				freelancer.setCompetences(resultSet.getString("competences"));
				list.add(freelancer);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	
	//fetching freelancer by id
	@Override
	public Freelancer get(int id) {
		Freelancer freelancer = null;
		try {
			freelancer = new Freelancer();
			String sql = "SELECT * FROM freelancers where id="+id;
			connection = DBConnectionUtil.openConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);
			if(resultSet.next()) {
				freelancer.setId(resultSet.getInt("id"));
				freelancer.setNom(resultSet.getString("nom"));
				freelancer.setPrenom(resultSet.getString("prenom"));
				freelancer.setEmail(resultSet.getString("email"));
				freelancer.setNb_annees_exp(resultSet.getString("nb_annees_exp"));
				freelancer.setCompetences(resultSet.getString("competences"));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return freelancer;
	}

	
	//ajouter freelancer
	@Override
	public boolean save(Freelancer f) {
		boolean flag = false;
		try {
			String sql = "INSERT INTO freelancers(nom, prenom, email, nb_annees_exp, competences)VALUES"
					+ "('"+f.getNom()+"', '"+f.getPrenom()+"', '"+f.getEmail()+"','"+f.getNb_annees_exp()+"','"+f.getCompetences()+"')";
			connection = DBConnectionUtil.openConnection();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.executeUpdate();
			flag = true;
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
		return flag;
	}
	
	
	
    //supprimer freelancer
	@Override
	public boolean delete(int id) {
		boolean flag = false;
		try {
			String sql = "DELETE FROM freelancers where id="+id;
			connection = DBConnectionUtil.openConnection();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.executeUpdate();
			flag = true;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}
	
	
	
    //modifier freelancer
	@Override
	public boolean update(Freelancer freelancer) {
		boolean flag = false;
		try {
			String sql = "UPDATE freelancers SET nom = '"+freelancer.getNom()+"', "
					+ "prenom = '"+freelancer.getPrenom()+"', email= '"+freelancer.getEmail()+"', nb_annees_exp='"+freelancer.getNb_annees_exp()+"', competences='"+freelancer.getCompetences()+"'where id="+freelancer.getId();
			connection = DBConnectionUtil.openConnection();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.executeUpdate();
			flag = true;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}

}
