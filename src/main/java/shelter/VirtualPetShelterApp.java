package shelter;

import java.util.Random;
import java.util.Scanner;

public class VirtualPetShelterApp {

    public static void main(String[] args) {

        //Create Objects

        VirtualPet pet1 = new VirtualPet("Doodle",
                "Tabby Cat. He stands out with his orange coat and is a feisty mouser.", 25, 25, 25);
        VirtualPet pet2 = new VirtualPet("Bart",
                "Bearded Dragon. He is quite lazy and really enjoys his heat lamp.", 25, 25, 25);
        VirtualPet pet3 = new VirtualPet("Frodo",
                "Corgi. He is a silly dog that cannot control the booty wiggles.", 25, 25, 25);
        VirtualPet pet4 = new VirtualPet("Gilbert",
                "Teddy Bear Hamster. He is timid but loves cuddles.", 25, 25, 25);

        //Create shelterAnimals (petMap) to interact with all pets at one time.

        VirtualPetShelter shelterAnimals = new VirtualPetShelter();
        shelterAnimals.addAnimal(pet1);
        shelterAnimals.addAnimal(pet2);
        shelterAnimals.addAnimal(pet3);
        shelterAnimals.addAnimal(pet4);

        // Game Introduction

        welcomeStatement(pet1, pet2, pet3, pet4);

        // Begin Game Loop

        while (true) {


            // Current Stats

            showAnimalCurrentNeedsStatus(shelterAnimals);

            // Win Conditions
            //
            // idea? for (VirtualPet petToDisplay: shelter.retrieveAllPets()) {
            //            System.out.println(petToDisplay.getName() + "\t" + "|" + petToDisplay.getHunger() + "\t"  + "\t" + "|" + petToDisplay.getThirst() + "\t" + "\t" + "|"
            //                + petToDisplay.getBoredom());
//
//            if (shelterAnimals.getHunger() <= 0) {
//                System.out.println("\n" + "Unfortunately, the Hunger level has reached 0. " + petName + " is starving and has been taken by animal control. You Lose!");
//                break;
//            }
//            if (pet.getThirst() <= 0) {
//                System.out.println("Unfortunately, the Thirst level has reached 0." + petName + " is severely dehydrated and has been taken by animal control. You Lose!");
//                break;
//            }
//            if (pet.getEnergy() <= 0) {
//                System.out.println("Unfortunately, the Energy level has reached 0." + petName + " is sleep deprived and has passed out. You Lose!");
//                break;
//            }
//            if (pet.getBoredom() <= 0) {
//                System.out.println("Unfortunately, the Boredom level has reached 0." + petName + " is neglected and has been taken by animal control. You Lose!");
//                break;
//            }
//            if (pet.getLove() <= 0) {
//                System.out.println("Unfortunately, the Love level has reached 0." + petName + " is neglected and has been taken by animal control. You Lose!");
//                break;
//            }
//            if (pet.getHunger() >= 50 || pet.getThirst() >= 50 || pet.getBoredom() >= 50 || pet.getEnergy() >= 50 || pet.getLove() >= 50){
//                System.out.println("Congratulations! " + petName + " has reached a maximum level of 50." + "\n" + "Great job taking care of your VirtualPet!");
//                break;
//            }

            // Player Selection

            System.out.println("\n" + "What would you like to do?");
            System.out.println("1. Feed the animals");
            System.out.println("2. Give the animals water");
            System.out.println("3. Play with an animal");
            System.out.println("4. Adopt an animal");
            System.out.println("5. Admit an animal");
            System.out.println("6: Quit");

            //use scanner to read player responses

            Scanner scanner = new Scanner(System.in);

            //user int playerSelection to create a spot for user input

            int playerSelection = scanner.nextInt();
            scanner.nextLine();

            //if statements to recognize playerSelection & direct game on what to do based on their selection

            if (playerSelection == 1) {
                System.out.println("You give food to all of the animals.");
                shelterAnimals.actionFeedAllAnimals();
            } else if (playerSelection == 2) {
                System.out.println("You give water to each of the animals.");
                shelterAnimals.actionGiveWaterToAnimals();
            } else if (playerSelection == 3) {
                System.out.println("Which animal would you like to play with?");
                for (VirtualPet pet:shelterAnimals.retrieveAllPets()) {
                    System.out.println(pet.getName() + " - " + pet.getDescription());
                }
                String playerPlayChoice = scanner.nextLine();
                // returns true if animal is in shelter
                if (shelterAnimals.retrievePetNames().contains(playerPlayChoice)){
                    shelterAnimals.actionPlayWithPet(playerPlayChoice);
                    System.out.println("You picked " + playerPlayChoice + ".");
                } else {
                    System.out.println("Sorry that animal does not exist.");
                    continue;
                }
            }else if (playerSelection == 4) {
                System.out.println("Which animal would you like to adopt?");
                for (VirtualPet pet:shelterAnimals.retrieveAllPets()) {
                    System.out.println(pet.getName() + " - " + pet.getDescription());
                }
                String adoptedAnimalName = scanner.nextLine();
                if (shelterAnimals.retrievePetNames().contains(adoptedAnimalName)){
                    shelterAnimals.petMap.remove(adoptedAnimalName);
                }
                System.out.println("Yay! Congratulations on finding " + adoptedAnimalName + " a new home.");
            }else if (playerSelection == 5) {
                System.out.println("In order to admit an animal, please provide the following information as it is requested:");
                System.out.println("Animal Name:");
                String admittedAnimalName = scanner.nextLine();
                System.out.println("Animal Description: (species & characteristics)");
                String admittedAnimalDescription = scanner.nextLine();
                System.out.println("Thank you. " + admittedAnimalName + " is now under the care of DAS.");
                Random randomNumber = new Random();
                shelterAnimals.addAnimal(new VirtualPet(admittedAnimalName, admittedAnimalDescription, randomNumber.nextInt(21), randomNumber.nextInt(21), randomNumber.nextInt(21)));
            } else if (playerSelection == 6){
                System.out.println("Thank you for playing. See you later!");
                break;
            } else {
                continue;
            }

            // call to tick method in VirtualPetShelter
            shelterAnimals.tickAll();

        }
    }

    private static void welcomeStatement(VirtualPet pet1, VirtualPet pet2, VirtualPet pet3, VirtualPet pet4) {
        System.out.println("Welcome to DAS: The Domesticated Animal Shelter!" + "\n");
        System.out.println("As this is your first day volunteering, " + "\n" +
                "we would like to familiarize you with our animal residents and " + "\n" +
                "your responsibilities." + "\n");
        System.out.println("Meet " + pet1.getName() + ", " + pet2.getName() + ", " + pet3.getName() + ", and "+ pet4.getName() + "." + "\n");
        System.out.println(pet1.getName() + " is a " + pet1.getDescription() + "\n");
        System.out.println(pet2.getName() + " is a " + pet2.getDescription() + "\n");
        System.out.println(pet3.getName() + " is a " + pet3.getDescription() + "\n");
        System.out.println(pet4.getName() + " is a " + pet4.getDescription() + "\n");
        System.out.println("Let's check out the statuses of their current needs.");
    }

    public static void showAnimalCurrentNeedsStatus(VirtualPetShelter shelter){
        System.out.println("\n" + " - Current Stats -" + "\n");
        System.out.println("Name\t|Hunger\t|Thirst\t|Boredom\t");
        System.out.println("----\t|------\t|------\t|-------\t");
        for (VirtualPet petToDisplay: shelter.retrieveAllPets()) {
            System.out.println(petToDisplay.getName() + "\t" + "|" + petToDisplay.getHunger() + "\t"  + "\t" + "|" + petToDisplay.getThirst() + "\t" + "\t" + "|"
                + petToDisplay.getBoredom());
        }
    }
}

