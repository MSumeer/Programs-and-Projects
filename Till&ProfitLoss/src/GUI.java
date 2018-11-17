import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI extends JFrame implements ActionListener {
    private JFrame frameCat = new JFrame();
    JFrame framePro = new JFrame();
    private JPanel till = new JPanel();
    private JPanel ProfitLoss = new JPanel();
    private JPanel west = new JPanel();
    private JPanel centre = new JPanel();
    private JPanel east = new JPanel();
    private JPanel westb = new JPanel();
    private JPanel westU = new JPanel();
    private JPanel eastb = new JPanel();
    private JPanel westUp = new JPanel();
    private JButton btnBurgerMeals = new JButton("Burger Meals");
    private JButton btnWraps = new JButton("Wraps");
    private JButton btnaddNewProduct = new JButton("add new Product");
    private JButton btnaddNewCategory = new JButton("add New Category");
    private JButton submitProduct = new JButton("Submit");
    private JButton submit = new JButton("Submit");
    private JButton[] categories = new JButton[10];
    private JButton[] products = new JButton[30];
    private TextField txtNameCat = new TextField();
    private TextField txtNamePro = new TextField();
    private TextField txtCost = new TextField();
    private TextField txtOrderNo = new TextField();
    private int y = 0;
    private int counter = 0;
    private int counterProduct = 0;
    private int times = 0;
    private  GridBagConstraints gc = new GridBagConstraints();
    public void Frame(){
        till.setLayout(new GridBagLayout());
        till.setVisible(true);
        JTabbedPane tab = new JTabbedPane();
        tab.add("Till",till);
        tab.add("Profit Loss",ProfitLoss);
        add(tab);
        setExtendedState(MAXIMIZED_BOTH);
        setVisible(true);
        till.setVisible(true);
        btnaddNewCategory.addActionListener(this);
        btnaddNewProduct.addActionListener(this);
        submit.addActionListener(this);
        submitProduct.addActionListener(this);
    }
    public void West(){
        gc.weightx = 1;
        gc.weighty = 0.0;
        gc.anchor = GridBagConstraints.FIRST_LINE_START;
        west.setLayout(new BorderLayout());
        west.setVisible(true);
        west.setBackground(Color.BLUE);
        gc.gridx = 0;
        gc.gridy = 0;
        west.add(btnaddNewProduct,BorderLayout.SOUTH);
        west.add(westU,BorderLayout.CENTER);
        westU.setLayout(new FlowLayout());
        till.add(west,gc);
        gc.gridy = 1;
        BorderLayout border = new BorderLayout();
        westb.setLayout(border);
        westb.add(westUp,BorderLayout.CENTER);
        westUp.setLayout(new FlowLayout(0,0,0));
        westUp.add(btnBurgerMeals);
        westUp.add(btnWraps);
        westb.add(btnaddNewCategory,BorderLayout.SOUTH);
        till.add(westb,gc);
        westU.setBorder(new LineBorder(Color.blue,5));
        west.setBorder(new LineBorder(Color.red,5));
        till.setBorder(new LineBorder(Color.black,5));
        west.setPreferredSize(new Dimension(500,500));
        westU.setPreferredSize(new Dimension(till.getWidth()/2,till.getHeight()/2));
        westU.setMaximumSize(new Dimension(till.getWidth()/2,till.getHeight()/2));
    }
    public void Centre(){
        gc.anchor = GridBagConstraints.NORTHWEST;
        centre.setLayout((new GridBagLayout()));
        centre.setVisible(true);
        centre.setBackground(Color.CYAN);
        gc.gridy = 0;
        gc.gridx = 1;
        centre.add(new JLabel("hi"));
        till.add(centre, gc);
    }
    public void east(){
        gc.anchor = GridBagConstraints.NORTHWEST;
        east.setLayout(new GridBagLayout());
        east.setVisible(true);
        east.setBackground(Color.green);
        gc.gridy = 0;
        gc.gridx = 2;
        east.add(new JLabel("hi"));
        till.add(east,gc);
        gc.gridy = 1;
        eastb.add(new JLabel("hi"));
        till.add(eastb,gc);
    }
    public void addNewCategoryForm(){
        JLabel Name = new JLabel("Category Name: ");
        Name.setBounds(10,10,100,20);
        txtNameCat.setBounds(120,10,100,20);
        submit.setBounds(50,60,100,20);
        frameCat.add(Name);
        frameCat.add(txtNameCat);
        frameCat.add(submit);
        frameCat.setLayout(null);
        frameCat.setSize(250,170);
        frameCat.setVisible(true);

    }
    public void addProductForm(){
        JLabel Name = new JLabel("Product Name: ");
        JLabel cost = new JLabel("Product Cost: ");
        JLabel OrderNo = new JLabel("Order Number");
        Name.setBounds(10,10,100,20);
        txtNamePro.setBounds(120,10,100,20);
        cost.setBounds(10,30,100,20);
        txtCost.setBounds(120,30,100,20);
        OrderNo.setBounds(10,50,100,20);
        txtOrderNo.setBounds(120,50,100,20);
        submitProduct.setBounds(50,70,100,20);
        framePro.add(Name);
        framePro.add(txtNamePro);
        framePro.add(cost);
        framePro.add(txtCost);
        framePro.add(submitProduct);
        framePro.setLayout(null);
        framePro.setSize(250,170);
        framePro.setVisible(true);
    }
    public void addCategory(){
        try {
            categories[counter] = new JButton(txtNameCat.getText());
            westUp.add(categories[counter]);
            counter++;
        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println("Too Many Categories");
        }
        frameCat.setVisible(false);
    }
    public void addProduct(){
        try{
            products[counterProduct] = new JButton(txtNamePro.getText());
            westU.add(products[counterProduct]);
            counterProduct++;
        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println("Too Many Products");
        }
        framePro.setVisible(false);
    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==btnaddNewCategory){
            addNewCategoryForm();
        }
        else if(e.getSource()==btnaddNewProduct){
            addProductForm();
        }
        else if(e.getSource()==submit){
           addCategory();
        }
        else if(e.getSource()==submitProduct){
            addProduct();
        }
    }
}
