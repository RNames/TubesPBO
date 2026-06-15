/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.smartschool.permit.tubespbo.gui.formDispen;

/**
 *
 * @author riyan
 */
public class FormDispensasi extends javax.swing.JFrame {
    
    private javax.swing.JRadioButton RadioKelasAlphabetK;
    private javax.swing.JCheckBox CheckKembali;
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(FormDispensasi.class.getName());

    /**
     * Creates new form FormDispensasi
     */
    public FormDispensasi() {
        initComponents();
        applyCustomStyles();
    }

    private void applyCustomStyles() {
        // 1. Center the Titles
        Top.removeAll();
        Top.setLayout(new javax.swing.BoxLayout(Top, javax.swing.BoxLayout.Y_AXIS));
        jLabel1.setAlignmentX(java.awt.Component.CENTER_ALIGNMENT);
        jLabel1.setFont(new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 24));
        jLabel2.setAlignmentX(java.awt.Component.CENTER_ALIGNMENT);
        jLabel2.setFont(new java.awt.Font("Segoe UI", java.awt.Font.PLAIN, 14));
        Top.add(jLabel1);
        Top.add(javax.swing.Box.createVerticalStrut(5));
        Top.add(jLabel2);
        
        // 2. Custom Action Buttons inside GridLayout
        ButtonNext.setVisible(false);
        javax.swing.JButton newNextBtn = new javax.swing.JButton("Berikutnya");
        for (java.awt.event.ActionListener al : ButtonNext.getActionListeners()) {
            newNextBtn.addActionListener(al);
        }
        
        javax.swing.JButton switchFormBtn = new javax.swing.JButton("Form Terlambat");
        switchFormBtn.addActionListener(e -> {
            this.dispose();
            new FormKeterlambatan().setVisible(true);
        });
        
        javax.swing.JPanel actionPanel = new javax.swing.JPanel(new java.awt.GridLayout(1, 2, 10, 0));
        actionPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 10, 15, 10));
        actionPanel.add(switchFormBtn);
        actionPanel.add(newNextBtn);

        // 3. Rebuild Bottom Panel using GridBagLayout for perfect alignment
        Bottom.removeAll();
        Bottom.setLayout(new java.awt.GridBagLayout());
        java.awt.GridBagConstraints gbcForm = new java.awt.GridBagConstraints();
        gbcForm.gridx = 0; gbcForm.gridy = 0; gbcForm.anchor = java.awt.GridBagConstraints.WEST;
        gbcForm.insets = new java.awt.Insets(5, 10, 5, 10);
        gbcForm.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gbcForm.weightx = 1.0;

        jLabel4.setText("Nama otomatis diformat huruf besar di awal saat selesai mengetik.");
        jLabel5.setText("Tingkat & Kelas");
        jLabel5.setFont(new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 14));
        
        Bottom.add(jLabel3, gbcForm); // Nama Lengkap
        gbcForm.gridy++; Bottom.add(FieldNama, gbcForm);
        gbcForm.gridy++; Bottom.add(jLabel4, gbcForm); // Hint
        
        gbcForm.gridy++; Bottom.add(new javax.swing.JLabel(" "), gbcForm);
        
        gbcForm.gridy++; Bottom.add(jLabel5, gbcForm);
        
        jLabel6.setText("Tingkat:");
        gbcForm.gridy++; Bottom.add(jLabel6, gbcForm);
        
        javax.swing.JPanel tingkatPanel = new javax.swing.JPanel(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 15, 0));
        tingkatPanel.add(RadioX); tingkatPanel.add(RadioXI); tingkatPanel.add(RadioXII);
        gbcForm.gridy++; Bottom.add(tingkatPanel, gbcForm);
        
        jLabel7.setText("Kelas:");
        gbcForm.gridy++; Bottom.add(jLabel7, gbcForm);
        
        RadioKelasAlphabetK = new javax.swing.JRadioButton("K");
        RadioKelasAlphabetK.setVisible(false); // Default hide
        buttonGroup2.add(RadioKelasAlphabetK); // Add to the existing buttonGroup2
        
        // levelListener logic moved into updateDipilih

        javax.swing.JPanel kelasPanel = new javax.swing.JPanel(new java.awt.GridLayout(2, 6, 5, 5));
        kelasPanel.add(RadioKelasAlphabetA); kelasPanel.add(RadioKelasAlphabetB); kelasPanel.add(RadioKelasAlphabetC); kelasPanel.add(RadioKelasAlphabetD); kelasPanel.add(RadioKelasAlphabetE); kelasPanel.add(RadioKelasAlphabetF);
        kelasPanel.add(RadioKelasAlphabetG); kelasPanel.add(RadioKelasAlphabetH); kelasPanel.add(RadioKelasAlphabetI); kelasPanel.add(RadionKelasAlphabetJ); kelasPanel.add(RadioKelasAlphabetK);
        gbcForm.gridy++; Bottom.add(kelasPanel, gbcForm);
        
        jLabel8.setText("Dipilih: -");
        jLabel8.setFont(new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 12));
        jLabel8.setForeground(new java.awt.Color(0, 102, 204));
        gbcForm.gridy++; Bottom.add(jLabel8, gbcForm);
        
        gbcForm.gridy++; Bottom.add(new javax.swing.JLabel(" "), gbcForm);
        
        gbcForm.gridy++; Bottom.add(jLabel9, gbcForm);
        
        gbcForm.gridy++; gbcForm.fill = java.awt.GridBagConstraints.BOTH; gbcForm.weighty = 1.0;
        Bottom.add(jScrollPane1, gbcForm);
        gbcForm.fill = java.awt.GridBagConstraints.HORIZONTAL; gbcForm.weighty = 0.0;
        
        gbcForm.gridy++; Bottom.add(new javax.swing.JLabel(" "), gbcForm);
        
        gbcForm.gridy++; Bottom.add(jLabel10, gbcForm);
        
        CheckKembali = new javax.swing.JCheckBox("Saya berencana kembali ke sekolah hari ini", true);
        CheckKembali.addActionListener(e -> SpinnerTimer.setEnabled(CheckKembali.isSelected()));
        gbcForm.gridy++; Bottom.add(CheckKembali, gbcForm);
        
        java.util.Calendar defaultTime = java.util.Calendar.getInstance();
        defaultTime.add(java.util.Calendar.HOUR_OF_DAY, 1);
        SpinnerTimer.setModel(new javax.swing.SpinnerDateModel(defaultTime.getTime(), null, null, java.util.Calendar.MINUTE));
        SpinnerTimer.setEditor(new javax.swing.JSpinner.DateEditor(SpinnerTimer, "HH:mm"));
        
        gbcForm.gridy++; Bottom.add(SpinnerTimer, gbcForm);
        
        jLabel11.setText("Hapus centang di atas jika Anda tidak berencana kembali hari ini.");
        gbcForm.gridy++; Bottom.add(jLabel11, gbcForm);

        java.awt.event.ActionListener updateDipilih = e -> {
            if (RadioX.isSelected()) {
                RadioKelasAlphabetK.setVisible(false);
                if (RadioKelasAlphabetK.isSelected()) {
                    buttonGroup2.clearSelection();
                }
            } else if (RadioXI.isSelected() || RadioXII.isSelected()) {
                RadioKelasAlphabetK.setVisible(true);
            }

            String t = "";
            if(RadioX.isSelected()) t="X";
            else if(RadioXI.isSelected()) t="XI";
            else if(RadioXII.isSelected()) t="XII";

            String k = "";
            if(RadioKelasAlphabetA.isSelected()) k="A";
            else if(RadioKelasAlphabetB.isSelected()) k="B";
            else if(RadioKelasAlphabetC.isSelected()) k="C";
            else if(RadioKelasAlphabetD.isSelected()) k="D";
            else if(RadioKelasAlphabetE.isSelected()) k="E";
            else if(RadioKelasAlphabetF.isSelected()) k="F";
            else if(RadioKelasAlphabetG.isSelected()) k="G";
            else if(RadioKelasAlphabetH.isSelected()) k="H";
            else if(RadioKelasAlphabetI.isSelected()) k="I";
            else if(RadionKelasAlphabetJ.isSelected()) k="J";
            else if(RadioKelasAlphabetK.isSelected()) k="K";

            if(!t.isEmpty() && !k.isEmpty()) {
                jLabel8.setText("Dipilih: " + t + "-" + k);
            } else if (!t.isEmpty()) {
                jLabel8.setText("Dipilih: " + t);
            } else {
                jLabel8.setText("Dipilih: -");
            }
        };

        javax.swing.JRadioButton[] radios = {RadioX, RadioXI, RadioXII, RadioKelasAlphabetA, RadioKelasAlphabetB, RadioKelasAlphabetC, RadioKelasAlphabetD, RadioKelasAlphabetE, RadioKelasAlphabetF, RadioKelasAlphabetG, RadioKelasAlphabetH, RadioKelasAlphabetI, RadionKelasAlphabetJ, RadioKelasAlphabetK};
        for(javax.swing.JRadioButton r : radios) {
            r.addActionListener(updateDipilih);
        }

        // 4. Form Box Wrapper (combines Bottom and buttons into one bordered box)
        Bottom.setBorder(null); // Remove original border
        javax.swing.JPanel formBoxWrapper = new javax.swing.JPanel();
        formBoxWrapper.setLayout(new javax.swing.BoxLayout(formBoxWrapper, javax.swing.BoxLayout.Y_AXIS));
        formBoxWrapper.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        formBoxWrapper.add(Bottom);
        formBoxWrapper.add(actionPanel);

        // 5. Main Wrapper
        java.awt.Container cp = getContentPane();
        cp.removeAll();
        cp.setLayout(new java.awt.BorderLayout());

        javax.swing.JPanel mainWrapper = new javax.swing.JPanel();
        mainWrapper.setLayout(new javax.swing.BoxLayout(mainWrapper, javax.swing.BoxLayout.Y_AXIS));
        mainWrapper.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));

        mainWrapper.add(Top);
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
        buttonGroup1.add(RadioX);
        buttonGroup1.add(RadioXI);
        buttonGroup1.add(RadioXII);

        buttonGroup2.add(RadioKelasAlphabetA);
        buttonGroup2.add(RadioKelasAlphabetB);
        buttonGroup2.add(RadioKelasAlphabetC);
        buttonGroup2.add(RadioKelasAlphabetD);
        buttonGroup2.add(RadioKelasAlphabetE);
        buttonGroup2.add(RadioKelasAlphabetF);
        buttonGroup2.add(RadioKelasAlphabetG);
        buttonGroup2.add(RadioKelasAlphabetH);
        buttonGroup2.add(RadioKelasAlphabetI);
        buttonGroup2.add(RadionKelasAlphabetJ);

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

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        Top = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        Bottom = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        FieldNama = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        RadioX = new javax.swing.JRadioButton();
        RadioXI = new javax.swing.JRadioButton();
        RadioXII = new javax.swing.JRadioButton();
        jLabel7 = new javax.swing.JLabel();
        RadioKelasAlphabetA = new javax.swing.JRadioButton();
        RadioKelasAlphabetB = new javax.swing.JRadioButton();
        RadioKelasAlphabetC = new javax.swing.JRadioButton();
        RadioKelasAlphabetD = new javax.swing.JRadioButton();
        RadioKelasAlphabetE = new javax.swing.JRadioButton();
        RadioKelasAlphabetF = new javax.swing.JRadioButton();
        RadioKelasAlphabetG = new javax.swing.JRadioButton();
        RadioKelasAlphabetH = new javax.swing.JRadioButton();
        RadioKelasAlphabetI = new javax.swing.JRadioButton();
        RadionKelasAlphabetJ = new javax.swing.JRadioButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TextAreaAlasan = new javax.swing.JTextArea();
        jLabel10 = new javax.swing.JLabel();
        SpinnerTimer = new javax.swing.JSpinner();
        jLabel11 = new javax.swing.JLabel();
        ButtonNext = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Top.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel1.setText("Form Dispensasi");

        jLabel2.setText("SMAN 1 Rejotangan");

        javax.swing.GroupLayout TopLayout = new javax.swing.GroupLayout(Top);
        Top.setLayout(TopLayout);
        TopLayout.setHorizontalGroup(
            TopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TopLayout.createSequentialGroup()
                .addGroup(TopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(TopLayout.createSequentialGroup()
                        .addGap(0, 0, 0)
                        .addComponent(jLabel1))
                    .addGroup(TopLayout.createSequentialGroup()
                        .addGap(0, 0, 0)
                        .addComponent(jLabel2)))
                .addContainerGap(0, Short.MAX_VALUE))
        );
        TopLayout.setVerticalGroup(
            TopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TopLayout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        Bottom.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel3.setText("Nama Lengkap");

        FieldNama.addActionListener(this::FieldNamaActionPerformed);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jLabel4.setText("Nama otomatis diformat Huruf Beesar Di awal saat selesai mengetik ");
        jLabel4.setAutoscrolls(true);
        jLabel4.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel5.setText("Kelas");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jLabel6.setText("Tingkat");

        RadioX.setText("X");
        RadioX.addActionListener(this::RadioXActionPerformed);

        RadioXI.setText("XI");
        RadioXI.addActionListener(this::RadioXIActionPerformed);

        RadioXII.setText("XII");
        RadioXII.addActionListener(this::RadioXIIActionPerformed);

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jLabel7.setText("kelas");

        RadioKelasAlphabetA.setText("A");
        RadioKelasAlphabetA.addActionListener(this::RadioKelasAlphabetAActionPerformed);

        RadioKelasAlphabetB.setText("B");
        RadioKelasAlphabetB.addActionListener(this::RadioKelasAlphabetBActionPerformed);

        RadioKelasAlphabetC.setText("C");
        RadioKelasAlphabetC.addActionListener(this::RadioKelasAlphabetCActionPerformed);

        RadioKelasAlphabetD.setText("D");
        RadioKelasAlphabetD.addActionListener(this::RadioKelasAlphabetDActionPerformed);

        RadioKelasAlphabetE.setText("E");
        RadioKelasAlphabetE.addActionListener(this::RadioKelasAlphabetEActionPerformed);

        RadioKelasAlphabetF.setText("F");
        RadioKelasAlphabetF.addActionListener(this::RadioKelasAlphabetFActionPerformed);

        RadioKelasAlphabetG.setText("G");
        RadioKelasAlphabetG.addActionListener(this::RadioKelasAlphabetGActionPerformed);

        RadioKelasAlphabetH.setText("H");
        RadioKelasAlphabetH.addActionListener(this::RadioKelasAlphabetHActionPerformed);

        RadioKelasAlphabetI.setText("I");
        RadioKelasAlphabetI.addActionListener(this::RadioKelasAlphabetIActionPerformed);

        RadionKelasAlphabetJ.setText("J");
        RadionKelasAlphabetJ.addActionListener(this::RadionKelasAlphabetJActionPerformed);

        jLabel8.setText("Dipilih :");

        jLabel9.setText("Alasan Dispensasi");

        TextAreaAlasan.setColumns(20);
        TextAreaAlasan.setRows(5);
        jScrollPane1.setViewportView(TextAreaAlasan);

        jLabel10.setText("Rencana Kembali (Opsional)");

        SpinnerTimer.setModel(new javax.swing.SpinnerDateModel(new java.util.Date(1781181646102L), null, null, java.util.Calendar.HOUR));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jLabel11.setText("Biarkan kosong jika tidak berencana kembali hari ini");

        ButtonNext.setText("Lanjut ->");
        ButtonNext.addActionListener(this::ButtonNextActionPerformed);

        javax.swing.GroupLayout BottomLayout = new javax.swing.GroupLayout(Bottom);
        Bottom.setLayout(BottomLayout);
        BottomLayout.setHorizontalGroup(
            BottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BottomLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(BottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(BottomLayout.createSequentialGroup()
                        .addGroup(BottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(FieldNama, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addGroup(BottomLayout.createSequentialGroup()
                                .addComponent(RadioX)
                                .addGap(18, 18, 18)
                                .addComponent(RadioXI)
                                .addGap(18, 18, 18)
                                .addComponent(RadioXII))
                            .addComponent(jLabel7)
                            .addComponent(jLabel8))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(BottomLayout.createSequentialGroup()
                        .addGroup(BottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(BottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(BottomLayout.createSequentialGroup()
                                    .addComponent(RadioKelasAlphabetI)
                                    .addGap(18, 18, 18)
                                    .addComponent(RadionKelasAlphabetJ))
                                .addGroup(BottomLayout.createSequentialGroup()
                                    .addComponent(RadioKelasAlphabetA)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(RadioKelasAlphabetB)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(RadioKelasAlphabetC)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(RadioKelasAlphabetD)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(RadioKelasAlphabetE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(RadioKelasAlphabetF)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(RadioKelasAlphabetG)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(RadioKelasAlphabetH))
                                .addComponent(jLabel9)
                                .addComponent(jScrollPane1))
                            .addGroup(BottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(SpinnerTimer, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jLabel11))
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(BottomLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(ButtonNext, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        BottomLayout.setVerticalGroup(
            BottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BottomLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(FieldNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(BottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(RadioX)
                    .addComponent(RadioXI)
                    .addComponent(RadioXII))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(BottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(RadioKelasAlphabetA)
                    .addComponent(RadioKelasAlphabetB)
                    .addComponent(RadioKelasAlphabetC)
                    .addComponent(RadioKelasAlphabetD)
                    .addComponent(RadioKelasAlphabetE)
                    .addComponent(RadioKelasAlphabetF)
                    .addComponent(RadioKelasAlphabetG)
                    .addComponent(RadioKelasAlphabetH))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(BottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(RadioKelasAlphabetI)
                    .addComponent(RadionKelasAlphabetJ))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addGap(18, 18, 18)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(SpinnerTimer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel11)
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
                    .addComponent(Top, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Bottom, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Top, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Bottom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void FieldNamaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FieldNamaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_FieldNamaActionPerformed

    private void RadioXIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RadioXIActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RadioXIActionPerformed

    private void RadioXActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RadioXActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RadioXActionPerformed

    private void RadioKelasAlphabetAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RadioKelasAlphabetAActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RadioKelasAlphabetAActionPerformed

    private void RadioKelasAlphabetFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RadioKelasAlphabetFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RadioKelasAlphabetFActionPerformed

    private void RadionKelasAlphabetJActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RadionKelasAlphabetJActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RadionKelasAlphabetJActionPerformed

    private void RadioXIIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RadioXIIActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RadioXIIActionPerformed

    private void RadioKelasAlphabetCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RadioKelasAlphabetCActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RadioKelasAlphabetCActionPerformed

    private void RadioKelasAlphabetBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RadioKelasAlphabetBActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RadioKelasAlphabetBActionPerformed

    private void RadioKelasAlphabetDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RadioKelasAlphabetDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RadioKelasAlphabetDActionPerformed

    private void RadioKelasAlphabetEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RadioKelasAlphabetEActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RadioKelasAlphabetEActionPerformed

    private void RadioKelasAlphabetGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RadioKelasAlphabetGActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RadioKelasAlphabetGActionPerformed

    private void RadioKelasAlphabetHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RadioKelasAlphabetHActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RadioKelasAlphabetHActionPerformed

    private void RadioKelasAlphabetIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RadioKelasAlphabetIActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RadioKelasAlphabetIActionPerformed

    private void ButtonNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonNextActionPerformed
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
        if (RadioKelasAlphabetA.isSelected()) kelas = "A";
        else if (RadioKelasAlphabetB.isSelected()) kelas = "B";
        else if (RadioKelasAlphabetC.isSelected()) kelas = "C";
        else if (RadioKelasAlphabetD.isSelected()) kelas = "D";
        else if (RadioKelasAlphabetE.isSelected()) kelas = "E";
        else if (RadioKelasAlphabetF.isSelected()) kelas = "F";
        else if (RadioKelasAlphabetG.isSelected()) kelas = "G";
        else if (RadioKelasAlphabetH.isSelected()) kelas = "H";
        else if (RadioKelasAlphabetI.isSelected()) kelas = "I";
        else if (RadionKelasAlphabetJ.isSelected()) kelas = "J";
        else if (RadioKelasAlphabetK.isSelected()) kelas = "K";
        if (kelas.isEmpty()) {
            javax.swing.JOptionPane.showMessageDialog(this, "Pilih kelas!", "Validasi Gagal", javax.swing.JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Validasi alasan
        String alasan = TextAreaAlasan.getText().trim();
        if (alasan.isEmpty()) {
            javax.swing.JOptionPane.showMessageDialog(this, "Alasan dispensasi harus diisi!", "Validasi Gagal", javax.swing.JOptionPane.WARNING_MESSAGE);
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

        // Ambil waktu dari Spinner
        long calculatedReturnTimestamp = 0;
        if (CheckKembali.isSelected()) {
            java.util.Date selectedTime = (java.util.Date) SpinnerTimer.getValue();
            java.util.Calendar timeCal = java.util.Calendar.getInstance();
            timeCal.setTime(selectedTime);
            int targetHour = timeCal.get(java.util.Calendar.HOUR_OF_DAY);
            int targetMinute = timeCal.get(java.util.Calendar.MINUTE);
            
            java.util.Calendar returnCal = java.util.Calendar.getInstance();
            returnCal.set(java.util.Calendar.HOUR_OF_DAY, targetHour);
            returnCal.set(java.util.Calendar.MINUTE, targetMinute);
            returnCal.set(java.util.Calendar.SECOND, 0);
            
            if (returnCal.getTimeInMillis() < System.currentTimeMillis()) {
                returnCal.add(java.util.Calendar.DAY_OF_YEAR, 1);
            }
            calculatedReturnTimestamp = returnCal.getTimeInMillis();
        }
        final long finalReturnTimestamp = calculatedReturnTimestamp;

        // Simpan ke Firestore via PermitService
        ButtonNext.setEnabled(false);
        new javax.swing.SwingWorker<String, Void>() {
            @Override
            protected String doInBackground() throws Exception {
                com.smartschool.permit.tubespbo.repository.PermitRepository permitRepo = new com.smartschool.permit.tubespbo.repository.PermitRepository();
                com.smartschool.permit.tubespbo.service.PermitService permitService = new com.smartschool.permit.tubespbo.service.PermitService(permitRepo);

                com.smartschool.permit.tubespbo.model.StudentPermit permit = new com.smartschool.permit.tubespbo.model.StudentPermit();
                permit.setStudentName(finalNama);
                permit.setClassName(fullKelas);
                permit.setReason(alasan);
                permit.setType(com.smartschool.permit.tubespbo.model.enums.PermitType.EXIT_PERMIT);
                permit.setSchoolId("sch_001");
                
                // Set timestamps for web app compatibility
                long now = System.currentTimeMillis();
                permit.setTimestamp(now); 
                permit.setExitTimestamp(now);
                permit.setReturnTimestamp(finalReturnTimestamp); // Menggunakan waktu yang diinput

                return permitService.createPermit(permit);
            }

            @Override
            protected void done() {
                try {
                    String id = get();
                    javax.swing.JOptionPane.showMessageDialog(FormDispensasi.this,
                        "Dispensasi berhasil dicatat!\nID: " + id + "\nNama: " + finalNama + "\nKelas: " + fullKelas,
                        "Berhasil", javax.swing.JOptionPane.INFORMATION_MESSAGE);
                    // Reset form
                    FieldNama.setText("");
                    TextAreaAlasan.setText("");
                    buttonGroup1.clearSelection();
                    buttonGroup2.clearSelection();
                    jLabel8.setText("Dipilih: -");
                } catch (Exception ex) {
                    String msg = ex.getCause() != null ? ex.getCause().getMessage() : ex.getMessage();
                    javax.swing.JOptionPane.showMessageDialog(FormDispensasi.this,
                        "Gagal menyimpan: " + msg, "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
                } finally {
                    ButtonNext.setEnabled(true);
                }
            }
        }.execute();
    }//GEN-LAST:event_ButtonNextActionPerformed

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
        java.awt.EventQueue.invokeLater(() -> new FormDispensasi().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Bottom;
    private javax.swing.JButton ButtonNext;
    private javax.swing.JTextField FieldNama;
    private javax.swing.JRadioButton RadioKelasAlphabetA;
    private javax.swing.JRadioButton RadioKelasAlphabetB;
    private javax.swing.JRadioButton RadioKelasAlphabetC;
    private javax.swing.JRadioButton RadioKelasAlphabetD;
    private javax.swing.JRadioButton RadioKelasAlphabetE;
    private javax.swing.JRadioButton RadioKelasAlphabetF;
    private javax.swing.JRadioButton RadioKelasAlphabetG;
    private javax.swing.JRadioButton RadioKelasAlphabetH;
    private javax.swing.JRadioButton RadioKelasAlphabetI;
    private javax.swing.JRadioButton RadioX;
    private javax.swing.JRadioButton RadioXI;
    private javax.swing.JRadioButton RadioXII;
    private javax.swing.JRadioButton RadionKelasAlphabetJ;
    private javax.swing.JSpinner SpinnerTimer;
    private javax.swing.JTextArea TextAreaAlasan;
    private javax.swing.JPanel Top;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
