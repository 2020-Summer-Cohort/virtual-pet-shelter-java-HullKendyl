package shelter;

import java.util.*;

public class VirtualPetShelter {

        Map<String, VirtualPet> petMap = new HashMap<String, VirtualPet>();

        public void addAnimal(VirtualPet pet) {
            petMap.put(pet.getName(),pet);
        }

        public void actionFeedAllAnimals(){
            for (VirtualPet petToFeed : petMap.values()) {
                petToFeed.actionFeedAnimals();
            }
            }

        public void actionGiveWaterToAnimals(){
            for (VirtualPet petToWater: petMap.values()){
                petToWater.actionGiveWaterToAnimals();
            }
        }

        public void actionPlayWithPet(String petName) {
            petMap.get(petName).actionPlayWithAnAnimal();
        }

        public Set<String> retrievePetNames(){
            return petMap.keySet();
        }

        public Collection<VirtualPet> retrieveAllPets() {
            return petMap.values();
        }


        // Set up tick method

        public void tickAll(){
            for (VirtualPet petToTick: petMap.values()){
                petToTick.tick();
            }
        }

    public void adopt() {
        System.out.println("Which animal would you like to adopt?");
        for (VirtualPet pet:retrieveAllPets()) {
            System.out.println(pet.getName() + " - " + pet.getDescription());
        }
        Scanner scanner = new Scanner(System.in);
        String adoptedAnimalName = scanner.nextLine();
            if (petMap.containsKey(adoptedAnimalName)) {
                petMap.remove(adoptedAnimalName);
                System.out.println("Yay! Congratulations on finding " + adoptedAnimalName + " a new home.");
            } else {
             System.out.println("Sorry that animal does not exist. Note: User input is case sensitive.");
            }

    }
}
