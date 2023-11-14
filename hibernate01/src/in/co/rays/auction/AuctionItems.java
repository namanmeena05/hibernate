package in.co.rays.auction;

import java.util.Set;

public class AuctionItems {
	
	private long id ;
	private Set bids;
	private String description;
	private Bid successfulBid=null;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Set getBids() {
		return bids;
	}
	public void setBids(Set bids) {
		this.bids = bids;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Bid getSuccessfulBid() {
		return successfulBid;
	}
	public void setSuccessfulBid(Bid successfulBid) {
		this.successfulBid = successfulBid;
	}

}
