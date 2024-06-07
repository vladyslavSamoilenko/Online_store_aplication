package menu.impl;

import configs.ApplicationContext;
import enteties.Cart;
import enteties.Product;
import enteties.impl.DefaultCart;
import menu.Menu;
import services.ProductManagementService;
import services.impl.DefaultProductManagementService;

import java.util.Map;
import java.util.Scanner;

public class ProductCatalogMenu implements Menu {
    private static final String CHECKOUT_COMMAND = "checkout";
    private ApplicationContext context;
    private ProductManagementService productManagementService;

    {
        context = ApplicationContext.getInstance();
        productManagementService = DefaultProductManagementService.getInstance();
    }

    @Override
    public void start() {
        Menu menuToNavigate = null;
        while(true){
            printMenuHeader();
            printProductsToConsole();

            String userInput = readUsernput();

            if(context.getLoggedInUser() == null){
                menuToNavigate = new MainMenu();
                System.out.println("You are not logged in. Please, sign in or create new account");
                break;

            }
            if (userInput.equalsIgnoreCase(MainMenu.MENU_COMMAND)){
                menuToNavigate = new MainMenu();
                break;
            }
            if (userInput.equalsIgnoreCase(CHECKOUT_COMMAND)){

                if ( context.getSessionCart() == null || context.getSessionCart().isEmpty()){
                    System.out.println("Your cart is empty. Please, add product to cart first and then proceed with checkout");
                }else {
                    menuToNavigate = new CheckoutMenu();
                    break;
                }
            }else {
                Product productAddToCart = fetchProduct(userInput);
                if (productAddToCart == null){
                    System.out.println("Please, enter product ID if you want to add product to cart. Or enter 'checkout' if you want to proceed with checkout. Or enter 'menu' if you want to navigate back to the main menu.");
                    continue;
                }

                processAddToCart(productAddToCart);
            }
        }
        menuToNavigate.start();

    }

    private void processAddToCart(Product productAddToCart) {
        context.getSessionCart().addProduct(productAddToCart);
        System.out.println("Product " + productAddToCart.getProductName() + " has been added to your cart. "
                + "If you want to add a new product - enter the product id. "
                + "If you want to proceed with checkout - enter word "
                + "'checkout' to console ");
    }

    private Product fetchProduct(String userInput) {
        int productIdToAddProduct = Integer.parseInt(userInput);
        Product productAddToCart = productManagementService.getProductById(productIdToAddProduct);
        return productAddToCart;
    }

    private void printProductsToConsole() {
        for (Product product : productManagementService.getProducts()) {
            System.out.println(product);
        }

    }

    private String readUsernput() {
            System.out.println("Product ID to add to cart or enter 'checkout' to proceed with checkout: ");
            Scanner sc = new Scanner(System.in);
            String userInput = sc.next();
            return userInput;

    }

    @Override
    public void printMenuHeader() {
        System.out.println("*** PRODUCT CATALOG MENU ***");
        System.out.println("Enter product id to add it to the cart or 'menu' if you want to navigate back to the main menu");
    }
}
