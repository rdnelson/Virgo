/*     */ class RunningThread extends Thread
/*     */   implements Constants
/*     */ {
/*     */   Virgo virgo;
/*     */ 
/*     */   RunningThread(Virgo paramVirgo)
/*     */   {
/* 676 */     super("Running Thread");
/* 677 */     setPriority(1);
/* 678 */     this.virgo = paramVirgo;
/*     */   }
/*     */ 
/*     */   public void run()
/*     */   {
/* 686 */     if (this.virgo.virgoState.endOfCodeReached)
/*     */     {
/* 688 */       this.virgo.mainWindow.showDialog("Hey!", "End of code is already reached.");
/* 689 */       return;
/*     */     }
/*     */ 
/* 692 */     this.virgo.setWindowsBusy(true);
/*     */ 
/* 697 */     this.virgo.virgoState.virgoIsRunning = true;
/*     */ 
/* 699 */     this.virgo.mainWindow.setNormalComponentsEnabled(false);
/*     */ 
/* 703 */     this.virgo.breakpoints.readyToRun();
/* 704 */     StopPoint localStopPoint = null;
/* 705 */     int i = this.virgo.machine.getRegister(8);
/*     */ 
/* 712 */     while ((this.virgo.virgoState.virgoIsRunning & localStopPoint == null & (this.virgo.virgoState.endOfCodeReached ^ true)))
/*     */     {
/* 717 */       if (!this.virgo.code.isValidStartAddress(this.virgo.machine.getRegister(8)))
/*     */       {
/* 719 */         localStopPoint = new StopPoint(3, "");
/* 720 */         break;
/*     */       }
/*     */ 
/* 725 */       i = this.virgo.machine.getRegister(8);
/*     */ 
/* 728 */       localStopPoint = this.virgo.machine.doInstruction();
/*     */ 
/* 731 */       if ((this.virgo.virgoState.breakpointsEnabled) && (this.virgo.breakpoints.shouldBreak()))
/*     */       {
/* 733 */         localStopPoint = new StopPoint(4, this.virgo.breakpoints.getMessage());
/* 734 */         break;
/*     */       }
/*     */ 
/* 737 */       if(this.virgo.machine.timeHasPassed(this.virgo.code.instructionTimingInfo[this.virgo.code.convertStartAddressToCodeLine(i)]))
/* NEW */       {
                  int[] data = new int[2];
				  int[][] instData = new int[3][];
				  instData[0] = new int[4];
				  instData[1] = new int[4];
				  instData[2] = new int[1];
				  instData[2][0] = -1;
				  int[] addrData = new int[3];
				  
				  data[1] = 8;
				  
/* NEW */         localStopPoint = this.virgo.machine.jumpTable.jumpCD(data, instData, addrData);
/* NEW */       }
/*     */     }
/*     */     int j;
/* 740 */     if (localStopPoint != null)
/*     */     {
/* 745 */       if (this.virgo.code.isValidStartAddress(this.virgo.machine.getRegister(8)))
/*     */       {
/* 747 */         j = this.virgo.code.convertStartAddressToCodeLine(this.virgo.machine.getRegister(8));
/* 748 */         this.virgo.codeWindow.setCurrentCodeLine(j);
/*     */       }
/*     */       else
/*     */       {
/* 755 */         j = this.virgo.code.convertStartAddressToCodeLine(i);
/*     */ 
/* 757 */         this.virgo.codeWindow.setCurrentCodeLine(j);
/*     */       }
/*     */ 
/* 761 */       this.virgo.mainWindow.showDialog("Execution Stopped", localStopPoint.toString());
/*     */     }
/* 765 */     else if (this.virgo.virgoState.endOfCodeReached)
/*     */     {
/* 768 */       j = this.virgo.code.convertStartAddressToCodeLine(i);
/* 769 */       this.virgo.codeWindow.setCurrentCodeLine(j);
/* 770 */       this.virgo.mainWindow.showDialog("Finally!", "End of code is reached.");
/*     */     }
/* 774 */     else if (!this.virgo.virgoState.virgoIsRunning)
/*     */     {
/* 777 */       if (this.virgo.code.isValidStartAddress(this.virgo.machine.getRegister(8)))
/*     */       {
/* 779 */         j = this.virgo.code.convertStartAddressToCodeLine(this.virgo.machine.getRegister(8));
/* 780 */         this.virgo.codeWindow.setCurrentCodeLine(j);
/*     */       }
/*     */       else
/*     */       {
/* 786 */         j = this.virgo.code.convertStartAddressToCodeLine(i);
/* 787 */         this.virgo.codeWindow.setCurrentCodeLine(j);
/*     */       }
/*     */     }
/*     */ 
/* 791 */     this.virgo.mainWindow.setNormalComponentsEnabled(true);
/*     */ 
/* 794 */     this.virgo.virgoState.virgoIsRunning = false;
/*     */ 
/* 797 */     if (!this.virgo.virgoState.updateGUIWhileRunning)
/*     */     {
/* 799 */       this.virgo.registerPortWindow.update();
/* 800 */       this.virgo.watches.update();
/* 801 */       this.virgo.watchesWindow.update();
/*     */     }
/*     */ 
/* 804 */     this.virgo.setWindowsBusy(false);
/*     */   }
/*     */ }

/* Location:           C:\Users\daishi\Downloads\virgo213\virgo213_2006\
 * Qualified Name:     RunningThread
 * JD-Core Version:    0.6.2
 */