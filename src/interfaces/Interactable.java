package interfaces;

import abstractions.Item;

public interface Interactable {
    void take(Item object);
    void put(Item object);
    void eat(Item food);

}
