/*     */ import java.awt.Component;
/*     */ import java.awt.Dialog;
/*     */ import java.awt.Frame;
/*     */ import java.awt.Point;
/*     */ import java.awt.Rectangle;
/*     */ import java.awt.Window;
/*     */ 
/*     */ class LoadingThread extends Thread
/*     */   implements Constants
/*     */ {
/*     */   String fullPath;
/*     */   String name;
/*     */   Virgo virgo;
/*     */   WaitDialog dialog;
/*     */ 
/*     */   LoadingThread(Virgo paramVirgo, String paramString1, String paramString2)
/*     */   {
/* 563 */     super("Loading Thread");
/* 564 */     setPriority(1);
/* 565 */     this.fullPath = paramString1;
/* 566 */     this.name = paramString2;
/* 567 */     this.virgo = paramVirgo;
/*     */   }
/*     */ 
/*     */   public void run()
/*     */   {
/* 573 */     this.virgo.setWindowsBusy(true);
/* 574 */     this.virgo.mainWindow.setBusy(true);
/*     */ 
/* 576 */     this.dialog = new WaitDialog(this.virgo.mainWindow);
/*     */ 
/* 580 */     this.dialog.setBounds(this.virgo.mainWindow.getLocation().x + (Constants.mainWindowBounds.width - Constants.waitDialogBounds.width) / 2, this.virgo.mainWindow.getLocation().y + (Constants.mainWindowBounds.height - Constants.waitDialogBounds.height) / 2, Constants.waitDialogBounds.width, Constants.waitDialogBounds.height);
/* 581 */     this.dialog.show();
/*     */ 
/* 584 */     boolean bool = ObjFileLoader.load(this.fullPath, this.virgo.code);
/*     */ 
/* 588 */     this.dialog.setValue(30);
/*     */ 
/* 592 */     if (!bool)
/*     */     {
/* 595 */       this.dialog.dispose();
/* 596 */       this.virgo.mainWindow.showDialog("Problem!", this.name + " is corrupted");
/* 597 */       this.virgo.mainWindow.repaint();
/*     */ 
/* 599 */       this.virgo.setWindowsBusy(false);
/* 600 */       this.virgo.mainWindow.setBusy(false);
/*     */ 
/* 602 */       return;
/*     */     }
/*     */ 
/* 606 */     this.virgo.breakpoints = new Breakpoints(this.virgo);
/* 607 */     this.virgo.watches = new Watches(this.virgo);
/*     */ 
/* 610 */     this.virgo.machine.reset();
/*     */ 
/* 613 */     this.virgo.machine.writeInstructionsIntoMemory(this.virgo.code.instructions, this.virgo.code.startAddresses);
/*     */ 
/* 617 */     this.virgo.machine.setRegister(0, 4);
/* 618 */     this.virgo.machine.setRegister(this.virgo.code.startAddress, 8);
/*     */ 
/* 621 */     this.virgo.virgoState.lastPath = this.fullPath;
/*     */ 
/* 625 */     this.dialog.setValue(50);
/*     */ 
/* 629 */     this.virgo.codeWindow.update();
/* 630 */     this.virgo.registerPortWindow.update();
/* 631 */     this.virgo.watchesWindow.update();
/*     */ 
/* 633 */     this.dialog.setValue(70);
/*     */ 
/* 637 */     this.virgo.breakpointsWindow.updateList();
/* 638 */     this.virgo.mainWindow.updateScreen();
/*     */ 
/* 641 */     this.dialog.setValue(80);
/*     */ 
/* 645 */     if (this.virgo.virgoState.memoryWindowEnabled) this.virgo.memoryWindow.update();
/*     */ 
/* 648 */     this.dialog.setValue(100);
/*     */ 
/* 653 */     this.virgo.mainWindow.setComponentsEnabled(true);
/* 654 */     this.virgo.mainWindow.setTitle("Virgo - " + this.name);
/*     */ 
/* 656 */     this.dialog.dispose();
/*     */ 
/* 659 */     this.virgo.resetView();
/*     */ 
/* 661 */     this.virgo.setWindowsBusy(false);
/* 662 */     this.virgo.mainWindow.setBusy(false);
/*     */   }
/*     */ }

/* Location:           C:\Users\daishi\Downloads\virgo213\virgo213_2006\
 * Qualified Name:     LoadingThread
 * JD-Core Version:    0.6.2
 */