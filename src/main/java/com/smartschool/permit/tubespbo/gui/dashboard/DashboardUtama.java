package com.mycompany.gui.dashboard;

import javax.swing.*;
import java.awt.*;
import com.mycompany.gui.login.LoginFrame;
import com.mycompany.gui.widget.SidebarPanel;

public class DashboardUtama extends JFrame {

    private CardLayout cardLayout;
    private JPanel mainContentPanel;

    public DashboardUtama() {
        setTitle("SMAN 1 Rejotangan - Admin Panel");
        setSize(1100, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); 
        setLayout(new BorderLayout());

        // Inisialisasi CardLayout untuk konten utama
        cardLayout = new CardLayout();
        mainContentPanel = new JPanel(cardLayout);

        // Tambahkan halaman-halaman ke dalam CardLayout
        mainContentPanel.add(new DashboardPanel(), "Dashboard");
        mainContentPanel.add(new BlankPanel("Siswa Terlambat"), "Siswa Terlambat");
        mainContentPanel.add(new BlankPanel("Izin Keluar"), "Izin Keluar");
        mainContentPanel.add(new BlankPanel("Laporan"), "Laporan");
        mainContentPanel.add(new BlankPanel("Kelola Admin"), "Kelola Admin");

        // Tambahkan komponen sidebar yang terpisah di sebelah kiri
        SidebarPanel sidebar = new SidebarPanel(
            // onMenuSelected
            (menuName) -> {
                cardLayout.show(mainContentPanel, menuName);
            },
            // onLogout
            () -> {
                int confirm = JOptionPane.showConfirmDialog(this, "Apakah Anda yakin ingin logout?", "Konfirmasi Logout", JOptionPane.YES_NO_OPTION);
                if (confirm == JOptionPane.YES_OPTION) {
                    this.dispose(); // Tutup dashboard
                    new LoginFrame().setVisible(true); // Buka kembali halaman login
                }
            }
        );

        add(sidebar, BorderLayout.WEST);
        add(mainContentPanel, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        // Menggunakan look and feel standar dari sistem operasi
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ignored) {}

        SwingUtilities.invokeLater(() -> {
            new DashboardUtama().setVisible(true);
        });
    }
}