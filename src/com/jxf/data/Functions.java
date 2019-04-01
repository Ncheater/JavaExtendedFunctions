package com.jxf.data;

import java.util.List;
import javax.swing.JTextField;

import com.jxf.model.TableModel;

public class Functions {
	public void setSizeLimit(JTextField tf) {
		String subs;
		int size = Math.round(tf.getWidth() / 8);
		if (tf.getText().length() == size) {
			subs = tf.getText().substring(0, size - 1);
			tf.setText(subs);
		}
	}

	public void setSizeLimit(JTextField tf, int size) {
		String subs;
		if (tf.getText().length() == size) {
			subs = tf.getText().substring(0, size - 1);
			tf.setText(subs);
		}
	}

	public TableModel tableFormat(List<Object> obj, String[] columns) {
		TableModel model = new TableModel(obj, columns);
		return model;
	}

	public boolean hasEmptyFields(List<JTextField> fields) {
		for (int i = 0; i < fields.size(); i++) {
			if (fields.get(i).getText().equals("")) {
				return true;
			}
		}
		return false;
	}

	@SuppressWarnings("null")
	public Object[] validateFields(List<JTextField> fields) {
		int invalidFieldsCount = 0;
		List<String> invalidFieldsName = null;
		for (int i = 0; i < fields.size(); i++) {
			if (fields.get(i).getText().equals("")) {
				invalidFieldsCount++;
				invalidFieldsName.add(fields.get(i).getName());
			}
		}
		Object[] data = { invalidFieldsCount, invalidFieldsName };
		return data;
	}

	@SuppressWarnings("null")
	public Object[] validateFields(List<JTextField> fields, int size) {
		int invalidFieldsCount = 0;
		List<String> invalidFieldsName = null;
		for (int i = 0; i < fields.size(); i++) {
			if (fields.get(i).getText().equals("") || fields.get(i).getText().length() > size) {
				invalidFieldsCount++;
				invalidFieldsName.add(fields.get(i).getName());
			}
		}
		Object[] data = { invalidFieldsCount, invalidFieldsName };
		return data;
	}

	@SuppressWarnings("null")
	public Object[] validateFields(List<JTextField> fields, CharSequence characters) {
		int invalidFieldsCount = 0;
		List<String> invalidFieldsName = null;
		for (int i = 0; i < fields.size(); i++) {
			if (fields.get(i).getText().equals("") || fields.get(i).getText().contains(characters)) {
				invalidFieldsCount++;
				invalidFieldsName.add(fields.get(i).getName());
			}
		}
		Object[] data = { invalidFieldsCount, invalidFieldsName };
		return data;
	}

	@SuppressWarnings("null")
	public Object[] validateFields(List<JTextField> fields, CharSequence characters, int size) {
		int invalidFieldsCount = 0;
		List<String> invalidFieldsName = null;
		for (int i = 0; i < fields.size(); i++) {
			if (fields.get(i).getText().equals("") || fields.get(i).getText().contains(characters)
					|| fields.get(i).getText().length() > size) {
				invalidFieldsCount++;
				invalidFieldsName.add(fields.get(i).getName());
			}
		}
		Object[] data = { invalidFieldsCount, invalidFieldsName };
		return data;
	}
}
