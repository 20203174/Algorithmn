package study.generic.lotte_world;

public class Main {
    public static void main(String[] args) {
        Zoo lotteWorld = new Zoo();

        lotteWorld.addAnimal(new Giraffe());
        lotteWorld.addAnimal(new Quokka());

        AnimalIteratorImpl animalIterator = new AnimalIteratorImpl(lotteWorld.getAnimals());
        animalIterator.iterateAnimal();
    }
}
