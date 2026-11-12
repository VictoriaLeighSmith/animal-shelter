package com.animalshelter;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AnimalShelter animalShelter = new AnimalShelter();

        boolean running = true;

        while (running) {
            int choice;

            System.out.println("*".repeat(50));
            System.out.println("*              ANIMAL ADOPTION MENU              *");
            System.out.println("*".repeat(50));
            System.out.println();
            System.out.println("1. Add an animal to the shelter");
            System.out.println("2. Adopt oldest animal");
            System.out.println("3. Adopt oldest dog");
            System.out.println("4. Adopt oldest cat");
            System.out.println("5. Exit");
            System.out.println();
            System.out.print("Please choose an option: ");

            String option = scanner.nextLine();

            try {
                choice = Integer.parseInt(option);
            } catch (NumberFormatException e) {
                System.out.println();
                System.out.println("[ERROR] Invalid input. Please enter a number between 1 and 5.");
                System.out.println();
                continue;
            }

            switch (choice) {
                case 1:
                    addAnimal(scanner, animalShelter);
                    break;
                case 2:
                    adoptOldestAnimal(animalShelter);
                    break;
                case 3:
                    adoptOldestDog(animalShelter);
                    break;
                case 4:
                    adoptOldestCat(animalShelter);
                    break;
                case 5:
                    System.out.println();
                    System.out.println("Exiting...");
                    running = false;
                    break;
                default:
                    System.out.println();
                    System.out.println("[ERROR] Invalid input. Please enter a number between 1 and 5.");
                    System.out.println();
                    break;
            }
        }

        scanner.close();
    }

    private static void addAnimal(Scanner scanner, AnimalShelter animalShelter) {
        boolean validAnimalType = false;
        String animalName = "";
        String animalType = "";

        while (animalName.isBlank()) {
            System.out.print("Enter animal name: ");
            animalName = scanner.nextLine().trim();

            if (animalName.isBlank()) {
                System.out.println();
                System.out.println("[ERROR] Invalid input. Animal name cannot be blank.");
                System.out.println();
            }
        }

        while (!validAnimalType) {
            System.out.print("Enter animal type: ");
            animalType = scanner.nextLine().trim();

            if (!animalType.equalsIgnoreCase("cat") && !animalType.equalsIgnoreCase("dog")) {
                System.out.println();
                System.out.println("[ERROR] Invalid input. Animal type must be cat or dog.");
                System.out.println();
            } else {
                validAnimalType = true;
            }
        }

        Animal animal = new Animal(animalName, animalType);

        boolean successfullyAddedAnimal = animalShelter.enqueueAnimal(animal);

        if (successfullyAddedAnimal) {
            System.out.println();
            System.out.println("[SUCCESS] " + animalName + " (" + animalType.toLowerCase() + ")" + " successfully added to the shelter.");
            System.out.println();
        } else {
            System.out.println();
            System.out.println("[ERROR] Unable to add animal to the shelter.");
            System.out.println();
        }
    }

    private static void adoptOldestAnimal(AnimalShelter animalShelter) {
        Animal oldestAnimal = animalShelter.dequeueAnyAnimal();

        if (oldestAnimal == null) {
            System.out.println();
            System.out.println("[ERROR] Shelter is currently empty.");
            System.out.println();
        } else {
            System.out.println();
            System.out.println("[SUCCESS] Adopted " + oldestAnimal.getName() + " (" + oldestAnimal.getType().toLowerCase() + ")" + " from the shelter.");
            System.out.println();
        }
    }

    private static void adoptOldestDog(AnimalShelter animalShelter) {
        Animal oldestDog = animalShelter.dequeueDog();

        if (oldestDog == null) {
            System.out.println();
            System.out.println("[ERROR] There are no dogs available for adoption right now.");
            System.out.println();
        } else {
            System.out.println();
            System.out.println("[SUCCESS] Adopted " + oldestDog.getName() + " (" + oldestDog.getType().toLowerCase() + ")" + " from the shelter.");
            System.out.println();
        }
    }

    private static void adoptOldestCat(AnimalShelter animalShelter) {
        Animal oldestCat = animalShelter.dequeueCat();

        if (oldestCat == null) {
            System.out.println();
            System.out.println("[ERROR] There are no cats available for adoption right now.");
            System.out.println();
        } else {
            System.out.println();
            System.out.println("[SUCCESS] Adopted " + oldestCat.getName() + " (" + oldestCat.getType().toLowerCase() + ")" + " from the shelter.");
            System.out.println();
        }
    }
}
