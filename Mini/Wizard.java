public class Wizard extends Heroes
{
    public Wizard(){
    
        hitPoints = 80;
        attackPoints = 20;
        powerUp = true;
    
    }
    public void increaseAttack(){
        attackPoints = attackPoints + 5;
    }
}