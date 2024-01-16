/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.Timer;

/**
 *
 * @author Madhushi
 */
public class MainForm extends javax.swing.JFrame {

    /**
     * Creates new form MainForm
     */
    
//    public static SystemManager manager ;
    
    public MainForm() {
        initComponents();
        
        construct();
        
//         manager = new SystemManager("flightinfo.txt");
    }
    
    public MainForm(String file) {
        initComponents();
        
        construct();
        
//        manager = new SystemManager(file);
    }
    
    private void construct()
    {

        final DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        int interval = 1000; // 1000 ms

        new Timer(interval, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Calendar now = Calendar.getInstance();
                lblNow.setText(dateFormat.format(now.getTime())+"   "+functions.get_balance(Main_Jframe.user)+"$");
            }
        }).start();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        dp = new javax.swing.JDesktopPane();
        jLabel1 = new javax.swing.JLabel();
        panelStatus = new javax.swing.JPanel();
        lblNow = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        menuReserveSeat = new javax.swing.JMenuItem();
        menuCancelReservation = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        menuAbout = new javax.swing.JMenuItem();

        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Fly With Us | User Portal");
        setMaximumSize(new java.awt.Dimension(1024, 650));
        setMinimumSize(new java.awt.Dimension(1024, 650));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        dp.setBackground(new java.awt.Color(204, 204, 204));
        dp.setMaximumSize(new java.awt.Dimension(1024, 500));
        dp.setMinimumSize(new java.awt.Dimension(1024, 500));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/let's flight .png"))); // NOI18N
        jLabel1.setMaximumSize(new java.awt.Dimension(1024, 500));
        jLabel1.setMinimumSize(new java.awt.Dimension(1024, 500));
        jLabel1.setPreferredSize(new java.awt.Dimension(1024, 500));

        dp.setLayer(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout dpLayout = new javax.swing.GroupLayout(dp);
        dp.setLayout(dpLayout);
        dpLayout.setHorizontalGroup(
            dpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        dpLayout.setVerticalGroup(
            dpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 552, Short.MAX_VALUE)
        );

        lblNow.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        lblNow.setText("Loading..");

        javax.swing.GroupLayout panelStatusLayout = new javax.swing.GroupLayout(panelStatus);
        panelStatus.setLayout(panelStatusLayout);
        panelStatusLayout.setHorizontalGroup(
            panelStatusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelStatusLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblNow)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelStatusLayout.setVerticalGroup(
            panelStatusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelStatusLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblNow, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jMenuBar1.setMinimumSize(new java.awt.Dimension(66, 50));
        jMenuBar1.setPreferredSize(new java.awt.Dimension(180, 50));

        jMenu1.setText("File");
        jMenu1.setFont(new java.awt.Font("Segoe UI Semibold", 0, 15)); // NOI18N
        jMenu1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jMenu1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jMenu1.setPreferredSize(new java.awt.Dimension(30, 25));

        jMenuItem2.setText("Log Out");
        jMenuItem2.setPreferredSize(new java.awt.Dimension(65, 30));
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuBar1.add(jMenu1);

        jMenu4.setText("Tools");
        jMenu4.setFont(new java.awt.Font("Segoe UI Semibold", 0, 15)); // NOI18N

        menuReserveSeat.setText("Booking");
        menuReserveSeat.setPreferredSize(new java.awt.Dimension(107, 30));
        menuReserveSeat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuReserveSeatActionPerformed(evt);
            }
        });
        jMenu4.add(menuReserveSeat);

        menuCancelReservation.setText("Previous Flights");
        menuCancelReservation.setPreferredSize(new java.awt.Dimension(131, 30));
        menuCancelReservation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuCancelReservationActionPerformed(evt);
            }
        });
        jMenu4.add(menuCancelReservation);

        jMenuBar1.add(jMenu4);

        jMenu3.setText("Help");
        jMenu3.setFont(new java.awt.Font("Segoe UI Semibold", 0, 15)); // NOI18N

        menuAbout.setText("About");
        menuAbout.setPreferredSize(new java.awt.Dimension(53, 30));
        menuAbout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuAboutActionPerformed(evt);
            }
        });
        jMenu3.add(menuAbout);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelStatus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(dp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(dp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        String ObjButtons[] = {"Yes","No"};
        int PromptResult = JOptionPane.showOptionDialog(null,"Are you sure you want to Log Out?","Fly With Us",JOptionPane.DEFAULT_OPTION,JOptionPane.WARNING_MESSAGE,null,ObjButtons,ObjButtons[1]);
        if(PromptResult==JOptionPane.YES_OPTION)
        {
            this.setVisible(false);
            Main_Jframe n=new Main_Jframe();
            n.setVisible(true);
        }
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void menuAboutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuAboutActionPerformed
        About ab = new About();
    }//GEN-LAST:event_menuAboutActionPerformed

    private void menuReserveSeatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuReserveSeatActionPerformed
       FlightSearch interf = new FlightSearch();
       interf.pack();
       interf.setVisible(true);
       dp.add(interf);
    }//GEN-LAST:event_menuReserveSeatActionPerformed

    private void menuCancelReservationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuCancelReservationActionPerformed
        try {
            ArrayList<String> checkData = new ArrayList<>();
            ArrayList<String> x = new ArrayList<>();
            x = functions.searchMyPreviosFilght(Main_Jframe.user);
            for (int i = x.size()-1; i >= Integer.max(0, x.size()-3); i--) {
                if (x.get(i).trim() != "") {
                    checkData.add(x.get(i));
                }
            }
            if (checkData.size() > 0) {
                PreviosFlightSearchResults select = new PreviosFlightSearchResults(checkData);
                select.pack();
                select.setVisible(true);
                dp.add(select);
            } else {
                JOptionPane.showMessageDialog(null, "Sorry but there are no flights for the provided details.");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_menuCancelReservationActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
//        manager.saveReservations();;
//        manager.saveFlightInfo();
    }//GEN-LAST:event_formWindowClosing


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane dp;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JLabel lblNow;
    private javax.swing.JMenuItem menuAbout;
    private javax.swing.JMenuItem menuCancelReservation;
    private javax.swing.JMenuItem menuReserveSeat;
    private javax.swing.JPanel panelStatus;
    // End of variables declaration//GEN-END:variables
}