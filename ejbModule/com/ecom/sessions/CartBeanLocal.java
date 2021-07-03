package com.ecom.sessions;

import javax.ejb.Local;

import com.ecom.entities.CartItem;
import com.ecom.entities.Cart;

import java.util.List;

@Local
public interface CartBeanLocal {

	public List<CartItem> getLineItemList();

    public CartItem getLineItemByProduct(Long productId);

    public Cart getPurchaseOrder();

    public void setLineItemList(List<CartItem> lineItemList);

    public void addLineItem(Long productId, int quantity);

    public void updateLineItem(CartItem cartItem, int quantity);

    public void deleteLineItem(Long lineItemId);

    public double getTotalPriceLineItemList();
}
