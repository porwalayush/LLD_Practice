package FoodKart;

import java.util.ArrayList;
import java.util.List;

public class User {
    String userName;
    String gender;
    String phoneNumber;
    String location;
    List<String> orderHistory;

    User(String userName, String gender, String phoneNumber, String location) {
        this.userName = userName;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
        this.location = location;
        this.orderHistory = new ArrayList<>();
    }
    public List<String> getOrderHistory() {
        return orderHistory;
    }
}
