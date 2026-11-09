package com.animalshelter;

import java.util.LinkedList;
import java.util.Queue;

public class AnimalShelter {
    private int arrivalOrderCounter = 0;

    private Queue<Animal> dogQueue;
    private Queue<Animal> catQueue;

    public AnimalShelter() {
        this.dogQueue = new LinkedList<>();
        this.catQueue = new LinkedList<>();
    }

    public boolean enqueueAnimal(Animal animal) {
        if (animal == null) {
            return false;
        }

        String animalType = animal.getType();

        if (animalType == null) {
            return false;
        }

        if (!animalType.equalsIgnoreCase("cat") && !animalType.equalsIgnoreCase("dog")) {
            return false;
        }

        arrivalOrderCounter++;
        animal.setArrivalOrder(arrivalOrderCounter);

        if (animalType.equalsIgnoreCase("dog")) {
            dogQueue.offer(animal);
        } else {
            catQueue.offer(animal);
        }

        return true;
    }

    public Animal dequeueDog() {
        return dogQueue.poll();
    }

    public Animal dequeueCat() {
        return catQueue.poll();
    }

    public Animal dequeueAnyAnimal() {
        if (dogQueue.isEmpty() && catQueue.isEmpty()) {
            return null;
        }

        if (dogQueue.isEmpty()) {
            return dequeueCat();
        }

        if (catQueue.isEmpty()) {
            return dequeueDog();
        }

        int firstDogOrder = dogQueue.peek().getArrivalOrder();
        int firstCatOrder = catQueue.peek().getArrivalOrder();

        if (firstDogOrder < firstCatOrder) {
            return dequeueDog();
        } else {
            return dequeueCat();
        }
    }
}
