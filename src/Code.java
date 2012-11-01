/*     */ import java.io.PrintStream;
/*     */ 
/*     */ public class Code
/*     */ {
/*     */   String[] source;
/*     */   String[] labels;
/*     */   int[][] instructions;
/*     */   int[] startAddresses;
/*     */   int[] instructionLengths;
/*     */   int[] instructionNestingInfo;
/*     */   int[] instructionTimingInfo;
/*     */   int numberOfLines;
/*     */   String[] dataLabels;
/*     */   int[] dataLabelAddresses;
/*     */   int[] dataLabelTypes;
/*     */   int startCodeLine;
/*     */   int startAddress;
/*     */ 
/*     */   public int convertStartAddressToCodeLine(int paramInt)
/*     */   {
/*  94 */     for (int i = 0; i < this.numberOfLines; i++)
/*     */     {
/*  96 */       if (this.startAddresses[i] == paramInt) return i;
/*     */     }
/*  98 */     return -1;
/*     */   }
/*     */ 
/*     */   public int[] getDataLabelAddresses()
/*     */   {
/*  81 */     return this.dataLabelAddresses;
/*     */   }
/*     */ 
/*     */   public int[] getDataLabelTypes()
/*     */   {
/*  86 */     return this.dataLabelTypes;
/*     */   }
/*     */ 
/*     */   public String[] getDataLabels()
/*     */   {
/*  76 */     return this.dataLabels;
/*     */   }
/*     */ 
/*     */   public String getLabel(int paramInt)
/*     */   {
/*  66 */     return this.labels[paramInt];
/*     */   }
/*     */ 
/*     */   public String getSource(int paramInt)
/*     */   {
/*  61 */     return this.source[paramInt];
/*     */   }
/*     */ 
/*     */   public int getStartAddress(int paramInt)
/*     */   {
/*  71 */     return this.startAddresses[paramInt];
/*     */   }
/*     */ 
/*     */   public boolean isValidStartAddress(int paramInt)
/*     */   {
/* 104 */     for (int i = 0; i < this.numberOfLines; i++)
/*     */     {
/* 106 */       if (this.startAddresses[i] == paramInt) return true;
/*     */     }
/* 108 */     return false;
/*     */   }
/*     */ 
/*     */   public int numberOfLines()
/*     */   {
/*  56 */     return this.numberOfLines;
/*     */   }
/*     */ 
/*     */   public void printCode()
/*     */   {
/* 113 */     System.out.println("Loaded instructions:");
/* 114 */     for (int i = 0; i < this.startAddresses.length; i++)
/*     */     {
/* 116 */       System.out.print(Library.toStringAddress(this.startAddresses[i]) + " " + this.instructionLengths[i] + " ");
/* 117 */       for (int j = 0; j < this.instructions[i].length; j++)
/*     */       {
/* 119 */         System.out.print(Library.toStringByte(this.instructions[i][j]) + ".");
/*     */       }
/*     */ 
/* 122 */       System.out.println(" " + this.instructionTimingInfo[i] + "millis");
/*     */     }
/*     */   }
/*     */ 
/*     */   public void resetCode(String[] paramArrayOfString1, String[] paramArrayOfString2, int[][] paramArrayOfInt, int[] paramArrayOfInt1, int[] paramArrayOfInt2, int[] paramArrayOfInt3, int[] paramArrayOfInt4, String[] paramArrayOfString3, int[] paramArrayOfInt5, int[] paramArrayOfInt6)
/*     */   {
/*  41 */     this.source = paramArrayOfString1;
/*  42 */     this.labels = paramArrayOfString2;
/*  43 */     this.instructions = paramArrayOfInt;
/*  44 */     this.startAddresses = paramArrayOfInt1;
/*  45 */     this.instructionLengths = paramArrayOfInt2;
/*  46 */     this.instructionNestingInfo = paramArrayOfInt3;
/*  47 */     this.instructionTimingInfo = paramArrayOfInt4;
/*  48 */     this.numberOfLines = paramArrayOfString1.length;
/*  49 */     this.dataLabels = paramArrayOfString3;
/*  50 */     this.dataLabelAddresses = paramArrayOfInt5;
/*  51 */     this.dataLabelTypes = paramArrayOfInt6;
/*     */   }
/*     */ }

/* Location:           C:\Users\daishi\Downloads\virgo213\virgo213_2006\
 * Qualified Name:     Code
 * JD-Core Version:    0.6.2
 */