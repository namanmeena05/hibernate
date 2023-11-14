package in.co.rays.test;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Order;

import in.co.rays.dto.UserDTO;

public class TestOrderBy {

	public static void main(String[] args) {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		Criteria criteria = session.createCriteria(UserDTO.class);
		//criteria.addOrder(Order.desc("firstName"));
		criteria.addOrder(Order.asc("firstName"));
		List list = criteria.list();
		Iterator it = list.iterator();
		while(it.hasNext()) {
		UserDTO dto = (UserDTO) it.next();
		System.out.println(dto.getFirstName());
		}
		session.close();

	}

}
