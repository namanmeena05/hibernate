package in.co.rays.hql;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import in.co.rays.dto.UserDTO;

public class TestQuery {

	public static void main(String[] args) {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		Query qu = session.createQuery("from UserDTO where firstName like 's%'");
		//Query qu = session.createSQLQuery("select * from userdto where firstName like 's%'");
		List list = qu.list();

		Iterator it = list.iterator();
		Object[] dto = null;
		/* UserDTO dto = null; */
		while (it.hasNext()) {

			/* dto = (UserDTO) it.next(); */
		 dto = (Object[]) it.next();
			/*
			 * System.out.println(dto.getId()); System.out.println(dto.getFirstName());
			 */
			
			  
			  System.out.println(dto[0]); 
			//  System.out.println(dto[1]);
			 

		}

		session.close();

	}

}
