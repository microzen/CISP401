package king;

public class Weapon {
    private Material material;
    public Weapon(Material material) {
        this.material = material;
    }

    public Material getMaterial() {
        return material;
    }
    public void reforge(Material newMaterial) {
        this.material = newMaterial;
    }
}
