package sn.proxybanque.gui;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import net.proteanit.sql.DbUtils;
import sn.proxybanque.modele.LogModel;
import sn.proxybanque.utils.MysqlConnection;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

public class ListeDesTransactionAnormal extends JPanel {
	private JTable table;

	/**
	 * Create the panel.
	 */
	public ListeDesTransactionAnormal() {
		setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 37, 954, 307);
		add(scrollPane);
		LogModel  logModel=new LogModel();
		table = new JTable(logModel);
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel = new JLabel("Liste Des Transaction Anormal");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 19));
		lblNewLabel.setBounds(0, 0, 954, 37);
		add(lblNewLabel);
	}
	
}
