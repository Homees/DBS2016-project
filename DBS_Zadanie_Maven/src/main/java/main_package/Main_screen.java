package main_package;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JList;
import javax.swing.JRadioButton;

public class Main_screen {
	
	Fill_comboBox naplnCB = new Fill_comboBox();
	Maven_database maven = new Maven_database();
        ArrayList<String> string_list = new ArrayList<>();
	Connection connection = null;
	Statement statement = null;
	static JComboBox comboBox, comboBox_1, comboBox_2, comboBox_3, comboBox_4, comboBox_5, comboBox_13, comboBox_14;
	static JComboBox comboBox_6, comboBox_7, comboBox_8, comboBox_9, comboBox_10, comboBox_11, comboBox_12;
	String[] columnNamesZviera = {"ID", "rasa", "plemeno", "vek", "stav", "meno", "ID objednavky", "ID kontroly", 
			"cena",	"pre rodinu?"};
	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTable table, table_1;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	private JTextField textField_13;
	private JTextField textField_14;
	private JTextField textField_15;
	private JTextField textField_16;
	private JTextField textField_17;
	private JTextField textField_18;
	private JTextField textField_19;
	private JTable table_2;
	private JTable table_3;
	private JTextField textField_20;
	private JTextField textField_21;
	private JTextField textField_22;
	private JTextField textField_23;
	private JTextField textField_24;
	private JTextField textField_25;
	private JTable table_4;
	private JTable table_5;
	private JTextField textField_26;
	private JTextField textField_27;
	private JTextField textField_28;
	private JTextField textField_29;
	private JTextField textField_30;
	private JTextField textField_31;
	private JTable table_6;
	private JTable table_7;
	private JTextField textField_32;
	private JTextField textField_33;
	private JTextField textField_34;
	private JTextField textField_35;
	private JTextField textField_36;
	private JTextField textField_37;
	private JTable table_8;
	private JTable table_9;
	private JTextField textField_38;
	private JTable table_10;
	private JTable table_11;
	private JTable table_12;
	private JTable table_13;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main_screen window = new Main_screen();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Main_screen() throws IOException, Exception {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() throws IOException, Exception {
		frame = new JFrame();
		frame.setBounds(100, 100, 679, 516);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 661, 469);
		frame.getContentPane().add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Zviera", null, panel, null);
		panel.setLayout(null);
		
		JTabbedPane tabbedPane_1 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_1.setBounds(0, 0, 656, 439);
		panel.add(tabbedPane_1);
		
		JPanel panel_5 = new JPanel();
		tabbedPane_1.addTab("Pridanie", null, panel_5, null);
		panel_5.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(47, 75, 116, 22);
		panel_5.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(252, 75, 116, 22);
		panel_5.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(439, 75, 116, 22);
		panel_5.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(47, 158, 116, 22);
		panel_5.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(252, 158, 116, 22);
		panel_5.add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(439, 158, 116, 22);
		panel_5.add(textField_5);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setBounds(47, 246, 116, 22);
		panel_5.add(textField_6);
		textField_6.setColumns(10);
		
		textField_7 = new JTextField();
		textField_7.setBounds(252, 246, 116, 22);
		panel_5.add(textField_7);
		textField_7.setColumns(10);
		
		textField_8 = new JTextField();
		textField_8.setBounds(439, 246, 116, 22);
		panel_5.add(textField_8);
		textField_8.setColumns(10);
		
		JButton btnPridajNoveZviera = new JButton("Pridaj zaznam");
		btnPridajNoveZviera.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
                                    statement = connection.createStatement();
                                    String sql = "insert into zviera (rasa, plemeno, vek, stav, meno, id_objednavky, id_kontroly, "
							+ "cena, rodinne) VALUES ('"+textField.getText()+"', '"+textField_1.getText()+"', '"+
							textField_2.getText()+"', '"+textField_3.getText()+"', '"+textField_4.getText()+"', '"+
							textField_5.getText()+"', '"+textField_6.getText()+"', '"+textField_7.getText()+"', '"+
							textField_8.getText()+"');";
			        statement.executeUpdate(sql);
			        connection.commit();
				} catch (Exception e1) {
					System.err.println(e1.getClass().getName()+": "+ e1.getMessage());
					System.exit(0);
				}
				System.out.println("Operation done successfully");
			}
		});
		btnPridajNoveZviera.setBounds(407, 325, 148, 38);
		panel_5.add(btnPridajNoveZviera);
		
		JLabel lblRasa = new JLabel("Rasa");
		lblRasa.setBounds(78, 46, 56, 16);
		panel_5.add(lblRasa);
		
		JLabel lblPlemeno = new JLabel("Plemeno");
		lblPlemeno.setBounds(283, 46, 56, 16);
		panel_5.add(lblPlemeno);
		
		JLabel lblVek = new JLabel("Vek");
		lblVek.setBounds(474, 46, 56, 16);
		panel_5.add(lblVek);
		
		JLabel lblStav = new JLabel("Stav");
		lblStav.setBounds(78, 129, 56, 16);
		panel_5.add(lblStav);
		
		JLabel lblMeno = new JLabel("Meno");
		lblMeno.setBounds(283, 129, 56, 16);
		panel_5.add(lblMeno);
		
		JLabel lblIdObjednavky = new JLabel("ID objednavky");
		lblIdObjednavky.setBounds(456, 129, 109, 16);
		panel_5.add(lblIdObjednavky);
		
		JLabel lblIdKontroly = new JLabel("ID kontroly");
		lblIdKontroly.setBounds(78, 217, 97, 16);
		panel_5.add(lblIdKontroly);
		
		JLabel lblCena = new JLabel("Cena");
		lblCena.setBounds(283, 217, 56, 16);
		panel_5.add(lblCena);
		
		JLabel lblPreRodinu = new JLabel("Pre rodinu?");
		lblPreRodinu.setBounds(464, 217, 91, 16);
		panel_5.add(lblPreRodinu);
		
		JPanel panel_6 = new JPanel();
		tabbedPane_1.addTab("Vymazanie", null, panel_6, null);
		panel_6.setLayout(null);
		
		comboBox = new JComboBox();
		comboBox.setBounds(450, 52, 155, 22);
		panel_6.add(comboBox);
		
		JButton btnVymazanieZaznamu = new JButton("Vymazanie zaznamu");
		btnVymazanieZaznamu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					statement = connection.createStatement();
			        String sql = "DELETE from zviera where ID="+comboBox.getSelectedItem()+";";
			        statement.executeUpdate(sql);
			        connection.commit();
			        
			        ResultSet rs = statement.executeQuery("SELECT * FROM zviera;");
			        table.setModel(buildTableModel(rs));
			        table.setVisible(true);
			        rs.close();
				} catch (Exception e1) {
					System.err.println(e1.getClass().getName()+": "+ e1.getMessage());
					System.exit(0);
				}
				System.out.println("Operation done successfully");
			}
		});
		btnVymazanieZaznamu.setBounds(450, 325, 162, 34);
		panel_6.add(btnVymazanieZaznamu);
		
		JPanel panel_25 = new JPanel();
		panel_25.setBounds(12, 13, 426, 383);
		panel_6.add(panel_25);
		panel_25.setLayout(null);
		
		table = new JTable();
		table.setBounds(0, 0, 426, 383);
		panel_25.add(table);
		
		JPanel panel_7 = new JPanel();
		tabbedPane_1.addTab("Aktualizacia", null, panel_7, null);
		panel_7.setLayout(null);
		
		table_1 = new JTable();
		table_1.setBounds(31, 24, 370, 361);
		panel_7.add(table_1);
		
		comboBox_1 = new JComboBox();
		comboBox_1.setBounds(441, 54, 177, 22);
		panel_7.add(comboBox_1);
		
		comboBox_2 = new JComboBox();
		comboBox_2.setBounds(441, 127, 177, 22);
		panel_7.add(comboBox_2);
		
		textField_9 = new JTextField();
		textField_9.setBounds(441, 223, 177, 22);
		panel_7.add(textField_9);
		textField_9.setColumns(10);
		
		JButton btnAktualizaciaZaznamu = new JButton("Aktualizacia zaznamu");
		btnAktualizaciaZaznamu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					statement = connection.createStatement();
			        String sql = "update zviera set "+comboBox_2.getSelectedItem()+" = '"+textField_9.getText()+
			        		"'where ID="+comboBox_1.getSelectedItem()+";";
			        statement.executeUpdate(sql);
			        connection.commit();
			        
			        ResultSet rs = statement.executeQuery("SELECT * FROM zviera;");
			        table_1.setModel(buildTableModel(rs));
			        table_1.setVisible(true);
			        rs.close();
				} catch (Exception e1) {
					System.err.println(e1.getClass().getName()+": "+ e1.getMessage());
					System.exit(0);
				}
				System.out.println("Operation done successfully");
			}
		});
		btnAktualizaciaZaznamu.setBounds(459, 319, 159, 36);
		panel_7.add(btnAktualizaciaZaznamu);
		
		JLabel lblIdStlpca = new JLabel("ID zaznamu");
		lblIdStlpca.setBounds(499, 23, 86, 16);
		panel_7.add(lblIdStlpca);
		
		JLabel lblMenoStlpca = new JLabel("meno stlpca");
		lblMenoStlpca.setBounds(499, 98, 102, 16);
		panel_7.add(lblMenoStlpca);
		
		JLabel lblHodnota = new JLabel("hodnota");
		lblHodnota.setBounds(499, 194, 56, 16);
		panel_7.add(lblHodnota);
		
		JPanel panel_8 = new JPanel();
		tabbedPane_1.addTab("Vyber", null, panel_8, null);
		panel_8.setLayout(null);
		
		JPanel panel_34 = new JPanel();
		panel_34.setBounds(24, 13, 599, 178);
		panel_8.add(panel_34);
		panel_34.setLayout(null);
		
		table_10 = new JTable();
		table_10.setBounds(0, 0, 599, 178);
		panel_34.add(table_10);
		
		JRadioButton rb1 = new JRadioButton("Vypisanie zvierat, ktore boli objednane zakaznikom za "
				+ "posledne 4 mesiace a meno a kontakt daneho zakaznika");
		rb1.setToolTipText("Vypisanie zvierat, ktore boli objednane zakaznikom za posledne 4 "
				+ "mesiace a meno a kontakt daneho zakaznika");
		rb1.setBounds(24, 221, 530, 25);
		panel_8.add(rb1);
		
		JRadioButton rb2 = new JRadioButton("Vypisanie mena zvierata a datum kontroly kedy bolo u "
				+ "zverolekara a meno lekara");
		rb2.setToolTipText("Vypisanie mena zvierata a datum kontroly kedy bolo u zverolekara a meno lekara");
		rb2.setBounds(24, 263, 530, 25);
		panel_8.add(rb2);
		
		JButton btnVyber_2 = new JButton("Vyber");
		btnVyber_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					statement = connection.createStatement();
					if (rb1.isSelected()){
						ResultSet rs = statement.executeQuery("select p.meno, p.kontakt, o.datum, z.meno, z.plemeno from "
								+ "zviera as z join objednavka as o on z.id=o.id_zvierata join osoba as p "
								+ "on o.id=p.id_objednavky where o.datum>'2016-01-01' and o.datum<'2016-04-30'");
						table_10.setModel(buildTableModel(rs));
				        table_10.setVisible(true);
						rs.close();
					}
					if(rb2.isSelected()){
						ResultSet rs = statement.executeQuery("select z.meno, p.meno, p.priezvisko, k.datum "
								+ "from zviera as z join kontrola_zvierata as k on z.id=k.id_zvierata join "
								+ "osoba as p on k.id=p.id_kontroly where p.typ_osoby=2 "
								+ "group by p.meno, z.meno, p.priezvisko, k.datum");
						table_10.setModel(buildTableModel(rs));
				        table_10.setVisible(true);
						rs.close();
					}
				} catch (Exception e1) {
					System.err.println(e1.getClass().getName()+": "+ e1.getMessage());
					System.exit(0);
				}
			}
		});
		btnVyber_2.setBounds(463, 338, 127, 35);
		panel_8.add(btnVyber_2);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Osoba", null, panel_1, null);
		panel_1.setLayout(null);
		
		JTabbedPane tabbedPane_2 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_2.setBounds(0, 0, 656, 439);
		panel_1.add(tabbedPane_2);
		
		JPanel panel_9 = new JPanel();
		tabbedPane_2.addTab("Pridanie", null, panel_9, null);
		panel_9.setLayout(null);
		
		textField_10 = new JTextField();
		textField_10.setBounds(65, 58, 116, 22);
		panel_9.add(textField_10);
		textField_10.setColumns(10);
		
		textField_11 = new JTextField();
		textField_11.setBounds(261, 58, 116, 22);
		panel_9.add(textField_11);
		textField_11.setColumns(10);
		
		textField_12 = new JTextField();
		textField_12.setBounds(452, 58, 116, 22);
		panel_9.add(textField_12);
		textField_12.setColumns(10);
		
		textField_13 = new JTextField();
		textField_13.setBounds(65, 140, 116, 22);
		panel_9.add(textField_13);
		textField_13.setColumns(10);
		
		textField_14 = new JTextField();
		textField_14.setBounds(261, 140, 116, 22);
		panel_9.add(textField_14);
		textField_14.setColumns(10);
		
		textField_15 = new JTextField();
		textField_15.setBounds(452, 140, 116, 22);
		panel_9.add(textField_15);
		textField_15.setColumns(10);
		
		textField_16 = new JTextField();
		textField_16.setBounds(65, 224, 116, 22);
		panel_9.add(textField_16);
		textField_16.setColumns(10);
		
		textField_17 = new JTextField();
		textField_17.setBounds(261, 224, 116, 22);
		panel_9.add(textField_17);
		textField_17.setColumns(10);
		
		textField_18 = new JTextField();
		textField_18.setBounds(452, 224, 116, 22);
		panel_9.add(textField_18);
		textField_18.setColumns(10);
		
		textField_19 = new JTextField();
		textField_19.setBounds(65, 298, 116, 22);
		panel_9.add(textField_19);
		textField_19.setColumns(10);
		
		JLabel lblMeno_1 = new JLabel("Meno");
		lblMeno_1.setBounds(90, 29, 56, 16);
		panel_9.add(lblMeno_1);
		
		JLabel lblPriezvisko = new JLabel("Priezvisko");
		lblPriezvisko.setBounds(292, 29, 56, 16);
		panel_9.add(lblPriezvisko);
		
		JLabel lblAdresa = new JLabel("Adresa");
		lblAdresa.setBounds(484, 29, 56, 16);
		panel_9.add(lblAdresa);
		
		JLabel lblVek_1 = new JLabel("Vek");
		lblVek_1.setBounds(100, 111, 56, 16);
		panel_9.add(lblVek_1);
		
		JLabel lblNewLabel = new JLabel("Pozicia");
		lblNewLabel.setBounds(292, 111, 56, 16);
		panel_9.add(lblNewLabel);
		
		JLabel lblPlat = new JLabel("Plat");
		lblPlat.setBounds(498, 111, 56, 16);
		panel_9.add(lblPlat);
		
		JLabel lblTypOsoby = new JLabel("Typ osoby");
		lblTypOsoby.setBounds(90, 195, 91, 16);
		panel_9.add(lblTypOsoby);
		
		JLabel lblKontakt = new JLabel("Kontakt");
		lblKontakt.setBounds(292, 195, 56, 16);
		panel_9.add(lblKontakt);
		
		JLabel lblIdObjednavky_1 = new JLabel("ID objednavky");
		lblIdObjednavky_1.setBounds(470, 195, 84, 16);
		panel_9.add(lblIdObjednavky_1);
		
		JLabel lblIdKontoly = new JLabel("ID kontoly");
		lblIdKontoly.setBounds(90, 269, 56, 16);
		panel_9.add(lblIdKontoly);
		
		JButton btnPridanieZaznamu = new JButton("Pridanie zaznamu");
		btnPridanieZaznamu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					statement = connection.createStatement();
			        String sql = "insert into osoba (meno, priezvisko, adresa, vek, pozicia, plat, typ_osoby, "
							+ "kontakt, id_objednavky, id_kontroly) values ('"+textField_10.getText()+"', '"+
			        		textField_11.getText()+"', '"+textField_12.getText()+"', '"+textField_13.getText()+"', '"+
							textField_14.getText()+"', '"+textField_15.getText()+"', '"+textField_16.getText()+"', '"+
			        		textField_17.getText()+"', '"+textField_18.getText()+"', '"+textField_19.getText()+"');";
			        statement.executeUpdate(sql);
			        connection.commit();
				} catch (Exception e1) {
					System.err.println(e1.getClass().getName()+": "+ e1.getMessage());
					System.exit(0);
				}
				System.out.println("Operation done successfully");
			}
		});
		btnPridanieZaznamu.setBounds(390, 315, 150, 38);
		panel_9.add(btnPridanieZaznamu);
		
		JPanel panel_10 = new JPanel();
		tabbedPane_2.addTab("Vymazanie", null, panel_10, null);
		panel_10.setLayout(null);
		
		JPanel panel_26 = new JPanel();
		panel_26.setBounds(25, 25, 418, 371);
		panel_10.add(panel_26);
		panel_26.setLayout(null);
		
		table_2 = new JTable();
		table_2.setBounds(0, 0, 418, 371);
		panel_26.add(table_2);
		
		comboBox_3 = new JComboBox();
		comboBox_3.setBounds(455, 78, 173, 22);
		panel_10.add(comboBox_3);
		
		JLabel lblIdZaznamu = new JLabel("ID zaznamu");
		lblIdZaznamu.setBounds(500, 49, 101, 16);
		panel_10.add(lblIdZaznamu);
		
		JButton btnZmazanieZaznamu = new JButton("Zmazanie zaznamu");
		btnZmazanieZaznamu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					statement = connection.createStatement();
			        String sql = "DELETE from osoba where ID="+comboBox_3.getSelectedItem()+";";
			        statement.executeUpdate(sql);
			        connection.commit();
			        
			        ResultSet rs = statement.executeQuery("SELECT * FROM osoba;");
			        table_2.setModel(buildTableModel(rs));
			        table_2.setVisible(true);
			        rs.close();
				} catch (Exception e1) {
					System.err.println(e1.getClass().getName()+": "+ e1.getMessage());
					System.exit(0);
				}
				System.out.println("Operation done successfully");
			}
		});
		btnZmazanieZaznamu.setBounds(467, 327, 161, 44);
		panel_10.add(btnZmazanieZaznamu);
		
		JPanel panel_11 = new JPanel();
		tabbedPane_2.addTab("Aktualizacia", null, panel_11, null);
		panel_11.setLayout(null);
		
		JPanel panel_27 = new JPanel();
		panel_27.setBounds(28, 28, 411, 352);
		panel_11.add(panel_27);
		panel_27.setLayout(null);
		
		table_3 = new JTable();
		table_3.setBounds(0, 0, 411, 352);
		panel_27.add(table_3);
		
		comboBox_4 = new JComboBox();
		comboBox_4.setBounds(465, 79, 161, 22);
		panel_11.add(comboBox_4);
		
		comboBox_5 = new JComboBox();
		comboBox_5.setBounds(465, 165, 161, 22);
		panel_11.add(comboBox_5);
		
		textField_20 = new JTextField();
		textField_20.setBounds(465, 246, 161, 22);
		panel_11.add(textField_20);
		textField_20.setColumns(10);
		
		JLabel lblNazovStlpca = new JLabel("Nazov stlpca");
		lblNazovStlpca.setBounds(507, 50, 98, 16);
		panel_11.add(lblNazovStlpca);
		
		JLabel lblIdZaznamu_1 = new JLabel("ID zaznamu");
		lblIdZaznamu_1.setBounds(507, 136, 98, 16);
		panel_11.add(lblIdZaznamu_1);
		
		JLabel lblHodnota_1 = new JLabel("Hodnota");
		lblHodnota_1.setBounds(507, 217, 56, 16);
		panel_11.add(lblHodnota_1);
		
		JButton btnAktualizaciaZaznamu_1 = new JButton("Aktualizacia zaznamu");
		btnAktualizaciaZaznamu_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					statement = connection.createStatement();
			        String sql = "update osoba set "+comboBox_4.getSelectedItem()+" = '"+textField_20.getText()+
			        		"'where ID="+comboBox_5.getSelectedItem()+";";
			        statement.executeUpdate(sql);
			        connection.commit();
			        
			        ResultSet rs = statement.executeQuery("SELECT * FROM osoba;");
			        table_3.setModel(buildTableModel(rs));
			        table_3.setVisible(true);
			        rs.close();
				} catch (Exception e1) {
					System.err.println(e1.getClass().getName()+": "+ e1.getMessage());
					System.exit(0);
				}
				System.out.println("Operation done successfully");
			}
		});
		btnAktualizaciaZaznamu_1.setBounds(465, 322, 161, 38);
		panel_11.add(btnAktualizaciaZaznamu_1);
		
		JPanel panel_12 = new JPanel();
		tabbedPane_2.addTab("Vyber", null, panel_12, null);
		panel_12.setLayout(null);
		
		JPanel panel_35 = new JPanel();
		panel_35.setBounds(28, 29, 589, 168);
		panel_12.add(panel_35);
		panel_35.setLayout(null);
		
		table_11 = new JTable();
		table_11.setBounds(0, 0, 589, 168);
		panel_35.add(table_11);
		
		JRadioButton rb3 = new JRadioButton("Meno, adresa, kontakt a pocet zakaznikov, ktori si objednali psa starsieho ako rok");
		rb3.setToolTipText("Meno, adresa, kontakt a pocet zakaznikov, ktori si objednali psa starsieho ako rok");
		rb3.setBounds(28, 224, 530, 25);
		panel_12.add(rb3);
		
		JRadioButton rb4 = new JRadioButton("Pracovnik, ktory ako posledny nakupil krmivo pre zvierata, datum objenavky a suma hmotnosti krmiva");
		rb4.setToolTipText("Pracovnik, ktory ako posledny nakupil krmivo pre zvierata, datum objenavky a suma hmotnosti krmiva");
		rb4.setBounds(28, 254, 530, 25);
		panel_12.add(rb4);
		
		JRadioButton rb5 = new JRadioButton("Pocet objednavok psov manazerom chovatelskej stanice a meno manazera");
		rb5.setToolTipText("Pocet objednavok psov manazerom chovatelskej stanice a meno manazera");
		rb5.setBounds(28, 284, 530, 25);
		panel_12.add(rb5);
		
		JButton btnVyber_1 = new JButton("Vyber");
		btnVyber_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {					
					statement = connection.createStatement();
					if (rb3.isSelected()){
						ResultSet rs = statement.executeQuery("select p.meno, p.adresa, p.kontakt, count(p.id) "
								+ "from osoba as p join objednavka as o on p.id=o.id_osoby join zviera as z "
								+ "on o.id=z.id_objednavky where z.rasa='pes' and z.vek>1 and p.typ_osoby=3 "
								+ "group by p.meno, p.adresa, p.kontakt");
						table_11.setModel(buildTableModel(rs));
				        table_11.setVisible(true);
						rs.close();
					}
					if (rb4.isSelected()){
						ResultSet rs = statement.executeQuery("select p.meno, p.priezvisko, max(o.datum), "
								+ "sum(k.hmotnost) from osoba as p join objednavka as o on p.id=o.id_osoby "
								+ "join krmivo as k on o.id=k.id_objednavky group by p.meno, p.priezvisko "
								+ "order by max(o.datum) desc limit 1");
						table_11.setModel(buildTableModel(rs));
				        table_11.setVisible(true);
						rs.close();
					}
					if (rb5.isSelected()){
						ResultSet rs = statement.executeQuery("select sum(o.id), p.meno, p.priezvisko from osoba as p "
								+ "join objednavka as o on p.id=o.id_osoby join zviera as z on o.id=z.id_objednavky "
								+ "where p.pozicia='manazer' and z.rasa='pes' and p.typ_osoby=1 group by p.meno, p.priezvisko");
						table_11.setModel(buildTableModel(rs));
				        table_11.setVisible(true);
						rs.close();
					}
				} catch (Exception e2) {
					System.err.println(e2.getClass().getName()+": "+ e2.getMessage());
					System.exit(0);
				}
			}
		});
		btnVyber_1.setBounds(460, 334, 127, 38);
		panel_12.add(btnVyber_1);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Objednávka", null, panel_2, null);
		panel_2.setLayout(null);
		
		JTabbedPane tabbedPane_3 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_3.setBounds(0, 0, 656, 439);
		panel_2.add(tabbedPane_3);
		
		JPanel panel_13 = new JPanel();
		tabbedPane_3.addTab("Pridanie", null, panel_13, null);
		panel_13.setLayout(null);
		
		textField_21 = new JTextField();
		textField_21.setBounds(52, 72, 116, 22);
		panel_13.add(textField_21);
		textField_21.setColumns(10);
		
		textField_22 = new JTextField();
		textField_22.setBounds(245, 72, 116, 22);
		panel_13.add(textField_22);
		textField_22.setColumns(10);
		
		textField_23 = new JTextField();
		textField_23.setBounds(442, 72, 116, 22);
		panel_13.add(textField_23);
		textField_23.setColumns(10);
		
		textField_24 = new JTextField();
		textField_24.setBounds(52, 157, 116, 22);
		panel_13.add(textField_24);
		textField_24.setColumns(10);
		
		textField_25 = new JTextField();
		textField_25.setBounds(245, 157, 116, 22);
		panel_13.add(textField_25);
		textField_25.setColumns(10);
		
		JLabel lblDatum = new JLabel("Datum");
		lblDatum.setBounds(77, 43, 56, 16);
		panel_13.add(lblDatum);
		
		JLabel lblTypObjenavky = new JLabel("Typ objenavky");
		lblTypObjenavky.setBounds(261, 43, 88, 16);
		panel_13.add(lblTypObjenavky);
		
		JLabel lblIdOsoby = new JLabel("ID osoby");
		lblIdOsoby.setBounds(474, 43, 56, 16);
		panel_13.add(lblIdOsoby);
		
		JLabel lblIdKrmiva = new JLabel("ID krmiva");
		lblIdKrmiva.setBounds(77, 128, 56, 16);
		panel_13.add(lblIdKrmiva);
		
		JLabel lblIdZvierata = new JLabel("ID zvierata");
		lblIdZvierata.setBounds(273, 128, 88, 16);
		panel_13.add(lblIdZvierata);
		
		JButton btnPridanieZaznamu_1 = new JButton("Pridanie zaznamu");
		btnPridanieZaznamu_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					statement = connection.createStatement();
			        String sql = "insert into objednavka (datum, objednal, id_osoby, id_krmiva, id_zvierata) "
			        		+ "values ('"+textField_21.getText()+"', '"+textField_22.getText()+"', '"+
			        		textField_23.getText()+"', '"+textField_24.getText()+"', '"+textField_25.getText()+"');";
			        statement.executeUpdate(sql);
			        connection.commit();
				} catch (Exception e1) {
					System.err.println(e1.getClass().getName()+": "+ e1.getMessage());
					System.exit(0);
				}
				System.out.println("Operation done successfully");
			}
		});
		btnPridanieZaznamu_1.setBounds(421, 311, 144, 35);
		panel_13.add(btnPridanieZaznamu_1);
		
		JPanel panel_14 = new JPanel();
		tabbedPane_3.addTab("Vymazanie", null, panel_14, null);
		panel_14.setLayout(null);
		
		JPanel panel_28 = new JPanel();
		panel_28.setBounds(29, 26, 391, 359);
		panel_14.add(panel_28);
		panel_28.setLayout(null);
		
		table_4 = new JTable();
		table_4.setBounds(0, 0, 391, 359);
		panel_28.add(table_4);
		
		comboBox_6 = new JComboBox();
		comboBox_6.setBounds(443, 73, 183, 22);
		panel_14.add(comboBox_6);
		
		JLabel lblIdZaznamu_2 = new JLabel("ID zaznamu");
		lblIdZaznamu_2.setBounds(492, 44, 99, 16);
		panel_14.add(lblIdZaznamu_2);
		
		JButton btnVymazanieZaznamu_1 = new JButton("Vymazanie zaznamu");
		btnVymazanieZaznamu_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					statement = connection.createStatement();
			        String sql = "DELETE from objednavka where ID="+comboBox_6.getSelectedItem()+";";
			        statement.executeUpdate(sql);
			        connection.commit();
			        
			        ResultSet rs = statement.executeQuery("SELECT * FROM objednavka;");
			        table_4.setModel(buildTableModel(rs));
			        table_4.setVisible(true);
			        rs.close();
				} catch (Exception e1) {
					System.err.println(e1.getClass().getName()+": "+ e1.getMessage());
					System.exit(0);
				}
				System.out.println("Operation done successfully");
			}
		});
		btnVymazanieZaznamu_1.setBounds(461, 327, 149, 34);
		panel_14.add(btnVymazanieZaznamu_1);
		
		JPanel panel_15 = new JPanel();
		tabbedPane_3.addTab("Aktualizacia", null, panel_15, null);
		panel_15.setLayout(null);
		
		JPanel panel_29 = new JPanel();
		panel_29.setBounds(32, 32, 384, 352);
		panel_15.add(panel_29);
		panel_29.setLayout(null);
		
		table_5 = new JTable();
		table_5.setBounds(0, 0, 384, 352);
		panel_29.add(table_5);
		
		comboBox_7 = new JComboBox();
		comboBox_7.setBounds(436, 69, 188, 22);
		panel_15.add(comboBox_7);
		
		comboBox_8 = new JComboBox();
		comboBox_8.setBounds(436, 154, 188, 22);
		panel_15.add(comboBox_8);
		
		textField_26 = new JTextField();
		textField_26.setBounds(436, 242, 188, 22);
		panel_15.add(textField_26);
		textField_26.setColumns(10);
		
		JLabel lblNazovStlpca_1 = new JLabel("Nazov stlpca");
		lblNazovStlpca_1.setBounds(485, 40, 111, 16);
		panel_15.add(lblNazovStlpca_1);
		
		JLabel lblIdZaznamu_3 = new JLabel("ID zaznamu");
		lblIdZaznamu_3.setBounds(485, 125, 111, 16);
		panel_15.add(lblIdZaznamu_3);
		
		JLabel lblHodnota_2 = new JLabel("Hodnota");
		lblHodnota_2.setBounds(497, 213, 56, 16);
		panel_15.add(lblHodnota_2);
		
		JButton btnAktualizovanieZaznamu = new JButton("Aktualizovanie zaznamu");
		btnAktualizovanieZaznamu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					statement = connection.createStatement();
			        String sql = "update objednavka set "+comboBox_7.getSelectedItem()+" = '"+textField_26.getText()+
			        		"'where ID="+comboBox_8.getSelectedItem()+";";
			        statement.executeUpdate(sql);
			        connection.commit();
			        
			        ResultSet rs = statement.executeQuery("SELECT * FROM objednavka;");
			        table_5.setModel(buildTableModel(rs));
			        table_5.setVisible(true);
			        rs.close();
				} catch (Exception e1) {
					System.err.println(e1.getClass().getName()+": "+ e1.getMessage());
					System.exit(0);
				}
				System.out.println("Operation done successfully");
			}
		});
		btnAktualizovanieZaznamu.setBounds(436, 328, 177, 38);
		panel_15.add(btnAktualizovanieZaznamu);
		
		JPanel panel_16 = new JPanel();
		tabbedPane_3.addTab("Vyber", null, panel_16, null);
		panel_16.setLayout(null);
		
		JPanel panel_36 = new JPanel();
		panel_36.setBounds(32, 36, 580, 174);
		panel_16.add(panel_36);
		panel_36.setLayout(null);
		
		table_12 = new JTable();
		table_12.setBounds(0, 0, 580, 174);
		panel_36.add(table_12);
		
		JRadioButton rb6 = new JRadioButton("Objednavky zvierat, ktore vhodne pre rodinu a ich priemerna cena");
		rb6.setToolTipText("Objednavky zvierat, ktore vhodne pre rodinu a ich priemerna cena");
		rb6.setBounds(32, 240, 530, 25);
		panel_16.add(rb6);
		
		JRadioButton rb7 = new JRadioButton("Objednavky krmiva, ktore su pre macky a ich hmotnosti je vacsia ako priemerna");
		rb7.setToolTipText("Objednavky krmiva, ktore su pre macky a ich hmotnosti je vacsia ako priemerna");
		rb7.setBounds(32, 284, 530, 25);
		panel_16.add(rb7);
		
		JButton btnVyber = new JButton("Vyber");
		btnVyber.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {					
					statement = connection.createStatement();
					if(rb6.isSelected()){
						ResultSet rs = statement.executeQuery("select o.id, z.meno, z.rasa, (select avg(cena) "
								+ "from zviera where rodinne='true') from objednavka as o join zviera as z on "
								+ "o.id=z.id_objednavky where rodinne='true' "
								+ "group by o.id, z.meno, z.rasa");
						table_12.setModel(buildTableModel(rs));
				        table_12.setVisible(true);
						rs.close();
					}
					if(rb7.isSelected()){
						ResultSet rs = statement.executeQuery("select o.id, k.nazov, k.hmotnost from objednavka as o "
								+ "join krmivo as k on o.id=k.id_objednavky where k.hmotnost >= (select avg(k.hmotnost) "
								+ "from krmivo as k where k.typ='krmivo pre macky') group by o.id, k.nazov, k.hmotnost order by k.hmotnost desc");
						table_12.setModel(buildTableModel(rs));
				        table_12.setVisible(true);
						rs.close();
					}
				} catch (Exception e2) {
					System.err.println(e2.getClass().getName()+": "+ e2.getMessage());
					System.exit(0);
				}
			}
		});
		btnVyber.setBounds(449, 340, 127, 38);
		panel_16.add(btnVyber);
		
		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("Kontrola zverolekárom", null, panel_3, null);
		panel_3.setLayout(null);
		
		JTabbedPane tabbedPane_4 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_4.setBounds(0, 0, 656, 439);
		panel_3.add(tabbedPane_4);
		
		JPanel panel_17 = new JPanel();
		tabbedPane_4.addTab("Pridanie", null, panel_17, null);
		panel_17.setLayout(null);
		
		textField_27 = new JTextField();
		textField_27.setBounds(53, 66, 116, 22);
		panel_17.add(textField_27);
		textField_27.setColumns(10);
		
		textField_28 = new JTextField();
		textField_28.setBounds(244, 66, 116, 22);
		panel_17.add(textField_28);
		textField_28.setColumns(10);
		
		textField_29 = new JTextField();
		textField_29.setBounds(436, 66, 116, 22);
		panel_17.add(textField_29);
		textField_29.setColumns(10);
		
		textField_30 = new JTextField();
		textField_30.setBounds(53, 160, 116, 22);
		panel_17.add(textField_30);
		textField_30.setColumns(10);
		
		textField_31 = new JTextField();
		textField_31.setBounds(244, 160, 116, 22);
		panel_17.add(textField_31);
		textField_31.setColumns(10);
		
		JLabel lblIdLekara = new JLabel("ID lekara");
		lblIdLekara.setBounds(83, 37, 56, 16);
		panel_17.add(lblIdLekara);
		
		JLabel lblIdZvierata_1 = new JLabel("ID zvierata");
		lblIdZvierata_1.setBounds(278, 37, 82, 16);
		panel_17.add(lblIdZvierata_1);
		
		JLabel lblLieky = new JLabel("Lieky");
		lblLieky.setBounds(471, 37, 56, 16);
		panel_17.add(lblLieky);
		
		JLabel lblLiecba = new JLabel("Liecba");
		lblLiecba.setBounds(83, 131, 56, 16);
		panel_17.add(lblLiecba);
		
		JLabel lblDatum_1 = new JLabel("Datum");
		lblDatum_1.setBounds(278, 131, 56, 16);
		panel_17.add(lblDatum_1);
		
		JButton btnPridanieZaznamu_2 = new JButton("Pridanie zaznamu");
		btnPridanieZaznamu_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					statement = connection.createStatement();
			        String sql = "insert into kontrola_zvierata (id_lekara, id_zvierata, lieky, liecba, datum) "
			        		+ "values ('"+textField_27.getText()+"', '"+textField_28.getText()+"', '"+
			        		textField_29.getText()+"', '"+textField_30.getText()+"', '"+textField_31.getText()+"');";
			        statement.executeUpdate(sql);
			        connection.commit();
				} catch (Exception e1) {
					System.err.println(e1.getClass().getName()+": "+ e1.getMessage());
					System.exit(0);
				}
				System.out.println("Operation done successfully");
			}
		});
		btnPridanieZaznamu_2.setBounds(399, 297, 152, 37);
		panel_17.add(btnPridanieZaznamu_2);
		
		JPanel panel_18 = new JPanel();
		tabbedPane_4.addTab("Vymazanie", null, panel_18, null);
		panel_18.setLayout(null);
		
		JPanel panel_30 = new JPanel();
		panel_30.setBounds(39, 35, 362, 335);
		panel_18.add(panel_30);
		panel_30.setLayout(null);
		
		table_6 = new JTable();
		table_6.setBounds(0, 0, 362, 335);
		panel_30.add(table_6);
		
		comboBox_9 = new JComboBox();
		comboBox_9.setBounds(434, 90, 183, 22);
		panel_18.add(comboBox_9);
		
		JLabel lblIdZaznamu_4 = new JLabel("ID zaznamu");
		lblIdZaznamu_4.setBounds(489, 61, 56, 16);
		panel_18.add(lblIdZaznamu_4);
		
		JButton btnZmazanieZaznamu_1 = new JButton("Zmazanie zaznamu");
		btnZmazanieZaznamu_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					statement = connection.createStatement();
			        String sql = "DELETE from kontrola_zvierata where ID="+comboBox_9.getSelectedItem()+";";
			        statement.executeUpdate(sql);
			        connection.commit();
			        
			        ResultSet rs = statement.executeQuery("SELECT * FROM kontrola_zvierata;");
			        table_6.setModel(buildTableModel(rs));
			        table_6.setVisible(true);
			        rs.close();
				} catch (Exception e1) {
					System.err.println(e1.getClass().getName()+": "+ e1.getMessage());
					System.exit(0);
				}
				System.out.println("Operation done successfully");
			}
		});
		btnZmazanieZaznamu_1.setBounds(450, 322, 152, 36);
		panel_18.add(btnZmazanieZaznamu_1);
		
		JPanel panel_19 = new JPanel();
		tabbedPane_4.addTab("Aktualizacia", null, panel_19, null);
		panel_19.setLayout(null);
		
		JPanel panel_31 = new JPanel();
		panel_31.setBounds(38, 35, 377, 344);
		panel_19.add(panel_31);
		panel_31.setLayout(null);
		
		table_7 = new JTable();
		table_7.setBounds(0, 0, 377, 344);
		panel_31.add(table_7);
		
		comboBox_10 = new JComboBox();
		comboBox_10.setBounds(442, 83, 178, 22);
		panel_19.add(comboBox_10);
		
		comboBox_11 = new JComboBox();
		comboBox_11.setBounds(442, 170, 178, 22);
		panel_19.add(comboBox_11);
		
		textField_32 = new JTextField();
		textField_32.setBounds(442, 250, 178, 22);
		panel_19.add(textField_32);
		textField_32.setColumns(10);
		
		JLabel lblNazovStlpca_2 = new JLabel("Nazov stlpca");
		lblNazovStlpca_2.setBounds(496, 54, 98, 16);
		panel_19.add(lblNazovStlpca_2);
		
		JLabel lblIdZaznamu_5 = new JLabel("ID zaznamu");
		lblIdZaznamu_5.setBounds(496, 141, 98, 16);
		panel_19.add(lblIdZaznamu_5);
		
		JLabel lblHodnota_3 = new JLabel("Hodnota");
		lblHodnota_3.setBounds(503, 220, 56, 16);
		panel_19.add(lblHodnota_3);
		
		JButton btnAktualizovanieZaznamu_1 = new JButton("Aktualizovanie zaznamu");
		btnAktualizovanieZaznamu_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					statement = connection.createStatement();
			        String sql = "update kontrola_zvierata set "+comboBox_10.getSelectedItem()+" = '"+
			        		textField_32.getText()+"'where ID="+comboBox_11.getSelectedItem()+";";
			        statement.executeUpdate(sql);
			        connection.commit();
			        
			        ResultSet rs = statement.executeQuery("SELECT * FROM kontrola_zvierata;");
			        table_7.setModel(buildTableModel(rs));
			        table_7.setVisible(true);
			        rs.close();
				} catch (Exception e1) {
					System.err.println(e1.getClass().getName()+": "+ e1.getMessage());
					System.exit(0);
				}
				System.out.println("Operation done successfully");
			}
		});
		btnAktualizovanieZaznamu_1.setBounds(442, 321, 178, 37);
		panel_19.add(btnAktualizovanieZaznamu_1);
		
		JPanel panel_4 = new JPanel();
		tabbedPane.addTab("Krmivo", null, panel_4, null);
		panel_4.setLayout(null);
		
		JTabbedPane tabbedPane_5 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_5.setBounds(0, 0, 656, 439);
		panel_4.add(tabbedPane_5);
		
		JPanel panel_21 = new JPanel();
		tabbedPane_5.addTab("Pridanie", null, panel_21, null);
		panel_21.setLayout(null);
		
		textField_33 = new JTextField();
		textField_33.setBounds(47, 57, 116, 22);
		panel_21.add(textField_33);
		textField_33.setColumns(10);
		
		textField_34 = new JTextField();
		textField_34.setBounds(230, 57, 116, 22);
		panel_21.add(textField_34);
		textField_34.setColumns(10);
		
		textField_35 = new JTextField();
		textField_35.setBounds(416, 57, 116, 22);
		panel_21.add(textField_35);
		textField_35.setColumns(10);
		
		textField_36 = new JTextField();
		textField_36.setBounds(47, 139, 116, 22);
		panel_21.add(textField_36);
		textField_36.setColumns(10);
		
		textField_37 = new JTextField();
		textField_37.setBounds(230, 139, 116, 22);
		panel_21.add(textField_37);
		textField_37.setColumns(10);
		
		JLabel lblNazov = new JLabel("Nazov");
		lblNazov.setBounds(76, 28, 56, 16);
		panel_21.add(lblNazov);
		
		JLabel lblHmotnost = new JLabel("Hmotnost");
		lblHmotnost.setBounds(255, 28, 56, 16);
		panel_21.add(lblHmotnost);
		
		JLabel lblTypKrmiva = new JLabel("Typ krmiva");
		lblTypKrmiva.setBounds(450, 28, 82, 16);
		panel_21.add(lblTypKrmiva);
		
		JLabel lblIdObjednavky_2 = new JLabel("ID objednavky");
		lblIdObjednavky_2.setBounds(60, 110, 87, 16);
		panel_21.add(lblIdObjednavky_2);
		
		JLabel label = new JLabel("Zlozenie krmiva");
		label.setBounds(255, 110, 56, 16);
		panel_21.add(label);
		
		JButton btnVytvorenieZaznamu = new JButton("Vytvorenie zaznamu");
		btnVytvorenieZaznamu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					statement = connection.createStatement();
			        String sql = "insert into krmivo (nazov, hmotnost, typ, id_objednavky) VALUES ('"+
			        		textField_33.getText()+"', '"+textField_34.getText()+"', '"+
			        		textField_35.getText()+"', '"+textField_36.getText()+"');";
			        statement.executeUpdate(sql);
			        connection.commit();
				} catch (Exception e1) {
					System.err.println(e1.getClass().getName()+": "+ e1.getMessage());
					System.exit(0);
				}
				System.out.println("Operation done successfully");
			}
		});
		btnVytvorenieZaznamu.setBounds(419, 306, 157, 38);
		panel_21.add(btnVytvorenieZaznamu);
		
		JPanel panel_22 = new JPanel();
		tabbedPane_5.addTab("Vymazanie", null, panel_22, null);
		panel_22.setLayout(null);
		
		JPanel panel_32 = new JPanel();
		panel_32.setBounds(45, 34, 372, 344);
		panel_22.add(panel_32);
		panel_32.setLayout(null);
		
		table_8 = new JTable();
		table_8.setBounds(0, 0, 372, 344);
		panel_32.add(table_8);
		
		comboBox_12 = new JComboBox();
		comboBox_12.setBounds(442, 87, 173, 22);
		panel_22.add(comboBox_12);
		
		JLabel lblIdZaznamu_6 = new JLabel("ID zaznamu");
		lblIdZaznamu_6.setBounds(489, 58, 95, 16);
		panel_22.add(lblIdZaznamu_6);
		
		JButton btnZmazanieZaznamu_2 = new JButton("Zmazanie zaznamu");
		btnZmazanieZaznamu_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					statement = connection.createStatement();
			        String sql = "DELETE from krmivo where ID="+comboBox_12.getSelectedItem()+";";
			        statement.executeUpdate(sql);
			        connection.commit();
			        
			        ResultSet rs = statement.executeQuery("SELECT * FROM krmivo;");
			        table_8.setModel(buildTableModel(rs));
			        table_8.setVisible(true);
			        rs.close();
				} catch (Exception e1) {
					System.err.println(e1.getClass().getName()+": "+ e1.getMessage());
					System.exit(0);
				}
				System.out.println("Operation done successfully");
			}
		});
		btnZmazanieZaznamu_2.setBounds(456, 303, 159, 39);
		panel_22.add(btnZmazanieZaznamu_2);
		
		JPanel panel_23 = new JPanel();
		tabbedPane_5.addTab("Aktualizacia", null, panel_23, null);
		panel_23.setLayout(null);
		
		JPanel panel_33 = new JPanel();
		panel_33.setBounds(37, 27, 398, 358);
		panel_23.add(panel_33);
		panel_33.setLayout(null);
		
		table_9 = new JTable();
		table_9.setBounds(0, 0, 398, 358);
		panel_33.add(table_9);
		
		comboBox_13 = new JComboBox();
		comboBox_13.setBounds(461, 62, 162, 22);
		panel_23.add(comboBox_13);
		
		comboBox_14 = new JComboBox();
		comboBox_14.setBounds(461, 151, 162, 22);
		panel_23.add(comboBox_14);
		
		textField_38 = new JTextField();
		textField_38.setBounds(461, 237, 162, 22);
		panel_23.add(textField_38);
		textField_38.setColumns(10);
		
		JLabel lblNazovStlpca_3 = new JLabel("Nazov stlpca");
		lblNazovStlpca_3.setBounds(504, 33, 92, 16);
		panel_23.add(lblNazovStlpca_3);
		
		JLabel lblIdZaznamu_7 = new JLabel("ID zaznamu");
		lblIdZaznamu_7.setBounds(504, 122, 92, 16);
		panel_23.add(lblIdZaznamu_7);
		
		JLabel lblHodnota_4 = new JLabel("Hodnota");
		lblHodnota_4.setBounds(512, 208, 56, 16);
		panel_23.add(lblHodnota_4);
		
		JButton btnAktualizaciaZaznamu_2 = new JButton("Aktualizacia zaznamu");
		btnAktualizaciaZaznamu_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					statement = connection.createStatement();
			        String sql = "update krmivo set "+comboBox_13.getSelectedItem()+" = '"+textField_38.getText()+
			        		"'where ID="+comboBox_14.getSelectedItem()+";";
			        statement.executeUpdate(sql);
			        connection.commit();
			        
			        ResultSet rs = statement.executeQuery("SELECT * FROM krmivo;");
			        table_9.setModel(buildTableModel(rs));
			        table_9.setVisible(true);
			        rs.close();
				} catch (Exception e1) {
					System.err.println(e1.getClass().getName()+": "+ e1.getMessage());
					System.exit(0);
				}
				System.out.println("Operation done successfully");
			}
		});
		btnAktualizaciaZaznamu_2.setBounds(461, 324, 162, 36);
		panel_23.add(btnAktualizaciaZaznamu_2);
                
                JPanel panel_24 = new JPanel();
		tabbedPane.addTab("ElasticSearch vyhladavanie", null, panel_24, null);
		panel_24.setLayout(null);
                
                JPanel panel_37 = new JPanel();
		panel_37.setBounds(32, 36, 580, 174);
		panel_24.add(panel_37);
		panel_37.setLayout(null);
		
		table_13 = new JTable();
		table_13.setBounds(0, 0, 580, 174);
		panel_37.add(table_13);
		
		JRadioButton rb8 = new JRadioButton("Zoznam krmiv s nazvom pedigri s hmotnostou od 20kg do 80kg a ich priemerna hmotnost");
		rb8.setToolTipText("Zoznam krmiv s nazvom pedigri s hmotnostou od 20kg do 80kg a ich priemerna hmotnost");
		rb8.setBounds(32, 240, 530, 25);
		panel_24.add(rb8);
		
		JButton btnElastic = new JButton("Vyber");
		btnElastic.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                            try {					
                                statement = connection.createStatement();
                                if(rb8.isSelected()){
                                    maven.maven_connect();
                                }
                            } catch (Exception e2) {
                                System.err.println(e2.getClass().getName()+": "+ e2.getMessage());
                                System.exit(0);
                            }
			}
		});
		btnElastic.setBounds(449, 340, 127, 38);
		panel_24.add(btnElastic);
		
		updateTable();
		naplnCB.updateTable();
		naplnCB.fillComboBoxZviera();
		naplnCB.fillComboBoxOsoba();
		naplnCB.fillComboBoxObjednavka();
		naplnCB.fillComboBoxKontrola();
		naplnCB.fillComboBoxKrmivo();
	}
	
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
	
	public static DefaultTableModel buildTableModel(ResultSet rs) throws SQLException {

	    ResultSetMetaData metaData = rs.getMetaData();

	    // names of columns
	    Vector<String> columnNames = new Vector<String>();
	    int columnCount = metaData.getColumnCount();
	    for (int column = 1; column <= columnCount; column++) {
	        columnNames.add(metaData.getColumnName(column));
	    }

	    // data of the table
	    Vector<Vector<Object>> data = new Vector<Vector<Object>>();
	    while (rs.next()) {
	        Vector<Object> vector = new Vector<Object>();
	        for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
	            vector.add(rs.getObject(columnIndex));
	        }
	        data.add(vector);
	    }

	    return new DefaultTableModel(data, columnNames);

	}
}
