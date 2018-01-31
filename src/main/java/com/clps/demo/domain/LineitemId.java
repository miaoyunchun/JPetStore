package com.clps.demo.domain;

/**
 * LineitemId entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class LineitemId implements java.io.Serializable {

	// Fields

	private Orders orders;
	private String itemid;

	// Constructors

	/** default constructor */
	public LineitemId() {
	}

	/** full constructor */
	public LineitemId(Orders orders, String itemid) {
		this.orders = orders;
		this.itemid = itemid;
	}

	// Property accessors

	public Orders getOrders() {
		return this.orders;
	}

	public void setOrders(Orders orders) {
		this.orders = orders;
	}

	public String getItemid() {
		return this.itemid;
	}

	public void setItemid(String itemid) {
		this.itemid = itemid;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof LineitemId))
			return false;
		LineitemId castOther = (LineitemId) other;

		return ((this.getOrders() == castOther.getOrders()) || (this
				.getOrders() != null
				&& castOther.getOrders() != null && this.getOrders().equals(
				castOther.getOrders())))
				&& ((this.getItemid() == castOther.getItemid()) || (this
						.getItemid() != null
						&& castOther.getItemid() != null && this.getItemid()
						.equals(castOther.getItemid())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getOrders() == null ? 0 : this.getOrders().hashCode());
		result = 37 * result
				+ (getItemid() == null ? 0 : this.getItemid().hashCode());
		return result;
	}

}