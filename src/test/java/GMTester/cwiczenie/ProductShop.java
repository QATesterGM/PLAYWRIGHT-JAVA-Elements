package GMTester.cwiczenie;

import com.microsoft.playwright.Locator;
import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public class ProductShop {

    private String productName;
    private int productPrice;

    public ProductShop(String productName, int productPrice) {
        this.productName = productName;
        this.productPrice = productPrice;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(int productPrice) {
        this.productPrice = productPrice;
    }
}
