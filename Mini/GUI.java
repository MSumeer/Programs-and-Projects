import java.awt.event.*;
import java.awt.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
import javax.swing.*;
import java.util.*;
public abstract class GUI extends JFrame 
{

    protected Button btnStartNewGame = new Button("New Game ");
    protected Button btnLoadGame =  new Button(" Load Game ");
    protected Button btnHowToPlay = new Button(" How To PLay ");
    protected Label lblWizard = new Label(" Class: Wizard ");
    protected Label lblWarrior = new Label(" Class: Warrior");
    protected Button btnWizard = new Button(" Select Wizard ");
    protected Button btnWarrior = new Button(" Select Warrior ");
    protected Button btnBackNewGame = new Button("Back");
    protected Button btnBackLoad = new Button(" Back ");
    protected Label lblInstructions = new Label("Instructions");
    protected JLabel lblWizardDescription = new JLabel("");
    protected Button btnSelectWizard = new Button("Select Wizard");
    protected  Button btnBackWizard = new Button("Back");
    protected JLabel lblWarriorDescription = new JLabel("Hello");
    protected Button btnSelectWarrior = new Button("Select Warrior");
    protected Button btnBackWarrior = new Button("Back");
    protected JLabel lblObjectSelected = new JLabel();
    protected JLabel lblPoints = new JLabel();
    protected Label lblAmPoints = new Label();
    protected Button btnIncrAttack = new Button("Add Point to your AttackPoints");
    protected Button btnIncrHP = new Button("Add point to your HitPoints");
    protected Label lblIncrHP = new Label();
    protected Label lblIncrAttack = new Label();
    protected Button btnNextLevel = new Button("Next Level");
    protected Button btnSave = new Button("Save");

    protected Label lblYouAreHere = new Label("You are here");

    protected int x = 0;

    protected Button btnAttack = new Button("Basic Attack");
    protected Button btnDodge = new Button("Dodge");
    protected Button btnPowerUp = new Button("Special Power");

    protected BufferedImage user;
    protected BufferedImage img;
    protected BufferedImage Goblin;
    protected BufferedImage Boss;
    protected int velx = 0;
    protected int Goblinx = 1000;
    protected int GoblinVelx=0;
    protected int BossVelx = 0;
    protected int Bossx = 1000;
    protected boolean GoblinFacingRight = false;
    protected boolean BossFacingRight = false;
    protected boolean draw = false;
    protected boolean facingRight = true;
    protected boolean collision = false;
    protected JLabel lblGameOver = new JLabel();
    protected Button btnMainMenu = new Button("Main Menu");

    public void fileWrite(ArrayList<Heroes> heroArr, boolean finished){
        try{
            FileWriter f = new FileWriter("Game.txt");
            BufferedWriter b = new BufferedWriter(f);
            if(heroArr.get(0).ChosenWarrior||heroArr.get(1).ChosenWarrior){
                b.write("Warrior " + heroArr.get(0).attackPoints + " " + heroArr.get(0).hitPoints + " " + heroArr.get(0).Name + " " + heroArr.get(0).level);
            }
            else{
                b.write("Wizard " + heroArr.get(1).attackPoints + " " + heroArr.get(1).hitPoints + " " + heroArr.get(1).Name + " " + heroArr.get(1).level);
            }
            if(finished){b.write("");}
            b.close();
        }catch(IOException e){}

    }
    
    public void LoadGame(){
        try{
            FileReader f = new FileReader("Game.txt");
            BufferedReader b = new BufferedReader(f);
            String line = b.readLine();
            String[] a = new String[5];
            a = line.split(" ");
            ArrayList<Heroes> heroArr = new ArrayList<Heroes>();
            heroArr.add(new Warrior());
            heroArr.add(new Wizard());
            if(a[0].equals("Warrior ")){
                heroArr.get(0).attackPoints = Integer.parseInt(a[1]);
                heroArr.get(0).hitPoints = Integer.parseInt(a[2]);
                heroArr.get(0).Name = a[3];
                heroArr.get(0).level = Integer.parseInt(a[4]);
            }
            else if(a[0].equals("Wizard ")){
                heroArr.get(1).attackPoints = Integer.parseInt(a[1]);
                heroArr.get(1).hitPoints = Integer.parseInt(a[2]);
                heroArr.get(1).Name = a[3];
                heroArr.get(1).level = Integer.parseInt(a[4]);
            }
            if(a[4].equals("0")){new CharacterUpgradeGUI(heroArr);}
            else if (a[4].equals("1")){new CharacterUpgradeBossGUI(heroArr);}
            else{System.out.println("No Save File");}
            b.close();
        }catch(IOException e){System.out.println("No Save File");}
        setVisible(false);
    }
    public void startNewGame(){
        setSize(500,500);
        setLayout(null);
        getContentPane().removeAll();

        lblWizard.setBounds(100,80,100,20);
        lblWarrior.setBounds(320,80,100,20);

        btnWizard.setBounds(100,280,100,20);
        btnWarrior.setBounds(320,280,120,20);
        btnBackNewGame.setBounds(200,400,100,20);

        add(lblWizard);
        add(lblWarrior);
        add(btnBackNewGame);
        add(btnWizard);
        add(btnWarrior);

    }

    public void wizard(){
        setSize(500,500);
        setVisible(true);
        setLayout(null);

        lblWizardDescription.setBounds(10,0,250,250);
        btnSelectWizard.setBounds(200,400,100,20);
        btnBackWizard.setBounds(200,350,100,20);
        Wizard wiz = new Wizard();

        lblWizardDescription.setText("<html>Wizard: <br/><br/> HitPoints: " + wiz.hitPoints + 
            "<br/><br/> AttackPoints: " + wiz.attackPoints + "<br/><br/> PowerUp:<br/><br/> Attackpoints are doubled.</html>");
        try{
            BufferedImage img = ImageIO.read(this.getClass().getResource("WizardBack.png"));
            JLabel lbl = new JLabel(new ImageIcon(img));
            lbl.setBounds(200,10,300, 300);
            add(lbl);
        }catch(IOException ex){}
        add(lblWizardDescription);
        add(btnSelectWizard);
        add(btnBackWizard);
    }

    public void warrior(){
        setSize(500,500);
        setVisible(true);
        setLayout(null);

        lblWarriorDescription.setBounds(10,0,250,250);
        btnSelectWarrior.setBounds(200,400,100,20);
        btnBackWarrior.setBounds(200,350,100,20);

        Warrior war = new Warrior();

        lblWarriorDescription.setText("<html>Warrior: <br/><br/> HitPoints: " + war.hitPoints + 
            "<br/><br/> AttackPoints: " + war.attackPoints + "<br/><br/> PowerUp: <br/><br/> invincible for 2 turns.</html>");

        try{
            BufferedImage img = ImageIO.read(this.getClass().getResource("Warrior.jpg"));
            JLabel lbl = new JLabel(new ImageIcon(img));
            lbl.setBounds(200,10,300, 300);
            add(lbl);
        }catch(IOException ex){}

        add(lblWarriorDescription);
        add(btnSelectWarrior);
        add(btnBackWarrior);

    }

    public void startRealGame(){

        setVisible(true);
        setLayout(null);
        getContentPane().removeAll();
        setSize(500,500);
        lblPoints.setText("<html><h1>You have 1 Upgrade Point</h1></html>");
        lblPoints.setBounds(50,50,350,50);
        lblAmPoints.setText("1/1");
        lblAmPoints.setBounds(350,10,100,40);
        lblIncrHP.setBounds(300,350,100,20);
        lblIncrAttack.setBounds(75,350,170,20);
        btnIncrAttack.setBounds(25,300,200,20);
        btnIncrHP.setBounds(250,300,200,20);
        btnSave.setBounds(150,400,100,20);
        add(btnSave);
        add(lblIncrAttack);
        add(lblIncrHP);
        add(btnIncrAttack);
        add(btnIncrHP);
        add(lblPoints);
        add(lblAmPoints);

    }

    public void btnIncreaseAttack(ArrayList<Heroes> heroArr){
        setLayout(null);
        if(heroArr.get(0).ChosenWarrior||heroArr.get(1).ChosenWarrior){
            lblIncrAttack.setText("+2 Attack");
        }
        else{
            lblIncrAttack.setText("+5 Attack");
        }
        remove(btnIncrHP);
        remove(btnIncrAttack);
        lblPoints.setText("<html><h1>You have 0 Upgrade Point</h1></html>");
        lblAmPoints.setText("0/1");
        btnNextLevel.setBounds(350,400,100,20);
        btnSave.setBounds(10,400,100,20);
        add(btnSave);
        add(btnNextLevel);

    }

    public void btnIncreaseHP(ArrayList<Heroes> heroArr){
        setLayout(null);
        if(heroArr.get(0).ChosenWarrior||heroArr.get(1).ChosenWarrior){
            lblIncrHP.setText("+5 HitPoints");
        }
        else{
            lblIncrHP.setText("+2 HitPoints");
        }
        remove(btnIncrHP);
        remove(btnIncrAttack);
        lblPoints.setText("<html><h1>You have 0 Upgrade Point</h1></html>");
        lblAmPoints.setText("0/1");
        btnNextLevel.setBounds(350,400,100,20);
        btnSave.setBounds(10,400,100,20);
        add(btnSave);
        add(btnNextLevel);
    }

    public void Map(ArrayList<Heroes> heroArr){

        setVisible(true);
        setLayout(null);
        setSize(950,475); 

        try{
            if(heroArr.get(0).ChosenWarrior||heroArr.get(1).ChosenWarrior){
                user = ImageIO.read(getClass().getResource("Warrior2.png"));
            }else{user = ImageIO.read(getClass().getResource("Wizard2.png"));}
            img = ImageIO.read(getClass().getResource("Background.jpg"));
            Goblin = ImageIO.read(getClass().getResource("Goblin.png"));
        }catch(IOException e){e.printStackTrace();}
    }

    public void GoblinFight(ArrayList<Heroes> heroArr){
        setVisible(true);
        setSize(700,700);
        setLayout(null);
        try{
            if(heroArr.get(0).ChosenWarrior||heroArr.get(1).ChosenWarrior){
                user = ImageIO.read(getClass().getResource("Warrior1.jpg"));
            }else{user = ImageIO.read(getClass().getResource("Wizard1.png"));}
            Goblin = ImageIO.read(getClass().getResource("GoblinBig.png"));
        }catch(IOException e){e.printStackTrace();}
        btnAttack.setBounds(100,580,100,20);
        btnDodge.setBounds(250,580,100,20);
        btnPowerUp.setBounds(400,580,100,20);

        add(btnAttack);
        add(btnDodge);
        add(btnPowerUp);

    }

    public void MapBoss(ArrayList<Heroes> heroArr){
        setVisible(true);
        setLayout(null);
        setSize(950,475); 

        try{
            if(heroArr.get(0).ChosenWarrior||heroArr.get(1).ChosenWarrior){
                user = ImageIO.read(getClass().getResource("Warrior2.png"));
            }else{user = ImageIO.read(getClass().getResource("Wizard2.png"));}
            img = ImageIO.read(getClass().getResource("Background.jpg"));
            Boss = ImageIO.read(getClass().getResource("Boss.png"));
        }catch(IOException e){e.printStackTrace();}  

    }

    public void BossFight(ArrayList<Heroes> heroArr){
        setVisible(true);
        setSize(700,700);
        setLayout(null);
        try{
            if(heroArr.get(0).ChosenWarrior||heroArr.get(1).ChosenWarrior){
                user = ImageIO.read(getClass().getResource("Warrior1.jpg"));
            }else{user = ImageIO.read(getClass().getResource("Wizard1.png"));}
            Boss = ImageIO.read(getClass().getResource("Boss.png"));
        }catch(IOException e){e.printStackTrace();}
        btnAttack.setBounds(100,580,100,20);
        btnDodge.setBounds(250,580,100,20);
        btnPowerUp.setBounds(400,580,100,20);

        add(btnAttack);
        add(btnDodge);
        add(btnPowerUp);

    }
}