/*     */ import java.awt.BorderLayout;
/*     */ import java.awt.Color;
/*     */ import java.awt.Component;
/*     */ import java.awt.Container;
/*     */ import java.awt.Cursor;
/*     */ import java.awt.Dimension;
/*     */ import java.awt.Frame;
/*     */ import java.awt.GridLayout;
/*     */ import java.awt.Insets;
/*     */ import java.awt.Window;
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.awt.event.ActionListener;
/*     */ import java.awt.event.MouseAdapter;
/*     */ import java.awt.event.MouseEvent;
/*     */ import java.awt.event.WindowAdapter;
/*     */ import java.awt.event.WindowEvent;
/*     */ import java.util.EventObject;
/*     */ import javax.swing.AbstractButton;
/*     */ import javax.swing.Box;
/*     */ import javax.swing.JButton;
/*     */ import javax.swing.JCheckBox;
/*     */ import javax.swing.JComponent;
/*     */ import javax.swing.JFrame;
/*     */ import javax.swing.JLabel;
/*     */ import javax.swing.JOptionPane;
/*     */ import javax.swing.JPanel;
/*     */ import javax.swing.JScrollPane;
/*     */ import javax.swing.border.EtchedBorder;
/*     */ import javax.swing.border.TitledBorder;
/*     */ 
/*     */ public class RegisterPortWindow extends JFrame
/*     */   implements ActionListener, Constants
/*     */ {
/*  29 */   private static final Dimension buttonSize = new Dimension(40, 35);
/*  30 */   private static final Dimension portValueSize = new Dimension(35, 17);
/*     */   Virgo virgo;
/*     */   Container container;
/*     */   JLabel[] registerLabels;
/*     */   JButton[] registerValues;
/*     */   JLabel[] portLabels;
/*     */   JLabel[] portValues;
/*     */   JCheckBox OFbox;
/*     */   JCheckBox CFbox;
/*     */   JCheckBox ZFbox;
/*     */   JCheckBox SFbox;
/*     */   JPanel registersPanel;
/*     */   JPanel portsPanel;
/*     */   JPanel flagsPanel;
/*     */   JScrollPane scrollPane;
/*     */ 
/*     */   RegisterPortWindow(Virgo paramVirgo)
/*     */   {
/*  52 */     super("Registers & Ports");
/*     */ 
/*  54 */     this.virgo = paramVirgo;
/*  55 */     this.container = getContentPane();
/*     */ 
/*  57 */     this.registerLabels = new JLabel[10];
/*  58 */     this.registerValues = new JButton[10];
/*  59 */     for (int i = 0; i < 10; i++)
/*     */     {
/*  61 */       this.registerValues[i] = new JButton();
/*  62 */       this.registerValues[i].setEnabled(true);
/*  63 */       this.registerValues[i].setMargin(new Insets(0, 0, 0, 0));
/*  64 */       this.registerValues[i].setPreferredSize(buttonSize);
/*  65 */       this.registerValues[i].setToolTipText("Click to modify value");
/*  66 */       this.registerValues[i].setActionCommand(new Integer(i).toString());
/*  67 */       this.registerValues[i].addActionListener(this);
/*  68 */       this.registerLabels[i] = new JLabel(Constants.realRegisterStrings[i], 4);
/*     */     }
/*     */ 
/*  71 */     this.portLabels = new JLabel[7];
/*  72 */     this.portValues = new JLabel[7];
/*  73 */     for (int j = 0; j < 7; j++)
/*     */     {
/*  75 */       this.portValues[j] = new JLabel(" ", 0);
/*  76 */       this.portValues[j].setForeground(Color.black);
/*  77 */       this.portValues[j].setPreferredSize(portValueSize);
/*  78 */       this.portLabels[j] = new JLabel(Constants.portStrings[j], 4);
/*     */     }
/*     */ 
/*  81 */     this.registersPanel = new JPanel();
/*  82 */     JPanel localJPanel1 = new JPanel(new GridLayout(5, 1));
/*  83 */     JPanel localJPanel2 = new JPanel(new GridLayout(5, 1));
/*     */ 
/*  86 */     for (int k = 0; k < 5; k++)
/*     */     {
/*  88 */       Box localBox1 = Box.createHorizontalBox();
/*  89 */       JPanel localObject1 = new JPanel();
/*  90 */       ((Container)localObject1).setLayout(new BorderLayout());
/*  91 */       ((Container)localObject1).add(this.registerLabels[k], "West");
/*  92 */       ((Container)localObject1).add(this.registerValues[k], "East");
/*  93 */       localBox1.add((Component)localObject1);
/*  94 */       localJPanel1.add(localBox1);
/*     */     }
/*  96 */     for (int m = 5; m < 10; m++)
/*     */     {
/*  98 */       Box localObject1 = Box.createHorizontalBox();
/*  99 */       JPanel localObject2 = new JPanel();
/* 100 */       ((Container)localObject2).setLayout(new BorderLayout());
/* 101 */       ((Container)localObject2).add(this.registerLabels[m], "West");
/* 102 */       ((Container)localObject2).add(this.registerValues[m], "East");
/* 103 */       ((Container)localObject1).add((Component)localObject2);
/* 104 */       localJPanel2.add((Component)localObject1);
/*     */     }
/*     */ 
/* 107 */     Object localObject1 = Box.createVerticalBox();
/* 108 */     ((Container)localObject1).add(localJPanel1);
/* 109 */     Object localObject2 = Box.createVerticalBox();
/* 110 */     ((Container)localObject2).add(localJPanel2);
/*     */ 
/* 112 */     this.registersPanel.add((Component)localObject1);
/* 113 */     this.registersPanel.add((Component)localObject2);
/* 114 */     this.registersPanel.setBorder(new TitledBorder(new EtchedBorder(), "Registers"));
/*     */ 
/* 116 */     JPanel localJPanel3 = new JPanel(new GridLayout(7, 1));
/* 117 */     JPanel localJPanel4 = new JPanel(new GridLayout(7, 1));
/* 118 */     for (int n = 0; n < 7; n++)
/*     */     {
/* 120 */       localJPanel3.add(this.portLabels[n]);
/* 121 */       localJPanel4.add(this.portValues[n]);
/*     */     }
/*     */ 
/* 124 */     this.portsPanel = new JPanel();
/*     */ 
/* 126 */     this.portsPanel.add(localJPanel3, "West");
/* 127 */     this.portsPanel.add(localJPanel4, "East");
/* 128 */     this.portsPanel.setBorder(new TitledBorder(new EtchedBorder(), "Ports"));
/*     */ 
/* 130 */     this.OFbox = new JCheckBox("OF");
/* 131 */     this.OFbox.addActionListener(this);
/* 132 */     this.OFbox.setToolTipText("Overflow flag");
/* 133 */     this.CFbox = new JCheckBox("CF");
/* 134 */     this.CFbox.addActionListener(this);
/* 135 */     this.CFbox.setToolTipText("Carry flag");
/* 136 */     this.ZFbox = new JCheckBox("ZF");
/* 137 */     this.ZFbox.addActionListener(this);
/* 138 */     this.ZFbox.setToolTipText("Zero flag");
/* 139 */     this.SFbox = new JCheckBox("SF");
/* 140 */     this.SFbox.addActionListener(this);
/* 141 */     this.SFbox.setToolTipText("Sign flag");
/*     */ 
/* 143 */     this.flagsPanel = new JPanel(new GridLayout(1, 4));
/* 144 */     this.flagsPanel.add(this.OFbox);
/* 145 */     this.flagsPanel.add(this.ZFbox);
/* 146 */     this.flagsPanel.add(this.SFbox);
/* 147 */     this.flagsPanel.add(this.CFbox);
/* 148 */     this.flagsPanel.setBorder(new TitledBorder(new EtchedBorder(), "Flags"));
/*     */ 
/* 150 */     Box localBox2 = Box.createHorizontalBox();
/* 151 */     Box localBox3 = Box.createVerticalBox();
/* 152 */     Box localBox4 = Box.createVerticalBox();
/* 153 */     Box localBox5 = Box.createHorizontalBox();
/* 154 */     Box localBox6 = Box.createHorizontalBox();
/*     */ 
/* 156 */     localBox6.add(this.flagsPanel);
/* 157 */     localBox5.add(this.portsPanel);
/* 158 */     localBox4.add(localBox5);
/* 159 */     localBox4.add(localBox6);
/* 160 */     localBox3.add(this.registersPanel);
/* 161 */     localBox2.add(localBox3);
/* 162 */     localBox2.add(localBox4);
/*     */ 
/* 164 */     this.scrollPane = new JScrollPane(localBox2, 20, 30);
/* 165 */     this.container.add(this.scrollPane);
/*     */ 
/* 167 */     updateRegisters();
/* 168 */     updatePorts();
/*     */ 
/* 170 */     getGlassPane().setCursor(Cursor.getPredefinedCursor(3));
/* 171 */     getGlassPane().addMouseListener(new MouseAdapter()
/*     */     {
/*     */       public void mousePressed(MouseEvent paramAnonymousMouseEvent)
/*     */       {
/*     */       }
/*     */     });
/* 172 */     setBusy(false);
/*     */ 
/* 174 */     addWindowListener(new RegisterPortWindow.WindowEventHandler());
/* 175 */     setDefaultCloseOperation(2);
/* 176 */     setBounds(Constants.registerPortWindowBounds);
/* 177 */     setResizable(true);
/*     */   }
/*     */ 
/*     */   public void actionPerformed(ActionEvent paramActionEvent)
/*     */   {
/* 279 */     if ((paramActionEvent.getSource() instanceof JButton))
/*     */     {
/* 282 */       JButton localJButton = (JButton)paramActionEvent.getSource();
/*     */ 
/* 285 */       String str1 = JOptionPane.showInputDialog(this, "Enter new value (hexadecimal word):", "Modify a Register", 3);
/*     */ 
/* 287 */       if ((str1 == null) || (str1.length() == 0)) return;
/* 288 */       if (!Library.isValidWord(str1.trim()))
/*     */       {
/* 292 */         JOptionPane.showMessageDialog(this, str1 + " is not a hexadecimal word!", "Problem!", 0);
/* 293 */         return;
/*     */       }
/*     */ 
/* 297 */       int i = Library.StringWordToInt(str1.trim());
/*     */ 
/* 306 */       String str2 = ((JButton)paramActionEvent.getSource()).getActionCommand();
/* 307 */       int j = new Integer(str2).intValue();
/* 308 */       j = Constants.realRegisters[j];
/*     */ 
/* 310 */       if (j == 8)
/*     */       {
/* 313 */         if (!this.virgo.code.isValidStartAddress(i))
/*     */         {
/* 316 */           JOptionPane.showMessageDialog(this, "new IP does not point to the start of an instruction!", "Problem!", 0);
/* 317 */           return;
/*     */         }
/*     */ 
/*     */       }
/*     */ 
/* 322 */       localJButton.setText(Library.toStringWord(i));
/* 323 */       this.virgo.machine.setRegister(i, j);
/* 324 */       if (j == 13) updateFlags();
/* 325 */       if (j == 8)
/*     */       {
/* 327 */         this.virgo.codeWindow.setCurrentCodeLine(this.virgo.code.convertStartAddressToCodeLine(i));
/* 328 */         this.virgo.virgoState.endOfCodeReached = false;
/*     */       }
/*     */ 
/*     */     }
/* 334 */     else if (paramActionEvent.getSource() == this.OFbox)
/*     */     {
/* 336 */       if (this.OFbox.isSelected()) this.virgo.machine.setFlag(11); else
/* 337 */         this.virgo.machine.clearFlag(11);
/*     */     }
/* 339 */     else if (paramActionEvent.getSource() == this.CFbox)
/*     */     {
/* 341 */       if (this.CFbox.isSelected()) this.virgo.machine.setFlag(0); else
/* 342 */         this.virgo.machine.clearFlag(0);
/*     */     }
/* 344 */     else if (paramActionEvent.getSource() == this.ZFbox)
/*     */     {
/* 346 */       if (this.ZFbox.isSelected()) this.virgo.machine.setFlag(6); else
/* 347 */         this.virgo.machine.clearFlag(6);
/*     */     }
/* 349 */     else if (paramActionEvent.getSource() == this.SFbox)
/*     */     {
/* 351 */       if (this.SFbox.isSelected()) this.virgo.machine.setFlag(7); else {
/* 352 */         this.virgo.machine.clearFlag(7);
/*     */       }
/*     */     }
/* 355 */     this.registerValues[9].setText(Library.toStringWord(this.virgo.machine.getRegister(13)));
/*     */   }
/*     */ 
/*     */   public void setBusy(boolean paramBoolean)
/*     */   {
/* 184 */     getGlassPane().setVisible(paramBoolean);
/*     */   }
/*     */ 
/*     */   public void update()
/*     */   {
/* 271 */     updateRegisters();
/* 272 */     updateFlags();
/* 273 */     updatePorts();
/*     */   }
/*     */ 
/*     */   public void updateFlags()
/*     */   {
/* 251 */     this.OFbox.setSelected(this.virgo.machine.getFlag(11));
/* 252 */     this.ZFbox.setSelected(this.virgo.machine.getFlag(6));
/* 253 */     this.CFbox.setSelected(this.virgo.machine.getFlag(0));
/* 254 */     this.SFbox.setSelected(this.virgo.machine.getFlag(7));
/*     */   }
/*     */ 
/*     */   public void updatePorts()
/*     */   {
/* 260 */     this.portValues[0].setText(Library.toStringByte(this.virgo.machine.getPortByte(1258)));
/* 261 */     this.portValues[1].setText(Library.toStringByte(this.virgo.machine.getPortByte(1259)));
/* 262 */     this.portValues[2].setText(Library.toStringByte(this.virgo.machine.getPortByte(1)));
/* 263 */     this.portValues[3].setText(Library.toStringByte(this.virgo.machine.getPortByte(2)));
/* 264 */     this.portValues[4].setText(Library.toStringByte(this.virgo.machine.getPortByte(17)));
/* 265 */     this.portValues[5].setText(Library.toStringWord(this.virgo.machine.getPortWord(18)));
/* 266 */     this.portValues[6].setText(Library.toStringWord(this.virgo.machine.getPortWord(20)));
/*     */   }
/*     */ 
/*     */   public void updateRegister(int paramInt1, int paramInt2)
/*     */   {
/* 190 */     switch (paramInt2)
/*     */     {
/*     */     case 0:
/*     */     case 20:
/*     */     case 30:
/* 195 */       this.registerValues[0].setText(Library.toStringWord(paramInt1));
/* 196 */       break;
/*     */     case 1:
/*     */     case 21:
/*     */     case 31:
/* 200 */       this.registerValues[1].setText(Library.toStringWord(paramInt1));
/* 201 */       break;
/*     */     case 2:
/*     */     case 22:
/*     */     case 32:
/* 205 */       this.registerValues[2].setText(Library.toStringWord(paramInt1));
/* 206 */       break;
/*     */     case 3:
/*     */     case 23:
/*     */     case 33:
/* 210 */       this.registerValues[3].setText(Library.toStringWord(paramInt1));
/* 211 */       break;
/*     */     case 11:
/* 213 */       this.registerValues[4].setText(Library.toStringWord(paramInt1));
/* 214 */       break;
/*     */     case 12:
/* 216 */       this.registerValues[5].setText(Library.toStringWord(paramInt1));
/* 217 */       break;
/*     */     case 9:
/* 219 */       this.registerValues[6].setText(Library.toStringWord(paramInt1));
/* 220 */       break;
/*     */     case 10:
/* 222 */       this.registerValues[7].setText(Library.toStringWord(paramInt1));
/* 223 */       break;
/*     */     case 8:
/* 225 */       this.registerValues[8].setText(Library.toStringWord(paramInt1));
/* 226 */       break;
/*     */     case 13:
/* 230 */       this.registerValues[9].setText(Library.toStringWord(paramInt1));
/* 231 */       updateFlags();
/* 232 */       break;
/*     */     case 4:
/*     */     case 5:
/*     */     case 6:
/*     */     case 7:
/*     */     case 14:
/*     */     case 15:
/*     */     case 16:
/*     */     case 17:
/*     */     case 18:
/*     */     case 19:
/*     */     case 24:
/*     */     case 25:
/*     */     case 26:
/*     */     case 27:
/*     */     case 28:
/*     */     case 29: }  } 
/* 240 */   public void updateRegisters() { for (int i = 0; i < this.registerValues.length; i++)
/*     */     {
/* 242 */       this.registerValues[i].setText(Library.toStringWord(this.virgo.machine.getRegister(Constants.realRegisters[i])));
/*     */     }
/*     */ 
/* 245 */     updateFlags();
/*     */   }
/*     */ 
/*     */   class WindowEventHandler extends WindowAdapter
/*     */   {
/*     */     WindowEventHandler()
/*     */     {
/*     */     }
/*     */ 
/*     */     public void windowClosing(WindowEvent paramWindowEvent)
/*     */     {
/* 364 */       RegisterPortWindow.this.virgo.setRegisterPortWindowVisible(false);
/*     */     }
/*     */   }
/*     */ }

/* Location:           C:\Users\daishi\Downloads\virgo213\virgo213_2006\
 * Qualified Name:     RegisterPortWindow
 * JD-Core Version:    0.6.2
 */