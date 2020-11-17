package procedural;

/**
 *
 *
 * @author Burkin A. Yur.
 * @ created 2020-01-15
 */
public enum DiscountType {

    GENERAL(10),
    WEEKEND(30);

    private int percent;

    DiscountType(int percent) {
        this.percent = percent;
    }

    public int getPercent() {
        return this.percent;
    }
}
