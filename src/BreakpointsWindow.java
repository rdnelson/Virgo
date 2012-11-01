/*     */ import java.awt.Color;
/*     */ import java.awt.Component;
/*     */ import java.awt.Container;
/*     */ import java.awt.Cursor;
/*     */ import java.awt.Frame;
/*     */ import java.awt.GridLayout;
/*     */ import java.awt.Window;
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.awt.event.ActionListener;
/*     */ import java.awt.event.ItemEvent;
/*     */ import java.awt.event.ItemListener;
/*     */ import java.awt.event.MouseAdapter;
/*     */ import java.awt.event.MouseEvent;
/*     */ import java.awt.event.WindowAdapter;
/*     */ import java.awt.event.WindowEvent;
/*     */ import java.util.EventObject;
/*     */ import java.util.Vector;
/*     */ import javax.swing.AbstractButton;
/*     */ import javax.swing.JButton;
/*     */ import javax.swing.JCheckBox;
/*     */ import javax.swing.JComboBox;
/*     */ import javax.swing.JComponent;
/*     */ import javax.swing.JFrame;
/*     */ import javax.swing.JLabel;
/*     */ import javax.swing.JList;
/*     */ import javax.swing.JOptionPane;
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
/*     */ public class BreakpointsWindow extends JFrame
/*     */   implements ListSelectionListener, CaretListener, ItemListener, ActionListener, Constants
/*     */ {
/*     */   Virgo virgo;
/*     */   Container container;
/*     */   JList list;
/*     */   JButton addCodeBreakpoint;
/*     */   JButton addRegisterBreakpoint;
/*     */   JButton addMemoryPortBreakpoint;
/*     */   JButton removeBreakpoint;
/*     */   JLabel break1;
/*     */   JLabel break2;
/*     */   JLabel break3;
/*     */   JLabel isReached;
/*     */   JLabel is;
/*     */   JLabel is2;
/*     */   JLabel at;
/*     */   JLabel address;
/*     */   JPanel panel;
/*     */   JPanel panel1;
/*     */   JPanel panel2;
/*     */   JPanel panel3;
/*     */   JPanel panel4;
/*     */   JScrollPane scrollPane;
/*     */   JComboBox combo1;
/*     */   JComboBox combo2;
/*     */   JComboBox combo3;
/*     */   JComboBox combo4;
/*     */   JComboBox combo5;
/*     */   JTextField field1;
/*     */   JTextField field2;
/*     */   JTextField field3;
/*     */   JTextField field4;
/*     */   JTabbedPane pane;
/*     */   JCheckBox checkBox;
/*     */   boolean breakpointsEnabled;
/*  40 */   String[] combo1Items = Constants.realRegisterStrings;
/*  41 */   String[] combo2Items = Constants.conditionStrings;
/*  42 */   String[] combo3Items = { "byte", "word" };
/*  43 */   String[] combo4Items = { "memory", "port" };
/*  44 */   String[] combo5Items = Constants.conditionStrings;
/*     */ 
/*     */   public BreakpointsWindow(Virgo paramVirgo)
/*     */   {
/*  49 */     super("Break points");
/*  50 */     this.virgo = paramVirgo;
/*  51 */     this.container = getContentPane();
/*  52 */     this.breakpointsEnabled = paramVirgo.virgoState.breakpointsEnabled;
/*     */ 
/*  56 */     this.break1 = new JLabel(" Break when instruction starting at address", 0);
/*  57 */     this.break1.setForeground(Color.black);
/*  58 */     this.break2 = new JLabel(" Break when register", 0);
/*  59 */     this.break2.setForeground(Color.black);
/*  60 */     this.break3 = new JLabel(" Break when", 0);
/*  61 */     this.break3.setForeground(Color.black);
/*  62 */     this.isReached = new JLabel("is reached", 0);
/*  63 */     this.isReached.setForeground(Color.black);
/*  64 */     this.is = new JLabel("is", 0);
/*  65 */     this.is.setForeground(Color.black);
/*  66 */     this.is2 = new JLabel("is", 0);
/*  67 */     this.is2.setForeground(Color.black);
/*  68 */     this.at = new JLabel("at", 0);
/*  69 */     this.at.setForeground(Color.black);
/*  70 */     this.address = new JLabel("address", 0);
/*  71 */     this.address.setForeground(Color.black);
/*     */ 
/*  74 */     this.addCodeBreakpoint = new JButton("Add");
/*  75 */     this.addCodeBreakpoint.setEnabled(false);
/*  76 */     this.addCodeBreakpoint.addActionListener(this);
/*     */ 
/*  78 */     this.addRegisterBreakpoint = new JButton("Add");
/*  79 */     this.addRegisterBreakpoint.setEnabled(true);
/*  80 */     this.addRegisterBreakpoint.addActionListener(this);
/*     */ 
/*  82 */     this.addMemoryPortBreakpoint = new JButton("Add");
/*  83 */     this.addMemoryPortBreakpoint.setEnabled(false);
/*  84 */     this.addMemoryPortBreakpoint.addActionListener(this);
/*     */ 
/*  86 */     this.removeBreakpoint = new JButton("Remove");
/*  87 */     this.removeBreakpoint.setEnabled(false);
/*  88 */     this.removeBreakpoint.addActionListener(this);
/*     */ 
/*  90 */     this.combo1 = new JComboBox(this.combo1Items);
/*  91 */     this.combo2 = new JComboBox(this.combo2Items);
/*  92 */     this.combo2.addItemListener(this);
/*  93 */     this.combo3 = new JComboBox(this.combo3Items);
/*  94 */     this.combo4 = new JComboBox(this.combo4Items);
/*  95 */     this.combo5 = new JComboBox(this.combo5Items);
/*  96 */     this.combo5.addItemListener(this);
/*     */ 
/*  98 */     this.field1 = new JTextField(4);
/*  99 */     this.field1.addCaretListener(this);
/* 100 */     this.field1.setToolTipText("Enter hexadecimal word");
/* 101 */     this.field2 = new JTextField(6);
/* 102 */     this.field2.addCaretListener(this);
/* 103 */     this.field2.setToolTipText("Enter decimal value");
/* 104 */     this.field3 = new JTextField(4);
/* 105 */     this.field3.addCaretListener(this);
/* 106 */     this.field3.setToolTipText("Enter hexadecimal word");
/* 107 */     this.field4 = new JTextField(6);
/* 108 */     this.field4.addCaretListener(this);
/* 109 */     this.field4.setToolTipText("Enter decimal value");
/*     */ 
/* 111 */     this.checkBox = new JCheckBox("Break points are enabled", this.breakpointsEnabled);
/* 112 */     this.checkBox.addItemListener(this);
/*     */ 
/* 115 */     this.list = new JList(paramVirgo.breakpoints.getList());
/* 116 */     this.list.setSelectionMode(2);
/* 117 */     this.list.addListSelectionListener(this);
/* 118 */     this.list.setPrototypeCellValue("Break when word at memory address 0000 is greater than or equal to some value, and scrollbar");
/*     */ 
/* 121 */     this.panel1 = new JPanel();
/* 122 */     this.panel1.add(this.break1);
/* 123 */     this.panel1.add(this.field1);
/* 124 */     this.panel1.add(this.isReached);
/* 125 */     this.panel1.add(this.addCodeBreakpoint);
/* 126 */     this.panel1.add(this.removeBreakpoint);
/*     */ 
/* 128 */     this.panel2 = new JPanel();
/* 129 */     this.panel2.add(this.break2);
/* 130 */     this.panel2.add(this.combo1);
/* 131 */     this.panel2.add(this.is2);
/* 132 */     this.panel2.add(this.combo2);
/* 133 */     this.panel2.add(this.field2);
/* 134 */     this.panel2.add(this.addRegisterBreakpoint);
/*     */ 
/* 136 */     this.panel3 = new JPanel();
/* 137 */     this.panel3.add(this.break3);
/* 138 */     this.panel3.add(this.combo3);
/* 139 */     this.panel3.add(this.at);
/* 140 */     this.panel3.add(this.combo4);
/* 141 */     this.panel3.add(this.address);
/* 142 */     this.panel3.add(this.field3);
/* 143 */     this.panel3.add(this.is);
/* 144 */     this.panel3.add(this.combo5);
/* 145 */     this.panel3.add(this.field4);
/* 146 */     this.panel3.add(this.addMemoryPortBreakpoint);
/*     */ 
/* 149 */     this.panel = new JPanel();
/* 150 */     this.scrollPane = new JScrollPane(this.list);
/* 151 */     this.panel.add(this.scrollPane, "West");
/* 152 */     this.panel.add(this.removeBreakpoint, "East");
/* 153 */     this.panel.add(this.checkBox, "South");
/*     */ 
/* 155 */     this.panel4 = new JPanel();
/* 156 */     this.panel4.setLayout(new GridLayout(3, 1));
/* 157 */     this.panel4.add(this.panel1);
/* 158 */     this.panel4.add(this.panel2);
/* 159 */     this.panel4.add(this.panel3);
/*     */ 
/* 162 */     this.pane = new JTabbedPane();
/* 163 */     this.pane.addTab("Current break points", this.panel);
/* 164 */     this.pane.addTab("Add", this.panel4);
/*     */ 
/* 166 */     this.container.add(this.pane);
/*     */ 
/* 168 */     getGlassPane().setCursor(Cursor.getPredefinedCursor(3));
/* 169 */     getGlassPane().addMouseListener(new MouseAdapter()
/*     */     {
/*     */       public void mousePressed(MouseEvent paramAnonymousMouseEvent)
/*     */       {
/*     */       }
/*     */     });
/* 170 */     setBusy(false);
/*     */ 
/* 172 */     addWindowListener(new BreakpointsWindow.WindowEventHandler());
/* 173 */     setDefaultCloseOperation(2);
/* 174 */     setBackground(Color.white);
/* 175 */     setBounds(Constants.breakpointsWindowBounds);
/* 176 */     setResizable(true);
/*     */   }
/*     */ 
/*     */   public void actionPerformed(ActionEvent paramActionEvent)
/*     */   {
/* 280 */     if (paramActionEvent.getSource() == this.removeBreakpoint)
/*     */     {
/* 282 */       this.virgo.breakpoints.removeBreakpoints(this.list.getSelectedIndices());
/*     */ 
/* 284 */       this.virgo.codeWindow.updateBreakpoints();
/*     */     }
/*     */     else
/*     */     {
/*     */       int i;
/* 286 */       if (paramActionEvent.getSource() == this.addCodeBreakpoint)
/*     */       {
/* 288 */         i = Library.StringAddressToInt(this.field1.getText());
/* 289 */         if (!this.virgo.code.isValidStartAddress(i))
/*     */         {
/* 292 */           JOptionPane.showMessageDialog(this, "No instruction starts at address " + this.field1.getText(), "Problem!", 0);
/* 293 */           return;
/*     */         }
/* 295 */         this.virgo.breakpoints.addBreakpoint(0, i);
/* 296 */         this.virgo.codeWindow.updateBreakpoints();
/*     */       }
/*     */       else
/*     */       {
/*     */         int j;
/* 298 */         if (paramActionEvent.getSource() == this.addRegisterBreakpoint)
/*     */         {
/* 300 */           i = this.combo2.getSelectedIndex() == 0 ? 0 : Integer.parseInt(this.field2.getText());
/* 301 */           j = Constants.realRegisters[this.combo1.getSelectedIndex()];
/* 302 */           this.virgo.breakpoints.addBreakpoint(3, j, this.combo2.getSelectedIndex(), i);
/*     */         }
/* 304 */         else if (paramActionEvent.getSource() == this.addMemoryPortBreakpoint)
/*     */         {
/* 306 */           i = 0;
/* 307 */           if (((String)this.combo3.getSelectedItem()).equals("byte")) i = 0;
/* 308 */           else if (((String)this.combo3.getSelectedItem()).equals("word")) i = 1;
/* 309 */           j = this.combo5.getSelectedIndex() == 0 ? 0 : Integer.parseInt(this.field4.getText());
/* 310 */           if (((String)this.combo4.getSelectedItem()).equals("memory"))
/*     */           {
/* 312 */             this.virgo.breakpoints.addBreakpoint(1, Integer.parseInt(this.field3.getText(), 16), i, this.combo5.getSelectedIndex(), j);
/*     */           }
/* 314 */           else if (((String)this.combo4.getSelectedItem()).equals("port"))
/*     */           {
/* 316 */             this.virgo.breakpoints.addBreakpoint(2, Integer.parseInt(this.field3.getText(), 16), i, this.combo5.getSelectedIndex(), j);
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/* 321 */     updateList();
/*     */   }
/*     */ 
/*     */   public void caretUpdate(CaretEvent paramCaretEvent)
/*     */   {
/* 217 */     if (Library.isValidAddress(this.field1.getText()))
/* 218 */       this.addCodeBreakpoint.setEnabled(true);
/* 219 */     else this.addCodeBreakpoint.setEnabled(false);
/*     */ 
/* 221 */     if ((Library.isValidDecimal(this.field2.getText())) || (this.combo2.getSelectedIndex() == 0))
/* 222 */       this.addRegisterBreakpoint.setEnabled(true);
/* 223 */     else this.addRegisterBreakpoint.setEnabled(false);
/*     */ 
/* 225 */     if ((Library.isValidAddress(this.field3.getText())) && ((Library.isValidDecimal(this.field4.getText())) || (this.combo5.getSelectedIndex() == 0)))
/* 226 */       this.addMemoryPortBreakpoint.setEnabled(true);
/* 227 */     else this.addMemoryPortBreakpoint.setEnabled(false);
/*     */   }
/*     */ 
/*     */   public void itemStateChanged(ItemEvent paramItemEvent)
/*     */   {
/* 234 */     if (paramItemEvent.getSource() == this.checkBox)
/*     */     {
/* 236 */       if (this.breakpointsEnabled)
/* 237 */         this.breakpointsEnabled = false;
/*     */       else
/* 239 */         this.breakpointsEnabled = true;
/* 240 */       this.virgo.setBreakpointsEnabled(this.breakpointsEnabled);
/*     */     }
/* 244 */     else if (paramItemEvent.getSource() == this.combo2)
/*     */     {
/* 246 */       if (this.combo2.getSelectedIndex() == 0)
/*     */       {
/* 248 */         this.addRegisterBreakpoint.setEnabled(true);
/* 249 */         this.field2.setText("");
/*     */       }
/* 251 */       else if (Library.isValidDecimal(this.field2.getText())) {
/* 252 */         this.addRegisterBreakpoint.setEnabled(true); } else {
/* 253 */         this.addRegisterBreakpoint.setEnabled(false);
/*     */       }
/*     */     }
/* 256 */     else if (paramItemEvent.getSource() == this.combo5)
/*     */     {
/* 258 */       if (Library.isValidAddress(this.field3.getText()))
/*     */       {
/* 260 */         if (this.combo5.getSelectedIndex() == 0)
/*     */         {
/* 262 */           this.addMemoryPortBreakpoint.setEnabled(true);
/* 263 */           this.field4.setText("");
/*     */         }
/* 265 */         else if (Library.isValidDecimal(this.field4.getText())) {
/* 266 */           this.addMemoryPortBreakpoint.setEnabled(true); } else {
/* 267 */           this.addMemoryPortBreakpoint.setEnabled(false);
/*     */         }
/*     */       } else this.addMemoryPortBreakpoint.setEnabled(false);
/*     */     }
/*     */   }
/*     */ 
/*     */   public void setBusy(boolean paramBoolean)
/*     */   {
/* 183 */     getGlassPane().setVisible(paramBoolean);
/*     */   }
/*     */ 
/*     */   public void updateList()
/*     */   {
/* 189 */     this.list.setListData(this.virgo.breakpoints.getList());
/* 190 */     this.list.setSelectedIndex(this.virgo.breakpoints.size() - 1);
/* 191 */     this.pane.setSelectedIndex(0);
/* 192 */     this.list.ensureIndexIsVisible(this.virgo.breakpoints.getList().size() - 1);
/* 193 */     this.list.repaint();
/*     */   }
/*     */ 
/*     */   public void valueChanged(ListSelectionEvent paramListSelectionEvent)
/*     */   {
/* 198 */     if (this.list.isSelectionEmpty()) this.removeBreakpoint.setEnabled(false); else
/* 199 */       this.removeBreakpoint.setEnabled(true); 
/*     */   }
/*     */ 
/*     */   class WindowEventHandler extends WindowAdapter {
/*     */     WindowEventHandler() {
/*     */     }
/*     */ 
/* 206 */     public void windowClosing(WindowEvent paramWindowEvent) { BreakpointsWindow.this.virgo.setBreakpointsWindowVisible(false); }
/*     */ 
/*     */   }
/*     */ }

/* Location:           C:\Users\daishi\Downloads\virgo213\virgo213_2006\
 * Qualified Name:     BreakpointsWindow
 * JD-Core Version:    0.6.2
 */