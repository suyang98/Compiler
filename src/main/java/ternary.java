import java.util.*;

enum Opcode {
    mov, add, sub, imul, idiv, sal, sar, setg, setge, setl, setle, sete, setne, movzx, and, xor, or,
    not, neg, inc, dec, jz, jnz, jmp, call, ret, size, cmp, load, store, push, pop, leave, test, cdq, cqo
}


class IR {
    List<String> GV= new ArrayList();
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
        if (op == Opcode.idiv) {
            if (src1 instanceof reg && src1.contxt.indexOf("%") != -1){
                ((reg) src1).reg = "rbx";
                System.out.println("\tmov\t" + ((reg)src1).reg + ",[" + f.var.get(src1.contxt).memory + "]");
                System.out.println("\tidiv\t" + ((reg)src1).reg);
            }
            else {
                System.out.println("\tidiv\t" + src1.contxt);
            }
            return;
        }
        if (op == Opcode.store){
            if (src2 instanceof reg && src2.contxt.indexOf("%") != -1) {
                ((reg)src2).reg = "rbx";
                System.out.println("\tmov\t" + ((reg)src2).reg + ",[" + f.var.get(src2.contxt).memory + "]");
            }
            if (src1 instanceof reg && src1.contxt.indexOf("%") != -1) {
                System.out.println("\tmov\trax,["+f.var.get(src1.contxt).memory+"]");
            }

            System.out.print("\tmov\t");
            if (src1 instanceof reg && src1.contxt.indexOf("%") != -1) {System.out.print("qword[rax],");((reg)src1).reg = "rax";}
            else {System.out.print("qword["+src1.contxt +"],"); }
            if (src2 instanceof reg && src2.contxt.indexOf("%") != -1) {System.out.println("rbx");}
            else System.out.println(src2.contxt);

        }
        else if (op == Opcode.load){
            if (src2 instanceof reg && src2.contxt.indexOf("%") != -1) {
                System.out.println("\tmov\trbx,["+f.var.get(src2.contxt).memory + "]");
            }

            System.out.print("\tmov\t");
            if (src1 instanceof reg && src1.contxt.indexOf("%") != -1) {System.out.print("rax,");((reg)src1).reg = "rax";}
            else {System.out.print(""+src1.contxt +","); }

            if (src2 instanceof reg && src2.contxt.indexOf("%") != -1) {System.out.println("[rbx]");((reg)src2).reg = "rbx";}
            else System.out.println("[" + src2.contxt + "]");

            for (int i = 0; i < def.size(); ++i){
                reg tmp = f.var.get(def.get(i).contxt);
                if (def.get(i).contxt.equals(src1.contxt)) System.out.println("\tmov\t["+ tmp.memory +"]," + ((reg)src1).reg);
                else {
                    System.out.println("\tmov\t[" + tmp.memory + "]," + ((reg) src2).reg);
                }
            }
        }
        else if (op == Opcode.test && src1 == src2){
            if (src1 instanceof reg && src1.contxt.indexOf("%") != -1) {
                ((reg)src1).reg = "rax";
                System.out.println("\tmov\t" + ((reg)src1).reg + ",[" + f.var.get(src1.contxt).memory + "]");
                System.out.println("\ttest\t" + ((reg) src1).reg + "," + ((reg)src1).reg);
            }
            else System.out.println("\ttest\t" + src1.contxt + "," + src1.contxt);
        }

        else if (src2 != null) {
            if (src1 instanceof reg && src1.contxt.indexOf("%") != -1) ((reg)src1).reg = "rax";
            if (src2 instanceof reg && src2.contxt.indexOf("%") != -1) ((reg)src2).reg = "rbx";
            for (int i = 0; i < use.size(); ++i){
                reg tmp = f.var.get(use.get(i).contxt);
                if (use.get(i).contxt.equals(src1.contxt)) {
                    System.out.println("\tmov\t" + ((reg)src1).reg + ",[" + tmp.memory + "]");
                }
                else {
                    System.out.println("\tmov\t" + ((reg)src2).reg + ",[" + tmp.memory + "]");
                }
            }
            if (op == Opcode.cmp && src1 instanceof imm) {
                System.out.println("\tmov\trax," + src1.contxt);
                System.out.print("\tcmp\trax,");
                if (src2 instanceof reg && src2.contxt.indexOf("%") != -1) {
                    System.out.println("rbx");
                    ((reg) src2).reg = "rbx";
                } else System.out.println(src2.contxt);
            }
            else {
                System.out.print("\t" + op + "\t");
                if (src1 instanceof reg && src1.contxt.indexOf("%") != -1) {
                    System.out.print("rax,");
                    ((reg) src1).reg = "rax";
                } else System.out.print("" + src1.contxt + ",");

                if (src2 instanceof reg && src2.contxt.indexOf("%") != -1) {
                    System.out.println("rbx");
                    ((reg) src2).reg = "rbx";
                } else System.out.println(src2.contxt);
            }

            for (int i = 0; i < def.size(); ++i){
                reg tmp = f.var.get(def.get(i).contxt);
                if (def.get(i).contxt.equals(src1.contxt)) System.out.println("\tmov\t["+ tmp.memory +"]," + ((reg)src1).reg);
                else {
                    System.out.println("\tmov\t[" + tmp.memory + "]," + ((reg) src2).reg);
                }
            }

        }
        else if (src1 != null){
            if (src1 instanceof reg && src1.contxt.indexOf("%") != -1) ((reg)src1).reg = "rax";
            for (int i = 0; i < use.size(); ++i){
                reg tmp = f.var.get(use.get(i).contxt);
                System.out.println("\tmov\t" + ((reg)src1).reg + ",[" + tmp.memory + "]");
            }
            System.out.print("\t"+op +"\t");
            if (src1 instanceof reg && src1.contxt.indexOf("%") != -1) {System.out.println("rax");((reg)src1).reg = "rax";}
            else {System.out.println(src1.contxt); }
            for (int i = 0; i < def.size(); ++i){
                reg tmp = f.var.get(def.get(i).contxt);
                System.out.println("\tmov\t["+ tmp.memory +"]," + ((reg)src1).reg);
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

class imm extends tnode{}

class strn extends tnode{}

class labn extends tnode{}

public class ternary {
    IR root = new IR();
    int cnt = 0;
    int bcnt = 0;
    Stack<Tern> flag_tern = new Stack<>();
    Stack<BasicBlock> label = new Stack<>();
    Stack<String> Continue = new Stack<>();
    Stack<String> Break = new Stack<>();
    GeneralScope General;
    Register r;
    BasicBlock Arr;
    int c = 0;

    reg find_var(String ID, Scope v, Node u){
        reg tmp = null;
        if (v.var.size()!= 0 && v.var.get(ID) != null
                && v.var.get(ID).line <= u.Location.line) tmp = v.var.get(ID).IR_name;
        if (tmp != null) {
            return tmp;
        }
        else if (v.parent!=null) return find_var(ID, v.parent, u);
        else return null;
    }

    VarTypeRef find_var_type(String ID, Scope v, Node u){
        VarTypeRef tmp = null;
        if (v.var.size()!= 0) tmp = v.var.get(ID);
        if (tmp != null) {
            return tmp;
        }
        else if (v.parent!=null) return find_var_type(ID, v.parent, u);
        else return null;
    }

    void alloc(){
        //printcontext();
        //System.out.println("\n");
        add_all();
        //flow(root.gen_var);
        for (int i = 0; i < root.gen_var.content.size(); ++i)
            use_def(root.gen_var.content.get(i), root.gen_var);
        for (Object k: root.gen_var.var.keySet())
            if (root.gen_var.var.get(k).memory == null) root.gen_var.var_num++;

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
        c = 0;
        add_dfs(root.gen_var, root.gen_var);
        for (Object obj: root.Blocks.keySet()){
            c = 0;
            String key = (String) obj;
            FuncBlock tmp = root.Blocks.get(key);
            add_dfs(tmp, tmp);
        }
    }


    void add_dfs(BasicBlock tmp, FuncBlock f){
        for (int i = 0; i < tmp.content.size(); ++i){
            f.all.add(tmp.content.get(i));
        }
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
        if (u.op == Opcode.mov || u.op == Opcode.movzx || u.op == Opcode.store || u.op == Opcode.load) {
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

    tnode define_arr(CreateNode u, BasicBlock v, int i, int l){
        Tern tmp0 = new Tern();
        tmp0.op = Opcode.mov;
        tmp0.src2 = dfs(u.Index.get(i), v);
        tmp0.src1 = new reg();
        tmp0.src1.contxt = "%v" + String.valueOf(cnt++);
        v.content.add(tmp0);

        Tern tmp2 = new Tern();
        if (i != u.Index.size()-1) {
            tmp2.op = Opcode.imul;
            tmp2.src1 = tmp0.src1;
            tmp2.src2 = new imm();
            tmp2.src2.contxt = "8";
            v.content.add(tmp2);
        }
        else {
            tmp2.op = Opcode.imul;
            tmp2.src1 = tmp0.src1;
            tmp2.src2 = new imm();
            tmp2.src2.contxt = Integer.toString(l);
            v.content.add(tmp2);
        }

        Tern tmp1 = new Tern();
        tmp1.op = Opcode.add;
        tmp1.src1 = tmp2.src1;
        tmp1.src2 = new imm();
        tmp1.src2.contxt = "8";
        v.content.add(tmp1);

        Tern tmp3 = new Tern();
        tmp3.op = Opcode.mov;
        tmp3.src1 = new reg();
        tmp3.src1.contxt = "rdi";
        tmp3.src2 = tmp1.src1;
        v.content.add(tmp3);
        Tern tmp4 = new Tern();
        tmp4.op = Opcode.call;
        tmp4.src1 = new reg();
        tmp4.src1.contxt = "malloc";
        v.content.add(tmp4);
        Tern tmp5 = new Tern();
        tmp5.op = Opcode.store;
        tmp5.src1 = new reg();
        tmp5.src1.contxt = "rax";
        tmp5.src2 = tmp0.src2;
        v.content.add(tmp5);
        Tern tmp6 = new Tern();
        tmp6.op = Opcode.mov;
        tmp6.src1 = new reg();
        tmp6.src1.contxt = "%v" + String.valueOf(cnt++);
        tmp6.src2 = new reg();
        tmp6.src2.contxt = "rax";
        v.content.add(tmp6);
        Tern t = new Tern();
        t.op = Opcode.add;
        t.src1 = tmp6.src1;
        t.src2 = new imm();
        t.src2.contxt = "8";
        v.content.add(t);

        if (i+1 < u.Index.size()){
            Tern tmp = new Tern();
            tmp.op = Opcode.mov;
            tmp.src1 = new reg();
            tmp.src1.contxt = "%v" + String.valueOf(cnt++);
            tmp.src2 = tmp6.src1;
            v.content.add(tmp);
            Tern tmp7 = new Tern();
            tmp7.op = Opcode.mov;
            tmp7.src1 = new reg();
            tmp7.src1.contxt = "%v" + String.valueOf(cnt++);
            tmp7.src2 = new imm();
            tmp7.src2.contxt = "0";
            v.content.add(tmp7);
            BasicBlock t1 = new BasicBlock();
            t1.name = "_for" + String.valueOf(bcnt++);
            BasicBlock t2 = new BasicBlock();
            t2.name = "_L" + String.valueOf(bcnt++);
            if (v.Next != null) t2.Next = v.Next;
            v.Next = t1;
            t1.Next = t2;
            Tern tmp9 = new Tern();
            tmp9.op = Opcode.store;
            tmp9.src1 = tmp.src1;
            tmp9.src2 = define_arr(u, t1, i+1, l);
            t1.content.add(tmp9);
            Tern tmp8 = new Tern();
            tmp8.op = Opcode.add;
            tmp8.src1 = tmp.src1;
            tmp8.src2 = new imm();
            tmp8.src2.contxt = "8";
            t1.content.add(tmp8);
            Tern tt = new Tern();
            tt.op = Opcode.add;
            tt.src1 = tmp7.src1;
            tt.src2 = new imm();
            tt.src2.contxt = "1";
            t1.content.add(tt);

            Tern tmp10 = new Tern();
            tmp10.op = Opcode.cmp;
            tmp10.src1 = tt.src1;
            tmp10.src2 = tmp0.src2;
            Tern tmp11 = new Tern();
            tmp11.op = Opcode.setl;
            tmp11.src1 = new reg();
            tmp11.src1.contxt = "al"; //"%v" + String.valueOf(cnt);cnt++;
            Tern tmp12 = new Tern();
            tmp12.op = Opcode.movzx;
            tmp12.src1 = new reg();
            tmp12.src1.contxt = "rax"; //"%v" + String.valueOf(cnt);cnt++;
            tmp12.src2 = new reg();
            tmp12.src2.contxt = "al";
            Tern tmp13 = new Tern();
            tmp13.op = Opcode.test;
            tmp13.src1 = tmp13.src2 = new reg();
            tmp13.src1.contxt = "rax";
            Tern tmp14 = new Tern();
            tmp14.op = Opcode.jnz;
            tmp14.src1 = new labn();
            tmp14.src1.contxt = t1.name;
            t2.content.add(tmp10);
            t2.content.add(tmp11);
            t2.content.add(tmp12);
            t2.content.add(tmp13);
            t2.content.add(tmp14);
            Arr = t2;
        }

        return tmp6.src1;
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
                if (tt instanceof ForNode || tt instanceof WhileNode || tt instanceof ConditionNode) v = label.pop();
                if (Arr != null) {v = Arr; Arr = null;}
            }
            u.V.name = tmp.FuncName;
            return null;
        }

        else if (u instanceof FuncDefNode){
            FuncBlock tmp = new FuncBlock();
            if (u.V.IR_name == null)  u.V.IR_name = tmp.FuncName = ((FuncDefNode) u).ID;
            else tmp.FuncName = u.V.IR_name;
            for (int i = 0; i < ((FuncScope)u.V).para.size(); ++i){
                ((FuncScope) u.V).para.get(i).IR_name = new reg();
                ((FuncScope) u.V).para.get(i).IR_name.contxt = "%v" + String.valueOf(cnt++);
                ((FuncScope) u.V).var.get(((FuncScope) u.V).para.get(i).ID).IR_name = ((FuncScope) u.V).para.get(i).IR_name;
                cnt++;
            }
            ((FuncScope) u.V).Return_IR_name = "%f"+((FuncDefNode) u).ID+String.valueOf(cnt);
            cnt++;

            root.Blocks.put(tmp.FuncName, tmp);
            tmp.name = tmp.FuncName;
            v = tmp;
            for (int i = ((FuncScope)u.V).para.size()-1; i >= 0 ; --i){
                Tern t = new Tern();
                if (i >= 6){
                    t.op = Opcode.mov;
                    t.src1 = ((FuncScope) u.V).para.get(i).IR_name;
                    t.src2 = new reg();
                    ((reg) t.src2).memory = "rbp+" +  String.valueOf((((FuncScope) u.V).para.size()-i+1)*8);
                    ((reg) t.src2).contxt = "[rbp+" +  String.valueOf((((FuncScope) u.V).para.size()-i+1)*8) + "]";
                }
                else {
                    t.op = Opcode.mov;
                    t.src1 = ((FuncScope) u.V).para.get(i).IR_name;
                    t.src2 = new reg();
                    t.src2.contxt = r.param(i);
                }
                v.content.add(t);
            }
            for (int i = 0; i < ((FuncDefNode)u).Body.size(); ++i){
                Node tt = ((FuncDefNode) u).Body.sons(i);
                dfs(tt, v);
                if (tt instanceof ForNode || tt instanceof WhileNode || tt instanceof ConditionNode) v = label.pop();
                if (Arr != null) {v = Arr; Arr = null;}
            }
            u.V.IR_name = tmp.FuncName;
            return null;
        }

        else if (u instanceof ParaNode){
            Tern t = new Tern();
            if (((ParaNode) u).InitE /*&& !(((ParaNode) u).Init instanceof CreateNode)*/) {
                if (((ParaNode) u).Init instanceof ArrNode ||
                        (((ParaNode) u).Init instanceof ClassNode && !(((ClassNode) ((ParaNode) u).Init).Varname instanceof MethodNode))){
                    t.op = Opcode.mov;
                    t.src1 = new reg();
                    ((reg) t.src1).contxt = "%v"+((ParaNode) u).ID + String.valueOf(cnt);
                    cnt++;
                    u.V.var.get(((ParaNode) u).ID).IR_name.contxt = t.src1.contxt;
                    t.src2 = dfs(((ParaNode) u).Init, v);
                    if (Arr != null) {v = Arr;}
                    v.content.add(t);
                }
                else {
                    t.op = Opcode.mov;
                    t.src1 = new reg();
                    ((reg) t.src1).contxt = "%v"+((ParaNode) u).ID + String.valueOf(cnt);
                    cnt++;
                    u.V.var.get(((ParaNode) u).ID).IR_name.contxt = t.src1.contxt;
                    t.src2 = dfs(((ParaNode) u).Init, v);
                    if (Arr != null) {v = Arr;}
                    v.content.add(t);
                }

                while (flag_tern.size() != 0){
                    v.content.add(flag_tern.pop());
                }

                if (u.V instanceof GeneralScope){
                    ((reg) t.src1).memory = "_" + ((ParaNode) u).ID;
                    u.V.var.get(((ParaNode) u).ID).IR_name.memory = ((reg) t.src1).memory;
                    u.V.var.get(((ParaNode) u).ID).IR_name.contxt = ((reg) t.src1).contxt;
                    root.GV.add(((ParaNode) u).ID);
                }

                return null;
            }
            else {
                u.V.var.get(((ParaNode) u).ID).IR_name.contxt = "%v" +((ParaNode) u).ID + String.valueOf(cnt);
                cnt++;
                if (u.V instanceof GeneralScope){
                    root.GV.add(((ParaNode) u).ID);
                    u.V.var.get(((ParaNode) u).ID).IR_name.memory = "_" + ((ParaNode) u).ID;
                }
            }
        }

        else if (u instanceof Return_Bool_Str && ((Return_Bool_Str) u).flag){
            MethodNode temp = new MethodNode();
            temp.Argument = new ListExpressionNode();
            temp.Argument.list.add(((InfixExpressionNode) u).Left);
            temp.Argument.list.add(((InfixExpressionNode) u).Right);
            temp.FuncID = "_"+((InfixExpressionNode) u).op.toString();
            return dfs(temp, v);
        }

        else if (u instanceof GreNode){
            Tern tmp = new Tern();
            tmp.op = Opcode.cmp;
            tmp.src1 = dfs(((GreNode) u).Left, v);
            tmp.src2 = dfs(((GreNode) u).Right, v);
            if (tmp.src1 instanceof reg && tmp.src1.contxt.indexOf("%") == -1){
                Tern t = new Tern();
                t.op = Opcode.mov;
                t.src1 = new reg();
                t.src1.contxt = "%v" + String.valueOf(cnt++);
                t.src2 = tmp.src1;
                v.content.add(t);
                tmp.src1 = t.src1;
            }
            if (tmp.src2 instanceof reg && tmp.src2.contxt.indexOf("%") == -1){
                Tern t = new Tern();
                t.op = Opcode.mov;
                t.src1 = new reg();
                t.src1.contxt = "%v" + String.valueOf(cnt++);
                t.src2 = tmp.src2;
                v.content.add(t);
                tmp.src2 = t.src1;
            }
            Tern tmp2 = new Tern();
            tmp2.op = Opcode.setg;
            tmp2.src1 = new reg();
            tmp2.src1.contxt = "al"; //"%v" + String.valueOf(cnt);cnt++;
            Tern tmp3 = new Tern();
            tmp3.op = Opcode.movzx;
            tmp3.src1 = new reg();
            tmp3.src1.contxt = "%v" + String.valueOf(cnt++);
            tmp3.src2 = tmp2.src1;
            v.content.add(tmp);
            v.content.add(tmp2);
            v.content.add(tmp3);
            while (flag_tern.size() != 0){
                v.content.add(flag_tern.pop());
            }
            return tmp3.src1;
        }

        else if (u instanceof GAENode){
            Tern tmp = new Tern();
            tmp.op = Opcode.cmp;
            tmp.src1 = dfs(((GAENode) u).Left, v);
            tmp.src2 = dfs(((GAENode) u).Right, v);
            if (tmp.src1 instanceof reg && tmp.src1.contxt.indexOf("%") == -1){
                Tern t = new Tern();
                t.op = Opcode.mov;
                t.src1 = new reg();
                t.src1.contxt = "%v" + String.valueOf(cnt++);
                t.src2 = tmp.src1;
                v.content.add(t);
                tmp.src1 = t.src1;
            }
            if (tmp.src2 instanceof reg && tmp.src2.contxt.indexOf("%") == -1){
                Tern t = new Tern();
                t.op = Opcode.mov;
                t.src1 = new reg();
                t.src1.contxt = "%v" + String.valueOf(cnt++);
                t.src2 = tmp.src2;
                v.content.add(t);
                tmp.src2 = t.src1;
            }
            Tern tmp2 = new Tern();
            tmp2.op = Opcode.setge;
            tmp2.src1 = new reg();
            tmp2.src1.contxt = "al"; //"%v" + String.valueOf(cnt);cnt++;
            Tern tmp3 = new Tern();
            tmp3.op = Opcode.movzx;
            tmp3.src1 = new reg();
            tmp3.src1.contxt = "%v" + String.valueOf(cnt++);
            tmp3.src2 = tmp2.src1;
            v.content.add(tmp);
            v.content.add(tmp2);
            v.content.add(tmp3);
            while (flag_tern.size() != 0){
                v.content.add(flag_tern.pop());
            }
            return tmp3.src1;
        }

        else if (u instanceof LesNode){
            Tern tmp = new Tern();
            tmp.op = Opcode.cmp;
            tmp.src1 = dfs(((LesNode) u).Left, v);
            tmp.src2 = dfs(((LesNode) u).Right, v);
            if (tmp.src1 instanceof reg && tmp.src1.contxt.indexOf("%") == -1){
                Tern t = new Tern();
                t.op = Opcode.mov;
                t.src1 = new reg();
                t.src1.contxt = "%v" + String.valueOf(cnt++);
                t.src2 = tmp.src1;
                v.content.add(t);
                tmp.src1 = t.src1;
            }
            if (tmp.src2 instanceof reg && tmp.src2.contxt.indexOf("%") == -1){
                Tern t = new Tern();
                t.op = Opcode.mov;
                t.src1 = new reg();
                t.src1.contxt = "%v" + String.valueOf(cnt++);
                t.src2 = tmp.src2;
                v.content.add(t);
                tmp.src2 = t.src1;
            }
            Tern tmp2 = new Tern();
            tmp2.op = Opcode.setl;
            tmp2.src1 = new reg();
            tmp2.src1.contxt = "al"; //"%v" + String.valueOf(cnt);cnt++;
            Tern tmp3 = new Tern();
            tmp3.op = Opcode.movzx;
            tmp3.src1 = new reg();
            tmp3.src1.contxt = "%v" + String.valueOf(cnt++);
            tmp3.src2 = tmp2.src1;
            v.content.add(tmp);
            v.content.add(tmp2);
            v.content.add(tmp3);
            while (flag_tern.size() != 0){
                v.content.add(flag_tern.pop());
            }
            return tmp3.src1;
        }

        else if (u instanceof LAENode){
            Tern tmp = new Tern();
            tmp.op = Opcode.cmp;
            tmp.src1 = dfs(((LAENode) u).Left, v);
            tmp.src2 = dfs(((LAENode) u).Right, v);
            if (tmp.src1 instanceof reg && tmp.src1.contxt.indexOf("%") == -1){
                Tern t = new Tern();
                t.op = Opcode.mov;
                t.src1 = new reg();
                t.src1.contxt = "%v" + String.valueOf(cnt++);
                t.src2 = tmp.src1;
                v.content.add(t);
                tmp.src1 = t.src1;
            }
            if (tmp.src2 instanceof reg && tmp.src2.contxt.indexOf("%") == -1){
                Tern t = new Tern();
                t.op = Opcode.mov;
                t.src1 = new reg();
                t.src1.contxt = "%v" + String.valueOf(cnt++);
                t.src2 = tmp.src2;
                v.content.add(t);
                tmp.src2 = t.src1;
            }
            Tern tmp2 = new Tern();
            tmp2.op = Opcode.setle;
            tmp2.src1 = new reg();
            tmp2.src1.contxt = "al"; //"%v" + String.valueOf(cnt);cnt++;
            Tern tmp3 = new Tern();
            tmp3.op = Opcode.movzx;
            tmp3.src1 = new reg();
            tmp3.src1.contxt = "%v" + String.valueOf(cnt++);
            tmp3.src2 = tmp2.src1;
            v.content.add(tmp);
            v.content.add(tmp2);
            v.content.add(tmp3);
            while (flag_tern.size() != 0){
                v.content.add(flag_tern.pop());
            }
            return tmp3.src1;
        }


        else if (u instanceof EquNode){
            Tern tmp = new Tern();
            tmp.op = Opcode.cmp;
            tmp.src1 = dfs(((EquNode) u).Left, v);
            tmp.src2 = dfs(((EquNode) u).Right, v);
            if (tmp.src1 instanceof reg && tmp.src1.contxt.indexOf("%") == -1){
                Tern t = new Tern();
                t.op = Opcode.mov;
                t.src1 = new reg();
                t.src1.contxt = "%v" + String.valueOf(cnt++);
                t.src2 = tmp.src1;
                v.content.add(t);
                tmp.src1 = t.src1;
            }
            if (tmp.src2 instanceof reg && tmp.src2.contxt.indexOf("%") == -1){
                Tern t = new Tern();
                t.op = Opcode.mov;
                t.src1 = new reg();
                t.src1.contxt = "%v" + String.valueOf(cnt++);
                t.src2 = tmp.src2;
                v.content.add(t);
                tmp.src2 = t.src1;
            }
            Tern tmp2 = new Tern();
            tmp2.op = Opcode.sete;
            tmp2.src1 = new reg();
            tmp2.src1.contxt = "al"; //"%v" + String.valueOf(cnt);cnt++;
            Tern tmp3 = new Tern();
            tmp3.op = Opcode.movzx;
            tmp3.src1 = new reg();
            tmp3.src1.contxt = "%v" + String.valueOf(cnt++);
            tmp3.src2 = tmp2.src1;
            v.content.add(tmp);
            v.content.add(tmp2);
            v.content.add(tmp3);
            while (flag_tern.size() != 0){
                v.content.add(flag_tern.pop());
            }
            return tmp3.src1;
        }

        else if (u instanceof NEqNode){
            Tern tmp = new Tern();
            tmp.op = Opcode.cmp;
            tmp.src1 = dfs(((NEqNode) u).Left, v);
            tmp.src2 = dfs(((NEqNode) u).Right, v);
            if (tmp.src1 instanceof reg && tmp.src1.contxt.indexOf("%") == -1){
                Tern t = new Tern();
                t.op = Opcode.mov;
                t.src1 = new reg();
                t.src1.contxt = "%v" + String.valueOf(cnt++);
                t.src2 = tmp.src1;
                v.content.add(t);
                tmp.src1 = t.src1;
            }
            if (tmp.src2 instanceof reg && tmp.src2.contxt.indexOf("%") == -1){
                Tern t = new Tern();
                t.op = Opcode.mov;
                t.src1 = new reg();
                t.src1.contxt = "%v" + String.valueOf(cnt++);
                t.src2 = tmp.src2;
                v.content.add(t);
                tmp.src2 = t.src1;
            }
            Tern tmp2 = new Tern();
            tmp2.op = Opcode.setne;
            tmp2.src1 = new reg();
            tmp2.src1.contxt = "al"; //"%v" + String.valueOf(cnt);cnt++;
            Tern tmp3 = new Tern();
            tmp3.op = Opcode.movzx;
            tmp3.src1 = new reg();
            tmp3.src1.contxt = "%v" + String.valueOf(cnt++);
            tmp3.src2 = tmp2.src1;
            v.content.add(tmp);
            v.content.add(tmp2);
            v.content.add(tmp3);
            while (flag_tern.size() != 0){
                v.content.add(flag_tern.pop());
            }
            return tmp3.src1;
        }

        else if (u instanceof InfixExpressionNode){
            if (((InfixExpressionNode) u).flag) {
                MethodNode temp = new MethodNode();
                temp.Argument = new ListExpressionNode();
                temp.Argument.list.add(((InfixExpressionNode) u).Left);
                temp.Argument.list.add(((InfixExpressionNode) u).Right);
                temp.FuncID = "_"+((InfixExpressionNode) u).op.toString();
                return dfs(temp, v);
            }
            Tern tmp = new Tern();
            tmp.src2 = dfs(((InfixExpressionNode) u).Right, v);
            if (tmp.src2 instanceof reg && tmp.src2.contxt.indexOf("%") == -1){
                Tern t0 = new Tern();
                t0.op = Opcode.mov;
                t0.src1 = new reg();
                t0.src1.contxt = "%v" + String.valueOf(cnt++);
                t0.src2 = tmp.src2;
                v.content.add(t0);
                tmp.src2 = t0.src1;
            }
            tmp.src1 = dfs(((InfixExpressionNode) u).Left, v);
            if (u instanceof AssignNode) {
                if ((((AssignNode) u).Right instanceof ArrNode) ||
                        ((((AssignNode) u).Right instanceof ClassNode) && !(((ClassNode)((AssignNode) u).Right).Varname instanceof MethodNode))){
                    if ((((AssignNode) u).Left instanceof ArrNode) ||
                            ((((AssignNode) u).Left instanceof ClassNode) && !(((ClassNode)((AssignNode) u).Left).Varname instanceof MethodNode))){
                        //arr_arr
//                        Tern tmp1 = new Tern();
//                        tmp1.op = Opcode.load;
//                        tmp1.src1 = new reg();
//                        tmp1.src1.contxt = "%v" + String.valueOf(cnt++);
//                        tmp1.src2 = tmp.src2;
//                        v.content.add(tmp1);
                        v.content.set(v.content.size()-1, tmp);
                        tmp.op = Opcode.store;
                        tmp.src1 = v.content.get(v.content.size()-2).src1;
                        while (flag_tern.size() != 0){
                            v.content.add(flag_tern.pop());
                        }
                        return null;
                    }
                    else {
                        //reg_arr
                        //tmp.op = Opcode.load;
                        tmp.op = Opcode.mov;
                        v.content.add(tmp);
                        while (flag_tern.size() != 0){
                            v.content.add(flag_tern.pop());
                        }
                        return null;
                    }
                }
                else{
                    if ((((AssignNode) u).Left instanceof ArrNode) ||
                            ((((AssignNode) u).Left instanceof ClassNode) && !(((ClassNode)((AssignNode) u).Left).Varname instanceof MethodNode))){
                        //arr_reg
                        int i = v.content.size()-1;
                        while (v.content.get(i).op != Opcode.load) i--;
                        v.content.set(i, tmp);
                        tmp.op = Opcode.store;
                        tmp.src1 = v.content.get(i-1).src1;
                        while (flag_tern.size() != 0){
                            v.content.add(flag_tern.pop());
                        }
                        return null;
                    }
                    else {
                        //reg_reg
                        tmp.op = Opcode.mov;
                        v.content.add(tmp);
                        while (flag_tern.size() != 0){
                            v.content.add(flag_tern.pop());
                        }
                        return null;
                    }
                }
            }
            if (u instanceof DivNode) {
                if (tmp.src2.contxt.equals("rax") || tmp.src2 instanceof imm){
                    Tern t = new Tern();
                    t.op = Opcode.mov;
                    t.src1 = new reg();
                    t.src1.contxt = "%v" + String.valueOf(cnt++);
                    t.src2 = tmp.src2;
                    v.content.add(t);
                    tmp.src2 = t.src1;
                }
                Tern tmp1 = new Tern();
                tmp1.op = Opcode.mov;
                tmp1.src1 = new reg();
                tmp1.src1.contxt = "rax";
                tmp1.src2 = tmp.src1;
                Tern tmp2 = new Tern();
                tmp2.op = Opcode.cqo;
                tmp.op = Opcode.idiv;
                tmp.src1 = tmp.src2;
                tmp.src2 = null;
                v.content.add(tmp1);
                v.content.add(tmp2);
                v.content.add(tmp);
                return tmp1.src1;
            }
            else if (u instanceof ModNode) {
                if (tmp.src2.contxt.equals("rax") || tmp.src2 instanceof imm){
                    Tern t = new Tern();
                    t.op = Opcode.mov;
                    t.src1 = new reg();
                    t.src1.contxt = "%v" + String.valueOf(cnt++);
                    t.src2 = tmp.src2;
                    v.content.add(t);
                    tmp.src2 = t.src1;
                }
                Tern tmp1 = new Tern();
                tmp1.op = Opcode.mov;
                tmp1.src1 = new reg();
                tmp1.src1.contxt = "rax";
                tmp1.src2 = tmp.src1;
                v.content.add(tmp1);
                Tern tmp2 = new Tern();
                tmp2.op = Opcode.cqo;
                v.content.add(tmp2);
                tmp.op = Opcode.idiv;
                tmp.src1 = tmp.src2;
                tmp.src2 = null;
                v.content.add(tmp);
                reg t = new reg();
                t.contxt = "rdx";
                while (flag_tern.size() != 0){
                    v.content.add(flag_tern.pop());
                }
                return t;
            }

            else{
//                if (tmp.src1 instanceof imm){
//                    tnode t = tmp.src1;
//                    tmp.src1 = tmp.src2;
//                    tmp.src2 = t;
//                }
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
            while (flag_tern.size() != 0){
                v.content.add(flag_tern.pop());
            }
            return tmp.src1;
        }

        else if (u instanceof PosNode){
            Tern tmp = new Tern();
            tmp.src1 = dfs(((PosNode) u).InnerNode, v);
            if (tmp.src1 instanceof imm){
                Tern t = new Tern();
                t.op = Opcode.mov;
                t.src1 = new reg();
                t.src1.contxt = "%v" + String.valueOf(cnt++);
                t.src2 = tmp.src1;
                v.content.add(t);
                tmp.src1 = t.src1;
            }
//            if (((PosNode) u).InnerNode instanceof ArrNode ||
//                    ((((PosNode) u).InnerNode instanceof ClassNode) && !(((ClassNode) ((PosNode) u).InnerNode).Varname instanceof  MethodNode))){
//                Tern tt = new Tern();
//                tt.op = Opcode.load;
//                tt.src2 = tmp.src1;
//                tt.src1 = new reg();
//                tt.src1.contxt = "%v" + String.valueOf(cnt++);
//                v.content.add(tt);
//                tmp.src1 = tt.src1;
//            }
            if (((PosNode) u).op == Opcode.dec || ((PosNode) u).op == Opcode.inc) {
                if (((PosNode) u).Is_Return) {
                    Tern t = new Tern();
                    t.op = ((PosNode) u).op;
                    t.src1 = tmp.src1;
                    flag_tern.push(t);
                    return tmp.src1;
                }
            }
            tmp.op = ((PosNode) u).op;
            v.content.add(tmp);
            while (flag_tern.size() != 0){
                v.content.add(flag_tern.pop());
            }
            return tmp.src1;
        }

        else if (u instanceof PreNode){
            Tern tmp = new Tern();
            tmp.src1 = dfs(((PreNode) u).InnerNode, v);
            if (tmp.src1 instanceof imm){
                Tern t = new Tern();
                t.op = Opcode.mov;
                t.src1 = new reg();
                t.src1.contxt = "%v" + String.valueOf(cnt++);
                t.src2 = tmp.src1;
                v.content.add(t);
                tmp.src1 = t.src1;
            }
//            if (((PosNode) u).InnerNode instanceof ArrNode ||
//                    ((((PosNode) u).InnerNode instanceof ClassNode) && !(((ClassNode) ((PosNode) u).InnerNode).Varname instanceof  MethodNode)){
//                Tern tt = new Tern();
//                tt.op = Opcode.load;
//                tt.src2 = tmp.src1;
//                tt.src1 = new reg();
//                tt.src1.contxt = "%v" + String.valueOf(cnt++);
//                v.content.add(tt);
//                tmp.src1 = tt.src1;
//            }
            if (u instanceof LNoNode){
                tmp.op = Opcode.xor;
                v.content.add(tmp);
                tmp.src2 = new imm();
                tmp.src2.contxt = "1";
            }
            else {
                tmp.op = ((PreNode) u).op;
                v.content.add(tmp);
            }
            while (flag_tern.size() != 0){
                v.content.add(flag_tern.pop());
            }
            return tmp.src1;
        }

        else if (u instanceof ConditionNode) {
            if (((ConditionNode) u).Then == null && ((ConditionNode) u).Else == null) return null;
            BasicBlock f = null;
            if (v.Next != null) f = v.Next;
            Tern tmp1 = new Tern();
            tmp1.op = Opcode.test;
            tmp1.src1 = tmp1.src2 = dfs(((ConditionNode) u).Condition, v);
            if (tmp1.src1 instanceof imm) {
                Tern t = new Tern();
                t.op = Opcode.mov;
                t.src1 = new reg();
                t.src1.contxt = "%v" + String.valueOf(cnt++);
                t.src2 = tmp1.src1;
                tmp1.src1 = tmp1.src2 = t.src1;
                v.content.add(t);
            }
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
                if (f != null) btmp3.Next = f;
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
                if (f != null) btmp3.Next = f;
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
                if (f != null) btmp3.Next = f;
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
                tt2.src1 = new labn();
                tt2.src1.contxt = tmp1;
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
                tmp.src1 = new labn();
                tmp.src1.contxt = Continue.peek();
                v.content.add(tmp);
                return null;
            }
            if (((JumpNode) u).Label == Jump.Break){
                Tern tmp = new Tern();
                tmp.op = Opcode.jmp;
                tmp.src1 = new labn();
                tmp.src1.contxt = Break.peek();
                v.content.add(tmp);
                return null;
            }
            if (((JumpNode) u).Label == Jump.Return){
                if (((JumpNode) u).Return != null) {
                    Tern tmp1 = new Tern();
                    tmp1.op = Opcode.mov;
                    tmp1.src2 = dfs(((JumpNode) u).Return, v);
                    tmp1.src1 = new reg();
                    ((reg) tmp1.src1).contxt = "rax";//init may not defined ((FuncScope)u.V).Return_IR_name;
                    v.content.add(tmp1);
                }
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
            return tmp;
        }

        else if (u instanceof StrNode){
            strn tmp = new strn();
            tmp.contxt = "signal"+String.valueOf(root.signal.size());
            root.signal.put(tmp.contxt, ((StrNode) u).Content);
            return tmp;
        }

        else if (u instanceof NullNode) {
            imm tmp = new imm();
            tmp.contxt = "0";
            return tmp;
        }

        else if (u instanceof VarNode){
            return find_var(((VarNode) u).ID, u.V, u);
        }

        else if (u instanceof ArrNode){
            Tern t = new Tern();
            t.op = Opcode.mov;
            t.src1 = new reg();
            t.src1.contxt = "%v" + String.valueOf(cnt++);
            t.src2 = dfs(((ArrNode) u).Index,v);
            v.content.add(t);
            Tern tt = new Tern();
            tt.op = Opcode.imul;
            tt.src1 = t.src1;
            tt.src2 = new imm();
            tt.src2.contxt = "8";
            v.content.add(tt);
            Tern tmp = new Tern();
            tmp.op = Opcode.mov;
            tmp.src1 = new reg();
            tmp.src1.contxt = "%v" + String.valueOf(cnt++);
            tmp.src2 = dfs(((ArrNode) u).ID, v);
            v.content.add(tmp);
            Tern tmp0 = new Tern();
            tmp0.op = Opcode.add;
            tmp0.src1 = tt.src1;
            tmp0.src2 = tmp.src1;
            v.content.add(tmp0);
            Tern tmp1 = new Tern();
            tmp1.op = Opcode.load;
            tmp1.src2 = tmp0.src1;
            tmp1.src1 = new reg();
            tmp1.src1.contxt = "%v" + String.valueOf(cnt++);
            v.content.add(tmp1);
            while (flag_tern.size() != 0){
                v.content.add(flag_tern.pop());
            }
            return tmp1.src1;
        }

        else if (u instanceof CreateNode){
            if (((CreateNode) u).dim != 0) {
                if (((CreateNode) u).VarTYpe.equals("int")|| ((CreateNode) u).VarTYpe.equals("bool"))
                    return define_arr((CreateNode) u, v, 0, 8);
                else {
                    ClassScope ctmp = General.clas.get(((CreateNode) u).VarTYpe);
                    return define_arr((CreateNode) u, v, 0, ctmp.var.size()*8);
                }
            }
            else {
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
        }

        else if (u instanceof ClassNode) {
            if (((ClassNode) u).Varname instanceof MethodNode && ((MethodNode)((ClassNode) u).Varname).FuncID.equals("size")) {
                Tern tmp = new Tern();
                tmp.op = Opcode.mov;
                tmp.src1 = new reg();
                tmp.src1.contxt = "%v" + String.valueOf(cnt++);
                tmp.src2 = dfs(((ClassNode) u).ID, v);
                v.content.add(tmp);
                Tern tmp1 = new Tern();
                tmp1.op = Opcode.sub;
                tmp1.src1 = tmp.src1;
                tmp1.src2 = new imm();
                tmp1.src2.contxt = "8";
                Tern tmp2 = new Tern();
                tmp2.op = Opcode.load;
                tmp2.src1 = new reg();
                tmp2.src1.contxt = "%v" + String.valueOf(cnt++);
                tmp2.src2 = tmp1.src1;
                v.content.add(tmp1);
                v.content.add(tmp2);
                return tmp2.src1;
            }
            else if (((ClassNode) u).Varname instanceof MethodNode){
                Tern tmp = new Tern();
                tmp.op = Opcode.mov;
                tmp.src1 = new reg();
                tmp.src1.contxt = "%v" + String.valueOf(cnt++);
                tmp.src2 = dfs(((ClassNode) u).ID, v);
//                if (((ClassNode) u).ID instanceof ArrNode || ((ClassNode) u).ID instanceof ClassNode){
//                    v.content.set(v.content.size()-1, tmp);
//                    tmp.src2 = v.content.get(v.content.size()-2).src1;
//                }
//                else
                v.content.add(tmp);

                tnode tt = dfs(((ClassNode) u).Varname, v);
                return tt;

            }
            else if (((ClassNode) u).Varname instanceof VarNode){
                ClassScope ttt = General.clas.get(((ClassNode) u).InClass);
                Tern tmp = new Tern();
                tmp.op = Opcode.mov;
                tmp.src1 = new reg();
                tmp.src1.contxt = "%v" + String.valueOf(cnt++);
                tmp.src2 = dfs(((ClassNode) u).ID, v);
                v.content.add(tmp);

                Tern tmp1 = new Tern();
                tmp1.op = Opcode.add;
                tmp1.src1 = tmp.src1;
                tmp1.src2 = new imm();
                tmp1.src2.contxt = String.valueOf(ttt.var.get(((VarNode) ((ClassNode) u).Varname).ID).num * 8);
                Tern tmp2 = new Tern();
                tmp2.op = Opcode.load;
                tmp2.src1 = new reg();
                tmp2.src1.contxt = "%v" + String.valueOf(cnt++);
                tmp2.src2 = tmp1.src1;
                v.content.add(tmp1);
                v.content.add(tmp2);
                return tmp2.src1;
            }
        }



//        else if (u instanceof ClassNode){
//            Node t = ((ClassNode) u).ID;
//            int d = 0;
//            if (t instanceof ClassNode) {
//            }
//
//            while (!(t instanceof VarNode)){
//                t = ((ArrNode)t).ID;
//                d += 1;
//            }
//            VarTypeRef temp = find_var_type(((VarNode) t).ID, u.V);
//            if (temp.dim - d > 0 && ((ClassNode) u).Varname instanceof MethodNode && ((MethodNode) ((ClassNode) u).Varname).FuncID.equals("size")){
//                Tern tmp = new Tern();
//                    tmp.op = Opcode.mov;
//                    tmp.src1 = new reg();
//                    tmp.src1.contxt = "%v" + String.valueOf(cnt++);
//                    tmp.src2 = dfs(((ClassNode) u).ID, v);
//                    v.content.add(tmp);
//                Tern tmp1 = new Tern();
//                tmp1.op = Opcode.sub;
//                tmp1.src1 = tmp.src1;
//                tmp1.src2 = new imm();
//                tmp1.src2.contxt = "8";
//                Tern tmp2 = new Tern();
//                tmp2.op = Opcode.load;
//                tmp2.src1 = new reg();
//                tmp2.src1.contxt = "%v" + String.valueOf(cnt++);
//                tmp2.src2 = tmp1.src1;
//                v.content.add(tmp1);
//                v.content.add(tmp2);
//                return tmp2.src1;
//            }
//            else {
//                ClassScope ttt = General.clas.get(temp.Type);
//                if (((ClassNode) u).Varname instanceof MethodNode) {
//                    FuncScope ft = ttt.func.get(((MethodNode) ((ClassNode) u).Varname).FuncID);
//                    ((MethodNode) ((ClassNode) u).Varname).InClass = temp.Type;
//
//                    Tern tmp = new Tern();
//                    tmp.op = Opcode.mov;
//                    tmp.src1 = new reg();
//                    tmp.src1.contxt = "%v" + String.valueOf(cnt++);
//                    tmp.src2 = dfs(((ClassNode) u).ID, v);
//                    if (((ClassNode) u).ID instanceof ArrNode){
//                        v.content.set(v.content.size()-1, tmp);
//                        tmp.src2 = v.content.get(v.content.size()-2).src1;
//                    }
//                    else v.content.add(tmp);
//
//                    tnode tt = dfs(((ClassNode) u).Varname, v);
//                    return tt;
//                }
//                else if (((ClassNode) u).Varname instanceof VarNode){
//                    Tern tmp = new Tern();
//                    tmp.op = Opcode.mov;
//                    tmp.src1 = new reg();
//                    tmp.src1.contxt = "%v" + String.valueOf(cnt++);
//                    tmp.src2 = dfs(((ClassNode) u).ID, v);
//                    v.content.add(tmp);
//
//                    Tern tmp1 = new Tern();
//                    tmp1.op = Opcode.add;
//                    tmp1.src1 = tmp.src1;
//                    tmp1.src2 = new imm();
//                    tmp1.src2.contxt = String.valueOf(ttt.var.get(((VarNode) ((ClassNode) u).Varname).ID).num * 8);
//                    Tern tmp2 = new Tern();
//                    tmp2.op = Opcode.load;
//                    tmp2.src1 = new reg();
//                    tmp2.src1.contxt = "%v" + String.valueOf(cnt++);
//                    tmp2.src2 = tmp1.src1;
//                    v.content.add(tmp1);
//                    v.content.add(tmp2);
//                    return tmp2.src1;
//                }
//            }
//        }

        else if (u instanceof MethodNode){
            Scope stmp;
            if (((MethodNode) u).InClass == null) stmp = General.func.get(((MethodNode) u).FuncID);
                else stmp = General.clas.get(((MethodNode) u).InClass).func.get(((MethodNode) u).FuncID);

            List<tnode> paralist = new ArrayList<>();

            Tern t = new Tern();
                if (((MethodNode) u).InClass == null) {
                    if (((MethodNode) u).Argument != null)
                    for (int i = 0; i < ((MethodNode) u).Argument.size(); ++i){
                        Tern tmp = new Tern();
                        tmp.op = Opcode.mov;
                        tmp.src2 = dfs(((MethodNode) u).Argument.sons(i), v);
                        tmp.src1 = new reg();
                        tmp.src1.contxt = "%v" + String.valueOf(cnt++);
                        paralist.add(tmp.src1);
                        v.content.add(tmp);
                    }
                }
                else {
                    paralist.add(v.content.get(v.content.size()-1).src1);
                    if (((MethodNode) u).Argument != null)
                    for (int i = 0; i < ((MethodNode) u).Argument.size(); ++i){
                        Tern tmp = new Tern();
                        tmp.op = Opcode.mov;
                        tmp.src2 = dfs(((MethodNode) u).Argument.sons(i), v);
                        tmp.src1 = new reg();
                        tmp.src1.contxt = "%v" + String.valueOf(cnt++);
                        paralist.add(tmp.src1);
                        v.content.add(tmp);
                    }
                }

            if (((FuncScope) stmp).para.size() > 6 && ((FuncScope) stmp).para.size() % 2 ==1){
                    Tern tmp = new Tern();
                    tmp.op = Opcode.push;
                    tmp.src1 = new reg();
                    tmp.src1.contxt = "rdi";
                    v.content.add(tmp);
            }
            for (int i = 0; i < ((FuncScope) stmp).para.size(); ++i){
                Tern tmp0 = new Tern();
                if (i < 6){
                    tmp0.op = Opcode.mov;
                    tmp0.src1 = new reg();
                    tmp0.src1.contxt = r.param(i);
                    tmp0.src2 = paralist.get(i);
                }
                else {
                    tmp0.op = Opcode.push;
                    tmp0.src1 = paralist.get(i);
                }
                v.content.add(tmp0);
            }

            Tern tmp = new Tern();
            tmp.op = Opcode.call;
            tmp.src1 = new reg();
            if (stmp.IR_name == null) stmp.IR_name = stmp.name + String.valueOf(bcnt++);
            ((reg) tmp.src1).contxt = stmp.IR_name;
            v.content.add(tmp);


            t.op = Opcode.mov;
            t.src1 = new reg();
            t.src1.contxt = "%f"+((MethodNode) u).FuncID+String.valueOf(cnt);
            cnt++;
            t.src2 = new reg();
            t.src2.contxt = "rax";
            v.content.add(t);

            for (int i = 6; i < ((FuncScope) stmp).para.size(); ++i){
                Tern tt = new Tern();
                tt.op = Opcode.pop;
                tt.src1 = new reg();
                tt.src1.contxt = "rax";
                v.content.add(tt);
            }

            if (((FuncScope) stmp).para.size() > 6 && ((FuncScope) stmp).para.size() % 2 ==1){
                Tern tt = new Tern();
                tt.op = Opcode.pop;
                tt.src1 = new reg();
                tt.src1.contxt = "rax";
                v.content.add(tt);
            }

//            if (((FuncScope) ftmp).para != null){
//                int tt = (6 < ((FuncScope) ftmp).para.size()) ? 6 : ((FuncScope) ftmp).para.size();
//                for (int i = tt - 1; i >= 0; --i){
//                    Tern t0 = new Tern();
//                    t0.op = Opcode.pop;
//                    t0.src1 = new reg();
//                    t0.src1.contxt = r.param(i);
//                    v.content.add(t0);
//                }
//            }

            return t.src1;
        }

        else if (u instanceof StateNode){
            for (int i = 0; i < u.size(); ++i) {
                Node tt = u.sons(i);
                dfs(tt, v);
                if (tt instanceof ForNode || tt instanceof WhileNode || tt instanceof ConditionNode) v = label.pop();
                if (Arr != null) {v = Arr; Arr = null;}
            }
            return null;
        }
        return null;

    }




}
