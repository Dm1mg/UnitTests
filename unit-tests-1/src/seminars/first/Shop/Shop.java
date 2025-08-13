package seminars.first.Shop;

import java.util.Comparator;
import java.util.List;

public class Shop implements Comparator<Product> {
    private List<Product> products;

    public Shop(List<Product> products) {
        this.products = products;
    }

    // Геттеры, сеттеры:
    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    // Метод должен вернуть отсортированный по возрастанию по цене список продуктов
    public List<Product> sortProductsByPrice() {
        List<Product> result = this.products;
        result.sort(Comparator.comparingInt(Product::getCost));
        return result;
    }

    // Метод должен вернуть самый дорогой продукт
    public Product getMostExpensiveProduct() {
        List<Product> products = sortProductsByPrice();
        return products.getLast();
    }

    @Override
    public String toString() {
        return "Shop{" +
                "products=" + products +
                '}';
    }

    @Override
    public int compare(Product o1, Product o2) {
        int coast1 = o1.getCost();
        int coast2 = o2.getCost();
        return Integer.compare(coast1, coast2);

    }
}