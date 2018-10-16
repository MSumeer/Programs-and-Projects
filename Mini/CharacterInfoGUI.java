import java.awt.event.*;
public class CharacterInfoGUI extends GUI implements ActionListener{

    public CharacterInfoGUI(){
        startNewGame();
        setVisible(true);

        btnBackNewGame.addActionListener(this);
        btnWizard.addActionListener(this);  
        btnWarrior.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e){
        if(e.getSource()==btnBackNewGame){
            setVisible(false);
            new MenuGUI();
        }
        if(e.getSource()==btnWizard){
            setVisible(false);
            new CharacterGUI(false);
        }
        if(e.getSource()==btnWarrior){
            setVisible(false);
            new CharacterGUI(true);
        }
    }
}