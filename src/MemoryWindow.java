/*     */ import java.awt.Color;
/*     */ import java.awt.Component;
/*     */ import java.awt.Container;
/*     */ import java.awt.Cursor;
/*     */ import java.awt.Window;
/*     */ import java.awt.event.MouseAdapter;
/*     */ import java.awt.event.MouseEvent;
/*     */ import java.awt.event.WindowAdapter;
/*     */ import java.awt.event.WindowEvent;
/*     */ import javax.swing.JComponent;
/*     */ import javax.swing.JFrame;
/*     */ import javax.swing.JLabel;
/*     */ import javax.swing.JOptionPane;
/*     */ import javax.swing.JScrollPane;
/*     */ import javax.swing.JTable;
/*     */ import javax.swing.table.AbstractTableModel;
/*     */ import javax.swing.table.DefaultTableCellRenderer;
/*     */ import javax.swing.table.JTableHeader;
/*     */ import javax.swing.table.TableColumn;
/*     */ import javax.swing.table.TableColumnModel;
/*     */ 
/*     */ public class MemoryWindow extends JFrame
/*     */   implements Constants
/*     */ {
/*     */   Virgo virgo;
/*     */   Container container;
/*     */   JTable table;
/*     */   JScrollPane scrollPane;
/*  31 */   String[] columnTitles = { "Address", "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F" };
/*  32 */   String[][] rowData = new String[4096][17];
/*     */   MemoryWindow.WindowEventHandler windowListener;
/*     */   MouseAdapter glassPaneMouseListener;
/*     */   MemoryWindow.MouseEventHandler tableMouseListener;
/*     */ 
/*     */   public MemoryWindow(Virgo paramVirgo)
/*     */   {
/*  39 */     super("Memory Contents");
/*  40 */     this.virgo = paramVirgo;
/*  41 */     this.container = getContentPane();
/*     */ 
/*  43 */     for (int i = 0; i < 4096; i++)
/*     */     {
/*  45 */       this.rowData[i][0] = Integer.toHexString(i).toUpperCase();
/*  46 */       while (this.rowData[i][0].length() < 3) this.rowData[i][0] = ("0" + this.rowData[i][0]);
/*     */       int tmp217_216 = 0;
/*     */       String[] tmp217_215 = this.rowData[i]; tmp217_215[tmp217_216] = (tmp217_215[tmp217_216] + "x");
/*  48 */       for (int j = 1; j < 17; j++)
/*     */       {
/*  50 */         this.rowData[i][j] = "";
/*     */       }
/*     */     }
/*     */ 
/*  54 */     MemoryWindow.SpecialTableModel localSpecialTableModel = new MemoryWindow.SpecialTableModel(this.rowData, this.columnTitles);
/*  55 */     this.table = new JTable(localSpecialTableModel);
/*     */ 
/*  58 */     this.table.setSelectionMode(0);
/*  59 */     this.table.setRowSelectionAllowed(true);
/*  60 */     this.table.setColumnSelectionAllowed(true);
/*  61 */     this.table.getTableHeader().setResizingAllowed(true);
/*     */ 
/*  63 */     this.tableMouseListener = new MemoryWindow.MouseEventHandler(this);
/*  64 */     this.table.addMouseListener(this.tableMouseListener);
/*     */ 
/*  67 */     this.table.getColumnModel().getColumn(0).setMinWidth(40);
/*  68 */     this.table.getColumnModel().getColumn(0).setWidth(40);
/*     */ 
/*  71 */     for (int k = 1; k < 17; k++)
/*     */     {
/*  73 */       this.table.getColumnModel().getColumn(k).setMinWidth(25);
/*  74 */       this.table.getColumnModel().getColumn(k).setWidth(25);
/*  75 */       MemoryWindow.MyCellRenderer localMyCellRenderer = new MemoryWindow.MyCellRenderer();
/*  76 */       localMyCellRenderer.setToolTipText("Double click to modify memory cell");
/*  77 */       this.table.getColumnModel().getColumn(k).setCellRenderer(localMyCellRenderer);
/*     */     }
/*     */ 
/*  81 */     this.container.add(new JScrollPane(this.table, 20, 30));
/*     */ 
/*  83 */     getGlassPane().setCursor(Cursor.getPredefinedCursor(3));
/*     */ 
/*  85 */     this.glassPaneMouseListener = new MouseAdapter()
/*     */     {
/*     */       public void mousePressed(MouseEvent paramAnonymousMouseEvent)
/*     */       {
/*     */       }
/*     */     };
/*  86 */     getGlassPane().addMouseListener(this.glassPaneMouseListener);
/*  87 */     setBusy(false);
/*     */ 
/*  89 */     this.windowListener = new MemoryWindow.WindowEventHandler();
/*  90 */     addWindowListener(this.windowListener);
/*  91 */     setDefaultCloseOperation(2);
/*  92 */     setBackground(Color.white);
/*  93 */     setBounds(Constants.memoryWindowBounds);
/*     */   }
/*     */ 
/*     */   public void dispose()
/*     */   {
/* 109 */     getGlassPane().removeMouseListener(this.glassPaneMouseListener);
/* 110 */     this.table.removeMouseListener(this.tableMouseListener);
/* 111 */     removeWindowListener(this.windowListener);
/* 112 */     super.dispose();
/*     */   }
/*     */ 
/*     */   public void setBusy(boolean paramBoolean)
/*     */   {
/* 102 */     getGlassPane().setVisible(paramBoolean);
/*     */   }
/*     */ 
/*     */   public void setMemoryCell(int paramInt1, int paramInt2)
/*     */   {
/* 118 */     paramInt2 &= 65535;
/* 119 */     int i = paramInt2 / 16;
/* 120 */     int j = paramInt2 % 16 + 1;
/* 121 */     paramInt1 &= 255;
/* 122 */     String str = Library.toStringByte(paramInt1);
/* 123 */     this.table.setValueAt(str, i, j);
/* 124 */     this.table.repaint();
/*     */   }
/*     */ 
/*     */   public void update()
/*     */   {
/* 133 */     for (int j = 0; j < 4096; j++)
/*     */     {
/* 135 */       for (int k = 0; k < 16; k++)
/*     */       {
/* 137 */         int i = this.virgo.machine.getMemoryByte(j * 16 + k);
/* 138 */         i &= 255;
/* 139 */         String str = Library.toStringByte(i);
/* 140 */         this.table.setValueAt(str, j, k + 1);
/*     */       }
/*     */     }
/* 143 */     this.table.repaint();
/*     */   }
/*     */   class WindowEventHandler extends WindowAdapter {
/*     */     WindowEventHandler() {
/*     */     }
/*     */ 
/*     */     public void windowClosing(WindowEvent paramWindowEvent) {
/* 150 */       MemoryWindow.this.virgo.setMemoryWindowEnabled(false);
/*     */     }
/*     */   }
/*     */ 
/*     */   class SpecialTableModel extends AbstractTableModel
/*     */   {
/*     */     String[] columnTitles;
/*     */     public Object[][] dataEntries;
/*     */     int rowCount;
/*     */ 
/*     */     public SpecialTableModel(Object[][] paramArrayOfString, String[] arg3)
/*     */     {
/* 162 */       this.columnTitles = arg3;
/* 163 */       this.dataEntries = paramArrayOfString;
/*     */     }
/*     */ 
/*     */     public Class getColumnClass(int paramInt)
/*     */     {
/* 183 */       return getValueAt(0, paramInt).getClass();
/*     */     }
/*     */ 
/*     */     public int getColumnCount()
/*     */     {
/* 171 */       return this.columnTitles.length;
/*     */     }
/*     */ 
/*     */     public String getColumnName(int paramInt)
/*     */     {
/* 179 */       return this.columnTitles[paramInt];
/*     */     }
/*     */ 
/*     */     public int getRowCount()
/*     */     {
/* 167 */       return this.dataEntries.length;
/*     */     }
/*     */ 
/*     */     public Object getValueAt(int paramInt1, int paramInt2)
/*     */     {
/* 175 */       return this.dataEntries[paramInt1][paramInt2];
/*     */     }
/*     */ 
/*     */     public boolean isCellEditable(int paramInt1, int paramInt2)
/*     */     {
/* 192 */       return false;
/*     */     }
/*     */ 
/*     */     public void setValueAt(Object paramObject, int paramInt1, int paramInt2)
/*     */     {
/* 187 */       this.dataEntries[paramInt1][paramInt2] = Library.toStringByte(Library.StringByteToInt(((String)paramObject).trim()));
/*     */     }
/*     */   }
/*     */ 
/*     */   class MouseEventHandler extends MouseAdapter
/*     */   {
/*     */     MemoryWindow memoryWindow;
/*     */ 
/*     */     MouseEventHandler(MemoryWindow arg2)
/*     */     {
/* 206 */       this.memoryWindow = arg2;
/*     */     }
/*     */ 
/*     */     public void mouseClicked(MouseEvent paramMouseEvent)
/*     */     {
/* 211 */       if (paramMouseEvent.getClickCount() != 2) return;
/* 212 */       int i = this.memoryWindow.table.rowAtPoint(paramMouseEvent.getPoint());
/* 213 */       if (i < 0) return;
/* 214 */       int j = this.memoryWindow.table.columnAtPoint(paramMouseEvent.getPoint());
/* 215 */       if (j < 1) return;
/*     */ 
/* 219 */       String str = JOptionPane.showInputDialog(this.memoryWindow, "Enter new value (hexadecimal byte):", "Modify a Memory Cell", 3);
/*     */ 
/* 221 */       if ((str == null) || (str.length() == 0)) return;
/* 222 */       if (!Library.isValidByte(str.trim()))
/*     */       {
/* 226 */         JOptionPane.showMessageDialog(this.memoryWindow, str + " is not a hexadecimal byte!", "Problem!", 0);
/* 227 */         return;
/*     */       }
/*     */ 
/* 232 */       this.memoryWindow.table.setValueAt(Library.toStringByte(Library.StringByteToInt(str.trim())), i, j);
/* 233 */       this.memoryWindow.table.repaint();
/*     */ 
/* 236 */       this.memoryWindow.virgo.machine.setMemoryByte(Library.StringByteToInt(str.trim()), i * 16 + j - 1);
/*     */ 
/* 239 */       this.memoryWindow.virgo.watches.update();
/* 240 */       this.memoryWindow.virgo.watchesWindow.updateList();
/*     */     }
/*     */   }
/*     */ 
/*     */   class MyCellRenderer extends DefaultTableCellRenderer
/*     */   {
/*     */     MyCellRenderer()
/*     */     {
/*     */     }
/*     */ 
/*     */     public Component getTableCellRendererComponent(JTable paramJTable, Object paramObject, boolean paramBoolean1, boolean paramBoolean2, int paramInt1, int paramInt2)
/*     */     {
/* 253 */       Component localComponent = super.getTableCellRendererComponent(paramJTable, paramObject, paramBoolean1, paramBoolean2, paramInt1, paramInt2);
/* 254 */       ((JLabel)localComponent).setHorizontalAlignment(0);
/* 255 */       return localComponent;
/*     */     }
/*     */   }
/*     */ }

/* Location:           C:\Users\daishi\Downloads\virgo213\virgo213_2006\
 * Qualified Name:     MemoryWindow
 * JD-Core Version:    0.6.2
 */