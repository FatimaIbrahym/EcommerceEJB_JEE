package com.ecom.entities;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Cart
 *
 */
@Entity

public class Cart implements Serializable {

	
	private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToMany(mappedBy = "cart",
                cascade = CascadeType.ALL,
                fetch = FetchType.EAGER,
                orphanRemoval = true)
    private List<CartItem> cartItems = new ArrayList<>();
    @OneToOne
    private User user;
    private Timestamp creationDate;
    @Transient
    private double totalPrice;

    public List<CartItem> getCartItems() {
        return cartItems;
    }

    public Timestamp getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Timestamp creationDate) {
        this.creationDate = creationDate;
    }

    public void setCartItems(List<CartItem> cartItems) {
        this.cartItems = cartItems;
    }

    public User getCustomer() {
        return user;
    }

    public void setCustomer(User user) {
        this.user = user;
    }

    public double getTotalPrice() {
        this.totalPrice = 0 ;
        for(CartItem item : this.getCartItems() ) {
        	this.totalPrice += item.getProduct().getPrice()*item.getProduct().getQuantity();
        }
        return this.totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Cart[id=" + id + "]";
    }

  /*  public void addPurchase(CartItem item, int quantity, double price) {
        if (cartItems == null) {
            cartItems = new ArrayList<CartItem>();
        }
        item.setQuantity(item.getQuantity() + quantity);
        item.setSubTotal(item.getSubTotal() + (quantity * price));
        totalPrice += item.getSubTotal() + (quantity * price);
    }

    public void updatePurchaseAndUpdateLineItem(CartItem item, int quantity, double price) {
        if (cartItems == null) {
            cartItems = new ArrayList<CartItem>();
        }
        int oldQuantity = item.getQuantity();
        item.setQuantity(quantity);
        item.setSubTotal(quantity * price);
        totalPrice = totalPrice - (oldQuantity * price);
        totalPrice += quantity * price;
    }
    Long itemId = (long) 0;

    public CartItem addPurchaseAndLineItem(Product product, int quantity, double price) {

        if (cartItems == null || cartItems.isEmpty()) {
            cartItems = new ArrayList<CartItem>();
        }
        CartItem item = new CartItem();
        item.setId(itemId);
        item.setProduct(product);
        item.setQuantity(quantity);
        item.setSubTotal(quantity * price);
        cartItems.add(item);
        totalPrice += quantity * price;
        itemId = itemId + 1;
        return item;
    }
    */
   
}
