package shelter;

public class VirtualPet {

    // declare variables

    private String name;
    private String description;
    private int hunger;
    private int thirst;
    private int boredom;

    // create constructor with name & description

    public VirtualPet(String name, String description){
        this.name = name;
        this.description = description;
    }

    public VirtualPet(String name, String description, int hunger, int thirst, int boredom) {
        this.name = name;
        this.description = description;
        this.hunger = hunger;
        this.thirst = thirst;
        this.boredom = boredom;
    }

    //generate getter methods

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getHunger() {
        return hunger;
    }

    public int getThirst() {
        return thirst;
    }

    public int getBoredom() {
        return boredom;
    }

    //methods to update game stats based on playerSelection

    public void actionFeedAnimals(){
        hunger += 10;
        thirst -= 2;
    }

    public void actionGiveWaterToAnimals(){
        thirst += 10;
    }

    public void actionPlayWithAnAnimal(){
        boredom += 10;
        hunger -= 2;
        thirst -= 2;
    }

    void tick() {
        hunger = hunger -= 5;
        thirst = thirst -= 5;
        boredom = boredom -= 5;
    }
}
