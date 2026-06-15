package com.mycompany.gui.dashboard;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class DashboardPanel extends JPanel {

    public DashboardPanel() {
        initComponents();
    }

    private void initComponents() {
        setLayout(new BorderLayout(10, 10));
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // --- TITLE ---
        JLabel titleLabel = new JLabel("Dashboard / Laporan Histori");
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 18));
        add(titleLabel, BorderLayout.NORTH);

        // --- CENTER CONTENT (CARDS + TABLE + CHART) ---
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));

        // 1. CARDS
        JPanel cardsPanel = new JPanel(new GridLayout(1, 4, 10, 0));
        cardsPanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 100));
        cardsPanel.add(createCard("Terlambat Hari Ini", "12"));
        cardsPanel.add(createCard("Izin Keluar Hari Ini", "5"));
        cardsPanel.add(createCard("Menunggu ACC", "3"));
        cardsPanel.add(createCard("Total Riwayat", "128"));
        
        centerPanel.add(cardsPanel);
        centerPanel.add(Box.createVerticalStrut(20));

        // 2. CHART & TABLE CONTAINER
        JPanel bottomPanel = new JPanel(new GridLayout(1, 2, 20, 0));
        
        // --- TABLE (DUMMY DATA) ---
        JPanel tableContainer = new JPanel(new BorderLayout());
        tableContainer.setBorder(BorderFactory.createTitledBorder("Aktivitas Terbaru"));
        
        String[] columns = {"Inisial", "Nama", "Kelas", "Keterangan", "Status", "Tanggal"};
        Object[][] data = {
            {"WA", "Wardah Ayu", "XI-J", "Mengambil ktp", "Disetujui", "29/5/2026"},
            {"TI", "Tina Ima Sari", "XI-D", "Sakit", "Disetujui", "26/5/2026"},
            {"SN", "Salwa Nikaisha", "X-J", "Acara keluarga", "Disetujui", "26/5/2026"},
            {"MB", "Miftah Bayu", "XI-G", "Technical meeting", "Disetujui", "26/5/2026"},
            {"RI", "Rendy Ilham", "XI-F", "Ambil tugas", "Menunggu", "26/5/2026"},
            {"MD", "Mohammad Danang", "XI-F", "Ambil seragam", "Disetujui", "26/5/2026"},
            {"DA", "Daffa Alana", "XI-E", "Jemput keluarga", "Disetujui", "26/5/2026"}
        };
        
        DefaultTableModel model = new DefaultTableModel(data, columns) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        JTable table = new JTable(model);
        table.setFillsViewportHeight(true);
        table.setRowHeight(25);
        tableContainer.add(new JScrollPane(table), BorderLayout.CENTER);
        
        bottomPanel.add(tableContainer);

        // --- CHART ---
        JPanel chartContainer = new JPanel(new BorderLayout());
        chartContainer.setBorder(BorderFactory.createTitledBorder("Grafik Izin & Terlambat Mingguan"));
        chartContainer.add(new SimpleBarChart(), BorderLayout.CENTER);

        bottomPanel.add(chartContainer);

        centerPanel.add(bottomPanel);
        
        add(centerPanel, BorderLayout.CENTER);
    }

    private JPanel createCard(String title, String value) {
        JPanel card = new JPanel(new BorderLayout());
        card.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(Color.GRAY, 1),
            BorderFactory.createEmptyBorder(15, 15, 15, 15)
        ));
        
        JLabel titleLabel = new JLabel(title);
        titleLabel.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        
        JLabel valueLabel = new JLabel(value);
        valueLabel.setFont(new Font("Segoe UI", Font.BOLD, 24));
        
        card.add(titleLabel, BorderLayout.NORTH);
        card.add(valueLabel, BorderLayout.CENTER);
        
        return card;
    }

    // A simple custom component to draw a bar chart
    class SimpleBarChart extends JPanel {
        private int[] values = {15, 10, 25, 8, 30};
        private String[] labels = {"Senin", "Selasa", "Rabu", "Kamis", "Jumat"};

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;
            
            // Background
            g2d.setColor(Color.WHITE);
            g2d.fillRect(0, 0, getWidth(), getHeight());
            
            int padding = 40;
            int width = getWidth() - (2 * padding);
            int height = getHeight() - (2 * padding);
            
            // Draw Axes
            g2d.setColor(Color.BLACK);
            g2d.drawLine(padding, padding, padding, height + padding); // Y axis
            g2d.drawLine(padding, height + padding, width + padding, height + padding); // X axis
            
            int max = 35; // Maximum Y value
            int barWidth = width / (values.length * 2);
            
            for (int i = 0; i < values.length; i++) {
                int barHeight = (int) (((double) values[i] / max) * height);
                int x = padding + (i * 2 * barWidth) + (barWidth / 2);
                int y = height + padding - barHeight;
                
                // Draw bar
                g2d.setColor(SystemColor.activeCaption); // Standard system blue color
                g2d.fillRect(x, y, barWidth, barHeight);
                g2d.setColor(Color.BLACK);
                g2d.drawRect(x, y, barWidth, barHeight);
                
                // Draw label
                g2d.drawString(labels[i], x, height + padding + 20);
                
                // Draw value
                g2d.drawString(String.valueOf(values[i]), x + (barWidth/2) - 5, y - 5);
            }
        }
    }
}
