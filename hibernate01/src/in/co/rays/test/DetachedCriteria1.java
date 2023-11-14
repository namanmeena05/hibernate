package in.co.rays.test;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import in.co.rays.dto.UserDTO;

public class DetachedCriteria1 {
	public static void main(String[] args) {
		DetachedCriteria dc = DetachedCriteria.forClass(UserDTO.class);
		dc.add(Restrictions.eq("firstName", "naman"));
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		List<UserDTO> list = dc.getExecutableCriteria(session).list();
		Iterator it = list.iterator();
		while (it.hasNext()) {
			UserDTO dto = (UserDTO) it.next();
			System.out.println(dto.getId());
		}
		session.close();

		Session session1 = sf.openSession();

		List<UserDTO> list1 = dc.getExecutableCriteria(session1).list();
		Iterator it1 = list1.iterator();
		while (it1.hasNext()) {
			UserDTO dto = (UserDTO) it1.next();
			System.out.println(dto.getLastName());
		}
		session1.close();

	}

}
