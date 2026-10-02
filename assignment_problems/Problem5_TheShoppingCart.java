/**
 * Problem 5: The Shopping Cart
 * Category C - Week 7 Assignment Problem
 *
 * Requirements:
 * - Store item prices in a private array (assume fixed maximum number of items).
 * - Provide a method to add an item's price to the cart.
 * - Provide a read-only total (sum of all prices) and read-only item count, computed on request.
 * - Give the cart a final cart ID, fixed when created.
 * - No method that returns the array of individual prices.
 */
public class Problem5_TheShoppingCart {

    public static class Cart {
        private final String cartId;
        private final double[] prices;
        private int itemCount;

        public Cart(String cartId, int capacity) {
            this.cartId = cartId;
            this.prices = new double[capacity];
            this.itemCount = 0;
        }

        public String getCartId() {
            return cartId;
        }

        public boolean addItem(double price) {
            if (price < 0) {
                System.out.println("Price cannot be negative.");
                return false;
            }
            if (itemCount >= prices.length) {
                System.out.println("Cart is full. Cannot add item with price: " + price);
                return false;
            }
            prices[itemCount++] = price;
            return true;
        }

        public double getTotal() {
            double sum = 0.0;
            for (int i = 0; i < itemCount; i++) {
                sum += prices[i];
            }
            return sum;
        }

        public int getItemCount() {
            return itemCount;
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Problem 5: The Shopping Cart ===");
        Cart cart = new Cart("CART-5", 20);
        cart.addItem(250);
        cart.addItem(99);
        cart.addItem(151);

        System.out.println("Cart ID: " + cart.getCartId());
        System.out.println("cart.getTotal() -> " + cart.getTotal());
        System.out.println("cart.getItemCount() -> " + cart.getItemCount());
    }
}
