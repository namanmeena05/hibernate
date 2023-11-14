package in.co.rays.auction;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class AuctionTest {

	public static void main(String[] args) {

		Bid bid1 = new Bid();
		bid1.setId(1);
		bid1.setAmount(1000);
		bid1.setTimestamp("xyz");

		Bid bid2 = new Bid();
		bid2.setId(2);
		bid2.setAmount(2000);
		bid2.setTimestamp("abc");

		Bid bid3 = new Bid();
		bid3.setId(3);
		bid3.setAmount(3000);
		bid3.setTimestamp("qrs");

		Set bids = new HashSet();
		bids.add(bid1);
		bids.add(bid2);
		bids.add(bid3);

		AuctionItems item = new AuctionItems();
		item.setId(1);
		item.setDescription("Car");
		item.setBids(bids);

		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();

		session.save(item);

		tx.commit();
		session.close();

	}

}
