package br.ifsp.livraria.utils;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JCheckBox;
/**
 * Criado para reutilizar código nos checkboxes
 * @author Raul
 *
 */
public class ActionCheckBoxes implements ActionListener {

	private static String SEPARATOR = " - ";
	private static StringBuilder stringBuilder; 
	
	@Override
	public void actionPerformed(ActionEvent event) {
		JCheckBox checkbox = (JCheckBox) event.getSource();
		String checkBoxText = checkbox.getText();
		if (stringBuilder == null) {
			stringBuilder = new StringBuilder();
		}
		if (checkbox.isSelected()) {
			stringBuilder.append(checkBoxText + SEPARATOR);
		}else {
			deleteString(checkBoxText);
		}
	}
	
	private void deleteString(String string) {
		int index = stringBuilder.indexOf(string);
		int endOfString = string.length() + index + SEPARATOR.length();
		stringBuilder.delete(index, endOfString);
	}
	
	
	public static StringBuilder getStringBuilder() {
		return stringBuilder;
	}
	

}
