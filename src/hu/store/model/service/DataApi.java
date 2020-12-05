package hu.store.model.service;

import hu.store.model.domain.Cart;

import java.util.List;

public class DataApi {

    private final FileReader fileReader;
    private final DataParser dataParser;

    public DataApi(FileReader fileReader, DataParser dataParser) {
        this.fileReader = fileReader;
        this.dataParser = dataParser;
    }

    public List<Cart> getCarts(String filename) {
        return dataParser.parse(fileReader.read(filename));
    }
}
