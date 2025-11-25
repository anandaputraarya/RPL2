package com.lily.report;

import java.sql.Connection;
import java.sql.DriverManager;

import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

public class CetakLaporan {

    public static void main(String[] args) {
        try {
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/db_kampus",
                    "root",
                    ""
            );

            String path = "src/main/resources/laporan_mahasiswa.jrxml";

            JasperReport report = JasperCompileManager.compileReport(path);
            JasperPrint print = JasperFillManager.fillReport(report, null, conn);
            JasperViewer.viewReport(print, false);

            System.out.println("Laporan berhasil ditampilkan!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
