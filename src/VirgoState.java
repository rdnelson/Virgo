/*    */ class VirgoState
/*    */ {
/* 52 */   boolean breakpointsEnabled = true;
/*    */   boolean breakpointsWindowVisible;
/*    */   boolean watchesWindowVisible;
/*    */   boolean codeWindowVisible;
/*    */   boolean registerPortWindowVisible;
/* 31 */   boolean memoryWindowEnabled = false;
/*    */ 
/* 53 */   boolean useExtendedFlags = false;
/*    */ 
/* 55 */   boolean endOfCodeReached = false;
/* 56 */   boolean segmentsEnabled = false;
/*    */ 
/* 59 */   boolean updateGUIWhileRunning = true;
/*    */ 
/* 54 */   String lastPath = System.getProperty("user.dir");
/*    */ 
/* 57 */   boolean virgoIsRunning = false;
/*    */ 
/* 46 */   boolean debuggingEnabled = false;
/*    */ }

/* Location:           C:\Users\daishi\Downloads\virgo213\virgo213_2006\
 * Qualified Name:     VirgoState
 * JD-Core Version:    0.6.2
 */