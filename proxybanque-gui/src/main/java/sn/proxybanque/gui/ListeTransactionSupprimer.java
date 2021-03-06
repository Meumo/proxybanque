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

public class ListeTransactionSupprimer extends JPanel {
	private JTable table;

	/**
	 * Create the panel.
	 */
	public ListeTransactionSupprimer() {
		setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 954, 361);
		add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		update();
	}
	
	public void update() { 
		try {
			Connection con = MysqlConnection.getInstanceConnection();
			String sql = "select * from log  where NOT EXISTS (select numeroTransaction from transaction)";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rs));
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
