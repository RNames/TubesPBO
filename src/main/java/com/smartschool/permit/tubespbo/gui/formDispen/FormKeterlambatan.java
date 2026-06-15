/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.smartschool.permit.tubespbo.gui.formDispen;

/**
 *
 * @author riyan
 */
public class FormKeterlambatan extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(FormKeterlambatan.class.getName());

    /**
     * Creates new form FormKeterlambatan
     */
    public FormKeterlambatan() {
        initComponents();
        applyCustomStyles();
    }

    private void applyCustomStyles() {
        // 1. Center the Titles
        jPanel1.removeAll();
        jPanel1.setLayout(new javax.swing.BoxLayout(jPanel1, javax.swing.BoxLayout.Y_AXIS));
        jLabel1.setAlignmentX(java.awt.Component.CENTER_ALIGNMENT);
        jLabel1.setFont(new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 24));
        jLabel2.setAlignmentX(java.awt.Component.CENTER_ALIGNMENT);
        jLabel2.setFont(new java.awt.Font("Segoe UI", java.awt.Font.PLAIN, 14));
        jPanel1.add(jLabel1);
        jPanel1.add(javax.swing.Box.createVerticalStrut(5));
        jPanel1.add(jLabel2);
        
        // 2. Custom Action Buttons inside GridLayout
        ButtonNext.setVisible(false);
        javax.swing.JButton newNextBtn = new javax.swing.JButton("Berikutnya");
        newNextBtn.addActionListener(e -> submitLateEntry(newNextBtn));
        
        javax.swing.JButton switchFormBtn = new javax.swing.JButton("Form Dispensasi");
        switchFormBtn.addActionListener(e -> {
            this.dispose();
            new FormDispensasi().setVisible(true);
        });
        
        javax.swing.JPanel actionPanel = new javax.swing.JPanel(new java.awt.GridLayout(1, 2, 10, 0));
        actionPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 10, 15, 10));
        actionPanel.add(switchFormBtn);
        actionPanel.add(newNextBtn);

        // 3. Rebuild jPanel2 Panel using GridBagLayout for perfect alignment
        jPanel2.removeAll();
        jPanel2.setLayout(new java.awt.GridBagLayout());
        java.awt.GridBagConstraints gbcForm = new java.awt.GridBagConstraints();
        gbcForm.gridx = 0; gbcForm.gridy = 0; gbcForm.anchor = java.awt.GridBagConstraints.WEST;
        gbcForm.insets = new java.awt.Insets(5, 10, 5, 10);
        gbcForm.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gbcForm.weightx = 1.0;

        jLabel2.setText("SMAN 1 Rejotangan");
        jLabel4.setText("Tingkat & Kelas");
        jLabel4.setFont(new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 14));
        
        jPanel2.add(jLabel3, gbcForm); // Nama Lengkap
        gbcForm.gridy++; jPanel2.add(FieldNama, gbcForm);
        
        gbcForm.gridy++; jPanel2.add(new javax.swing.JLabel(" "), gbcForm);
        
        gbcForm.gridy++; jPanel2.add(jLabel4, gbcForm); // Tingkat & Kelas Heading
        
        jLabel5.setText("Tingkat:");
        gbcForm.gridy++; jPanel2.add(jLabel5, gbcForm);
        
        javax.swing.JPanel tingkatPanel = new javax.swing.JPanel(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 15, 0));
        tingkatPanel.add(RadioX); tingkatPanel.add(RadioXI); tingkatPanel.add(RadioXII);
        gbcForm.gridy++; jPanel2.add(tingkatPanel, gbcForm);
        
        jLabel6.setText("Kelas:");
        gbcForm.gridy++; jPanel2.add(jLabel6, gbcForm);
        
        javax.swing.JPanel kelasPanel = new javax.swing.JPanel(new java.awt.GridLayout(2, 5, 5, 5));
        kelasPanel.add(RadioAlphabet); kelasPanel.add(RadioAlphabetB); kelasPanel.add(RadioAlphabetC); kelasPanel.add(RadioAlphabetD); kelasPanel.add(RadioAlphabetE);
        kelasPanel.add(RadioAlphabetF); kelasPanel.add(RadioAlphabetG); kelasPanel.add(RadioAlphabetH); kelasPanel.add(RadioAlphabetI); kelasPanel.add(RadioAlphabetJ);
        gbcForm.gridy++; jPanel2.add(kelasPanel, gbcForm);

        jLabel7.setText("Dipilih: -");
        jLabel7.setFont(new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 12));
        jLabel7.setForeground(new java.awt.Color(0, 102, 204));
        gbcForm.gridy++; jPanel2.add(jLabel7, gbcForm);
        
        gbcForm.gridy++; jPanel2.add(new javax.swing.JLabel(" "), gbcForm);
        
        jLabel8.setText("Alasan Keterlambatan:");
        gbcForm.gridy++; jPanel2.add(jLabel8, gbcForm);
        
        gbcForm.gridy++; gbcForm.fill = java.awt.GridBagConstraints.BOTH; gbcForm.weighty = 1.0;
        jPanel2.add(jScrollPane1, gbcForm);
        gbcForm.fill = java.awt.GridBagConstraints.HORIZONTAL; gbcForm.weighty = 0.0;
        
        java.awt.event.ActionListener updateDipilih = e -> {
            String t = "";
            if(RadioX.isSelected()) t="X";
            else if(RadioXI.isSelected()) t="XI";
            else if(RadioXII.isSelected()) t="XII";

            String k = "";
            if(RadioAlphabet.isSelected()) k="A";
            else if(RadioAlphabetB.isSelected()) k="B";
            else if(RadioAlphabetC.isSelected()) k="C";
            else if(RadioAlphabetD.isSelected()) k="D";
            else if(RadioAlphabetE.isSelected()) k="E";
            else if(RadioAlphabetF.isSelected()) k="F";
            else if(RadioAlphabetG.isSelected()) k="G";
            else if(RadioAlphabetH.isSelected()) k="H";
            else if(RadioAlphabetI.isSelected()) k="I";
            else if(RadioAlphabetJ.isSelected()) k="J";

            if(!t.isEmpty() && !k.isEmpty()) {
                jLabel7.setText("Dipilih: " + t + "-" + k);
            }
        };

        javax.swing.JRadioButton[] radios = {RadioX, RadioXI, RadioXII, RadioAlphabet, RadioAlphabetB, RadioAlphabetC, RadioAlphabetD, RadioAlphabetE, RadioAlphabetF, RadioAlphabetG, RadioAlphabetH, RadioAlphabetI, RadioAlphabetJ};
        for(javax.swing.JRadioButton r : radios) {
            r.addActionListener(updateDipilih);
        }

        // 4. Form Box Wrapper (combines jPanel2 and buttons into one bordered box)
        jPanel2.setBorder(null); // Remove original border
        javax.swing.JPanel formBoxWrapper = new javax.swing.JPanel();
        formBoxWrapper.setLayout(new javax.swing.BoxLayout(formBoxWrapper, javax.swing.BoxLayout.Y_AXIS));
        formBoxWrapper.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        formBoxWrapper.add(jPanel2);
        formBoxWrapper.add(actionPanel);

        // 5. Main Wrapper
        java.awt.Container cp = getContentPane();
        cp.removeAll();
        cp.setLayout(new java.awt.BorderLayout());

        javax.swing.JPanel mainWrapper = new javax.swing.JPanel();
        mainWrapper.setLayout(new javax.swing.BoxLayout(mainWrapper, javax.swing.BoxLayout.Y_AXIS));
        mainWrapper.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));

        mainWrapper.add(jPanel1);
        mainWrapper.add(javax.swing.Box.createVerticalStrut(18));
        mainWrapper.add(formBoxWrapper);

        // Center the form horizontally and align to top
        javax.swing.JPanel centeringPanel = new javax.swing.JPanel(new java.awt.GridBagLayout());
        java.awt.GridBagConstraints gbc = new java.awt.GridBagConstraints();
        gbc.anchor = java.awt.GridBagConstraints.NORTH;
        gbc.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.insets = new java.awt.Insets(20, 40, 20, 40);
        centeringPanel.add(mainWrapper, gbc);

        javax.swing.JScrollPane scrollPane = new javax.swing.JScrollPane(centeringPanel);
        scrollPane.setBorder(null);
        cp.add(scrollPane, java.awt.BorderLayout.CENTER);

        // 5. Admin Button
        javax.swing.JButton adminBtn = new javax.swing.JButton("Masuk sebagai Admin");
        adminBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        adminBtn.addActionListener(e -> {
            this.dispose();
            new com.smartschool.permit.tubespbo.gui.login.LoginFrame().setVisible(true);
        });
        
        javax.swing.JPanel footerPanel = new javax.swing.JPanel(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER));
        footerPanel.add(adminBtn);
        cp.add(footerPanel, java.awt.BorderLayout.SOUTH);

        // 6. Setup Radio Button Groups
        javax.swing.ButtonGroup buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup1.add(RadioX);
        buttonGroup1.add(RadioXI);
        buttonGroup1.add(RadioXII);

        javax.swing.ButtonGroup buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup2.add(RadioAlphabet);
        buttonGroup2.add(RadioAlphabetB);
        buttonGroup2.add(RadioAlphabetC);
        buttonGroup2.add(RadioAlphabetD);
        buttonGroup2.add(RadioAlphabetE);
        buttonGroup2.add(RadioAlphabetF);
        buttonGroup2.add(RadioAlphabetG);
        buttonGroup2.add(RadioAlphabetH);
        buttonGroup2.add(RadioAlphabetI);
        buttonGroup2.add(RadioAlphabetJ);

        cp.revalidate();
        cp.repaint();
        
        // Ensure consistent window size and center on screen
        this.setSize(480, 750);
        this.setMinimumSize(new java.awt.Dimension(450, 700));
        this.setLocationRelativeTo(null);
    }



    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSpinner1 = new javax.swing.JSpinner();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        FieldNama = new javax.swing.JTextField();
        RadioAlphabetJ = new javax.swing.JRadioButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        RadioX = new javax.swing.JRadioButton();
        RadioXI = new javax.swing.JRadioButton();
        RadioXII = new javax.swing.JRadioButton();
        jLabel6 = new javax.swing.JLabel();
        RadioAlphabet = new javax.swing.JRadioButton();
        RadioAlphabetB = new javax.swing.JRadioButton();
        RadioAlphabetC = new javax.swing.JRadioButton();
        RadioAlphabetD = new javax.swing.JRadioButton();
        RadioAlphabetE = new javax.swing.JRadioButton();
        RadioAlphabetF = new javax.swing.JRadioButton();
        RadioAlphabetG = new javax.swing.JRadioButton();
        RadioAlphabetH = new javax.swing.JRadioButton();
        RadioAlphabetI = new javax.swing.JRadioButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        AreaReason = new javax.swing.JTextArea();
        ButtonNext = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(660, 688));

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel1.setText("Catat Keterlambatan");

        jLabel2.setText("SMAN 1 Renjotangan");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addContainerGap(265, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(44, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addGap(18, 18, 18))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel3.setText("Nama Lengkap");

        RadioAlphabetJ.setText("J");

        jLabel4.setText("Kelas");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jLabel5.setText("Tingkatan");

        RadioX.setText("X");

        RadioXI.setText("XI");

        RadioXII.setText("XII");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jLabel6.setText("Kelas");

        RadioAlphabet.setText("A");
        RadioAlphabet.addActionListener(this::RadioAlphabetActionPerformed);

        RadioAlphabetB.setText("B");

        RadioAlphabetC.setText("C");

        RadioAlphabetD.setText("D");

        RadioAlphabetE.setText("E");

        RadioAlphabetF.setText("F");

        RadioAlphabetG.setText("G");

        RadioAlphabetH.setText("H");

        RadioAlphabetI.setText("I");

        jLabel7.setText("Dipilih:");

        jLabel8.setText("Alasan Keterlambatan:");

        AreaReason.setColumns(20);
        AreaReason.setRows(5);
        jScrollPane1.setViewportView(AreaReason);

        ButtonNext.setText("Lanjut ->");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(FieldNama, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(RadioX)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(RadioXI)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(RadioXII))
                            .addComponent(jLabel6)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(RadioAlphabet)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(RadioAlphabetB)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(RadioAlphabetC)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(RadioAlphabetD)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(RadioAlphabetE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(RadioAlphabetF)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(RadioAlphabetG))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(RadioAlphabetH)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(RadioAlphabetI)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(RadioAlphabetJ))
                            .addComponent(jLabel7)
                            .addComponent(jLabel8)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, 0)
                        .addComponent(ButtonNext)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(FieldNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(RadioX)
                    .addComponent(RadioXI)
                    .addComponent(RadioXII))
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(RadioAlphabet)
                    .addComponent(RadioAlphabetB)
                    .addComponent(RadioAlphabetC)
                    .addComponent(RadioAlphabetD)
                    .addComponent(RadioAlphabetE)
                    .addComponent(RadioAlphabetF)
                    .addComponent(RadioAlphabetG))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(RadioAlphabetH)
                    .addComponent(RadioAlphabetI)
                    .addComponent(RadioAlphabetJ))
                .addGap(18, 18, 18)
                .addComponent(jLabel7)
                .addGap(18, 18, 18)
                .addComponent(jLabel8)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(ButtonNext)
                .addGap(0, 0, 0))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(10, 10, 10)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(13, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void submitLateEntry(javax.swing.JButton submitBtn) {
        // Validasi nama
        String nama = FieldNama.getText().trim();
        if (nama.isEmpty()) {
            javax.swing.JOptionPane.showMessageDialog(this, "Nama lengkap harus diisi!", "Validasi Gagal", javax.swing.JOptionPane.WARNING_MESSAGE);
            return;
        }
        // Format nama title case
        String[] words = nama.split("\\s+");
        StringBuilder sb = new StringBuilder();
        for (String w : words) {
            if (!w.isEmpty()) {
                sb.append(Character.toUpperCase(w.charAt(0))).append(w.substring(1).toLowerCase()).append(" ");
            }
        }
        nama = sb.toString().trim();
        FieldNama.setText(nama);

        // Validasi tingkat
        String tingkat = "";
        if (RadioX.isSelected()) tingkat = "X";
        else if (RadioXI.isSelected()) tingkat = "XI";
        else if (RadioXII.isSelected()) tingkat = "XII";
        if (tingkat.isEmpty()) {
            javax.swing.JOptionPane.showMessageDialog(this, "Pilih tingkat kelas!", "Validasi Gagal", javax.swing.JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Validasi kelas
        String kelas = "";
        if (RadioAlphabet.isSelected()) kelas = "A";
        else if (RadioAlphabetB.isSelected()) kelas = "B";
        else if (RadioAlphabetC.isSelected()) kelas = "C";
        else if (RadioAlphabetD.isSelected()) kelas = "D";
        else if (RadioAlphabetE.isSelected()) kelas = "E";
        else if (RadioAlphabetF.isSelected()) kelas = "F";
        else if (RadioAlphabetG.isSelected()) kelas = "G";
        else if (RadioAlphabetH.isSelected()) kelas = "H";
        else if (RadioAlphabetI.isSelected()) kelas = "I";
        else if (RadioAlphabetJ.isSelected()) kelas = "J";
        if (kelas.isEmpty()) {
            javax.swing.JOptionPane.showMessageDialog(this, "Pilih kelas!", "Validasi Gagal", javax.swing.JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Validasi alasan
        String alasan = AreaReason.getText().trim();
        if (alasan.isEmpty()) {
            javax.swing.JOptionPane.showMessageDialog(this, "Alasan keterlambatan harus diisi!", "Validasi Gagal", javax.swing.JOptionPane.WARNING_MESSAGE);
            return;
        }

        String fullKelas = tingkat + "-" + kelas;
        String finalNama = nama;

        // Konfirmasi
        int confirm = javax.swing.JOptionPane.showConfirmDialog(this,
            "Apakah data yang Anda masukkan sudah benar?\n\nNama: " + finalNama + "\nKelas: " + fullKelas + "\nAlasan: " + alasan,
            "Konfirmasi Simpan", javax.swing.JOptionPane.YES_NO_OPTION);

        if (confirm != javax.swing.JOptionPane.YES_OPTION) {
            return;
        }

        // Simpan ke Firestore via PermitService
        submitBtn.setEnabled(false);
        new javax.swing.SwingWorker<String, Void>() {
            @Override
            protected String doInBackground() throws Exception {
                com.smartschool.permit.tubespbo.repository.PermitRepository permitRepo = new com.smartschool.permit.tubespbo.repository.PermitRepository();
                com.smartschool.permit.tubespbo.service.PermitService permitService = new com.smartschool.permit.tubespbo.service.PermitService(permitRepo);

                com.smartschool.permit.tubespbo.model.StudentPermit permit = new com.smartschool.permit.tubespbo.model.StudentPermit();
                permit.setStudentName(finalNama);
                permit.setClassName(fullKelas);
                permit.setReason(alasan);
                permit.setType(com.smartschool.permit.tubespbo.model.enums.PermitType.LATE_ENTRY);
                permit.setSchoolId("sch_001");

                return permitService.createPermit(permit);
            }

            @Override
            protected void done() {
                try {
                    String id = get();
                    javax.swing.JOptionPane.showMessageDialog(FormKeterlambatan.this,
                        "Keterlambatan berhasil dicatat!\nID: " + id + "\nNama: " + finalNama + "\nKelas: " + fullKelas,
                        "Berhasil", javax.swing.JOptionPane.INFORMATION_MESSAGE);
                    // Reset form
                    FieldNama.setText("");
                    AreaReason.setText("");
                    jLabel7.setText("Dipilih: -");
                } catch (Exception ex) {
                    String msg = ex.getCause() != null ? ex.getCause().getMessage() : ex.getMessage();
                    javax.swing.JOptionPane.showMessageDialog(FormKeterlambatan.this,
                        "Gagal menyimpan: " + msg, "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
                } finally {
                    submitBtn.setEnabled(true);
                }
            }
        }.execute();
    }

    private void RadioAlphabetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RadioAlphabetActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RadioAlphabetActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            javax.swing.UIManager.setLookAndFeel(javax.swing.UIManager.getSystemLookAndFeelClassName());
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new FormKeterlambatan().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea AreaReason;
    private javax.swing.JButton ButtonNext;
    private javax.swing.JTextField FieldNama;
    private javax.swing.JRadioButton RadioAlphabet;
    private javax.swing.JRadioButton RadioAlphabetB;
    private javax.swing.JRadioButton RadioAlphabetC;
    private javax.swing.JRadioButton RadioAlphabetD;
    private javax.swing.JRadioButton RadioAlphabetE;
    private javax.swing.JRadioButton RadioAlphabetF;
    private javax.swing.JRadioButton RadioAlphabetG;
    private javax.swing.JRadioButton RadioAlphabetH;
    private javax.swing.JRadioButton RadioAlphabetI;
    private javax.swing.JRadioButton RadioAlphabetJ;
    private javax.swing.JRadioButton RadioX;
    private javax.swing.JRadioButton RadioXI;
    private javax.swing.JRadioButton RadioXII;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSpinner jSpinner1;
    // End of variables declaration//GEN-END:variables
}
