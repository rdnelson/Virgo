/*     */ import java.awt.AWTEvent;
/*     */ import java.awt.Color;
/*     */ import java.awt.Font;
/*     */ import java.io.PrintStream;
/*     */ import javax.swing.JComponent;
/*     */ import javax.swing.JTextArea;
/*     */ import javax.swing.text.JTextComponent;
/*     */ 
/*     */ class MainWindow$MyJTextArea extends JTextArea
/*     */ {
/*     */   private final MainWindow this$0;
/*     */ 
/*     */   MainWindow$MyJTextArea(MainWindow paramMainWindow, int paramInt1, int paramInt2)
/*     */   {
/* 546 */     super(paramInt1, paramInt2);
/*     */ 
/*  11 */     this.this$0 = 
/* 546 */       paramMainWindow;
/* 547 */     setDoubleBuffered(true);
/* 548 */     setEditable(false);
/* 549 */     setEnabled(true);
/* 550 */     setBackground(Color.black);
/* 551 */     setForeground(Color.white);
/* 552 */     setSelectionColor(Color.white);
/* 553 */     setLineWrap(true);
/* 554 */     setFont(new Font("Courier New", 0, 12));
/*     */   }
/* 556 */   public boolean isFocusTraversable() { return false; } 
/* 557 */   protected void processEvent(AWTEvent paramAWTEvent) { System.out.println("consumed an event"); }
/*     */ 
/*     */ }

/* Location:           C:\Users\daishi\Downloads\virgo213\virgo213_2006\
 * Qualified Name:     MainWindow.MyJTextArea
 * JD-Core Version:    0.6.2
 */