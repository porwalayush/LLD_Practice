package FoodKart;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Restaurant {
    String restaurantName;
    Set<String> restaurantLocations;
    String dishName;
    int price;
    int quantity;
    User owner;
    List<Integer> ratings;
    List<String> comments;

    Restaurant(String restaurantName, Set<String> restaurantLocation, String dishName, int price, int quantity, User owner) {
        this.restaurantName = restaurantName;
        this.restaurantLocations = restaurantLocation;
        this.dishName = dishName;
        this.price = price;
        this.quantity = quantity;
        this.owner = owner;
        this.ratings = new ArrayList<>();
        this.comments = new ArrayList<>();
    }

    void updateQuantity(int increaseQuantity) {
        this.quantity = this.quantity + increaseQuantity;
    }
    void updateLocation(Set<String> restaurantLocations) {
        this.restaurantLocations = restaurantLocations;
    }
    void addRating(int rating, String comment) {
        ratings.add(rating);
        if(!comment.isEmpty()){
            comments.add(comment);
        }
    }

    boolean isServiceable(String userLocation){
        return restaurantLocations.contains(userLocation) && quantity>0;
    }
    int getPrice() {
        return price;
    }
    double getAvarageRating() {
        return ratings.isEmpty() ? 0 : ratings.stream().mapToInt(Integer::intValue).average().orElse(0.0);
    }
}
