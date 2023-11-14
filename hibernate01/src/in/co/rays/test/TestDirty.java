package in.co.rays.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import in.co.rays.auction.AuctionItems;


public class TestDirty {
	
	public static void main(String[] args) {
		
		
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		
		Transaction tx = session.beginTransaction();
		
	AuctionItems auc=	(AuctionItems) session.get( AuctionItems.class, 1L);
	
	auc.setDescription("option3");
		
		
		
		tx.commit();
		session.close();
	}

}
