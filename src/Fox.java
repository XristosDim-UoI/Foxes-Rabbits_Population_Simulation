class Fox extends Animal
{

    private int numberOfStepsWithNoRabbitFound = 0;

    public Fox(){}

    @Override
    public boolean isRabbit() {
        return false;
    }

    @Override
    public boolean timeToBreed() {
        return getStepsSurvived()%8 == 0;
    }

    @Override
    public Animal giveBirth() {
        return new Fox();
    }

    @Override
    public void move()
    {
        for(Cell element : getCellWhereTheAnimalIs().getNeighboringCells())
        {
            if(element.getAnimal()!= null && element.getAnimal().isRabbit())
            {
                Rabbit rabbit = (Rabbit) element.getAnimal();
                rabbit.becomeEaten();
                this.getCellWhereTheAnimalIs().removeAnimal();
                element.setAnimal(this);
                this.setCellWhereTheAnimalIs(element);
                numberOfStepsWithNoRabbitFound = 0;
                survived();
                return;
            }
        }
        randomMove();
        survived();
    }

    public boolean starve()
    {
        if(this.numberOfStepsWithNoRabbitFound == 3)
        {
            this.getCellWhereTheAnimalIs().removeAnimal();
            return true;
        }

        return false;
    }

    public String toString()
    {
        return "X ";
    }

    public void setNumberOfStepsWithNoRabbitFound(int numberOfStepsWithNoRabbitFound)
    {
        this.numberOfStepsWithNoRabbitFound = numberOfStepsWithNoRabbitFound;
    }

    public int getNumberOfStepsWithNoRabbitFound()
    {
        return numberOfStepsWithNoRabbitFound;
    }

}


