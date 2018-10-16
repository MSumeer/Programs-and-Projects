import java.awt.event.*;
import java.awt.*;
import java.util.*;
public class GameOverGUI extends GUI implements ActionListener
{
    public GameOverGUI(){
        setVisible(true);
        setLayout(null);
        setSize(500,500);

        lblGameOver.setText("<html><h1>Game Over</h1></html>");
        lblGameOver.setBounds(50,190,200,60);
        btnMainMenu.setBounds(150,400,100,20);
        add(lblGameOver);
        add(btnMainMenu);

        btnMainMenu.addActionListener(this);

    }

    public void actionPerformed(ActionEvent e){
        ArrayList<Heroes> a = new ArrayList<Heroes>();
        fileWrite(a,true);
        new MenuGUI();
        setVisible(false);
    }
}
