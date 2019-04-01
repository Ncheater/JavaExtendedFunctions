package com.jxf.sql;

import java.sql.*;
import java.util.Vector;

import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Functions {
	public static DefaultTableModel fill(ResultSet rs) throws SQLException {
		ResultSetMetaData metaData = rs.getMetaData();
		int count = metaData.getColumnCount();

		Vector<String> names = new Vector<>();
		for (int i = 1; i <= count; i++) {
			names.add(metaData.getColumnName(i));
		}

		Vector<Vector<Object>> data = new Vector<>();
		while (rs.next()) {
			Vector<Object> vector = new Vector<>();
			for (int i = 1; i <= count; i++) {
				vector.add(rs.getObject(i));
			}
			data.add(vector);
		}

		return new DefaultTableModel(data, names);
	}

	public static void fetchItems(JComboBox<String> cb, ResultSet rs) throws SQLException {
		while (rs.next()) {
			cb.addItem(rs.getString(6));
			for (int i = 0; i < cb.getItemCount(); i++) {
				for (int x = i + 1; x < cb.getItemCount(); x++) {
					if (cb.getItemAt(i).equals(cb.getItemAt(x))) {

						cb.removeItemAt(x);
					}
				}
			}
		}
	}
	
	public void reset(ResultSet rs, JTable table) throws SQLException {
        table.setModel(com.jxf.sql.Functions.fill(rs));
	}
}
