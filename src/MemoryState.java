/*     */ import java.io.PrintStream;
/*     */ 
/*     */ public class MemoryState
/*     */   implements Constants
/*     */ {
/*     */   private byte[] memory;
/*     */ 
/*     */   MemoryState()
/*     */   {
/*  63 */     this(255);
/*     */   }
/*     */ 
/*     */   MemoryState(int paramInt)
/*     */   {
/*  70 */     this.memory = new byte[65536];
/*  71 */     initialize(paramInt);
/*     */   }
/*     */ 
/*     */   public synchronized void clear()
/*     */   {
/* 323 */     initialize(255);
/*     */   }
/*     */ 
/*     */   public void displayMemoryContents(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
/*     */   {
/* 300 */     int i = 0;
/* 301 */     int[] arrayOfInt = new int[3];
/* 302 */     arrayOfInt[0] = 0;
/* 303 */     System.out.println("SEGMENT: " + paramArrayOfInt1[1]);
/* 304 */     arrayOfInt[0] = paramArrayOfInt1[0];
/* 305 */     for (; arrayOfInt[0] <= paramArrayOfInt2[0]; 
/* 306 */       arrayOfInt[0] += 1) {
/* 307 */       System.out.print(arrayOfInt[0] + ": " + read8(arrayOfInt) + "\t");
/* 308 */       i++;
/* 309 */       if (i % 5 == 0) System.out.println("");
/*     */     }
/* 311 */     System.out.println("");
/* 312 */     System.out.println("");
/*     */   }
/*     */ 
/*     */   public void initialize(int paramInt)
/*     */   {
/* 317 */     for (int i = 0; i < 65536; i++)
/* 318 */       this.memory[i] = ((byte)((paramInt & 0xFF) - 128));
/*     */   }
/*     */ 
/*     */   public int read16(int paramInt)
/*     */   {
/* 232 */     int[] arrayOfInt = new int[2];
/* 233 */     arrayOfInt[0] = paramInt;
/* 234 */     arrayOfInt[1] = 0;
/* 235 */     return read16(arrayOfInt);
/*     */   }
/*     */ 
/*     */   public int read16(int[] paramArrayOfInt)
/*     */   {
/* 250 */     return 
/* 251 */       (this.memory[
/* 251 */       ((paramArrayOfInt[0] + 1 & 0xFFFF) + (
/* 251 */       (paramArrayOfInt[1] & 0xFFFF) << 4) & 0xFFFF)] + 128 << 8) + (
/* 252 */       this.memory[
/* 253 */       ((paramArrayOfInt[0] & 0xFFFF) + (
/* 253 */       (paramArrayOfInt[1] & 0xFFFF) << 4) & 0xFFFF)] + 128);
/*     */   }
/*     */ 
/*     */   public int read8(int paramInt)
/*     */   {
/* 204 */     int[] arrayOfInt = new int[2];
/* 205 */     arrayOfInt[0] = paramInt;
/* 206 */     arrayOfInt[1] = 0;
/* 207 */     return read8(arrayOfInt);
/*     */   }
/*     */ 
/*     */   public int read8(int[] paramArrayOfInt)
/*     */   {
/* 220 */     return this.memory[
/* 221 */       ((paramArrayOfInt[0] & 0xFFFF) + (
/* 221 */       (paramArrayOfInt[1] & 0xFFFF) << 4) & 0xFFFF)] + 128;
/*     */   }
/*     */ 
/*     */   public int[] readBlock(int[] paramArrayOfInt, int paramInt)
/*     */   {
/* 279 */     int[] arrayOfInt = new int[paramInt];
/* 280 */     for (int i = 0; i < paramInt; i++) {
/* 281 */       arrayOfInt[i] = 
/* 283 */         (this.memory[
/* 283 */         ((paramArrayOfInt[0] & 0xFFFF) + (
/* 282 */         (paramArrayOfInt[1] & 0xFFFF) << 4) + i & 
/* 283 */         0xFFFF)] + 128);
/*     */     }
/*     */ 
/* 293 */     return arrayOfInt;
/*     */   }
/*     */ 
/*     */   public void write16(int paramInt1, int paramInt2)
/*     */   {
/* 102 */     int[] arrayOfInt = new int[2];
/* 103 */     arrayOfInt[0] = paramInt2;
/* 104 */     arrayOfInt[1] = 0;
/* 105 */     write16(paramInt1, arrayOfInt);
/*     */   }
/*     */ 
/*     */   public void write16(int paramInt, int[] paramArrayOfInt)
/*     */   {
/* 120 */     int i = (paramArrayOfInt[0] & 0xFFFF) + ((paramArrayOfInt[1] & 0xFFFF) << 4) & 0xFFFF;
/* 121 */     int j = (paramArrayOfInt[0] + 1 & 0xFFFF) + ((paramArrayOfInt[1] & 0xFFFF) << 4) & 0xFFFF;
/* 122 */     int k = paramInt & 0xFF;
/* 123 */     int m = (paramInt & 0xFF00) >> 8;
/*     */ 
/* 126 */     this.memory[i] = ((byte)(k - 128));
/*     */ 
/* 129 */     this.memory[j] = ((byte)(m - 128));
/*     */   }
/*     */ 
/*     */   public void write8(int paramInt1, int paramInt2)
/*     */   {
/*  78 */     int[] arrayOfInt = new int[2];
/*  79 */     arrayOfInt[0] = paramInt2;
/*  80 */     arrayOfInt[1] = 0;
/*  81 */     write8(paramInt1, arrayOfInt);
/*     */   }
/*     */ 
/*     */   public void write8(int paramInt, int[] paramArrayOfInt)
/*     */   {
/*  93 */     int i = (paramArrayOfInt[0] & 0xFFFF) + ((paramArrayOfInt[1] & 0xFFFF) << 4) & 0xFFFF;
/*  94 */     paramInt &= 255;
/*     */ 
/*  96 */     this.memory[i] = ((byte)(paramInt - 128));
/*     */   }
/*     */ 
/*     */   public void writeArray(int[] paramArrayOfInt1, int[] paramArrayOfInt2, int[] paramArrayOfInt3)
/*     */   {
/* 152 */     int i = 0;
/* 153 */     for (int j = 0; j < paramArrayOfInt2.length; j++)
/* 154 */       for (int k = 0; k < paramArrayOfInt3[j]; k++) {
/* 155 */         int m = paramArrayOfInt1[i];
/* 156 */         int n = paramArrayOfInt2[j] + k;
/* 157 */         this.memory[(n & 0xFFFF & 0xFFFF)] = ((byte)((m & 0xFF) - 128));
/* 158 */         i++;
/*     */       }
/*     */   }
/*     */ 
/*     */   public void writeBlock(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
/*     */   {
/* 192 */     int[] arrayOfInt = new int[paramArrayOfInt1.length];
/*     */ 
/* 194 */     for (int i = 0; i < paramArrayOfInt1.length; i++)
/* 195 */       this.memory[((paramArrayOfInt2[0] & 0xFFFF) + ((paramArrayOfInt2[1] & 0xFFFF) << 4) + i & 0xFFFF)] = 
/* 196 */         ((byte)((paramArrayOfInt1[i] & 0xFF) - 128));
/*     */   }
/*     */ 
/*     */   public void writeInstructions(int[][] paramArrayOfInt, int[] paramArrayOfInt1)
/*     */   {
/* 166 */     for (int i = 0; i < paramArrayOfInt1.length; i++)
/* 167 */       for (int j = 0; j < paramArrayOfInt[i].length; j++) {
/* 168 */         int k = paramArrayOfInt[i][j];
/* 169 */         int m = paramArrayOfInt1[i] + j;
/* 170 */         this.memory[(m & 0xFFFF & 0xFFFF)] = ((byte)((k & 0xFF) - 128));
/*     */       }
/*     */   }
/*     */ }

/* Location:           C:\Users\daishi\Downloads\virgo213\virgo213_2006\
 * Qualified Name:     MemoryState
 * JD-Core Version:    0.6.2
 */