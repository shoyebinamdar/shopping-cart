public class Product {
    private String name;
    private Integer quantity;
    private Float unitPrice;
    private Float totalPrice;
    private IOffer offer;

    public Product(String name, Integer quantity, Float unitPrice, IOffer offer) {
        this.name = name;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.offer = offer;
        this.totalPrice = quantity * unitPrice;

        offer.apply(this);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Float getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Float unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Float totalPrice) {
        this.totalPrice = totalPrice;
    }
}
