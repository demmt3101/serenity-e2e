package com.tcs.tasks;

import com.tcs.UI.SauceInventoryUI;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import java.util.List;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class AddProductsToCart implements Task {

    private final List<String> products;

    public AddProductsToCart(List<String> products) {
        this.products = products;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        for (String slug : products) {
            actor.attemptsTo(Click.on(SauceInventoryUI.addToCartBySlug(slug)));
        }
        actor.attemptsTo(Click.on(SauceInventoryUI.CART));
    }

    public static AddProductsToCart from(List<String> products) {
        return instrumented(AddProductsToCart.class, products);
    }
}