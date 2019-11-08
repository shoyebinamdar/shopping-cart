import org.junit.Test;

import static org.junit.Assert.*;

public class ShoppingCartTest {

    @Test
    public void testEmptyShoppingCart() {
        ShoppingCart shoppingCart = new ShoppingCart();

        assertEquals(0, shoppingCart.getProductCount());
    }

    @Test
    public void shouldTestProductCountWhenNewProductIsAdded() {
        ShoppingCart shoppingCart = new ShoppingCart();

        shoppingCart.add(new Product("soap", 1, 20.0F));

        assertEquals(1, shoppingCart.getProductCount());
    }

    @Test
    public void shouldTestProductCountAndTotalPriceWhenNewProductIsAdded() {
        ShoppingCart shoppingCart = new ShoppingCart();

        shoppingCart.add(new Product("soap", 1, 20.0F));

        assertEquals(1, shoppingCart.getProductCount());
        assertEquals(20.0F, shoppingCart.getTotalAmount(), 0.0);
    }

    @Test
    public void shouldTestProductCountAndTotalPriceWhenMultipleProductsAreAdded() {
        ShoppingCart shoppingCart = new ShoppingCart();

        shoppingCart.add(new Product("soap", 6, 50.0F));
        shoppingCart.add(new Product("shampoo", 1, 250.0F));
        shoppingCart.add(new Product("oil", 2, 70.0F));

        assertEquals(3, shoppingCart.getProductCount());
        assertEquals(690.0F, shoppingCart.getTotalAmount(), 0.0);
    }

    @Test
    public void shouldApplyBuyTwoGetOneOfferOnSelectedProduct() {
        ShoppingCart shoppingCart = new ShoppingCart();

        shoppingCart.setOffer(new BuyXItemGetXItemFreeOffer(2, 1));
        shoppingCart.add(new Product("soap", 5, 50.0F));

        assertEquals(1, shoppingCart.getProductCount());
        assertEquals(200.0F, shoppingCart.getTotalAmount(), 0.0);
    }

    @Test
    public void shouldApplyNoOfferOnSelectedProduct() {
        ShoppingCart shoppingCart = new ShoppingCart();

        shoppingCart.setOffer(new NoOffer());
        shoppingCart.add(new Product("soap", 5, 50.0F));

        assertEquals(1, shoppingCart.getProductCount());
        assertEquals(250.0F, shoppingCart.getTotalAmount(), 0.0);
    }

    @Test
    public void shouldApplyDifferentOffersForDifferentProducts() {
        ShoppingCart shoppingCart = new ShoppingCart();

        shoppingCart.setOffer(new BuyXItemGetXItemFreeOffer(2, 1));
        shoppingCart.add(new Product("soap", 5, 50.0F));

        shoppingCart.setOffer(new NoOffer());
        shoppingCart.add(new Product("shampoo", 1, 200.0F));

        assertEquals(2, shoppingCart.getProductCount());
        assertEquals(400.0F, shoppingCart.getTotalAmount(), 0.0);
    }

    @Test
    public void shouldApplyThirtyPercentOfferOnSelectedProduct() {
        ShoppingCart shoppingCart = new ShoppingCart();

        shoppingCart.setOffer(new XPercentDiscountOffer(30));
        shoppingCart.add(new Product("soap", 5, 50.0F));

        assertEquals(1, shoppingCart.getProductCount());
        assertEquals(175.0F, shoppingCart.getTotalAmount(), 0.0);
    }
}
