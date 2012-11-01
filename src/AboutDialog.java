/*    */ import java.awt.AWTEvent;
/*    */ import java.awt.Component;
/*    */ import java.awt.Container;
/*    */ import java.awt.Dialog;
/*    */ import java.awt.Rectangle;
/*    */ import javax.swing.AbstractButton;
/*    */ import javax.swing.Box;
/*    */ import javax.swing.ImageIcon;
/*    */ import javax.swing.JButton;
/*    */ import javax.swing.JDialog;
/*    */ import javax.swing.JFrame;
/*    */ import javax.swing.JLabel;
/*    */ 
/*    */ public class AboutDialog extends JDialog
/*    */   implements Constants
/*    */ {
/*    */   public AboutDialog(JFrame paramJFrame)
/*    */   {
/* 27 */     super(paramJFrame, "About Virgo", true);
/* 28 */     JLabel localJLabel1 = new JLabel("Credits:", 2);
/* 29 */     JLabel localJLabel2 = new JLabel("Abdelhalim Abbas (designer and programmer)", 2);
/* 30 */     JLabel localJLabel3 = new JLabel("Peter Drake (designer of previous versions)", 2);
/* 31 */     JLabel localJLabel4 = new JLabel("Prof. T. Pearce (supervisor)", 2);
/*    */ 
/* 33 */     ImageIcon localImageIcon = new ImageIcon("logo.gif");
/* 34 */     JButton local1 = new JButton()
/*    */     {
/*    */       protected void processEvent(AWTEvent paramAnonymousAWTEvent)
/*    */       {
/*    */       }
/*    */     };
/* 36 */     local1.setIcon(localImageIcon);
/*    */ 
/* 38 */     Box localBox1 = Box.createHorizontalBox();
/* 39 */     localBox1.add(local1);
/* 40 */     Box localBox2 = Box.createHorizontalBox();
/* 41 */     localBox2.add(localJLabel1);
/* 42 */     Box localBox3 = Box.createHorizontalBox();
/* 43 */     localBox3.add(localJLabel2);
/* 44 */     Box localBox4 = Box.createHorizontalBox();
/* 45 */     localBox4.add(localJLabel4);
/* 46 */     Box localBox5 = Box.createHorizontalBox();
/* 47 */     localBox5.add(localJLabel3);
/* 48 */     Box localBox6 = Box.createVerticalBox();
/* 49 */     localBox6.add(localBox1);
/* 50 */     localBox6.add(localBox2);
/* 51 */     localBox6.add(localBox3);
/* 52 */     localBox6.add(localBox4);
/* 53 */     localBox6.add(localBox5);
/* 54 */     getContentPane().add(localBox6);
/* 55 */     setResizable(false);
/* 56 */     setBounds(new Rectangle(100, 100, 400, 220));
/*    */   }
/*    */ }

/* Location:           C:\Users\daishi\Downloads\virgo213\virgo213_2006\
 * Qualified Name:     AboutDialog
 * JD-Core Version:    0.6.2
 */