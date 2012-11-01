/*     */ class StepOverThread extends Thread
/*     */   implements Constants
/*     */ {
/*     */   Virgo virgo;
/*     */ 
/*     */   StepOverThread(Virgo paramVirgo)
/*     */   {
/* 818 */     super("Step Over Thread");
/* 819 */     setPriority(1);
/* 820 */     this.virgo = paramVirgo;
/*     */   }
/*     */ 
/*     */   public void run()
/*     */   {
/* 828 */     if (this.virgo.virgoState.endOfCodeReached)
/*     */     {
/* 830 */       this.virgo.mainWindow.showDialog("Hey!", "End of code is already reached.");
/* 831 */       return;
/*     */     }
/*     */ 
/* 834 */     this.virgo.setWindowsBusy(true);
/*     */ 
/* 839 */     this.virgo.virgoState.virgoIsRunning = true;
/*     */ 
/* 841 */     this.virgo.mainWindow.setNormalComponentsEnabled(false);
/*     */ 
/* 845 */     this.virgo.breakpoints.readyToRun();
/* 846 */     StopPoint localStopPoint = null;
/* 847 */     int i = this.virgo.machine.getRegister(8);
/*     */ 
/* 850 */     int j = 0;
/*     */     int m;
/* 858 */     while ((this.virgo.virgoState.virgoIsRunning & localStopPoint == null & (this.virgo.virgoState.endOfCodeReached ^ true)))
/*     */     {
/* 863 */       if (!this.virgo.code.isValidStartAddress(this.virgo.machine.getRegister(8)))
/*     */       {
/* 865 */         localStopPoint = new StopPoint(3, "");
/* 866 */         break;
/*     */       }
/*     */ 
/* 871 */       i = this.virgo.machine.getRegister(8);
/*     */ 
/* 874 */       m = this.virgo.code.convertStartAddressToCodeLine(this.virgo.machine.getRegister(8));
/* 875 */       int k = this.virgo.code.instructionNestingInfo[m];
/* 876 */       if ((k == 1) || (k == 2))
/* 877 */         j++;
/* 878 */       else if ((k == 3) || (k == 4)) {
/* 879 */         j--;
/*     */       }
/*     */ 
/* 883 */       localStopPoint = this.virgo.machine.doInstruction();
/*     */ 
/* 886 */       if ((this.virgo.virgoState.breakpointsEnabled) && (this.virgo.breakpoints.shouldBreak()))
/*     */       {
/* 888 */         localStopPoint = new StopPoint(4, this.virgo.breakpoints.getMessage());
/* 889 */         break;
/*     */       }
/*     */ 
/* 893 */       if (j <= 0)
/*     */       {
/* 895 */         localStopPoint = null;
/* 896 */         break;
/*     */       }
/*     */ 
/*     */     }
/*     */ 
/* 901 */     if (localStopPoint != null)
/*     */     {
/* 906 */       if (this.virgo.code.isValidStartAddress(this.virgo.machine.getRegister(8)))
/*     */       {
/* 908 */         m = this.virgo.code.convertStartAddressToCodeLine(this.virgo.machine.getRegister(8));
/* 909 */         this.virgo.codeWindow.setCurrentCodeLine(m);
/*     */       }
/*     */       else
/*     */       {
/* 916 */         m = this.virgo.code.convertStartAddressToCodeLine(i);
/*     */ 
/* 918 */         this.virgo.codeWindow.setCurrentCodeLine(m);
/*     */       }
/*     */ 
/* 922 */       this.virgo.mainWindow.showDialog("Execution Stopped", localStopPoint.toString());
/*     */     }
/* 926 */     else if (this.virgo.virgoState.endOfCodeReached)
/*     */     {
/* 929 */       m = this.virgo.code.convertStartAddressToCodeLine(i);
/* 930 */       this.virgo.codeWindow.setCurrentCodeLine(m);
/* 931 */       this.virgo.mainWindow.showDialog("Finally!", "End of code is reached.");
/*     */     }
/* 939 */     else if (this.virgo.code.isValidStartAddress(this.virgo.machine.getRegister(8)))
/*     */     {
/* 941 */       m = this.virgo.code.convertStartAddressToCodeLine(this.virgo.machine.getRegister(8));
/* 942 */       this.virgo.codeWindow.setCurrentCodeLine(m);
/*     */     }
/*     */     else
/*     */     {
/* 948 */       m = this.virgo.code.convertStartAddressToCodeLine(i);
/* 949 */       this.virgo.codeWindow.setCurrentCodeLine(m);
/*     */     }
/*     */ 
/* 953 */     this.virgo.mainWindow.setNormalComponentsEnabled(true);
/*     */ 
/* 956 */     this.virgo.virgoState.virgoIsRunning = false;
/*     */ 
/* 959 */     if (!this.virgo.virgoState.updateGUIWhileRunning)
/*     */     {
/* 961 */       this.virgo.registerPortWindow.update();
/* 962 */       this.virgo.watches.update();
/* 963 */       this.virgo.watchesWindow.update();
/*     */     }
/*     */ 
/* 967 */     this.virgo.setWindowsBusy(false);
/*     */   }
/*     */ }

/* Location:           C:\Users\daishi\Downloads\virgo213\virgo213_2006\
 * Qualified Name:     StepOverThread
 * JD-Core Version:    0.6.2
 */