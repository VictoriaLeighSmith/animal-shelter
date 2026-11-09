package com.animalshelter;

public class Main {
    public static void main(String[] args) {
        AnimalShelter animalShelter = new AnimalShelter();

        Animal dog1 = new Animal("Buddy", "Dog");
        Animal cat1 = new Animal("Luna", "Cat");
        Animal dog2 = new Animal("Max", "Dog");

        animalShelter.enqueueAnimal(dog1);
        animalShelter.enqueueAnimal(cat1);
        animalShelter.enqueueAnimal(dog2);

        Animal adoptedAnimal = animalShelter.dequeueAnyAnimal();
        Animal adoptedCat = animalShelter.dequeueCat();

        System.out.println(adoptedAnimal.getName());
        System.out.println(adoptedCat.getName());
        System.out.println(animalShelter.dequeueCat());
    }
}
