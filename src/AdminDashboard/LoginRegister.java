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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;


public class LoginRegister extends javax.swing.JFrame {

    //DATABASE CREATION
    Connection con = null;
    PreparedStatement st = null;
    ResultSet rs = null;
    Statement s = null;
    
    
    //validation object
    Validation val = new Validation();
    
    
    //validation booleans
    private boolean phoneval = false, nameval = false, usernameval = false, emailval = false, postcodeval = false;
    
    
    LoginRegister( {
        
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/festivalorg","root","");
        } catch (SQLException ex) {
            Logger.getLogger(AdminDash.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        initComponents();
        seticon();
    }
    
    //set Jframe Icon
    private void seticon(){       
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Images/LOGO.PNG")));
    }
    
 //close the screen   
public void close(){
        WindowEvent winClosingEvent = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosingEvent);
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainscreen = new javax.swing.JPanel();
        loginregister = new javax.swing.JPanel();
        selectiontabs = new javax.swing.JPanel();
        login_selection = new javax.swing.JButton();
        register_selection = new javax.swing.JButton();
        login_reg_card = new javax.swing.JPanel();
        login_screen = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        unamelbl = new javax.swing.JLabel();
        pwlbl = new javax.swing.JLabel();
        userntxt = new javax.swing.JTextField();
        login_btn = new javax.swing.JButton();
        pwtxt = new javax.swing.JPasswordField();
        login_error_lbl = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        reg_btn_2 = new javax.swing.JButton();
        register_screen = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        emailtxt = new javax.swing.JTextField();
        addlbl = new javax.swing.JLabel();
        nametxt = new javax.swing.JTextField();
        phnolbl = new javax.swing.JLabel();
        namelbl = new javax.swing.JLabel();
        webtxt = new javax.swing.JTextField();
        acctypetxt = new javax.swing.JComboBox<>();
        acctypelbl = new javax.swing.JLabel();
        weblbl = new javax.swing.JLabel();
        posttxt = new javax.swing.JTextField();
        postlbl = new javax.swing.JLabel();
        addtxt = new javax.swing.JTextField();
        phnotxt = new javax.swing.JTextField();
        emaillbl = new javax.swing.JLabel();
        usernamelbl = new javax.swing.JLabel();
        passwordlbl = new javax.swing.JLabel();
        usernametxt = new javax.swing.JTextField();
        register_btn = new javax.swing.JButton();
        passwordtxt = new javax.swing.JPasswordField();
        name_val_lbl = new javax.swing.JLabel();
        postcode_val_lbl = new javax.swing.JLabel();
        website_val_lbl = new javax.swing.JLabel();
        username_val_lbl = new javax.swing.JLabel();
        phone_val_lbl = new javax.swing.JLabel();
        email_val_lbl = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        registration_val_lbl = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("LOGIN/REGISTER-- Global Music Concert/Music Festival Booking");
        setLocation(new java.awt.Point(360, 180));
        setMaximumSize(new java.awt.Dimension(1280, 720));
        setMinimumSize(new java.awt.Dimension(1280, 720));
        setPreferredSize(new java.awt.Dimension(1280, 720));
        setResizable(false);

        mainscreen.setBackground(new java.awt.Color(244, 204, 230));
        mainscreen.setMaximumSize(new java.awt.Dimension(1280, 720));

        loginregister.setMaximumSize(new java.awt.Dimension(512, 700));
        loginregister.setMinimumSize(new java.awt.Dimension(512, 700));
        loginregister.setPreferredSize(new java.awt.Dimension(512, 700));

        selectiontabs.setBackground(new java.awt.Color(248, 229, 229));
        selectiontabs.setMaximumSize(new java.awt.Dimension(512, 72));
        selectiontabs.setMinimumSize(new java.awt.Dimension(512, 72));

        login_selection.setBackground(new java.awt.Color(255, 94, 137));
        login_selection.setFont(new java.awt.Font("Georgia", 0, 18)); // NOI18N
        login_selection.setText("Login");
        login_selection.setPreferredSize(new java.awt.Dimension(240, 46));
        login_selection.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                login_selectionActionPerformed(evt);
            }
        });

        register_selection.setBackground(new java.awt.Color(255, 94, 137));
        register_selection.setFont(new java.awt.Font("Georgia", 0, 18)); // NOI18N
        register_selection.setText("Register");
        register_selection.setPreferredSize(new java.awt.Dimension(240, 46));
        register_selection.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                register_selectionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout selectiontabsLayout = new javax.swing.GroupLayout(selectiontabs);
        selectiontabs.setLayout(selectiontabsLayout);
        selectiontabsLayout.setHorizontalGroup(
            selectiontabsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, selectiontabsLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(register_selection, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(selectiontabsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(selectiontabsLayout.createSequentialGroup()
                    .addGap(16, 16, 16)
                    .addComponent(login_selection, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(256, Short.MAX_VALUE)))
        );
        selectiontabsLayout.setVerticalGroup(
            selectiontabsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, selectiontabsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(register_selection, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(selectiontabsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(selectiontabsLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(login_selection, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        login_reg_card.setBackground(new java.awt.Color(204, 255, 204));
        login_reg_card.setLayout(new java.awt.CardLayout());

        login_screen.setBackground(new java.awt.Color(255, 204, 204));

        jPanel1.setBackground(new java.awt.Color(248, 229, 229));

        unamelbl.setFont(new java.awt.Font("Georgia", 1, 14)); // NOI18N
        unamelbl.setText("Username: ");

        pwlbl.setFont(new java.awt.Font("Georgia", 1, 14)); // NOI18N
        pwlbl.setText("Password:");

        userntxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userntxtActionPerformed(evt);
            }
        });

        login_btn.setBackground(new java.awt.Color(255, 94, 137));
        login_btn.setFont(new java.awt.Font("Georgia", 1, 14)); // NOI18N
        login_btn.setText("Login");
        login_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                login_btnActionPerformed(evt);
            }
        });

        pwtxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pwtxtActionPerformed(evt);
            }
        });

        login_error_lbl.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        login_error_lbl.setForeground(new java.awt.Color(255, 51, 102));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(pwlbl, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(unamelbl, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(login_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(pwtxt, javax.swing.GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE)
                                .addComponent(userntxt))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(login_error_lbl, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(52, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(36, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(unamelbl, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(userntxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pwtxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pwlbl, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(login_error_lbl, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(login_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32))
        );

        jLabel1.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        jLabel1.setText("Don't have an account? ");

        reg_btn_2.setBackground(new java.awt.Color(255, 94, 137));
        reg_btn_2.setFont(new java.awt.Font("Georgia", 0, 13)); // NOI18N
        reg_btn_2.setText("Register");
        reg_btn_2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reg_btn_2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout login_screenLayout = new javax.swing.GroupLayout(login_screen);
        login_screen.setLayout(login_screenLayout);
        login_screenLayout.setHorizontalGroup(
            login_screenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(login_screenLayout.createSequentialGroup()
                .addGroup(login_screenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(login_screenLayout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(login_screenLayout.createSequentialGroup()
                        .addGap(88, 88, 88)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(reg_btn_2, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(32, Short.MAX_VALUE))
        );
        login_screenLayout.setVerticalGroup(
            login_screenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(login_screenLayout.createSequentialGroup()
                .addGap(197, 197, 197)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(login_screenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(reg_btn_2, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(141, Short.MAX_VALUE))
        );

        login_reg_card.add(login_screen, "card3");

        register_screen.setBackground(new java.awt.Color(255, 204, 204));

        jPanel2.setBackground(new java.awt.Color(248, 229, 229));

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

        addlbl.setFont(new java.awt.Font("Georgia", 1, 14)); // NOI18N
        addlbl.setText("Address:");

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

        phnolbl.setFont(new java.awt.Font("Georgia", 1, 14)); // NOI18N
        phnolbl.setText("Phone Number:");

        namelbl.setFont(new java.awt.Font("Georgia", 1, 14)); // NOI18N
        namelbl.setText("Name");

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

        acctypetxt.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "General", "Corporate", "Organizer" }));
        acctypetxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                acctypetxtActionPerformed(evt);
            }
        });

        acctypelbl.setFont(new java.awt.Font("Georgia", 1, 14)); // NOI18N
        acctypelbl.setText("Account Type:");

        weblbl.setFont(new java.awt.Font("Georgia", 1, 14)); // NOI18N
        weblbl.setText("Website:");

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

        postlbl.setFont(new java.awt.Font("Georgia", 1, 14)); // NOI18N
        postlbl.setText("Post Code:");

        addtxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addtxtActionPerformed(evt);
            }
        });

        phnotxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                phnotxtKeyReleased(evt);
            }
        });

        emaillbl.setFont(new java.awt.Font("Georgia", 1, 14)); // NOI18N
        emaillbl.setText("Email:");

        usernamelbl.setFont(new java.awt.Font("Georgia", 1, 14)); // NOI18N
        usernamelbl.setText("Username:");

        passwordlbl.setFont(new java.awt.Font("Georgia", 1, 14)); // NOI18N
        passwordlbl.setText("Password ");

        usernametxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usernametxtActionPerformed(evt);
            }
        });
        usernametxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                usernametxtKeyReleased(evt);
            }
        });

        register_btn.setBackground(new java.awt.Color(255, 94, 137));
        register_btn.setFont(new java.awt.Font("Georgia", 1, 14)); // NOI18N
        register_btn.setText("Register");
        register_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                register_btnActionPerformed(evt);
            }
        });

        passwordtxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordtxtActionPerformed(evt);
            }
        });

        name_val_lbl.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        name_val_lbl.setForeground(new java.awt.Color(255, 51, 51));

        postcode_val_lbl.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        postcode_val_lbl.setForeground(new java.awt.Color(255, 51, 51));

        website_val_lbl.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        website_val_lbl.setForeground(new java.awt.Color(255, 51, 51));

        username_val_lbl.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        username_val_lbl.setForeground(new java.awt.Color(255, 51, 51));

        phone_val_lbl.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        phone_val_lbl.setForeground(new java.awt.Color(255, 51, 51));

        email_val_lbl.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        email_val_lbl.setForeground(new java.awt.Color(255, 51, 51));

        jLabel2.setForeground(new java.awt.Color(255, 51, 102));
        jLabel2.setText("*");

        jLabel3.setForeground(new java.awt.Color(255, 51, 102));
        jLabel3.setText("*");

        jLabel4.setForeground(new java.awt.Color(255, 51, 102));
        jLabel4.setText("*");

        jLabel5.setForeground(new java.awt.Color(255, 51, 102));
        jLabel5.setText("*");

        jLabel6.setForeground(new java.awt.Color(255, 51, 102));
        jLabel6.setText("*");

        jLabel7.setForeground(new java.awt.Color(255, 51, 102));
        jLabel7.setText("*");

        jLabel8.setForeground(new java.awt.Color(255, 51, 102));
        jLabel8.setText("*");

        jLabel9.setForeground(new java.awt.Color(255, 51, 102));
        jLabel9.setText("*");

        jLabel10.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        jLabel10.setText("Required");

        jLabel11.setForeground(new java.awt.Color(255, 51, 102));
        jLabel11.setText("*");

        registration_val_lbl.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        registration_val_lbl.setForeground(new java.awt.Color(255, 51, 51));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(username_val_lbl, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addComponent(register_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel3)
                            .addComponent(jLabel7)
                            .addComponent(jLabel6)
                            .addComponent(jLabel9)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(phnolbl)
                            .addComponent(namelbl)
                            .addComponent(emaillbl)
                            .addComponent(addlbl)
                            .addComponent(acctypelbl)
                            .addComponent(postlbl)
                            .addComponent(weblbl)
                            .addComponent(usernamelbl)
                            .addComponent(passwordlbl))
                        .addGap(37, 37, 37)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(name_val_lbl, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(webtxt, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(posttxt, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(acctypetxt, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(addtxt, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(emailtxt, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(phnotxt, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(passwordtxt, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(nametxt, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(usernametxt, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(website_val_lbl, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(postcode_val_lbl, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(phone_val_lbl, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(email_val_lbl, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(registration_val_lbl))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(namelbl)
                    .addComponent(nametxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(2, 2, 2)
                .addComponent(name_val_lbl)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(phnotxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(phnolbl)
                    .addComponent(jLabel4))
                .addGap(1, 1, 1)
                .addComponent(phone_val_lbl)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(emailtxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(emaillbl, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(email_val_lbl)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addlbl)
                    .addComponent(addtxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(24, 24, 24)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(acctypelbl)
                    .addComponent(acctypetxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(29, 29, 29)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(posttxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(postlbl, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(6, 6, 6)
                .addComponent(postcode_val_lbl)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(webtxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(weblbl, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4)
                .addComponent(website_val_lbl)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(usernametxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(usernamelbl)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(username_val_lbl)
                .addGap(22, 22, 22)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(passwordtxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(passwordlbl)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 69, Short.MAX_VALUE)
                .addComponent(registration_val_lbl, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(register_btn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel10)
                        .addComponent(jLabel11)))
                .addGap(27, 27, 27))
        );

        javax.swing.GroupLayout register_screenLayout = new javax.swing.GroupLayout(register_screen);
        register_screen.setLayout(register_screenLayout);
        register_screenLayout.setHorizontalGroup(
            register_screenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(register_screenLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(39, Short.MAX_VALUE))
        );
        register_screenLayout.setVerticalGroup(
            register_screenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(register_screenLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        login_reg_card.add(register_screen, "card2");

        javax.swing.GroupLayout loginregisterLayout = new javax.swing.GroupLayout(loginregister);
        loginregister.setLayout(loginregisterLayout);
        loginregisterLayout.setHorizontalGroup(
            loginregisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(selectiontabs, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(login_reg_card, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        loginregisterLayout.setVerticalGroup(
            loginregisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loginregisterLayout.createSequentialGroup()
                .addComponent(selectiontabs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(login_reg_card, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/LOGO.PNG"))); // NOI18N

        jLabel13.setFont(new java.awt.Font("Georgia", 0, 48)); // NOI18N
        jLabel13.setText("GLOBAL MUSIC");

        jLabel14.setFont(new java.awt.Font("Georgia", 0, 24)); // NOI18N
        jLabel14.setText("Concert/Festival Booking ");

        javax.swing.GroupLayout mainscreenLayout = new javax.swing.GroupLayout(mainscreen);
        mainscreen.setLayout(mainscreenLayout);
        mainscreenLayout.setHorizontalGroup(
            mainscreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainscreenLayout.createSequentialGroup()
                .addGroup(mainscreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mainscreenLayout.createSequentialGroup()
                        .addGap(119, 119, 119)
                        .addComponent(jLabel12))
                    .addGroup(mainscreenLayout.createSequentialGroup()
                        .addGap(187, 187, 187)
                        .addComponent(jLabel13))
                    .addGroup(mainscreenLayout.createSequentialGroup()
                        .addGap(226, 226, 226)
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 137, Short.MAX_VALUE)
                .addComponent(loginregister, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        mainscreenLayout.setVerticalGroup(
            mainscreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainscreenLayout.createSequentialGroup()
                .addGroup(mainscreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(mainscreenLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(loginregister, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(mainscreenLayout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(jLabel12)
                        .addGap(26, 26, 26)
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainscreen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainscreen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
 
// register panel button config
    private void register_selectionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_register_selectionActionPerformed
       login_reg_card.removeAll();
        login_reg_card.repaint();
        login_reg_card.revalidate();
        login_reg_card.add(register_screen);
        login_reg_card.repaint();
        login_reg_card.revalidate();
        login_selection.setBorder(BorderFactory.createEmptyBorder());  
        register_selection.setBorder(BorderFactory.createLineBorder(new Color (0, 0, 0), 5));            
    }//GEN-LAST:event_register_selectionActionPerformed

    
    //login button functions
    private void login_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_login_btnActionPerformed
        try {
            String query = "select userName, password, accountType, accountStatus from user";
            s = con.createStatement();
            rs = s.executeQuery(query);
            boolean logcheck = false;
            String acctype = null;
            String username = null;
            String status = "a";
            
            while (rs.next()){
                if (rs.getString("userName").equals(userntxt.getText()) && rs.getString("password").equals(pwtxt.getText())){
                    logcheck = true;    
                    acctype = rs.getString("accountType");
                    username = rs.getString("userName");
                    status = rs.getString("accountStatus");
//                    System.out.println(acctype);
//                    System.out.println(username);
//                    System.out.println(status);
                    break;
                    
                }
            }
            if (status.equals("active")){
                if (logcheck && acctype.equals("general")){
                    CostumerDash cd = new CostumerDash();                    
                    cd.setusername(username);
                    cd.setVisible(true);
                    close();
                } else if (logcheck && acctype.equals("corporate")){
                    CostumerDash cd = new CostumerDash();                    
                    cd.setusername(username);
                    cd.setVisible(true);
                    close();
                } else if (logcheck && acctype.equals("organizer")){
                    OrgDash orga = new OrgDash();
                    orga.setusername(username) ;
                    orga.setVisible(true);
                    close();
                } else if (logcheck && acctype.equals("admin")){
                    AdminDash aDash = new AdminDash();
                    aDash.setVisible(true);
                    close();
                } else {
                    login_error_lbl.setText("Username/Password incorrect");
                }
            } else if ((status.equals("inactive"))){ 
                JOptionPane.showMessageDialog(null, "Your account is deactivated. Please contact your administrator.");
            } else {
                login_error_lbl.setText("Username/Password incorrect");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Login error! Database connectivity error sucpected.");
        }
        
    }//GEN-LAST:event_login_btnActionPerformed

    private void userntxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userntxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_userntxtActionPerformed

    private void emailtxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailtxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emailtxtActionPerformed

    private void nametxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nametxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nametxtActionPerformed

    private void webtxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_webtxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_webtxtActionPerformed

    private void acctypetxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_acctypetxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_acctypetxtActionPerformed

    private void posttxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_posttxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_posttxtActionPerformed

    private void addtxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addtxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addtxtActionPerformed

    
    //panel login button congig
    private void login_selectionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_login_selectionActionPerformed
        login_reg_card.removeAll();
        login_reg_card.repaint();
        login_reg_card.revalidate();
        login_reg_card.add(login_screen);
        login_reg_card.repaint();
        login_reg_card.revalidate();
        login_selection.setBorder(BorderFactory.createLineBorder(new Color (0, 0, 0), 5));
        register_selection.setBorder(BorderFactory.createEmptyBorder());  
        
    }//GEN-LAST:event_login_selectionActionPerformed

    private void passwordtxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordtxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passwordtxtActionPerformed
    
    //registration 
    private void register_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_register_btnActionPerformed
        boolean registercheck = false;
        if (usernameval && nameval && phoneval && emailval && postcodeval && !(addtxt.getText().equals("")) && !(passwordtxt.getText().equals(""))) {
            registercheck = true;
            
        } else {
           registercheck = false;
           registration_val_lbl.setText("Please check validations and fill all required feilds");
        }
        
        if (registercheck){
        try {
            String query = "INSERT INTO user (userName, password, name, address, postCode, contactNumber, email, website, accountStatus, accountType) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            st = con.prepareStatement(query);
            st.setString(1, usernametxt.getText());
            st.setString(2, passwordtxt.getText());
            st.setString(3, nametxt.getText());
            st.setString(4, addtxt.getText());
            st.setString(5, posttxt.getText());
            st.setString(6, phnotxt.getText());
            st.setString(7, emailtxt.getText());
            st.setString(8, webtxt.getText());
            st.setString(9, "active");
            if (acctypetxt.getSelectedItem().equals("General")){
                st.setString(10, "general");
            } else if (acctypetxt.getSelectedItem().equals("Organizer")){
                st.setString(10, "organizer");
            } else {
                st.setString(10, "corporate");
            }
            st.executeUpdate();
            JOptionPane.showMessageDialog(null, "Registration Successful");
            clear_feilds();
            login_reg_card.removeAll();
            login_reg_card.repaint();
            login_reg_card.revalidate();
            login_reg_card.add(login_screen);
            login_reg_card.repaint();
            login_reg_card.revalidate();
            login_selection.setBorder(BorderFactory.createLineBorder(new Color (0, 0, 0), 5));
            register_selection.setBorder(BorderFactory.createEmptyBorder());  

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Registration failed! Database error suspected.");
        }
        }
    }//GEN-LAST:event_register_btnActionPerformed

    private void usernametxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usernametxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_usernametxtActionPerformed

    private void pwtxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pwtxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pwtxtActionPerformed

    
    //registration alrernate button
    private void reg_btn_2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reg_btn_2ActionPerformed
        login_reg_card.removeAll();
        login_reg_card.repaint();
        login_reg_card.revalidate();
        login_reg_card.add(register_screen);
        login_reg_card.repaint();
        login_reg_card.revalidate();
        login_selection.setBorder(BorderFactory.createEmptyBorder());  
        register_selection.setBorder(BorderFactory.createLineBorder(new Color (0, 0, 0), 5));
    }//GEN-LAST:event_reg_btn_2ActionPerformed

    
    //VALIDATIONS
    private void nametxtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nametxtKeyReleased
        if (val.nameTest(nametxt.getText())){
            name_val_lbl.setText("");
            nameval = true;
        } else {
            name_val_lbl.setText("Enter a valid name");
            nameval = true;
        }
    }//GEN-LAST:event_nametxtKeyReleased

    private void phnotxtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_phnotxtKeyReleased
        if (val.phoneTest(phnotxt.getText())){
            phone_val_lbl.setText("");
            if (val.phone_repeat(phnotxt.getText())) {
                phone_val_lbl.setText("Phone number is alredy taken");
            } else {
                phone_val_lbl.setText("");
                phoneval = true;
            }
        } else {
            phone_val_lbl.setText("Enter a valid Phone number");
            phoneval = false;
        }
    }//GEN-LAST:event_phnotxtKeyReleased

    private void emailtxtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_emailtxtKeyReleased
        if (val.emailTest(emailtxt.getText())){
            if (val.email_repeat(emailtxt.getText())) {
                email_val_lbl.setText("Email number is alredy taken");
            } else {
                email_val_lbl.setText("");
                emailval = true;
            }
        } else {
            email_val_lbl.setText("Enter a valid email");
            emailval = false;
        }
    }//GEN-LAST:event_emailtxtKeyReleased

    private void posttxtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_posttxtKeyReleased
        if (val.testNumber(posttxt.getText())){
            postcode_val_lbl.setText("");
            postcodeval = true;
        } else {
            postcode_val_lbl.setText("Enter a valid postal code");
            postcodeval = false;
        }
    }//GEN-LAST:event_posttxtKeyReleased

    private void webtxtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_webtxtKeyReleased
        if (val.testWebsite(webtxt.getText())){
            website_val_lbl.setText("");
        } else {
            website_val_lbl.setText("Enter a valid web address");
        }  
    }//GEN-LAST:event_webtxtKeyReleased

    private void usernametxtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_usernametxtKeyReleased
        if (val.usernTest(usernametxt.getText())){
            if (val.username_repeat(usernametxt.getText())) {
                username_val_lbl.setText("Username number is alredy taken");
                usernameval = true;                
            } else {
                username_val_lbl.setText("");
            }
        } else {
            username_val_lbl.setText("Username(3-10 characters)can't contain special characters [ex: -_]");
            usernameval = true;
        }
    }//GEN-LAST:event_usernametxtKeyReleased

    
    //clear feilds
    private void clear_feilds(){
        nametxt.setText(null);
        usernametxt.setText(null);
        passwordtxt.setText(null);
        emailtxt.setText(null);
        phnotxt.setText(null);
        addtxt.setText(null);
        posttxt.setText(null);
        webtxt.setText(null);
    }
    //MAIN METHOD

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(LoginRegister.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginRegister.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginRegister.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginRegister.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginRegister().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel acctypelbl;
    private javax.swing.JComboBox<String> acctypetxt;
    private javax.swing.JLabel addlbl;
    private javax.swing.JTextField addtxt;
    private javax.swing.JLabel email_val_lbl;
    private javax.swing.JLabel emaillbl;
    private javax.swing.JTextField emailtxt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
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
    private javax.swing.JButton login_btn;
    private javax.swing.JLabel login_error_lbl;
    private javax.swing.JPanel login_reg_card;
    private javax.swing.JPanel login_screen;
    private javax.swing.JButton login_selection;
    private javax.swing.JPanel loginregister;
    private javax.swing.JPanel mainscreen;
    private javax.swing.JLabel name_val_lbl;
    private javax.swing.JLabel namelbl;
    private javax.swing.JTextField nametxt;
    private javax.swing.JLabel passwordlbl;
    private javax.swing.JPasswordField passwordtxt;
    private javax.swing.JLabel phnolbl;
    private javax.swing.JTextField phnotxt;
    private javax.swing.JLabel phone_val_lbl;
    private javax.swing.JLabel postcode_val_lbl;
    private javax.swing.JLabel postlbl;
    private javax.swing.JTextField posttxt;
    private javax.swing.JLabel pwlbl;
    private javax.swing.JPasswordField pwtxt;
    private javax.swing.JButton reg_btn_2;
    private javax.swing.JButton register_btn;
    private javax.swing.JPanel register_screen;
    private javax.swing.JButton register_selection;
    private javax.swing.JLabel registration_val_lbl;
    private javax.swing.JPanel selectiontabs;
    private javax.swing.JLabel unamelbl;
    private javax.swing.JLabel username_val_lbl;
    private javax.swing.JLabel usernamelbl;
    private javax.swing.JTextField usernametxt;
    private javax.swing.JTextField userntxt;
    private javax.swing.JLabel weblbl;
    private javax.swing.JLabel website_val_lbl;
    private javax.swing.JTextField webtxt;
    // End of variables declaration//GEN-END:variables
}
