class Rabbit extends Animal
{
    private boolean eaten;

    public Rabbit(){}

    public Rabbit(Cell cellWhereTheAnimalIs)
    {
        super(cellWhereTheAnimalIs);
    }

    public boolean isEaten()
    {
        return eaten;
    }

    public void becomeEaten()
    {
        eaten = true;
    }

    public String toString()
    {
        return "O ";
    }

    @Override
    public boolean isRabbit() {
        return true;
    }

    @Override
    public boolean timeToBreed() {
        return getStepsSurvived()%3 == 0;
    }

    @Override
    public Animal giveBirth()
    {
       return new Rabbit();
    }

    @Override
    public void move()
    {
        randomMove();
        survived();
    }
}
