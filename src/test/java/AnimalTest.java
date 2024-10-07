import lab.w6.Animal;
import lab.w6.Elephant;
import org.junit.jupiter.api.Test;

public class AnimalTest {
    @Test
    void elephantTest(){
        Animal elephant = new Elephant("China","Mu",1);
        elephant.makeNoise();
    }
}
