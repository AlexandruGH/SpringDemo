package com.ghiurutan.springdemo.models.forms;

import com.ghiurutan.springdemo.models.Cheese;
import com.ghiurutan.springdemo.models.Menu;

import javax.validation.constraints.NotNull;

/**
 * Created by AlexandruGh on 8/30/2017.
 */
public class AddMenuItemForm {

    @NotNull
    private int menuId;

    @NotNull
    private int cheeseId;

    private Iterable<Cheese> cheeses;

    private Menu menu;

    public AddMenuItemForm() {
    }

    public AddMenuItemForm(Iterable<Cheese> aCheeses, Menu aMenu) {
        cheeses = aCheeses;
        menu = aMenu;
    }

    public int getMenuId() {
        return menuId;
    }

    public void setMenuId(int aMenuId) {
        menuId = aMenuId;
    }

    public int getCheeseId() {
        return cheeseId;
    }

    public void setCheeseId(int aCheeseId) {
        cheeseId = aCheeseId;
    }

    public Iterable<Cheese> getCheeses() {
        return cheeses;
    }

    public Menu getMenu() {
        return menu;
    }
}
