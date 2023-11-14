package in.co.rays.model;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import in.co.rays.dto.UserDTO;

public class UserModel {

	public UserDTO findByPk(long pk) {

		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
	UserDTO dto =	(UserDTO) session.get(UserDTO.class, pk);
		return dto;

	}

	public void add(UserDTO dto) {

		SessionFactory sf = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();

		Session session = sf.openSession();

		Transaction tx = session.beginTransaction();

		session.save(dto);

		tx.commit();

		session.close();

	}

	public void update(UserDTO dto) {
		SessionFactory sf = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();

		Session session = sf.openSession();

		Transaction tx = session.beginTransaction();

		session.update(dto);

		tx.commit();

		session.close();

	}

	public List search(UserDTO dto) {

		SessionFactory sf = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();

		Session session = sf.openSession();

		Criteria criteria = session.createCriteria(UserDTO.class);

		criteria.add(Restrictions.like("firstName", dto.getFirstName()));

		List list = criteria.list();

		return list;

	}

	public UserDTO authenticate(String login, String password) {
		UserDTO dto = new UserDTO();
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		Query q = session.createQuery("from UserDTO where login=? and password=?");
		q.setString(0, login);
		q.setString(1, password);
		List list = q.list();
		if (list.size() > 0) {
			dto = (UserDTO) list.get(0);
		}
		return dto;

	}

}
