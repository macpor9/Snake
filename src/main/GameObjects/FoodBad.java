package GameObjects;

import Screens.Utills;

public class FoodBad extends Food {

    public FoodBad(){
        super(Utills.getInstance().getFoodBadTexture());
    }
    @Override
    public int eat() {
        this.setRandomPosition();
        return -1;
    }
}
