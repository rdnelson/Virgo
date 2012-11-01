/*    */ public class StopPoint
/*    */   implements Constants
/*    */ {
/*    */   private String message;
/*    */   int type;
/*    */ 
/*    */   StopPoint()
/*    */   {
/*    */   }
/*    */ 
/*    */   StopPoint(int paramInt, String paramString)
/*    */   {
/* 37 */     this.type = paramInt;
/* 38 */     this.message = paramString;
/*    */   }
/*    */   public int getType() {
/* 41 */     return this.type;
/*    */   }
/*    */ 
/*    */   public String toString() {
/* 45 */     if (this.type == 0) return "The first byte in the instruction does not confirm to any known instruction";
/* 46 */     if (this.type == 2) return "Instruction contains an invalid address mode";
/* 47 */     if (this.type == 3) return "Instruction set IP to a location that is NOT the start of an instruction";
/* 48 */     if (this.type == 5) return "Attempt to divide by zero";
/* 49 */     if (this.type == 4) return "Breakpoint: " + this.message;
/* 50 */     return new String(this.message);
/*    */   }
/*    */ }

/* Location:           C:\Users\daishi\Downloads\virgo213\virgo213_2006\
 * Qualified Name:     StopPoint
 * JD-Core Version:    0.6.2
 */