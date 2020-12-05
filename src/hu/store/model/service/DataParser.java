package hu.store.model.service;

import hu.store.model.domain.Cart;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DataParser {

    private int id = 0;

    List<Cart> parse(List<String> lines) {
        List<Cart> carts = new ArrayList<>();
        List<String> items = new ArrayList<>();
        for (var line : lines) {
            if ("F".equals(line)) {
               carts.add(createCart(items));
               items = new ArrayList<>();
            } else {
                items.add(line);
            }
        }
        return carts;
    }

    private Cart createCart(List<String> items) {
        Map<String, Long> goodsMap = createGoodsMap(items);
        int totalValue = calculateTotalValue(goodsMap);
        return new Cart(++id, goodsMap, totalValue);
    }

    private int calculateTotalValue(Map<String, Long> goodsMap) {
        return goodsMap.values().stream()
                .mapToInt(ValueCalculator::calculate)
                .sum();
    }

    private Map<String, Long> createGoodsMap(List<String> items) {
        return items.stream()
                .collect(Collectors.groupingBy(i -> i, Collectors.counting()));
    }
}
