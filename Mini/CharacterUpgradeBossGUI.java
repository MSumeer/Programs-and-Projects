import java.awt.event.*;
import javax.swing.*;
import java.util.*;
public class CharacterUpgradeBossGUI extends GUI implements ActionListener{
    private ArrayList<Heroes> heroArr = new ArrayList<Heroes>();
    public CharacterUpgradeBossGUI(ArrayList<Heroes> heroArr){
        this.heroArr = heroArr;
        if(heroArr.get(0).ChosenWarrior||heroArr.get(1).ChosenWarrior){
            CharacterUpgradeWarrior();
        }
        else{CharacterUpgradeWizard();}
    }

    public void CharacterUpgradeWarrior(){
        startRealGame(); 
        btnIncrAttack.addActionListener(this);
        btnIncrHP.addActionListener(this);
        btnNextLevel.addActionListener(this);
        btnSave.addActionListener(this);
    }

    public void CharacterUpgradeWizard(){
        startRealGame(); 
        btnIncrAttack.addActionListener(this);
        btnIncrHP.addActionListener(this);
        btnNextLevel.addActionListener(this);
        btnSave.addActionListener(this);

    }

    public void actionPerformed(ActionEvent e){
        if(e.getSource()==btnIncrAttack){
            if (heroArr.get(0).ChosenWarrior||heroArr.get(1).ChosenWarrior){
                heroArr.get(0).increaseAttack();
            }
            else{
                heroArr.get(1).increaseAttack();
            }
            btnIncreaseAttack(heroArr);
        }
        if(e.getSource()==btnIncrHP){
            if (heroArr.get(0).ChosenWarrior||heroArr.get(1).ChosenWarrior){
                heroArr.get(0).increaseHP();
            }
            else{heroArr.get(1).increaseHP();}
            btnIncreaseHP(heroArr);
        }
        if(e.getSource()==btnNextLevel){

            setVisible(false);
            new MapBossGUI(heroArr);

        }
        if(e.getSource()==btnSave){ 
            fileWrite(heroArr,false);
            setVisible(false);
        }
    }
}