/*      */ class UntilCursorThread extends Thread
/*      */   implements Constants
/*      */ {
/*      */   Virgo virgo;
/*      */ 
/*      */   UntilCursorThread(Virgo paramVirgo)
/*      */   {
/* 1141 */     super("Until Cursor Thread");
/* 1142 */     setPriority(1);
/* 1143 */     this.virgo = paramVirgo;
/*      */   }
/*      */ 
/*      */   public void run()
/*      */   {
/* 1151 */     if (this.virgo.virgoState.endOfCodeReached)
/*      */     {
/* 1153 */       this.virgo.mainWindow.showDialog("Hey!", "End of code is already reached.");
/* 1154 */       return;
/*      */     }
/*      */ 
/* 1157 */     this.virgo.setWindowsBusy(true);
/*      */ 
/* 1162 */     this.virgo.virgoState.virgoIsRunning = true;
/*      */ 
/* 1164 */     this.virgo.mainWindow.setNormalComponentsEnabled(false);
/*      */ 
/* 1168 */     this.virgo.breakpoints.readyToRun();
/* 1169 */     StopPoint localStopPoint = null;
/* 1170 */     int i = this.virgo.machine.getRegister(8);
/*      */ 
/* 1174 */     int j = this.virgo.codeWindow.getSelectedCodeLine();
/*      */     int k;
/* 1184 */     while ((this.virgo.virgoState.virgoIsRunning & localStopPoint == null & (this.virgo.virgoState.endOfCodeReached ^ true)))
/*      */     {
/* 1189 */       if (!this.virgo.code.isValidStartAddress(this.virgo.machine.getRegister(8)))
/*      */       {
/* 1191 */         localStopPoint = new StopPoint(3, "");
/* 1192 */         break;
/*      */       }
/*      */ 
/* 1197 */       i = this.virgo.machine.getRegister(8);
/*      */ 
/* 1201 */       k = this.virgo.code.convertStartAddressToCodeLine(this.virgo.machine.getRegister(8));
/*      */ 
/* 1205 */       if (k == j)
/*      */       {
/* 1207 */         localStopPoint = null;
/* 1208 */         break;
/*      */       }
/*      */ 
/* 1214 */       localStopPoint = this.virgo.machine.doInstruction();
/*      */ 
/* 1217 */       if ((this.virgo.virgoState.breakpointsEnabled) && (this.virgo.breakpoints.shouldBreak()))
/*      */       {
/* 1219 */         localStopPoint = new StopPoint(4, this.virgo.breakpoints.getMessage());
/* 1220 */         break;
/*      */       }
/*      */ 
/*      */     }
/*      */ 
/* 1226 */     if (localStopPoint != null)
/*      */     {
/* 1231 */       if (this.virgo.code.isValidStartAddress(this.virgo.machine.getRegister(8)))
/*      */       {
/* 1233 */         k = this.virgo.code.convertStartAddressToCodeLine(this.virgo.machine.getRegister(8));
/* 1234 */         this.virgo.codeWindow.setCurrentCodeLine(k);
/*      */       }
/*      */       else
/*      */       {
/* 1241 */         k = this.virgo.code.convertStartAddressToCodeLine(i);
/*      */ 
/* 1243 */         this.virgo.codeWindow.setCurrentCodeLine(k);
/*      */       }
/*      */ 
/* 1247 */       this.virgo.mainWindow.showDialog("Execution Stopped", localStopPoint.toString());
/*      */     }
/* 1251 */     else if (this.virgo.virgoState.endOfCodeReached)
/*      */     {
/* 1254 */       k = this.virgo.code.convertStartAddressToCodeLine(i);
/* 1255 */       this.virgo.codeWindow.setCurrentCodeLine(k);
/* 1256 */       this.virgo.mainWindow.showDialog("Finally!", "End of code is reached.");
/*      */     }
/* 1264 */     else if (this.virgo.code.isValidStartAddress(this.virgo.machine.getRegister(8)))
/*      */     {
/* 1266 */       k = this.virgo.code.convertStartAddressToCodeLine(this.virgo.machine.getRegister(8));
/* 1267 */       this.virgo.codeWindow.setCurrentCodeLine(k);
/*      */     }
/*      */     else
/*      */     {
/* 1273 */       k = this.virgo.code.convertStartAddressToCodeLine(i);
/* 1274 */       this.virgo.codeWindow.setCurrentCodeLine(k);
/*      */     }
/*      */ 
/* 1278 */     this.virgo.mainWindow.setNormalComponentsEnabled(true);
/*      */ 
/* 1281 */     this.virgo.virgoState.virgoIsRunning = false;
/*      */ 
/* 1284 */     if (!this.virgo.virgoState.updateGUIWhileRunning)
/*      */     {
/* 1286 */       this.virgo.registerPortWindow.update();
/* 1287 */       this.virgo.watches.update();
/* 1288 */       this.virgo.watchesWindow.update();
/*      */     }
/*      */ 
/* 1292 */     this.virgo.setWindowsBusy(false);
/*      */   }
/*      */ }

/* Location:           C:\Users\daishi\Downloads\virgo213\virgo213_2006\
 * Qualified Name:     UntilCursorThread
 * JD-Core Version:    0.6.2
 */