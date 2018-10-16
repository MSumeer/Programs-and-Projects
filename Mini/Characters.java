public abstract class Characters
{
    protected int hitPoints;
    protected int attackPoints;
    protected boolean powerUp;
    protected String Name;
    protected int mana;
    
    public int getHitPoints(){
    return hitPoints;
    }
    
    public int getAttackPoints(){
    return attackPoints;
    }
    
    public boolean getPowerUp(){
    return powerUp;
    }
    
    public String getName(){
    return Name;
    }
    
    public void setName(String name){
    Name = name;
    }
}