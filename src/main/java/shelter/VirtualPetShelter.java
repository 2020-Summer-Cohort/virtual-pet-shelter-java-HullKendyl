package shelter;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class VirtualPetShelter {

        Map<String, VirtualPet> petMap = new HashMap<String, VirtualPet>();

        public void addAnimal(VirtualPet pet) {
            petMap.put(pet.getName(),pet);
        }

        public void removeAnimal(VirtualPet pet){
            petMap.remove(pet.getName(),pet);
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
}
