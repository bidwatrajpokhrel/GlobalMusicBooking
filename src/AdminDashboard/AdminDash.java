/*
Java Project Group 1 -- GlobalMusic Festival Booking Agency System
Bidwat Raj Pokhrel - 1812483
Aastha Pandey - 1814220
Kapendra Kathayat - 1822753
Numa Rai - 1822754
*/

package AdminDashboard;

import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;
import net.proteanit.sql.DbUtils;
import java.util.*;
import javax.swing.BorderFactory;



public class AdminDash extends javax.swing.JFrame {
    //database objects
    Connection con = null;
    PreparedStatement st = null;
    ResultSet rs = null;
    Statement s = null;
    
    
    //validation class
    Validation val = new Validation();

    //validation booleans
    private boolean phoneval = true, nameval = true, emailval = true, postcodeval = true;
    
    
    public AdminDash() {
        //db connectivity
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/festivalorg","root","");
        } catch (SQLException ex) {
            Logger.getLogger(AdminDash.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        initComponents();
        fetch();
        seticon();
        
        
    }

    //set Jframe Icon
    private void seticon(){       
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Images/LOGO.PNG")));
    }
    //close class
public void close(){
        WindowEvent winClosingEvent = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosingEvent);
    }
    @SuppressWarnings("unchecked")
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        adminDash = new javax.swing.JPanel();
        adminControl = new javax.swing.JPanel();
        viewInvoice = new javax.swing.JButton();
        editUser = new javax.swing.JButton();
        editConcert = new javax.swing.JButton();
        editBooking = new javax.swing.JButton();
        editInvoice = new javax.swing.JButton();
        log_out_btn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        adminScreen = new javax.swing.JPanel();
        cover_panel = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        adminUser = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        userTable = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        namelbl = new javax.swing.JLabel();
        usernlbl = new javax.swing.JLabel();
        userntxt = new javax.swing.JLabel();
        addtxt = new javax.swing.JTextField();
        acctypelbl = new javax.swing.JLabel();
        emailtxt = new javax.swing.JTextField();
        acctypetxt = new javax.swing.JComboBox<>();
        emaillbl = new javax.swing.JLabel();
        phnolbl = new javax.swing.JLabel();
        addlbl = new javax.swing.JLabel();
        pwlbl = new javax.swing.JLabel();
        phnotxt = new javax.swing.JTextField();
        activestattxt = new javax.swing.JComboBox<>();
        activestatlbl = new javax.swing.JLabel();
        pwtxt = new javax.swing.JPasswordField();
        nametxt = new javax.swing.JTextField();
        weblbl = new javax.swing.JLabel();
        postlbl = new javax.swing.JLabel();
        posttxt = new javax.swing.JTextField();
        webtxt = new javax.swing.JTextField();
        userupdatebtn = new javax.swing.JButton();
        name_val_lbl = new javax.swing.JLabel();
        phone_val_lbl = new javax.swing.JLabel();
        email_val_lbl = new javax.swing.JLabel();
        website_val_lbl = new javax.swing.JLabel();
        postcode_val_lbl = new javax.swing.JLabel();
        update_error_lbl = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        adminConcert = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        concertTable = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        conidlbl = new javax.swing.JLabel();
        conorglbl = new javax.swing.JLabel();
        loclbl = new javax.swing.JLabel();
        condatelbl = new javax.swing.JLabel();
        connamelbl = new javax.swing.JLabel();
        totlbl = new javax.swing.JLabel();
        pralbl = new javax.swing.JLabel();
        prblbl = new javax.swing.JLabel();
        prclbl = new javax.swing.JLabel();
        constatlbl = new javax.swing.JLabel();
        remlbl = new javax.swing.JLabel();
        conidtxt = new javax.swing.JLabel();
        connametxt = new javax.swing.JLabel();
        loctxt = new javax.swing.JLabel();
        condatetxt = new javax.swing.JLabel();
        conorgtxt = new javax.swing.JLabel();
        tottxt = new javax.swing.JLabel();
        remtxt = new javax.swing.JLabel();
        constattxt = new javax.swing.JComboBox<>();
        pratxt = new javax.swing.JTextField();
        prbtxt = new javax.swing.JTextField();
        prctxt = new javax.swing.JTextField();
        conertupdatebtn = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        adminBooking = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        bookingTable = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        bookunamelbl = new javax.swing.JLabel();
        bookidlbl = new javax.swing.JLabel();
        bookconidlbl = new javax.swing.JLabel();
        bookpaylbl = new javax.swing.JLabel();
        bookidtxt = new javax.swing.JLabel();
        bookunametxt = new javax.swing.JLabel();
        bookconidtxt = new javax.swing.JLabel();
        bookpaytxt = new javax.swing.JComboBox<>();
        bookstattxt = new javax.swing.JComboBox<>();
        bookstatlbl = new javax.swing.JLabel();
        bookupdatebtn = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        adminInvoice = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        invoiceTable = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        orgphtxt = new javax.swing.JLabel();
        create_invoice_btn = new javax.swing.JButton();
        unamelbl = new javax.swing.JLabel();
        orgnamelbl = new javax.swing.JLabel();
        orgphlbl = new javax.swing.JLabel();
        orgaddlbl = new javax.swing.JLabel();
        orgunametxt = new javax.swing.JLabel();
        orgaddtxt = new javax.swing.JLabel();
        orgnametxt = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        adminViewInvoice = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        invoiceViewTable = new javax.swing.JTable();
        jScrollPane6 = new javax.swing.JScrollPane();
        viewInvoiceDetails = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        ytxt = new javax.swing.JLabel();
        atxt = new javax.swing.JLabel();
        unlbl = new javax.swing.JLabel();
        mlbl = new javax.swing.JLabel();
        ylbl = new javax.swing.JLabel();
        albl = new javax.swing.JLabel();
        pslbl = new javax.swing.JLabel();
        pstxt = new javax.swing.JComboBox<>();
        updateInvoice = new javax.swing.JButton();
        untxt = new javax.swing.JLabel();
        mtxt = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("ADMINISTRATOR -- Global Music Concert/Music Festival Booking");
        setLocation(new java.awt.Point(360, 180));
        setMaximumSize(new java.awt.Dimension(1280, 720));
        setMinimumSize(new java.awt.Dimension(1280, 720));
        setResizable(false);

        adminDash.setMaximumSize(new java.awt.Dimension(1280, 720));
        adminDash.setMinimumSize(new java.awt.Dimension(1280, 720));
        adminDash.setPreferredSize(new java.awt.Dimension(1280, 720));

        adminControl.setBackground(new java.awt.Color(248, 229, 229));
        adminControl.setMaximumSize(new java.awt.Dimension(256, 720));
        adminControl.setMinimumSize(new java.awt.Dimension(256, 720));
        adminControl.setPreferredSize(new java.awt.Dimension(256, 720));

        viewInvoice.setBackground(new java.awt.Color(255, 94, 137));
        viewInvoice.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        viewInvoice.setText("View Invoices");
        viewInvoice.setPreferredSize(new java.awt.Dimension(230, 100));
        viewInvoice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewInvoiceActionPerformed(evt);
            }
        });

        editUser.setBackground(new java.awt.Color(255, 94, 137));
        editUser.setFont(new java.awt.Font("Georgia", 0, 18)); // NOI18N
        editUser.setText("Manage User");
        editUser.setPreferredSize(new java.awt.Dimension(230, 100));
        editUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editUserActionPerformed(evt);
            }
        });

        editConcert.setBackground(new java.awt.Color(255, 94, 137));
        editConcert.setFont(new java.awt.Font("Georgia", 0, 18)); // NOI18N
        editConcert.setText("Manage Concert");
        editConcert.setPreferredSize(new java.awt.Dimension(230, 100));
        editConcert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editConcertActionPerformed(evt);
            }
        });

        editBooking.setBackground(new java.awt.Color(255, 94, 137));
        editBooking.setFont(new java.awt.Font("Georgia", 0, 18)); // NOI18N
        editBooking.setText("Manage Booking");
        editBooking.setPreferredSize(new java.awt.Dimension(230, 100));
        editBooking.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editBookingActionPerformed(evt);
            }
        });

        editInvoice.setBackground(new java.awt.Color(255, 94, 137));
        editInvoice.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        editInvoice.setText("Manage Invoice");
        editInvoice.setPreferredSize(new java.awt.Dimension(230, 100));
        editInvoice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editInvoiceActionPerformed(evt);
            }
        });

        log_out_btn.setBackground(new java.awt.Color(255, 94, 137));
        log_out_btn.setFont(new java.awt.Font("Georgia", 0, 12)); // NOI18N
        log_out_btn.setText("Log Out");
        log_out_btn.setMaximumSize(new java.awt.Dimension(230, 30));
        log_out_btn.setMinimumSize(new java.awt.Dimension(230, 30));
        log_out_btn.setPreferredSize(new java.awt.Dimension(230, 30));
        log_out_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                log_out_btnActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Georgia", 0, 36)); // NOI18N
        jLabel1.setText("ADMIN");

        jLabel3.setFont(new java.awt.Font("Georgia", 0, 18)); // NOI18N
        jLabel3.setText("PANEL");

        javax.swing.GroupLayout adminControlLayout = new javax.swing.GroupLayout(adminControl);
        adminControl.setLayout(adminControlLayout);
        adminControlLayout.setHorizontalGroup(
            adminControlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(adminControlLayout.createSequentialGroup()
                .addGroup(adminControlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(adminControlLayout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(adminControlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(editBooking, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(editInvoice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(viewInvoice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(log_out_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(editConcert, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(editUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(adminControlLayout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addComponent(jLabel1))
                    .addGroup(adminControlLayout.createSequentialGroup()
                        .addGap(87, 87, 87)
                        .addComponent(jLabel3)))
                .addGap(5, 5, 5))
        );
        adminControlLayout.setVerticalGroup(
            adminControlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(adminControlLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(editUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(editConcert, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(editBooking, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(editInvoice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(viewInvoice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(log_out_btn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(56, Short.MAX_VALUE))
        );

        adminScreen.setBackground(new java.awt.Color(0, 204, 204));
        adminScreen.setMaximumSize(new java.awt.Dimension(1024, 720));
        adminScreen.setMinimumSize(new java.awt.Dimension(2024, 720));
        adminScreen.setPreferredSize(new java.awt.Dimension(1024, 720));
        adminScreen.setLayout(new java.awt.CardLayout());

        cover_panel.setBackground(new java.awt.Color(255, 204, 204));
        cover_panel.setPreferredSize(new java.awt.Dimension(1024, 720));

        jLabel4.setFont(new java.awt.Font("Georgia", 1, 100)); // NOI18N
        jLabel4.setText("WELCOME, ");

        jLabel5.setFont(new java.awt.Font("Georgia", 0, 75)); // NOI18N
        jLabel5.setText("Administrator!");

        jLabel6.setFont(new java.awt.Font("Georgia", 2, 48)); // NOI18N
        jLabel6.setText("Select a tab on the left to continue...");

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/admin-with-cogwheels.png"))); // NOI18N

        javax.swing.GroupLayout cover_panelLayout = new javax.swing.GroupLayout(cover_panel);
        cover_panel.setLayout(cover_panelLayout);
        cover_panelLayout.setHorizontalGroup(
            cover_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cover_panelLayout.createSequentialGroup()
                .addGroup(cover_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(cover_panelLayout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(cover_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 792, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(cover_panelLayout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(185, 185, 185))))
                    .addGroup(cover_panelLayout.createSequentialGroup()
                        .addGap(390, 390, 390)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 518, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(cover_panelLayout.createSequentialGroup()
                        .addGap(78, 78, 78)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(1116, Short.MAX_VALUE))
        );
        cover_panelLayout.setVerticalGroup(
            cover_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, cover_panelLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(75, 75, 75)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52))
        );

        adminScreen.add(cover_panel, "card7");

        adminUser.setBackground(new java.awt.Color(255, 204, 204));
        adminUser.setMaximumSize(new java.awt.Dimension(1024, 720));
        adminUser.setMinimumSize(new java.awt.Dimension(1024, 720));
        adminUser.setPreferredSize(new java.awt.Dimension(1024, 720));

        userTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Username", "Name", "Account Type", "Account Status"
            }
        ));
        userTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                userTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(userTable);

        jPanel1.setBackground(new java.awt.Color(248, 229, 229));

        namelbl.setFont(new java.awt.Font("Georgia", 1, 14)); // NOI18N
        namelbl.setText("Name");

        usernlbl.setFont(new java.awt.Font("Georgia", 1, 14)); // NOI18N
        usernlbl.setText("Username:");

        userntxt.setText("PLEASE SELECT A USER");

        addtxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addtxtActionPerformed(evt);
            }
        });

        acctypelbl.setFont(new java.awt.Font("Georgia", 1, 14)); // NOI18N
        acctypelbl.setText("Account Type:");

        emailtxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailtxtActionPerformed(evt);
            }
        });
        emailtxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                emailtxtKeyReleased(evt);
            }
        });

        acctypetxt.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Admin", "General", "Corporate", "Organizer" }));
        acctypetxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                acctypetxtActionPerformed(evt);
            }
        });

        emaillbl.setFont(new java.awt.Font("Georgia", 1, 14)); // NOI18N
        emaillbl.setText("Email:");

        phnolbl.setFont(new java.awt.Font("Georgia", 1, 14)); // NOI18N
        phnolbl.setText("Phone Number:");

        addlbl.setFont(new java.awt.Font("Georgia", 1, 14)); // NOI18N
        addlbl.setText("Address:");

        pwlbl.setFont(new java.awt.Font("Georgia", 1, 14)); // NOI18N
        pwlbl.setText("Password:");

        phnotxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                phnotxtKeyReleased(evt);
            }
        });

        activestattxt.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Active", "Deactivated" }));
        activestattxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                activestattxtActionPerformed(evt);
            }
        });

        activestatlbl.setFont(new java.awt.Font("Georgia", 1, 14)); // NOI18N
        activestatlbl.setText("Active Status:");

        nametxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nametxtActionPerformed(evt);
            }
        });
        nametxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                nametxtKeyReleased(evt);
            }
        });

        weblbl.setFont(new java.awt.Font("Georgia", 1, 14)); // NOI18N
        weblbl.setText("Website:");

        postlbl.setFont(new java.awt.Font("Georgia", 1, 14)); // NOI18N
        postlbl.setText("Post Colde:");

        posttxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                posttxtActionPerformed(evt);
            }
        });
        posttxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                posttxtKeyReleased(evt);
            }
        });

        webtxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                webtxtActionPerformed(evt);
            }
        });
        webtxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                webtxtKeyReleased(evt);
            }
        });

        userupdatebtn.setText("UPDATE");
        userupdatebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userupdatebtnActionPerformed(evt);
            }
        });

        name_val_lbl.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N
        name_val_lbl.setForeground(new java.awt.Color(255, 51, 102));

        phone_val_lbl.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N
        phone_val_lbl.setForeground(new java.awt.Color(255, 51, 102));

        email_val_lbl.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N
        email_val_lbl.setForeground(new java.awt.Color(255, 51, 102));

        website_val_lbl.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N
        website_val_lbl.setForeground(new java.awt.Color(255, 51, 102));

        postcode_val_lbl.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N
        postcode_val_lbl.setForeground(new java.awt.Color(255, 51, 102));

        update_error_lbl.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        update_error_lbl.setForeground(new java.awt.Color(255, 51, 102));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(usernlbl)
                            .addComponent(namelbl)
                            .addComponent(phnolbl)
                            .addComponent(pwlbl))
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(acctypelbl)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(addlbl)
                                .addComponent(activestatlbl)
                                .addComponent(emaillbl)))
                        .addGap(24, 24, 24)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(addtxt)
                            .addComponent(emailtxt)
                            .addComponent(phnotxt)
                            .addComponent(pwtxt)
                            .addComponent(acctypetxt, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(activestattxt, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(userntxt))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(101, 101, 101)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(weblbl)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(website_val_lbl, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(webtxt, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(postlbl)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(posttxt, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(postcode_val_lbl, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 112, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(userupdatebtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(update_error_lbl, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(26, 26, 26))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(email_val_lbl, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(phone_val_lbl, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(name_val_lbl, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nametxt, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(usernlbl)
                    .addComponent(userntxt)
                    .addComponent(weblbl, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(webtxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addComponent(website_val_lbl)
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pwlbl)
                    .addComponent(pwtxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(postlbl, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(posttxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(postcode_val_lbl)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(namelbl)
                    .addComponent(nametxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addComponent(name_val_lbl)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(phnolbl)
                    .addComponent(phnotxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(phone_val_lbl)
                .addGap(2, 2, 2)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(emaillbl, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(emailtxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(email_val_lbl)
                .addGap(1, 1, 1)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addlbl)
                    .addComponent(addtxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(update_error_lbl))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(10, 10, 10)
                            .addComponent(acctypetxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(acctypelbl))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(activestattxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(activestatlbl)
                    .addComponent(userupdatebtn, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(36, Short.MAX_VALUE))
        );

        jLabel8.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        jLabel8.setText("Select a user from table above to edit it below: ");

        jLabel9.setFont(new java.awt.Font("Georgia", 1, 36)); // NOI18N
        jLabel9.setText("EDIT USER INFORMATION");

        javax.swing.GroupLayout adminUserLayout = new javax.swing.GroupLayout(adminUser);
        adminUser.setLayout(adminUserLayout);
        adminUserLayout.setHorizontalGroup(
            adminUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(adminUserLayout.createSequentialGroup()
                .addGap(173, 173, 173)
                .addGroup(adminUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addGap(0, 1077, Short.MAX_VALUE))
            .addGroup(adminUserLayout.createSequentialGroup()
                .addGroup(adminUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(adminUserLayout.createSequentialGroup()
                        .addGap(190, 190, 190)
                        .addComponent(jLabel8))
                    .addGroup(adminUserLayout.createSequentialGroup()
                        .addGap(238, 238, 238)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 540, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        adminUserLayout.setVerticalGroup(
            adminUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(adminUserLayout.createSequentialGroup()
                .addContainerGap(97, Short.MAX_VALUE)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(65, 65, 65))
        );

        adminScreen.add(adminUser, "card2");

        adminConcert.setBackground(new java.awt.Color(255, 204, 204));
        adminConcert.setMaximumSize(new java.awt.Dimension(1024, 720));
        adminConcert.setMinimumSize(new java.awt.Dimension(1024, 720));
        adminConcert.setPreferredSize(new java.awt.Dimension(1024, 720));

        concertTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Concert ID", "Concert Name ", "Concert Location", "Concert Date"
            }
        ));
        concertTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                concertTableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(concertTable);

        jPanel2.setBackground(new java.awt.Color(248, 229, 229));

        conidlbl.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        conidlbl.setText("Concert ID:");

        conorglbl.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        conorglbl.setText("Organizer:");

        loclbl.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        loclbl.setText("Locaion:");

        condatelbl.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        condatelbl.setText("Date");

        connamelbl.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        connamelbl.setText("Name");

        totlbl.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        totlbl.setText("Total Seats:");

        pralbl.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        pralbl.setText("General Price:");

        prblbl.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        prblbl.setText("Discounted Price:");

        prclbl.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        prclbl.setText("Corporate Price: ");

        constatlbl.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        constatlbl.setText("Concert Status:");

        remlbl.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        remlbl.setText("Remaining Seats: ");

        conidtxt.setText("PLEASE SELECT A CONCERT");

        connametxt.setText("PLEASE SELECT A CONCERT");

        loctxt.setText("PLEASE SELECT A CONCERT");

        condatetxt.setText("PLEASE SELECT A CONCERT");

        conorgtxt.setText("PLEASE SELECT A CONCERT");

        tottxt.setText("PLEASE SELECT A CONCERT");

        remtxt.setText("PLEASE SELECT A CONCERT");

        constattxt.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Active", "Cancelled" }));
        constattxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                constattxtActionPerformed(evt);
            }
        });

        prbtxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prbtxtActionPerformed(evt);
            }
        });

        conertupdatebtn.setText("UPDATE");
        conertupdatebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                conertupdatebtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(conorglbl, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(loclbl, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(condatelbl, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(connamelbl, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(conidlbl, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(totlbl, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(37, 37, 37)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(conorgtxt, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(condatetxt, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(connametxt, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(loctxt, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(tottxt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(conidtxt))
                            .addGap(100, 100, 100)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(pralbl)
                                        .addComponent(prblbl))
                                    .addGap(18, 18, 18)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(prbtxt)
                                        .addComponent(pratxt)))
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addGap(1, 1, 1)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(conertupdatebtn, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                            .addComponent(prclbl)
                                            .addGap(18, 18, 18)
                                            .addComponent(prctxt, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(remlbl)
                                .addComponent(constatlbl))
                            .addGap(18, 18, 18)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(remtxt)
                                .addComponent(constattxt, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addContainerGap(41, Short.MAX_VALUE)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 319, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(conidlbl)
                        .addComponent(pralbl)
                        .addComponent(conidtxt)
                        .addComponent(pratxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(connamelbl)
                        .addComponent(prblbl)
                        .addComponent(connametxt)
                        .addComponent(prbtxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(loclbl)
                        .addComponent(prclbl)
                        .addComponent(loctxt)
                        .addComponent(prctxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(10, 10, 10)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(condatelbl)
                        .addComponent(condatetxt))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(conorglbl)
                        .addComponent(conorgtxt))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(totlbl)
                        .addComponent(tottxt))
                    .addGap(18, 18, 18)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(remlbl)
                        .addComponent(remtxt)
                        .addComponent(conertupdatebtn, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(constatlbl)
                        .addComponent(constattxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        jLabel10.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        jLabel10.setText("Please select a concert from the table above to edit it's details below:");

        jLabel11.setFont(new java.awt.Font("Georgia", 1, 36)); // NOI18N
        jLabel11.setText("View and Edit Concerts");

        javax.swing.GroupLayout adminConcertLayout = new javax.swing.GroupLayout(adminConcert);
        adminConcert.setLayout(adminConcertLayout);
        adminConcertLayout.setHorizontalGroup(
            adminConcertLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(adminConcertLayout.createSequentialGroup()
                .addGroup(adminConcertLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(adminConcertLayout.createSequentialGroup()
                        .addGap(128, 128, 128)
                        .addGroup(adminConcertLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel10)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 703, Short.MAX_VALUE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(adminConcertLayout.createSequentialGroup()
                        .addGap(266, 266, 266)
                        .addComponent(jLabel11)))
                .addGap(0, 193, Short.MAX_VALUE))
        );
        adminConcertLayout.setVerticalGroup(
            adminConcertLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(adminConcertLayout.createSequentialGroup()
                .addGap(106, 106, 106)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(jLabel10)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 71, Short.MAX_VALUE))
        );

        adminScreen.add(adminConcert, "card2");

        adminBooking.setBackground(new java.awt.Color(255, 204, 204));
        adminBooking.setMaximumSize(new java.awt.Dimension(1024, 720));
        adminBooking.setMinimumSize(new java.awt.Dimension(1024, 720));
        adminBooking.setPreferredSize(new java.awt.Dimension(1024, 862));

        bookingTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "BookingId", "Username", "Concert Name", "Concert Date"
            }
        ));
        bookingTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bookingTableMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(bookingTable);

        jPanel3.setBackground(new java.awt.Color(248, 229, 229));

        bookunamelbl.setFont(new java.awt.Font("Georgia", 1, 14)); // NOI18N
        bookunamelbl.setText("Username:");

        bookidlbl.setFont(new java.awt.Font("Georgia", 1, 14)); // NOI18N
        bookidlbl.setText("Booking ID:");

        bookconidlbl.setFont(new java.awt.Font("Georgia", 1, 14)); // NOI18N
        bookconidlbl.setText("Concert ID: ");

        bookpaylbl.setFont(new java.awt.Font("Georgia", 1, 14)); // NOI18N
        bookpaylbl.setText("Payment Status:");

        bookidtxt.setText("PLEASE SELECT A BOOKING");

        bookunametxt.setText("PLEASE SELECT A BOOKING");

        bookconidtxt.setText("PLEASE SELECT A BOOKING");

        bookpaytxt.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Paid", "Unpaid" }));
        bookpaytxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bookpaytxtActionPerformed(evt);
            }
        });

        bookstattxt.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Active", "Cancelled", " " }));
        bookstattxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bookstattxtActionPerformed(evt);
            }
        });

        bookstatlbl.setFont(new java.awt.Font("Georgia", 1, 14)); // NOI18N
        bookstatlbl.setText("Booking Status:");

        bookupdatebtn.setText("Update");
        bookupdatebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bookupdatebtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(602, 602, 602)
                .addComponent(bookupdatebtn, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(bookidlbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(bookconidlbl, javax.swing.GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE)
                                .addComponent(bookunamelbl, javax.swing.GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(bookunametxt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(bookidtxt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(bookconidtxt, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addComponent(bookpaylbl)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(bookpaytxt, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addComponent(bookstatlbl)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(bookstattxt, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGap(1664, 1664, 1664)))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(bookupdatebtn, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54))
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(bookidlbl, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(bookidtxt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGap(9, 9, 9)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(bookunamelbl, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(bookunametxt))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(bookconidlbl, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(bookconidtxt))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(bookpaylbl, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(bookpaytxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(bookstatlbl, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(bookstattxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(131, 131, 131)))
        );

        jLabel12.setText("Please select a booking in the table above to view and edit it");

        jLabel13.setFont(new java.awt.Font("Georgia", 0, 36)); // NOI18N
        jLabel13.setText("View and Edit Bookings");

        javax.swing.GroupLayout adminBookingLayout = new javax.swing.GroupLayout(adminBooking);
        adminBooking.setLayout(adminBookingLayout);
        adminBookingLayout.setHorizontalGroup(
            adminBookingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(adminBookingLayout.createSequentialGroup()
                .addGroup(adminBookingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(adminBookingLayout.createSequentialGroup()
                        .addGap(140, 140, 140)
                        .addGroup(adminBookingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 725, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12)
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 725, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(adminBookingLayout.createSequentialGroup()
                        .addGap(282, 282, 282)
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 405, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(159, Short.MAX_VALUE))
        );
        adminBookingLayout.setVerticalGroup(
            adminBookingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(adminBookingLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel12)
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(142, 142, 142))
        );

        adminScreen.add(adminBooking, "card2");

        adminInvoice.setBackground(new java.awt.Color(255, 204, 204));
        adminInvoice.setMaximumSize(new java.awt.Dimension(1024, 720));
        adminInvoice.setMinimumSize(new java.awt.Dimension(1024, 720));
        adminInvoice.setPreferredSize(new java.awt.Dimension(1024, 720));

        invoiceTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Corporate username", "Corporate Address", "Corporate website", "Corporate Phone"
            }
        ));
        invoiceTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                invoiceTableMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(invoiceTable);

        jPanel4.setBackground(new java.awt.Color(248, 229, 229));

        orgphtxt.setText("PLEASE SELECT A USER TO GENERATE INVOICE");

        create_invoice_btn.setFont(new java.awt.Font("Georgia", 1, 14)); // NOI18N
        create_invoice_btn.setText("Generate Invoice");
        create_invoice_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                create_invoice_btnActionPerformed(evt);
            }
        });

        unamelbl.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        unamelbl.setText("Username:");

        orgnamelbl.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        orgnamelbl.setText("Name:");

        orgphlbl.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        orgphlbl.setText("Phone Number: ");

        orgaddlbl.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        orgaddlbl.setText("Address:");

        orgunametxt.setText("PLEASE SELECT A USER TO GENERATE INVOICE");

        orgaddtxt.setText("PLEASE SELECT A USER TO GENERATE INVOICE");

        orgnametxt.setText("PLEASE SELECT A USER TO GETERATE INVOICE");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(orgaddlbl, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(unamelbl, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(orgnamelbl, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(55, 55, 55)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(orgunametxt, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(orgaddtxt, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(orgnametxt, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(orgphlbl, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(orgphtxt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 83, Short.MAX_VALUE)
                .addComponent(create_invoice_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(unamelbl, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(orgunametxt, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(orgnamelbl, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(orgnametxt, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(orgaddlbl, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(orgaddtxt, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(orgphlbl, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(orgphtxt, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(57, 57, 57))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(create_invoice_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33))))
        );

        jLabel14.setFont(new java.awt.Font("Georgia", 1, 14)); // NOI18N
        jLabel14.setText("Please select a user int the table above to create invoice");

        jLabel15.setFont(new java.awt.Font("Georgia", 1, 36)); // NOI18N
        jLabel15.setText("GENREATE INVOICE");

        javax.swing.GroupLayout adminInvoiceLayout = new javax.swing.GroupLayout(adminInvoice);
        adminInvoice.setLayout(adminInvoiceLayout);
        adminInvoiceLayout.setHorizontalGroup(
            adminInvoiceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(adminInvoiceLayout.createSequentialGroup()
                .addGap(118, 118, 118)
                .addGroup(adminInvoiceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane4)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, adminInvoiceLayout.createSequentialGroup()
                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 419, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(156, 156, 156)))
                .addContainerGap(143, Short.MAX_VALUE))
        );
        adminInvoiceLayout.setVerticalGroup(
            adminInvoiceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(adminInvoiceLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel14)
                .addGap(18, 18, 18)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(80, Short.MAX_VALUE))
        );

        adminScreen.add(adminInvoice, "card2");

        adminViewInvoice.setBackground(new java.awt.Color(255, 204, 204));
        adminViewInvoice.setMaximumSize(new java.awt.Dimension(1024, 720));
        adminViewInvoice.setMinimumSize(new java.awt.Dimension(1024, 720));
        adminViewInvoice.setPreferredSize(new java.awt.Dimension(1024, 720));

        jLabel2.setFont(new java.awt.Font("Georgia", 1, 14)); // NOI18N
        jLabel2.setText("SELECT INVOICE IN THE FIRST TABLE TO VIEW BOOKINGS AND CONCERTS IN SECOND TABLE");

        invoiceViewTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        invoiceViewTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                invoiceViewTableMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(invoiceViewTable);

        viewInvoiceDetails.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane6.setViewportView(viewInvoiceDetails);

        jPanel5.setBackground(new java.awt.Color(248, 229, 229));

        ytxt.setText("SELECT");

        atxt.setText("SELECT");

        unlbl.setFont(new java.awt.Font("Georgia", 1, 14)); // NOI18N
        unlbl.setText("Username: ");

        mlbl.setFont(new java.awt.Font("Georgia", 1, 14)); // NOI18N
        mlbl.setText("Month:");

        ylbl.setFont(new java.awt.Font("Georgia", 1, 14)); // NOI18N
        ylbl.setText("Year:");

        albl.setFont(new java.awt.Font("Georgia", 1, 14)); // NOI18N
        albl.setText("Amount:");

        pslbl.setFont(new java.awt.Font("Georgia", 1, 14)); // NOI18N
        pslbl.setText("Payment Status:");

        pstxt.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Paid", "Unpaid" }));

        updateInvoice.setFont(new java.awt.Font("Georgia", 1, 14)); // NOI18N
        updateInvoice.setText("Confirm");
        updateInvoice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateInvoiceActionPerformed(evt);
            }
        });

        untxt.setText("SELECT");

        mtxt.setText("SELECT");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(303, 303, 303)
                        .addComponent(pslbl)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(pstxt, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel5Layout.createSequentialGroup()
                        .addComponent(unlbl, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(untxt, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addComponent(mlbl)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(mtxt, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(ylbl)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ytxt, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(albl)))
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(updateInvoice))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(atxt, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(43, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(unlbl)
                    .addComponent(ylbl)
                    .addComponent(albl)
                    .addComponent(mlbl)
                    .addComponent(untxt)
                    .addComponent(mtxt)
                    .addComponent(ytxt)
                    .addComponent(atxt))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pslbl)
                    .addComponent(pstxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(updateInvoice))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        jLabel16.setFont(new java.awt.Font("Georgia", 1, 36)); // NOI18N
        jLabel16.setText("VIEW GENERATED INVOICE");

        javax.swing.GroupLayout adminViewInvoiceLayout = new javax.swing.GroupLayout(adminViewInvoice);
        adminViewInvoice.setLayout(adminViewInvoiceLayout);
        adminViewInvoiceLayout.setHorizontalGroup(
            adminViewInvoiceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(adminViewInvoiceLayout.createSequentialGroup()
                .addGroup(adminViewInvoiceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(adminViewInvoiceLayout.createSequentialGroup()
                        .addGap(117, 117, 117)
                        .addGroup(adminViewInvoiceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 784, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(adminViewInvoiceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jScrollPane6))
                            .addComponent(jLabel2)))
                    .addGroup(adminViewInvoiceLayout.createSequentialGroup()
                        .addGap(224, 224, 224)
                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 562, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(123, Short.MAX_VALUE))
        );
        adminViewInvoiceLayout.setVerticalGroup(
            adminViewInvoiceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(adminViewInvoiceLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, 76, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(72, 72, 72))
        );

        adminScreen.add(adminViewInvoice, "card6");

        javax.swing.GroupLayout adminDashLayout = new javax.swing.GroupLayout(adminDash);
        adminDash.setLayout(adminDashLayout);
        adminDashLayout.setHorizontalGroup(
            adminDashLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(adminDashLayout.createSequentialGroup()
                .addComponent(adminControl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(adminScreen, javax.swing.GroupLayout.DEFAULT_SIZE, 2024, Short.MAX_VALUE))
        );
        adminDashLayout.setVerticalGroup(
            adminDashLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(adminControl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(adminScreen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(adminDash, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(adminDash, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //invoice generation method
    private void generate_invoice(String username) throws ParseException{

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String today[] = (sdf.format(Calendar.getInstance().getTime())).split("-");
        int y = Integer.parseInt(today[0]);
        int m = (Integer.parseInt(today[1])) - 1;
        String year = Integer.toString(y);
        String month = Integer.toString(m);
        try {
            String query = "SELECT * FROM invoice";
            s = con.createStatement();
            rs = s.executeQuery(query);
            boolean checkinvoice = true;
            while(rs.next()){
                if ((rs.getString("year").equals(year)) && (rs.getString("month").equals(month)) && (rs.getString("userName").equals(username))){
                    checkinvoice = false;
                    JOptionPane.showMessageDialog(null, "Last Month's invoice already generated for user");
                    break;
                } else {
                    checkinvoice = true;
                }
            }
            if (checkinvoice){
                
                //SELECT booking.numberofTickets, concert.priceC FROM booking INNER JOIN concert ON booking.concertID = concert.concertId WHERE booking.username = "hello";  
               String query1 = "SELECT booking.numberofTickets, booking.bookingDate, concert.priceC FROM booking INNER JOIN concert ON booking.concertID = concert.concertId WHERE booking.userName = \"" + username + "\"";
                s = con.createStatement();
                rs = s.executeQuery(query1);
                java.util.Date first_day = sdf.parse(year +"-"+ month +"-"+ "1");
                java.util.Date last_day = null;
                if (month.equals("1") || month.equals("3")|| month.equals("5")||month.equals("7")|| month.equals("8")|| month.equals("10")|| month.equals("12")){
                     last_day = sdf.parse(year +"-"+ month +"-"+ "31");
                } else if (month.equals("4") || month.equals("6")|| month.equals("9")||month.equals("11")){
                    last_day = sdf.parse(year +"-"+ month +"-"+ "30");
                } else {
                    last_day = sdf.parse(year +"-"+ month +"-"+ "29");
                }
                int totalPrice = 0, totalBooking = 0, totalTickets = 0;
                
                while (rs.next()){
                    if (first_day.before(sdf.parse(rs.getString(2))) && last_day.after(sdf.parse(rs.getString(2)))){
                        totalPrice += (Integer.parseInt(rs.getString(1)) * Integer.parseInt(rs.getString(3)));
                        totalBooking += 1;
                        totalTickets += (Integer.parseInt(rs.getString(1)));                                
                    }                    
                }
                String query2 = "INSERT INTO invoice (userName, year, month, amount, paymentStatus,totalBooking, totalTickets)  VALUES (?, ?, ?, ? ,?, ?, ?)";
                st = con.prepareStatement(query2);
                st.setString(1, username);
                st.setString(2, year);
                st.setString(3, month);
                st.setInt(4, totalPrice);
                st.setString(5, "unpaid");
                st.setInt(6, totalBooking);
                st.setInt(7, totalTickets);
                
                st.executeUpdate();
                JOptionPane.showMessageDialog(null, "INVOICE CREATED for user:  " + username );
            }
                
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "SQLCONNECTIVITY ERROR");
        }
        
        
    }
    
    //fetch all tables
    private void fetch(){
        try{
            String query = "SELECT userName, Name, accountType, accountStatus FROM user;";
            st = con.prepareStatement(query);
            rs = st.executeQuery();
            userTable.setModel(DbUtils.resultSetToTableModel(rs));
            
            String query1 = "SELECT concertId, concertName, location, date FROM concert;";
            st = con.prepareStatement(query1);
            rs = st.executeQuery();
            concertTable.setModel(DbUtils.resultSetToTableModel(rs));
            String query2 = "SELECT booking.bookingId, booking.userName, concert.concertName, concert.date FROM booking LEFT JOIN concert ON booking.concertID = concert.concertID;";
            st = con.prepareStatement(query2);
            rs = st.executeQuery();
            bookingTable.setModel(DbUtils.resultSetToTableModel(rs));
            
            String query3 = "SELECT userName, address, website, contactNumber FROM user WHERE accountType = \"corporate\";";
            st = con.prepareStatement(query3);
            rs = st.executeQuery();
            invoiceTable.setModel(DbUtils.resultSetToTableModel(rs));
            
            String query4 = "SELECT invoiceId, userName, month, year FROM invoice;";
            st = con.prepareStatement(query4);
            rs = st.executeQuery();
            invoiceViewTable.setModel(DbUtils.resultSetToTableModel(rs));
            
            
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    //fetch booking table from selected invoice
    private void fetch_bookings(String username, String year, String month) throws ParseException{
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");        
        java.util.Date start1 = sdf.parse(year +"-"+ month +"-"+ "1");
        java.util.Date end1 = null;
        if (month.equals("1") || month.equals("3")|| month.equals("5")||month.equals("7")|| month.equals("8")|| month.equals("10")|| month.equals("12")){
             end1 = sdf.parse(year +"-"+ month +"-"+ "31");
        } else if (month.equals("4") || month.equals("6")|| month.equals("9")||month.equals("11")){
            end1  = sdf.parse(year +"-"+ month +"-"+ "31");
        } else {
            end1 = sdf.parse(year +"-"+ month +"-"+ "29");
        }
        String start = sdf.format(start1); 
        String end = sdf.format(end1);
        try {
            String query0 = "SELECT bookingId, concertId, numberofTickets, bookingDate FROM booking WHERE userName = \"" + username + "\" AND \"" +start+ "\" < bookingDate AND bookingDate < \"" + end + "\"";
            st = con.prepareStatement(query0);
            System.out.println(st);
            rs = st.executeQuery();
            viewInvoiceDetails.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }
    
    //clear all fields
    private void clear_feilds(){
        acctypetxt.setSelectedIndex(1);
        activestattxt.setSelectedIndex(1);
        addtxt.setText(null);
        bookconidtxt.setText(null);
        bookidtxt.setText(null);
        bookpaytxt.setSelectedIndex(1);
        bookstattxt.setSelectedIndex(1);
        bookunametxt.setText(null);
        condatetxt.setText(null);
        conidtxt.setText(null);
        constattxt.setSelectedIndex(1);
        emailtxt.setText(null);
        loctxt.setText(null);
        nametxt.setText(null);
        phnotxt.setText(null);
        posttxt.setText(null);
        pratxt.setText(null);
        prbtxt.setText(null);
        prctxt.setText(null);
        pwtxt.setText(null);
        remtxt.setText(null);
        tottxt.setText(null);
        userntxt.setText(null);
        webtxt.setText(null);
        connametxt.setText(null);
        conorgtxt.setText(null);
    }
    
    
    //SIDE PANEL BUTTON CONFIG:::::::::::::::::
    
    private void editInvoiceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editInvoiceActionPerformed
        adminScreen.removeAll();
        adminScreen.repaint();
        adminScreen.revalidate();
        adminScreen.add(adminInvoice);
        adminScreen.repaint();
        adminScreen.revalidate();
        editInvoice.setBorder(BorderFactory.createLineBorder(new Color (0, 0, 0), 5));
        editBooking.setBorder(BorderFactory.createEmptyBorder());
        editConcert.setBorder(BorderFactory.createEmptyBorder());
        editUser.setBorder(BorderFactory.createEmptyBorder());
        viewInvoice.setBorder(BorderFactory.createEmptyBorder());
        clear_feilds();
        
    }//GEN-LAST:event_editInvoiceActionPerformed

    private void editBookingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editBookingActionPerformed
        adminScreen.removeAll();
        adminScreen.repaint();
        adminScreen.revalidate();
        adminScreen.add(adminBooking);
        adminScreen.repaint();
        adminScreen.revalidate();
        editInvoice.setBorder(BorderFactory.createEmptyBorder());
        editBooking.setBorder(BorderFactory.createLineBorder(new Color (0, 0, 0), 5));
        editConcert.setBorder(BorderFactory.createEmptyBorder());
        editUser.setBorder(BorderFactory.createEmptyBorder());
        viewInvoice.setBorder(BorderFactory.createEmptyBorder());
        clear_feilds();
    }//GEN-LAST:event_editBookingActionPerformed

    private void editConcertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editConcertActionPerformed
        adminScreen.removeAll();
        adminScreen.repaint();
        adminScreen.revalidate();
        adminScreen.add(adminConcert);
        adminScreen.repaint();
        adminScreen.revalidate();
        editInvoice.setBorder(BorderFactory.createEmptyBorder());
        editBooking.setBorder(BorderFactory.createEmptyBorder());
        editConcert.setBorder(BorderFactory.createLineBorder(new Color (0, 0, 0), 5));
        editUser.setBorder(BorderFactory.createEmptyBorder());
        viewInvoice.setBorder(BorderFactory.createEmptyBorder());
        clear_feilds();
    }//GEN-LAST:event_editConcertActionPerformed

    private void editUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editUserActionPerformed
        adminScreen.removeAll();
        adminScreen.repaint();
        adminScreen.revalidate();
        adminScreen.add(adminUser);
        adminScreen.repaint();
        adminScreen.revalidate();
        editInvoice.setBorder(BorderFactory.createEmptyBorder());
        editBooking.setBorder(BorderFactory.createEmptyBorder());
        editConcert.setBorder(BorderFactory.createEmptyBorder());
        editUser.setBorder(BorderFactory.createLineBorder(new Color (0, 0, 0), 5));
        viewInvoice.setBorder(BorderFactory.createEmptyBorder());
        clear_feilds();
    }//GEN-LAST:event_editUserActionPerformed

    
    
    //junk
    private void addtxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addtxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addtxtActionPerformed

    private void emailtxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailtxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emailtxtActionPerformed

    private void acctypetxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_acctypetxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_acctypetxtActionPerformed

    private void activestattxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_activestattxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_activestattxtActionPerformed

    //USER info fetch
    private void userTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_userTableMouseClicked
        int i = userTable.getSelectedRow();
        TableModel model = userTable.getModel();

        try {
            
            String query2 = ("SELECT * FROM user WHERE username = \"" + model.getValueAt(i, 0).toString() + "\"");
            s = con.createStatement();
            rs = s.executeQuery(query2);
            rs.next();
            userntxt.setText(rs.getString("userName"));
            pwtxt.setText(rs.getString("password"));
            nametxt.setText(rs.getString("name")); 
            phnotxt.setText(rs.getString("contactNumber"));
            emailtxt.setText(rs.getString("email"));
            addtxt.setText(rs.getString("address"));
            webtxt.setText(rs.getString("website"));
            posttxt.setText(rs.getString("postCode"));
            
            switch (rs.getString("accountType")) {
                case "admin":
                    acctypetxt.setSelectedItem("Admin");
                    break;
                case "corporate":
                    acctypetxt.setSelectedItem("Corporate");
                    break;
                case "organizer":
                    acctypetxt.setSelectedItem("Organizer");
                    break;
                default:
                    acctypetxt.setSelectedItem("General");
                    break;
            }
            
            if (rs.getString("accountStatus").equals("active")){
                activestattxt.setSelectedItem("Active");
            }else{
                activestattxt.setSelectedItem("Deactivated");
            }
                        
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }//GEN-LAST:event_userTableMouseClicked

    
    //junk
    private void nametxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nametxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nametxtActionPerformed

    private void posttxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_posttxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_posttxtActionPerformed

    private void webtxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_webtxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_webtxtActionPerformed

    
    //update user info
    private void userupdatebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userupdatebtnActionPerformed
        boolean updatecheck = false;
        if ( nameval && phoneval && emailval && postcodeval && !(addtxt.getText().equals("")) && !(pwtxt.getText().equals(""))) {
            updatecheck = true;
            
        } else {
           updatecheck = false;
           update_error_lbl.setText("Please check validations and fill all required feilds");
        }
        if(updatecheck){
        try{
           int row = userTable.getSelectedRow();
           String value = (userTable.getModel().getValueAt(row, 0).toString());
           String query3 = "UPDATE user SET password = ?, name = ?, contactNumber = ?, email = ?, address = ?, postcode = ?, accountType = ? , accountStatus = ?, website = ? where userName = \""+value + "\"";

           st = con.prepareStatement(query3);
           st.setString(1, pwtxt.getText());
           st.setString(2, nametxt.getText()); 
           st.setString(3, phnotxt.getText());
           st.setString(4, emailtxt.getText());
           st.setString(5, addtxt.getText());
           st.setString(6, posttxt.getText());
           if (acctypetxt.getSelectedItem().equals("Admin")){
               st.setString(7, "admin");
           }else if (acctypetxt.getSelectedItem().equals("Corporate")){
               st.setString(7, "corporate");
           } else if (acctypetxt.getSelectedItem().equals("Organizer")){
               st.setString(7, "organizer");
           } else{
               st.setString(7, "general");
           }
           
            if (activestattxt.getSelectedItem().equals("Active")){
               st.setString(8, "active");
           }else{
               st.setString(8, "inactive");
           }
            
           st.setString(9 , webtxt.getText());
           st.executeUpdate();
           
           JOptionPane.showMessageDialog(null, "Successfully updated");
           
           fetch();
           clear_feilds();
           
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Update Failed! Database Error Suspected.");
        }
        }
    }//GEN-LAST:event_userupdatebtnActionPerformed

    
    //junk
    private void constattxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_constattxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_constattxtActionPerformed

    private void prbtxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prbtxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_prbtxtActionPerformed

    
    //get concert info from table into labels and textfields
    private void concertTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_concertTableMouseClicked
        int i = concertTable.getSelectedRow();
        TableModel model = concertTable.getModel();

        try {
            String query2 = ("SELECT * FROM concert WHERE concertId = \"" + model.getValueAt(i, 0).toString() + "\"");
            s = con.createStatement();
            rs = s.executeQuery(query2);
            rs.next();
            conidtxt.setText(rs.getString("concertId"));
            connametxt.setText(rs.getString("concertName"));
            loctxt.setText(rs.getString("location")); 
            condatetxt.setText(rs.getString("date"));
            tottxt.setText(rs.getString("totalSeats"));
            remtxt.setText(rs.getString("remainingSeats"));
            conorgtxt.setText(rs.getString("organizer"));
            pratxt.setText(rs.getString("priceA"));
            prbtxt.setText(rs.getString("priceB"));
            prctxt.setText(rs.getString("priceC"));

            
            if (rs.getString("concertStatus").equals("active")){
                constattxt.setSelectedItem("Active");
            }else{
                constattxt.setSelectedItem("Cancelled");
            }
                        
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }//GEN-LAST:event_concertTableMouseClicked

    
    //update conert
    private void conertupdatebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_conertupdatebtnActionPerformed
        try{
           int row = concertTable.getSelectedRow();
           String value = (concertTable.getModel().getValueAt(row, 0).toString());
           String queryB = "UPDATE concert SET priceA = ?, priceB = ?, priceC = ?, concertStatus = ? where concertId = \"" +value + "\"";

           st = con.prepareStatement(queryB);
           st.setString(1, pratxt.getText());
           st.setString(2, prbtxt.getText()); 
           st.setString(3, prctxt.getText());         
           if (constattxt.getSelectedItem().equals("Active")){
               st.setString(4, "active");
           }else{
               st.setString(4, "cancelled");
           }
           st.executeUpdate();
           
           fetch();
           
            clear_feilds();
           
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_conertupdatebtnActionPerformed

    //junk
    private void bookpaytxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bookpaytxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bookpaytxtActionPerformed

    
    //booking info populate
    private void bookingTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bookingTableMouseClicked
        int i = bookingTable.getSelectedRow();
        TableModel model = bookingTable.getModel();

        try {
            String query2 = ("SELECT * FROM booking WHERE bookingId = \"" + model.getValueAt(i, 0).toString() + "\"");
            s = con.createStatement();
            rs = s.executeQuery(query2);
            rs.next();
            bookidtxt.setText(rs.getString("bookingId"));
            bookunametxt.setText(rs.getString("userName"));
            bookconidtxt.setText(rs.getString("concertId"));             
            if (rs.getString("bookingPayment").equals("paid")){
                bookpaytxt.setSelectedItem("Paid");
            }else{
                bookpaytxt.setSelectedItem("Unpaid");
            }
            
             if (rs.getString("bookingStatus").equals("active")){
                bookstattxt.setSelectedItem("Active");
            }else{
                bookstattxt.setSelectedItem("Cancelled");
            }     
                      
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }//GEN-LAST:event_bookingTableMouseClicked

    //junk
    private void bookstattxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bookstattxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bookstattxtActionPerformed

    
    //update booking
    private void bookupdatebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bookupdatebtnActionPerformed
        try{
           int row = bookingTable.getSelectedRow();
           String value = (bookingTable.getModel().getValueAt(row, 0).toString());
           String queryC = "UPDATE booking SET bookingStatus = ? , bookingPayment = ? WHERE bookingId = \"" +value + "\"";

           PreparedStatement pst = con.prepareStatement(queryC);
        
           if (bookstattxt.getSelectedItem().equals("Active")){
               pst.setString(1, "active");
           }else{
               pst.setString(1, "cancelled");
           }
           
            if (bookpaytxt.getSelectedItem().equals("Paid")){
               pst.setString(2, "paid");
           }else{
               pst.setString(2, "unpaid");
           }
           pst.executeUpdate();
            
           fetch();
           clear_feilds();

           
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
        
    }//GEN-LAST:event_bookupdatebtnActionPerformed

    
    //invoice details fetch
    private void invoiceTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_invoiceTableMouseClicked
        int i = invoiceTable.getSelectedRow();
        TableModel model = invoiceTable.getModel();

        try {
            String query2 = ("SELECT * FROM user WHERE userName = \"" + model.getValueAt(i, 0).toString() + "\"");
            s = con.createStatement();
            rs = s.executeQuery(query2);
            rs.next();
            orgnametxt.setText(rs.getString("Name"));
            orgunametxt.setText(rs.getString("userName"));
            orgaddtxt.setText(rs.getString("address"));             
            orgphtxt.setText(rs.getString("contactNumber"));
                      
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }//GEN-LAST:event_invoiceTableMouseClicked

    
    //create invoice
    private void create_invoice_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_create_invoice_btnActionPerformed
         int row = invoiceTable.getSelectedRow();
         String value = (invoiceTable.getModel().getValueAt(row, 0).toString());
        try {
            generate_invoice(value);
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
         
        
    }//GEN-LAST:event_create_invoice_btnActionPerformed

    
    //view invoices (sidepanel button )
    private void viewInvoiceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewInvoiceActionPerformed
        adminScreen.removeAll();
        adminScreen.repaint();
        adminScreen.revalidate();
        adminScreen.add(adminViewInvoice);
        adminScreen.repaint();
        adminScreen.revalidate();
        editInvoice.setBorder(BorderFactory.createEmptyBorder());
        editBooking.setBorder(BorderFactory.createEmptyBorder());
        editConcert.setBorder(BorderFactory.createEmptyBorder());
        editUser.setBorder(BorderFactory.createEmptyBorder());
        viewInvoice.setBorder(BorderFactory.createLineBorder(new Color (0, 0, 0), 5));
        clear_feilds();
        fetch();
    }//GEN-LAST:event_viewInvoiceActionPerformed

    
    //VIEW INVOICE DETAILS SUCH AS BOOKINGS AND OTHERS
    private void invoiceViewTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_invoiceViewTableMouseClicked
        try {
            int i = invoiceViewTable.getSelectedRow();        
            TableModel model = invoiceViewTable.getModel();
            String query = ("SELECT * FROM invoice WHERE invoiceId = \"" + model.getValueAt(i, 0).toString() + "\"");
            s = con.createStatement();
            rs = s.executeQuery(query);
            rs.next();
            String usern = rs.getString("userName");
            String y = rs.getString("year");
            String m = rs.getString ("month");
            if (rs.getString("paymentStatus").equals("paid")){
                pstxt.setSelectedIndex(0);
            } else {
                pstxt.setSelectedIndex(1);
            }
            untxt.setText(rs.getString("userName"));
            mtxt.setText(rs.getString("month"));
            ytxt.setText(rs.getString("year"));
            atxt.setText(rs.getString("amount"));
            
            try {
                fetch_bookings(usern, y, m);
            } catch (ParseException ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }//GEN-LAST:event_invoiceViewTableMouseClicked

    
    //GET THE FIRST DAY OF THE LAST MONTH 
    public String convertDateStart(String month, String year){
        
        String start = null;
        try{    
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");         
            java.util.Date start1 = sdf.parse(year +"-"+ month +"-"+ "1");
            start = sdf.format(start1);             
        } catch (ParseException e){
            JOptionPane.showMessageDialog(null, e);
        }
        return start;
    }
    
    //GET LAST DAY OF THE LAST (PREVIOUS) MONTH
    public String convertDateEnd(String month, String year){
        
        String start = null, end = null;
        try{    
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");         
            java.util.Date end1 = null;
            if (month.equals("1") || month.equals("3")|| month.equals("5")||month.equals("7")|| month.equals("8")|| month.equals("10")|| month.equals("12")){
                 end1 = sdf.parse(year +"-"+ month +"-"+ "31");
            } else if (month.equals("4") || month.equals("6")|| month.equals("9")||month.equals("11")){
                end1  = sdf.parse(year +"-"+ month +"-"+ "30");
            } else {
                end1 = sdf.parse(year +"-"+ month +"-"+ "29");
            }
            end = sdf.format(end1);
        } catch (ParseException e){
            JOptionPane.showMessageDialog(null, e);
        }
        return end;
    }
    
    //UPDATE INVOICE PAID/UNPAID 
    private void updateInvoiceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateInvoiceActionPerformed
        try{
           int row = invoiceViewTable.getSelectedRow();
           String value = (invoiceViewTable.getModel().getValueAt(row, 0).toString());
           String usern = ((invoiceViewTable.getModel().getValueAt(row, 1).toString()));
           String month = (invoiceViewTable.getModel().getValueAt(row, 2).toString());
           String year = ((invoiceViewTable.getModel().getValueAt(row, 3).toString()));
           String queryC = "UPDATE invoice SET paymentStatus = ? WHERE invoiceId = \"" +value + "\"";
           st = con.prepareStatement(queryC);
           String paymentstat = null; 
           if (pstxt.getSelectedItem().equals("Paid")){
               st.setString(1, "paid");   
               paymentstat = "paid";
           }else{
               st.setString(1, "unpaid");
               paymentstat = "unpaid";
           }
    
           
           st.executeUpdate();
           
           String start = convertDateStart(month, year);
           String end = convertDateEnd(month, year);
           String query = "UPDATE booking SET bookingPayment = \"" + paymentstat +"\" WHERE userName = \"" + usern + "\" AND \"" +start+ "\" < bookingDate AND bookingDate < \"" + end + "\"";
           
           st = con.prepareStatement(query); //findme
           System.out.println(st);
           st.executeUpdate();
      
           JOptionPane.showMessageDialog(null, "UPDATED");
        } catch (SQLException e){
            JOptionPane.showMessageDialog(null, e);
        }           
    }//GEN-LAST:event_updateInvoiceActionPerformed

    
    //LOGOUT
    private void log_out_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_log_out_btnActionPerformed
        LoginRegister lr = new LoginRegister();
        lr.setVisible(true);
        close();
    }//GEN-LAST:event_log_out_btnActionPerformed

    
    //validations
    private void nametxtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nametxtKeyReleased
        if (val.nameTest(nametxt.getText())){
            name_val_lbl.setText("");
            nameval = true;
        } else {
            name_val_lbl.setText("Enter a valid name");
            nameval = false;
        }
    }//GEN-LAST:event_nametxtKeyReleased

    private void phnotxtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_phnotxtKeyReleased
        if (val.phoneTest(phnotxt.getText())){
            phone_val_lbl.setText("");
            phoneval = true;
        }else {
            phone_val_lbl.setText("Enter a valid Phone number");
            phoneval = false;
        }
    }//GEN-LAST:event_phnotxtKeyReleased

    private void emailtxtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_emailtxtKeyReleased
        if (val.emailTest(emailtxt.getText())){
            email_val_lbl.setText("");
            emailval = true;            
        } else {
            email_val_lbl.setText("Enter a valid email");
            emailval = false;
        }
    }//GEN-LAST:event_emailtxtKeyReleased

    private void webtxtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_webtxtKeyReleased
        if (val.testWebsite(webtxt.getText())){
            website_val_lbl.setText("");            
        } else {
            website_val_lbl.setText("Enter a valid web address");
        }  
    }//GEN-LAST:event_webtxtKeyReleased

    private void posttxtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_posttxtKeyReleased
        if (val.testNumber(posttxt.getText())){
            postcode_val_lbl.setText("");
            postcodeval = true;
        } else {
            postcode_val_lbl.setText("Enter a valid postal code");
            postcodeval = false;
        }
    }//GEN-LAST:event_posttxtKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel acctypelbl;
    private javax.swing.JComboBox<String> acctypetxt;
    private javax.swing.JLabel activestatlbl;
    private javax.swing.JComboBox<String> activestattxt;
    private javax.swing.JLabel addlbl;
    private javax.swing.JTextField addtxt;
    private javax.swing.JPanel adminBooking;
    private javax.swing.JPanel adminConcert;
    private javax.swing.JPanel adminControl;
    private javax.swing.JPanel adminDash;
    private javax.swing.JPanel adminInvoice;
    private javax.swing.JPanel adminScreen;
    private javax.swing.JPanel adminUser;
    private javax.swing.JPanel adminViewInvoice;
    private javax.swing.JLabel albl;
    private javax.swing.JLabel atxt;
    private javax.swing.JLabel bookconidlbl;
    private javax.swing.JLabel bookconidtxt;
    private javax.swing.JLabel bookidlbl;
    private javax.swing.JLabel bookidtxt;
    private javax.swing.JTable bookingTable;
    private javax.swing.JLabel bookpaylbl;
    private javax.swing.JComboBox<String> bookpaytxt;
    private javax.swing.JLabel bookstatlbl;
    private javax.swing.JComboBox<String> bookstattxt;
    private javax.swing.JLabel bookunamelbl;
    private javax.swing.JLabel bookunametxt;
    private javax.swing.JButton bookupdatebtn;
    private javax.swing.JTable concertTable;
    private javax.swing.JLabel condatelbl;
    private javax.swing.JLabel condatetxt;
    private javax.swing.JButton conertupdatebtn;
    private javax.swing.JLabel conidlbl;
    private javax.swing.JLabel conidtxt;
    private javax.swing.JLabel connamelbl;
    private javax.swing.JLabel connametxt;
    private javax.swing.JLabel conorglbl;
    private javax.swing.JLabel conorgtxt;
    private javax.swing.JLabel constatlbl;
    private javax.swing.JComboBox<String> constattxt;
    private javax.swing.JPanel cover_panel;
    private javax.swing.JButton create_invoice_btn;
    private javax.swing.JButton editBooking;
    private javax.swing.JButton editConcert;
    private javax.swing.JButton editInvoice;
    private javax.swing.JButton editUser;
    private javax.swing.JLabel email_val_lbl;
    private javax.swing.JLabel emaillbl;
    private javax.swing.JTextField emailtxt;
    private javax.swing.JTable invoiceTable;
    private javax.swing.JTable invoiceViewTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JLabel loclbl;
    private javax.swing.JLabel loctxt;
    private javax.swing.JButton log_out_btn;
    private javax.swing.JLabel mlbl;
    private javax.swing.JLabel mtxt;
    private javax.swing.JLabel name_val_lbl;
    private javax.swing.JLabel namelbl;
    private javax.swing.JTextField nametxt;
    private javax.swing.JLabel orgaddlbl;
    private javax.swing.JLabel orgaddtxt;
    private javax.swing.JLabel orgnamelbl;
    private javax.swing.JLabel orgnametxt;
    private javax.swing.JLabel orgphlbl;
    private javax.swing.JLabel orgphtxt;
    private javax.swing.JLabel orgunametxt;
    private javax.swing.JLabel phnolbl;
    private javax.swing.JTextField phnotxt;
    private javax.swing.JLabel phone_val_lbl;
    private javax.swing.JLabel postcode_val_lbl;
    private javax.swing.JLabel postlbl;
    private javax.swing.JTextField posttxt;
    private javax.swing.JLabel pralbl;
    private javax.swing.JTextField pratxt;
    private javax.swing.JLabel prblbl;
    private javax.swing.JTextField prbtxt;
    private javax.swing.JLabel prclbl;
    private javax.swing.JTextField prctxt;
    private javax.swing.JLabel pslbl;
    private javax.swing.JComboBox<String> pstxt;
    private javax.swing.JLabel pwlbl;
    private javax.swing.JPasswordField pwtxt;
    private javax.swing.JLabel remlbl;
    private javax.swing.JLabel remtxt;
    private javax.swing.JLabel totlbl;
    private javax.swing.JLabel tottxt;
    private javax.swing.JLabel unamelbl;
    private javax.swing.JLabel unlbl;
    private javax.swing.JLabel untxt;
    private javax.swing.JButton updateInvoice;
    private javax.swing.JLabel update_error_lbl;
    private javax.swing.JTable userTable;
    private javax.swing.JLabel usernlbl;
    private javax.swing.JLabel userntxt;
    private javax.swing.JButton userupdatebtn;
    private javax.swing.JButton viewInvoice;
    private javax.swing.JTable viewInvoiceDetails;
    private javax.swing.JLabel weblbl;
    private javax.swing.JLabel website_val_lbl;
    private javax.swing.JTextField webtxt;
    private javax.swing.JLabel ylbl;
    private javax.swing.JLabel ytxt;
    // End of variables declaration//GEN-END:variables

    private void setIcon() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
