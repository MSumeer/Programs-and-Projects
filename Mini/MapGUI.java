import java.awt.event.*;
import javax.swing.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
import java.awt.Graphics;
import java.util.ArrayList;
public class MapGUI extends GUI implements ActionListener, KeyListener{
    ArrayList<Heroes> heroArr;
    protected Timer t = new Timer(5,this);
    public MapGUI(ArrayList<Heroes>heroArr){
        addKeyListener(this);
        Map(heroArr);
        this.heroArr = heroArr;
        t.start();

    }

    public void paint(Graphics g){
        if(draw){moveGoblin();}
        g.drawImage(img,0,0,null);
        g.drawImage(user,x,355,null);
        g.drawImage(Goblin,Goblinx,360,null);

        if(x>Goblinx-45&&draw&&x<Goblinx+45){
            GoblinVelx = 0;
            velx=0;
            draw = false;
            collision = true;
            new GoblinFightGUI(heroArr);
            setVisible(false);
        }
    }

    public void moveGoblin(){
        if(Goblinx>877){
            GoblinVelx = -1;
            if(GoblinFacingRight){
                try{
                    Goblin = ImageIO.read(getClass().getResource("Goblin.png"));
                    GoblinFacingRight = false;
                }catch(IOException e){e.printStackTrace();}
            }
        }
        if(Goblinx<677){
            GoblinVelx = 1;
            if(GoblinFacingRight == false){
                try{
                    Goblin = ImageIO.read(getClass().getResource("Goblin1.png"));
                    GoblinFacingRight = true;
                }catch(IOException e){e.printStackTrace();}
            }
        }
        Goblinx +=GoblinVelx;
    }

    public void actionPerformed(ActionEvent a){
        if(draw){moveGoblin();}
        if(velx == 1||velx == -1){
            update();
            repaint();
            if(x==878){
                x=8;
                draw = true;
            }
            if (x<8){
                x=8;
            }
        }
        if(GoblinVelx >0||GoblinVelx<0){
            repaint();
        }
    }

    public void update(){
        x+=velx;
    }

    public void keyPressed(KeyEvent a){
        int key = a.getKeyCode();
        if(key == KeyEvent.VK_RIGHT&&collision==false){
            velx = 1;
            try{
                if(facingRight == false&&heroArr.get(0).ChosenWarrior||heroArr.get(1).ChosenWarrior){
                    user = ImageIO.read(getClass().getResource("Warrior2.png"));
                    facingRight=true;
                }else if(facingRight == false){
                    user = ImageIO.read(getClass().getResource("Wizard2.png"));
                    facingRight=true;
                } 
            }catch(IOException e){e.printStackTrace();}
        }
        if(key == KeyEvent.VK_LEFT&&collision == false){
            velx = -1;
            try{
                if(facingRight&&heroArr.get(0).ChosenWarrior||heroArr.get(1).ChosenWarrior){
                    user = ImageIO.read(getClass().getResource("Warrior1.png"));
                    facingRight=false;
                }else if(facingRight){
                    user = ImageIO.read(getClass().getResource("Wizard.png"));
                    facingRight=false;
                }
            }catch(IOException e){e.printStackTrace();}
        }
    }

    public void keyReleased(KeyEvent a){
        int key = a.getKeyCode();
        if(key == KeyEvent.VK_RIGHT){
            velx = 0;
        }
        if(key == KeyEvent.VK_LEFT){
            velx = 0;
        }
    }

    public void keyTyped(KeyEvent a){}
}