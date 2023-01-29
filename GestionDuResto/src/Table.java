
public class Table {
	
	
	private int numTable;
	private boolean tabDispo;
	
	
	public int getNumTable() {
		return numTable;
	}

	public void setNumTable(int numTable) {
		this.numTable = numTable;
	}
	public boolean isTabDispo() {
		return tabDispo;
	}

	public void setTabDispo(boolean tabDispo) {
		this.tabDispo = tabDispo;
	}


	public Table(int num)
	{
		this.numTable=num;
		this.tabDispo=true;
	}
}
