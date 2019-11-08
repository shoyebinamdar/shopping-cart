import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    List<Product> products = new ArrayList<>();

    public int getProductCount() {
        return products.size();
    }

    public void add(Product product) {
        products.add(product);
    }

    public float getTotalAmount() {
        return products.stream().map(Product::getTotalPrice).reduce(0.0F, Float::sum);
    }
}
