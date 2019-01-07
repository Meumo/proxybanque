package sn.proxybanque.modele;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;
import sn.proxybanque.domaine.Log;
import sn.proxybanque.domaine.Transaction;
import sn.proxybanque.service.ServiceAudit;
import sn.proxybanque.service.ServiceLog;

/*
 * la classe etudiantModel represente le model de stockage des donnees du tableau des etudiants
 */
public class LogModel extends AbstractTableModel {

	private ServiceAudit serviceAudit;
	private List<Log> listLog;
	private String[] entete = { "numeroTransaction", "montantTransaction", "dateTransaction", "typeTransaction", "numeroCompte","idConseiller"};
	public LogModel() {
		super();
		serviceAudit=new ServiceAudit();
		
		listLog = serviceAudit.listeTransactionNonRecommandee();
		
	}

	
	/*
	 * renvoit le nombre de colone du tableau
	 * 
	 * @see javax.swing.table.TableModel#getColumnCount()
	 */
	public int getColumnCount() {

		return entete.length;
	}

	
	/*
	 * renvoit le nombre de ligne du tableau
	 * 
	 * @see javax.swing.table.TableModel#getRowCount()
	 */
	public int getRowCount() {

		return listLog.size();
	}

	
	/*
	 * renvoit la valeur de la celule defini au indice rowIndex et columnIndex
	 * 
	 * @see javax.swing.table.TableModel#getValueAt(int, int)
	 */
	public Object getValueAt(int rowIndex, int columnIndex) {
		
		switch (columnIndex) {
		case 0:
             return listLog.get(rowIndex).getNumeroTransaction();
		case 1:
			return listLog.get(rowIndex).getMontantTransaction();
		case 2:
			return listLog.get(rowIndex).getDateTransaction();
		case 3:
			return listLog.get(rowIndex).getTypeTransaction();
		case 4:
			return listLog.get(rowIndex).getNumeroCompte();
		case 5:
			return listLog.get(rowIndex).getIdConseiller();
		default:
			 return null;	
			
		}
	}

	@Override
	/*
	 *renvoi le nom de la colone en fonction de l'indice
	 * @see javax.swing.table.AbstractTableModel#getColumnName(int)
	 */
	public String getColumnName(int column) {

		return entete[column];
	}
	
	public void removeEtudiant(int row) {
       
		listLog.remove(row);
		
		this.fireTableRowsDeleted(row, row);
	}
  public void addEtudiant(Log log) {
	 
	 listLog.add(log);
	  
	  this.fireTableRowsInserted(listLog.size()-1, listLog.size()-1);
  }
}
