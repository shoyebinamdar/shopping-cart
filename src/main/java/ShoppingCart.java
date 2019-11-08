import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ShoppingCart {
    List<Product> products = new ArrayList<>();
    IOffer offer;


    public int getProductCount() {
        return products.size();
    }

    public void add(Product product) {
        if (Objects.nonNull(offer))
            offer.apply(product);
        products.add(product);
    }

    public float getTotalAmount() {
        return products.stream().map(Product::getTotalPrice).reduce(0.0F, Float::sum);
    }

    public void setOffer(IOffer offer) {
        this.offer = offer;
    }
}
