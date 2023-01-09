package sg.edu.nus.iss.app.httpsession.models;

import java.util.List;
import java.util.LinkedList;

// Class representing a shopping cart
public class Cart {
    // List of items in the cart
    private List<Item> contents =new LinkedList<Item>();
    
    // Returns the list of items in the cart
    public List<Item> getContents() {
        return contents;
    }

    // Sets the list of items in the cart
    public void setContents(List<Item> contents) {
        this.contents = contents;
    }

    // Adds an item to the cart
    public void addItemToCart(Item item){
        this.contents.add(item);
    }
}
