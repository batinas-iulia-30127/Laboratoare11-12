package aut.utcluj.isp.ex4;

import java.util.List;
import java.util.ArrayList;

/**
 * @author stefan
 */
public class UserCart implements ICartDetails {
    private List<Product> cardProducts = new ArrayList<Product>();
    private double totalPrice = 0;

    public double getTotalPrice() {
        return totalPrice;

    }

    public List<Product> getCardProducts() {
        return cardProducts;
    }

    /**
     * Add new product to user cart
     *
     * @param product  - product to be added
     * @param quantity - number of products of the same type to be added
     */
    public void addProductToCart(final Product product, int quantity) {
        for (int i = 1; i <= quantity; i++) {
            cardProducts.add(product);
            totalPrice += product.getPrice();
        }
    }

    /**
     * Remove one product with product id from cart
     * If the product with desired id not found in the card, an {@link ProductNotFoundException} exception will be thrown
     *
     * @param productId - unique product id
     */
    public void removeProductFromCart(final String productId) throws ProductNotFoundException {
        boolean found = false;
        for (Product product : cardProducts) {
            if (product.getProductId().equals(productId)) {
                found = true;
                cardProducts.remove(product);
                totalPrice = totalPrice - product.getPrice();
                break;
            }
        }
        if (!found) {
            throw new ProductNotFoundException();
        }
    }

    /**
     * Reset user cart
     * Reset products and total price to default values
     */
    public void resetCart() {
        cardProducts = new ArrayList<Product>();
        totalPrice = 0;
    }

    @Override
    public String getCartDetails() {
        /**
         * Return cart details
         * Cart details should have the following format:
         * Product id: , Items:
         * Product id: , Items:
         * Total price:
         *
         * @return cart details
         */
        String cartDetails = "";
        ArrayList<String> productIds = new ArrayList<String>();
        for (Product product : cardProducts) {
            if (productIds.contains(product.getProductId())) {
                continue;
            } else {
                cartDetails += "Product id: " + product.getProductId() + ", Items: " + getOccurences(product.getProductId()) + "\n";
                productIds.add(product.getProductId());
            }
        }
        cartDetails += "Total price: " + totalPrice;
        return cartDetails;
    }

    private Integer getOccurences(String productId) {
        int occurences = 0;
        for (Product product : cardProducts) {
            if (product.getProductId().equals(productId)) {
                occurences += 1;
            }
        }
        return occurences;

    }
}
