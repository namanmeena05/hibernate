package in.co.rays.test;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import in.co.rays.auction.AuctionItems;
import in.co.rays.auction.Bid;

public class Joins {

	public static void main(String[] args) {

		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();

		Criteria criteria = session.createCriteria(AuctionItems.class);

		criteria.setFetchMode("itemId", FetchMode.JOIN);
		criteria.add(Restrictions.eq("id", 1L));

		List list = criteria.list();

		Iterator it = list.iterator();
		while (it.hasNext()) {
			AuctionItems act = (AuctionItems) it.next();
			System.out.println(act.getId());
			System.out.println(act.getDescription());

			Set s = act.getBids();

			Iterator it1 = s.iterator();

			while (it1.hasNext()) {
				Bid obj = (Bid) it1.next();
				System.out.println(obj.getId());
				System.out.println(obj.getAmount());
				System.out.println(obj.getTimestamp());
			}

		}
		session.close();
	}

}
