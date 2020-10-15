abstract class Animal
{
    private Cell cellWhereTheAnimalIs;
    private int stepsSurvived = 0;

    public abstract boolean isRabbit();
    public abstract boolean timeToBreed();
    public abstract Animal giveBirth();
    public abstract void move();

    public Animal(){}

    public Animal(Cell cellWhereTheAnimalIs)
    {
        this.cellWhereTheAnimalIs = cellWhereTheAnimalIs;
    }

    public void setCellWhereTheAnimalIs(Cell cell)
    {
        this.cellWhereTheAnimalIs =  cell;
    }

    public void setStepsSurvived(int stepsSurvived)
    {
        this.stepsSurvived = stepsSurvived;
    }

    public Cell getCellWhereTheAnimalIs()
    {
        return cellWhereTheAnimalIs;
    }

    public int getStepsSurvived()
    {
        return stepsSurvived;
    }

    public void survived()
    {
        this.setStepsSurvived(this.getStepsSurvived() + 1);
    }

    public void randomMove()
    {
        Cell cell = cellWhereTheAnimalIs.getRandomNeighbor();

        if(cell!=null && cell.isEmpty())
        {
            if(!this.isRabbit())
            {
                Fox fox = (Fox)this;
                fox.setNumberOfStepsWithNoRabbitFound(fox.getNumberOfStepsWithNoRabbitFound()+1);
            }
            cellWhereTheAnimalIs.removeAnimal();
            cellWhereTheAnimalIs = cell;
            cellWhereTheAnimalIs.setAnimal(this);

        }

    }

    public Animal breed()
    {
        if(this.timeToBreed())
        {
            for(Cell element : cellWhereTheAnimalIs.getNeighboringCells())
            {
                if(element != null && element.isEmpty())
                {
                    Animal animal = giveBirth();
                    element.setAnimal(animal);
                    animal.setCellWhereTheAnimalIs(element);
                    return animal;
                }
            }
        }
        return null;
    }

}
