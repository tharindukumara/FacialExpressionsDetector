/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emotions;

import Luxand.FSDK;
import com.googlecode.javacv.cpp.opencv_core;
import com.googlecode.javacv.cpp.opencv_core.IplImage;
import static com.googlecode.javacv.cpp.opencv_core.cvClearMemStorage;
import static com.googlecode.javacv.cpp.opencv_core.cvGetSeqElem;
import static com.googlecode.javacv.cpp.opencv_core.cvLoad;
import static com.googlecode.javacv.cpp.opencv_core.cvReleaseImage;
import static com.googlecode.javacv.cpp.opencv_core.cvSetImageROI;
import static com.googlecode.javacv.cpp.opencv_highgui.cvSaveImage;
import com.googlecode.javacv.cpp.opencv_objdetect;
import static com.googlecode.javacv.cpp.opencv_objdetect.CV_HAAR_DO_CANNY_PRUNING;
import static com.googlecode.javacv.cpp.opencv_objdetect.cvHaarDetectObjects;
import java.awt.Color;
import java.awt.FileDialog;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import org.neuroph.core.NeuralNetwork;

/**
 *
 * @author Tharindu
 */
public class Main extends javax.swing.JFrame {

    BufferedImage imgs;
    private int width;
    private int height;
    String fileName;
    String fileSave;
    String classifer1 = "C:/opencv/data/haarcascades/haarcascade_frontalface_alt_tree.xml";
    String classifer2 = "C:/opencv/data/haarcascades/haarcascade_frontalface_alt.xml";
    String emotionFile = "Neutral";
    String emotionType[] = {"Anger", "Disgust", "Fear", "Happy", "Sadness", "Surprise", "Neutral"};
    int myfeature[] = {16, 17, 27, 28, 31, 32, 3, 4, 54, 13, 14, 64, 25, 26, 23, 24};
    int line[][] = {{54, 64}, {13, 24}, {14, 25}, {32, 31}, {28, 27}, {27, 16}, {31, 17}, {23, 24}, {25, 26}, {3, 4}, {4, 25}, {4, 26}, {3, 27}, {3, 23}};

    /**
     * Creates new form Main
     */
    public Main() {
        initComponents();

        width = withfeatures.getSize().width;
        height = withfeatures.getSize().height;
        try {
            int r = FSDK.ActivateLibrary("OoofBIq3Wa8H2X8yb778rlqvseokUZpmRJjRAFaqHjotklLQHCZh/pIZmuSnZCxRZE4m+PzBvp7roU6N2LaU+xSJ37g1wfG1lq1iosoa85/0FH1I9IeNUmh8sv0JhctOwoZbN3Kh9fo5ZTDXCgJQTe/3SMFavgusCwK5ryAbyvg=");
            if (r != FSDK.FSDKE_OK) {
                System.out.println("Activation Failed!!!");
                System.exit(r);
            }
        } catch (java.lang.UnsatisfiedLinkError e) {
            System.out.println("Error occured...!!!");
            System.exit(1);
        }

        FSDK.Initialize();
        FSDK.SetFaceDetectionParameters(false, true, 384);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        original = new javax.swing.JLabel();
        face = new javax.swing.JLabel();
        withfeatures = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        myimg = new javax.swing.JLabel();
        imgtxt = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Emotion Detector");
        setMinimumSize(new java.awt.Dimension(1090, 730));

        original.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        face.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        withfeatures.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jButton3.setText("Detect");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton1.setText("Browse");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Convert");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Controls");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(40, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 102, 102));
        jLabel2.setText("Sad     :");

        jTextField1.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jTextField1.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 102, 102));
        jLabel3.setText("Happy : ");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(102, 102, 102));
        jLabel4.setText("Fear    : ");

        jTextField2.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jTextField2.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        jTextField3.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jTextField3.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(102, 102, 102));
        jLabel5.setText("Suprise : ");

        jTextField4.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jTextField4.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        jTextField5.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jTextField5.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        jTextField6.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jTextField6.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(102, 102, 102));
        jLabel6.setText("Angry   : ");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(102, 102, 102));
        jLabel7.setText("Disgust : ");

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        imgtxt.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        imgtxt.setForeground(new java.awt.Color(255, 0, 0));
        imgtxt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(imgtxt, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(myimg, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(myimg, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(imgtxt, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
                    .addComponent(jTextField2)
                    .addComponent(jTextField3))
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jTextField4))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5)))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(30, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 216, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(original, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(withfeatures, javax.swing.GroupLayout.PREFERRED_SIZE, 354, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(face, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 4, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(2, 2, 2))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(original, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(face, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(withfeatures, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        jTextField1.setText("0" + "%");
        jTextField2.setText("0" + "%");
        jTextField3.setText("0" + "%");
        jTextField4.setText("0" + "%");
        jTextField5.setText("0" + "%");
        jTextField6.setText("0" + "%");
        try {
            FileDialog dlg = new FileDialog((java.awt.Frame) null, "Open File", FileDialog.LOAD);
            dlg.setFile("*.jpg");
            dlg.setVisible(true);
            fileSave = dlg.getFile();
            fileName = dlg.getDirectory() + fileSave;
            imgs = null;
            imgs = ImageIO.read(new File(fileName));

            ImageIcon img = new ImageIcon(imgs);
            img.setImage(img.getImage().getScaledInstance(original.getSize().width, original.getSize().height, 1));
            original.setIcon(img);

        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:  
        //Convet Button
        imgs = IPMethods.contrastStretching(imgs);
        imgs = IPMethods.medianFilter(imgs);
        imgs = IPMethods.toGScale(imgs);
        ImageIcon img = new ImageIcon(imgs);
        img = new ImageIcon(imgs);

        img.setImage(img.getImage().getScaledInstance(face.getSize().width, face.getSize().height, 1));

        face.setIcon(img);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        IplImage image = IplImage.createFrom(imgs);
//        cvSaveImage("tmp2.jpg", image);
        if (image.isNull()) {
            System.out.println("Could not open the image file");
            System.exit(0);

        }
        double len[] = null;
        try {

            image = detect_and_draw(image, classifer1);
            if (image.isNull()) {
            }

            cvSaveImage("tmp.jpg", image);
            double normalizeX = image.width();
            double normalizeY = image.height();
            image.release();
            cvReleaseImage(image);
            len = getFeatureValues(normalizeX, normalizeY, "tmp.jpg", true);

        } catch (NullPointerException e) {

            try {
                image = IplImage.createFrom(imgs);
                image = detect_and_draw(image, classifer2);
                if (image.isNull()) {
                } else {

                    cvSaveImage("tmp.jpg", image);
                    double normalizeX = image.width();
                    double normalizeY = image.height();
                    image.release();
                    cvReleaseImage(image);
                    len = getFeatureValues(normalizeX, normalizeY, "tmp.jpg", true);
                    if (len.length > 2) {
                        for (int i = 0; i < len.length; ++i) {
                            System.out.print(len[i] + ",");
                        }
                        System.out.println("");
                    }
                }

            } catch (NullPointerException ex) {
                JOptionPane.showMessageDialog(null, "NO FACE DETECTED");

            }
        }

        if (len.length > 2) {
            double[] emotion = new double[6];
            NeuralNetwork network = NeuralNetwork.load(".\\NeuralNetworks\\angryNN.nnet");

            network.setInput(len);
            network.calculate();
            double[] output = network.getOutput();
            emotion[0] = output[0];

            //happy
            network = NeuralNetwork.load(".\\NeuralNetworks\\happyNN.nnet");

            network.setInput(len);
            network.calculate();
            output = network.getOutput();
            emotion[1] = output[0];

            //fear
            network = NeuralNetwork.load(".\\NeuralNetworks\\fearNN.nnet");

            network.setInput(len);
            network.calculate();
            output = network.getOutput();
            emotion[2] = output[0];

            //disgust
            network = NeuralNetwork.load(".\\NeuralNetworks\\disgustNN.nnet");

            network.setInput(len);
            network.calculate();
            output = network.getOutput();
            emotion[3] = output[0];

            //sad
            network = NeuralNetwork.load(".\\NeuralNetworks\\sadNN.nnet");

            network.setInput(len);
            network.calculate();
            output = network.getOutput();
            emotion[4] = output[0];

            //surprise
            network = NeuralNetwork.load(".\\NeuralNetworks\\surpriseNN.nnet");

            network.setInput(len);
            network.calculate();
            output = network.getOutput();
            emotion[5] = output[0];

            int i = maxIndex(emotion);
            if (emotion[i] < 0.5) {

                myimg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/emotions/smilies/neutral.png")));
                imgtxt.setText("Neutral");
            } else {
                switch (i) {
                    case 0:
                        myimg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/emotions/smilies/anger.png")));
                        imgtxt.setText("Angry");
                        break;
                    case 1:
                        myimg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/emotions/smilies/happy.png")));
                        imgtxt.setText("Happy");
                        break;
                    case 2:
                        myimg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/emotions/smilies/fear.png")));
                        imgtxt.setText("Fear");
                        break;
                    case 3:
                        myimg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/emotions/smilies/disgust.png")));
                        imgtxt.setText("Disgust");
                        break;
                    case 4:
                        myimg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/emotions/smilies/sad.png")));
                        imgtxt.setText("Sadness");
                        break;
                    case 5:
                        myimg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/emotions/smilies/suprise.png")));
                        imgtxt.setText("Suprise");
                        break;

                }
            }
            jTextField1.setText(Math.round(emotion[1] * 100) + "%");
            jTextField2.setText(Math.round(emotion[4] * 100) + "%");
            jTextField3.setText(Math.round(emotion[2] * 100) + "%");
            jTextField4.setText(Math.round(emotion[5] * 100) + "%");
            jTextField5.setText(Math.round(emotion[0] * 100) + "%");
            jTextField6.setText(Math.round(emotion[3] * 100) + "%");
        }
        image.release();
        cvReleaseImage(image);

    }//GEN-LAST:event_jButton3ActionPerformed
    int maxIndex(double[] array) {
        int m = 0;
        double max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (max < array[i]) {
                m = i;
                max = array[i];
            }
        }
        return m;
    }

    IplImage detect_and_draw(opencv_core.IplImage img, String classifier) {
        // Create a new Haar classifier & Load the HaarClassifierCascad
        opencv_objdetect.CvHaarClassifierCascade cascade = new opencv_objdetect.CvHaarClassifierCascade(cvLoad(classifier));
        // Check whether the cascade has loaded successfully. Else report and error and quit
        if (cascade.isNull()) {
            System.out.println("ERROR: Could not load classifier cascade\n");
            return null;
        }
        // Allocate the memory storage
        opencv_core.CvMemStorage storage = opencv_core.CvMemStorage.create();

        opencv_core.CvSeq faces = cvHaarDetectObjects(img, cascade, storage, 1.5, 3, CV_HAAR_DO_CANNY_PRUNING);
        // Find whether the cascade is loaded, to find the faces. If yes, then:

        cvClearMemStorage(storage);

        int total = faces.total();
        // There can be more than one face in an image. So create a growable sequence of faces.
        // Detect the objects and store them in the sequence

        if (total == 0) {
            return null;
        } else {

            // Create a new rectangle for drawing the face
            opencv_core.CvRect r = new opencv_core.CvRect(cvGetSeqElem(faces, 0));

            // Find the dimensions of the face,and scale it if necessary
            cvSetImageROI(img, new opencv_core.CvRect(r.x(), r.y(), r.width(), r.height()));

            return img;
        }

    }

    public double[] getFeatureValues(double normalizeX, double normalizeY, String imgFile, boolean draw) {

        double len[] = {1};
        FSDK.HImage imageHandle = new FSDK.HImage();
        if (FSDK.LoadImageFromFileW(imageHandle, imgFile) == FSDK.FSDKE_OK) {
            // if (FSDK.LoadImageFromAWTImage(imageHandle, imgs, FSDK.FSDK_IMAGEMODE.FSDK_IMAGE_COLOR_24BIT) == FSDK.FSDKE_OK) {
            // resize image to fit the window width/height

            int imageWidthByReference[] = new int[1];
            int imageHeightByReference[] = new int[1];
            FSDK.GetImageWidth(imageHandle, imageWidthByReference);
            FSDK.GetImageHeight(imageHandle, imageHeightByReference);
            int imageWidth = imageWidthByReference[0];
            int imageHeight = imageHeightByReference[0];
            double ratio = java.lang.Math.min((width + 0.4) / imageWidth, (height + 0.4) / imageHeight);
            
            FSDK.HImage image2Handle = new FSDK.HImage();
            FSDK.CreateEmptyImage(image2Handle);
            FSDK.ResizeImage(imageHandle, ratio, image2Handle);
            FSDK.CopyImage(image2Handle, imageHandle);
            FSDK.FreeImage(image2Handle);

            // save image into awt.Image
            Image awtImage[] = new Image[1];
            if (FSDK.SaveImageToAWTImage(imageHandle, awtImage, FSDK.FSDK_IMAGEMODE.FSDK_IMAGE_COLOR_24BIT) != FSDK.FSDKE_OK) {
                JOptionPane.showMessageDialog(null, "Error displaying picture");
            } else {
                Image img = awtImage[0];
                BufferedImage bimg = null;

                FSDK.TFacePosition.ByReference facePosition = new FSDK.TFacePosition.ByReference();
                if (FSDK.DetectFace(imageHandle, facePosition) != FSDK.FSDKE_OK) {
                    JOptionPane.showMessageDialog(null, "No faces found");
                } else {
                    bimg = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_ARGB);
                    Graphics gr = bimg.getGraphics();
                    gr.drawImage(img, 0, 0, null);
                    gr.setColor(Color.green);

                    FSDK.FSDK_Features.ByReference facialFeatures = new FSDK.FSDK_Features.ByReference();
                    FSDK.DetectFacialFeaturesInRegion(imageHandle, (FSDK.TFacePosition) facePosition, facialFeatures);
                    len = new double[line.length];

                    if (draw) {
                        for (int i = 0; i < myfeature.length; ++i) {

                            gr.setColor(Color.GREEN);
                            gr.drawOval(facialFeatures.features[myfeature[i]].x, facialFeatures.features[myfeature[i]].y, 3, 3);
                        }
                    }
                    normalizeX = Math.abs(facialFeatures.features[25].x - facialFeatures.features[24].x);
                    normalizeY = Math.abs(facialFeatures.features[22].y - facialFeatures.features[49].y);
                    for (int i = 0; i < line.length; ++i) {

                        if (draw) {
                            gr.setColor(Color.BLUE);
                            gr.drawLine(facialFeatures.features[line[i][0]].x, facialFeatures.features[line[i][0]].y, facialFeatures.features[line[i][1]].x, facialFeatures.features[line[i][1]].y);
                        }
                        double valx = (Math.abs(facialFeatures.features[line[i][0]].x - facialFeatures.features[line[i][1]].x) * 1.0) / normalizeX;
                        double valy = (Math.abs(facialFeatures.features[line[i][0]].y - facialFeatures.features[line[i][1]].y) * 1.0) / normalizeY;
                        len[i] = Math.sqrt((valx * valx) + (valy * valy));
                    }
                    gr.dispose();

                }

                // draw image on window
                if (draw) {
                    ImageIcon imgnew = new ImageIcon();
                    imgnew.setImage((bimg != null) ? bimg : img);
//                    IplImage image = IplImage.createFrom(bimg);
//                    cvSaveImage("tmp3.jpg", image);
                    withfeatures.setIcon(imgnew);
                }
            }

            FSDK.FreeImage(imageHandle);

        }
        return len;
    }

    /**
     * @param args the command line arguments     */
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
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel face;
    private javax.swing.JLabel imgtxt;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JLabel myimg;
    private javax.swing.JLabel original;
    private javax.swing.JLabel withfeatures;
    // End of variables declaration//GEN-END:variables
}
