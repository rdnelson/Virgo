/*     */ public class Library
/*     */   implements Constants
/*     */ {
/*     */   public static int StringAddressToInt(String paramString)
/*     */   {
/* 104 */     return StringWordToInt(paramString);
/*     */   }
/*     */ 
/*     */   public static int StringByteToInt(String paramString)
/*     */   {
/* 110 */     return Integer.parseInt(paramString, 16);
/*     */   }
/*     */ 
/*     */   public static int StringWordToInt(String paramString)
/*     */   {
/*  99 */     return Integer.parseInt(paramString, 16);
/*     */   }
/*     */ 
/*     */   public static String conditionToString(int paramInt)
/*     */   {
/*  91 */     if (paramInt > 6) return "undefined condition";
/*  92 */     return new String(Constants.conditionStrings[paramInt]);
/*     */   }
/*     */ 
/*     */   public static boolean isValidAddress(String paramString)
/*     */   {
/*  52 */     return isValidWord(paramString);
/*     */   }
/*     */ 
/*     */   public static boolean isValidByte(String paramString)
/*     */   {
/*  57 */     if (paramString.length() > 2) return false;
/*  58 */     if (paramString.trim().startsWith("-")) return false;
/*     */     try
/*     */     {
/*  61 */       Integer.parseInt(paramString, 16);
/*  62 */       return true; } catch (NumberFormatException localNumberFormatException) {
/*     */     }
/*  64 */     return false;
/*     */   }
/*     */ 
/*     */   public static boolean isValidDecimal(String paramString)
/*     */   {
/*     */     try
/*     */     {
/*  71 */       Integer.parseInt(paramString);
/*  72 */       return true; } catch (NumberFormatException localNumberFormatException) {
/*     */     }
/*  74 */     return false;
/*     */   }
/*     */ 
/*     */   public static boolean isValidFlag(int paramInt)
/*     */   {
/*  34 */     if ((paramInt >= 0) && (paramInt <= 15)) return true;
/*  35 */     return false;
/*     */   }
/*     */ 
/*     */   public static boolean isValidRegister(int paramInt)
/*     */   {
/*  26 */     if ((paramInt >= 0) && (paramInt <= 13)) return true;
/*  27 */     if ((paramInt >= 20) && (paramInt <= 23)) return true;
/*  28 */     if ((paramInt >= 30) && (paramInt <= 33)) return true;
/*  29 */     return false;
/*     */   }
/*     */ 
/*     */   public static boolean isValidWord(String paramString)
/*     */   {
/*  40 */     if (paramString.length() > 4) return false;
/*  41 */     if (paramString.trim().startsWith("-")) return false;
/*     */     try
/*     */     {
/*  44 */       Integer.parseInt(paramString, 16);
/*  45 */       return true; } catch (NumberFormatException localNumberFormatException) {
/*     */     }
/*  47 */     return false;
/*     */   }
/*     */ 
/*     */   public static boolean portIsSignificantToPortWindow(int paramInt)
/*     */   {
/* 141 */     if ((paramInt == 1258) || (paramInt == 1259) || (paramInt == 1257) || 
/* 142 */       (paramInt == 1) || (paramInt == 2) || (paramInt == 17) || (paramInt == 18) || 
/* 143 */       (paramInt == 20) || (paramInt == 0) || 
/* 144 */       (paramInt == 16) || (paramInt == 1256)) {
/* 145 */       return true;
/*     */     }
/* 147 */     return false;
/*     */   }
/*     */ 
/*     */   public static boolean portIsSignificantToScreenArea(int paramInt)
/*     */   {
/* 155 */     if ((paramInt >= 256) && (paramInt <= 1255)) return true;
/*     */ 
/* 158 */     if ((paramInt == 1257) || (paramInt == 1256) || (paramInt == 1258) || (paramInt == 1259)) return true;
/*     */ 
/* 160 */     return false;
/*     */   }
/*     */ 
/*     */   public static String registerToString(int paramInt)
/*     */   {
/*  85 */     if (!isValidRegister(paramInt)) return "UNDEFINED REGISTER";
/*  86 */     return new String(Constants.registerStrings[paramInt]);
/*     */   }
/*     */ 
/*     */   public static String toStringAddress(int paramInt)
/*     */   {
/* 115 */     return toStringWord(paramInt);
/*     */   }
/*     */ 
/*     */   public static String toStringByte(int paramInt)
/*     */   {
/* 128 */     String str = Integer.toHexString(paramInt).toUpperCase();
/* 129 */     while (str.length() < 2) str = "0" + str;
/* 130 */     if (str.length() > 2) str = str.substring(str.length() - 3);
/* 131 */     return str;
/*     */   }
/*     */ 
/*     */   public static String toStringWord(int paramInt)
/*     */   {
/* 120 */     String str = Integer.toHexString(paramInt).toUpperCase();
/* 121 */     while (str.length() < 4) str = "0" + str;
/* 122 */     if (str.length() > 4) str = str.substring(str.length() - 5);
/* 123 */     return str;
/*     */   }
/*     */ }

/* Location:           C:\Users\daishi\Downloads\virgo213\virgo213_2006\
 * Qualified Name:     Library
 * JD-Core Version:    0.6.2
 */