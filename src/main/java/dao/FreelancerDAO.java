package dao;

import java.util.List;

import model.Freelancer;


public interface FreelancerDAO {
	
	List<Freelancer> get();
	
	Freelancer get(int id);
	
	boolean save(Freelancer freelancer);
	
	boolean delete(int id);
	
	boolean update(Freelancer freelancer);
}
