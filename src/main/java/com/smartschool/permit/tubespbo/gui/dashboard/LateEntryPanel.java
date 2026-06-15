package com.smartschool.permit.tubespbo.gui.dashboard;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

import com.smartschool.permit.tubespbo.app.UserSession;
import com.smartschool.permit.tubespbo.model.AdminUser;
import com.smartschool.permit.tubespbo.model.StudentPermit;
import com.smartschool.permit.tubespbo.model.enums.PermitType;
import com.smartschool.permit.tubespbo.repository.PermitRepository;
import com.smartschool.permit.tubespbo.service.PermitService;
import com.smartschool.permit.tubespbo.util.DateUtils;

/**
 * Panel admin untuk mengelola data siswa terlambat.
 * Menampilkan tabel data, filter/search, dan tombol approve.
 */
public class LateEntryPanel extends JPanel {

    private DefaultTableModel tableModel;
    private JTextField searchField;
    private final PermitRepository permitRepo = new PermitRepository();
    private final PermitService permitService = new PermitService(permitRepo);
    private List<StudentPermit> currentPermits;

    public LateEntryPanel() {
        initComponents();
        loadData();
    }

    private void initComponents() {
        setLayout(new BorderLayout(10, 10));
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // --- TITLE & SEARCH ---
        JPanel topPanel = new JPanel(new BorderLayout());
        JLabel titleLabel = new JLabel("Siswa Terlambat");
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 18));
        topPanel.add(titleLabel, BorderLayout.WEST);

        JPanel searchPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        searchField = new JTextField(15);
        JButton searchBtn = new JButton("Cari");
        searchBtn.addActionListener(e -> filterData());
        searchField.addActionListener(e -> filterData());
        searchPanel.add(new JLabel("Cari: "));
        searchPanel.add(searchField);
        searchPanel.add(searchBtn);
        topPanel.add(searchPanel, BorderLayout.EAST);

        add(topPanel, BorderLayout.NORTH);

        // --- TABLE ---
        String[] columns = {"No", "Nama", "Kelas", "Alasan", "Waktu", "Status", "Disetujui Oleh"};
        tableModel = new DefaultTableModel(columns, 0) {
            @Override
            public boolean isCellEditable(int row, int column) { return false; }
        };
        JTable table = new JTable(tableModel);
        table.setFillsViewportHeight(true);
        table.setRowHeight(28);
        table.getColumnModel().getColumn(0).setPreferredWidth(40);
        add(new JScrollPane(table), BorderLayout.CENTER);

        // --- BOTTOM BUTTONS ---
        JPanel btnPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 5));
        JButton approveBtn = new JButton("Approve Terpilih");
        approveBtn.addActionListener(e -> {
            int row = table.getSelectedRow();
            if (row < 0) {
                JOptionPane.showMessageDialog(this, "Pilih baris yang ingin di-approve!", "Info", JOptionPane.WARNING_MESSAGE);
                return;
            }
            approvePermit(row);
        });

        JButton refreshBtn = new JButton("Refresh");
        refreshBtn.addActionListener(e -> loadData());

        btnPanel.add(approveBtn);
        btnPanel.add(refreshBtn);
        add(btnPanel, BorderLayout.SOUTH);
    }

    public void loadData() {
        String schoolId = UserSession.getInstance().getSchoolId();
        if (schoolId == null) return;

        new SwingWorker<List<StudentPermit>, Void>() {
            @Override
            protected List<StudentPermit> doInBackground() {
                return permitService.getPermitsByType(schoolId, PermitType.LATE_ENTRY);
            }

            @Override
            protected void done() {
                try {
                    currentPermits = get();
                    populateTable(currentPermits);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(LateEntryPanel.this, "Error memuat data: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }.execute();
    }

    private void filterData() {
        if (currentPermits == null) return;
        String keyword = searchField.getText().trim();
        List<StudentPermit> filtered = permitService.filterPermits(currentPermits, null, keyword);
        populateTable(filtered);
    }

    private void populateTable(List<StudentPermit> permits) {
        tableModel.setRowCount(0);
        for (int i = 0; i < permits.size(); i++) {
            StudentPermit p = permits.get(i);
            tableModel.addRow(new Object[]{
                i + 1,
                p.getStudentName(),
                p.getClassName(),
                p.getReason(),
                DateUtils.formatDateTime(p.getTimestamp()),
                p.isPending() ? "Menunggu" : "Disetujui",
                p.getApprovedBy() != null ? p.getApprovedBy() : "-"
            });
        }
    }

    private void approvePermit(int row) {
        if (currentPermits == null || row >= currentPermits.size()) return;
        StudentPermit permit = currentPermits.get(row);
        if (!permit.isPending()) {
            JOptionPane.showMessageDialog(this, "Izin ini sudah disetujui!", "Info", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        AdminUser admin = UserSession.getInstance().getCurrentUser();
        int confirm = JOptionPane.showConfirmDialog(this,
            "Approve izin terlambat untuk " + permit.getStudentName() + "?",
            "Konfirmasi", JOptionPane.YES_NO_OPTION);

        if (confirm == JOptionPane.YES_OPTION) {
            new SwingWorker<Void, Void>() {
                @Override
                protected Void doInBackground() {
                    permitService.approvePermit(permit.getId(), admin);
                    return null;
                }

                @Override
                protected void done() {
                    try {
                        get();
                        JOptionPane.showMessageDialog(LateEntryPanel.this, "Berhasil di-approve!", "Sukses", JOptionPane.INFORMATION_MESSAGE);
                        loadData();
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(LateEntryPanel.this, "Gagal approve: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }.execute();
        }
    }
}
