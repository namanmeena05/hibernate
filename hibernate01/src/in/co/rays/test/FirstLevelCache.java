package in.co.rays.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import in.co.rays.dto.UserDTO;

public class FirstLevelCache {
	
	public static void main(String[] args) {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
	Transaction tx =	session.beginTransaction();
	UserDTO dto =	(UserDTO) session.get(UserDTO.class, 2);
	System.out.println(dto.getFirstName());
	session.evict(dto);
	UserDTO dto1 =(UserDTO) session.get(UserDTO.class, 2);
	System.out.println(dto1.getFirstName());
	tx.commit();
	session.close();
	}

}
