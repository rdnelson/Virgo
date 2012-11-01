/*     */ public class AddressModeDecoder
/*     */   implements Constants
/*     */ {
/*     */   Machine machine;
/*     */   int modRM;
/*  47 */   int[] modRMLOC = new int[4];
/*     */ 
/*     */   public AddressModeDecoder(Machine paramMachine)
/*     */   {
/*  51 */     this.machine = paramMachine;
/*     */   }
/*     */ 
/*     */   public StopPoint decode(int[] paramArrayOfInt1, int[][] paramArrayOfInt, int[] paramArrayOfInt2)
/*     */   {
/*  65 */     this.modRM = (((paramArrayOfInt1[1] & 0xC0) >> 3) + (
/*  66 */       paramArrayOfInt1[1] & 0x7));
/*     */ 
/*  69 */     for (int i = 0; i < 4; i++) {
/*  70 */       this.modRMLOC[i] = 0;
/*     */     }
/*     */ 
/*  80 */     StopPoint localStopPoint = decodeModRM(paramArrayOfInt1, paramArrayOfInt, paramArrayOfInt2);
/*     */ 
/*  82 */     if (localStopPoint != null) return localStopPoint;
/*     */ 
/* 107 */     switch (paramArrayOfInt2[0])
/*     */     {
/*     */     case 1:
/* 110 */       if (paramArrayOfInt2[2] == 0) {
/* 111 */         if (paramArrayOfInt2[1] == 1)
/*     */         {
/* 113 */           paramArrayOfInt[1][2] = 
/* 114 */             Constants.REG8_LOOKUP_TABLE[((paramArrayOfInt1[1] & 0x38) >> 3)];
/*     */         }
/*     */         else
/*     */         {
/* 118 */           paramArrayOfInt[1][2] = 
/* 119 */             Constants.REG16_LOOKUP_TABLE[((paramArrayOfInt1[1] & 0x38) >> 3)];
/*     */         }
/*     */ 
/* 122 */         paramArrayOfInt[0][0] = this.modRMLOC[0];
/* 123 */         if (paramArrayOfInt[0][2] == 0) {
/* 124 */           paramArrayOfInt[0][1] = this.modRMLOC[1];
/* 125 */           paramArrayOfInt[0][2] = this.modRMLOC[2];
/*     */         }
/* 127 */         paramArrayOfInt[0][3] = this.modRMLOC[3];
/*     */       }
/*     */       else {
/* 130 */         if (paramArrayOfInt2[1] == 1)
/*     */         {
/* 132 */           paramArrayOfInt[0][2] = 
/* 133 */             Constants.REG8_LOOKUP_TABLE[((paramArrayOfInt1[1] & 0x38) >> 3)];
/*     */         }
/*     */         else
/*     */         {
/* 137 */           paramArrayOfInt[0][2] = 
/* 138 */             Constants.REG16_LOOKUP_TABLE[((paramArrayOfInt1[1] & 0x38) >> 3)];
/*     */         }
/*     */ 
/* 141 */         paramArrayOfInt[1][0] = this.modRMLOC[0];
/* 142 */         if (paramArrayOfInt[1][2] == 0) {
/* 143 */           paramArrayOfInt[1][1] = this.modRMLOC[1];
/* 144 */           paramArrayOfInt[1][2] = this.modRMLOC[2];
/*     */         }
/* 146 */         paramArrayOfInt[1][3] = this.modRMLOC[3];
/*     */       }
/* 148 */       break;
/*     */     case 2:
/* 151 */       if (paramArrayOfInt2[2] == 0)
/*     */       {
/* 153 */         paramArrayOfInt[1][2] = 
/* 154 */           Constants.SEGREG16_LOOKUP_TABLE[((paramArrayOfInt1[1] & 0x18) >> 3)];
/*     */ 
/* 156 */         paramArrayOfInt[0][0] = this.modRMLOC[0];
/* 157 */         if (paramArrayOfInt[0][2] == 0) {
/* 158 */           paramArrayOfInt[0][1] = this.modRMLOC[1];
/* 159 */           paramArrayOfInt[0][2] = this.modRMLOC[2];
/*     */         }
/* 161 */         paramArrayOfInt[0][3] = this.modRMLOC[3];
/*     */       }
/*     */       else
/*     */       {
/* 165 */         paramArrayOfInt[0][2] = 
/* 166 */           Constants.SEGREG16_LOOKUP_TABLE[((paramArrayOfInt1[1] & 0x18) >> 3)];
/*     */ 
/* 168 */         paramArrayOfInt[1][0] = this.modRMLOC[0];
/* 169 */         if (paramArrayOfInt[1][2] == 0) {
/* 170 */           paramArrayOfInt[1][1] = this.modRMLOC[1];
/* 171 */           paramArrayOfInt[1][2] = this.modRMLOC[2];
/*     */         }
/* 173 */         paramArrayOfInt[1][3] = this.modRMLOC[3];
/*     */       }
/* 175 */       break;
/*     */     }
/*     */ 
/* 179 */     return null;
/*     */   }
/*     */ 
/*     */   private StopPoint decodeModRM(int[] paramArrayOfInt1, int[][] paramArrayOfInt, int[] paramArrayOfInt2)
/*     */   {
/* 195 */     int i = paramArrayOfInt1[2];
/* 196 */     if (i > 127) i = -(((i ^ 0xFFFFFFFF) & 0xFF) + 1);
/*     */ 
/* 200 */     int j = (paramArrayOfInt1[3] << 8) + paramArrayOfInt1[2];
/*     */ 
/* 209 */     switch (this.modRM) {
/*     */     case 0:
/* 211 */       this.modRMLOC[0] = 
/* 212 */         (this.machine.processor.read16(1) + this.machine.processor.read16(11) & 0xFFFF);
/*     */ 
/* 214 */       this.modRMLOC[1] = this.machine.processor.read16(5);
/* 215 */       this.modRMLOC[2] = 5;
/* 216 */       this.modRMLOC[3] = 2;
/*     */ 
/* 218 */       break;
/*     */     case 1:
/* 220 */       this.modRMLOC[0] = 
/* 221 */         (this.machine.processor.read16(1) + this.machine.processor.read16(12) & 0xFFFF);
/*     */ 
/* 223 */       this.modRMLOC[1] = this.machine.processor.read16(5);
/* 224 */       this.modRMLOC[2] = 5;
/* 225 */       this.modRMLOC[3] = 2;
/*     */ 
/* 227 */       break;
/*     */     case 2:
/* 229 */       this.modRMLOC[0] = 
/* 230 */         (this.machine.processor.read16(10) + this.machine.processor.read16(11) & 0xFFFF);
/*     */ 
/* 232 */       this.modRMLOC[1] = this.machine.processor.read16(6);
/* 233 */       this.modRMLOC[2] = 6;
/* 234 */       this.modRMLOC[3] = 2;
/*     */ 
/* 236 */       break;
/*     */     case 3:
/* 238 */       this.modRMLOC[0] = 
/* 239 */         (this.machine.processor.read16(10) + this.machine.processor.read16(12) & 0xFFFF);
/*     */ 
/* 241 */       this.modRMLOC[1] = this.machine.processor.read16(6);
/* 242 */       this.modRMLOC[2] = 6;
/* 243 */       this.modRMLOC[3] = 2;
/*     */ 
/* 245 */       break;
/*     */     case 4:
/* 248 */       this.modRMLOC[0] = this.machine.processor.read16(11);
/*     */ 
/* 250 */       this.modRMLOC[1] = this.machine.processor.read16(5);
/* 251 */       this.modRMLOC[2] = 5;
/* 252 */       this.modRMLOC[3] = 2;
/*     */ 
/* 254 */       break;
/*     */     case 5:
/* 257 */       this.modRMLOC[0] = this.machine.processor.read16(12);
/*     */ 
/* 259 */       this.modRMLOC[1] = this.machine.processor.read16(5);
/* 260 */       this.modRMLOC[2] = 5;
/* 261 */       this.modRMLOC[3] = 2;
/*     */ 
/* 263 */       break;
/*     */     case 6:
/* 265 */       this.modRMLOC[0] = j;
/*     */ 
/* 267 */       this.modRMLOC[1] = this.machine.processor.read16(5);
/* 268 */       this.modRMLOC[2] = 5;
/* 269 */       this.modRMLOC[3] = 2;
/*     */ 
/* 271 */       paramArrayOfInt[2][0] += 2;
/* 272 */       break;
/*     */     case 7:
/* 275 */       this.modRMLOC[0] = this.machine.processor.read16(1);
/*     */ 
/* 277 */       this.modRMLOC[1] = this.machine.processor.read16(5);
/* 278 */       this.modRMLOC[2] = 5;
/* 279 */       this.modRMLOC[3] = 2;
/*     */ 
/* 281 */       break;
/*     */     case 8:
/* 283 */       this.modRMLOC[0] = 
/* 284 */         (this.machine.processor.read16(1) + this.machine.processor.read16(11) + i & 0xFFFF);
/*     */ 
/* 286 */       this.modRMLOC[1] = this.machine.processor.read16(5);
/* 287 */       this.modRMLOC[2] = 5;
/* 288 */       this.modRMLOC[3] = 2;
/*     */ 
/* 290 */       paramArrayOfInt[2][0] += 1;
/* 291 */       break;
/*     */     case 9:
/* 293 */       this.modRMLOC[0] = 
/* 294 */         (this.machine.processor.read16(1) + this.machine.processor.read16(12) + i & 0xFFFF);
/*     */ 
/* 296 */       this.modRMLOC[1] = this.machine.processor.read16(5);
/* 297 */       this.modRMLOC[2] = 5;
/* 298 */       this.modRMLOC[3] = 2;
/*     */ 
/* 300 */       paramArrayOfInt[2][0] += 1;
/* 301 */       break;
/*     */     case 10:
/* 303 */       this.modRMLOC[0] = 
/* 304 */         (this.machine.processor.read16(10) + this.machine.processor.read16(11) + i & 0xFFFF);
/*     */ 
/* 306 */       this.modRMLOC[1] = this.machine.processor.read16(6);
/* 307 */       this.modRMLOC[2] = 6;
/* 308 */       this.modRMLOC[3] = 2;
/*     */ 
/* 310 */       paramArrayOfInt[2][0] += 1;
/* 311 */       break;
/*     */     case 11:
/* 313 */       this.modRMLOC[0] = 
/* 314 */         (this.machine.processor.read16(10) + this.machine.processor.read16(12) + i & 0xFFFF);
/*     */ 
/* 316 */       this.modRMLOC[1] = this.machine.processor.read16(6);
/* 317 */       this.modRMLOC[2] = 6;
/* 318 */       this.modRMLOC[3] = 2;
/*     */ 
/* 320 */       paramArrayOfInt[2][0] += 1;
/* 321 */       break;
/*     */     case 12:
/* 323 */       this.modRMLOC[0] = 
/* 324 */         (this.machine.processor.read16(11) + i & 0xFFFF);
/*     */ 
/* 326 */       this.modRMLOC[1] = this.machine.processor.read16(5);
/* 327 */       this.modRMLOC[2] = 5;
/* 328 */       this.modRMLOC[3] = 2;
/*     */ 
/* 330 */       paramArrayOfInt[2][0] += 1;
/* 331 */       break;
/*     */     case 13:
/* 333 */       this.modRMLOC[0] = 
/* 334 */         (this.machine.processor.read16(12) + i & 0xFFFF);
/*     */ 
/* 336 */       this.modRMLOC[1] = this.machine.processor.read16(5);
/* 337 */       this.modRMLOC[2] = 5;
/* 338 */       this.modRMLOC[3] = 2;
/*     */ 
/* 340 */       paramArrayOfInt[2][0] += 1;
/* 341 */       break;
/*     */     case 14:
/* 343 */       this.modRMLOC[0] = 
/* 344 */         (this.machine.processor.read16(10) + i & 0xFFFF);
/*     */ 
/* 346 */       this.modRMLOC[1] = this.machine.processor.read16(6);
/* 347 */       this.modRMLOC[2] = 6;
/* 348 */       this.modRMLOC[3] = 2;
/*     */ 
/* 350 */       paramArrayOfInt[2][0] += 1;
/* 351 */       break;
/*     */     case 15:
/* 353 */       this.modRMLOC[0] = 
/* 354 */         (this.machine.processor.read16(1) + i & 0xFFFF);
/*     */ 
/* 356 */       this.modRMLOC[1] = this.machine.processor.read16(5);
/* 357 */       this.modRMLOC[2] = 5;
/* 358 */       this.modRMLOC[3] = 2;
/*     */ 
/* 360 */       paramArrayOfInt[2][0] += 1;
/* 361 */       break;
/*     */     case 16:
/* 363 */       this.modRMLOC[0] = 
/* 364 */         (this.machine.processor.read16(1) + this.machine.processor.read16(11) + j & 0xFFFF);
/*     */ 
/* 366 */       this.modRMLOC[1] = this.machine.processor.read16(5);
/* 367 */       this.modRMLOC[2] = 5;
/* 368 */       this.modRMLOC[3] = 2;
/*     */ 
/* 370 */       paramArrayOfInt[2][0] += 2;
/* 371 */       break;
/*     */     case 17:
/* 373 */       this.modRMLOC[0] = 
/* 374 */         (this.machine.processor.read16(1) + this.machine.processor.read16(12) + j & 0xFFFF);
/*     */ 
/* 376 */       this.modRMLOC[1] = this.machine.processor.read16(5);
/* 377 */       this.modRMLOC[2] = 5;
/* 378 */       this.modRMLOC[3] = 2;
/*     */ 
/* 380 */       paramArrayOfInt[2][0] += 2;
/* 381 */       break;
/*     */     case 18:
/* 383 */       this.modRMLOC[0] = 
/* 384 */         (this.machine.processor.read16(10) + this.machine.processor.read16(11) + j & 0xFFFF);
/*     */ 
/* 386 */       this.modRMLOC[1] = this.machine.processor.read16(6);
/* 387 */       this.modRMLOC[2] = 6;
/* 388 */       this.modRMLOC[3] = 2;
/*     */ 
/* 390 */       paramArrayOfInt[2][0] += 2;
/* 391 */       break;
/*     */     case 19:
/* 393 */       this.modRMLOC[0] = 
/* 394 */         (this.machine.processor.read16(10) + this.machine.processor.read16(12) + j & 0xFFFF);
/*     */ 
/* 396 */       this.modRMLOC[1] = this.machine.processor.read16(6);
/* 397 */       this.modRMLOC[2] = 6;
/* 398 */       this.modRMLOC[3] = 2;
/*     */ 
/* 400 */       paramArrayOfInt[2][0] += 2;
/* 401 */       break;
/*     */     case 20:
/* 403 */       this.modRMLOC[0] = 
/* 404 */         (this.machine.processor.read16(11) + j & 0xFFFF);
/*     */ 
/* 406 */       this.modRMLOC[1] = this.machine.processor.read16(5);
/* 407 */       this.modRMLOC[2] = 5;
/* 408 */       this.modRMLOC[3] = 2;
/*     */ 
/* 410 */       paramArrayOfInt[2][0] += 2;
/* 411 */       break;
/*     */     case 21:
/* 413 */       this.modRMLOC[0] = 
/* 414 */         (this.machine.processor.read16(12) + j & 0xFFFF);
/*     */ 
/* 416 */       this.modRMLOC[1] = this.machine.processor.read16(5);
/* 417 */       this.modRMLOC[2] = 5;
/* 418 */       this.modRMLOC[3] = 2;
/*     */ 
/* 420 */       paramArrayOfInt[2][0] += 2;
/* 421 */       break;
/*     */     case 22:
/* 423 */       this.modRMLOC[0] = 
/* 424 */         (this.machine.processor.read16(10) + j & 0xFFFF);
/*     */ 
/* 426 */       this.modRMLOC[1] = this.machine.processor.read16(6);
/* 427 */       this.modRMLOC[2] = 6;
/* 428 */       this.modRMLOC[3] = 2;
/*     */ 
/* 430 */       paramArrayOfInt[2][0] += 2;
/* 431 */       break;
/*     */     case 23:
/* 433 */       this.modRMLOC[0] = 
/* 434 */         (this.machine.processor.read16(1) + j & 0xFFFF);
/*     */ 
/* 436 */       this.modRMLOC[1] = this.machine.processor.read16(5);
/* 437 */       this.modRMLOC[2] = 5;
/* 438 */       this.modRMLOC[3] = 2;
/*     */ 
/* 440 */       paramArrayOfInt[2][0] += 2;
/* 441 */       break;
/*     */     case 24:
/* 443 */       if (paramArrayOfInt2[1] == 1)
/* 444 */         this.modRMLOC[2] = 20;
/*     */       else
/* 446 */         this.modRMLOC[2] = 0;
/* 447 */       this.modRMLOC[3] = 1;
/*     */ 
/* 449 */       break;
/*     */     case 25:
/* 451 */       if (paramArrayOfInt2[1] == 1)
/* 452 */         this.modRMLOC[2] = 22;
/*     */       else
/* 454 */         this.modRMLOC[2] = 2;
/* 455 */       this.modRMLOC[3] = 1;
/*     */ 
/* 457 */       break;
/*     */     case 26:
/* 459 */       if (paramArrayOfInt2[1] == 1)
/* 460 */         this.modRMLOC[2] = 23;
/*     */       else
/* 462 */         this.modRMLOC[2] = 3;
/* 463 */       this.modRMLOC[3] = 1;
/*     */ 
/* 465 */       break;
/*     */     case 27:
/* 467 */       if (paramArrayOfInt2[1] == 1)
/* 468 */         this.modRMLOC[2] = 21;
/*     */       else
/* 470 */         this.modRMLOC[2] = 1;
/* 471 */       this.modRMLOC[3] = 1;
/*     */ 
/* 473 */       break;
/*     */     case 28:
/* 475 */       if (paramArrayOfInt2[1] == 1)
/* 476 */         this.modRMLOC[2] = 30;
/*     */       else
/* 478 */         this.modRMLOC[2] = 9;
/* 479 */       this.modRMLOC[3] = 1;
/*     */ 
/* 481 */       break;
/*     */     case 29:
/* 483 */       if (paramArrayOfInt2[1] == 1)
/* 484 */         this.modRMLOC[2] = 32;
/*     */       else
/* 486 */         this.modRMLOC[2] = 10;
/* 487 */       this.modRMLOC[3] = 1;
/*     */ 
/* 489 */       break;
/*     */     case 30:
/* 491 */       if (paramArrayOfInt2[1] == 1)
/* 492 */         this.modRMLOC[2] = 33;
/*     */       else
/* 494 */         this.modRMLOC[2] = 11;
/* 495 */       this.modRMLOC[3] = 1;
/*     */ 
/* 497 */       break;
/*     */     case 31:
/* 499 */       if (paramArrayOfInt2[1] == 1)
/* 500 */         this.modRMLOC[2] = 31;
/*     */       else
/* 502 */         this.modRMLOC[2] = 12;
/* 503 */       this.modRMLOC[3] = 1;
/*     */ 
/* 505 */       break;
/*     */     default:
/* 508 */       return new StopPoint(2, "");
/*     */     }
/*     */ 
/* 513 */     return null;
/*     */   }
/*     */ }

/* Location:           C:\Users\daishi\Downloads\virgo213\virgo213_2006\
 * Qualified Name:     AddressModeDecoder
 * JD-Core Version:    0.6.2
 */