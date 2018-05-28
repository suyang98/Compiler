import java.io.*;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;


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
        TempTestAst test = new TempTestAst();
        Node Root = buildASTVistor.visit(tree);
//        test.dfs(Root);
//        System.out.println();

//        System.out.println("Scope");
        TempTestScope BuildScope = new TempTestScope();
        BuildScope.dfs(Root, BuildScope.Root);
//        BuildScope.dfs2(BuildScope.Root);
        BuildScope.dfs1(Root, BuildScope.Root);
        BuildScope.put_this();

        ternary ir = new ternary();
        ir.General = BuildScope.Root;
        ir.dfs(Root, null);
        ir.alloc();

        mayfinal fin = new mayfinal();
        fin.root = ir.root;
        fin.transform();

    }
}

