package practice13_2.domain;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ShoppingCart implements Serializable {
    private static final long serialVersionUID = 23L;
    private int cartID;
    private ArrayList<Item> items;
    private int itemCount;
    private transient double cartTotal;

    public ShoppingCart ( int custID ) {
        this.cartID = custID;
        items = new ArrayList<>();
        itemCount = 0;
        cartTotal = 0;
    }

    public double getCartTotal () {
        return cartTotal;
    }

    public int getCartID () {
        return cartID;
    }

    public void addItem ( Item i ) {
        if (items.add(i)) {
            cartTotal += i.getCost();
        }
    }

    public int getCartSize () {
        return items.size();
    }

    public List<Item> getItems () {
        return items;
    }

    // Method invoked during deserialization (Adds a timestamp during serialization)
    private void writeObject ( ObjectOutputStream oos ) throws IOException {
        oos.defaultWriteObject();
        oos.writeObject(new Date());
    }

    // Method invoked during serialization (Recalculates the total cost of the shopping cart)
    private void readObject ( ObjectInputStream ois ) throws IOException, ClassNotFoundException {
        ois.defaultReadObject();
        if (cartTotal == 0 && (items.size() > 0)) {
            for (Item item : items) {
                cartTotal += item.getCost();
            }
            Date date = (Date) ois.readObject();
            System.out.println("Restored shopping cart from " + DateFormat.getDateInstance().format(date));
        }
    }
}
