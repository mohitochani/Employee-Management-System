import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
class DeleteFrame extends JFrame
{
  JPanel jp1,jp2;
  JButton delete,back;
  JLabel l1,l2;
  JTextField t1,t2;
  public DeleteFrame()
  {
	  super("Delete Employee");
	  setSize(500,150);
	  setResizable(false);
	  jp1=new JPanel();
	  jp1.setLayout(new FlowLayout(FlowLayout.CENTER,10,25));
	  delete=new JButton("Delete");
	  back=new JButton("Back");
	  l1=new JLabel("Id:");
	  //l2=new JLabel("Name:");
	  t1=new JTextField(5);
	  //t2=new JTextField(10);
	  jp1.add(l1);
	  jp1.add(t1);
	  //jp1.add(l2);
	  //jp1.add(t2);
	  add(jp1);
	  jp2=new JPanel();
	  jp2.setLayout(new FlowLayout(FlowLayout.CENTER,10,25));
	  jp2.add(delete);
	  jp2.add(back);
	  add(jp2,BorderLayout.SOUTH);
	  setLocationRelativeTo(null);
	  setVisible(true);
	  addWindowListener(new WindowAdapter(){
		  public void windowClosing(WindowEvent we){
			HomeFrame h=new HomeFrame();
            dispose();
		  }
	  });
      back.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent ae){
           HomeFrame a=new HomeFrame();
           dispose();
        }
      });
      delete.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent ae){
          String id=t1.getText();
          //String name=t2.getText();
          if(id.length()==0)
          {
			  //Sound.failure();
			  JOptionPane.showMessageDialog(new JDialog(),"All fields are mandatory");
			  return;
          }
	 try{
	int i=Integer.parseInt(id);
	  /*boolean x=true;	
          DatabaseHandler s=new DatabaseHandler();
	  x=s.dbchecker(i);
	if(x==false)
	{	
		
		JOptionPane.showMessageDialog(new JDialog(),"Id Not Found");
		return;
	}*/
			
	

	DatabaseHandler d=new DatabaseHandler();
	d.delete(i);
	} 	
	  catch(Exception e)
	  {
		  Sound.failure();
			  JOptionPane.showMessageDialog(new JDialog(),"Please enter integer");
			  return;
          
	 
		}
		 
	t1.setText("");
          //t2.setText("");
		}
	  });	
  }	  
}