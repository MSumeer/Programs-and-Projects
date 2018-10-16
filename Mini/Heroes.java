public abstract class Heroes extends Characters
{

    protected boolean powerUp = true;
    protected boolean ChosenWarrior = false;
    protected int level =0;
    public void increaseAttack(){
        attackPoints = attackPoints + 2;
    }

    public void increaseHP(){
        hitPoints = hitPoints + 2;
    }

    public void decreaseHitPoints(int VillianAttack){  
        hitPoints = hitPoints-VillianAttack;}

    public void dodge(boolean dodge){
        if(dodge){
            hitPoints = hitPoints + 40;
        }
    }

    public void increaseMana(){
        mana=mana+10;
    }

    public void decreaseMana(){mana = mana-60;}
}