/*     */ class SimulatedScreen
/*     */   implements Constants
/*     */ {
/*     */   int cursorX;
/*     */   int cursorY;
/*     */   int rows;
/*     */   int columns;
/*     */   String contents;
/*     */   String blankLine;
/*     */ 
/*     */   SimulatedScreen(int paramInt1, int paramInt2)
/*     */   {
/*  32 */     this.rows = paramInt1;
/*  33 */     this.columns = paramInt2;
/*     */ 
/*  37 */     char[] arrayOfChar = new char[paramInt2];
/*  38 */     for (int i = 0; i < paramInt2; i++)
/*     */     {
/*  40 */       arrayOfChar[i] = ' ';
/*     */     }
/*  42 */     this.blankLine = new String(arrayOfChar);
/*     */ 
/*  45 */     reset();
/*     */   }
/*     */ 
/*     */   public void advanceCursor()
/*     */   {
/* 229 */     this.cursorX += 1;
/* 230 */     if (this.cursorX == this.columns)
/*     */     {
/* 232 */       this.cursorX = 0;
/* 233 */       if (this.cursorY < this.rows - 1) this.cursorY += 1;
/*     */     }
/*     */   }
/*     */ 
/*     */   public void clearScreen()
/*     */   {
/*  63 */     this.contents = new String();
/*  64 */     for (int i = 0; i < this.rows; i++)
/*     */     {
/*  66 */       this.contents += this.blankLine;
/*     */     }
/*     */   }
/*     */ 
/*     */   public String getContents()
/*     */   {
/* 123 */     return this.contents;
/*     */   }
/*     */ 
/*     */   public int getCursorX()
/*     */   {
/*  74 */     return this.cursorX;
/*     */   }
/*     */ 
/*     */   public int getCursorY()
/*     */   {
/*  86 */     return this.cursorY;
/*     */   }
/*     */ 
/*     */   public int getValueAt(int paramInt)
/*     */   {
/*  98 */     if (paramInt >= this.contents.length()) return -1;
/*  99 */     return this.contents.charAt(paramInt);
/*     */   }
/*     */ 
/*     */   public void putChar(char paramChar)
/*     */   {
/* 131 */     if ((paramChar > '\037') && (paramChar < ''))
/*     */     {
/* 133 */       putDisplayableChar(paramChar);
/* 134 */       return;
/*     */     }
/* 136 */     switch (paramChar)
/*     */     {
/*     */     case '\r':
/* 140 */       this.cursorX = 0;
/* 141 */       break;
/*     */     case '\n':
/* 144 */       this.cursorY += 1;
/*     */ 
/* 146 */       if (this.cursorY == this.rows)
/*     */       {
/* 148 */         this.cursorY -= 1;
/* 149 */         this.contents = 
/* 151 */           (this.contents.substring(this.columns, this.rows * this.columns) + 
/* 151 */           this.blankLine);
/*     */       }
/* 153 */       break;
/*     */     case '':
/* 156 */       this.contents = 
/* 159 */         (this.contents.substring(0, this.cursorY * this.columns + this.cursorX) + 
/* 158 */         new Character(' ').toString() + 
/* 159 */         this.contents.substring(this.cursorY * this.columns + this.cursorX + 1, this.rows * this.columns));
/* 160 */       break;
/*     */     case '\b':
/* 163 */       if ((this.cursorX != 0) || (this.cursorY != 0)) {
/* 164 */         this.cursorX -= 1;
/* 165 */         if (this.cursorX < 0)
/*     */         {
/* 167 */           this.cursorX = (this.columns - 1);
/* 168 */           this.cursorY -= 1;
/*     */         }
/* 170 */         this.contents = 
/* 173 */           (this.contents.substring(0, this.cursorY * this.columns + this.cursorX) + 
/* 172 */           new Character(' ').toString() + 
/* 173 */           this.contents.substring(this.cursorY * this.columns + this.cursorX + 1, this.rows * this.columns));
/* 174 */       }break;
/*     */     case '\t':
/* 177 */       for (int i = 0; i < 7; i++)
/*     */       {
/* 179 */         putDisplayableChar(' ');
/*     */       }
/* 181 */       break;
/*     */     default:
/* 185 */       putDisplayableChar('p');
/*     */     }
/*     */   }
/*     */ 
/*     */   private void putDisplayableChar(char paramChar)
/*     */   {
/* 199 */     if ((this.cursorX == 0) && (this.cursorY == 0)) {
/* 200 */       this.contents = (paramChar + this.contents.substring(1, this.rows * this.columns));
/*     */     }
/* 203 */     else if ((this.cursorX == this.columns - 1) && (this.cursorY == this.rows - 1))
/*     */     {
/* 205 */       char[] arrayOfChar = new char[this.columns];
/* 206 */       for (int i = 0; i < this.columns; i++)
/*     */       {
/* 208 */         arrayOfChar[i] = ' ';
/*     */       }
/* 210 */       this.contents = 
/* 213 */         (this.contents.substring(this.columns, this.rows * this.columns - 1) + 
/* 212 */         paramChar + 
/* 213 */         new String(arrayOfChar));
/*     */     }
/*     */     else {
/* 216 */       this.contents = 
/* 219 */         (this.contents.substring(0, this.cursorY * this.columns + this.cursorX) + 
/* 218 */         paramChar + 
/* 219 */         this.contents.substring(this.cursorY * this.columns + this.cursorX + 1, this.rows * this.columns));
/*     */     }
/*     */ 
/* 222 */     advanceCursor();
/*     */   }
/*     */ 
/*     */   public void reset()
/*     */   {
/*  55 */     this.cursorX = 0;
/*  56 */     this.cursorY = 0;
/*  57 */     clearScreen();
/*     */   }
/*     */ 
/*     */   public void setCursorX(int paramInt)
/*     */   {
/*  79 */     if ((paramInt >= 0) && (paramInt < 40))
/*  80 */       this.cursorX = paramInt;
/*     */   }
/*     */ 
/*     */   public void setCursorY(int paramInt)
/*     */   {
/*  91 */     if ((paramInt >= 0) && (paramInt < 25))
/*  92 */       this.cursorY = paramInt;
/*     */   }
/*     */ 
/*     */   public void setValueAt(int paramInt1, int paramInt2)
/*     */   {
/* 104 */     if ((paramInt1 < 32) || (paramInt1 > 126)) paramInt1 = 112;
/* 105 */     else if (paramInt1 == 32) paramInt1 = 32;
/*     */ 
/* 107 */     if (paramInt2 == 0)
/*     */     {
/* 109 */       this.contents = ((char)paramInt1 + this.contents.substring(1, this.rows * this.columns));
/*     */     }
/* 111 */     else if ((paramInt2 > 0) && (paramInt2 < this.contents.length()))
/*     */     {
/* 113 */       this.contents = 
/* 116 */         (this.contents.substring(0, paramInt2) + 
/* 115 */         (char)paramInt1 + 
/* 116 */         this.contents.substring(paramInt2 + 1, this.rows * this.columns));
/*     */     }
/*     */   }
/*     */ }

/* Location:           C:\Users\daishi\Downloads\virgo213\virgo213_2006\
 * Qualified Name:     SimulatedScreen
 * JD-Core Version:    0.6.2
 */