import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

class PopulationSimulator
{
    private Grid grid;
    private final int NUMBER_OF_FOXES = 5;
    private final int NUMBER_0F_RABBITS = 100;
    private HashSet<Rabbit> rabbitsHashSet = new HashSet<>();
    private HashSet<Fox> foxesHashSet =  new HashSet<>();


    public PopulationSimulator(int numberOfSteps)
    {
        Scanner input = new Scanner(System.in);
        populateGrid();
        int count = 0;
        while (count<numberOfSteps)
        {
            System.out.println(grid);
            System.out.println("Foxes : "+foxesHashSet.size());
            System.out.println("Rabbits : "+rabbitsHashSet.size());
            input.nextLine();
            handleFoxes();
            handleRabbits();
            count++;

        }


    }


    private void populateGrid()
    {
        this.grid = new Grid();
        for(int i=0; i<NUMBER_0F_RABBITS; i++)
        {
            Rabbit rabbit = new Rabbit();
            this.grid.addRandomly(rabbit);
            rabbitsHashSet.add(rabbit);
        }
        for(int i=0; i<NUMBER_OF_FOXES; i++)
        {
            Fox fox = new Fox();
            this.grid.addRandomly(fox);
            foxesHashSet.add(fox);
        }
    }


    private void handleFoxes()
    {
        ArrayList<Fox> foxArrayList = new ArrayList<>();
        for(Fox element : foxesHashSet) {
            element.move();
        }

        for(Fox element: foxesHashSet)
        {
            if(element.starve())
            {
                foxArrayList.add(element);
            }
        }

        for(Fox element : foxArrayList)
        {
            foxesHashSet.remove(element);
        }

        foxArrayList.clear();

        for(Fox element : foxesHashSet)
        {
            foxArrayList.add((Fox)element.breed());
        }

        for(Fox element : foxArrayList)
        {
            if(element != null)
            {
                foxesHashSet.add(element);
            }
        }
    }

    private void handleRabbits()
    {
        ArrayList<Rabbit> rabbitArrayList = new ArrayList<>();
        for(Rabbit element : rabbitsHashSet)
        {
            if(element.isEaten())
            {
                rabbitArrayList.add(element);
            }
        }

        for(Rabbit element : rabbitArrayList)
        {
            rabbitsHashSet.remove(element);
        }

        rabbitArrayList.clear();

        for(Rabbit element : rabbitsHashSet)
        {
            element.move();
            rabbitArrayList.add((Rabbit)element.breed());
        }

        for(Rabbit element : rabbitArrayList)
        {
            if(element != null)
            {
                rabbitsHashSet.add(element);
            }
        }
    }

}
