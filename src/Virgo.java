/*     */ import java.awt.Component;
/*     */ import java.awt.Window;
/*     */ import java.io.PrintStream;
/*     */ import javax.swing.FocusManager;
/*     */ 
/*     */ public class Virgo
/*     */   implements Constants
/*     */ {
/*     */   Machine machine;
/*     */   MainWindow mainWindow;
/*     */   MemoryWindow memoryWindow;
/*     */   CodeWindow codeWindow;
/*     */   BreakpointsWindow breakpointsWindow;
/*     */   WatchesWindow watchesWindow;
/*     */   RegisterPortWindow registerPortWindow;
/*     */   Breakpoints breakpoints;
/*     */   Watches watches;
/*     */   Code code;
/*     */   VirgoState virgoState;
/*     */ 
/*     */   Virgo()
/*     */   {
/*  64 */     this.virgoState = new VirgoState();
/*  65 */     this.machine = new Machine(this);
/*     */ 
/*  67 */     this.code = new Code();
/*  68 */     this.breakpoints = new Breakpoints(this);
/*  69 */     this.watches = new Watches(this);
/*     */ 
/*  71 */     this.mainWindow = new MainWindow(this);
/*     */ 
/*  73 */     this.codeWindow = new CodeWindow(this);
/*  74 */     this.breakpointsWindow = new BreakpointsWindow(this);
/*  75 */     this.watchesWindow = new WatchesWindow(this);
/*  76 */     this.registerPortWindow = new RegisterPortWindow(this);
/*     */ 
/*  79 */     setMemoryWindowEnabled(false);
/*     */ 
/*  81 */     setCodeWindowVisible(false);
/*  82 */     this.mainWindow.setCodeWindowVisible(false);
/*  83 */     setWatchesWindowVisible(false);
/*  84 */     this.mainWindow.setWatchesWindowVisible(false);
/*  85 */     setBreakpointsWindowVisible(false);
/*  86 */     this.mainWindow.setBreakpointsWindowVisible(false);
/*  87 */     setRegisterPortWindowVisible(false);
/*  88 */     this.mainWindow.setRegisterPortWindowVisible(false);
/*  89 */     this.mainWindow.setUpdateWindowsWhileRunning(true);
/*     */ 
/*  91 */     this.mainWindow.setComponentsEnabled(false);
/*  92 */     this.mainWindow.show();
/*     */ 
/*  95 */     FocusManager.setCurrentManager(new VirgoFocusManager(this));
/*     */   }
/*     */ 
/*     */   public void closeAll()
/*     */   {
/* 517 */     setCodeWindowVisible(false);
/* 518 */     setRegisterPortWindowVisible(false);
/* 519 */     setWatchesWindowVisible(false);
/* 520 */     setBreakpointsWindowVisible(false);
/* 521 */     setMemoryWindowEnabled(false);
/*     */   }
/*     */ 
/*     */   public void loadFile(String paramString1, String paramString2)
/*     */   {
/* 125 */     LoadingThread localLoadingThread = new LoadingThread(this, paramString2, paramString1);
/* 126 */     localLoadingThread.start();
/*     */   }
/*     */ 
/*     */   public static void main(String[] paramArrayOfString)
/*     */   {
/* 102 */     Virgo localVirgo = new Virgo();
/* 103 */     System.out.println("Virgo Version 2.1.3 Running");
/*     */   }
/*     */ 
/*     */   public void memoryCellHasChanged(int paramInt1, int paramInt2)
/*     */   {
/* 333 */     if (this.virgoState.memoryWindowEnabled) this.memoryWindow.setMemoryCell(paramInt1, paramInt2);
/*     */ 
/* 336 */     if ((this.virgoState.updateGUIWhileRunning) || (!this.virgoState.virgoIsRunning))
/*     */     {
/* 338 */       this.watches.update();
/* 339 */       this.watchesWindow.updateList();
/*     */     }
/*     */   }
/*     */ 
/*     */   public void portHasChanged(int paramInt)
/*     */   {
/* 362 */     if (Library.portIsSignificantToScreenArea(paramInt)) {
/* 363 */       this.mainWindow.updateScreen();
/*     */     }
/* 365 */     if (this.virgoState.updateGUIWhileRunning)
/*     */     {
/* 368 */       if (Library.portIsSignificantToPortWindow(paramInt))
/* 369 */         this.registerPortWindow.updatePorts();
/*     */     }
/*     */   }
/*     */ 
/*     */   public void registerHasChanged(int paramInt1, int paramInt2)
/*     */   {
/* 352 */     if ((this.virgoState.updateGUIWhileRunning) || (!this.virgoState.virgoIsRunning))
/* 353 */       this.registerPortWindow.updateRegisters();
/*     */   }
/*     */ 
/*     */   public void reset()
/*     */   {
/* 141 */     this.machine.reset();
/*     */ 
/* 144 */     this.machine.writeInstructionsIntoMemory(this.code.instructions, this.code.startAddresses);
/*     */ 
/* 147 */     this.machine.setRegister(0, 4);
/* 148 */     this.machine.setRegister(this.code.startAddress, 8);
/*     */ 
/* 150 */     this.watches.update();
/*     */ 
/* 154 */     this.codeWindow.resetCurrentCodeLine();
/* 155 */     this.registerPortWindow.update();
/* 156 */     this.watchesWindow.update();
/* 157 */     this.mainWindow.updateScreen();
/*     */ 
/* 159 */     if (this.virgoState.memoryWindowEnabled) this.memoryWindow.update();
/*     */ 
/* 161 */     resetView();
/*     */   }
/*     */ 
/*     */   public void resetView()
/*     */   {
/* 527 */     this.codeWindow.setBounds(Constants.codeWindowBounds);
/* 528 */     setCodeWindowVisible(true);
/* 529 */     this.registerPortWindow.setBounds(Constants.registerPortWindowBounds);
/* 530 */     setRegisterPortWindowVisible(true);
/* 531 */     this.watchesWindow.setBounds(Constants.watchesWindowBounds);
/* 532 */     setWatchesWindowVisible(true);
/* 533 */     if (this.virgoState.memoryWindowEnabled)
/*     */     {
/* 535 */       this.memoryWindow.setBounds(Constants.memoryWindowBounds);
/* 536 */       this.memoryWindow.setVisible(true);
/* 537 */       setBreakpointsWindowVisible(false);
/*     */     }
/*     */     else
/*     */     {
/* 541 */       this.breakpointsWindow.setBounds(Constants.breakpointsWindowBounds);
/* 542 */       setBreakpointsWindowVisible(true);
/*     */     }
/* 544 */     this.mainWindow.setBounds(Constants.mainWindowBounds);
/* 545 */     this.mainWindow.repaint();
/*     */   }
/*     */ 
/*     */   public void run()
/*     */   {
/* 241 */     RunningThread localRunningThread = new RunningThread(this);
/* 242 */     localRunningThread.start();
/*     */   }
/*     */ 
/*     */   public void setBreakpointsEnabled(boolean paramBoolean)
/*     */   {
/* 375 */     this.virgoState.breakpointsEnabled = paramBoolean;
/*     */   }
/*     */ 
/*     */   public void setBreakpointsWindowVisible(boolean paramBoolean)
/*     */   {
/* 432 */     if (paramBoolean)
/*     */     {
/* 434 */       this.virgoState.breakpointsWindowVisible = true;
/* 435 */       this.breakpointsWindow.setVisible(true);
/* 436 */       this.mainWindow.setBreakpointsWindowVisible(true);
/*     */     }
/*     */     else
/*     */     {
/* 440 */       this.virgoState.breakpointsWindowVisible = false;
/* 441 */       this.breakpointsWindow.setVisible(false);
/* 442 */       this.mainWindow.setBreakpointsWindowVisible(false);
/*     */     }
/*     */   }
/*     */ 
/*     */   public void setCodeWindowVisible(boolean paramBoolean)
/*     */   {
/* 416 */     if (paramBoolean)
/*     */     {
/* 418 */       this.virgoState.codeWindowVisible = true;
/* 419 */       this.codeWindow.setVisible(true);
/* 420 */       this.mainWindow.setCodeWindowVisible(true);
/*     */     }
/*     */     else
/*     */     {
/* 424 */       this.virgoState.codeWindowVisible = false;
/* 425 */       this.codeWindow.setVisible(false);
/* 426 */       this.mainWindow.setCodeWindowVisible(false);
/*     */     }
/*     */   }
/*     */ 
/*     */   public void setMemoryWindowEnabled(boolean paramBoolean)
/*     */   {
/* 381 */     if (paramBoolean)
/*     */     {
/* 386 */       this.memoryWindow = new MemoryWindow(this);
/*     */ 
/* 388 */       this.memoryWindow.update();
/*     */ 
/* 390 */       this.virgoState.memoryWindowEnabled = true;
/* 391 */       this.mainWindow.setMemoryWindowEnabled(true);
/*     */ 
/* 393 */       setBreakpointsWindowVisible(false);
/* 394 */       this.memoryWindow.setVisible(true);
/*     */     }
/*     */     else
/*     */     {
/* 401 */       this.virgoState.memoryWindowEnabled = false;
/* 402 */       this.mainWindow.setMemoryWindowEnabled(false);
/* 403 */       if (this.memoryWindow != null)
/*     */       {
/* 405 */         this.memoryWindow.dispose();
/* 406 */         this.memoryWindow = null;
/* 407 */         System.gc();
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */   public void setRegisterPortWindowVisible(boolean paramBoolean)
/*     */   {
/* 464 */     if (paramBoolean)
/*     */     {
/* 466 */       this.virgoState.registerPortWindowVisible = true;
/* 467 */       this.registerPortWindow.setVisible(true);
/* 468 */       this.mainWindow.setRegisterPortWindowVisible(true);
/*     */     }
/*     */     else
/*     */     {
/* 472 */       this.virgoState.registerPortWindowVisible = false;
/* 473 */       this.registerPortWindow.setVisible(false);
/* 474 */       this.mainWindow.setRegisterPortWindowVisible(false);
/*     */     }
/*     */   }
/*     */ 
/*     */   public void setUpdateWhileRun(boolean paramBoolean)
/*     */   {
/* 480 */     this.virgoState.updateGUIWhileRunning = paramBoolean;
/*     */   }
/*     */ 
/*     */   public void setWatchesWindowVisible(boolean paramBoolean)
/*     */   {
/* 448 */     if (paramBoolean)
/*     */     {
/* 450 */       this.virgoState.watchesWindowVisible = true;
/* 451 */       this.watchesWindow.setVisible(true);
/* 452 */       this.mainWindow.setWatchesWindowVisible(true);
/*     */     }
/*     */     else
/*     */     {
/* 456 */       this.virgoState.watchesWindowVisible = false;
/* 457 */       this.watchesWindow.setVisible(false);
/* 458 */       this.mainWindow.setWatchesWindowVisible(false);
/*     */     }
/*     */   }
/*     */ 
/*     */   public void setWindowsBusy(boolean paramBoolean)
/*     */   {
/* 111 */     this.registerPortWindow.setBusy(paramBoolean);
/* 112 */     this.watchesWindow.setBusy(paramBoolean);
/* 113 */     this.codeWindow.setBusy(paramBoolean);
/* 114 */     this.breakpointsWindow.setBusy(paramBoolean);
/* 115 */     if (this.virgoState.memoryWindowEnabled) this.memoryWindow.setBusy(paramBoolean);
/*     */   }
/*     */ 
/*     */   public void singleStep()
/*     */   {
/* 170 */     if (this.virgoState.endOfCodeReached)
/*     */     {
/* 172 */       this.mainWindow.showDialog("Hey!", "End of code is already reached.");
/* 173 */       return;
/*     */     }
/*     */ 
/* 176 */     StopPoint localStopPoint = this.machine.doInstruction();
/*     */     int i;
/*     */     int j;
/* 178 */     if (localStopPoint != null)
/*     */     {
/* 180 */       i = this.machine.getRegister(8);
/*     */ 
/* 185 */       if (this.code.isValidStartAddress(i))
/*     */       {
/* 187 */         j = this.code.convertStartAddressToCodeLine(i);
/* 188 */         this.codeWindow.setCurrentCodeLine(j);
/*     */       }
/*     */ 
/* 191 */       this.mainWindow.showDialog("Execution Stopped", localStopPoint.toString());
/* 192 */       return;
/*     */     }
/*     */ 
/* 197 */     if (!this.virgoState.endOfCodeReached)
/*     */     {
/* 199 */       i = this.machine.getRegister(8);
/* 200 */       if (!this.code.isValidStartAddress(i))
/*     */       {
/* 204 */         localStopPoint = new StopPoint(3, "");
/* 205 */         this.mainWindow.showDialog("Execution Stopped", localStopPoint.toString());
/* 206 */         return;
/*     */       }
/* 208 */       j = this.code.convertStartAddressToCodeLine(i);
/* 209 */       this.codeWindow.setCurrentCodeLine(j);
/* 210 */       return;
/*     */     }
/*     */ 
/* 217 */     this.mainWindow.showDialog("Finally!", "End of code is reached.");
/*     */   }
/*     */ 
/*     */   public void stepOver()
/*     */   {
/* 255 */     if ((this.code.instructionNestingInfo[this.codeWindow.getCurrentCodeLine()] != 1) && 
/* 256 */       (this.code.instructionNestingInfo[this.codeWindow.getCurrentCodeLine()] != 2))
/*     */     {
/* 258 */       singleStep();
/* 259 */       return;
/*     */     }
/*     */ 
/* 267 */     StepOverThread localStepOverThread = new StepOverThread(this);
/* 268 */     localStepOverThread.start();
/*     */   }
/*     */ 
/*     */   public void toggleBreakpointsWindowVisible()
/*     */   {
/* 495 */     setBreakpointsWindowVisible(this.virgoState.breakpointsWindowVisible ^ true);
/*     */   }
/*     */ 
/*     */   public void toggleCodeWindowVisible()
/*     */   {
/* 490 */     setCodeWindowVisible(this.virgoState.codeWindowVisible ^ true);
/*     */   }
/*     */ 
/*     */   public void toggleMemoryWindowEnabled()
/*     */   {
/* 485 */     setMemoryWindowEnabled(this.virgoState.memoryWindowEnabled ^ true);
/*     */   }
/*     */ 
/*     */   public void toggleRegisterPortWindowVisible()
/*     */   {
/* 505 */     setRegisterPortWindowVisible(this.virgoState.registerPortWindowVisible ^ true);
/*     */   }
/*     */ 
/*     */   public void toggleUpdateWhileRun()
/*     */   {
/* 510 */     setUpdateWhileRun(this.virgoState.updateGUIWhileRunning ^ true);
/*     */   }
/*     */ 
/*     */   public void toggleWatchesWindowVisible()
/*     */   {
/* 500 */     setWatchesWindowVisible(this.virgoState.watchesWindowVisible ^ true);
/*     */   }
/*     */ 
/*     */   public void untilCall()
/*     */   {
/* 281 */     if ((this.code.instructionNestingInfo[this.codeWindow.getCurrentCodeLine()] == 1) && 
/* 282 */       (this.code.instructionNestingInfo[this.codeWindow.getCurrentCodeLine()] == 2))
/*     */     {
/* 284 */       return;
/*     */     }
/*     */ 
/* 292 */     UntilCallThread localUntilCallThread = new UntilCallThread(this);
/* 293 */     localUntilCallThread.start();
/*     */   }
/*     */ 
/*     */   public void untilCursor()
/*     */   {
/* 307 */     if (this.codeWindow.getCurrentCodeLine() == this.codeWindow.getSelectedCodeLine()) {
/* 308 */       return;
/*     */     }
/*     */ 
/* 311 */     if (this.codeWindow.getSelectedCodeLine() < 0) {
/* 312 */       return;
/*     */     }
/*     */ 
/* 319 */     UntilCursorThread localUntilCursorThread = new UntilCursorThread(this);
/* 320 */     localUntilCursorThread.start();
/*     */   }
/*     */ }

/* Location:           C:\Users\daishi\Downloads\virgo213\virgo213_2006\
 * Qualified Name:     Virgo
 * JD-Core Version:    0.6.2
 */