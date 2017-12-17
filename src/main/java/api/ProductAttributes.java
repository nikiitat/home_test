package api;

/**
 * Created by nikitatertytskyi on 17.12.17.
 */
public class ProductAttributes {
    private String title;
    private String oldPrice;
    private String newPrice;

    public ProductAttributes(final String title, final String oldPrice, final String newPrice){
        this.title = "";
        this.oldPrice = "";
        this.newPrice = "";
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
}
