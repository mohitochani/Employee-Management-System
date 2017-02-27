import java.sql.*;
import javax.swing.*;
import java.util.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;



class DatabaseHandler
{
	static Connection con;
	public static void getConnection()
	{
		
		try{
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","mohit1234");
		}
		catch( Exception e)
		{
			JOptionPane.showMessageDialog(new JDialog(),""+e);
			
		}
		
	}	
	
	public void insert(int id,String name)
	{
		
		try{
			getConnection();
			String q="insert into employee values(?,?)";
			PreparedStatement pst=con.prepareStatement(q);
			pst.setInt(1,id);
			pst.setString(2,name);
			pst.executeUpdate();
			pst.close();
			Sound.success();
			JOptionPane.showMessageDialog(new JDialog()," 1 Record added");
			
		}
		catch(Exception e)
		{
			Sound.failure();
			JOptionPane.showMessageDialog(new JDialog(),"Record Already Exists");
			
			
		}
	}
	
	public String query()
	{
    StringBuffer sb=new StringBuffer();		
		try{
			getConnection();
			String q="select * from employee order by id";
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(q);
			
			sb.append("ID: "+"\t"+"NAME: "+"\n");
			while(rs.next())
			{
				sb.append(rs.getString(1)+"\t"+rs.getString(2)+"\n");
			}
			rs.close();
			
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(new JDialog()," "+e);
		}
			return sb.toString();
	}
	

	public void modify(int id,String name)
	{
		int flag=0;
		try{
			
			getConnection();
			if(Character.isDigit(id))
			JOptionPane.showMessageDialog(new JDialog(),"Please Enter an Integer ");
			
			
  			String r="select * from employee order by id";
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(r);
			while(rs.next())
			{
				if(id==Integer.parseInt(rs.getString(1)))
				{
				flag=1;
				break;
				}
			}
			if(flag==0)
			{
                                Sound.failure();
				JOptionPane.showMessageDialog(new JDialog(),"No Record Found");
				rs.close();
			
			}
			
			String q="update employee set name=? where id=?";
			PreparedStatement pst=con.prepareStatement(q);
			pst.setString(1,name);
			pst.setInt(2,id);
			pst.executeUpdate();
			pst.close();
			if(flag!=0){
			Sound.success();
			JOptionPane.showMessageDialog(new JDialog(),"Record modified");
			}
		}
		catch(Exception e)
		{
			Sound.failure();
			JOptionPane.showMessageDialog(new JDialog()," "+e);
		}
	}
	
	public void delete(int id)
	{
		int flag=0;
		StringBuffer sb=new StringBuffer();
		try{
			getConnection();
			
  			String r="select * from employee order by id";
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(r);
			while(rs.next())
			{
				if(id==Integer.parseInt(rs.getString(1)))
				{
				flag=1;
				break;
				}
			}
			if(flag==0)
			{
                                Sound.failure();
				JOptionPane.showMessageDialog(new JDialog(),"No Record Found");
				rs.close();
			
			}
			

			String q="delete from employee where id=?";
			PreparedStatement pst=con.prepareStatement(q);
			pst.setInt(1,id);
			//pst.setString(2,name);
			pst.executeUpdate();
			pst.close();	
			if(flag!=0){
			Sound.success();
			JOptionPane.showMessageDialog(new JDialog(),"Record deleted");
			}
			return;
			
		}
		catch(Exception e)
		{
			Sound.failure();
			JOptionPane.showMessageDialog(new JDialog()," "+e);
		}
	}
	
/*public boolean dbchecker(int id)
{
	StringBuffer sb = new StringBuffer();
	try
	{
	getConnection();
	String q="select * from employees";
	Statement st=con.createStatement();
	ResultSet rs=st.executeQuery(q);
	while(rs.next())
	{	
		sb.append(rs.getString(1)+"\n");
	}	
	rs.close();
	} // end of try
	catch (Exception e)
	{
	JOptionPane.showMessageDialog(new JDialog()," "+ e);
	}// end of catch
	String str=sb.toString();
	if(str.contains(Integer.toString(id)))
		return true;
	else
		return false;
}*/	 
	
}












