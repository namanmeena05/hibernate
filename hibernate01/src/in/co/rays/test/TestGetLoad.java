package in.co.rays.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import in.co.rays.dto.UserDTO;

public class TestGetLoad {
	public static void main(String[] args) {

		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();

		UserDTO dto = (UserDTO) session.load(UserDTO.class, 1);
		System.out.println(dto.getFirstName());
		tx.commit();
		session.close();
		
	}

}
