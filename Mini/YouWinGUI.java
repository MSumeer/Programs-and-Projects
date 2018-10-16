import java.awt.event.*;
import java.awt.*;
import java.util.*;
public class YouWinGUI extends GUI implements ActionListener
{
    ArrayList<Heroes> heroArr;
    public YouWinGUI(ArrayList<Heroes> heroArr){
        setVisible(true);
        setLayout(null);
        setSize(500,500);

        lblGameOver.setText("<html><h1>Congrats You Beat The Game</h1></html>");
        lblGameOver.setBounds(50,190,200,60);
        btnMainMenu.setBounds(150,400,100,20);
        add(lblGameOver);
        add(btnMainMenu);
        this.heroArr = heroArr;
        btnMainMenu.addActionListener(this);

    }

    public void actionPerformed(ActionEvent e){
        fileWrite(heroArr,true);
        new MenuGUI();
        setVisible(false);
    }
}
