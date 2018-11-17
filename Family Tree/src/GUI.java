import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class GUI extends JFrame implements ActionListener,MouseListener,MouseMotionListener {
    private JPanel body = new JPanel();
    private int x = 0;
    private int y = 0;
    private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    private JButton btnaddNewPerson = new JButton("Add New Person");
    private JButton btnmarried = new JButton("----->");
    private JButton btnChildOf = new JButton("->");
    private JButton btnaddNewCountry = new JButton("add new Country");
    private JButton btnstart = new JButton("Start");
    private boolean newPerson = false;
    private boolean MarriageRealation = false;
    private boolean childOfRelation = false;
    private ArrayList<Person> people = new ArrayList<>();
    private JPanel Centre = new JPanel(){
        private boolean start = true;
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Point p = MouseInfo.getPointerInfo().getLocation();
            g.drawRect((int) Math.round(p.getX())-365,(int) Math.round(p.getY())-185, 100, 100);
            for (int i = 0; i < people.size(); i++) {
                    g.drawRect(people.get(i).getX(), people.get(i).getY(), 100, 100);
            }
        }
    };
    public void setFirstFrame(){
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int)Math.round(screenSize.getWidth());
        int y = (int)Math.round(screenSize.getHeight());
        int centerX = (x-(x/5))/2;
        int centerY = (y-(y/5))/2;
        setLayout(null);
        setBounds(centerX,centerY,x/5,y/5);
        btnstart.setBounds(((x/5)-100)/2,((y/5)-50)/2,100,20);
        add(btnstart);
        btnstart.addActionListener(this);
        setVisible(true);
    }
    public void setSecFrame(String country,String Title){
        JFrame frame = new JFrame("FamilyTree");
        frame.setExtendedState(frame.MAXIMIZED_BOTH);
        JPanel main = new JPanel();
        main.setLayout(new BorderLayout());
        JPanel footer = new JPanel();
        Border blackLine = BorderFactory.createLineBorder(Color.black);
        Border blackLin = BorderFactory.createLineBorder(Color.blue);
        body.setBorder(blackLin);
        footer.setBorder(blackLine);
        JTabbedPane tabs = new JTabbedPane();
        tabs.add(country,main);
        x = (int)Math.round(screenSize.getWidth());
        y = (int)Math.round(screenSize.getHeight());
        x = (int)Math.round(x*0.8);
        y = (int)Math.round(y*0.8);
        body.setPreferredSize(new Dimension(x,y));
        x = (int)Math.round(screenSize.getWidth());
        y = (int)Math.round(screenSize.getHeight());
        footer.setPreferredSize(new Dimension(x/10,y/10));
        frame.add(tabs);
        main.add(body,BorderLayout.CENTER);
        main.add(footer,BorderLayout.SOUTH);
        setBody(Title);
        footer.setVisible(true);
        body.setVisible(true);
        main.setVisible(true);
        frame.setVisible(true);
    }
    public void setBody(String Title){
        JLabel title = new JLabel(Title,SwingConstants.CENTER);
        title.setFont(new Font("Serif",Font.PLAIN,40));
        title.setBounds((x/2), y/2,100,20);
        Border blackLin = BorderFactory.createLineBorder(Color.GREEN);
        body.setLayout(new BorderLayout());
        JPanel North = new JPanel();
        JPanel West = new JPanel();
        North.setLayout(new BorderLayout());
        North.setPreferredSize(new Dimension(x,y/10));
        West.setPreferredSize(new Dimension(x/5,y/5));
        West.setLayout(new GridBagLayout());
        GridBagConstraints a = new GridBagConstraints();
        a.gridx = 0;
        a.gridy=0;
        a.insets = new Insets(50,100,50,100);
        West.add(btnaddNewPerson,a);
        a.gridy = 1;
        West.add(btnmarried,a);
        a.gridy =2;
        West.add(btnChildOf,a);
        a.gridy=3;
        West.add(btnaddNewCountry,a);
        Centre.setLayout(null);
        North.add(title,BorderLayout.CENTER);
        North.setBorder(blackLin);
        West.setBorder(blackLin);
        body.add(North,BorderLayout.NORTH);
        body.add(West,BorderLayout.WEST);
        body.add(Centre,BorderLayout.CENTER);
        Centre.addMouseListener(this);
        Centre.addMouseMotionListener(this);
        Centre.setBorder(blackLin);
        North.setVisible(true);
        West.setVisible(true);
        Centre.setVisible(true);
    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==btnstart){
            String countryName = JOptionPane.showInputDialog("Enter Country");
            String Title = JOptionPane.showInputDialog("Enter Title");
            setVisible(false);

            new seccondFrame(countryName,Title);
        }
        else if(e.getSource()==btnaddNewPerson){
            newPerson = true;
            MarriageRealation = false;
            childOfRelation = false;
        }else if(e.getSource()==btnChildOf){
            newPerson = false;
            MarriageRealation = false;
            childOfRelation = true;
        }else if(e.getSource()==btnmarried){
            newPerson = false;
            MarriageRealation = true;
            childOfRelation = false;
        }else if(e.getSource()==btnaddNewCountry){

        }
    }


    @Override
    public void mouseClicked(MouseEvent e) {
        String fullName = JOptionPane.showInputDialog("type your full name");
        String DOB = JOptionPane.showInputDialog("input Your DOB in the format DD/MM/YYYY");
        Point p = MouseInfo.getPointerInfo().getLocation();
        people.add(new Person((int) Math.round(p.getX())-365,(int) Math.round(p.getY())-185,fullName,DOB,false));
        JLabel name = new JLabel();
        Centre.repaint();
    }

    @Override
    public void mousePressed(MouseEvent e){
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        Centre.repaint();
    }
}
