import java.awt.Dimension;
import java.awt.*; 
import java.awt.event.*; 
import java.awt.Font;
import java.awt.Color;
import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.*;
import java.io.FileWriter;
import java.nio.file.*;
import java.io.*;
class MovieIcon

{
JPanel panel = new JPanel();
 JPanel p = new JPanel();
MovieIcon(String img,String m,String r,String l,int t)
{
  
  
  ImageIcon i1 = new ImageIcon(img);
 Image img1 = i1.getImage();
            Image newImg1 = img1.getScaledInstance(150, 150, Image.SCALE_SMOOTH);
            ImageIcon newImc1 = new ImageIcon(newImg1);
      JLabel lable1 = new JLabel(newImc1);
//lable1.setSize(new Dimension(800,100));
this.panel.add(lable1);
JLabel moviename=new JLabel(m);
moviename.setFont(new Font("Verdana", Font.BOLD, t));
moviename.setSize(new Dimension(100,100));
this.p.add(moviename);
JLabel rating=new JLabel(r);
rating.setFont(new Font("Verdana", Font.PLAIN, 16));
this.p.add(rating);
String text = "Movie Link";
JLabel hyperLink = new JLabel(text);
hyperLink.setFont(new Font("Verdana", Font.PLAIN, 16));
new Link(hyperLink,l,text);
 this.p.add(hyperLink);
moviename.setForeground(new Color(255,155,0));
rating.setForeground(new Color(255,155,0));
this.p.setBackground(new Color(60,60,60));
this.p.setLayout( new GridLayout(3, 1,0,18));
this.panel.add(p);
this.panel.setBackground(new Color(60,60,60));
this.panel.setLayout(new FlowLayout(FlowLayout.RIGHT,100,0));;
}
}
class MovieIconHome
{
JPanel panel = new JPanel();
 JPanel p = new JPanel();
MovieIconHome(String img,String m,String r,String l)
{
ImageIcon i1 = new ImageIcon(img);
 Image img1 = i1.getImage();
            Image newImg1 = img1.getScaledInstance(200, 180, Image.SCALE_SMOOTH);
            ImageIcon newImc1 = new ImageIcon(newImg1);
      JLabel lable1 = new JLabel(newImc1);
lable1.setSize(new Dimension(800,100));
this.panel.add(lable1);
JLabel moviename=new JLabel(m);
moviename.setFont(new Font("Verdana", Font.BOLD, 16));

this.p.add(moviename);

JLabel rating=new JLabel(r);
rating.setFont(new Font("Verdana", Font.PLAIN, 16));
this.p.add(rating);
String text = "Movie Link";
JLabel hyperLink = new JLabel(text);
hyperLink.setFont(new Font("Verdana", Font.PLAIN, 16));
new Link(hyperLink,l,text);
 this.p.add(hyperLink);
moviename.setForeground(new Color(255,155,0));
rating.setForeground(new Color(255,155,0));
this.p.setBackground(new Color(60,60,60));
this.p.setLayout( new GridLayout(3, 1,0,25));
this.panel.add(p);
this.panel.setBackground(new Color(60,60,60));
this.panel.setLayout(new FlowLayout(FlowLayout.LEFT,10,0));
}
}
class Link
{
Link(JLabel hyperlink,String s,String text)
{
hyperlink.setForeground(new Color(255,155,0));
 hyperlink.setCursor(new Cursor(Cursor.HAND_CURSOR));
 hyperlink.addMouseListener(new MouseAdapter() {
 
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    Desktop.getDesktop().browse(new URI(s));
                } catch (IOException | URISyntaxException e1) {
                    e1.printStackTrace();
                }
            }
 
            @Override
            public void mouseExited(MouseEvent e) {
                hyperlink.setText(text);
            }
 
            @Override
            public void mouseEntered(MouseEvent e) {
                hyperlink.setText("<html><a href=''>" + text + "</a></html>");
            }
});
}
}
class Login extends JFrame
{
Login(){
Image icon = Toolkit.getDefaultToolkit().getImage("img/p1.png");    
    setIconImage(icon);
addWindowListener(new WindowAdapter(){  
   public void windowClosing(WindowEvent e) {  
         dispose();   }  
  });
JLabel id=new JLabel("User Id:");
id.setBounds(127,165, 100,30);
JTextField t=new JTextField();
t.setBounds(235,170, 170,25);
t.setBackground(new Color(240,240,240));
add(t);
JLabel password=new JLabel("Password:");
password.setBounds(117,220,100,30);
password.setFont(new Font("Verdana", Font.BOLD, 16));
add(password);
JLabel newpassword=new JLabel("Confirm Password:");
newpassword.setBounds(0,0, 0,0);
newpassword.setFont(new Font("Verdana", Font.BOLD, 13));
add(newpassword);
JLabel v=new JLabel();
v.setBounds(100,130, 300,30);
v.setFont(new Font("Verdana", Font.ITALIC, 14));
v.setForeground(Color.RED);
add(v);
JPasswordField p = new JPasswordField(); 
p.setBounds(235,224, 170,25);
p.setBackground(new Color(240,240,240));
add(p);  
JPasswordField np = new JPasswordField(); 
np.setBounds(0,0, 0,0);
np.setBackground(new Color(240,240,240));
add(np);  
id.setFont(new Font("Verdana", Font.BOLD, 16));
JButton a=new JButton("Login");  
a.setBounds(217,290,100,30);
a.setBackground(new Color(240,240,240));
add(a);
JButton sign=new JButton("Sign Up");  
sign.setBounds(217,355,100,30);
sign.setBackground(new Color(240,240,240));
add(sign);
JButton c=new JButton("Create User");  
c.setBounds(0,0,0,0);
c.setBackground(new Color(240,240,240));
add(c);
add(id);
Map<String,String> m=new HashMap<>();

File file =new File("user-password.txt");
try{
    Scanner sc = new Scanner(file);
while(sc.hasNext())
{
String s=sc.next();
String k=sc.next();
m.put(s,k);
//System.out.println(s+" "+k);
}

}
catch( FileNotFoundException e){
System.out.println(e);
}

a.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent ae) {

Set<String> s= m.keySet();
String k1=t.getText().trim();
if(s.contains(k1))
{
     if(String.valueOf(p.getPassword()).equals(m.get(k1)))
  {
dispose();
F1 f=new F1(1);
Thread thread = new Thread(f);
thread.start(); 
  }
else
  {
v.setText("Invalid Password");  
  }
}
else if(t.getText().equals(""))
{
v.setText("User Id Required");
}
else if(String.valueOf(p.getPassword()).equals(""))
{
v.setText("Password Required");
}
else
{
v.setText("Invalid User");
}
}
});
sign.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent ae) {
v.setText("");
t.setText("");
p.setText("");
np.setText("");
a.setBounds(0,0,0,0);
sign.setBounds(0,0,0,0);
np.setBounds(235,280, 170,25);
newpassword.setBounds(82,275, 250,30);
c.setBounds(217,355,120,20);
}
});
c.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent ae) {
Set<String> s= m.keySet();
if(s.contains(t.getText().trim()))
{
v.setText("User Id Exists");
}
else if(t.getText().equals(""))
{
v.setText("User Id Required");
}
else if(String.valueOf(p.getPassword()).equals(""))
{
v.setText("Password Required");
}
else if(!String.valueOf(p.getPassword()).equals(String.valueOf(np.getPassword())))
{
v.setText("Password did not match");
}
else
{
m.put(t.getText(),String.valueOf(p.getPassword())); 
	try{
File file1 = new File("user-password.txt"); 
           FileWriter fileWritter = new FileWriter(file1,true);
         BufferedWriter bw = new BufferedWriter(fileWritter);
         bw.write(t.getText()+" "+String.valueOf(p.getPassword())+"\n");
         bw.close();
}
catch( IOException e){
System.out.println(e);
}

            
v.setText("");
t.setText("");
p.setText("");
np.setText("");
a.setBounds(217,290,100,30);
c.setBounds(0,0,0,0);
newpassword.setBounds(0,0, 0,0);
np.setBounds(0,0, 0,0);
sign.setBounds(217,355,100,30);
}

}
});
ImageIcon i = new ImageIcon("img/sc.png");
Image img = i.getImage();
  Image newImg = img.getScaledInstance(1000, 1000, Image.SCALE_SMOOTH);
           ImageIcon newImc = new ImageIcon(newImg);
      JLabel lable = new JLabel(i);
lable.setBounds(0,0,520,500);
//getContentPane().setBackground(new Color(60,60,60));
add(lable);
setTitle("Login Page");
setLayout(null); 
setSize(535,520);
setVisible(true);

}

}

class F1 extends JFrame implements Runnable
{
ImageIcon i = new ImageIcon("img/p1.jpeg");
      JLabel lable = new JLabel(i);
public void run() {
Image icon = Toolkit.getDefaultToolkit().getImage("img/p1.png");    
    setIconImage(icon);
  addWindowListener(new WindowAdapter(){  
   public void windowClosing(WindowEvent e) {  
         dispose();   }  
  });

ImageIcon ii = new ImageIcon("img/p1.jpeg");
 Image img = ii.getImage();
            Image newImg = img.getScaledInstance(200, 350, Image.SCALE_SMOOTH);
            ImageIcon newImc = new ImageIcon(newImg);
      JLabel lable = new JLabel(newImc);     
    add(lable);
ImageIcon i1 = new ImageIcon("img/p1.jpeg");
 Image img1 = i1.getImage();
            Image newImg1 = img.getScaledInstance(140, 200, Image.SCALE_SMOOTH);
            ImageIcon newImc1 = new ImageIcon(newImg1);
      JLabel lable1 = new JLabel(newImc1);
     lable1.setSize(new Dimension(120,550));
String text = "Movie Link";
String g="https://app.primevideo.com/detail?gti=amzn1.dv.gti.eeb6e58d-1c3d-848f-0fd8-ca1ae14d7bf5&ref_=atv_dp_share_mv&r=web";
JPanel t=new JPanel();
MovieIconHome m1=new MovieIconHome("img/joker.jpg","JOKER","4.2/5","https://www.netflix.com/title/81092221");
MovieIconHome m2=new MovieIconHome("img/interstellar.jpg","INTERSTELLAR","4.3/5","https://www.netflix.com/title/70305903");
MovieIconHome m3=new MovieIconHome("img/kgf.jpg","K.G.F ","4.1/5","");
MovieIconHome m4=new MovieIconHome("img/d1.jpeg","JERSEY","4.3/5","https://www.zee5.com/movies/details/jersey/0-0-59341");
MovieIconHome m5=new MovieIconHome("img/ba5.jpeg","WAR","3.25/5","https://www.primevideo.com/detail/0IE81NLJ76SMXNZFNXSO19XWRK/ref=atv_br_def_r_br_c_unkc_1_60");
MovieIconHome m6=new MovieIconHome("img/bd9.jpeg","SANJU","3.35/5","https://www.netflix.com/title/81020508");
t.add(m1.panel);
t.add(m3.panel);
t.add(m5.panel);
t.add(m2.panel);
t.add(m4.panel);
t.add(m6.panel);
GridLayout g1=new GridLayout(2,3);
t.setLayout(g1);
g1.setVgap(0);

JLabel r=new JLabel("Recommended Movies");
r.setBounds(10,200,500,50);
r.setForeground(Color.lightGray);
r.setFont(new Font("Verdana", Font.BOLD, 26));
add(r);
 JButton logOut =new JButton("Log Out");
JButton b1=new JButton("Action ");
JButton b2=new JButton("Drama");
JButton b3=new JButton("Comedy");
JButton b4=new JButton("Thriller");
JButton b5=new JButton("Romance");
JButton b6=new JButton("Sci-Fi");
b1.setBackground(new Color(60,60,60));
b2.setBackground(new Color(60,60,60));
b3.setBackground(new Color(60,60,60));
b4.setBackground(new Color(60,60,60));
b5.setBackground(new Color(60,60,60));
b6.setBackground(new Color(60,60,60));
b1.setForeground(new Color(255,155,0));
b2.setForeground(new Color(255,155,0));
b3.setForeground(new Color(255,155,0));
b4.setForeground(new Color(255,155,0));
b5.setForeground(new Color(255,155,0));
b6.setForeground(new Color(255,155,0));
logOut.setFont(new Font("Verdana", Font.BOLD, 15));
b1.setFont(new Font("Verdana", Font.ITALIC, 15));
b2.setFont(new Font("Verdana", Font.ITALIC, 15));
b3.setFont(new Font("Verdana", Font.ITALIC, 15));
b4.setFont(new Font("Verdana", Font.ITALIC, 15));
b5.setFont(new Font("Verdana", Font.ITALIC, 15));
b6.setFont(new Font("Verdana", Font.ITALIC, 15));
 JPanel panel = new JPanel();
      panel.setBackground(Color.lightGray);
      
      FlowLayout layout = new FlowLayout(FlowLayout.CENTER);
      layout.setHgap(70);              
            
      panel.setLayout(layout);	        
      panel.add(b1);
      panel.add(b2);
  panel.add(b3);
  panel.add(b4);
  panel.add(b5);
 panel.add(b6);
panel.setBounds(0,160,0,30);
add(panel);
add(logOut);
logOut.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent ae) {
dispose();
new Login();
}
});
b1.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent ae) {
dispose();
new Action();
}
});
b2.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent ae) {
dispose();
new Drama();
}
});
b3.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent ae) {
dispose();
new Comedy();
}
});
b4.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent ae) {
dispose();
new Thriller();
}
});
b5.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent ae) {
dispose();
new Romance();
}
});
b6.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent ae) {
dispose();
new SciFi();
}
});
getContentPane().setBackground(new Color(60,60,60));

Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    lable.setBounds((screenSize.width/2)-100,0,200,160);
panel.setSize(screenSize.width,40);
logOut.setBounds(screenSize.width-150,10,100,50);
t.setBounds(0,260,screenSize.width,450);
add(t);
this.lable.setBounds(0,0,0, 0);
    setSize(screenSize.width, screenSize.height);
setTitle("Home");
setLayout(null);
setVisible(true);

  }
F1(int c)
{
if(c==1)
{ 

Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
setSize(screenSize.width, screenSize.height);
this.lable.setBounds(0,0,screenSize.width, screenSize.height);
add(lable);
setTitle("F1");
setLayout(null);
setVisible(true);
}
}
}
class Home
{
public static void main(String []args)throws InterruptedException
{
Login l=new Login();

}
}
class Action {
 
 Action() {
 JFrame f = new JFrame("Action");
 JButton a=new JButton("Previous");
Image icon = Toolkit.getDefaultToolkit().getImage("img/p1.png");    
    f.setIconImage(icon); 
 a.setBackground(new Color(204,204,204));
f.add(a);
a.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent ae) {
f.dispose();
Thread thread = new Thread(new F1(0));
    thread.start();

}
});
JPanel t=new JPanel();
 JPanel e=new JPanel(); 
JPanel h=new JPanel();

MovieIcon m1=new MovieIcon("img/a1.jpeg","KRACK                ","3.65/5","https://www.aha.video/movies/krack",16);
t.add(m1.panel);
MovieIcon m2=new MovieIcon("img/a2.jpeg","FALAKNUMA DAS  ","3.25/5","https://www.primevideo.com/detail/0O2TCWD6RG8N3QH8WMWRJ5HC47/ref=atv_sr_fle_c_Tn74RA__1_1_1?sr=1-1&pageTypeIdSource=ASIN&pageTypeId=B07TCGHBWD&qid=1621227130",16);
t.add(m2.panel);
MovieIcon m3=new MovieIcon("img/a3.jpeg","LUCIFER             ","3.75/5","https://www.primevideo.com/detail/Lucifer-Telugu/0NQ0VFZCDBDQ7A03X7JOET8KZ9",16);
t.add(m3.panel);
MovieIcon m4=new MovieIcon("img/a4.jpeg","JANATHA GARAGE","3.65/5","https://www.hotstar.com/in/movies/janatha-garage/1000155071/watch",14);
t.add(m4.panel);
MovieIcon m5=new MovieIcon("img/a5.jpeg","GEORGE REDDY  ","3.6/5","https://www.primevideo.com/dp/amzn1.dv.gti.90b79407-5bf7-fe44-66a9-220fdbc0ad7b?autoplay=1&ref_=atv_cf_strg_wb",16);
t.add(m5.panel);
MovieIcon m6=new MovieIcon("img/a6.jpeg","KALKI                ","3.5/5","https://www.primevideo.com/dp/amzn1.dv.gti.e2b879c9-45b7-bb54-8565-7068537e4bca?autoplay=1&ref_=atv_cf_strg_wb",16);
t.add(m6.panel);
MovieIcon m7=new MovieIcon("img/a7.jpeg","DHRUVA             ","3.9/5","https://www.mxplayer.in/movie/watch-dhruva-telugu-movie-online-021a5606a7433e94b0b0b18d73b5c728",16);
t.add(m7.panel);
MovieIcon m8=new MovieIcon("img/a8.jpeg","PATAAS              ","3.35/5","https://www.mxplayer.in/movie/watch-pataas-movie-online-2b041980aa871c6236e2c6b67b1d2b11?utm_source=paid-ext-con-perf-google_sem-web&utm_medium=web&utm_campaign=sem-web-181220-traffic-nbr-movies-mix-mix-telugu-ext_paid-DSA-na-pan-na-Sunnxt-groupm&utm_cid=112672681622&gclid=CjwKCAjwhYOFBhBkEiwASF3KGc0fqAlDzxeiqLqYGX5Uex7jD3nsvfCDLtf5y-sVIPvtTC2Yu3EdsBoC2qoQAvD_BwE",16);
t.add(m8.panel);
t.setBounds(0,500,700,400);
MovieIcon m9=new MovieIcon("img/a9.jpeg","KESHAVA            ","3.2/5","https://www.mxplayer.in/movie/watch-keshava-movie-online-6622bd26ab8318bd65a83667585f1789?utm_source=paid-ext-con-perf-google_sem-web&utm_medium=web&utm_campaign=sem-web-181220-traffic-nbr-movies-mix-mix-telugu-ext_paid-DSA-na-pan-na-Sunnxt-groupm&utm_cid=112672681622&gclid=CjwKCAjwhYOFBhBkEiwASF3KGUCLrpF6ALNka76HL8dWCLW1KokIKURpegOUq36oPUO0C0-cRG1cIhoC51AQAvD_BwE",16);
t.add(m9.panel);
MovieIcon m10=new MovieIcon("img/a10.jpeg"," GOUTHAM NANDA","3.2/5","https://www.mxplayer.in/movie/watch-goutham-nanda-movie-online-d8ba991d91c15fbeb687b6ac6314f45e?utm_source=paid-ext-con-perf-google_sem-web&utm_medium=web&utm_campaign=sem-web-181220-traffic-nbr-movies-mix-mix-telugu-ext_paid-DSA-na-pan-na-Sunnxt-groupm&utm_cid=112672681622&gclid=CjwKCAjwhYOFBhBkEiwASF3KGXC-QH0BVJjovQ2jwt0W47-_5JoxlSFRJ8rd9mWgZzvvRm7Q1b0OwRoCD20QAvD_BwE",14);
t.add(m10.panel);
MovieIcon m11=new MovieIcon("img/baby.jpg","BABY DRIVER      ","3.8/5","https://www.netflix.com/title/80142090",16);
e.add(m11.panel);
MovieIcon m12=new MovieIcon("img/escape.jpg","ESCAPE PLAN      ","3.35/5","https://www.netflix.com/title/70273614",16);
e.add(m12.panel);
MovieIcon m13=new MovieIcon("img/saving.jpg","SAVING PRIVATE RYAN  ","4.3/5","https://www.netflix.com/title/21878564",12);
e.add(m13.panel);
MovieIcon m14=new MovieIcon("img/dunkirk.jpg","DUNKIRK            ","4.5/5","https://www.primevideo.com/detail/Dunkirk/0LTSIM9J5S9TFCRQFPFGNLIMEY",16);
e.add(m14.panel);
MovieIcon m15=new MovieIcon("img/300.jpg","300                    ","3.9/5","https://www.netflix.com/title/70269488",16);
e.add(m15.panel);
MovieIcon m16=new MovieIcon("img/raid.jpg","THE RAID            ","3.8/5","https://www.primevideo.com/detail/0JXNC8XQ051ON4M209O796GGQZ/ref=atv_sr_fle_c_Tn74RA__1_1_1?sr=1-1&pageTypeIdSource=ASIN&pageTypeId=B0865W1J93&qid=1621436061",16);
e.add(m16.panel);
MovieIcon m17=new MovieIcon("img/bb.jpg","BATMAN BEGINS      ","4.1/5","https://www.netflix.com/title/70021642",14);
e.add(m17.panel);
MovieIcon m18=new MovieIcon("img/tdk.jpg","THE DARK KNIGHT   ","4.5/5","https://www.netflix.com/title/70079583",14);
e.add(m18.panel);
e.setBounds(0,500,700,400);
MovieIcon m19=new MovieIcon("img/tdkr.jpg","  THE DARK KNIGHT RISES","4.2/5","https://www.netflix.com/title/70213514",12);
e.add(m19.panel);
MovieIcon m20=new MovieIcon("img/z.jpg","WORLD WAR Z    "  ,"3.5/5","https://www.netflix.com/title/70262639", 16);
e.add(m20.panel);
MovieIcon m21=new MovieIcon("img/ba1.jpeg","BABY                 ","4/5","https://www.hotstar.com/in/movies/baby/1000053838",16);
h.add(m21.panel);
MovieIcon m22=new MovieIcon("img/ba2.jpeg","TANHAJI             ","3.8/5","https://www.hotstar.com/in/movies/tanhaji/1260022117",16);
h.add(m22.panel);
MovieIcon m23=new MovieIcon("img/ba3.jpeg","BANG BANG         ","2.8/5","https://www.hotstar.com/in/movies/bang-bang/1000034503",16);
h.add(m23.panel);
MovieIcon m24=new MovieIcon("img/ba4.jpeg","TIGER ZINDA HAI ","3/5","https://www.primevideo.com/detail/0FSE8GW3LLYSQZK9HZ30BY9S2X/ref=atv_mv_hom_c_HQaJEi_brws_8_10",16);
h.add(m24.panel);
MovieIcon m25=new MovieIcon("img/ba5.jpeg","WAR                  ","3.25/5","https://www.primevideo.com/detail/0IE81NLJ76SMXNZFNXSO19XWRK/ref=atv_br_def_r_br_c_unkc_1_60",16);
h.add(m25.panel);
MovieIcon m26=new MovieIcon("img/ba6.jpeg","RACE                  ","3.35/5","https://www.netflix.com/in/title/70096752",16);
h.add(m26.panel);
MovieIcon m27=new MovieIcon("img/ba7.jpeg","SINGHAM            ","3.4/5","https://www.netflix.com/title/70217385",16);
h.add(m27.panel); 
MovieIcon m28=new MovieIcon("img/ba8.jpg","KESARI               ","3.7/5","https://www.primevideo.com/detail/Kesari/0JCB3275HAX276B62XF6FP79F2",16);
h.add(m28.panel);
h.setBounds(0,500,700,400);
MovieIcon m29=new MovieIcon("img/ba9.jpeg","MANIKARNIKA      ","3.2/5","https://www.primevideo.com/detail/0TIVU5MTUWOMFGTH0I6JDKNFR6/ref=atv_sr_fle_c_Tn74RA__1_1_1?sr=1-1&pageTypeIdSource=ASIN&pageTypeId=B07P8PXJF1&qid=1621336927",16);
h.add(m29.panel);
MovieIcon m30=new MovieIcon("img/ba10.jpg","RAAZI                ","3.9/5","https://www.primevideo.com/detail/Raazi/0RZG6XRLLQ2SMTSFU8FG9YB6UV",16);
h.add(m30.panel);
GridLayout g1=new GridLayout(2,2);
t.setLayout(g1);
g1.setHgap(0);
g1.setVgap(0);
GridLayout g2=new GridLayout(2,2);
e.setLayout(g2);
g2.setHgap(0);
g2.setVgap(0);
GridLayout g3=new GridLayout(2,2);
h.setLayout(g3);
g3.setHgap(0);
g3.setVgap(0);

Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
JRadioButton r1=new JRadioButton(" Telugu",true);    
JRadioButton r2=new JRadioButton(" English");
JRadioButton r3=new JRadioButton(" Hindi");
r1.setBackground(new Color(60,60,60));
r2.setBackground(new Color(60,60,60));
r3.setBackground(new Color(60,60,60));
r1.setForeground(new Color(255,155,0));
r2.setForeground(new Color(255,155,0));
r3.setForeground(new Color(255,155,0));
r1.setBounds(screenSize.width-500,screenSize.height-120,100,30);  
r2.setBounds(screenSize.width-350,screenSize.height-120,100,30);  
r3.setBounds(screenSize.width-200,screenSize.height-120,100,30);
f.add(r1);
f.add(r2);
 f.add(r3); 

ButtonGroup group = new ButtonGroup();
      group.add(r1);
      group.add(r2);
      group.add(r3);
f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
if(r1.isSelected()){    
f.add(t);   
f.setVisible(true);
}
r1.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent ae) {
e.setBounds(0,0,0,0);
h.setBounds(0,0,0,0);
f.add(t);
f.setVisible(true);
}
});
r2.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent ae) {
t.setBounds(0,0,0,0);
h.setBounds(0,0,0,0);
f.add(e);
f.setVisible(true);
}
});
r3.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent ae) {
t.setBounds(0,0,0,0);
e.setBounds(0,0,0,0);
f.add(h);
f.setVisible(true);
}
});
 a.setBounds(0,screenSize.height-120,95,30);      
    f.setSize(screenSize.width, screenSize.height);
}
}
class Drama{

 Drama() {
 JFrame f = new JFrame("Drama");
 JButton a=new JButton("Previous");  
Image icon = Toolkit.getDefaultToolkit().getImage("img/p1.png");    
    f.setIconImage(icon);
  a.setBackground(new Color(204,204,204));
    f.add(a);
a.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent ae) {
f.dispose();
Thread thread = new Thread(new F1(0));
    thread.start();
}
});
JPanel t=new JPanel();
 JPanel e=new JPanel(); 
JPanel h=new JPanel();
MovieIcon m1=new MovieIcon("img/d1.jpeg","JERSEY               ","4.3/5","https://www.zee5.com/movies/details/jersey/0-0-59341",16);
t.add(m1.panel);
MovieIcon m2=new MovieIcon("img/d2.jpeg","MALLESHAM         ","4.2/5","https://www.netflix.com/title/81217739",16);
t.add(m2.panel);
MovieIcon m3=new MovieIcon("img/d3.jpeg","BROCHEVAREVARURA","4/5","https://www.primevideo.com/dp/amzn1.dv.gti.f6b62763-87a3-afd1-ce9e-d57edeecdea7?autoplay=1&ref_=atv_cf_strg_wb",11);
t.add(m3.panel);
MovieIcon m4=new MovieIcon("img/d4.jpeg","MAHANATI          ","4.25/5","https://www.primevideo.com/detail/0OJU2LQUJ86FDG9YZPPSN5C8K5/ref=atv_sr_fle_c_Tn74RA__1_1_1?sr=1-1&pageTypeIdSource=ASIN&pageTypeId=B07DX4RNBS&qid=1621241170",16);
t.add(m4.panel);
MovieIcon m5=new MovieIcon("img/d5.jpeg","C/O KANCHARAPALEM ","4.5/5","https://www.netflix.com/title/81113928",12);
t.add(m5.panel);
MovieIcon m6=new MovieIcon("img/d6.jpeg","GURU                 ","4/5","https://www.mxplayer.in/movie/watch-guru-movie-online-08b6ece7499bf8c899fa6ecd78ba2e8e",16);
t.add(m6.panel);
MovieIcon m7=new MovieIcon("img/d7.jpeg","KANCHE              ","4/5","https://www.hotstar.com/in/movies/kanche/1000086490/watch",16);
t.add(m7.panel);
MovieIcon m8=new MovieIcon("img/d8.jpeg","OOPIRI               ","4/5","https://www.mxplayer.in/movie/watch-oopiri-movie-online-d97411e8aafda722a01a452fe57695e4?utm_source=paid-ext-con-perf-google_sem-web&utm_medium=web&utm_campaign=sem-web-181220-traffic-nbr-movies-mix-mix-telugu-ext_paid-DSA-na-pan-na-Sunnxt-groupm&utm_cid=112672681622&gclid=CjwKCAjwqIiFBhAHEiwANg9sztroLiFX1VynaAX6cTek-5XeU5gywVYpPQ3O-PmnOQ_vm9YaFx3gGRoCy4IQAvD_BwE",16);
t.add(m8.panel);
t.setBounds(0,500,700,400);
MovieIcon m9=new MovieIcon("img/d9.jpeg","MANAMANTHA     ","3.85/5","https://www.hotstar.com/in/movies/manamantha/1000153482",16);
t.add(m9.panel);
MovieIcon m10=new MovieIcon("img/d10.jpeg","YEVADE SUBRAMANYAM ","3.8/5","https://www.mxplayer.in/movie/watch-yevade-subramanyam-movie-online-3e41f09b6f34f22722fccb9ba4db5f96?utm_source=paid-ext-con-perf-google_sem-web&utm_medium=web&utm_campaign=sem-web-181220-traffic-nbr-movies-mix-mix-telugu-ext_paid-DSA-na-pan-na-Sunnxt-groupm&utm_cid=112672681622&gclid=CjwKCAjwqIiFBhAHEiwANg9szsubp6Ty0_VZMl2GFEmvfo54z0w3y3H-EeF5cfotG0wYA8LBhdZ53RoCFLgQAvD_BwE",10);
t.add(m10.panel);
MovieIcon m11=new MovieIcon("img/imitation.jpg","THE IMITATION GAME ","4/5","https://www.netflix.com/title/70295172",10);
e.add(m11.panel);
MovieIcon m12=new MovieIcon("img/joker.jpg","JOKER                ","4.2/5","https://www.netflix.com/title/81092221",16);
e.add(m12.panel);
MovieIcon m13=new MovieIcon("img/knives.jpg","KNIVES OUT        ","4/5","https://www.airtelxstream.in/movies/knives-out/LIONSGATEPLAY_MOVIE_KNIVESOUTY2019M",16);
e.add(m13.panel);
MovieIcon m14=new MovieIcon("img/money.jpg","MONEYBALL        ","3.8/5","https://www.netflix.com/title/70201437",16);
e.add(m14.panel);
MovieIcon m15=new MovieIcon("img/ford.jpg","FORD V FERRARI","4/5","https://www.hotstar.com/in/movies/ford-v-ferrari/1260029222",14);
e.add(m15.panel);
MovieIcon m16=new MovieIcon("img/shaw.jpg","THE SHAWSHANK REDEMPTION ","4.2/5","https://www.hungama.com/movie/the-shawshank-redemption/2715049/",8);
e.add(m16.panel); 
MovieIcon m17=new MovieIcon("img/paw.jpg","SOUTHPAW        ","3.7/5","https://www.netflix.com/title/80038447",16);
e.add(m17.panel);
MovieIcon m18=new MovieIcon("img/net.jpg","THE SOCIAL NETWORK  ","3.85/5","https://www.netflix.com/title/70132721",12);
e.add(m18.panel);
e.setBounds(0,500,700,400);
MovieIcon m19=new MovieIcon("img/contagion.jpg","CONTAGION        ","3.35/5","https://www.netflix.com/title/70185071",16);
e.add(m19.panel); 
MovieIcon m20=new MovieIcon("img/trial.jpg","THE TRIAL OF CHICAGO 7 ","3.9/5","https://www.netflix.com/title/81043755",10);
e.add(m20.panel);
MovieIcon m21=new MovieIcon("img/bd1.jpeg","MISSION MANGAL ","3.25/5","https://www.hotstar.com/in/movies/mission-mangal/1260011536",16);
h.add(m21.panel);
MovieIcon m22=new MovieIcon("img/bd2.jpeg"," BAJRANGI BAIJAAN","4/5","https://www.hotstar.com/in/movies/bajrangi-bhaijaan/1000071777",16);
h.add(m22.panel);
MovieIcon m23=new MovieIcon("img/bd3.jpeg","GULLY BOY         ","4/5","https://www.primevideo.com/detail/0I5OF8K1O8JNLUPOQ3VU3MBR5I/ref=atv_sr_fle_c_Tn74RA__1_1_1?sr=1-1&pageTypeIdSource=ASIN&pageTypeId=B07PM3TWQL&qid=1621348800",16);
h.add(m23.panel);
MovieIcon m24=new MovieIcon("img/bd4.jpeg","CHHICHHORE      ","4.2/5","https://www.hotstar.com/in/movies/chhichhore/1260012713",16);
h.add(m24.panel);
MovieIcon m25=new MovieIcon("img/bd5.jpeg","PINK                  ","4.1/5","https://www.primevideo.com/detail/0RV973JC7QSEJGTEJX0Q7VMFA5/ref=atv_sr_fle_c_Tn74RA__1_1_1?sr=1-1&pageTypeIdSource=ASIN&pageTypeId=B08HV386BF&qid=1621346631",16);
h.add(m25.panel);
MovieIcon m26=new MovieIcon("img/bd6.jpeg","PK                     ","4.1/5","https://www.netflix.com/title/70303496",16);
h.add(m26.panel);
MovieIcon m27=new MovieIcon("img/bd7.jpeg","LAGAAN              ","4.1/5","https://www.netflix.com/title/60020906",16);
h.add(m27.panel);
MovieIcon m28=new MovieIcon("img/bd8.jpeg","DANGAL              ","4.2/5","https://www.netflix.com/title/80166185",16);
h.add(m28.panel);
h.setBounds(0,500,700,400);
MovieIcon m29=new MovieIcon("img/bd9.jpeg","SANJU                ","3.85/5","https://www.netflix.com/title/81020508",16);
h.add(m29.panel); 
MovieIcon m30=new MovieIcon("img/bd10.jpeg","DIL BECHARA      ","3.3/5","https://www.hotstar.com/in/movies/dil-bechara/1260036017",16);
h.add(m30.panel);
GridLayout g1=new GridLayout(2,2);
t.setLayout(g1);
g1.setHgap(0);
g1.setVgap(0);
GridLayout g2=new GridLayout(2,2);
e.setLayout(g2);
g2.setHgap(0);
g2.setVgap(0);
GridLayout g3=new GridLayout(2,2);
h.setLayout(g3);
g3.setHgap(0);
g3.setVgap(0);

Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
JRadioButton r1=new JRadioButton("Telugu",true);    
JRadioButton r2=new JRadioButton(" English");
JRadioButton r3=new JRadioButton(" Hindi");
r1.setBackground(new Color(60,60,60));
r2.setBackground(new Color(60,60,60));
r3.setBackground(new Color(60,60,60));
r1.setForeground(new Color(255,155,0));
r2.setForeground(new Color(255,155,0));
r3.setForeground(new Color(255,155,0));
r1.setBounds(screenSize.width-500,screenSize.height-120,100,30);  
r2.setBounds(screenSize.width-350,screenSize.height-120,100,30);  
r3.setBounds(screenSize.width-200,screenSize.height-120,100,30);
f.add(r1);
f.add(r2);
 f.add(r3); 

ButtonGroup group = new ButtonGroup();
      group.add(r1);
      group.add(r2);
      group.add(r3);
f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
if(r1.isSelected()){    
f.add(t);   
f.setVisible(true);
}
r1.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent ae) {
e.setBounds(0,0,0,0);
h.setBounds(0,0,0,0);
f.add(t);
f.setVisible(true);
}
});
r2.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent ae) {
t.setBounds(0,0,0,0);
h.setBounds(0,0,0,0);
f.add(e);
f.setVisible(true);
}
});
r3.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent ae) {
t.setBounds(0,0,0,0);
e.setBounds(0,0,0,0);
f.add(h);
f.setVisible(true);
}
});
 a.setBounds(0,screenSize.height-120,95,30);      
    f.setSize(screenSize.width, screenSize.height);
}
}
class Comedy {

 Comedy() {
 JFrame f = new JFrame("Comedy");
 JButton a=new JButton("Previous"); 
  a.setBackground(new Color(204,204,204)); 
Image icon = Toolkit.getDefaultToolkit().getImage("img/p1.png");    
    f.setIconImage(icon);
    f.add(a);
a.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent ae) {
f.dispose();
Thread thread = new Thread(new F1(0));
    thread.start();
}
});
JPanel t=new JPanel();
 JPanel e=new JPanel(); 
JPanel h=new JPanel();
MovieIcon m1=new MovieIcon("img/c1.jpeg","MAIL                  ","4/5","https://www.aha.video/movies/mail",16);
t.add(m1.panel);
MovieIcon m2=new MovieIcon("img/c2.jpeg","JATHI RATNALU   ","3.8/5","https://app.primevideo.com/detail?gti=amzn1.dv.gti.c6bc4996-e5de-b2d7-088f-69d7807a18fc&ref_=atv_dp_share_mv&r=web",16);
t.add(m2.panel);
MovieIcon m3=new MovieIcon("img/c3.jpeg","CINEMA BANDI    ","4.1/5","https://www.netflix.com/title/81382253",16);
t.add(m3.panel);
MovieIcon m4=new MovieIcon("img/c4.jpeg","CHALO                ","3.2/5","https://www.mxplayer.in/movie/watch-chalo-telugu-movie-online-ac9e8e2a43b415f877e1bf8fb07bd372?utm_source=paid-ext-con-perf-google_sem-web&utm_medium=web&utm_campaign=sem-web-181220-traffic-nbr-movies-mix-mix-telugu-ext_paid-DSA-na-pan-na-Sunnxt-groupm&utm_cid=112672681622&gclid=CjwKCAjwqIiFBhAHEiwANg9szlQDFwKArAqOgpwIbp_pwonI6QhaLNAfjOj9VZdlzwhl2BKrvteEwBoCy4kQAvD_BwE",16);
t.add(m4.panel);
MovieIcon m5=new MovieIcon("img/c5.jpeg","CHI LA SOW        ","3.9/5","https://www.mxplayer.in/movie/watch-chi-la-sow-movie-online-5e376533075876ec20489ac2c35305bf?utm_source=paid-ext-con-perf-google_sem-web&utm_medium=web&utm_campaign=sem-web-181220-traffic-nbr-movies-mix-mix-telugu-ext_paid-DSA-na-pan-na-Sunnxt-groupm&utm_cid=112672681622&gclid=CjwKCAjwqIiFBhAHEiwANg9szhMc329_7K1PFGYB7FsB1NY-d2JoI6p1XM0DuCP3aUU3nxtvo97AqxoCZU0QAvD_BwE",16);
t.add(m5.panel);
MovieIcon m6=new MovieIcon("img/c6.jpeg","PELLI CHOOPULU ","4.1/5","https://www.mxplayer.in/movie/watch-pelli-choopulu-movie-online-a76c58e832a91f957cffee2554fda3ce?utm_source=paid-ext-con-perf-google_sem-web&utm_medium=web&utm_campaign=sem-web-181220-traffic-nbr-movies-mix-mix-telugu-ext_paid-DSA-na-pan-na-Sunnxt-groupm&utm_cid=112672681622&gclid=CjwKCAjwqIiFBhAHEiwANg9szgPm5XvspjqiU6wTB9MeK3ImzNV9BF5dyku9-swdCeidSNcU7WHN4hoCVb0QAvD_BwE",16);
t.add(m6.panel);
MovieIcon m7=new MovieIcon("img/c7.jpeg","RUN RAJA RUN     ","3.7/5","https://www.mxplayer.in/movie/watch-run-raja-run-movie-online-88236999948aec988eec6e7dece60dc9?utm_source=paid-ext-con-perf-google_sem-web&utm_medium=web&utm_campaign=sem-web-181220-traffic-nbr-movies-mix-mix-telugu-ext_paid-DSA-na-pan-na-Sunnxt-groupm&utm_cid=112672681622&gclid=CjwKCAjwqIiFBhAHEiwANg9szjYpbTA31w1St5idzyq5qH3XjUySor9Y1fF_8U5ksAzDMprVK4LEvRoCrXIQAvD_BwE",16);
t.add(m7.panel);
MovieIcon m8=new MovieIcon("img/c8.jpeg","   EE NAGARANIKI EM AYYINDI"," 4/5","https://www.netflix.com/title/81052275",9);
t.add(m8.panel);
MovieIcon m9=new MovieIcon("img/c9.jpeg","AGENT SAI SRINIVAS ATHREYA        "," 4.2/5","https://www.primevideo.com/detail/Agent-Sai-Srinivasa-Athreya/0PQHTNL47NU88A3P7S2DYWN1AU",8);
t.add(m9.panel);
MovieIcon m10=new MovieIcon("img/c10.jpeg"," MIDDLE CLASS MELODIES  "," 4/5","https://www.primevideo.com/dp/amzn1.dv.gti.dab9eb90-8863-1561-890d-cefbe9389fbd?autoplay=1&ref_=atv_cf_strg_wb",10);
t.add(m10.panel);
MovieIcon m11=new MovieIcon("img/hangover.jpg","THE HANGOVER   ","3.85/5","https://www.netflix.com/title/70113002",16);
e.add(m11.panel);
MovieIcon m12=new MovieIcon("img/shazam.jpg","SHAZAM!             ","3.5/5","https://www.netflix.com/title/81030627",16);
e.add(m12.panel);
MovieIcon m13=new MovieIcon("img/jumanji.jpg","JUMANJI: WELCOME TO THE JUNGLE","3.5/5","https://www.netflix.com/title/80192646",8);
e.add(m13.panel);
MovieIcon m14=new MovieIcon("img/soul.jpg","SOUL                  ","4/5","https://www.hotstar.com/in/movies/soul/1260049853",16);
e.add(m14.panel);
MovieIcon m15=new MovieIcon("img/jojo.jpg","JOJO RABBIT       ","4/5","https://www.hotstar.com/in/movies/jojo-rabbit/1260027305",16);
e.add(m15.panel);
MovieIcon m16=new MovieIcon("img/museum.jpg","NIGHT AT THE MUSEUM","3.2/5","https://www.hotstar.com/in/movies/night-at-the-museum/1770000749",12);
e.add(m16.panel);
MovieIcon m17=new MovieIcon("img/incred.jpg","THE INCREDEBILES","4/5","https://www.hotstar.com/in/movies/the-incredibles/1260018306",16);
e.add(m17.panel);
MovieIcon m18=new MovieIcon("img/toy.jpg","TOY STORY         ","4.1/5","https://www.hotstar.com/in/movies/toy-story/1660010197",16);
e.add(m18.panel);
e.setBounds(0,500,700,400);
MovieIcon m19=new MovieIcon("img/nemo.jpg","FINDING NEMO    ","4/5","https://www.hotstar.com/in/movies/finding-nemo/1660010114",16);
e.add(m19.panel);
MovieIcon m20=new MovieIcon("img/despi.jpg","DESPICABLE ME   ","3.8/5","https://www.netflix.com/title/70115629",16);
e.add(m20.panel);
MovieIcon m21=new MovieIcon("img/bc1.jpeg","3 IDIOTS            ","4.2/5","https://www.netflix.com/title/70121522",16);
h.add(m21.panel); 
MovieIcon m22=new MovieIcon("img/bc2.jpeg","JOLLY LLB           ","3.25/5","https://www.hotstar.com/in/movies/jolly-llb/1000007132",16);
h.add(m22.panel);
MovieIcon m23=new MovieIcon("img/bc3.jpeg","BALA                  ","3.65/5","https://www.hotstar.com/in/movies/bala/1260016419",16);
h.add(m23.panel);  
MovieIcon m24=new MovieIcon("img/bc4.jpg","STREE                ","3.8/5","https://www.hotstar.com/in/movies/stree/1000223587",16);
h.add(m24.panel);
MovieIcon m25=new MovieIcon("img/bc5.jpeg","GOLMAAL            ","3.7/5","https://www.zee5.com/movies/details/golmaal-fun-unlimited-2006-hindi-drama/0-0-7698",16);
h.add(m25.panel);
MovieIcon m26=new MovieIcon("img/bc6.jpeg","LOOTCASE          ","3.8/5","https://www.hotstar.com/in/movies/lootcase/1260028560",16);
h.add(m26.panel);
MovieIcon m27=new MovieIcon("img/bc7.jpeg","FUCKREY             ","3.5/5","https://www.hotstar.com/in/movies/fukrey/1000001027",16);
h.add(m27.panel);
MovieIcon m28=new MovieIcon("img/bc8.jpg","VICKY DONOR     ","3.9/5","https://www.jiocinema.com/movies/vicky-donor?type=0&id=67177550d03a11e6a3132fc17de8f966",16);
h.add(m28.panel);
h.setBounds(0,500,700,400);
MovieIcon m29=new MovieIcon("img/bc9.jpeg"," ZINDAGI NA MILEGI DOBARA","4.1/5","https://www.netflix.com/title/70202336",10);
h.add(m29.panel);
MovieIcon m30=new MovieIcon("img/bc10.jpeg"," BADRINATH KI DULHANIA","3/5","https://www.primevideo.com/detail/0QSSI97L6FF0AN5EV3FEEWV298/ref=atv_sr_fle_c_Tn74RA__1_1_1?sr=1-1&pageTypeIdSource=ASIN&pageTypeId=B0728P28F9&qid=1621396999",12);
h.add(m30.panel);
GridLayout g1=new GridLayout(2,2);
t.setLayout(g1);
g1.setHgap(0);
g1.setVgap(0);
GridLayout g2=new GridLayout(2,2);
e.setLayout(g2);
g2.setHgap(0);
g2.setVgap(0);
GridLayout g3=new GridLayout(2,2);
h.setLayout(g3);
g3.setHgap(0);
g3.setVgap(0);

Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
JRadioButton r1=new JRadioButton(" Telugu",true);    
JRadioButton r2=new JRadioButton(" English");
JRadioButton r3=new JRadioButton(" Hindi");
r1.setBackground(new Color(60,60,60));
r2.setBackground(new Color(60,60,60));
r3.setBackground(new Color(60,60,60));
r1.setForeground(new Color(255,155,0));
r2.setForeground(new Color(255,155,0));
r3.setForeground(new Color(255,155,0));
r1.setBounds(screenSize.width-500,screenSize.height-120,100,30);  
r2.setBounds(screenSize.width-350,screenSize.height-120,100,30);  
r3.setBounds(screenSize.width-200,screenSize.height-120,100,30);
f.add(r1);
f.add(r2);
 f.add(r3); 

ButtonGroup group = new ButtonGroup();
      group.add(r1);
      group.add(r2);
      group.add(r3);
f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
if(r1.isSelected()){    
f.add(t);   
f.setVisible(true);
}
r1.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent ae) {
e.setBounds(0,0,0,0);
h.setBounds(0,0,0,0);
f.add(t);
f.setVisible(true);
}
});
r2.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent ae) {
t.setBounds(0,0,0,0);
h.setBounds(0,0,0,0);
f.add(e);
f.setVisible(true);
}
});
r3.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent ae) {
t.setBounds(0,0,0,0);
e.setBounds(0,0,0,0);
f.add(h);
f.setVisible(true);
}
});
 a.setBounds(0,screenSize.height-120,95,30);      
    f.setSize(screenSize.width, screenSize.height);
}
}

class Romance{

Romance() {
JFrame f = new JFrame("Romance");
JButton a=new JButton("Previous"); 
a.setBackground(new Color(204,204,204)); 
Image icon = Toolkit.getDefaultToolkit().getImage("img/p1.png");    
f.setIconImage(icon);
f.add(a);
a.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent ae) {
f.dispose();
Thread thread = new Thread(new F1(0));
thread.start();
}
});
JPanel t=new JPanel();
 JPanel e=new JPanel(); 
JPanel h=new JPanel();
MovieIcon m[]=new MovieIcon[30];
m[0]=new MovieIcon("img/tholi.jpg","THOLI PREMA      ","3.7/5","https://www.sunnxt.com/movie/detail/72211/tholi-prema/",16);
m[1]=new MovieIcon("img/sammo.jpg","SAMMOHANAM     ","3.8/5","https://www.hotstar.com/in/movies/sammohanam/1000230936",16);
m[2]=new MovieIcon("img/ninnu.jpg","NINNU KORI       ","3.75/5","https://www.primevideo.com/detail/Ninnu-Kori/0RZF76TUZPT15XK11AY2LLJQYJ",16);
m[3]=new MovieIcon("img/malliraava.jpg","MALLI RAAVA      ","4/5","https://www.sunnxt.com/movie/detail/72206/malli-raava/",16);
m[4]=new MovieIcon("img/premam.jpg","PREMAM             ","3.25/5","https://www.sunnxt.com/movie/detail/31263",16);
m[5]=new MovieIcon("img/oohalu.jpg","OOHALU GUSAGUSALADE  ","3.9/5","https://www.hotstar.com/in/movies/oohalu-gusagusalaade/1000055255",9);
m[6]=new MovieIcon("img/mallimalli.jpg","MALLI MALLI IDHI RANI ROJU","3.75/5","https://www.hotstar.com/in/movies/malli-malli-idi-rani-roju/1000074643",10);
m[7]=new MovieIcon("img/raja.jpg","RAJA VAARU RANI GAARU  ","3.8/5","https://www.primevideo.com/detail/Raja-Vaaru-Raani-Gaaru/0JTDVP40X64CI73V4S5V8I79AL",10);
m[8]=new MovieIcon("img/uppena.jpg","UPPENA            ","3.5/5","https://www.netflix.com/title/81231988",16);
m[9]=new MovieIcon("img/colour.jpg","COLOUR PHOTO      ","4/5","https://www.aha.video/movies/colour-photo",14);
t.setBounds(0,500,700,400);
m[10]=new MovieIcon("img/lala.jpg","LA LA LAND        ","4.4/5","https://www.netflix.com/title/80095365",16);
m[11]=new MovieIcon("img/titanic.jpg","TITANIC             ","3.9/5","https://www.hotstar.com/in/movies/titanic/1770001166",16);
m[12]=new MovieIcon("img/forrest.jpg","FORREST GUMP   ","4.4/5","https://www.netflix.com/title/60000724",16);
m[13]=new MovieIcon("img/star.jpg","A STAR IS BORN ","3.8/5","https://www.netflix.com/title/80221908",16);
m[14]=new MovieIcon("img/callme.jpg","CALL ME BY YOUR NAME ","3.95/5","https://www.netflix.com/title/80169498",12);
m[15]=new MovieIcon("img/fault.jpg"," THE FAULT IN OUR STARS ","3.85/5","https://www.hotstar.com/in/movies/the-fault-in-our-stars/1770000333",10);
m[16]=new MovieIcon("img/theory.jpg","THE THEORY OF EVERYTHING","3.85/5","https://www.netflix.com/title/80000644",10);
m[17]=new MovieIcon("img/beauty.jpg","BEAUTY AND THE BEAST","3.4/5","https://www.hotstar.com/in/movies/beauty-and-the-beast/1260017283",12);
m[18]=new MovieIcon("img/note.jpg","THE NOTEBOOK   ","3.9/5","https://www.netflix.com/title/60036227",16);
m[19]=new MovieIcon("img/hill.jpg","NOTTING HILL     ","3.5/5","https://www.netflix.com/title/21304015",16);
e.setBounds(0,500,700,400);
m[20]=new MovieIcon("img/br1.jpeg","2 STATES           ","3.5/5","https://www.hotstar.com/in/movies/2-states/1000034502",16);
m[21]=new MovieIcon("img/br2.jpeg","CHENNAI EXPRESS","3/5","https://www.hotstar.com/in/movies/chennai-express/1000164208",16);
m[22]=new MovieIcon("img/br3.jpeg","STUDENT OF THE YEAR    ","2.7/5","https://www.primevideo.com/detail/0PHVUL9RF3AW62EAIKSSW9053U/ref=atv_sr_fle_c_Tn74RA__2_1_2?sr=1-2&pageTypeIdSource=ASIN&pageTypeId=B01MA55LB2&qid=1621398265",11);
m[23]=new MovieIcon("img/br4.jpeg","YEH JAWAANI HAI DEEWANI","3.5/5","https://www.primevideo.com/detail/0NU7MBRU958PX2QUTM0F3GG5TP/ref=atv_sr_fle_c_Tn74RA__1_1_1?sr=1-1&pageTypeIdSource=ASIN&pageTypeId=B01MXONSTY&qid=1621398686",10);
m[24]=new MovieIcon("img/br5.jpg","DE DE PYAAR DE ","3.3/5","https://www.hotstar.com/us/movies/de-de-pyaar-de/1000239103",16);
m[25]=new MovieIcon("img/br6.jpeg","OK JAANU           ","3.2/5","https://www.primevideo.com/detail/0IQXL0BSRD53FLSZI4KNIY21IJ/ref=atv_sr_fle_c_Tn74RA__1_1_1?sr=1-1&pageTypeIdSource=ASIN&pageTypeId=B06ZY2P28D&qid=1621398940",16);
m[26]=new MovieIcon("img/br7.jpeg","RAB NE BANADI JODI","3.6/5","https://www.primevideo.com/detail/0I9V8J7ULXMS79SCYQS7FN0JS3/ref=atv_sr_fle_c_Tn74RA__1_1_1?sr=1-1&pageTypeIdSource=ASIN&pageTypeId=B01MA57OKL&qid=1621399100",14);
m[27]=new MovieIcon("img/br8.jpeg","KABIR SINGH      ","3.5/5","https://www.netflix.com/br-en/title/81107545",16);
m[28]=new MovieIcon("img/br9.jpg","BAJIRAO MASTANI","3.6/5","https://www.jiocinema.com/movies/bajirao-mastani?type=0&id=536f5fd1564c11e68ab857b70042686d",16);
m[29]=new MovieIcon("img/br10.jpeg","WAKEUP SID       ","3.8/5","https://www.netflix.com/title/70123119",16);
h.setBounds(0,500,700,400);
for(int i=0; i<10; i++)
{
  t.add(m[i].panel);
  e.add(m[i+10].panel);
  h.add(m[i+20].panel);
}
GridLayout g1=new GridLayout(2,2);
t.setLayout(g1);
g1.setHgap(0);
g1.setVgap(0);
GridLayout g2=new GridLayout(2,2);
e.setLayout(g2);
g2.setHgap(0);
g2.setVgap(0);
GridLayout g3=new GridLayout(2,2);
h.setLayout(g3);
g3.setHgap(0);
g3.setVgap(0);

Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
JRadioButton r1=new JRadioButton("Telugu",true);    
JRadioButton r2=new JRadioButton(" English");
JRadioButton r3=new JRadioButton(" Hindi");
r1.setBackground(new Color(60,60,60));
r2.setBackground(new Color(60,60,60));
r3.setBackground(new Color(60,60,60));
r1.setForeground(new Color(255,155,0));
r2.setForeground(new Color(255,155,0));
r3.setForeground(new Color(255,155,0));
r1.setBounds(screenSize.width-500,screenSize.height-120,100,30);  
r2.setBounds(screenSize.width-350,screenSize.height-120,100,30);  
r3.setBounds(screenSize.width-200,screenSize.height-120,100,30);
f.add(r1);
f.add(r2);
f.add(r3); 

ButtonGroup group = new ButtonGroup();
group.add(r1);
group.add(r2);
group.add(r3);
f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
if(r1.isSelected()){    
f.add(t);   
f.setVisible(true);
}
r1.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent ae) {
e.setBounds(0,0,0,0);
h.setBounds(0,0,0,0);
f.add(t);
f.setVisible(true);
}
});
r2.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent ae) {
t.setBounds(0,0,0,0);
h.setBounds(0,0,0,0);
f.add(e);
f.setVisible(true);
}
});
r3.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent ae) {
t.setBounds(0,0,0,0);
e.setBounds(0,0,0,0);
f.add(h);
f.setVisible(true);
}
});
a.setBounds(0,screenSize.height-120,95,30);      
f.setSize(screenSize.width, screenSize.height);
}
}
class Thriller{

 Thriller() {
 JFrame f = new JFrame("Thirller");
 JButton a=new JButton("Previous");
  a.setBackground(new Color(204,204,204));  
Image icon = Toolkit.getDefaultToolkit().getImage("img/p1.png");    
    f.setIconImage(icon);
    f.add(a);
a.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent ae) {
f.dispose();
Thread thread = new Thread(new F1(0));
    thread.start();
}
});
JPanel t=new JPanel();
JPanel e=new JPanel(); 
JPanel h=new JPanel();
MovieIcon m[]=new MovieIcon[30];
m[0]=new MovieIcon("img/hit.jpg","HIT: THE FIRST CASE    ","3.85/5","https://www.primevideo.com/detail/Hit-The-First-Case/0P579F2LOKNHCHINGTPAB1XA8C",12);
m[1]=new MovieIcon("img/rakshasudu.jpg","RAKSHASUDU      ","4/5","https://www.sunnxt.com/telugu-movie/detail/89105/rakshasudu/",16);
m[2]=new MovieIcon("img/awe.jpg","AWE                  ","3.9/5","https://www.netflix.com/title/81052266",16);
m[3]=new MovieIcon("img/goodachari.jpg","GOODACHARI      ","4/5","https://www.primevideo.com/detail/0JTC6Z3S8789FTGPUWLJQICAXC",16);
m[4]=new MovieIcon("img/kshanam.jpg","KSHANAM           ","4.2/5","https://www.sunnxt.com/movie/detail/7759/kshanam/",16);
m[5]=new MovieIcon("img/mathuvadalara.jpg","MATHU VADALARA","4.2/5","https://www.primevideo.com/detail/Mathu-Vadalara/0N0GVANIJJEAS04V3AMLRDHKDP",16);
m[6]=new MovieIcon("img/lie.jpg","LIE                    ","3/5","https://www.zee5.com/movies/details/lie/0-0-movie_1163063379",16);
m[7]=new MovieIcon("img/psv.jpg","PSV GARUDA VEGA  ","3.9/5","https://www.sunnxt.com/movie/detail/80342/psv-garudavega/",14);
m[8]=new MovieIcon("img/ghazi.jpg","GHAZI                ","3.8/5","https://www.primevideo.com/detail/Ghazi-Telugu/0LCPHUMGJENN5U8HJCYMOMVP6M",16);
m[9]=new MovieIcon("img/karthikeya.jpg","KARTHIKEYA      ","3.7/5","https://www.sunnxt.com/movie/detail/7628/karthikeya/",16);
t.setBounds(0,500,700,400);
m[10]=new MovieIcon("img/zodiac.jpg","ZODIAC              ","3.85/5","https://www.netflix.com/title/70044686",16);
m[11]=new MovieIcon("img/now.jpg","NOW YOU SEE ME","3.6/5","https://www.airtelxstream.in/movies/now-you-see-me/LIONSGATEPLAY_MOVIE_NOWYOUSEEMEY2013M",16);
m[12]=new MovieIcon("img/john.jpg","JOHN WICK         ","3.7/5","https://www.netflix.com/title/80013762",16);
m[13]=new MovieIcon("img/john2.jpg","JOHN WICK 2      ","3.75/5","https://www.airtelxstream.in/movies/john-wick-chapter-2/LIONSGATEPLAY_MOVIE_JOHNWICKCHAPTER2Y2017M",16);
m[14]=new MovieIcon("img/john3.jpg","JOHN WICK 3      ","4.25/5","https://www.airtelxstream.in/movies/john-wick-chapter-3-parabellum/LIONSGATEPLAY_MOVIE_JOHNWICKCHAPTER3PARABELLUMY2019M",16);
m[15]=new MovieIcon("img/shutter.jpg","SHUTTER ISLAND ","4.1/5","https://www.netflix.com/title/70095139",16);
m[16]=new MovieIcon("img/departed.jpg","THE DEPARTED    ","4.25/5","https://www.hungama.com/movie/the-departed/2019250/",16);
m[17]=new MovieIcon("img/inside.jpg","INSIDE MAN        ","3.8/5","https://www.netflix.com/title/70044379",16);
m[18]=new MovieIcon("img/night.jpg","NIGHT CRAWLER ","3.9/5","https://www.netflix.com/title/70295182",16);
m[19]=new MovieIcon("img/irishman.jpg","THE IRISHMAN    ","3.9/5","https://www.netflix.com/title/80175798",16);
e.setBounds(0,500,700,400);
m[20]=new MovieIcon("img/bt1.jpeg","MOM                  ","3.65/5","https://www.netflix.com/title/80201175",16);
m[21]=new MovieIcon("img/bt2.jpeg","ARTICLE 15         ","4.1/5","https://www.netflix.com/in/title/81154455",16);
m[22]=new MovieIcon("img/bt3.jpeg","ANDHADHUN        ","4.1/5","https://www.netflix.com/title/81039381",16);
m[23]=new MovieIcon("img/bt4.jpeg","SPECIAL 26         ","4/5","https://www.netflix.com/title/70273637",16);
m[24]=new MovieIcon("img/bt5.jpeg","KAHAANI            ","4/5","https://www.netflix.com/title/70236020",16);
m[25]=new MovieIcon("img/bt6.jpeg","BADLA               ","3.9/5","https://www.netflix.com/title/81112446",16);
m[26]=new MovieIcon("img/bt7.jpeg","ROMEO AKBAR WALTER   ","3.3/5","https://www.netflix.com/title/81039384",11);
m[27]=new MovieIcon("img/bt8.jpeg","WAZIR               ","3.5/5","https://www.netflix.com/title/80094096",16);
m[28]=new MovieIcon("img/bt9.jpeg","MADRAS CAFE     ","3.85/5","https://www.netflix.com/title/70293703",16);
m[29]=new MovieIcon("img/bt10.jpeg","UGLY                 ","4/5","https://www.hotstar.com/in/movies/ugly/1000224705",16);
h.setBounds(0,500,700,400);
for(int i=0; i<10; i++)
{
  t.add(m[i].panel);
  e.add(m[i+10].panel);
  h.add(m[i+20].panel);
}

GridLayout g1=new GridLayout(2,2);
t.setLayout(g1);
g1.setHgap(0);
g1.setVgap(0);
GridLayout g2=new GridLayout(2,2);
e.setLayout(g2);
g2.setHgap(0);
g2.setVgap(0);
GridLayout g3=new GridLayout(2,2);
h.setLayout(g3);
g3.setHgap(0);
g3.setVgap(0);

Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
JRadioButton r1=new JRadioButton("Telugu",true);    
JRadioButton r2=new JRadioButton(" English");
JRadioButton r3=new JRadioButton(" Hindi");
r1.setBackground(new Color(60,60,60));
r2.setBackground(new Color(60,60,60));
r3.setBackground(new Color(60,60,60));
r1.setForeground(new Color(255,155,0));
r2.setForeground(new Color(255,155,0));
r3.setForeground(new Color(255,155,0));
r1.setBounds(screenSize.width-500,screenSize.height-120,100,30);  
r2.setBounds(screenSize.width-350,screenSize.height-120,100,30);  
r3.setBounds(screenSize.width-200,screenSize.height-120,100,30);
f.add(r1);
f.add(r2);
f.add(r3); 

ButtonGroup group = new ButtonGroup();
group.add(r1);
group.add(r2);
group.add(r3);
f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
if(r1.isSelected()){    
f.add(t);   
f.setVisible(true);
}
r1.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent ae) {
e.setBounds(0,0,0,0);
h.setBounds(0,0,0,0);
f.add(t);
f.setVisible(true);
}
});
r2.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent ae) {
t.setBounds(0,0,0,0);
h.setBounds(0,0,0,0);
f.add(e);
f.setVisible(true);
}
});
r3.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent ae) {
t.setBounds(0,0,0,0);
e.setBounds(0,0,0,0);
f.add(h);
f.setVisible(true);
}
});
a.setBounds(0,screenSize.height-120,95,30);      
f.setSize(screenSize.width, screenSize.height);
}
}
class SciFi {

SciFi() {
JFrame f = new JFrame("SciFi");
JButton a=new JButton("Previous");
a.setBackground(new Color(204,204,204));  
Image icon = Toolkit.getDefaultToolkit().getImage("img/p1.png");    
f.setIconImage(icon);
f.add(a);
a.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent ae) {
f.dispose();
Thread thread = new Thread(new F1(0));
thread.start();
}
});
JPanel e=new JPanel();
MovieIcon m[]= new MovieIcon[10];
m[0]=new MovieIcon("img/interstellar.jpg","INTERSTELLAR     ","4.3/5","https://www.netflix.com/title/70305903",16);
m[1]=new MovieIcon("img/martian.jpg","THE MARTIAN      ","4/5","https://www.hotstar.com/in/movies/the-martian/1770002321",16);
m[2]=new MovieIcon("img/inception.jpg","INCEPTION         ","4.4/5","https://www.primevideo.com/detail/Inception/0JTBVK6L41AABWSV8DK605AI0U",16);
m[3]=new MovieIcon("img/gravity.jpg","GRAVITY            ","3.85/5","https://www.primevideo.com/detail/Gravity/0GZ0O97SOB4VWFWCTVWY2LCZ56",16);
m[4]=new MovieIcon("img/prestige.jpg","THE PRESTIGE     ","4.25/5","https://www.netflix.com/title/70047095",16);
m[5]=new MovieIcon("img/arrival.jpg","ARRIVAL             ","4/5","https://www.netflix.com/title/80117799",16);
m[6]=new MovieIcon("img/predestin.jpg","PREDESTINATION ","3.25/5","https://www.primevideo.com/detail/0MF6JGXHHXF4HKD7531ZR4F152/ref=atv_sr_fle_c_Tn74RA__1_1_1?sr=1-1&pageTypeIdSource=ASIN&pageTypeId=B08MV1H5RY&qid=1621405640",16);
m[7]=new MovieIcon("img/source.jpg","SOURCE CODE     "," 3.75/5","https://www.primevideo.com/detail/0H7N38U2TT05RH54QE4CMK2QU6/ref=atv_sr_fle_c_Tn74RA__1_1_1?sr=1-1&pageTypeIdSource=ASIN&pageTypeId=B0924QDQMP&qid=1621408243",16);
m[8]=new MovieIcon("img/matrix.jpg","THE MATRIX        "," 4.35/5","https://www.netflix.com/title/20557937",16);
m[9]=new MovieIcon("img/wall.jpg","WALL E              "," 4.2/5","https://www.hotstar.com/in/movies/walle/1660010169",16);
for(int i=0; i<m.length; i++)
{
  e.add(m[i].panel);
}

GridLayout g1=new GridLayout(2,2);
e.setLayout(g1);
g1.setHgap(0);
g1.setVgap(0);

f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
f.add(e);   
f.setVisible(true);
a.setBounds(0,screenSize.height-120,95,30);      
f.setSize(screenSize.width, screenSize.height);
}
}
