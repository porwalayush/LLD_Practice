package FoodKart;

import java.util.*;

public class FoodKart {
    public static FoodKart foodKartInstance = null;
    public Map<String, User> phoneToUserMapping = new HashMap<>();
    public Map<String, Restaurant> nameToRestaurantMapping = new HashMap<>();
    public User currentUser;

    private FoodKart() {
        // private constructor
        currentUser = null;
    }

    public static FoodKart getInstance() {
        if (foodKartInstance == null) {
            foodKartInstance = new FoodKart();
        }
        return foodKartInstance;
    }

    void register_user(String username, String gender, String phoneNumber, String location){
        phoneToUserMapping.put(phoneNumber, new User(username, gender, phoneNumber, location));
    }

    void login_user(String phoneNumber){
        if(phoneToUserMapping.containsKey(phoneNumber)) {
            currentUser = phoneToUserMapping.get(phoneNumber);
        }
    }

    void register_restaurant(String restaurantName, String restaurantLocation, String dishName, int price, int quantity){
        if(currentUser!=null)
        {
            nameToRestaurantMapping.put(restaurantName, new Restaurant(restaurantName, getListOfLocations(restaurantLocation), dishName, price, quantity, currentUser));
        }
    }

    void show_restaurant(String condition) {
        List<Restaurant> availableRestaurant = new ArrayList<>();
        for(Restaurant restaurant: nameToRestaurantMapping.values()){
            if(restaurant.isServiceable(currentUser.location)) {
                availableRestaurant.add(restaurant);
            }
        }
        if("price".equals(condition)) {
            availableRestaurant.sort(Comparator.comparingInt(Restaurant::getPrice).reversed());
        } else {
            availableRestaurant.sort(Comparator.comparingDouble(Restaurant::getAvarageRating).reversed());
        }
        for(Restaurant restaurant: availableRestaurant) {
            System.out.println(restaurant.restaurantName + "," + restaurant.dishName);
        }
    }

    void place_order(String restaurantName, int quantity) {
        if(nameToRestaurantMapping.containsKey(restaurantName)) {
            Restaurant current_restaurant = nameToRestaurantMapping.get(restaurantName);
            if(current_restaurant.isServiceable(currentUser.location) && current_restaurant.quantity>=quantity){
                current_restaurant.updateQuantity(-quantity);
                System.out.println("Order Placed Successfully.");
            } else {
                System.out.println("Cannot place order.");
            }
        }
    }

    void create_review(String restaurantName, int rating, String comment){
        if(nameToRestaurantMapping.containsKey(restaurantName)) {
            nameToRestaurantMapping.get(restaurantName).addRating(rating, comment);
        }
    }

    void update_quantity(String restaurantName, int increasedQuantity) {
        if(nameToRestaurantMapping.containsKey(restaurantName)) {
            nameToRestaurantMapping.get(restaurantName).updateQuantity(increasedQuantity);
        }
    }

    void update_location(String restaurantName, String locations) {
        if(nameToRestaurantMapping.containsKey(restaurantName)) {
            nameToRestaurantMapping.get(restaurantName).updateLocation(getListOfLocations(locations));
        }
    }


    Set<String> getListOfLocations(String restaurantLocation) {
        return new HashSet<>(Arrays.asList(restaurantLocation.split("/")));
    }
}
