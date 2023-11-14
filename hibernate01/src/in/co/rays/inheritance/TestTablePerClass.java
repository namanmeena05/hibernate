package in.co.rays.inheritance;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class TestTablePerClass {

	public static void main(String[] args) {

		CreditCardPayment ccp = new CreditCardPayment();
		ccp.setAmount(100);
		ccp.setCcType("rupay");
		ccp.setPaymentType("Phonepe");

		Cheque ch = new Cheque();
		ch.setChequeNo(05);
		ch.setBankName("ANJ Bank Of India ");
		ch.setAmount(10);
		ch.setPaymentType("deposit");

		Cash c = new Cash();
		c.setAmount(19);
		c.setPaymentType("Googlepay");

		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		session.save(ccp);
		session.save(ch);
		session.save(c);
		tx.commit();
		session.close();
	}

}
