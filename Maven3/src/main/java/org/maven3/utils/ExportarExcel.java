/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.maven3.utils;

import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JTable;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

public class ExportarExcel {

    public void exportarExcel(JTable table) throws IOException {
        JFileChooser fileChooser = createFileChooser();
        if (fileChooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            String ruta = selectedFile.toString().concat(".xls");

            Workbook workbook = createWorkbook(table);
            writeWorkbookToFile(workbook, ruta);

            openFileInDefaultApplication(selectedFile);
        }
    }

    private JFileChooser createFileChooser() {
        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivos de excel", "xls");
        chooser.setFileFilter(filter);
        chooser.setDialogTitle("Guardar archivo");
        chooser.setAcceptAllFileFilterUsed(false);
        return chooser;
    }

    private Workbook createWorkbook(JTable table) {
        Workbook workbook = new HSSFWorkbook();
        Sheet sheet = workbook.createSheet("Mi hoja de trabajo 1");
        sheet.setDisplayGridlines(true);

        createHeaderRow(sheet, table);
        fillDataRows(sheet, table);

        return workbook;
    }

    private void createHeaderRow(Sheet sheet, JTable table) {
        Row headerRow = sheet.createRow(0);
        for (int columnIndex = 0; columnIndex < table.getColumnCount(); columnIndex++) {
            Cell cell = headerRow.createCell(columnIndex);
            cell.setCellValue(table.getColumnName(columnIndex));
        }
    }

    private void fillDataRows(Sheet sheet, JTable table) {
        for (int rowIndex = 0; rowIndex < table.getRowCount(); rowIndex++) {
            Row dataRow = sheet.createRow(rowIndex + 1);
            for (int columnIndex = 0; columnIndex < table.getColumnCount(); columnIndex++) {
                Cell cell = dataRow.createCell(columnIndex);
                setCellValue(cell, table.getValueAt(rowIndex, columnIndex));
            }
        }
    }

    private void setCellValue(Cell cell, Object value) {
        if (value instanceof Double) {
            cell.setCellValue((Double) value);
        } else if (value instanceof Float) {
            cell.setCellValue((Float) value);
        } else {
            cell.setCellValue(String.valueOf(value));
        }
    }

    private void writeWorkbookToFile(Workbook workbook, String filePath) throws IOException {
        try (FileOutputStream fileOutputStream = new FileOutputStream(filePath)) {
            workbook.write(fileOutputStream);
        }
    }

    private void openFileInDefaultApplication(File file) throws IOException {
        Desktop.getDesktop().open(file);
    }

}
