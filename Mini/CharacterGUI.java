import java.awt.event.*;
import java.util.*;
public class CharacterGUI extends GUI implements ActionListener
{
    private ArrayList<Heroes> heroArr = new ArrayList<Heroes>();
    public CharacterGUI(boolean isWarrior){
        heroArr.add(new Warrior());
        heroArr.add(new Wizard());
        heroArr.get(0).ChosenWarrior = isWarrior;
        heroArr.get(1).ChosenWarrior = isWarrior;
        if(isWarrior){
            WarriorGUI();
        }
        else{
            WizardGUI();
        }

    }
    public void WizardGUI(){
        wizard();
        btnSelectWizard.addActionListener(this);
        btnBackWizard.addActionListener(this);

    }

    public void WarriorGUI(){
        warrior();

        btnBackWarrior.addActionListener(this);
        btnSelectWarrior.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==btnBackWizard){
            setVisible(false);
            new CharacterInfoGUI();
        }
        if(e.getSource()==btnSelectWizard){
            setVisible(false);
            new CharacterUpgradeGUI(heroArr);
        }
        if(e.getSource()==btnSelectWarrior){
            setVisible(false);
            new CharacterUpgradeGUI(heroArr);
        }
        if(e.getSource()==btnBackWarrior){
            setVisible(false);
            new CharacterInfoGUI();
        }
    }

}