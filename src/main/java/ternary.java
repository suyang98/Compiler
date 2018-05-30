import java.util.*;

enum Opcode {
    malloc, mov, add, sub, imul, div, mod, sal, sar, setg, setge, setl, setle, sete, setne, movzx, and, xor, or,
    not, neg, inc, dec, jz, jnz, jmp, call, ret, size, cmp, mov_add, push, pop, leave, test
}


class IR {
    BasicBlock start;
    List<String> GV= new ArrayList();
    Map<String, String> ST = new HashMap<>();
    Map<String, FuncBlock> Blocks = new HashMap<>();
    Map<String, BasicBlock> All = new HashMap<>();
    FuncBlock gen_var = new FuncBlock();
    Map<String, String> signal = new HashMap<>();
}

class BasicBlock{
    ArrayList<Tern> content = new ArrayList<>();
    boolean flag = true;
    BasicBlock Next = null;
    String name;

    void print(IR root){
        System.out.println(name+":");
        if (name.indexOf("main") != -1) {
            for (int i = 0; i < root.gen_var.content.size(); ++i){
                Tern t = root.gen_var.content.get(i);
                System.out.print("\t" + t.op+"\t");
                if (t.src1 != null) System.out.print(t.src1.contxt);
                else System.out.print("     ");
                if (t.src2 != null) System.out.print("," + t.src2.contxt);
                else System.out.print("     ");
                if (t.des != null) System.out.println("," + t.des.contxt);
                else System.out.println("     ");
            }
        }
        for (int i = 0; i < content.size(); ++i){
            Tern t = content.get(i);
            System.out.print("\t" + t.op+"\t");
            if (t.src1 != null) System.out.print(t.src1.contxt);
            else System.out.print("     ");
            if (t.src2 != null) System.out.print("," + t.src2.contxt);
            else System.out.print("     ");
            if (t.des != null) System.out.println("," + t.des.contxt);
            else System.out.println("     ");

        }
        flag = false;
    }

    void gen(IR root, FuncBlock f){
        for (int i = 0; i < content.size(); ++i){
            Tern t = content.get(i);
            t.num = f.inst_num++;
            f.all.add(t);
        }
    }
}

class FuncBlock extends BasicBlock{
    String FuncName;
    List<Tern> all = new ArrayList<>();
    int inst_num = 0;
    int var_num = 0;
    boolean [] tag = new boolean [16];
    Map<String, reg> var = new HashMap<>();

}

class Tern {
    Opcode op;
    tnode src1;
    tnode src2;
    tnode des;
    int num;
    List<Tern> pred = new ArrayList<>();
    List<Tern> next = new ArrayList<>();
    List<reg> def = new ArrayList<>();
    List<reg> use = new ArrayList<>();
    Map<String, reg> in = new HashMap<>();
    Map<String, reg> out = new HashMap<>();
    void print(FuncBlock f){
        if (des != null) {
        //mov_add
            if (src1 instanceof reg && src1.contxt.indexOf("%") != -1) {((reg)src1).reg = "rax";}
            if (des instanceof reg && des.contxt.indexOf("%") != -1) {((reg)des).reg = "rcx";}
            if (((reg)src1).Is_Point) System.out.println("\tmov\t[" + ((reg)src1).reg + "],[" + f.var.get(src1.contxt).memory + "]");
            else System.out.println("\tmov\t" + ((reg)src1).reg + ",[" + f.var.get(src1.contxt).memory + "]");

            System.out.println("\tmov\t" + ((reg)des).reg + ",[" + ((reg) src1).reg +"+"+ src2.contxt+"]");

            if (((reg)des).Is_Point) {
                System.out.println("\tlea\trbx,["+f.var.get(des.contxt).memory+"]");
                System.out.println("\tmov\t[rbx],"+((reg)des).reg);
            }
            else System.out.println("\tmov\t[" + f.var.get(des.contxt).memory +"]," + ((reg)des).reg);
        }
        else if (src2 != null) {
            if (src1 instanceof reg && src1.contxt.indexOf("%") != -1) ((reg)src1).reg = "rax";
            if (src2 instanceof reg && src2.contxt.indexOf("%") != -1) ((reg)src2).reg = "rcx";
            for (int i = 0; i < use.size(); ++i){
                reg tmp = f.var.get(use.get(i).contxt);
                if (use.get(i).contxt.equals(src1.contxt)) {
                    if (((reg)src1).Is_Point) System.out.println("\tmov\t[" + ((reg)src1).reg + "],[" + tmp.memory + "]");
                    else System.out.println("\tmov\t" + ((reg)src1).reg + ",[" + tmp.memory + "]");
                }
                else {
                    if (((reg)src2).Is_Point) System.out.println("\tmov\t[" + ((reg)src2).reg + "],[" + tmp.memory + "]");
                    else System.out.println("\tmov\t" + ((reg)src2).reg + ",[" + tmp.memory + "]");
                }
            }
            System.out.print("\t"+op +"\t");
            if (src1 instanceof reg && src1.contxt.indexOf("%") != -1) {System.out.print("rax,");((reg)src1).reg = "rax";}
            else {System.out.print(src1.contxt +","); }
            if (src2 instanceof reg && src2.contxt.indexOf("%") != -1) {System.out.println("rcx");((reg)src2).reg = "rcx";}
            else System.out.println(src2.contxt);
            for (int i = 0; i < def.size(); ++i){
                reg tmp = f.var.get(def.get(i).contxt);
                if (def.get(i).contxt.equals(src1.contxt)) {
                    if (((reg)src1).Is_Point){
                        System.out.println("\tlea\trbx,["+tmp.memory+"]");
                        System.out.println("\tmov\t[rbx],"+((reg)src1).reg);
                    }
                    else System.out.println("\tmov\t["+ tmp.memory +"]," + ((reg)src1).reg);
                }
                else {
                    if (((reg)src2).Is_Point){
                        System.out.println("\tlea\trbx,["+ tmp.memory+"]");
                        System.out.println("\tmov\t[rbx],"+((reg)src2).reg);
                    }
                    else System.out.println("\tmov\t["+ tmp.memory +"]," + ((reg)src2).reg);
                }
            }

        }
        else if (src1 != null){
            if (src1 instanceof reg && src1.contxt.indexOf("%") != -1) ((reg)src1).reg = "rax";
            for (int i = 0; i < use.size(); ++i){
                reg tmp = f.var.get(use.get(i).contxt);
                if (((reg)src1).Is_Point) System.out.println("\tmov\t[" + ((reg)src1).reg + "],[" + tmp.memory + "]");
                else System.out.println("\tmov\t" + ((reg)src1).reg + ",[" + tmp.memory + "]");
            }
            System.out.print("\t"+op +"\t");
            if (src1 instanceof reg && src1.contxt.indexOf("%") != -1) {System.out.println("rax");((reg)src1).reg = "rax";}
            else {System.out.println(src1.contxt); }
            for (int i = 0; i < def.size(); ++i){
                reg tmp = f.var.get(def.get(i).contxt);
                if (((reg)src1).Is_Point){
                    System.out.println("\tlea\trbx,["+tmp.memory+"]");
                    System.out.println("\tmov\t[rbx],"+((reg)src1).reg);
                }
                else System.out.println("\tmov\t["+ tmp.memory +"]," + ((reg)src1).reg);
            }
        }
        else System.out.println("\t" + op);
    }

}

abstract class tnode {
    String contxt;
}

class reg extends tnode{
    String reg;
    String memory;
    boolean Is_Point = false;
}

class imm extends tnode{
}

class strn extends tnode{
}

class labn extends tnode{}

class mem extends tnode{
    reg r;
}

public class ternary {
    IR root = new IR();
    int cnt = 0;
    int bcnt = 0;
    boolean flag = false;
    Tern flag_tern = null;
    Stack<BasicBlock> label = new Stack<>();
    Stack<String> Continue = new Stack<>();
    Stack<String> Break = new Stack<>();
    GeneralScope General;
    Register r;

    reg find_var(String ID, Scope v){
        reg tmp = null;
        if (v.var.size()!= 0 && v.var.get(ID) != null) tmp = v.var.get(ID).IR_name;
        if (tmp != null) {
            return tmp;
        }
        else if (v.parent!=null) return find_var(ID, v.parent);
        else return null;
    }

    VarTypeRef find_var_type(String ID, Scope v){
        VarTypeRef tmp = null;
        if (v.var.size()!= 0) tmp = v.var.get(ID);
        if (tmp != null) {
            return tmp;
        }
        else if (v.parent!=null) return find_var_type(ID, v.parent);
        else return null;
    }

    void alloc(){
        printcontext();
        System.out.println("\n");
        add_all();
        for (int i = 0; i < root.gen_var.content.size(); ++i)
            use_def(root.gen_var.content.get(i), root.gen_var);
        for (Object obj: root.Blocks.keySet()) {
            String key = (String) obj;
            FuncBlock tmp = root.Blocks.get(key);
            //flow(tmp);
            for (int i = 0; i < tmp.all.size(); ++i)
                use_def(tmp.all.get(i), tmp);
            for (Object k: tmp.var.keySet()){
                if (tmp.var.get(k).memory == null) tmp.var_num++;
            }
            //balance(tmp);

        }

    }

    void printcontext(){
        for (Object obj: root.Blocks.keySet()){
            String key = (String) obj;
            BasicBlock tmp = root.Blocks.get(key);
            print_dfs(tmp);
        }
    }



    void print_dfs(BasicBlock tmp){
        if (tmp.flag) {
            tmp.print(root);
            if (tmp.Next != null){
                print_dfs(tmp.Next);
            }
        }
    }

    void add_all(){
        for (Object obj: root.Blocks.keySet()){
            String key = (String) obj;
            FuncBlock tmp = root.Blocks.get(key);
            add_dfs(tmp, tmp);
        }
    }


    void add_dfs(BasicBlock tmp, FuncBlock f){
        for (int i = 0; i < tmp.content.size(); ++i)
            f.all.add(tmp.content.get(i));
        if (tmp.Next != null){
            add_dfs(tmp.Next, f);
        }
    }

    void flow(FuncBlock tmp){
        Tern pre = null;
        for (int i = 0; i < tmp.all.size(); ++i){
            Tern u = tmp.all.get(i);
            use_def(u, tmp);
            if (pre != null) {u.pred.add(pre); pre.next.add(u);}
            if (u.op == Opcode.jz || u.op == Opcode.jnz) {
                root.All.get(u.src1).content.get(0).pred.add(u);
                u.next.add(root.All.get(u.src1).content.get(0));
            }
            if (u.op == Opcode.jmp) {
                root.All.get(u.src1).content.get(0).pred.add(u);
                pre = null;
                continue;
            }
            pre = u;
        }

    }

    void use_def(Tern u, FuncBlock f){
        if (u.src1 != null && u.src1 instanceof reg && (u.src1.contxt.indexOf("%") != -1)) f.var.put(u.src1.contxt, (reg)u.src1);
        if (u.src2 != null && u.src2 instanceof reg && (u.src2.contxt.indexOf("%") != -1)) f.var.put(u.src2.contxt, (reg)u.src2);
        if (u.op == Opcode.mov_add) {
            if (u.des instanceof reg && u.des.contxt.indexOf("%") != -1) u.def.add((reg) u.des);
            if (u.src1 instanceof reg && u.src1.contxt.indexOf("%") != -1) u.use.add((reg) u.src1);
            if (u.src2 instanceof reg && u.src2.contxt.indexOf("%") != -1) u.use.add((reg) u.src2);
        }
        if (u.op == Opcode.mov) {
            if (u.src1 instanceof reg && u.src1.contxt.indexOf("%") != -1) u.def.add((reg) u.src1);
            if (u.src2 instanceof reg && u.src2.contxt.indexOf("%") != -1) u.use.add((reg) u.src2);
        }
        if (u.op == Opcode.add || u.op == Opcode.sub || u.op == Opcode.imul || u.op == Opcode.sal || u.op == Opcode.sar
                || u.op == Opcode.and || u.op == Opcode.or || u.op == Opcode.xor) {
            if (u.src1 instanceof reg && u.src1.contxt.indexOf("%") != -1) u.use.add((reg) u.src1);
            if (u.src2 instanceof reg && u.src2.contxt.indexOf("%") != -1) u.use.add((reg) u.src2);
            if (u.src1 instanceof reg && u.src1.contxt.indexOf("%") != -1) u.def.add((reg) u.src1);
        }
        if (u.op == Opcode.cmp || u.op == Opcode.test){
            if (u.src1 instanceof reg && u.src1.contxt.indexOf("%") != -1) u.use.add((reg) u.src1);
            if (u.src2 instanceof reg && u.src2.contxt.indexOf("%") != -1) u.use.add((reg) u.src2);
        }
        if (u.op == Opcode.not || u.op == Opcode.neg || u.op == Opcode.inc || u.op == Opcode.dec){
            if (u.src1 instanceof reg && u.src1.contxt.indexOf("%") != -1) u.def.add((reg) u.src1);
            if (u.src1 instanceof reg && u.src1.contxt.indexOf("%") != -1) u.use.add((reg) u.src1);
        }
        if (u.op == Opcode.sete || u.op == Opcode.setg || u.op == Opcode.setge || u.op == Opcode.setl
                || u.op == Opcode.setle || u.op == Opcode.setne || u.op == Opcode.pop) {
            if (u.src1 instanceof reg && u.src1.contxt.indexOf("%") != -1) u.def.add((reg) u.src1);
        }
        if (u.op == Opcode.push){
            if (u.src1 instanceof reg && u.src1.contxt.indexOf("%") != -1) u.use.add((reg) u.src1);
        }

    }

    void balance(FuncBlock tmp){
        boolean need = true;
        while (need){
            need = false;
            for (int i = tmp.all.size()-1; i >= 0; --i){
                Tern u = tmp.all.get(i);
                for (int j = 0; j < u.next.size(); ++j){
                    Tern t = u.next.get(j);
                    for (Object key: t.in.keySet()){
                        reg tt = t.in.get(key);
                        if (u.out.get(tt.contxt) == null){
                            need = true;
                            u.out.put(tt.contxt, tt);
                        }
                    }
                }
                for (int j = 0; j < u.use.size(); ++j){
                    reg tt = u.use.get(j);
                    if (u.in.get(tt.contxt) == null){
                        need = true;
                        u.in.put(tt.contxt, tt);
                    }
                    else break;
                }
                for (Object key: u.out.keySet()){
                    boolean flag = false;
                    for (int j = 0; j < u.def.size(); ++j)
                        if (u.def.get(j).contxt.equals(key)) {flag = true; break;}
                    if (flag) continue;
                    reg tt = u.out.get(key);
                    if (u.in.get(key) == null){
                        need = true;
                        u.in.put(tt.contxt, tt);
                    }
                }
            }
        }

    }

    void color(FuncBlock tmp){

    }

    tnode define_arr(CreateNode u, BasicBlock v, int i){
//        Tern tmp1 = new Tern();
//        tmp1.op = Opcode.add;
//        tmp1.src1 = dfs(u.Index.get(i), v);
//        tmp1.src2 = new imm();
//        tmp1.src2.contxt = "1";
//        v.content.add(tmp1);
//        Tern tmp4 = new Tern();
//        tmp4.op = Opcode.imul;
//        tmp4.src1 = tmp1.src1;
//        tmp4.src2 = new imm();
//        tmp4.src2.contxt = "8";
//        v.content.add(tmp4);
//        Tern tmp2 = new Tern();
//        tmp2.op = Opcode.mov;
//        tmp2.src1 = new reg();
//        tmp2.src1.contxt = "rdi";
//        tmp2.src2 = tmp1.src1;
//        v.content.add(tmp2);
//        Tern tmp3 = new Tern();
//        tmp3.op = Opcode.call;
//        tmp3.src1 = new reg();
//        tmp3.src1.contxt = "malloc";
//        Tern tmp5 = new Tern();
//        tmp5.op = Opcode.lea;
//        tmp5.src1 =
//        tmp5.src2 = tmp1.src1;
//        if (i+1 < u.Index.size()) define_arr(u, , i+1);
        return null;
    }

    tnode dfs(Node u, BasicBlock v){
        if (u == null) return null;
//        if (u instanceof StateNode && !label.empty()){
//            v = label.pop();
//        }

        if (u instanceof ProgNode){
            for (int i = 0; i < ((ProgNode) u).para_size(); ++i){
                dfs(((ProgNode) u).ParaList.get(i), root.gen_var);
            }
            for(int i = 0; i < u.size()-((ProgNode) u).para_size(); ++i){
                dfs(u.sons(i), null);
            }
            return null;
        }

        else if (u instanceof ClassDefNode){
            for (int i = 0; i < ((ClassDefNode) u).State.size(); ++i){
                dfs(((ClassDefNode) u).State.sons(i), null);
            }
            return null;
        }

        else if (u instanceof ClassConstNode){
            FuncBlock tmp = new FuncBlock();
            if (u.V.IR_name == null) {
                tmp.FuncName = ((FuncDefNode) u).ID+String.valueOf(bcnt);
                bcnt++;
            }
            else  tmp.FuncName = u.V.IR_name;
            root.Blocks.put(tmp.FuncName, tmp);
            tmp.name = tmp.FuncName;
            v = tmp;
            for (int i = 0; i < ((ClassConstNode) u).Body.size(); ++i){
                Node tt = ((ClassConstNode) u).Body.sons(i);
                dfs(tt, v);
                if (tt instanceof ForNode || tt instanceof WhileNode || tt instanceof ConditionNode){
                    v = label.pop();
                }
            }
            u.V.name = tmp.FuncName;
            return null;
        }

        else if (u instanceof FuncDefNode){
            FuncBlock tmp = new FuncBlock();
            if (u.V.IR_name == null) {
                u.V.IR_name = tmp.FuncName = ((FuncDefNode) u).ID;
                for (int i = 0; i < ((FuncScope)u.V).para.size(); ++i){
                    if (i < 6) {
                        ((FuncScope) u.V).para.get(i).IR_name = new reg();
                        ((FuncScope) u.V).para.get(i).IR_name.contxt = r.param(i);
                        ((FuncScope) u.V).var.get(((FuncScope) u.V).para.get(i).ID).IR_name = ((FuncScope) u.V).para.get(i).IR_name;
                        cnt++;
                    }
                }
                ((FuncScope) u.V).Return_IR_name = "%f"+((FuncDefNode) u).ID+String.valueOf(cnt);
                cnt++;
            }
            else tmp.FuncName = u.V.IR_name;
            root.Blocks.put(tmp.FuncName, tmp);
            tmp.name = tmp.FuncName;
            v = tmp;
            for (int i = 0; i < ((FuncDefNode)u).Body.size(); ++i){
                Node tt = ((FuncDefNode) u).Body.sons(i);
                dfs(tt, v);
                if (tt instanceof ForNode || tt instanceof WhileNode || tt instanceof ConditionNode){
                    v = label.pop();
                }
            }
            if (((FuncDefNode)u).ID.equals("main")){
                root.start = tmp;
                u.V.IR_name = tmp.FuncName;
                return null;
            }
            u.V.IR_name = tmp.FuncName;
            return null;
        }

        else if (u instanceof ParaNode){
            if (u.V instanceof GeneralScope){
                if (((ParaNode) u).InitE) {
                    Tern tmp = new Tern();
                    tmp.op = Opcode.mov;
                    tmp.src1 = new reg();
                    tmp.src1.contxt = "%v"+((ParaNode) u).ID + String.valueOf(cnt);
                    cnt++;
                    ((reg) tmp.src1).memory = ((ParaNode) u).ID;
                    u.V.var.get(((ParaNode) u).ID).IR_name.memory = ((reg) tmp.src1).memory;
                    u.V.var.get(((ParaNode) u).ID).IR_name.contxt = ((reg) tmp.src1).contxt;
                    tmp.src2 = dfs(((ParaNode) u).Init, v);
                    v.content.add(tmp);
                }
                root.GV.add(((ParaNode) u).ID);
            }
            else if (((ParaNode) u).InitE /*&& !(((ParaNode) u).Init instanceof CreateNode)*/) {
                Tern t = new Tern();
                t.op = Opcode.mov;
                t.src1 = new reg();
                ((reg) t.src1).contxt = "%v"+((ParaNode) u).ID + String.valueOf(cnt);
                cnt++;
                u.V.var.get(((ParaNode) u).ID).IR_name.contxt = t.src1.contxt;
                t.src2 = dfs(((ParaNode) u).Init, v);
                v.content.add(t);
                return null;
            }
            else {
                u.V.var.get(((ParaNode) u).ID).IR_name.contxt = "%v" +((ParaNode) u).ID + String.valueOf(cnt);
                cnt++;
            }
        }

        else if (u instanceof GreNode){
            Tern tmp = new Tern();
            tmp.op = Opcode.cmp;
            tmp.src1 = dfs(((GreNode) u).Left, v);
            tmp.src2 = dfs(((GreNode) u).Right, v);
            Tern tmp2 = new Tern();
            tmp2.op = Opcode.setg;
            tmp2.src1 = new reg();
            tmp2.src1.contxt = "al"; //"%v" + String.valueOf(cnt);cnt++;
            Tern tmp3 = new Tern();
            tmp3.op = Opcode.movzx;
            tmp3.src1 = new reg();
            tmp3.src1.contxt = "rax"; //"%v" + String.valueOf(cnt);cnt++;
            tmp3.src2 = tmp2.src1;
            v.content.add(tmp);
            v.content.add(tmp2);
            v.content.add(tmp3);
            return tmp3.src1;
        }

        else if (u instanceof GAENode){
            Tern tmp = new Tern();
            tmp.op = Opcode.cmp;
            tmp.src1 = dfs(((GAENode) u).Left, v);
            tmp.src2 = dfs(((GAENode) u).Right, v);
            Tern tmp2 = new Tern();
            tmp2.op = Opcode.setge;
            tmp2.src1 = new reg();
            tmp2.src1.contxt = "al"; //"%v" + String.valueOf(cnt);cnt++;
            Tern tmp3 = new Tern();
            tmp3.op = Opcode.movzx;
            tmp3.src1 = new reg();
            tmp3.src1.contxt = "rax"; //"%v" + String.valueOf(cnt);cnt++;
            tmp3.src2 = tmp2.src1;
            v.content.add(tmp);
            v.content.add(tmp2);
            v.content.add(tmp3);
            return tmp3.src1;
        }

        else if (u instanceof LesNode){
            Tern tmp = new Tern();
            tmp.op = Opcode.cmp;
            tmp.src1 = dfs(((LesNode) u).Left, v);
            tmp.src2 = dfs(((LesNode) u).Right, v);
            Tern tmp2 = new Tern();
            tmp2.op = Opcode.setl;
            tmp2.src1 = new reg();
            tmp2.src1.contxt = "al"; //"%v" + String.valueOf(cnt);cnt++;
            Tern tmp3 = new Tern();
            tmp3.op = Opcode.movzx;
            tmp3.src1 = new reg();
            tmp3.src1.contxt = "rax"; //"%v" + String.valueOf(cnt);cnt++;
            tmp3.src2 = tmp2.src1;
            v.content.add(tmp);
            v.content.add(tmp2);
            v.content.add(tmp3);
            return tmp3.src1;
        }

        else if (u instanceof LAENode){
            Tern tmp = new Tern();
            tmp.op = Opcode.cmp;
            tmp.src1 = dfs(((LAENode) u).Left, v);
            tmp.src2 = dfs(((LAENode) u).Right, v);
            Tern tmp2 = new Tern();
            tmp2.op = Opcode.setle;
            tmp2.src1 = new reg();
            tmp2.src1.contxt = "al"; //"%v" + String.valueOf(cnt);cnt++;
            Tern tmp3 = new Tern();
            tmp3.op = Opcode.movzx;
            tmp3.src1 = new reg();
            tmp3.src1.contxt = "rax"; //"%v" + String.valueOf(cnt);cnt++;
            tmp3.src2 = tmp2.src1;
            v.content.add(tmp);
            v.content.add(tmp2);
            v.content.add(tmp3);
            return tmp3.src1;
        }


        else if (u instanceof EquNode){
            Tern tmp = new Tern();
            tmp.op = Opcode.cmp;
            tmp.src1 = dfs(((EquNode) u).Left, v);
            tmp.src2 = dfs(((EquNode) u).Right, v);
            Tern tmp2 = new Tern();
            tmp2.op = Opcode.sete;
            tmp2.src1 = new reg();
            tmp2.src1.contxt = "al"; //"%v" + String.valueOf(cnt);cnt++;
            Tern tmp3 = new Tern();
            tmp3.op = Opcode.movzx;
            tmp3.src1 = new reg();
            tmp3.src1.contxt = "rax"; //"%v" + String.valueOf(cnt);cnt++;
            tmp3.src2 = tmp2.src1;
            v.content.add(tmp);
            v.content.add(tmp2);
            v.content.add(tmp3);
            return tmp3.src1;
        }

        else if (u instanceof NEqNode){
            Tern tmp = new Tern();
            tmp.op = Opcode.cmp;
            tmp.src1 = dfs(((NEqNode) u).Left, v);
            tmp.src2 = dfs(((NEqNode) u).Right, v);
            Tern tmp2 = new Tern();
            tmp2.op = Opcode.setne;
            tmp2.src1 = new reg();
            tmp2.src1.contxt = "al"; //"%v" + String.valueOf(cnt);cnt++;
            Tern tmp3 = new Tern();
            tmp3.op = Opcode.movzx;
            tmp3.src1 = new reg();
            tmp3.src1.contxt = "rax"; //"%v" + String.valueOf(cnt);cnt++;
            tmp3.src2 = tmp2.src1;
            v.content.add(tmp);
            v.content.add(tmp2);
            v.content.add(tmp3);
            return tmp3.src1;
        }

        else if (u instanceof InfixExpressionNode){
            Tern tmp = new Tern();
            tmp.src2 = dfs(((InfixExpressionNode) u).Right, v);
            tmp.src1 = dfs(((InfixExpressionNode) u).Left, v);
            if (u instanceof AssignNode) {
                tmp.op = ((InfixExpressionNode) u).op;
                v.content.add(tmp);
            }
            else {
                if (tmp.src1 instanceof imm){
                    tnode t = tmp.src1;
                    tmp.src1 = tmp.src2;
                    tmp.src2 = t;
                }
                Tern tmp0 = new Tern();
                tmp0.op = Opcode.mov;
                tmp0.src2 = tmp.src1;
                tmp0.src1 = new reg();
                ((reg) tmp0.src1).contxt = "%v" + String.valueOf(cnt);
                cnt++;
                tmp.op = ((InfixExpressionNode) u).op;
                //tmp.src2 = tmp.src2;
                tmp.src1 = tmp0.src1;
                v.content.add(tmp0);
                v.content.add(tmp);
            }
            if (flag) {v.content.add(flag_tern); flag_tern = null; flag = false;}
            return tmp.src1;
        }

        else if (u instanceof PosNode){
            Tern tmp = new Tern();
            tmp.src1 = dfs(((PosNode) u).InnerNode, v);
            if (((PosNode) u).op == Opcode.dec || ((PosNode) u).op == Opcode.inc) {
                if (((PosNode) u).Is_Return) {
                    flag = true;
                    flag_tern = new Tern();
                    flag_tern.op = ((PosNode) u).op;
                    flag_tern.src1 = tmp.src1;
                    return tmp.src1;
                }
            }
            tmp.op = ((PosNode) u).op;
            v.content.add(tmp);
            if (flag) {v.content.add(flag_tern); flag_tern = null; flag = false;}
            return tmp.src1;
        }

        else if (u instanceof PreNode){
            Tern tmp = new Tern();
            tmp.src1 = dfs(((PreNode) u).InnerNode, v);
            tmp.op = ((PreNode) u).op;
            v.content.add(tmp);
            if (flag) {v.content.add(flag_tern); flag_tern = null; flag = false;}
            return tmp.src1;
        }

        else if (u instanceof ConditionNode) {
            if (((ConditionNode) u).Then == null && ((ConditionNode) u).Else == null) return null;
            Tern tmp1 = new Tern();
            tmp1.op = Opcode.test;
            tmp1.src1 = tmp1.src2 = dfs(((ConditionNode) u).Condition, v);
            v.content.add(tmp1);

            if (((ConditionNode) u).Then != null && ((ConditionNode) u).Else != null) {
                Tern tmp2 = new Tern();
                tmp2.op = Opcode.jnz;
                Tern tmp3 = new Tern();
                tmp3.op = Opcode.jz;
                v.content.add(tmp2);
                v.content.add(tmp3);
                BasicBlock btmp1 = new BasicBlock();
                BasicBlock btmp2 = new BasicBlock();
                BasicBlock btmp3 = new BasicBlock();
                btmp1.name = "then" + String.valueOf(bcnt);
                btmp2.name = "else" + String.valueOf(bcnt);
                bcnt++;
                btmp3.name = "L" + String.valueOf(bcnt);
                bcnt++;
                v.Next = btmp1;
                btmp1.Next = btmp2;
                btmp2.Next = btmp3;
                root.All.put(btmp1.name, btmp1);
                root.All.put(btmp2.name, btmp2);
                root.All.put(btmp3.name, btmp3);
                tmp2.src1 = new labn();
                tmp2.src1.contxt = btmp1.name;
                LocalScope tt1 = ((LocalScope)u.V).sons.get(((ConditionNode) u).Then.name);
                tt1.IR_name = tmp2.src1.contxt;
                tmp3.src1 = new labn();
                tmp3.src1.contxt = btmp2.name;
                LocalScope tt2 = ((LocalScope)u.V).sons.get(((ConditionNode) u).Else.name);
                tt2.IR_name = tmp3.src1.contxt;
                if (((ConditionNode) u).Then.StateList.size() == 0) dfs(((ConditionNode) u).Then, btmp1);
                else {
                    BasicBlock ttt = btmp1;
                    for (int i = 0; i < ((ConditionNode) u).Then.size(); ++i) {
                        Node tt = ((ConditionNode) u).Then.sons(i);
                        dfs(tt, ttt);
                        if (tt instanceof ForNode || tt instanceof WhileNode || tt instanceof ConditionNode){
                            ttt = label.pop();
                        }
                    }
                }
                Tern tmp4 = new Tern();
                tmp4.op = Opcode.jmp;
                tmp4.src1 = new labn();
                tmp4.src1.contxt = btmp3.name;
                btmp1.content.add(tmp4);
                if (((ConditionNode) u).Else.StateList.size() == 0) dfs(((ConditionNode) u).Else, btmp2);
                else{
                    BasicBlock ttt = btmp2;
                    for (int i = 0; i < ((ConditionNode) u).Else.size(); ++i) {
                        Node tt = ((ConditionNode) u).Else.sons(i);
                        dfs(tt, ttt);
                        if (tt instanceof ForNode || tt instanceof WhileNode || tt instanceof ConditionNode){
                            ttt = label.pop();
                        }
                    }
                }
                label.push(btmp3);
                return null;
            }
            else if (((ConditionNode) u).Then != null && ((ConditionNode) u).Else == null){
                Tern tmp2 = new Tern();
                tmp2.op = Opcode.jnz;
                Tern tmp3 = new Tern();
                tmp3.op = Opcode.jz;
                v.content.add(tmp2);
                v.content.add(tmp3);
                BasicBlock btmp1 = new BasicBlock();
                BasicBlock btmp3 = new BasicBlock();
                btmp1.name = "then" + String.valueOf(bcnt);
                bcnt++;
                btmp3.name = "L" + String.valueOf(bcnt);
                bcnt++;
                v.Next = btmp1;
                btmp1.Next = btmp3;
                root.All.put(btmp1.name, btmp1);
                root.All.put(btmp3.name, btmp3);
                tmp2.src1 = new labn();
                tmp2.src1.contxt = btmp1.name;
                LocalScope tt1 = ((LocalScope)u.V).sons.get(((ConditionNode) u).Then.name);
                tt1.IR_name = tmp2.src1.contxt;
                tmp3.src1 = new labn();
                tmp3.src1.contxt = btmp3.name;
                if (((ConditionNode) u).Then.StateList.size() == 0) dfs(((ConditionNode) u).Then, btmp1);
                else {
                    BasicBlock ttt = btmp1;
                    for (int i = 0; i < ((ConditionNode) u).Then.size(); ++i) {
                        Node tt = ((ConditionNode) u).Then.sons(i);
                        dfs(tt, ttt);
                        if (tt instanceof ForNode || tt instanceof WhileNode || tt instanceof ConditionNode){
                            ttt = label.pop();
                        }
                    }

                }
                label.push(btmp3);
                return null;
            }
            else {
                Tern tmp2 = new Tern();
                tmp2.op = Opcode.jnz;
                Tern tmp3 = new Tern();
                tmp3.op = Opcode.jz;
                v.content.add(tmp2);
                v.content.add(tmp3);
                BasicBlock btmp2 = new BasicBlock();
                BasicBlock btmp3 = new BasicBlock();
                btmp2.name = "else" + String.valueOf(bcnt);
                bcnt++;
                btmp3.name = "L" + String.valueOf(bcnt);
                bcnt++;
                v.Next = btmp2;
                btmp2.Next = btmp3;
                root.All.put(btmp2.name, btmp2);
                root.All.put(btmp3.name, btmp3);
                tmp2.src1 = new labn();
                tmp2.src1.contxt = btmp3.name;
                tmp3.src1 = new labn();
                tmp3.src1.contxt = btmp2.name;
                LocalScope tt2 = ((LocalScope)u.V).sons.get(((ConditionNode) u).Else.name);
                tt2.IR_name = ((reg) tmp3.src1).contxt;
                if (((ConditionNode) u).Else.StateList.size() == 0) dfs(((ConditionNode) u).Else, btmp2);
                else{
                    BasicBlock ttt = btmp2;
                    for (int i = 0; i < ((ConditionNode) u).Else.size(); ++i) {
                        Node tt = ((ConditionNode) u).Else.sons(i);
                        dfs(tt, ttt);
                        if (tt instanceof ForNode || tt instanceof WhileNode || tt instanceof ConditionNode){
                            ttt = label.pop();
                        }
                    }
                }
                label.push(btmp3);
                return null;
            }

        }

        else if (u instanceof WhileNode) {
            if (((WhileNode) u).Block == null) return null;
            BasicBlock tmp = null;
            if (v.Next != null) tmp = v.Next;
            String tmp1 = "while"+ String.valueOf(bcnt);
            BasicBlock t1 = new BasicBlock();
            t1.name = tmp1;
            root.All.put(tmp1, t1);
            String tmp2 = "whi" + String.valueOf(bcnt);
            bcnt++;
            BasicBlock t2 = new BasicBlock();
            t2.name = tmp2;
            root.All.put(tmp2, t2);
            String tmp3 = "L" +String.valueOf(bcnt);
            bcnt++;
            BasicBlock t3 = new BasicBlock();
            t3.name = tmp3;
            root.All.put(tmp3, t3);
            v.Next = t1;
            t1.Next = t2;
            t2.Next = t3;
            Break.push(tmp3);
            Tern t = new Tern();
            t.op = Opcode.jmp;
            t.src1 = new labn();
            t.src1.contxt = tmp2;
            v.content.add(t);
            Tern ttt = new Tern();
            ttt.op = Opcode.test;
            ttt.src1 = ttt.src2 = dfs(((WhileNode) u).Condition, t2);
            t2.content.add(ttt);
            Tern tt = new Tern();
            tt.op = Opcode.jnz;
            tt.src1 = new labn();
            tt.src1.contxt = tmp1;
            t2.content.add(tt);
            if (((WhileNode) u).Block.StateList.size() == 0) dfs(((WhileNode) u).Block, t1);
            else {
                for (int i = 0; i < ((WhileNode) u).Block.size(); ++i) {
                    Node temp = ((WhileNode) u).Block.sons(i);
                    dfs(temp, t1);
                    if (temp instanceof ForNode || temp instanceof WhileNode || temp instanceof ConditionNode){
                        t1 = label.pop();
                    }
                }
            }

            Break.pop();
            if (tmp != null) t3.Next = tmp;
            label.push(t3);
            return null;
        }

        else if (u instanceof ForNode){
            if (((ForNode) u).Block == null) return null;
            BasicBlock tmp = null;
            if (v.Next != null) tmp = v.Next;
            dfs(((ForNode) u).Expr1, v);
            String tmp1 = "for" + String.valueOf(bcnt);
            BasicBlock t1 = new BasicBlock();
            t1.name = tmp1;
            root.All.put(tmp1, t1);
            String tmp2 = "continue" + String.valueOf(bcnt);
            BasicBlock t2 = new BasicBlock();
            t2.name = tmp2;
            root.All.put(tmp2, t2);
            String tmp3 = "fo" + String.valueOf(bcnt);
            bcnt++;
            BasicBlock t3 = new BasicBlock();
            t3.name = tmp3;
            root.All.put(tmp3, t3);
            String tmp4 = "L" + String.valueOf(bcnt);
            bcnt++;
            BasicBlock t4 = new BasicBlock();
            t4.name = tmp4;
            root.All.put(tmp4, t4);
            v.Next = t1;
            t1.Next = t2;
            t2.Next = t3;
            t3.Next = t4;
            Continue.push(tmp2);
            Break.push(tmp4);
            Tern t = new Tern();
            t.op = Opcode.jmp;
            t.src1 = new reg();
            ((reg)t.src1).contxt = tmp3;
            v.content.add(t);
            Tern tt2 = new Tern();
            if (((ForNode) u).Expr2 != null) {
                Tern ttt = new Tern();
                ttt.op = Opcode.test;
                ttt.src1 = ttt.src2 = dfs(((ForNode) u).Expr2, t3);
                t3.content.add(ttt);
                tt2.op = Opcode.jnz;
                tt2.src1 = new labn();
                tt2.src1.contxt = tmp1;
                t3.content.add(tt2);
            }
            else {
                tt2.op = Opcode.jmp;
                ((reg)tt2.src1).contxt = tmp1;
                t3.content.add(tt2);
            }
            dfs(((ForNode) u).Expr3, t2);
            if (((ForNode) u).Block.StateList.size() == 0) dfs(((ForNode) u).Block, t1);
            else{
                for (int i = 0; i < ((ForNode) u).Block.size(); ++i) {
                    Node tt = ((ForNode) u).Block.sons(i);
                    dfs(tt, t1);
                    if (tt instanceof ForNode || tt instanceof WhileNode || tt instanceof ConditionNode){
                        t1 = label.pop();
                    }
                }
            }

            Break.pop();
            Continue.pop();
            if (tmp != null) t4.Next = tmp;
            label.push(t4);
        }


        else if (u instanceof JumpNode){
            if (((JumpNode) u).Label == Jump.Continue) {
                Tern tmp = new Tern();
                tmp.op = Opcode.jmp;
                ((reg)tmp.src1).contxt = Continue.peek();
                v.content.add(tmp);
                return null;
            }
            if (((JumpNode) u).Label == Jump.Break){
                Tern tmp = new Tern();
                tmp.op = Opcode.jmp;
                ((reg)tmp.src1).contxt = Break.peek();
                v.content.add(tmp);
                return null;
            }
            if (((JumpNode) u).Label == Jump.Return){
                Tern tmp1 = new Tern();
                tmp1.op = Opcode.mov;
                tmp1.src2 = dfs(((JumpNode) u).Return, v);
                tmp1.src1 = new reg();
                ((reg)tmp1.src1).contxt = "rax";//init may not defined ((FuncScope)u.V).Return_IR_name;
                v.content.add(tmp1);
                Tern tmp3 = new Tern();
                tmp3.op = Opcode.leave;
                v.content.add(tmp3);
                Tern tmp2 = new Tern();
                tmp2.op = Opcode.ret;
                v.content.add(tmp2);
                return null;
            }
        }

        else if (u instanceof NumberNode){
            imm tmp = new imm();
            tmp.contxt = String.valueOf(((NumberNode)u).Value);
            return tmp;
        }

        else if (u instanceof BoolNode){
            imm tmp = new imm();
            if (((BoolNode) u).S.equals("true")) tmp.contxt = "1";
            else if (((BoolNode) u).S.equals("false"))tmp.contxt = "0";
        }

        else if (u instanceof StrNode){
            strn tmp = new strn();
            root.signal.put("signal"+String.valueOf(root.signal.size()),((StrNode) u).Content);
            tmp.contxt = "signal"+String.valueOf(root.signal.size());
            return tmp;
        }

        else if (u instanceof NullNode) {
            imm tmp = new imm();
            tmp.contxt = "0";
            return tmp;
        }

        else if (u instanceof VarNode){
            return find_var(((VarNode) u).ID, u.V);
        }

        else if (u instanceof ArrNode){
            Tern tmp1 = new Tern();
            tmp1.op = Opcode.mov_add;
            tmp1.src1 = dfs(((ArrNode) u).ID, v);
            tmp1.src2 = dfs(((ArrNode) u).Index, v);
            tmp1.des = new reg();
            ((reg) tmp1.des).contxt = "%v" + String.valueOf(cnt);
            cnt++;
            v.content.add(tmp1);
            if (flag) {v.content.add(flag_tern); flag_tern = null; flag = false;}
            reg tmp2 = new reg();
            tmp2.contxt = tmp1.des.contxt;
            tmp2.Is_Point = true;
            return tmp2;
        }

        else if (u instanceof CreateNode){
            if (!(((CreateNode) u).VarTYpe.equals("int")|| ((CreateNode) u).VarTYpe.equals("bool"))) {
                ClassScope ctmp = General.clas.get(((CreateNode) u).VarTYpe);
                Tern tmp1 = new Tern();
                tmp1.op = Opcode.mov;
                tmp1.src1 = new reg();
                tmp1.src1.contxt = "rdi";
                tmp1.src2 = new imm();
                tmp1.src2.contxt = String.valueOf(ctmp.var.size()*8);
                v.content.add(tmp1);
                Tern tmp2 = new Tern();
                tmp2.op = Opcode.call;
                tmp2.src1 = new reg();
                tmp2.src1.contxt = "malloc";
                v.content.add(tmp2);
                Tern tmp3 = new Tern();
                tmp3.op = Opcode.mov;
                tmp3.src1 = new reg();
                tmp3.src1.contxt = "%v" + String.valueOf(cnt);
                cnt++;
                tmp3.src2 = new reg();
                tmp3.src2.contxt = "rax";
                v.content.add(tmp3);
                if (ctmp.func.get(((CreateNode) u).VarTYpe) != null) {
                    Tern tmp4 = new Tern();
                    tmp4.op = Opcode.call;
                    tmp4.src1 = new reg();
                    tmp4.src1.contxt = ((CreateNode) u).VarTYpe;
                }
                return tmp3.src1;
            }
            else return define_arr((CreateNode) u, v, 0);
        }

        else if (u instanceof ClassNode){
            Node t = ((ClassNode) u).ID;
            int d = 0;
            while (!(t instanceof VarNode)){
                t = ((ArrNode)t).ID;
                d += 1;
            }
            VarTypeRef temp = find_var_type(((VarNode) t).ID, u.V);
            if (temp.dim - d > 0 && ((ClassNode) u).Varname instanceof MethodNode && ((MethodNode) ((ClassNode) u).Varname).FuncID.equals("size")){
                Tern tmp = new Tern();
                tmp.op = Opcode.mov;
                tmp.src1 = new reg();
                tmp.src1.contxt = "%v" + String.valueOf(cnt);
                cnt++;
                tmp.src2 = new mem();
                ((mem) tmp.src2).r = (reg) dfs(((ClassNode) u).ID, v);
                tmp.src2.contxt = "-8";
                v.content.add(tmp);
                return tmp.src1;
            }
            else {
                ClassScope ttt = General.clas.get(temp.Type);
                if (((ClassNode) u).Varname instanceof MethodNode) {
                    FuncScope ft = ttt.func.get(((MethodNode) ((ClassNode) u).Varname).FuncID);
                    ((MethodNode) ((ClassNode) u).Varname).InClass = ((ClassNode) u).name;
                    Tern tmp1 = new Tern();
                    tmp1.op = Opcode.push;
                    tmp1.src1 = temp.IR_name;
                    v.content.add(tmp1);
                    Tern tmp = new Tern();
                    tmp.op = Opcode.mov;
                    tmp.src1 = temp.IR_name;
                    tmp.src2 = ft.para.get(ft.para.size()-1).IR_name;
                    v.content.add(tmp);
                    tnode tt = dfs(((ClassNode) u).Varname, v);
                    Tern tmp2 = new Tern();
                    tmp2.op = Opcode.pop;
                    tmp2.src1 = tmp1.src1;
                    v.content.add(tmp2);
                    return tt;
                }
                else if (((ClassNode) u).Varname instanceof VarNode){
                    Tern tmp1 = new Tern();
                    tmp1.op = Opcode.mov_add;
                    tmp1.src1 = dfs(((ClassNode) u).ID, v);
                    tmp1.src2 = new imm();
                    tmp1.src2.contxt = String.valueOf(ttt.var.get(((VarNode) ((ClassNode) u).Varname).ID).num * 8);
                    tmp1.des = new reg();
                    ((reg) tmp1.des).contxt = "%v" + String.valueOf(cnt);
                    cnt++;
                    v.content.add(tmp1);
                    reg tmp2 = new reg();
                    tmp2.contxt = tmp1.des.contxt;
                    tmp2.Is_Point = true;
                    return tmp2;
                }
            }
        }

        else if (u instanceof MethodNode){
            Scope stmp;
            if (((MethodNode) u).InClass == null) stmp = General.func.get(((MethodNode) u).FuncID);
                else stmp = General.clas.get(((MethodNode) u).InClass).func.get(((MethodNode) u).name);

            if (((MethodNode) u).InClass == null) {
                for (int i = 0; i < 6 && i < ((MethodNode) u).Argument.size(); ++i){
                    Tern t = new Tern();
                    t.op = Opcode.push;
                    t.src1 = new reg();
                    t.src1.contxt = r.param(i);
                    v.content.add(t);
                }
            }
            else {
                for (int i = 0; i < 5 && i < ((MethodNode) u).Argument.size()-1; ++i){
                    Tern t = new Tern();
                    t.op = Opcode.push;
                    t.src1 = new reg();
                    t.src1.contxt = r.param(i+1);
                    v.content.add(t);
                }
            }


            Tern t = new Tern();
            if (stmp.IR_name == null) {
                if (((MethodNode) u).Argument != null) {
                    List<Tern> all_tmp = new ArrayList<>();
                    if (((MethodNode) u).InClass == null) {
                        for (int i = 0; i < ((MethodNode) u).Argument.size(); ++i) {
                            Tern tmp = new Tern();
                            if (i < 6) {
                                tmp.op = Opcode.mov;
                                tmp.src2 = dfs(((MethodNode) u).Argument.sons(i), v);
                                tmp.src1 = new reg();
                                ((reg) tmp.src1).contxt = r.param(i);
                                ((FuncScope) stmp).para.get(i).IR_name = (reg) tmp.src1;
                                stmp.var.get(((FuncScope) stmp).para.get(i).ID).IR_name = (reg) tmp.src1;
                                cnt++;
                            } else {
                                tmp.op = Opcode.push;
                                tmp.src1 = dfs(((MethodNode) u).Argument.sons(i), v);
                            }
                            all_tmp.add(tmp);
                        }
                    }
                    else {
                        for (int i = 0; i < ((MethodNode) u).Argument.size()-1; ++i) {
                            Tern tmp = new Tern();
                            if (i < 6) {
                                tmp.op = Opcode.mov;
                                tmp.src2 = dfs(((MethodNode) u).Argument.sons(i), v);
                                tmp.src1 = new reg();
                                ((reg) tmp.src1).contxt = r.param(i);
                                ((FuncScope) stmp).para.get(i).IR_name = (reg) tmp.src1;
                                stmp.var.get(((FuncScope) stmp).para.get(i).ID).IR_name = (reg) tmp.src1;
                                cnt++;
                                all_tmp.add(tmp);
                            } else {
                                tmp.op = Opcode.push;
                                tmp.src1 = dfs(((MethodNode) u).Argument.sons(i), v);
                                all_tmp.add(tmp);
                            }
                        }
                    }
                    for (int i = 0; i < all_tmp.size(); ++i)
                        v.content.add(all_tmp.get(i));
                }
                stmp.IR_name = stmp.name + String.valueOf(bcnt);
                bcnt++;
            }
            else {
                List<Tern> all_tmp = new ArrayList<>();
                if (((MethodNode) u).Argument != null)
                    if (((MethodNode) u).InClass == null) {
                        for (int i = 0; i < ((MethodNode) u).Argument.size(); ++i) {
                            Tern tmp = new Tern();
                            tmp.op = Opcode.mov;
                            tmp.src2 = dfs(((MethodNode) u).Argument.sons(i), v);
                            tmp.src1 = ((FuncScope) stmp).para.get(i).IR_name;
                            all_tmp.add(tmp);
                        }
                    }
                    else {
                        for (int i = 0; i < ((MethodNode) u).Argument.size()-1; ++i) {
                            Tern tmp = new Tern();
                            tmp.op = Opcode.mov;
                            tmp.src2 = dfs(((MethodNode) u).Argument.sons(i), v);
                            tmp.src1 = ((FuncScope) stmp).para.get(i).IR_name;
                            all_tmp.add(tmp);
                        }
                    }
                    for (int i = 0; i < all_tmp.size(); ++i)
                        v.content.add(all_tmp.get(i));
            }
            Tern tmp = new Tern();
            tmp.op = Opcode.call;
            tmp.src1 = new reg();
            ((reg) tmp.src1).contxt = stmp.IR_name;
            v.content.add(tmp);


            t.op = Opcode.mov;
            t.src1 = new reg();
            t.src1.contxt = "%f"+((MethodNode) u).FuncID+String.valueOf(cnt);
            cnt++;
            t.src2 = new reg();
            t.src2.contxt = "rax";
            v.content.add(t);

            if (((MethodNode) u).InClass == null) {
                int tt = (6 < ((MethodNode) u).Argument.size()) ? 6 : ((MethodNode) u).Argument.size();
                for (int i = tt -1; i >= 0; --i){
                    Tern t0 = new Tern();
                    t0.op = Opcode.pop;
                    t0.src1 = new reg();
                    t0.src1.contxt = r.param(i);
                    v.content.add(t0);
                }
            }
            else {
                int tt = (5< ((MethodNode) u).Argument.size()-1)? 5 : (((MethodNode) u).Argument.size()-1);
                for (int i = tt; i > 0; --i){
                    Tern t0 = new Tern();
                    t0.op = Opcode.pop;
                    t0.src1 = new reg();
                    t0.src1.contxt = r.param(i+1);
                    v.content.add(t0);
                }
            }

            return t.src1;
        }

        else if (u instanceof StateNode){
            for (int i = 0; i < u.size(); ++i) {
                Node tt = u.sons(i);
                dfs(tt, v);
                if (tt instanceof ForNode || tt instanceof WhileNode || tt instanceof ConditionNode) v = label.pop();
            }
            return null;
        }
        return null;

    }




}
