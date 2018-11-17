public class Person {
    private int x = 0;
    private int y = 0;
    private String fullName;
    private String DOB;
    private boolean married;
    public Person(int x, int y, String FullName,String DOB, boolean Married){
        this.x = x;
        this.y = y;
        this.fullName = FullName;
        this.DOB = DOB;
        this.married = Married;
    }
    public void setX(int x){
        this.x = x;
    }
    public int getX(){return x;}
    public int getY(){return y;}
    public void setY(int y){
        this.y = y;
    }
    public void setFullName(String a){
        fullName = a;
    }
    public void setMarried(boolean m){
        married = m;
    }
    public String getFullName(){return fullName;}
    public boolean getMarried(){return married;}
}
