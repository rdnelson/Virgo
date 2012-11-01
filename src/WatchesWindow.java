/*     */ import java.awt.Color;
/*     */ import java.awt.Component;
/*     */ import java.awt.Container;
/*     */ import java.awt.Cursor;
/*     */ import java.awt.Frame;
/*     */ import java.awt.GridLayout;
/*     */ import java.awt.Window;
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.awt.event.ActionListener;
/*     */ import java.awt.event.MouseAdapter;
/*     */ import java.awt.event.MouseEvent;
/*     */ import java.awt.event.WindowAdapter;
/*     */ import java.awt.event.WindowEvent;
/*     */ import java.util.EventObject;
/*     */ import java.util.Vector;
/*     */ import javax.swing.AbstractButton;
/*     */ import javax.swing.JButton;
/*     */ import javax.swing.JComboBox;
/*     */ import javax.swing.JComponent;
/*     */ import javax.swing.JFrame;
/*     */ import javax.swing.JLabel;
/*     */ import javax.swing.JList;
/*     */ import javax.swing.JPanel;
/*     */ import javax.swing.JScrollPane;
/*     */ import javax.swing.JTabbedPane;
/*     */ import javax.swing.JTextField;
/*     */ import javax.swing.event.CaretEvent;
/*     */ import javax.swing.event.CaretListener;
/*     */ import javax.swing.event.ListSelectionEvent;
/*     */ import javax.swing.event.ListSelectionListener;
/*     */ import javax.swing.text.JTextComponent;
/*     */ 
/*     */ public class WatchesWindow extends JFrame
/*     */   implements ListSelectionListener, CaretListener, ActionListener, Constants
/*     */ {
/*     */   Virgo virgo;
/*     */   Container container;
/*     */   JList list;
/*     */   JButton addAddressWatch;
/*     */   JButton addLabelWatch;
/*     */   JButton removeWatches;
/*     */   JLabel label1;
/*     */   JLabel label2;
/*     */   JLabel label3;
/*     */   JLabel label4;
/*     */   JPanel panel1;
/*     */   JPanel panel2;
/*     */   JPanel panel3;
/*     */   JPanel panel4;
/*     */   JComboBox combo1;
/*     */   JComboBox combo2;
/*     */   JTextField field;
/*     */   JTabbedPane pane;
/*     */ 
/*     */   public WatchesWindow(Virgo paramVirgo)
/*     */   {
/*  42 */     super("Watches");
/*  43 */     this.virgo = paramVirgo;
/*  44 */     this.container = getContentPane();
/*     */ 
/*  47 */     String[] arrayOfString = { "byte", "word" };
/*  48 */     Vector localVector = paramVirgo.watches.getList();
/*     */ 
/*  50 */     this.label1 = new JLabel(" Watch", 0);
/*  51 */     this.label1.setForeground(Color.black);
/*  52 */     this.label2 = new JLabel("starting at address", 0);
/*  53 */     this.label2.setForeground(Color.black);
/*  54 */     this.label3 = new JLabel(" Watch variable", 0);
/*  55 */     this.label3.setForeground(Color.black);
/*     */ 
/*  58 */     this.addAddressWatch = new JButton("Add");
/*  59 */     this.addAddressWatch.setEnabled(false);
/*  60 */     this.addAddressWatch.addActionListener(this);
/*  61 */     this.addLabelWatch = new JButton("Add");
/*  62 */     this.addLabelWatch.setEnabled(true);
/*  63 */     this.addLabelWatch.addActionListener(this);
/*  64 */     this.removeWatches = new JButton("Remove");
/*  65 */     this.removeWatches.setEnabled(false);
/*  66 */     this.removeWatches.addActionListener(this);
/*     */ 
/*  68 */     this.combo1 = new JComboBox(arrayOfString);
/*  69 */     this.combo2 = new JComboBox();
/*     */ 
/*  71 */     this.field = new JTextField(4);
/*  72 */     this.field.addCaretListener(this);
/*     */ 
/*  75 */     this.list = new JList(localVector);
/*  76 */     this.list.setSelectionMode(2);
/*  77 */     this.list.addListSelectionListener(this);
/*  78 */     this.list.setPrototypeCellValue("variable blablablab has value 798 scrollbar");
/*     */ 
/*  82 */     this.panel1 = new JPanel();
/*  83 */     this.panel1.add(
/*  84 */       new JScrollPane(this.list, 20, 
/*  85 */       30), "North");
/*  86 */     this.panel1.add(this.removeWatches, "South");
/*     */ 
/*  88 */     this.panel2 = new JPanel();
/*  89 */     this.panel2.add(this.label1);
/*  90 */     this.panel2.add(this.combo1);
/*  91 */     this.panel2.add(this.label2);
/*  92 */     this.panel2.add(this.field);
/*  93 */     this.panel2.add(this.addAddressWatch);
/*     */ 
/*  95 */     this.panel3 = new JPanel();
/*  96 */     this.panel3.add(this.label3);
/*  97 */     this.panel3.add(this.combo2);
/*  98 */     this.panel3.add(this.addLabelWatch);
/*     */ 
/* 100 */     this.panel4 = new JPanel(new GridLayout(2, 1));
/* 101 */     this.panel4.add(this.panel2);
/* 102 */     this.panel4.add(this.panel3);
/*     */ 
/* 105 */     this.pane = new JTabbedPane();
/* 106 */     this.pane.add("Current watches", this.panel1);
/* 107 */     this.pane.add("Add", this.panel4);
/*     */ 
/* 109 */     this.container.add(this.pane);
/*     */ 
/* 111 */     getGlassPane().setCursor(Cursor.getPredefinedCursor(3));
/* 112 */     getGlassPane().addMouseListener(new MouseAdapter()
/*     */     {
/*     */       public void mousePressed(MouseEvent paramAnonymousMouseEvent)
/*     */       {
/*     */       }
/*     */     });
/* 113 */     setBusy(false);
/*     */ 
/* 116 */     addWindowListener(new WatchesWindow.WindowEventHandler());
/* 117 */     setDefaultCloseOperation(2);
/* 118 */     setBounds(Constants.watchesWindowBounds);
/* 119 */     setResizable(true);
/*     */   }
/*     */ 
/*     */   public void actionPerformed(ActionEvent paramActionEvent)
/*     */   {
/* 193 */     if (paramActionEvent.getSource() == this.addAddressWatch)
/*     */     {
/* 195 */       this.virgo.watches.addAddressWatch(Library.StringAddressToInt(this.field.getText()), this.combo1.getSelectedIndex());
/*     */     }
/* 197 */     else if (paramActionEvent.getSource() == this.addLabelWatch)
/*     */     {
/* 199 */       int i = this.combo2.getSelectedIndex();
/* 200 */       this.virgo.watches.addLabelWatch(
/* 201 */         this.virgo.code.getDataLabels()[i], 
/* 202 */         this.virgo.code.getDataLabelAddresses()[i], 
/* 203 */         this.virgo.code.getDataLabelTypes()[i]);
/*     */     }
/* 205 */     else if (paramActionEvent.getSource() == this.removeWatches)
/*     */     {
/* 207 */       this.virgo.watches.removeWatches(this.list.getSelectedIndices());
/*     */     }
/* 209 */     this.list.setListData(this.virgo.watches.getList());
/* 210 */     this.list.setSelectedIndex(this.virgo.watches.size() - 1);
/* 211 */     this.pane.setSelectedIndex(0);
/* 212 */     this.list.ensureIndexIsVisible(this.virgo.watches.getList().size() - 1);
/* 213 */     this.list.repaint();
/*     */   }
/*     */ 
/*     */   public void caretUpdate(CaretEvent paramCaretEvent)
/*     */   {
/* 185 */     if (Library.isValidAddress(this.field.getText())) this.addAddressWatch.setEnabled(true); else
/* 186 */       this.addAddressWatch.setEnabled(false);
/*     */   }
/*     */ 
/*     */   public void setBusy(boolean paramBoolean)
/*     */   {
/* 126 */     getGlassPane().setVisible(paramBoolean);
/*     */   }
/*     */ 
/*     */   public void update()
/*     */   {
/* 144 */     updateList();
/*     */ 
/* 146 */     if (this.combo2.getItemCount() > 0) this.combo2.removeAllItems();
/*     */ 
/* 148 */     if (this.virgo.code.getDataLabels().length < 1)
/*     */     {
/* 150 */       this.combo2.addItem("no variables");
/* 151 */       this.combo2.setEnabled(false);
/* 152 */       this.addLabelWatch.setEnabled(false);
/* 153 */       return;
/*     */     }
/* 155 */     this.combo2.setEnabled(true);
/* 156 */     this.addLabelWatch.setEnabled(true);
/* 157 */     for (int i = 0; i < this.virgo.code.getDataLabels().length; i++)
/*     */     {
/* 159 */       this.combo2.addItem(this.virgo.code.getDataLabels()[i]);
/*     */     }
/*     */   }
/*     */ 
/*     */   public void updateList()
/*     */   {
/* 137 */     this.list.setListData(this.virgo.watches.getList());
/*     */   }
/*     */ 
/*     */   public void valueChanged(ListSelectionEvent paramListSelectionEvent)
/*     */   {
/* 166 */     if (this.list.isSelectionEmpty()) this.removeWatches.setEnabled(false); else
/* 167 */       this.removeWatches.setEnabled(true); 
/*     */   }
/*     */ 
/*     */   class WindowEventHandler extends WindowAdapter {
/*     */     WindowEventHandler() {
/*     */     }
/*     */ 
/* 174 */     public void windowClosing(WindowEvent paramWindowEvent) { WatchesWindow.this.virgo.setWatchesWindowVisible(false); }
/*     */ 
/*     */   }
/*     */ }

/* Location:           C:\Users\daishi\Downloads\virgo213\virgo213_2006\
 * Qualified Name:     WatchesWindow
 * JD-Core Version:    0.6.2
 */