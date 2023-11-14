package in.co.rays.projection;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;

import in.co.rays.dto.UserDTO;

public class GetColumn {

	public static void main(String[] args) {

		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		Criteria cr = session.createCriteria(UserDTO.class);
		ProjectionList p = Projections.projectionList();
		//p.add(Projections.property("id"));
		p.add(Projections.property("firstName"));
		
		cr.setProjection(p);
		List<String> list = cr.list();
		Iterator<String> it = list.iterator();
		
		while (it.hasNext()) {
			String dto = it.next();
			System.out.println(dto);
			//System.out.println(dto[1]);
			
			
			/*
								 * Object[] dto = (Object[]) it.next(); System.out.println(dto[0]);
								 * System.out.println(dto[1]);
								 */
		}
		tx.commit();
		session.close();

	}

}
