package king;

public class Knight {
    private Weapon arms;
    public Knight(Weapon arms) {
        this.arms = arms;
    }
    private void equipWeapon(Weapon newWeapon){
        this.arms = newWeapon;
    }
    public Weapon getWeapon(){
        return this.arms;
    }
}
