package homework.homework07;

import java.util.Objects;

public class DiscountProduct extends Product {

    private int discount;
    private boolean discountIsOn = false;

    public DiscountProduct(String name, long cost, int discount, boolean discountIsOn) {
        super(name, cost);
        this.discount = discount;
        this.discountIsOn = discountIsOn;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public boolean isDiscountIsOn() {
        return discountIsOn;
    }

    public void setDiscountIsOn(boolean discountIsOn) {
        this.discountIsOn = discountIsOn;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        DiscountProduct that = (DiscountProduct) o;
        return discount == that.discount && discountIsOn == that.discountIsOn;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), discount, discountIsOn);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
