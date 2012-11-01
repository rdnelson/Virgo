/*      */ import java.io.PrintStream;
/*      */ 
/*      */ public class InstructionSet
/*      */   implements Constants
/*      */ {
/*      */   Machine machine;
/*      */   int srcValue;
/*      */   int destValue;
/*   38 */   int[] location = new int[4];
/*      */   int result;
/*      */   int finalResult;
/*      */   long longResult;
/*      */   long longFinalResult;
/*      */   int numberOfOnes;
/*      */   boolean carry;
/*      */   boolean tempCarry;
/*      */ 
/*      */   public InstructionSet(Machine paramMachine)
/*      */   {
/*   49 */     this.machine = paramMachine;
/*      */   }
/*      */ 
/*      */   public StopPoint ADC16(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
/*      */   {
/*  180 */     if (this.machine.debuggingEnabled)
/*      */     {
/*  182 */       System.out.print("ADC16: Dest: ");
/*  183 */       for (int i = 0; i < paramArrayOfInt1.length; i++) System.out.print(paramArrayOfInt1[i] + " ");
/*  184 */       System.out.print("\tSrc: ");
/*  185 */       for (int j = 0; j < paramArrayOfInt2.length; j++) System.out.print(paramArrayOfInt2[j] + " ");
/*  186 */       System.out.println("");
/*      */     }
/*      */ 
/*  194 */     if (paramArrayOfInt2[3] == 2)
/*  195 */       this.srcValue = this.machine.getMemoryWord(paramArrayOfInt2);
/*  196 */     else if (paramArrayOfInt2[3] == 3)
/*  197 */       this.srcValue = paramArrayOfInt2[0];
/*      */     else
/*  199 */       this.srcValue = this.machine.getRegister(paramArrayOfInt2[2]);
/*  200 */     if (this.machine.getFlag(0)) this.srcValue += 1;
/*      */ 
/*  206 */     if (paramArrayOfInt1[3] == 2) {
/*  207 */       this.destValue = this.machine.getMemoryWord(paramArrayOfInt1);
/*  208 */       this.result = (this.srcValue + this.destValue);
/*  209 */       this.finalResult = (this.result & 0xFFFF);
/*  210 */       this.machine.setMemoryWordAndNotify(this.finalResult, paramArrayOfInt1);
/*      */     }
/*      */     else {
/*  213 */       if (paramArrayOfInt1[3] == 3) {
/*  214 */         return new StopPoint(1, "Immediate as destination in ADC16");
/*      */       }
/*      */ 
/*  218 */       this.destValue = this.machine.getRegister(paramArrayOfInt1[2]);
/*  219 */       this.result = (this.srcValue + this.destValue);
/*  220 */       this.finalResult = (this.result & 0xFFFF);
/*  221 */       this.machine.setRegisterAndNotify(this.finalResult, paramArrayOfInt1[2]);
/*      */     }
/*      */ 
/*  228 */     if (this.machine.debuggingEnabled) {
/*  229 */       System.out.println("SourceValue: " + this.srcValue + 
/*  230 */         " DestValue: " + this.destValue + 
/*  231 */         " Result: " + this.result + 
/*  232 */         " Final Result: " + this.finalResult);
/*      */     }
/*      */ 
/*  247 */     if (this.result != this.finalResult)
/*  248 */       this.machine.setFlagAndNotify(0);
/*      */     else {
/*  250 */       this.machine.clearFlagAndNotify(0);
/*      */     }
/*      */ 
/*  254 */     if ((this.destValue & 0xF) + (this.srcValue & 0xF) > 15)
/*  255 */       this.machine.setFlagAndNotify(4);
/*      */     else {
/*  257 */       this.machine.clearFlagAndNotify(4);
/*      */     }
/*      */ 
/*  261 */     int i = this.srcValue > 32767 ? 0 : 1;
/*  262 */     int j = this.destValue > 32767 ? 0 : 1;
/*  263 */     int k = this.finalResult > 32767 ? 0 : 1;
/*      */ 
/*  265 */     if (((i != 0) && (j != 0) && (k == 0)) || ((i == 0) && (j == 0) && (k != 0)))
/*  266 */       this.machine.setFlagAndNotify(11);
/*      */     else {
/*  268 */       this.machine.clearFlagAndNotify(11);
/*      */     }
/*      */ 
/*  272 */     this.numberOfOnes = 0;
/*  273 */     for (int m = 0; m < 8; m++)
/*  274 */       this.numberOfOnes += ((this.result & Constants.BITMASK[m]) >> m);
/*  275 */     if (this.numberOfOnes % 2 == 0)
/*  276 */       this.machine.setFlagAndNotify(2);
/*      */     else {
/*  278 */       this.machine.clearFlagAndNotify(2);
/*      */     }
/*      */ 
/*  282 */     if (k == 0)
/*  283 */       this.machine.setFlagAndNotify(7);
/*      */     else {
/*  285 */       this.machine.clearFlagAndNotify(7);
/*      */     }
/*      */ 
/*  289 */     if (this.finalResult == 0)
/*  290 */       this.machine.setFlagAndNotify(6);
/*      */     else {
/*  292 */       this.machine.clearFlagAndNotify(6);
/*      */     }
/*  294 */     return null;
/*      */   }
/*      */ 
/*      */   public StopPoint ADC8(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
/*      */   {
/*   57 */     if (this.machine.debuggingEnabled) {
/*   58 */       System.out.print("ADC8: Dest: ");
/*   59 */       for (int i = 0; i < paramArrayOfInt1.length; i++) System.out.print(paramArrayOfInt1[i] + " ");
/*   60 */       System.out.print("\tSrc: ");
/*   61 */       for (int j = 0; j < paramArrayOfInt2.length; j++) System.out.print(paramArrayOfInt2[j] + " ");
/*   62 */       System.out.println("");
/*      */     }
/*      */ 
/*   71 */     if (paramArrayOfInt2[3] == 2)
/*   72 */       this.srcValue = this.machine.getMemoryByte(paramArrayOfInt2);
/*   73 */     else if (paramArrayOfInt2[3] == 3)
/*   74 */       this.srcValue = paramArrayOfInt2[0];
/*      */     else
/*   76 */       this.srcValue = this.machine.getRegister(paramArrayOfInt2[2]);
/*   77 */     if (this.machine.getFlag(0)) this.srcValue += 1;
/*      */ 
/*   83 */     if (paramArrayOfInt1[3] == 2) {
/*   84 */       this.destValue = this.machine.getMemoryByte(paramArrayOfInt1);
/*   85 */       this.result = (this.srcValue + this.destValue);
/*   86 */       this.finalResult = (this.result & 0xFF);
/*   87 */       this.machine.setMemoryByteAndNotify(this.finalResult, paramArrayOfInt1);
/*      */     }
/*      */     else {
/*   90 */       if (paramArrayOfInt1[3] == 3) {
/*   91 */         return new StopPoint(1, "Immediate as destination in ADC8");
/*      */       }
/*      */ 
/*   94 */       this.destValue = this.machine.getRegister(paramArrayOfInt1[2]);
/*   95 */       this.result = (this.srcValue + this.destValue);
/*   96 */       this.finalResult = (this.result & 0xFF);
/*   97 */       this.machine.setRegisterAndNotify(this.finalResult, paramArrayOfInt1[2]);
/*      */     }
/*      */ 
/*  104 */     if (this.machine.debuggingEnabled)
/*      */     {
/*  106 */       System.out.println("SourceValue: " + this.srcValue + 
/*  107 */         " DestValue: " + this.destValue + 
/*  108 */         " Result: " + this.result + 
/*  109 */         " Final Result: " + this.finalResult);
/*      */     }
/*      */ 
/*  123 */     if (this.result != this.finalResult)
/*  124 */       this.machine.setFlagAndNotify(0);
/*      */     else {
/*  126 */       this.machine.clearFlagAndNotify(0);
/*      */     }
/*      */ 
/*  130 */     if ((this.destValue & 0xF) + (this.srcValue & 0xF) > 15)
/*  131 */       this.machine.setFlagAndNotify(4);
/*      */     else {
/*  133 */       this.machine.clearFlagAndNotify(4);
/*      */     }
/*      */ 
/*  137 */     int i = this.srcValue > 127 ? 0 : 1;
/*  138 */     int j = this.destValue > 127 ? 0 : 1;
/*  139 */     int k = this.finalResult > 127 ? 0 : 1;
/*      */ 
/*  141 */     if (((i != 0) && (j != 0) && (k == 0)) || ((i == 0) && (j == 0) && (k != 0)))
/*  142 */       this.machine.setFlagAndNotify(11);
/*      */     else {
/*  144 */       this.machine.clearFlagAndNotify(11);
/*      */     }
/*      */ 
/*  148 */     this.numberOfOnes = 0;
/*  149 */     for (int m = 0; m < 8; m++)
/*  150 */       this.numberOfOnes += ((this.result & Constants.BITMASK[m]) >> m);
/*  151 */     if (this.numberOfOnes % 2 == 0)
/*  152 */       this.machine.setFlagAndNotify(2);
/*      */     else {
/*  154 */       this.machine.clearFlagAndNotify(2);
/*      */     }
/*      */ 
/*  158 */     if (k == 0)
/*  159 */       this.machine.setFlagAndNotify(7);
/*      */     else {
/*  161 */       this.machine.clearFlagAndNotify(7);
/*      */     }
/*      */ 
/*  165 */     if (this.finalResult == 0)
/*  166 */       this.machine.setFlagAndNotify(6);
/*      */     else {
/*  168 */       this.machine.clearFlagAndNotify(6);
/*      */     }
/*  170 */     return null;
/*      */   }
/*      */ 
/*      */   public StopPoint ADD16(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
/*      */   {
/*  428 */     if (this.machine.debuggingEnabled) {
/*  429 */       System.out.print("ADD16: Dest: ");
/*  430 */       for (int i = 0; i < paramArrayOfInt1.length; i++) System.out.print(paramArrayOfInt1[i] + " ");
/*  431 */       System.out.print("\tSrc: ");
/*  432 */       for (int j = 0; j < paramArrayOfInt2.length; j++) System.out.print(paramArrayOfInt2[j] + " ");
/*  433 */       System.out.println("");
/*      */     }
/*      */ 
/*  441 */     if (paramArrayOfInt2[3] == 2)
/*  442 */       this.srcValue = this.machine.getMemoryWord(paramArrayOfInt2);
/*  443 */     else if (paramArrayOfInt2[3] == 3)
/*  444 */       this.srcValue = paramArrayOfInt2[0];
/*      */     else {
/*  446 */       this.srcValue = this.machine.getRegister(paramArrayOfInt2[2]);
/*      */     }
/*      */ 
/*  453 */     if (paramArrayOfInt1[3] == 2) {
/*  454 */       this.destValue = this.machine.getMemoryWord(paramArrayOfInt1);
/*  455 */       this.result = (this.srcValue + this.destValue);
/*  456 */       this.finalResult = (this.result & 0xFFFF);
/*  457 */       this.machine.setMemoryWordAndNotify(this.finalResult, paramArrayOfInt1);
/*      */     }
/*      */     else {
/*  460 */       if (paramArrayOfInt1[3] == 3) {
/*  461 */         return new StopPoint(1, "Immediate as destination in ADD16");
/*      */       }
/*      */ 
/*  464 */       this.destValue = this.machine.getRegister(paramArrayOfInt1[2]);
/*  465 */       this.result = (this.srcValue + this.destValue);
/*  466 */       this.finalResult = (this.result & 0xFFFF);
/*  467 */       this.machine.setRegisterAndNotify(this.finalResult, paramArrayOfInt1[2]);
/*      */     }
/*      */ 
/*  474 */     if (this.machine.debuggingEnabled) {
/*  475 */       System.out.println("SourceValue: " + this.srcValue + 
/*  476 */         " DestValue: " + this.destValue + 
/*  477 */         " Result: " + this.result + 
/*  478 */         " Final Result: " + this.finalResult);
/*      */     }
/*      */ 
/*  492 */     if (this.result != this.finalResult)
/*  493 */       this.machine.setFlagAndNotify(0);
/*      */     else {
/*  495 */       this.machine.clearFlagAndNotify(0);
/*      */     }
/*      */ 
/*  499 */     if ((this.destValue & 0xF) + (this.srcValue & 0xF) > 15)
/*  500 */       this.machine.setFlagAndNotify(4);
/*      */     else {
/*  502 */       this.machine.clearFlagAndNotify(4);
/*      */     }
/*      */ 
/*  506 */     int i = this.srcValue > 32767 ? 0 : 1;
/*  507 */     int j = this.destValue > 32767 ? 0 : 1;
/*  508 */     int k = this.finalResult > 32767 ? 0 : 1;
/*      */ 
/*  510 */     if (((i != 0) && (j != 0) && (k == 0)) || ((i == 0) && (j == 0) && (k != 0)))
/*  511 */       this.machine.setFlagAndNotify(11);
/*      */     else {
/*  513 */       this.machine.clearFlagAndNotify(11);
/*      */     }
/*      */ 
/*  517 */     this.numberOfOnes = 0;
/*  518 */     for (int m = 0; m < 8; m++)
/*  519 */       this.numberOfOnes += ((this.result & Constants.BITMASK[m]) >> m);
/*  520 */     if (this.numberOfOnes % 2 == 0)
/*  521 */       this.machine.setFlagAndNotify(2);
/*      */     else {
/*  523 */       this.machine.clearFlagAndNotify(2);
/*      */     }
/*      */ 
/*  527 */     if (k == 0)
/*  528 */       this.machine.setFlagAndNotify(7);
/*      */     else {
/*  530 */       this.machine.clearFlagAndNotify(7);
/*      */     }
/*      */ 
/*  534 */     if (this.finalResult == 0)
/*  535 */       this.machine.setFlagAndNotify(6);
/*      */     else {
/*  537 */       this.machine.clearFlagAndNotify(6);
/*      */     }
/*  539 */     return null;
/*      */   }
/*      */ 
/*      */   public StopPoint ADD8(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
/*      */   {
/*  304 */     if (this.machine.debuggingEnabled) {
/*  305 */       System.out.print("ADD8: Dest: ");
/*  306 */       for (int i = 0; i < paramArrayOfInt1.length; i++) System.out.print(paramArrayOfInt1[i] + " ");
/*  307 */       System.out.print("\tSrc: ");
/*  308 */       for (int j = 0; j < paramArrayOfInt2.length; j++) System.out.print(paramArrayOfInt2[j] + " ");
/*  309 */       System.out.println("");
/*      */     }
/*      */ 
/*  318 */     if (paramArrayOfInt2[3] == 2)
/*  319 */       this.srcValue = this.machine.getMemoryByte(paramArrayOfInt2);
/*  320 */     else if (paramArrayOfInt2[3] == 3)
/*  321 */       this.srcValue = paramArrayOfInt2[0];
/*      */     else {
/*  323 */       this.srcValue = this.machine.getRegister(paramArrayOfInt2[2]);
/*      */     }
/*      */ 
/*  330 */     if (paramArrayOfInt1[3] == 2) {
/*  331 */       this.destValue = this.machine.getMemoryByte(paramArrayOfInt1);
/*  332 */       this.result = (this.srcValue + this.destValue);
/*  333 */       this.finalResult = (this.result & 0xFF);
/*  334 */       this.machine.setMemoryByteAndNotify(this.finalResult, paramArrayOfInt1);
/*      */     }
/*      */     else {
/*  337 */       if (paramArrayOfInt1[3] == 3) {
/*  338 */         return new StopPoint(1, "Immediate as destination in ADD8");
/*      */       }
/*      */ 
/*  342 */       this.destValue = this.machine.getRegister(paramArrayOfInt1[2]);
/*  343 */       this.result = (this.srcValue + this.destValue);
/*  344 */       this.finalResult = (this.result & 0xFF);
/*  345 */       this.machine.setRegisterAndNotify(this.finalResult, paramArrayOfInt1[2]);
/*      */     }
/*      */ 
/*  352 */     if (this.machine.debuggingEnabled) {
/*  353 */       System.out.println("SourceValue: " + this.srcValue + 
/*  354 */         " DestValue: " + this.destValue + 
/*  355 */         " Result: " + this.result + 
/*  356 */         " Final Result: " + this.finalResult);
/*      */     }
/*      */ 
/*  371 */     if (this.result != this.finalResult)
/*  372 */       this.machine.setFlagAndNotify(0);
/*      */     else {
/*  374 */       this.machine.clearFlagAndNotify(0);
/*      */     }
/*      */ 
/*  378 */     if ((this.destValue & 0xF) + (this.srcValue & 0xF) > 15)
/*  379 */       this.machine.setFlagAndNotify(4);
/*      */     else {
/*  381 */       this.machine.clearFlagAndNotify(4);
/*      */     }
/*      */ 
/*  385 */     int i = this.srcValue > 127 ? 0 : 1;
/*  386 */     int j = this.destValue > 127 ? 0 : 1;
/*  387 */     int k = this.finalResult > 127 ? 0 : 1;
/*      */ 
/*  389 */     if (((i != 0) && (j != 0) && (k == 0)) || ((i == 0) && (j == 0) && (k != 0)))
/*  390 */       this.machine.setFlagAndNotify(11);
/*      */     else {
/*  392 */       this.machine.clearFlagAndNotify(11);
/*      */     }
/*      */ 
/*  396 */     this.numberOfOnes = 0;
/*  397 */     for (int m = 0; m < 8; m++)
/*  398 */       this.numberOfOnes += ((this.result & Constants.BITMASK[m]) >> m);
/*  399 */     if (this.numberOfOnes % 2 == 0)
/*  400 */       this.machine.setFlagAndNotify(2);
/*      */     else {
/*  402 */       this.machine.clearFlagAndNotify(2);
/*      */     }
/*      */ 
/*  406 */     if (k == 0)
/*  407 */       this.machine.setFlagAndNotify(7);
/*      */     else {
/*  409 */       this.machine.clearFlagAndNotify(7);
/*      */     }
/*      */ 
/*  413 */     if (this.finalResult == 0)
/*  414 */       this.machine.setFlagAndNotify(6);
/*      */     else {
/*  416 */       this.machine.clearFlagAndNotify(6);
/*      */     }
/*  418 */     return null;
/*      */   }
/*      */ 
/*      */   public StopPoint AND16(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
/*      */   {
/*  653 */     if (this.machine.debuggingEnabled) {
/*  654 */       System.out.print("AND16: Dest: ");
/*  655 */       for (int i = 0; i < paramArrayOfInt1.length; i++) System.out.print(paramArrayOfInt1[i] + " ");
/*  656 */       System.out.print("\tSrc: ");
/*  657 */       for (int j = 0; j < paramArrayOfInt2.length; j++) System.out.print(paramArrayOfInt2[j] + " ");
/*  658 */       System.out.println("");
/*      */     }
/*      */ 
/*  666 */     if (paramArrayOfInt2[3] == 2)
/*  667 */       this.srcValue = this.machine.getMemoryWord(paramArrayOfInt2);
/*  668 */     else if (paramArrayOfInt2[3] == 3)
/*  669 */       this.srcValue = paramArrayOfInt2[0];
/*      */     else {
/*  671 */       this.srcValue = this.machine.getRegister(paramArrayOfInt2[2]);
/*      */     }
/*      */ 
/*  678 */     if (paramArrayOfInt1[3] == 2) {
/*  679 */       this.destValue = this.machine.getMemoryWord(paramArrayOfInt1);
/*  680 */       this.finalResult = (this.srcValue & this.destValue);
/*  681 */       this.machine.setMemoryWordAndNotify(this.finalResult, paramArrayOfInt1);
/*      */     }
/*      */     else {
/*  684 */       if (paramArrayOfInt1[3] == 3) {
/*  685 */         return new StopPoint(1, "Immediate as destination in AND16");
/*      */       }
/*      */ 
/*  688 */       this.destValue = this.machine.getRegister(paramArrayOfInt1[2]);
/*  689 */       this.finalResult = (this.srcValue & this.destValue);
/*  690 */       this.machine.setRegisterAndNotify(this.finalResult, paramArrayOfInt1[2]);
/*      */     }
/*      */ 
/*  697 */     if (this.machine.debuggingEnabled) {
/*  698 */       System.out.println("SourceValue: " + this.srcValue + 
/*  699 */         " DestValue: " + this.destValue + 
/*  700 */         " Final Result: " + this.finalResult);
/*      */     }
/*      */ 
/*  714 */     this.machine.clearFlagAndNotify(0);
/*      */ 
/*  718 */     this.machine.clearFlagAndNotify(11);
/*      */ 
/*  722 */     int i = 0;
/*  723 */     for (int j = 0; j < 16; j++)
/*  724 */       i += ((this.finalResult & Constants.BITMASK[j]) >> j);
/*  725 */     if (i % 2 == 0)
/*  726 */       this.machine.setFlagAndNotify(2);
/*      */     else {
/*  728 */       this.machine.clearFlagAndNotify(2);
/*      */     }
/*      */ 
/*  732 */     if (this.finalResult > 32767)
/*  733 */       this.machine.setFlagAndNotify(7);
/*      */     else {
/*  735 */       this.machine.clearFlagAndNotify(7);
/*      */     }
/*      */ 
/*  739 */     if (this.finalResult == 0)
/*  740 */       this.machine.setFlagAndNotify(6);
/*      */     else {
/*  742 */       this.machine.clearFlagAndNotify(6);
/*      */     }
/*  744 */     return null;
/*      */   }
/*      */ 
/*      */   public StopPoint AND8(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
/*      */   {
/*  550 */     if (this.machine.debuggingEnabled) {
/*  551 */       System.out.print("AND8: Dest: ");
/*  552 */       for (int i = 0; i < paramArrayOfInt1.length; i++) System.out.print(paramArrayOfInt1[i] + " ");
/*  553 */       System.out.print("\tSrc: ");
/*  554 */       for (int j = 0; j < paramArrayOfInt2.length; j++) System.out.print(paramArrayOfInt2[j] + " ");
/*  555 */       System.out.println("");
/*      */     }
/*      */ 
/*  563 */     if (paramArrayOfInt2[3] == 2)
/*  564 */       this.srcValue = this.machine.getMemoryByte(paramArrayOfInt2);
/*  565 */     else if (paramArrayOfInt2[3] == 3)
/*  566 */       this.srcValue = paramArrayOfInt2[0];
/*      */     else {
/*  568 */       this.srcValue = this.machine.getRegister(paramArrayOfInt2[2]);
/*      */     }
/*      */ 
/*  575 */     if (paramArrayOfInt1[3] == 2) {
/*  576 */       this.destValue = this.machine.getMemoryByte(paramArrayOfInt1);
/*  577 */       this.finalResult = (this.srcValue & this.destValue);
/*  578 */       this.machine.setMemoryByteAndNotify(this.finalResult, paramArrayOfInt1);
/*      */     }
/*      */     else {
/*  581 */       if (paramArrayOfInt1[3] == 3) {
/*  582 */         return new StopPoint(1, "Immediate as destination in AND8");
/*      */       }
/*      */ 
/*  586 */       this.destValue = this.machine.getRegister(paramArrayOfInt1[2]);
/*  587 */       this.finalResult = (this.srcValue & this.destValue);
/*  588 */       this.machine.setRegisterAndNotify(this.finalResult, paramArrayOfInt1[2]);
/*      */     }
/*      */ 
/*  595 */     if (this.machine.debuggingEnabled) {
/*  596 */       System.out.println("SourceValue: " + this.srcValue + 
/*  597 */         " DestValue: " + this.destValue + 
/*  598 */         " Final Result: " + this.finalResult);
/*      */     }
/*      */ 
/*  612 */     this.machine.clearFlagAndNotify(0);
/*      */ 
/*  616 */     this.machine.clearFlagAndNotify(11);
/*      */ 
/*  620 */     this.numberOfOnes = 0;
/*  621 */     for (int i = 0; i < 8; i++)
/*  622 */       this.numberOfOnes += ((this.finalResult & Constants.BITMASK[i]) >> i);
/*  623 */     if (this.numberOfOnes % 2 == 0)
/*  624 */       this.machine.setFlagAndNotify(2);
/*      */     else {
/*  626 */       this.machine.clearFlagAndNotify(2);
/*      */     }
/*      */ 
/*  630 */     if (this.finalResult > 127)
/*  631 */       this.machine.setFlagAndNotify(7);
/*      */     else {
/*  633 */       this.machine.clearFlagAndNotify(7);
/*      */     }
/*      */ 
/*  637 */     if (this.finalResult == 0)
/*  638 */       this.machine.setFlagAndNotify(6);
/*      */     else {
/*  640 */       this.machine.clearFlagAndNotify(6);
/*      */     }
/*  642 */     return null;
/*      */   }
/*      */ 
/*      */   public StopPoint CMP16(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
/*      */   {
/*  882 */     if (this.machine.debuggingEnabled) {
/*  883 */       System.out.print("CMP16: Dest: ");
/*  884 */       for (int i = 0; i < paramArrayOfInt1.length; i++) System.out.print(paramArrayOfInt1[i] + " ");
/*  885 */       System.out.print("\tSrc: ");
/*  886 */       for (int j = 0; j < paramArrayOfInt2.length; j++) System.out.print(paramArrayOfInt2[j] + " ");
/*  887 */       System.out.println("");
/*      */     }
/*      */ 
/*  895 */     if (paramArrayOfInt2[3] == 2)
/*  896 */       this.srcValue = this.machine.getMemoryWord(paramArrayOfInt2);
/*  897 */     else if (paramArrayOfInt2[3] == 3)
/*  898 */       this.srcValue = paramArrayOfInt2[0];
/*      */     else {
/*  900 */       this.srcValue = this.machine.getRegister(paramArrayOfInt2[2]);
/*      */     }
/*      */ 
/*  907 */     if (paramArrayOfInt1[3] == 2) {
/*  908 */       this.destValue = this.machine.getMemoryWord(paramArrayOfInt1);
/*      */     }
/*      */     else {
/*  911 */       if (paramArrayOfInt1[3] == 3) {
/*  912 */         return new StopPoint(1, "Immediate as destination in ADD16");
/*      */       }
/*      */ 
/*  915 */       this.destValue = this.machine.getRegister(paramArrayOfInt1[2]);
/*      */     }
/*      */ 
/*  923 */     this.result = (this.destValue - this.srcValue);
/*  924 */     this.finalResult = (this.result & 0xFFFF);
/*      */ 
/*  928 */     if (this.machine.debuggingEnabled) {
/*  929 */       System.out.println("SourceValue: " + this.srcValue + 
/*  930 */         " DestValue: " + this.destValue + 
/*  931 */         " Result: " + this.result + 
/*  932 */         " Final Result: " + this.finalResult);
/*      */     }
/*      */ 
/*  945 */     if (this.result != this.finalResult)
/*  946 */       this.machine.setFlagAndNotify(0);
/*      */     else {
/*  948 */       this.machine.clearFlagAndNotify(0);
/*      */     }
/*      */ 
/*  952 */     if ((this.destValue & 0xF) - (this.srcValue & 0xF) < 0)
/*  953 */       this.machine.setFlagAndNotify(4);
/*      */     else {
/*  955 */       this.machine.clearFlagAndNotify(4);
/*      */     }
/*      */ 
/*  965 */     int i = this.srcValue <= 32767 ? 0 : 1;
/*  966 */     int j = this.destValue > 32767 ? 0 : 1;
/*  967 */     int k = this.finalResult > 32767 ? 0 : 1;
/*      */ 
/*  969 */     if (((i != 0) && (j != 0) && (k == 0)) || ((i == 0) && (j == 0) && (k != 0)))
/*  970 */       this.machine.setFlagAndNotify(11);
/*      */     else {
/*  972 */       this.machine.clearFlagAndNotify(11);
/*      */     }
/*      */ 
/*  976 */     this.numberOfOnes = 0;
/*  977 */     for (int m = 0; m < 8; m++)
/*  978 */       this.numberOfOnes += ((this.result & Constants.BITMASK[m]) >> m);
/*  979 */     if (this.numberOfOnes % 2 == 0)
/*  980 */       this.machine.setFlagAndNotify(2);
/*      */     else {
/*  982 */       this.machine.clearFlagAndNotify(2);
/*      */     }
/*      */ 
/*  986 */     if (k == 0)
/*  987 */       this.machine.setFlagAndNotify(7);
/*      */     else {
/*  989 */       this.machine.clearFlagAndNotify(7);
/*      */     }
/*      */ 
/*  993 */     if (this.finalResult == 0)
/*  994 */       this.machine.setFlagAndNotify(6);
/*      */     else {
/*  996 */       this.machine.clearFlagAndNotify(6);
/*      */     }
/*  998 */     return null;
/*      */   }
/*      */ 
/*      */   public StopPoint CMP8(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
/*      */   {
/*  755 */     if (this.machine.debuggingEnabled) {
/*  756 */       System.out.print("CMP8: Dest: ");
/*  757 */       for (int i = 0; i < paramArrayOfInt1.length; i++) System.out.print(paramArrayOfInt1[i] + " ");
/*  758 */       System.out.print("\tSrc: ");
/*  759 */       for (int j = 0; j < paramArrayOfInt2.length; j++) System.out.print(paramArrayOfInt2[j] + " ");
/*  760 */       System.out.println("");
/*      */     }
/*      */ 
/*  768 */     if (paramArrayOfInt2[3] == 2)
/*  769 */       this.srcValue = this.machine.getMemoryByte(paramArrayOfInt2);
/*  770 */     else if (paramArrayOfInt2[3] == 3)
/*  771 */       this.srcValue = paramArrayOfInt2[0];
/*      */     else {
/*  773 */       this.srcValue = this.machine.getRegister(paramArrayOfInt2[2]);
/*      */     }
/*      */ 
/*  780 */     if (paramArrayOfInt1[3] == 2) {
/*  781 */       this.destValue = this.machine.getMemoryByte(paramArrayOfInt1);
/*      */     }
/*      */     else {
/*  784 */       if (paramArrayOfInt1[3] == 3) {
/*  785 */         return new StopPoint(1, "Immediate as destination in ADD16");
/*      */       }
/*      */ 
/*  788 */       this.destValue = this.machine.getRegister(paramArrayOfInt1[2]);
/*      */     }
/*      */ 
/*  796 */     this.result = (this.destValue - this.srcValue);
/*  797 */     this.finalResult = (this.result & 0xFF);
/*      */ 
/*  801 */     if (this.machine.debuggingEnabled) {
/*  802 */       System.out.println("SourceValue: " + this.srcValue + 
/*  803 */         " DestValue: " + this.destValue + 
/*  804 */         " Result: " + this.result + 
/*  805 */         " Final Result: " + this.finalResult);
/*      */     }
/*      */ 
/*  818 */     if (this.result != this.finalResult)
/*  819 */       this.machine.setFlagAndNotify(0);
/*      */     else {
/*  821 */       this.machine.clearFlagAndNotify(0);
/*      */     }
/*      */ 
/*  825 */     if ((this.destValue & 0xF) - (this.srcValue & 0xF) < 0)
/*  826 */       this.machine.setFlagAndNotify(4);
/*      */     else {
/*  828 */       this.machine.clearFlagAndNotify(4);
/*      */     }
/*      */ 
/*  838 */     int i = this.srcValue <= 127 ? 0 : 1;
/*  839 */     int j = this.destValue > 127 ? 0 : 1;
/*  840 */     int k = this.finalResult > 127 ? 0 : 1;
/*      */ 
/*  842 */     if (((i != 0) && (j != 0) && (k == 0)) || ((i == 0) && (j == 0) && (k != 0)))
/*  843 */       this.machine.setFlagAndNotify(11);
/*      */     else {
/*  845 */       this.machine.clearFlagAndNotify(11);
/*      */     }
/*      */ 
/*  849 */     this.numberOfOnes = 0;
/*  850 */     for (int m = 0; m < 8; m++)
/*  851 */       this.numberOfOnes += ((this.result & Constants.BITMASK[m]) >> m);
/*  852 */     if (this.numberOfOnes % 2 == 0)
/*  853 */       this.machine.setFlagAndNotify(2);
/*      */     else {
/*  855 */       this.machine.clearFlagAndNotify(2);
/*      */     }
/*      */ 
/*  859 */     if (k == 0)
/*  860 */       this.machine.setFlagAndNotify(7);
/*      */     else {
/*  862 */       this.machine.clearFlagAndNotify(7);
/*      */     }
/*      */ 
/*  866 */     if (this.finalResult == 0)
/*  867 */       this.machine.setFlagAndNotify(6);
/*      */     else {
/*  869 */       this.machine.clearFlagAndNotify(6);
/*      */     }
/*  871 */     return null;
/*      */   }
/*      */ 
/*      */   public StopPoint CMPS16(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
/*      */   {
/* 1134 */     paramArrayOfInt2[0] = this.machine.getRegister(11);
/*      */ 
/* 1136 */     paramArrayOfInt1[1] = this.machine.getRegister(7);
/*      */ 
/* 1140 */     if (this.machine.debuggingEnabled) {
/* 1141 */       System.out.println("CMPS16: Dest: " + paramArrayOfInt1[0] + "\tSrc: " + paramArrayOfInt2[0]);
/*      */     }
/*      */ 
/* 1149 */     this.srcValue = this.machine.getMemoryWord(paramArrayOfInt2);
/* 1150 */     this.destValue = this.machine.getMemoryWord(paramArrayOfInt1);
/*      */ 
/* 1156 */     if (this.machine.getFlag(10)) {
/* 1157 */       this.machine.incSIAndNotify(-2);
/* 1158 */       this.machine.incDIAndNotify(-2);
/*      */     }
/*      */     else {
/* 1161 */       this.machine.incSIAndNotify(2);
/* 1162 */       this.machine.incDIAndNotify(2);
/*      */     }
/*      */ 
/* 1169 */     this.result = (this.srcValue - this.destValue);
/* 1170 */     this.finalResult = (this.result & 0xFFFF);
/*      */ 
/* 1174 */     if (this.machine.debuggingEnabled) {
/* 1175 */       System.out.println("SourceValue: " + this.srcValue + 
/* 1176 */         " DestValue: " + this.destValue + 
/* 1177 */         " Result: " + this.result + 
/* 1178 */         " Final Result: " + this.finalResult);
/*      */     }
/*      */ 
/* 1190 */     if (this.result != this.finalResult)
/* 1191 */       this.machine.setFlagAndNotify(0);
/*      */     else {
/* 1193 */       this.machine.clearFlagAndNotify(0);
/*      */     }
/*      */ 
/* 1197 */     if ((this.srcValue & 0xF) - (this.destValue & 0xF) < 0)
/* 1198 */       this.machine.setFlagAndNotify(4);
/*      */     else {
/* 1200 */       this.machine.clearFlagAndNotify(4);
/*      */     }
/*      */ 
/* 1210 */     int i = this.srcValue > 32767 ? 0 : 1;
/* 1211 */     int j = this.destValue <= 32767 ? 0 : 1;
/* 1212 */     int k = this.finalResult > 32767 ? 0 : 1;
/*      */ 
/* 1214 */     if (((i != 0) && (j != 0) && (k == 0)) || ((i == 0) && (j == 0) && (k != 0)))
/* 1215 */       this.machine.setFlagAndNotify(11);
/*      */     else {
/* 1217 */       this.machine.clearFlagAndNotify(11);
/*      */     }
/*      */ 
/* 1221 */     this.numberOfOnes = 0;
/* 1222 */     for (int m = 0; m < 8; m++)
/* 1223 */       this.numberOfOnes += ((this.result & Constants.BITMASK[m]) >> m);
/* 1224 */     if (this.numberOfOnes % 2 == 0)
/* 1225 */       this.machine.setFlagAndNotify(2);
/*      */     else {
/* 1227 */       this.machine.clearFlagAndNotify(2);
/*      */     }
/*      */ 
/* 1231 */     if (k == 0)
/* 1232 */       this.machine.setFlagAndNotify(7);
/*      */     else {
/* 1234 */       this.machine.clearFlagAndNotify(7);
/*      */     }
/*      */ 
/* 1238 */     if (this.finalResult == 0)
/* 1239 */       this.machine.setFlagAndNotify(6);
/*      */     else {
/* 1241 */       this.machine.clearFlagAndNotify(6);
/*      */     }
/* 1243 */     return null;
/*      */   }
/*      */ 
/*      */   public StopPoint CMPS8(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
/*      */   {
/* 1011 */     paramArrayOfInt2[0] = this.machine.getRegister(11);
/*      */ 
/* 1013 */     paramArrayOfInt1[1] = this.machine.getRegister(7);
/*      */ 
/* 1017 */     if (this.machine.debuggingEnabled) {
/* 1018 */       System.out.println("CMPS8: Dest: " + paramArrayOfInt1[0] + "\tSrc: " + paramArrayOfInt2[0]);
/*      */     }
/*      */ 
/* 1026 */     this.srcValue = this.machine.getMemoryByte(paramArrayOfInt2);
/* 1027 */     this.destValue = this.machine.getMemoryByte(paramArrayOfInt1);
/*      */ 
/* 1033 */     if (this.machine.getFlag(10)) {
/* 1034 */       this.machine.incSIAndNotify(-1);
/* 1035 */       this.machine.incDIAndNotify(-1);
/*      */     }
/*      */     else {
/* 1038 */       this.machine.incSIAndNotify(1);
/* 1039 */       this.machine.incDIAndNotify(1);
/*      */     }
/*      */ 
/* 1046 */     this.result = (this.srcValue - this.destValue);
/* 1047 */     this.finalResult = (this.result & 0xFFFF);
/*      */ 
/* 1051 */     if (this.machine.debuggingEnabled) {
/* 1052 */       System.out.println("SourceValue: " + this.srcValue + 
/* 1053 */         " DestValue: " + this.destValue + 
/* 1054 */         " Result: " + this.result + 
/* 1055 */         " Final Result: " + this.finalResult);
/*      */     }
/*      */ 
/* 1068 */     if (this.result != this.finalResult)
/* 1069 */       this.machine.setFlagAndNotify(0);
/*      */     else {
/* 1071 */       this.machine.clearFlagAndNotify(0);
/*      */     }
/*      */ 
/* 1075 */     if ((this.srcValue & 0xF) - (this.destValue & 0xF) < 0)
/* 1076 */       this.machine.setFlagAndNotify(4);
/*      */     else {
/* 1078 */       this.machine.clearFlagAndNotify(4);
/*      */     }
/*      */ 
/* 1088 */     int i = this.srcValue > 127 ? 0 : 1;
/* 1089 */     int j = this.destValue <= 127 ? 0 : 1;
/* 1090 */     int k = this.finalResult > 127 ? 0 : 1;
/*      */ 
/* 1092 */     if (((i != 0) && (j != 0) && (k == 0)) || ((i == 0) && (j == 0) && (k != 0)))
/* 1093 */       this.machine.setFlagAndNotify(11);
/*      */     else {
/* 1095 */       this.machine.clearFlagAndNotify(11);
/*      */     }
/*      */ 
/* 1099 */     this.numberOfOnes = 0;
/* 1100 */     for (int m = 0; m < 8; m++)
/* 1101 */       this.numberOfOnes += ((this.result & Constants.BITMASK[m]) >> m);
/* 1102 */     if (this.numberOfOnes % 2 == 0)
/* 1103 */       this.machine.setFlagAndNotify(2);
/*      */     else {
/* 1105 */       this.machine.clearFlagAndNotify(2);
/*      */     }
/*      */ 
/* 1109 */     if (k == 0)
/* 1110 */       this.machine.setFlagAndNotify(7);
/*      */     else {
/* 1112 */       this.machine.clearFlagAndNotify(7);
/*      */     }
/*      */ 
/* 1116 */     if (this.finalResult == 0)
/* 1117 */       this.machine.setFlagAndNotify(6);
/*      */     else {
/* 1119 */       this.machine.clearFlagAndNotify(6);
/*      */     }
/* 1121 */     return null;
/*      */   }
/*      */ 
/*      */   public StopPoint DEC16(int[] paramArrayOfInt)
/*      */   {
/* 1354 */     if (this.machine.debuggingEnabled) {
/* 1355 */       System.out.print("DEC16: Src/Dest: ");
/* 1356 */       for (int i = 0; i < paramArrayOfInt.length; i++) System.out.print(paramArrayOfInt[i] + " ");
/* 1357 */       System.out.println("");
/*      */     }
/*      */ 
/* 1367 */     if (paramArrayOfInt[3] == 2) {
/* 1368 */       this.srcValue = this.machine.getMemoryWord(paramArrayOfInt);
/* 1369 */       this.result = (this.srcValue - 1);
/* 1370 */       this.finalResult = (this.result & 0xFFFF);
/* 1371 */       this.machine.setMemoryWordAndNotify(this.finalResult, paramArrayOfInt);
/*      */     }
/*      */     else {
/* 1374 */       if (paramArrayOfInt[3] == 3) {
/* 1375 */         return new StopPoint(1, "Immediate as src/dest in DEC16");
/*      */       }
/*      */ 
/* 1379 */       this.srcValue = this.machine.getRegister(paramArrayOfInt[2]);
/* 1380 */       this.result = (this.srcValue - 1);
/* 1381 */       this.finalResult = (this.result & 0xFFFF);
/* 1382 */       this.machine.setRegisterAndNotify(this.finalResult, paramArrayOfInt[2]);
/*      */     }
/*      */ 
/* 1388 */     if (this.machine.debuggingEnabled) {
/* 1389 */       System.out.println("Value: " + this.srcValue + 
/* 1390 */         " Result: " + this.result + 
/* 1391 */         " Final Result: " + this.finalResult);
/*      */     }
/*      */ 
/* 1404 */     if ((this.srcValue & 0xF) == 0)
/*      */     {
/* 1406 */       this.machine.setFlagAndNotify(4);
/*      */     }
/* 1408 */     else this.machine.clearFlagAndNotify(4);
/*      */ 
/* 1412 */     int i = this.srcValue > 32767 ? 0 : 1;
/* 1413 */     int j = this.finalResult > 32767 ? 0 : 1;
/*      */ 
/* 1415 */     if ((i == 0) && (j != 0))
/* 1416 */       this.machine.setFlagAndNotify(11);
/*      */     else {
/* 1418 */       this.machine.clearFlagAndNotify(11);
/*      */     }
/*      */ 
/* 1422 */     this.numberOfOnes = 0;
/* 1423 */     for (int k = 0; k < 8; k++)
/* 1424 */       this.numberOfOnes += ((this.result & Constants.BITMASK[k]) >> k);
/* 1425 */     if (this.numberOfOnes % 2 == 0)
/* 1426 */       this.machine.setFlagAndNotify(2);
/*      */     else {
/* 1428 */       this.machine.clearFlagAndNotify(2);
/*      */     }
/*      */ 
/* 1432 */     if (j == 0)
/* 1433 */       this.machine.setFlagAndNotify(7);
/*      */     else {
/* 1435 */       this.machine.clearFlagAndNotify(7);
/*      */     }
/*      */ 
/* 1439 */     if (this.finalResult == 0)
/* 1440 */       this.machine.setFlagAndNotify(6);
/*      */     else {
/* 1442 */       this.machine.clearFlagAndNotify(6);
/*      */     }
/* 1444 */     return null;
/*      */   }
/*      */ 
/*      */   public StopPoint DEC8(int[] paramArrayOfInt)
/*      */   {
/* 1254 */     if (this.machine.debuggingEnabled) {
/* 1255 */       System.out.print("DEC8: Src/Dest: ");
/* 1256 */       for (int i = 0; i < paramArrayOfInt.length; i++) System.out.print(paramArrayOfInt[i] + " ");
/* 1257 */       System.out.println("");
/*      */     }
/*      */ 
/* 1267 */     if (paramArrayOfInt[3] == 2) {
/* 1268 */       this.srcValue = this.machine.getMemoryByte(paramArrayOfInt);
/* 1269 */       this.result = (this.srcValue - 1);
/* 1270 */       this.finalResult = (this.result & 0xFF);
/* 1271 */       this.machine.setMemoryByteAndNotify(this.finalResult, paramArrayOfInt);
/*      */     }
/*      */     else {
/* 1274 */       if (paramArrayOfInt[3] == 3) {
/* 1275 */         return new StopPoint(1, "Immediate as src/dest in DEC8");
/*      */       }
/*      */ 
/* 1278 */       this.srcValue = this.machine.getRegister(paramArrayOfInt[2]);
/* 1279 */       this.result = (this.srcValue - 1);
/* 1280 */       this.finalResult = (this.result & 0xFF);
/* 1281 */       this.machine.setRegisterAndNotify(this.finalResult, paramArrayOfInt[2]);
/*      */     }
/*      */ 
/* 1287 */     if (this.machine.debuggingEnabled) {
/* 1288 */       System.out.println("Value: " + this.srcValue + 
/* 1289 */         " Result: " + this.result + 
/* 1290 */         " Final Result: " + this.finalResult);
/*      */     }
/*      */ 
/* 1303 */     if ((this.srcValue & 0xF) == 0)
/*      */     {
/* 1305 */       this.machine.setFlagAndNotify(4);
/*      */     }
/* 1307 */     else this.machine.clearFlagAndNotify(4);
/*      */ 
/* 1311 */     int i = this.srcValue > 127 ? 0 : 1;
/* 1312 */     int j = this.finalResult > 127 ? 0 : 1;
/*      */ 
/* 1314 */     if ((i == 0) && (j != 0))
/* 1315 */       this.machine.setFlagAndNotify(11);
/*      */     else {
/* 1317 */       this.machine.clearFlagAndNotify(11);
/*      */     }
/*      */ 
/* 1321 */     this.numberOfOnes = 0;
/* 1322 */     for (int k = 0; k < 8; k++)
/* 1323 */       this.numberOfOnes += ((this.result & Constants.BITMASK[k]) >> k);
/* 1324 */     if (this.numberOfOnes % 2 == 0)
/* 1325 */       this.machine.setFlagAndNotify(2);
/*      */     else {
/* 1327 */       this.machine.clearFlagAndNotify(2);
/*      */     }
/*      */ 
/* 1331 */     if (j == 0)
/* 1332 */       this.machine.setFlagAndNotify(7);
/*      */     else {
/* 1334 */       this.machine.clearFlagAndNotify(7);
/*      */     }
/*      */ 
/* 1338 */     if (this.finalResult == 0)
/* 1339 */       this.machine.setFlagAndNotify(6);
/*      */     else {
/* 1341 */       this.machine.clearFlagAndNotify(6);
/*      */     }
/* 1343 */     return null;
/*      */   }
/*      */ 
/*      */   public StopPoint DIV16(int[] paramArrayOfInt)
/*      */   {
/* 1526 */     if (this.machine.debuggingEnabled) {
/* 1527 */       System.out.print("DIV16: Src: ");
/* 1528 */       for (int i = 0; i < paramArrayOfInt.length; i++) System.out.print(paramArrayOfInt[i] + " ");
/* 1529 */       System.out.println("");
/*      */     }
/*      */ 
/* 1537 */     if (paramArrayOfInt[3] == 2) {
/* 1538 */       this.srcValue = this.machine.getMemoryWord(paramArrayOfInt);
/*      */     } else {
/* 1540 */       if (paramArrayOfInt[3] == 3) {
/* 1541 */         return new StopPoint(1, "Immediate as source in DIV16");
/*      */       }
/*      */ 
/* 1545 */       this.srcValue = this.machine.getRegister(paramArrayOfInt[2]);
/*      */     }
/*      */ 
/* 1556 */     if (this.srcValue == 0) return new StopPoint(5, "");
/*      */ 
/* 1566 */     this.longFinalResult = ((this.machine.getRegister(3) << 16) + this.machine.getRegister(0));
/* 1567 */     this.result = ((int)(this.longFinalResult / this.srcValue & 0xFFFF));
/* 1568 */     this.finalResult = ((int)(this.longFinalResult % this.srcValue));
/* 1569 */     this.machine.setRegisterAndNotify(this.result, 0);
/* 1570 */     this.machine.setRegisterAndNotify(this.finalResult, 3);
/*      */ 
/* 1575 */     if (this.machine.debuggingEnabled) {
/* 1576 */       System.out.println("SourceValue: " + this.srcValue + 
/* 1577 */         " DestValue: " + this.longFinalResult + 
/* 1578 */         " Quotient: " + this.result + 
/* 1579 */         " Remainder: " + this.finalResult);
/*      */     }
/*      */ 
/* 1588 */     return null;
/*      */   }
/*      */ 
/*      */   public StopPoint DIV8(int[] paramArrayOfInt)
/*      */   {
/* 1455 */     if (this.machine.debuggingEnabled) {
/* 1456 */       System.out.print("DIV8: Src: ");
/* 1457 */       for (int i = 0; i < paramArrayOfInt.length; i++) System.out.print(paramArrayOfInt[i] + " ");
/* 1458 */       System.out.println("");
/*      */     }
/*      */ 
/* 1467 */     if (paramArrayOfInt[3] == 2) {
/* 1468 */       this.srcValue = this.machine.getMemoryByte(paramArrayOfInt);
/*      */     } else {
/* 1470 */       if (paramArrayOfInt[3] == 3) {
/* 1471 */         return new StopPoint(1, "Immediate as source in DIV8");
/*      */       }
/*      */ 
/* 1475 */       this.srcValue = this.machine.getRegister(paramArrayOfInt[2]);
/*      */     }
/*      */ 
/* 1486 */     if (this.srcValue == 0) return new StopPoint(5, "");
/*      */ 
/* 1494 */     this.destValue = this.machine.getRegister(0);
/* 1495 */     this.result = (this.destValue / this.srcValue & 0xFF);
/* 1496 */     this.finalResult = (this.destValue % this.srcValue);
/* 1497 */     this.machine.setRegisterAndNotify((this.finalResult << 8) + this.result, 0);
/*      */ 
/* 1502 */     if (this.machine.debuggingEnabled) {
/* 1503 */       System.out.println("SourceValue: " + this.srcValue + 
/* 1504 */         " DestValue: " + this.destValue + 
/* 1505 */         " Quotient: " + this.result + 
/* 1506 */         " Remainder: " + this.finalResult);
/*      */     }
/*      */ 
/* 1516 */     return null;
/*      */   }
/*      */ 
/*      */   public void DisplayInstrBytes(String paramString, int[] paramArrayOfInt)
/*      */   {
/* 6045 */     if (this.machine.debuggingEnabled)
/*      */     {
/* 6047 */       System.out.print(paramString + ":  instrByte: ");
/* 6048 */       for (int i = 0; i < paramArrayOfInt.length; i++) System.out.print(paramArrayOfInt[i] + " ");
/* 6049 */       System.out.println("");
/*      */     }
/*      */   }
/*      */ 
/*      */   public void DisplayInstrData(int[][] paramArrayOfInt)
/*      */   {
/* 6057 */     if (this.machine.debuggingEnabled)
/*      */     {
/* 6060 */       System.out.print("\tinstrData: ");
/* 6061 */       for (int i = 0; i < paramArrayOfInt.length; i++) {
/* 6062 */         System.out.print("{");
/* 6063 */         for (int j = 0; j < paramArrayOfInt[i].length; j++) System.out.print(paramArrayOfInt[i][j] + " ");
/* 6064 */         System.out.print("}");
/*      */       }
/* 6066 */       System.out.println("");
/*      */     }
/*      */   }
/*      */ 
/*      */   public StopPoint IDIV16(int[] paramArrayOfInt)
/*      */   {
/* 1662 */     if (this.machine.debuggingEnabled) {
/* 1663 */       System.out.print("IDIV16: Src: ");
/* 1664 */       for (int i = 0; i < paramArrayOfInt.length; i++) System.out.print(paramArrayOfInt[i] + " ");
/* 1665 */       System.out.println("");
/*      */     }
/*      */ 
/* 1673 */     if (paramArrayOfInt[3] == 2) {
/* 1674 */       this.srcValue = this.machine.getMemoryWord(paramArrayOfInt);
/*      */     } else {
/* 1676 */       if (paramArrayOfInt[3] == 3) {
/* 1677 */         return new StopPoint(1, "Immediate as source in IDIV16");
/*      */       }
/*      */ 
/* 1681 */       this.srcValue = this.machine.getRegister(paramArrayOfInt[2]);
/*      */     }
/*      */ 
/* 1684 */     if (this.srcValue > 32767) this.srcValue = (-(((this.srcValue ^ 0xFFFFFFFF) & 0xFFFF) + 1));
/*      */ 
/* 1693 */     this.destValue = ((this.machine.getRegister(3) << 16) + this.machine.getRegister(0));
/* 1694 */     this.result = (this.destValue / this.srcValue & 0xFFFF);
/* 1695 */     this.finalResult = (this.destValue % this.srcValue);
/* 1696 */     this.machine.setRegisterAndNotify(this.result, 0);
/* 1697 */     this.machine.setRegisterAndNotify(this.finalResult, 3);
/*      */ 
/* 1702 */     if (this.machine.debuggingEnabled) {
/* 1703 */       System.out.println("SourceValue: " + this.srcValue + 
/* 1704 */         " DestValue: " + this.destValue + 
/* 1705 */         " Quotient: " + this.result + 
/* 1706 */         " Remainder: " + this.finalResult);
/*      */     }
/*      */ 
/* 1717 */     return null;
/*      */   }
/*      */ 
/*      */   public StopPoint IDIV8(int[] paramArrayOfInt)
/*      */   {
/* 1598 */     if (this.machine.debuggingEnabled) {
/* 1599 */       System.out.print("IDIV8: Src: ");
/* 1600 */       for (int i = 0; i < paramArrayOfInt.length; i++) System.out.print(paramArrayOfInt[i] + " ");
/* 1601 */       System.out.println("");
/*      */     }
/*      */ 
/* 1610 */     if (paramArrayOfInt[3] == 2) {
/* 1611 */       this.srcValue = this.machine.getMemoryByte(paramArrayOfInt);
/*      */     } else {
/* 1613 */       if (paramArrayOfInt[3] == 3) {
/* 1614 */         return new StopPoint(1, "Immediate as source in IDIV8");
/*      */       }
/*      */ 
/* 1618 */       this.srcValue = this.machine.getRegister(paramArrayOfInt[2]);
/*      */     }
/*      */ 
/* 1621 */     if (this.srcValue > 127) this.srcValue = (-(((this.srcValue ^ 0xFFFFFFFF) & 0xFF) + 1));
/*      */ 
/* 1629 */     this.destValue = this.machine.getRegister(0);
/*      */ 
/* 1631 */     if (this.destValue > 32767) this.destValue = (-(((this.destValue ^ 0xFFFFFFFF) & 0xFF) + 1));
/* 1632 */     this.result = (this.destValue / this.srcValue & 0xFF);
/* 1633 */     this.finalResult = (this.destValue % this.srcValue);
/* 1634 */     this.machine.setRegisterAndNotify((this.finalResult << 8) + this.result, 0);
/*      */ 
/* 1639 */     if (this.machine.debuggingEnabled) {
/* 1640 */       System.out.println("SourceValue: " + this.srcValue + 
/* 1641 */         " DestValue: " + this.destValue + 
/* 1642 */         " Quotient: " + this.result + 
/* 1643 */         " Remainder: " + this.finalResult);
/*      */     }
/*      */ 
/* 1652 */     return null;
/*      */   }
/*      */ 
/*      */   public StopPoint IMUL16(int[] paramArrayOfInt)
/*      */   {
/* 1808 */     if (this.machine.debuggingEnabled) {
/* 1809 */       System.out.print("IMUL16: Src: ");
/* 1810 */       for (int i = 0; i < paramArrayOfInt.length; i++) System.out.print(paramArrayOfInt[i] + " ");
/* 1811 */       System.out.println("");
/*      */     }
/*      */ 
/* 1820 */     if (paramArrayOfInt[3] == 2) {
/* 1821 */       this.srcValue = this.machine.getMemoryWord(paramArrayOfInt);
/*      */     } else {
/* 1823 */       if (paramArrayOfInt[3] == 3) {
/* 1824 */         return new StopPoint(1, "Immediate as source in IMUL16");
/*      */       }
/*      */ 
/* 1828 */       this.srcValue = this.machine.getRegister(paramArrayOfInt[2]);
/*      */     }
/*      */ 
/* 1831 */     if (this.srcValue > 32767) this.srcValue = (-(((this.srcValue ^ 0xFFFFFFFF) & 0xFFFF) + 1));
/*      */ 
/* 1838 */     this.destValue = this.machine.getRegister(0);
/*      */ 
/* 1840 */     if (this.destValue > 32767) this.destValue = (-(((this.destValue ^ 0xFFFFFFFF) & 0xFFFF) + 1));
/* 1841 */     this.longResult = (this.srcValue * this.destValue);
/* 1842 */     this.longFinalResult = (this.longResult & 0xFFFFFFFF);
/* 1843 */     this.machine.setRegisterAndNotify((int)(this.longFinalResult & 0xFFFF), 0);
/* 1844 */     this.machine.setRegisterAndNotify((int)((this.longFinalResult & 0xFFFF0000) >> 16), 3);
/*      */ 
/* 1849 */     if (this.machine.debuggingEnabled) {
/* 1850 */       System.out.println("SourceValue: " + this.srcValue + 
/* 1851 */         " DestValue: " + this.destValue + 
/* 1852 */         " Result: " + this.longResult + 
/* 1853 */         " Final Result: " + this.longFinalResult);
/*      */     }
/*      */ 
/* 1868 */     if ((((this.longFinalResult & Constants.BITMASK[15]) == 0L) && ((this.finalResult & 0xFF00) == 0)) || (
/* 1869 */       ((this.finalResult & Constants.BITMASK[15]) != 0) && ((this.finalResult & 0xFF00) == 255))) {
/* 1870 */       this.machine.clearFlagAndNotify(0);
/* 1871 */       this.machine.clearFlagAndNotify(11);
/*      */     }
/*      */     else {
/* 1874 */       this.machine.setFlagAndNotify(0);
/* 1875 */       this.machine.setFlagAndNotify(11);
/*      */     }
/*      */ 
/* 1879 */     return null;
/*      */   }
/*      */ 
/*      */   public StopPoint IMUL8(int[] paramArrayOfInt)
/*      */   {
/* 1727 */     if (this.machine.debuggingEnabled) {
/* 1728 */       System.out.print("IMUL8: Src: ");
/* 1729 */       for (int i = 0; i < paramArrayOfInt.length; i++) System.out.print(paramArrayOfInt[i] + " ");
/* 1730 */       System.out.println("");
/*      */     }
/*      */ 
/* 1739 */     if (paramArrayOfInt[3] == 2) {
/* 1740 */       this.srcValue = this.machine.getMemoryByte(paramArrayOfInt);
/*      */     } else {
/* 1742 */       if (paramArrayOfInt[3] == 3) {
/* 1743 */         return new StopPoint(1, "Immediate as source in IMUL8");
/*      */       }
/*      */ 
/* 1747 */       this.srcValue = this.machine.getRegister(paramArrayOfInt[2]);
/*      */     }
/*      */ 
/* 1750 */     if (this.srcValue > 127) this.srcValue = (-(((this.srcValue ^ 0xFFFFFFFF) & 0xFF) + 1));
/*      */ 
/* 1757 */     this.destValue = this.machine.getRegister(20);
/*      */ 
/* 1759 */     if (this.destValue > 127) this.destValue = (-(((this.destValue ^ 0xFFFFFFFF) & 0xFF) + 1));
/* 1760 */     this.result = (this.srcValue * this.destValue);
/* 1761 */     this.finalResult = (this.result & 0xFFFF);
/* 1762 */     this.machine.setRegisterAndNotify(this.finalResult, 0);
/*      */ 
/* 1767 */     if (this.machine.debuggingEnabled) {
/* 1768 */       System.out.println("SourceValue: " + this.srcValue + 
/* 1769 */         " DestValue: " + this.destValue + 
/* 1770 */         " Result: " + this.result + 
/* 1771 */         " Final Result: " + this.finalResult);
/*      */     }
/*      */ 
/* 1786 */     if ((((this.finalResult & Constants.BITMASK[7]) == 0) && ((this.finalResult & 0xFF00) == 0)) || (
/* 1787 */       ((this.finalResult & Constants.BITMASK[7]) != 0) && ((this.finalResult & 0xFF00) == 255))) {
/* 1788 */       this.machine.clearFlagAndNotify(0);
/* 1789 */       this.machine.clearFlagAndNotify(11);
/*      */     }
/*      */     else {
/* 1792 */       this.machine.setFlagAndNotify(0);
/* 1793 */       this.machine.setFlagAndNotify(11);
/*      */     }
/*      */ 
/* 1797 */     return null;
/*      */   }
/*      */ 
/*      */   public StopPoint INC16(int[] paramArrayOfInt)
/*      */   {
/* 1990 */     if (this.machine.debuggingEnabled) {
/* 1991 */       System.out.print("INC16: Src/Dest: ");
/* 1992 */       for (int i = 0; i < paramArrayOfInt.length; i++) System.out.print(paramArrayOfInt[i] + " ");
/* 1993 */       System.out.println("");
/*      */     }
/*      */ 
/* 2003 */     if (paramArrayOfInt[3] == 2) {
/* 2004 */       this.srcValue = this.machine.getMemoryWord(paramArrayOfInt);
/* 2005 */       this.result = (this.srcValue + 1);
/* 2006 */       this.finalResult = (this.result & 0xFFFF);
/* 2007 */       this.machine.setMemoryWordAndNotify(this.finalResult, paramArrayOfInt);
/*      */     }
/*      */     else {
/* 2010 */       if (paramArrayOfInt[3] == 3) {
/* 2011 */         return new StopPoint(1, "Immediate as src/dest in INC16");
/*      */       }
/*      */ 
/* 2015 */       this.srcValue = this.machine.getRegister(paramArrayOfInt[2]);
/* 2016 */       this.result = (this.srcValue + 1);
/* 2017 */       this.finalResult = (this.result & 0xFFFF);
/* 2018 */       this.machine.setRegisterAndNotify(this.finalResult, paramArrayOfInt[2]);
/*      */     }
/*      */ 
/* 2024 */     if (this.machine.debuggingEnabled) {
/* 2025 */       System.out.println("Value: " + this.srcValue + 
/* 2026 */         " Result: " + this.result + 
/* 2027 */         " Final Result: " + this.finalResult);
/*      */     }
/*      */ 
/* 2041 */     if ((this.srcValue & 0xF) == 15)
/* 2042 */       this.machine.setFlagAndNotify(4);
/*      */     else {
/* 2044 */       this.machine.clearFlagAndNotify(4);
/*      */     }
/*      */ 
/* 2048 */     int i = this.srcValue > 32767 ? 0 : 1;
/* 2049 */     int j = this.finalResult > 32767 ? 0 : 1;
/*      */ 
/* 2051 */     if ((i != 0) && (j == 0))
/* 2052 */       this.machine.setFlagAndNotify(11);
/*      */     else {
/* 2054 */       this.machine.clearFlagAndNotify(11);
/*      */     }
/*      */ 
/* 2058 */     this.numberOfOnes = 0;
/* 2059 */     for (int k = 0; k < 8; k++)
/* 2060 */       this.numberOfOnes += ((this.result & Constants.BITMASK[k]) >> k);
/* 2061 */     if (this.numberOfOnes % 2 == 0)
/* 2062 */       this.machine.setFlagAndNotify(2);
/*      */     else {
/* 2064 */       this.machine.clearFlagAndNotify(2);
/*      */     }
/*      */ 
/* 2068 */     if (j == 0)
/* 2069 */       this.machine.setFlagAndNotify(7);
/*      */     else {
/* 2071 */       this.machine.clearFlagAndNotify(7);
/*      */     }
/*      */ 
/* 2075 */     if (this.finalResult == 0)
/* 2076 */       this.machine.setFlagAndNotify(6);
/*      */     else {
/* 2078 */       this.machine.clearFlagAndNotify(6);
/*      */     }
/* 2080 */     return null;
/*      */   }
/*      */ 
/*      */   public StopPoint INC8(int[] paramArrayOfInt)
/*      */   {
/* 1889 */     if (this.machine.debuggingEnabled) {
/* 1890 */       System.out.print("INC8: Src/Dest: ");
/* 1891 */       for (int i = 0; i < paramArrayOfInt.length; i++) System.out.print(paramArrayOfInt[i] + " ");
/* 1892 */       System.out.println("");
/*      */     }
/*      */ 
/* 1902 */     if (paramArrayOfInt[3] == 2) {
/* 1903 */       this.srcValue = this.machine.getMemoryByte(paramArrayOfInt);
/* 1904 */       this.result = (this.srcValue + 1);
/* 1905 */       this.finalResult = (this.result & 0xFF);
/* 1906 */       this.machine.setMemoryByteAndNotify(this.finalResult, paramArrayOfInt);
/*      */     }
/*      */     else {
/* 1909 */       if (paramArrayOfInt[3] == 3) {
/* 1910 */         return new StopPoint(1, "Immediate as src/dest in INC8");
/*      */       }
/*      */ 
/* 1914 */       this.srcValue = this.machine.getRegister(paramArrayOfInt[2]);
/* 1915 */       this.result = (this.srcValue + 1);
/* 1916 */       this.finalResult = (this.result & 0xFF);
/* 1917 */       this.machine.setRegisterAndNotify(this.finalResult, paramArrayOfInt[2]);
/*      */     }
/*      */ 
/* 1923 */     if (this.machine.debuggingEnabled) {
/* 1924 */       System.out.println("Value: " + this.srcValue + 
/* 1925 */         " Result: " + this.result + 
/* 1926 */         " Final Result: " + this.finalResult);
/*      */     }
/*      */ 
/* 1940 */     if ((this.srcValue & 0xF) == 15)
/* 1941 */       this.machine.setFlagAndNotify(4);
/*      */     else {
/* 1943 */       this.machine.clearFlagAndNotify(4);
/*      */     }
/*      */ 
/* 1947 */     int i = this.srcValue > 127 ? 0 : 1;
/* 1948 */     int j = this.finalResult > 127 ? 0 : 1;
/*      */ 
/* 1950 */     if ((i != 0) && (j == 0))
/* 1951 */       this.machine.setFlagAndNotify(11);
/*      */     else {
/* 1953 */       this.machine.clearFlagAndNotify(11);
/*      */     }
/*      */ 
/* 1957 */     this.numberOfOnes = 0;
/* 1958 */     for (int k = 0; k < 8; k++)
/* 1959 */       this.numberOfOnes += ((this.result & Constants.BITMASK[k]) >> k);
/* 1960 */     if (this.numberOfOnes % 2 == 0)
/* 1961 */       this.machine.setFlagAndNotify(2);
/*      */     else {
/* 1963 */       this.machine.clearFlagAndNotify(2);
/*      */     }
/*      */ 
/* 1967 */     if (j == 0)
/* 1968 */       this.machine.setFlagAndNotify(7);
/*      */     else {
/* 1970 */       this.machine.clearFlagAndNotify(7);
/*      */     }
/*      */ 
/* 1974 */     if (this.finalResult == 0)
/* 1975 */       this.machine.setFlagAndNotify(6);
/*      */     else {
/* 1977 */       this.machine.clearFlagAndNotify(6);
/*      */     }
/* 1979 */     return null;
/*      */   }
/*      */ 
/*      */   public StopPoint LODS16(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
/*      */   {
/* 2150 */     paramArrayOfInt2[0] = this.machine.getRegister(11);
/*      */ 
/* 2154 */     if (this.machine.debuggingEnabled) {
/* 2155 */       System.out.println("LODS16: Src: " + paramArrayOfInt2[0]);
/*      */     }
/*      */ 
/* 2163 */     this.srcValue = this.machine.getMemoryWord(paramArrayOfInt2);
/*      */ 
/* 2167 */     if (this.machine.debuggingEnabled) {
/* 2168 */       System.out.println("SourceValue: " + this.srcValue);
/*      */     }
/*      */ 
/* 2175 */     this.machine.setRegisterAndNotify(this.srcValue, 0);
/*      */ 
/* 2181 */     if (this.machine.getFlag(10)) {
/* 2182 */       this.machine.incSIAndNotify(-2);
/*      */     }
/*      */     else {
/* 2185 */       this.machine.incSIAndNotify(2);
/*      */     }
/*      */ 
/* 2193 */     return null;
/*      */   }
/*      */ 
/*      */   public StopPoint LODS8(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
/*      */   {
/* 2094 */     paramArrayOfInt2[0] = this.machine.getRegister(11);
/*      */ 
/* 2098 */     if (this.machine.debuggingEnabled) {
/* 2099 */       System.out.println("LODS8: Src: " + paramArrayOfInt2[0]);
/*      */     }
/*      */ 
/* 2107 */     this.srcValue = this.machine.getMemoryByte(paramArrayOfInt2);
/*      */ 
/* 2111 */     if (this.machine.debuggingEnabled) {
/* 2112 */       System.out.println("SourceValue: " + this.srcValue);
/*      */     }
/*      */ 
/* 2119 */     this.machine.setRegisterAndNotify(this.srcValue, 20);
/*      */ 
/* 2125 */     if (this.machine.getFlag(10)) {
/* 2126 */       this.machine.incSIAndNotify(-1);
/*      */     }
/*      */     else {
/* 2129 */       this.machine.incSIAndNotify(1);
/*      */     }
/*      */ 
/* 2136 */     return null;
/*      */   }
/*      */ 
/*      */   public StopPoint MOV16(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
/*      */   {
/* 2257 */     if (this.machine.debuggingEnabled) {
/* 2258 */       System.out.print("MOV16: Dest: ");
/* 2259 */       for (int i = 0; i < paramArrayOfInt1.length; i++) System.out.print(paramArrayOfInt1[i] + " ");
/* 2260 */       System.out.print("\tSrc: ");
/* 2261 */       for (int j = 0; j < paramArrayOfInt2.length; j++) System.out.print(paramArrayOfInt2[j] + " ");
/* 2262 */       System.out.println("");
/*      */     }
/*      */ 
/* 2271 */     if (paramArrayOfInt2[3] == 2)
/* 2272 */       this.srcValue = this.machine.getMemoryWord(paramArrayOfInt2);
/* 2273 */     else if (paramArrayOfInt2[3] == 3)
/* 2274 */       this.srcValue = paramArrayOfInt2[0];
/*      */     else {
/* 2276 */       this.srcValue = this.machine.getRegister(paramArrayOfInt2[2]);
/*      */     }
/*      */ 
/* 2280 */     if (this.machine.debuggingEnabled) {
/* 2281 */       System.out.println("SourceValue: " + this.srcValue);
/*      */     }
/*      */ 
/* 2288 */     if (paramArrayOfInt1[3] == 2) {
/* 2289 */       this.machine.setMemoryWordAndNotify(this.srcValue, paramArrayOfInt1);
/*      */     } else {
/* 2291 */       if (paramArrayOfInt1[3] == 3) {
/* 2292 */         return new StopPoint(1, "Immediate as destination in MOV16");
/*      */       }
/*      */ 
/* 2296 */       this.machine.setRegisterAndNotify(this.srcValue, paramArrayOfInt1[2]);
/*      */     }
/*      */ 
/* 2303 */     return null;
/*      */   }
/*      */ 
/*      */   public StopPoint MOV8(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
/*      */   {
/* 2203 */     if (this.machine.debuggingEnabled) {
/* 2204 */       System.out.print("MOV8: Dest: ");
/* 2205 */       for (int i = 0; i < paramArrayOfInt1.length; i++) System.out.print(paramArrayOfInt1[i] + " ");
/* 2206 */       System.out.print("\tSrc: ");
/* 2207 */       for (int j = 0; j < paramArrayOfInt2.length; j++) System.out.print(paramArrayOfInt2[j] + " ");
/* 2208 */       System.out.println("");
/*      */     }
/*      */ 
/* 2216 */     if (paramArrayOfInt2[3] == 2)
/* 2217 */       this.srcValue = this.machine.getMemoryByte(paramArrayOfInt2);
/* 2218 */     else if (paramArrayOfInt2[3] == 3)
/* 2219 */       this.srcValue = paramArrayOfInt2[0];
/*      */     else {
/* 2221 */       this.srcValue = this.machine.getRegister(paramArrayOfInt2[2]);
/*      */     }
/*      */ 
/* 2225 */     if (this.machine.debuggingEnabled) {
/* 2226 */       System.out.println("SourceValue: " + this.srcValue);
/*      */     }
/*      */ 
/* 2233 */     if (paramArrayOfInt1[3] == 2) {
/* 2234 */       this.machine.setMemoryByteAndNotify(this.srcValue, paramArrayOfInt1);
/*      */     } else {
/* 2236 */       if (paramArrayOfInt1[3] == 3) {
/* 2237 */         return new StopPoint(1, "Immediate as destination in MOV8");
/*      */       }
/*      */ 
/* 2241 */       this.machine.setRegisterAndNotify(this.srcValue, paramArrayOfInt1[2]);
/*      */     }
/*      */ 
/* 2247 */     return null;
/*      */   }
/*      */ 
/*      */   public StopPoint MOVS16(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
/*      */   {
/* 2373 */     paramArrayOfInt2[0] = this.machine.getRegister(11);
/*      */ 
/* 2375 */     paramArrayOfInt1[1] = this.machine.getRegister(7);
/*      */ 
/* 2379 */     if (this.machine.debuggingEnabled) {
/* 2380 */       System.out.println("MOVS16: Dest: " + paramArrayOfInt1[0] + "\tSrc: " + paramArrayOfInt2[0]);
/*      */     }
/*      */ 
/* 2388 */     this.srcValue = this.machine.getMemoryWord(paramArrayOfInt2);
/*      */ 
/* 2392 */     if (this.machine.debuggingEnabled) {
/* 2393 */       System.out.println("SourceValue: " + this.srcValue);
/*      */     }
/*      */ 
/* 2400 */     this.machine.setMemoryWordAndNotify(this.srcValue, paramArrayOfInt1);
/*      */ 
/* 2406 */     if (this.machine.getFlag(10)) {
/* 2407 */       this.machine.incSIAndNotify(-2);
/* 2408 */       this.machine.incDIAndNotify(-2);
/*      */     }
/*      */     else {
/* 2411 */       this.machine.incSIAndNotify(2);
/* 2412 */       this.machine.incDIAndNotify(2);
/*      */     }
/*      */ 
/* 2420 */     return null;
/*      */   }
/*      */ 
/*      */   public StopPoint MOVS8(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
/*      */   {
/* 2315 */     paramArrayOfInt2[0] = this.machine.getRegister(11);
/*      */ 
/* 2317 */     paramArrayOfInt1[1] = this.machine.getRegister(7);
/*      */ 
/* 2321 */     if (this.machine.debuggingEnabled) {
/* 2322 */       System.out.println("MOVS8: Dest: " + paramArrayOfInt1[0] + "\tSrc: " + paramArrayOfInt2[0]);
/*      */     }
/*      */ 
/* 2330 */     this.srcValue = this.machine.getMemoryByte(paramArrayOfInt2);
/*      */ 
/* 2334 */     if (this.machine.debuggingEnabled) {
/* 2335 */       System.out.println("SourceValue: " + this.srcValue);
/*      */     }
/*      */ 
/* 2342 */     this.machine.setMemoryByteAndNotify(this.srcValue, paramArrayOfInt1);
/*      */ 
/* 2348 */     if (this.machine.getFlag(10)) {
/* 2349 */       this.machine.incSIAndNotify(-1);
/* 2350 */       this.machine.incDIAndNotify(-1);
/*      */     }
/*      */     else {
/* 2353 */       this.machine.incSIAndNotify(1);
/* 2354 */       this.machine.incDIAndNotify(1);
/*      */     }
/*      */ 
/* 2361 */     return null;
/*      */   }
/*      */ 
/*      */   public StopPoint MUL16(int[] paramArrayOfInt)
/*      */   {
/* 2504 */     if (this.machine.debuggingEnabled) {
/* 2505 */       System.out.print("MUL16: Src: ");
/* 2506 */       for (int i = 0; i < paramArrayOfInt.length; i++) System.out.print(paramArrayOfInt[i] + " ");
/* 2507 */       System.out.println("");
/*      */     }
/*      */ 
/* 2515 */     if (paramArrayOfInt[3] == 2) {
/* 2516 */       this.srcValue = this.machine.getMemoryWord(paramArrayOfInt);
/*      */     } else {
/* 2518 */       if (paramArrayOfInt[3] == 3) {
/* 2519 */         return new StopPoint(1, "Immediate as source in MUL16");
/*      */       }
/*      */ 
/* 2523 */       this.srcValue = this.machine.getRegister(paramArrayOfInt[2]);
/*      */     }
/*      */ 
/* 2532 */     this.destValue = this.machine.getRegister(0);
/* 2533 */     this.longResult = (this.srcValue * this.destValue);
/* 2534 */     this.longFinalResult = (this.longResult & 0xFFFFFFFF);
/* 2535 */     this.machine.setRegisterAndNotify((int)(this.longFinalResult & 0xFFFF), 0);
/* 2536 */     this.machine.setRegisterAndNotify((int)((this.longFinalResult & 0xFFFF0000) >> 16), 3);
/*      */ 
/* 2541 */     if (this.machine.debuggingEnabled) {
/* 2542 */       System.out.println("SourceValue: " + this.srcValue + 
/* 2543 */         " DestValue: " + this.destValue + 
/* 2544 */         " Result: " + this.longResult + 
/* 2545 */         " Final Result: " + this.longFinalResult);
/*      */     }
/*      */ 
/* 2559 */     if ((this.finalResult & 0xFFFF0000) != 0) {
/* 2560 */       this.machine.setFlagAndNotify(0);
/* 2561 */       this.machine.setFlagAndNotify(11);
/*      */     }
/*      */     else {
/* 2564 */       this.machine.clearFlagAndNotify(0);
/* 2565 */       this.machine.clearFlagAndNotify(11);
/*      */     }
/*      */ 
/* 2569 */     return null;
/*      */   }
/*      */ 
/*      */   public StopPoint MUL8(int[] paramArrayOfInt)
/*      */   {
/* 2430 */     if (this.machine.debuggingEnabled) {
/* 2431 */       System.out.print("MUL8: Src: ");
/* 2432 */       for (int i = 0; i < paramArrayOfInt.length; i++) System.out.print(paramArrayOfInt[i] + " ");
/* 2433 */       System.out.println("");
/*      */     }
/*      */ 
/* 2442 */     if (paramArrayOfInt[3] == 2) {
/* 2443 */       this.srcValue = this.machine.getMemoryByte(paramArrayOfInt);
/*      */     } else {
/* 2445 */       if (paramArrayOfInt[3] == 3) {
/* 2446 */         return new StopPoint(1, "Immediate as source in MUL8");
/*      */       }
/*      */ 
/* 2450 */       this.srcValue = this.machine.getRegister(paramArrayOfInt[2]);
/*      */     }
/*      */ 
/* 2458 */     this.destValue = this.machine.getRegister(20);
/* 2459 */     this.result = (this.srcValue * this.destValue);
/* 2460 */     this.finalResult = (this.result & 0xFFFF);
/* 2461 */     this.machine.setRegisterAndNotify(this.finalResult, 0);
/*      */ 
/* 2466 */     if (this.machine.debuggingEnabled) {
/* 2467 */       System.out.println("SourceValue: " + this.srcValue + 
/* 2468 */         " DestValue: " + this.destValue + 
/* 2469 */         " Result: " + this.result + 
/* 2470 */         " Final Result: " + this.finalResult);
/*      */     }
/*      */ 
/* 2484 */     if ((this.finalResult & 0xFF00) != 0) {
/* 2485 */       this.machine.setFlagAndNotify(0);
/* 2486 */       this.machine.setFlagAndNotify(11);
/*      */     }
/*      */     else {
/* 2489 */       this.machine.clearFlagAndNotify(0);
/* 2490 */       this.machine.clearFlagAndNotify(11);
/*      */     }
/*      */ 
/* 2493 */     return null;
/*      */   }
/*      */ 
/*      */   public StopPoint NEG16(int[] paramArrayOfInt)
/*      */   {
/* 2673 */     if (this.machine.debuggingEnabled) {
/* 2674 */       System.out.print("NEG16: Src: ");
/* 2675 */       for (int i = 0; i < paramArrayOfInt.length; i++) System.out.print(paramArrayOfInt[i] + " ");
/* 2676 */       System.out.println("");
/*      */     }
/*      */ 
/* 2684 */     if (paramArrayOfInt[3] == 2) {
/* 2685 */       this.srcValue = this.machine.getMemoryWord(paramArrayOfInt);
/* 2686 */       this.result = (((this.srcValue ^ 0xFFFFFFFF) & 0xFFFF) + 1);
/* 2687 */       this.finalResult = (this.result & 0xFFFF);
/* 2688 */       this.machine.setMemoryWordAndNotify(this.finalResult, paramArrayOfInt);
/*      */     }
/*      */     else {
/* 2691 */       if (paramArrayOfInt[3] == 3) {
/* 2692 */         return new StopPoint(1, "Immediate as source in NEG16");
/*      */       }
/*      */ 
/* 2696 */       this.srcValue = this.machine.getRegister(paramArrayOfInt[2]);
/* 2697 */       this.result = (((this.srcValue ^ 0xFFFFFFFF) & 0xFFFF) + 1);
/* 2698 */       this.finalResult = (this.result & 0xFFFF);
/* 2699 */       this.machine.setRegisterAndNotify(this.finalResult, paramArrayOfInt[2]);
/*      */     }
/*      */ 
/* 2706 */     if (this.machine.debuggingEnabled) {
/* 2707 */       System.out.println("SourceValue: " + this.srcValue + 
/* 2708 */         " Result: " + this.result + 
/* 2709 */         " Final Result: " + this.finalResult);
/*      */     }
/*      */ 
/* 2723 */     if (this.srcValue == 0) {
/* 2724 */       this.machine.clearFlagAndNotify(0);
/* 2725 */       this.machine.setFlagAndNotify(6);
/*      */     }
/*      */     else {
/* 2728 */       this.machine.setFlagAndNotify(0);
/* 2729 */       this.machine.clearFlagAndNotify(6);
/*      */     }
/*      */ 
/* 2734 */     if (this.srcValue != 32768)
/*      */     {
/* 2736 */       this.machine.clearFlagAndNotify(0);
/*      */     }
/* 2738 */     else this.machine.setFlagAndNotify(0);
/*      */ 
/* 2742 */     this.numberOfOnes = 0;
/* 2743 */     for (int i = 0; i < 16; i++)
/* 2744 */       this.numberOfOnes += ((this.finalResult & Constants.BITMASK[i]) >> i);
/* 2745 */     if (this.numberOfOnes % 2 == 0)
/* 2746 */       this.machine.setFlagAndNotify(2);
/*      */     else {
/* 2748 */       this.machine.clearFlagAndNotify(2);
/*      */     }
/*      */ 
/* 2752 */     if (this.finalResult > 32767)
/* 2753 */       this.machine.setFlagAndNotify(7);
/*      */     else {
/* 2755 */       this.machine.clearFlagAndNotify(7);
/*      */     }
/* 2757 */     return null;
/*      */   }
/*      */ 
/*      */   public StopPoint NEG8(int[] paramArrayOfInt)
/*      */   {
/* 2579 */     if (this.machine.debuggingEnabled) {
/* 2580 */       System.out.print("NEG8: Src: ");
/* 2581 */       for (int i = 0; i < paramArrayOfInt.length; i++) System.out.print(paramArrayOfInt[i] + " ");
/* 2582 */       System.out.println("");
/*      */     }
/*      */ 
/* 2591 */     if (paramArrayOfInt[3] == 2) {
/* 2592 */       this.srcValue = this.machine.getMemoryByte(paramArrayOfInt);
/* 2593 */       this.result = (((this.srcValue ^ 0xFFFFFFFF) & 0xFF) + 1);
/* 2594 */       this.finalResult = (this.result & 0xFF);
/* 2595 */       this.machine.setMemoryByteAndNotify(this.finalResult, paramArrayOfInt);
/*      */     }
/*      */     else {
/* 2598 */       if (paramArrayOfInt[3] == 3) {
/* 2599 */         return new StopPoint(1, "Immediate as source in NEG8");
/*      */       }
/*      */ 
/* 2603 */       this.srcValue = this.machine.getRegister(paramArrayOfInt[2]);
/* 2604 */       this.result = (((this.srcValue ^ 0xFFFFFFFF) & 0xFF) + 1);
/* 2605 */       this.finalResult = (this.result & 0xFF);
/* 2606 */       this.machine.setRegisterAndNotify(this.finalResult, paramArrayOfInt[2]);
/*      */     }
/*      */ 
/* 2613 */     if (this.machine.debuggingEnabled) {
/* 2614 */       System.out.println("SourceValue: " + this.srcValue + 
/* 2615 */         " Result: " + this.result + 
/* 2616 */         " Final Result: " + this.finalResult);
/*      */     }
/*      */ 
/* 2630 */     if (this.srcValue == 0) {
/* 2631 */       this.machine.clearFlagAndNotify(0);
/* 2632 */       this.machine.setFlagAndNotify(6);
/*      */     }
/*      */     else {
/* 2635 */       this.machine.setFlagAndNotify(0);
/* 2636 */       this.machine.clearFlagAndNotify(6);
/*      */     }
/*      */ 
/* 2641 */     if (this.srcValue != 128)
/* 2642 */       this.machine.clearFlagAndNotify(0);
/*      */     else {
/* 2644 */       this.machine.setFlagAndNotify(0);
/*      */     }
/*      */ 
/* 2648 */     this.numberOfOnes = 0;
/* 2649 */     for (int i = 0; i < 8; i++)
/* 2650 */       this.numberOfOnes += ((this.finalResult & Constants.BITMASK[i]) >> i);
/* 2651 */     if (this.numberOfOnes % 2 == 0)
/* 2652 */       this.machine.setFlagAndNotify(2);
/*      */     else {
/* 2654 */       this.machine.clearFlagAndNotify(2);
/*      */     }
/*      */ 
/* 2658 */     if (this.finalResult > 127)
/* 2659 */       this.machine.setFlagAndNotify(7);
/*      */     else {
/* 2661 */       this.machine.clearFlagAndNotify(7);
/*      */     }
/* 2663 */     return null;
/*      */   }
/*      */ 
/*      */   public StopPoint NOT16(int[] paramArrayOfInt)
/*      */   {
/* 2817 */     if (this.machine.debuggingEnabled) {
/* 2818 */       System.out.print("NOT16: Src/Dest: ");
/* 2819 */       for (int i = 0; i < paramArrayOfInt.length; i++) System.out.print(paramArrayOfInt[i] + " ");
/* 2820 */       System.out.println("");
/*      */     }
/*      */ 
/* 2828 */     if (paramArrayOfInt[3] == 2) {
/* 2829 */       this.srcValue = this.machine.getMemoryWord(paramArrayOfInt);
/* 2830 */       this.result = (this.srcValue ^ 0xFFFFFFFF);
/* 2831 */       this.finalResult = (this.result & 0xFFFF);
/* 2832 */       this.machine.setMemoryWordAndNotify(this.finalResult, paramArrayOfInt);
/*      */     } else {
/* 2834 */       if (paramArrayOfInt[3] == 3) {
/* 2835 */         return new StopPoint(1, "Immediate as source in NOT16");
/*      */       }
/*      */ 
/* 2839 */       this.srcValue = this.machine.getRegister(paramArrayOfInt[2]);
/* 2840 */       this.result = (this.srcValue ^ 0xFFFFFFFF);
/* 2841 */       this.finalResult = (this.result & 0xFFFF);
/* 2842 */       this.machine.setRegisterAndNotify(this.finalResult, paramArrayOfInt[2]);
/*      */     }
/*      */ 
/* 2847 */     if (this.machine.debuggingEnabled) {
/* 2848 */       System.out.println("SourceValue: " + this.srcValue + 
/* 2849 */         " Result: " + this.result + 
/* 2850 */         " Final Result: " + this.finalResult);
/*      */     }
/*      */ 
/* 2857 */     return null;
/*      */   }
/*      */ 
/*      */   public StopPoint NOT8(int[] paramArrayOfInt)
/*      */   {
/* 2767 */     if (this.machine.debuggingEnabled) {
/* 2768 */       System.out.print("NOT8: Src/Dest: ");
/* 2769 */       for (int i = 0; i < paramArrayOfInt.length; i++) System.out.print(paramArrayOfInt[i] + " ");
/* 2770 */       System.out.println("");
/*      */     }
/*      */ 
/* 2778 */     if (paramArrayOfInt[3] == 2) {
/* 2779 */       this.srcValue = this.machine.getMemoryByte(paramArrayOfInt);
/* 2780 */       this.result = (this.srcValue ^ 0xFFFFFFFF);
/* 2781 */       this.finalResult = (this.result & 0xFF);
/* 2782 */       this.machine.setMemoryByteAndNotify(this.finalResult, paramArrayOfInt);
/*      */     } else {
/* 2784 */       if (paramArrayOfInt[3] == 3) {
/* 2785 */         return new StopPoint(1, "Immediate as source in NOT8");
/*      */       }
/*      */ 
/* 2789 */       this.srcValue = this.machine.getRegister(paramArrayOfInt[2]);
/* 2790 */       this.result = (this.srcValue ^ 0xFFFFFFFF);
/* 2791 */       this.finalResult = (this.result & 0xFF);
/* 2792 */       this.machine.setRegisterAndNotify(this.finalResult, paramArrayOfInt[2]);
/*      */     }
/*      */ 
/* 2797 */     if (this.machine.debuggingEnabled) {
/* 2798 */       System.out.println("SourceValue: " + this.srcValue + 
/* 2799 */         " Result: " + this.result + 
/* 2800 */         " Final Result: " + this.finalResult);
/*      */     }
/*      */ 
/* 2807 */     return null;
/*      */   }
/*      */ 
/*      */   public StopPoint NotUsed()
/*      */   {
/* 6031 */     if (this.machine.debuggingEnabled) {
/* 6032 */       System.out.println("Second Byte of Instruction is not Defined for this Instruction");
/*      */     }
/* 6034 */     return new StopPoint(1, "Invalid second instruction control byte");
/*      */   }
/*      */ 
/*      */   public StopPoint OR16(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
/*      */   {
/* 2970 */     if (this.machine.debuggingEnabled) {
/* 2971 */       System.out.print("OR16: Dest: ");
/* 2972 */       for (int i = 0; i < paramArrayOfInt1.length; i++) System.out.print(paramArrayOfInt1[i] + " ");
/* 2973 */       System.out.print("\tSrc: ");
/* 2974 */       for (int j = 0; j < paramArrayOfInt2.length; j++) System.out.print(paramArrayOfInt2[j] + " ");
/* 2975 */       System.out.println("");
/*      */     }
/*      */ 
/* 2983 */     if (paramArrayOfInt2[3] == 2)
/* 2984 */       this.srcValue = this.machine.getMemoryWord(paramArrayOfInt2);
/* 2985 */     else if (paramArrayOfInt2[3] == 3)
/* 2986 */       this.srcValue = paramArrayOfInt2[0];
/*      */     else {
/* 2988 */       this.srcValue = this.machine.getRegister(paramArrayOfInt2[2]);
/*      */     }
/*      */ 
/* 2995 */     if (paramArrayOfInt1[3] == 2) {
/* 2996 */       this.destValue = this.machine.getMemoryWord(paramArrayOfInt1);
/* 2997 */       this.finalResult = (this.srcValue | this.destValue);
/* 2998 */       this.machine.setMemoryWordAndNotify(this.finalResult, paramArrayOfInt1);
/*      */     }
/*      */     else {
/* 3001 */       if (paramArrayOfInt1[3] == 3) {
/* 3002 */         return new StopPoint(1, "Immediate as destination in AND16");
/*      */       }
/*      */ 
/* 3006 */       this.destValue = this.machine.getRegister(paramArrayOfInt1[2]);
/* 3007 */       this.finalResult = (this.srcValue | this.destValue);
/* 3008 */       this.machine.setRegisterAndNotify(this.finalResult, paramArrayOfInt1[2]);
/*      */     }
/*      */ 
/* 3015 */     if (this.machine.debuggingEnabled) {
/* 3016 */       System.out.println("SourceValue: " + this.srcValue + 
/* 3017 */         " DestValue: " + this.destValue + 
/* 3018 */         " Final Result: " + this.finalResult);
/*      */     }
/*      */ 
/* 3032 */     this.machine.clearFlagAndNotify(0);
/*      */ 
/* 3036 */     this.machine.clearFlagAndNotify(11);
/*      */ 
/* 3040 */     int i = 0;
/* 3041 */     for (int j = 0; j < 16; j++)
/* 3042 */       i += ((this.finalResult & Constants.BITMASK[j]) >> j);
/* 3043 */     if (i % 2 == 0)
/* 3044 */       this.machine.setFlagAndNotify(2);
/*      */     else {
/* 3046 */       this.machine.clearFlagAndNotify(2);
/*      */     }
/*      */ 
/* 3050 */     if (this.finalResult > 32767)
/* 3051 */       this.machine.setFlagAndNotify(7);
/*      */     else {
/* 3053 */       this.machine.clearFlagAndNotify(7);
/*      */     }
/*      */ 
/* 3057 */     if (this.finalResult == 0)
/* 3058 */       this.machine.setFlagAndNotify(6);
/*      */     else {
/* 3060 */       this.machine.clearFlagAndNotify(6);
/*      */     }
/*      */ 
/* 3063 */     return null;
/*      */   }
/*      */ 
/*      */   public StopPoint OR8(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
/*      */   {
/* 2867 */     if (this.machine.debuggingEnabled) {
/* 2868 */       System.out.print("OR8: Dest: ");
/* 2869 */       for (int i = 0; i < paramArrayOfInt1.length; i++) System.out.print(paramArrayOfInt1[i] + " ");
/* 2870 */       System.out.print("\tSrc: ");
/* 2871 */       for (int j = 0; j < paramArrayOfInt2.length; j++) System.out.print(paramArrayOfInt2[j] + " ");
/* 2872 */       System.out.println("");
/*      */     }
/*      */ 
/* 2880 */     if (paramArrayOfInt2[3] == 2)
/* 2881 */       this.srcValue = this.machine.getMemoryByte(paramArrayOfInt2);
/* 2882 */     else if (paramArrayOfInt2[3] == 3)
/* 2883 */       this.srcValue = paramArrayOfInt2[0];
/*      */     else {
/* 2885 */       this.srcValue = this.machine.getRegister(paramArrayOfInt2[2]);
/*      */     }
/*      */ 
/* 2892 */     if (paramArrayOfInt1[3] == 2) {
/* 2893 */       this.destValue = this.machine.getMemoryByte(paramArrayOfInt1);
/* 2894 */       this.finalResult = (this.srcValue | this.destValue);
/* 2895 */       this.machine.setMemoryByteAndNotify(this.finalResult, paramArrayOfInt1);
/*      */     }
/*      */     else {
/* 2898 */       if (paramArrayOfInt1[3] == 3) {
/* 2899 */         return new StopPoint(1, "Immediate as destination in OR8");
/*      */       }
/*      */ 
/* 2903 */       this.destValue = this.machine.getRegister(paramArrayOfInt1[2]);
/* 2904 */       this.finalResult = (this.srcValue | this.destValue);
/* 2905 */       this.machine.setRegisterAndNotify(this.finalResult, paramArrayOfInt1[2]);
/*      */     }
/*      */ 
/* 2912 */     if (this.machine.debuggingEnabled) {
/* 2913 */       System.out.println("SourceValue: " + this.srcValue + 
/* 2914 */         " DestValue: " + this.destValue + 
/* 2915 */         " Final Result: " + this.finalResult);
/*      */     }
/*      */ 
/* 2929 */     this.machine.clearFlagAndNotify(0);
/*      */ 
/* 2933 */     this.machine.clearFlagAndNotify(11);
/*      */ 
/* 2937 */     this.numberOfOnes = 0;
/* 2938 */     for (int i = 0; i < 8; i++)
/* 2939 */       this.numberOfOnes += ((this.finalResult & Constants.BITMASK[i]) >> i);
/* 2940 */     if (this.numberOfOnes % 2 == 0)
/* 2941 */       this.machine.setFlagAndNotify(2);
/*      */     else {
/* 2943 */       this.machine.clearFlagAndNotify(2);
/*      */     }
/*      */ 
/* 2947 */     if (this.finalResult > 127)
/* 2948 */       this.machine.setFlagAndNotify(7);
/*      */     else {
/* 2950 */       this.machine.clearFlagAndNotify(7);
/*      */     }
/*      */ 
/* 2954 */     if (this.finalResult == 0)
/* 2955 */       this.machine.setFlagAndNotify(6);
/*      */     else {
/* 2957 */       this.machine.clearFlagAndNotify(6);
/*      */     }
/*      */ 
/* 2960 */     return null;
/*      */   }
/*      */ 
/*      */   public StopPoint POP(int[] paramArrayOfInt)
/*      */   {
/* 3073 */     if (this.machine.debuggingEnabled) {
/* 3074 */       System.out.print("POP: Dest: ");
/* 3075 */       for (int i = 0; i < paramArrayOfInt.length; i++) System.out.print(paramArrayOfInt[i] + " ");
/* 3076 */       System.out.println("");
/*      */     }
/*      */ 
/* 3086 */     this.location[0] = this.machine.getRegister(9);
/* 3087 */     this.location[1] = this.machine.getRegister(6);
/*      */ 
/* 3090 */     this.srcValue = this.machine.getMemoryWord(this.location);
/*      */ 
/* 3093 */     this.machine.incSPAndNotify(2);
/*      */ 
/* 3097 */     if (this.machine.debuggingEnabled) {
/* 3098 */       System.out.println("SourceValue: " + this.srcValue);
/*      */     }
/*      */ 
/* 3105 */     if (paramArrayOfInt[3] == 2) {
/* 3106 */       this.machine.setMemoryWordAndNotify(this.srcValue, paramArrayOfInt);
/*      */     } else {
/* 3108 */       if (paramArrayOfInt[3] == 3) {
/* 3109 */         return new StopPoint(1, "Immediate as destination in POP");
/*      */       }
/*      */ 
/* 3113 */       this.machine.setRegisterAndNotify(this.srcValue, paramArrayOfInt[2]);
/*      */     }
/*      */ 
/* 3120 */     return null;
/*      */   }
/*      */ 
/*      */   public StopPoint PUSH(int[] paramArrayOfInt)
/*      */   {
/* 3130 */     if (this.machine.debuggingEnabled) {
/* 3131 */       System.out.print("PUSH: Src: ");
/* 3132 */       for (int i = 0; i < paramArrayOfInt.length; i++) System.out.print(paramArrayOfInt[i] + " ");
/* 3133 */       System.out.println("");
/*      */     }
/*      */ 
/* 3142 */     if (paramArrayOfInt[3] == 3) {
/* 3143 */       return new StopPoint(1, "Immediate as source in PUSH");
/*      */     }
/*      */ 
/* 3147 */     if (paramArrayOfInt[3] == 2)
/* 3148 */       this.srcValue = this.machine.getMemoryWord(paramArrayOfInt);
/* 3149 */     else if (paramArrayOfInt[3] == 1) {
/* 3150 */       this.srcValue = this.machine.getRegister(paramArrayOfInt[2]);
/*      */     }
/*      */ 
/* 3153 */     if (this.machine.debuggingEnabled) {
/* 3154 */       System.out.println("SourceValue: " + this.srcValue);
/*      */     }
/*      */ 
/* 3162 */     this.machine.incSPAndNotify(-2);
/*      */ 
/* 3165 */     this.location[0] = this.machine.getRegister(9);
/* 3166 */     this.location[1] = this.machine.getRegister(6);
/*      */ 
/* 3169 */     this.machine.setMemoryWordAndNotify(this.srcValue, this.location);
/*      */ 
/* 3175 */     return null;
/*      */   }
/*      */ 
/*      */   public StopPoint RCL16(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
/*      */   {
/*      */     int i;
/* 3288 */     if (this.machine.debuggingEnabled) {
/* 3289 */       System.out.print("RCL16: Dest: ");
/* 3290 */       for (i = 0; i < paramArrayOfInt1.length; i++) System.out.print(paramArrayOfInt1[i] + " ");
/* 3291 */       System.out.print("\tSrc: ");
/* 3292 */       for (int j = 0; j < paramArrayOfInt2.length; j++) System.out.print(paramArrayOfInt2[j] + " ");
/* 3293 */       System.out.println("");
/*      */     }
/*      */ 
/* 3302 */     if (paramArrayOfInt2[3] == 2) {
/* 3303 */       return new StopPoint(1, "Memory as source in RCL16");
/*      */     }
/*      */ 
/* 3306 */     if (paramArrayOfInt2[3] == 3)
/* 3307 */       this.srcValue = paramArrayOfInt2[0];
/*      */     else {
/* 3309 */       this.srcValue = this.machine.getRegister(22);
/*      */     }
/*      */ 
/* 3315 */     if (paramArrayOfInt1[3] == 2) {
/* 3316 */       this.destValue = this.machine.getMemoryWord(paramArrayOfInt1);
/* 3317 */       this.result = this.destValue;
/* 3318 */       this.carry = this.machine.getFlag(0);
/* 3319 */       for (i = this.srcValue; i > 0; i--) {
/* 3320 */         this.tempCarry = (this.result > 32767);
/* 3321 */         this.result = (this.result << 1 & 0xFFFF);
/* 3322 */         if (this.carry) this.result += 1;
/* 3323 */         this.carry = this.tempCarry;
/*      */       }
/* 3325 */       this.machine.setMemoryWordAndNotify(this.result, paramArrayOfInt1);
/*      */     }
/*      */     else {
/* 3328 */       if (paramArrayOfInt1[3] == 3) {
/* 3329 */         return new StopPoint(1, "Immediate as destination in RCL16");
/*      */       }
/*      */ 
/* 3333 */       this.destValue = this.machine.getRegister(paramArrayOfInt1[2]);
/* 3334 */       this.result = this.destValue;
/* 3335 */       this.carry = this.machine.getFlag(0);
/* 3336 */       for (i = this.srcValue; i > 0; i--) {
/* 3337 */         this.tempCarry = (this.result > 32767);
/* 3338 */         this.result = (this.result << 1 & 0xFFFF);
/* 3339 */         if (this.carry) this.result += 1;
/* 3340 */         this.carry = this.tempCarry;
/*      */       }
/* 3342 */       this.machine.setRegisterAndNotify(this.result, paramArrayOfInt1[2]);
/*      */     }
/*      */ 
/* 3349 */     if (this.machine.debuggingEnabled) {
/* 3350 */       System.out.println("SourceValue: " + this.srcValue + 
/* 3351 */         " DestValue: " + this.destValue + 
/* 3352 */         " Result: " + this.result);
/*      */     }
/*      */ 
/* 3366 */     if (this.carry)
/* 3367 */       this.machine.setFlagAndNotify(0);
/*      */     else {
/* 3369 */       this.machine.clearFlagAndNotify(0);
/*      */     }
/*      */ 
/* 3373 */     this.tempCarry = (this.result > 32767);
/* 3374 */     if (this.tempCarry != this.carry)
/* 3375 */       this.machine.setFlagAndNotify(11);
/*      */     else {
/* 3377 */       this.machine.clearFlagAndNotify(11);
/*      */     }
/*      */ 
/* 3380 */     return null;
/*      */   }
/*      */ 
/*      */   public StopPoint RCL8(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
/*      */   {
/*      */     int i;
/* 3187 */     if (this.machine.debuggingEnabled) {
/* 3188 */       System.out.print("RCL8: Dest: ");
/* 3189 */       for (i = 0; i < paramArrayOfInt1.length; i++) System.out.print(paramArrayOfInt1[i] + " ");
/* 3190 */       System.out.print("\tSrc: ");
/* 3191 */       for (int j = 0; j < paramArrayOfInt2.length; j++) System.out.print(paramArrayOfInt2[j] + " ");
/* 3192 */       System.out.println("");
/*      */     }
/*      */ 
/* 3201 */     if (paramArrayOfInt2[3] == 2) {
/* 3202 */       return new StopPoint(1, "Memory as source in RCL8");
/*      */     }
/*      */ 
/* 3205 */     if (paramArrayOfInt2[3] == 3)
/* 3206 */       this.srcValue = paramArrayOfInt2[0];
/*      */     else {
/* 3208 */       this.srcValue = this.machine.getRegister(22);
/*      */     }
/*      */ 
/* 3214 */     if (paramArrayOfInt1[3] == 2) {
/* 3215 */       this.destValue = this.machine.getMemoryByte(paramArrayOfInt1);
/* 3216 */       this.result = this.destValue;
/* 3217 */       this.carry = this.machine.getFlag(0);
/* 3218 */       for (i = this.srcValue; i > 0; i--) {
/* 3219 */         this.tempCarry = (this.result > 127);
/* 3220 */         this.result = (this.result << 1 & 0xFF);
/* 3221 */         if (this.carry) this.result += 1;
/* 3222 */         this.carry = this.tempCarry;
/*      */       }
/* 3224 */       this.machine.setMemoryByteAndNotify(this.result, paramArrayOfInt1);
/*      */     }
/*      */     else {
/* 3227 */       if (paramArrayOfInt1[3] == 3) {
/* 3228 */         return new StopPoint(1, "Immediate as destination in RCL8");
/*      */       }
/*      */ 
/* 3232 */       this.destValue = this.machine.getRegister(paramArrayOfInt1[2]);
/* 3233 */       this.result = this.destValue;
/* 3234 */       this.carry = this.machine.getFlag(0);
/* 3235 */       for (i = this.srcValue; i > 0; i--) {
/* 3236 */         this.tempCarry = (this.result > 127);
/* 3237 */         this.result = (this.result << 1 & 0xFF);
/* 3238 */         if (this.carry) this.result += 1;
/* 3239 */         this.carry = this.tempCarry;
/*      */       }
/* 3241 */       this.machine.setRegisterAndNotify(this.result, paramArrayOfInt1[2]);
/*      */     }
/*      */ 
/* 3248 */     if (this.machine.debuggingEnabled) {
/* 3249 */       System.out.println("SourceValue: " + this.srcValue + 
/* 3250 */         " DestValue: " + this.destValue + 
/* 3251 */         " Result: " + this.result);
/*      */     }
/*      */ 
/* 3265 */     if (this.carry)
/* 3266 */       this.machine.setFlagAndNotify(0);
/*      */     else {
/* 3268 */       this.machine.clearFlagAndNotify(0);
/*      */     }
/*      */ 
/* 3272 */     this.tempCarry = (this.result > 127);
/* 3273 */     if (this.tempCarry != this.carry)
/* 3274 */       this.machine.setFlagAndNotify(11);
/*      */     else {
/* 3276 */       this.machine.clearFlagAndNotify(11);
/*      */     }
/* 3278 */     return null;
/*      */   }
/*      */ 
/*      */   public StopPoint RCR16(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
/*      */   {
/*      */     int i;
/* 3493 */     if (this.machine.debuggingEnabled) {
/* 3494 */       System.out.print("RCR16: Dest: ");
/* 3495 */       for (i = 0; i < paramArrayOfInt1.length; i++) System.out.print(paramArrayOfInt1[i] + " ");
/* 3496 */       System.out.print("\tSrc: ");
/* 3497 */       for (int j = 0; j < paramArrayOfInt2.length; j++) System.out.print(paramArrayOfInt2[j] + " ");
/* 3498 */       System.out.println("");
/*      */     }
/*      */ 
/* 3507 */     if (paramArrayOfInt2[3] == 2) {
/* 3508 */       return new StopPoint(1, "Memory as source in RCR16");
/*      */     }
/*      */ 
/* 3511 */     if (paramArrayOfInt2[3] == 3)
/* 3512 */       this.srcValue = paramArrayOfInt2[0];
/*      */     else {
/* 3514 */       this.srcValue = this.machine.getRegister(22);
/*      */     }
/*      */ 
/* 3520 */     if (paramArrayOfInt1[3] == 2) {
/* 3521 */       this.destValue = this.machine.getMemoryWord(paramArrayOfInt1);
/* 3522 */       this.result = this.destValue;
/* 3523 */       this.carry = this.machine.getFlag(0);
/* 3524 */       for (i = this.srcValue; i > 0; i--) {
/* 3525 */         this.tempCarry = ((this.result & Constants.BITMASK[0]) == 1);
/* 3526 */         this.result >>= 1;
/* 3527 */         if (this.carry) this.result += Constants.BITMASK[15];
/* 3528 */         this.carry = this.tempCarry;
/*      */       }
/* 3530 */       this.machine.setMemoryWordAndNotify(this.result, paramArrayOfInt1);
/*      */     }
/*      */     else {
/* 3533 */       if (paramArrayOfInt1[3] == 3) {
/* 3534 */         return new StopPoint(1, "Immediate as destination in RCR16");
/*      */       }
/*      */ 
/* 3538 */       this.destValue = this.machine.getRegister(paramArrayOfInt1[2]);
/* 3539 */       this.result = this.destValue;
/* 3540 */       this.carry = this.machine.getFlag(0);
/* 3541 */       for (i = this.srcValue; i > 0; i--) {
/* 3542 */         this.tempCarry = ((this.result & Constants.BITMASK[0]) == 1);
/* 3543 */         this.result >>= 1;
/* 3544 */         if (this.carry) this.result += Constants.BITMASK[15];
/* 3545 */         this.carry = this.tempCarry;
/*      */       }
/* 3547 */       this.machine.setRegisterAndNotify(this.result, paramArrayOfInt1[2]);
/*      */     }
/*      */ 
/* 3554 */     if (this.machine.debuggingEnabled) {
/* 3555 */       System.out.println("SourceValue: " + this.srcValue + 
/* 3556 */         " DestValue: " + this.destValue + 
/* 3557 */         " Result: " + this.result);
/*      */     }
/*      */ 
/* 3570 */     if (this.carry)
/* 3571 */       this.machine.setFlagAndNotify(0);
/*      */     else {
/* 3573 */       this.machine.clearFlagAndNotify(0);
/*      */     }
/*      */ 
/* 3577 */     this.carry = ((this.result & Constants.BITMASK[15]) != 0);
/* 3578 */     this.tempCarry = ((this.result & Constants.BITMASK[14]) != 0);
/* 3579 */     if (this.tempCarry != this.carry)
/* 3580 */       this.machine.setFlagAndNotify(11);
/*      */     else {
/* 3582 */       this.machine.clearFlagAndNotify(11);
/*      */     }
/*      */ 
/* 3585 */     return null;
/*      */   }
/*      */ 
/*      */   public StopPoint RCR8(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
/*      */   {
/*      */     int i;
/* 3390 */     if (this.machine.debuggingEnabled) {
/* 3391 */       System.out.print("RCR8: Dest: ");
/* 3392 */       for (i = 0; i < paramArrayOfInt1.length; i++) System.out.print(paramArrayOfInt1[i] + " ");
/* 3393 */       System.out.print("\tSrc: ");
/* 3394 */       for (int j = 0; j < paramArrayOfInt2.length; j++) System.out.print(paramArrayOfInt2[j] + " ");
/* 3395 */       System.out.println("");
/*      */     }
/*      */ 
/* 3404 */     if (paramArrayOfInt2[3] == 2) {
/* 3405 */       return new StopPoint(1, "Memory as source in RCR8");
/*      */     }
/*      */ 
/* 3408 */     if (paramArrayOfInt2[3] == 3)
/* 3409 */       this.srcValue = paramArrayOfInt2[0];
/*      */     else {
/* 3411 */       this.srcValue = this.machine.getRegister(22);
/*      */     }
/*      */ 
/* 3417 */     if (paramArrayOfInt1[3] == 2) {
/* 3418 */       this.destValue = this.machine.getMemoryByte(paramArrayOfInt1);
/* 3419 */       this.result = this.destValue;
/* 3420 */       this.carry = this.machine.getFlag(0);
/* 3421 */       for (i = this.srcValue; i > 0; i--) {
/* 3422 */         this.tempCarry = ((this.result & Constants.BITMASK[0]) == 1);
/* 3423 */         this.result >>= 1;
/* 3424 */         if (this.carry) this.result += Constants.BITMASK[7];
/* 3425 */         this.carry = this.tempCarry;
/*      */       }
/* 3427 */       this.machine.setMemoryByteAndNotify(this.result, paramArrayOfInt1);
/*      */     }
/*      */     else {
/* 3430 */       if (paramArrayOfInt1[3] == 3) {
/* 3431 */         return new StopPoint(1, "Immediate as destination in RCR8");
/*      */       }
/*      */ 
/* 3435 */       this.destValue = this.machine.getRegister(paramArrayOfInt1[2]);
/* 3436 */       this.result = this.destValue;
/* 3437 */       this.carry = this.machine.getFlag(0);
/* 3438 */       for (i = this.srcValue; i > 0; i--) {
/* 3439 */         this.tempCarry = ((this.result & Constants.BITMASK[0]) == 1);
/* 3440 */         this.result >>= 1;
/* 3441 */         if (this.carry) this.result += Constants.BITMASK[7];
/* 3442 */         this.carry = this.tempCarry;
/*      */       }
/* 3444 */       this.machine.setRegisterAndNotify(this.result, paramArrayOfInt1[2]);
/*      */     }
/*      */ 
/* 3451 */     if (this.machine.debuggingEnabled) {
/* 3452 */       System.out.println("SourceValue: " + this.srcValue + 
/* 3453 */         " DestValue: " + this.destValue + 
/* 3454 */         " Result: " + this.result);
/*      */     }
/*      */ 
/* 3468 */     if (this.carry)
/* 3469 */       this.machine.setFlagAndNotify(0);
/*      */     else {
/* 3471 */       this.machine.clearFlagAndNotify(0);
/*      */     }
/*      */ 
/* 3475 */     this.carry = ((this.result & Constants.BITMASK[7]) != 0);
/* 3476 */     this.tempCarry = ((this.result & Constants.BITMASK[6]) != 0);
/* 3477 */     if (this.tempCarry != this.carry)
/* 3478 */       this.machine.setFlagAndNotify(11);
/*      */     else {
/* 3480 */       this.machine.clearFlagAndNotify(11);
/*      */     }
/*      */ 
/* 3483 */     return null;
/*      */   }
/*      */ 
/*      */   public StopPoint ROL16(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
/*      */   {
/*      */     int i;
/* 3692 */     if (this.machine.debuggingEnabled) {
/* 3693 */       System.out.print("ROL16: Dest: ");
/* 3694 */       for (i = 0; i < paramArrayOfInt1.length; i++) System.out.print(paramArrayOfInt1[i] + " ");
/* 3695 */       System.out.print("\tSrc: ");
/* 3696 */       for (int j = 0; j < paramArrayOfInt2.length; j++) System.out.print(paramArrayOfInt2[j] + " ");
/* 3697 */       System.out.println("");
/*      */     }
/*      */ 
/* 3706 */     if (paramArrayOfInt2[3] == 2) {
/* 3707 */       return new StopPoint(1, "Memory as source in ROL16");
/*      */     }
/*      */ 
/* 3710 */     if (paramArrayOfInt2[3] == 3)
/* 3711 */       this.srcValue = paramArrayOfInt2[0];
/*      */     else {
/* 3713 */       this.srcValue = this.machine.getRegister(22);
/*      */     }
/*      */ 
/* 3719 */     if (paramArrayOfInt1[3] == 2) {
/* 3720 */       this.destValue = this.machine.getMemoryWord(paramArrayOfInt1);
/* 3721 */       this.result = this.destValue;
/* 3722 */       for (i = this.srcValue; i > 0; i--) {
/* 3723 */         this.carry = (this.result > 32767);
/* 3724 */         this.result = (this.result << 1 & 0xFFFF);
/* 3725 */         if (this.carry) this.result += 1;
/*      */       }
/* 3727 */       this.machine.setMemoryWordAndNotify(this.result, paramArrayOfInt1);
/*      */     }
/*      */     else {
/* 3730 */       if (paramArrayOfInt1[3] == 3) {
/* 3731 */         return new StopPoint(1, "Immediate as destination in ROL16");
/*      */       }
/*      */ 
/* 3735 */       this.destValue = this.machine.getRegister(paramArrayOfInt1[2]);
/* 3736 */       this.result = this.destValue;
/* 3737 */       for (i = this.srcValue; i > 0; i--) {
/* 3738 */         this.carry = (this.result > 32767);
/* 3739 */         this.result = (this.result << 1 & 0xFFFF);
/* 3740 */         if (this.carry) this.result += 1;
/*      */       }
/* 3742 */       this.machine.setRegisterAndNotify(this.result, paramArrayOfInt1[2]);
/*      */     }
/*      */ 
/* 3749 */     if (this.machine.debuggingEnabled) {
/* 3750 */       System.out.println("SourceValue: " + this.srcValue + 
/* 3751 */         " DestValue: " + this.destValue + 
/* 3752 */         " Result: " + this.result);
/*      */     }
/*      */ 
/* 3766 */     if (this.carry)
/* 3767 */       this.machine.setFlagAndNotify(0);
/*      */     else {
/* 3769 */       this.machine.clearFlagAndNotify(0);
/*      */     }
/*      */ 
/* 3773 */     this.tempCarry = (this.result > 32767);
/* 3774 */     if (this.tempCarry != this.carry)
/* 3775 */       this.machine.setFlagAndNotify(11);
/*      */     else {
/* 3777 */       this.machine.clearFlagAndNotify(11);
/*      */     }
/*      */ 
/* 3780 */     return null;
/*      */   }
/*      */ 
/*      */   public StopPoint ROL8(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
/*      */   {
/*      */     int i;
/* 3595 */     if (this.machine.debuggingEnabled) {
/* 3596 */       System.out.print("ROL8: Dest: ");
/* 3597 */       for (i = 0; i < paramArrayOfInt1.length; i++) System.out.print(paramArrayOfInt1[i] + " ");
/* 3598 */       System.out.print("\tSrc: ");
/* 3599 */       for (int j = 0; j < paramArrayOfInt2.length; j++) System.out.print(paramArrayOfInt2[j] + " ");
/* 3600 */       System.out.println("");
/*      */     }
/*      */ 
/* 3609 */     if (paramArrayOfInt2[3] == 2) {
/* 3610 */       return new StopPoint(1, "Memory as source in ROL8");
/*      */     }
/*      */ 
/* 3613 */     if (paramArrayOfInt2[3] == 3)
/* 3614 */       this.srcValue = paramArrayOfInt2[0];
/*      */     else {
/* 3616 */       this.srcValue = this.machine.getRegister(22);
/*      */     }
/*      */ 
/* 3622 */     if (paramArrayOfInt1[3] == 2) {
/* 3623 */       this.destValue = this.machine.getMemoryByte(paramArrayOfInt1);
/* 3624 */       this.result = this.destValue;
/* 3625 */       for (i = this.srcValue; i > 0; i--) {
/* 3626 */         this.carry = (this.result > 127);
/* 3627 */         this.result = (this.result << 1 & 0xFF);
/* 3628 */         if (this.carry) this.result += 1;
/*      */       }
/* 3630 */       this.machine.setMemoryByteAndNotify(this.result, paramArrayOfInt1);
/*      */     }
/*      */     else {
/* 3633 */       if (paramArrayOfInt1[3] == 3) {
/* 3634 */         return new StopPoint(1, "Immediate as destination in ROL8");
/*      */       }
/*      */ 
/* 3638 */       this.destValue = this.machine.getRegister(paramArrayOfInt1[2]);
/* 3639 */       this.result = this.destValue;
/* 3640 */       for (i = this.srcValue; i > 0; i--) {
/* 3641 */         this.carry = (this.result > 127);
/* 3642 */         this.result = (this.result << 1 & 0xFF);
/* 3643 */         if (this.carry) this.result += 1;
/*      */       }
/* 3645 */       this.machine.setRegisterAndNotify(this.result, paramArrayOfInt1[2]);
/*      */     }
/*      */ 
/* 3652 */     if (this.machine.debuggingEnabled) {
/* 3653 */       System.out.println("SourceValue: " + this.srcValue + 
/* 3654 */         " DestValue: " + this.destValue + 
/* 3655 */         " Result: " + this.result);
/*      */     }
/*      */ 
/* 3669 */     if (this.carry)
/* 3670 */       this.machine.setFlagAndNotify(0);
/*      */     else {
/* 3672 */       this.machine.clearFlagAndNotify(0);
/*      */     }
/*      */ 
/* 3676 */     this.tempCarry = (this.result > 127);
/* 3677 */     if (this.tempCarry != this.carry)
/* 3678 */       this.machine.setFlagAndNotify(11);
/*      */     else {
/* 3680 */       this.machine.clearFlagAndNotify(11);
/*      */     }
/* 3682 */     return null;
/*      */   }
/*      */ 
/*      */   public StopPoint ROR16(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
/*      */   {
/*      */     int i;
/* 3888 */     if (this.machine.debuggingEnabled) {
/* 3889 */       System.out.print("ROR16: Dest: ");
/* 3890 */       for (i = 0; i < paramArrayOfInt1.length; i++) System.out.print(paramArrayOfInt1[i] + " ");
/* 3891 */       System.out.print("\tSrc: ");
/* 3892 */       for (int j = 0; j < paramArrayOfInt2.length; j++) System.out.print(paramArrayOfInt2[j] + " ");
/* 3893 */       System.out.println("");
/*      */     }
/*      */ 
/* 3902 */     if (paramArrayOfInt2[3] == 2) {
/* 3903 */       return new StopPoint(1, "Memory as source in ROR16");
/*      */     }
/*      */ 
/* 3906 */     if (paramArrayOfInt2[3] == 3)
/* 3907 */       this.srcValue = paramArrayOfInt2[0];
/*      */     else {
/* 3909 */       this.srcValue = this.machine.getRegister(22);
/*      */     }
/*      */ 
/* 3915 */     if (paramArrayOfInt1[3] == 2) {
/* 3916 */       this.destValue = this.machine.getMemoryWord(paramArrayOfInt1);
/* 3917 */       this.result = this.destValue;
/* 3918 */       for (i = this.srcValue; i > 0; i--) {
/* 3919 */         this.carry = ((this.result & Constants.BITMASK[0]) == 1);
/* 3920 */         this.result >>= 1;
/* 3921 */         if (this.carry) this.result += Constants.BITMASK[15];
/*      */       }
/* 3923 */       this.machine.setMemoryWordAndNotify(this.result, paramArrayOfInt1);
/*      */     }
/*      */     else {
/* 3926 */       if (paramArrayOfInt1[3] == 3) {
/* 3927 */         return new StopPoint(1, "Immediate as destination in ROR16");
/*      */       }
/*      */ 
/* 3931 */       this.destValue = this.machine.getRegister(paramArrayOfInt1[2]);
/* 3932 */       this.result = this.destValue;
/* 3933 */       for (i = this.srcValue; i > 0; i--) {
/* 3934 */         this.carry = ((this.result & Constants.BITMASK[0]) == 1);
/* 3935 */         this.result >>= 1;
/* 3936 */         if (this.carry) this.result += Constants.BITMASK[15];
/*      */       }
/* 3938 */       this.machine.setRegisterAndNotify(this.result, paramArrayOfInt1[2]);
/*      */     }
/*      */ 
/* 3945 */     if (this.machine.debuggingEnabled) {
/* 3946 */       System.out.println("SourceValue: " + this.srcValue + 
/* 3947 */         " DestValue: " + this.destValue + 
/* 3948 */         " Result: " + this.result);
/*      */     }
/*      */ 
/* 3962 */     if (this.carry)
/* 3963 */       this.machine.setFlagAndNotify(0);
/*      */     else {
/* 3965 */       this.machine.clearFlagAndNotify(0);
/*      */     }
/*      */ 
/* 3969 */     this.carry = ((this.result & Constants.BITMASK[15]) != 0);
/* 3970 */     this.tempCarry = ((this.result & Constants.BITMASK[14]) != 0);
/* 3971 */     if (this.tempCarry != this.carry)
/* 3972 */       this.machine.setFlagAndNotify(11);
/*      */     else {
/* 3974 */       this.machine.clearFlagAndNotify(11);
/*      */     }
/* 3976 */     return null;
/*      */   }
/*      */ 
/*      */   public StopPoint ROR8(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
/*      */   {
/*      */     int i;
/* 3790 */     if (this.machine.debuggingEnabled) {
/* 3791 */       System.out.print("ROR8: Dest: ");
/* 3792 */       for (i = 0; i < paramArrayOfInt1.length; i++) System.out.print(paramArrayOfInt1[i] + " ");
/* 3793 */       System.out.print("\tSrc: ");
/* 3794 */       for (int j = 0; j < paramArrayOfInt2.length; j++) System.out.print(paramArrayOfInt2[j] + " ");
/* 3795 */       System.out.println("");
/*      */     }
/*      */ 
/* 3804 */     if (paramArrayOfInt2[3] == 2) {
/* 3805 */       return new StopPoint(1, "Memory as source in ROR8");
/*      */     }
/* 3807 */     if (paramArrayOfInt2[3] == 3)
/* 3808 */       this.srcValue = paramArrayOfInt2[0];
/*      */     else {
/* 3810 */       this.srcValue = this.machine.getRegister(22);
/*      */     }
/*      */ 
/* 3816 */     if (paramArrayOfInt1[3] == 2) {
/* 3817 */       this.destValue = this.machine.getMemoryByte(paramArrayOfInt1);
/* 3818 */       this.result = this.destValue;
/* 3819 */       for (i = this.srcValue; i > 0; i--) {
/* 3820 */         this.carry = ((this.result & Constants.BITMASK[0]) == 1);
/* 3821 */         this.result >>= 1;
/* 3822 */         if (this.carry) this.result += Constants.BITMASK[7];
/*      */       }
/* 3824 */       this.machine.setMemoryByteAndNotify(this.result, paramArrayOfInt1);
/*      */     }
/*      */     else {
/* 3827 */       if (paramArrayOfInt1[3] == 3) {
/* 3828 */         return new StopPoint(1, "Immediate as destination in ROR8");
/*      */       }
/*      */ 
/* 3832 */       this.destValue = this.machine.getRegister(paramArrayOfInt1[2]);
/* 3833 */       this.result = this.destValue;
/* 3834 */       for (i = this.srcValue; i > 0; i--) {
/* 3835 */         this.carry = ((this.result & Constants.BITMASK[0]) == 1);
/* 3836 */         this.result >>= 1;
/* 3837 */         if (this.carry) this.result += Constants.BITMASK[7];
/*      */       }
/* 3839 */       this.machine.setRegisterAndNotify(this.result, paramArrayOfInt1[2]);
/*      */     }
/*      */ 
/* 3846 */     if (this.machine.debuggingEnabled) {
/* 3847 */       System.out.println("SourceValue: " + this.srcValue + 
/* 3848 */         " DestValue: " + this.destValue + 
/* 3849 */         " Result: " + this.result);
/*      */     }
/*      */ 
/* 3863 */     if (this.carry)
/* 3864 */       this.machine.setFlagAndNotify(0);
/*      */     else {
/* 3866 */       this.machine.clearFlagAndNotify(0);
/*      */     }
/*      */ 
/* 3870 */     this.carry = ((this.result & Constants.BITMASK[7]) != 0);
/* 3871 */     this.tempCarry = ((this.result & Constants.BITMASK[6]) != 0);
/* 3872 */     if (this.tempCarry != this.carry)
/* 3873 */       this.machine.setFlagAndNotify(11);
/*      */     else {
/* 3875 */       this.machine.clearFlagAndNotify(11);
/*      */     }
/*      */ 
/* 3878 */     return null;
/*      */   }
/*      */ 
/*      */   public StopPoint SALSHL16(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
/*      */   {
/*      */     int i;
/* 4081 */     if (this.machine.debuggingEnabled) {
/* 4082 */       System.out.print("SALSHL16: Dest: ");
/* 4083 */       for (i = 0; i < paramArrayOfInt1.length; i++) System.out.print(paramArrayOfInt1[i] + " ");
/* 4084 */       System.out.print("\tSrc: ");
/* 4085 */       for (int j = 0; j < paramArrayOfInt2.length; j++) System.out.print(paramArrayOfInt2[j] + " ");
/* 4086 */       System.out.println("");
/*      */     }
/*      */ 
/* 4095 */     if (paramArrayOfInt2[3] == 2) {
/* 4096 */       return new StopPoint(1, "Memory as source in SALSHL16");
/*      */     }
/*      */ 
/* 4099 */     if (paramArrayOfInt2[3] == 3)
/* 4100 */       this.srcValue = paramArrayOfInt2[0];
/*      */     else {
/* 4102 */       this.srcValue = this.machine.getRegister(22);
/*      */     }
/*      */ 
/* 4108 */     if (paramArrayOfInt1[3] == 2) {
/* 4109 */       this.destValue = this.machine.getMemoryWord(paramArrayOfInt1);
/* 4110 */       this.result = this.destValue;
/* 4111 */       for (i = this.srcValue; i > 0; i--) {
/* 4112 */         this.carry = (this.result > 32767);
/* 4113 */         this.result = (this.result << 1 & 0xFFFF);
/*      */       }
/* 4115 */       this.machine.setMemoryWordAndNotify(this.result, paramArrayOfInt1);
/*      */     }
/*      */     else {
/* 4118 */       if (paramArrayOfInt1[3] == 3) {
/* 4119 */         return new StopPoint(1, "Immediate as destination in SALSHL16");
/*      */       }
/*      */ 
/* 4122 */       this.destValue = this.machine.getRegister(paramArrayOfInt1[2]);
/* 4123 */       this.result = this.destValue;
/* 4124 */       for (i = this.srcValue; i > 0; i--) {
/* 4125 */         this.carry = (this.result > 32767);
/* 4126 */         this.result = (this.result << 1 & 0xFFFF);
/*      */       }
/* 4128 */       this.machine.setRegisterAndNotify(this.result, paramArrayOfInt1[2]);
/*      */     }
/*      */ 
/* 4135 */     if (this.machine.debuggingEnabled) {
/* 4136 */       System.out.println("SourceValue: " + this.srcValue + 
/* 4137 */         " DestValue: " + this.destValue + 
/* 4138 */         " Result: " + this.result);
/*      */     }
/*      */ 
/* 4152 */     if (this.carry)
/* 4153 */       this.machine.setFlagAndNotify(0);
/*      */     else {
/* 4155 */       this.machine.clearFlagAndNotify(0);
/*      */     }
/*      */ 
/* 4159 */     this.tempCarry = (this.result > 32767);
/* 4160 */     if (this.tempCarry != this.carry)
/* 4161 */       this.machine.setFlagAndNotify(11);
/*      */     else {
/* 4163 */       this.machine.clearFlagAndNotify(11);
/*      */     }
/* 4165 */     return null;
/*      */   }
/*      */ 
/*      */   public StopPoint SALSHL8(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
/*      */   {
/*      */     int i;
/* 3986 */     if (this.machine.debuggingEnabled) {
/* 3987 */       System.out.print("SALSHL8: Dest: ");
/* 3988 */       for (i = 0; i < paramArrayOfInt1.length; i++) System.out.print(paramArrayOfInt1[i] + " ");
/* 3989 */       System.out.print("\tSrc: ");
/* 3990 */       for (int j = 0; j < paramArrayOfInt2.length; j++) System.out.print(paramArrayOfInt2[j] + " ");
/* 3991 */       System.out.println("");
/*      */     }
/*      */ 
/* 4000 */     if (paramArrayOfInt2[3] == 2) {
/* 4001 */       return new StopPoint(1, "Memory as source in SALSHL8");
/*      */     }
/*      */ 
/* 4004 */     if (paramArrayOfInt2[3] == 3)
/* 4005 */       this.srcValue = paramArrayOfInt2[0];
/*      */     else {
/* 4007 */       this.srcValue = this.machine.getRegister(22);
/*      */     }
/*      */ 
/* 4013 */     if (paramArrayOfInt1[3] == 2) {
/* 4014 */       this.destValue = this.machine.getMemoryByte(paramArrayOfInt1);
/* 4015 */       this.result = this.destValue;
/* 4016 */       for (i = this.srcValue; i > 0; i--) {
/* 4017 */         this.carry = (this.result > 127);
/* 4018 */         this.result = (this.result << 1 & 0xFF);
/*      */       }
/* 4020 */       this.machine.setMemoryByteAndNotify(this.result, paramArrayOfInt1);
/*      */     }
/*      */     else {
/* 4023 */       if (paramArrayOfInt1[3] == 3) {
/* 4024 */         return new StopPoint(1, "Immediate as destination in SALSHL8");
/*      */       }
/*      */ 
/* 4028 */       this.destValue = this.machine.getRegister(paramArrayOfInt1[2]);
/* 4029 */       this.result = this.destValue;
/* 4030 */       for (i = this.srcValue; i > 0; i--) {
/* 4031 */         this.carry = (this.result > 127);
/* 4032 */         this.result = (this.result << 1 & 0xFF);
/*      */       }
/* 4034 */       this.machine.setRegisterAndNotify(this.result, paramArrayOfInt1[2]);
/*      */     }
/*      */ 
/* 4041 */     if (this.machine.debuggingEnabled) {
/* 4042 */       System.out.println("SourceValue: " + this.srcValue + 
/* 4043 */         " DestValue: " + this.destValue + 
/* 4044 */         " Result: " + this.result);
/*      */     }
/*      */ 
/* 4058 */     if (this.carry)
/* 4059 */       this.machine.setFlagAndNotify(0);
/*      */     else {
/* 4061 */       this.machine.clearFlagAndNotify(0);
/*      */     }
/*      */ 
/* 4065 */     this.tempCarry = (this.result > 127);
/* 4066 */     if (this.tempCarry != this.carry)
/* 4067 */       this.machine.setFlagAndNotify(11);
/*      */     else {
/* 4069 */       this.machine.clearFlagAndNotify(11);
/*      */     }
/* 4071 */     return null;
/*      */   }
/*      */ 
/*      */   public StopPoint SAR16(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
/*      */   {
/*      */     int i;
/* 4275 */     if (this.machine.debuggingEnabled) {
/* 4276 */       System.out.print("SAR16: Dest: ");
/* 4277 */       for (i = 0; i < paramArrayOfInt1.length; i++) System.out.print(paramArrayOfInt1[i] + " ");
/* 4278 */       System.out.print("\tSrc: ");
/* 4279 */       for (int j = 0; j < paramArrayOfInt2.length; j++) System.out.print(paramArrayOfInt2[j] + " ");
/* 4280 */       System.out.println("");
/*      */     }
/*      */ 
/* 4289 */     if (paramArrayOfInt2[3] == 2) {
/* 4290 */       return new StopPoint(1, "Memory as source in SAR16");
/*      */     }
/*      */ 
/* 4293 */     if (paramArrayOfInt2[3] == 3)
/* 4294 */       this.srcValue = paramArrayOfInt2[0];
/*      */     else {
/* 4296 */       this.srcValue = this.machine.getRegister(22);
/*      */     }
/*      */ 
/* 4302 */     if (paramArrayOfInt1[3] == 2) {
/* 4303 */       this.destValue = this.machine.getMemoryWord(paramArrayOfInt1);
/* 4304 */       this.result = this.destValue;
/* 4305 */       for (i = this.srcValue; i > 0; i--) {
/* 4306 */         this.carry = ((this.result & Constants.BITMASK[0]) == 1);
/* 4307 */         this.tempCarry = ((this.result & Constants.BITMASK[15]) == 1);
/* 4308 */         this.result >>= 1;
/* 4309 */         if (this.tempCarry) this.result += Constants.BITMASK[15];
/*      */       }
/* 4311 */       this.machine.setMemoryWordAndNotify(this.result, paramArrayOfInt1);
/*      */     }
/*      */     else {
/* 4314 */       if (paramArrayOfInt1[3] == 3) {
/* 4315 */         return new StopPoint(1, "Immediate as destination in SAR16");
/*      */       }
/*      */ 
/* 4318 */       this.destValue = this.machine.getRegister(paramArrayOfInt1[2]);
/* 4319 */       this.result = this.destValue;
/* 4320 */       for (i = this.srcValue; i > 0; i--) {
/* 4321 */         this.carry = ((this.result & Constants.BITMASK[0]) == 1);
/* 4322 */         this.tempCarry = ((this.result & Constants.BITMASK[15]) == 1);
/* 4323 */         this.result >>= 1;
/* 4324 */         if (this.tempCarry) this.result += Constants.BITMASK[15];
/*      */       }
/* 4326 */       this.machine.setRegisterAndNotify(this.result, paramArrayOfInt1[2]);
/*      */     }
/*      */ 
/* 4333 */     if (this.machine.debuggingEnabled) {
/* 4334 */       System.out.println("SourceValue: " + this.srcValue + 
/* 4335 */         " DestValue: " + this.destValue + 
/* 4336 */         " Result: " + this.result);
/*      */     }
/*      */ 
/* 4350 */     if (this.carry)
/* 4351 */       this.machine.setFlagAndNotify(0);
/*      */     else {
/* 4353 */       this.machine.clearFlagAndNotify(0);
/*      */     }
/*      */ 
/* 4357 */     this.carry = ((this.result & Constants.BITMASK[15]) != 0);
/* 4358 */     this.tempCarry = ((this.result & Constants.BITMASK[14]) != 0);
/* 4359 */     if (this.tempCarry != this.carry)
/* 4360 */       this.machine.setFlagAndNotify(11);
/*      */     else {
/* 4362 */       this.machine.clearFlagAndNotify(11);
/*      */     }
/* 4364 */     return null;
/*      */   }
/*      */ 
/*      */   public StopPoint SAR8(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
/*      */   {
/*      */     int i;
/* 4175 */     if (this.machine.debuggingEnabled) {
/* 4176 */       System.out.print("SAR8: Dest: ");
/* 4177 */       for (i = 0; i < paramArrayOfInt1.length; i++) System.out.print(paramArrayOfInt1[i] + " ");
/* 4178 */       System.out.print("\tSrc: ");
/* 4179 */       for (int j = 0; j < paramArrayOfInt2.length; j++) System.out.print(paramArrayOfInt2[j] + " ");
/* 4180 */       System.out.println("");
/*      */     }
/*      */ 
/* 4189 */     if (paramArrayOfInt2[3] == 2) {
/* 4190 */       return new StopPoint(1, "Memory as source in SAR8");
/*      */     }
/*      */ 
/* 4193 */     if (paramArrayOfInt2[3] == 3)
/* 4194 */       this.srcValue = paramArrayOfInt2[0];
/*      */     else {
/* 4196 */       this.srcValue = this.machine.getRegister(22);
/*      */     }
/*      */ 
/* 4202 */     if (paramArrayOfInt1[3] == 2) {
/* 4203 */       this.destValue = this.machine.getMemoryByte(paramArrayOfInt1);
/* 4204 */       this.result = this.destValue;
/* 4205 */       for (i = this.srcValue; i > 0; i--) {
/* 4206 */         this.carry = ((this.result & Constants.BITMASK[0]) == 1);
/* 4207 */         this.tempCarry = ((this.result & Constants.BITMASK[7]) == 1);
/* 4208 */         this.result >>= 1;
/* 4209 */         if (this.tempCarry) this.result += Constants.BITMASK[7];
/*      */       }
/* 4211 */       this.machine.setMemoryByteAndNotify(this.result, paramArrayOfInt1);
/*      */     }
/*      */     else {
/* 4214 */       if (paramArrayOfInt1[3] == 3) {
/* 4215 */         return new StopPoint(1, "Immediate as destination in SAR8");
/*      */       }
/*      */ 
/* 4219 */       this.destValue = this.machine.getRegister(paramArrayOfInt1[2]);
/* 4220 */       this.result = this.destValue;
/* 4221 */       for (i = this.srcValue; i > 0; i--) {
/* 4222 */         this.carry = ((this.result & Constants.BITMASK[0]) == 1);
/* 4223 */         this.tempCarry = ((this.result & Constants.BITMASK[7]) == 1);
/* 4224 */         this.result >>= 1;
/* 4225 */         if (this.tempCarry) this.result += Constants.BITMASK[7];
/*      */       }
/* 4227 */       this.machine.setRegisterAndNotify(this.result, paramArrayOfInt1[2]);
/*      */     }
/*      */ 
/* 4234 */     if (this.machine.debuggingEnabled) {
/* 4235 */       System.out.println("SourceValue: " + this.srcValue + 
/* 4236 */         " DestValue: " + this.destValue + 
/* 4237 */         " Result: " + this.result);
/*      */     }
/*      */ 
/* 4251 */     if (this.carry)
/* 4252 */       this.machine.setFlagAndNotify(0);
/*      */     else {
/* 4254 */       this.machine.clearFlagAndNotify(0);
/*      */     }
/*      */ 
/* 4258 */     this.carry = ((this.result & Constants.BITMASK[7]) != 0);
/* 4259 */     this.tempCarry = ((this.result & Constants.BITMASK[6]) != 0);
/* 4260 */     if (this.tempCarry != this.carry)
/* 4261 */       this.machine.setFlagAndNotify(11);
/*      */     else {
/* 4263 */       this.machine.clearFlagAndNotify(11);
/*      */     }
/* 4265 */     return null;
/*      */   }
/*      */ 
/*      */   public StopPoint SBB16(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
/*      */   {
/* 4505 */     if (this.machine.debuggingEnabled) {
/* 4506 */       System.out.print("SBB16: Dest: ");
/* 4507 */       for (int i = 0; i < paramArrayOfInt1.length; i++) System.out.print(paramArrayOfInt1[i] + " ");
/* 4508 */       System.out.print("\tSrc: ");
/* 4509 */       for (int j = 0; j < paramArrayOfInt2.length; j++) System.out.print(paramArrayOfInt2[j] + " ");
/* 4510 */       System.out.println("");
/*      */     }
/*      */ 
/* 4518 */     if (paramArrayOfInt2[3] == 2)
/* 4519 */       this.srcValue = this.machine.getMemoryWord(paramArrayOfInt2);
/* 4520 */     else if (paramArrayOfInt2[3] == 3)
/* 4521 */       this.srcValue = paramArrayOfInt2[0];
/*      */     else
/* 4523 */       this.srcValue = this.machine.getRegister(paramArrayOfInt2[2]);
/* 4524 */     if (this.machine.getFlag(0)) this.srcValue += 1;
/*      */ 
/* 4531 */     if (paramArrayOfInt1[3] == 2) {
/* 4532 */       this.destValue = this.machine.getMemoryWord(paramArrayOfInt1);
/* 4533 */       this.result = (this.destValue - this.srcValue);
/* 4534 */       this.finalResult = (this.result & 0xFFFF);
/* 4535 */       this.machine.setMemoryWordAndNotify(this.finalResult, paramArrayOfInt1);
/*      */     }
/*      */     else {
/* 4538 */       if (paramArrayOfInt1[3] == 3) {
/* 4539 */         return new StopPoint(1, "Immediate as destination in SBB16");
/*      */       }
/*      */ 
/* 4543 */       this.destValue = this.machine.getRegister(paramArrayOfInt1[2]);
/* 4544 */       this.result = (this.destValue - this.srcValue);
/* 4545 */       this.finalResult = (this.result & 0xFFFF);
/* 4546 */       this.machine.setRegisterAndNotify(this.finalResult, paramArrayOfInt1[2]);
/*      */     }
/*      */ 
/* 4553 */     if (this.machine.debuggingEnabled) {
/* 4554 */       System.out.println("SourceValue: " + this.srcValue + 
/* 4555 */         " DestValue: " + this.destValue + 
/* 4556 */         " Result: " + this.result + 
/* 4557 */         " Final Result: " + this.finalResult);
/*      */     }
/*      */ 
/* 4570 */     if (this.result != this.finalResult)
/* 4571 */       this.machine.setFlagAndNotify(0);
/*      */     else {
/* 4573 */       this.machine.clearFlagAndNotify(0);
/*      */     }
/*      */ 
/* 4577 */     if ((this.destValue & 0xF) - (this.srcValue & 0xF) < 0)
/* 4578 */       this.machine.setFlagAndNotify(4);
/*      */     else {
/* 4580 */       this.machine.clearFlagAndNotify(4);
/*      */     }
/*      */ 
/* 4590 */     int i = this.srcValue <= 32767 ? 0 : 1;
/* 4591 */     int j = this.destValue > 32767 ? 0 : 1;
/* 4592 */     int k = this.finalResult > 32767 ? 0 : 1;
/*      */ 
/* 4594 */     if (((i != 0) && (j != 0) && (k == 0)) || ((i == 0) && (j == 0) && (k != 0)))
/* 4595 */       this.machine.setFlagAndNotify(11);
/*      */     else {
/* 4597 */       this.machine.clearFlagAndNotify(11);
/*      */     }
/*      */ 
/* 4601 */     this.numberOfOnes = 0;
/* 4602 */     for (int m = 0; m < 8; m++)
/* 4603 */       this.numberOfOnes += ((this.result & Constants.BITMASK[m]) >> m);
/* 4604 */     if (this.numberOfOnes % 2 == 0)
/* 4605 */       this.machine.setFlagAndNotify(2);
/*      */     else {
/* 4607 */       this.machine.clearFlagAndNotify(2);
/*      */     }
/*      */ 
/* 4611 */     if (k == 0)
/* 4612 */       this.machine.setFlagAndNotify(7);
/*      */     else {
/* 4614 */       this.machine.clearFlagAndNotify(7);
/*      */     }
/*      */ 
/* 4618 */     if (this.finalResult == 0)
/* 4619 */       this.machine.setFlagAndNotify(6);
/*      */     else {
/* 4621 */       this.machine.clearFlagAndNotify(6);
/*      */     }
/* 4623 */     return null;
/*      */   }
/*      */ 
/*      */   public StopPoint SBB8(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
/*      */   {
/* 4374 */     if (this.machine.debuggingEnabled) {
/* 4375 */       System.out.print("SBB8: Dest: ");
/* 4376 */       for (int i = 0; i < paramArrayOfInt1.length; i++) System.out.print(paramArrayOfInt1[i] + " ");
/* 4377 */       System.out.print("\tSrc: ");
/* 4378 */       for (int j = 0; j < paramArrayOfInt2.length; j++) System.out.print(paramArrayOfInt2[j] + " ");
/* 4379 */       System.out.println("");
/*      */     }
/*      */ 
/* 4388 */     if (paramArrayOfInt2[3] == 2)
/* 4389 */       this.srcValue = this.machine.getMemoryByte(paramArrayOfInt2);
/* 4390 */     else if (paramArrayOfInt2[3] == 3)
/* 4391 */       this.srcValue = paramArrayOfInt2[0];
/*      */     else
/* 4393 */       this.srcValue = this.machine.getRegister(paramArrayOfInt2[2]);
/* 4394 */     if (this.machine.getFlag(0)) this.srcValue += 1;
/*      */ 
/* 4401 */     if (paramArrayOfInt1[3] == 2) {
/* 4402 */       this.destValue = this.machine.getMemoryByte(paramArrayOfInt1);
/* 4403 */       this.result = (this.destValue - this.srcValue);
/* 4404 */       this.finalResult = (this.result & 0xFF);
/* 4405 */       this.machine.setMemoryByteAndNotify(this.finalResult, paramArrayOfInt1);
/*      */     }
/*      */     else {
/* 4408 */       if (paramArrayOfInt1[3] == 3) {
/* 4409 */         return new StopPoint(1, "Immediate as destination in SBB8");
/*      */       }
/*      */ 
/* 4413 */       this.destValue = this.machine.getRegister(paramArrayOfInt1[2]);
/* 4414 */       this.result = (this.destValue - this.srcValue);
/* 4415 */       this.finalResult = (this.result & 0xFF);
/* 4416 */       this.machine.setRegisterAndNotify(this.finalResult, paramArrayOfInt1[2]);
/*      */     }
/*      */ 
/* 4423 */     if (this.machine.debuggingEnabled) {
/* 4424 */       System.out.println("SourceValue: " + this.srcValue + 
/* 4425 */         " DestValue: " + this.destValue + 
/* 4426 */         " Result: " + this.result + 
/* 4427 */         " Final Result: " + this.finalResult);
/*      */     }
/*      */ 
/* 4441 */     if (this.result != this.finalResult)
/* 4442 */       this.machine.setFlagAndNotify(0);
/*      */     else {
/* 4444 */       this.machine.clearFlagAndNotify(0);
/*      */     }
/*      */ 
/* 4448 */     if ((this.destValue & 0xF) - (this.srcValue & 0xF) < 0)
/* 4449 */       this.machine.setFlagAndNotify(4);
/*      */     else {
/* 4451 */       this.machine.clearFlagAndNotify(4);
/*      */     }
/*      */ 
/* 4461 */     int i = this.srcValue <= 127 ? 0 : 1;
/* 4462 */     int j = this.destValue > 127 ? 0 : 1;
/* 4463 */     int k = this.finalResult > 127 ? 0 : 1;
/*      */ 
/* 4465 */     if (((i != 0) && (j != 0) && (k == 0)) || ((i == 0) && (j == 0) && (k != 0)))
/* 4466 */       this.machine.setFlagAndNotify(11);
/*      */     else {
/* 4468 */       this.machine.clearFlagAndNotify(11);
/*      */     }
/*      */ 
/* 4472 */     this.numberOfOnes = 0;
/* 4473 */     for (int m = 0; m < 8; m++)
/* 4474 */       this.numberOfOnes += ((this.result & Constants.BITMASK[m]) >> m);
/* 4475 */     if (this.numberOfOnes % 2 == 0)
/* 4476 */       this.machine.setFlagAndNotify(2);
/*      */     else {
/* 4478 */       this.machine.clearFlagAndNotify(2);
/*      */     }
/*      */ 
/* 4482 */     if (k == 0)
/* 4483 */       this.machine.setFlagAndNotify(7);
/*      */     else {
/* 4485 */       this.machine.clearFlagAndNotify(7);
/*      */     }
/*      */ 
/* 4489 */     if (this.finalResult == 0)
/* 4490 */       this.machine.setFlagAndNotify(6);
/*      */     else {
/* 4492 */       this.machine.clearFlagAndNotify(6);
/*      */     }
/*      */ 
/* 4495 */     return null;
/*      */   }
/*      */ 
/*      */   public StopPoint SCAS16(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
/*      */   {
/* 4755 */     paramArrayOfInt1[0] = this.machine.getRegister(12);
/* 4756 */     paramArrayOfInt1[1] = this.machine.getRegister(7);
/*      */ 
/* 4760 */     if (this.machine.debuggingEnabled) {
/* 4761 */       System.out.println("SCAS16: Dest: " + paramArrayOfInt1[0]);
/*      */     }
/*      */ 
/* 4769 */     this.destValue = this.machine.getMemoryWord(paramArrayOfInt1);
/* 4770 */     this.srcValue = this.machine.getRegister(0);
/*      */ 
/* 4776 */     if (this.machine.getFlag(10)) {
/* 4777 */       this.machine.incDIAndNotify(-2);
/*      */     }
/*      */     else {
/* 4780 */       this.machine.incDIAndNotify(2);
/*      */     }
/*      */ 
/* 4787 */     this.result = (this.srcValue - this.destValue);
/* 4788 */     this.finalResult = (this.result & 0xFFFF);
/*      */ 
/* 4792 */     if (this.machine.debuggingEnabled) {
/* 4793 */       System.out.println("SourceValue: " + this.srcValue + 
/* 4794 */         " DestValue: " + this.destValue + 
/* 4795 */         " Result: " + this.result + 
/* 4796 */         " Final Result: " + this.finalResult);
/*      */     }
/*      */ 
/* 4809 */     if (this.result != this.finalResult)
/* 4810 */       this.machine.setFlagAndNotify(0);
/*      */     else {
/* 4812 */       this.machine.clearFlagAndNotify(0);
/*      */     }
/*      */ 
/* 4816 */     if ((this.srcValue & 0xF) - (this.destValue & 0xF) < 0)
/* 4817 */       this.machine.setFlagAndNotify(4);
/*      */     else {
/* 4819 */       this.machine.clearFlagAndNotify(4);
/*      */     }
/*      */ 
/* 4829 */     int i = this.srcValue > 32767 ? 0 : 1;
/* 4830 */     int j = this.destValue <= 32767 ? 0 : 1;
/* 4831 */     int k = this.finalResult > 32767 ? 0 : 1;
/*      */ 
/* 4833 */     if (((i != 0) && (j != 0) && (k == 0)) || ((i == 0) && (j == 0) && (k != 0)))
/* 4834 */       this.machine.setFlagAndNotify(11);
/*      */     else {
/* 4836 */       this.machine.clearFlagAndNotify(11);
/*      */     }
/*      */ 
/* 4840 */     this.numberOfOnes = 0;
/* 4841 */     for (int m = 0; m < 8; m++)
/* 4842 */       this.numberOfOnes += ((this.result & Constants.BITMASK[m]) >> m);
/* 4843 */     if (this.numberOfOnes % 2 == 0)
/* 4844 */       this.machine.setFlagAndNotify(2);
/*      */     else {
/* 4846 */       this.machine.clearFlagAndNotify(2);
/*      */     }
/*      */ 
/* 4850 */     if (k == 0)
/* 4851 */       this.machine.setFlagAndNotify(7);
/*      */     else {
/* 4853 */       this.machine.clearFlagAndNotify(7);
/*      */     }
/*      */ 
/* 4857 */     if (this.finalResult == 0)
/* 4858 */       this.machine.setFlagAndNotify(6);
/*      */     else {
/* 4860 */       this.machine.clearFlagAndNotify(6);
/*      */     }
/*      */ 
/* 4863 */     return null;
/*      */   }
/*      */ 
/*      */   public StopPoint SCAS8(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
/*      */   {
/* 4635 */     paramArrayOfInt1[0] = this.machine.getRegister(12);
/* 4636 */     paramArrayOfInt1[1] = this.machine.getRegister(7);
/*      */ 
/* 4640 */     if (this.machine.debuggingEnabled) {
/* 4641 */       System.out.println("SCAS8: Dest: " + paramArrayOfInt1[0]);
/*      */     }
/*      */ 
/* 4649 */     this.destValue = this.machine.getMemoryByte(paramArrayOfInt1);
/* 4650 */     this.srcValue = this.machine.getRegister(20);
/*      */ 
/* 4656 */     if (this.machine.getFlag(10)) {
/* 4657 */       this.machine.incDIAndNotify(-1);
/*      */     }
/*      */     else {
/* 4660 */       this.machine.incDIAndNotify(1);
/*      */     }
/*      */ 
/* 4667 */     this.result = (this.srcValue - this.destValue);
/* 4668 */     this.finalResult = (this.result & 0xFFFF);
/*      */ 
/* 4672 */     if (this.machine.debuggingEnabled) {
/* 4673 */       System.out.println("SourceValue: " + this.srcValue + 
/* 4674 */         " DestValue: " + this.destValue + 
/* 4675 */         " Result: " + this.result + 
/* 4676 */         " Final Result: " + this.finalResult);
/*      */     }
/*      */ 
/* 4689 */     if (this.result != this.finalResult)
/* 4690 */       this.machine.setFlagAndNotify(0);
/*      */     else {
/* 4692 */       this.machine.clearFlagAndNotify(0);
/*      */     }
/*      */ 
/* 4696 */     if ((this.srcValue & 0xF) - (this.destValue & 0xF) < 0)
/* 4697 */       this.machine.setFlagAndNotify(4);
/*      */     else {
/* 4699 */       this.machine.clearFlagAndNotify(4);
/*      */     }
/*      */ 
/* 4709 */     int i = this.srcValue > 127 ? 0 : 1;
/* 4710 */     int j = this.destValue <= 127 ? 0 : 1;
/* 4711 */     int k = this.finalResult > 127 ? 0 : 1;
/*      */ 
/* 4713 */     if (((i != 0) && (j != 0) && (k == 0)) || ((i == 0) && (j == 0) && (k != 0)))
/* 4714 */       this.machine.setFlagAndNotify(11);
/*      */     else {
/* 4716 */       this.machine.clearFlagAndNotify(11);
/*      */     }
/*      */ 
/* 4720 */     this.numberOfOnes = 0;
/* 4721 */     for (int m = 0; m < 8; m++)
/* 4722 */       this.numberOfOnes += ((this.result & Constants.BITMASK[m]) >> m);
/* 4723 */     if (this.numberOfOnes % 2 == 0)
/* 4724 */       this.machine.setFlagAndNotify(2);
/*      */     else {
/* 4726 */       this.machine.clearFlagAndNotify(2);
/*      */     }
/*      */ 
/* 4730 */     if (k == 0)
/* 4731 */       this.machine.setFlagAndNotify(7);
/*      */     else {
/* 4733 */       this.machine.clearFlagAndNotify(7);
/*      */     }
/*      */ 
/* 4737 */     if (this.finalResult == 0)
/* 4738 */       this.machine.setFlagAndNotify(6);
/*      */     else {
/* 4740 */       this.machine.clearFlagAndNotify(6);
/*      */     }
/*      */ 
/* 4743 */     return null;
/*      */   }
/*      */ 
/*      */   public StopPoint SHR16(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
/*      */   {
/* 4987 */     if (this.machine.debuggingEnabled) {
/* 4988 */       System.out.print("SHR16: Dest: ");
/* 4989 */       for (int i = 0; i < paramArrayOfInt1.length; i++) System.out.print(paramArrayOfInt1[i] + " ");
/* 4990 */       System.out.print("\tSrc: ");
/* 4991 */       for (int j = 0; j < paramArrayOfInt2.length; j++) System.out.print(paramArrayOfInt2[j] + " ");
/* 4992 */       System.out.println("");
/*      */     }
/*      */ 
/* 5001 */     if (paramArrayOfInt2[3] == 2) {
/* 5002 */       return new StopPoint(1, "Memory as source in SHR16");
/*      */     }
/*      */ 
/* 5005 */     if (paramArrayOfInt2[3] == 3)
/* 5006 */       this.srcValue = paramArrayOfInt2[0];
/*      */     else {
/* 5008 */       this.srcValue = this.machine.getRegister(22);
/*      */     }
/*      */ 
/* 5014 */     if (paramArrayOfInt1[3] == 2) {
/* 5015 */       this.destValue = this.machine.getMemoryWord(paramArrayOfInt1);
/* 5016 */       this.result = this.destValue;
/* 5017 */       for (int i = this.srcValue; i > 0; i--) {
/* 5018 */         this.carry = ((this.result & Constants.BITMASK[0]) == 1);
/* 5019 */         this.result >>= 1;
/*      */       }
/* 5021 */       this.machine.setMemoryWordAndNotify(this.result, paramArrayOfInt1);
/*      */     }
/*      */     else {
/* 5024 */       if (paramArrayOfInt1[3] == 3) {
/* 5025 */         return new StopPoint(1, "Immediate as destination in SHR16");
/*      */       }
/*      */ 
/* 5029 */       this.destValue = this.machine.getRegister(paramArrayOfInt1[2]);
/* 5030 */       this.result = this.destValue;
/* 5031 */       for (int i = this.srcValue; i > 0; i--) {
/* 5032 */         this.carry = ((this.result & Constants.BITMASK[0]) == 1);
/* 5033 */         this.result >>= 1;
/*      */       }
/* 5035 */       this.machine.setRegisterAndNotify(this.result, paramArrayOfInt1[2]);
/*      */     }
/*      */ 
/* 5042 */     if (this.machine.debuggingEnabled) {
/* 5043 */       System.out.println("SourceValue: " + this.srcValue + 
/* 5044 */         " DestValue: " + this.destValue + 
/* 5045 */         " Result: " + this.result);
/*      */     }
/*      */ 
/* 5059 */     if (this.carry)
/* 5060 */       this.machine.setFlagAndNotify(0);
/*      */     else {
/* 5062 */       this.machine.clearFlagAndNotify(0);
/*      */     }
/*      */ 
/* 5066 */     if ((this.destValue & Constants.BITMASK[15]) != 0)
/* 5067 */       this.machine.setFlagAndNotify(11);
/*      */     else {
/* 5069 */       this.machine.clearFlagAndNotify(11);
/*      */     }
/*      */ 
/* 5073 */     this.numberOfOnes = 0;
/* 5074 */     for (int i = 0; i < 15; i++)
/* 5075 */       this.numberOfOnes += ((this.result & Constants.BITMASK[i]) >> i);
/* 5076 */     if (this.numberOfOnes % 2 == 0)
/* 5077 */       this.machine.setFlagAndNotify(2);
/*      */     else {
/* 5079 */       this.machine.clearFlagAndNotify(2);
/*      */     }
/*      */ 
/* 5083 */     this.machine.clearFlagAndNotify(7);
/*      */ 
/* 5087 */     if (this.result == 0)
/* 5088 */       this.machine.setFlagAndNotify(6);
/*      */     else {
/* 5090 */       this.machine.clearFlagAndNotify(6);
/*      */     }
/*      */ 
/* 5093 */     return null;
/*      */   }
/*      */ 
/*      */   public StopPoint SHR8(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
/*      */   {
/* 4873 */     if (this.machine.debuggingEnabled) {
/* 4874 */       System.out.print("SHR8: Dest: ");
/* 4875 */       for (int i = 0; i < paramArrayOfInt1.length; i++) System.out.print(paramArrayOfInt1[i] + " ");
/* 4876 */       System.out.print("\tSrc: ");
/* 4877 */       for (int j = 0; j < paramArrayOfInt2.length; j++) System.out.print(paramArrayOfInt2[j] + " ");
/* 4878 */       System.out.println("");
/*      */     }
/*      */ 
/* 4887 */     if (paramArrayOfInt2[3] == 2) {
/* 4888 */       return new StopPoint(1, "Memory as source in SHR8");
/*      */     }
/*      */ 
/* 4891 */     if (paramArrayOfInt2[3] == 3)
/* 4892 */       this.srcValue = paramArrayOfInt2[0];
/*      */     else {
/* 4894 */       this.srcValue = this.machine.getRegister(22);
/*      */     }
/*      */ 
/* 4900 */     if (paramArrayOfInt1[3] == 2) {
/* 4901 */       this.destValue = this.machine.getMemoryByte(paramArrayOfInt1);
/* 4902 */       this.result = this.destValue;
/* 4903 */       for (int i = this.srcValue; i > 0; i--) {
/* 4904 */         this.carry = ((this.result & Constants.BITMASK[0]) == 1);
/* 4905 */         this.result >>= 1;
/*      */       }
/* 4907 */       this.machine.setMemoryByteAndNotify(this.result, paramArrayOfInt1);
/*      */     }
/*      */     else {
/* 4910 */       if (paramArrayOfInt1[3] == 3) {
/* 4911 */         return new StopPoint(1, "Immediate as destination in SHR8");
/*      */       }
/*      */ 
/* 4915 */       this.destValue = this.machine.getRegister(paramArrayOfInt1[2]);
/* 4916 */       this.result = this.destValue;
/* 4917 */       for (int i = this.srcValue; i > 0; i--) {
/* 4918 */         this.carry = ((this.result & Constants.BITMASK[0]) == 1);
/* 4919 */         this.result >>= 1;
/*      */       }
/* 4921 */       this.machine.setRegisterAndNotify(this.result, paramArrayOfInt1[2]);
/*      */     }
/*      */ 
/* 4928 */     if (this.machine.debuggingEnabled) {
/* 4929 */       System.out.println("SourceValue: " + this.srcValue + 
/* 4930 */         " DestValue: " + this.destValue + 
/* 4931 */         " Result: " + this.result);
/*      */     }
/*      */ 
/* 4943 */     if (this.carry)
/* 4944 */       this.machine.setFlagAndNotify(0);
/*      */     else {
/* 4946 */       this.machine.clearFlagAndNotify(0);
/*      */     }
/*      */ 
/* 4950 */     if ((this.destValue & Constants.BITMASK[7]) != 0)
/* 4951 */       this.machine.setFlagAndNotify(11);
/*      */     else {
/* 4953 */       this.machine.clearFlagAndNotify(11);
/*      */     }
/*      */ 
/* 4957 */     this.numberOfOnes = 0;
/* 4958 */     for (int i = 0; i < 7; i++)
/* 4959 */       this.numberOfOnes += ((this.result & Constants.BITMASK[i]) >> i);
/* 4960 */     if (this.numberOfOnes % 2 == 0)
/* 4961 */       this.machine.setFlagAndNotify(2);
/*      */     else {
/* 4963 */       this.machine.clearFlagAndNotify(2);
/*      */     }
/*      */ 
/* 4967 */     this.machine.clearFlagAndNotify(7);
/*      */ 
/* 4971 */     if (this.result == 0)
/* 4972 */       this.machine.setFlagAndNotify(6);
/*      */     else {
/* 4974 */       this.machine.clearFlagAndNotify(6);
/*      */     }
/*      */ 
/* 4977 */     return null;
/*      */   }
/*      */ 
/*      */   public StopPoint STOS16(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
/*      */   {
/* 5161 */     paramArrayOfInt1[0] = this.machine.getRegister(12);
/* 5162 */     paramArrayOfInt1[1] = this.machine.getRegister(7);
/*      */ 
/* 5166 */     if (this.machine.debuggingEnabled) {
/* 5167 */       System.out.println("STOS16: Dest: " + paramArrayOfInt1[0]);
/*      */     }
/*      */ 
/* 5175 */     this.srcValue = this.machine.getRegister(20);
/*      */ 
/* 5179 */     if (this.machine.debuggingEnabled) {
/* 5180 */       System.out.println("SrcValue: " + this.srcValue);
/*      */     }
/*      */ 
/* 5187 */     this.machine.setMemoryWordAndNotify(this.srcValue, paramArrayOfInt1);
/*      */ 
/* 5193 */     if (this.machine.getFlag(10)) {
/* 5194 */       this.machine.incDIAndNotify(-2);
/*      */     }
/*      */     else {
/* 5197 */       this.machine.incDIAndNotify(2);
/*      */     }
/*      */ 
/* 5204 */     return null;
/*      */   }
/*      */ 
/*      */   public StopPoint STOS8(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
/*      */   {
/* 5105 */     paramArrayOfInt1[0] = this.machine.getRegister(12);
/* 5106 */     paramArrayOfInt1[1] = this.machine.getRegister(7);
/*      */ 
/* 5110 */     if (this.machine.debuggingEnabled) {
/* 5111 */       System.out.println("STOS8: Dest: " + paramArrayOfInt1[0]);
/*      */     }
/*      */ 
/* 5119 */     this.srcValue = this.machine.getRegister(20);
/*      */ 
/* 5123 */     if (this.machine.debuggingEnabled) {
/* 5124 */       System.out.println("SrcValue: " + this.srcValue);
/*      */     }
/*      */ 
/* 5131 */     this.machine.setMemoryByteAndNotify(this.srcValue, paramArrayOfInt1);
/*      */ 
/* 5137 */     if (this.machine.getFlag(10)) {
/* 5138 */       this.machine.incDIAndNotify(-1);
/*      */     }
/*      */     else {
/* 5141 */       this.machine.incDIAndNotify(1);
/*      */     }
/*      */ 
/* 5149 */     return null;
/*      */   }
/*      */ 
/*      */   public StopPoint SUB16(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
/*      */   {
/* 5344 */     if (this.machine.debuggingEnabled) {
/* 5345 */       System.out.print("SUB16: Dest: ");
/* 5346 */       for (int i = 0; i < paramArrayOfInt1.length; i++) System.out.print(paramArrayOfInt1[i] + " ");
/* 5347 */       System.out.print("\tSrc: ");
/* 5348 */       for (int j = 0; j < paramArrayOfInt2.length; j++) System.out.print(paramArrayOfInt2[j] + " ");
/* 5349 */       System.out.println("");
/*      */     }
/*      */ 
/* 5357 */     if (paramArrayOfInt2[3] == 2)
/* 5358 */       this.srcValue = this.machine.getMemoryWord(paramArrayOfInt2);
/* 5359 */     else if (paramArrayOfInt2[3] == 3)
/* 5360 */       this.srcValue = paramArrayOfInt2[0];
/*      */     else {
/* 5362 */       this.srcValue = this.machine.getRegister(paramArrayOfInt2[2]);
/*      */     }
/*      */ 
/* 5369 */     if (paramArrayOfInt1[3] == 2) {
/* 5370 */       this.destValue = this.machine.getMemoryWord(paramArrayOfInt1);
/* 5371 */       this.result = (this.destValue - this.srcValue);
/* 5372 */       this.finalResult = (this.result & 0xFFFF);
/* 5373 */       this.machine.setMemoryWordAndNotify(this.finalResult, paramArrayOfInt1);
/*      */     }
/*      */     else {
/* 5376 */       if (paramArrayOfInt1[3] == 3) {
/* 5377 */         return new StopPoint(1, "Immediate as destination in SUB16");
/*      */       }
/*      */ 
/* 5381 */       this.destValue = this.machine.getRegister(paramArrayOfInt1[2]);
/* 5382 */       this.result = (this.destValue - this.srcValue);
/* 5383 */       this.finalResult = (this.result & 0xFFFF);
/* 5384 */       this.machine.setRegisterAndNotify(this.finalResult, paramArrayOfInt1[2]);
/*      */     }
/*      */ 
/* 5391 */     if (this.machine.debuggingEnabled) {
/* 5392 */       System.out.println("SourceValue: " + this.srcValue + 
/* 5393 */         " DestValue: " + this.destValue + 
/* 5394 */         " Result: " + this.result + 
/* 5395 */         " Final Result: " + this.finalResult);
/*      */     }
/*      */ 
/* 5409 */     if (this.result != this.finalResult)
/* 5410 */       this.machine.setFlagAndNotify(0);
/*      */     else {
/* 5412 */       this.machine.clearFlagAndNotify(0);
/*      */     }
/*      */ 
/* 5416 */     if ((this.destValue & 0xF) - (this.srcValue & 0xF) < 0)
/* 5417 */       this.machine.setFlagAndNotify(4);
/*      */     else {
/* 5419 */       this.machine.clearFlagAndNotify(4);
/*      */     }
/*      */ 
/* 5429 */     int i = this.srcValue <= 32767 ? 0 : 1;
/* 5430 */     int j = this.destValue > 32767 ? 0 : 1;
/* 5431 */     int k = this.finalResult > 32767 ? 0 : 1;
/*      */ 
/* 5433 */     if (((i != 0) && (j != 0) && (k == 0)) || ((i == 0) && (j == 0) && (k != 0)))
/* 5434 */       this.machine.setFlagAndNotify(11);
/*      */     else {
/* 5436 */       this.machine.clearFlagAndNotify(11);
/*      */     }
/*      */ 
/* 5440 */     this.numberOfOnes = 0;
/* 5441 */     for (int m = 0; m < 8; m++)
/* 5442 */       this.numberOfOnes += ((this.result & Constants.BITMASK[m]) >> m);
/* 5443 */     if (this.numberOfOnes % 2 == 0)
/* 5444 */       this.machine.setFlagAndNotify(2);
/*      */     else {
/* 5446 */       this.machine.clearFlagAndNotify(2);
/*      */     }
/*      */ 
/* 5450 */     if (k == 0)
/* 5451 */       this.machine.setFlagAndNotify(7);
/*      */     else {
/* 5453 */       this.machine.clearFlagAndNotify(7);
/*      */     }
/*      */ 
/* 5457 */     if (this.finalResult == 0)
/* 5458 */       this.machine.setFlagAndNotify(6);
/*      */     else {
/* 5460 */       this.machine.clearFlagAndNotify(6);
/*      */     }
/*      */ 
/* 5463 */     return null;
/*      */   }
/*      */ 
/*      */   public StopPoint SUB8(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
/*      */   {
/* 5214 */     if (this.machine.debuggingEnabled) {
/* 5215 */       System.out.print("SUB8: Dest: ");
/* 5216 */       for (int i = 0; i < paramArrayOfInt1.length; i++) System.out.print(paramArrayOfInt1[i] + " ");
/* 5217 */       System.out.print("\tSrc: ");
/* 5218 */       for (int j = 0; j < paramArrayOfInt2.length; j++) System.out.print(paramArrayOfInt2[j] + " ");
/* 5219 */       System.out.println("");
/*      */     }
/*      */ 
/* 5228 */     if (paramArrayOfInt2[3] == 2)
/* 5229 */       this.srcValue = this.machine.getMemoryByte(paramArrayOfInt2);
/* 5230 */     else if (paramArrayOfInt2[3] == 3)
/* 5231 */       this.srcValue = paramArrayOfInt2[0];
/*      */     else {
/* 5233 */       this.srcValue = this.machine.getRegister(paramArrayOfInt2[2]);
/*      */     }
/*      */ 
/* 5240 */     if (paramArrayOfInt1[3] == 2) {
/* 5241 */       this.destValue = this.machine.getMemoryByte(paramArrayOfInt1);
/* 5242 */       this.result = (this.destValue - this.srcValue);
/* 5243 */       this.finalResult = (this.result & 0xFF);
/* 5244 */       this.machine.setMemoryByteAndNotify(this.finalResult, paramArrayOfInt1);
/*      */     }
/*      */     else {
/* 5247 */       if (paramArrayOfInt1[3] == 3) {
/* 5248 */         return new StopPoint(1, "Immediate as destination in SUB8");
/*      */       }
/*      */ 
/* 5252 */       this.destValue = this.machine.getRegister(paramArrayOfInt1[2]);
/* 5253 */       this.result = (this.destValue - this.srcValue);
/* 5254 */       this.finalResult = (this.result & 0xFF);
/* 5255 */       this.machine.setRegisterAndNotify(this.finalResult, paramArrayOfInt1[2]);
/*      */     }
/*      */ 
/* 5262 */     if (this.machine.debuggingEnabled) {
/* 5263 */       System.out.println("SourceValue: " + this.srcValue + 
/* 5264 */         " DestValue: " + this.destValue + 
/* 5265 */         " Result: " + this.result + 
/* 5266 */         " Final Result: " + this.finalResult);
/*      */     }
/*      */ 
/* 5280 */     if (this.result != this.finalResult)
/* 5281 */       this.machine.setFlagAndNotify(0);
/*      */     else {
/* 5283 */       this.machine.clearFlagAndNotify(0);
/*      */     }
/*      */ 
/* 5287 */     if ((this.destValue & 0xF) - (this.srcValue & 0xF) < 0)
/* 5288 */       this.machine.setFlagAndNotify(4);
/*      */     else {
/* 5290 */       this.machine.clearFlagAndNotify(4);
/*      */     }
/*      */ 
/* 5300 */     int i = this.srcValue <= 127 ? 0 : 1;
/* 5301 */     int j = this.destValue > 127 ? 0 : 1;
/* 5302 */     int k = this.finalResult > 127 ? 0 : 1;
/*      */ 
/* 5304 */     if (((i != 0) && (j != 0) && (k == 0)) || ((i == 0) && (j == 0) && (k != 0)))
/* 5305 */       this.machine.setFlagAndNotify(11);
/*      */     else {
/* 5307 */       this.machine.clearFlagAndNotify(11);
/*      */     }
/*      */ 
/* 5311 */     this.numberOfOnes = 0;
/* 5312 */     for (int m = 0; m < 8; m++)
/* 5313 */       this.numberOfOnes += ((this.result & Constants.BITMASK[m]) >> m);
/* 5314 */     if (this.numberOfOnes % 2 == 0)
/* 5315 */       this.machine.setFlagAndNotify(2);
/*      */     else {
/* 5317 */       this.machine.clearFlagAndNotify(2);
/*      */     }
/*      */ 
/* 5321 */     if (k == 0)
/* 5322 */       this.machine.setFlagAndNotify(7);
/*      */     else {
/* 5324 */       this.machine.clearFlagAndNotify(7);
/*      */     }
/*      */ 
/* 5328 */     if (this.finalResult == 0)
/* 5329 */       this.machine.setFlagAndNotify(6);
/*      */     else {
/* 5331 */       this.machine.clearFlagAndNotify(6);
/*      */     }
/*      */ 
/* 5334 */     return null;
/*      */   }
/*      */ 
/*      */   public StopPoint TEST16(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
/*      */   {
/* 5574 */     if (this.machine.debuggingEnabled) {
/* 5575 */       System.out.print("TEST16: Dest: ");
/* 5576 */       for (int i = 0; i < paramArrayOfInt1.length; i++) System.out.print(paramArrayOfInt1[i] + " ");
/* 5577 */       System.out.print("\tSrc: ");
/* 5578 */       for (int j = 0; j < paramArrayOfInt2.length; j++) System.out.print(paramArrayOfInt2[j] + " ");
/* 5579 */       System.out.println("");
/*      */     }
/*      */ 
/* 5587 */     if (paramArrayOfInt2[3] == 2)
/* 5588 */       this.srcValue = this.machine.getMemoryWord(paramArrayOfInt2);
/* 5589 */     else if (paramArrayOfInt2[3] == 3)
/* 5590 */       this.srcValue = paramArrayOfInt2[0];
/*      */     else {
/* 5592 */       this.srcValue = this.machine.getRegister(paramArrayOfInt2[2]);
/*      */     }
/*      */ 
/* 5599 */     if (paramArrayOfInt1[3] == 2) {
/* 5600 */       this.destValue = this.machine.getMemoryWord(paramArrayOfInt1);
/* 5601 */       this.finalResult = (this.srcValue & this.destValue);
/*      */     }
/*      */     else {
/* 5604 */       if (paramArrayOfInt1[3] == 3) {
/* 5605 */         return new StopPoint(1, "Immediate as destination in TEST16");
/*      */       }
/*      */ 
/* 5608 */       this.destValue = this.machine.getRegister(paramArrayOfInt1[2]);
/* 5609 */       this.finalResult = (this.srcValue & this.destValue);
/*      */     }
/*      */ 
/* 5616 */     if (this.machine.debuggingEnabled) {
/* 5617 */       System.out.println("SourceValue: " + this.srcValue + 
/* 5618 */         " DestValue: " + this.destValue + 
/* 5619 */         " Final Result: " + this.finalResult);
/*      */     }
/*      */ 
/* 5633 */     this.machine.clearFlagAndNotify(0);
/*      */ 
/* 5637 */     this.machine.clearFlagAndNotify(11);
/*      */ 
/* 5641 */     int i = 0;
/* 5642 */     for (int j = 0; j < 16; j++)
/* 5643 */       i += ((this.finalResult & Constants.BITMASK[j]) >> j);
/* 5644 */     if (i % 2 == 0)
/* 5645 */       this.machine.setFlagAndNotify(2);
/*      */     else {
/* 5647 */       this.machine.clearFlagAndNotify(2);
/*      */     }
/*      */ 
/* 5651 */     if (this.finalResult > 32767)
/* 5652 */       this.machine.setFlagAndNotify(7);
/*      */     else {
/* 5654 */       this.machine.clearFlagAndNotify(7);
/*      */     }
/*      */ 
/* 5658 */     if (this.finalResult == 0)
/* 5659 */       this.machine.setFlagAndNotify(6);
/*      */     else {
/* 5661 */       this.machine.clearFlagAndNotify(6);
/*      */     }
/* 5663 */     return null;
/*      */   }
/*      */ 
/*      */   public StopPoint TEST8(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
/*      */   {
/* 5473 */     if (this.machine.debuggingEnabled) {
/* 5474 */       System.out.print("TEST8: Dest: ");
/* 5475 */       for (int i = 0; i < paramArrayOfInt1.length; i++) System.out.print(paramArrayOfInt1[i] + " ");
/* 5476 */       System.out.print("\tSrc: ");
/* 5477 */       for (int j = 0; j < paramArrayOfInt2.length; j++) System.out.print(paramArrayOfInt2[j] + " ");
/* 5478 */       System.out.println("");
/*      */     }
/*      */ 
/* 5486 */     if (paramArrayOfInt2[3] == 2)
/* 5487 */       this.srcValue = this.machine.getMemoryByte(paramArrayOfInt2);
/* 5488 */     else if (paramArrayOfInt2[3] == 3)
/* 5489 */       this.srcValue = paramArrayOfInt2[0];
/*      */     else {
/* 5491 */       this.srcValue = this.machine.getRegister(paramArrayOfInt2[2]);
/*      */     }
/*      */ 
/* 5498 */     if (paramArrayOfInt1[3] == 2) {
/* 5499 */       this.destValue = this.machine.getMemoryByte(paramArrayOfInt1);
/* 5500 */       this.finalResult = (this.srcValue & this.destValue);
/*      */     }
/*      */     else {
/* 5503 */       if (paramArrayOfInt1[3] == 3) {
/* 5504 */         return new StopPoint(1, "Immediate as destination in TEST8");
/*      */       }
/*      */ 
/* 5508 */       this.destValue = this.machine.getRegister(paramArrayOfInt1[2]);
/* 5509 */       this.finalResult = (this.srcValue & this.destValue);
/*      */     }
/*      */ 
/* 5516 */     if (this.machine.debuggingEnabled) {
/* 5517 */       System.out.println("SourceValue: " + this.srcValue + 
/* 5518 */         " DestValue: " + this.destValue + 
/* 5519 */         " Final Result: " + this.finalResult);
/*      */     }
/*      */ 
/* 5533 */     this.machine.clearFlagAndNotify(0);
/*      */ 
/* 5537 */     this.machine.clearFlagAndNotify(11);
/*      */ 
/* 5541 */     this.numberOfOnes = 0;
/* 5542 */     for (int i = 0; i < 8; i++)
/* 5543 */       this.numberOfOnes += ((this.finalResult & Constants.BITMASK[i]) >> i);
/* 5544 */     if (this.numberOfOnes % 2 == 0)
/* 5545 */       this.machine.setFlagAndNotify(2);
/*      */     else {
/* 5547 */       this.machine.clearFlagAndNotify(2);
/*      */     }
/*      */ 
/* 5551 */     if (this.finalResult > 127)
/* 5552 */       this.machine.setFlagAndNotify(7);
/*      */     else {
/* 5554 */       this.machine.clearFlagAndNotify(7);
/*      */     }
/*      */ 
/* 5558 */     if (this.finalResult == 0)
/* 5559 */       this.machine.setFlagAndNotify(6);
/*      */     else {
/* 5561 */       this.machine.clearFlagAndNotify(6);
/*      */     }
/*      */ 
/* 5564 */     return null;
/*      */   }
/*      */ 
/*      */   public StopPoint XCHG16(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
/*      */   {
/* 5748 */     if (this.machine.debuggingEnabled) {
/* 5749 */       System.out.print("XCHG16: Dest: ");
/* 5750 */       for (int i = 0; i < paramArrayOfInt1.length; i++) System.out.print(paramArrayOfInt1[i] + " ");
/* 5751 */       System.out.print("\tSrc: ");
/* 5752 */       for (int j = 0; j < paramArrayOfInt2.length; j++) System.out.print(paramArrayOfInt2[j] + " ");
/* 5753 */       System.out.println("");
/*      */     }
/*      */ 
/* 5761 */     if (paramArrayOfInt2[3] == 2)
/* 5762 */       this.srcValue = this.machine.getMemoryWord(paramArrayOfInt2);
/* 5763 */     else if (paramArrayOfInt2[3] == 3)
/* 5764 */       this.srcValue = paramArrayOfInt2[0];
/*      */     else {
/* 5766 */       this.srcValue = this.machine.getRegister(paramArrayOfInt2[2]);
/*      */     }
/*      */ 
/* 5772 */     if (paramArrayOfInt1[3] == 2) {
/* 5773 */       this.destValue = this.machine.getMemoryWord(paramArrayOfInt1);
/* 5774 */       this.machine.setMemoryWordAndNotify(this.srcValue, paramArrayOfInt1);
/*      */     }
/*      */     else {
/* 5777 */       if (paramArrayOfInt1[3] == 3) {
/* 5778 */         return new StopPoint(1, "Immediate as destination in XCHG16");
/*      */       }
/*      */ 
/* 5782 */       this.destValue = this.machine.getRegister(paramArrayOfInt1[2]);
/* 5783 */       this.machine.setRegisterAndNotify(this.srcValue, paramArrayOfInt1[2]);
/*      */     }
/*      */ 
/* 5791 */     if (paramArrayOfInt2[3] == 2) {
/* 5792 */       this.machine.setMemoryWordAndNotify(this.destValue, paramArrayOfInt2);
/*      */     } else {
/* 5794 */       if (paramArrayOfInt2[3] == 3) {
/* 5795 */         return new StopPoint(1, "Immediate as source in XCHG16");
/*      */       }
/*      */ 
/* 5799 */       this.machine.setRegisterAndNotify(this.destValue, paramArrayOfInt2[2]);
/*      */     }
/*      */ 
/* 5804 */     if (this.machine.debuggingEnabled) {
/* 5805 */       System.out.println("SourceValue: " + this.srcValue + 
/* 5806 */         " DestValue: " + this.destValue);
/*      */     }
/*      */ 
/* 5814 */     return null;
/*      */   }
/*      */ 
/*      */   public StopPoint XCHG8(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
/*      */   {
/* 5673 */     if (this.machine.debuggingEnabled) {
/* 5674 */       System.out.print("XCHG8: Dest: ");
/* 5675 */       for (int i = 0; i < paramArrayOfInt1.length; i++) System.out.print(paramArrayOfInt1[i] + " ");
/* 5676 */       System.out.print("\tSrc: ");
/* 5677 */       for (int j = 0; j < paramArrayOfInt2.length; j++) System.out.print(paramArrayOfInt2[j] + " ");
/* 5678 */       System.out.println("");
/*      */     }
/*      */ 
/* 5686 */     if (paramArrayOfInt2[3] == 2)
/* 5687 */       this.srcValue = this.machine.getMemoryByte(paramArrayOfInt2);
/* 5688 */     else if (paramArrayOfInt2[3] == 3)
/* 5689 */       this.srcValue = paramArrayOfInt2[0];
/*      */     else {
/* 5691 */       this.srcValue = this.machine.getRegister(paramArrayOfInt2[2]);
/*      */     }
/*      */ 
/* 5697 */     if (paramArrayOfInt1[3] == 2) {
/* 5698 */       this.destValue = this.machine.getMemoryByte(paramArrayOfInt1);
/* 5699 */       this.machine.setMemoryByteAndNotify(this.srcValue, paramArrayOfInt1);
/*      */     }
/*      */     else {
/* 5702 */       if (paramArrayOfInt1[3] == 3) {
/* 5703 */         return new StopPoint(1, "Immediate as destination in XCHG8");
/*      */       }
/*      */ 
/* 5707 */       this.destValue = this.machine.getRegister(paramArrayOfInt1[2]);
/* 5708 */       this.machine.setRegisterAndNotify(this.srcValue, paramArrayOfInt1[2]);
/*      */     }
/*      */ 
/* 5716 */     if (paramArrayOfInt2[3] == 2) {
/* 5717 */       this.machine.setMemoryByteAndNotify(this.destValue, paramArrayOfInt2);
/*      */     } else {
/* 5719 */       if (paramArrayOfInt2[3] == 3) {
/* 5720 */         return new StopPoint(1, "Immediate as destination in XCHG8");
/*      */       }
/*      */ 
/* 5724 */       this.machine.setRegisterAndNotify(this.destValue, paramArrayOfInt2[2]);
/*      */     }
/*      */ 
/* 5729 */     if (this.machine.debuggingEnabled) {
/* 5730 */       System.out.println("SourceValue: " + this.srcValue + 
/* 5731 */         " DestValue: " + this.destValue);
/*      */     }
/*      */ 
/* 5738 */     return null;
/*      */   }
/*      */ 
/*      */   public StopPoint XOR16(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
/*      */   {
/* 5925 */     if (this.machine.debuggingEnabled) {
/* 5926 */       System.out.print("XOR16: Dest: ");
/* 5927 */       for (int i = 0; i < paramArrayOfInt1.length; i++) System.out.print(paramArrayOfInt1[i] + " ");
/* 5928 */       System.out.print("\tSrc: ");
/* 5929 */       for (int j = 0; j < paramArrayOfInt2.length; j++) System.out.print(paramArrayOfInt2[j] + " ");
/* 5930 */       System.out.println("");
/*      */     }
/*      */ 
/* 5938 */     if (paramArrayOfInt2[3] == 2)
/* 5939 */       this.srcValue = this.machine.getMemoryWord(paramArrayOfInt2);
/* 5940 */     else if (paramArrayOfInt2[3] == 3)
/* 5941 */       this.srcValue = paramArrayOfInt2[0];
/*      */     else {
/* 5943 */       this.srcValue = this.machine.getRegister(paramArrayOfInt2[2]);
/*      */     }
/*      */ 
/* 5950 */     if (paramArrayOfInt1[3] == 2) {
/* 5951 */       this.destValue = this.machine.getMemoryWord(paramArrayOfInt1);
/* 5952 */       this.finalResult = (this.srcValue ^ this.destValue);
/* 5953 */       this.machine.setMemoryWordAndNotify(this.finalResult, paramArrayOfInt1);
/*      */     }
/*      */     else {
/* 5956 */       if (paramArrayOfInt1[3] == 3) {
/* 5957 */         return new StopPoint(1, "Immediate as destination in AND16");
/*      */       }
/*      */ 
/* 5961 */       this.destValue = this.machine.getRegister(paramArrayOfInt1[2]);
/* 5962 */       this.finalResult = (this.srcValue ^ this.destValue);
/* 5963 */       this.machine.setRegisterAndNotify(this.finalResult, paramArrayOfInt1[2]);
/*      */     }
/*      */ 
/* 5970 */     if (this.machine.debuggingEnabled) {
/* 5971 */       System.out.println("SourceValue: " + this.srcValue + 
/* 5972 */         " DestValue: " + this.destValue + 
/* 5973 */         " Final Result: " + this.finalResult);
/*      */     }
/*      */ 
/* 5987 */     this.machine.clearFlagAndNotify(0);
/*      */ 
/* 5991 */     this.machine.clearFlagAndNotify(11);
/*      */ 
/* 5995 */     int i = 0;
/* 5996 */     for (int j = 0; j < 16; j++)
/* 5997 */       i += ((this.finalResult & Constants.BITMASK[j]) >> j);
/* 5998 */     if (i % 2 == 0)
/* 5999 */       this.machine.setFlagAndNotify(2);
/*      */     else {
/* 6001 */       this.machine.clearFlagAndNotify(2);
/*      */     }
/*      */ 
/* 6005 */     if (this.finalResult > 32767)
/* 6006 */       this.machine.setFlagAndNotify(7);
/*      */     else {
/* 6008 */       this.machine.clearFlagAndNotify(7);
/*      */     }
/*      */ 
/* 6012 */     if (this.finalResult == 0)
/* 6013 */       this.machine.setFlagAndNotify(6);
/*      */     else {
/* 6015 */       this.machine.clearFlagAndNotify(6);
/*      */     }
/*      */ 
/* 6018 */     return null;
/*      */   }
/*      */ 
/*      */   public StopPoint XOR8(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
/*      */   {
/* 5824 */     if (this.machine.debuggingEnabled) {
/* 5825 */       System.out.print("XOR8: Dest: ");
/* 5826 */       for (int i = 0; i < paramArrayOfInt1.length; i++) System.out.print(paramArrayOfInt1[i] + " ");
/* 5827 */       System.out.print("\tSrc: ");
/* 5828 */       for (int j = 0; j < paramArrayOfInt2.length; j++) System.out.print(paramArrayOfInt2[j] + " ");
/* 5829 */       System.out.println("");
/*      */     }
/*      */ 
/* 5837 */     if (paramArrayOfInt2[3] == 2)
/* 5838 */       this.srcValue = this.machine.getMemoryByte(paramArrayOfInt2);
/* 5839 */     else if (paramArrayOfInt2[3] == 3)
/* 5840 */       this.srcValue = paramArrayOfInt2[0];
/*      */     else {
/* 5842 */       this.srcValue = this.machine.getRegister(paramArrayOfInt2[2]);
/*      */     }
/*      */ 
/* 5849 */     if (paramArrayOfInt1[3] == 2) {
/* 5850 */       this.destValue = this.machine.getMemoryByte(paramArrayOfInt1);
/* 5851 */       this.finalResult = (this.srcValue ^ this.destValue);
/* 5852 */       this.machine.setMemoryByteAndNotify(this.finalResult, paramArrayOfInt1);
/*      */     }
/*      */     else {
/* 5855 */       if (paramArrayOfInt1[3] == 3) {
/* 5856 */         return new StopPoint(1, "Immediate as destination in OR8");
/*      */       }
/*      */ 
/* 5860 */       this.destValue = this.machine.getRegister(paramArrayOfInt1[2]);
/* 5861 */       this.finalResult = (this.srcValue ^ this.destValue);
/* 5862 */       this.machine.setRegisterAndNotify(this.finalResult, paramArrayOfInt1[2]);
/*      */     }
/*      */ 
/* 5869 */     if (this.machine.debuggingEnabled) {
/* 5870 */       System.out.println("SourceValue: " + this.srcValue + 
/* 5871 */         " DestValue: " + this.destValue + 
/* 5872 */         " Final Result: " + this.finalResult);
/*      */     }
/*      */ 
/* 5885 */     this.machine.clearFlagAndNotify(0);
/*      */ 
/* 5889 */     this.machine.clearFlagAndNotify(11);
/*      */ 
/* 5893 */     this.numberOfOnes = 0;
/* 5894 */     for (int i = 0; i < 8; i++)
/* 5895 */       this.numberOfOnes += ((this.finalResult & Constants.BITMASK[i]) >> i);
/* 5896 */     if (this.numberOfOnes % 2 == 0)
/* 5897 */       this.machine.setFlagAndNotify(2);
/*      */     else {
/* 5899 */       this.machine.clearFlagAndNotify(2);
/*      */     }
/*      */ 
/* 5903 */     if (this.finalResult > 127)
/* 5904 */       this.machine.setFlagAndNotify(7);
/*      */     else {
/* 5906 */       this.machine.clearFlagAndNotify(7);
/*      */     }
/*      */ 
/* 5910 */     if (this.finalResult == 0)
/* 5911 */       this.machine.setFlagAndNotify(6);
/*      */     else {
/* 5913 */       this.machine.clearFlagAndNotify(6);
/*      */     }
/* 5915 */     return null;
/*      */   }
/*      */ }

/* Location:           C:\Users\daishi\Downloads\virgo213\virgo213_2006\
 * Qualified Name:     InstructionSet
 * JD-Core Version:    0.6.2
 */