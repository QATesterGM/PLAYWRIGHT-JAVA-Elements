package GMTesterPlaywrightActionsAndElements.cwiczenie;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class ProductShop {

    private String productName;
    private int productPrice;

    public ProductShop(String productName, int productPrice) {
        this.productName = productName;
        this.productPrice = productPrice;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setProductPrice(int productPrice) {
        this.productPrice = productPrice;
    }
}
