import java.awt.event.*;
import javax.swing.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
import java.awt.Graphics;
import java.awt.Color;
import java.util.ArrayList;
public class BossFightGUI extends GUI implements ActionListener
{
    private boolean Dodge = false;
    private Villains BossOBJ = new Boss();
    private ArrayList<Heroes> heroArr;
    private Color p;
    private int counter = 0;
    Timer t = new Timer(5,this);
    public BossFightGUI(ArrayList<Heroes> heroArr){
        p = new Color(255,0,0);
        BossFight(heroArr);
        this.heroArr = heroArr;
        btnAttack.addActionListener(this);
        btnDodge.addActionListener(this);
        btnPowerUp.addActionListener(this);
        repaint();
        t.start();
    }

    public void paint(Graphics g){
        g.drawImage(user,100,250,null);
        g.drawImage(Boss,500,250,null);
        g.setColor(p);
        g.clearRect(100,200,200,20);
        g.clearRect(500,200,300,20);
        g.clearRect(100,100,200,20);
        if(heroArr.get(0).ChosenWarrior||heroArr.get(1).ChosenWarrior){
            g.fillRect(100,100,heroArr.get(0).mana,20);
            g.fillRect(100,200,heroArr.get(0).hitPoints,20);
        }
        else{
            g.fillRect(100,100,heroArr.get(1).mana,20);
            g.fillRect(100,200,heroArr.get(1).hitPoints,20);

        }
        g.fillRect(500,200,BossOBJ.hitPoints,20);
    }

    public void actionPerformed(ActionEvent e){
        if(e.getSource()==btnAttack){
            if(heroArr.get(0).ChosenWarrior||heroArr.get(1).ChosenWarrior){
                heroArr.get(0).decreaseHitPoints(BossOBJ.getAttack());
                heroArr.get(0).increaseMana();
                BossOBJ.decreaseHitPoints(heroArr.get(0).getAttackPoints());
            }
            else{
                heroArr.get(1).decreaseHitPoints(BossOBJ.getAttack());
                heroArr.get(1).increaseMana();
                BossOBJ.decreaseHitPoints(heroArr.get(1).getAttackPoints());
            }

            if(heroArr.get(0).powerUp||heroArr.get(1).powerUp){
                counter = counter+1;
            }
            if (counter == 5){
                if(heroArr.get(0).ChosenWarrior||heroArr.get(1).ChosenWarrior){
                    heroArr.get(0).attackPoints = heroArr.get(0).attackPoints/2;
                    heroArr.get(0).powerUp = false;
                }
                else{
                    heroArr.get(1).attackPoints = heroArr.get(1).attackPoints/2;
                    heroArr.get(1).powerUp = false;
                }
                counter = 0;
            }
            if(heroArr.get(0).hitPoints <= 0||heroArr.get(1).hitPoints<=0){
                new GameOverGUI();
                setVisible(false);
            }
            else if(BossOBJ.hitPoints <=0){
                new YouWinGUI(heroArr);
                setVisible(false);
            }
        }
        if(e.getSource()==btnDodge){
            int ran = (int)(Math.random()*10)+1;
            if (ran<9||ran>0){
                Dodge = true;
                if(heroArr.get(0).ChosenWarrior||heroArr.get(1).ChosenWarrior){
                    heroArr.get(0).dodge(Dodge);
                }else{heroArr.get(1).dodge(Dodge);}
            }
            else if(ran>8){
                Dodge = false;
            }
            if(heroArr.get(0).ChosenWarrior||heroArr.get(1).ChosenWarrior){
                heroArr.get(0).increaseMana();
            }
            else{heroArr.get(1).increaseMana();}
        }
        if(e.getSource()==btnPowerUp){
            if(heroArr.get(0).mana >= 60|| heroArr.get(1).mana>=60){
                if(heroArr.get(0).ChosenWarrior||heroArr.get(1).ChosenWarrior){
                    heroArr.get(0).decreaseMana();
                    heroArr.get(0).attackPoints = heroArr.get(0).attackPoints*2;
                    heroArr.get(0).powerUp = true;
                }
                else{
                    heroArr.get(1).decreaseMana();
                    heroArr.get(1).attackPoints = heroArr.get(1).attackPoints*2;
                    heroArr.get(1).powerUp = true;

                }
            }else{
                if(heroArr.get(0).ChosenWarrior||heroArr.get(1).ChosenWarrior){
                    heroArr.get(0).decreaseHitPoints(BossOBJ.getAttack());
                }else{
                    heroArr.get(1).decreaseHitPoints(BossOBJ.getAttack());
                }
            }
        }
        repaint();
    }
}
