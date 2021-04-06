package GameObjects;

import Screens.Utills;

public class FoodGood extends Food {

    public FoodGood(){
        super(Utills.getInstance().getFoodGoodTexture());
    }
    @Override
    public int eat() {
        this.setRandomPosition();
        return 1;
    }
}
