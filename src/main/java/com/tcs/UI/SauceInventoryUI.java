package com.tcs.UI;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class SauceInventoryUI {

    public static Target addToCartBySlug(String slug) {
        return Target.the("add to cart " + slug)
                .located(By.cssSelector("button[name='add-to-cart-" + slug + "']"));
    }

    public static final Target CART = Target.the("cart link")
            .located(By.cssSelector("a.shopping_cart_link"));
}