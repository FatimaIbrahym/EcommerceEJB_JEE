package com.ecom.sessions;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import com.ecom.dao.ProductDaoLocal;
import com.ecom.entities.CartItem;
import com.ecom.entities.Product;
import com.ecom.entities.Cart;

/**
 * Session Bean implementation class CartBean
 */
@Stateless
@LocalBean
public class CartBean implements CartBeanLocal {

	@EJB
    private ProductDaoLocal productDaoBean;
    private Cart order;
    private List<CartItem> lineItemList;

    public CartBean() {
        this.lineItemList = new ArrayList<CartItem>();
    }

    public void addLineItem(Long productId, int quantity) {
        CartItem cartItem = getLineItemByProduct(productId);
        Product product = productDaoBean.getProductByProductId(productId);
        double price = product.getPrice();
        if (cartItem == null) {
            cartItem = getPurchaseOrder().addPurchaseAndLineItem(product, quantity, price);
            if (!lineItemList.contains(cartItem)) {
                lineItemList.add(cartItem);
            }
        } else {
            getPurchaseOrder().addPurchase(cartItem, quantity, price);
        }
    }

    public void updateLineItem(CartItem cartItem, int quantity) {
        double price = cartItem.getProduct().getPrice();
        getPurchaseOrder().updatePurchaseAndUpdateLineItem(cartItem, quantity, price);
    }

    public void deleteLineItem(Long lineItemId) {
        List<CartItem> lineItemListTest = new ArrayList<CartItem>();
        for (Iterator<CartItem> it = lineItemList.iterator(); it.hasNext();) {
            CartItem cartItem = it.next();
            if (cartItem.getId().equals(lineItemId)) {
                lineItemListTest.add(cartItem);
            }
        }
        lineItemList.removeAll(lineItemListTest);
    }

    public List<CartItem> getLineItemList() {
        return lineItemList;
    }

    public double getTotalPriceLineItemList() {
        double totlalPrice = 0;
        for (Iterator<CartItem> it = lineItemList.iterator(); it.hasNext();) {
            CartItem cartItem = it.next();
            totlalPrice = totlalPrice + cartItem.getSubTotal();
        }
        return totlalPrice;
    }

    public void setLineItemList(List<CartItem> lineItemList) {
        this.lineItemList = lineItemList;
    }

    public CartItem getLineItemByProduct(Long productId) {
        CartItem cartItem = null;
        if ((lineItemList != null) && (!lineItemList.isEmpty())) {
            for (Iterator<CartItem> it = lineItemList.iterator(); it.hasNext();) {
                CartItem item = it.next();
                if (item.getProduct().getId().equals(productId)) {
                    cartItem = item;
                }
            }
        }
        return cartItem;
    }

    public Cart getPurchaseOrder() {
        if (order == null) {
            order = new Cart();
        }
        return order;
    }

}
