package ru.netology.javaqa.java;

public class ProductManager {


    protected ProductRepository repository;

    public ProductManager(ProductRepository repo) {
        this.repository = repo;
    }

    public void add(Product product) {
        repository.save(product);
    }

    public Product[] findAll() {
        Product[] items = repository.findAll();
        return items;
    }

    public Product[] searchBy(String text) {
        Product[] result = new Product[0];
        for (Product item : repository.findAll()) {
            if (matches(item, text)) {
                Product[] tmp = new Product[result.length + 1];
                for (int i = 0; i < result.length; i++) {
                    tmp[i] = result[i];
                }
                tmp[tmp.length - 1] = item;
                result = tmp;

            }
        }
        return result;
    }


    public boolean matches(Product item, String search) {
        return item.getName().contains(search);
    }
}
