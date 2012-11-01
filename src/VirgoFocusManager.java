/*    */ import java.awt.AWTEvent;
/*    */ import java.awt.Component;
/*    */ import java.awt.event.InputEvent;
/*    */ import java.awt.event.KeyEvent;
/*    */ import javax.swing.DefaultFocusManager;
/*    */ 
/*    */ class VirgoFocusManager extends DefaultFocusManager
/*    */   implements Constants
/*    */ {
/*    */   Virgo virgo;
/*    */ 
/*    */   VirgoFocusManager(Virgo paramVirgo)
/*    */   {
/* 35 */     this.virgo = paramVirgo;
/*    */   }
/*    */ 
/*    */   public void processKeyEvent(Component paramComponent, KeyEvent paramKeyEvent)
/*    */   {
/* 42 */     if (!this.virgo.virgoState.virgoIsRunning)
/*    */     {
/* 44 */       super.processKeyEvent(paramComponent, paramKeyEvent);
/* 45 */       return;
/*    */     }
/*    */ 
/* 48 */     if (paramKeyEvent.getKeyCode() == 19)
/*    */     {
/* 51 */       this.virgo.virgoState.virgoIsRunning = false;
/*    */     }
/* 55 */     else if (paramKeyEvent.getID() == 400)
/*    */     {
/* 59 */       this.virgo.machine.handleKeyboardInput(paramKeyEvent.getKeyChar());
/*    */ 
/* 62 */       this.virgo.portHasChanged(2);
/*    */     }
/*    */ 
/* 65 */     paramKeyEvent.consume();
/*    */   }
/*    */ }

/* Location:           C:\Users\daishi\Downloads\virgo213\virgo213_2006\
 * Qualified Name:     VirgoFocusManager
 * JD-Core Version:    0.6.2
 */