package student;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.Vector;
import java.awt.event.*;


public class Info extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	  public Info()
	    {
	        ArrayList columnNames = new ArrayList();
	        ArrayList data = new ArrayList();

	        //  Connect to an MySQL Database, run query, get result set
	        String sql = "SELECT * FROM stu_info";
	        try 
	        {
	        	Class.forName("com.mysql.jdbc.Driver");
	    		  Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3308/stu", "root", "root1" );
	            Statement stmt = connection.createStatement();
	            ResultSet rs = stmt.executeQuery( sql );
	            ResultSetMetaData md = rs.getMetaData();
	            int columns = md.getColumnCount();

	            //  Get column names
	            for (int i = 1; i <= columns; i++)
	            {
	                columnNames.add( md.getColumnName(i) );
	            }

	            //  Get row data
	            while (rs.next())
	            {
	                ArrayList row = new ArrayList(columns);

	                for (int i = 1; i <= columns; i++)
	                {
	                    row.add( rs.getObject(i) );
	                }

	                data.add( row );
	            }
	        }
	        catch (Exception e)
	        {
	            System.out.println( e.getMessage() );
	        }
	        Vector columnNamesVector = new Vector();
	        Vector dataVector = new Vector();

	        for (int i = 0; i < data.size(); i++)
	        {
	            ArrayList subArray = (ArrayList)data.get(i);
	            Vector subVector = new Vector();
	            for (int j = 0; j < subArray.size(); j++)
	            {
	                subVector.add(subArray.get(j));
	            }
	            dataVector.add(subVector);
	        }

	        for (int i = 0; i < columnNames.size(); i++ )
	            columnNamesVector.add(columnNames.get(i));

	        //  Create table with database data    
	        JTable table = new JTable(dataVector, columnNamesVector)
	        {
	            public Class getColumnClass(int column)
	            {
	                for (int row = 0; row < getRowCount(); row++)
	                {
	                    Object o = getValueAt(row, column);

	                    if (o != null)
	                    {
	                        return o.getClass();
	                    }
	                }

	                return Object.class;
	            }
	        };

	        JScrollPane scrollPane = new JScrollPane( table );
	        getContentPane().add( scrollPane );

	        JPanel buttonPanel = new JPanel();
	        getContentPane().add( buttonPanel, BorderLayout.SOUTH );
	    }
	  public static void NewScreen()
	    {
		  Info frame = new Info();
	        frame.setDefaultCloseOperation( EXIT_ON_CLOSE );
	        frame.pack();
	        frame.setVisible(true);
	    }
	}