import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class HomeFrame extends JFrame{
JPanel jp;
JButton add,modify,delete,view;

public HomeFrame(){
super("Employee Records Management");
setSize(500,150);
setResizable(false);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

jp=new JPanel();
jp.setLayout(new FlowLayout(FlowLayout.CENTER,10,25));

add=new JButton("Add");
modify=new JButton("Modify");
delete=new JButton("Delete");
view=new JButton("View");

jp.add(add);
jp.add(modify);
jp.add(delete);
jp.add(view);

add(jp);


setLocationRelativeTo(null);
setVisible(true);


add.addActionListener(new ActionListener(){
public void actionPerformed(ActionEvent ae){
AddFrame a=new AddFrame();
dispose();
}});

modify.addActionListener(new ActionListener(){
public void actionPerformed(ActionEvent ae){
ModifyFrame m=new ModifyFrame();
dispose();
}});

delete.addActionListener(new ActionListener(){
public void actionPerformed(ActionEvent ae){
DeleteFrame d=new DeleteFrame();
dispose();
}});

view.addActionListener(new ActionListener(){
public void actionPerformed(ActionEvent ae){
ViewFrame v=new ViewFrame();
dispose();
}});

}
public static void main(String args[])
{
HomeFrame h=new HomeFrame();
h.addWindowListener(new WindowAdapter(){
public void WindowClosing(WindowEvent e){
int output=JOptionPane.showConfirmDialog(new JDialog(),"Do you want to Exit");
if(output==JOptionPane.YES_OPTION){
output=JOptionPane.showConfirmDialog(new JDialog(),"Are you sure?");
if(output==JOptionPane.YES_OPTION)
System.exit(1);
}}});

}}
/*
class DatabaseHandler{
static Connection con;

public static void getConnection(){
try{
Class.forName("oracle.jdbc.driver.OracleDriver");
con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","mohit1234");
}
catch(Exception e){
JOptionPane.showMessageDialog(new JDialog()," "+e);
}}

public void insert(int id,String name)
{
try{
getConnection();

String q="insert into employee values(?,?)";
PreparedStatement pst=con.prepareStatement(q);
pst.setInt(1,id);
pst.setString(2,name);

int i=pst.executeUpdate();

//Sound.success();
JOptionPane.showMessageDialog(new JDialog(),"1 Record Added");
}
catch(Exception e){
JOptionPane.showMessageDialog(new JDialog(),"Record Already Exits");
}}

public String query(){
StringBuffer sb=new StringBuffer();

try{
getConnection();
String q="select * from employee order by id";
Statement st=con.createStatement();
ResultSet rs=st.executeQuery(q);
sb.append("ID:"+"\t"+"NAME:"+"\n");
while(rs.next()){
sb.append(rs.getString(1)+"\t"+rs.getString(2)+"\n");
}
rs.close();
}
catch(Exception e){
JOptionPane.showMessageDialog(new JDialog()," "+e);
}
return sb.toString();
}
}
*/
