import java.io.*;
import java.util.ArrayList;
import java.util.List;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

class p{
    boolean flag = true;
}
class sent extends p{
    String operation;
    String s1;
    String s2;
    int num;
    sent(String S0, String S1, String S2){
        operation = S0;
        s1 = S1;
        s2 = S2;
        num = 3;
    }
    sent(String S0, String S1){
        operation = S0;
        s1 = S1;
        num = 2;
    }
    sent(String S0){
        operation = S0;
        num = 1;
    }
    void print(){
        if (num == 1) System.out.println("\t"+operation);
        if (num == 2) System.out.println("\t"+operation+"\t"+s1);
        if (num == 3) System.out.println("\t"+operation+"\t"+s1+","+s2);
    }
}
class lab extends p{
    String s;
    int loc;
    List<Integer> appear = new ArrayList<>();
    lab(String S){
        s = S;
    }
    void print(){
        System.out.println(s);
    }
}

public class main{
    public static void main(String[] args) throws Exception{
        InputStream is = new FileInputStream("program.txt");
        ANTLRInputStream input = new ANTLRInputStream(is);
        demoLexer lexer = new demoLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        demoParser parser = new demoParser(tokens);
        parser.setErrorHandler(new BailErrorStrategy());
        ParseTree tree = parser.prog();

//        System.out.println("LISP:");
//        System.out.println(tree.toStringTree(parser));
//        System.out.println();

//        System.out.println("Visitor:");
        BuildASTVisitor buildASTVistor = new BuildASTVisitor();
//        TempTestAst test = new TempTestAst();
        Node Root = buildASTVistor.visit(tree);
//        test.dfs(Root);
//        System.out.println();

//        System.out.println("Scope");
        TempTestScope BuildScope = new TempTestScope();
        BuildScope.del_repeat(Root);
        BuildScope.dfs(Root, BuildScope.Root);
//        BuildScope.dfs2(BuildScope.Root);
        BuildScope.dfs1(Root, BuildScope.Root);
        BuildScope.put_this();
        boolean flag = BuildScope.flag;
        flag = false;

        //test.find_logic(Root);
        //BuildScope.add_this(Root);

        Register register = new Register();
        ternary ir = new ternary();
        ir.fff = flag;
        ir.r = register;
        ir.General = BuildScope.Root;
        ir.dfs(Root, null);
        ir.alloc(flag);

        mayfinal fin = new mayfinal();
        fin.flag = flag;
        fin.root = ir.root;
        fin.transform();
        fin.optim();
        fin.out();

    }
}

