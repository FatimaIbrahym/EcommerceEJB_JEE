package com.ecom.sessions;

import java.sql.Timestamp;
import java.util.Iterator;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import com.ecom.dao.CustomerDaoLocal;
import com.ecom.dao.CartItemDaoLocal;
import com.ecom.dao.PurchaseOrderDaoLocal;
import com.ecom.entities.CartItem;
import com.ecom.entities.Cart;


/**
 * Session Bean implementation class OrderBean
 */
@Stateless
@LocalBean
public class OrderBean implements OrderBeanLocal {

	@EJB
    private CartItemDaoLocal lineItemDaoBean;
    @EJB
    private PurchaseOrderDaoLocal purchaseOrderDaoBean;
    @EJB
    private CustomerDaoLocal customerDaoBean;

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method" or "Web Service > Add Operation")
    public Cart order(Long customerId, CartBeanLocal cartProcessBean) {
        for (Iterator<?> it = cartProcessBean.getLineItemList().iterator(); it.hasNext();) {
            CartItem item = (CartItem) it.next();
            item.setId(null);
            lineItemDaoBean.persistLineItem(item);
        }
        Cart order = new Cart();
        order.setCustomer(customerDaoBean.findCustomerById(customerId));
        order.setCreationDate(new Timestamp(System.currentTimeMillis()));
        order.setCartItems(cartProcessBean.getLineItemList());
        order.setTotalPrice(cartProcessBean.getTotalPriceLineItemList());
        purchaseOrderDaoBean.executeOrder(order);

        return order;
    }

}
