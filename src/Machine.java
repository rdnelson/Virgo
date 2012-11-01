/*     */ import java.io.PrintStream;
/*     */ 
/*     */ public class Machine
/*     */   implements Constants
/*     */ {
/*     */   private final boolean useExtendedFlags;
/*     */   Virgo virgo;
/*     */   MemoryState memory;
/*     */   ProcessorState processor;
/*     */   DeviceState devices;
/*     */   JumpTable jumpTable;
/*     */   AddressModeDecoder addressModeDecoder;
/*     */   InstructionSet instructionSet;
/*     */   int[] address;
/*     */   int[][] instrData;
/*     */   int[] addrModeData;
/*     */   boolean segmentOverride;
/*     */   boolean debuggingEnabled;
/*     */ 
/*     */   Machine(Virgo paramVirgo)
/*     */   {
/*  68 */     this.virgo = paramVirgo;
/*     */ 
/*  70 */     this.useExtendedFlags = paramVirgo.virgoState.useExtendedFlags;
/*  71 */     this.debuggingEnabled = paramVirgo.virgoState.debuggingEnabled;
/*     */ 
/*  74 */     this.memory = new MemoryState();
/*     */ 
/*  77 */     this.processor = new ProcessorState(this.useExtendedFlags);
/*     */ 
/*  80 */     this.devices = new DeviceState();
/*     */ 
/*  82 */     this.addrModeData = new int[3];
/*  83 */     this.instrData = new int[3][4];
///*  84 */     this.instrData[0] = new int[4];
///*  85 */     this.instrData[1] = new int[4];
///*  86 */     this.instrData[2] = new int[1];
/*  87 */     this.address = new int[4];
/*     */ 
/*  90 */     this.addressModeDecoder = new AddressModeDecoder(this);
/*  91 */     this.instructionSet = new InstructionSet(this);
/*  92 */     this.jumpTable = new JumpTable(this);
/*  93 */     this.segmentOverride = false;
/*     */   }
/*     */ 
/*     */   public void clearFlag(int paramInt)
/*     */   {
/* 353 */     if (Library.isValidFlag(paramInt))
/* 354 */       this.processor.clearFlag(paramInt);
/*     */   }
/*     */ 
/*     */   public void clearFlagAndNotify(int paramInt)
/*     */   {
/* 377 */     if (Library.isValidFlag(paramInt))
/*     */     {
/* 379 */       this.processor.clearFlag(paramInt);
/* 380 */       this.virgo.registerHasChanged(this.processor.read(13), 13);
/*     */     }
/*     */   }
/*     */ 
/*     */   public synchronized boolean decrementCurrentTimerAndNotify()
/*     */   {
/* 292 */     boolean retVal = this.devices.decrementCurrentTimer();
/* 293 */     this.virgo.portHasChanged(20);
/* 294 */     this.virgo.portHasChanged(21);
			  return retVal;
/*     */   }
/*     */ 
/*     */   public StopPoint doInstruction()
/*     */   {
/* 437 */     int[] arrayOfInt = new int[7];
/* 438 */     return doInstruction(arrayOfInt);
/*     */   }
/*     */ 
/*     */   public StopPoint doInstruction(int[] paramArrayOfInt)
/*     */   {
/* 454 */     for (int i = 0; i < 3; i++) {
/* 455 */       for (int j = 0; j < this.instrData[i].length; j++) {
/* 456 */         this.instrData[i][j] = 0;
/*     */       }
/*     */     }
/* 459 */     for (int j = 0; j < 3; j++) {
/* 460 */       this.addrModeData[j] = 0;
/*     */     }
/*     */ 
/* 463 */     this.segmentOverride = false;
/*     */     int ds = this.processor.read16(5); this.instrData[1][1] = ds; this.instrData[0][1] = ds;
/*     */ 
/* 470 */     fetchBytes(paramArrayOfInt);
/*     */ 
/* 476 */     if (this.debuggingEnabled)
/*     */     {
/* 478 */       System.out.print("Machine.doInstruction: Instruction Bytes {");
/* 479 */       for (int k = 0; k < paramArrayOfInt.length; k++) {
/* 480 */         String str = Integer.toHexString(paramArrayOfInt[k]).toUpperCase();
/* 481 */         while (str.length() < 2) str = "0" + str;
/* 482 */         System.out.print(str);
/* 483 */         if (k != paramArrayOfInt.length - 1) System.out.print(",");
/*     */       }
/* 485 */       System.out.println("}");
/*     */     }
/*     */ 
/* 497 */     this.instrData[2][0] += 1;
/*     */ 
/* 499 */     StopPoint localStopPoint = this.jumpTable.executeInstruction(paramArrayOfInt, this.instrData, this.addrModeData);
/*     */ 
/* 503 */     if (localStopPoint != null) return localStopPoint;
/*     */ 
/* 507 */     if (this.segmentOverride)
/*     */     {
/* 509 */       incIPAndNotify(1);
/* 510 */       this.instrData[2][0] = 0;
/*     */ 
/* 515 */       fetchBytes(paramArrayOfInt);
/*     */ 
/* 521 */       this.instrData[2][0] += 1;
/*     */ 
/* 523 */       localStopPoint = this.jumpTable.executeInstruction(paramArrayOfInt, this.instrData, this.addrModeData);
/*     */ 
/* 527 */       if (localStopPoint != null) return localStopPoint;
/*     */ 
/* 530 */       this.segmentOverride = false;
/*     */     }
/*     */ 
/* 534 */     incIPAndNotify(this.instrData[2][0]);
/*     */ 
/* 540 */     return null;
/*     */   }
/*     */ 
/*     */   public void endOfCodeIsReached()
/*     */   {
/* 115 */     this.virgo.virgoState.endOfCodeReached = true;
/*     */   }
/*     */ 
/*     */   public void fetchBytes(int[] paramArrayOfInt)
/*     */   {
/* 545 */     if (this.virgo.virgoState.segmentsEnabled)
/* 546 */       this.address[1] = this.processor.read16(4);
/*     */     else
/* 548 */       this.address[1] = 0;
/* 549 */     this.address[0] = this.processor.read16(8);
/*     */ 
/* 551 */     int[] arrayOfInt = this.memory.readBlock(this.address, 7);
/* 552 */     for (int i = 0; i < 7; i++)
/* 553 */       paramArrayOfInt[i] = arrayOfInt[i];
/*     */   }
/*     */ 
/*     */   public synchronized int getCursorX()
/*     */   {
/* 280 */     return this.devices.screen.getCursorX();
/*     */   }
/*     */ 
/*     */   public synchronized int getCursorY()
/*     */   {
/* 285 */     return this.devices.screen.getCursorY();
/*     */   }
/*     */ 
/*     */   public boolean getFlag(int paramInt)
/*     */   {
/* 334 */     if (Library.isValidFlag(paramInt))
/* 335 */       return this.processor.readFlag(paramInt);
/* 336 */     return false;
/*     */   }
/*     */ 
/*     */   public int getMemoryByte(int paramInt)
/*     */   {
/* 131 */     return this.memory.read8(paramInt);
/*     */   }
/*     */ 
/*     */   public int getMemoryByte(int[] paramArrayOfInt)
/*     */   {
/* 136 */     return this.memory.read8(paramArrayOfInt[0]);
/*     */   }
/*     */ 
/*     */   public int getMemoryWord(int paramInt)
/*     */   {
/* 141 */     return this.memory.read16(paramInt);
/*     */   }
/*     */ 
/*     */   public int getMemoryWord(int[] paramArrayOfInt)
/*     */   {
/* 146 */     return this.memory.read16(paramArrayOfInt[0]);
/*     */   }
/*     */ 
/*     */   public synchronized int getPortByte(int paramInt)
/*     */   {
/* 215 */     return this.devices.getPortValue8(paramInt);
/*     */   }
/*     */ 
/*     */   public synchronized int getPortWord(int paramInt)
/*     */   {
/* 222 */     return this.devices.getPortValue16(paramInt);
/*     */   }
/*     */ 
/*     */   public int getRegister(int paramInt)
/*     */   {
/* 327 */     if (Library.isValidRegister(paramInt))
/* 328 */       return this.processor.read(paramInt);
/* 329 */     return -1;
/*     */   }
/*     */ 
/*     */   public synchronized String getScreenContents()
/*     */   {
/* 275 */     return this.devices.screen.getContents();
/*     */   }
/*     */ 
/*     */   public synchronized void handleKeyboardInput(char paramChar)
/*     */   {
/* 265 */     this.devices.writePort8(paramChar, 2);
/*     */ 
/* 268 */     this.devices.writePort8(this.devices.readPort8(1) | Constants.BITMASK[1], 1);
/*     */   }
/*     */ 
/*     */   public void incAndNotify(int paramInt1, int paramInt2)
/*     */   {
/* 386 */     this.processor.inc(paramInt1, paramInt2);
/* 387 */     this.virgo.registerHasChanged(this.processor.read(paramInt2), paramInt2);
/*     */   }
/*     */ 
/*     */   public void incCXAndNotify(int paramInt)
/*     */   {
/* 404 */     this.processor.incCX(paramInt);
/* 405 */     this.virgo.registerHasChanged(this.processor.read(2), 2);
/*     */   }
/*     */ 
/*     */   public void incDIAndNotify(int paramInt)
/*     */   {
/* 416 */     this.processor.incDI(paramInt);
/* 417 */     this.virgo.registerHasChanged(this.processor.read(12), 12);
/*     */   }
/*     */ 
/*     */   public void incIPAndNotify(int paramInt)
/*     */   {
/* 392 */     this.processor.incIP(paramInt);
/* 393 */     this.virgo.registerHasChanged(this.processor.read(8), 8);
/*     */   }
/*     */ 
/*     */   public void incSIAndNotify(int paramInt)
/*     */   {
/* 410 */     this.processor.incSI(paramInt);
/* 411 */     this.virgo.registerHasChanged(this.processor.read(11), 11);
/*     */   }
/*     */ 
/*     */   public void incSPAndNotify(int paramInt)
/*     */   {
/* 398 */     this.processor.incSP(paramInt);
/* 399 */     this.virgo.registerHasChanged(this.processor.read(9), 9);
/*     */   }
/*     */ 
/*     */   public synchronized int readPortByteAndNotify(int paramInt)
/*     */   {
/* 231 */     int i = this.devices.readPort8(paramInt);
/* 232 */     this.virgo.portHasChanged(paramInt);
/* 233 */     return i;
/*     */   }
/*     */ 
/*     */   public synchronized int readPortWordAndNotify(int paramInt)
/*     */   {
/* 242 */     int i = this.devices.readPort16(paramInt);
/* 243 */     this.virgo.portHasChanged(paramInt);
/* 244 */     return i;
/*     */   }
/*     */ 
/*     */   public void reset()
/*     */   {
/* 104 */     this.processor.clear();
/* 105 */     this.memory.clear();
/* 106 */     this.devices.reset();
/* 107 */     this.segmentOverride = false;
/* 108 */     this.virgo.virgoState.endOfCodeReached = false;
/*     */   }
/*     */ 
/*     */   public void resetMemory()
/*     */   {
/* 125 */     this.memory.clear();
/*     */   }
/*     */ 
/*     */   public void setFlag(int paramInt)
/*     */   {
/* 347 */     if (Library.isValidFlag(paramInt))
/* 348 */       this.processor.setFlag(paramInt);
/*     */   }
/*     */ 
/*     */   public void setFlagAndNotify(int paramInt)
/*     */   {
/* 368 */     if (Library.isValidFlag(paramInt))
/*     */     {
/* 370 */       this.processor.setFlag(paramInt);
/* 371 */       this.virgo.registerHasChanged(this.processor.read(13), 13);
/*     */     }
/*     */   }
/*     */ 
/*     */   public void setMemoryByte(int paramInt1, int paramInt2)
/*     */   {
/* 155 */     this.memory.write8(paramInt1, paramInt2);
/*     */   }
/*     */ 
/*     */   public void setMemoryByteAndNotify(int paramInt1, int paramInt2)
/*     */   {
/* 164 */     this.memory.write8(paramInt1, paramInt2);
/*     */ 
/* 166 */     this.virgo.memoryCellHasChanged(paramInt1, paramInt2);
/*     */   }
/*     */ 
/*     */   public void setMemoryByteAndNotify(int paramInt, int[] paramArrayOfInt)
/*     */   {
/* 173 */     this.memory.write8(paramInt, paramArrayOfInt[0]);
/*     */ 
/* 175 */     this.virgo.memoryCellHasChanged(paramInt, paramArrayOfInt[0]);
/*     */   }
/*     */ 
/*     */   public void setMemoryWordAndNotify(int paramInt1, int paramInt2)
/*     */   {
/* 182 */     this.memory.write16(paramInt1, paramInt2);
/*     */ 
/* 184 */     this.virgo.memoryCellHasChanged(paramInt1 & 0xFF, paramInt2);
/* 185 */     this.virgo.memoryCellHasChanged((paramInt1 & 0xFF00) >> 8, paramInt2 + 1);
/*     */   }
/*     */ 
/*     */   public void setMemoryWordAndNotify(int paramInt, int[] paramArrayOfInt)
/*     */   {
/* 192 */     this.memory.write16(paramInt, paramArrayOfInt[0]);
/*     */ 
/* 194 */     this.virgo.memoryCellHasChanged(paramInt & 0xFF, paramArrayOfInt[0]);
/* 195 */     this.virgo.memoryCellHasChanged((paramInt & 0xFF00) >> 8, paramArrayOfInt[0] + 1);
/*     */   }
/*     */ 
/*     */   public synchronized void setPortByteAndNotify(int paramInt1, int paramInt2)
/*     */   {
/* 250 */     this.devices.writePort8(paramInt1, paramInt2);
/* 251 */     this.virgo.portHasChanged(paramInt2);
/*     */   }
/*     */ 
/*     */   public synchronized void setPortWordAndNotify(int paramInt1, int paramInt2)
/*     */   {
/* 256 */     this.devices.writePort16(paramInt1, paramInt2);
/* 257 */     this.virgo.portHasChanged(paramInt2);
/*     */   }
/*     */ 
/*     */   public void setRegister(int paramInt1, int paramInt2)
/*     */   {
/* 341 */     if (Library.isValidRegister(paramInt2))
/* 342 */       this.processor.write(paramInt1, paramInt2);
/*     */   }
/*     */ 
/*     */   public void setRegisterAndNotify(int paramInt1, int paramInt2)
/*     */   {
/* 359 */     if (Library.isValidRegister(paramInt2))
/*     */     {
/* 361 */       this.processor.write(paramInt1, paramInt2);
/* 362 */       this.virgo.registerHasChanged(paramInt1, paramInt2);
/*     */     }
/*     */   }
/*     */ 
/* MOD */   public boolean timeHasPassed(int paramInt)
/*     */   {
/* 301 */     if (this.devices.timerIsOn)
/*     */     {
/* 304 */       this.devices.elapsedTime += paramInt;
/*     */ 
/* 307 */       if (this.devices.elapsedTime >= 1000)
/*     */       {
/* 310 */         this.devices.elapsedTime = 0;
/*     */ 
/* 313 */         return decrementCurrentTimerAndNotify();
/*     */       }
/*     */     }
/* NEW */     return false;
/*     */   }
/*     */ 
/*     */   public void writeInstructionsIntoMemory(int[][] paramArrayOfInt, int[] paramArrayOfInt1)
/*     */   {
/* 203 */     this.memory.writeInstructions(paramArrayOfInt, paramArrayOfInt1);
/*     */   }
/*     */ }

/* Location:           C:\Users\daishi\Downloads\virgo213\virgo213_2006\
 * Qualified Name:     Machine
 * JD-Core Version:    0.6.2
 */