/*     */ import java.io.BufferedReader;
/*     */ import java.io.FileInputStream;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStreamReader;
/*     */ import java.io.StreamTokenizer;
/*     */ 
/*     */ class ObjFileLoader
/*     */   implements Constants
/*     */ {
/*     */   private static int getDataType(String paramString)
/*     */   {
/* 276 */     paramString = paramString.trim().toLowerCase();
/* 277 */     if (paramString.startsWith("db")) return 0;
/* 278 */     if (paramString.startsWith("dw")) return 1;
/* 279 */     return -1;
/*     */   }
/*     */ 
/*     */   private static int getNestingInfo(String paramString)
/*     */   {
/* 255 */     paramString = paramString.toLowerCase();
/* 256 */     if (paramString.startsWith("call")) return 1;
/* 257 */     if (paramString.startsWith("int")) return 2;
/* 258 */     if (paramString.startsWith("ret")) return 3;
/* 259 */     if (paramString.startsWith("iret")) return 4;
/* 260 */     return 0;
/*     */   }
/*     */ 
/*     */   private static boolean isDataDeclaration(String paramString)
/*     */   {
/* 267 */     paramString = paramString.trim().toLowerCase();
/* 268 */     if ((paramString.startsWith("dw")) || (paramString.startsWith("db"))) return true;
/* 269 */     return false;
/*     */   }
/*     */ 
/*     */   public static boolean load(String paramString, Code paramCode)
/*     */   {
/*     */     FileInputStream localFileInputStream;
/*     */     try
/*     */     {
/*  34 */       localFileInputStream = new FileInputStream(paramString);
/*     */     }
/*     */     catch (IOException localIOException1)
/*     */     {
/*  38 */       return false;
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/*  46 */       BufferedReader localBufferedReader = new BufferedReader(new InputStreamReader(localFileInputStream));
/*  47 */       StreamTokenizer localStreamTokenizer = new StreamTokenizer(localBufferedReader);
/*  48 */       localStreamTokenizer.eolIsSignificant(false);
/*  49 */       localStreamTokenizer.lowerCaseMode(false);
/*  50 */       localStreamTokenizer.slashSlashComments(false);
/*  51 */       localStreamTokenizer.slashStarComments(false);
/*  52 */       localStreamTokenizer.quoteChar(31);
/*     */ 
/*  57 */       localStreamTokenizer.nextToken();
/*  58 */       int i = (int)localStreamTokenizer.nval;
/*     */ 
/*  61 */       int[] arrayOfInt1 = new int[i];
/*  62 */       for (int j = 0; j < i; j++)
/*     */       {
/*  64 */         localStreamTokenizer.nextToken();
/*  65 */         arrayOfInt1[j] = ((int)localStreamTokenizer.nval);
/*     */       }
/*     */ 
/*  68 */       int k = arrayOfInt1[0];
/*  69 */       int m = arrayOfInt1[1];
/*  70 */       int n = arrayOfInt1[2];
/*     */ 
/*  74 */       arrayOfInt1 = null;
/*     */ 
/*  78 */       int[] arrayOfInt2 = new int[k];
/*  79 */       int[] arrayOfInt3 = new int[k];
/*  80 */       int[] arrayOfInt4 = new int[k];
/*  81 */       int[] arrayOfInt5 = new int[k];
/*  82 */       int[][] arrayOfInt = new int[k][];
/*  83 */       String[] arrayOfString1 = new String[k];
/*  84 */       String[] arrayOfString2 = new String[k];
/*  85 */       String[] arrayOfString3 = new String[k];
/*  86 */       int[] arrayOfInt6 = new int[k];
/*  87 */       int[] arrayOfInt7 = new int[k];
/*     */ 
/*  89 */       int i1 = 0;
/*     */ 
/*  95 */       int i2 = 0;
/*     */ 
/*  97 */       String localObject1 = "";
/*     */ 
/* 105 */       for (int i3 = 0; i3 < k; i3++)
/*     */       {
/* 109 */         localStreamTokenizer.nextToken();
/* 110 */         int i4 = Integer.parseInt(localStreamTokenizer.sval, 16);
/*     */ 
/* 113 */         localStreamTokenizer.nextToken();
/* 114 */         int i5 = Integer.parseInt(localStreamTokenizer.sval);
/*     */ 
/* 117 */         localStreamTokenizer.nextToken();
/* 118 */         int[] arrayOfInt10 = new int[i5];
/* 119 */         for (int i6 = 0; i6 < i5; i6++)
/*     */         {
/* 121 */           arrayOfInt10[i6] = Integer.parseInt(localStreamTokenizer.sval.substring(i6 * 2, i6 * 2 + 2), 16);
/*     */         }
/*     */ 
/* 125 */         localStreamTokenizer.nextToken();
/* 126 */         String localObject2 = new String(localStreamTokenizer.sval);
/*     */ 
/* 129 */         localStreamTokenizer.nextToken();
/* 130 */         String localObject3 = new String(localStreamTokenizer.sval).trim();
/*     */ 
/* 133 */         localStreamTokenizer.nextToken();
/* 134 */         String localObject4 = new String(localStreamTokenizer.sval).trim();
/*     */         int i7;
/* 136 */         if ((localObject4 == null) || (((String)localObject4).length() == 0))
/* 137 */           i7 = 0;
/*     */         else try {
/* 139 */             i7 = Integer.parseInt((String)localObject4); } catch (NumberFormatException localNumberFormatException) {
/* 140 */             i7 = 0;
/*     */           }
/* 142 */         if (i5 <= 0)
/*     */         {
/* 145 */           if ((localObject2 != null) && (((String)localObject2).length() > 0)) localObject1 = localObject2;
/*     */ 
/*     */         }
/*     */         else
/*     */         {
/* 150 */           arrayOfInt2[i1] = i4;
/* 151 */           arrayOfInt3[i1] = i5;
/* 152 */           arrayOfInt[i1] = arrayOfInt10;
/* 153 */           arrayOfString2[i1] = localObject3;
/* 154 */           arrayOfInt4[i1] = getNestingInfo((String)localObject3);
/* 155 */           arrayOfInt5[i1] = (i7 * 2);
/* 156 */           if (isDataDeclaration((String)localObject3))
/*     */           {
/* 160 */             if ((localObject2 != null) && (((String)localObject2).length() > 0))
/*     */             {
/* 163 */               arrayOfString3[i2] = new String(((String)localObject2).substring(0, ((String)localObject2).length() - 1));
/* 164 */               arrayOfInt6[i2] = i4;
/* 165 */               arrayOfInt7[i2] = getDataType((String)localObject3);
/* 166 */               i2++;
/*     */             }
/* 168 */             else if ((localObject1 != null) && (((String)localObject1).length() > 0))
/*     */             {
/* 171 */               arrayOfString3[i2] = new String(((String)localObject1).substring(0, ((String)localObject1).length() - 1));
/* 172 */               arrayOfInt6[i2] = i4;
/* 173 */               arrayOfInt7[i2] = getDataType((String)localObject3);
/* 174 */               i2++;
/*     */             }
/*     */           }
/* 177 */           if ((localObject2 != null) && (((String)localObject2).length() > 0))
/*     */           {
/* 179 */             arrayOfString1[i1] = new String((String)localObject2);
/*     */           }
/*     */           else {
/* 182 */             arrayOfString1[i1] = localObject1;
/* 183 */             localObject1 = "";
/*     */           }
/* 185 */           i1++;
/*     */         }
/*     */ 
/*     */       }
/*     */ 
/* 192 */       int[] arrayOfInt8 = new int[i1];
/* 193 */       int[] arrayOfInt9 = new int[i1];
/* 194 */       int[] arrayOfInt10 = new int[i1];
/* 195 */       int[] arrayOfInt11 = new int[i1];
/* 196 */       int[][] localObject2 = new int[i1][];
/* 197 */       String[] localObject3 = new String[i1];
/* 198 */       String[] localObject4 = new String[i1];
/*     */ 
/* 200 */       String[] arrayOfString4 = new String[i2];
/* 201 */       int[] arrayOfInt12 = new int[i2];
/* 202 */       int[] arrayOfInt13 = new int[i2];
/*     */ 
/* 205 */       for (int i8 = 0; i8 < i1; i8++)
/*     */       {
/* 207 */         arrayOfInt8[i8] = arrayOfInt2[i8];
/* 208 */         arrayOfInt9[i8] = arrayOfInt3[i8];
/* 209 */         arrayOfInt10[i8] = arrayOfInt4[i8];
/* 210 */         arrayOfInt11[i8] = arrayOfInt5[i8];
/* 211 */         localObject2[i8] = arrayOfInt[i8];
/* 212 */         localObject3[i8] = arrayOfString1[i8];
/* 213 */         localObject4[i8] = arrayOfString2[i8];
/*     */       }
/*     */ 
/* 216 */       for (int i9 = 0; i9 < i2; i9++)
/*     */       {
/* 218 */         arrayOfString4[i9] = arrayOfString3[i9];
/* 219 */         arrayOfInt12[i9] = arrayOfInt6[i9];
/* 220 */         arrayOfInt13[i9] = arrayOfInt7[i9];
/*     */       }
/*     */ 
/* 224 */       paramCode.startAddresses = arrayOfInt8;
/* 225 */       paramCode.instructionLengths = arrayOfInt9;
/* 226 */       paramCode.instructionNestingInfo = arrayOfInt10;
/* 227 */       paramCode.instructionTimingInfo = arrayOfInt11;
/* 228 */       paramCode.instructions = ((int[][])localObject2);
/* 229 */       paramCode.labels = ((String[])localObject3);
/* 230 */       paramCode.source = ((String[])localObject4);
/* 231 */       paramCode.numberOfLines = i1;
/* 232 */       paramCode.startAddress = m;
/* 233 */       paramCode.startCodeLine = paramCode.convertStartAddressToCodeLine(paramCode.startAddress);
/* 234 */       if (paramCode.startCodeLine < 0) return false;
/*     */ 
/* 236 */       paramCode.dataLabels = arrayOfString4;
/* 237 */       paramCode.dataLabelAddresses = arrayOfInt12;
/* 238 */       paramCode.dataLabelTypes = arrayOfInt13;
/*     */       try {
/* 240 */         localFileInputStream.close(); } catch (IOException localIOException2) {
/* 241 */       }return true;
/*     */     }
/*     */     catch (Throwable localThrowable)
/*     */     {
/*     */       try {
/* 246 */         localFileInputStream.close(); } catch (IOException localIOException3) {  }
/* 247 */     }return false;
/*     */   }
/*     */ }

/* Location:           C:\Users\daishi\Downloads\virgo213\virgo213_2006\
 * Qualified Name:     ObjFileLoader
 * JD-Core Version:    0.6.2
 */