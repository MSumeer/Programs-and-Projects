public class Villains extends Characters
{
    public void setPowerUp(){
        powerUp = false;
    }
    public int getAttack(){return attackPoints;}
    public void decreaseHitPoints(int userAttack){
       hitPoints = hitPoints-userAttack;
    }
}