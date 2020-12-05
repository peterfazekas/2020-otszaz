package hu.store.model.domain;

import java.util.Map;
import java.util.stream.Collectors;

public class Cart {

    private final int id;
    private final Map<String, Long> goods;
    private final int totalValue;

    public Cart(int id, Map<String, Long> goods, int totalValue) {
        this.id = id;
        this.goods = goods;
        this.totalValue = totalValue;
    }

    public int getId() {
        return id;
    }

    public Map<String, Long> getGoods() {
        return goods;
    }

    public int getTotalValue() {
        return totalValue;
    }

    public Long countItemsInCart() {
        return goods.entrySet().stream()
                .mapToLong(Map.Entry::getValue)
                .sum();
    }

    public boolean contains(String itemName) {
        return goods.containsKey(itemName);
    }

    public String getCartContentInDetails() {
        return goods.entrySet().stream()
                .map(i -> i.getValue() + " " + i.getKey())
                .collect(Collectors.joining("\r\n"));
    }

    @Override
    public String toString() {
        return id + ": " + totalValue;
    }
}
