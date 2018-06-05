import java.util.*;


class VarTypeRef{
    ParaNode u;
    reg IR_name = new reg();
    int line, column;
    String Type;
    int dim = 0;
    int num;
    List<ExpressionNode> index = new ArrayList<>();

}
class ParTypeRef extends VarTypeRef{
    String ID;
}


class Scope {
    Scope parent;
    String name;
    String IR_name;
    Map<String, VarTypeRef> var = new LinkedHashMap<>();
}

class ClassScope extends Scope{
    Map<String, FuncScope> func = new LinkedHashMap<>();
}
class GeneralScope extends ClassScope{
    Map<String, ClassScope> clas = new LinkedHashMap<>();
}
class LocalScope extends Scope{
    Map<String, LocalScope> sons = new LinkedHashMap<>();
}
class FuncScope extends LocalScope{
    List<ParTypeRef> para = new ArrayList<>();
    String Return;
    String Return_IR_name;
    int dim = 0;
}

public class TempTestScope {
    public GeneralScope Root = new GeneralScope();
    int cntfor = 0;
    int cntwhile = 0;
    int cntthen = 0;
    int cntelse = 0;
    int cnt = 0;

    List<String> keyword = Arrays.asList("bool","int","string","null","void","true","false","if","for", "while","break","continue","return","new","class","this");


    TempTestScope(){
        Root.name =  "General";

        FuncScope Print = new FuncScope();
        Print.Return = "void";
        Print.name = "print";
        VarTypeRef tmp1 = new VarTypeRef();
        ParTypeRef t1 = new ParTypeRef();
        tmp1.Type = t1.Type = "string";
        t1.ID = "S";
        Print.para.add(t1);
        Print.var.put("S", tmp1);
        Root.func.put("print", Print);
        Print.IR_name = "print";
        Print.para.get(0).IR_name = new reg();
        Print.para.get(0).IR_name.contxt = "%vs_1";
        Print.var.get("S").IR_name = Print.para.get(0).IR_name;
        Print.Return_IR_name = "%fprint";

        FuncScope Println = new FuncScope();
        Println.Return = "void";
        Println.name = "println";
        VarTypeRef tmp2 = new VarTypeRef();
        ParTypeRef t2 = new ParTypeRef();
        tmp2.Type = t2.Type = "string";
        t2.ID = "S";
        Println.para.add(t2);
        Println.var.put("S", tmp2);
        Root.func.put("println", Println);
        Println.IR_name = "println";
        Println.para.get(0).IR_name = new reg();
        Println.para.get(0).IR_name.contxt = "%vs_2";
        Println.var.get("S").IR_name = Println.para.get(0).IR_name;
        Println.Return_IR_name = "%fprintln";

        FuncScope Getstring = new FuncScope();
        Getstring.Return = "string";
        Getstring.name = "getString";
        Root.func.put("getString", Getstring);
        Getstring.IR_name = "getString";
        Getstring.Return_IR_name = "%fgetstring";

        FuncScope Getint = new FuncScope();
        Getint.Return = "int";
        Getint.name = "getInt";
        Root.func.put("getInt", Getint);
        Getint.IR_name = "getint";
        Getint.Return_IR_name = "%fgetint";

        FuncScope Tostring = new FuncScope();
        Tostring.Return = "string";
        Tostring.name = "toString";
        VarTypeRef tmp3 = new VarTypeRef();
        ParTypeRef t3 = new ParTypeRef();
        tmp3.Type = t3.Type = "int";
        t3.ID = "i";
        Tostring.para.add(t3);
        Tostring.var.put("i", tmp3);
        Root.func.put("toString", Tostring);
        Tostring.IR_name = "tostring";
        Tostring.para.get(0).IR_name = new reg();
        Tostring.para.get(0).IR_name.contxt = "%vi_1";
        Tostring.var.get("i").IR_name = Tostring.para.get(0).IR_name;
        Tostring.Return_IR_name = "%ftostring";


        ClassScope Str = new ClassScope();

        FuncScope Length = new FuncScope();
        Length.Return = "int";
        Length.name = "length";
        Str.func.put("length", Length);
        Length.IR_name = "length";
        Length.Return_IR_name = "%flength";

        FuncScope Substring = new FuncScope();
        Substring.Return = "string";
        Substring.name = "substring";
        VarTypeRef tmp4 = new VarTypeRef();
        ParTypeRef t4 = new ParTypeRef();
        tmp4.Type = t4.Type = "int";
        t4.ID = "left";
        tmp4.IR_name = t4.IR_name = new reg();
        t4.IR_name.contxt = "%vleft";
        Substring.para.add(t4);
        Substring.var.put("left", tmp4);
        VarTypeRef tmp5 = new VarTypeRef();
        ParTypeRef t5 = new ParTypeRef();
        tmp5.Type = t5.Type = "int";
        t5.ID = "right";
        tmp5.IR_name = t5.IR_name = new reg();
        t5.IR_name.contxt = "%vright";
        Substring.para.add(t5);
        Substring.var.put("right", tmp5);
        Str.func.put("substring", Substring);
        Substring.IR_name = "substring";
        Substring.Return_IR_name = "%fsub";


        FuncScope ParseInt = new FuncScope();
        ParseInt.Return = "int";
        ParseInt.name = "parseInt";
        Str.func.put("parseInt", ParseInt);
        ParseInt.IR_name = "parseint";
        ParseInt.Return_IR_name = "%fparse";

        FuncScope Ord = new FuncScope();
        Ord.Return = "int";
        Ord.name = "ord";
        VarTypeRef tmp6 = new VarTypeRef();
        ParTypeRef t6 = new ParTypeRef();
        tmp6.Type = t6.Type = "int";
        t6.ID = "pos";
        tmp6.IR_name = t6.IR_name = new reg();
        t6.IR_name.contxt = "%vpos";
        Ord.para.add(t6);
        Ord.var.put("pos", tmp6);
        Str.func.put("ord", Ord);
        Ord.IR_name = "ord";
        Ord.Return_IR_name = "%ford";

        Root.clas.put("string", Str);

        FuncScope Add = new FuncScope();
        Add.Return = "string";
        Add.name = "_add";
        VarTypeRef tmp7 = new VarTypeRef();
        ParTypeRef t7 = new ParTypeRef();
        tmp7.Type = t7.Type = "string";
        t7.ID = "S1";
        Add.para.add(t7);
        Add.var.put("S1", tmp7);
        VarTypeRef tmp8 = new VarTypeRef();
        ParTypeRef t8 = new ParTypeRef();
        tmp8.Type = t8.Type = "string";
        t8.ID = "S2";
        Add.para.add(t8);
        Add.var.put("S2", tmp8);
        Root.func.put("_add", Add);
        Add.IR_name = "_add";
        Add.para.get(0).IR_name = new reg();
        Add.para.get(0).IR_name.contxt = "%va_1";
        Add.var.get("S1").IR_name = Print.para.get(0).IR_name;
        Add.para.get(1).IR_name = new reg();
        Add.para.get(1).IR_name.contxt = "%va_2";
        Add.var.get("S2").IR_name = Print.para.get(0).IR_name;
        Add.Return_IR_name = "%fadd";



    }

    public void put_this(){
        for (Object obj: Root.clas.keySet()){
            String key = (String) obj;
            ClassScope tmp = Root.clas.get(key);
            for (Object ob: tmp.func.keySet()){
                FuncScope t = tmp.func.get(ob);
                ParTypeRef tmp1 = new ParTypeRef();
                VarTypeRef tmp2 = new VarTypeRef();
                tmp1.ID = "this";
                tmp1.Type = tmp2.Type = tmp.name;
                tmp1.line = tmp1.column = tmp2.line = tmp2.column = 0;
                tmp1.IR_name = tmp2.IR_name = new reg();
                tmp1.IR_name.contxt = "%vthis";
                t.var.put("this", tmp2);
                t.para.add(0, tmp1);
            }
        }
    }

    public void dfs2(Scope v){
        System.out.println(v.name);
        for (Object obj:v.var.keySet()){
            String key = (String)obj;
            System.out.println(key);
        }
        if (v instanceof GeneralScope){
            for (Object obj:((GeneralScope) v).func.keySet()){
                String key = (String)obj;
                FuncScope value = ((GeneralScope) v).func.get(key);
                dfs2(value);
            }
            for (Object obj:((GeneralScope) v).clas.keySet()){
                String key = (String)obj;
                ClassScope value = ((GeneralScope) v).clas.get(key);
                dfs2(value);
            }
        }
        else if (v instanceof ClassScope){
            for (Object obj:((ClassScope) v).func.keySet()){
                String key = (String) obj;
                FuncScope value = ((ClassScope)v).func.get(key);
                dfs2(value);
            }
        }
        else if (v instanceof FuncScope || v instanceof LocalScope){
            for(Object obj:((LocalScope)v).sons.keySet()){
                String key = (String) obj;
                dfs2(((LocalScope)v).sons.get(key));
            }
        }
    }

    Type IsVar(VarNode u, Scope v){
        Type t = null;
        VarTypeRef tmp = v.var.get(u.ID);
        if (tmp != null &&
                ((tmp.line < u.Location.line || (tmp.line == u.Location.line && tmp.column <= u.Location.column)) ||
                        ((v instanceof ClassScope) && !(v instanceof GeneralScope)))) {
            if (tmp.Type.equals("int")) t = new IntType();
            else if (tmp.Type.equals("bool")) t = new BoolType();
            else if (tmp.Type.equals("str")) t = new ClassType("string");
            else if (tmp.Type.equals("null")) t = new NullType();
            else if (IsClass(tmp.Type) != null) t = new ClassType(tmp.Type);
            else {
                System.err.println(u.Location.line + " " + u.Location.column + "Class " + tmp.Type + " is not defined");
                System.exit(1);
            }
            t.dim = tmp.dim;
            return t;
        }
        else {
            if (v instanceof GeneralScope) return null;
                else return IsVar(u, v.parent);
        }
    }

    FuncScope IsReturn(Scope v){
        FuncScope tmp = null;
        if (v instanceof GeneralScope) return tmp;
        else if (v instanceof FuncScope) return tmp = (FuncScope)v;
        else return IsReturn(v.parent);
    }

    boolean IsOut(Scope v){
        if (v instanceof GeneralScope) return false;
        else if (v.name.contains("for") || v.name.contains("while") || v.name.contains("then") || v.name.contains("else"))
            return true;
        else IsOut(v.parent);
        return false;
    }

    ClassScope IsClass(String S){
        ClassScope t = this.Root.clas.get(S);
        return t;
    }

    FuncScope IsFunc(String S, Scope v){
        if (v instanceof ClassScope) {
            FuncScope tmp = ((ClassScope) v).func.get(S);
            if (tmp == null) return IsFunc(S, v.parent);
            else return tmp;
        }
        else if (v.parent != null) return IsFunc(S, v.parent);
        return null;
    }

    ClassType InClass(Scope v, boolean flag){
        ClassType tmp = null;
        if (v instanceof  GeneralScope) return null;
        else if (v instanceof FuncScope) {flag = true; return InClass(v.parent, true);}
        else if (v instanceof ClassScope && flag == true) {
            tmp = new ClassType(v.name);
            return tmp;
        }
        else if (v instanceof LocalScope) return InClass(v.parent, flag);
        return tmp;
    }


    public void dfs(Node u, Scope v){
        if (u == null) return;
        if (u instanceof ProgNode) {
            boolean IsMain = false;
            for (int i = 0; i < ((ProgNode) u).ClassList.size(); ++i){
                dfs(((ProgNode) u).ClassList.get(i), v);
            }
            for (int i = 0; i < ((ProgNode) u).ParaList.size(); ++i){
                dfs(((ProgNode) u).ParaList.get(i), v);
            }
            for (int i = 0; i < ((ProgNode) u).FuncList.size(); ++i){
                dfs(((ProgNode) u).FuncList.get(i), v);
                if (((ProgNode) u).FuncList.get(i).ID.equals("main"))  IsMain = true;
            }
            if (IsMain == false) {System.err.println("doesn't has a main function"); System.exit(1);}
        }

        else if (u instanceof FuncDefNode){
            FuncScope tmp = new FuncScope();
            if (keyword.contains(((FuncDefNode) u).ID)){
                System.err.println(u.Location.line+" "+u.Location.column+" \""+((FuncDefNode) u).ID+"\" is a reserved word");
                System.exit(1);
            }
            tmp.parent = v;
            tmp.name = ((FuncDefNode) u).ID;

            if (!((ClassScope)v).func.isEmpty()
                    && ((ClassScope)v).func.containsKey(tmp.name)) {
                System.err.println(u.Location.line+" "+u.Location.column+" "+"Function "+v.name+" is redefined");
                System.exit(1);
            }
            if (((FuncDefNode) u).ID.equals("main") && !((FuncDefNode) u).Return.equals("int")){
                System.err.println(u.Location.line+" "+u.Location.column+" Function main's return type is wrong");
                System.exit(1);
            }

            tmp.dim = ((FuncDefNode) u).dim;
            tmp.Return = ((FuncDefNode) u).Return;
            for (int i = 0; i < ((FuncDefNode) u).ParaList.size(); ++i){
                ParTypeRef tt = new ParTypeRef();
                tt.ID = ((FuncDefNode) u).ParaList.get(i).ID;
                tt.dim = ((FuncDefNode) u).ParaList.get(i).dim;
                tt.Type = ((FuncDefNode) u).ParaList.get(i).Type;
                tt.line = ((FuncDefNode) u).ParaList.get(i).Location.line;
                tt.column = ((FuncDefNode) u).ParaList.get(i).Location.column;
                ((FuncScope)tmp).para.add(tt);
            }
            ((ClassScope)v).func.put(((FuncDefNode) u).ID, tmp);

            for (int i = 0; i < u.size()-1; ++i){
                dfs(u.sons(i), tmp);
            }
            for (int i = 0; i < ((FuncDefNode)u).Body.size(); ++i){
                dfs(((FuncDefNode) u).Body.sons(i), tmp);
            }
            for (Object obj:tmp.var.keySet()){
                String key = (String)obj;
                VarTypeRef t = tmp.var.get(key);
            }
        }

        else if (u instanceof ClassDefNode){
            ClassScope tmp = new ClassScope();
            tmp.parent = v;
            tmp.name = ((ClassDefNode) u).ID;

            if (!((GeneralScope)v).clas.isEmpty() && ((GeneralScope)v).clas.containsKey(tmp.name)) {
                System.err.println(u.Location.line+" "+u.Location.column+" "+"Class "+v.name+" is redefined");
                System.exit(1);
            }

            if (keyword.contains(((ClassDefNode) u).ID)|| ((ClassDefNode) u).ID.equals("main")){
                System.err.println(u.Location.line+" "+u.Location.column+" \""+((ClassDefNode) u).ID+"\" is a reserved word");
                System.exit(1);
            }

            ((GeneralScope)v).clas.put(((ClassDefNode) u).ID, tmp);
            for (int i = 0; i < ((ClassDefNode) u).State.size(); ++i) {
                dfs(((ClassDefNode) u).State.sons(i), tmp);
            }
            for (int i = 0; i < ((ClassDefNode) u).State.ParaList.size(); ++i)
                tmp.var.get(((ClassDefNode) u).State.ParaList.get(i).ID).num = i;

        }

        else if (u instanceof ClassConstNode){
            boolean IsCon = false;
            if (!((ClassConstNode) u).ID.equals(v.name)){
                System.err.println(u.Location.line+" "+u.Location.column+" Construction's name is wrong");
                System.exit(1);
            }
            FuncScope tmp = new FuncScope();
            tmp.parent = v;
            tmp.name = ((ClassConstNode) u).ID;
            tmp.dim = 0;
            tmp.Return = "void";
            ((ClassScope)v).func.put(((ClassConstNode) u).ID, tmp);
            for (int i = 0; i < u.size(); ++i) {
                if (u.sons(i) instanceof JumpNode && ((JumpNode) u.sons(i)).Label == Jump.Return){
                    System.err.println(u.sons(i).Location.line+" "+u.sons(i).Location.column+"cannot return any value in a constructor");
                    System.exit(1);
                }
                dfs(u.sons(i), tmp);
            }
        }

        else if (u instanceof ParaNode){
            if (((ParaNode) u).ID.equals("this")){
                System.err.println(u.Location.line+" "+u.Location.column+" \"this\" is a reserved word");
                System.exit(1);
            }
            ParTypeRef tmp = new ParTypeRef();
            tmp.column = u.Location.column;
            tmp.line = u.Location.line;
            tmp.dim = ((ParaNode) u).dim;
            tmp.Type = ((ParaNode) u).Type;
            tmp.ID = ((ParaNode) u).ID;
            tmp.u = (ParaNode)u;

            if (!v.var.isEmpty() && v.var.containsKey(tmp.ID)){
                System.err.println(tmp.line+" "+tmp.column+"Var "+tmp.ID+" is redefined");
                System.exit(1);
            }

            v.var.put(tmp.ID, tmp);
        }

        else if (u instanceof WhileNode){
            LocalScope tmp = new LocalScope();
            dfs(((WhileNode) u).Condition, v);
            ((WhileNode) u).name = "while"+String.valueOf(cntwhile);
            tmp.name = "while"+String.valueOf(cntwhile);
            cntwhile++;
            tmp.parent = v;
            if (((WhileNode) u).Block == null) return;
            if (((WhileNode) u).Block.StateList.size() == 0) dfs(((WhileNode) u).Block, tmp);
            else {
                for (int i = 0; i < ((WhileNode) u).Block.size(); ++i)
                    dfs(((WhileNode) u).Block.sons(i), tmp);
            }
            ((LocalScope)v).sons.put(tmp.name, tmp);
        }

        else if (u instanceof ForNode){
            LocalScope tmp = new LocalScope();
            dfs(((ForNode) u).Expr1, v);
            dfs(((ForNode) u).Expr2, v);
            dfs(((ForNode) u).Expr3, v);
            tmp.parent = v;
            tmp.name = "for"+String.valueOf(cntfor);
            ((ForNode) u).name = "for"+String.valueOf(cntfor);
            cntfor++;
            if (((ForNode) u).Block == null) return;
            if (((ForNode) u).Block.StateList.size() == 0) dfs(((ForNode) u).Block, tmp);
            else {
                for (int i = 0; i < ((ForNode) u).Block.size(); ++i)
                    dfs(((ForNode) u).Block.sons(i), tmp);
            }
            ((LocalScope)v).sons.put(tmp.name, tmp);
        }

        else if (u instanceof ConditionNode){
            LocalScope tmp1 = new LocalScope();
            LocalScope tmp2 = new LocalScope();
            dfs(((ConditionNode)u).Condition,v);
            if (((ConditionNode) u).Then == null) return;
            tmp1.name = "then"+String.valueOf(cntthen);
            ((ConditionNode) u).Then.name = "then"+String.valueOf(cntthen);
            cntthen++;
            tmp1.parent = v;
            if (((ConditionNode) u).Then.StateList.size() == 0) dfs(((ConditionNode) u).Then, tmp1);
            else {
                for (int i = 0; i < ((ConditionNode) u).Then.StateList.size(); ++i)
                    dfs(((ConditionNode) u).Then.StateList.get(i), tmp1);
            }
            ((LocalScope)v).sons.put(tmp1.name, tmp1);
            if (((ConditionNode) u).Else != null) {
                tmp2.name = "else"+String.valueOf(cntelse);
                ((ConditionNode) u).Else.name = "else"+String.valueOf(cntelse);
                cntelse++;
                tmp2.parent = v;
                if (((ConditionNode) u).Else.StateList.size() == 0) dfs(((ConditionNode) u).Else, tmp2);
                else {
                    for (int i = 0; i < ((ConditionNode) u).Else.StateList.size(); ++i)
                        dfs(((ConditionNode) u).Else.StateList.get(i), tmp2);
                }
                ((LocalScope) v).sons.put(tmp2.name, tmp2);
            }
        }

        else if (u instanceof StateNode && !(u instanceof ExpressionNode) && !(u instanceof ListExpressionNode) &&
                !(u instanceof ListParaNode) && !(u instanceof JumpNode)){
            LocalScope tmp = new LocalScope();
            tmp.parent = v;
            tmp.name = "state"+String.valueOf(cnt);
            ((StateNode) u).name = "state"+String.valueOf(cnt);
            cnt++;
            for (int i = 0; i < u.size(); ++i){
                dfs(u.sons(i), tmp);
            }
            ((LocalScope)v).sons.put(tmp.name, tmp);
        }

    }

    public Type dfs1(Node u, Scope v) {
        if (u == null) {
            NullType t = new NullType();
            return t;
        }
        u.V = v;
        if (u instanceof ProgNode) {
            for (int i = 0; i < u.size(); ++i) {
                dfs1(u.sons(i), v);
            }
            VoidType t = new VoidType();
            return t;
        }

        else if (u instanceof FuncDefNode) {
            Type t = new NullType();
            FuncScope tmp = ((ClassScope) v).func.get(((FuncDefNode) u).ID);
            if (!(((FuncDefNode) u).Return.equals("int")||((FuncDefNode) u).Return.equals("bool")
                    ||((FuncDefNode) u).Return.equals("string") || ((FuncDefNode) u).Return.equals("void"))){
                if (IsClass(((FuncDefNode) u).Return) == null){
                    System.err.println(u.Location.line+" "+u.Location.column+" Function return type is wrong");
                    System.exit(1);
                }
            }
            boolean ff = false;
            for (int i = 0; i < ((FuncDefNode) u).Body.size(); ++i) {
                dfs1(((FuncDefNode) u).Body.sons(i), tmp);
                if (((FuncDefNode) u).Body.sons(i) instanceof JumpNode && ((JumpNode) ((FuncDefNode) u).Body.sons(i)).Label == Jump.Return) ff = true;
            }
            if (!ff) {
                JumpNode tt = new JumpNode();
                tt.Label = Jump.Return;
                ((FuncDefNode) u).Body.StateList.add(tt);
            }
            u.V = tmp;
            return t;
        }

        else if (u instanceof ClassDefNode) {
            NullType t = new NullType();
            ClassScope tmp = ((GeneralScope) v).clas.get(((ClassDefNode) u).ID);
            for (int i = 0; i < ((ClassDefNode) u).State.size(); ++i) {
                dfs1(((ClassDefNode) u).State.sons(i), tmp);
            }
            u.V = tmp;
            return t;
        }

        else if (u instanceof ClassConstNode) {
            VoidType t = new VoidType();
            FuncScope tmp = ((ClassScope) v).func.get(((ClassConstNode) u).ID);
            for (int i = 0; i < u.size(); ++i) {
                if (u.sons(i) instanceof JumpNode && ((JumpNode) u.sons(i)).Label == Jump.Return) {
                    System.err.println(u.Location.line+" "+u.Location.column+"cannot return any value in a constructor");
                    System.exit(1);
                }
                dfs1(u.sons(i), tmp);
                u.V = tmp;
            }
            return t;
        }

        else if (u instanceof ParaNode) {
            VoidType t = new VoidType();

            if (!((ParaNode) u).Type.equals("int") && !((ParaNode) u).Type.equals("string") && !((ParaNode) u).Type.equals("bool")) {
                ClassScope flag = IsClass(((ParaNode) u).Type);
                if (flag == null){
                    System.err.println(u.Location.line+" "+u.Location.column+((ParaNode) u).Type+" is not defined");
                    System.exit(1);
                }
            }

            if (((ParaNode) u).InitE) {
                Type tmp = dfs1(((ParaNode) u).Init, v);
                if (tmp instanceof NullType && ((ParaNode) u).Type.equals("string") && ((ParaNode) u).dim == 0){
                    System.err.println(u.Location.line+" "+u.Location.column+" string can't be assigned as null");
                    System.exit(1);
                }
                if (!(tmp instanceof NullType) && (!tmp.S.equals(((ParaNode) u).Type) || tmp.dim != ((ParaNode) u).dim)) {
                    System.err.println(u.Location.line+" "+u.Location.column+"var " + ((ParaNode) u).ID + "'s initialization type is wrong");
                    System.exit(1);
                }
            }
            return t;
        }

        else if (u instanceof ListParaNode){
            Type tmp = new VoidType();
            for (int i = 0; i < u.size(); ++i)
                dfs1(u.sons(i), v);
            return tmp;
        }

        else if (u instanceof WhileNode) {
            VoidType t = new VoidType();
            LocalScope tmp = ((LocalScope) v).sons.get(((WhileNode) u).name);
            if (!(dfs1(((WhileNode) u).Condition, v) instanceof BoolType)) {
                System.err.println(u.Location.line+" "+u.Location.column+"While's condition return value is wrong");
                System.exit(1);
            }
            if (((WhileNode) u).Block == null) return t;
            if (((WhileNode) u).Block.StateList.size() == 0) dfs1(((WhileNode) u).Block, tmp);
            else {
                for (int i = 0; i < ((WhileNode) u).Block.size(); ++i)
                    dfs1(((WhileNode) u).Block.sons(i), tmp);
            }
            return t;
        }

        else if (u instanceof ForNode) {
            VoidType t = new VoidType();
            LocalScope tmp = ((LocalScope) v).sons.get(((ForNode) u).name);
            if (((ForNode) u).Expr1 != null) dfs1(((ForNode) u).Expr1, v);
            if (((ForNode) u).Expr2 != null) {
                Type tt = dfs1(((ForNode) u).Expr2, v);
                if (!(tt instanceof BoolType)) {
                    System.err.println(u.Location.line+" "+u.Location.column+"for's condition return value is wrong");
                    System.exit(1);
                }
            }
            if (((ForNode) u).Expr3 != null) dfs1(((ForNode) u).Expr3, v);
            if (((ForNode) u).Block == null) return t;
            if (((ForNode) u).Block.StateList.size() == 0) dfs1(((ForNode) u).Block, tmp);
            else {
                for (int i = 0; i < ((ForNode) u).Block.size(); ++i)
                    dfs1(((ForNode) u).Block.sons(i), tmp);
            }
            return t;
        }

        else if (u instanceof ConditionNode) {
            VoidType t = new VoidType();
            if (!(dfs1(((ConditionNode) u).Condition, v) instanceof BoolType)) {
                System.err.println(u.Location.line+" "+u.Location.column+"if's condition return value is wrong");
                System.exit(1);
            }

            if (((ConditionNode) u).Then == null) return t;
            LocalScope tmp1 = ((LocalScope) v).sons.get(((ConditionNode) u).Then.name);
            if (((ConditionNode) u).Then.StateList.size() == 0) dfs1(((ConditionNode) u).Then, tmp1);
            else {
                for (int i = 0; i < ((ConditionNode) u).Then.StateList.size(); ++i)
                    dfs1(((ConditionNode) u).Then.StateList.get(i), tmp1);
            }

            if (((ConditionNode) u).Else != null) {
                LocalScope tmp2 = ((LocalScope) v).sons.get(((ConditionNode) u).Else.name);
                if (((ConditionNode) u).Else == null) return t;
                if (((ConditionNode) u).Else.StateList.size() == 0) dfs1(((ConditionNode) u).Else, tmp2);
                else {
                    for (int i = 0; i < ((ConditionNode) u).Else.StateList.size(); ++i)
                        dfs1(((ConditionNode) u).Else.StateList.get(i), tmp2);
                }
            }
            return t;
        }

        else if (u instanceof StateNode && !(u instanceof ExpressionNode) && !(u instanceof JumpNode)) {
            VoidType t = new VoidType();
            if (v == null) return t;
            LocalScope tmp = ((LocalScope) v).sons.get(((StateNode) u).name);
            for (int i = 0; i < u.size(); ++i) {
                dfs1(u.sons(i), tmp);
            }
            return t;
        }

        else if (u instanceof AssignNode) {
            Type t1 = dfs1(((AssignNode)u).Left, v);
            Type t2 = dfs1(((AssignNode)u).Right, v);
            if (!(t2 instanceof NullType) && (t1.dim != t2.dim || !t1.S.equals(t2.S))) {
                System.err.println(u.Location.line+" "+u.Location.column+" the types on both sides of the equation is different");
                System.exit(1);
            }
            if (t1.S.equals("string") && t1.dim == 0 && t2 instanceof NullType) {
                System.err.println(u.Location.line+" "+u.Location.column+" string can't be assigned as null");
                System.exit(1);
            }
            if (((AssignNode) u).Left instanceof ClassNode) {
                if (((ClassNode) ((AssignNode) u).Left).Varname instanceof VarNode || ((ClassNode) ((AssignNode) u).Left).Varname instanceof ArrNode)
                    return t1;
            }
            else if (!(((AssignNode) u).Left instanceof VarNode) && !(((AssignNode) u).Left instanceof ArrNode)){
                System.err.println(u.Location.line+" "+u.Location.column+"this isn't a left value");
                System.exit(1);
            }
            return t1;
        }

        else if (u instanceof AddNode){
            Type t1 = dfs1(((Return_Int)u).Left, v);
            Type t2 = dfs1(((Return_Int)u).Right, v);
            if (t1.dim != 0 || t2.dim != 0 || !t1.S.equals((t2.S)) || (!t1.S.equals("int") && !t1.S.equals("string"))){
                System.err.println(u.Location.line+" "+u.Location.column+"this type can't do this operation");
                System.exit(1);
            }
            if (t1.S.equals("string")) ((AddNode) u).flag = true;
            return t1;
        }

        else if (u instanceof Return_Int){
            Type t1 = dfs1(((Return_Int)u).Left, v);
            Type t2 = dfs1(((Return_Int)u).Right, v);
            if (t1.dim != 0 || t2.dim != 0 || !t1.S.equals((t2.S)) || !t1.S.equals("int")){
                System.err.println(u.Location.line+" "+u.Location.column+"this type can't do this operation");
                System.exit(1);
            }
            return t1;
        }

        else if (u instanceof EquNode || u instanceof NEqNode){
            BoolType t = new BoolType();
            Type t1 = dfs1(((Return_Bool_Str) u).Left, v);
            Type t2 = dfs1(((Return_Bool_Str) u).Right, v);
            if ((!(t1 instanceof  NullType) && !(t2 instanceof NullType)) && (!t1.S.equals(t2.S) || t1.dim != t2.dim)) {
                System.err.println(u.Location.line+" "+u.Location.column+"different type can't be compared");
                System.exit(1);
            }
            if (t1.S.equals("string")) ((Return_Bool_Str)u).flag = true;
            return t;
        }

        else if (u instanceof Return_Bool_Str){
            BoolType t = new BoolType();
            Type t1 = dfs1(((Return_Bool_Str) u).Left, v);
            Type t2 = dfs1(((Return_Bool_Str) u).Right, v);
            if (!t1.S.equals(t2.S) || t1.dim != t2.dim) {
                System.err.println(u.Location.line+" "+u.Location.column+"different type can't be compared");
                System.exit(1);
            }
            if (t1.S.equals("string")) ((Return_Bool_Str) u).flag = true;
            return t;
        }

        else if (u instanceof  Return_Bool){
            BoolType t = new BoolType();
            Type t1 = dfs1(((Return_Bool) u).Left, v);
            Type t2 = dfs1(((Return_Bool) u).Right, v);
            if (!t1.S.equals(t2.S) || t1.dim != t2.dim || !t1.S.equals("bool") || !t2.S.equals("bool")) {
                System.err.println(u.Location.line+" "+u.Location.column+"different type can't be compared");
                System.exit(1);
            }
            return t;
        }

        else if (u instanceof PosNode) {
            Type t = dfs1(((PosNode) u).InnerNode, v);
            if (!(t instanceof IntType)){
                System.err.println(u.Location.line+" "+u.Location.column+"this type can't do this operation");
                System.exit(1);
            }

            if (((PosNode) u).InnerNode instanceof ClassNode) {
                if (((ClassNode) ((PosNode) u).InnerNode).Varname instanceof VarNode || ((ClassNode) ((PosNode) u).InnerNode).Varname instanceof ArrNode)
                    return t;
            }
            else if (!(((PosNode) u).InnerNode instanceof VarNode) && !(((PosNode) u).InnerNode instanceof ArrNode)){
                System.err.println(u.Location.line+" "+u.Location.column+"this isn't a left value, can't ++");
                System.exit(1);
            }

            return t;
        }

        else if (u instanceof LNoNode){
            Type t = dfs1(((LNoNode) u).InnerNode, v);
            if (!(t instanceof BoolType)) {
                System.err.println(u.Location.line+" "+u.Location.column+"this type can't do this operation");
                System.exit(1);
            }
            return t;
        }

        else if (u instanceof PreNode){
            Type t = dfs1(((PreNode) u).InnerNode, v);
            if (!(t instanceof IntType)){
                System.err.println(u.Location.line+" "+u.Location.column+"this type can't do this operation");
                System.exit(1);
            }
            return t;
        }

        else if (u instanceof JumpNode) {
            if (((JumpNode) u).Label == Jump.Return) {
                FuncScope flag = IsReturn(v);
                if (flag == null) {
                    System.err.println(u.Location.line+" "+u.Location.column+"unnecssary return");
                    System.exit(1);
                }
                Type T = dfs1(((JumpNode) u).Return, v);
                if (!(T instanceof NullType) && (!T.S.equals(flag.Return) || T.dim != flag.dim)){
                    System.err.println(u.Location.line+" "+u.Location.column+" function "+flag.name+" return type is wrong");
                    System.exit(1);
                }
                return T;
            }
            else {
                boolean flag = IsOut(v);
                if (flag == false){
                    System.err.println(u.Location.line+" "+u.Location.column+"unnecessary out");
                    System.exit(1);
                }
                VoidType t = new VoidType();
                return t;
            }
        }

        else if (u instanceof NumberNode) {
            IntType t = new IntType();
            t.dim = 0;
            return t;
        }

        else if (u instanceof StrNode) {
            ClassType t = new ClassType("string");
            t.dim = 0;
            return t;
        }

        else if (u instanceof BoolNode) {
            BoolType t = new BoolType();
            t.dim = 0;
            return t;
        }

        else if (u instanceof NullNode){
            NullType t = new NullType();
            t.dim = 0;
            return t;
        }

        else if (u instanceof VarNode){
            if (((VarNode) u).ID.equals("this")) {
                ClassType t1 = InClass(v, false);
                if (t1 == null) {
                    System.err.println(u.Location.line+" "+u.Location.column+"this isn't in a class's function");
                    System.exit(1);
                }
                else return t1;
            }
            Type t = IsVar((VarNode) u, v);
            if (t == null){
                System.err.println(u.Location.line+" "+u.Location.column+((VarNode) u).ID+" is not defined");
                System.exit(1);
            }
            return t;
        }

        else if (u instanceof ArrNode){
            Type t = dfs1(((ArrNode) u).ID, v);
            t.dim--;
            Type t1 = dfs1(((ArrNode) u).Index, v);
            if (!(t1 instanceof IntType)) {
                System.err.println(u.Location.line+" "+u.Location.column+"index shuld be integer");
                System.exit(1);
            }
            return t;
        }

        else if (u instanceof CreateNode){
            Type t = null;
            if (((CreateNode) u).VarTYpe.equals("int")) t = new IntType();
            else if (((CreateNode) u).VarTYpe.equals("string")) t = new ClassType("string");
            else if (((CreateNode) u).VarTYpe.equals("bool")) t = new BoolType();
            else if (IsClass(((CreateNode) u).VarTYpe) != null) t = new ClassType(((CreateNode) u).VarTYpe);
            else {
                System.err.println(u.Location.line+" "+u.Location.column+"This type is not defined");
                System.exit(1);
            }
            for (int i = 0; i < u.size(); ++i) {
                dfs1(u.sons(i), v);
            }
            t.dim = ((CreateNode) u).dim;
            return t;
        }

        else if (u instanceof ClassNode){
            Type t1 = null;
            Type t2 = null;
            t1 = dfs1(((ClassNode) u).ID, v);
            if ((t1.dim != 0)) {
                Node uu = ((ClassNode) u).ID;
                while (!(uu instanceof VarNode)) uu = ((ArrNode)uu).ID;
                Type tt = IsVar((VarNode) uu, v);
                if (!(tt != null && t1.dim != 0 && ((ClassNode) u).Varname instanceof MethodNode
                        && ((MethodNode) ((ClassNode) u).Varname).FuncID.equals("size")) ) {
                    System.err.println(u.Location.line + " " + u.Location.column + "This isn't a class");
                    System.exit(1);
                }
                return t2 = new IntType();
            }


            else {
                ClassScope t = IsClass(t1.S);
                if (((ClassNode) u).Varname instanceof VarNode) {
                    VarTypeRef tt = t.var.get(((VarNode) ((ClassNode) u).Varname).ID);
                    if (tt == null) {
                        System.err.println(u.Location.line + " " + u.Location.column + "This var "+((ClassNode) u).Varname+" is not in " + t1.S);
                        System.exit(1);
                    }
                    if (tt.Type.equals("int")) t2 = new IntType();
                    else if (tt.Type.equals("string")) t2 = new ClassType("string");
                    else if (tt.Type.equals("bool")) t2 = new BoolType();
                    else t2 = new ClassType(tt.Type);
                    t2.dim = tt.dim;
                }
                else if (((ClassNode) u).Varname instanceof ArrNode){
                    int cnt = 0;
                    Node uu = ((ClassNode) u).Varname;
                    while (!(uu instanceof VarNode)) {uu = ((ArrNode)uu).ID; cnt++;}
                    VarTypeRef tt = t.var.get(((VarNode) uu).ID);
                    if (tt == null) {
                        System.err.println(u.Location.line + " " + u.Location.column + "This var "+((VarNode) uu).ID+" is not in " + t1.S);
                        System.exit(1);
                    }
                    if (tt.Type.equals("int")) t2 = new IntType();
                    else if (tt.Type.equals("string")) t2 = new ClassType("string");
                    else if (tt.Type.equals("bool")) t2 = new BoolType();
                    else t2 = new ClassType(tt.Type);
                    t2.dim = tt.dim - cnt;
                }
                else {
                    FuncScope tt = t.func.get(((MethodNode) ((ClassNode) u).Varname).FuncID);
                    if (tt == null) {
                        System.err.println(u.Location.line + " " + u.Location.column + "This function is not in " + t1.S);
                        System.exit(1);
                    }

                    ((MethodNode) ((ClassNode) u).Varname).InClass = t1.S;
                    if (tt.Return.equals("int")) t2 = new IntType();
                    else if (tt.Return.equals("string")) t2 = new ClassType("string");
                    else if (tt.Return.equals("bool")) t2 = new BoolType();
                    else t2 = new ClassType(tt.Return);
                    t2.dim = tt.dim;
                }
                return t2;
            }
        }

        else if (u instanceof MethodNode){
            Type t;
            if (((MethodNode) u).FuncID.equals("main")){
                System.err.println(u.Location.line+" "+u.Location.column+" 'main' can't be called");
                System.exit(1);
            }
            FuncScope flag = IsFunc(((MethodNode) u).FuncID, v);
            if (flag == null) {
                System.err.println(u.Location.line+" "+u.Location.column+"This function isn't defined");
                System.exit(1);
            }
            if (flag.Return.equals("int")) t = new IntType();
            else if (flag.Return.equals("string")) t = new ClassType("string");
            else if (flag.Return.equals("bool")) t = new BoolType();
            else if (flag.Return.equals("void")) t = new VoidType();
            else t = new ClassType(flag.Return);
            if (((MethodNode) u).Argument != null) {
                for (int i = 0; i < ((MethodNode) u).Argument.size(); ++i) {
                    Type tt = dfs1(((MethodNode) u).Argument.sons(i), v);
                    if (tt instanceof NullType) continue;
                    if (tt.dim != flag.para.get(i).dim || !tt.S.equals(flag.para.get(i).Type)) {
                        System.err.println((((MethodNode) u).Argument.sons(i)).Location.line + " " +
                                ((MethodNode) u).Argument.sons(i).Location.column + "method's paralist type is wrong");
                        System.exit(1);
                    }
                }
            }
            t.dim = flag.dim;
            return t;
        }
        return null;
    }



}


abstract class Type{
    int dim = 0;
    String S;
}
class IntType extends Type{
    IntType(){
        S = "int";
    }
}
class BoolType extends Type{
    BoolType(){
        S = "bool";
    }
}
class VoidType extends Type{
    VoidType(){
        S = "void";
    }
}
class NullType extends Type{}
class ClassType extends Type{
    ClassType(String S) {
        this.S = S;
    }
}