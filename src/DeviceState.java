/*     */ import java.io.PrintStream;
/*     */ 
/*     */ class DeviceState
/*     */   implements Constants
/*     */ {
/*     */   private int[] port;
/*     */   SimulatedScreen screen;
/*     */   public boolean timerIsOn;
/*     */   int elapsedTime;
/*     */ 
/*     */   DeviceState()
/*     */   {
/* 147 */     this.port = new int[5632];
/*     */ 
/* 151 */     this.screen = new SimulatedScreen(25, 40);
/*     */ 
/* 154 */     reset();
/*     */   }
/*     */ 
/* MOD */   public boolean decrementCurrentTimer()
/*     */   {
/* NEW */     boolean retVal = false;
/* 431 */     synchronized (this)
/*     */     {
/* 433 */       int i = this.port[20];
/* 434 */       int j = this.port[21];
/* 435 */       int k = this.port[17];
/* 436 */       i--;
/* 437 */       if ((i == 0) && (j == 0))
/*     */       {
/* 442 */         i = this.port[18];
/* 443 */         j = this.port[19];
/* 444 */         k |= Constants.BITMASK[1];
/* NEW */         retVal = true;
/*     */       }
/* 447 */       else if (i < 0) {
/* 448 */         i = 255;
/* 449 */         j--;
/*     */       }
/*     */ 
/* 453 */       this.port[20] = i;
/* 454 */       this.port[21] = j;
/* 455 */       this.port[17] = k;
/*     */     }
/* NEW */     return retVal;
/*     */   }
/*     */ 
/*     */   public void displayPortContents()
/*     */   {
/* 482 */     System.out.println("");
/* 483 */     System.out.println("Keyboard Control 0000: " + Library.toStringByte(getPortValue8(0)));
/* 484 */     System.out.println("Keyboard Status  0001: " + Library.toStringByte(getPortValue8(1)));
/* 485 */     System.out.println("Keyboard Data    0002: " + Library.toStringByte(getPortValue8(2)));
/* 486 */     System.out.println("Display Control: " + Library.toStringByte(getPortValue8(1256)));
/* 487 */     System.out.println("Display Data: " + Library.toStringByte(getPortValue8(1257)));
/* 488 */     System.out.println("Cursor X: " + Library.toStringByte(getPortValue8(1258)));
/* 489 */     System.out.println("Cursor Y: " + Library.toStringByte(getPortValue8(1259)));
/* 490 */     System.out.println("Timer Control: " + Library.toStringByte(getPortValue8(16)));
/* 491 */     System.out.println("Timer Status: " + Library.toStringByte(getPortValue8(17)));
/* 492 */     System.out.println("Timer Reload: " + Library.toStringWord(getPortValue16(18)));
/* 493 */     System.out.println("Timer Current: " + Library.toStringWord(getPortValue16(20)));
/* 494 */     System.out.println("");
/*     */   }
/*     */ 
/*     */   public int getPortValue16(int paramInt)
/*     */   {
/* 272 */     synchronized (this)
/*     */     {
/* 274 */       int j = paramInt % 5632;
/* 275 */       int k = (paramInt + 1) % 5632;
/*     */ 
/* 277 */       int m = getPortValue8(j);
/* 278 */       int n = getPortValue8(k);
/*     */ 
/* 280 */       n <<= 8;
/* 281 */       int i1 = n + m;
/*     */ 
/* 285 */       int i = i1; return i;
/*     */     }
/*     */   }
/*     */ 
/*     */   public int getPortValue8(int paramInt)
/*     */   {
/* 247 */     synchronized (this)
/*     */     {
/* 249 */       paramInt %= 5632;
/*     */ 
/* 251 */       int j = this.port[paramInt] & 0xFF;
/*     */ 
/* 254 */       if (paramInt == 1258)
/* 255 */         j = this.screen.getCursorX();
/* 256 */       else if (paramInt == 1259)
/* 257 */         j = this.screen.getCursorY();
/* 258 */       else if ((paramInt >= 256) && (paramInt <= 1255)) {
/* 259 */         j = this.screen.getValueAt(paramInt - 256);
/*     */       }
/*     */ 
/* 262 */       int i = j; return i;
/*     */     }
/*     */   }
/*     */ 
/*     */   public boolean isReadOnlyPort(int paramInt)
/*     */   {
/* 461 */     paramInt %= 5632;
/* 462 */     if ((paramInt != 1) && (paramInt != 2) && (paramInt != 17))
/* 463 */       return false;
/* 464 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean isWriteOnlyPort(int paramInt)
/*     */   {
/* 469 */     paramInt %= 5632;
/* 470 */     if ((paramInt != 0) && (paramInt != 1256) && (paramInt != 1257) && (paramInt != 16))
/* 471 */       return false;
/* 472 */     return true;
/*     */   }
/*     */ 
/*     */   public int readPort16(int paramInt)
/*     */   {
/* 224 */     synchronized (this)
/*     */     {
/* 226 */       int j = paramInt % 5632;
/* 227 */       int k = (paramInt + 1) % 5632;
/*     */ 
/* 229 */       int m = readPort8(j);
/* 230 */       int n = readPort8(k);
/*     */ 
/* 232 */       n <<= 8;
/* 233 */       int i1 = n + m;
/*     */ 
/* 237 */       int i = i1; return i;
/*     */     }
/*     */   }
/*     */ 
/*     */   public int readPort8(int paramInt)
/*     */   {
/* 192 */     synchronized (this)
/*     */     {
/* 194 */       paramInt %= 5632;
/*     */ 
/* 196 */       int j = this.port[paramInt] & 0xFF;
/*     */ 
/* 199 */       if (paramInt == 1258)
/* 200 */         j = this.screen.getCursorX();
/* 201 */       else if (paramInt == 1259)
/* 202 */         j = this.screen.getCursorY();
/* 203 */       else if ((paramInt >= 256) && (paramInt <= 1255)) {
/* 204 */         j = this.screen.getValueAt(paramInt - 256);
/*     */       }
/* 207 */       else if (paramInt == 2)
/*     */       {
/* 210 */         this.port[1] &= (Constants.BITMASK[1] ^ 0xFFFFFFFF);
/*     */       }
/*     */ 
/* 213 */       int i = j; return i;
/*     */     }
/*     */   }
/*     */ 
/*     */   public void reset()
/*     */   {
/* 160 */     for (int i = 0; i < this.port.length; i++) {
/* 161 */       this.port[i] = 0;
/*     */     }
/*     */ 
/* 164 */     this.port[18] = 255;
/* 165 */     this.port[19] = 255;
/* 166 */     this.port[20] = 255;
/* 167 */     this.port[21] = 255;
/* 168 */     this.port[17] = 0;
/*     */ 
/* 171 */     this.screen.reset();
/*     */ 
/* 174 */     this.timerIsOn = false;
/* 175 */     this.elapsedTime = 0;
/*     */   }
/*     */ 
/*     */   public void writePort16(int paramInt1, int paramInt2)
/*     */   {
/* 406 */     synchronized (this)
/*     */     {
/* 408 */       int i = paramInt2 % 5632;
/* 409 */       int j = (paramInt2 + 1) % 5632;
/*     */ 
/* 412 */       int k = paramInt1 & 0xFF;
/* 413 */       int m = (paramInt1 & 0xFF00) >> 8;
/*     */ 
/* 415 */       writePort8(k, i);
/* 416 */       writePort8(m, j);
/*     */     }
/*     */   }
/*     */ 
/*     */   public void writePort8(int paramInt1, int paramInt2)
/*     */   {
/* 298 */     synchronized (this)
/*     */     {
/* 300 */       paramInt2 %= 5632;
/* 301 */       paramInt1 &= 255;
/*     */ 
/* 304 */       if ((paramInt2 >= 256) && (paramInt2 <= 1255))
/*     */       {
/* 307 */         int i = paramInt2 - 256;
/*     */ 
/* 309 */         this.screen.setValueAt(paramInt1, i);
/*     */       }
/*     */       else
/*     */       {
/* 315 */         switch (paramInt2)
/*     */         {
/*     */         case 0:
/* 319 */           if ((paramInt1 & Constants.BITMASK[0]) != 0)
/* 320 */             this.port[1] |= Constants.BITMASK[0];
/*     */           else
/* 322 */             this.port[1] &= (Constants.BITMASK[0] ^ 0xFFFFFFFF);
/* 323 */           this.port[0] = 0;
/* 324 */           break;
/*     */         case 16:
/* 328 */           if ((paramInt1 & Constants.BITMASK[0]) != 0)
/* 329 */             this.port[17] |= Constants.BITMASK[0];
/* 330 */           else this.port[17] &= (Constants.BITMASK[0] ^ 0xFFFFFFFF);
/* 331 */           if ((paramInt1 & Constants.BITMASK[1]) != 0)
/* 332 */             this.port[17] &= (Constants.BITMASK[1] ^ 0xFFFFFFFF);
/* 333 */           switch ((paramInt1 & (Constants.BITMASK[3] | Constants.BITMASK[2])) >> 2)
/*     */           {
/*     */           case 1:
/* 337 */             this.port[17] |= Constants.BITMASK[2];
/* 338 */             writePort16(getPortValue16(18), 20);
/* 339 */             this.timerIsOn = true;
/* 340 */             this.elapsedTime = 0;
/* 341 */             break;
/*     */           case 2:
/* 343 */             this.port[17] &= (Constants.BITMASK[2] ^ 0xFFFFFFFF);
/* 344 */             this.timerIsOn = false;
/* 345 */             break;
/*     */           case 3:
/* 347 */             this.port[17] |= Constants.BITMASK[2];
/* 348 */             this.timerIsOn = true;
/* 349 */             this.elapsedTime = 0;
/* 350 */             break;
/*     */           case 0:
/*     */           }
/* 353 */           this.port[16] = 0;
/* 354 */           break;
/*     */         case 1256:
/* 358 */           if ((paramInt1 & Constants.BITMASK[0]) != 0)
/* 359 */             this.screen.reset();
/* 360 */           if ((paramInt1 & Constants.BITMASK[1]) != 0)
/*     */           {
/* 362 */             this.screen.setCursorX(0);
/* 363 */             this.screen.setCursorY(0);
/*     */           }
/* 365 */           if ((paramInt1 & Constants.BITMASK[2]) != 0)
/* 366 */             this.screen.putChar('\r');
/* 367 */           if ((paramInt1 & Constants.BITMASK[3]) != 0) {
/* 368 */             this.screen.putChar('\n');
/*     */           }
/* 370 */           this.port[1256] = 0;
/* 371 */           break;
/*     */         case 1257:
/* 374 */           this.screen.putChar((char)paramInt1);
/*     */ 
/* 377 */           break;
/*     */         case 1258:
/* 380 */           this.screen.setCursorX(paramInt1);
/*     */ 
/* 382 */           break;
/*     */         case 1259:
/* 385 */           this.screen.setCursorY(paramInt1);
/*     */ 
/* 387 */           break;
/*     */         default:
/* 392 */           this.port[paramInt2] = paramInt1;
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */ }

/* Location:           C:\Users\daishi\Downloads\virgo213\virgo213_2006\
 * Qualified Name:     DeviceState
 * JD-Core Version:    0.6.2
 */