package in.co.rays.test;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import in.co.rays.dto.UserDTO;

public class QueryCache {

	public static void main(String[] args) {

		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		Query q = session.createQuery("from UserDTO where id=2");
		q.setCacheable(true);
		List list = q.list();
		Iterator it = list.iterator();
		while (it.hasNext()) {
			UserDTO dto = (UserDTO) it.next();
			System.out.println(dto.getFirstName());
			session.evict(dto);
			Query q1 = session.createQuery("from UserDTO where id =2");
			q1.setCacheable(true);
			List list1 = q1.list();
			Iterator it1 = list1.iterator();
			while (it1.hasNext()) {
				UserDTO dto1 = (UserDTO) it1.next();
				System.out.println(dto1.getFirstName());
			}
			session.close();
		}
	}

}
