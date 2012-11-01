/*     */ import java.util.Enumeration;
/*     */ import java.util.Vector;
/*     */ 
/*     */ class Breakpoints
/*     */   implements Constants
/*     */ {
/*     */   Virgo virgo;
/*     */   protected String message;
/*     */   private Vector breakpoints;
/*     */ 
/*     */   Breakpoints(Virgo paramVirgo)
/*     */   {
/*  32 */     this.virgo = paramVirgo;
/*  33 */     this.breakpoints = new Vector();
/*  34 */     this.message = null;
/*     */   }
/*     */ 
/*     */   public void addBreakpoint(int paramInt1, int paramInt2)
/*     */   {
/*  62 */     if (paramInt1 == 0)
/*  63 */       this.breakpoints.addElement(new Breakpoints.CodeBreakpoint(paramInt2));
/*     */   }
/*     */ 
/*     */   public void addBreakpoint(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
/*     */   {
/*  68 */     if (paramInt1 == 3)
/*  69 */       this.breakpoints.addElement(new Breakpoints.RegisterBreakpoint(paramInt2, paramInt3, paramInt4));
/*     */   }
/*     */ 
/*     */   public void addBreakpoint(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
/*     */   {
/*  74 */     if (paramInt1 == 1)
/*  75 */       this.breakpoints.addElement(new Breakpoints.MemoryBreakpoint(paramInt2, paramInt3, paramInt4, paramInt5));
/*  76 */     else if (paramInt1 == 2)
/*  77 */       this.breakpoints.addElement(new Breakpoints.PortBreakpoint(paramInt2, paramInt3, paramInt4, paramInt5));
/*     */   }
/*     */ 
/*     */   public Vector getList()
/*     */   {
/* 127 */     if (this.breakpoints == null) return null;
/* 128 */     Vector localVector = new Vector();
/* 129 */     for (Enumeration localEnumeration = this.breakpoints.elements(); localEnumeration.hasMoreElements(); )
/*     */     {
/* 132 */       localVector.addElement("Break when " + localEnumeration.nextElement().toString());
/*     */     }
/* 134 */     return localVector;
/*     */   }
/*     */ 
/*     */   public String getMessage()
/*     */   {
/*  39 */     return new String(this.message);
/*     */   }
/*     */ 
/*     */   public boolean isCodeBreakpoint(int paramInt)
/*     */   {
/*  51 */     for (Enumeration localEnumeration = this.breakpoints.elements(); localEnumeration.hasMoreElements(); )
/*     */     {
/*  53 */       Breakpoints.Breakpoint localBreakpoint = (Breakpoints.Breakpoint)localEnumeration.nextElement();
/*  54 */       if (((localBreakpoint instanceof Breakpoints.CodeBreakpoint)) && 
/*  55 */         (((Breakpoints.CodeBreakpoint)localBreakpoint).getAddress() == paramInt)) return true;
/*     */     }
/*  57 */     return false;
/*     */   }
/*     */ 
/*     */   public void readyToRun()
/*     */   {
/* 142 */     for (Enumeration localEnumeration = this.breakpoints.elements(); localEnumeration.hasMoreElements(); )
/*     */     {
/* 144 */       ((Breakpoints.Breakpoint)localEnumeration.nextElement()).readyToRun();
/*     */     }
/*     */   }
/*     */ 
/*     */   public void removeBreakpoints(int[] paramArrayOfInt)
/*     */   {
/*  97 */     Vector localVector = (Vector)this.breakpoints.clone();
/*  98 */     for (int i = 0; i < paramArrayOfInt.length; i++)
/*     */     {
/* 100 */       if (paramArrayOfInt[i] < localVector.size())
/* 101 */         this.breakpoints.removeElement(localVector.elementAt(paramArrayOfInt[i]));
/*     */     }
/*     */   }
/*     */ 
/*     */   public void removeCodeBreakpoint(int paramInt)
/*     */   {
/* 110 */     for (Enumeration localEnumeration = this.breakpoints.elements(); localEnumeration.hasMoreElements(); )
/*     */     {
/* 112 */       Breakpoints.Breakpoint localBreakpoint = (Breakpoints.Breakpoint)localEnumeration.nextElement();
/* 113 */       if ((localBreakpoint instanceof Breakpoints.CodeBreakpoint))
/*     */       {
/* 115 */         if (((Breakpoints.CodeBreakpoint)localBreakpoint).getAddress() == paramInt)
/*     */         {
/* 117 */           this.breakpoints.removeElement(localBreakpoint);
/*     */           return;
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */   public boolean shouldBreak()
/*     */   {
/*  82 */     if (this.breakpoints == null) return false;
/*  83 */     for (Enumeration localEnumeration = this.breakpoints.elements(); localEnumeration.hasMoreElements(); )
/*     */     {
/*  85 */       if (((Breakpoints.Breakpoint)localEnumeration.nextElement()).isBreakpointReached())
/*     */       {
/*  87 */         return true;
/*     */       }
/*     */     }
/*     */ 
/*  91 */     this.message = null;
/*  92 */     return false;
/*     */   }
/*     */ 
/*     */   public int size()
/*     */   {
/*  44 */     return this.breakpoints.size();
/*     */   }
/*     */ 
/*     */   abstract class Breakpoint
/*     */   {
/*     */     Breakpoint()
/*     */     {
/*     */     }
/*     */ 
/*     */     public boolean isBreakpointReached()
/*     */     {
/* 152 */       return false; } 
/*     */     public void readyToRun() {  } 
/* 153 */     public String toString() { return new String("Breakpoint undefined"); }
/*     */ 
/*     */   }
/*     */ 
/*     */   class CodeBreakpoint extends Breakpoints.Breakpoint
/*     */   {
/*     */     private int address;
/*     */ 
/*     */     CodeBreakpoint(int arg2)
/*     */     {
/* 167 */       super();
/* 169 */       this.address = arg2;
/*     */     }
/*     */ 
/*     */     public int getAddress()
/*     */     {
/* 164 */       return this.address;
/*     */     }
/*     */ 
/*     */     public boolean isBreakpointReached()
/*     */     {
/* 176 */       if (this.address == Breakpoints.this.virgo.machine.getRegister(8))
/*     */       {
/* 178 */         Breakpoints.this.message = new String("instruction breakpoint");
/* 179 */         return true;
/*     */       }
/*     */ 
/* 182 */       return false;
/*     */     }
/*     */ 
/*     */     public String toString()
/*     */     {
/* 187 */       String str = new String(Integer.toHexString(this.address).toUpperCase());
/* 188 */       while (str.length() < 4) str = "0" + str;
/*     */ 
/* 190 */       return new String("instruction starting at address " + 
/* 191 */         str + " is reached");
/*     */     }
/*     */   }
/*     */ 
/*     */   class RegisterBreakpoint extends Breakpoints.Breakpoint {
/*     */     private int register;
/*     */     private int condition;
/*     */     private int value;
/*     */ 
/*     */     RegisterBreakpoint(int paramInt1, int paramInt2, int arg4) {
/* 203 */       super();
/*     */ 
/* 205 */       this.register = paramInt1;
/* 206 */       this.condition = paramInt2;
/* 207 */       this.value = arg4;
/*     */     }
/*     */ 
/*     */     public boolean isBreakpointReached()
/*     */     {
/* 221 */       switch (this.condition)
/*     */       {
/*     */       case 0:
/* 224 */         if (Breakpoints.this.virgo.machine.getRegister(this.register) != this.value)
/*     */         {
/* 226 */           Breakpoints.this.message = new String(toString());
/* 227 */           return true;
/*     */         }
/*     */         break;
/*     */       case 1:
/* 231 */         if (Breakpoints.this.virgo.machine.getRegister(this.register) == this.value)
/*     */         {
/* 233 */           Breakpoints.this.message = new String(toString());
/* 234 */           return true;
/*     */         }
/*     */         break;
/*     */       case 2:
/* 238 */         if (Breakpoints.this.virgo.machine.getRegister(this.register) > this.value)
/*     */         {
/* 240 */           Breakpoints.this.message = new String(toString());
/* 241 */           return true;
/*     */         }
/*     */         break;
/*     */       case 3:
/* 245 */         if (Breakpoints.this.virgo.machine.getRegister(this.register) < this.value)
/*     */         {
/* 247 */           Breakpoints.this.message = new String(toString());
/* 248 */           return true;
/*     */         }
/*     */         break;
/*     */       case 4:
/* 252 */         if (Breakpoints.this.virgo.machine.getRegister(this.register) != this.value)
/*     */         {
/* 254 */           Breakpoints.this.message = new String(toString());
/* 255 */           return true;
/*     */         }
/*     */         break;
/*     */       case 5:
/* 259 */         if (Breakpoints.this.virgo.machine.getRegister(this.register) <= this.value)
/*     */         {
/* 261 */           Breakpoints.this.message = new String(toString());
/* 262 */           return true;
/*     */         }
/*     */         break;
/*     */       case 6:
/* 266 */         if (Breakpoints.this.virgo.machine.getRegister(this.register) >= this.value)
/*     */         {
/* 268 */           Breakpoints.this.message = new String(toString());
/* 269 */           return true;
/*     */         }
/*     */         break;
/*     */       }
/*     */ 
/* 274 */       return false;
/*     */     }
/*     */ 
/*     */     public void readyToRun()
/*     */     {
/* 215 */       if (this.condition == 0) this.value = Breakpoints.this.virgo.machine.getRegister(this.register);
/*     */     }
/*     */ 
/*     */     public String toString()
/*     */     {
/* 279 */       String str = new String("register " + Library.registerToString(this.register) + " is " + Library.conditionToString(this.condition));
/* 280 */       if (this.condition != 0) str = str + " " + this.value;
/* 281 */       return str;
/*     */     }
/*     */   }
/*     */   class PortBreakpoint extends Breakpoints.Breakpoint {
/*     */     private int address;
/*     */     private int condition;
/*     */     private int type;
/*     */     private int value;
/*     */ 
/* 293 */     PortBreakpoint(int paramInt1, int paramInt2, int paramInt3, int arg5) { super();
/*     */ 
/* 295 */       this.address = paramInt1;
/* 296 */       this.type = paramInt2;
/* 297 */       this.condition = paramInt3;
/* 298 */       this.value = arg5;
/*     */     }
/*     */ 
/*     */     public boolean isBreakpointReached()
/*     */     {
/* 316 */       switch (this.condition)
/*     */       {
/*     */       case 0:
/* 319 */         if (((this.type == 0) && (Breakpoints.this.virgo.machine.getPortByte(this.address) != this.value)) || ((this.type == 1) && (Breakpoints.this.virgo.machine.getPortWord(this.address) != this.value)))
/*     */         {
/* 321 */           Breakpoints.this.message = new String(toString());
/* 322 */           return true;
/*     */         }
/*     */ 
/*     */         break;
/*     */       case 1:
/* 327 */         if (((this.type == 0) && (Breakpoints.this.virgo.machine.getPortByte(this.address) == this.value)) || ((this.type == 1) && (Breakpoints.this.virgo.machine.getPortWord(this.address) == this.value)))
/*     */         {
/* 329 */           Breakpoints.this.message = new String(toString());
/* 330 */           return true;
/*     */         }
/*     */         break;
/*     */       case 2:
/* 334 */         if (((this.type == 0) && (Breakpoints.this.virgo.machine.getPortByte(this.address) > this.value)) || ((this.type == 1) && (Breakpoints.this.virgo.machine.getPortWord(this.address) > this.value)))
/*     */         {
/* 336 */           Breakpoints.this.message = new String(toString());
/* 337 */           return true;
/*     */         }
/*     */         break;
/*     */       case 3:
/* 341 */         if (((this.type == 0) && (Breakpoints.this.virgo.machine.getPortByte(this.address) < this.value)) || ((this.type == 1) && (Breakpoints.this.virgo.machine.getPortWord(this.address) < this.value)))
/*     */         {
/* 343 */           Breakpoints.this.message = new String(toString());
/* 344 */           return true;
/*     */         }
/*     */         break;
/*     */       case 4:
/* 348 */         if (((this.type == 0) && (Breakpoints.this.virgo.machine.getPortByte(this.address) != this.value)) || ((this.type == 1) && (Breakpoints.this.virgo.machine.getPortWord(this.address) != this.value)))
/*     */         {
/* 350 */           Breakpoints.this.message = new String(toString());
/* 351 */           return true;
/*     */         }
/*     */         break;
/*     */       case 5:
/* 355 */         if (((this.type == 0) && (Breakpoints.this.virgo.machine.getPortByte(this.address) <= this.value)) || ((this.type == 1) && (Breakpoints.this.virgo.machine.getPortWord(this.address) <= this.value)))
/*     */         {
/* 357 */           Breakpoints.this.message = new String(toString());
/* 358 */           return true;
/*     */         }
/*     */         break;
/*     */       case 6:
/* 362 */         if (((this.type == 0) && (Breakpoints.this.virgo.machine.getPortByte(this.address) >= this.value)) || ((this.type == 1) && (Breakpoints.this.virgo.machine.getPortWord(this.address) >= this.value)))
/*     */         {
/* 364 */           Breakpoints.this.message = new String(toString());
/* 365 */           return true;
/*     */         }
/*     */         break;
/*     */       }
/*     */ 
/* 370 */       return false;
/*     */     }
/*     */ 
/*     */     public void readyToRun()
/*     */     {
/* 306 */       if (this.condition == 0)
/*     */       {
/* 308 */         if (this.type == 0) this.value = Breakpoints.this.virgo.machine.getPortByte(this.address);
/* 309 */         else if (this.type == 1) this.value = Breakpoints.this.virgo.machine.getPortWord(this.address);
/*     */       }
/*     */     }
/*     */ 
/*     */     public String toString()
/*     */     {
/* 375 */       String str = new String(Integer.toHexString(this.address).toUpperCase());
/* 376 */       while (str.length() < 4) str = "0" + str;
/* 377 */       if (this.type == 0) str = "the byte at port " + str; else
/* 378 */         str = "the word at port " + str;
/* 379 */       str = str + " is " + Library.conditionToString(this.condition);
/* 380 */       if (this.condition != 0) str = str + " " + this.value;
/* 381 */       return str;
/*     */     }
/*     */   }
/*     */   class MemoryBreakpoint extends Breakpoints.Breakpoint { private int address;
/*     */     private int condition;
/*     */     private int type;
/*     */     private int value;
/*     */ 
/* 392 */     MemoryBreakpoint(int paramInt1, int paramInt2, int paramInt3, int arg5) { super();
/*     */ 
/* 394 */       this.address = paramInt1;
/* 395 */       this.type = paramInt2;
/* 396 */       this.condition = paramInt3;
/* 397 */       this.value = arg5;
/*     */     }
/*     */ 
/*     */     public boolean isBreakpointReached()
/*     */     {
/* 416 */       switch (this.condition)
/*     */       {
/*     */       case 0:
/* 419 */         if (((this.type == 0) && (Breakpoints.this.virgo.machine.getMemoryByte(this.address) != this.value)) || ((this.type == 1) && (Breakpoints.this.virgo.machine.getMemoryWord(this.address) != this.value)))
/*     */         {
/* 421 */           Breakpoints.this.message = new String(toString());
/* 422 */           return true;
/*     */         }
/*     */ 
/*     */         break;
/*     */       case 1:
/* 427 */         if (((this.type == 0) && (Breakpoints.this.virgo.machine.getMemoryByte(this.address) == this.value)) || ((this.type == 1) && (Breakpoints.this.virgo.machine.getMemoryWord(this.address) == this.value)))
/*     */         {
/* 429 */           Breakpoints.this.message = new String(toString());
/* 430 */           return true;
/*     */         }
/*     */         break;
/*     */       case 2:
/* 434 */         if (((this.type == 0) && (Breakpoints.this.virgo.machine.getMemoryByte(this.address) > this.value)) || ((this.type == 1) && (Breakpoints.this.virgo.machine.getMemoryWord(this.address) > this.value)))
/*     */         {
/* 436 */           Breakpoints.this.message = new String(toString());
/* 437 */           return true;
/*     */         }
/*     */         break;
/*     */       case 3:
/* 441 */         if (((this.type == 0) && (Breakpoints.this.virgo.machine.getMemoryByte(this.address) < this.value)) || ((this.type == 1) && (Breakpoints.this.virgo.machine.getMemoryWord(this.address) < this.value)))
/*     */         {
/* 443 */           Breakpoints.this.message = new String(toString());
/* 444 */           return true;
/*     */         }
/*     */         break;
/*     */       case 4:
/* 448 */         if (((this.type == 0) && (Breakpoints.this.virgo.machine.getMemoryByte(this.address) != this.value)) || ((this.type == 1) && (Breakpoints.this.virgo.machine.getMemoryWord(this.address) != this.value)))
/*     */         {
/* 450 */           Breakpoints.this.message = new String(toString());
/* 451 */           return true;
/*     */         }
/*     */         break;
/*     */       case 5:
/* 455 */         if (((this.type == 0) && (Breakpoints.this.virgo.machine.getMemoryByte(this.address) <= this.value)) || ((this.type == 1) && (Breakpoints.this.virgo.machine.getMemoryWord(this.address) <= this.value)))
/*     */         {
/* 457 */           Breakpoints.this.message = new String(toString());
/* 458 */           return true;
/*     */         }
/*     */         break;
/*     */       case 6:
/* 462 */         if (((this.type == 0) && (Breakpoints.this.virgo.machine.getMemoryByte(this.address) >= this.value)) || ((this.type == 1) && (Breakpoints.this.virgo.machine.getMemoryWord(this.address) >= this.value)))
/*     */         {
/* 464 */           Breakpoints.this.message = new String(toString());
/* 465 */           return true;
/*     */         }
/*     */         break;
/*     */       }
/*     */ 
/* 470 */       return false;
/*     */     }
/*     */ 
/*     */     public void readyToRun()
/*     */     {
/* 405 */       if (this.condition == 0)
/*     */       {
/* 407 */         if (this.type == 0) this.value = Breakpoints.this.virgo.machine.getMemoryByte(this.address);
/* 408 */         else if (this.type == 1) this.value = Breakpoints.this.virgo.machine.getMemoryWord(this.address);
/*     */       }
/*     */     }
/*     */ 
/*     */     public String toString()
/*     */     {
/* 475 */       String str = new String(Integer.toHexString(this.address).toUpperCase());
/* 476 */       while (str.length() < 4) str = "0" + str;
/* 477 */       if (this.type == 0) str = "the byte at memory address " + str; else
/* 478 */         str = "the word at memory address " + str;
/* 479 */       str = str + " is " + Library.conditionToString(this.condition);
/* 480 */       if (this.condition != 0) str = str + " " + this.value;
/* 481 */       return str;
/*     */     }
/*     */   }
/*     */ }

/* Location:           C:\Users\daishi\Downloads\virgo213\virgo213_2006\
 * Qualified Name:     Breakpoints
 * JD-Core Version:    0.6.2
 */