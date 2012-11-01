/*      */ class UntilCallThread extends Thread
/*      */   implements Constants
/*      */ {
/*      */   Virgo virgo;
/*      */ 
/*      */   UntilCallThread(Virgo paramVirgo)
/*      */   {
/*  980 */     super("Until Call Thread");
/*  981 */     setPriority(1);
/*  982 */     this.virgo = paramVirgo;
/*      */   }
/*      */ 
/*      */   public void run()
/*      */   {
/*  990 */     if (this.virgo.virgoState.endOfCodeReached)
/*      */     {
/*  992 */       this.virgo.mainWindow.showDialog("Hey!", "End of code is already reached.");
/*  993 */       return;
/*      */     }
/*      */ 
/*  996 */     this.virgo.setWindowsBusy(true);
/*      */ 
/* 1001 */     this.virgo.virgoState.virgoIsRunning = true;
/*      */ 
/* 1003 */     this.virgo.mainWindow.setNormalComponentsEnabled(false);
/*      */ 
/* 1007 */     this.virgo.breakpoints.readyToRun();
/* 1008 */     StopPoint localStopPoint = null;
/* 1009 */     int i = this.virgo.machine.getRegister(8);
/*      */     int k;
/* 1019 */     while ((this.virgo.virgoState.virgoIsRunning & localStopPoint == null & (this.virgo.virgoState.endOfCodeReached ^ true)))
/*      */     {
/* 1024 */       if (!this.virgo.code.isValidStartAddress(this.virgo.machine.getRegister(8)))
/*      */       {
/* 1026 */         localStopPoint = new StopPoint(3, "");
/* 1027 */         break;
/*      */       }
/*      */ 
/* 1032 */       i = this.virgo.machine.getRegister(8);
/*      */ 
/* 1036 */       k = this.virgo.code.convertStartAddressToCodeLine(this.virgo.machine.getRegister(8));
/* 1037 */       int j = this.virgo.code.instructionNestingInfo[k];
/*      */ 
/* 1040 */       if ((j == 1) || (j == 2))
/*      */       {
/* 1042 */         localStopPoint = null;
/* 1043 */         break;
/*      */       }
/*      */ 
/* 1049 */       localStopPoint = this.virgo.machine.doInstruction();
/*      */ 
/* 1052 */       if ((this.virgo.virgoState.breakpointsEnabled) && (this.virgo.breakpoints.shouldBreak()))
/*      */       {
/* 1054 */         localStopPoint = new StopPoint(4, this.virgo.breakpoints.getMessage());
/* 1055 */         break;
/*      */       }
/*      */ 
/*      */     }
/*      */ 
/* 1061 */     if (localStopPoint != null)
/*      */     {
/* 1066 */       if (this.virgo.code.isValidStartAddress(this.virgo.machine.getRegister(8)))
/*      */       {
/* 1068 */         k = this.virgo.code.convertStartAddressToCodeLine(this.virgo.machine.getRegister(8));
/* 1069 */         this.virgo.codeWindow.setCurrentCodeLine(k);
/*      */       }
/*      */       else
/*      */       {
/* 1076 */         k = this.virgo.code.convertStartAddressToCodeLine(i);
/*      */ 
/* 1078 */         this.virgo.codeWindow.setCurrentCodeLine(k);
/*      */       }
/*      */ 
/* 1082 */       this.virgo.mainWindow.showDialog("Execution Stopped", localStopPoint.toString());
/*      */     }
/* 1086 */     else if (this.virgo.virgoState.endOfCodeReached)
/*      */     {
/* 1089 */       k = this.virgo.code.convertStartAddressToCodeLine(i);
/* 1090 */       this.virgo.codeWindow.setCurrentCodeLine(k);
/* 1091 */       this.virgo.mainWindow.showDialog("Finally!", "End of code is reached.");
/*      */     }
/* 1099 */     else if (this.virgo.code.isValidStartAddress(this.virgo.machine.getRegister(8)))
/*      */     {
/* 1101 */       k = this.virgo.code.convertStartAddressToCodeLine(this.virgo.machine.getRegister(8));
/* 1102 */       this.virgo.codeWindow.setCurrentCodeLine(k);
/*      */     }
/*      */     else
/*      */     {
/* 1108 */       k = this.virgo.code.convertStartAddressToCodeLine(i);
/* 1109 */       this.virgo.codeWindow.setCurrentCodeLine(k);
/*      */     }
/*      */ 
/* 1113 */     this.virgo.mainWindow.setNormalComponentsEnabled(true);
/*      */ 
/* 1116 */     this.virgo.virgoState.virgoIsRunning = false;
/*      */ 
/* 1119 */     if (!this.virgo.virgoState.updateGUIWhileRunning)
/*      */     {
/* 1121 */       this.virgo.registerPortWindow.update();
/* 1122 */       this.virgo.watches.update();
/* 1123 */       this.virgo.watchesWindow.update();
/*      */     }
/*      */ 
/* 1127 */     this.virgo.setWindowsBusy(false);
/*      */   }
/*      */ }

/* Location:           C:\Users\daishi\Downloads\virgo213\virgo213_2006\
 * Qualified Name:     UntilCallThread
 * JD-Core Version:    0.6.2
 */