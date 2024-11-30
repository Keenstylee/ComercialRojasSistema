/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package components;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.JLabel;

/**
 *
 * @author intel
 */
public class TableButtonCellRenderer extends DefaultTableCellRenderer {
    // Sobrescribe el método getTableCellRendererComponent para personalizar la apariencia de las celdas de botones en una JTable
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {      
        // Establece el fondo de la celda como amarillo claro (Color RGB: 255, 200, 0)
        this.setBackground(new Color(255, 200, 0));
        // Establece la fuente del texto de la celda como "Segoe UI" con negrita y tamaño 12
        this.setFont(new java.awt.Font("Segoe UI", 1, 12));
        // Establece el cursor del ratón como el cursor de mano cuando pasa sobre la celda
        this.setCursor(new Cursor(12));
        // Establece el texto de la celda con el valor proporcionado (debe ser un objeto String en este caso)
        this.setText((String) value);
        // Establece la alineación del texto en el centro de la celda
        this.setHorizontalAlignment(JLabel.CENTER);
        
        // Devuelve la celda personalizada como un componente para que se muestre en la tabla
        return this;
    }
}
