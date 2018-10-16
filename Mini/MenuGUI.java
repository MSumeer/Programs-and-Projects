import java.awt.event.*;
public class MenuGUI extends GUI implements ActionListener
{
    public MenuGUI(){
        btnStartNewGame.setBounds(200,80,100,20);
        btnLoadGame.setBounds(200,150,100,20);

        setSize(500,500);
        setVisible(true);
        setLayout(null);

        add(btnStartNewGame);
        add(btnLoadGame);
        btnStartNewGame.addActionListener(this);
        btnLoadGame.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e){
        if(e.getSource()==btnStartNewGame){
        setVisible(false);
        new CharacterInfoGUI();
    }
    if(e.getSource()==btnLoadGame){
        LoadGame();
        
    }
    }
}