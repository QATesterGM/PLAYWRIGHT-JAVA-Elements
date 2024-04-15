package GMTesterPlaywrightActionsAndElements.cwiczenie;

import GMTesterPlaywrightActionsAndElements.BaseTest;
import com.microsoft.playwright.Locator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class ShopTest extends BaseTest {

    @Test
    void check_price_not_above_15$() {
        List<ProductShop> products = getProducts();

        System.out.println(products);

        List<Integer> prices = new ArrayList<>();
        products.forEach(p -> prices.add(p.getProductPrice()));
        Assertions.assertThat(prices.stream().allMatch(p -> p > 15)).isTrue();
    }

    @Test
    void list_names_of_all_objects() {
        List<ProductShop> products = getProducts();

        List<String> names = new ArrayList<>();
        products.forEach(p -> names.add(p.getProductName()));
        Assertions.assertThat(names.stream().allMatch(n -> n.contains("Printed"))).isTrue(); //czy kazdy zawiera szukana frazę

        System.out.println(names);

    }

    private List<ProductShop> getProducts() {
        page.navigate("http://www.automationpractice.pl/index.php?");
        page.locator("a[title=Dresses]").last().click();
        List<Locator> productLocators = page.locator(".product_list .ajax_block_product").all();
        List<ProductShop> products = new ArrayList<>();

        productLocators.forEach(p -> {
            String productName = p.locator(".right-block .product-name").innerText();
            int productPrice = Integer.parseInt(p.locator(".right-block .content_price .price").innerText().replace("$", ""));

            products.add(new ProductShop(productName, productPrice));
        });
        return products;
    }
}
