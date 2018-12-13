package sn.proxybanque.gui;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JPanel;

import sn.proxybanque.utils.MysqlConnection;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import net.proteanit.sql.DbUtils;
import javax.swing.table.DefaultTableModel;

public class ListeClient extends JPanel {
	private JTable table;

	/**
	 * Create the panel.
	 */
	public ListeClient() {
		setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 11, 745, 453);
		add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
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
