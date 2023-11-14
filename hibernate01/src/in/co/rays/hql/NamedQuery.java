package in.co.rays.hql;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import in.co.rays.dto.UserDTO;

public class NamedQuery {

	public static void main(String[] args) {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		Query q = session.getNamedQuery("allUser");
		List list = q.list();
		Iterator it = list.iterator();
		while (it.hasNext()) {
			UserDTO dto = (UserDTO) it.next();
			System.out.println(dto.getFirstName());
		}
		session.close();
	}

}
