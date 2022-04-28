package com.linkedin.jsf;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@SessionScoped
@Named
public class CatalogItemFormBean implements Serializable {

    private CatalogItem item = new CatalogItem();

    private List<CatalogItem> items = new ArrayList<>();

    public String addItem() {

        long itemId = this.items.size() + 1;

        items.add(new CatalogItem(itemId, this.item.getName(), this.item.getManufacturer(), this.item.getDescription(),
                this.item.getAvailableDate()));

        this.items.stream().forEach(item -> {
            System.out.println(item.toString());
        } );

        return "list?faces-redirect=true";
    }

    public CatalogItem getItem() {
        return item;
    }

    public void setItem(CatalogItem item) {
        this.item = item;
    }

    public List<CatalogItem> getItems() {
        return items;
    }

    public void setItems(List<CatalogItem> items) {
        this.items = items;
    }
}
