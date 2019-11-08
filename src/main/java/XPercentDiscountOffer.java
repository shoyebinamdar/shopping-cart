public class XPercentDiscountOffer implements IOffer {
    Integer discountPercent;

    public XPercentDiscountOffer(Integer discountPercent) {
        this.discountPercent = discountPercent;
    }

    @Override
    public void apply(Product product) {
        product.setTotalPrice(product.getTotalPrice() - (product.getTotalPrice() * (discountPercent / 100.0F)));
    }
}
