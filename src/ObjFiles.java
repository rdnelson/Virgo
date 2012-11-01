/*    */ import java.io.File;
/*    */ import javax.swing.filechooser.FileFilter;
/*    */ 
/*    */ class ObjFiles extends FileFilter
/*    */ {
/*    */   public boolean accept(File paramFile)
/*    */   {
/* 26 */     if (paramFile.isDirectory()) return true;
/*    */ 
/* 28 */     String str1 = paramFile.getName();
/* 29 */     int i = str1.lastIndexOf('.');
/* 30 */     boolean bool = false;
/*    */ 
/* 32 */     if ((i > 0) && (i < str1.length() - 1))
/*    */     {
/* 34 */       String str2 = str1.substring(i + 1).toLowerCase();
/* 35 */       if (str2.equals("obj")) bool = true;
/*    */     }
/*    */ 
/* 38 */     return bool;
/*    */   }
/*    */ 
/*    */   public String getDescription()
/*    */   {
/* 43 */     return "Object Files (*.obj)";
/*    */   }
/*    */ }

/* Location:           C:\Users\daishi\Downloads\virgo213\virgo213_2006\
 * Qualified Name:     ObjFiles
 * JD-Core Version:    0.6.2
 */