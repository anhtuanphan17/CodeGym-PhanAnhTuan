package ss7_abstract_and_interface.thuc_hanh.thuc_hanh1;

public class Chicken extends Animal implements Edible {
    @Override
    public String makeSound() {
        return "Chicken: cluck cluck";
    }
    @Override
    public String howToEat(){
        return "could be fried";
    }
}
