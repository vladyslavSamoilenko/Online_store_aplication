package enteties;

public interface Cart {
    boolean isEmpty();
    void addProduct(Product productById);
    Product[] getProductsInCart();

    void clear();
}
