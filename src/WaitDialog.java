/*    */ import java.awt.Color;
/*    */ import java.awt.Component;
/*    */ import java.awt.Container;
/*    */ import java.awt.Dialog;
/*    */ import java.awt.Font;
/*    */ import javax.swing.Box;
/*    */ import javax.swing.JComponent;
/*    */ import javax.swing.JDialog;
/*    */ import javax.swing.JFrame;
/*    */ import javax.swing.JLabel;
/*    */ import javax.swing.JProgressBar;
/*    */ 
/*    */ public class WaitDialog extends JDialog
/*    */   implements Constants
/*    */ {
/*    */   JProgressBar bar;
/*    */ 
/*    */   public WaitDialog(JFrame paramJFrame)
/*    */   {
/* 26 */     super(paramJFrame, "Loading", false);
/* 27 */     JLabel localJLabel = new JLabel("Loading file please wait...", 0);
/* 28 */     localJLabel.setFont(new Font("Times New Roman", 0, 22));
/* 29 */     localJLabel.setForeground(Color.black);
/* 30 */     this.bar = new JProgressBar();
/* 31 */     this.bar.setMaximum(100);
/* 32 */     this.bar.setMinimum(0);
/* 33 */     this.bar.setValue(0);
/* 34 */     this.bar.setOrientation(0);
/* 35 */     this.bar.setBorderPainted(true);
/* 36 */     this.bar.setSize(200, 60);
/*    */ 
/* 40 */     Box localBox1 = Box.createHorizontalBox();
/* 41 */     localBox1.add(localJLabel);
/* 42 */     Box localBox2 = Box.createHorizontalBox();
/* 43 */     localBox2.add(this.bar);
/* 44 */     Box localBox3 = Box.createVerticalBox();
/* 45 */     localBox3.add(localBox1);
/* 46 */     localBox3.add(localBox2);
/*    */ 
/* 48 */     getContentPane().add(localBox3);
/*    */ 
/* 50 */     setResizable(false);
/*    */   }
/*    */ 
/*    */   public void setValue(int paramInt)
/*    */   {
/* 55 */     this.bar.setValue(paramInt);
/*    */   }
/*    */ }

/* Location:           C:\Users\daishi\Downloads\virgo213\virgo213_2006\
 * Qualified Name:     WaitDialog
 * JD-Core Version:    0.6.2
 */