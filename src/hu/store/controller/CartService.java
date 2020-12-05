package hu.store.controller;

import hu.store.model.domain.Cart;

import java.util.List;
import java.util.stream.Collectors;

public class CartService {

    private final List<Cart> carts;

    public CartService(List<Cart> carts) {
        this.carts = carts;
    }

    /**
     * 2. feladat: Határozza meg, hogy hányszor fizettek a pénztárnál!
     */
    public int getCartNumber() {
        return carts.size();
    }

    /**
     * 3. feladat: Írja a képernyőre, hogy az első vásárlónak hány darab
     * árucikk volt a kosarában!
     */
    public long getGoodsNumberInChart(int id) {
        return getCartById(id).countItemsInCart();
    }

    private Cart getCartById(int id) {
        return carts.stream()
                .filter(i -> i.getId()==id)
                .findAny()
                .get();
    }

    /**
     * 5.a feladat: Határozza meg, hogy a bekért árucikkből melyik
     * vásárláskor vettek először!
     */
    public int getFirstCartIdByGoods(String goods) {
        return getCartsByGoods(goods).get(0).getId();
    }

    /**
     * 5.a feladat: Határozza meg, hogy a bekért árucikkből melyik
     * vásárláskor vettek utoljára!
     */
    public int getLastCartIdByGoods(String goods) {
        List<Cart> cartsByGoods = getCartsByGoods(goods);
        return cartsByGoods.get(cartsByGoods.size() - 1).getId();
    }

    /**
     * 5.b feladat: Határozza meg, hogy a bekért árucikkből
     * összesen hány alkalommal vásároltak!
     */
    public int getCountOfCartsByGoods(String goods) {
        return getCartsByGoods(goods).size();
    }

    private List<Cart> getCartsByGoods(String goods) {
        return carts.stream()
                .filter(i -> i.contains(goods))
                .collect(Collectors.toList());
    }

    /**
     * 7. feladat: Határozza meg, hogy a bekért sorszámú vásárláskor
     * mely árucikkekből és milyen mennyiségben vásároltak!
     * Az árucikkek nevét tetszőleges sorrendben megjelenítheti.
     */
    public String getCartContentInDetailsById(int id) {
        return getCartById(id).getCartContentInDetails();
    }

    /**
     * 8. feladat: Készítse el az osszeg.txt fájlt, amelybe soronként
     * az egy-egy vásárlás alkalmával fizetendő összeg kerüljön a
     * kimeneti mintának megfelelően!
     */
    public List<String> getTotalValue() {
        return carts.stream()
                .map(Cart::toString)
                .collect(Collectors.toList());
    }

}
