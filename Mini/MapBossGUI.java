import java.awt.event.*;
import javax.swing.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
import java.awt.Graphics;
import java.util.ArrayList;
public class MapBossGUI extends GUI implements ActionListener, KeyListener{
    ArrayList<Heroes> heroArr;
    protected Timer t = new Timer(5,this);
    public MapBossGUI(ArrayList<Heroes> heroArr){
        addKeyListener(this);
        MapBoss(heroArr);
        this.heroArr = heroArr;
        t.start();

    }

    public void paint(Graphics g){
        if(draw){moveBoss();}
        g.drawImage(img,0,0,null);
        g.drawImage(user,x,355,null);
        g.drawImage(Boss,Bossx,330,null);

        if(x>Bossx-45&&draw&&x<Bossx+45){
            BossVelx = 0;
            velx=0;
            draw = false;
            collision = true;
            new BossFightGUI(heroArr);
            setVisible(false);
        }
    }

    public void moveBoss(){
        if(Bossx>763){
            BossVelx = -1;
            if(BossFacingRight){
                try{
                    Boss = ImageIO.read(getClass().getResource("Boss.png"));
                    BossFacingRight = false;
                }catch(IOException e){e.printStackTrace();}
            }
        }
        if(Bossx<563){
            BossVelx = 1;
            if(BossFacingRight == false){
                try{
                    Boss = ImageIO.read(getClass().getResource("Boss1.png"));
                    BossFacingRight = true;
                }catch(IOException e){e.printStackTrace();}
            }
        }
        Bossx +=BossVelx;
    }

    public void actionPerformed(ActionEvent a){
        if(draw){moveBoss();}
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
        if(BossVelx >0||BossVelx<0){
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