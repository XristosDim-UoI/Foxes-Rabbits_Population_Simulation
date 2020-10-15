import java.util.ArrayList;
import java.util.Random;

class Cell {
    private ArrayList<Cell> neighboringCells = new ArrayList<>(4);
    private Animal animal = null;


    public ArrayList<Cell> getNeighboringCells() {
        return neighboringCells;
    }

    public void addNeighbor(Cell cell) {

        this.neighboringCells.add(cell);
    }

    public Cell getRandomNeighbor() {
        Random random = new Random();
        int randomNumber = 0;
        if(getNeighboringCells().size()==4)
        {
            randomNumber = random.nextInt(4);
        }
        if(getNeighboringCells().size()==3)
        {
            randomNumber = random.nextInt(3);
        }
        else
            {
                randomNumber = random.nextInt(2);
            }
        return neighboringCells.get(randomNumber);

    }

    public void removeAnimal()
    {
        this.animal = null;
    }

    public boolean isEmpty()
    {
        return animal == null;
    }

    public void setAnimal(Animal animal)
    {
        this.animal = animal;
    }
    public boolean containsRabbit()
    {
        return this.getAnimal().isRabbit();
    }

    public String toString()
    {
       if(animal == null)
       {
           return "_ ";
       }
       else
       {
           return animal+"";
       }
    }

    public Animal getAnimal()
    {
        return animal;
    }

}
