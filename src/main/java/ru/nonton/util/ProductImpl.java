package ru.nonton.util;

import ru.nonton.model.Product;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * This class contains the storage of Product objects and CRUD methods for working with it.
 *
 * @author Rustam Saidov
 * @version 1.0.0-SNAPSHOT
 */
public class ProductImpl {
    private final Set<Product> productSet = new HashSet<>();

    /**
     * This method using to test the existence of Product in the storage
     *
     * @param product object of Product
     * @return boolean value of presence Product in the storage
     */
    public boolean addProduct(Product product) {
        return productSet.add(product);
    }

    /**
     * This method using to delete Product from the storage
     *
     * @param product object of Product
     * @return boolean value of deleting Product from the storage
     */
    public boolean deleteProduct(Product product) {
        return productSet.remove(product);
    }

    /**
     * This method using to get name of Product in the storage by id
     *
     * @param id parameter of Product
     * @return String value of Product name
     */
    public String getName(int id) {
        boolean isPresent = productSet.stream().anyMatch(x -> x.getId() == id);
        return isPresent ? productSet.stream().filter(x -> x.getId() == id).findFirst().get().getName() : "";
    }

    /**
     * This method using to get list of id's by the Product name
     *
     * @param name parameter of Product
     * @return List<Product> value id's
     */
    public List<Product> findByName(String name) {
        return productSet.stream().filter(x -> x.getName() == name).toList();
    }

    /**
     * Main method of program. Create Set of objects and output them with their parameters by request
     *
     * @param args - entry arguments
     */
    public static void main(String[] args) {
        ProductImpl prodStore = new ProductImpl();
        System.out.println("Create products with the names laptop, smartphone, smartphone: ");
        Product product1 = new Product(1, "laptop");
        Product product2 = new Product(2, "smartphone");
        Product product3 = new Product(3, "smartphone");
        System.out.println("Add this products to storage: ");
        System.out.println("adding " + product1 + " to the storage: " + prodStore.addProduct(product1));
        System.out.println("adding " + product2 + " to the storage: " + prodStore.addProduct(product2));
        System.out.println("adding " + product3 + " to the storage: " + prodStore.addProduct(product3));
        System.out.println("Add first product to storage again: ");
        System.out.println("adding " + product1 + " to the storage: " + prodStore.addProduct(product1));
        System.out.println("get name of the product with id=1");
        System.out.println(prodStore.getName(1));
        System.out.println("get name of the product with id=999");
        System.out.println(prodStore.getName(999));
        System.out.println("return a list of products id with the name smartphone:");
        System.out.println(prodStore.findByName("smartphone"));
        System.out.println("return a list of products id with the name absentprod:");
        System.out.println(prodStore.findByName("absentprod"));
    }
}
