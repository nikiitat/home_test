package api;

/**
 * Created by nikitatertytskyi on 17.12.17.
 */
public class ProductAttributes {
    private String title;
    private String oldPrice;
    private String newPrice;

    public ProductAttributes(final String title, final String oldPrice, final String newPrice) {
        this.title = title;
        this.oldPrice = oldPrice;
        this.newPrice = newPrice;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setOldPrice(String oldPrice) {
        this.oldPrice = oldPrice;
    }

    public void setNewPrice(String newPrice) {
        this.newPrice = newPrice;
    }

    public String getTitle() {
        return title;
    }

    public String getOldPrice() {
        return oldPrice;
    }

    public String getNewPrice() {
        return newPrice;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        ProductAttributes that = (ProductAttributes) o;

        if (title != null ? !title.equals(that.title) : that.title != null) {
            return false;
        }
        if (oldPrice != null ? !oldPrice.equals(that.oldPrice) : that.oldPrice != null) {
            return false;
        }
        return newPrice != null ? newPrice.equals(that.newPrice) : that.newPrice == null;
    }
}
