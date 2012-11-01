/*     */ import java.awt.Rectangle;
/*     */ 
/*     */ public abstract interface Constants
/*     */ {
/*  26 */   public static final Rectangle mainWindowBounds = new Rectangle(0, 0, 320, 500);
/*  27 */   public static final Rectangle memoryWindowBounds = new Rectangle(0, 500, 665, 250);
/*  28 */   public static final Rectangle registerPortWindowBounds = new Rectangle(320, 0, 345, 250);
/*  29 */   public static final Rectangle codeWindowBounds = new Rectangle(665, 0, 359, 750);
/*  30 */   public static final Rectangle watchesWindowBounds = new Rectangle(320, 250, 345, 250);
/*  31 */   public static final Rectangle breakpointsWindowBounds = new Rectangle(0, 500, 665, 250);
/*  32 */   public static final Rectangle waitDialogBounds = new Rectangle(0, 0, 250, 70);
/*     */   public static final int SCREEN_ROWS = 25;
/*     */   public static final int SCREEN_COLUMNS = 40;
/*     */   public static final int MEMORY_SIZE = 65536;
/*     */   public static final int INITIAL_MEMORY_VALUE = 255;
/*     */   public static final int MAX_MEMORY = 65535;
/*     */   public static final int OFFSET = 0;
/*     */   public static final int SEGMENT = 1;
/*     */   public static final int AX = 0;
/*     */   public static final int BX = 1;
/*     */   public static final int CX = 2;
/*     */   public static final int DX = 3;
/*     */   public static final int CS = 4;
/*     */   public static final int DS = 5;
/*     */   public static final int SS = 6;
/*     */   public static final int ES = 7;
/*     */   public static final int IP = 8;
/*     */   public static final int SP = 9;
/*     */   public static final int BP = 10;
/*     */   public static final int SI = 11;
/*     */   public static final int DI = 12;
/*     */   public static final int FLAGS = 13;
/*     */   public static final int NUM_REGISTERS = 14;
/*     */   public static final int AH = 30;
/*     */   public static final int AL = 20;
/*     */   public static final int BH = 31;
/*     */   public static final int BL = 21;
/*     */   public static final int CH = 32;
/*     */   public static final int CL = 22;
/*     */   public static final int DH = 33;
/*     */   public static final int DL = 23;
/*     */   public static final short LOW_REG = 2;
/*     */   public static final short HIGH_REG = 3;
/*  92 */   public static final String[] registerStrings = { 
/*  93 */     "AX", "BX", "CX", "DX", 
/*  94 */     "CS", "DS", "SS", "ES", 
/*  95 */     "IP", "SP", "BP", 
/*  96 */     "SI", "DI", "FLAGS", 
/*  97 */     "14", "15", "16", "17", "18", "19", 
/*  98 */     "AL", "BL", "CL", "DL", 
/*  99 */     "24", "25", "26", "27", "28", "29", 
/* 100 */     "AH", "BH", "CH", "DH" };
/*     */   public static final int REAL_REGISTERS = 10;
/* 104 */   public static final int[] realRegisters = { 0, 1, 2, 3, 11, 12, 9, 10, 8, 13 };
/*     */ 
/* 106 */   public static final String[] realRegisterStrings = { 
/* 107 */     "AX", "BX", "CX", "DX", 
/* 108 */     "SI", "DI", "SP", "BP", "IP", "FG" };
/*     */   public static final int NUM_FLAGS = 16;
/*     */   public static final int CF = 0;
/*     */   public static final int PF = 2;
/*     */   public static final int AF = 4;
/*     */   public static final int ZF = 6;
/*     */   public static final int SF = 7;
/*     */   public static final int TF = 8;
/*     */   public static final int IF = 9;
/*     */   public static final int DF = 10;
/*     */   public static final int OF = 11;
/* 130 */   public static final String[] flagStrings = { "CF", "01", "PF", "03", "AF", "05", "ZF", "SF", 
/* 131 */     "TF", "IF", "DF", "OF", "12", "13", "14", "15" };
/*     */ 
/* 134 */   public static final boolean[] FLAG_DEFINED = new boolean[16];
/*     */   public static final int INITIAL_TIMER = 65535;
/*     */   public static final int INITIAL_TIMER_STATUS = 0;
/*     */   public static final int DISPLAY_SIZE = 1000;
/*     */   public static final int TIMER_CONTROL = 16;
/*     */   public static final int KEYBOARD_CONTROL = 0;
/*     */   public static final int DISPLAY_START = 256;
/*     */   public static final int DISPLAY_CONTROL = 1256;
/*     */   public static final int DISPLAY_DATA = 1257;
/*     */   public static final int CURSOR_X = 1258;
/*     */   public static final int CURSOR_Y = 1259;
/*     */   public static final int KEYBOARD_STATUS = 1;
/*     */   public static final int KEYBOARD_DATA = 2;
/*     */   public static final int TIMER_STATUS = 17;
/*     */   public static final int TIMER_RELOAD = 18;
/*     */   public static final int TIMER_CURRENT = 20;
/*     */   public static final int PORT_SIZE = 5632;
/*     */   public static final int PORTS = 7;
/* 166 */   public static final String[] portStrings = { 
/* 167 */     "Cursor X (04EA)", 
/* 168 */     "Cursor Y (04EB)", 
/* 169 */     "Keyboard status (0001)", 
/* 170 */     "Keyboard data (0002)", 
/* 171 */     "Timer status (0011)", 
/* 172 */     "Timer reload (0012)", 
/* 173 */     "Timer current (0014)" };
/*     */   public static final int TIMER_TICK_PERIOD = 1000;
/*     */   public static final int LOW_NIBBLE = 15;
/*     */   public static final int LOW_BYTE = 255;
/*     */   public static final int HIGH_BYTE = 65280;
/*     */   public static final int LOW_WORD = 65535;
/*     */   public static final int HIGH_WORD = -65536;
/*     */   public static final int LOW_DOUBLE_WORD = -1;
/*     */   public static final int BIAS = 128;
/*     */   public static final int MAXPOSBYTE = 127;
/*     */   public static final int MAXPOSWORD = 32767;
/* 205 */   public static final int[] BITMASK = { 1, 2, 4, 8, 
/* 206 */     16, 32, 64, 128, 
/* 207 */     256, 512, 1024, 2048, 
/* 208 */     4096, 8192, 16384, 32768 };
/*     */   public static final int REGMASK = 56;
/*     */   public static final int SEGREGMASK = 24;
/*     */   public static final int ZEROSRMASK = 16;
/*     */   public static final int MODMASK = 192;
/*     */   public static final int RM_MASK = 7;
/*     */   public static final int INSTRUCTION_TIME_MULTIPLIER = 2;
/*     */   public static final byte MAX_INSTR_LENGTH = 7;
/*     */   public static final byte LOCATION_FIELDS = 4;
/*     */   public static final byte OPLOC_FIELDS = 4;
/*     */   public static final byte OFSVAL = 0;
/*     */   public static final byte SEGVAL = 1;
/*     */   public static final byte REG_ID = 2;
/*     */   public static final byte REG_MEM_IMMED = 3;
/*     */   public static final int IS_REG = 1;
/*     */   public static final int IS_MEM = 2;
/*     */   public static final int IS_IMMED = 3;
/*     */   public static final byte BYTE1 = 0;
/*     */   public static final byte BYTE2 = 1;
/*     */   public static final byte BYTE3 = 2;
/*     */   public static final byte BYTE4 = 3;
/*     */   public static final byte BYTE5 = 4;
/*     */   public static final byte BYTE6 = 5;
/*     */   public static final byte INSTR_DATA_FIELDS = 3;
/*     */   public static final byte OPLOC1 = 0;
/*     */   public static final byte OPLOC2 = 1;
/*     */   public static final byte DATA = 2;
/*     */   public static final byte DATA_FIELDS = 1;
/*     */   public static final byte IPINC = 0;
/*     */   public static final byte ADDRMODEDATA_FIELDS = 3;
/*     */   public static final byte ADDRMODE_TYPE = 0;
/*     */   public static final int MODREGRM = 1;
/*     */   public static final int MOD0SRRM = 2;
/*     */   public static final byte OPERAND_WIDTH = 1;
/*     */   public static final int EIGHTBIT = 1;
/*     */   public static final int SIXTEENBIT = 2;
/*     */   public static final byte OPERAND_DIRECTION = 2;
/*     */   public static final int FROMREG = 0;
/*     */   public static final int TOREG = 1;
/*     */   public static final byte INVALID_FIRST_BYTE = 0;
/*     */   public static final byte INVALID_INSTRUCTION = 1;
/*     */   public static final byte INVALID_ADDRESSING_MODE = 2;
/*     */   public static final byte INVALID_NEW_IP = 3;
/*     */   public static final byte BREAKPOINT_REACHED = 4;
/*     */   public static final byte DIVISION_BY_ZERO = 5;
/* 291 */   public static final int[] REG8_LOOKUP_TABLE = { 20, 22, 23, 21, 30, 32, 33, 31 };
/* 292 */   public static final int[] REG16_LOOKUP_TABLE = { 0, 2, 3, 1, 9, 10, 11, 12 };
/* 293 */   public static final int[] SEGREG16_LOOKUP_TABLE = { 7, 4, 6, 5 };
/*     */   public static final int VECTOR_TABLE_SEGMENT = 0;
/*     */   public static final int VECTOR_TABLE_OFFSET = 0;
/*     */   public static final int ORDINARY_INSTRUCTION = 0;
/*     */   public static final int CALL_INSTRUCTION = 1;
/*     */   public static final int INT_INSTRUCTION = 2;
/*     */   public static final int RET_INSTRUCTION = 3;
/*     */   public static final int IRET_INSTRUCTION = 4;
/*     */   public static final char LF = '\n';
/*     */   public static final char CR = '\r';
/*     */   public static final char DEL = '';
/*     */   public static final char BS = '\b';
/*     */   public static final char TAB = '\t';
/*     */   public static final char BLANK = ' ';
/*     */   public static final char SPECIAL_CHAR = 'p';
/*     */   public static final int TAB_SPACES = 7;
/*     */   public static final int BYTE = 0;
/*     */   public static final int WORD = 1;
/*     */   public static final int CODE = 0;
/*     */   public static final int MEMORY = 1;
/*     */   public static final int PORT = 2;
/*     */   public static final int REGISTER = 3;
/*     */   public static final int MODIFIED = 0;
/*     */   public static final int EQUALS = 1;
/*     */   public static final int GREATER_THAN = 2;
/*     */   public static final int LESS_THAN = 3;
/*     */   public static final int NOT_EQUAL = 4;
/*     */   public static final int LESS_THAN_OR_EQUALS = 5;
/*     */   public static final int GREATER_THAN_OR_EQUALS = 6;
/* 351 */   public static final String[] conditionStrings = { "modified", "equal to", "greater than", "less than", "not equal to", "less than or equal to", "greater than or equal to" };
/*     */ }

/* Location:           C:\Users\daishi\Downloads\virgo213\virgo213_2006\
 * Qualified Name:     Constants
 * JD-Core Version:    0.6.2
 */