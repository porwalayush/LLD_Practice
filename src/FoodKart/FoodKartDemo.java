package FoodKart;

public class FoodKartDemo {
    public static void main(String[] args) {
        FoodKart foodKart = FoodKart.getInstance();
        foodKart.register_user("Rahul", "M", "1234567890", "HSR");
        foodKart.register_user("Ayush", "F", "6789012345", "BTM");
        foodKart.register_user("Rohit", "M", "1122334455", "HSR");
        foodKart.register_user("Shreya", "F", "2233445566", "BTM");

        foodKart.login_user("1122334455");
        foodKart.register_restaurant("FoodCourt-1", "BTM/HSR", "NI Thali", 100, 5);
        foodKart.register_restaurant("FoodCourt-2", "HSR", "Burger", 120, 3);

        foodKart.login_user("1234567890");
        foodKart.show_restaurant("price");

        foodKart.place_order("FoodCourt-2", 3);
        foodKart.create_review("FoodCourt-2", 1, "Good Food");
        foodKart.create_review("FoodCourt-1", 5, "Good Food");

        foodKart.show_restaurant("rating");
        foodKart.update_quantity("FoodCourt-2", 2);
        foodKart.place_order("FoodCourt-2", 1);
        foodKart.place_order("FoodCourt-2", 2);
        foodKart.update_location("FoodCourt-2", "BTM/HSR");
        foodKart.show_restaurant("price");

    }
}
