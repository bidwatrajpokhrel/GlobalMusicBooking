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
import javax.swing.*;
import javax.swing.table.TableModel;
import net.proteanit.sql.DbUtils;

public class CostumerDash extends javax.swing.JFrame {
    
    
    //declaration of database variables
    Connection con = null;
    PreparedStatement st = null;
    ResultSet rs = null;
    Statement s = null;
    
    //making object for validation class
    Validation val = new Validation();
    
    //boolean values for validations
    private boolean phoneval = true, nameval = true, emailval = true, postcodeval = true, booknumval = false;
    
    
    private String username;
    private String accountType;

    CostumerDash() {
        
        //connecting to database server
         try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/festivalorg","root","");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Database connectivity failed");
        }
        
        initComponents();
        fetch();
        seticon();
        
     
    }
    //set Jframe Icon
    private void seticon(){       
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Images/LOGO.PNG")));
    }
    
    //fetching username and viewing account type
    public void setusername (String username_input){
        username = username_input;
        System.out.println(username);
        String query = "SELECT accountType FROM user WHERE userName = \"" + username + "\"";
        try {
            st = con.prepareStatement(query);
            rs = st.executeQuery();
            rs.next();
            accountType = rs.getString("accountType");            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,ex);
        }
      
    }
    
    //close window
    public void close(){
        WindowEvent winClosingEvent = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosingEvent);
    }
    
    //fetch bands to fill in table
    private void fetch_bands(String concertId){
        String query = "SELECT band.bandName, concertBand.isMain  FROM band INNER JOIN concertband ON band.bandId = concertband.bandId WHERE concertBand.concertId = " + concertId ;
         try{
            st = con.prepareStatement(query);
            rs = st.executeQuery();
            view_bands_table.setModel(DbUtils.resultSetToTableModel(rs));
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Database error");
        }
        
    }
    
    //fetch booking
    private void fetch_booking(){
        try {
            String query = "SELECT booking.bookingId, concert.concertName, booking.numberofTickets, booking.bookingPayment FROM concert, booking WHERE booking.userName = \""+ username + "\" AND booking.concertId = concert.concertId";
            st = con.prepareStatement(query);
            rs = st.executeQuery();
            view_booking_table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }
    
    //to fetch bookings from invoice table
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
            view_invoiced_bookings.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }
    //get the invoice table     
    private void fetch_invoice(){
        try {
            String query = "SELECT invoiceId, year, month, paymentStatus from invoice WHERE userName = \"" + username + "\"";
            st = con.prepareStatement(query);
            rs = st.executeQuery();
            view_invoice_table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }
    
    
    //get data in concert table
    private void fetch(){
             
        try{
            String query = "SELECT concertId, concertName, location, date FROM concert WHERE concertStatus = \"active\" AND date > now();";
            st = con.prepareStatement(query);
            rs = st.executeQuery();
            view_concert_table.setModel(DbUtils.resultSetToTableModel(rs));
            
            
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e);
        }
               
    }
    
  
    private void setlbl(){
        
        try {
            String query = ("SELECT * FROM user WHERE userName = \"" + username + "\"");
            s = con.createStatement();
            rs = s.executeQuery(query);
            rs.next();
            edituntxt.setText(rs.getString("userName"));
            editpwtxt.setText(rs.getString("password"));
            editnametxt.setText(rs.getString("name"));
            editaddtxt.setText(rs.getString("address"));
            editpctxt.setText(rs.getString("postCode"));
            editemailtxt.setText(rs.getString("email"));
            editcntxt.setText(rs.getString("contactNumber"));
            editwbtxt.setText(rs.getString("website"));
            editattxt.setText(rs.getString("accountType"));
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
                
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPasswordField1 = new javax.swing.JPasswordField();
        cost_controls = new javax.swing.JPanel();
        book_concert_selection = new javax.swing.JButton();
        view_booking_selection = new javax.swing.JButton();
        view_invoice_selection = new javax.swing.JButton();
        edit_profile_selection = new javax.swing.JButton();
        log_out_btn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cost_work_area = new javax.swing.JPanel();
        cover_pane = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        book_concert_pane = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        view_concert_table = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        connamelbl = new javax.swing.JLabel();
        conloclbl = new javax.swing.JLabel();
        condatelbl = new javax.swing.JLabel();
        contotlbl = new javax.swing.JLabel();
        conremlbl = new javax.swing.JLabel();
        conorglbl = new javax.swing.JLabel();
        pralbl = new javax.swing.JLabel();
        prblbl = new javax.swing.JLabel();
        prclbl = new javax.swing.JLabel();
        conidlbl = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        no_of_tickets_lbl = new javax.swing.JLabel();
        book_button = new javax.swing.JButton();
        no_of_tickets_txt = new javax.swing.JTextField();
        number_val_lbl = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        conidtxt = new javax.swing.JLabel();
        condatetxt = new javax.swing.JLabel();
        conremtxt = new javax.swing.JLabel();
        contottxt = new javax.swing.JLabel();
        conorgtxt = new javax.swing.JLabel();
        prbtxt = new javax.swing.JLabel();
        pratxt = new javax.swing.JLabel();
        prctxt = new javax.swing.JLabel();
        conloctxt = new javax.swing.JLabel();
        connametxt = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        view_bands_table = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        view_booking_pane = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        view_booking_table = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        bookidlbl = new javax.swing.JLabel();
        bookconidlbl = new javax.swing.JLabel();
        bookconnamelbl = new javax.swing.JLabel();
        bookticketlbl = new javax.swing.JLabel();
        bookpaylbl = new javax.swing.JLabel();
        bookdatelbl = new javax.swing.JLabel();
        bookprtlbl = new javax.swing.JLabel();
        bookstatlbl = new javax.swing.JLabel();
        bookidtxt = new javax.swing.JLabel();
        bookdatetxt = new javax.swing.JLabel();
        booktickettxt = new javax.swing.JLabel();
        bookconidtxt = new javax.swing.JLabel();
        bookpaytxt = new javax.swing.JLabel();
        bookconnametxt = new javax.swing.JLabel();
        bookstattxt = new javax.swing.JLabel();
        bookprttxt = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        view_invoice_pane = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        view_invoice_table = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        view_invoiced_bookings = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        mtxt = new javax.swing.JLabel();
        mlbl = new javax.swing.JLabel();
        albl = new javax.swing.JLabel();
        atxt = new javax.swing.JLabel();
        ylbl = new javax.swing.JLabel();
        pstxt = new javax.swing.JLabel();
        ytxt = new javax.swing.JLabel();
        pslbl = new javax.swing.JLabel();
        pay_invoice_button = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        edit_accounts_pane = new javax.swing.JPanel();
        update_account_button = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        editcntxt = new javax.swing.JTextField();
        editaddlbl = new javax.swing.JLabel();
        editpctxt = new javax.swing.JTextField();
        editpclbl = new javax.swing.JLabel();
        editaddtxt = new javax.swing.JTextField();
        editcnlbl = new javax.swing.JLabel();
        editnametxt = new javax.swing.JTextField();
        editemaillbl = new javax.swing.JLabel();
        editpwtxt = new javax.swing.JPasswordField();
        editwblbl = new javax.swing.JLabel();
        editatlbl = new javax.swing.JLabel();
        editunlbl = new javax.swing.JLabel();
        editwbtxt = new javax.swing.JTextField();
        editpwlbl = new javax.swing.JLabel();
        editemailtxt = new javax.swing.JTextField();
        editnamelbl = new javax.swing.JLabel();
        edituntxt = new javax.swing.JLabel();
        editattxt = new javax.swing.JLabel();
        name_val_lbl = new javax.swing.JLabel();
        postcode_val_lbl = new javax.swing.JLabel();
        phone_val_lbl = new javax.swing.JLabel();
        email_val_lbl = new javax.swing.JLabel();
        website_val_lbl = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        update_error_lbl = new javax.swing.JLabel();

        jPasswordField1.setText("jPasswordField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("COSTUMER -- Global Music Concert/Music Festival Booking");
        setLocation(new java.awt.Point(360, 180));
        setMaximumSize(new java.awt.Dimension(1280, 720));
        setMinimumSize(new java.awt.Dimension(1280, 720));
        setName(""); // NOI18N
        setPreferredSize(new java.awt.Dimension(1280, 720));
        setResizable(false);

        cost_controls.setBackground(new java.awt.Color(248, 229, 229));
        cost_controls.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        cost_controls.setPreferredSize(new java.awt.Dimension(256, 720));
        cost_controls.setRequestFocusEnabled(false);

        book_concert_selection.setBackground(new java.awt.Color(255, 94, 137));
        book_concert_selection.setFont(new java.awt.Font("Georgia", 0, 18)); // NOI18N
        book_concert_selection.setText("View and Book Concert");
        book_concert_selection.setMaximumSize(new java.awt.Dimension(230, 100));
        book_concert_selection.setMinimumSize(new java.awt.Dimension(230, 100));
        book_concert_selection.setPreferredSize(new java.awt.Dimension(230, 100));
        book_concert_selection.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                book_concert_selectionActionPerformed(evt);
            }
        });

        view_booking_selection.setBackground(new java.awt.Color(255, 94, 137));
        view_booking_selection.setFont(new java.awt.Font("Georgia", 0, 18)); // NOI18N
        view_booking_selection.setText("View Booking");
        view_booking_selection.setToolTipText("");
        view_booking_selection.setPreferredSize(new java.awt.Dimension(230, 100));
        view_booking_selection.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                view_booking_selectionActionPerformed(evt);
            }
        });

        view_invoice_selection.setBackground(new java.awt.Color(255, 94, 137));
        view_invoice_selection.setFont(new java.awt.Font("Georgia", 0, 18)); // NOI18N
        view_invoice_selection.setText("View Invoices");
        view_invoice_selection.setToolTipText("");
        view_invoice_selection.setMaximumSize(new java.awt.Dimension(230, 100));
        view_invoice_selection.setPreferredSize(new java.awt.Dimension(230, 100));
        view_invoice_selection.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                view_invoice_selectionActionPerformed(evt);
            }
        });

        edit_profile_selection.setBackground(new java.awt.Color(255, 94, 137));
        edit_profile_selection.setFont(new java.awt.Font("Georgia", 0, 12)); // NOI18N
        edit_profile_selection.setText("Edit Profile");
        edit_profile_selection.setPreferredSize(new java.awt.Dimension(110, 30));
        edit_profile_selection.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edit_profile_selectionActionPerformed(evt);
            }
        });

        log_out_btn.setBackground(new java.awt.Color(255, 94, 137));
        log_out_btn.setFont(new java.awt.Font("Georgia", 0, 12)); // NOI18N
        log_out_btn.setText("Log Out");
        log_out_btn.setPreferredSize(new java.awt.Dimension(110, 30));
        log_out_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                log_out_btnActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Georgia", 3, 36)); // NOI18N
        jLabel1.setText("CUSTOMER");

        jLabel3.setFont(new java.awt.Font("Georgia", 0, 24)); // NOI18N
        jLabel3.setText("PANEL");

        javax.swing.GroupLayout cost_controlsLayout = new javax.swing.GroupLayout(cost_controls);
        cost_controls.setLayout(cost_controlsLayout);
        cost_controlsLayout.setHorizontalGroup(
            cost_controlsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, cost_controlsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(cost_controlsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(view_booking_selection, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, cost_controlsLayout.createSequentialGroup()
                        .addComponent(edit_profile_selection, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(log_out_btn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(cost_controlsLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(book_concert_selection, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(view_invoice_selection, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(cost_controlsLayout.createSequentialGroup()
                .addGap(91, 91, 91)
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        cost_controlsLayout.setVerticalGroup(
            cost_controlsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, cost_controlsLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addComponent(book_concert_selection, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52)
                .addComponent(view_booking_selection, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(view_invoice_selection, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(66, 66, 66)
                .addGroup(cost_controlsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(edit_profile_selection, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(log_out_btn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(53, 53, 53))
        );

        cost_work_area.setPreferredSize(new java.awt.Dimension(1024, 720));
        cost_work_area.setLayout(new java.awt.CardLayout());

        cover_pane.setBackground(new java.awt.Color(255, 204, 204));

        jLabel2.setFont(new java.awt.Font("Georgia", 1, 100)); // NOI18N
        jLabel2.setText("WELCOME, ");

        jLabel4.setFont(new java.awt.Font("Georgia", 0, 75)); // NOI18N
        jLabel4.setText("Dear Costumer! ");

        jLabel5.setFont(new java.awt.Font("Georgia", 2, 48)); // NOI18N
        jLabel5.setText("Select a tab on the left to continue...");

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/multiple-users-silhouette.png"))); // NOI18N

        javax.swing.GroupLayout cover_paneLayout = new javax.swing.GroupLayout(cover_pane);
        cover_pane.setLayout(cover_paneLayout);
        cover_paneLayout.setHorizontalGroup(
            cover_paneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cover_paneLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, cover_paneLayout.createSequentialGroup()
                .addContainerGap(91, Short.MAX_VALUE)
                .addGroup(cover_paneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(cover_paneLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 784, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(cover_paneLayout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(59, 59, 59)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 563, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(30, 30, 30))
        );
        cover_paneLayout.setVerticalGroup(
            cover_paneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cover_paneLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(cover_paneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(cover_paneLayout.createSequentialGroup()
                        .addGap(0, 88, Short.MAX_VALUE)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(76, 76, 76))
        );

        cost_work_area.add(cover_pane, "card6");

        book_concert_pane.setBackground(new java.awt.Color(255, 204, 204));
        book_concert_pane.setPreferredSize(new java.awt.Dimension(1024, 720));

        view_concert_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        view_concert_table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                view_concert_tableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(view_concert_table);

        jPanel1.setBackground(new java.awt.Color(248, 229, 229));

        connamelbl.setFont(new java.awt.Font("Georgia", 1, 14)); // NOI18N
        connamelbl.setText("Concert Name: ");

        conloclbl.setFont(new java.awt.Font("Georgia", 1, 14)); // NOI18N
        conloclbl.setText("Concert Location: ");

        condatelbl.setFont(new java.awt.Font("Georgia", 1, 14)); // NOI18N
        condatelbl.setText("Concert Date: ");

        contotlbl.setFont(new java.awt.Font("Georgia", 1, 14)); // NOI18N
        contotlbl.setText("Total Seats: ");

        conremlbl.setFont(new java.awt.Font("Georgia", 1, 14)); // NOI18N
        conremlbl.setText("Remaining Seats: ");

        conorglbl.setFont(new java.awt.Font("Georgia", 1, 14)); // NOI18N
        conorglbl.setText("Organizer: ");

        pralbl.setFont(new java.awt.Font("Georgia", 1, 14)); // NOI18N
        pralbl.setText("Price:");

        prblbl.setFont(new java.awt.Font("Georgia", 1, 14)); // NOI18N
        prblbl.setText("Discounted Price: ");

        prclbl.setFont(new java.awt.Font("Georgia", 1, 14)); // NOI18N
        prclbl.setText("Corporate Price:");

        conidlbl.setFont(new java.awt.Font("Georgia", 1, 14)); // NOI18N
        conidlbl.setText("Concert ID:");

        jPanel2.setBackground(new java.awt.Color(255, 204, 204));

        no_of_tickets_lbl.setFont(new java.awt.Font("Georgia", 1, 14)); // NOI18N
        no_of_tickets_lbl.setText("Number of Tickets: ");

        book_button.setText("Book Tickets");
        book_button.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        book_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                book_buttonActionPerformed(evt);
            }
        });

        no_of_tickets_txt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                no_of_tickets_txtKeyReleased(evt);
            }
        });

        number_val_lbl.setFont(new java.awt.Font("Georgia", 0, 10)); // NOI18N
        number_val_lbl.setForeground(new java.awt.Color(255, 0, 102));

        jLabel18.setText("Note for General customers:");

        jLabel19.setText("Buy 10 tickets to get the discounted price.");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel18)
                        .addGap(0, 79, Short.MAX_VALUE))
                    .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(book_button)
                .addGap(26, 26, 26))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(no_of_tickets_lbl)
                .addGap(31, 31, 31)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(number_val_lbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(no_of_tickets_txt, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(no_of_tickets_lbl)
                    .addComponent(no_of_tickets_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(number_val_lbl)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 83, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(book_button)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel18)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel19)
                        .addGap(9, 9, 9))))
        );

        conidtxt.setText("Please Select A Concert");

        condatetxt.setText("Please Select A Concert");

        conremtxt.setText("Please Select A Concert");

        contottxt.setText("Please Select A Concert");

        conorgtxt.setText("Please Select A Concert");

        prbtxt.setText("Please Select A Concert");

        pratxt.setText("Please Select A Concert");

        prctxt.setText("Please Select A Concert");

        conloctxt.setText("Please Select A Concert");

        connametxt.setText("Please Select A Concert");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(conidlbl)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(conidtxt, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(prclbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(prblbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(conloclbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(connamelbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(condatelbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(contotlbl, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(conremlbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(conorglbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(pralbl, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(prbtxt, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(prctxt, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pratxt, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(conorgtxt, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(conremtxt, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(contottxt, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(condatetxt, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(connametxt, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(conloctxt, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(101, 101, 101))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(conidlbl)
                    .addComponent(conidtxt, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(connamelbl)
                    .addComponent(connametxt, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(conloctxt, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(conloclbl))
                .addGap(7, 7, 7)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(condatetxt, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(condatelbl))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(contottxt, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(contotlbl, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(conremlbl)
                    .addComponent(conremtxt, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(conorglbl)
                    .addComponent(conorgtxt, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pralbl)
                    .addComponent(pratxt, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(prbtxt, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(prblbl))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(prclbl)
                    .addComponent(prctxt, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        view_bands_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Band Name", "Is Main"
            }
        ));
        jScrollPane2.setViewportView(view_bands_table);

        jLabel7.setFont(new java.awt.Font("Georgia", 0, 13)); // NOI18N
        jLabel7.setText("Please select a concert from the table above to view bands and other informaton");

        jLabel8.setFont(new java.awt.Font("Georgia", 1, 18)); // NOI18N
        jLabel8.setText("Concerts:");

        jLabel9.setFont(new java.awt.Font("Georgia", 1, 36)); // NOI18N
        jLabel9.setText("Book and View Concerts");

        javax.swing.GroupLayout book_concert_paneLayout = new javax.swing.GroupLayout(book_concert_pane);
        book_concert_pane.setLayout(book_concert_paneLayout);
        book_concert_paneLayout.setHorizontalGroup(
            book_concert_paneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(book_concert_paneLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(book_concert_paneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 541, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(book_concert_paneLayout.createSequentialGroup()
                        .addGroup(book_concert_paneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 494, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 497, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addGap(48, 48, 48)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(27, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, book_concert_paneLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 522, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(251, 251, 251))
        );
        book_concert_paneLayout.setVerticalGroup(
            book_concert_paneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(book_concert_paneLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(book_concert_paneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(book_concert_paneLayout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(69, Short.MAX_VALUE))
        );

        cost_work_area.add(book_concert_pane, "card2");

        view_booking_pane.setBackground(new java.awt.Color(255, 204, 204));
        view_booking_pane.setMaximumSize(new java.awt.Dimension(1024, 720));

        jPanel5.setBackground(new java.awt.Color(248, 229, 229));

        view_booking_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        view_booking_table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                view_booking_tableMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(view_booking_table);

        jPanel3.setBackground(new java.awt.Color(255, 204, 204));

        bookidlbl.setFont(new java.awt.Font("Georgia", 1, 14)); // NOI18N
        bookidlbl.setText("Booking Id: ");

        bookconidlbl.setFont(new java.awt.Font("Georgia", 1, 14)); // NOI18N
        bookconidlbl.setText("Concert Id:");

        bookconnamelbl.setFont(new java.awt.Font("Georgia", 1, 14)); // NOI18N
        bookconnamelbl.setText("Concert Name: ");

        bookticketlbl.setFont(new java.awt.Font("Georgia", 1, 14)); // NOI18N
        bookticketlbl.setText("Number of Tickets: ");

        bookpaylbl.setFont(new java.awt.Font("Georgia", 1, 14)); // NOI18N
        bookpaylbl.setText("Payment Status: ");

        bookdatelbl.setFont(new java.awt.Font("Georgia", 1, 14)); // NOI18N
        bookdatelbl.setText("Booking Date:");

        bookprtlbl.setFont(new java.awt.Font("Georgia", 1, 14)); // NOI18N
        bookprtlbl.setText("Price Type:");

        bookstatlbl.setFont(new java.awt.Font("Georgia", 1, 14)); // NOI18N
        bookstatlbl.setText("Booking Status: ");

        bookidtxt.setText("Please Select A Booking");

        bookdatetxt.setText("Please Select A Booking");

        booktickettxt.setText("Please Select A Booking");

        bookconidtxt.setText("Please Select A Booking");

        bookpaytxt.setText("Please Select A Booking");

        bookconnametxt.setText("Please Select A Booking");

        bookstattxt.setText("Please Select A Booking");

        bookprttxt.setText("Please Select A Booking");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(bookdatelbl, javax.swing.GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE)
                            .addComponent(bookidlbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bookidtxt, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(bookpaylbl, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bookticketlbl, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(bookdatetxt, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(booktickettxt, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(bookpaytxt, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(bookconidlbl, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6))
                            .addComponent(bookstatlbl, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(50, 50, 50)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(bookprttxt, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bookconidtxt, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bookconnametxt, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bookstattxt, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 9, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(bookprtlbl, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(bookconnamelbl, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bookidlbl)
                    .addComponent(bookidtxt)
                    .addComponent(bookconidlbl)
                    .addComponent(bookconidtxt))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bookdatelbl)
                    .addComponent(bookconnamelbl)
                    .addComponent(bookconnametxt)
                    .addComponent(bookdatetxt))
                .addGap(7, 7, 7)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bookticketlbl)
                    .addComponent(booktickettxt)
                    .addComponent(bookprtlbl)
                    .addComponent(bookprttxt))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bookpaylbl)
                    .addComponent(bookpaytxt)
                    .addComponent(bookstatlbl)
                    .addComponent(bookstattxt))
                .addContainerGap(55, Short.MAX_VALUE))
        );

        jLabel10.setFont(new java.awt.Font("Georgia", 1, 14)); // NOI18N
        jLabel10.setText("Please select a booking from the table above to view information");

        jLabel11.setFont(new java.awt.Font("Georgia", 1, 18)); // NOI18N
        jLabel11.setText(" Your Bookings:");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 679, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 679, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34))
        );

        jLabel12.setFont(new java.awt.Font("Georgia", 1, 36)); // NOI18N
        jLabel12.setText("View Booking");

        javax.swing.GroupLayout view_booking_paneLayout = new javax.swing.GroupLayout(view_booking_pane);
        view_booking_pane.setLayout(view_booking_paneLayout);
        view_booking_paneLayout.setHorizontalGroup(
            view_booking_paneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(view_booking_paneLayout.createSequentialGroup()
                .addContainerGap(138, Short.MAX_VALUE)
                .addGroup(view_booking_paneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, view_booking_paneLayout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(126, 126, 126))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, view_booking_paneLayout.createSequentialGroup()
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(337, 337, 337))))
        );
        view_booking_paneLayout.setVerticalGroup(
            view_booking_paneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(view_booking_paneLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(76, Short.MAX_VALUE))
        );

        cost_work_area.add(view_booking_pane, "card2");

        view_invoice_pane.setBackground(new java.awt.Color(255, 204, 204));

        view_invoice_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        view_invoice_table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                view_invoice_tableMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(view_invoice_table);

        jPanel4.setBackground(new java.awt.Color(248, 229, 229));

        view_invoiced_bookings.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane5.setViewportView(view_invoiced_bookings);

        jPanel6.setBackground(new java.awt.Color(255, 204, 204));

        mtxt.setText("PLEASE SELECT AN INVOICE");

        mlbl.setFont(new java.awt.Font("Georgia", 1, 14)); // NOI18N
        mlbl.setText("Month:");

        albl.setFont(new java.awt.Font("Georgia", 1, 14)); // NOI18N
        albl.setText("Total Amount:");

        atxt.setText("PLEASE SELECT AN INVOICE");

        ylbl.setFont(new java.awt.Font("Georgia", 1, 14)); // NOI18N
        ylbl.setText("Year:");

        pstxt.setText("PLEASE SELECT AN INVOICE");

        ytxt.setText("PLEASE SELECT AN INVOICE");

        pslbl.setFont(new java.awt.Font("Georgia", 1, 14)); // NOI18N
        pslbl.setText("Payment Status: ");

        pay_invoice_button.setText("Pay Invoice");
        pay_invoice_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pay_invoice_buttonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(312, Short.MAX_VALUE)
                .addComponent(pay_invoice_button, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel6Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(pslbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(ylbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(mlbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(albl, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(pstxt, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(atxt, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(mtxt, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(ytxt, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(104, Short.MAX_VALUE)))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pay_invoice_button, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel6Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(pslbl)
                        .addComponent(pstxt))
                    .addGap(23, 23, 23)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(ylbl)
                        .addComponent(ytxt))
                    .addGap(18, 18, 18)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(mlbl)
                        .addComponent(mtxt))
                    .addGap(18, 18, 18)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(albl)
                        .addComponent(atxt))
                    .addContainerGap(117, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 381, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 257, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jLabel13.setFont(new java.awt.Font("Georgia", 0, 13)); // NOI18N
        jLabel13.setText("Please select invoice in the table above to view your bookings of the month and other details:");

        jLabel14.setFont(new java.awt.Font("Georgia", 1, 18)); // NOI18N
        jLabel14.setText("Invoice Table:");

        jLabel15.setFont(new java.awt.Font("Georgia", 1, 36)); // NOI18N
        jLabel15.setText("View Invoices");

        jLabel16.setText("Note: You only recieve an invoice if you are a corporate user.");

        javax.swing.GroupLayout view_invoice_paneLayout = new javax.swing.GroupLayout(view_invoice_pane);
        view_invoice_pane.setLayout(view_invoice_paneLayout);
        view_invoice_paneLayout.setHorizontalGroup(
            view_invoice_paneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(view_invoice_paneLayout.createSequentialGroup()
                .addGroup(view_invoice_paneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 867, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(view_invoice_paneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(view_invoice_paneLayout.createSequentialGroup()
                            .addGap(127, 127, 127)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 585, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(view_invoice_paneLayout.createSequentialGroup()
                            .addGap(372, 372, 372)
                            .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(view_invoice_paneLayout.createSequentialGroup()
                            .addGap(74, 74, 74)
                            .addGroup(view_invoice_paneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(view_invoice_paneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jScrollPane4))))))
                .addContainerGap(75, Short.MAX_VALUE))
        );
        view_invoice_paneLayout.setVerticalGroup(
            view_invoice_paneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(view_invoice_paneLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel16)
                .addGap(23, 23, 23))
        );

        cost_work_area.add(view_invoice_pane, "card2");

        edit_accounts_pane.setBackground(new java.awt.Color(255, 204, 204));

        update_account_button.setFont(new java.awt.Font("Georgia", 0, 18)); // NOI18N
        update_account_button.setText("Update Account");
        update_account_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                update_account_buttonActionPerformed(evt);
            }
        });

        jPanel7.setBackground(new java.awt.Color(248, 229, 229));

        editcntxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                editcntxtKeyReleased(evt);
            }
        });

        editaddlbl.setFont(new java.awt.Font("Georgia", 1, 14)); // NOI18N
        editaddlbl.setText("Address: ");

        editpctxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                editpctxtKeyReleased(evt);
            }
        });

        editpclbl.setFont(new java.awt.Font("Georgia", 1, 14)); // NOI18N
        editpclbl.setText("Post Code: ");

        editcnlbl.setFont(new java.awt.Font("Georgia", 1, 14)); // NOI18N
        editcnlbl.setText("Contact Number: ");

        editnametxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editnametxtActionPerformed(evt);
            }
        });
        editnametxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                editnametxtKeyReleased(evt);
            }
        });

        editemaillbl.setFont(new java.awt.Font("Georgia", 1, 14)); // NOI18N
        editemaillbl.setText("Email: ");

        editwblbl.setFont(new java.awt.Font("Georgia", 1, 14)); // NOI18N
        editwblbl.setText("Website: ");

        editatlbl.setFont(new java.awt.Font("Georgia", 1, 14)); // NOI18N
        editatlbl.setText("Account Type: ");

        editunlbl.setFont(new java.awt.Font("Georgia", 1, 14)); // NOI18N
        editunlbl.setText("Username: ");

        editwbtxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                editwbtxtKeyReleased(evt);
            }
        });

        editpwlbl.setFont(new java.awt.Font("Georgia", 1, 14)); // NOI18N
        editpwlbl.setText("Password: ");

        editemailtxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                editemailtxtKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                editemailtxtKeyTyped(evt);
            }
        });

        editnamelbl.setFont(new java.awt.Font("Georgia", 1, 14)); // NOI18N
        editnamelbl.setText("Name: ");

        name_val_lbl.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N
        name_val_lbl.setForeground(new java.awt.Color(255, 51, 102));

        postcode_val_lbl.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N
        postcode_val_lbl.setForeground(new java.awt.Color(255, 51, 102));

        phone_val_lbl.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N
        phone_val_lbl.setForeground(new java.awt.Color(255, 51, 102));

        email_val_lbl.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N
        email_val_lbl.setForeground(new java.awt.Color(255, 51, 102));

        website_val_lbl.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N
        website_val_lbl.setForeground(new java.awt.Color(255, 51, 102));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(26, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(editatlbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(editwblbl, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(editemaillbl, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(editcnlbl, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(editaddlbl, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(editnamelbl, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(editpwlbl, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(editpclbl, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(editunlbl, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(editattxt, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(108, 108, 108)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(website_val_lbl, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(email_val_lbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(phone_val_lbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(postcode_val_lbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(name_val_lbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(edituntxt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(editnametxt)
                                .addComponent(editpwtxt)
                                .addComponent(editaddtxt)
                                .addComponent(editpctxt)
                                .addComponent(editcntxt)
                                .addComponent(editemailtxt)
                                .addComponent(editwbtxt, javax.swing.GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(editunlbl)
                    .addComponent(edituntxt))
                .addGap(28, 28, 28)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(editpwlbl)
                    .addComponent(editpwtxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(editnamelbl)
                    .addComponent(editnametxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4)
                .addComponent(name_val_lbl)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(editaddlbl)
                    .addComponent(editaddtxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(editpclbl)
                    .addComponent(editpctxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addComponent(postcode_val_lbl)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(editcnlbl)
                    .addComponent(editcntxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(phone_val_lbl)
                .addGap(3, 3, 3)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(editemaillbl)
                    .addComponent(editemailtxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3)
                .addComponent(email_val_lbl)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(editwblbl)
                    .addComponent(editwbtxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2)
                .addComponent(website_val_lbl, javax.swing.GroupLayout.PREFERRED_SIZE, 9, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(editatlbl)
                    .addComponent(editattxt))
                .addGap(35, 35, 35))
        );

        jLabel17.setFont(new java.awt.Font("Georgia", 1, 36)); // NOI18N
        jLabel17.setText("Edit Profile/Account");

        update_error_lbl.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        update_error_lbl.setForeground(new java.awt.Color(255, 51, 102));

        javax.swing.GroupLayout edit_accounts_paneLayout = new javax.swing.GroupLayout(edit_accounts_pane);
        edit_accounts_pane.setLayout(edit_accounts_paneLayout);
        edit_accounts_paneLayout.setHorizontalGroup(
            edit_accounts_paneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(edit_accounts_paneLayout.createSequentialGroup()
                .addContainerGap(288, Short.MAX_VALUE)
                .addGroup(edit_accounts_paneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, edit_accounts_paneLayout.createSequentialGroup()
                        .addGroup(edit_accounts_paneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(update_account_button, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(update_error_lbl, javax.swing.GroupLayout.PREFERRED_SIZE, 411, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(264, 264, 264))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, edit_accounts_paneLayout.createSequentialGroup()
                        .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 402, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(297, 297, 297))))
        );
        edit_accounts_paneLayout.setVerticalGroup(
            edit_accounts_paneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(edit_accounts_paneLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 72, Short.MAX_VALUE)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(update_error_lbl, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(update_account_button, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(64, 64, 64))
        );

        cost_work_area.add(edit_accounts_pane, "card2");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(cost_controls, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cost_work_area, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(cost_controls, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(cost_work_area, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //BUTTONS IN THE SIDEPANEL (CONFIGURATION)
    
    private void view_invoice_selectionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_view_invoice_selectionActionPerformed
        cost_work_area.removeAll();
        cost_work_area.repaint();
        cost_work_area.revalidate();
        cost_work_area.add(view_invoice_pane);
        cost_work_area.repaint();
        cost_work_area.revalidate();
        view_invoice_selection.setBorder(BorderFactory.createLineBorder(new Color (0, 0, 0), 5));
        view_booking_selection.setBorder(BorderFactory.createEmptyBorder());
        book_concert_selection.setBorder(BorderFactory.createEmptyBorder());
        edit_profile_selection.setBorder(BorderFactory.createEmptyBorder());
        fetch_invoice();
    }//GEN-LAST:event_view_invoice_selectionActionPerformed

    private void book_concert_selectionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_book_concert_selectionActionPerformed
        cost_work_area.removeAll();
        cost_work_area.repaint();
        cost_work_area.revalidate();
        cost_work_area.add(book_concert_pane);
        cost_work_area.repaint();
        cost_work_area.revalidate();
        view_invoice_selection.setBorder(BorderFactory.createEmptyBorder());
        view_booking_selection.setBorder(BorderFactory.createEmptyBorder());
        book_concert_selection.setBorder(BorderFactory.createLineBorder(new Color (0, 0, 0), 5));
        edit_profile_selection.setBorder(BorderFactory.createEmptyBorder());
    }//GEN-LAST:event_book_concert_selectionActionPerformed

    private void edit_profile_selectionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edit_profile_selectionActionPerformed
        cost_work_area.removeAll();
        cost_work_area.repaint();
        cost_work_area.revalidate();
        cost_work_area.add(edit_accounts_pane);
        cost_work_area.repaint();
        cost_work_area.revalidate();
        view_invoice_selection.setBorder(BorderFactory.createEmptyBorder());
        view_booking_selection.setBorder(BorderFactory.createEmptyBorder());
        book_concert_selection.setBorder(BorderFactory.createEmptyBorder());
        edit_profile_selection.setBorder(BorderFactory.createLineBorder(new Color (0, 0, 0), 5));
        setlbl();
    }//GEN-LAST:event_edit_profile_selectionActionPerformed

    private void view_booking_selectionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_view_booking_selectionActionPerformed
        cost_work_area.removeAll();
        cost_work_area.repaint();
        cost_work_area.revalidate();
        cost_work_area.add(view_booking_pane);
        cost_work_area.repaint();
        cost_work_area.revalidate();
        view_invoice_selection.setBorder(BorderFactory.createEmptyBorder());
        view_booking_selection.setBorder(BorderFactory.createLineBorder(new Color (0, 0, 0), 5));
        book_concert_selection.setBorder(BorderFactory.createEmptyBorder());
        edit_profile_selection.setBorder(BorderFactory.createEmptyBorder());
        fetch_booking();
    }//GEN-LAST:event_view_booking_selectionActionPerformed

    //populate concert details
    private void view_concert_tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_view_concert_tableMouseClicked
        int row = view_concert_table.getSelectedRow();
        String value = (view_concert_table.getModel().getValueAt(row, 0).toString());
        fetch_bands(value);
        
          try {
            String query = ("SELECT * FROM concert WHERE concertId = \"" + value + "\"");
            s = con.createStatement();
            rs = s.executeQuery(query);
            rs.next(); 
            conidtxt.setText(rs.getString("concertId"));
            connametxt.setText(rs.getString("concertName"));
            conloctxt.setText(rs.getString("location")); 
            condatetxt.setText(rs.getString("date"));
            contottxt.setText(rs.getString("totalSeats"));
            conremtxt.setText(rs.getString("remainingSeats"));
            conorgtxt.setText(rs.getString("organizer"));
            pratxt.setText(rs.getString("priceA"));
            prbtxt.setText(rs.getString("priceB"));
            prctxt.setText(rs.getString("priceC"));
            
                        
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
                                       

    }//GEN-LAST:event_view_concert_tableMouseClicked

    
    //book seats for a conert
    private void book_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_book_buttonActionPerformed
        if (booknumval){
        try {
            String q = "SELECT * FROM concert WHERE concertId = " + conidtxt.getText() ;
            s = con.createStatement();
            rs = s.executeQuery(q);
            rs.next();
            if (Integer.parseInt(no_of_tickets_txt.getText()) > Integer.parseInt(rs.getString("remainingSeats"))){
                JOptionPane.showMessageDialog(null , "NUMBER OF SEATS EXCEEDS REMAINING SEATS");
            }else{

                String query = "INSERT INTO BOOKING (userName, concertId, numberofTickets, priceType, bookingStatus, bookingPayment, bookingDate) values (?, ?, ?, ?, ?, ?, ?)"; 
                st = con.prepareStatement(query);
                st.setString(1, username);
                st.setString(2, conidtxt.getText());
                st.setString(3, no_of_tickets_txt.getText());
                String priceType = null;
                String bookingPay = null;
                String msg = null; 
                if (accountType.equals("corporate")){
                    priceType = "c";
                    bookingPay = "unpaid";
                    msg = "BOOKING SUCCESSFUL! PLEASE PAY YOUR BOOKINGS IN THE INVOICE NEXT MONTH";             
                } else {
                    bookingPay = "paid";
                    msg = "BOOKING SUCCESSFUL! YOU PAID FOR YOUR BOOKING! THANK YOU";  
                    if (Integer.parseInt(no_of_tickets_txt.getText()) > 10){
                        priceType = "b";

                    } else {
                        priceType = "a";
                    }
                }
                st.setString(4, priceType);
                st.setString(5, "active");
                st.setString(6, bookingPay);
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                String today = sdf.format(Calendar.getInstance().getTime());
                st.setString(7, today);
                st.executeUpdate();

                query = "UPDATE concert SET remainingSeats = ? WHERE concertId = " + conidtxt.getText();
                st = con.prepareStatement(query);
                int remaining = Integer.parseInt(conremtxt.getText()) - Integer.parseInt(no_of_tickets_txt.getText());
                st.setInt(1, remaining);
                st.executeUpdate();

                JOptionPane.showMessageDialog(null, msg);
            }
        
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Booking Error, Database Error Suspected");
        }
        }
        
    }//GEN-LAST:event_book_buttonActionPerformed

    //get booking details
    private void view_booking_tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_view_booking_tableMouseClicked
        int i = view_booking_table.getSelectedRow();
        TableModel model = view_booking_table.getModel(); 

        try {
            String query2 = ("SELECT * FROM booking WHERE bookingId = " + model.getValueAt(i, 0).toString()) ;
            s = con.createStatement();
            rs = s.executeQuery(query2);
            rs.next();
            bookidtxt.setText(rs.getString("bookingId"));            
            bookconidtxt.setText(rs.getString("concertId"));             
            if (rs.getString("bookingPayment").equals("paid")){
                bookpaytxt.setText("Paid");
            }else{
                bookpaytxt.setText("Unpaid");
            }
            
            if (rs.getString("bookingStatus").equals("active")){
                bookstattxt.setText("Active");
            }else{
                bookstattxt.setText("Cancelled");
            }     
            if (rs.getString("priceType").equals("a")){
                bookprttxt.setText("Normal");
            } else if (rs.getString("priceType").equals("b")){
                bookprttxt.setText("Discounted");
            } else {
                bookprttxt.setText("Corporate");
            }   
            bookdatetxt.setText(rs.getString("bookingDate"));
            booktickettxt.setText(rs.getString("numberofTickets"));
            bookconnametxt.setText(model.getValueAt(i, 1).toString());
            
                      
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }//GEN-LAST:event_view_booking_tableMouseClicked

    //pay invoice
    private void pay_invoice_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pay_invoice_buttonActionPerformed
        try{
           int row = view_invoice_table.getSelectedRow();
           String value = (view_invoice_table.getModel().getValueAt(row, 0).toString());
           String month = (view_invoice_table.getModel().getValueAt(row, 2).toString());
           String year = ((view_invoice_table.getModel().getValueAt(row, 1).toString()));
           String queryC = "UPDATE invoice SET paymentStatus = \"paid\" WHERE invoiceId = \"" +value + "\"";
           st = con.prepareStatement(queryC);        
           st.executeUpdate();
           
           AdminDash ad = new AdminDash();
           String start = ad.convertDateStart(month, year);
           String end = ad.convertDateEnd(month, year);
           String query = "UPDATE booking SET bookingPayment = \"paid\" WHERE userName = \"" + username + "\" AND \"" +start+ "\" < bookingDate AND bookingDate < \"" + end + "\"";
           
           st = con.prepareStatement(query);
           st.executeUpdate();
           
           JOptionPane.showMessageDialog(null, "YOU HAVE SUCCESSFULLY PAID YOUR INVOICE");
           fetch_invoice();
        } catch (SQLException e){
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_pay_invoice_buttonActionPerformed

    //view invoice details
    private void view_invoice_tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_view_invoice_tableMouseClicked
                try {
            int i = view_invoice_table.getSelectedRow();        
            TableModel model = view_invoice_table.getModel();
            String query = ("SELECT * FROM invoice WHERE invoiceId = \"" + model.getValueAt(i, 0).toString() + "\"");
            s = con.createStatement();
            rs = s.executeQuery(query);
            rs.next();
            String usern = rs.getString("userName");
            String y = rs.getString("year");
            String m = rs.getString ("month");
            if (rs.getString("paymentStatus").equals("paid")){
                pstxt.setText("Paid");
            } else {
                pstxt.setText("Not Paid");
            }
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
    }//GEN-LAST:event_view_invoice_tableMouseClicked

    private void editnametxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editnametxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_editnametxtActionPerformed

    //update your account 
    private void update_account_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_update_account_buttonActionPerformed
        boolean registercheck = false;
        if (nameval && phoneval && emailval && postcodeval && !(editaddtxt.getText().equals("")) && !(editpwtxt.getText().equals(""))) {
            registercheck = true;
            
        } else {
           registercheck = false;
           update_error_lbl.setText("Please check validations and fill all required feilds");
        }
        
        if (registercheck){
        try{
           String query3 = "UPDATE user SET password = ?, name = ?, contactNumber = ?, email = ?, address = ?, postcode = ?, website = ? where userName = \""+ username + "\"";

           st = con.prepareStatement(query3);
           st.setString(1, editpwtxt.getText());
           st.setString(2, editnametxt.getText()); 
           st.setString(3, editcntxt.getText());
           st.setString(4, editemailtxt.getText());
           st.setString(5, editaddtxt.getText());
           st.setString(6, editpctxt.getText());
           st.setString(7 , editwbtxt.getText());
           st.executeUpdate();
           
           JOptionPane.showMessageDialog(null, "Successfully updated");
           setlbl();
           
           
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Update Error, Database Error Suspected");
        }
        
        }
    }//GEN-LAST:event_update_account_buttonActionPerformed



//logout    
    private void log_out_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_log_out_btnActionPerformed
        LoginRegister lr = new LoginRegister();
        lr.setVisible(true);
        close();
    }//GEN-LAST:event_log_out_btnActionPerformed

    //VALIDATIONS
    private void editnametxtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_editnametxtKeyReleased
        if (val.nameTest(editnametxt.getText())){
            name_val_lbl.setText("");
            nameval = true;
        } else {
            name_val_lbl.setText("Enter a valid name");
            nameval = false;
        }
    }//GEN-LAST:event_editnametxtKeyReleased

    private void editpctxtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_editpctxtKeyReleased
        if (val.testNumber(editpctxt.getText())){
            postcode_val_lbl.setText("");
            postcodeval = true;
        } else {
            postcode_val_lbl.setText("Enter a valid postal code");
            postcodeval = false;
        }
    }//GEN-LAST:event_editpctxtKeyReleased

    private void editcntxtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_editcntxtKeyReleased
        if (val.phoneTest(editcntxt.getText())){
            phone_val_lbl.setText("");
            phoneval = true;
        }else {
            phone_val_lbl.setText("Enter a valid Phone number");
            phoneval = false;
        }
    }//GEN-LAST:event_editcntxtKeyReleased

    private void editemailtxtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_editemailtxtKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_editemailtxtKeyTyped

    private void editemailtxtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_editemailtxtKeyReleased
        if (val.emailTest(editemailtxt.getText())){
            email_val_lbl.setText(""); 
            emailval = true;
        } else {
            email_val_lbl.setText("Enter a valid email");
            emailval = false;
        }
    }//GEN-LAST:event_editemailtxtKeyReleased

    private void editwbtxtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_editwbtxtKeyReleased
        if (val.testWebsite(editwbtxt.getText())){
            website_val_lbl.setText("");
        } else {
            website_val_lbl.setText("Enter a valid web address");
        }  
    }//GEN-LAST:event_editwbtxtKeyReleased

    private void no_of_tickets_txtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_no_of_tickets_txtKeyReleased
        if (val.testNumber(no_of_tickets_txt.getText())){
            number_val_lbl.setText("");
            booknumval = true;
        } else {
            number_val_lbl.setText("Enter valid number");
            booknumval = false;
        }
    }//GEN-LAST:event_no_of_tickets_txtKeyReleased



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel albl;
    private javax.swing.JLabel atxt;
    private javax.swing.JButton book_button;
    private javax.swing.JPanel book_concert_pane;
    private javax.swing.JButton book_concert_selection;
    private javax.swing.JLabel bookconidlbl;
    private javax.swing.JLabel bookconidtxt;
    private javax.swing.JLabel bookconnamelbl;
    private javax.swing.JLabel bookconnametxt;
    private javax.swing.JLabel bookdatelbl;
    private javax.swing.JLabel bookdatetxt;
    private javax.swing.JLabel bookidlbl;
    private javax.swing.JLabel bookidtxt;
    private javax.swing.JLabel bookpaylbl;
    private javax.swing.JLabel bookpaytxt;
    private javax.swing.JLabel bookprtlbl;
    private javax.swing.JLabel bookprttxt;
    private javax.swing.JLabel bookstatlbl;
    private javax.swing.JLabel bookstattxt;
    private javax.swing.JLabel bookticketlbl;
    private javax.swing.JLabel booktickettxt;
    private javax.swing.JLabel condatelbl;
    private javax.swing.JLabel condatetxt;
    private javax.swing.JLabel conidlbl;
    private javax.swing.JLabel conidtxt;
    private javax.swing.JLabel conloclbl;
    private javax.swing.JLabel conloctxt;
    private javax.swing.JLabel connamelbl;
    private javax.swing.JLabel connametxt;
    private javax.swing.JLabel conorglbl;
    private javax.swing.JLabel conorgtxt;
    private javax.swing.JLabel conremlbl;
    private javax.swing.JLabel conremtxt;
    private javax.swing.JLabel contotlbl;
    private javax.swing.JLabel contottxt;
    private javax.swing.JPanel cost_controls;
    private javax.swing.JPanel cost_work_area;
    private javax.swing.JPanel cover_pane;
    private javax.swing.JPanel edit_accounts_pane;
    private javax.swing.JButton edit_profile_selection;
    private javax.swing.JLabel editaddlbl;
    private javax.swing.JTextField editaddtxt;
    private javax.swing.JLabel editatlbl;
    private javax.swing.JLabel editattxt;
    private javax.swing.JLabel editcnlbl;
    private javax.swing.JTextField editcntxt;
    private javax.swing.JLabel editemaillbl;
    private javax.swing.JTextField editemailtxt;
    private javax.swing.JLabel editnamelbl;
    private javax.swing.JTextField editnametxt;
    private javax.swing.JLabel editpclbl;
    private javax.swing.JTextField editpctxt;
    private javax.swing.JLabel editpwlbl;
    private javax.swing.JPasswordField editpwtxt;
    private javax.swing.JLabel editunlbl;
    private javax.swing.JLabel edituntxt;
    private javax.swing.JLabel editwblbl;
    private javax.swing.JTextField editwbtxt;
    private javax.swing.JLabel email_val_lbl;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
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
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JButton log_out_btn;
    private javax.swing.JLabel mlbl;
    private javax.swing.JLabel mtxt;
    private javax.swing.JLabel name_val_lbl;
    private javax.swing.JLabel no_of_tickets_lbl;
    private javax.swing.JTextField no_of_tickets_txt;
    private javax.swing.JLabel number_val_lbl;
    private javax.swing.JButton pay_invoice_button;
    private javax.swing.JLabel phone_val_lbl;
    private javax.swing.JLabel postcode_val_lbl;
    private javax.swing.JLabel pralbl;
    private javax.swing.JLabel pratxt;
    private javax.swing.JLabel prblbl;
    private javax.swing.JLabel prbtxt;
    private javax.swing.JLabel prclbl;
    private javax.swing.JLabel prctxt;
    private javax.swing.JLabel pslbl;
    private javax.swing.JLabel pstxt;
    private javax.swing.JButton update_account_button;
    private javax.swing.JLabel update_error_lbl;
    private javax.swing.JTable view_bands_table;
    private javax.swing.JPanel view_booking_pane;
    private javax.swing.JButton view_booking_selection;
    private javax.swing.JTable view_booking_table;
    private javax.swing.JTable view_concert_table;
    private javax.swing.JPanel view_invoice_pane;
    private javax.swing.JButton view_invoice_selection;
    private javax.swing.JTable view_invoice_table;
    private javax.swing.JTable view_invoiced_bookings;
    private javax.swing.JLabel website_val_lbl;
    private javax.swing.JLabel ylbl;
    private javax.swing.JLabel ytxt;
    // End of variables declaration//GEN-END:variables
}
