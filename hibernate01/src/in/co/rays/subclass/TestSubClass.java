package in.co.rays.subclass;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class TestSubClass {

	public static void main(String[] args) {

		CreditCardPayment ccp = new CreditCardPayment();
		ccp.setAmount(100);
		ccp.setCcType("xyz");

		Cash c = new Cash();
		c.setAmount(100);
		

		Cheque ch = new Cheque();
		ch.setAmount(199);
		ch.setBankName("SBI");
		ch.setChequeNo(0501);

		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		session.save(ccp);
		session.save(c);
		session.save(ch);
		tx.commit();
		session.close();

	}

}
