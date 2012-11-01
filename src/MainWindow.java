/*     */ import java.awt.AWTEvent;
/*     */ import java.awt.Color;
/*     */ import java.awt.Component;
/*     */ import java.awt.Container;
/*     */ import java.awt.Cursor;
/*     */ import java.awt.Dialog;
/*     */ import java.awt.Dimension;
/*     */ import java.awt.Font;
/*     */ import java.awt.Frame;
/*     */ import java.awt.GridLayout;
/*     */ import java.awt.Toolkit;
/*     */ import java.awt.Window;
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.awt.event.ActionListener;
/*     */ import java.awt.event.MouseAdapter;
/*     */ import java.awt.event.MouseEvent;
/*     */ import java.awt.event.WindowAdapter;
/*     */ import java.awt.event.WindowEvent;
/*     */ import java.io.File;
/*     */ import java.io.PrintStream;
/*     */ import java.net.URL;
/*     */ import javax.help.CSH.DisplayHelpFromSource;
/*     */ import javax.help.HelpBroker;
/*     */ import javax.help.HelpSet;
/*     */ import javax.swing.AbstractButton;
/*     */ import javax.swing.Icon;
/*     */ import javax.swing.ImageIcon;
/*     */ import javax.swing.JButton;
/*     */ import javax.swing.JCheckBoxMenuItem;
/*     */ import javax.swing.JComponent;
/*     */ import javax.swing.JFileChooser;
/*     */ import javax.swing.JFrame;
/*     */ import javax.swing.JMenu;
/*     */ import javax.swing.JMenuBar;
/*     */ import javax.swing.JMenuItem;
/*     */ import javax.swing.JOptionPane;
/*     */ import javax.swing.JPanel;
/*     */ import javax.swing.JScrollPane;
/*     */ import javax.swing.JTextArea;
/*     */ import javax.swing.JToolBar;
/*     */ import javax.swing.border.EtchedBorder;
/*     */ import javax.swing.border.TitledBorder;
/*     */ import javax.swing.text.JTextComponent;
/*     */ 
/*     */ class MainWindow extends JFrame
/*     */   implements ActionListener, Constants
/*     */ {
/*     */   Virgo virgo;
/*     */   Container container;
/*     */   MainWindow.SpecialJTextArea screen;
/*  36 */   static String OPEN = "a";
/*  37 */   static String EXIT = "b";
/*  38 */   static String SHOW_CODE_WINDOW = "c";
/*  39 */   static String TOGGLE_CODE_WINDOW = "d";
/*  40 */   static String SHOW_REGISTERPORT_WINDOW = "e";
/*  41 */   static String TOGGLE_REGISTERPORT_WINDOW = "f";
/*  42 */   static String SHOW_WATCHES_WINDOW = "i";
/*  43 */   static String TOGGLE_WATCHES_WINDOW = "j";
/*  44 */   static String SHOW_BREAKPOINTS_WINDOW = "k";
/*  45 */   static String TOGGLE_BREAKPOINTS_WINDOW = "l";
/*  46 */   static String RESET = "m";
/*  47 */   static String PLAY = "n";
/*  48 */   static String PAUSE = "o";
/*  49 */   static String SINGLE_STEP = "p";
/*  50 */   static String STEP_OVER = "q";
/*  51 */   static String UNTIL_CALL = "r";
/*  52 */   static String UNTIL_CURSOR = "s";
/*  53 */   static String RESET_VIEW = "t";
/*  54 */   static String CLOSE_ALL = "u";
/*  55 */   static String TOGGLE_MEMORY_WINDOW_ENABLED = "v";
/*  56 */   static String ABOUT = "w";
/*  57 */   static String TOGGLE_UPDATE_WINDOWS_WHILE_RUNNING = "x";
/*     */   JMenuBar menuBar;
/*     */   JMenu fileMenu;
/*     */   JMenuItem openItem;
/*     */   JMenuItem exitItem;
/*     */   JMenu windowsMenu;
/*     */   JCheckBoxMenuItem breakpointsItem;
/*     */   JCheckBoxMenuItem watchesItem;
/*     */   JCheckBoxMenuItem codeItem;
/*     */   JCheckBoxMenuItem registerPortItem;
/*     */   JMenuItem resetViewItem;
/*     */   JMenuItem closeAllItem;
/*     */   JCheckBoxMenuItem updateWindowsWhileRunningItem;
/*     */   JCheckBoxMenuItem includeMemoryWindowItem;
/*     */   JMenu runMenu;
/*     */   JMenuItem resetItem;
/*     */   JMenuItem runItem;
/*     */   JMenuItem singleStepItem;
/*     */   JMenuItem stepOverItem;
/*     */   JMenuItem untilCallItem;
/*     */   JMenuItem untilCursorItem;
/*     */   JMenu helpMenu;
/*     */   JMenuItem helpMeItem;
/*     */   JMenuItem aboutItem;
/*     */   JPanel panel;
/*     */   JToolBar toolBar;
/*     */   Icon playIcon;
/*     */   Icon pauseIcon;
/*     */   Icon singleStepIcon;
/*     */   Icon resetIcon;
/*     */   Icon stepOverIcon;
/*     */   Icon untilCallIcon;
/*     */   Icon untilCursorIcon;
/*     */   Icon showCodeWindowIcon;
/*     */   Icon showRegisterPortWindowIcon;
/*     */   Icon showWatchesWindowIcon;
/*     */   JButton playButton;
/*     */   JButton pauseButton;
/*     */   JButton singleStepButton;
/*     */   JButton resetButton;
/*     */   JButton stepOverButton;
/*     */   JButton untilCallButton;
/*     */   JButton untilCursorButton;
/*     */   JButton showCodeWindowButton;
/*     */   JButton showRegisterPortWindowButton;
/*     */   JButton showWatchesWindowButton;
/*     */ 
/*     */   MainWindow(Virgo paramVirgo)
/*     */   {
/* 120 */     super("Virgo - no file opened");
/*     */ 
/* 122 */     this.virgo = paramVirgo;
/* 123 */     this.container = getContentPane();
/*     */ 
/* 125 */     this.playIcon = new ImageIcon("play.gif");
/* 126 */     this.pauseIcon = new ImageIcon("pause.gif");
/* 127 */     this.singleStepIcon = new ImageIcon("singlestep.gif");
/* 128 */     this.stepOverIcon = new ImageIcon("stepOver.gif");
/* 129 */     this.resetIcon = new ImageIcon("reset.gif");
/* 130 */     this.untilCallIcon = new ImageIcon("untilCall.gif");
/* 131 */     this.untilCursorIcon = new ImageIcon("untilCursor.gif");
/*     */ 
/* 133 */     this.showCodeWindowIcon = new ImageIcon("showCodeWindow.gif");
/* 134 */     this.showRegisterPortWindowIcon = new ImageIcon("showRegisterPortWindow.gif");
/* 135 */     this.showWatchesWindowIcon = new ImageIcon("showWatchesWindow.gif");
/*     */ 
/* 139 */     this.menuBar = new JMenuBar();
/* 140 */     this.fileMenu = new JMenu("File");
/*     */ 
/* 142 */     this.fileMenu.setMnemonic('f');
/* 143 */     this.menuBar.add(this.fileMenu);
/*     */ 
/* 145 */     this.openItem = new JMenuItem("Open");
/* 146 */     this.openItem.setIcon(new ImageIcon("open.gif"));
/* 147 */     this.openItem.setVerticalTextPosition(0);
/* 148 */     this.openItem.setHorizontalTextPosition(4);
/* 149 */     this.openItem.setActionCommand(OPEN);
/* 150 */     this.openItem.addActionListener(this);
/*     */ 
/* 152 */     this.openItem.setMnemonic('o');
/* 153 */     this.fileMenu.add(this.openItem);
/*     */ 
/* 155 */     this.fileMenu.addSeparator();
/*     */ 
/* 157 */     this.exitItem = new JMenuItem("Exit");
/* 158 */     this.exitItem.addActionListener(this);
/* 159 */     this.exitItem.setActionCommand(EXIT);
/*     */ 
/* 161 */     this.exitItem.setMnemonic('e');
/* 162 */     this.fileMenu.add(this.exitItem);
/*     */ 
/* 164 */     this.runMenu = new JMenu("Run");
/*     */ 
/* 166 */     this.runMenu.setMnemonic('r');
/* 167 */     this.menuBar.add(this.runMenu);
/*     */ 
/* 169 */     this.resetItem = new JMenuItem("Reset");
/* 170 */     this.resetItem.setIcon(this.resetIcon);
/* 171 */     this.resetItem.setVerticalTextPosition(0);
/* 172 */     this.resetItem.setHorizontalTextPosition(4);
/* 173 */     this.resetItem.setActionCommand(RESET);
/* 174 */     this.resetItem.addActionListener(this);
/*     */ 
/* 176 */     this.resetItem.setMnemonic('e');
/* 177 */     this.runMenu.add(this.resetItem);
/*     */ 
/* 179 */     this.runItem = new JMenuItem("Play");
/* 180 */     this.runItem.setIcon(this.playIcon);
/* 181 */     this.runItem.setVerticalTextPosition(0);
/* 182 */     this.runItem.setHorizontalTextPosition(4);
/* 183 */     this.runItem.setActionCommand(PLAY);
/* 184 */     this.runItem.addActionListener(this);
/*     */ 
/* 186 */     this.runItem.setMnemonic('p');
/* 187 */     this.runMenu.add(this.runItem);
/*     */ 
/* 189 */     this.singleStepItem = new JMenuItem("Single step");
/* 190 */     this.singleStepItem.setIcon(this.singleStepIcon);
/* 191 */     this.singleStepItem.setVerticalTextPosition(0);
/* 192 */     this.singleStepItem.setHorizontalTextPosition(4);
/* 193 */     this.singleStepItem.setActionCommand(SINGLE_STEP);
/* 194 */     this.singleStepItem.addActionListener(this);
/*     */ 
/* 196 */     this.singleStepItem.setMnemonic('s');
/* 197 */     this.runMenu.add(this.singleStepItem);
/*     */ 
/* 199 */     this.stepOverItem = new JMenuItem("Step over");
/* 200 */     this.stepOverItem.setIcon(this.stepOverIcon);
/* 201 */     this.stepOverItem.setVerticalTextPosition(0);
/* 202 */     this.stepOverItem.setHorizontalTextPosition(4);
/* 203 */     this.stepOverItem.setActionCommand(STEP_OVER);
/* 204 */     this.stepOverItem.addActionListener(this);
/*     */ 
/* 206 */     this.stepOverItem.setMnemonic('o');
/* 207 */     this.runMenu.add(this.stepOverItem);
/*     */ 
/* 209 */     this.untilCallItem = new JMenuItem("Run until CALL");
/* 210 */     this.untilCallItem.setIcon(this.untilCallIcon);
/* 211 */     this.untilCallItem.setVerticalTextPosition(0);
/* 212 */     this.untilCallItem.setHorizontalTextPosition(4);
/* 213 */     this.untilCallItem.setActionCommand(UNTIL_CALL);
/* 214 */     this.untilCallItem.addActionListener(this);
/*     */ 
/* 216 */     this.untilCallItem.setMnemonic('c');
/* 217 */     this.runMenu.add(this.untilCallItem);
/*     */ 
/* 219 */     this.untilCursorItem = new JMenuItem("Run until selected line");
/* 220 */     this.untilCursorItem.setIcon(this.untilCursorIcon);
/* 221 */     this.untilCursorItem.setVerticalTextPosition(0);
/* 222 */     this.untilCursorItem.setHorizontalTextPosition(4);
/* 223 */     this.untilCursorItem.setActionCommand(UNTIL_CURSOR);
/* 224 */     this.untilCursorItem.addActionListener(this);
/*     */ 
/* 226 */     this.untilCursorItem.setMnemonic('u');
/* 227 */     this.runMenu.add(this.untilCursorItem);
/*     */ 
/* 229 */     this.windowsMenu = new JMenu("Windows");
/*     */ 
/* 231 */     this.windowsMenu.setMnemonic('w');
/* 232 */     this.menuBar.add(this.windowsMenu);
/*     */ 
/* 235 */     this.codeItem = new JCheckBoxMenuItem("Instructions", false);
/* 236 */     this.codeItem.setActionCommand(TOGGLE_CODE_WINDOW);
/* 237 */     this.codeItem.addActionListener(this);
/*     */ 
/* 239 */     this.codeItem.setMnemonic('i');
/* 240 */     this.windowsMenu.add(this.codeItem);
/*     */ 
/* 242 */     this.registerPortItem = new JCheckBoxMenuItem("Registers & ports");
/* 243 */     this.registerPortItem.setActionCommand(TOGGLE_REGISTERPORT_WINDOW);
/* 244 */     this.registerPortItem.addActionListener(this);
/*     */ 
/* 246 */     this.registerPortItem.setMnemonic('r');
/* 247 */     this.windowsMenu.add(this.registerPortItem);
/*     */ 
/* 249 */     this.watchesItem = new JCheckBoxMenuItem("Watches", false);
/* 250 */     this.watchesItem.setActionCommand(TOGGLE_WATCHES_WINDOW);
/* 251 */     this.watchesItem.addActionListener(this);
/*     */ 
/* 253 */     this.watchesItem.setMnemonic('t');
/* 254 */     this.windowsMenu.add(this.watchesItem);
/*     */ 
/* 256 */     this.breakpointsItem = new JCheckBoxMenuItem("Break points", false);
/* 257 */     this.breakpointsItem.setActionCommand(TOGGLE_BREAKPOINTS_WINDOW);
/* 258 */     this.breakpointsItem.addActionListener(this);
/*     */ 
/* 260 */     this.breakpointsItem.setMnemonic('b');
/* 261 */     this.windowsMenu.add(this.breakpointsItem);
/*     */ 
/* 263 */     this.includeMemoryWindowItem = new JCheckBoxMenuItem("Memory Window Enabled");
/* 264 */     this.includeMemoryWindowItem.setActionCommand(TOGGLE_MEMORY_WINDOW_ENABLED);
/* 265 */     this.includeMemoryWindowItem.addActionListener(this);
/*     */ 
/* 267 */     this.includeMemoryWindowItem.setMnemonic('m');
/* 268 */     this.windowsMenu.add(this.includeMemoryWindowItem);
/*     */ 
/* 271 */     this.windowsMenu.addSeparator();
/*     */ 
/* 273 */     this.closeAllItem = new JMenuItem("Close all");
/* 274 */     this.closeAllItem.setActionCommand(CLOSE_ALL);
/* 275 */     this.closeAllItem.addActionListener(this);
/*     */ 
/* 277 */     this.closeAllItem.setMnemonic('a');
/* 278 */     this.windowsMenu.add(this.closeAllItem);
/*     */ 
/* 280 */     this.resetViewItem = new JMenuItem("Arrange neatly");
/* 281 */     this.resetViewItem.setActionCommand(RESET_VIEW);
/* 282 */     this.resetViewItem.addActionListener(this);
/*     */ 
/* 284 */     this.resetViewItem.setMnemonic('n');
/* 285 */     this.windowsMenu.add(this.resetViewItem);
/*     */ 
/* 288 */     this.windowsMenu.addSeparator();
/*     */ 
/* 290 */     this.updateWindowsWhileRunningItem = new JCheckBoxMenuItem("Update windows while running");
/* 291 */     this.updateWindowsWhileRunningItem.setActionCommand(TOGGLE_UPDATE_WINDOWS_WHILE_RUNNING);
/* 292 */     this.updateWindowsWhileRunningItem.addActionListener(this);
/* 293 */     this.updateWindowsWhileRunningItem.setMnemonic('u');
/* 294 */     this.windowsMenu.add(this.updateWindowsWhileRunningItem);
/*     */ 
/* 297 */     this.helpMenu = new JMenu("HELP!");
/*     */ 
/* 299 */     this.helpMenu.setMnemonic('h');
/* 300 */     this.menuBar.add(this.helpMenu);
/*     */ 
/* 302 */     this.helpMeItem = new JMenuItem("Help ME!");
/*     */ 
/* 304 */     this.helpMeItem.setMnemonic('m');
/* 305 */     this.helpMenu.add(this.helpMeItem);
/*     */ 
/* 309 */     HelpBroker localHelpBroker = null;
/*     */     try
/*     */     {
/* 312 */       URL localObject = HelpSet.findHelpSet(null, "help/Virgo.hs");
/* 313 */       HelpSet localHelpSet = new HelpSet(null, (URL)localObject);
/* 314 */       localHelpBroker = localHelpSet.createHelpBroker();
/*     */     }
/*     */     catch (Exception localException)
/*     */     {
/* 318 */       System.out.println("HelpSet not found");
/*     */     }
/* 320 */     if (localHelpBroker != null) {
/* 321 */       this.helpMeItem.addActionListener(new javax.help.CSH.DisplayHelpFromSource(localHelpBroker));
/*     */     }
/*     */ 
/* 324 */     this.aboutItem = new JMenuItem("About");
/* 325 */     this.aboutItem.setActionCommand(ABOUT);
/* 326 */     this.aboutItem.addActionListener(this);
/*     */ 
/* 328 */     this.aboutItem.setMnemonic('a');
/* 329 */     this.helpMenu.add(this.aboutItem);
/*     */ 
/* 332 */     this.playButton = new JButton(this.playIcon);
/* 333 */     this.playButton.setToolTipText("Run");
/* 334 */     this.playButton.setActionCommand(PLAY);
/* 335 */     this.playButton.addActionListener(this);
/* 336 */     this.pauseButton = new JButton(this.pauseIcon);
/* 337 */     this.pauseButton.setToolTipText("Pause");
/* 338 */     this.pauseButton.setActionCommand(PAUSE);
/* 339 */     this.pauseButton.addActionListener(this);
/* 340 */     this.singleStepButton = new JButton(this.singleStepIcon);
/* 341 */     this.singleStepButton.setToolTipText("Run a single instruction");
/* 342 */     this.singleStepButton.setActionCommand(SINGLE_STEP);
/* 343 */     this.singleStepButton.addActionListener(this);
/* 344 */     this.resetButton = new JButton(this.resetIcon);
/* 345 */     this.resetButton.setToolTipText("Reset program");
/* 346 */     this.resetButton.setActionCommand(RESET);
/* 347 */     this.resetButton.addActionListener(this);
/* 348 */     this.stepOverButton = new JButton(this.stepOverIcon);
/* 349 */     this.stepOverButton.setToolTipText("Step over (run until RET)");
/* 350 */     this.stepOverButton.setActionCommand(STEP_OVER);
/* 351 */     this.stepOverButton.addActionListener(this);
/* 352 */     this.untilCallButton = new JButton(this.untilCallIcon);
/* 353 */     this.untilCallButton.setToolTipText("Run until CALL");
/* 354 */     this.untilCallButton.setActionCommand(UNTIL_CALL);
/* 355 */     this.untilCallButton.addActionListener(this);
/* 356 */     this.untilCursorButton = new JButton(this.untilCursorIcon);
/* 357 */     this.untilCursorButton.setToolTipText("Run until selected code line");
/* 358 */     this.untilCursorButton.setActionCommand(UNTIL_CURSOR);
/* 359 */     this.untilCursorButton.addActionListener(this);
/*     */ 
/* 363 */     this.showCodeWindowButton = new JButton(this.showCodeWindowIcon);
/* 364 */     this.showCodeWindowButton.setToolTipText("View instructions");
/* 365 */     this.showCodeWindowButton.setActionCommand(SHOW_CODE_WINDOW);
/* 366 */     this.showCodeWindowButton.addActionListener(this);
/* 367 */     this.showRegisterPortWindowButton = new JButton(this.showRegisterPortWindowIcon);
/* 368 */     this.showRegisterPortWindowButton.setToolTipText("View registers and ports");
/* 369 */     this.showRegisterPortWindowButton.setActionCommand(SHOW_REGISTERPORT_WINDOW);
/* 370 */     this.showRegisterPortWindowButton.addActionListener(this);
/* 371 */     this.showWatchesWindowButton = new JButton(this.showWatchesWindowIcon);
/* 372 */     this.showWatchesWindowButton.setToolTipText("View watches");
/* 373 */     this.showWatchesWindowButton.setActionCommand(SHOW_WATCHES_WINDOW);
/* 374 */     this.showWatchesWindowButton.addActionListener(this);
/*     */ 
/* 377 */     this.toolBar = new JToolBar();
/* 378 */     this.toolBar.setFloatable(false);
/* 379 */     this.toolBar.add(this.resetButton);
/* 380 */     this.toolBar.add(this.pauseButton);
/* 381 */     this.toolBar.add(this.playButton);
/* 382 */     this.toolBar.add(this.singleStepButton);
/* 383 */     this.toolBar.add(this.stepOverButton);
/* 384 */     this.toolBar.add(this.untilCallButton);
/* 385 */     this.toolBar.add(this.untilCursorButton);
/* 386 */     this.toolBar.addSeparator();
/* 387 */     this.toolBar.add(this.showCodeWindowButton);
/* 388 */     this.toolBar.add(this.showRegisterPortWindowButton);
/* 389 */     this.toolBar.add(this.showWatchesWindowButton);
/*     */ 
/* 393 */     this.panel = new JPanel(new GridLayout(2, 1));
/* 394 */     this.panel.add(this.menuBar);
/* 395 */     this.panel.add(this.toolBar);
/*     */ 
/* 400 */     Object localObject = new JPanel();
/* 401 */     ((JComponent)localObject).setBorder(new TitledBorder(new EtchedBorder(), "Display screen"));
/* 402 */     this.screen = new MainWindow.SpecialJTextArea(25, 40);
/* 403 */     updateScreen();
/* 404 */     JScrollPane localJScrollPane = new JScrollPane(this.screen, 21, 31);
/* 405 */     localJScrollPane.setPreferredSize(new Dimension(285, 355));
/*     */ 
/* 407 */     ((Container)localObject).add(localJScrollPane);
/*     */ 
/* 409 */     this.container.add((Component)localObject, "South");
/* 410 */     this.container.add(this.panel, "North");
/*     */ 
/* 413 */     getGlassPane().setCursor(Cursor.getPredefinedCursor(3));
/* 414 */     getGlassPane().addMouseListener(new MouseAdapter()
/*     */     {
/*     */       public void mousePressed(MouseEvent paramAnonymousMouseEvent)
/*     */       {
/*     */       }
/*     */     });
/* 415 */     setBusy(false);
/*     */ 
/* 417 */     setIconImage(Toolkit.getDefaultToolkit().getImage("icon.gif"));
/*     */ 
/* 419 */     addWindowListener(new MainWindow.WindowEventHandler());
/* 420 */     setDefaultCloseOperation(2);
/* 421 */     setBounds(Constants.mainWindowBounds);
/* 422 */     setResizable(false);
/*     */   }
/*     */ 
/*     */   public void actionPerformed(ActionEvent paramActionEvent)
/*     */   {
/* 523 */     String str = paramActionEvent.getActionCommand();
/*     */ 
/* 525 */     if (str.equals(PAUSE))
/*     */     {
/* 527 */       this.virgo.virgoState.virgoIsRunning = false;
/*     */     }
/* 529 */     else if (str.equals(PLAY))
/*     */     {
/* 531 */       this.virgo.run();
/*     */     }
/* 534 */     else if (str.equals(SINGLE_STEP))
/*     */     {
/* 536 */       this.virgo.singleStep();
/*     */     }
/* 539 */     else if (str.equals(RESET))
/*     */     {
/* 541 */       this.virgo.reset();
/*     */     }
/* 544 */     else if (str.equals(STEP_OVER))
/*     */     {
/* 546 */       this.virgo.stepOver();
/*     */     }
/* 549 */     else if (str.equals(UNTIL_CALL))
/*     */     {
/* 551 */       this.virgo.untilCall();
/*     */     }
/* 554 */     else if (str.equals(UNTIL_CURSOR))
/*     */     {
/* 556 */       this.virgo.untilCursor();
/*     */     }
/* 559 */     else if (str.equals(TOGGLE_REGISTERPORT_WINDOW))
/*     */     {
/* 561 */       this.virgo.toggleRegisterPortWindowVisible();
/*     */     }
/* 564 */     else if (str.equals(SHOW_REGISTERPORT_WINDOW))
/*     */     {
/* 566 */       this.virgo.setRegisterPortWindowVisible(true);
/*     */     }
/* 570 */     else if (str.equals(TOGGLE_CODE_WINDOW))
/*     */     {
/* 572 */       this.virgo.toggleCodeWindowVisible();
/*     */     }
/* 575 */     else if (str.equals(SHOW_CODE_WINDOW))
/*     */     {
/* 577 */       this.virgo.setCodeWindowVisible(true);
/*     */     }
/* 580 */     else if (str.equals(TOGGLE_WATCHES_WINDOW))
/*     */     {
/* 582 */       this.virgo.toggleWatchesWindowVisible();
/*     */     }
/* 585 */     else if (str.equals(SHOW_WATCHES_WINDOW))
/*     */     {
/* 587 */       this.virgo.setWatchesWindowVisible(true);
/*     */     }
/* 590 */     else if (str.equals(TOGGLE_BREAKPOINTS_WINDOW))
/*     */     {
/* 592 */       this.virgo.toggleBreakpointsWindowVisible();
/*     */     }
/* 595 */     else if (str.equals(TOGGLE_MEMORY_WINDOW_ENABLED))
/*     */     {
/* 597 */       this.virgo.toggleMemoryWindowEnabled();
/*     */     }
/* 600 */     else if (str.equals(TOGGLE_UPDATE_WINDOWS_WHILE_RUNNING))
/*     */     {
/* 602 */       this.virgo.toggleUpdateWhileRun();
/*     */     }
/* 605 */     else if (str.equals(RESET_VIEW))
/*     */     {
/* 607 */       this.virgo.resetView();
/*     */     }
/* 610 */     else if (str.equals(CLOSE_ALL))
/*     */     {
/* 612 */       this.virgo.closeAll();
/*     */     }
/*     */     else
/*     */     {
/*     */       Object localObject;
/* 615 */       if (str.equals(OPEN))
/*     */       {
/* 617 */         localObject = new JFileChooser(this.virgo.virgoState.lastPath);
/* 618 */         ((JFileChooser)localObject).setFileFilter(new ObjFiles());
/* 619 */         int i = ((JFileChooser)localObject).showOpenDialog(this);
/*     */ 
/* 621 */         if (i == 0)
/*     */         {
/* 623 */           File localFile = ((JFileChooser)localObject).getSelectedFile();
/* 624 */           if (!localFile.canRead())
/*     */           {
/* 627 */             showDialog("Problem!", localFile.getName() + " does not exist or is unreachable");
/* 628 */             repaint();
/* 629 */             return;
/*     */           }
/* 631 */           this.virgo.loadFile(localFile.getName(), localFile.getAbsolutePath());
/*     */         }
/*     */ 
/*     */       }
/* 635 */       else if (str.equals(ABOUT))
/*     */       {
/* 637 */         localObject = new AboutDialog(this);
/* 638 */         ((Dialog)localObject).show();
/*     */       }
/* 641 */       else if (str.equals(EXIT))
/*     */       {
/* 643 */         System.exit(0);
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */   public void setBreakpointsWindowVisible(boolean paramBoolean)
/*     */   {
/* 498 */     this.breakpointsItem.setSelected(paramBoolean);
/*     */   }
/*     */ 
/*     */   public void setBusy(boolean paramBoolean)
/*     */   {
/* 430 */     getGlassPane().setVisible(paramBoolean);
/*     */   }
/*     */ 
/*     */   public void setCodeWindowVisible(boolean paramBoolean)
/*     */   {
/* 493 */     this.codeItem.setSelected(paramBoolean);
/*     */   }
/*     */ 
/*     */   public void setComponentsEnabled(boolean paramBoolean)
/*     */   {
/* 456 */     this.playButton.setEnabled(paramBoolean);
/* 457 */     this.resetButton.setEnabled(paramBoolean);
/* 458 */     this.singleStepButton.setEnabled(paramBoolean);
/* 459 */     this.stepOverButton.setEnabled(paramBoolean);
/* 460 */     this.pauseButton.setEnabled(paramBoolean);
/* 461 */     this.untilCallButton.setEnabled(paramBoolean);
/* 462 */     this.untilCursorButton.setEnabled(paramBoolean);
/* 463 */     this.showCodeWindowButton.setEnabled(paramBoolean);
/* 464 */     this.showRegisterPortWindowButton.setEnabled(paramBoolean);
/* 465 */     this.showWatchesWindowButton.setEnabled(paramBoolean);
/* 466 */     this.runMenu.setEnabled(paramBoolean);
/* 467 */     this.windowsMenu.setEnabled(paramBoolean);
/*     */   }
/*     */ 
/*     */   public void setMemoryWindowEnabled(boolean paramBoolean)
/*     */   {
/* 513 */     this.includeMemoryWindowItem.setSelected(paramBoolean);
/*     */   }
/*     */ 
/*     */   public void setNormalComponentsEnabled(boolean paramBoolean)
/*     */   {
/* 476 */     this.playButton.setEnabled(paramBoolean);
/* 477 */     this.resetButton.setEnabled(paramBoolean);
/* 478 */     this.singleStepButton.setEnabled(paramBoolean);
/* 479 */     this.stepOverButton.setEnabled(paramBoolean);
/* 480 */     this.untilCallButton.setEnabled(paramBoolean);
/* 481 */     this.untilCursorButton.setEnabled(paramBoolean);
/* 482 */     this.showCodeWindowButton.setEnabled(paramBoolean);
/* 483 */     this.showRegisterPortWindowButton.setEnabled(paramBoolean);
/* 484 */     this.showWatchesWindowButton.setEnabled(paramBoolean);
/* 485 */     this.fileMenu.setEnabled(paramBoolean);
/* 486 */     this.runMenu.setEnabled(paramBoolean);
/* 487 */     this.windowsMenu.setEnabled(paramBoolean);
/* 488 */     this.helpMenu.setEnabled(paramBoolean);
/*     */   }
/*     */ 
/*     */   public void setRegisterPortWindowVisible(boolean paramBoolean)
/*     */   {
/* 508 */     this.registerPortItem.setSelected(paramBoolean);
/*     */   }
/*     */ 
/*     */   public void setUpdateWindowsWhileRunning(boolean paramBoolean)
/*     */   {
/* 518 */     this.updateWindowsWhileRunningItem.setSelected(paramBoolean);
/*     */   }
/*     */ 
/*     */   public void setWatchesWindowVisible(boolean paramBoolean)
/*     */   {
/* 503 */     this.watchesItem.setSelected(paramBoolean);
/*     */   }
/*     */ 
/*     */   public void showDialog(String paramString1, String paramString2)
/*     */   {
/* 448 */     JOptionPane.showMessageDialog(this, paramString2, paramString1, 0);
/*     */   }
/*     */ 
/*     */   public void updateScreen()
/*     */   {
/* 438 */     this.screen.setText(this.virgo.machine.getScreenContents());
/*     */ 
/* 440 */     int i = this.virgo.machine.getCursorY() * 40 + this.virgo.machine.getCursorX();
/* 441 */     this.screen.setCaretPosition(i);
/* 442 */     this.screen.moveCaretPosition(i + 1);
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
/* 651 */       System.exit(0);
/*     */     }
/*     */   }
/*     */ 
/*     */   class SpecialJTextArea extends JTextArea
/*     */   {
/*     */     SpecialJTextArea(int paramInt1, int arg3)
/*     */     {
/* 661 */       super();
/*     */ 
/* 664 */       setDoubleBuffered(true);
/* 665 */       setEditable(false);
/* 666 */       setEnabled(true);
/* 667 */       setBackground(Color.black);
/* 668 */       setForeground(Color.white);
/* 669 */       setSelectionColor(Color.white);
/* 670 */       setLineWrap(true);
/* 671 */       setFont(new Font("Courier New", 0, 12));
/*     */     }
/*     */     public boolean isFocusTraversable() {
/* 674 */       return false;
/*     */     }
/*     */ 
/*     */     protected void processEvent(AWTEvent paramAWTEvent)
/*     */     {
/*     */     }
/*     */   }
/*     */ }

/* Location:           C:\Users\daishi\Downloads\virgo213\virgo213_2006\
 * Qualified Name:     MainWindow
 * JD-Core Version:    0.6.2
 */