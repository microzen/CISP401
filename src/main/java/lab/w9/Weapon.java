package lab.w9;

public abstract class Weapon {
    protected String actionWord;
    public Weapon (String action) {
        actionWord = action;
    }
    public abstract String getName();
    public String getAction() {
        return actionWord;
    }
}
