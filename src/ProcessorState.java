/*     */ import java.io.PrintStream;
/*     */ 
/*     */ public class ProcessorState
/*     */   implements Constants
/*     */ {
/*  63 */   private int[] register = new int[14];
/*     */ 
/*     */   public ProcessorState(boolean paramBoolean)
/*     */   {
/*  70 */     Constants.FLAG_DEFINED[0] = true;
/*  71 */     Constants.FLAG_DEFINED[6] = true;
/*  72 */     Constants.FLAG_DEFINED[7] = true;
/*  73 */     Constants.FLAG_DEFINED[11] = true;
/*  74 */     Constants.FLAG_DEFINED[8] = false;
/*     */ 
/*  76 */     if (paramBoolean) {
/*  77 */       Constants.FLAG_DEFINED[2] = true;
/*  78 */       Constants.FLAG_DEFINED[4] = true;
/*  79 */       Constants.FLAG_DEFINED[9] = true;
/*  80 */       Constants.FLAG_DEFINED[10] = true;
/*     */     }
/*     */   }
/*     */ 
/*     */   public synchronized void clear()
/*     */   {
/* 423 */     for (int i = 0; i < this.register.length; i++)
/* 424 */       this.register[i] = 0;
/*     */   }
/*     */ 
/*     */   public void clearFlag(int paramInt)
/*     */   {
/* 151 */     this.register[13] &= (Constants.BITMASK[(paramInt & 0xF)] ^ 0xFFFFFFFF);
/*     */   }
/*     */ 
/*     */   public void inc(int paramInt1, int paramInt2)
/*     */   {
/* 389 */     if (paramInt2 <= 13)
/*     */     {
/* 391 */       this.register[paramInt2] += paramInt1;
/*     */ 
/* 394 */       this.register[paramInt2] &= 65535;
/*     */     }
/*     */     else
/*     */     {
/* 398 */       int i = (short)(paramInt2 % 10);
/*     */ 
/* 400 */       int j = (short)(paramInt2 / 10);
/*     */ 
/* 402 */       if (j == 2) {
/* 403 */         this.register[i] = ((this.register[i] & 0xFF) + paramInt1 & 255 + (
/* 404 */           this.register[i] & 0xFF00));
/*     */       }
/* 409 */       else if (j == 3)
/* 410 */         this.register[i] = 
/* 411 */           (((((this.register[i] & 0xFF00) >> 8) + paramInt1 & 0xFF) << 8) + (
/* 412 */           this.register[i] & 0xFF));
/*     */     }
/*     */   }
/*     */ 
/*     */   public void incCX(int paramInt)
/*     */   {
/* 340 */     this.register[2] += paramInt;
/*     */ 
/* 343 */     this.register[2] &= 65535;
/*     */   }
/*     */ 
/*     */   public void incDI(int paramInt)
/*     */   {
/* 370 */     this.register[12] += paramInt;
/*     */ 
/* 373 */     this.register[12] &= 65535;
/*     */   }
/*     */ 
/*     */   public void incIP(int paramInt)
/*     */   {
/* 311 */     this.register[8] += paramInt;
/*     */ 
/* 314 */     this.register[8] &= 65535;
/*     */   }
/*     */ 
/*     */   public void incSI(int paramInt)
/*     */   {
/* 355 */     this.register[11] += paramInt;
/*     */ 
/* 358 */     this.register[11] &= 65535;
/*     */   }
/*     */ 
/*     */   public void incSP(int paramInt)
/*     */   {
/* 325 */     this.register[9] += paramInt;
/*     */ 
/* 328 */     this.register[9] &= 65535;
/*     */   }
/*     */ 
/*     */   public void printState()
/*     */   {
/* 433 */     System.out.println("REGISTERS:");
/* 434 */     System.out.println("AX:" + Library.toStringAddress(read(0)) + " BX:" + Library.toStringAddress(read(1)) + " CX:" + Library.toStringAddress(read(2)) + " DX:" + Library.toStringAddress(read(3)));
/* 435 */     System.out.println("AH:" + Library.toStringAddress(read(30)) + " BH:" + Library.toStringAddress(read(31)) + " CH:" + Library.toStringAddress(read(32)) + " DH:" + Library.toStringAddress(read(33)));
/* 436 */     System.out.println("AL:" + Library.toStringAddress(read(20)) + " BL:" + Library.toStringAddress(read(21)) + " CL:" + Library.toStringAddress(read(22)) + " DL:" + Library.toStringAddress(read(23)));
/* 437 */     System.out.println("CS:" + Library.toStringAddress(read(4)) + " DS:" + Library.toStringAddress(read(5)) + " SS:" + Library.toStringAddress(read(6)) + " ES:" + Library.toStringAddress(read(7)));
/* 438 */     System.out.println("IP:" + Library.toStringAddress(read(8)) + " SP:" + Library.toStringAddress(read(9)) + " BP:" + Library.toStringAddress(read(10)) + " SI:" + Library.toStringAddress(read(11)));
/* 439 */     System.out.print("DI:" + Library.toStringAddress(read(12)) + " Flags:" + Library.toStringAddress(read(13)) + " or:");
/* 440 */     for (int i = 15; i >= 0; i--) {
/* 441 */       if (readFlag(i)) System.out.print("1"); else
/* 442 */         System.out.print("0");
/*     */     }
/* 444 */     System.out.println("");
/* 445 */     System.out.println("");
/*     */   }
/*     */ 
/*     */   public int read(int paramInt)
/*     */   {
/* 244 */     if ((paramInt >= 0) && (paramInt <= 13)) {
/* 245 */       return read16(paramInt);
/*     */     }
/* 247 */     return read8(paramInt);
/*     */   }
/*     */ 
/*     */   public int read16(int paramInt)
/*     */   {
/* 283 */     return this.register[paramInt];
/*     */   }
/*     */ 
/*     */   public int[] read16All()
/*     */   {
/* 294 */     int[] arrayOfInt = { this.register[0], this.register[1], this.register[2], this.register[3], 
/* 295 */       this.register[4], this.register[5], this.register[6], this.register[7], 
/* 296 */       this.register[8], this.register[9], this.register[10], 
/* 297 */       this.register[11], this.register[12], this.register[13] };
/*     */ 
/* 299 */     return arrayOfInt;
/*     */   }
/*     */ 
/*     */   public int read8(int paramInt)
/*     */   {
/* 260 */     int i = (short)(paramInt % 10);
/* 261 */     int j = (short)(paramInt / 10);
/*     */ 
/* 263 */     if (j == 2) {
/* 264 */       return this.register[i] & 0xFF;
/*     */     }
/*     */ 
/* 267 */     if (j == 3) {
/* 268 */       return (this.register[i] & 0xFF00) >> 8;
/*     */     }
/*     */ 
/* 271 */     return 0;
/*     */   }
/*     */ 
/*     */   public boolean readFlag(int paramInt)
/*     */   {
/* 163 */     return (this.register[13] & Constants.BITMASK[(paramInt & 0xF)]) != 0;
/*     */   }
/*     */ 
/*     */   public void setFlag(int paramInt)
/*     */   {
/* 140 */     this.register[13] |= Constants.BITMASK[(paramInt & 0xF)];
/*     */   }
/*     */ 
/*     */   public void write(int paramInt1, int paramInt2)
/*     */   {
/* 177 */     if ((paramInt2 >= 0) && (paramInt2 <= 13))
/* 178 */       write16(paramInt1, paramInt2);
/*     */     else
/* 180 */       write8(paramInt1, paramInt2);
/*     */   }
/*     */ 
/*     */   public void write16(int paramInt1, int paramInt2)
/*     */   {
/* 229 */     this.register[paramInt2] = (paramInt1 & 0xFFFF);
/*     */   }
/*     */ 
/*     */   public void write8(int paramInt1, int paramInt2)
/*     */   {
/* 193 */     int i = (short)(paramInt2 % 10);
/*     */ 
/* 195 */     int j = (short)(paramInt2 / 10);
/*     */ 
/* 197 */     int k = this.register[i];
/* 198 */     int m = 0;
/*     */ 
/* 201 */     if (j == 2) {
/* 202 */       m = (paramInt1 & 0xFF) + (k & 0xFF00);
/*     */     }
/* 207 */     else if (j == 3) {
/* 208 */       m = ((paramInt1 & 0xFF) << 8) + (k & 0xFF);
/*     */     }
/*     */ 
/* 215 */     this.register[i] = m;
/*     */   }
/*     */ }

/* Location:           C:\Users\daishi\Downloads\virgo213\virgo213_2006\
 * Qualified Name:     ProcessorState
 * JD-Core Version:    0.6.2
 */