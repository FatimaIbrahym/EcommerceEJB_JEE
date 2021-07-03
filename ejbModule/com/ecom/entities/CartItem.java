package com.ecom.entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: LineItem
 *
 */
@Entity

public class CartItem implements Serializable {

	
	 private static final long serialVersionUID = 1L;
	    @Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    private Long id;
	    private int quantity;
	    @ManyToOne
	    private Product product;

	    @ManyToOne(fetch = FetchType.LAZY,cascade = {CascadeType.PERSIST,CascadeType.MERGE})
	    private Cart cart;
	    
	    public CartItem() {
	    }

	    public CartItem(int quantity, Product product) {
	        this.product = product;
	        this.quantity = quantity;
	    }

	    public Product getProduct() {
	        return product;
	    }

	    public void setProduct(Product product) {
	        this.product = product;
	    }

	    public int getQuantity() {
	        return quantity;
	    }

	    public void setQuantity(int quantity) {
	        this.quantity = quantity;
	    }

	    public Long getId() {
	        return id;
	    }

	    public void setId(Long id) {
	        this.id = id;
	    }

	    @Override
	    public String toString() {
	        return "LineItem[id=" + id + "product=" + product + "quantity=" + quantity + "]";
	    }
   
}
