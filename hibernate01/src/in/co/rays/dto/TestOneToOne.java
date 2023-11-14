package in.co.rays.dto;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class TestOneToOne {
	
	public static void main(String[] args) {
		
	
		
		Address addr = new Address();
		addr.setId(1);
		addr.setStreet("mog line");
		addr.setCity("nasrullaganj");
		addr.setState("mp");
		

		Employee emp = new Employee();
		emp.setId(1);
		emp.setFirstName("naman");
		emp.setLastName("meena");
		emp.setEmpAddr(addr);
		
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session =   sf.openSession();
		 Transaction tx = session.beginTransaction();
		 session.save(emp);
		 tx.commit();
		 session.close();
	
	
		
	}

}
