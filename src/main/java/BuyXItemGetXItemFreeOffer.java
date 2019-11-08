public class BuyXItemGetXItemFreeOffer implements IOffer {
    private int xItem;
    private int yItem;

    public BuyXItemGetXItemFreeOffer(int xItem, int yItem) {
        this.xItem = xItem;
        this.yItem = yItem;
    }

    @Override
    public void apply(Product product) {
        if (product.getQuantity() >= xItem) {
            int freeProductQuantity = product.getQuantity() / (xItem + yItem);
            Float discount = freeProductQuantity * product.getUnitPrice();
            product.setTotalPrice(product.getTotalPrice() - discount);
        }
    }
}
