/*      */ public class JumpTable
/*      */   implements Constants
/*      */ {
/*      */   Machine machine;
/*      */   StopPoint stopPoint;
/*      */ 
/*      */   public JumpTable(Machine paramMachine)
/*      */   {
/*   37 */     this.machine = paramMachine;
/*   38 */     this.stopPoint = null;
/*      */   }
/*      */ 
/*      */   public StopPoint executeInstruction(int[] paramArrayOfInt1, int[][] paramArrayOfInt, int[] paramArrayOfInt2) {
/*   42 */     int i = paramArrayOfInt1[0];
/*   43 */     switch (i) { case 0:
/*   44 */       return jump00(paramArrayOfInt1, paramArrayOfInt, paramArrayOfInt2);
/*      */     case 1:
/*   45 */       return jump01(paramArrayOfInt1, paramArrayOfInt, paramArrayOfInt2);
/*      */     case 2:
/*   46 */       return jump02(paramArrayOfInt1, paramArrayOfInt, paramArrayOfInt2);
/*      */     case 3:
/*   47 */       return jump03(paramArrayOfInt1, paramArrayOfInt, paramArrayOfInt2);
/*      */     case 4:
/*   48 */       return jump04(paramArrayOfInt1, paramArrayOfInt, paramArrayOfInt2);
/*      */     case 5:
/*   49 */       return jump05(paramArrayOfInt1, paramArrayOfInt, paramArrayOfInt2);
/*      */     case 6:
/*   50 */       return jump06(paramArrayOfInt1, paramArrayOfInt, paramArrayOfInt2);
/*      */     case 7:
/*   51 */       return jump07(paramArrayOfInt1, paramArrayOfInt, paramArrayOfInt2);
/*      */     case 8:
/*   52 */       return jump08(paramArrayOfInt1, paramArrayOfInt, paramArrayOfInt2);
/*      */     case 9:
/*   53 */       return jump09(paramArrayOfInt1, paramArrayOfInt, paramArrayOfInt2);
/*      */     case 10:
/*   54 */       return jump0A(paramArrayOfInt1, paramArrayOfInt, paramArrayOfInt2);
/*      */     case 11:
/*   55 */       return jump0B(paramArrayOfInt1, paramArrayOfInt, paramArrayOfInt2);
/*      */     case 12:
/*   56 */       return jump0C(paramArrayOfInt1, paramArrayOfInt, paramArrayOfInt2);
/*      */     case 13:
/*   57 */       return jump0D(paramArrayOfInt1, paramArrayOfInt, paramArrayOfInt2);
/*      */     case 14:
/*   58 */       return jump0E(paramArrayOfInt1, paramArrayOfInt, paramArrayOfInt2);
/*      */     case 15:
/*   59 */       return jumpNU(paramArrayOfInt1, paramArrayOfInt, paramArrayOfInt2);
/*      */     case 16:
/*   60 */       return jump10(paramArrayOfInt1, paramArrayOfInt, paramArrayOfInt2);
/*      */     case 17:
/*   61 */       return jump11(paramArrayOfInt1, paramArrayOfInt, paramArrayOfInt2);
/*      */     case 18:
/*   62 */       return jump12(paramArrayOfInt1, paramArrayOfInt, paramArrayOfInt2);
/*      */     case 19:
/*   63 */       return jump13(paramArrayOfInt1, paramArrayOfInt, paramArrayOfInt2);
/*      */     case 20:
/*   64 */       return jump14(paramArrayOfInt1, paramArrayOfInt, paramArrayOfInt2);
/*      */     case 21:
/*   65 */       return jump15(paramArrayOfInt1, paramArrayOfInt, paramArrayOfInt2);
/*      */     case 22:
/*   66 */       return jump16(paramArrayOfInt1, paramArrayOfInt, paramArrayOfInt2);
/*      */     case 23:
/*   67 */       return jump17(paramArrayOfInt1, paramArrayOfInt, paramArrayOfInt2);
/*      */     case 24:
/*   68 */       return jump18(paramArrayOfInt1, paramArrayOfInt, paramArrayOfInt2);
/*      */     case 25:
/*   69 */       return jump19(paramArrayOfInt1, paramArrayOfInt, paramArrayOfInt2);
/*      */     case 26:
/*   70 */       return jump1A(paramArrayOfInt1, paramArrayOfInt, paramArrayOfInt2);
/*      */     case 27:
/*   71 */       return jump1B(paramArrayOfInt1, paramArrayOfInt, paramArrayOfInt2);
/*      */     case 28:
/*   72 */       return jump1C(paramArrayOfInt1, paramArrayOfInt, paramArrayOfInt2);
/*      */     case 29:
/*   73 */       return jump1D(paramArrayOfInt1, paramArrayOfInt, paramArrayOfInt2);
/*      */     case 30:
/*   74 */       return jump1E(paramArrayOfInt1, paramArrayOfInt, paramArrayOfInt2);
/*      */     case 31:
/*   75 */       return jump1F(paramArrayOfInt1, paramArrayOfInt, paramArrayOfInt2);
/*      */     case 32:
/*   76 */       return jump20(paramArrayOfInt1, paramArrayOfInt, paramArrayOfInt2);
/*      */     case 33:
/*   77 */       return jump21(paramArrayOfInt1, paramArrayOfInt, paramArrayOfInt2);
/*      */     case 34:
/*   78 */       return jump22(paramArrayOfInt1, paramArrayOfInt, paramArrayOfInt2);
/*      */     case 35:
/*   79 */       return jump23(paramArrayOfInt1, paramArrayOfInt, paramArrayOfInt2);
/*      */     case 36:
/*   80 */       return jump24(paramArrayOfInt1, paramArrayOfInt, paramArrayOfInt2);
/*      */     case 37:
/*   81 */       return jump25(paramArrayOfInt1, paramArrayOfInt, paramArrayOfInt2);
/*      */     case 38:
/*   82 */       return jump26(paramArrayOfInt1, paramArrayOfInt, paramArrayOfInt2);
/*      */     case 39:
/*   83 */       return jump27(paramArrayOfInt1, paramArrayOfInt, paramArrayOfInt2);
/*      */     case 40:
/*   84 */       return jump28(paramArrayOfInt1, paramArrayOfInt, paramArrayOfInt2);
/*      */     case 41:
/*   85 */       return jump29(paramArrayOfInt1, paramArrayOfInt, paramArrayOfInt2);
/*      */     case 42:
/*   86 */       return jump2A(paramArrayOfInt1, paramArrayOfInt, paramArrayOfInt2);
/*      */     case 43:
/*   87 */       return jump2B(paramArrayOfInt1, paramArrayOfInt, paramArrayOfInt2);
/*      */     case 44:
/*   88 */       return jump2C(paramArrayOfInt1, paramArrayOfInt, paramArrayOfInt2);
/*      */     case 45:
/*   89 */       return jump2D(paramArrayOfInt1, paramArrayOfInt, paramArrayOfInt2);
/*      */     case 46:
/*   90 */       return jump2E(paramArrayOfInt1, paramArrayOfInt, paramArrayOfInt2);
/*      */     case 47:
/*   91 */       return jump2F(paramArrayOfInt1, paramArrayOfInt, paramArrayOfInt2);
/*      */     case 48:
/*   92 */       return jump30(paramArrayOfInt1, paramArrayOfInt, paramArrayOfInt2);
/*      */     case 49:
/*   93 */       return jump31(paramArrayOfInt1, paramArrayOfInt, paramArrayOfInt2);
/*      */     case 50:
/*   94 */       return jump32(paramArrayOfInt1, paramArrayOfInt, paramArrayOfInt2);
/*      */     case 51:
/*   95 */       return jump33(paramArrayOfInt1, paramArrayOfInt, paramArrayOfInt2);
/*      */     case 52:
/*   96 */       return jump34(paramArrayOfInt1, paramArrayOfInt, paramArrayOfInt2);
/*      */     case 53:
/*   97 */       return jump35(paramArrayOfInt1, paramArrayOfInt, paramArrayOfInt2);
/*      */     case 54:
/*   98 */       return jump36(paramArrayOfInt1, paramArrayOfInt, paramArrayOfInt2);
/*      */     case 55:
/*   99 */       return jump37(paramArrayOfInt1, paramArrayOfInt, paramArrayOfInt2);
/*      */     case 56:
/*  100 */       return jump38(paramArrayOfInt1, paramArrayOfInt, paramArrayOfInt2);
/*      */     case 57:
/*  101 */       return jump39(paramArrayOfInt1, paramArrayOfInt, paramArrayOfInt2);
/*      */     case 58:
/*  102 */       return jump3A(paramArrayOfInt1, paramArrayOfInt, paramArrayOfInt2);
/*      */     case 59:
/*  103 */       return jump3B(paramArrayOfInt1, paramArrayOfInt, paramArrayOfInt2);
/*      */     case 60:
/*  104 */       return jump3C(paramArrayOfInt1, paramArrayOfInt, paramArrayOfInt2);
/*      */     case 61:
/*  105 */       return jump3D(paramArrayOfInt1, paramArrayOfInt, paramArrayOfInt2);
/*      */     case 62:
/*  106 */       return jump3E(paramArrayOfInt1, paramArrayOfInt, paramArrayOfInt2);
/*      */     case 63:
/*  107 */       return jump3F(paramArrayOfInt1, paramArrayOfInt, paramArrayOfInt2);
/*      */     case 64:
/*  108 */       return jump40(paramArrayOfInt1, paramArrayOfInt, paramArrayOfInt2);
/*      */     case 65:
/*  109 */       return jump41(paramArrayOfInt1, paramArrayOfInt, paramArrayOfInt2);
/*      */     case 66:
/*  110 */       return jump42(paramArrayOfInt1, paramArrayOfInt, paramArrayOfInt2);
/*      */     case 67:
/*  111 */       return jump43(paramArrayOfInt1, paramArrayOfInt, paramArrayOfInt2);
/*      */     case 68:
/*  112 */       return jump44(paramArrayOfInt1, paramArrayOfInt, paramArrayOfInt2);
/*      */     case 69:
/*  113 */       return jump45(paramArrayOfInt1, paramArrayOfInt, paramArrayOfInt2);
/*      */     case 70:
/*  114 */       return jump46(paramArrayOfInt1, paramArrayOfInt, paramArrayOfInt2);
/*      */     case 71:
/*  115 */       return jump47(paramArrayOfInt1, paramArrayOfInt, paramArrayOfInt2);
/*      */     case 72:
/*  116 */       return jump48(paramArrayOfInt1, paramArrayOfInt, paramArrayOfInt2);
/*      */     case 73:
/*  117 */       return jump49(paramArrayOfInt1, paramArrayOfInt, paramArrayOfInt2);
/*      */     case 74:
/*  118 */       return jump4A(paramArrayOfInt1, paramArrayOfInt, paramArrayOfInt2);
/*      */     case 75:
/*  119 */       return jump4B(paramArrayOfInt1, paramArrayOfInt, paramArrayOfInt2);
/*      */     case 76:
/*  120 */       return jump4C(paramArrayOfInt1, paramArrayOfInt, paramArrayOfInt2);
/*      */     case 77:
/*  121 */       return jump4D(paramArrayOfInt1, paramArrayOfInt, paramArrayOfInt2);
/*      */     case 78:
/*  122 */       return jump4E(paramArrayOfInt1, paramArrayOfInt, paramArrayOfInt2);
/*      */     case 79:
/*  123 */       return jump4F(paramArrayOfInt1, paramArrayOfInt, paramArrayOfInt2);
/*      */     case 80:
/*  124 */       return jump50(paramArrayOfInt1, paramArrayOfInt, paramArrayOfInt2);
/*      */     case 81:
/*  125 */       return jump51(paramArrayOfInt1, paramArrayOfInt, paramArrayOfInt2);
/*      */     case 82:
/*  126 */       return jump52(paramArrayOfInt1, paramArrayOfInt, paramArrayOfInt2);
/*      */     case 83:
/*  127 */       return jump53(paramArrayOfInt1, paramArrayOfInt, paramArrayOfInt2);
/*      */     case 84:
/*  128 */       return jump54(paramArrayOfInt1, paramArrayOfInt, paramArrayOfInt2);
/*      */     case 85:
/*  129 */       return jump55(paramArrayOfInt1, paramArrayOfInt, paramArrayOfInt2);
/*      */     case 86:
/*  130 */       return jump56(paramArrayOfInt1, paramArrayOfInt, paramArrayOfInt2);
/*      */     case 87:
/*  131 */       return jump57(paramArrayOfInt1, paramArrayOfInt, paramArrayOfInt2);
/*      */     case 88:
/*  132 */       return jump58(paramArrayOfInt1, paramArrayOfInt, paramArrayOfInt2);
/*      */     case 89:
/*  133 */       return jump59(paramArrayOfInt1, paramArrayOfInt, paramArrayOfInt2);
/*      */     case 90:
/*  134 */       return jump5A(paramArrayOfInt1, paramArrayOfInt, paramArrayOfInt2);
/*      */     case 91:
/*  135 */       return jump5B(paramArrayOfInt1, paramArrayOfInt, paramArrayOfInt2);
/*      */     case 92:
/*  136 */       return jump5C(paramArrayOfInt1, paramArrayOfInt, paramArrayOfInt2);
/*      */     case 93:
/*  137 */       return jump5D(paramArrayOfInt1, paramArrayOfInt, paramArrayOfInt2);
/*      */     case 94:
/*  138 */       return jump5E(paramArrayOfInt1, paramArrayOfInt, paramArrayOfInt2);
/*      */     case 95:
/*  139 */       return jump5F(paramArrayOfInt1, paramArrayOfInt, paramArrayOfInt2);
/*      */     case 96:
/*  140 */       return jumpNU(paramArrayOfInt1, paramArrayOfInt, paramArrayOfInt2);
/*      */     case 97:
/*  141 */       return jumpNU(paramArrayOfInt1, paramArrayOfInt, paramArrayOfInt2);
/*      */     case 98:
/*  142 */       return jumpNU(paramArrayOfInt1, paramArrayOfInt, paramArrayOfInt2);
/*      */     case 99:
/*  143 */       return jumpNU(paramArrayOfInt1, paramArrayOfInt, paramArrayOfInt2);
/*      */     case 100:
/*  144 */       return jumpNU(paramArrayOfInt1, paramArrayOfInt, paramArrayOfInt2);
/*      */     case 101:
/*  145 */       return jumpNU(paramArrayOfInt1, paramArrayOfInt, paramArrayOfInt2);
/*      */     case 102:
/*  146 */       return jumpNU(paramArrayOfInt1, paramArrayOfInt, paramArrayOfInt2);
/*      */     case 103:
/*  147 */       return jumpNU(paramArrayOfInt1, paramArrayOfInt, paramArrayOfInt2);
/*      */     case 104:
/*  148 */       return jumpNU(paramArrayOfInt1, paramArrayOfInt, paramArrayOfInt2);
/*      */     case 105:
/*  149 */       return jumpNU(paramArrayOfInt1, paramArrayOfInt, paramArrayOfInt2);
/*      */     case 106:
/*  150 */       return jumpNU(paramArrayOfInt1, paramArrayOfInt, paramArrayOfInt2);
/*      */     case 107:
/*  151 */       return jumpNU(paramArrayOfInt1, paramArrayOfInt, paramArrayOfInt2);
/*      */     case 108:
/*  152 */       return jumpNU(paramArrayOfInt1, paramArrayOfInt, paramArrayOfInt2);
/*      */     case 109:
/*  153 */       return jumpNU(paramArrayOfInt1, paramArrayOfInt, paramArrayOfInt2);
/*      */     case 110:
/*  154 */       return jumpNU(paramArrayOfInt1, paramArrayOfInt, paramArrayOfInt2);
/*      */     case 111:
/*  155 */       return jumpNU(paramArrayOfInt1, paramArrayOfInt, paramArrayOfInt2);
/*      */     case 112:
/*  156 */       return jump70(paramArrayOfInt1, paramArrayOfInt, paramArrayOfInt2);
/*      */     case 113:
/*  157 */       return jump71(paramArrayOfInt1, paramArrayOfInt, paramArrayOfInt2);
/*      */     case 114:
/*  158 */       return jump72(paramArrayOfInt1, paramArrayOfInt, paramArrayOfInt2);
/*      */     case 115:
/*  159 */       return jump73(paramArrayOfInt1, paramArrayOfInt, paramArrayOfInt2);
/*      */     case 116:
/*  160 */       return jump74(paramArrayOfInt1, paramArrayOfInt, paramArrayOfInt2);
/*      */     case 117:
/*  161 */       return jump75(paramArrayOfInt1, paramArrayOfInt, paramArrayOfInt2);
/*      */     case 118:
/*  162 */       return jump76(paramArrayOfInt1, paramArrayOfInt, paramArrayOfInt2);
/*      */     case 119:
/*  163 */       return jump77(paramArrayOfInt1, paramArrayOfInt, paramArrayOfInt2);
/*      */     case 120:
/*  164 */       return jump78(paramArrayOfInt1, paramArrayOfInt, paramArrayOfInt2);
/*      */     case 121:
/*  165 */       return jump79(paramArrayOfInt1, paramArrayOfInt, paramArrayOfInt2);
/*      */     case 122:
/*  166 */       return jump7A(paramArrayOfInt1, paramArrayOfInt, paramArrayOfInt2);
/*      */     case 123:
/*  167 */       return jump7B(paramArrayOfInt1, paramArrayOfInt, paramArrayOfInt2);
/*      */     case 124:
/*  168 */       return jump7C(paramArrayOfInt1, paramArrayOfInt, paramArrayOfInt2);
/*      */     case 125:
/*  169 */       return jump7D(paramArrayOfInt1, paramArrayOfInt, paramArrayOfInt2);
/*      */     case 126:
/*  170 */       return jump7E(paramArrayOfInt1, paramArrayOfInt, paramArrayOfInt2);
/*      */     case 127:
/*  171 */       return jump7F(paramArrayOfInt1, paramArrayOfInt, paramArrayOfInt2);
/*      */     case 128:
/*  172 */       return jump80(paramArrayOfInt1, paramArrayOfInt, paramArrayOfInt2);
/*      */     case 129:
/*  173 */       return jump81(paramArrayOfInt1, paramArrayOfInt, paramArrayOfInt2);
/*      */     case 130:
/*  174 */       return jump82(paramArrayOfInt1, paramArrayOfInt, paramArrayOfInt2);
/*      */     case 131:
/*  175 */       return jump83(paramArrayOfInt1, paramArrayOfInt, paramArrayOfInt2);
/*      */     case 132:
/*  176 */       return jump84(paramArrayOfInt1, paramArrayOfInt, paramArrayOfInt2);
/*      */     case 133:
/*  177 */       return jump85(paramArrayOfInt1, paramArrayOfInt, paramArrayOfInt2);
/*      */     case 134:
/*  178 */       return jump86(paramArrayOfInt1, paramArrayOfInt, paramArrayOfInt2);
/*      */     case 135:
/*  179 */       return jump87(paramArrayOfInt1, paramArrayOfInt, paramArrayOfInt2);
/*      */     case 136:
/*  180 */       return jump88(paramArrayOfInt1, paramArrayOfInt, paramArrayOfInt2);
/*      */     case 137:
/*  181 */       return jump89(paramArrayOfInt1, paramArrayOfInt, paramArrayOfInt2);
/*      */     case 138:
/*  182 */       return jump8A(paramArrayOfInt1, paramArrayOfInt, paramArrayOfInt2);
/*      */     case 139:
/*  183 */       return jump8B(paramArrayOfInt1, paramArrayOfInt, paramArrayOfInt2);
/*      */     case 140:
/*  184 */       return jump8C(paramArrayOfInt1, paramArrayOfInt, paramArrayOfInt2);
/*      */     case 141:
/*  185 */       return jump8D(paramArrayOfInt1, paramArrayOfInt, paramArrayOfInt2);
/*      */     case 142:
/*  186 */       return jump8E(paramArrayOfInt1, paramArrayOfInt, paramArrayOfInt2);
/*      */     case 143:
/*  187 */       return jump8F(paramArrayOfInt1, paramArrayOfInt, paramArrayOfInt2);
/*      */     case 144:
/*  188 */       return jump90(paramArrayOfInt1, paramArrayOfInt, paramArrayOfInt2);
/*      */     case 145:
/*  189 */       return jump91(paramArrayOfInt1, paramArrayOfInt, paramArrayOfInt2);
/*      */     case 146:
/*  190 */       return jump92(paramArrayOfInt1, paramArrayOfInt, paramArrayOfInt2);
/*      */     case 147:
/*  191 */       return jump93(paramArrayOfInt1, paramArrayOfInt, paramArrayOfInt2);
/*      */     case 148:
/*  192 */       return jump94(paramArrayOfInt1, paramArrayOfInt, paramArrayOfInt2);
/*      */     case 149:
/*  193 */       return jump95(paramArrayOfInt1, paramArrayOfInt, paramArrayOfInt2);
/*      */     case 150:
/*  194 */       return jump96(paramArrayOfInt1, paramArrayOfInt, paramArrayOfInt2);
/*      */     case 151:
/*  195 */       return jump97(paramArrayOfInt1, paramArrayOfInt, paramArrayOfInt2);
/*      */     case 152:
/*  196 */       return jump98(paramArrayOfInt1, paramArrayOfInt, paramArrayOfInt2);
/*      */     case 153:
/*  197 */       return jump99(paramArrayOfInt1, paramArrayOfInt, paramArrayOfInt2);
/*      */     case 154:
/*  198 */       return jump9A(paramArrayOfInt1, paramArrayOfInt, paramArrayOfInt2);
/*      */     case 155:
/*  199 */       return jumpNU(paramArrayOfInt1, paramArrayOfInt, paramArrayOfInt2);
/*      */     case 156:
/*  200 */       return jump9C(paramArrayOfInt1, paramArrayOfInt, paramArrayOfInt2);
/*      */     case 157:
/*  201 */       return jump9D(paramArrayOfInt1, paramArrayOfInt, paramArrayOfInt2);
/*      */     case 158:
/*  202 */       return jump9E(paramArrayOfInt1, paramArrayOfInt, paramArrayOfInt2);
/*      */     case 159:
/*  203 */       return jump9F(paramArrayOfInt1, paramArrayOfInt, paramArrayOfInt2);
/*      */     case 160:
/*  204 */       return jumpA0(paramArrayOfInt1, paramArrayOfInt, paramArrayOfInt2);
/*      */     case 161:
/*  205 */       return jumpA1(paramArrayOfInt1, paramArrayOfInt, paramArrayOfInt2);
/*      */     case 162:
/*  206 */       return jumpA2(paramArrayOfInt1, paramArrayOfInt, paramArrayOfInt2);
/*      */     case 163:
/*  207 */       return jumpA3(paramArrayOfInt1, paramArrayOfInt, paramArrayOfInt2);
/*      */     case 164:
/*  208 */       return jumpA4(paramArrayOfInt1, paramArrayOfInt, paramArrayOfInt2);
/*      */     case 165:
/*  209 */       return jumpA5(paramArrayOfInt1, paramArrayOfInt, paramArrayOfInt2);
/*      */     case 166:
/*  210 */       return jumpA6(paramArrayOfInt1, paramArrayOfInt, paramArrayOfInt2);
/*      */     case 167:
/*  211 */       return jumpA7(paramArrayOfInt1, paramArrayOfInt, paramArrayOfInt2);
/*      */     case 168:
/*  212 */       return jumpA8(paramArrayOfInt1, paramArrayOfInt, paramArrayOfInt2);
/*      */     case 169:
/*  213 */       return jumpA9(paramArrayOfInt1, paramArrayOfInt, paramArrayOfInt2);
/*      */     case 170:
/*  214 */       return jumpAA(paramArrayOfInt1, paramArrayOfInt, paramArrayOfInt2);
/*      */     case 171:
/*  215 */       return jumpAB(paramArrayOfInt1, paramArrayOfInt, paramArrayOfInt2);
/*      */     case 172:
/*  216 */       return jumpAC(paramArrayOfInt1, paramArrayOfInt, paramArrayOfInt2);
/*      */     case 173:
/*  217 */       return jumpAD(paramArrayOfInt1, paramArrayOfInt, paramArrayOfInt2);
/*      */     case 174:
/*  218 */       return jumpAE(paramArrayOfInt1, paramArrayOfInt, paramArrayOfInt2);
/*      */     case 175:
/*  219 */       return jumpAF(paramArrayOfInt1, paramArrayOfInt, paramArrayOfInt2);
/*      */     case 176:
/*  220 */       return jumpB0(paramArrayOfInt1, paramArrayOfInt, paramArrayOfInt2);
/*      */     case 177:
/*  221 */       return jumpB1(paramArrayOfInt1, paramArrayOfInt, paramArrayOfInt2);
/*      */     case 178:
/*  222 */       return jumpB2(paramArrayOfInt1, paramArrayOfInt, paramArrayOfInt2);
/*      */     case 179:
/*  223 */       return jumpB3(paramArrayOfInt1, paramArrayOfInt, paramArrayOfInt2);
/*      */     case 180:
/*  224 */       return jumpB4(paramArrayOfInt1, paramArrayOfInt, paramArrayOfInt2);
/*      */     case 181:
/*  225 */       return jumpB5(paramArrayOfInt1, paramArrayOfInt, paramArrayOfInt2);
/*      */     case 182:
/*  226 */       return jumpB6(paramArrayOfInt1, paramArrayOfInt, paramArrayOfInt2);
/*      */     case 183:
/*  227 */       return jumpB7(paramArrayOfInt1, paramArrayOfInt, paramArrayOfInt2);
/*      */     case 184:
/*  228 */       return jumpB8(paramArrayOfInt1, paramArrayOfInt, paramArrayOfInt2);
/*      */     case 185:
/*  229 */       return jumpB9(paramArrayOfInt1, paramArrayOfInt, paramArrayOfInt2);
/*      */     case 186:
/*  230 */       return jumpBA(paramArrayOfInt1, paramArrayOfInt, paramArrayOfInt2);
/*      */     case 187:
/*  231 */       return jumpBB(paramArrayOfInt1, paramArrayOfInt, paramArrayOfInt2);
/*      */     case 188:
/*  232 */       return jumpBC(paramArrayOfInt1, paramArrayOfInt, paramArrayOfInt2);
/*      */     case 189:
/*  233 */       return jumpBD(paramArrayOfInt1, paramArrayOfInt, paramArrayOfInt2);
/*      */     case 190:
/*  234 */       return jumpBE(paramArrayOfInt1, paramArrayOfInt, paramArrayOfInt2);
/*      */     case 191:
/*  235 */       return jumpBF(paramArrayOfInt1, paramArrayOfInt, paramArrayOfInt2);
/*      */     case 192:
/*  236 */       return jumpNU(paramArrayOfInt1, paramArrayOfInt, paramArrayOfInt2);
/*      */     case 193:
/*  237 */       return jumpNU(paramArrayOfInt1, paramArrayOfInt, paramArrayOfInt2);
/*      */     case 194:
/*  238 */       return jumpC2(paramArrayOfInt1, paramArrayOfInt, paramArrayOfInt2);
/*      */     case 195:
/*  239 */       return jumpC3(paramArrayOfInt1, paramArrayOfInt, paramArrayOfInt2);
/*      */     case 196:
/*  240 */       return jumpC4(paramArrayOfInt1, paramArrayOfInt, paramArrayOfInt2);
/*      */     case 197:
/*  241 */       return jumpC5(paramArrayOfInt1, paramArrayOfInt, paramArrayOfInt2);
/*      */     case 198:
/*  242 */       return jumpC6(paramArrayOfInt1, paramArrayOfInt, paramArrayOfInt2);
/*      */     case 199:
/*  243 */       return jumpC7(paramArrayOfInt1, paramArrayOfInt, paramArrayOfInt2);
/*      */     case 200:
/*  244 */       return jumpNU(paramArrayOfInt1, paramArrayOfInt, paramArrayOfInt2);
/*      */     case 201:
/*  245 */       return jumpNU(paramArrayOfInt1, paramArrayOfInt, paramArrayOfInt2);
/*      */     case 202:
/*  246 */       return jumpCA(paramArrayOfInt1, paramArrayOfInt, paramArrayOfInt2);
/*      */     case 203:
/*  247 */       return jumpCB(paramArrayOfInt1, paramArrayOfInt, paramArrayOfInt2);
/*      */     case 204:
/*  248 */       return jumpCC(paramArrayOfInt1, paramArrayOfInt, paramArrayOfInt2);
/*      */     case 205:
/*  249 */       return jumpCD(paramArrayOfInt1, paramArrayOfInt, paramArrayOfInt2);
/*      */     case 206:
/*  250 */       return jumpCE(paramArrayOfInt1, paramArrayOfInt, paramArrayOfInt2);
/*      */     case 207:
/*  251 */       return jumpCF(paramArrayOfInt1, paramArrayOfInt, paramArrayOfInt2);
/*      */     case 208:
/*  252 */       return jumpD0(paramArrayOfInt1, paramArrayOfInt, paramArrayOfInt2);
/*      */     case 209:
/*  253 */       return jumpD1(paramArrayOfInt1, paramArrayOfInt, paramArrayOfInt2);
/*      */     case 210:
/*  254 */       return jumpD2(paramArrayOfInt1, paramArrayOfInt, paramArrayOfInt2);
/*      */     case 211:
/*  255 */       return jumpD3(paramArrayOfInt1, paramArrayOfInt, paramArrayOfInt2);
/*      */     case 212:
/*  256 */       return jumpD4(paramArrayOfInt1, paramArrayOfInt, paramArrayOfInt2);
/*      */     case 213:
/*  257 */       return jumpD5(paramArrayOfInt1, paramArrayOfInt, paramArrayOfInt2);
/*      */     case 214:
/*  258 */       return jumpNU(paramArrayOfInt1, paramArrayOfInt, paramArrayOfInt2);
/*      */     case 215:
/*  259 */       return jumpD7(paramArrayOfInt1, paramArrayOfInt, paramArrayOfInt2);
/*      */     case 216:
/*  260 */       return jumpNU(paramArrayOfInt1, paramArrayOfInt, paramArrayOfInt2);
/*      */     case 217:
/*  261 */       return jumpNU(paramArrayOfInt1, paramArrayOfInt, paramArrayOfInt2);
/*      */     case 218:
/*  262 */       return jumpNU(paramArrayOfInt1, paramArrayOfInt, paramArrayOfInt2);
/*      */     case 219:
/*  263 */       return jumpNU(paramArrayOfInt1, paramArrayOfInt, paramArrayOfInt2);
/*      */     case 220:
/*  264 */       return jumpNU(paramArrayOfInt1, paramArrayOfInt, paramArrayOfInt2);
/*      */     case 221:
/*  265 */       return jumpNU(paramArrayOfInt1, paramArrayOfInt, paramArrayOfInt2);
/*      */     case 222:
/*  266 */       return jumpNU(paramArrayOfInt1, paramArrayOfInt, paramArrayOfInt2);
/*      */     case 223:
/*  267 */       return jumpNU(paramArrayOfInt1, paramArrayOfInt, paramArrayOfInt2);
/*      */     case 224:
/*  268 */       return jumpE0(paramArrayOfInt1, paramArrayOfInt, paramArrayOfInt2);
/*      */     case 225:
/*  269 */       return jumpE1(paramArrayOfInt1, paramArrayOfInt, paramArrayOfInt2);
/*      */     case 226:
/*  270 */       return jumpE2(paramArrayOfInt1, paramArrayOfInt, paramArrayOfInt2);
/*      */     case 227:
/*  271 */       return jumpE3(paramArrayOfInt1, paramArrayOfInt, paramArrayOfInt2);
/*      */     case 228:
/*  272 */       return jumpE4(paramArrayOfInt1, paramArrayOfInt, paramArrayOfInt2);
/*      */     case 229:
/*  273 */       return jumpE5(paramArrayOfInt1, paramArrayOfInt, paramArrayOfInt2);
/*      */     case 230:
/*  274 */       return jumpE6(paramArrayOfInt1, paramArrayOfInt, paramArrayOfInt2);
/*      */     case 231:
/*  275 */       return jumpE7(paramArrayOfInt1, paramArrayOfInt, paramArrayOfInt2);
/*      */     case 232:
/*  276 */       return jumpE8(paramArrayOfInt1, paramArrayOfInt, paramArrayOfInt2);
/*      */     case 233:
/*  277 */       return jumpE9(paramArrayOfInt1, paramArrayOfInt, paramArrayOfInt2);
/*      */     case 234:
/*  278 */       return jumpEA(paramArrayOfInt1, paramArrayOfInt, paramArrayOfInt2);
/*      */     case 235:
/*  279 */       return jumpEB(paramArrayOfInt1, paramArrayOfInt, paramArrayOfInt2);
/*      */     case 236:
/*  280 */       return jumpEC(paramArrayOfInt1, paramArrayOfInt, paramArrayOfInt2);
/*      */     case 237:
/*  281 */       return jumpED(paramArrayOfInt1, paramArrayOfInt, paramArrayOfInt2);
/*      */     case 238:
/*  282 */       return jumpEE(paramArrayOfInt1, paramArrayOfInt, paramArrayOfInt2);
/*      */     case 239:
/*  283 */       return jumpEF(paramArrayOfInt1, paramArrayOfInt, paramArrayOfInt2);
/*      */     case 240:
/*  284 */       return jumpNU(paramArrayOfInt1, paramArrayOfInt, paramArrayOfInt2);
/*      */     case 241:
/*  285 */       return jumpNU(paramArrayOfInt1, paramArrayOfInt, paramArrayOfInt2);
/*      */     case 242:
/*  286 */       return jumpF2(paramArrayOfInt1, paramArrayOfInt, paramArrayOfInt2);
/*      */     case 243:
/*  287 */       return jumpF3(paramArrayOfInt1, paramArrayOfInt, paramArrayOfInt2);
/*      */     case 244:
/*  288 */       return jumpF4(paramArrayOfInt1, paramArrayOfInt, paramArrayOfInt2);
/*      */     case 245:
/*  289 */       return jumpF5(paramArrayOfInt1, paramArrayOfInt, paramArrayOfInt2);
/*      */     case 246:
/*  290 */       return jumpF6(paramArrayOfInt1, paramArrayOfInt, paramArrayOfInt2);
/*      */     case 247:
/*  291 */       return jumpF7(paramArrayOfInt1, paramArrayOfInt, paramArrayOfInt2);
/*      */     case 248:
/*  292 */       return jumpF8(paramArrayOfInt1, paramArrayOfInt, paramArrayOfInt2);
/*      */     case 249:
/*  293 */       return jumpF9(paramArrayOfInt1, paramArrayOfInt, paramArrayOfInt2);
/*      */     case 250:
/*  294 */       return jumpFA(paramArrayOfInt1, paramArrayOfInt, paramArrayOfInt2);
/*      */     case 251:
/*  295 */       return jumpFB(paramArrayOfInt1, paramArrayOfInt, paramArrayOfInt2);
/*      */     case 252:
/*  296 */       return jumpFC(paramArrayOfInt1, paramArrayOfInt, paramArrayOfInt2);
/*      */     case 253:
/*  297 */       return jumpFD(paramArrayOfInt1, paramArrayOfInt, paramArrayOfInt2);
/*      */     case 254:
/*  298 */       return jumpFE(paramArrayOfInt1, paramArrayOfInt, paramArrayOfInt2);
/*      */     case 255:
/*  299 */       return jumpFF(paramArrayOfInt1, paramArrayOfInt, paramArrayOfInt2);
/*      */     }
/*      */ 
/*  302 */     return jumpNU(paramArrayOfInt1, paramArrayOfInt, paramArrayOfInt2);
/*      */   }
/*      */ 
/*      */   public StopPoint jump00(int[] paramArrayOfInt1, int[][] paramArrayOfInt, int[] paramArrayOfInt2)
/*      */   {
/*  319 */     paramArrayOfInt2[0] = 1;
/*  320 */     paramArrayOfInt2[1] = 1;
/*  321 */     paramArrayOfInt2[2] = 0;
/*      */ 
/*  324 */     this.stopPoint = this.machine.addressModeDecoder.decode(paramArrayOfInt1, paramArrayOfInt, paramArrayOfInt2);
/*      */ 
/*  326 */     if (this.stopPoint != null) return this.stopPoint;
/*      */ 
/*  334 */     paramArrayOfInt[2][0] += 1;
/*      */ 
/*  344 */     return this.machine.instructionSet.ADD8(paramArrayOfInt[0], paramArrayOfInt[1]);
/*      */   }
/*      */ 
/*      */   public StopPoint jump01(int[] paramArrayOfInt1, int[][] paramArrayOfInt, int[] paramArrayOfInt2)
/*      */   {
/*  362 */     paramArrayOfInt2[0] = 1;
/*  363 */     paramArrayOfInt2[1] = 2;
/*  364 */     paramArrayOfInt2[2] = 0;
/*      */ 
/*  367 */     this.stopPoint = this.machine.addressModeDecoder.decode(paramArrayOfInt1, paramArrayOfInt, paramArrayOfInt2);
/*      */ 
/*  369 */     if (this.stopPoint != null) return this.stopPoint;
/*      */ 
/*  378 */     paramArrayOfInt[2][0] += 1;
/*      */ 
/*  388 */     return this.machine.instructionSet.ADD16(paramArrayOfInt[0], paramArrayOfInt[1]);
/*      */   }
/*      */ 
/*      */   public StopPoint jump02(int[] paramArrayOfInt1, int[][] paramArrayOfInt, int[] paramArrayOfInt2)
/*      */   {
/*  406 */     paramArrayOfInt2[0] = 1;
/*  407 */     paramArrayOfInt2[1] = 1;
/*  408 */     paramArrayOfInt2[2] = 1;
/*      */ 
/*  411 */     this.stopPoint = this.machine.addressModeDecoder.decode(paramArrayOfInt1, paramArrayOfInt, paramArrayOfInt2);
/*      */ 
/*  413 */     if (this.stopPoint != null) return this.stopPoint;
/*      */ 
/*  421 */     paramArrayOfInt[2][0] += 1;
/*      */ 
/*  431 */     return this.machine.instructionSet.ADD8(paramArrayOfInt[0], paramArrayOfInt[1]);
/*      */   }
/*      */ 
/*      */   public StopPoint jump03(int[] paramArrayOfInt1, int[][] paramArrayOfInt, int[] paramArrayOfInt2)
/*      */   {
/*  449 */     paramArrayOfInt2[0] = 1;
/*  450 */     paramArrayOfInt2[1] = 2;
/*  451 */     paramArrayOfInt2[2] = 1;
/*      */ 
/*  454 */     this.stopPoint = this.machine.addressModeDecoder.decode(paramArrayOfInt1, paramArrayOfInt, paramArrayOfInt2);
/*      */ 
/*  456 */     if (this.stopPoint != null) return this.stopPoint;
/*      */ 
/*  464 */     paramArrayOfInt[2][0] += 1;
/*      */ 
/*  474 */     return this.machine.instructionSet.ADD16(paramArrayOfInt[0], paramArrayOfInt[1]);
/*      */   }
/*      */ 
/*      */   public StopPoint jump04(int[] paramArrayOfInt1, int[][] paramArrayOfInt, int[] paramArrayOfInt2)
/*      */   {
/*  492 */     paramArrayOfInt[2][0] += 1;
/*      */ 
/*  498 */     paramArrayOfInt[0][2] = 20;
/*  499 */     paramArrayOfInt[0][3] = 1;
/*  500 */     paramArrayOfInt[1][3] = 3;
/*  501 */     paramArrayOfInt[1][0] = paramArrayOfInt1[1];
/*      */ 
/*  511 */     return this.machine.instructionSet.ADD8(paramArrayOfInt[0], paramArrayOfInt[1]);
/*      */   }
/*      */ 
/*      */   public StopPoint jump05(int[] paramArrayOfInt1, int[][] paramArrayOfInt, int[] paramArrayOfInt2)
/*      */   {
/*  529 */     paramArrayOfInt[2][0] += 2;
/*      */ 
/*  535 */     paramArrayOfInt[0][2] = 0;
/*  536 */     paramArrayOfInt[0][3] = 1;
/*  537 */     paramArrayOfInt[1][3] = 3;
/*  538 */     paramArrayOfInt[1][0] = 
/*  539 */       ((paramArrayOfInt1[2] << 8) + paramArrayOfInt1[1]);
/*      */ 
/*  549 */     return this.machine.instructionSet.ADD16(paramArrayOfInt[0], paramArrayOfInt[1]);
/*      */   }
/*      */ 
/*      */   public StopPoint jump06(int[] paramArrayOfInt1, int[][] paramArrayOfInt, int[] paramArrayOfInt2)
/*      */   {
/*  573 */     paramArrayOfInt[1][2] = 7;
/*  574 */     paramArrayOfInt[1][3] = 1;
/*      */ 
/*  585 */     return this.machine.instructionSet.PUSH(paramArrayOfInt[1]);
/*      */   }
/*      */ 
/*      */   public StopPoint jump07(int[] paramArrayOfInt1, int[][] paramArrayOfInt, int[] paramArrayOfInt2)
/*      */   {
/*  609 */     paramArrayOfInt[0][2] = 7;
/*  610 */     paramArrayOfInt[0][3] = 1;
/*      */ 
/*  621 */     return this.machine.instructionSet.POP(paramArrayOfInt[0]);
/*      */   }
/*      */ 
/*      */   public StopPoint jump08(int[] paramArrayOfInt1, int[][] paramArrayOfInt, int[] paramArrayOfInt2)
/*      */   {
/*  639 */     paramArrayOfInt2[0] = 1;
/*  640 */     paramArrayOfInt2[1] = 1;
/*  641 */     paramArrayOfInt2[2] = 0;
/*      */ 
/*  644 */     this.stopPoint = this.machine.addressModeDecoder.decode(paramArrayOfInt1, paramArrayOfInt, paramArrayOfInt2);
/*      */ 
/*  646 */     if (this.stopPoint != null) return this.stopPoint;
/*      */ 
/*  654 */     paramArrayOfInt[2][0] += 1;
/*      */ 
/*  664 */     return this.machine.instructionSet.OR8(paramArrayOfInt[0], paramArrayOfInt[1]);
/*      */   }
/*      */ 
/*      */   public StopPoint jump09(int[] paramArrayOfInt1, int[][] paramArrayOfInt, int[] paramArrayOfInt2)
/*      */   {
/*  682 */     paramArrayOfInt2[0] = 1;
/*  683 */     paramArrayOfInt2[1] = 2;
/*  684 */     paramArrayOfInt2[2] = 0;
/*      */ 
/*  687 */     this.stopPoint = this.machine.addressModeDecoder.decode(paramArrayOfInt1, paramArrayOfInt, paramArrayOfInt2);
/*      */ 
/*  689 */     if (this.stopPoint != null) return this.stopPoint;
/*      */ 
/*  698 */     paramArrayOfInt[2][0] += 1;
/*      */ 
/*  708 */     return this.machine.instructionSet.OR16(paramArrayOfInt[0], paramArrayOfInt[1]);
/*      */   }
/*      */ 
/*      */   public StopPoint jump0A(int[] paramArrayOfInt1, int[][] paramArrayOfInt, int[] paramArrayOfInt2)
/*      */   {
/*  726 */     paramArrayOfInt2[0] = 1;
/*  727 */     paramArrayOfInt2[1] = 1;
/*  728 */     paramArrayOfInt2[2] = 1;
/*      */ 
/*  731 */     this.stopPoint = this.machine.addressModeDecoder.decode(paramArrayOfInt1, paramArrayOfInt, paramArrayOfInt2);
/*      */ 
/*  733 */     if (this.stopPoint != null) return this.stopPoint;
/*      */ 
/*  741 */     paramArrayOfInt[2][0] += 1;
/*      */ 
/*  751 */     return this.machine.instructionSet.OR8(paramArrayOfInt[0], paramArrayOfInt[1]);
/*      */   }
/*      */ 
/*      */   public StopPoint jump0B(int[] paramArrayOfInt1, int[][] paramArrayOfInt, int[] paramArrayOfInt2)
/*      */   {
/*  769 */     paramArrayOfInt2[0] = 1;
/*  770 */     paramArrayOfInt2[1] = 2;
/*  771 */     paramArrayOfInt2[2] = 1;
/*      */ 
/*  774 */     this.stopPoint = this.machine.addressModeDecoder.decode(paramArrayOfInt1, paramArrayOfInt, paramArrayOfInt2);
/*      */ 
/*  776 */     if (this.stopPoint != null) return this.stopPoint;
/*      */ 
/*  784 */     paramArrayOfInt[2][0] += 1;
/*      */ 
/*  794 */     return this.machine.instructionSet.OR16(paramArrayOfInt[0], paramArrayOfInt[1]);
/*      */   }
/*      */ 
/*      */   public StopPoint jump0C(int[] paramArrayOfInt1, int[][] paramArrayOfInt, int[] paramArrayOfInt2)
/*      */   {
/*  812 */     paramArrayOfInt[2][0] += 1;
/*      */ 
/*  818 */     paramArrayOfInt[0][2] = 20;
/*  819 */     paramArrayOfInt[0][3] = 1;
/*  820 */     paramArrayOfInt[1][3] = 3;
/*  821 */     paramArrayOfInt[1][0] = paramArrayOfInt1[1];
/*      */ 
/*  831 */     return this.machine.instructionSet.OR8(paramArrayOfInt[0], paramArrayOfInt[1]);
/*      */   }
/*      */ 
/*      */   public StopPoint jump0D(int[] paramArrayOfInt1, int[][] paramArrayOfInt, int[] paramArrayOfInt2)
/*      */   {
/*  849 */     paramArrayOfInt[2][0] += 2;
/*      */ 
/*  855 */     paramArrayOfInt[0][2] = 0;
/*  856 */     paramArrayOfInt[0][3] = 1;
/*  857 */     paramArrayOfInt[1][3] = 3;
/*  858 */     paramArrayOfInt[1][0] = 
/*  859 */       ((paramArrayOfInt1[2] << 8) + paramArrayOfInt1[1]);
/*      */ 
/*  869 */     return this.machine.instructionSet.OR16(paramArrayOfInt[0], paramArrayOfInt[1]);
/*      */   }
/*      */ 
/*      */   public StopPoint jump0E(int[] paramArrayOfInt1, int[][] paramArrayOfInt, int[] paramArrayOfInt2)
/*      */   {
/*  893 */     paramArrayOfInt[1][2] = 4;
/*  894 */     paramArrayOfInt[1][3] = 1;
/*      */ 
/*  905 */     return this.machine.instructionSet.PUSH(paramArrayOfInt[1]);
/*      */   }
/*      */ 
/*      */   public StopPoint jump10(int[] paramArrayOfInt1, int[][] paramArrayOfInt, int[] paramArrayOfInt2)
/*      */   {
/*  923 */     paramArrayOfInt2[0] = 1;
/*  924 */     paramArrayOfInt2[1] = 1;
/*  925 */     paramArrayOfInt2[2] = 0;
/*      */ 
/*  928 */     this.stopPoint = this.machine.addressModeDecoder.decode(paramArrayOfInt1, paramArrayOfInt, paramArrayOfInt2);
/*      */ 
/*  930 */     if (this.stopPoint != null) return this.stopPoint;
/*      */ 
/*  938 */     paramArrayOfInt[2][0] += 1;
/*      */ 
/*  948 */     return this.machine.instructionSet.ADC8(paramArrayOfInt[0], paramArrayOfInt[1]);
/*      */   }
/*      */ 
/*      */   public StopPoint jump11(int[] paramArrayOfInt1, int[][] paramArrayOfInt, int[] paramArrayOfInt2)
/*      */   {
/*  966 */     paramArrayOfInt2[0] = 1;
/*  967 */     paramArrayOfInt2[1] = 2;
/*  968 */     paramArrayOfInt2[2] = 0;
/*      */ 
/*  971 */     this.stopPoint = this.machine.addressModeDecoder.decode(paramArrayOfInt1, paramArrayOfInt, paramArrayOfInt2);
/*      */ 
/*  973 */     if (this.stopPoint != null) return this.stopPoint;
/*      */ 
/*  982 */     paramArrayOfInt[2][0] += 1;
/*      */ 
/*  992 */     return this.machine.instructionSet.ADC16(paramArrayOfInt[0], paramArrayOfInt[1]);
/*      */   }
/*      */ 
/*      */   public StopPoint jump12(int[] paramArrayOfInt1, int[][] paramArrayOfInt, int[] paramArrayOfInt2)
/*      */   {
/* 1010 */     paramArrayOfInt2[0] = 1;
/* 1011 */     paramArrayOfInt2[1] = 1;
/* 1012 */     paramArrayOfInt2[2] = 1;
/*      */ 
/* 1015 */     this.stopPoint = this.machine.addressModeDecoder.decode(paramArrayOfInt1, paramArrayOfInt, paramArrayOfInt2);
/*      */ 
/* 1017 */     if (this.stopPoint != null) return this.stopPoint;
/*      */ 
/* 1025 */     paramArrayOfInt[2][0] += 1;
/*      */ 
/* 1035 */     return this.machine.instructionSet.ADC8(paramArrayOfInt[0], paramArrayOfInt[1]);
/*      */   }
/*      */ 
/*      */   public StopPoint jump13(int[] paramArrayOfInt1, int[][] paramArrayOfInt, int[] paramArrayOfInt2)
/*      */   {
/* 1053 */     paramArrayOfInt2[0] = 1;
/* 1054 */     paramArrayOfInt2[1] = 2;
/* 1055 */     paramArrayOfInt2[2] = 1;
/*      */ 
/* 1058 */     this.stopPoint = this.machine.addressModeDecoder.decode(paramArrayOfInt1, paramArrayOfInt, paramArrayOfInt2);
/*      */ 
/* 1060 */     if (this.stopPoint != null) return this.stopPoint;
/*      */ 
/* 1068 */     paramArrayOfInt[2][0] += 1;
/*      */ 
/* 1078 */     return this.machine.instructionSet.ADC16(paramArrayOfInt[0], paramArrayOfInt[1]);
/*      */   }
/*      */ 
/*      */   public StopPoint jump14(int[] paramArrayOfInt1, int[][] paramArrayOfInt, int[] paramArrayOfInt2)
/*      */   {
/* 1096 */     paramArrayOfInt[2][0] += 1;
/*      */ 
/* 1102 */     paramArrayOfInt[0][2] = 20;
/* 1103 */     paramArrayOfInt[0][3] = 1;
/* 1104 */     paramArrayOfInt[1][3] = 3;
/* 1105 */     paramArrayOfInt[1][0] = paramArrayOfInt1[1];
/*      */ 
/* 1115 */     return this.machine.instructionSet.ADC8(paramArrayOfInt[0], paramArrayOfInt[1]);
/*      */   }
/*      */ 
/*      */   public StopPoint jump15(int[] paramArrayOfInt1, int[][] paramArrayOfInt, int[] paramArrayOfInt2)
/*      */   {
/* 1133 */     paramArrayOfInt[2][0] += 2;
/*      */ 
/* 1139 */     paramArrayOfInt[0][2] = 0;
/* 1140 */     paramArrayOfInt[0][3] = 1;
/* 1141 */     paramArrayOfInt[1][3] = 3;
/* 1142 */     paramArrayOfInt[1][0] = 
/* 1143 */       ((paramArrayOfInt1[2] << 8) + paramArrayOfInt1[1]);
/*      */ 
/* 1153 */     return this.machine.instructionSet.ADC16(paramArrayOfInt[0], paramArrayOfInt[1]);
/*      */   }
/*      */ 
/*      */   public StopPoint jump16(int[] paramArrayOfInt1, int[][] paramArrayOfInt, int[] paramArrayOfInt2)
/*      */   {
/* 1177 */     paramArrayOfInt[1][2] = 6;
/* 1178 */     paramArrayOfInt[1][3] = 1;
/*      */ 
/* 1189 */     return this.machine.instructionSet.PUSH(paramArrayOfInt[1]);
/*      */   }
/*      */ 
/*      */   public StopPoint jump17(int[] paramArrayOfInt1, int[][] paramArrayOfInt, int[] paramArrayOfInt2)
/*      */   {
/* 1213 */     paramArrayOfInt[0][2] = 6;
/* 1214 */     paramArrayOfInt[0][3] = 1;
/*      */ 
/* 1225 */     return this.machine.instructionSet.POP(paramArrayOfInt[0]);
/*      */   }
/*      */ 
/*      */   public StopPoint jump18(int[] paramArrayOfInt1, int[][] paramArrayOfInt, int[] paramArrayOfInt2)
/*      */   {
/* 1243 */     paramArrayOfInt2[0] = 1;
/* 1244 */     paramArrayOfInt2[1] = 1;
/* 1245 */     paramArrayOfInt2[2] = 0;
/*      */ 
/* 1248 */     this.stopPoint = this.machine.addressModeDecoder.decode(paramArrayOfInt1, paramArrayOfInt, paramArrayOfInt2);
/*      */ 
/* 1250 */     if (this.stopPoint != null) return this.stopPoint;
/*      */ 
/* 1258 */     paramArrayOfInt[2][0] += 1;
/*      */ 
/* 1268 */     return this.machine.instructionSet.SBB8(paramArrayOfInt[0], paramArrayOfInt[1]);
/*      */   }
/*      */ 
/*      */   public StopPoint jump19(int[] paramArrayOfInt1, int[][] paramArrayOfInt, int[] paramArrayOfInt2)
/*      */   {
/* 1286 */     paramArrayOfInt2[0] = 1;
/* 1287 */     paramArrayOfInt2[1] = 2;
/* 1288 */     paramArrayOfInt2[2] = 0;
/*      */ 
/* 1291 */     this.stopPoint = this.machine.addressModeDecoder.decode(paramArrayOfInt1, paramArrayOfInt, paramArrayOfInt2);
/*      */ 
/* 1293 */     if (this.stopPoint != null) return this.stopPoint;
/*      */ 
/* 1302 */     paramArrayOfInt[2][0] += 1;
/*      */ 
/* 1312 */     return this.machine.instructionSet.SBB16(paramArrayOfInt[0], paramArrayOfInt[1]);
/*      */   }
/*      */ 
/*      */   public StopPoint jump1A(int[] paramArrayOfInt1, int[][] paramArrayOfInt, int[] paramArrayOfInt2)
/*      */   {
/* 1330 */     paramArrayOfInt2[0] = 1;
/* 1331 */     paramArrayOfInt2[1] = 1;
/* 1332 */     paramArrayOfInt2[2] = 1;
/*      */ 
/* 1335 */     this.stopPoint = this.machine.addressModeDecoder.decode(paramArrayOfInt1, paramArrayOfInt, paramArrayOfInt2);
/*      */ 
/* 1337 */     if (this.stopPoint != null) return this.stopPoint;
/*      */ 
/* 1345 */     paramArrayOfInt[2][0] += 1;
/*      */ 
/* 1355 */     return this.machine.instructionSet.SBB8(paramArrayOfInt[0], paramArrayOfInt[1]);
/*      */   }
/*      */ 
/*      */   public StopPoint jump1B(int[] paramArrayOfInt1, int[][] paramArrayOfInt, int[] paramArrayOfInt2)
/*      */   {
/* 1373 */     paramArrayOfInt2[0] = 1;
/* 1374 */     paramArrayOfInt2[1] = 2;
/* 1375 */     paramArrayOfInt2[2] = 1;
/*      */ 
/* 1378 */     this.stopPoint = this.machine.addressModeDecoder.decode(paramArrayOfInt1, paramArrayOfInt, paramArrayOfInt2);
/*      */ 
/* 1380 */     if (this.stopPoint != null) return this.stopPoint;
/*      */ 
/* 1388 */     paramArrayOfInt[2][0] += 1;
/*      */ 
/* 1398 */     return this.machine.instructionSet.SBB16(paramArrayOfInt[0], paramArrayOfInt[1]);
/*      */   }
/*      */ 
/*      */   public StopPoint jump1C(int[] paramArrayOfInt1, int[][] paramArrayOfInt, int[] paramArrayOfInt2)
/*      */   {
/* 1416 */     paramArrayOfInt[2][0] += 1;
/*      */ 
/* 1422 */     paramArrayOfInt[0][2] = 20;
/* 1423 */     paramArrayOfInt[0][3] = 1;
/* 1424 */     paramArrayOfInt[1][3] = 3;
/* 1425 */     paramArrayOfInt[1][0] = paramArrayOfInt1[1];
/*      */ 
/* 1435 */     return this.machine.instructionSet.SBB8(paramArrayOfInt[0], paramArrayOfInt[1]);
/*      */   }
/*      */ 
/*      */   public StopPoint jump1D(int[] paramArrayOfInt1, int[][] paramArrayOfInt, int[] paramArrayOfInt2)
/*      */   {
/* 1453 */     paramArrayOfInt[2][0] += 2;
/*      */ 
/* 1459 */     paramArrayOfInt[0][2] = 0;
/* 1460 */     paramArrayOfInt[0][3] = 1;
/* 1461 */     paramArrayOfInt[1][3] = 3;
/* 1462 */     paramArrayOfInt[1][0] = 
/* 1463 */       ((paramArrayOfInt1[2] << 8) + paramArrayOfInt1[1]);
/*      */ 
/* 1473 */     return this.machine.instructionSet.SBB16(paramArrayOfInt[0], paramArrayOfInt[1]);
/*      */   }
/*      */ 
/*      */   public StopPoint jump1E(int[] paramArrayOfInt1, int[][] paramArrayOfInt, int[] paramArrayOfInt2)
/*      */   {
/* 1497 */     paramArrayOfInt[1][2] = 5;
/* 1498 */     paramArrayOfInt[1][3] = 1;
/*      */ 
/* 1509 */     return this.machine.instructionSet.PUSH(paramArrayOfInt[1]);
/*      */   }
/*      */ 
/*      */   public StopPoint jump1F(int[] paramArrayOfInt1, int[][] paramArrayOfInt, int[] paramArrayOfInt2)
/*      */   {
/* 1533 */     paramArrayOfInt[0][2] = 5;
/* 1534 */     paramArrayOfInt[0][3] = 1;
/*      */ 
/* 1545 */     return this.machine.instructionSet.POP(paramArrayOfInt[0]);
/*      */   }
/*      */ 
/*      */   public StopPoint jump20(int[] paramArrayOfInt1, int[][] paramArrayOfInt, int[] paramArrayOfInt2)
/*      */   {
/* 1563 */     paramArrayOfInt2[0] = 1;
/* 1564 */     paramArrayOfInt2[1] = 1;
/* 1565 */     paramArrayOfInt2[2] = 0;
/*      */ 
/* 1568 */     this.stopPoint = this.machine.addressModeDecoder.decode(paramArrayOfInt1, paramArrayOfInt, paramArrayOfInt2);
/*      */ 
/* 1570 */     if (this.stopPoint != null) return this.stopPoint;
/*      */ 
/* 1579 */     paramArrayOfInt[2][0] += 1;
/*      */ 
/* 1589 */     return this.machine.instructionSet.AND8(paramArrayOfInt[0], paramArrayOfInt[1]);
/*      */   }
/*      */ 
/*      */   public StopPoint jump21(int[] paramArrayOfInt1, int[][] paramArrayOfInt, int[] paramArrayOfInt2)
/*      */   {
/* 1607 */     paramArrayOfInt2[0] = 1;
/* 1608 */     paramArrayOfInt2[1] = 2;
/* 1609 */     paramArrayOfInt2[2] = 0;
/*      */ 
/* 1612 */     this.stopPoint = this.machine.addressModeDecoder.decode(paramArrayOfInt1, paramArrayOfInt, paramArrayOfInt2);
/*      */ 
/* 1614 */     if (this.stopPoint != null) return this.stopPoint;
/*      */ 
/* 1622 */     paramArrayOfInt[2][0] += 1;
/*      */ 
/* 1632 */     return this.machine.instructionSet.AND16(paramArrayOfInt[0], paramArrayOfInt[1]);
/*      */   }
/*      */ 
/*      */   public StopPoint jump22(int[] paramArrayOfInt1, int[][] paramArrayOfInt, int[] paramArrayOfInt2)
/*      */   {
/* 1650 */     paramArrayOfInt2[0] = 1;
/* 1651 */     paramArrayOfInt2[1] = 1;
/* 1652 */     paramArrayOfInt2[2] = 1;
/*      */ 
/* 1655 */     this.stopPoint = this.machine.addressModeDecoder.decode(paramArrayOfInt1, paramArrayOfInt, paramArrayOfInt2);
/*      */ 
/* 1657 */     if (this.stopPoint != null) return this.stopPoint;
/*      */ 
/* 1665 */     paramArrayOfInt[2][0] += 1;
/*      */ 
/* 1675 */     return this.machine.instructionSet.AND8(paramArrayOfInt[0], paramArrayOfInt[1]);
/*      */   }
/*      */ 
/*      */   public StopPoint jump23(int[] paramArrayOfInt1, int[][] paramArrayOfInt, int[] paramArrayOfInt2)
/*      */   {
/* 1693 */     paramArrayOfInt2[0] = 1;
/* 1694 */     paramArrayOfInt2[1] = 2;
/* 1695 */     paramArrayOfInt2[2] = 1;
/*      */ 
/* 1698 */     this.stopPoint = this.machine.addressModeDecoder.decode(paramArrayOfInt1, paramArrayOfInt, paramArrayOfInt2);
/*      */ 
/* 1700 */     if (this.stopPoint != null) return this.stopPoint;
/*      */ 
/* 1708 */     paramArrayOfInt[2][0] += 1;
/*      */ 
/* 1718 */     return this.machine.instructionSet.AND16(paramArrayOfInt[0], paramArrayOfInt[1]);
/*      */   }
/*      */ 
/*      */   public StopPoint jump24(int[] paramArrayOfInt1, int[][] paramArrayOfInt, int[] paramArrayOfInt2)
/*      */   {
/* 1736 */     paramArrayOfInt[2][0] += 1;
/*      */ 
/* 1742 */     paramArrayOfInt[0][2] = 20;
/* 1743 */     paramArrayOfInt[0][3] = 1;
/* 1744 */     paramArrayOfInt[1][3] = 3;
/* 1745 */     paramArrayOfInt[1][0] = paramArrayOfInt1[1];
/*      */ 
/* 1755 */     return this.machine.instructionSet.AND8(paramArrayOfInt[0], paramArrayOfInt[1]);
/*      */   }
/*      */ 
/*      */   public StopPoint jump25(int[] paramArrayOfInt1, int[][] paramArrayOfInt, int[] paramArrayOfInt2)
/*      */   {
/* 1773 */     paramArrayOfInt[2][0] += 2;
/*      */ 
/* 1779 */     paramArrayOfInt[0][2] = 0;
/* 1780 */     paramArrayOfInt[0][3] = 1;
/* 1781 */     paramArrayOfInt[1][3] = 3;
/* 1782 */     paramArrayOfInt[1][0] = 
/* 1783 */       ((paramArrayOfInt1[2] << 8) + paramArrayOfInt1[1]);
/*      */ 
/* 1793 */     return this.machine.instructionSet.AND16(paramArrayOfInt[0], paramArrayOfInt[1]);
/*      */   }
/*      */ 
/*      */   public StopPoint jump26(int[] paramArrayOfInt1, int[][] paramArrayOfInt, int[] paramArrayOfInt2)
/*      */   {
/*      */     int tmp17_14 = 
/* 1811 */       this.machine.getRegister(7);
/*      */ 
/* 1810 */     paramArrayOfInt[1][1] = tmp17_14; paramArrayOfInt[0][1] = tmp17_14;
/*      */ 
/* 1822 */     this.machine.segmentOverride = true;
/* 1823 */     return null;
/*      */   }
/*      */ 
/*      */   public StopPoint jump27(int[] paramArrayOfInt1, int[][] paramArrayOfInt, int[] paramArrayOfInt2)
/*      */   {
/* 1846 */     int i = this.machine.getRegister(20);
/* 1847 */     if (((i & 0xF) > 9) || (this.machine.getFlag(4))) {
/* 1848 */       this.machine.setRegisterAndNotify(i + 6 & 0xFF, 20);
/* 1849 */       this.machine.setFlagAndNotify(4);
/*      */     }
/*      */     else {
/* 1852 */       this.machine.clearFlagAndNotify(4);
/*      */     }
/* 1854 */     if (((i + 6 & 0xFF) > 159) || 
/* 1855 */       (this.machine.getFlag(0))) {
/* 1856 */       this.machine.setRegisterAndNotify(i + 102 & 0xFF, 20);
/* 1857 */       this.machine.setFlagAndNotify(0);
/*      */     }
/*      */     else {
/* 1860 */       this.machine.clearFlagAndNotify(0);
/*      */     }
/*      */ 
/* 1869 */     int j = 0;
/* 1870 */     int k = this.machine.getRegister(20);
/* 1871 */     for (int m = 0; m < 8; m++)
/* 1872 */       j += ((k & Constants.BITMASK[m]) >> m);
/* 1873 */     if (j % 2 == 0)
/* 1874 */       this.machine.setFlagAndNotify(2);
/*      */     else {
/* 1876 */       this.machine.clearFlagAndNotify(2);
/*      */     }
/*      */ 
/* 1880 */     if (k > 127)
/* 1881 */       this.machine.setFlagAndNotify(7);
/*      */     else {
/* 1883 */       this.machine.clearFlagAndNotify(7);
/*      */     }
/*      */ 
/* 1887 */     if (k == 0)
/* 1888 */       this.machine.setFlagAndNotify(6);
/*      */     else {
/* 1890 */       this.machine.clearFlagAndNotify(6);
/*      */     }
/* 1892 */     return null;
/*      */   }
/*      */ 
/*      */   public StopPoint jump28(int[] paramArrayOfInt1, int[][] paramArrayOfInt, int[] paramArrayOfInt2)
/*      */   {
/* 1910 */     paramArrayOfInt2[0] = 1;
/* 1911 */     paramArrayOfInt2[1] = 1;
/* 1912 */     paramArrayOfInt2[2] = 0;
/*      */ 
/* 1915 */     this.stopPoint = this.machine.addressModeDecoder.decode(paramArrayOfInt1, paramArrayOfInt, paramArrayOfInt2);
/*      */ 
/* 1917 */     if (this.stopPoint != null) return this.stopPoint;
/*      */ 
/* 1925 */     paramArrayOfInt[2][0] += 1;
/*      */ 
/* 1935 */     return this.machine.instructionSet.SUB8(paramArrayOfInt[0], paramArrayOfInt[1]);
/*      */   }
/*      */ 
/*      */   public StopPoint jump29(int[] paramArrayOfInt1, int[][] paramArrayOfInt, int[] paramArrayOfInt2)
/*      */   {
/* 1953 */     paramArrayOfInt2[0] = 1;
/* 1954 */     paramArrayOfInt2[1] = 2;
/* 1955 */     paramArrayOfInt2[2] = 0;
/*      */ 
/* 1958 */     this.stopPoint = this.machine.addressModeDecoder.decode(paramArrayOfInt1, paramArrayOfInt, paramArrayOfInt2);
/*      */ 
/* 1960 */     if (this.stopPoint != null) return this.stopPoint;
/*      */ 
/* 1969 */     paramArrayOfInt[2][0] += 1;
/*      */ 
/* 1979 */     return this.machine.instructionSet.SUB16(paramArrayOfInt[0], paramArrayOfInt[1]);
/*      */   }
/*      */ 
/*      */   public StopPoint jump2A(int[] paramArrayOfInt1, int[][] paramArrayOfInt, int[] paramArrayOfInt2)
/*      */   {
/* 1997 */     paramArrayOfInt2[0] = 1;
/* 1998 */     paramArrayOfInt2[1] = 1;
/* 1999 */     paramArrayOfInt2[2] = 1;
/*      */ 
/* 2002 */     this.stopPoint = this.machine.addressModeDecoder.decode(paramArrayOfInt1, paramArrayOfInt, paramArrayOfInt2);
/*      */ 
/* 2004 */     if (this.stopPoint != null) return this.stopPoint;
/*      */ 
/* 2012 */     paramArrayOfInt[2][0] += 1;
/*      */ 
/* 2022 */     return this.machine.instructionSet.SUB8(paramArrayOfInt[0], paramArrayOfInt[1]);
/*      */   }
/*      */ 
/*      */   public StopPoint jump2B(int[] paramArrayOfInt1, int[][] paramArrayOfInt, int[] paramArrayOfInt2)
/*      */   {
/* 2040 */     paramArrayOfInt2[0] = 1;
/* 2041 */     paramArrayOfInt2[1] = 2;
/* 2042 */     paramArrayOfInt2[2] = 1;
/*      */ 
/* 2045 */     this.stopPoint = this.machine.addressModeDecoder.decode(paramArrayOfInt1, paramArrayOfInt, paramArrayOfInt2);
/*      */ 
/* 2047 */     if (this.stopPoint != null) return this.stopPoint;
/*      */ 
/* 2055 */     paramArrayOfInt[2][0] += 1;
/*      */ 
/* 2065 */     return this.machine.instructionSet.SUB16(paramArrayOfInt[0], paramArrayOfInt[1]);
/*      */   }
/*      */ 
/*      */   public StopPoint jump2C(int[] paramArrayOfInt1, int[][] paramArrayOfInt, int[] paramArrayOfInt2)
/*      */   {
/* 2083 */     paramArrayOfInt[2][0] += 1;
/*      */ 
/* 2089 */     paramArrayOfInt[0][2] = 20;
/* 2090 */     paramArrayOfInt[0][3] = 1;
/* 2091 */     paramArrayOfInt[1][3] = 3;
/* 2092 */     paramArrayOfInt[1][0] = paramArrayOfInt1[1];
/*      */ 
/* 2102 */     return this.machine.instructionSet.SUB8(paramArrayOfInt[0], paramArrayOfInt[1]);
/*      */   }
/*      */ 
/*      */   public StopPoint jump2D(int[] paramArrayOfInt1, int[][] paramArrayOfInt, int[] paramArrayOfInt2)
/*      */   {
/* 2120 */     paramArrayOfInt[2][0] += 2;
/*      */ 
/* 2126 */     paramArrayOfInt[0][2] = 0;
/* 2127 */     paramArrayOfInt[0][3] = 1;
/* 2128 */     paramArrayOfInt[1][3] = 3;
/* 2129 */     paramArrayOfInt[1][0] = 
/* 2130 */       ((paramArrayOfInt1[2] << 8) + paramArrayOfInt1[1]);
/*      */ 
/* 2140 */     return this.machine.instructionSet.SUB16(paramArrayOfInt[0], paramArrayOfInt[1]);
/*      */   }
/*      */ 
/*      */   public StopPoint jump2E(int[] paramArrayOfInt1, int[][] paramArrayOfInt, int[] paramArrayOfInt2)
/*      */   {
/*      */     int tmp16_13 = 
/* 2158 */       this.machine.getRegister(4);
/*      */ 
/* 2157 */     paramArrayOfInt[1][1] = tmp16_13; paramArrayOfInt[0][1] = tmp16_13;
/*      */ 
/* 2169 */     this.machine.segmentOverride = true;
/* 2170 */     return null;
/*      */   }
/*      */ 
/*      */   public StopPoint jump2F(int[] paramArrayOfInt1, int[][] paramArrayOfInt, int[] paramArrayOfInt2)
/*      */   {
/* 2193 */     int i = this.machine.getRegister(20);
/* 2194 */     if (((i & 0xF) > 9) || (this.machine.getFlag(4))) {
/* 2195 */       this.machine.setRegisterAndNotify(i - 6 & 0xFF, 20);
/* 2196 */       this.machine.setFlagAndNotify(4);
/*      */     }
/*      */     else {
/* 2199 */       this.machine.clearFlagAndNotify(4);
/*      */     }
/* 2201 */     if (((i - 6 & 0xFF) > 159) || 
/* 2202 */       (this.machine.getFlag(0))) {
/* 2203 */       this.machine.setRegisterAndNotify(i - 102 & 0xFF, 20);
/* 2204 */       this.machine.setFlagAndNotify(0);
/*      */     }
/*      */     else {
/* 2207 */       this.machine.clearFlagAndNotify(0);
/*      */     }
/*      */ 
/* 2216 */     int j = 0;
/* 2217 */     int k = this.machine.getRegister(20);
/* 2218 */     for (int m = 0; m < 8; m++)
/* 2219 */       j += ((k & Constants.BITMASK[m]) >> m);
/* 2220 */     if (j % 2 == 0)
/* 2221 */       this.machine.setFlagAndNotify(2);
/*      */     else {
/* 2223 */       this.machine.clearFlagAndNotify(2);
/*      */     }
/*      */ 
/* 2227 */     if (k > 127)
/* 2228 */       this.machine.setFlagAndNotify(7);
/*      */     else {
/* 2230 */       this.machine.clearFlagAndNotify(7);
/*      */     }
/*      */ 
/* 2234 */     if (k == 0)
/* 2235 */       this.machine.setFlagAndNotify(6);
/*      */     else {
/* 2237 */       this.machine.clearFlagAndNotify(6);
/*      */     }
/* 2239 */     return null;
/*      */   }
/*      */ 
/*      */   public StopPoint jump30(int[] paramArrayOfInt1, int[][] paramArrayOfInt, int[] paramArrayOfInt2)
/*      */   {
/* 2257 */     paramArrayOfInt2[0] = 1;
/* 2258 */     paramArrayOfInt2[1] = 1;
/* 2259 */     paramArrayOfInt2[2] = 0;
/*      */ 
/* 2262 */     this.stopPoint = this.machine.addressModeDecoder.decode(paramArrayOfInt1, paramArrayOfInt, paramArrayOfInt2);
/*      */ 
/* 2264 */     if (this.stopPoint != null) return this.stopPoint;
/*      */ 
/* 2272 */     paramArrayOfInt[2][0] += 1;
/*      */ 
/* 2282 */     return this.machine.instructionSet.XOR8(paramArrayOfInt[0], paramArrayOfInt[1]);
/*      */   }
/*      */ 
/*      */   public StopPoint jump31(int[] paramArrayOfInt1, int[][] paramArrayOfInt, int[] paramArrayOfInt2)
/*      */   {
/* 2300 */     paramArrayOfInt2[0] = 1;
/* 2301 */     paramArrayOfInt2[1] = 2;
/* 2302 */     paramArrayOfInt2[2] = 0;
/*      */ 
/* 2305 */     this.stopPoint = this.machine.addressModeDecoder.decode(paramArrayOfInt1, paramArrayOfInt, paramArrayOfInt2);
/*      */ 
/* 2307 */     if (this.stopPoint != null) return this.stopPoint;
/*      */ 
/* 2316 */     paramArrayOfInt[2][0] += 1;
/*      */ 
/* 2326 */     return this.machine.instructionSet.XOR16(paramArrayOfInt[0], paramArrayOfInt[1]);
/*      */   }
/*      */ 
/*      */   public StopPoint jump32(int[] paramArrayOfInt1, int[][] paramArrayOfInt, int[] paramArrayOfInt2)
/*      */   {
/* 2344 */     paramArrayOfInt2[0] = 1;
/* 2345 */     paramArrayOfInt2[1] = 1;
/* 2346 */     paramArrayOfInt2[2] = 1;
/*      */ 
/* 2349 */     this.stopPoint = this.machine.addressModeDecoder.decode(paramArrayOfInt1, paramArrayOfInt, paramArrayOfInt2);
/*      */ 
/* 2351 */     if (this.stopPoint != null) return this.stopPoint;
/*      */ 
/* 2359 */     paramArrayOfInt[2][0] += 1;
/*      */ 
/* 2369 */     return this.machine.instructionSet.XOR8(paramArrayOfInt[0], paramArrayOfInt[1]);
/*      */   }
/*      */ 
/*      */   public StopPoint jump33(int[] paramArrayOfInt1, int[][] paramArrayOfInt, int[] paramArrayOfInt2)
/*      */   {
/* 2387 */     paramArrayOfInt2[0] = 1;
/* 2388 */     paramArrayOfInt2[1] = 2;
/* 2389 */     paramArrayOfInt2[2] = 1;
/*      */ 
/* 2392 */     this.stopPoint = this.machine.addressModeDecoder.decode(paramArrayOfInt1, paramArrayOfInt, paramArrayOfInt2);
/*      */ 
/* 2394 */     if (this.stopPoint != null) return this.stopPoint;
/*      */ 
/* 2402 */     paramArrayOfInt[2][0] += 1;
/*      */ 
/* 2412 */     return this.machine.instructionSet.XOR16(paramArrayOfInt[0], paramArrayOfInt[1]);
/*      */   }
/*      */ 
/*      */   public StopPoint jump34(int[] paramArrayOfInt1, int[][] paramArrayOfInt, int[] paramArrayOfInt2)
/*      */   {
/* 2430 */     paramArrayOfInt[2][0] += 1;
/*      */ 
/* 2436 */     paramArrayOfInt[0][2] = 20;
/* 2437 */     paramArrayOfInt[0][3] = 1;
/* 2438 */     paramArrayOfInt[1][3] = 3;
/* 2439 */     paramArrayOfInt[1][0] = paramArrayOfInt1[1];
/*      */ 
/* 2449 */     return this.machine.instructionSet.XOR8(paramArrayOfInt[0], paramArrayOfInt[1]);
/*      */   }
/*      */ 
/*      */   public StopPoint jump35(int[] paramArrayOfInt1, int[][] paramArrayOfInt, int[] paramArrayOfInt2)
/*      */   {
/* 2467 */     paramArrayOfInt[2][0] += 2;
/*      */ 
/* 2473 */     paramArrayOfInt[0][2] = 0;
/* 2474 */     paramArrayOfInt[0][3] = 1;
/* 2475 */     paramArrayOfInt[1][3] = 3;
/* 2476 */     paramArrayOfInt[1][0] = 
/* 2477 */       ((paramArrayOfInt1[2] << 8) + paramArrayOfInt1[1]);
/*      */ 
/* 2487 */     return this.machine.instructionSet.XOR16(paramArrayOfInt[0], paramArrayOfInt[1]);
/*      */   }
/*      */ 
/*      */   public StopPoint jump36(int[] paramArrayOfInt1, int[][] paramArrayOfInt, int[] paramArrayOfInt2)
/*      */   {
/*      */     int tmp17_14 = 
/* 2505 */       this.machine.getRegister(6);
/*      */ 
/* 2504 */     paramArrayOfInt[1][1] = tmp17_14; paramArrayOfInt[0][1] = tmp17_14;
/*      */ 
/* 2516 */     this.machine.segmentOverride = true;
/* 2517 */     return null;
/*      */   }
/*      */ 
/*      */   public StopPoint jump37(int[] paramArrayOfInt1, int[][] paramArrayOfInt, int[] paramArrayOfInt2)
/*      */   {
/* 2540 */     int i = this.machine.getRegister(20);
/* 2541 */     if (((i & 0xF) > 9) || (this.machine.getFlag(4))) {
/* 2542 */       this.machine.setRegisterAndNotify(i + 6 & 0xF, 20);
/* 2543 */       this.machine.incAndNotify(1, 30);
/* 2544 */       this.machine.setFlagAndNotify(4);
/* 2545 */       this.machine.setFlagAndNotify(0);
/*      */     }
/*      */     else {
/* 2548 */       this.machine.clearFlagAndNotify(4);
/* 2549 */       this.machine.clearFlagAndNotify(0);
/*      */     }
/*      */ 
/* 2552 */     return null;
/*      */   }
/*      */ 
/*      */   public StopPoint jump38(int[] paramArrayOfInt1, int[][] paramArrayOfInt, int[] paramArrayOfInt2)
/*      */   {
/* 2570 */     paramArrayOfInt2[0] = 1;
/* 2571 */     paramArrayOfInt2[1] = 1;
/* 2572 */     paramArrayOfInt2[2] = 0;
/*      */ 
/* 2575 */     this.stopPoint = this.machine.addressModeDecoder.decode(paramArrayOfInt1, paramArrayOfInt, paramArrayOfInt2);
/*      */ 
/* 2577 */     if (this.stopPoint != null) return this.stopPoint;
/*      */ 
/* 2585 */     paramArrayOfInt[2][0] += 1;
/*      */ 
/* 2595 */     return this.machine.instructionSet.CMP8(paramArrayOfInt[0], paramArrayOfInt[1]);
/*      */   }
/*      */ 
/*      */   public StopPoint jump39(int[] paramArrayOfInt1, int[][] paramArrayOfInt, int[] paramArrayOfInt2)
/*      */   {
/* 2613 */     paramArrayOfInt2[0] = 1;
/* 2614 */     paramArrayOfInt2[1] = 2;
/* 2615 */     paramArrayOfInt2[2] = 0;
/*      */ 
/* 2618 */     this.stopPoint = this.machine.addressModeDecoder.decode(paramArrayOfInt1, paramArrayOfInt, paramArrayOfInt2);
/*      */ 
/* 2620 */     if (this.stopPoint != null) return this.stopPoint;
/*      */ 
/* 2628 */     paramArrayOfInt[2][0] += 1;
/*      */ 
/* 2638 */     return this.machine.instructionSet.CMP16(paramArrayOfInt[0], paramArrayOfInt[1]);
/*      */   }
/*      */ 
/*      */   public StopPoint jump3A(int[] paramArrayOfInt1, int[][] paramArrayOfInt, int[] paramArrayOfInt2)
/*      */   {
/* 2656 */     paramArrayOfInt2[0] = 1;
/* 2657 */     paramArrayOfInt2[1] = 1;
/* 2658 */     paramArrayOfInt2[2] = 1;
/*      */ 
/* 2661 */     this.stopPoint = this.machine.addressModeDecoder.decode(paramArrayOfInt1, paramArrayOfInt, paramArrayOfInt2);
/*      */ 
/* 2663 */     if (this.stopPoint != null) return this.stopPoint;
/*      */ 
/* 2671 */     paramArrayOfInt[2][0] += 1;
/*      */ 
/* 2681 */     return this.machine.instructionSet.CMP8(paramArrayOfInt[0], paramArrayOfInt[1]);
/*      */   }
/*      */ 
/*      */   public StopPoint jump3B(int[] paramArrayOfInt1, int[][] paramArrayOfInt, int[] paramArrayOfInt2)
/*      */   {
/* 2699 */     paramArrayOfInt2[0] = 1;
/* 2700 */     paramArrayOfInt2[1] = 2;
/* 2701 */     paramArrayOfInt2[2] = 1;
/*      */ 
/* 2704 */     this.stopPoint = this.machine.addressModeDecoder.decode(paramArrayOfInt1, paramArrayOfInt, paramArrayOfInt2);
/*      */ 
/* 2706 */     if (this.stopPoint != null) return this.stopPoint;
/*      */ 
/* 2714 */     paramArrayOfInt[2][0] += 1;
/*      */ 
/* 2724 */     return this.machine.instructionSet.CMP16(paramArrayOfInt[0], paramArrayOfInt[1]);
/*      */   }
/*      */ 
/*      */   public StopPoint jump3C(int[] paramArrayOfInt1, int[][] paramArrayOfInt, int[] paramArrayOfInt2)
/*      */   {
/* 2742 */     paramArrayOfInt[0][2] = 20;
/* 2743 */     paramArrayOfInt[0][3] = 1;
/* 2744 */     paramArrayOfInt[1][3] = 3;
/*      */ 
/* 2746 */     paramArrayOfInt[1][0] = paramArrayOfInt1[1];
/*      */ 
/* 2752 */     paramArrayOfInt[2][0] += 1;
/*      */ 
/* 2762 */     return this.machine.instructionSet.CMP8(paramArrayOfInt[0], paramArrayOfInt[1]);
/*      */   }
/*      */ 
/*      */   public StopPoint jump3D(int[] paramArrayOfInt1, int[][] paramArrayOfInt, int[] paramArrayOfInt2)
/*      */   {
/* 2780 */     paramArrayOfInt[0][2] = 0;
/* 2781 */     paramArrayOfInt[0][3] = 1;
/* 2782 */     paramArrayOfInt[1][3] = 3;
/*      */ 
/* 2784 */     paramArrayOfInt[1][0] = ((paramArrayOfInt1[2] << 8) + paramArrayOfInt1[1]);
/*      */ 
/* 2790 */     paramArrayOfInt[2][0] += 2;
/*      */ 
/* 2800 */     return this.machine.instructionSet.CMP16(paramArrayOfInt[0], paramArrayOfInt[1]);
/*      */   }
/*      */ 
/*      */   public StopPoint jump3E(int[] paramArrayOfInt1, int[][] paramArrayOfInt, int[] paramArrayOfInt2)
/*      */   {
/*      */     int tmp16_13 = 
/* 2818 */       this.machine.getRegister(5);
/*      */ 
/* 2817 */     paramArrayOfInt[1][1] = tmp16_13; paramArrayOfInt[0][1] = tmp16_13;
/*      */ 
/* 2829 */     this.machine.segmentOverride = true;
/* 2830 */     return null;
/*      */   }
/*      */ 
/*      */   public StopPoint jump3F(int[] paramArrayOfInt1, int[][] paramArrayOfInt, int[] paramArrayOfInt2)
/*      */   {
/* 2853 */     int i = this.machine.getRegister(20);
/* 2854 */     if (((i & 0xF) > 9) || (this.machine.getFlag(4))) {
/* 2855 */       this.machine.setRegisterAndNotify(i - 6 & 0xF, 20);
/* 2856 */       this.machine.incAndNotify(-1, 30);
/* 2857 */       this.machine.setFlagAndNotify(4);
/* 2858 */       this.machine.setFlagAndNotify(0);
/*      */     }
/*      */     else {
/* 2861 */       this.machine.clearFlagAndNotify(4);
/* 2862 */       this.machine.clearFlagAndNotify(0);
/*      */     }
/*      */ 
/* 2865 */     return null;
/*      */   }
/*      */ 
/*      */   public StopPoint jump40(int[] paramArrayOfInt1, int[][] paramArrayOfInt, int[] paramArrayOfInt2)
/*      */   {
/* 2883 */     paramArrayOfInt[0][2] = 0;
/* 2884 */     paramArrayOfInt[0][3] = 1;
/*      */ 
/* 2897 */     return this.machine.instructionSet.INC16(paramArrayOfInt[0]);
/*      */   }
/*      */ 
/*      */   public StopPoint jump41(int[] paramArrayOfInt1, int[][] paramArrayOfInt, int[] paramArrayOfInt2)
/*      */   {
/* 2915 */     paramArrayOfInt[0][2] = 2;
/* 2916 */     paramArrayOfInt[0][3] = 1;
/*      */ 
/* 2929 */     return this.machine.instructionSet.INC16(paramArrayOfInt[0]);
/*      */   }
/*      */ 
/*      */   public StopPoint jump42(int[] paramArrayOfInt1, int[][] paramArrayOfInt, int[] paramArrayOfInt2)
/*      */   {
/* 2947 */     paramArrayOfInt[0][2] = 3;
/* 2948 */     paramArrayOfInt[0][3] = 1;
/*      */ 
/* 2961 */     return this.machine.instructionSet.INC16(paramArrayOfInt[0]);
/*      */   }
/*      */ 
/*      */   public StopPoint jump43(int[] paramArrayOfInt1, int[][] paramArrayOfInt, int[] paramArrayOfInt2)
/*      */   {
/* 2979 */     paramArrayOfInt[0][2] = 1;
/* 2980 */     paramArrayOfInt[0][3] = 1;
/*      */ 
/* 2993 */     return this.machine.instructionSet.INC16(paramArrayOfInt[0]);
/*      */   }
/*      */ 
/*      */   public StopPoint jump44(int[] paramArrayOfInt1, int[][] paramArrayOfInt, int[] paramArrayOfInt2)
/*      */   {
/* 3011 */     paramArrayOfInt[0][2] = 9;
/* 3012 */     paramArrayOfInt[0][3] = 1;
/*      */ 
/* 3025 */     return this.machine.instructionSet.INC16(paramArrayOfInt[0]);
/*      */   }
/*      */ 
/*      */   public StopPoint jump45(int[] paramArrayOfInt1, int[][] paramArrayOfInt, int[] paramArrayOfInt2)
/*      */   {
/* 3043 */     paramArrayOfInt[0][2] = 10;
/* 3044 */     paramArrayOfInt[0][3] = 1;
/*      */ 
/* 3057 */     return this.machine.instructionSet.INC16(paramArrayOfInt[0]);
/*      */   }
/*      */ 
/*      */   public StopPoint jump46(int[] paramArrayOfInt1, int[][] paramArrayOfInt, int[] paramArrayOfInt2)
/*      */   {
/* 3075 */     paramArrayOfInt[0][2] = 11;
/* 3076 */     paramArrayOfInt[0][3] = 1;
/*      */ 
/* 3089 */     return this.machine.instructionSet.INC16(paramArrayOfInt[0]);
/*      */   }
/*      */ 
/*      */   public StopPoint jump47(int[] paramArrayOfInt1, int[][] paramArrayOfInt, int[] paramArrayOfInt2)
/*      */   {
/* 3107 */     paramArrayOfInt[0][2] = 12;
/* 3108 */     paramArrayOfInt[0][3] = 1;
/*      */ 
/* 3121 */     return this.machine.instructionSet.INC16(paramArrayOfInt[0]);
/*      */   }
/*      */ 
/*      */   public StopPoint jump48(int[] paramArrayOfInt1, int[][] paramArrayOfInt, int[] paramArrayOfInt2)
/*      */   {
/* 3139 */     paramArrayOfInt[0][2] = 0;
/* 3140 */     paramArrayOfInt[0][3] = 1;
/*      */ 
/* 3153 */     return this.machine.instructionSet.DEC16(paramArrayOfInt[0]);
/*      */   }
/*      */ 
/*      */   public StopPoint jump49(int[] paramArrayOfInt1, int[][] paramArrayOfInt, int[] paramArrayOfInt2)
/*      */   {
/* 3171 */     paramArrayOfInt[0][2] = 2;
/* 3172 */     paramArrayOfInt[0][3] = 1;
/*      */ 
/* 3185 */     return this.machine.instructionSet.DEC16(paramArrayOfInt[0]);
/*      */   }
/*      */ 
/*      */   public StopPoint jump4A(int[] paramArrayOfInt1, int[][] paramArrayOfInt, int[] paramArrayOfInt2)
/*      */   {
/* 3203 */     paramArrayOfInt[0][2] = 3;
/* 3204 */     paramArrayOfInt[0][3] = 1;
/*      */ 
/* 3217 */     return this.machine.instructionSet.DEC16(paramArrayOfInt[0]);
/*      */   }
/*      */ 
/*      */   public StopPoint jump4B(int[] paramArrayOfInt1, int[][] paramArrayOfInt, int[] paramArrayOfInt2)
/*      */   {
/* 3235 */     paramArrayOfInt[0][2] = 1;
/* 3236 */     paramArrayOfInt[0][3] = 1;
/*      */ 
/* 3249 */     return this.machine.instructionSet.DEC16(paramArrayOfInt[0]);
/*      */   }
/*      */ 
/*      */   public StopPoint jump4C(int[] paramArrayOfInt1, int[][] paramArrayOfInt, int[] paramArrayOfInt2)
/*      */   {
/* 3267 */     paramArrayOfInt[0][2] = 9;
/* 3268 */     paramArrayOfInt[0][3] = 1;
/*      */ 
/* 3281 */     return this.machine.instructionSet.DEC16(paramArrayOfInt[0]);
/*      */   }
/*      */ 
/*      */   public StopPoint jump4D(int[] paramArrayOfInt1, int[][] paramArrayOfInt, int[] paramArrayOfInt2)
/*      */   {
/* 3299 */     paramArrayOfInt[0][2] = 10;
/* 3300 */     paramArrayOfInt[0][3] = 1;
/*      */ 
/* 3313 */     return this.machine.instructionSet.DEC16(paramArrayOfInt[0]);
/*      */   }
/*      */ 
/*      */   public StopPoint jump4E(int[] paramArrayOfInt1, int[][] paramArrayOfInt, int[] paramArrayOfInt2)
/*      */   {
/* 3331 */     paramArrayOfInt[0][2] = 11;
/* 3332 */     paramArrayOfInt[0][3] = 1;
/*      */ 
/* 3345 */     return this.machine.instructionSet.DEC16(paramArrayOfInt[0]);
/*      */   }
/*      */ 
/*      */   public StopPoint jump4F(int[] paramArrayOfInt1, int[][] paramArrayOfInt, int[] paramArrayOfInt2)
/*      */   {
/* 3363 */     paramArrayOfInt[0][2] = 12;
/* 3364 */     paramArrayOfInt[0][3] = 1;
/*      */ 
/* 3377 */     return this.machine.instructionSet.DEC16(paramArrayOfInt[0]);
/*      */   }
/*      */ 
/*      */   public StopPoint jump50(int[] paramArrayOfInt1, int[][] paramArrayOfInt, int[] paramArrayOfInt2)
/*      */   {
/* 3401 */     paramArrayOfInt[1][2] = 0;
/* 3402 */     paramArrayOfInt[1][3] = 1;
/*      */ 
/* 3413 */     return this.machine.instructionSet.PUSH(paramArrayOfInt[1]);
/*      */   }
/*      */ 
/*      */   public StopPoint jump51(int[] paramArrayOfInt1, int[][] paramArrayOfInt, int[] paramArrayOfInt2)
/*      */   {
/* 3437 */     paramArrayOfInt[1][2] = 2;
/* 3438 */     paramArrayOfInt[1][3] = 1;
/*      */ 
/* 3449 */     return this.machine.instructionSet.PUSH(paramArrayOfInt[1]);
/*      */   }
/*      */ 
/*      */   public StopPoint jump52(int[] paramArrayOfInt1, int[][] paramArrayOfInt, int[] paramArrayOfInt2)
/*      */   {
/* 3473 */     paramArrayOfInt[1][2] = 3;
/* 3474 */     paramArrayOfInt[1][3] = 1;
/*      */ 
/* 3485 */     return this.machine.instructionSet.PUSH(paramArrayOfInt[1]);
/*      */   }
/*      */ 
/*      */   public StopPoint jump53(int[] paramArrayOfInt1, int[][] paramArrayOfInt, int[] paramArrayOfInt2)
/*      */   {
/* 3509 */     paramArrayOfInt[1][2] = 1;
/* 3510 */     paramArrayOfInt[1][3] = 1;
/*      */ 
/* 3521 */     return this.machine.instructionSet.PUSH(paramArrayOfInt[1]);
/*      */   }
/*      */ 
/*      */   public StopPoint jump54(int[] paramArrayOfInt1, int[][] paramArrayOfInt, int[] paramArrayOfInt2)
/*      */   {
/* 3545 */     paramArrayOfInt[1][2] = 9;
/* 3546 */     paramArrayOfInt[1][3] = 1;
/*      */ 
/* 3557 */     return this.machine.instructionSet.PUSH(paramArrayOfInt[1]);
/*      */   }
/*      */ 
/*      */   public StopPoint jump55(int[] paramArrayOfInt1, int[][] paramArrayOfInt, int[] paramArrayOfInt2)
/*      */   {
/* 3581 */     paramArrayOfInt[1][2] = 10;
/* 3582 */     paramArrayOfInt[1][3] = 1;
/*      */ 
/* 3593 */     return this.machine.instructionSet.PUSH(paramArrayOfInt[1]);
/*      */   }
/*      */ 
/*      */   public StopPoint jump56(int[] paramArrayOfInt1, int[][] paramArrayOfInt, int[] paramArrayOfInt2)
/*      */   {
/* 3617 */     paramArrayOfInt[1][2] = 11;
/* 3618 */     paramArrayOfInt[1][3] = 1;
/*      */ 
/* 3629 */     return this.machine.instructionSet.PUSH(paramArrayOfInt[1]);
/*      */   }
/*      */ 
/*      */   public StopPoint jump57(int[] paramArrayOfInt1, int[][] paramArrayOfInt, int[] paramArrayOfInt2)
/*      */   {
/* 3653 */     paramArrayOfInt[1][2] = 12;
/* 3654 */     paramArrayOfInt[1][3] = 1;
/*      */ 
/* 3665 */     return this.machine.instructionSet.PUSH(paramArrayOfInt[1]);
/*      */   }
/*      */ 
/*      */   public StopPoint jump58(int[] paramArrayOfInt1, int[][] paramArrayOfInt, int[] paramArrayOfInt2)
/*      */   {
/* 3689 */     paramArrayOfInt[0][2] = 0;
/* 3690 */     paramArrayOfInt[0][3] = 1;
/*      */ 
/* 3701 */     return this.machine.instructionSet.POP(paramArrayOfInt[0]);
/*      */   }
/*      */ 
/*      */   public StopPoint jump59(int[] paramArrayOfInt1, int[][] paramArrayOfInt, int[] paramArrayOfInt2)
/*      */   {
/* 3725 */     paramArrayOfInt[0][2] = 2;
/* 3726 */     paramArrayOfInt[0][3] = 1;
/*      */ 
/* 3737 */     return this.machine.instructionSet.POP(paramArrayOfInt[0]);
/*      */   }
/*      */ 
/*      */   public StopPoint jump5A(int[] paramArrayOfInt1, int[][] paramArrayOfInt, int[] paramArrayOfInt2)
/*      */   {
/* 3761 */     paramArrayOfInt[0][2] = 3;
/* 3762 */     paramArrayOfInt[0][3] = 1;
/*      */ 
/* 3773 */     return this.machine.instructionSet.POP(paramArrayOfInt[0]);
/*      */   }
/*      */ 
/*      */   public StopPoint jump5B(int[] paramArrayOfInt1, int[][] paramArrayOfInt, int[] paramArrayOfInt2)
/*      */   {
/* 3797 */     paramArrayOfInt[0][2] = 1;
/* 3798 */     paramArrayOfInt[0][3] = 1;
/*      */ 
/* 3809 */     return this.machine.instructionSet.POP(paramArrayOfInt[0]);
/*      */   }
/*      */ 
/*      */   public StopPoint jump5C(int[] paramArrayOfInt1, int[][] paramArrayOfInt, int[] paramArrayOfInt2)
/*      */   {
/* 3833 */     paramArrayOfInt[0][2] = 9;
/* 3834 */     paramArrayOfInt[0][3] = 1;
/*      */ 
/* 3845 */     return this.machine.instructionSet.POP(paramArrayOfInt[0]);
/*      */   }
/*      */ 
/*      */   public StopPoint jump5D(int[] paramArrayOfInt1, int[][] paramArrayOfInt, int[] paramArrayOfInt2)
/*      */   {
/* 3869 */     paramArrayOfInt[0][2] = 10;
/* 3870 */     paramArrayOfInt[0][3] = 1;
/*      */ 
/* 3881 */     return this.machine.instructionSet.POP(paramArrayOfInt[0]);
/*      */   }
/*      */ 
/*      */   public StopPoint jump5E(int[] paramArrayOfInt1, int[][] paramArrayOfInt, int[] paramArrayOfInt2)
/*      */   {
/* 3905 */     paramArrayOfInt[0][2] = 11;
/* 3906 */     paramArrayOfInt[0][3] = 1;
/*      */ 
/* 3917 */     return this.machine.instructionSet.POP(paramArrayOfInt[0]);
/*      */   }
/*      */ 
/*      */   public StopPoint jump5F(int[] paramArrayOfInt1, int[][] paramArrayOfInt, int[] paramArrayOfInt2)
/*      */   {
/* 3941 */     paramArrayOfInt[0][2] = 12;
/* 3942 */     paramArrayOfInt[0][3] = 1;
/*      */ 
/* 3953 */     return this.machine.instructionSet.POP(paramArrayOfInt[0]);
/*      */   }
/*      */ 
/*      */   public StopPoint jump70(int[] paramArrayOfInt1, int[][] paramArrayOfInt, int[] paramArrayOfInt2)
/*      */   {
/* 3970 */     paramArrayOfInt[2][0] += 1;
/*      */ 
/* 3976 */     if (this.machine.getFlag(11)) {
/* 3977 */       int i = paramArrayOfInt1[1];
/* 3978 */       if (i > 127) i = -(((i ^ 0xFFFFFFFF) & 0xFF) + 1);
/* 3979 */       this.machine.incIPAndNotify(i);
/*      */     }
/*      */ 
/* 3986 */     return null;
/*      */   }
/*      */ 
/*      */   public StopPoint jump71(int[] paramArrayOfInt1, int[][] paramArrayOfInt, int[] paramArrayOfInt2)
/*      */   {
/* 4003 */     paramArrayOfInt[2][0] += 1;
/*      */ 
/* 4009 */     if (!this.machine.getFlag(11)) {
/* 4010 */       int i = paramArrayOfInt1[1];
/* 4011 */       if (i > 127) i = -(((i ^ 0xFFFFFFFF) & 0xFF) + 1);
/* 4012 */       this.machine.incIPAndNotify(i);
/*      */     }
/*      */ 
/* 4019 */     return null;
/*      */   }
/*      */ 
/*      */   public StopPoint jump72(int[] paramArrayOfInt1, int[][] paramArrayOfInt, int[] paramArrayOfInt2)
/*      */   {
/* 4036 */     paramArrayOfInt[2][0] += 1;
/*      */ 
/* 4042 */     if (this.machine.getFlag(0)) {
/* 4043 */       int i = paramArrayOfInt1[1];
/* 4044 */       if (i > 127) i = -(((i ^ 0xFFFFFFFF) & 0xFF) + 1);
/* 4045 */       this.machine.incIPAndNotify(i);
/*      */     }
/*      */ 
/* 4052 */     return null;
/*      */   }
/*      */ 
/*      */   public StopPoint jump73(int[] paramArrayOfInt1, int[][] paramArrayOfInt, int[] paramArrayOfInt2)
/*      */   {
/* 4069 */     paramArrayOfInt[2][0] += 1;
/*      */ 
/* 4075 */     if (!this.machine.getFlag(0)) {
/* 4076 */       int i = paramArrayOfInt1[1];
/* 4077 */       if (i > 127) i = -(((i ^ 0xFFFFFFFF) & 0xFF) + 1);
/* 4078 */       this.machine.incIPAndNotify(i);
/*      */     }
/*      */ 
/* 4085 */     return null;
/*      */   }
/*      */ 
/*      */   public StopPoint jump74(int[] paramArrayOfInt1, int[][] paramArrayOfInt, int[] paramArrayOfInt2)
/*      */   {
/* 4102 */     paramArrayOfInt[2][0] += 1;
/*      */ 
/* 4108 */     if (this.machine.getFlag(6)) {
/* 4109 */       int i = paramArrayOfInt1[1];
/* 4110 */       if (i > 127) i = -(((i ^ 0xFFFFFFFF) & 0xFF) + 1);
/* 4111 */       this.machine.incIPAndNotify(i);
/*      */     }
/*      */ 
/* 4118 */     return null;
/*      */   }
/*      */ 
/*      */   public StopPoint jump75(int[] paramArrayOfInt1, int[][] paramArrayOfInt, int[] paramArrayOfInt2)
/*      */   {
/* 4135 */     paramArrayOfInt[2][0] += 1;
/*      */ 
/* 4141 */     if (!this.machine.getFlag(6)) {
/* 4142 */       int i = paramArrayOfInt1[1];
/* 4143 */       if (i > 127) i = -(((i ^ 0xFFFFFFFF) & 0xFF) + 1);
/* 4144 */       this.machine.incIPAndNotify(i);
/*      */     }
/*      */ 
/* 4151 */     return null;
/*      */   }
/*      */ 
/*      */   public StopPoint jump76(int[] paramArrayOfInt1, int[][] paramArrayOfInt, int[] paramArrayOfInt2)
/*      */   {
/* 4168 */     paramArrayOfInt[2][0] += 1;
/*      */ 
/* 4174 */     if ((this.machine.getFlag(0)) || (this.machine.getFlag(6))) {
/* 4175 */       int i = paramArrayOfInt1[1];
/* 4176 */       if (i > 127) i = -(((i ^ 0xFFFFFFFF) & 0xFF) + 1);
/* 4177 */       this.machine.incIPAndNotify(i);
/*      */     }
/*      */ 
/* 4184 */     return null;
/*      */   }
/*      */ 
/*      */   public StopPoint jump77(int[] paramArrayOfInt1, int[][] paramArrayOfInt, int[] paramArrayOfInt2)
/*      */   {
/* 4201 */     paramArrayOfInt[2][0] += 1;
/*      */ 
/* 4207 */     if ((!this.machine.getFlag(0)) && (!this.machine.getFlag(6))) {
/* 4208 */       int i = paramArrayOfInt1[1];
/* 4209 */       if (i > 127) i = -(((i ^ 0xFFFFFFFF) & 0xFF) + 1);
/* 4210 */       this.machine.incIPAndNotify(i);
/*      */     }
/*      */ 
/* 4217 */     return null;
/*      */   }
/*      */ 
/*      */   public StopPoint jump78(int[] paramArrayOfInt1, int[][] paramArrayOfInt, int[] paramArrayOfInt2)
/*      */   {
/* 4234 */     paramArrayOfInt[2][0] += 1;
/*      */ 
/* 4240 */     if (this.machine.getFlag(7)) {
/* 4241 */       int i = paramArrayOfInt1[1];
/* 4242 */       if (i > 127) i = -(((i ^ 0xFFFFFFFF) & 0xFF) + 1);
/* 4243 */       this.machine.incIPAndNotify(i);
/*      */     }
/*      */ 
/* 4250 */     return null;
/*      */   }
/*      */ 
/*      */   public StopPoint jump79(int[] paramArrayOfInt1, int[][] paramArrayOfInt, int[] paramArrayOfInt2)
/*      */   {
/* 4267 */     paramArrayOfInt[2][0] += 1;
/*      */ 
/* 4273 */     if (!this.machine.getFlag(7)) {
/* 4274 */       int i = paramArrayOfInt1[1];
/* 4275 */       if (i > 127) i = -(((i ^ 0xFFFFFFFF) & 0xFF) + 1);
/* 4276 */       this.machine.incIPAndNotify(i);
/*      */     }
/*      */ 
/* 4283 */     return null;
/*      */   }
/*      */ 
/*      */   public StopPoint jump7A(int[] paramArrayOfInt1, int[][] paramArrayOfInt, int[] paramArrayOfInt2)
/*      */   {
/* 4300 */     paramArrayOfInt[2][0] += 1;
/*      */ 
/* 4306 */     if (this.machine.getFlag(2)) {
/* 4307 */       int i = paramArrayOfInt1[1];
/* 4308 */       if (i > 127) i = -(((i ^ 0xFFFFFFFF) & 0xFF) + 1);
/* 4309 */       this.machine.incIPAndNotify(i);
/*      */     }
/*      */ 
/* 4316 */     return null;
/*      */   }
/*      */ 
/*      */   public StopPoint jump7B(int[] paramArrayOfInt1, int[][] paramArrayOfInt, int[] paramArrayOfInt2)
/*      */   {
/* 4333 */     paramArrayOfInt[2][0] += 1;
/*      */ 
/* 4339 */     if (!this.machine.getFlag(2)) {
/* 4340 */       int i = paramArrayOfInt1[1];
/* 4341 */       if (i > 127) i = -(((i ^ 0xFFFFFFFF) & 0xFF) + 1);
/* 4342 */       this.machine.incIPAndNotify(i);
/*      */     }
/*      */ 
/* 4349 */     return null;
/*      */   }
/*      */ 
/*      */   public StopPoint jump7C(int[] paramArrayOfInt1, int[][] paramArrayOfInt, int[] paramArrayOfInt2)
/*      */   {
/* 4366 */     paramArrayOfInt[2][0] += 1;
/*      */ 
/* 4372 */     if ((this.machine.getFlag(7) ^ this.machine.getFlag(11))) {
/* 4373 */       int i = paramArrayOfInt1[1];
/* 4374 */       if (i > 127) i = -(((i ^ 0xFFFFFFFF) & 0xFF) + 1);
/* 4375 */       this.machine.incIPAndNotify(i);
/*      */     }
/*      */ 
/* 4382 */     return null;
/*      */   }
/*      */ 
/*      */   public StopPoint jump7D(int[] paramArrayOfInt1, int[][] paramArrayOfInt, int[] paramArrayOfInt2)
/*      */   {
/* 4399 */     paramArrayOfInt[2][0] += 1;
/*      */ 
/* 4405 */     if (this.machine.getFlag(7) == this.machine.getFlag(11)) {
/* 4406 */       int i = paramArrayOfInt1[1];
/* 4407 */       if (i > 127) i = -(((i ^ 0xFFFFFFFF) & 0xFF) + 1);
/* 4408 */       this.machine.incIPAndNotify(i);
/*      */     }
/*      */ 
/* 4415 */     return null;
/*      */   }
/*      */ 
/*      */   public StopPoint jump7E(int[] paramArrayOfInt1, int[][] paramArrayOfInt, int[] paramArrayOfInt2)
/*      */   {
/* 4432 */     paramArrayOfInt[2][0] += 1;
/*      */ 
/* 4438 */     boolean bool1 = this.machine.getFlag(6);
/* 4439 */     boolean bool2 = this.machine.getFlag(7);
/* 4440 */     boolean bool3 = this.machine.getFlag(11);
/*      */ 
/* 4442 */     if ((bool1) || (bool2 != bool3)) {
/* 4443 */       int i = paramArrayOfInt1[1];
/* 4444 */       if (i > 127) i = -(((i ^ 0xFFFFFFFF) & 0xFF) + 1);
/* 4445 */       this.machine.incIPAndNotify(i);
/*      */     }
/*      */ 
/* 4452 */     return null;
/*      */   }
/*      */ 
/*      */   public StopPoint jump7F(int[] paramArrayOfInt1, int[][] paramArrayOfInt, int[] paramArrayOfInt2)
/*      */   {
/* 4469 */     paramArrayOfInt[2][0] += 1;
/*      */ 
/* 4475 */     boolean bool1 = this.machine.getFlag(6);
/* 4476 */     boolean bool2 = this.machine.getFlag(7);
/* 4477 */     boolean bool3 = this.machine.getFlag(11);
/*      */ 
/* 4479 */     if ((!bool1) && (bool2 == bool3)) {
/* 4480 */       int i = paramArrayOfInt1[1];
/* 4481 */       if (i > 127) i = -(((i ^ 0xFFFFFFFF) & 0xFF) + 1);
/* 4482 */       this.machine.incIPAndNotify(i);
/*      */     }
/*      */ 
/* 4489 */     return null;
/*      */   }
/*      */ 
/*      */   public StopPoint jump80(int[] paramArrayOfInt1, int[][] paramArrayOfInt, int[] paramArrayOfInt2)
/*      */   {
/* 4509 */     paramArrayOfInt2[0] = 1;
/* 4510 */     paramArrayOfInt2[1] = 1;
/* 4511 */     paramArrayOfInt2[2] = 0;
/*      */ 
/* 4514 */     this.stopPoint = this.machine.addressModeDecoder.decode(paramArrayOfInt1, paramArrayOfInt, paramArrayOfInt2);
/*      */ 
/* 4516 */     if (this.stopPoint != null) return this.stopPoint;
/*      */ 
/* 4524 */     paramArrayOfInt[2][0] += 1;
/*      */ 
/* 4530 */     paramArrayOfInt[1][3] = 3;
/*      */ 
/* 4533 */     paramArrayOfInt[1][0] = paramArrayOfInt1[paramArrayOfInt[2][0]];
/*      */ 
/* 4539 */     paramArrayOfInt[2][0] += 1;
/*      */ 
/* 4549 */     int i = (byte)((paramArrayOfInt1[1] & 0x38) >> 3);
/* 4550 */     switch (i) {
/*      */     case 0:
/* 4552 */       return this.machine.instructionSet.ADD8(paramArrayOfInt[0], paramArrayOfInt[1]);
/*      */     case 1:
/* 4555 */       return this.machine.instructionSet.OR8(paramArrayOfInt[0], paramArrayOfInt[1]);
/*      */     case 2:
/* 4558 */       return this.machine.instructionSet.ADC8(paramArrayOfInt[0], paramArrayOfInt[1]);
/*      */     case 3:
/* 4561 */       return this.machine.instructionSet.SBB8(paramArrayOfInt[0], paramArrayOfInt[1]);
/*      */     case 4:
/* 4564 */       return this.machine.instructionSet.AND8(paramArrayOfInt[0], paramArrayOfInt[1]);
/*      */     case 5:
/* 4567 */       return this.machine.instructionSet.SUB8(paramArrayOfInt[0], paramArrayOfInt[1]);
/*      */     case 6:
/* 4570 */       return this.machine.instructionSet.XOR8(paramArrayOfInt[0], paramArrayOfInt[1]);
/*      */     case 7:
/* 4573 */       return this.machine.instructionSet.CMP8(paramArrayOfInt[0], paramArrayOfInt[1]);
/*      */     }
/*      */ 
/* 4576 */     return new StopPoint(0, "");
/*      */   }
/*      */ 
/*      */   public StopPoint jump81(int[] paramArrayOfInt1, int[][] paramArrayOfInt, int[] paramArrayOfInt2)
/*      */   {
/* 4598 */     paramArrayOfInt2[0] = 1;
/* 4599 */     paramArrayOfInt2[1] = 2;
/* 4600 */     paramArrayOfInt2[2] = 0;
/*      */ 
/* 4603 */     this.stopPoint = this.machine.addressModeDecoder.decode(paramArrayOfInt1, paramArrayOfInt, paramArrayOfInt2);
/*      */ 
/* 4605 */     if (this.stopPoint != null) return this.stopPoint;
/*      */ 
/* 4613 */     paramArrayOfInt[2][0] += 1;
/*      */ 
/* 4619 */     paramArrayOfInt[1][3] = 3;
/*      */ 
/* 4622 */     paramArrayOfInt[1][0] = 
/* 4624 */       ((paramArrayOfInt1[(paramArrayOfInt[2][0] + 1)] << 8) + 
/* 4624 */       paramArrayOfInt1[paramArrayOfInt[2][0]]);
/*      */ 
/* 4630 */     paramArrayOfInt[2][0] += 2;
/*      */ 
/* 4640 */     int i = (byte)((paramArrayOfInt1[1] & 0x38) >> 3);
/* 4641 */     switch (i) {
/*      */     case 0:
/* 4643 */       return this.machine.instructionSet.ADD16(paramArrayOfInt[0], paramArrayOfInt[1]);
/*      */     case 1:
/* 4646 */       return this.machine.instructionSet.OR16(paramArrayOfInt[0], paramArrayOfInt[1]);
/*      */     case 2:
/* 4649 */       return this.machine.instructionSet.ADC16(paramArrayOfInt[0], paramArrayOfInt[1]);
/*      */     case 3:
/* 4652 */       return this.machine.instructionSet.SBB16(paramArrayOfInt[0], paramArrayOfInt[1]);
/*      */     case 4:
/* 4655 */       return this.machine.instructionSet.AND16(paramArrayOfInt[0], paramArrayOfInt[1]);
/*      */     case 5:
/* 4658 */       return this.machine.instructionSet.SUB16(paramArrayOfInt[0], paramArrayOfInt[1]);
/*      */     case 6:
/* 4661 */       return this.machine.instructionSet.XOR16(paramArrayOfInt[0], paramArrayOfInt[1]);
/*      */     case 7:
/* 4664 */       return this.machine.instructionSet.CMP16(paramArrayOfInt[0], paramArrayOfInt[1]);
/*      */     }
/*      */ 
/* 4667 */     return new StopPoint(0, "");
/*      */   }
/*      */ 
/*      */   public StopPoint jump82(int[] paramArrayOfInt1, int[][] paramArrayOfInt, int[] paramArrayOfInt2)
/*      */   {
/* 4689 */     paramArrayOfInt2[0] = 1;
/* 4690 */     paramArrayOfInt2[1] = 1;
/* 4691 */     paramArrayOfInt2[2] = 0;
/*      */ 
/* 4694 */     this.stopPoint = this.machine.addressModeDecoder.decode(paramArrayOfInt1, paramArrayOfInt, paramArrayOfInt2);
/*      */ 
/* 4696 */     if (this.stopPoint != null) return this.stopPoint;
/*      */ 
/* 4704 */     paramArrayOfInt[2][0] += 1;
/*      */ 
/* 4710 */     paramArrayOfInt[1][3] = 3;
/*      */ 
/* 4713 */     paramArrayOfInt[1][0] = paramArrayOfInt1[paramArrayOfInt[2][0]];
/*      */ 
/* 4719 */     paramArrayOfInt[2][0] += 1;
/*      */ 
/* 4729 */     int i = (byte)((paramArrayOfInt1[1] & 0x38) >> 3);
/* 4730 */     switch (i) {
/*      */     case 0:
/* 4732 */       return this.machine.instructionSet.ADD8(paramArrayOfInt[0], paramArrayOfInt[1]);
/*      */     case 2:
/* 4735 */       return this.machine.instructionSet.ADC8(paramArrayOfInt[0], paramArrayOfInt[1]);
/*      */     case 3:
/* 4738 */       return this.machine.instructionSet.SBB8(paramArrayOfInt[0], paramArrayOfInt[1]);
/*      */     case 1:
/*      */     case 4:
/*      */     case 6:
/* 4743 */       return new StopPoint(1, "Bad REG Field of '82' Instruction:  Value: " + i);
/*      */     case 5:
/* 4746 */       return this.machine.instructionSet.SUB8(paramArrayOfInt[0], paramArrayOfInt[1]);
/*      */     case 7:
/* 4749 */       return this.machine.instructionSet.CMP8(paramArrayOfInt[0], paramArrayOfInt[1]);
/*      */     }
/*      */ 
/* 4752 */     return new StopPoint(0, "");
/*      */   }
/*      */ 
/*      */   public StopPoint jump83(int[] paramArrayOfInt1, int[][] paramArrayOfInt, int[] paramArrayOfInt2)
/*      */   {
/* 4774 */     paramArrayOfInt2[0] = 1;
/* 4775 */     paramArrayOfInt2[1] = 2;
/* 4776 */     paramArrayOfInt2[2] = 0;
/*      */ 
/* 4779 */     this.stopPoint = this.machine.addressModeDecoder.decode(paramArrayOfInt1, paramArrayOfInt, paramArrayOfInt2);
/*      */ 
/* 4781 */     if (this.stopPoint != null) return this.stopPoint;
/*      */ 
/* 4789 */     paramArrayOfInt[2][0] += 1;
/*      */ 
/* 4795 */     paramArrayOfInt[1][3] = 3;
/*      */ 
/* 4798 */     paramArrayOfInt[1][0] = paramArrayOfInt1[paramArrayOfInt[2][0]];
/* 4799 */     if (paramArrayOfInt[1][0] > 127) {
/* 4800 */       paramArrayOfInt[1][0] += 65280;
/*      */     }
/*      */ 
/* 4807 */     paramArrayOfInt[2][0] += 1;
/*      */ 
/* 4817 */     int i = (byte)((paramArrayOfInt1[1] & 0x38) >> 3);
/* 4818 */     switch (i) {
/*      */     case 0:
/* 4820 */       return this.machine.instructionSet.ADD16(paramArrayOfInt[0], paramArrayOfInt[1]);
/*      */     case 2:
/* 4823 */       return this.machine.instructionSet.ADC16(paramArrayOfInt[0], paramArrayOfInt[1]);
/*      */     case 3:
/* 4826 */       return this.machine.instructionSet.SBB16(paramArrayOfInt[0], paramArrayOfInt[1]);
/*      */     case 1:
/*      */     case 4:
/*      */     case 6:
/* 4831 */       return new StopPoint(1, "Bad REG Field of '83' Instruction:  Value: " + i);
/*      */     case 5:
/* 4834 */       return this.machine.instructionSet.SUB16(paramArrayOfInt[0], paramArrayOfInt[1]);
/*      */     case 7:
/* 4837 */       return this.machine.instructionSet.CMP16(paramArrayOfInt[0], paramArrayOfInt[1]);
/*      */     }
/*      */ 
/* 4840 */     return new StopPoint(0, "");
/*      */   }
/*      */ 
/*      */   public StopPoint jump84(int[] paramArrayOfInt1, int[][] paramArrayOfInt, int[] paramArrayOfInt2)
/*      */   {
/* 4860 */     paramArrayOfInt2[0] = 1;
/* 4861 */     paramArrayOfInt2[1] = 1;
/* 4862 */     paramArrayOfInt2[2] = 0;
/*      */ 
/* 4865 */     this.stopPoint = this.machine.addressModeDecoder.decode(paramArrayOfInt1, paramArrayOfInt, paramArrayOfInt2);
/*      */ 
/* 4867 */     if (this.stopPoint != null) return this.stopPoint;
/*      */ 
/* 4875 */     paramArrayOfInt[2][0] += 1;
/*      */ 
/* 4885 */     return this.machine.instructionSet.TEST8(paramArrayOfInt[0], paramArrayOfInt[1]);
/*      */   }
/*      */ 
/*      */   public StopPoint jump85(int[] paramArrayOfInt1, int[][] paramArrayOfInt, int[] paramArrayOfInt2)
/*      */   {
/* 4903 */     paramArrayOfInt2[0] = 1;
/* 4904 */     paramArrayOfInt2[1] = 2;
/* 4905 */     paramArrayOfInt2[2] = 0;
/*      */ 
/* 4908 */     this.stopPoint = this.machine.addressModeDecoder.decode(paramArrayOfInt1, paramArrayOfInt, paramArrayOfInt2);
/*      */ 
/* 4910 */     if (this.stopPoint != null) return this.stopPoint;
/*      */ 
/* 4919 */     paramArrayOfInt[2][0] += 1;
/*      */ 
/* 4929 */     return this.machine.instructionSet.TEST16(paramArrayOfInt[0], paramArrayOfInt[1]);
/*      */   }
/*      */ 
/*      */   public StopPoint jump86(int[] paramArrayOfInt1, int[][] paramArrayOfInt, int[] paramArrayOfInt2)
/*      */   {
/* 4947 */     paramArrayOfInt2[0] = 1;
/* 4948 */     paramArrayOfInt2[1] = 1;
/* 4949 */     paramArrayOfInt2[2] = 0;
/*      */ 
/* 4952 */     this.stopPoint = this.machine.addressModeDecoder.decode(paramArrayOfInt1, paramArrayOfInt, paramArrayOfInt2);
/*      */ 
/* 4954 */     if (this.stopPoint != null) return this.stopPoint;
/*      */ 
/* 4962 */     paramArrayOfInt[2][0] += 1;
/*      */ 
/* 4972 */     return this.machine.instructionSet.XCHG8(paramArrayOfInt[0], paramArrayOfInt[1]);
/*      */   }
/*      */ 
/*      */   public StopPoint jump87(int[] paramArrayOfInt1, int[][] paramArrayOfInt, int[] paramArrayOfInt2)
/*      */   {
/* 4990 */     paramArrayOfInt2[0] = 1;
/* 4991 */     paramArrayOfInt2[1] = 2;
/* 4992 */     paramArrayOfInt2[2] = 0;
/*      */ 
/* 4995 */     this.stopPoint = this.machine.addressModeDecoder.decode(paramArrayOfInt1, paramArrayOfInt, paramArrayOfInt2);
/*      */ 
/* 4997 */     if (this.stopPoint != null) return this.stopPoint;
/*      */ 
/* 5006 */     paramArrayOfInt[2][0] += 1;
/*      */ 
/* 5016 */     return this.machine.instructionSet.XCHG16(paramArrayOfInt[0], paramArrayOfInt[1]);
/*      */   }
/*      */ 
/*      */   public StopPoint jump88(int[] paramArrayOfInt1, int[][] paramArrayOfInt, int[] paramArrayOfInt2)
/*      */   {
/* 5034 */     paramArrayOfInt2[0] = 1;
/* 5035 */     paramArrayOfInt2[1] = 1;
/* 5036 */     paramArrayOfInt2[2] = 0;
/*      */ 
/* 5039 */     this.stopPoint = this.machine.addressModeDecoder.decode(paramArrayOfInt1, paramArrayOfInt, paramArrayOfInt2);
/*      */ 
/* 5041 */     if (this.stopPoint != null) return this.stopPoint;
/*      */ 
/* 5049 */     paramArrayOfInt[2][0] += 1;
/*      */ 
/* 5059 */     return this.machine.instructionSet.MOV8(paramArrayOfInt[0], paramArrayOfInt[1]);
/*      */   }
/*      */ 
/*      */   public StopPoint jump89(int[] paramArrayOfInt1, int[][] paramArrayOfInt, int[] paramArrayOfInt2)
/*      */   {
/* 5077 */     paramArrayOfInt2[0] = 1;
/* 5078 */     paramArrayOfInt2[1] = 2;
/* 5079 */     paramArrayOfInt2[2] = 0;
/*      */ 
/* 5082 */     this.stopPoint = this.machine.addressModeDecoder.decode(paramArrayOfInt1, paramArrayOfInt, paramArrayOfInt2);
/*      */ 
/* 5084 */     if (this.stopPoint != null) return this.stopPoint;
/*      */ 
/* 5092 */     paramArrayOfInt[2][0] += 1;
/*      */ 
/* 5102 */     return this.machine.instructionSet.MOV16(paramArrayOfInt[0], paramArrayOfInt[1]);
/*      */   }
/*      */ 
/*      */   public StopPoint jump8A(int[] paramArrayOfInt1, int[][] paramArrayOfInt, int[] paramArrayOfInt2)
/*      */   {
/* 5120 */     paramArrayOfInt2[0] = 1;
/* 5121 */     paramArrayOfInt2[1] = 1;
/* 5122 */     paramArrayOfInt2[2] = 1;
/*      */ 
/* 5125 */     this.stopPoint = this.machine.addressModeDecoder.decode(paramArrayOfInt1, paramArrayOfInt, paramArrayOfInt2);
/*      */ 
/* 5127 */     if (this.stopPoint != null) return this.stopPoint;
/*      */ 
/* 5135 */     paramArrayOfInt[2][0] += 1;
/*      */ 
/* 5145 */     return this.machine.instructionSet.MOV8(paramArrayOfInt[0], paramArrayOfInt[1]);
/*      */   }
/*      */ 
/*      */   public StopPoint jump8B(int[] paramArrayOfInt1, int[][] paramArrayOfInt, int[] paramArrayOfInt2)
/*      */   {
/* 5163 */     paramArrayOfInt2[0] = 1;
/* 5164 */     paramArrayOfInt2[1] = 2;
/* 5165 */     paramArrayOfInt2[2] = 1;
/*      */ 
/* 5168 */     this.stopPoint = this.machine.addressModeDecoder.decode(paramArrayOfInt1, paramArrayOfInt, paramArrayOfInt2);
/*      */ 
/* 5170 */     if (this.stopPoint != null) return this.stopPoint;
/*      */ 
/* 5178 */     paramArrayOfInt[2][0] += 1;
/*      */ 
/* 5188 */     return this.machine.instructionSet.MOV16(paramArrayOfInt[0], paramArrayOfInt[1]);
/*      */   }
/*      */ 
/*      */   public StopPoint jump8C(int[] paramArrayOfInt1, int[][] paramArrayOfInt, int[] paramArrayOfInt2)
/*      */   {
/* 5206 */     paramArrayOfInt2[0] = 2;
/* 5207 */     paramArrayOfInt2[1] = 2;
/* 5208 */     paramArrayOfInt2[2] = 0;
/*      */ 
/* 5211 */     this.stopPoint = this.machine.addressModeDecoder.decode(paramArrayOfInt1, paramArrayOfInt, paramArrayOfInt2);
/*      */ 
/* 5213 */     if (this.stopPoint != null) return this.stopPoint;
/*      */ 
/* 5221 */     paramArrayOfInt[2][0] += 1;
/*      */ 
/* 5231 */     if ((paramArrayOfInt1[1] & 0x10) == 0) {
/* 5232 */       return this.machine.instructionSet.MOV16(paramArrayOfInt[0], paramArrayOfInt[1]);
/*      */     }
/* 5234 */     int i = (byte)((paramArrayOfInt1[1] & 0x38) >> 3);
/* 5235 */     return new StopPoint(1, "Bad REG Field of '8C' Instruction:  Value: " + i);
/*      */   }
/*      */ 
/*      */   public StopPoint jump8D(int[] paramArrayOfInt1, int[][] paramArrayOfInt, int[] paramArrayOfInt2)
/*      */   {
/* 5254 */     paramArrayOfInt2[0] = 1;
/* 5255 */     paramArrayOfInt2[1] = 2;
/* 5256 */     paramArrayOfInt2[2] = 1;
/*      */ 
/* 5259 */     this.stopPoint = this.machine.addressModeDecoder.decode(paramArrayOfInt1, paramArrayOfInt, paramArrayOfInt2);
/*      */ 
/* 5261 */     if (this.stopPoint != null) return this.stopPoint;
/*      */ 
/* 5269 */     paramArrayOfInt[2][0] += 1;
/*      */ 
/* 5279 */     if (paramArrayOfInt[1][3] == 2) {
/* 5280 */       paramArrayOfInt[1][3] = 3;
/*      */     }
/*      */ 
/* 5289 */     return this.machine.instructionSet.MOV16(paramArrayOfInt[0], paramArrayOfInt[1]);
/*      */   }
/*      */ 
/*      */   public StopPoint jump8E(int[] paramArrayOfInt1, int[][] paramArrayOfInt, int[] paramArrayOfInt2)
/*      */   {
/* 5307 */     paramArrayOfInt2[0] = 2;
/* 5308 */     paramArrayOfInt2[1] = 2;
/* 5309 */     paramArrayOfInt2[2] = 1;
/*      */ 
/* 5312 */     this.stopPoint = this.machine.addressModeDecoder.decode(paramArrayOfInt1, paramArrayOfInt, paramArrayOfInt2);
/*      */ 
/* 5314 */     if (this.stopPoint != null) return this.stopPoint;
/*      */ 
/* 5322 */     paramArrayOfInt[2][0] += 1;
/*      */ 
/* 5332 */     this.stopPoint = this.machine.instructionSet.MOV16(paramArrayOfInt[0], paramArrayOfInt[1]);
/* 5333 */     if (this.stopPoint != null) return this.stopPoint;
/* 5334 */     if ((paramArrayOfInt1[1] & 0x10) == 0) {
/* 5335 */       return this.machine.instructionSet.MOV16(paramArrayOfInt[0], paramArrayOfInt[1]);
/*      */     }
/* 5337 */     int i = (byte)((paramArrayOfInt1[1] & 0x38) >> 3);
/* 5338 */     return new StopPoint(1, "Bad REG Field of '8E' Instruction:  Value: " + i);
/*      */   }
/*      */ 
/*      */   public StopPoint jump8F(int[] paramArrayOfInt1, int[][] paramArrayOfInt, int[] paramArrayOfInt2)
/*      */   {
/* 5357 */     paramArrayOfInt2[0] = 1;
/* 5358 */     paramArrayOfInt2[1] = 2;
/* 5359 */     paramArrayOfInt2[2] = 0;
/*      */ 
/* 5362 */     this.stopPoint = this.machine.addressModeDecoder.decode(paramArrayOfInt1, paramArrayOfInt, paramArrayOfInt2);
/*      */ 
/* 5364 */     if (this.stopPoint != null) return this.stopPoint;
/*      */ 
/* 5372 */     paramArrayOfInt[2][0] += 1;
/*      */ 
/* 5382 */     if (paramArrayOfInt[1][2] == 0) {
/* 5383 */       return this.machine.instructionSet.POP(paramArrayOfInt[0]);
/*      */     }
/* 5385 */     return new StopPoint(1, "Bad REG Field of '8F' Instruction:  Value :" + paramArrayOfInt1[0]);
/*      */   }
/*      */ 
/*      */   public StopPoint jump90(int[] paramArrayOfInt1, int[][] paramArrayOfInt, int[] paramArrayOfInt2)
/*      */   {
/* 5398 */     return null;
/*      */   }
/*      */ 
/*      */   public StopPoint jump91(int[] paramArrayOfInt1, int[][] paramArrayOfInt, int[] paramArrayOfInt2)
/*      */   {
/* 5416 */     paramArrayOfInt[0][2] = 0;
/* 5417 */     paramArrayOfInt[0][3] = 1;
/* 5418 */     paramArrayOfInt[1][2] = 2;
/* 5419 */     paramArrayOfInt[1][3] = 1;
/*      */ 
/* 5429 */     return this.machine.instructionSet.XCHG16(paramArrayOfInt[0], paramArrayOfInt[1]);
/*      */   }
/*      */ 
/*      */   public StopPoint jump92(int[] paramArrayOfInt1, int[][] paramArrayOfInt, int[] paramArrayOfInt2)
/*      */   {
/* 5447 */     paramArrayOfInt[0][2] = 0;
/* 5448 */     paramArrayOfInt[0][3] = 1;
/* 5449 */     paramArrayOfInt[1][2] = 3;
/* 5450 */     paramArrayOfInt[1][3] = 1;
/*      */ 
/* 5460 */     return this.machine.instructionSet.XCHG16(paramArrayOfInt[0], paramArrayOfInt[1]);
/*      */   }
/*      */ 
/*      */   public StopPoint jump93(int[] paramArrayOfInt1, int[][] paramArrayOfInt, int[] paramArrayOfInt2)
/*      */   {
/* 5478 */     paramArrayOfInt[0][2] = 0;
/* 5479 */     paramArrayOfInt[0][3] = 1;
/* 5480 */     paramArrayOfInt[1][2] = 1;
/* 5481 */     paramArrayOfInt[1][3] = 1;
/*      */ 
/* 5491 */     return this.machine.instructionSet.XCHG16(paramArrayOfInt[0], paramArrayOfInt[1]);
/*      */   }
/*      */ 
/*      */   public StopPoint jump94(int[] paramArrayOfInt1, int[][] paramArrayOfInt, int[] paramArrayOfInt2)
/*      */   {
/* 5509 */     paramArrayOfInt[0][2] = 0;
/* 5510 */     paramArrayOfInt[0][3] = 1;
/* 5511 */     paramArrayOfInt[1][2] = 9;
/* 5512 */     paramArrayOfInt[1][3] = 1;
/*      */ 
/* 5522 */     return this.machine.instructionSet.XCHG16(paramArrayOfInt[0], paramArrayOfInt[1]);
/*      */   }
/*      */ 
/*      */   public StopPoint jump95(int[] paramArrayOfInt1, int[][] paramArrayOfInt, int[] paramArrayOfInt2)
/*      */   {
/* 5540 */     paramArrayOfInt[0][2] = 0;
/* 5541 */     paramArrayOfInt[0][3] = 1;
/* 5542 */     paramArrayOfInt[1][2] = 10;
/* 5543 */     paramArrayOfInt[1][3] = 1;
/*      */ 
/* 5553 */     return this.machine.instructionSet.XCHG16(paramArrayOfInt[0], paramArrayOfInt[1]);
/*      */   }
/*      */ 
/*      */   public StopPoint jump96(int[] paramArrayOfInt1, int[][] paramArrayOfInt, int[] paramArrayOfInt2)
/*      */   {
/* 5571 */     paramArrayOfInt[0][2] = 0;
/* 5572 */     paramArrayOfInt[0][3] = 1;
/* 5573 */     paramArrayOfInt[1][2] = 11;
/* 5574 */     paramArrayOfInt[1][3] = 1;
/*      */ 
/* 5584 */     return this.machine.instructionSet.XCHG16(paramArrayOfInt[0], paramArrayOfInt[1]);
/*      */   }
/*      */ 
/*      */   public StopPoint jump97(int[] paramArrayOfInt1, int[][] paramArrayOfInt, int[] paramArrayOfInt2)
/*      */   {
/* 5602 */     paramArrayOfInt[0][2] = 0;
/* 5603 */     paramArrayOfInt[0][3] = 1;
/* 5604 */     paramArrayOfInt[1][2] = 12;
/* 5605 */     paramArrayOfInt[1][3] = 1;
/*      */ 
/* 5615 */     return this.machine.instructionSet.XCHG16(paramArrayOfInt[0], paramArrayOfInt[1]);
/*      */   }
/*      */ 
/*      */   public StopPoint jump98(int[] paramArrayOfInt1, int[][] paramArrayOfInt, int[] paramArrayOfInt2)
/*      */   {
/* 5639 */     if (this.machine.getRegister(20) <= 127)
/* 5640 */       this.machine.setRegisterAndNotify(0, 30);
/*      */     else {
/* 5642 */       this.machine.setRegisterAndNotify(255, 30);
/*      */     }
/* 5644 */     return null;
/*      */   }
/*      */ 
/*      */   public StopPoint jump99(int[] paramArrayOfInt1, int[][] paramArrayOfInt, int[] paramArrayOfInt2)
/*      */   {
/* 5668 */     if (this.machine.getRegister(0) <= 32767)
/* 5669 */       this.machine.setRegisterAndNotify(0, 3);
/*      */     else {
/* 5671 */       this.machine.setRegisterAndNotify(65535, 3);
/*      */     }
/* 5673 */     return null;
/*      */   }
/*      */ 
/*      */   public StopPoint jump9A(int[] paramArrayOfInt1, int[][] paramArrayOfInt, int[] paramArrayOfInt2)
/*      */   {
/* 5690 */     paramArrayOfInt[2][0] += 4;
/*      */ 
/* 5696 */     this.machine.incIPAndNotify(paramArrayOfInt[2][0]);
/* 5697 */     paramArrayOfInt[2][0] = 0;
/*      */ 
/* 5704 */     paramArrayOfInt[0][3] = 1;
/* 5705 */     paramArrayOfInt[0][2] = 4;
/* 5706 */     this.stopPoint = this.machine.instructionSet.PUSH(paramArrayOfInt[0]);
/* 5707 */     if (this.stopPoint != null) return this.stopPoint;
/*      */ 
/* 5711 */     paramArrayOfInt[0][2] = 8;
/* 5712 */     this.stopPoint = this.machine.instructionSet.PUSH(paramArrayOfInt[0]);
/* 5713 */     if (this.stopPoint != null) return this.stopPoint;
/*      */ 
/* 5719 */     this.machine.setRegisterAndNotify((paramArrayOfInt1[2] << 8) + paramArrayOfInt1[1], 8);
/* 5720 */     this.machine.setRegisterAndNotify((paramArrayOfInt1[4] << 8) + paramArrayOfInt1[3], 4);
/*      */ 
/* 5722 */     return null;
/*      */   }
/*      */ 
/*      */   public StopPoint jump9C(int[] paramArrayOfInt1, int[][] paramArrayOfInt, int[] paramArrayOfInt2)
/*      */   {
/* 5746 */     paramArrayOfInt[1][2] = 13;
/* 5747 */     paramArrayOfInt[1][3] = 1;
/*      */ 
/* 5758 */     return this.machine.instructionSet.PUSH(paramArrayOfInt[1]);
/*      */   }
/*      */ 
/*      */   public StopPoint jump9D(int[] paramArrayOfInt1, int[][] paramArrayOfInt, int[] paramArrayOfInt2)
/*      */   {
/* 5782 */     paramArrayOfInt[0][2] = 13;
/* 5783 */     paramArrayOfInt[0][3] = 1;
/*      */ 
/* 5794 */     return this.machine.instructionSet.POP(paramArrayOfInt[0]);
/*      */   }
/*      */ 
/*      */   public StopPoint jump9E(int[] paramArrayOfInt1, int[][] paramArrayOfInt, int[] paramArrayOfInt2)
/*      */   {
/* 5817 */     this.machine.setRegisterAndNotify((this.machine.getRegister(13) & 0xFF00) + 
/* 5818 */       this.machine.getRegister(30), 13);
/*      */ 
/* 5822 */     return null;
/*      */   }
/*      */ 
/*      */   public StopPoint jump9F(int[] paramArrayOfInt1, int[][] paramArrayOfInt, int[] paramArrayOfInt2)
/*      */   {
/* 5845 */     this.machine.setRegisterAndNotify(this.machine.getRegister(13) & 0xFF, 30);
/*      */ 
/* 5849 */     return null;
/*      */   }
/*      */ 
/*      */   public StopPoint jumpA0(int[] paramArrayOfInt1, int[][] paramArrayOfInt, int[] paramArrayOfInt2)
/*      */   {
/* 5867 */     paramArrayOfInt[2][0] += 2;
/*      */ 
/* 5873 */     paramArrayOfInt[0][2] = 20;
/* 5874 */     paramArrayOfInt[0][3] = 1;
/* 5875 */     paramArrayOfInt[1][3] = 2;
/* 5876 */     paramArrayOfInt[1][0] = ((paramArrayOfInt1[2] << 8) + paramArrayOfInt1[1]);
/*      */ 
/* 5878 */     if (!this.machine.segmentOverride) {
/* 5879 */       paramArrayOfInt[1][1] = this.machine.getRegister(5);
/*      */     }
/*      */ 
/* 5889 */     return this.machine.instructionSet.MOV8(paramArrayOfInt[0], paramArrayOfInt[1]);
/*      */   }
/*      */ 
/*      */   public StopPoint jumpA1(int[] paramArrayOfInt1, int[][] paramArrayOfInt, int[] paramArrayOfInt2)
/*      */   {
/* 5907 */     paramArrayOfInt[2][0] += 2;
/*      */ 
/* 5913 */     paramArrayOfInt[0][2] = 0;
/* 5914 */     paramArrayOfInt[0][3] = 1;
/* 5915 */     paramArrayOfInt[1][3] = 2;
/* 5916 */     paramArrayOfInt[1][0] = ((paramArrayOfInt1[2] << 8) + paramArrayOfInt1[1]);
/*      */ 
/* 5918 */     if (!this.machine.segmentOverride) {
/* 5919 */       paramArrayOfInt[1][1] = this.machine.getRegister(5);
/*      */     }
/*      */ 
/* 5929 */     return this.machine.instructionSet.MOV16(paramArrayOfInt[0], paramArrayOfInt[1]);
/*      */   }
/*      */ 
/*      */   public StopPoint jumpA2(int[] paramArrayOfInt1, int[][] paramArrayOfInt, int[] paramArrayOfInt2)
/*      */   {
/* 5947 */     paramArrayOfInt[2][0] += 2;
/*      */ 
/* 5953 */     paramArrayOfInt[0][3] = 2;
/* 5954 */     paramArrayOfInt[0][0] = ((paramArrayOfInt1[2] << 8) + paramArrayOfInt1[1]);
/*      */ 
/* 5956 */     if (!this.machine.segmentOverride)
/* 5957 */       paramArrayOfInt[0][1] = this.machine.getRegister(5);
/* 5958 */     paramArrayOfInt[1][2] = 20;
/* 5959 */     paramArrayOfInt[1][3] = 1;
/*      */ 
/* 5969 */     return this.machine.instructionSet.MOV8(paramArrayOfInt[0], paramArrayOfInt[1]);
/*      */   }
/*      */ 
/*      */   public StopPoint jumpA3(int[] paramArrayOfInt1, int[][] paramArrayOfInt, int[] paramArrayOfInt2)
/*      */   {
/* 5987 */     paramArrayOfInt[2][0] += 2;
/*      */ 
/* 5993 */     paramArrayOfInt[0][3] = 2;
/* 5994 */     paramArrayOfInt[0][0] = ((paramArrayOfInt1[2] << 8) + paramArrayOfInt1[1]);
/*      */ 
/* 5996 */     if (!this.machine.segmentOverride)
/* 5997 */       paramArrayOfInt[0][1] = this.machine.getRegister(5);
/* 5998 */     paramArrayOfInt[1][2] = 0;
/* 5999 */     paramArrayOfInt[1][3] = 1;
/*      */ 
/* 6009 */     return this.machine.instructionSet.MOV16(paramArrayOfInt[0], paramArrayOfInt[1]);
/*      */   }
/*      */ 
/*      */   public StopPoint jumpA4(int[] paramArrayOfInt1, int[][] paramArrayOfInt, int[] paramArrayOfInt2)
/*      */   {
/* 6034 */     return this.machine.instructionSet.MOVS8(paramArrayOfInt[0], paramArrayOfInt[1]);
/*      */   }
/*      */ 
/*      */   public StopPoint jumpA5(int[] paramArrayOfInt1, int[][] paramArrayOfInt, int[] paramArrayOfInt2)
/*      */   {
/* 6059 */     return this.machine.instructionSet.MOVS16(paramArrayOfInt[0], paramArrayOfInt[1]);
/*      */   }
/*      */ 
/*      */   public StopPoint jumpA6(int[] paramArrayOfInt1, int[][] paramArrayOfInt, int[] paramArrayOfInt2)
/*      */   {
/* 6084 */     return this.machine.instructionSet.CMPS8(paramArrayOfInt[0], paramArrayOfInt[1]);
/*      */   }
/*      */ 
/*      */   public StopPoint jumpA7(int[] paramArrayOfInt1, int[][] paramArrayOfInt, int[] paramArrayOfInt2)
/*      */   {
/* 6109 */     return this.machine.instructionSet.CMPS16(paramArrayOfInt[0], paramArrayOfInt[1]);
/*      */   }
/*      */ 
/*      */   public StopPoint jumpA8(int[] paramArrayOfInt1, int[][] paramArrayOfInt, int[] paramArrayOfInt2)
/*      */   {
/* 6127 */     paramArrayOfInt[2][0] += 1;
/*      */ 
/* 6133 */     paramArrayOfInt[0][2] = 20;
/* 6134 */     paramArrayOfInt[0][3] = 1;
/* 6135 */     paramArrayOfInt[1][3] = 3;
/* 6136 */     paramArrayOfInt[1][0] = paramArrayOfInt1[1];
/*      */ 
/* 6146 */     return this.machine.instructionSet.TEST8(paramArrayOfInt[0], paramArrayOfInt[1]);
/*      */   }
/*      */ 
/*      */   public StopPoint jumpA9(int[] paramArrayOfInt1, int[][] paramArrayOfInt, int[] paramArrayOfInt2)
/*      */   {
/* 6164 */     paramArrayOfInt[2][0] += 2;
/*      */ 
/* 6170 */     paramArrayOfInt[0][2] = 0;
/* 6171 */     paramArrayOfInt[0][3] = 1;
/* 6172 */     paramArrayOfInt[1][3] = 3;
/* 6173 */     paramArrayOfInt[1][0] = 
/* 6174 */       ((paramArrayOfInt1[2] << 8) + paramArrayOfInt1[1]);
/*      */ 
/* 6184 */     return this.machine.instructionSet.TEST16(paramArrayOfInt[0], paramArrayOfInt[1]);
/*      */   }
/*      */ 
/*      */   public StopPoint jumpAA(int[] paramArrayOfInt1, int[][] paramArrayOfInt, int[] paramArrayOfInt2)
/*      */   {
/* 6209 */     return this.machine.instructionSet.STOS8(paramArrayOfInt[0], paramArrayOfInt[1]);
/*      */   }
/*      */ 
/*      */   public StopPoint jumpAB(int[] paramArrayOfInt1, int[][] paramArrayOfInt, int[] paramArrayOfInt2)
/*      */   {
/* 6234 */     return this.machine.instructionSet.STOS16(paramArrayOfInt[0], paramArrayOfInt[1]);
/*      */   }
/*      */ 
/*      */   public StopPoint jumpAC(int[] paramArrayOfInt1, int[][] paramArrayOfInt, int[] paramArrayOfInt2)
/*      */   {
/* 6259 */     return this.machine.instructionSet.LODS8(paramArrayOfInt[0], paramArrayOfInt[1]);
/*      */   }
/*      */ 
/*      */   public StopPoint jumpAD(int[] paramArrayOfInt1, int[][] paramArrayOfInt, int[] paramArrayOfInt2)
/*      */   {
/* 6284 */     return this.machine.instructionSet.LODS16(paramArrayOfInt[0], paramArrayOfInt[1]);
/*      */   }
/*      */ 
/*      */   public StopPoint jumpAE(int[] paramArrayOfInt1, int[][] paramArrayOfInt, int[] paramArrayOfInt2)
/*      */   {
/* 6309 */     return this.machine.instructionSet.SCAS8(paramArrayOfInt[0], paramArrayOfInt[1]);
/*      */   }
/*      */ 
/*      */   public StopPoint jumpAF(int[] paramArrayOfInt1, int[][] paramArrayOfInt, int[] paramArrayOfInt2)
/*      */   {
/* 6334 */     return this.machine.instructionSet.SCAS16(paramArrayOfInt[0], paramArrayOfInt[1]);
/*      */   }
/*      */ 
/*      */   public StopPoint jumpB0(int[] paramArrayOfInt1, int[][] paramArrayOfInt, int[] paramArrayOfInt2)
/*      */   {
/* 6352 */     paramArrayOfInt[2][0] += 1;
/*      */ 
/* 6358 */     paramArrayOfInt[0][2] = 20;
/* 6359 */     paramArrayOfInt[0][3] = 1;
/* 6360 */     paramArrayOfInt[1][3] = 3;
/*      */ 
/* 6362 */     paramArrayOfInt[1][0] = paramArrayOfInt1[1];
/*      */ 
/* 6372 */     return this.machine.instructionSet.MOV8(paramArrayOfInt[0], paramArrayOfInt[1]);
/*      */   }
/*      */ 
/*      */   public StopPoint jumpB1(int[] paramArrayOfInt1, int[][] paramArrayOfInt, int[] paramArrayOfInt2)
/*      */   {
/* 6390 */     paramArrayOfInt[2][0] += 1;
/*      */ 
/* 6396 */     paramArrayOfInt[0][2] = 22;
/* 6397 */     paramArrayOfInt[0][3] = 1;
/* 6398 */     paramArrayOfInt[1][3] = 3;
/*      */ 
/* 6400 */     paramArrayOfInt[1][0] = paramArrayOfInt1[1];
/*      */ 
/* 6410 */     return this.machine.instructionSet.MOV8(paramArrayOfInt[0], paramArrayOfInt[1]);
/*      */   }
/*      */ 
/*      */   public StopPoint jumpB2(int[] paramArrayOfInt1, int[][] paramArrayOfInt, int[] paramArrayOfInt2)
/*      */   {
/* 6428 */     paramArrayOfInt[2][0] += 1;
/*      */ 
/* 6434 */     paramArrayOfInt[0][2] = 23;
/* 6435 */     paramArrayOfInt[0][3] = 1;
/* 6436 */     paramArrayOfInt[1][3] = 3;
/*      */ 
/* 6438 */     paramArrayOfInt[1][0] = paramArrayOfInt1[1];
/*      */ 
/* 6448 */     return this.machine.instructionSet.MOV8(paramArrayOfInt[0], paramArrayOfInt[1]);
/*      */   }
/*      */ 
/*      */   public StopPoint jumpB3(int[] paramArrayOfInt1, int[][] paramArrayOfInt, int[] paramArrayOfInt2)
/*      */   {
/* 6466 */     paramArrayOfInt[2][0] += 1;
/*      */ 
/* 6472 */     paramArrayOfInt[0][2] = 21;
/* 6473 */     paramArrayOfInt[0][3] = 1;
/* 6474 */     paramArrayOfInt[1][3] = 3;
/*      */ 
/* 6476 */     paramArrayOfInt[1][0] = paramArrayOfInt1[1];
/*      */ 
/* 6486 */     return this.machine.instructionSet.MOV8(paramArrayOfInt[0], paramArrayOfInt[1]);
/*      */   }
/*      */ 
/*      */   public StopPoint jumpB4(int[] paramArrayOfInt1, int[][] paramArrayOfInt, int[] paramArrayOfInt2)
/*      */   {
/* 6504 */     paramArrayOfInt[2][0] += 1;
/*      */ 
/* 6510 */     paramArrayOfInt[0][2] = 30;
/* 6511 */     paramArrayOfInt[0][3] = 1;
/* 6512 */     paramArrayOfInt[1][3] = 3;
/*      */ 
/* 6514 */     paramArrayOfInt[1][0] = paramArrayOfInt1[1];
/*      */ 
/* 6524 */     return this.machine.instructionSet.MOV8(paramArrayOfInt[0], paramArrayOfInt[1]);
/*      */   }
/*      */ 
/*      */   public StopPoint jumpB5(int[] paramArrayOfInt1, int[][] paramArrayOfInt, int[] paramArrayOfInt2)
/*      */   {
/* 6542 */     paramArrayOfInt[2][0] += 1;
/*      */ 
/* 6548 */     paramArrayOfInt[0][2] = 32;
/* 6549 */     paramArrayOfInt[0][3] = 1;
/* 6550 */     paramArrayOfInt[1][3] = 3;
/*      */ 
/* 6552 */     paramArrayOfInt[1][0] = paramArrayOfInt1[1];
/*      */ 
/* 6562 */     return this.machine.instructionSet.MOV8(paramArrayOfInt[0], paramArrayOfInt[1]);
/*      */   }
/*      */ 
/*      */   public StopPoint jumpB6(int[] paramArrayOfInt1, int[][] paramArrayOfInt, int[] paramArrayOfInt2)
/*      */   {
/* 6580 */     paramArrayOfInt[2][0] += 1;
/*      */ 
/* 6586 */     paramArrayOfInt[0][2] = 33;
/* 6587 */     paramArrayOfInt[0][3] = 1;
/* 6588 */     paramArrayOfInt[1][3] = 3;
/*      */ 
/* 6590 */     paramArrayOfInt[1][0] = paramArrayOfInt1[1];
/*      */ 
/* 6600 */     return this.machine.instructionSet.MOV8(paramArrayOfInt[0], paramArrayOfInt[1]);
/*      */   }
/*      */ 
/*      */   public StopPoint jumpB7(int[] paramArrayOfInt1, int[][] paramArrayOfInt, int[] paramArrayOfInt2)
/*      */   {
/* 6618 */     paramArrayOfInt[2][0] += 1;
/*      */ 
/* 6624 */     paramArrayOfInt[0][2] = 31;
/* 6625 */     paramArrayOfInt[0][3] = 1;
/* 6626 */     paramArrayOfInt[1][3] = 3;
/*      */ 
/* 6628 */     paramArrayOfInt[1][0] = paramArrayOfInt1[1];
/*      */ 
/* 6638 */     return this.machine.instructionSet.MOV8(paramArrayOfInt[0], paramArrayOfInt[1]);
/*      */   }
/*      */ 
/*      */   public StopPoint jumpB8(int[] paramArrayOfInt1, int[][] paramArrayOfInt, int[] paramArrayOfInt2)
/*      */   {
/* 6656 */     paramArrayOfInt[2][0] += 2;
/*      */ 
/* 6662 */     paramArrayOfInt[0][2] = 0;
/* 6663 */     paramArrayOfInt[0][3] = 1;
/* 6664 */     paramArrayOfInt[1][3] = 3;
/*      */ 
/* 6666 */     paramArrayOfInt[1][0] = ((paramArrayOfInt1[2] << 8) + paramArrayOfInt1[1]);
/*      */ 
/* 6676 */     return this.machine.instructionSet.MOV16(paramArrayOfInt[0], paramArrayOfInt[1]);
/*      */   }
/*      */ 
/*      */   public StopPoint jumpB9(int[] paramArrayOfInt1, int[][] paramArrayOfInt, int[] paramArrayOfInt2)
/*      */   {
/* 6694 */     paramArrayOfInt[2][0] += 2;
/*      */ 
/* 6700 */     paramArrayOfInt[0][2] = 2;
/* 6701 */     paramArrayOfInt[0][3] = 1;
/* 6702 */     paramArrayOfInt[1][3] = 3;
/*      */ 
/* 6704 */     paramArrayOfInt[1][0] = ((paramArrayOfInt1[2] << 8) + paramArrayOfInt1[1]);
/*      */ 
/* 6714 */     return this.machine.instructionSet.MOV16(paramArrayOfInt[0], paramArrayOfInt[1]);
/*      */   }
/*      */ 
/*      */   public StopPoint jumpBA(int[] paramArrayOfInt1, int[][] paramArrayOfInt, int[] paramArrayOfInt2)
/*      */   {
/* 6732 */     paramArrayOfInt[2][0] += 2;
/*      */ 
/* 6738 */     paramArrayOfInt[0][2] = 3;
/* 6739 */     paramArrayOfInt[0][3] = 1;
/* 6740 */     paramArrayOfInt[1][3] = 3;
/*      */ 
/* 6742 */     paramArrayOfInt[1][0] = ((paramArrayOfInt1[2] << 8) + paramArrayOfInt1[1]);
/*      */ 
/* 6752 */     return this.machine.instructionSet.MOV16(paramArrayOfInt[0], paramArrayOfInt[1]);
/*      */   }
/*      */ 
/*      */   public StopPoint jumpBB(int[] paramArrayOfInt1, int[][] paramArrayOfInt, int[] paramArrayOfInt2)
/*      */   {
/* 6770 */     paramArrayOfInt[2][0] += 2;
/*      */ 
/* 6776 */     paramArrayOfInt[0][2] = 1;
/* 6777 */     paramArrayOfInt[0][3] = 1;
/* 6778 */     paramArrayOfInt[1][3] = 3;
/*      */ 
/* 6780 */     paramArrayOfInt[1][0] = ((paramArrayOfInt1[2] << 8) + paramArrayOfInt1[1]);
/*      */ 
/* 6790 */     return this.machine.instructionSet.MOV16(paramArrayOfInt[0], paramArrayOfInt[1]);
/*      */   }
/*      */ 
/*      */   public StopPoint jumpBC(int[] paramArrayOfInt1, int[][] paramArrayOfInt, int[] paramArrayOfInt2)
/*      */   {
/* 6808 */     paramArrayOfInt[2][0] += 2;
/*      */ 
/* 6814 */     paramArrayOfInt[0][2] = 9;
/* 6815 */     paramArrayOfInt[0][3] = 1;
/* 6816 */     paramArrayOfInt[1][3] = 3;
/*      */ 
/* 6818 */     paramArrayOfInt[1][0] = ((paramArrayOfInt1[2] << 8) + paramArrayOfInt1[1]);
/*      */ 
/* 6828 */     return this.machine.instructionSet.MOV16(paramArrayOfInt[0], paramArrayOfInt[1]);
/*      */   }
/*      */ 
/*      */   public StopPoint jumpBD(int[] paramArrayOfInt1, int[][] paramArrayOfInt, int[] paramArrayOfInt2)
/*      */   {
/* 6846 */     paramArrayOfInt[2][0] += 2;
/*      */ 
/* 6852 */     paramArrayOfInt[0][2] = 10;
/* 6853 */     paramArrayOfInt[0][3] = 1;
/* 6854 */     paramArrayOfInt[1][3] = 3;
/*      */ 
/* 6856 */     paramArrayOfInt[1][0] = ((paramArrayOfInt1[2] << 8) + paramArrayOfInt1[1]);
/*      */ 
/* 6866 */     return this.machine.instructionSet.MOV16(paramArrayOfInt[0], paramArrayOfInt[1]);
/*      */   }
/*      */ 
/*      */   public StopPoint jumpBE(int[] paramArrayOfInt1, int[][] paramArrayOfInt, int[] paramArrayOfInt2)
/*      */   {
/* 6884 */     paramArrayOfInt[2][0] += 2;
/*      */ 
/* 6890 */     paramArrayOfInt[0][2] = 11;
/* 6891 */     paramArrayOfInt[0][3] = 1;
/* 6892 */     paramArrayOfInt[1][3] = 3;
/*      */ 
/* 6894 */     paramArrayOfInt[1][0] = ((paramArrayOfInt1[2] << 8) + paramArrayOfInt1[1]);
/*      */ 
/* 6904 */     return this.machine.instructionSet.MOV16(paramArrayOfInt[0], paramArrayOfInt[1]);
/*      */   }
/*      */ 
/*      */   public StopPoint jumpBF(int[] paramArrayOfInt1, int[][] paramArrayOfInt, int[] paramArrayOfInt2)
/*      */   {
/* 6922 */     paramArrayOfInt[2][0] += 2;
/*      */ 
/* 6928 */     paramArrayOfInt[0][2] = 12;
/* 6929 */     paramArrayOfInt[0][3] = 1;
/* 6930 */     paramArrayOfInt[1][3] = 3;
/*      */ 
/* 6932 */     paramArrayOfInt[1][0] = ((paramArrayOfInt1[2] << 8) + paramArrayOfInt1[1]);
/*      */ 
/* 6942 */     return this.machine.instructionSet.MOV16(paramArrayOfInt[0], paramArrayOfInt[1]);
/*      */   }
/*      */ 
/*      */   public StopPoint jumpC2(int[] paramArrayOfInt1, int[][] paramArrayOfInt, int[] paramArrayOfInt2)
/*      */   {
/* 6960 */     paramArrayOfInt[2][0] = 0;
/*      */ 
/* 6967 */     paramArrayOfInt[0][3] = 1;
/* 6968 */     paramArrayOfInt[0][2] = 8;
/*      */ 
/* 6971 */     this.stopPoint = this.machine.instructionSet.POP(paramArrayOfInt[0]);
/* 6972 */     if (this.stopPoint != null) return this.stopPoint;
/*      */ 
/* 6975 */     this.machine.incSPAndNotify((paramArrayOfInt1[2] << 8) + paramArrayOfInt1[1] & 0xFFFF);
/*      */ 
/* 6977 */     return null;
/*      */   }
/*      */ 
/*      */   public StopPoint jumpC3(int[] paramArrayOfInt1, int[][] paramArrayOfInt, int[] paramArrayOfInt2)
/*      */   {
/* 6995 */     paramArrayOfInt[2][0] = 0;
/*      */ 
/* 7002 */     paramArrayOfInt[0][3] = 1;
/* 7003 */     paramArrayOfInt[0][2] = 8;
/*      */ 
/* 7006 */     return this.machine.instructionSet.POP(paramArrayOfInt[0]);
/*      */   }
/*      */ 
/*      */   public StopPoint jumpC4(int[] paramArrayOfInt1, int[][] paramArrayOfInt, int[] paramArrayOfInt2)
/*      */   {
/* 7024 */     paramArrayOfInt2[0] = 1;
/* 7025 */     paramArrayOfInt2[1] = 2;
/* 7026 */     paramArrayOfInt2[2] = 1;
/*      */ 
/* 7029 */     this.stopPoint = this.machine.addressModeDecoder.decode(paramArrayOfInt1, paramArrayOfInt, paramArrayOfInt2);
/*      */ 
/* 7031 */     if (this.stopPoint != null) return this.stopPoint;
/*      */ 
/* 7039 */     paramArrayOfInt[2][0] += 1;
/*      */ 
/* 7050 */     this.stopPoint = this.machine.instructionSet.MOV16(paramArrayOfInt[0], paramArrayOfInt[1]);
/* 7051 */     if (this.stopPoint != null) return this.stopPoint;
/* 7052 */     paramArrayOfInt[1][0] += 2;
/* 7053 */     paramArrayOfInt[0][2] = 7;
/*      */ 
/* 7055 */     return this.machine.instructionSet.MOV16(paramArrayOfInt[0], paramArrayOfInt[1]);
/*      */   }
/*      */ 
/*      */   public StopPoint jumpC5(int[] paramArrayOfInt1, int[][] paramArrayOfInt, int[] paramArrayOfInt2)
/*      */   {
/* 7073 */     paramArrayOfInt2[0] = 1;
/* 7074 */     paramArrayOfInt2[1] = 2;
/* 7075 */     paramArrayOfInt2[2] = 1;
/*      */ 
/* 7078 */     this.stopPoint = this.machine.addressModeDecoder.decode(paramArrayOfInt1, paramArrayOfInt, paramArrayOfInt2);
/*      */ 
/* 7080 */     if (this.stopPoint != null) return this.stopPoint;
/*      */ 
/* 7088 */     paramArrayOfInt[2][0] += 1;
/*      */ 
/* 7099 */     this.stopPoint = this.machine.instructionSet.MOV16(paramArrayOfInt[0], paramArrayOfInt[1]);
/* 7100 */     if (this.stopPoint != null) return this.stopPoint;
/* 7101 */     paramArrayOfInt[1][0] += 2;
/* 7102 */     paramArrayOfInt[0][2] = 5;
/*      */ 
/* 7104 */     return this.machine.instructionSet.MOV16(paramArrayOfInt[0], paramArrayOfInt[1]);
/*      */   }
/*      */ 
/*      */   public StopPoint jumpC6(int[] paramArrayOfInt1, int[][] paramArrayOfInt, int[] paramArrayOfInt2)
/*      */   {
/* 7122 */     paramArrayOfInt2[0] = 1;
/* 7123 */     paramArrayOfInt2[1] = 1;
/* 7124 */     paramArrayOfInt2[2] = 0;
/*      */ 
/* 7127 */     this.stopPoint = this.machine.addressModeDecoder.decode(paramArrayOfInt1, paramArrayOfInt, paramArrayOfInt2);
/*      */ 
/* 7129 */     if (this.stopPoint != null) return this.stopPoint;
/*      */ 
/* 7137 */     paramArrayOfInt[2][0] += 1;
/*      */ 
/* 7139 */     if (paramArrayOfInt[1][2] == 20)
/*      */     {
/* 7145 */       paramArrayOfInt[1][3] = 3;
/*      */ 
/* 7148 */       paramArrayOfInt[1][0] = paramArrayOfInt1[paramArrayOfInt[2][0]];
/*      */ 
/* 7154 */       paramArrayOfInt[2][0] += 1;
/*      */ 
/* 7164 */       return this.machine.instructionSet.MOV8(paramArrayOfInt[0], paramArrayOfInt[1]);
/*      */     }
/*      */ 
/* 7167 */     return new StopPoint(1, "Bad REG Field of 'C6' Instruction:  Value :" + paramArrayOfInt1[0]);
/*      */   }
/*      */ 
/*      */   public StopPoint jumpC7(int[] paramArrayOfInt1, int[][] paramArrayOfInt, int[] paramArrayOfInt2)
/*      */   {
/* 7187 */     paramArrayOfInt2[0] = 1;
/* 7188 */     paramArrayOfInt2[1] = 2;
/* 7189 */     paramArrayOfInt2[2] = 0;
/*      */ 
/* 7192 */     this.stopPoint = this.machine.addressModeDecoder.decode(paramArrayOfInt1, paramArrayOfInt, paramArrayOfInt2);
/*      */ 
/* 7194 */     if (this.stopPoint != null) return this.stopPoint;
/*      */ 
/* 7202 */     paramArrayOfInt[2][0] += 1;
/*      */ 
/* 7204 */     if (paramArrayOfInt[1][2] == 0)
/*      */     {
/* 7210 */       paramArrayOfInt[1][3] = 3;
/*      */ 
/* 7213 */       paramArrayOfInt[1][0] = 
/* 7215 */         ((paramArrayOfInt1[(paramArrayOfInt[2][0] + 1)] << 8) + 
/* 7215 */         paramArrayOfInt1[paramArrayOfInt[2][0]]);
/*      */ 
/* 7221 */       paramArrayOfInt[2][0] += 2;
/*      */ 
/* 7231 */       return this.machine.instructionSet.MOV16(paramArrayOfInt[0], paramArrayOfInt[1]);
/*      */     }
/*      */ 
/* 7235 */     return new StopPoint(1, "Bad REG Field of 'C7' Instruction:  Value :" + paramArrayOfInt1[0]);
/*      */   }
/*      */ 
/*      */   public StopPoint jumpCA(int[] paramArrayOfInt1, int[][] paramArrayOfInt, int[] paramArrayOfInt2)
/*      */   {
/* 7255 */     paramArrayOfInt[2][0] = 0;
/*      */ 
/* 7262 */     paramArrayOfInt[0][3] = 1;
/* 7263 */     paramArrayOfInt[0][2] = 8;
/*      */ 
/* 7266 */     this.stopPoint = this.machine.instructionSet.POP(paramArrayOfInt[0]);
/* 7267 */     if (this.stopPoint != null) return this.stopPoint;
/*      */ 
/* 7271 */     paramArrayOfInt[0][2] = 4;
/*      */ 
/* 7274 */     this.stopPoint = this.machine.instructionSet.POP(paramArrayOfInt[0]);
/* 7275 */     if (this.stopPoint != null) return this.stopPoint;
/*      */ 
/* 7278 */     this.machine.incSPAndNotify((paramArrayOfInt1[2] << 8) + paramArrayOfInt1[1] & 0xFFFF);
/*      */ 
/* 7280 */     return null;
/*      */   }
/*      */ 
/*      */   public StopPoint jumpCB(int[] paramArrayOfInt1, int[][] paramArrayOfInt, int[] paramArrayOfInt2)
/*      */   {
/* 7298 */     paramArrayOfInt[2][0] = 0;
/*      */ 
/* 7305 */     paramArrayOfInt[0][3] = 1;
/* 7306 */     paramArrayOfInt[0][2] = 8;
/*      */ 
/* 7309 */     this.stopPoint = this.machine.instructionSet.POP(paramArrayOfInt[0]);
/* 7310 */     if (this.stopPoint != null) return this.stopPoint;
/*      */ 
/* 7314 */     paramArrayOfInt[0][2] = 4;
/*      */ 
/* 7317 */     return this.machine.instructionSet.POP(paramArrayOfInt[0]);
/*      */   }
/*      */ 
/*      */   public StopPoint jumpCC(int[] paramArrayOfInt1, int[][] paramArrayOfInt, int[] paramArrayOfInt2)
/*      */   {
/* 7335 */     this.machine.incIPAndNotify(paramArrayOfInt[2][0]);
/* 7336 */     paramArrayOfInt[2][0] = 0;
/*      */ 
/* 7343 */     paramArrayOfInt[1][3] = 1;
/* 7344 */     paramArrayOfInt[1][2] = 13;
/* 7345 */     this.stopPoint = this.machine.instructionSet.PUSH(paramArrayOfInt[1]);
/* 7346 */     if (this.stopPoint != null) return this.stopPoint;
/*      */ 
/* 7350 */     paramArrayOfInt[1][2] = 4;
/* 7351 */     this.stopPoint = this.machine.instructionSet.PUSH(paramArrayOfInt[1]);
/* 7352 */     if (this.stopPoint != null) return this.stopPoint;
/*      */ 
/* 7356 */     paramArrayOfInt[1][2] = 8;
/* 7357 */     this.stopPoint = this.machine.instructionSet.PUSH(paramArrayOfInt[1]);
/* 7358 */     if (this.stopPoint != null) return this.stopPoint;
/*      */ 
/* 7364 */     this.machine.clearFlagAndNotify(9);
/* 7365 */     this.machine.clearFlagAndNotify(8);
/*      */ 
/* 7371 */     paramArrayOfInt[0][1] = 0;
/*      */ 
/* 7373 */     paramArrayOfInt[0][0] = 12;
/*      */ 
/* 7381 */     this.machine.setRegisterAndNotify(this.machine.getMemoryWord(paramArrayOfInt[0]), 8);
/*      */ 
/* 7383 */     paramArrayOfInt[0][0] += 2;
/* 7384 */     this.machine.setRegisterAndNotify(this.machine.getMemoryWord(paramArrayOfInt[0]), 4);
/*      */ 
/* 7386 */     return null;
/*      */   }
/*      */ 
/*      */   public StopPoint jumpCD(int[] paramArrayOfInt1, int[][] paramArrayOfInt, int[] paramArrayOfInt2)
/*      */   {
/* 7403 */     paramArrayOfInt[2][0] += 1;
/* 7404 */     this.machine.incIPAndNotify(paramArrayOfInt[2][0]);
/* 7405 */     paramArrayOfInt[2][0] = 0;
/*      */ 
/* 7412 */     paramArrayOfInt[1][3] = 1;
/* 7413 */     paramArrayOfInt[1][2] = 13;
/* 7414 */     this.stopPoint = this.machine.instructionSet.PUSH(paramArrayOfInt[1]);
/* 7415 */     if (this.stopPoint != null) return this.stopPoint;
/*      */ 
/* 7419 */     paramArrayOfInt[1][2] = 4;
/* 7420 */     this.stopPoint = this.machine.instructionSet.PUSH(paramArrayOfInt[1]);
/* 7421 */     if (this.stopPoint != null) return this.stopPoint;
/*      */ 
/* 7425 */     paramArrayOfInt[1][2] = 8;
/* 7426 */     this.stopPoint = this.machine.instructionSet.PUSH(paramArrayOfInt[1]);
/* 7427 */     if (this.stopPoint != null) return this.stopPoint;
/*      */ 
/* 7434 */     this.machine.clearFlagAndNotify(9);
/* 7435 */     this.machine.clearFlagAndNotify(8);
/*      */ 
/* 7441 */     paramArrayOfInt[0][1] = 0;
/*      */ 
/* 7443 */     paramArrayOfInt[0][0] = (paramArrayOfInt1[1] * 4);
/*      */ 
/* 7451 */     this.machine.setRegisterAndNotify(this.machine.getMemoryWord(paramArrayOfInt[0]), 8);
/*      */ 
/* 7453 */     paramArrayOfInt[0][0] += 2;
/* 7454 */     this.machine.setRegisterAndNotify(this.machine.getMemoryWord(paramArrayOfInt[0]), 4);
/*      */ 
/* 7456 */     return null;
/*      */   }
/*      */ 
/*      */   public StopPoint jumpCE(int[] paramArrayOfInt1, int[][] paramArrayOfInt, int[] paramArrayOfInt2)
/*      */   {
/* 7469 */     if (this.machine.getFlag(11))
/*      */     {
/* 7476 */       this.machine.incIPAndNotify(paramArrayOfInt[2][0]);
/* 7477 */       paramArrayOfInt[2][0] = 0;
/*      */ 
/* 7484 */       paramArrayOfInt[1][3] = 1;
/* 7485 */       paramArrayOfInt[1][2] = 13;
/* 7486 */       this.stopPoint = this.machine.instructionSet.PUSH(paramArrayOfInt[1]);
/* 7487 */       if (this.stopPoint != null) return this.stopPoint;
/*      */ 
/* 7492 */       paramArrayOfInt[1][2] = 4;
/* 7493 */       this.stopPoint = this.machine.instructionSet.PUSH(paramArrayOfInt[1]);
/* 7494 */       if (this.stopPoint != null) return this.stopPoint;
/*      */ 
/* 7499 */       paramArrayOfInt[1][2] = 8;
/* 7500 */       this.stopPoint = this.machine.instructionSet.PUSH(paramArrayOfInt[1]);
/* 7501 */       if (this.stopPoint != null) return this.stopPoint;
/*      */ 
/* 7508 */       this.machine.clearFlagAndNotify(9);
/* 7509 */       this.machine.clearFlagAndNotify(8);
/*      */ 
/* 7515 */       paramArrayOfInt[0][1] = 0;
/*      */ 
/* 7517 */       paramArrayOfInt[0][0] = 12;
/*      */ 
/* 7525 */       this.machine.setRegisterAndNotify(this.machine.getMemoryWord(paramArrayOfInt[0]), 8);
/*      */ 
/* 7527 */       paramArrayOfInt[0][0] += 2;
/* 7528 */       this.machine.setRegisterAndNotify(this.machine.getMemoryWord(paramArrayOfInt[0]), 4);
/*      */     }
/*      */ 
/* 7532 */     return null;
/*      */   }
/*      */ 
/*      */   public StopPoint jumpCF(int[] paramArrayOfInt1, int[][] paramArrayOfInt, int[] paramArrayOfInt2)
/*      */   {
/* 7549 */     paramArrayOfInt[2][0] = 0;
/*      */ 
/* 7557 */     paramArrayOfInt[1][2] = 8;
/* 7558 */     this.stopPoint = this.machine.instructionSet.POP(paramArrayOfInt[1]);
/* 7559 */     if (this.stopPoint != null) return this.stopPoint;
/*      */ 
/* 7564 */     paramArrayOfInt[1][2] = 4;
/* 7565 */     this.stopPoint = this.machine.instructionSet.POP(paramArrayOfInt[1]);
/* 7566 */     if (this.stopPoint != null) return this.stopPoint;
/*      */ 
/* 7570 */     paramArrayOfInt[1][3] = 1;
/* 7571 */     paramArrayOfInt[1][2] = 13;
/* 7572 */     return this.machine.instructionSet.POP(paramArrayOfInt[1]);
/*      */   }
/*      */ 
/*      */   public StopPoint jumpD0(int[] paramArrayOfInt1, int[][] paramArrayOfInt, int[] paramArrayOfInt2)
/*      */   {
/* 7592 */     paramArrayOfInt2[0] = 1;
/* 7593 */     paramArrayOfInt2[1] = 1;
/* 7594 */     paramArrayOfInt2[2] = 0;
/*      */ 
/* 7597 */     this.stopPoint = this.machine.addressModeDecoder.decode(paramArrayOfInt1, paramArrayOfInt, paramArrayOfInt2);
/*      */ 
/* 7599 */     if (this.stopPoint != null) return this.stopPoint;
/*      */ 
/* 7607 */     paramArrayOfInt[2][0] += 1;
/*      */ 
/* 7613 */     paramArrayOfInt[1][3] = 3;
/* 7614 */     paramArrayOfInt[1][0] = 1;
/*      */ 
/* 7624 */     int i = (byte)((paramArrayOfInt1[1] & 0x38) >> 3);
/* 7625 */     switch (i) {
/*      */     case 0:
/* 7627 */       return this.machine.instructionSet.ROL8(paramArrayOfInt[0], paramArrayOfInt[1]);
/*      */     case 1:
/* 7630 */       return this.machine.instructionSet.ROR8(paramArrayOfInt[0], paramArrayOfInt[1]);
/*      */     case 2:
/* 7633 */       return this.machine.instructionSet.RCL8(paramArrayOfInt[0], paramArrayOfInt[1]);
/*      */     case 3:
/* 7636 */       return this.machine.instructionSet.RCR8(paramArrayOfInt[0], paramArrayOfInt[1]);
/*      */     case 4:
/* 7639 */       return this.machine.instructionSet.SALSHL8(paramArrayOfInt[0], paramArrayOfInt[1]);
/*      */     case 5:
/* 7642 */       return this.machine.instructionSet.SHR8(paramArrayOfInt[0], paramArrayOfInt[1]);
/*      */     case 6:
/* 7645 */       return new StopPoint(1, "Bad REG Field of 'D0' Instruction:  Value :" + i);
/*      */     case 7:
/* 7648 */       return this.machine.instructionSet.SAR8(paramArrayOfInt[0], paramArrayOfInt[1]);
/*      */     }
/*      */ 
/* 7651 */     return new StopPoint(1, 
/* 7652 */       "invalid case for instruction switch statement in jumpD0.");
/*      */   }
/*      */ 
/*      */   public StopPoint jumpD1(int[] paramArrayOfInt1, int[][] paramArrayOfInt, int[] paramArrayOfInt2)
/*      */   {
/* 7673 */     paramArrayOfInt2[0] = 1;
/* 7674 */     paramArrayOfInt2[1] = 2;
/* 7675 */     paramArrayOfInt2[2] = 0;
/*      */ 
/* 7678 */     this.stopPoint = this.machine.addressModeDecoder.decode(paramArrayOfInt1, paramArrayOfInt, paramArrayOfInt2);
/*      */ 
/* 7680 */     if (this.stopPoint != null) return this.stopPoint;
/*      */ 
/* 7688 */     paramArrayOfInt[2][0] += 1;
/*      */ 
/* 7694 */     paramArrayOfInt[1][3] = 3;
/* 7695 */     paramArrayOfInt[1][0] = 1;
/*      */ 
/* 7705 */     int i = (byte)((paramArrayOfInt1[1] & 0x38) >> 3);
/* 7706 */     switch (i) {
/*      */     case 0:
/* 7708 */       return this.machine.instructionSet.ROL16(paramArrayOfInt[0], paramArrayOfInt[1]);
/*      */     case 1:
/* 7711 */       return this.machine.instructionSet.ROR16(paramArrayOfInt[0], paramArrayOfInt[1]);
/*      */     case 2:
/* 7714 */       return this.machine.instructionSet.RCL16(paramArrayOfInt[0], paramArrayOfInt[1]);
/*      */     case 3:
/* 7717 */       return this.machine.instructionSet.RCR16(paramArrayOfInt[0], paramArrayOfInt[1]);
/*      */     case 4:
/* 7720 */       return this.machine.instructionSet.SALSHL16(paramArrayOfInt[0], paramArrayOfInt[1]);
/*      */     case 5:
/* 7723 */       return this.machine.instructionSet.SHR16(paramArrayOfInt[0], paramArrayOfInt[1]);
/*      */     case 6:
/* 7726 */       return new StopPoint(1, "Bad REG Field of 'D0' Instruction:  Value :" + i);
/*      */     case 7:
/* 7729 */       return this.machine.instructionSet.SAR16(paramArrayOfInt[0], paramArrayOfInt[1]);
/*      */     }
/*      */ 
/* 7732 */     return new StopPoint(1, "invalid case for instruction switch statement");
/*      */   }
/*      */ 
/*      */   public StopPoint jumpD2(int[] paramArrayOfInt1, int[][] paramArrayOfInt, int[] paramArrayOfInt2)
/*      */   {
/* 7754 */     paramArrayOfInt2[0] = 1;
/* 7755 */     paramArrayOfInt2[1] = 1;
/* 7756 */     paramArrayOfInt2[2] = 0;
/*      */ 
/* 7759 */     this.stopPoint = this.machine.addressModeDecoder.decode(paramArrayOfInt1, paramArrayOfInt, paramArrayOfInt2);
/*      */ 
/* 7761 */     if (this.stopPoint != null) return this.stopPoint;
/*      */ 
/* 7769 */     paramArrayOfInt[2][0] += 1;
/*      */ 
/* 7775 */     paramArrayOfInt[1][2] = 22;
/* 7776 */     paramArrayOfInt[1][3] = 1;
/*      */ 
/* 7786 */     int i = (byte)((paramArrayOfInt1[1] & 0x38) >> 3);
/* 7787 */     switch (i) {
/*      */     case 0:
/* 7789 */       return this.machine.instructionSet.ROL8(paramArrayOfInt[0], paramArrayOfInt[1]);
/*      */     case 1:
/* 7792 */       return this.machine.instructionSet.ROR8(paramArrayOfInt[0], paramArrayOfInt[1]);
/*      */     case 2:
/* 7795 */       return this.machine.instructionSet.RCL8(paramArrayOfInt[0], paramArrayOfInt[1]);
/*      */     case 3:
/* 7798 */       return this.machine.instructionSet.RCR8(paramArrayOfInt[0], paramArrayOfInt[1]);
/*      */     case 4:
/* 7801 */       return this.machine.instructionSet.SALSHL8(paramArrayOfInt[0], paramArrayOfInt[1]);
/*      */     case 5:
/* 7804 */       return this.machine.instructionSet.SHR8(paramArrayOfInt[0], paramArrayOfInt[1]);
/*      */     case 6:
/* 7807 */       return new StopPoint(1, "Bad REG Field of 'D0' Instruction:  Value :" + i);
/*      */     case 7:
/* 7810 */       return this.machine.instructionSet.SAR8(paramArrayOfInt[0], paramArrayOfInt[1]);
/*      */     }
/*      */ 
/* 7813 */     return new StopPoint(1, "invalid case for instruction switch statement");
/*      */   }
/*      */ 
/*      */   public StopPoint jumpD3(int[] paramArrayOfInt1, int[][] paramArrayOfInt, int[] paramArrayOfInt2)
/*      */   {
/* 7835 */     paramArrayOfInt2[0] = 1;
/* 7836 */     paramArrayOfInt2[1] = 2;
/* 7837 */     paramArrayOfInt2[2] = 0;
/*      */ 
/* 7840 */     this.stopPoint = this.machine.addressModeDecoder.decode(paramArrayOfInt1, paramArrayOfInt, paramArrayOfInt2);
/*      */ 
/* 7842 */     if (this.stopPoint != null) return this.stopPoint;
/*      */ 
/* 7850 */     paramArrayOfInt[2][0] += 1;
/*      */ 
/* 7856 */     paramArrayOfInt[1][2] = 22;
/* 7857 */     paramArrayOfInt[1][3] = 1;
/*      */ 
/* 7866 */     int i = (byte)((paramArrayOfInt1[1] & 0x38) >> 3);
/* 7867 */     switch (i) {
/*      */     case 0:
/* 7869 */       return this.machine.instructionSet.ROL16(paramArrayOfInt[0], paramArrayOfInt[1]);
/*      */     case 1:
/* 7872 */       return this.machine.instructionSet.ROR16(paramArrayOfInt[0], paramArrayOfInt[1]);
/*      */     case 2:
/* 7875 */       return this.machine.instructionSet.RCL16(paramArrayOfInt[0], paramArrayOfInt[1]);
/*      */     case 3:
/* 7878 */       return this.machine.instructionSet.RCR16(paramArrayOfInt[0], paramArrayOfInt[1]);
/*      */     case 4:
/* 7881 */       return this.machine.instructionSet.SALSHL16(paramArrayOfInt[0], paramArrayOfInt[1]);
/*      */     case 5:
/* 7884 */       return this.machine.instructionSet.SHR16(paramArrayOfInt[0], paramArrayOfInt[1]);
/*      */     case 6:
/* 7887 */       return new StopPoint(1, "Bad REG Field of 'D0' Instruction:  Value :" + i);
/*      */     case 7:
/* 7890 */       return this.machine.instructionSet.SAR16(paramArrayOfInt[0], paramArrayOfInt[1]);
/*      */     }
/*      */ 
/* 7893 */     return new StopPoint(1, "invalid case for instruction switch statement");
/*      */   }
/*      */ 
/*      */   public StopPoint jumpD4(int[] paramArrayOfInt1, int[][] paramArrayOfInt, int[] paramArrayOfInt2)
/*      */   {
/* 7912 */     paramArrayOfInt[2][0] += 1;
/*      */ 
/* 7918 */     if (paramArrayOfInt1[1] == 10) {
/* 7919 */       int i = this.machine.getRegister(20) / 10;
/* 7920 */       this.machine.setRegisterAndNotify(i, 30);
/* 7921 */       i <<= 8;
/* 7922 */       i += this.machine.getRegister(20) % 10;
/* 7923 */       this.machine.setRegisterAndNotify(i & 0xFF, 20);
/*      */ 
/* 7931 */       int j = 0;
/* 7932 */       for (int k = 0; k < 16; k++)
/* 7933 */         j += ((i & Constants.BITMASK[k]) >> k);
/* 7934 */       if (j % 2 == 0)
/* 7935 */         this.machine.setFlagAndNotify(2);
/*      */       else {
/* 7937 */         this.machine.clearFlagAndNotify(2);
/*      */       }
/*      */ 
/* 7941 */       if (i > 32767)
/* 7942 */         this.machine.setFlagAndNotify(7);
/*      */       else {
/* 7944 */         this.machine.clearFlagAndNotify(7);
/*      */       }
/*      */ 
/* 7948 */       if (i == 0)
/* 7949 */         this.machine.setFlagAndNotify(6);
/*      */       else {
/* 7951 */         this.machine.clearFlagAndNotify(6);
/*      */       }
/* 7953 */       return null;
/*      */     }
/*      */ 
/* 7956 */     return new StopPoint(1, "Second Byte of AAM Instruction is not a Defined Instruction:  Value :" + paramArrayOfInt1[1]);
/*      */   }
/*      */ 
/*      */   public StopPoint jumpD5(int[] paramArrayOfInt1, int[][] paramArrayOfInt, int[] paramArrayOfInt2)
/*      */   {
/* 7974 */     paramArrayOfInt[2][0] += 1;
/*      */ 
/* 7980 */     if (paramArrayOfInt1[1] == 10) {
/* 7981 */       int i = this.machine.getRegister(30) * 10 + 
/* 7982 */         this.machine.getRegister(20) & 0xFF;
/* 7983 */       this.machine.setRegisterAndNotify(i, 20);
/* 7984 */       this.machine.setRegisterAndNotify(0, 30);
/*      */ 
/* 7992 */       int j = 0;
/* 7993 */       for (int k = 0; k < 8; k++)
/* 7994 */         j += ((i & Constants.BITMASK[k]) >> k);
/* 7995 */       if (j % 2 == 0)
/* 7996 */         this.machine.setFlagAndNotify(2);
/*      */       else {
/* 7998 */         this.machine.clearFlagAndNotify(2);
/*      */       }
/*      */ 
/* 8002 */       if (i > 127)
/* 8003 */         this.machine.setFlagAndNotify(7);
/*      */       else {
/* 8005 */         this.machine.clearFlagAndNotify(7);
/*      */       }
/*      */ 
/* 8009 */       if (i == 0)
/* 8010 */         this.machine.setFlagAndNotify(6);
/*      */       else {
/* 8012 */         this.machine.clearFlagAndNotify(6);
/*      */       }
/* 8014 */       return null;
/*      */     }
/*      */ 
/* 8017 */     return new StopPoint(1, "Second Byte of AAD Instruction is not a Defined Instruction:  Value :" + paramArrayOfInt1[1]);
/*      */   }
/*      */ 
/*      */   public StopPoint jumpD7(int[] paramArrayOfInt1, int[][] paramArrayOfInt, int[] paramArrayOfInt2)
/*      */   {
/* 8041 */     paramArrayOfInt[1][3] = 2;
/* 8042 */     paramArrayOfInt[1][0] = (this.machine.getRegister(1) + this.machine.getRegister(20) & 0xFFFF);
/* 8043 */     if (!this.machine.segmentOverride)
/* 8044 */       paramArrayOfInt[1][1] = this.machine.getRegister(5);
/* 8045 */     paramArrayOfInt[0][3] = 1;
/* 8046 */     paramArrayOfInt[0][2] = 20;
/*      */ 
/* 8056 */     return this.machine.instructionSet.MOV8(paramArrayOfInt[0], paramArrayOfInt[1]);
/*      */   }
/*      */ 
/*      */   public StopPoint jumpE0(int[] paramArrayOfInt1, int[][] paramArrayOfInt, int[] paramArrayOfInt2)
/*      */   {
/* 8073 */     paramArrayOfInt[2][0] += 1;
/*      */ 
/* 8080 */     this.machine.incCXAndNotify(-1);
/*      */ 
/* 8082 */     if ((this.machine.getRegister(2) != 0) && (!this.machine.getFlag(6))) {
/* 8083 */       int i = paramArrayOfInt1[1];
/* 8084 */       if (i > 127) i = -(((i ^ 0xFFFFFFFF) & 0xFF) + 1);
/* 8085 */       this.machine.incIPAndNotify(i);
/*      */     }
/*      */ 
/* 8093 */     return null;
/*      */   }
/*      */ 
/*      */   public StopPoint jumpE1(int[] paramArrayOfInt1, int[][] paramArrayOfInt, int[] paramArrayOfInt2)
/*      */   {
/* 8110 */     paramArrayOfInt[2][0] += 1;
/*      */ 
/* 8117 */     this.machine.incCXAndNotify(-1);
/*      */ 
/* 8119 */     if ((this.machine.getRegister(2) != 0) && (this.machine.getFlag(6))) {
/* 8120 */       int i = paramArrayOfInt1[1];
/* 8121 */       if (i > 127) i = -(((i ^ 0xFFFFFFFF) & 0xFF) + 1);
/* 8122 */       this.machine.incIPAndNotify(i);
/*      */     }
/*      */ 
/* 8129 */     return null;
/*      */   }
/*      */ 
/*      */   public StopPoint jumpE2(int[] paramArrayOfInt1, int[][] paramArrayOfInt, int[] paramArrayOfInt2)
/*      */   {
/* 8146 */     paramArrayOfInt[2][0] += 1;
/*      */ 
/* 8153 */     this.machine.incCXAndNotify(-1);
/*      */ 
/* 8155 */     if (this.machine.getRegister(2) != 0) {
/* 8156 */       int i = paramArrayOfInt1[1];
/* 8157 */       if (i > 127) i = -(((i ^ 0xFFFFFFFF) & 0xFF) + 1);
/* 8158 */       this.machine.incIPAndNotify(i);
/*      */     }
/*      */ 
/* 8165 */     return null;
/*      */   }
/*      */ 
/*      */   public StopPoint jumpE3(int[] paramArrayOfInt1, int[][] paramArrayOfInt, int[] paramArrayOfInt2)
/*      */   {
/* 8182 */     paramArrayOfInt[2][0] += 1;
/*      */ 
/* 8188 */     if (this.machine.getRegister(2) == 0) {
/* 8189 */       int i = paramArrayOfInt1[1];
/* 8190 */       if (i > 127) i = -(((i ^ 0xFFFFFFFF) & 0xFF) + 1);
/* 8191 */       this.machine.incIPAndNotify(i);
/*      */     }
/*      */ 
/* 8198 */     return null;
/*      */   }
/*      */ 
/*      */   public StopPoint jumpE4(int[] paramArrayOfInt1, int[][] paramArrayOfInt, int[] paramArrayOfInt2)
/*      */   {
/* 8215 */     paramArrayOfInt[2][0] += 1;
/*      */ 
/* 8221 */     if (!this.machine.devices.isWriteOnlyPort(paramArrayOfInt1[1])) {
/* 8222 */       this.machine.setRegisterAndNotify(this.machine.readPortByteAndNotify(paramArrayOfInt1[1]), 20);
/* 8223 */       return null;
/*      */     }
/*      */ 
/* 8226 */     return new StopPoint(1, "IN AL,IMMED8: can't read from WRITE-ONLY PORT");
/*      */   }
/*      */ 
/*      */   public StopPoint jumpE5(int[] paramArrayOfInt1, int[][] paramArrayOfInt, int[] paramArrayOfInt2)
/*      */   {
/* 8244 */     paramArrayOfInt[2][0] += 1;
/*      */ 
/* 8250 */     if ((!this.machine.devices.isWriteOnlyPort(paramArrayOfInt1[1])) && (!this.machine.devices.isWriteOnlyPort(paramArrayOfInt1[1] + 1))) {
/* 8251 */       this.machine.setRegisterAndNotify(this.machine.readPortWordAndNotify(paramArrayOfInt1[1]), 0);
/* 8252 */       return null;
/*      */     }
/*      */ 
/* 8255 */     return new StopPoint(1, "IN AX,IMMED8: can't read from WRITE-ONLY PORT");
/*      */   }
/*      */ 
/*      */   public StopPoint jumpE6(int[] paramArrayOfInt1, int[][] paramArrayOfInt, int[] paramArrayOfInt2)
/*      */   {
/* 8273 */     paramArrayOfInt[2][0] += 1;
/*      */ 
/* 8279 */     int i = paramArrayOfInt1[1];
/* 8280 */     int j = this.machine.getRegister(20);
/*      */ 
/* 8282 */     if (i == 1258) j %= 40;
/* 8283 */     if (i == 1259) j %= 25;
/*      */ 
/* 8285 */     if (!this.machine.devices.isReadOnlyPort(paramArrayOfInt1[1])) {
/* 8286 */       this.machine.setPortByteAndNotify(j, i);
/* 8287 */       return null;
/*      */     }
/*      */ 
/* 8290 */     return new StopPoint(1, "OUT AL,IMMED8: can't write to READ-ONLY PORT");
/*      */   }
/*      */ 
/*      */   public StopPoint jumpE7(int[] paramArrayOfInt1, int[][] paramArrayOfInt, int[] paramArrayOfInt2)
/*      */   {
/* 8308 */     paramArrayOfInt[2][0] += 1;
/*      */ 
/* 8314 */     int i = paramArrayOfInt1[1];
/* 8315 */     int j = this.machine.getRegister(0);
/*      */ 
/* 8317 */     if (i == 1258) j = (j & 0xFF00) + (j & 0xFF) % 40;
/* 8318 */     if (i + 1 == 1258) j = (j & 0xFF) + (((j & 0xFF00) >> 8) % 40 << 8);
/* 8319 */     if (i == 1259) j = (j & 0xFF00) + (j & 0xFF) % 25;
/* 8320 */     if (i + 1 == 1259) j = (j & 0xFF) + (((j & 0xFF00) >> 8) % 25 << 8);
/*      */ 
/* 8322 */     if ((!this.machine.devices.isReadOnlyPort(i)) && (!this.machine.devices.isReadOnlyPort(i + 1))) {
/* 8323 */       this.machine.setPortWordAndNotify(j, i);
/* 8324 */       return null;
/*      */     }
/*      */ 
/* 8327 */     return new StopPoint(1, "OUT AX,IMMED8: can't write to READ-ONLY PORT");
/*      */   }
/*      */ 
/*      */   public StopPoint jumpE8(int[] paramArrayOfInt1, int[][] paramArrayOfInt, int[] paramArrayOfInt2)
/*      */   {
/* 8345 */     paramArrayOfInt[2][0] += 2;
/*      */ 
/* 8351 */     this.machine.incIPAndNotify(paramArrayOfInt[2][0]);
/*      */ 
/* 8359 */     paramArrayOfInt[0][3] = 1;
/* 8360 */     paramArrayOfInt[0][2] = 8;
/* 8361 */     this.stopPoint = this.machine.instructionSet.PUSH(paramArrayOfInt[0]);
/* 8362 */     if (this.stopPoint != null) return this.stopPoint;
/*      */ 
/* 8368 */     paramArrayOfInt[2][0] = ((paramArrayOfInt1[2] << 8) + paramArrayOfInt1[1]);
/*      */ 
/* 8372 */     return null;
/*      */   }
/*      */ 
/*      */   public StopPoint jumpE9(int[] paramArrayOfInt1, int[][] paramArrayOfInt, int[] paramArrayOfInt2)
/*      */   {
/* 8389 */     paramArrayOfInt[2][0] += 2;
/*      */ 
/* 8395 */     int i = (paramArrayOfInt1[2] << 8) + paramArrayOfInt1[1];
/* 8396 */     if (i > 32767) i = -(((i ^ 0xFFFFFFFF) & 0xFFFF) + 1);
/* 8397 */     this.machine.incIPAndNotify(i);
/*      */ 
/* 8399 */     return null;
/*      */   }
/*      */ 
/*      */   public StopPoint jumpEA(int[] paramArrayOfInt1, int[][] paramArrayOfInt, int[] paramArrayOfInt2)
/*      */   {
/* 8418 */     paramArrayOfInt[2][0] = 0;
/*      */ 
/* 8424 */     this.machine.setRegisterAndNotify((paramArrayOfInt1[2] << 8) + paramArrayOfInt1[1], 8);
/* 8425 */     this.machine.setRegisterAndNotify((paramArrayOfInt1[4] << 8) + paramArrayOfInt1[3], 4);
/*      */ 
/* 8427 */     return null;
/*      */   }
/*      */ 
/*      */   public StopPoint jumpEB(int[] paramArrayOfInt1, int[][] paramArrayOfInt, int[] paramArrayOfInt2)
/*      */   {
/* 8444 */     paramArrayOfInt[2][0] += 1;
/*      */ 
/* 8450 */     int i = paramArrayOfInt1[1];
/* 8451 */     if (i > 127) i = -(((i ^ 0xFFFFFFFF) & 0xFF) + 1);
/* 8452 */     this.machine.incIPAndNotify(i);
/*      */ 
/* 8454 */     return null;
/*      */   }
/*      */ 
/*      */   public StopPoint jumpEC(int[] paramArrayOfInt1, int[][] paramArrayOfInt, int[] paramArrayOfInt2)
/*      */   {
/* 8477 */     int i = this.machine.getRegister(3);
/* 8478 */     if (!this.machine.devices.isWriteOnlyPort(i)) {
/* 8479 */       this.machine.setRegisterAndNotify(this.machine.readPortByteAndNotify(i), 20);
/* 8480 */       return null;
/*      */     }
/*      */ 
/* 8483 */     return new StopPoint(1, "IN AL,DX: can't read from WRITE-ONLY PORT");
/*      */   }
/*      */ 
/*      */   public StopPoint jumpED(int[] paramArrayOfInt1, int[][] paramArrayOfInt, int[] paramArrayOfInt2)
/*      */   {
/* 8507 */     int i = this.machine.getRegister(3);
/* 8508 */     if ((!this.machine.devices.isWriteOnlyPort(i)) && (!this.machine.devices.isWriteOnlyPort(i + 1))) {
/* 8509 */       this.machine.setRegisterAndNotify(this.machine.readPortWordAndNotify(i), 0);
/* 8510 */       return null;
/*      */     }
/*      */ 
/* 8513 */     return new StopPoint(1, "IN AX,DX: can't read from WRITE-ONLY PORT");
/*      */   }
/*      */ 
/*      */   public StopPoint jumpEE(int[] paramArrayOfInt1, int[][] paramArrayOfInt, int[] paramArrayOfInt2)
/*      */   {
/* 8537 */     int i = this.machine.getRegister(3);
/* 8538 */     int j = this.machine.getRegister(20);
/*      */ 
/* 8541 */     if (i == 1258) j %= 40;
/* 8542 */     if (i == 1259) j %= 25;
/*      */ 
/* 8544 */     if (!this.machine.devices.isReadOnlyPort(i)) {
/* 8545 */       this.machine.setPortByteAndNotify(j, i);
/* 8546 */       return null;
/*      */     }
/*      */ 
/* 8549 */     return new StopPoint(1, "OUT AL,DX: can't write to READ-ONLY PORT");
/*      */   }
/*      */ 
/*      */   public StopPoint jumpEF(int[] paramArrayOfInt1, int[][] paramArrayOfInt, int[] paramArrayOfInt2)
/*      */   {
/* 8573 */     int i = this.machine.getRegister(3);
/* 8574 */     int j = this.machine.getRegister(0);
/*      */ 
/* 8577 */     if (i == 1258) j = (j & 0xFF00) + (j & 0xFF) % 40;
/* 8578 */     if (i + 1 == 1258) j = (j & 0xFF) + (((j & 0xFF00) >> 8) % 40 << 8);
/* 8579 */     if (i == 1259) j = (j & 0xFF00) + (j & 0xFF) % 25;
/* 8580 */     if (i + 1 == 1259) j = (j & 0xFF) + (((j & 0xFF00) >> 8) % 25 << 8);
/*      */ 
/* 8582 */     if ((!this.machine.devices.isReadOnlyPort(i)) && (!this.machine.devices.isReadOnlyPort(i + 1))) {
/* 8583 */       this.machine.setPortWordAndNotify(j, i);
/* 8584 */       return null;
/*      */     }
/*      */ 
/* 8587 */     return new StopPoint(1, "OUT AX,DX: can't write to READ-ONLY PORT");
/*      */   }
/*      */ 
/*      */   public StopPoint jumpF2(int[] paramArrayOfInt1, int[][] paramArrayOfInt, int[] paramArrayOfInt2)
/*      */   {
/* 8608 */     paramArrayOfInt[2][0] = 0;
/*      */ 
/* 8615 */     if ((paramArrayOfInt1[1] >= 164) && (paramArrayOfInt1[1] <= 175));
/* 8616 */     switch (paramArrayOfInt1[1] - 164) {
/*      */     case 0:
/* 8618 */       this.stopPoint = this.machine.instructionSet.MOVS8(paramArrayOfInt[0], paramArrayOfInt[1]);
/* 8619 */       break;
/*      */     case 1:
/* 8622 */       this.stopPoint = this.machine.instructionSet.MOVS16(paramArrayOfInt[0], paramArrayOfInt[1]);
/* 8623 */       break;
/*      */     case 2:
/* 8626 */       this.stopPoint = this.machine.instructionSet.CMPS8(paramArrayOfInt[0], paramArrayOfInt[1]);
/* 8627 */       break;
/*      */     case 3:
/* 8630 */       this.stopPoint = this.machine.instructionSet.CMPS16(paramArrayOfInt[0], paramArrayOfInt[1]);
/* 8631 */       break;
/*      */     case 4:
/*      */     case 5:
/* 8635 */       this.stopPoint = new StopPoint(1, "StopPoint! Invalid command after REP/REPE/REPZ Instruction:  Value :" + paramArrayOfInt1[1]);
/* 8636 */       break;
/*      */     case 6:
/* 8639 */       this.stopPoint = this.machine.instructionSet.STOS8(paramArrayOfInt[0], paramArrayOfInt[1]);
/* 8640 */       break;
/*      */     case 7:
/* 8643 */       this.stopPoint = this.machine.instructionSet.STOS16(paramArrayOfInt[0], paramArrayOfInt[1]);
/* 8644 */       break;
/*      */     case 8:
/* 8647 */       this.stopPoint = this.machine.instructionSet.LODS8(paramArrayOfInt[0], paramArrayOfInt[1]);
/* 8648 */       break;
/*      */     case 9:
/* 8651 */       this.stopPoint = this.machine.instructionSet.LODS16(paramArrayOfInt[0], paramArrayOfInt[1]);
/* 8652 */       break;
/*      */     case 10:
/* 8655 */       this.stopPoint = this.machine.instructionSet.SCAS8(paramArrayOfInt[0], paramArrayOfInt[1]);
/* 8656 */       break;
/*      */     case 11:
/* 8659 */       this.stopPoint = this.machine.instructionSet.SCAS16(paramArrayOfInt[0], paramArrayOfInt[1]);
/* 8660 */       break;
/*      */     default:
/* 8663 */       this.stopPoint = new StopPoint(1, "invalid case for REP instruction switch statement");
/* 8664 */       break;
/*      */ 
/*      */     }
/* 8670 */     if (this.stopPoint != null) return this.stopPoint;
/*      */ 
/* 8673 */     this.machine.incCXAndNotify(-1);
/*      */ 
/* 8676 */     if ((this.machine.getRegister(2) == 0) || (!this.machine.getFlag(6))) {
/* 8677 */       paramArrayOfInt[2][0] = 2;
/*      */     }
/* 8679 */     return null;
/*      */   }
/*      */ 
/*      */   public StopPoint jumpF3(int[] paramArrayOfInt1, int[][] paramArrayOfInt, int[] paramArrayOfInt2)
/*      */   {
/* 8696 */     if ((paramArrayOfInt1[1] >= 164) && (paramArrayOfInt1[1] <= 175)) {
/* 8697 */       if (this.machine.getRegister(2) == 0)
/*      */       {
/* 8703 */         paramArrayOfInt[2][0] += 1;
/*      */       }
/*      */       else
/*      */       {
/* 8712 */         paramArrayOfInt[2][0] = 0;
/*      */ 
/* 8719 */         switch (paramArrayOfInt1[1] - 164) {
/*      */         case 0:
/* 8721 */           this.stopPoint = this.machine.instructionSet.MOVS8(paramArrayOfInt[0], paramArrayOfInt[1]);
/* 8722 */           break;
/*      */         case 1:
/* 8725 */           this.stopPoint = this.machine.instructionSet.MOVS16(paramArrayOfInt[0], paramArrayOfInt[1]);
/* 8726 */           break;
/*      */         case 2:
/* 8729 */           this.stopPoint = this.machine.instructionSet.CMPS8(paramArrayOfInt[0], paramArrayOfInt[1]);
/* 8730 */           break;
/*      */         case 3:
/* 8733 */           this.stopPoint = this.machine.instructionSet.CMPS16(paramArrayOfInt[0], paramArrayOfInt[1]);
/* 8734 */           break;
/*      */         case 4:
/*      */         case 5:
/* 8738 */           this.stopPoint = new StopPoint(1, "Invalid command after REP/REPE/REPZ Instruction:  Value :" + paramArrayOfInt1[1]);
/* 8739 */           break;
/*      */         case 6:
/* 8742 */           this.stopPoint = this.machine.instructionSet.STOS8(paramArrayOfInt[0], paramArrayOfInt[1]);
/* 8743 */           break;
/*      */         case 7:
/* 8746 */           this.stopPoint = this.machine.instructionSet.STOS16(paramArrayOfInt[0], paramArrayOfInt[1]);
/* 8747 */           break;
/*      */         case 8:
/* 8750 */           this.stopPoint = this.machine.instructionSet.LODS8(paramArrayOfInt[0], paramArrayOfInt[1]);
/* 8751 */           break;
/*      */         case 9:
/* 8754 */           this.stopPoint = this.machine.instructionSet.LODS16(paramArrayOfInt[0], paramArrayOfInt[1]);
/* 8755 */           break;
/*      */         case 10:
/* 8758 */           this.stopPoint = this.machine.instructionSet.SCAS8(paramArrayOfInt[0], paramArrayOfInt[1]);
/* 8759 */           break;
/*      */         case 11:
/* 8762 */           this.stopPoint = this.machine.instructionSet.SCAS16(paramArrayOfInt[0], paramArrayOfInt[1]);
/* 8763 */           break;
/*      */         default:
/* 8766 */           this.stopPoint = new StopPoint(1, 
/* 8767 */             "Invalid case for REP instruction switch statement in jumpF3.");
/*      */         }
/*      */ 
/* 8770 */         if (this.stopPoint != null) return this.stopPoint;
/*      */ 
/* 8772 */         this.machine.incCXAndNotify(-1);
/*      */ 
/* 8775 */         if (this.machine.getRegister(2) == 0) {
/* 8776 */           paramArrayOfInt[2][0] = 2;
/*      */         }
/*      */       }
/*      */ 
/*      */     }
/*      */     else
/*      */     {
/* 8783 */       return new StopPoint(1, "Invalid command after REP/REPE/REPZ Instruction:  Value :" + paramArrayOfInt1[1]);
/*      */     }
/*      */ 
/* 8786 */     return null;
/*      */   }
/*      */ 
/*      */   public StopPoint jumpF4(int[] paramArrayOfInt1, int[][] paramArrayOfInt, int[] paramArrayOfInt2)
/*      */   {
/* 8802 */     this.machine.endOfCodeIsReached();
/* 8803 */     return null;
/*      */   }
/*      */ 
/*      */   public StopPoint jumpF5(int[] paramArrayOfInt1, int[][] paramArrayOfInt, int[] paramArrayOfInt2)
/*      */   {
/* 8820 */     if (this.machine.getFlag(0))
/* 8821 */       this.machine.clearFlagAndNotify(0);
/*      */     else {
/* 8823 */       this.machine.setFlagAndNotify(0);
/*      */     }
/* 8825 */     return null;
/*      */   }
/*      */ 
/*      */   public StopPoint jumpF6(int[] paramArrayOfInt1, int[][] paramArrayOfInt, int[] paramArrayOfInt2)
/*      */   {
/* 8845 */     paramArrayOfInt2[0] = 1;
/* 8846 */     paramArrayOfInt2[1] = 1;
/* 8847 */     paramArrayOfInt2[2] = 0;
/*      */ 
/* 8850 */     this.stopPoint = this.machine.addressModeDecoder.decode(paramArrayOfInt1, paramArrayOfInt, paramArrayOfInt2);
/*      */ 
/* 8852 */     if (this.stopPoint != null) return this.stopPoint;
/*      */ 
/* 8860 */     paramArrayOfInt[2][0] += 1;
/*      */ 
/* 8870 */     int i = (byte)((paramArrayOfInt1[1] & 0x38) >> 3);
/* 8871 */     switch (i)
/*      */     {
/*      */     case 0:
/* 8875 */       paramArrayOfInt[1][3] = 3;
/*      */ 
/* 8878 */       paramArrayOfInt[1][0] = paramArrayOfInt1[paramArrayOfInt[2][0]];
/*      */ 
/* 8881 */       paramArrayOfInt[2][0] += 1;
/*      */ 
/* 8884 */       return this.machine.instructionSet.TEST8(paramArrayOfInt[0], paramArrayOfInt[1]);
/*      */     case 1:
/* 8887 */       return new StopPoint(1, "Bad REG Field of 'F6' Instruction:  Value :" + i);
/*      */     case 2:
/* 8890 */       return this.machine.instructionSet.NOT8(paramArrayOfInt[0]);
/*      */     case 3:
/* 8893 */       return this.machine.instructionSet.NEG8(paramArrayOfInt[0]);
/*      */     case 4:
/* 8896 */       return this.machine.instructionSet.MUL8(paramArrayOfInt[0]);
/*      */     case 5:
/* 8899 */       return this.machine.instructionSet.IMUL8(paramArrayOfInt[0]);
/*      */     case 6:
/* 8902 */       return this.machine.instructionSet.DIV8(paramArrayOfInt[0]);
/*      */     case 7:
/* 8905 */       return this.machine.instructionSet.IDIV8(paramArrayOfInt[0]);
/*      */     }
/*      */ 
/* 8908 */     return new StopPoint(1, 
/* 8909 */       "invalid case for instruction switch statement in jumpF6.");
/*      */   }
/*      */ 
/*      */   public StopPoint jumpF7(int[] paramArrayOfInt1, int[][] paramArrayOfInt, int[] paramArrayOfInt2)
/*      */   {
/* 8932 */     paramArrayOfInt2[0] = 1;
/* 8933 */     paramArrayOfInt2[1] = 2;
/* 8934 */     paramArrayOfInt2[2] = 0;
/*      */ 
/* 8937 */     this.stopPoint = this.machine.addressModeDecoder.decode(paramArrayOfInt1, paramArrayOfInt, paramArrayOfInt2);
/*      */ 
/* 8939 */     if (this.stopPoint != null) return this.stopPoint;
/*      */ 
/* 8947 */     paramArrayOfInt[2][0] += 1;
/*      */ 
/* 8957 */     int i = (byte)((paramArrayOfInt1[1] & 0x38) >> 3);
/* 8958 */     switch (i)
/*      */     {
/*      */     case 0:
/* 8962 */       paramArrayOfInt[1][3] = 3;
/*      */ 
/* 8965 */       paramArrayOfInt[1][0] = 
/* 8967 */         ((paramArrayOfInt1[(paramArrayOfInt[2][0] + 1)] << 8) + 
/* 8967 */         paramArrayOfInt1[paramArrayOfInt[2][0]]);
/*      */ 
/* 8970 */       paramArrayOfInt[2][0] += 1;
/*      */ 
/* 8973 */       return this.machine.instructionSet.TEST16(paramArrayOfInt[0], paramArrayOfInt[1]);
/*      */     case 1:
/* 8976 */       return new StopPoint(1, "Bad REG Field of 'F7' Instruction:  Value :" + i);
/*      */     case 2:
/* 8979 */       return this.machine.instructionSet.NOT16(paramArrayOfInt[0]);
/*      */     case 3:
/* 8982 */       return this.machine.instructionSet.NEG16(paramArrayOfInt[0]);
/*      */     case 4:
/* 8985 */       return this.machine.instructionSet.MUL16(paramArrayOfInt[0]);
/*      */     case 5:
/* 8988 */       return this.machine.instructionSet.IMUL16(paramArrayOfInt[0]);
/*      */     case 6:
/* 8991 */       return this.machine.instructionSet.DIV16(paramArrayOfInt[0]);
/*      */     case 7:
/* 8994 */       return this.machine.instructionSet.IDIV16(paramArrayOfInt[0]);
/*      */     }
/*      */ 
/* 8997 */     return new StopPoint(1, 
/* 8998 */       "invalid case for instruction switch statement in jumpF7.");
/*      */   }
/*      */ 
/*      */   public StopPoint jumpF8(int[] paramArrayOfInt1, int[][] paramArrayOfInt, int[] paramArrayOfInt2)
/*      */   {
/* 9017 */     this.machine.clearFlagAndNotify(0);
/* 9018 */     return null;
/*      */   }
/*      */ 
/*      */   public StopPoint jumpF9(int[] paramArrayOfInt1, int[][] paramArrayOfInt, int[] paramArrayOfInt2)
/*      */   {
/* 9035 */     this.machine.setFlagAndNotify(0);
/* 9036 */     return null;
/*      */   }
/*      */ 
/*      */   public StopPoint jumpFA(int[] paramArrayOfInt1, int[][] paramArrayOfInt, int[] paramArrayOfInt2)
/*      */   {
/* 9053 */     this.machine.clearFlagAndNotify(9);
/* 9054 */     return null;
/*      */   }
/*      */ 
/*      */   public StopPoint jumpFB(int[] paramArrayOfInt1, int[][] paramArrayOfInt, int[] paramArrayOfInt2)
/*      */   {
/* 9071 */     this.machine.setFlagAndNotify(9);
/* 9072 */     return null;
/*      */   }
/*      */ 
/*      */   public StopPoint jumpFC(int[] paramArrayOfInt1, int[][] paramArrayOfInt, int[] paramArrayOfInt2)
/*      */   {
/* 9089 */     this.machine.clearFlagAndNotify(10);
/* 9090 */     return null;
/*      */   }
/*      */ 
/*      */   public StopPoint jumpFD(int[] paramArrayOfInt1, int[][] paramArrayOfInt, int[] paramArrayOfInt2)
/*      */   {
/* 9107 */     this.machine.setFlagAndNotify(10);
/* 9108 */     return null;
/*      */   }
/*      */ 
/*      */   public StopPoint jumpFE(int[] paramArrayOfInt1, int[][] paramArrayOfInt, int[] paramArrayOfInt2)
/*      */   {
/* 9128 */     paramArrayOfInt2[0] = 1;
/* 9129 */     paramArrayOfInt2[1] = 1;
/* 9130 */     paramArrayOfInt2[2] = 0;
/*      */ 
/* 9133 */     this.stopPoint = this.machine.addressModeDecoder.decode(paramArrayOfInt1, paramArrayOfInt, paramArrayOfInt2);
/*      */ 
/* 9135 */     if (this.stopPoint != null) return this.stopPoint;
/*      */ 
/* 9143 */     paramArrayOfInt[2][0] += 1;
/*      */ 
/* 9153 */     int i = (byte)((paramArrayOfInt1[1] & 0x38) >> 3);
/* 9154 */     switch (i) {
/*      */     case 0:
/* 9156 */       return this.machine.instructionSet.INC8(paramArrayOfInt[0]);
/*      */     case 1:
/* 9159 */       return this.machine.instructionSet.DEC8(paramArrayOfInt[0]);
/*      */     case 2:
/*      */     case 3:
/*      */     case 4:
/*      */     case 5:
/*      */     case 6:
/*      */     case 7:
/* 9167 */       return new StopPoint(1, "Bad REG Field of 'FE' Instruction:  Value :" + i);
/*      */     }
/*      */ 
/* 9170 */     return new StopPoint(1, 
/* 9171 */       "Invalid case for instruction switch statement in jumpF6.");
/*      */   }
/*      */ 
/*      */   public StopPoint jumpFF(int[] paramArrayOfInt1, int[][] paramArrayOfInt, int[] paramArrayOfInt2)
/*      */   {
/* 9193 */     paramArrayOfInt2[0] = 1;
/* 9194 */     paramArrayOfInt2[1] = 2;
/* 9195 */     paramArrayOfInt2[2] = 0;
/*      */ 
/* 9198 */     this.stopPoint = this.machine.addressModeDecoder.decode(paramArrayOfInt1, paramArrayOfInt, paramArrayOfInt2);
/*      */ 
/* 9200 */     if (this.stopPoint != null) return this.stopPoint;
/*      */ 
/* 9208 */     paramArrayOfInt[2][0] += 1;
/*      */ 
/* 9214 */     int i = (byte)((paramArrayOfInt1[1] & 0x38) >> 3);
/* 9215 */     switch (i) {
/*      */     case 0:
/* 9217 */       return this.machine.instructionSet.INC16(paramArrayOfInt[0]);
/*      */     case 1:
/* 9220 */       return this.machine.instructionSet.DEC16(paramArrayOfInt[0]);
/*      */     case 2:
/* 9224 */       this.machine.incIPAndNotify(paramArrayOfInt[2][0]);
/* 9225 */       paramArrayOfInt[2][0] = 0;
/*      */ 
/* 9229 */       paramArrayOfInt[1][3] = 1;
/* 9230 */       paramArrayOfInt[1][2] = 8;
/* 9231 */       this.stopPoint = this.machine.instructionSet.PUSH(paramArrayOfInt[1]);
/* 9232 */       if (this.stopPoint != null) return this.stopPoint;
/*      */ 
/* 9235 */       return this.machine.instructionSet.MOV16(paramArrayOfInt[1], paramArrayOfInt[0]);
/*      */     case 3:
/* 9240 */       this.machine.incIPAndNotify(paramArrayOfInt[2][0]);
/* 9241 */       paramArrayOfInt[2][0] = 0;
/*      */ 
/* 9245 */       paramArrayOfInt[1][3] = 1;
/* 9246 */       paramArrayOfInt[1][2] = 4;
/* 9247 */       this.stopPoint = this.machine.instructionSet.PUSH(paramArrayOfInt[1]);
/* 9248 */       if (this.stopPoint != null) return this.stopPoint;
/*      */ 
/* 9252 */       paramArrayOfInt[1][2] = 8;
/* 9253 */       this.stopPoint = this.machine.instructionSet.PUSH(paramArrayOfInt[1]);
/* 9254 */       if (this.stopPoint != null) return this.stopPoint;
/*      */ 
/* 9257 */       this.machine.setRegisterAndNotify(this.machine.getMemoryWord(paramArrayOfInt[0]), 8);
/*      */ 
/* 9259 */       paramArrayOfInt[0][0] += 2;
/* 9260 */       this.machine.setRegisterAndNotify(this.machine.getMemoryWord(paramArrayOfInt[0]), 4);
/* 9261 */       return null;
/*      */     case 4:
/* 9266 */       paramArrayOfInt[2][0] = 0;
/*      */ 
/* 9269 */       if (paramArrayOfInt[0][3] == 2)
/*      */       {
/* 9271 */         this.machine.setRegisterAndNotify(this.machine.getMemoryWord(paramArrayOfInt[0]), 8);
/* 9272 */         return null;
/*      */       }
/* 9274 */       if (paramArrayOfInt[0][3] == 3)
/*      */       {
/* 9277 */         return new StopPoint(1, "Immediate value in JMP REG16/MEM16");
/*      */       }
/*      */ 
/* 9281 */       this.machine.setRegisterAndNotify(this.machine.getRegister(paramArrayOfInt[0][2]), 8);
/* 9282 */       return null;
/*      */     case 5:
/* 9288 */       paramArrayOfInt[2][0] = 0;
/*      */ 
/* 9291 */       this.machine.setRegisterAndNotify(this.machine.getMemoryWord(paramArrayOfInt[0]), 8);
/* 9292 */       paramArrayOfInt[0][0] += 2;
/* 9293 */       this.machine.setRegisterAndNotify(this.machine.getMemoryWord(paramArrayOfInt[0]), 4);
/* 9294 */       return null;
/*      */     case 6:
/* 9305 */       return this.machine.instructionSet.PUSH(paramArrayOfInt[0]);
/*      */     case 7:
/* 9308 */       return new StopPoint(1, "Bad REG Field of 'FF' Instruction:  Value :" + i);
/*      */     }
/*      */ 
/* 9311 */     return new StopPoint(1, 
/* 9312 */       "Invalid case for instruction switch statement in jumpFF.");
/*      */   }
/*      */ 
/*      */   public StopPoint jumpNU(int[] paramArrayOfInt1, int[][] paramArrayOfInt, int[] paramArrayOfInt2)
/*      */   {
/* 9326 */     return new StopPoint(0, "");
/*      */   }
/*      */ }

/* Location:           C:\Users\daishi\Downloads\virgo213\virgo213_2006\
 * Qualified Name:     JumpTable
 * JD-Core Version:    0.6.2
 */