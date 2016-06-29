package main_package;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

public class Fill_comboBox {
	Connection connection = null;
	Statement statement = null;
	
	public void updateTable(){
		try {
			Class.forName("org.postgresql.Driver");
			connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres",
					"postgres", "databazy2016");
			connection.setAutoCommit(false);
			System.out.println("Opened database successfully");
		} catch (Exception e) {
			System.err.println(e.getClass().getName()+": "+ e.getMessage());
			System.exit(0);
		}
		System.out.println("Operation done successfully");
	}
	
	public void fillComboBoxZviera(){
		try {
			statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("SELECT * FROM zviera;");
			ResultSetMetaData rsmeta = rs.getMetaData();
			int colCount = rsmeta.getColumnCount();
			while (rs.next()) {
				Main_screen.comboBox.addItem(rs.getString("id"));
				Main_screen.comboBox_1.addItem(rs.getString("id"));
			}
			for (int i=1; i<=colCount; i++){
				Main_screen.comboBox_2.addItem(rsmeta.getColumnLabel(i));
			}
			rs.close();
		} catch (Exception e) {
			System.err.println(e.getClass().getName()+": "+ e.getMessage());
			System.exit(0);
		}
		System.out.println("Operation done successfully");
	}
	
	public void fillComboBoxOsoba(){
		try {
			statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("SELECT * FROM osoba;");
			ResultSetMetaData rsmeta = rs.getMetaData();
			int colCount = rsmeta.getColumnCount();
			while (rs.next()) {
				Main_screen.comboBox_3.addItem(rs.getString("id"));
				Main_screen.comboBox_5.addItem(rs.getString("id"));
			}
			for (int i=1; i<=colCount; i++){
				Main_screen.comboBox_4.addItem(rsmeta.getColumnLabel(i));
			}
			rs.close();
		} catch (Exception e) {
			System.err.println(e.getClass().getName()+": "+ e.getMessage());
			System.exit(0);
		}
		System.out.println("Operation done successfully");
	}
	
	public void fillComboBoxObjednavka(){
		try {
			statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("SELECT * FROM objednavka;");
			ResultSetMetaData rsmeta = rs.getMetaData();
			int colCount = rsmeta.getColumnCount();
			while (rs.next()) {
				Main_screen.comboBox_6.addItem(rs.getString("id"));
				Main_screen.comboBox_8.addItem(rs.getString("id"));
			}
			for (int i=1; i<=colCount; i++){
				Main_screen.comboBox_7.addItem(rsmeta.getColumnLabel(i));
			}
			rs.close();
		} catch (Exception e) {
			System.err.println(e.getClass().getName()+": "+ e.getMessage());
			System.exit(0);
		}
		System.out.println("Operation done successfully");
	}
	
	public void fillComboBoxKontrola(){
		try {
			statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("SELECT * FROM kontrola_zvierata;");
			ResultSetMetaData rsmeta = rs.getMetaData();
			int colCount = rsmeta.getColumnCount();
			while (rs.next()) {
				Main_screen.comboBox_9.addItem(rs.getString("id"));
				Main_screen.comboBox_11.addItem(rs.getString("id"));
			}
			for (int i=1; i<=colCount; i++){
				Main_screen.comboBox_10.addItem(rsmeta.getColumnLabel(i));
			}
			rs.close();
		} catch (Exception e) {
			System.err.println(e.getClass().getName()+": "+ e.getMessage());
			System.exit(0);
		}
		System.out.println("Operation done successfully");
	}
	
	public void fillComboBoxKrmivo(){
		try {
			statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("SELECT * FROM krmivo;");
			ResultSetMetaData rsmeta = rs.getMetaData();
			int colCount = rsmeta.getColumnCount();
			while (rs.next()) {
				Main_screen.comboBox_12.addItem(rs.getString("id"));
				Main_screen.comboBox_14.addItem(rs.getString("id"));
			}
			for (int i=1; i<=colCount; i++){
				Main_screen.comboBox_13.addItem(rsmeta.getColumnLabel(i));
			}
			rs.close();
		} catch (Exception e) {
			System.err.println(e.getClass().getName()+": "+ e.getMessage());
			System.exit(0);
		}
		System.out.println("Operation done successfully");
	}
}
