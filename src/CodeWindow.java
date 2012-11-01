/*     */ import java.awt.Color;
/*     */ import java.awt.Component;
/*     */ import java.awt.Container;
/*     */ import java.awt.Cursor;
/*     */ import java.awt.Font;
/*     */ import java.awt.Frame;
/*     */ import java.awt.Window;
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.awt.event.ActionListener;
/*     */ import java.awt.event.MouseAdapter;
/*     */ import java.awt.event.MouseEvent;
/*     */ import java.awt.event.WindowAdapter;
/*     */ import java.awt.event.WindowEvent;
/*     */ import java.util.EventObject;
/*     */ import javax.swing.AbstractButton;
/*     */ import javax.swing.DefaultCellEditor;
/*     */ import javax.swing.JCheckBox;
/*     */ import javax.swing.JComponent;
/*     */ import javax.swing.JFrame;
/*     */ import javax.swing.JScrollPane;
/*     */ import javax.swing.JTable;
/*     */ import javax.swing.border.EmptyBorder;
/*     */ import javax.swing.border.LineBorder;
/*     */ import javax.swing.table.AbstractTableModel;
/*     */ import javax.swing.table.DefaultTableCellRenderer;
/*     */ import javax.swing.table.JTableHeader;
/*     */ import javax.swing.table.TableColumn;
/*     */ import javax.swing.table.TableColumnModel;
/*     */ 
/*     */ public class CodeWindow extends JFrame
/*     */   implements ActionListener, Constants
/*     */ {
/*     */   Virgo virgo;
/*     */   Code code;
/*     */   int currentCodeLine;
/*     */   Container container;
/*     */   JTable table;
/*     */   JScrollPane scrollPane;
/*  38 */   String[] columnTitles = { "", "At", "Label", "Source code" };
/*     */   Object[][] rowData;
/*     */ 
/*     */   public CodeWindow(Virgo paramVirgo)
/*     */   {
/*  43 */     super("Instructions");
/*  44 */     this.virgo = paramVirgo;
/*  45 */     this.code = paramVirgo.code;
/*  46 */     this.container = getContentPane();
/*     */ 
/*  48 */     getGlassPane().setCursor(Cursor.getPredefinedCursor(3));
/*  49 */     getGlassPane().addMouseListener(new MouseAdapter()
/*     */     {
/*     */       public void mousePressed(MouseEvent paramAnonymousMouseEvent)
/*     */       {
/*     */       }
/*     */     });
/*  50 */     setBusy(false);
/*     */ 
/*  52 */     addWindowListener(new CodeWindow.WindowEventHandler());
/*  53 */     setDefaultCloseOperation(2);
/*  54 */     setBounds(Constants.codeWindowBounds);
/*  55 */     setResizable(true);
/*     */   }
/*     */ 
/*     */   public void actionPerformed(ActionEvent paramActionEvent)
/*     */   {
/* 152 */     if (!(paramActionEvent.getSource() instanceof JCheckBox)) return;
/*     */ 
/* 154 */     Boolean localBoolean = (Boolean)this.table.getValueAt(this.table.getSelectedRow(), this.table.getSelectedColumn());
/* 155 */     if (localBoolean.booleanValue())
/*     */     {
/* 157 */       this.virgo.breakpoints.addBreakpoint(0, this.code.getStartAddress(this.table.getSelectedRow()));
/* 158 */       this.virgo.breakpointsWindow.updateList();
/*     */     }
/*     */     else
/*     */     {
/* 162 */       this.virgo.breakpoints.removeCodeBreakpoint(this.code.getStartAddress(this.table.getSelectedRow()));
/* 163 */       this.virgo.breakpointsWindow.updateList();
/*     */     }
/*     */   }
/*     */ 
/*     */   public int getCurrentCodeLine()
/*     */   {
/* 179 */     return this.currentCodeLine;
/*     */   }
/*     */ 
/*     */   public int getSelectedCodeLine()
/*     */   {
/* 192 */     return this.table.getSelectedRow();
/*     */   }
/*     */ 
/*     */   public void resetCurrentCodeLine()
/*     */   {
/* 186 */     setCurrentCodeLine(this.code.startCodeLine);
/*     */   }
/*     */ 
/*     */   public void setBusy(boolean paramBoolean)
/*     */   {
/*  62 */     getGlassPane().setVisible(paramBoolean);
/*     */   }
/*     */ 
/*     */   public void setCurrentCodeLine(int paramInt)
/*     */   {
/* 172 */     this.currentCodeLine = paramInt;
/* 173 */     this.table.scrollRectToVisible(this.table.getCellRect(this.currentCodeLine, 0, true));
/* 174 */     this.table.repaint();
/*     */   }
/*     */ 
/*     */   public void update()
/*     */   {
/*  72 */     this.container.removeAll();
/*     */ 
/*  74 */     this.rowData = new Object[this.code.numberOfLines()][4];
/*  75 */     for (int i = 0; i < this.code.numberOfLines(); i++)
/*     */     {
/*  77 */       this.rowData[i][0] = new Boolean(false);
/*  78 */       this.rowData[i][1] = Library.toStringAddress(this.code.getStartAddress(i));
/*  79 */       this.rowData[i][2] = this.code.getLabel(i);
/*  80 */       this.rowData[i][3] = this.code.getSource(i);
/*     */     }
/*     */ 
/*  83 */     CodeWindow.SpecialTableModel localSpecialTableModel = new CodeWindow.SpecialTableModel(this.rowData, this.columnTitles);
/*  84 */     this.table = new JTable(localSpecialTableModel);
/*     */ 
/*  86 */     CodeWindow.ColoredRenderer localColoredRenderer1 = new CodeWindow.ColoredRenderer();
/*  87 */     localColoredRenderer1.setToolTipText("Address of the first byte in the instruction");
/*  88 */     this.table.getColumnModel().getColumn(1).setCellRenderer(localColoredRenderer1);
/*     */ 
/*  90 */     CodeWindow.ColoredRenderer localColoredRenderer2 = new CodeWindow.ColoredRenderer();
/*  91 */     localColoredRenderer2.setToolTipText("Label given for that instruction");
/*  92 */     this.table.getColumnModel().getColumn(2).setCellRenderer(localColoredRenderer2);
/*     */ 
/*  94 */     CodeWindow.ColoredRenderer localColoredRenderer3 = new CodeWindow.ColoredRenderer();
/*  95 */     localColoredRenderer3.setToolTipText("Assembly code for the instruction");
/*  96 */     this.table.getColumnModel().getColumn(3).setCellRenderer(localColoredRenderer3);
/*     */ 
/*  98 */     this.table.setSelectionMode(0);
/*     */ 
/* 100 */     this.table.setRowSelectionAllowed(true);
/* 101 */     this.table.setColumnSelectionAllowed(false);
/* 102 */     this.table.setSelectionBackground(this.table.getBackground());
/* 103 */     this.table.setSelectionForeground(this.table.getForeground());
/*     */ 
/* 106 */     for (int j = 0; j < this.code.numberOfLines(); j++)
/*     */     {
/* 108 */       JCheckBox localJCheckBox = new JCheckBox("");
/* 109 */       localJCheckBox.setHorizontalAlignment(0);
/* 110 */       localJCheckBox.setBackground(this.table.getSelectionBackground());
/* 111 */       localJCheckBox.addActionListener(this);
/* 112 */       this.table.getColumnModel().getColumn(0).setCellEditor(new DefaultCellEditor(localJCheckBox));
/*     */     }
/*     */ 
/* 116 */     this.table.getTableHeader().getColumnModel().getColumn(0).setMaxWidth(15);
/* 117 */     this.table.getTableHeader().getColumnModel().getColumn(0).setPreferredWidth(15);
/* 118 */     this.table.getTableHeader().getColumnModel().getColumn(1).setMaxWidth(40);
/* 119 */     this.table.getTableHeader().getColumnModel().getColumn(1).setPreferredWidth(40);
/* 120 */     this.table.getTableHeader().getColumnModel().getColumn(2).setMaxWidth(200);
/* 121 */     this.table.getTableHeader().getColumnModel().getColumn(2).setPreferredWidth(70);
/*     */ 
/* 124 */     this.container.add(new JScrollPane(this.table, 20, 30));
/* 125 */     setCurrentCodeLine(this.code.startCodeLine);
/* 126 */     this.container.repaint();
/*     */   }
/*     */ 
/*     */   public void updateBreakpoints()
/*     */   {
/* 134 */     for (int i = 0; i < this.code.numberOfLines; i++)
/*     */     {
/* 136 */       this.table.setValueAt(new Boolean(this.virgo.breakpoints.isCodeBreakpoint(this.code.getStartAddress(i))), i, 0);
/*     */     }
/* 138 */     this.table.repaint();
/*     */   }
/*     */   class WindowEventHandler extends WindowAdapter {
/*     */     WindowEventHandler() {
/*     */     }
/*     */ 
/*     */     public void windowClosing(WindowEvent paramWindowEvent) {
/* 145 */       CodeWindow.this.virgo.setCodeWindowVisible(false);
/*     */     }
/*     */   }
/*     */ 
/*     */   class SpecialTableModel extends AbstractTableModel
/*     */   {
/*     */     String[] columnTitles;
/*     */     Object[][] dataEntries;
/*     */     int rowCount;
/*     */ 
/*     */     public SpecialTableModel(Object[][] paramArrayOfString, String[] arg3)
/*     */     {
/* 203 */       this.columnTitles = arg3;
/* 204 */       this.dataEntries = paramArrayOfString;
/*     */     }
/*     */ 
/*     */     public Class getColumnClass(int paramInt)
/*     */     {
/* 224 */       return getValueAt(0, paramInt).getClass();
/*     */     }
/*     */ 
/*     */     public int getColumnCount()
/*     */     {
/* 212 */       return this.columnTitles.length;
/*     */     }
/*     */ 
/*     */     public String getColumnName(int paramInt)
/*     */     {
/* 220 */       return this.columnTitles[paramInt];
/*     */     }
/*     */ 
/*     */     public int getRowCount()
/*     */     {
/* 208 */       return this.dataEntries.length;
/*     */     }
/*     */ 
/*     */     public Object getValueAt(int paramInt1, int paramInt2)
/*     */     {
/* 216 */       return this.dataEntries[paramInt1][paramInt2];
/*     */     }
/*     */ 
/*     */     public boolean isCellEditable(int paramInt1, int paramInt2)
/*     */     {
/* 232 */       if (paramInt2 == 0) return true;
/* 233 */       return false;
/*     */     }
/*     */ 
/*     */     public void setValueAt(Object paramObject, int paramInt1, int paramInt2)
/*     */     {
/* 228 */       this.dataEntries[paramInt1][paramInt2] = paramObject;
/*     */     }
/*     */   }
/*     */ 
/*     */   class ColoredRenderer extends DefaultTableCellRenderer
/*     */   {
/*     */     ColoredRenderer()
/*     */     {
/*     */     }
/*     */ 
/*     */     public Component getTableCellRendererComponent(JTable paramJTable, Object paramObject, boolean paramBoolean1, boolean paramBoolean2, int paramInt1, int paramInt2)
/*     */     {
/* 245 */       Component localComponent = super.getTableCellRendererComponent(paramJTable, paramObject, paramBoolean1, paramBoolean2, paramInt1, paramInt2);
/* 246 */       localComponent.setFont(new Font("Courier New", 0, 12));
/*     */ 
/* 248 */       if (paramInt1 == CodeWindow.this.currentCodeLine) localComponent.setBackground(Color.red); else {
/* 249 */         localComponent.setBackground(paramJTable.getBackground());
/*     */       }
/* 251 */       if (paramBoolean1)
/*     */       {
/* 253 */         localComponent.setForeground(Color.blue);
/* 254 */         ((JComponent)localComponent).setBorder(new LineBorder(Color.blue, 1));
/*     */       }
/*     */       else
/*     */       {
/* 258 */         localComponent.setForeground(Color.black);
/* 259 */         ((JComponent)localComponent).setBorder(new EmptyBorder(0, 0, 0, 0));
/*     */       }
/*     */ 
/* 265 */       return localComponent;
/*     */     }
/*     */   }
/*     */ }

/* Location:           C:\Users\daishi\Downloads\virgo213\virgo213_2006\
 * Qualified Name:     CodeWindow
 * JD-Core Version:    0.6.2
 */