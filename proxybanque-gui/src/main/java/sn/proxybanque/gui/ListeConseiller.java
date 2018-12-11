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

public class ListeConseiller extends JPanel {
	private JTable table;

	/**
	 * Create the panel.
	 */
	public ListeConseiller() {
		setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 685, 357);
		add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);

	}
}
