import java.util.Random;

class Grid
{
    private final int SIZE = 20;
    private Cell [][] grid = new Cell[SIZE][SIZE];


    public Grid()
    {
        for(int i=0; i<SIZE; i++)
        {
            for(int j=0; j<SIZE; j++)
            {
                Cell cell = new Cell();
                grid[i][j] = cell;
                if(i>0)
                {
                    grid[i-1][j].addNeighbor(cell);
                    cell.addNeighbor(grid[i-1][j]);
                }
                if(j>0)
                {
                    grid[i][j-1].addNeighbor(cell);
                    cell.addNeighbor(grid[i][j-1]);
                }
            }
        }

    }
    public void addRandomly(Animal animal)
    {
        Random random = new Random();
        while (true)
        {
            int i = random.nextInt(20);
            int j = random.nextInt(20);
            if(!(grid[i][j].isEmpty()))
            {
                continue;
            }
            grid[i][j].setAnimal(animal);
            animal.setCellWhereTheAnimalIs(grid[i][j]);
            break;
        }
    }

    public String toString()
    {
        for(int i=0; i<SIZE; i++)
        {
            for(int j=0; j<SIZE; j++)
            {
                System.out.print(grid[i][j]);
            }
            System.out.println();
        }
        return "";
    }

    public static void main(String[] args)
    {
        Grid dokimi = new Grid();
        System.out.println(dokimi);
    }

}
