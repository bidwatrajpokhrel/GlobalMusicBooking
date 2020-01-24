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
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;
import net.proteanit.sql.DbUtils;



public class OrgDash extends javax.swing.JFrame {
    
    
    private String username;
    
    //creation of validation object 
    Validation val = new Validation();
    
    //initiating validation variables
    boolean priceval = false;

    OrgDash() {
        initComponents();
        seticon();
           
    }
    
    
    //set Jframe Icon
    private void seticon(){       
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Images/LOGO.PNG")));
    }
    //fetch username from login
    public void setusername (String username_input){
        username = username_input;
    }
    
    //close window for logout
    public void close(){
            WindowEvent winClosingEvent = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
            Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosingEvent);
    }

    //clear all feilds
    public void clear_textfields(){
        addagenttxt.setText(null);
        addbandtxt.setText(null);
        bandconcnametxt.setSelectedIndex(0);
        concbandnametxt.setSelectedIndex(0);
        concertdatetxt.setText(null);
        concertidtxt.setText(null);
        concertlocationtxt.setText(null);
        concertnametxt.setText(null);
        concertstatustxt.setSelectedIndex(0);
        condatetxt.setDate(null);
        connametxt.setText(null);
        loctxt.setText(null);
        mainbandtxt.setSelectedIndex(0);
        pratxt.setText(null);
        prbtxt.setText(null);
        prctxt.setText(null);
        tottxt.setText(null);
    
    }
    
    //fetching concert table
    private void tblData(){
        try{
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/festivalorg", "root", "");
            String query1 = "SELECT concertId, concertName, location, date FROM concert WHERE organizer = \"" + username + "\"";            
            PreparedStatement st = con.prepareStatement(query1);
            ResultSet rs = st.executeQuery();
            conTable.setModel(DbUtils.resultSetToTableModel(rs));
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        orgDash = new javax.swing.JPanel();
        orgControl = new javax.swing.JPanel();
        orgConcertBtn = new javax.swing.JButton();
        orgAgentBandBtn = new javax.swing.JButton();
        orgViewBtn = new javax.swing.JButton();
        log_out_btn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        orgScreen = new javax.swing.JPanel();
        cover_pane = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        orgConcert = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel1 = new javax.swing.JPanel();
        condatetxt = new com.toedter.calendar.JDateChooser();
        tottxt = new javax.swing.JTextField();
        pratxt = new javax.swing.JTextField();
        prbtxt = new javax.swing.JTextField();
        prctxt = new javax.swing.JTextField();
        connamelbl = new javax.swing.JLabel();
        loclbl = new javax.swing.JLabel();
        condatelbl = new javax.swing.JLabel();
        totlbl = new javax.swing.JLabel();
        pralbl = new javax.swing.JLabel();
        prblbl = new javax.swing.JLabel();
        prclbl = new javax.swing.JLabel();
        conaddbtn = new javax.swing.JButton();
        connametxt = new javax.swing.JTextField();
        loctxt = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        price_val_lbl = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        bandconcnametxt = new javax.swing.JComboBox<>();
        concbandnametxt = new javax.swing.JComboBox<>();
        mainbandtxt = new javax.swing.JComboBox<>();
        addconcertband = new javax.swing.JButton();
        bandconcnamelbl = new javax.swing.JLabel();
        concbandnamelbl = new javax.swing.JLabel();
        mainbandlbl = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        orgAgentBand = new javax.swing.JPanel();
        AgentPane = new javax.swing.JPanel();
        addagentlbl = new javax.swing.JLabel();
        addagenttxt = new javax.swing.JTextField();
        addagentbtn = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        BandPane = new javax.swing.JPanel();
        agent1lbl = new javax.swing.JLabel();
        agentlist = new javax.swing.JComboBox<>();
        addbandlbl = new javax.swing.JLabel();
        addbandtxt = new javax.swing.JTextField();
        addbandbtn = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel12 = new javax.swing.JLabel();
        orgView = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        conTable = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        concertidtxt = new javax.swing.JLabel();
        concertnametxt = new javax.swing.JLabel();
        concertlocationtxt = new javax.swing.JLabel();
        concertdatetxt = new javax.swing.JLabel();
        concertidlbl = new javax.swing.JLabel();
        concertnamelbl = new javax.swing.JLabel();
        concertlocationlbl = new javax.swing.JLabel();
        concertdatelbl = new javax.swing.JLabel();
        concertstatuslbl = new javax.swing.JLabel();
        concertcancelbtn = new javax.swing.JButton();
        concertstatustxt = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("ORGANIZER -- Global Music Concert/Music Festival Booking");
        setLocation(new java.awt.Point(360, 180));
        setMaximumSize(new java.awt.Dimension(1280, 720));
        setMinimumSize(new java.awt.Dimension(1280, 720));
        setPreferredSize(new java.awt.Dimension(1280, 720));
        setResizable(false);

        orgDash.setPreferredSize(new java.awt.Dimension(1280, 720));

        orgControl.setBackground(new java.awt.Color(248, 229, 229));
        orgControl.setPreferredSize(new java.awt.Dimension(256, 720));

        orgConcertBtn.setBackground(new java.awt.Color(255, 94, 137));
        orgConcertBtn.setFont(new java.awt.Font("Georgia", 0, 18)); // NOI18N
        orgConcertBtn.setText("Add Concerts");
        orgConcertBtn.setPreferredSize(new java.awt.Dimension(230, 100));
        orgConcertBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                orgConcertBtnActionPerformed(evt);
            }
        });

        orgAgentBandBtn.setBackground(new java.awt.Color(255, 94, 137));
        orgAgentBandBtn.setFont(new java.awt.Font("Georgia", 0, 18)); // NOI18N
        orgAgentBandBtn.setText("Add Agents/Bands");
        orgAgentBandBtn.setPreferredSize(new java.awt.Dimension(230, 100));
        orgAgentBandBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                orgAgentBandBtnActionPerformed(evt);
            }
        });

        orgViewBtn.setBackground(new java.awt.Color(255, 94, 137));
        orgViewBtn.setFont(new java.awt.Font("Georgia", 0, 18)); // NOI18N
        orgViewBtn.setText("View/Edit Your Festivals");
        orgViewBtn.setPreferredSize(new java.awt.Dimension(230, 100));
        orgViewBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                orgViewBtnActionPerformed(evt);
            }
        });

        log_out_btn.setBackground(new java.awt.Color(255, 94, 137));
        log_out_btn.setFont(new java.awt.Font("Georgia", 0, 12)); // NOI18N
        log_out_btn.setText("Log Out");
        log_out_btn.setPreferredSize(new java.awt.Dimension(230, 30));
        log_out_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                log_out_btnActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Georgia", 0, 36)); // NOI18N
        jLabel1.setText("ORGANIZER ");

        jLabel2.setFont(new java.awt.Font("Georgia", 0, 24)); // NOI18N
        jLabel2.setText("PANEL");

        javax.swing.GroupLayout orgControlLayout = new javax.swing.GroupLayout(orgControl);
        orgControl.setLayout(orgControlLayout);
        orgControlLayout.setHorizontalGroup(
            orgControlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(orgControlLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(orgControlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(orgViewBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 232, Short.MAX_VALUE)
                    .addComponent(orgAgentBandBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(orgConcertBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, orgControlLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(orgControlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(log_out_btn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(orgControlLayout.createSequentialGroup()
                        .addGap(71, 71, 71)
                        .addComponent(jLabel2)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        orgControlLayout.setVerticalGroup(
            orgControlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(orgControlLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(orgConcertBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addComponent(orgAgentBandBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addComponent(orgViewBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60)
                .addComponent(log_out_btn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        orgScreen.setMaximumSize(new java.awt.Dimension(1024, 720));
        orgScreen.setPreferredSize(new java.awt.Dimension(1024, 720));
        orgScreen.setLayout(new java.awt.CardLayout());

        cover_pane.setBackground(new java.awt.Color(255, 204, 204));

        jLabel4.setFont(new java.awt.Font("Georgia", 1, 100)); // NOI18N
        jLabel4.setText("WELCOME, ");

        jLabel5.setFont(new java.awt.Font("Georgia", 0, 75)); // NOI18N
        jLabel5.setText("Organizer! ");

        jLabel6.setFont(new java.awt.Font("Georgia", 2, 48)); // NOI18N
        jLabel6.setText("Select a tab on the left to continue...");

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/manager.png"))); // NOI18N

        javax.swing.GroupLayout cover_paneLayout = new javax.swing.GroupLayout(cover_pane);
        cover_pane.setLayout(cover_paneLayout);
        cover_paneLayout.setHorizontalGroup(
            cover_paneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cover_paneLayout.createSequentialGroup()
                .addGroup(cover_paneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(cover_paneLayout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addComponent(jLabel4))
                    .addGroup(cover_paneLayout.createSequentialGroup()
                        .addGap(471, 471, 471)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 518, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(cover_paneLayout.createSequentialGroup()
                        .addGap(108, 108, 108)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 792, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(cover_paneLayout.createSequentialGroup()
                        .addGap(154, 154, 154)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        cover_paneLayout.setVerticalGroup(
            cover_paneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cover_paneLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(96, 96, 96)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
        );

        orgScreen.add(cover_pane, "card5");

        orgConcert.setBackground(new java.awt.Color(255, 204, 204));
        orgConcert.setMaximumSize(new java.awt.Dimension(1024, 720));
        orgConcert.setMinimumSize(new java.awt.Dimension(1024, 720));
        orgConcert.setPreferredSize(new java.awt.Dimension(1024, 720));

        jSeparator1.setBackground(new java.awt.Color(255, 102, 102));
        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jPanel1.setBackground(new java.awt.Color(248, 229, 229));

        tottxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tottxtActionPerformed(evt);
            }
        });

        pratxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                pratxtKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                pratxtKeyReleased(evt);
            }
        });

        prbtxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                prbtxtKeyReleased(evt);
            }
        });

        prctxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                prctxtKeyReleased(evt);
            }
        });

        connamelbl.setFont(new java.awt.Font("Georgia", 1, 14)); // NOI18N
        connamelbl.setText("Concert Name: ");

        loclbl.setFont(new java.awt.Font("Georgia", 1, 14)); // NOI18N
        loclbl.setText("Location:");

        condatelbl.setFont(new java.awt.Font("Georgia", 1, 14)); // NOI18N
        condatelbl.setText("Date:");

        totlbl.setFont(new java.awt.Font("Georgia", 1, 14)); // NOI18N
        totlbl.setText("Total Seats: ");

        pralbl.setFont(new java.awt.Font("Georgia", 1, 14)); // NOI18N
        pralbl.setText("General Price:");

        prblbl.setFont(new java.awt.Font("Georgia", 1, 14)); // NOI18N
        prblbl.setText("Discounted Price:");

        prclbl.setFont(new java.awt.Font("Georgia", 1, 14)); // NOI18N
        prclbl.setText("Corporate Price:");
        prclbl.setToolTipText("");

        conaddbtn.setFont(new java.awt.Font("Georgia", 1, 14)); // NOI18N
        conaddbtn.setText("ADD CONCERT");
        conaddbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                conaddbtnActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Georgia", 0, 24)); // NOI18N
        jLabel7.setText("ADD CONCERTS");

        price_val_lbl.setForeground(new java.awt.Color(255, 0, 51));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(85, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(price_val_lbl, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(57, 57, 57))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(conaddbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(connamelbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(loclbl, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(condatelbl)
                                        .addComponent(totlbl)
                                        .addComponent(pralbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(prblbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(prclbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGap(18, 18, 18)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(connametxt)
                                        .addComponent(loctxt)
                                        .addComponent(condatetxt, javax.swing.GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)
                                        .addComponent(tottxt)
                                        .addComponent(pratxt)
                                        .addComponent(prbtxt)
                                        .addComponent(prctxt))))
                            .addGap(77, 77, 77)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(124, 124, 124))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 79, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(connamelbl)
                        .addGap(19, 19, 19)
                        .addComponent(loclbl))
                    .addComponent(loctxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(connametxt, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(condatelbl)
                    .addComponent(condatetxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(totlbl)
                    .addComponent(tottxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pralbl)
                    .addComponent(pratxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(prblbl)
                    .addComponent(prbtxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(prclbl)
                    .addComponent(prctxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(48, 48, 48)
                .addComponent(price_val_lbl)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(conaddbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36))
        );

        jPanel2.setBackground(new java.awt.Color(248, 229, 229));

        concbandnametxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                concbandnametxtActionPerformed(evt);
            }
        });

        mainbandtxt.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Yes", "No" }));

        addconcertband.setFont(new java.awt.Font("Georgia", 1, 14)); // NOI18N
        addconcertband.setText("ADD BAND TO CONCERT");
        addconcertband.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addconcertbandActionPerformed(evt);
            }
        });

        bandconcnamelbl.setFont(new java.awt.Font("Georgia", 1, 14)); // NOI18N
        bandconcnamelbl.setText("Concert Name:");

        concbandnamelbl.setFont(new java.awt.Font("Georgia", 1, 14)); // NOI18N
        concbandnamelbl.setText("BandName:");

        mainbandlbl.setFont(new java.awt.Font("Georgia", 1, 14)); // NOI18N
        mainbandlbl.setText("Main Band:");

        jLabel8.setFont(new java.awt.Font("Georgia", 0, 24)); // NOI18N
        jLabel8.setText("ADD BANDS TO CONCERT");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel8)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(concbandnamelbl, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bandconcnamelbl, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(mainbandlbl, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(40, 40, 40)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(bandconcnametxt, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(concbandnametxt, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(mainbandtxt, 0, 170, Short.MAX_VALUE)))
                    .addComponent(addconcertband, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(63, 63, 63))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(bandconcnamelbl)
                    .addComponent(bandconcnametxt, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(concbandnamelbl)
                        .addGap(60, 60, 60))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(concbandnametxt, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(68, 68, 68)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(mainbandlbl, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(mainbandtxt, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(93, 93, 93)
                .addComponent(addconcertband, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );

        jLabel9.setFont(new java.awt.Font("Georgia", 1, 36)); // NOI18N
        jLabel9.setText("Add Concerts and Manage Bands");

        javax.swing.GroupLayout orgConcertLayout = new javax.swing.GroupLayout(orgConcert);
        orgConcert.setLayout(orgConcertLayout);
        orgConcertLayout.setHorizontalGroup(
            orgConcertLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(orgConcertLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, orgConcertLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel9)
                .addGap(173, 173, 173))
        );
        orgConcertLayout.setVerticalGroup(
            orgConcertLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, orgConcertLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE)
                .addGap(33, 33, 33)
                .addGroup(orgConcertLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 493, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(78, 78, 78))
        );

        orgScreen.add(orgConcert, "card2");

        orgAgentBand.setBackground(new java.awt.Color(255, 204, 204));
        orgAgentBand.setMaximumSize(new java.awt.Dimension(1024, 720));
        orgAgentBand.setMinimumSize(new java.awt.Dimension(1024, 720));
        orgAgentBand.setPreferredSize(new java.awt.Dimension(1024, 720));

        AgentPane.setBackground(new java.awt.Color(248, 229, 229));
        AgentPane.setPreferredSize(new java.awt.Dimension(400, 450));

        addagentlbl.setFont(new java.awt.Font("Georgia", 1, 18)); // NOI18N
        addagentlbl.setText("Agent Name:");

        addagenttxt.setPreferredSize(new java.awt.Dimension(200, 30));
        addagenttxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addagenttxtActionPerformed(evt);
            }
        });

        addagentbtn.setFont(new java.awt.Font("Georgia", 0, 13)); // NOI18N
        addagentbtn.setText("Add Agent");
        addagentbtn.setPreferredSize(new java.awt.Dimension(300, 40));
        addagentbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addagentbtnActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Georgia", 1, 24)); // NOI18N
        jLabel11.setText("Add Agents");

        javax.swing.GroupLayout AgentPaneLayout = new javax.swing.GroupLayout(AgentPane);
        AgentPane.setLayout(AgentPaneLayout);
        AgentPaneLayout.setHorizontalGroup(
            AgentPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AgentPaneLayout.createSequentialGroup()
                .addGroup(AgentPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(AgentPaneLayout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(addagentlbl, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(addagenttxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(AgentPaneLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(addagentbtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(34, 34, 34))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AgentPaneLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel11)
                .addGap(130, 130, 130))
        );
        AgentPaneLayout.setVerticalGroup(
            AgentPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AgentPaneLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(127, 127, 127)
                .addGroup(AgentPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addagentlbl)
                    .addComponent(addagenttxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 94, Short.MAX_VALUE)
                .addComponent(addagentbtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(82, 82, 82))
        );

        BandPane.setBackground(new java.awt.Color(248, 229, 229));
        BandPane.setPreferredSize(new java.awt.Dimension(400, 450));

        agent1lbl.setFont(new java.awt.Font("Georgia", 1, 18)); // NOI18N
        agent1lbl.setText("Agent: ");

        agentlist.setPreferredSize(new java.awt.Dimension(200, 30));

        addbandlbl.setFont(new java.awt.Font("Georgia", 1, 18)); // NOI18N
        addbandlbl.setText("Band Name:");

        addbandtxt.setPreferredSize(new java.awt.Dimension(200, 30));
        addbandtxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addbandtxtActionPerformed(evt);
            }
        });

        addbandbtn.setFont(new java.awt.Font("Georgia", 0, 13)); // NOI18N
        addbandbtn.setText("Add Band");
        addbandbtn.setPreferredSize(new java.awt.Dimension(300, 40));
        addbandbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addbandbtnActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Georgia", 1, 24)); // NOI18N
        jLabel10.setText("Add Bands");

        javax.swing.GroupLayout BandPaneLayout = new javax.swing.GroupLayout(BandPane);
        BandPane.setLayout(BandPaneLayout);
        BandPaneLayout.setHorizontalGroup(
            BandPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BandPaneLayout.createSequentialGroup()
                .addGroup(BandPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(BandPaneLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(BandPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(BandPaneLayout.createSequentialGroup()
                                .addComponent(addbandlbl)
                                .addGap(18, 18, 18)
                                .addComponent(addbandtxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(BandPaneLayout.createSequentialGroup()
                                .addComponent(agent1lbl, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(agentlist, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(BandPaneLayout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(addbandbtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(53, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, BandPaneLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel10)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        BandPaneLayout.setVerticalGroup(
            BandPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BandPaneLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addGroup(BandPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(agent1lbl, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(agentlist, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(78, 78, 78)
                .addGroup(BandPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(addbandlbl, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addbandtxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(63, 63, 63)
                .addComponent(addbandbtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(83, Short.MAX_VALUE))
        );

        jSeparator2.setBackground(new java.awt.Color(255, 102, 102));
        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jLabel12.setFont(new java.awt.Font("Georgia", 1, 36)); // NOI18N
        jLabel12.setText("Add Agents and Bands");

        javax.swing.GroupLayout orgAgentBandLayout = new javax.swing.GroupLayout(orgAgentBand);
        orgAgentBand.setLayout(orgAgentBandLayout);
        orgAgentBandLayout.setHorizontalGroup(
            orgAgentBandLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(orgAgentBandLayout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addComponent(AgentPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 100, Short.MAX_VALUE)
                .addComponent(BandPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(61, 61, 61))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, orgAgentBandLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel12)
                .addGap(283, 283, 283))
            .addGroup(orgAgentBandLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(orgAgentBandLayout.createSequentialGroup()
                    .addGap(511, 511, 511)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(511, Short.MAX_VALUE)))
        );
        orgAgentBandLayout.setVerticalGroup(
            orgAgentBandLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, orgAgentBandLayout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(orgAgentBandLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(AgentPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BandPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(125, 125, 125))
            .addGroup(orgAgentBandLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(orgAgentBandLayout.createSequentialGroup()
                    .addGap(150, 150, 150)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 442, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(128, Short.MAX_VALUE)))
        );

        orgScreen.add(orgAgentBand, "card3");

        orgView.setBackground(new java.awt.Color(255, 204, 204));
        orgView.setMaximumSize(new java.awt.Dimension(1024, 720));
        orgView.setMinimumSize(new java.awt.Dimension(1024, 720));
        orgView.setPreferredSize(new java.awt.Dimension(1024, 720));

        conTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        conTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                conTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(conTable);

        jPanel3.setBackground(new java.awt.Color(248, 229, 229));

        concertidtxt.setText("PLEASE SELECT CONCERT");

        concertnametxt.setText("PLEASE SELECT CONCERT");

        concertlocationtxt.setText("PLEASE SELECT CONCERT");

        concertdatetxt.setText("PLEASE SELECT CONCERT");

        concertidlbl.setFont(new java.awt.Font("Georgia", 1, 14)); // NOI18N
        concertidlbl.setText("Concert ID:");

        concertnamelbl.setFont(new java.awt.Font("Georgia", 1, 14)); // NOI18N
        concertnamelbl.setText("Concert Name:");

        concertlocationlbl.setFont(new java.awt.Font("Georgia", 1, 14)); // NOI18N
        concertlocationlbl.setText("Concert Location:");

        concertdatelbl.setFont(new java.awt.Font("Georgia", 1, 14)); // NOI18N
        concertdatelbl.setText("Concert Date:");

        concertstatuslbl.setFont(new java.awt.Font("Georgia", 1, 14)); // NOI18N
        concertstatuslbl.setText("Concert Status:");

        concertcancelbtn.setFont(new java.awt.Font("Georgia", 1, 14)); // NOI18N
        concertcancelbtn.setText("Update");
        concertcancelbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                concertcancelbtnActionPerformed(evt);
            }
        });

        concertstatustxt.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Active", "Cancelled" }));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(concertdatelbl, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(concertlocationlbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(concertnamelbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(concertidlbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(concertstatuslbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(147, 147, 147)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(concertstatustxt, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(concertdatetxt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(concertlocationtxt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(concertidtxt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(concertnametxt))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(concertcancelbtn)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(concertidlbl)
                    .addComponent(concertidtxt))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(concertnamelbl)
                    .addComponent(concertnametxt, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(concertlocationlbl)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(concertlocationtxt, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(concertdatelbl)
                    .addComponent(concertdatetxt))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(concertstatuslbl)
                    .addComponent(concertstatustxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(concertcancelbtn)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        jLabel13.setFont(new java.awt.Font("Georgia", 1, 14)); // NOI18N
        jLabel13.setText("Select concerts from the table above to view and edit them.");

        jLabel14.setFont(new java.awt.Font("Georgia", 1, 14)); // NOI18N
        jLabel14.setText("Concert Table:");

        jLabel15.setFont(new java.awt.Font("Georgia", 1, 36)); // NOI18N
        jLabel15.setText("View and Edit Concerts");

        javax.swing.GroupLayout orgViewLayout = new javax.swing.GroupLayout(orgView);
        orgView.setLayout(orgViewLayout);
        orgViewLayout.setHorizontalGroup(
            orgViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(orgViewLayout.createSequentialGroup()
                .addGap(188, 188, 188)
                .addGroup(orgViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14)
                    .addGroup(orgViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 623, Short.MAX_VALUE)
                        .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, orgViewLayout.createSequentialGroup()
                .addContainerGap(300, Short.MAX_VALUE)
                .addComponent(jLabel15)
                .addGap(293, 293, 293))
        );
        orgViewLayout.setVerticalGroup(
            orgViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(orgViewLayout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, 57, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(74, 74, 74))
        );

        orgScreen.add(orgView, "card4");

        javax.swing.GroupLayout orgDashLayout = new javax.swing.GroupLayout(orgDash);
        orgDash.setLayout(orgDashLayout);
        orgDashLayout.setHorizontalGroup(
            orgDashLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(orgDashLayout.createSequentialGroup()
                .addComponent(orgControl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(orgScreen, javax.swing.GroupLayout.PREFERRED_SIZE, 1024, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        orgDashLayout.setVerticalGroup(
            orgDashLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(orgControl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(orgScreen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(orgDash, javax.swing.GroupLayout.DEFAULT_SIZE, 1287, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(orgDash, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //filling agent combo
    private void fill_agent_combo(){
        try {
            agentlist.removeAllItems();
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/festivalorg", "root", "");
            String q = "SELECT * FROM agent";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(q);
            
            while(rs.next()){
                String agent = rs.getString("agentName");
                agentlist.addItem(agent);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        
    }
    
    //filling concert combo
    private void fill_concert_combo(String uname){ 
        try {
            bandconcnametxt.removeAllItems();
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/festivalorg", "root", "");
            String q = "SELECT * FROM concert WHERE organizer = \"" + uname + "\""  ;
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(q);
            
            while(rs.next()){
                String agent = rs.getString("concertName");
                bandconcnametxt.addItem(agent);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        
    }
    
    //filling band combobox 
    private void fill_band_combo(){
        try {
            concbandnametxt.removeAllItems();
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/festivalorg", "root", "");
            String q = "SELECT * FROM band";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(q);
            
            while(rs.next()){
                String agent = rs.getString("bandName");
                concbandnametxt.addItem(agent);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        
    }
    
    //sidepanel button configuration   
    private void orgConcertBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_orgConcertBtnActionPerformed
        orgScreen.removeAll();
        orgScreen.repaint();
        orgScreen.revalidate();
        orgScreen.add(orgConcert);
        orgScreen.repaint();
        orgScreen.revalidate();
        orgConcertBtn.setBorder(BorderFactory.createLineBorder(new Color (0, 0, 0), 5));
        orgAgentBandBtn.setBorder(BorderFactory.createEmptyBorder());
        orgViewBtn.setBorder(BorderFactory.createEmptyBorder());
        fill_band_combo();
        fill_concert_combo(username);
        clear_textfields();
    }//GEN-LAST:event_orgConcertBtnActionPerformed

    private void orgViewBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_orgViewBtnActionPerformed
        orgScreen.removeAll();
        orgScreen.repaint();
        orgScreen.revalidate();
        orgScreen.add(orgView);
        orgScreen.repaint();
        orgScreen.revalidate();
        orgViewBtn.setBorder(BorderFactory.createLineBorder(new Color (0, 0, 0), 5));
        orgAgentBandBtn.setBorder(BorderFactory.createEmptyBorder());
        orgConcertBtn.setBorder(BorderFactory.createEmptyBorder());
        tblData();
        clear_textfields();
    }//GEN-LAST:event_orgViewBtnActionPerformed

    private void orgAgentBandBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_orgAgentBandBtnActionPerformed
        orgScreen.removeAll();
        orgScreen.repaint();
        orgScreen.revalidate();
        orgScreen.add(orgAgentBand);
        orgScreen.repaint();
        orgScreen.revalidate();
        orgConcertBtn.setBorder(BorderFactory.createEmptyBorder());
        orgAgentBandBtn.setBorder(BorderFactory.createLineBorder(new Color (0, 0, 0), 5));
        orgViewBtn.setBorder(BorderFactory.createEmptyBorder());
        fill_agent_combo();
        clear_textfields();
    }//GEN-LAST:event_orgAgentBandBtnActionPerformed

    private void addagenttxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addagenttxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addagenttxtActionPerformed

    
    //add new agents
    private void addagentbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addagentbtnActionPerformed
        try{
           Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/festivalorg", "root", "");
           String queryAA = " INSERT INTO agent (agentName) VALUES (?) ";

           PreparedStatement pst = con.prepareStatement(queryAA);
           pst.setString(1, addagenttxt.getText());
           pst.executeUpdate();
           fill_agent_combo();
           JOptionPane.showMessageDialog(null, "Successfully added agent");
           
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
        clear_textfields();
    }//GEN-LAST:event_addagentbtnActionPerformed

    private void addbandtxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addbandtxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addbandtxtActionPerformed

    
    //add bands
    private void addbandbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addbandbtnActionPerformed
        try{
           Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/festivalorg", "root", "");
          
           String queryAB = "SELECT agentId FROM agent WHERE agentName = \"" + agentlist.getSelectedItem().toString() + "\""; 
           PreparedStatement pst = con.prepareStatement(queryAB);
           ResultSet rs = pst.executeQuery();
           rs.next();
           String agentid = rs.getString("agentId");
           
           String queryAC = " INSERT INTO band (bandName, agentId) VALUES (?, ?) ";

           pst = con.prepareStatement(queryAC);
           pst.setString(1, addbandtxt.getText());
           pst.setString(2, agentid);
           
           pst.executeUpdate();
           
           JOptionPane.showMessageDialog(null, "Successfully added band");
           
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
        clear_textfields();
    }//GEN-LAST:event_addbandbtnActionPerformed

    private void tottxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tottxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tottxtActionPerformed
    
    
    //add new concerts
    private void conaddbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_conaddbtnActionPerformed
        if (priceval){
        try{
           Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/festivalorg", "root", "");
           String queryAA = " INSERT INTO concert (concertName, location, date, totalSeats, remainingSeats, organizer, priceA, priceB, priceC, concertStatus) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ";

           PreparedStatement pst = con.prepareStatement(queryAA);
           pst.setString(1, connametxt.getText());
           pst.setString(2, loctxt.getText());
           SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
           String date=sdf.format(condatetxt.getDate());
           pst.setString(3, date); 
           pst.setString(4, tottxt.getText());
           pst.setString(5, tottxt.getText());
           pst.setString(6, username);
           pst.setString(7, pratxt.getText());
           pst.setString(8, prbtxt.getText());
           pst.setString(9, prctxt.getText());
           pst.setString(10, "active");
           pst.executeUpdate();
           fill_concert_combo(username);
           
           JOptionPane.showMessageDialog(null, "Concert added, now ADD BANDS to your concert!! ");
           
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Concert addition FAILED! Databse error suspected! ");
        }                 
        clear_textfields();
        }
    }//GEN-LAST:event_conaddbtnActionPerformed
    
    //add bands to concert
    private void addconcertbandActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addconcertbandActionPerformed
        try{
           Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/festivalorg", "root", "");
          
           String queryBA = "SELECT concertId FROM concert WHERE concertName = \"" + bandconcnametxt.getSelectedItem().toString() + "\""; 
           PreparedStatement pst = con.prepareStatement(queryBA);
           ResultSet rs = pst.executeQuery();
           rs.next();
           String concertid = rs.getString("concertId");
           
           String queryBB = "SELECT bandId FROM band WHERE bandName = \"" + concbandnametxt.getSelectedItem().toString() + "\""; 
           pst = con.prepareStatement(queryBB);
           rs = pst.executeQuery();
           rs.next();
           String bandid = rs.getString("bandId");
           
           String mb =null;
           if (mainbandtxt.getSelectedItem().equals("Yes")){
               mb = "yes";
           } else {
               mb = "no";
           }
           
           String queryBC = " INSERT INTO concertband (concertId, bandId, ismain) VALUES (?, ?, ?) ";

           pst = con.prepareStatement(queryBC);
           pst.setString(1, concertid);
           pst.setString(2, bandid);
           pst.setString(3, mb);
           
           pst.executeUpdate();
           
           JOptionPane.showMessageDialog(null, "Successfully added BAND to the CONCERT");
           
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
        clear_textfields();
    }//GEN-LAST:event_addconcertbandActionPerformed
    
    
    //cancel concert
    private void concertcancelbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_concertcancelbtnActionPerformed
        try{
           Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/festivalorg", "root", "");
           int row = conTable.getSelectedRow();
           String value = (conTable.getModel().getValueAt(row, 0).toString());
           String queryB = "UPDATE concert SET concertStatus = ? WHERE concertId = " + value ;

           PreparedStatement pst = con.prepareStatement(queryB);     
           if (concertstatustxt.getSelectedItem().equals("Active")){
               pst.setString(1, "active");
           }else{
               pst.setString(1, "cancelled");
           }
           pst.executeUpdate();

            String query1 = "SELECT concertId, concertName, location, date FROM concert WHERE organizer = \"" + username + "\";";
            pst = con.prepareStatement(query1);
            ResultSet rs = pst.executeQuery();
            conTable.setModel(DbUtils.resultSetToTableModel(rs));

           JOptionPane.showMessageDialog(null, "Successfully updated");
           

           
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
        clear_textfields();
    }//GEN-LAST:event_concertcancelbtnActionPerformed
    
    //view concert details
    private void conTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_conTableMouseClicked
        int i = conTable.getSelectedRow();
        TableModel model = conTable.getModel();

        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/festivalorg", "root", "");
            String query2 = ("SELECT * FROM concert WHERE concertId = \"" + model.getValueAt(i, 0).toString() + "\"");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query2);
            rs.next();
            concertidtxt.setText(rs.getString("concertId"));
            concertnametxt.setText(rs.getString("concertName"));
            concertlocationtxt.setText(rs.getString("location")); 
            concertdatetxt.setText(rs.getString("date"));            
            if (rs.getString("concertStatus").equals("active")){
                concertstatustxt.setSelectedItem("Active");
            }else{
                concertstatustxt.setSelectedItem("Cancelled");
            }
                        
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }//GEN-LAST:event_conTableMouseClicked

    
    //logout
    private void log_out_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_log_out_btnActionPerformed
        LoginRegister lr = new LoginRegister();
        lr.setVisible(true);
        close();
    }//GEN-LAST:event_log_out_btnActionPerformed

    private void concbandnametxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_concbandnametxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_concbandnametxtActionPerformed

    private void pratxtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pratxtKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_pratxtKeyPressed

        // VALIDATIONS ::::
    private void pratxtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pratxtKeyReleased
        if (val.testNumber(pratxt.getText())){
            price_val_lbl.setText("");
            priceval = true;
        } else {
            price_val_lbl.setText("Prices should be numbers");
            priceval = false;
        }
    }//GEN-LAST:event_pratxtKeyReleased

    private void prbtxtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_prbtxtKeyReleased
        if (val.testNumber(prbtxt.getText())){
            price_val_lbl.setText("");
            priceval = true;
        } else {
            price_val_lbl.setText("Prices should be numbers");
            priceval = false;
        }
    }//GEN-LAST:event_prbtxtKeyReleased

    private void prctxtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_prctxtKeyReleased
        if (val.testNumber(prctxt.getText())){
            price_val_lbl.setText("");
            priceval = true;
        } else {
            price_val_lbl.setText("Prices should be numbers");
            priceval = false;
        }
    }//GEN-LAST:event_prctxtKeyReleased



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel AgentPane;
    private javax.swing.JPanel BandPane;
    private javax.swing.JButton addagentbtn;
    private javax.swing.JLabel addagentlbl;
    private javax.swing.JTextField addagenttxt;
    private javax.swing.JButton addbandbtn;
    private javax.swing.JLabel addbandlbl;
    private javax.swing.JTextField addbandtxt;
    private javax.swing.JButton addconcertband;
    private javax.swing.JLabel agent1lbl;
    public javax.swing.JComboBox<String> agentlist;
    private javax.swing.JLabel bandconcnamelbl;
    private javax.swing.JComboBox<String> bandconcnametxt;
    private javax.swing.JTable conTable;
    private javax.swing.JButton conaddbtn;
    private javax.swing.JLabel concbandnamelbl;
    private javax.swing.JComboBox<String> concbandnametxt;
    private javax.swing.JButton concertcancelbtn;
    private javax.swing.JLabel concertdatelbl;
    private javax.swing.JLabel concertdatetxt;
    private javax.swing.JLabel concertidlbl;
    private javax.swing.JLabel concertidtxt;
    private javax.swing.JLabel concertlocationlbl;
    private javax.swing.JLabel concertlocationtxt;
    private javax.swing.JLabel concertnamelbl;
    private javax.swing.JLabel concertnametxt;
    private javax.swing.JLabel concertstatuslbl;
    private javax.swing.JComboBox<String> concertstatustxt;
    private javax.swing.JLabel condatelbl;
    private com.toedter.calendar.JDateChooser condatetxt;
    private javax.swing.JLabel connamelbl;
    private javax.swing.JTextField connametxt;
    private javax.swing.JPanel cover_pane;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel loclbl;
    private javax.swing.JTextField loctxt;
    private javax.swing.JButton log_out_btn;
    private javax.swing.JLabel mainbandlbl;
    private javax.swing.JComboBox<String> mainbandtxt;
    private javax.swing.JPanel orgAgentBand;
    private javax.swing.JButton orgAgentBandBtn;
    private javax.swing.JPanel orgConcert;
    private javax.swing.JButton orgConcertBtn;
    private javax.swing.JPanel orgControl;
    private javax.swing.JPanel orgDash;
    private javax.swing.JPanel orgScreen;
    private javax.swing.JPanel orgView;
    private javax.swing.JButton orgViewBtn;
    private javax.swing.JLabel pralbl;
    private javax.swing.JTextField pratxt;
    private javax.swing.JLabel prblbl;
    private javax.swing.JTextField prbtxt;
    private javax.swing.JLabel prclbl;
    private javax.swing.JTextField prctxt;
    private javax.swing.JLabel price_val_lbl;
    private javax.swing.JLabel totlbl;
    private javax.swing.JTextField tottxt;
    // End of variables declaration//GEN-END:variables
}
