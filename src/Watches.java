/*     */ import java.util.Enumeration;
/*     */ import java.util.Vector;
/*     */ 
/*     */ class Watches
/*     */   implements Constants
/*     */ {
/*     */   private Vector watches;
/*     */   Virgo virgo;
/*     */ 
/*     */   Watches(Virgo paramVirgo)
/*     */   {
/*  30 */     this.virgo = paramVirgo;
/*     */ 
/*  32 */     this.watches = new Vector();
/*     */   }
/*     */ 
/*     */   public void addAddressWatch(int paramInt1, int paramInt2)
/*     */   {
/*  45 */     this.watches.addElement(new Watches.AddressWatch(paramInt1, paramInt2));
/*     */   }
/*     */ 
/*     */   public void addLabelWatch(String paramString, int paramInt1, int paramInt2)
/*     */   {
/*  51 */     this.watches.addElement(new Watches.LabelWatch(paramString, paramInt1, paramInt2));
/*     */   }
/*     */ 
/*     */   public Vector getList()
/*     */   {
/*  65 */     if (this.watches == null) return null;
/*  66 */     Vector localVector = new Vector();
/*  67 */     for (Enumeration localEnumeration = this.watches.elements(); localEnumeration.hasMoreElements(); )
/*     */     {
/*  69 */       localVector.addElement(localEnumeration.nextElement().toString());
/*     */     }
/*  71 */     return localVector;
/*     */   }
/*     */ 
/*     */   public void removeWatches(int[] paramArrayOfInt)
/*     */   {
/*  56 */     Vector localVector = (Vector)this.watches.clone();
/*  57 */     for (int i = 0; i < paramArrayOfInt.length; i++)
/*     */     {
/*  59 */       this.watches.removeElement(localVector.elementAt(paramArrayOfInt[i]));
/*     */     }
/*     */   }
/*     */ 
/*     */   public int size()
/*     */   {
/*  38 */     return this.watches.size();
/*     */   }
/*     */ 
/*     */   public void update()
/*     */   {
/*  77 */     for (Enumeration localEnumeration = this.watches.elements(); localEnumeration.hasMoreElements(); )
/*     */     {
/*  80 */       ((Watches.Watch)localEnumeration.nextElement()).update();
/*     */     }
/*     */   }
/*     */ 
/*     */   class Watch
/*     */   {
/*     */     protected int type;
/*     */     protected int address;
/*     */     protected int value;
/*     */ 
/*     */     Watch()
/*     */     {
/*     */     }
/*     */ 
/*     */     public String toString()
/*     */     {
/* 105 */       return "Undefined watch";
/*     */     }
/*     */ 
/*     */     public void update()
/*     */     {
/*  95 */       if (this.type == 0)
/*     */       {
/*  97 */         this.value = Watches.this.virgo.machine.getMemoryByte(this.address);
/*     */       }
/*  99 */       else if (this.type == 1)
/*     */       {
/* 101 */         this.value = Watches.this.virgo.machine.getMemoryWord(this.address);
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */   class AddressWatch extends Watches.Watch
/*     */   {
/*     */     AddressWatch(int paramInt1, int arg3)
/*     */     {
/* 110 */       super();
/*     */ 
/* 112 */       this.address = paramInt1;
/* 113 */       this.type = arg3;
/*     */ 
/* 115 */       this.value = 0;
/*     */ 
/* 117 */       update();
/*     */     }
/*     */ 
/*     */     public String toString()
/*     */     {
/* 122 */       String str1 = Library.toStringAddress(this.address);
/* 123 */       String str2 = new String();
/* 124 */       if (this.type == 0)
/*     */       {
/* 126 */         str2 = Library.toStringByte(this.value);
/* 127 */         return "Byte at address " + str1 + " has value " + str2;
/*     */       }
/* 129 */       if (this.type == 1)
/*     */       {
/* 131 */         str2 = Library.toStringWord(this.value);
/* 132 */         return "Word at address " + str1 + " has value " + str2;
/*     */       }
/* 134 */       return null;
/*     */     }
/*     */   }
/*     */ 
/*     */   class LabelWatch extends Watches.Watch {
/*     */     String name;
/*     */ 
/*     */     LabelWatch(String paramInt1, int paramInt2, int arg4) {
/* 142 */       super();
/*     */ 
/* 144 */       this.name = new String(paramInt1);
/* 145 */       this.address = paramInt2;
/* 146 */       this.type = arg4;
/*     */ 
/* 148 */       this.value = 0;
/*     */ 
/* 150 */       update();
/*     */     }
/*     */ 
/*     */     public String toString()
/*     */     {
/* 155 */       String str = new String();
/* 156 */       if (this.type == 0)
/* 157 */         str = Library.toStringByte(this.value);
/* 158 */       else if (this.type == 1)
/* 159 */         str = Library.toStringWord(this.value);
/* 160 */       return "Variable " + this.name + " has value " + str;
/*     */     }
/*     */   }
/*     */ }

/* Location:           C:\Users\daishi\Downloads\virgo213\virgo213_2006\
 * Qualified Name:     Watches
 * JD-Core Version:    0.6.2
 */