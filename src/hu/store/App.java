package hu.store;

import hu.store.controller.CartService;
import hu.store.model.service.*;

import java.util.Scanner;

public class App {

    private final CartService cartService;
    private final DataWriter dataWriter;
    private final Console console;

    private App() {
        console = new Console(new Scanner(System.in));
        dataWriter = new DataWriter("osszeg.txt");
        DataApi dataApi = new DataApi(new FileReader(), new DataParser());
        cartService = new CartService(dataApi.getCarts("penztar.txt"));
    }

    public static void main(String[] args) {
        new App().run();
    }

    private void run() {
        System.out.println("2. feladat");
        System.out.println("A fizetések száma: " + cartService.getCartNumber());
        System.out.println("3. feladat:");
        System.out.println("Az első vásárló " +
                cartService.getGoodsNumberInChart(1) +
                " darab árucikket vásárolt. ");
        System.out.println("4. feladat");
        System.out.print("Adja meg egy vásárlás sorszámát! ");
        int id = console.readInt();
        System.out.print("Adja meg egy árucikk nevét! ");
        String item = console.read();
        System.out.print("Adja meg a vásárolt darabszámot! ");
        int count = console.readInt();
        System.out.println("5. feladat:");
        System.out.println("Az első vásárlás sorszáma: " +
                cartService.getFirstCartIdByGoods(item));
        System.out.println("Az utolsó vásárlás sorszáma: " +
                cartService.getLastCartIdByGoods(item));
        System.out.println(cartService.getCountOfCartsByGoods(item) +
                " vásárlás során vettek belőle.");
        System.out.println("6. feladat:");
        System.out.println(count + " darab vételekor fizetendő: " +
                ValueCalculator.calculate(count));
        System.out.println("7. feladat");
        System.out.println(cartService.getCartContentInDetailsById(id));
        dataWriter.printAll(cartService.getTotalValue());
    }
}
