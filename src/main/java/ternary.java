import java.util.ArrayList;
import java.util.List;

public class ternary {

    int cnt = 0;

    enum Opcode {
     //   add, sub, mul, div, load, store, if, goto, call, return, phi
    }

    class Src{

    }

    class Tern {
        Opcode op;
        String src1;
        String src2;
        Tern prev, next;
    }

    class BasicBlock {
        Tern head;
        ArrayList<Tern> phis = new ArrayList<>();
        ArrayList<BasicBlock> successors = new ArrayList<>();
    }

    class IR {
        BasicBlock start;
        ArrayList<BasicBlock> blocks = new ArrayList<>();
    }

    IR Root;

//    Tern dfs(Node u, Tern v){
//
//    }

}
