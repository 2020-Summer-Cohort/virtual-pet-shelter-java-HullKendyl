package shelter;

import java.util.Random;
import java.util.Scanner;

public class VirtualPetShelterApp {

    public static void main(String[] args) {

        //Create Objects

        VirtualPet pet1 = new VirtualPet("Doodle",
                "Tabby Cat. He stands out with his orange coat and is a feisty mouser.", 50 , 50, 50);
        VirtualPet pet2 = new VirtualPet("Bart",
                "Bearded Dragon. He is quite lazy and really enjoys his heat lamp.", 50, 50, 50);
        VirtualPet pet3 = new VirtualPet("Frodo",
                "Corgi. He is a silly dog that cannot control the booty wiggles.", 50, 50, 50);
        VirtualPet pet4 = new VirtualPet("Gilbert",
                "Teddy Bear Hamster. He is timid but loves cuddles.", 50, 50, 50);

        //Create shelterAnimals (petMap) to interact with all pets at one time.

        VirtualPetShelter shelterAnimals = new VirtualPetShelter();
        shelterAnimals.addAnimal(pet1);
        shelterAnimals.addAnimal(pet2);
        shelterAnimals.addAnimal(pet3);
        shelterAnimals.addAnimal(pet4);

        // Game Introduction

        welcomeStatement(pet1, pet2, pet3, pet4);

        // Begin Game Loop

        while (winConditions(shelterAnimals)) {

            // Current Stats

            showAnimalCurrentNeedsStatus(shelterAnimals);

            // Player Selection

            playerOptions();

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
                shelterAnimals.adopt();
            }else if (playerSelection == 5) {
                System.out.println("In order to admit an animal, please provide the following information as it is requested:");
                System.out.println("Animal Name:");
                String admittedAnimalName = scanner.nextLine();
                System.out.println("Animal Description: (species & characteristics)");
                String admittedAnimalDescription = scanner.nextLine();
                System.out.println("Thank you. " + admittedAnimalName + " is now under the care of DAS.");
                Random randomNumber = new Random();
                shelterAnimals.addAnimal(new VirtualPet(admittedAnimalName, admittedAnimalDescription, randomNumber.nextInt(50), randomNumber.nextInt(50), randomNumber.nextInt(50)));
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

    private static boolean winConditions(VirtualPetShelter shelter) {

        for (VirtualPet pet:shelter.petMap.values()) {
        if (pet.getBoredom() <= 0 || pet.getHunger() <= 0 || pet.getThirst() <= 0) {
            System.out.println(pet.getName() + " has died! You lose.");
            return false;}
        if (pet.getBoredom() >= 100 || pet.getHunger() >= 100 || pet.getThirst() >= 100){
            System.out.println(pet.getName() + " current needs have been met. Congratulations! You Win!");
            return false;}
        }
        return true;
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

    private static void playerOptions() {
        System.out.println("\n" + "What would you like to do?");
        System.out.println("1. Feed the animals");
        System.out.println("2. Give the animals water");
        System.out.println("3. Play with an animal");
        System.out.println("4. Adopt an animal");
        System.out.println("5. Admit an animal");
        System.out.println("6: Quit");
    }

}

