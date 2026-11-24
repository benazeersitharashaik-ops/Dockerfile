
import java.util.*;

public class ShoppingWebsite {

    static class Product {
        int id;
        String name;
        double price;

        Product(int id, String name, double price) {
            this.id = id;
            this.name = name;
            this.price = price;
        }
    }

    static Scanner sc = new Scanner(System.in);

    static ArrayList<Product> products = new ArrayList<>();
    static ArrayList<Product> cart = new ArrayList<>();

    static void loadProducts() {
        products.add(new Product(1, "Laptop", 55000));
        products.add(new Product(2, "Mobile", 25000));
        products.add(new Product(3, "Headphones", 1500));
        products.add(new Product(4, "Smart Watch", 3000));
        products.add(new Product(5, "Shoes", 2000));
    }

    static void showProducts() {
        System.out.println("\n===== SHOPPING PRODUCTS =====");

        for (Product p : products) {
            System.out.println(
                p.id + ". " + p.name + " - Rs." + p.price
            );
        }
    }

    static void addToCart() {
        showProducts();

        System.out.print("\nEnter Product ID: ");
        int id = sc.nextInt();

        for (Product p : products) {
            if (p.id == id) {
                cart.add(p);
                System.out.println(p.name + " Added to Cart!");
                return;
            }
        }

        System.out.println("Product Not Found!");
    }

    static void showCart() {
        System.out.println("\n===== YOUR CART =====");

        if (cart.isEmpty()) {
            System.out.println("Cart is Empty!");
            return;
        }

        double total = 0;

        for (Product p : cart) {
            System.out.println(p.name + " - Rs." + p.price);
            total += p.price;
        }

        System.out.println("----------------------");
        System.out.println("Total Amount: Rs." + total);
    }

    static void checkout() {
        if (cart.isEmpty()) {
            System.out.println("Your Cart is Empty!");
            return;
        }

        showCart();

        System.out.print("\nConfirm Order? (yes/no): ");
        String choice = sc.next();

        if (choice.equalsIgnoreCase("yes")) {
            System.out.println("\nOrder Placed Successfully!");
            System.out.println("Thank You For Shopping!");

            cart.clear();
        } else {
            System.out.println("Order Cancelled!");
        }
    }

    public static void main(String[] args) {

        loadProducts();

        while (true) {

            System.out.println("\n================================");
            System.out.println("       WELCOME TO SHOP EASY");
            System.out.println("================================");
            System.out.println("1. View Products");
            System.out.println("2. Add To Cart");
            System.out.println("3. View Cart");
            System.out.println("4. Checkout");
            System.out.println("5. Exit");

            System.out.print("\nEnter Your Choice: ");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    showProducts();
                    break;

                case 2:
                    addToCart();
                    break;

                case 3:
                    showCart();
                    break;

                case 4:
                    checkout();
                    break;

                case 5:
                    System.out.println("Thank You! Visit Again.");
                    return;

                default:
                    System.out.println("Invalid Choice!");
            }
        }
    }
}
