package sn.proxybanque.gui;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import net.proteanit.sql.DbUtils;
import sn.proxybanque.utils.MysqlConnection;
import javax.swing.JButton;

public class ListeClient extends JPanel {
	private JTable table;

	/**
	 * Create the panel.
	 */
	public ListeClient() {
		setLayout(null);
		
		JPanel panelbable = new JPanel();
		panelbable.setBounds(0, 11, 745, 367);
		add(panelbable);
		panelbable.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 5, 735, 316);
		panelbable.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnConsulter = new JButton("Consulter ");
		btnConsulter.setBounds(51, 327, 130, 40);
		panelbable.add(btnConsulter);
		
		JButton btnModifier = new JButton("Modifier");
		btnModifier.setBounds(245, 327, 107, 40);
		panelbable.add(btnModifier);
		
		JButton btnSupprimer = new JButton("Supprimer");
		btnSupprimer.setBounds(404, 327, 130, 40);
		panelbable.add(btnSupprimer);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 389, 735, 106);
		add(panel);
		update();
	}
	
	public void update() {
		try {
			Connection con = MysqlConnection.getInstanceConnection();
			String sql = "SELECT * FROM client";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rs));
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
