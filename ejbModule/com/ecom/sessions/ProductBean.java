package com.ecom.sessions;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import com.ecom.dao.CategoryDaoLocal;
import com.ecom.dao.ProductDaoLocal;
import com.ecom.entities.Product;
import com.ecom.enumerations.CategoryEnum;

/**
 * Session Bean implementation class ProductBean
 */
@Stateless
@LocalBean
public class ProductBean implements  ProductBeanLocal {
	
	    @EJB
	    private CategoryDaoLocal categoryDaoBean;
	    @EJB
	    private ProductDaoLocal productDaoBean;

	    // Add business logic below. (Right-click in editor and choose
	    // "Insert Code > Add Business Method" or "Web Service > Add Operation")
	    public void updateProductQuantity(Long id, int quantity) {
	        Product product = productDaoBean.getProductByProductId(id);
	        int remainQuantity = product.getQuantity() - quantity;
	        if (remainQuantity > 0) {
	            product.setQuantity(remainQuantity);
	        } else {
	            product.setQuantity(0);
	            product.setAvailability(false);
	        }
	    }

	    public void createProduct() {
	        productDaoBean.addProduct(new Product("Chance", "Chanel 50ml", "chanel-chance.bmp", 20, categoryDaoBean.getCategoryByName(CategoryEnum.Men.getCategoryText()), 70, true));
	      //  productDaoBean.addProduct(new Product("J'adore", "Dior 50ml", "dior-jadore.bmp", 20, categoryDaoBean.getCategoryByName(CategoryEnum.COSMETIC.getCategoryText()), "Perfume", 70, true));
	      //  productDaoBean.addProduct(new Product("Ring", "Gold ring", "ring-gold.bmp", 20, categoryDaoBean.getCategoryByName(CategoryEnum.JEWEL.getCategoryText()), "ring", 150, true));
	      //  productDaoBean.addProduct(new Product("Bracelet tiffany", "Or blanc", "bracelet-tiffany.bmp", 20, categoryDaoBean.getCategoryByName(CategoryEnum.JEWEL.getCategoryText()), "bracelet", 100, true));
	      //  productDaoBean.addProduct(new Product("Collier fantaisie", "Or 750", "collier-fantaisie.bmp", 20, categoryDaoBean.getCategoryByName(CategoryEnum.JEWEL.getCategoryText()), "collier", 386, true));
	      //  productDaoBean.addProduct(new Product("Coffret epice", "Variet� 900g", "coffret-epice.bmp", 20, categoryDaoBean.getCategoryByName(CategoryEnum.GASTRONOMY.getCategoryText()), "epice", 60, true));
	      //  productDaoBean.addProduct(new Product("Coffret chocolat", "Variet� 200g", "coffret-chocolat.bmp", 20, categoryDaoBean.getCategoryByName(CategoryEnum.GASTRONOMY.getCategoryText()), "chocolat", 35, true));
	      //  productDaoBean.addProduct(new Product("Ferrero", "Ferrero 100g", "ferrero-rocher.bmp", 20, categoryDaoBean.getCategoryByName(CategoryEnum.GASTRONOMY.getCategoryText()), "chocolat", 15, true));
	    }

		@Override
		public void createProduct(Product product) {
			productDaoBean.addProduct(product);
			
		}

	@Override
	public void updateProduct(Product product) {
		productDaoBean.updateProduct(product);
	}

	@Override
	public void deleteProduct(Long id) {
		productDaoBean.deleteProduct(id);
	}
}
