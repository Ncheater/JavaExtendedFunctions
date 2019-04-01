package com.jxf.model;

import java.util.List;
import javax.swing.table.AbstractTableModel;

@SuppressWarnings("serial")
public class TableModel extends AbstractTableModel {

	private List<Object> data;
	private String[] columns;

	public TableModel(List<Object> data, String[] columns) {
		this.data = data;
		this.columns = columns;
	}

	@Override
	public String getColumnName(int columns) {
		return this.columns[columns];
	}

	@Override
	public int getColumnCount() {
		return this.columns.length;
	}

	@Override
	public int getRowCount() {
		if (data == null) {
			return 0;
		} else {
			return this.data.size();
		}
	}

	@Override
	public Object getValueAt(int row, int column) {
		if (this.data.get(row) != null) {
			Object item = this.data.get(row);
			return item;
		} else {
			return null;
		}
	}

}
