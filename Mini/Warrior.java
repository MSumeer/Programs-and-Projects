public class Warrior extends Heroes
{
    public Warrior(){
    
        hitPoints = 120;
        attackPoints = 10;
        powerUp = true;
    
    }
    public void increaseHP(){
        hitPoints = hitPoints + 5;
    }
}