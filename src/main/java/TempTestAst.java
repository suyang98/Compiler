import java.util.ArrayList;
import java.util.List;

enum Jump{
    Return, Break, Continue
}

class location{
    public int column, line;
    public void get_location(int line, int column) {
        this.line = line;
        this.column = column;
    }

}

abstract class Node {
    abstract void print();
    abstract int size();
    abstract Node sons(int i);
    location Location;
    Node(){
        this.Location = new location();
    }
}

class ProgNode extends Node {
    public List<ClassDefNode> ClassList = new ArrayList<ClassDefNode>();
    public List<FuncDefNode> FuncList = new ArrayList<FuncDefNode>();
    public List<ParaNode> ParaList = new ArrayList<ParaNode>();
    void print(){
        System.out.println("Prog");
    }
    int size(){
        return ClassList.size()+FuncList.size()+ParaList.size();
    }
    Node sons(int i){
        if (i >= 0 && i < FuncList.size()) return FuncList.get(i);
        else {
            i = i - FuncList.size();
            if (i < ClassList.size()) return ClassList.get(i);
            else return ParaList.get(i - ClassList.size());
        }
    }

}

class ClassDefNode extends Node {
    public String ID;
    public ClassStateNode State;
    void print(){System.out.println("ClassDef "+ID);}
    int size(){return 1;}
    Node sons(int i){
        return State;
    }
}

class ClassStateNode extends Node {
    public List<ParaNode> ParaList = new ArrayList<ParaNode>();
    public List<FuncDefNode> FuncList = new ArrayList<FuncDefNode>();
    public ClassConstNode Contruct;
    void print(){
        System.out.println("ClassState");
    }
    int size(){
        return ParaList.size()+FuncList.size()+1;
    }
    Node sons(int i){
        if (i == 0) return Contruct;
        else {
            i--;
            if (i < ParaList.size()) return ParaList.get(i);
            else return FuncList.get(i-ParaList.size());
        }
    }
}

class ClassConstNode extends Node {
    public String ID;
    public StateNode Body;
    void print(){
        System.out.println("ClassConstNode");
    }
    int size(){
        return 1;
    }
    Node sons(int i){
        return Body;
    }
}

class FuncDefNode extends Node {
    public String Return, ID;
    public int dim;
    public List<ParaNode> ParaList = new ArrayList<ParaNode>();
    public StateNode Body;
    void print(){
        System.out.println("FunctionDef "+Return+' '+ID);
    }
    int size(){
        return ParaList.size()+1;
    }
    Node sons(int i){
        if (i < ParaList.size()) return ParaList.get(i);
        else return Body;
    }
}

class StateNode extends Node {
    public List<StateNode> StateList = new ArrayList<StateNode>();
    public String name;
    void print(){
        System.out.println("State");
    }
    int size(){
        return StateList.size();
    }
    Node sons(int i){
        return StateList.get(i);
    }
}

class ParaNode extends StateNode {
    public String Type;
    public String ID;
    public int dim;
    public boolean InitE;
    public ExpressionNode Init;
    void print(){
        System.out.println("Para"+Type+' '+ID);
    }
    int size(){
        if (InitE) return 1;else return 0;
    }
    Node sons(int i){
        return Init;
    }
}

class ListParaNode extends StateNode {
    public List<ParaNode> list = new ArrayList<>();
    void print(){
        System.out.println("ListPara");
    }
    int size(){
        return list.size();
    }
    Node sons(int i){
        return list.get(i);
    }
}


abstract class ExpressionNode extends StateNode {
}

class ListExpressionNode extends StateNode{
    public List<ExpressionNode> list = new ArrayList<>();
    void print(){System.out.println("ListExpr");}
    int size() {return list.size();}
    Node sons(int i) {return list.get(i);}
}

abstract class InfixExpressionNode extends ExpressionNode {
    public ExpressionNode Left;
    public ExpressionNode Right;
    void print(){
        System.out.println(this.getClass());
    }
    int size(){
        return 2;
    }
    Node sons(int i){
        if (i == 0) return Left;
        else return Right;
    }
}

class Return_Int extends InfixExpressionNode{}
class Return_Bool extends InfixExpressionNode{}

class AddNode extends Return_Int {
}

class SubNode extends Return_Int {
}

class MulNode extends Return_Int {
}

class DivNode extends Return_Int {
}

class ModNode extends Return_Int {
}

class LShNode extends Return_Int {
}

class RShNode extends Return_Int {
}

class GreNode extends Return_Bool {
}

class GAENode extends Return_Bool {
}

class LesNode extends Return_Bool {
}

class LAENode extends Return_Bool {
}

class EquNode extends Return_Bool {
}

class NEqNode extends Return_Bool {
}

class AAnNode extends Return_Int {
}

class AXoNode extends Return_Int {
}

class AOrNode extends Return_Int {
}

class LAnNode extends Return_Bool {
}

class LOrNode extends Return_Bool {
}

class AssignNode extends InfixExpressionNode{
}

class PreNode extends ExpressionNode
{
    public ExpressionNode InnerNode;
    void print(){
        System.out.println(this.getClass());
    }
    int size(){
        return 1;
    }
    Node sons(int i){
        return InnerNode;
    }
}

class PreIncNode extends PreNode { //++i
}

class PreDecNode extends PreNode {
}

class LNoNode extends PreNode {
}

class ANoNode extends PreNode {
}

class MinNode extends PreNode{
}

class PosNode extends ExpressionNode
{
    public ExpressionNode InnerNode;
    void print(){
        System.out.println(this.getClass());
    }
    int size(){
        return 1;
    }
    Node sons(int i){
        return InnerNode;
    }
}

class PosIncNode extends PosNode { //i++
}

class PosDecNode extends PosNode {
}

class NumberNode extends ExpressionNode {
    public int Value;
    void print (){
        System.out.println(Value);
    }
    int size(){
        return 0;
    }
    Node sons(int i){
        return null;
    }

}

class BoolNode extends ExpressionNode{
    public String S;
    void print (){System.out.println("BoolNode");}
    int size(){return 0;}
    Node sons(int i) {return null;}
}

class StrNode extends ExpressionNode {
    public String Content;
    void print(){
        System.out.println(Content);
    }
    int size() {
        return 0;
    }
    Node sons(int i) {
        return null;
    }

}

class NullNode extends ExpressionNode {
    void print(){}
    int size(){return 0;}
    Node sons(int i){return null;}
}

class VarNode extends ExpressionNode {
    public String ID;
    void print(){
        System.out.println("VarId "+ID);
    }
    int size(){
        return 0;
    }
    Node sons(int i){
        return null;
    }
}

class ArrNode extends ExpressionNode {
    public ExpressionNode ID;
    public ExpressionNode Index;
    void print(){
        System.out.println("Array "+ID+' '+Index);
    }
    int size(){
        return 1;
    }
    Node sons(int i){
        return Index;
    }
}

class CreateNode extends ExpressionNode {
    public String VarTYpe;
    public int dim;
    public List<ExpressionNode> Index = new ArrayList<ExpressionNode>();
    void print(){
        System.out.println("Creator "+VarTYpe);
    }
    int size(){
        return Index.size();
    }
    Node sons(int i){
        return Index.get(i);
    }
}

class ClassNode extends ExpressionNode {
    public ExpressionNode ID;
    public ExpressionNode Varname;
    void print(){
        System.out.println("Class ");
    }
    int size(){
        return 2;
    }
    Node sons(int i){
        if (i == 0) return ID;
        else return Varname;
    }
}

class MethodNode extends ExpressionNode {
    public String FuncID;
    public ListExpressionNode Argument;
    void print(){
        System.out.println("Method "+FuncID);
    }
    int size(){
        return 1;
    }
    Node sons(int i){
        return Argument;
    }
}

class ConditionNode extends StateNode {
    public ExpressionNode Condition;
    public StateNode Then;
    public StateNode Else;
    public String name;
    void print(){
        System.out.println("IF");
    }
    int size(){
        return 3;
    }
    Node sons(int i){
        if (i == 0) return Condition;
        else if (i == 1) return Then;
        else return Else;
    }
}

class WhileNode extends StateNode {
    public ExpressionNode Condition;
    public StateNode Block;
    public String name;
    void print(){
        System.out.println("While");
    }
    int size(){
        return 2;
    }
    Node sons(int i){
        if (i == 0) return Condition;
        else return Block;
    }
}

class ForNode extends StateNode {
    public ExpressionNode Expr1, Expr2, Expr3;
    public StateNode Block;
    public String name;
    void print(){
        System.out.println("For");
    }
    int size(){
        return 4;
    }
    Node sons(int i){
        if (i == 0) return Expr1;
        else if (i == 1) return Expr2;
        else if (i == 2) return Expr3;
        else return Block;
    }
}

class JumpNode extends StateNode {
    public Jump Label;
    public ExpressionNode Return;
    void print(){
        System.out.println(Label);
    }
    int size(){
        return 1;
    }
    Node sons(int i){
        return Return;
    }
}


class BuildASTVisitor extends demoBaseVisitor<Node>{
    @Override
    public ProgNode visitProg(demoParser.ProgContext ctx){
        ProgNode tmp = new ProgNode();
        tmp.Location.get_location(ctx.start.getLine(), ctx.start.getCharPositionInLine());
        for (int i = 0; i < ctx.block().size(); ++i){
            Node t = visit(ctx.block(i));
            if (t instanceof ClassDefNode) tmp.ClassList.add((ClassDefNode)t);
            else if (t instanceof FuncDefNode) tmp.FuncList.add((FuncDefNode)t);
            else tmp.ParaList.add((ParaNode)t);
        }
        return tmp;
    }

    @Override
    public FuncDefNode visitBlock_funcdef(demoParser.Block_funcdefContext ctx) {
        FuncDefNode tmp = (FuncDefNode) visit(ctx.funcdef());
        return tmp;
    }

    @Override
    public FuncDefNode visitFuncdef(demoParser.FuncdefContext ctx){
        FuncDefNode tmp = new FuncDefNode();
        tmp.Location.get_location(ctx.start.getLine(),ctx.start.getCharPositionInLine());
        tmp.ID = ctx.funcid().getText();
        tmp.Return = ctx.functype().type().getText();
        tmp.dim = (ctx.functype().getText().length() - tmp.Return.length())/2;
        if (ctx.paralist() != null) tmp.ParaList = ((ListParaNode)visit(ctx.paralist())).list;
        if (ctx.stat() != null) tmp.Body = ((StateNode)visit(ctx.stat()));
        return tmp;
    }

    @Override
    public VarNode visitFunctype(demoParser.FunctypeContext ctx){
        VarNode tmp = (VarNode)visit(ctx.type());
        return tmp;
    }

    @Override
    public ListParaNode visitParalist(demoParser.ParalistContext ctx){
        ListParaNode tmp = new ListParaNode();
        tmp.Location.get_location(ctx.start.getLine(),ctx.start.getCharPositionInLine());
        for (int i = 0; i < ctx.para().size(); ++i)
            tmp.list.add((ParaNode) visit(ctx.para(i)));
        return tmp;
    }

    @Override
    public ParaNode visitPara_var(demoParser.Para_varContext ctx) {
        ParaNode tmp = new ParaNode();
        tmp.Location.get_location(ctx.start.getLine(),ctx.start.getCharPositionInLine());
        tmp.Type = ctx.vartype().getText();
        tmp.ID = ctx.varid().getText();
        tmp.dim = 0;
        if (ctx.expr() == null) tmp.InitE = false;
        else {
            tmp.InitE = true;
            tmp.Init = (ExpressionNode) visit(ctx.expr());
        }
        return tmp;
    }

    @Override
    public StateNode visitStat_many(demoParser.Stat_manyContext ctx){
        StateNode tmp = new StateNode();
        tmp.Location.get_location(ctx.start.getLine(),ctx.start.getCharPositionInLine());
        for (int i = 0 ; i < ctx.stat().size(); ++i){
            tmp.StateList.add((StateNode)visit(ctx.stat(i)));
        }
        return tmp;
    }

    @Override
    public ParaNode visitPara_arr(demoParser.Para_arrContext ctx) {
        ParaNode tmp = new ParaNode();
        tmp.Location.get_location(ctx.start.getLine(),ctx.start.getCharPositionInLine());
        tmp.Type = ctx.arrtype().vartype().getText();
        String s = ctx.arrtype().getText();
        tmp.dim = (s.length()-tmp.Type.length()) / 2;
        tmp.ID = ctx.varid().getText();
        if (ctx.expr() == null) tmp.InitE = false;
        else {
            tmp.InitE = true;
            tmp.Init = (ExpressionNode) visit(ctx.expr());
        }
        return tmp;
    }


    @Override
    public ClassDefNode visitBlock_clasdef(demoParser.Block_clasdefContext ctx){
        ClassDefNode tmp = (ClassDefNode) visit(ctx.clasdef());
        return tmp;
    }

    @Override
    public ClassDefNode visitClasdef(demoParser.ClasdefContext ctx){
        ClassDefNode tmp = new ClassDefNode();
        tmp.Location.get_location(ctx.start.getLine(),ctx.start.getCharPositionInLine());
        tmp.ID = ctx.clasid().getText();
        if (ctx.classbody() != null) tmp.State = ((ClassStateNode) visit(ctx.classbody()));
        return tmp;
    }

    @Override
    public ClassStateNode visitClassbody(demoParser.ClassbodyContext ctx){
        ClassStateNode tmp = new ClassStateNode();
        tmp.Location.get_location(ctx.start.getLine(),ctx.start.getCharPositionInLine());
        for (int i = 0; i < ctx.clastat().size(); ++i){
            Node t = visit(ctx.clastat(i));
            if (t instanceof FuncDefNode) tmp.FuncList.add((FuncDefNode)t);
            else if (t instanceof ParaNode) tmp.ParaList.add((ParaNode)t);
            else {
                if (tmp.Contruct == null) tmp.Contruct = (ClassConstNode)t;
            }
        }
        return tmp;
    }

    @Override
    public FuncDefNode visitClass_funcdef(demoParser.Class_funcdefContext ctx){
        FuncDefNode tmp = (FuncDefNode) visit(ctx.funcdef());
        return tmp;
    }

    @Override
    public StateNode visitClass_stat(demoParser.Class_statContext ctx){
        StateNode tmp = (StateNode) visit(ctx.stat());
        return tmp;
    }

    @Override
    public ClassConstNode visitClass_clac(demoParser.Class_clacContext ctx){
        ClassConstNode tmp = (ClassConstNode) visit(ctx.claconstr());
        return tmp;
    }

    @Override
    public ClassConstNode visitClaconstr(demoParser.ClaconstrContext ctx){
        ClassConstNode tmp = new ClassConstNode();
        tmp.Location.get_location(ctx.start.getLine(), ctx.start.getCharPositionInLine());
        tmp.ID = ctx.clasid().getText();
        tmp.Body = (StateNode)visit(ctx.stat());
        return tmp;
    }

    @Override
    public StateNode visitBlock_state(demoParser.Block_stateContext ctx){
        StateNode tmp = (StateNode) visit(ctx.stat());
        return tmp;
    }

    @Override
    public StateNode visitStat_para(demoParser.Stat_paraContext ctx){
        ParaNode tmp = (ParaNode) visit(ctx.para());
        return tmp;
    }

    @Override
    public ExpressionNode visitStat_expr(demoParser.Stat_exprContext ctx){
        ExpressionNode tmp = (ExpressionNode) visit(ctx.expr());
        return tmp;
    }

    @Override
    public ExpressionNode visitExpr_prim(demoParser.Expr_primContext ctx){
        ExpressionNode tmp = (ExpressionNode) visit(ctx.primary());
        return tmp;
    }

    @Override
    public ExpressionNode visitPrimary_parens(demoParser.Primary_parensContext ctx){
        ExpressionNode tmp = (ExpressionNode) visit(ctx.expr());
        return tmp;
    }

    @Override
    public VarNode visitPrimary_var(demoParser.Primary_varContext ctx){
        VarNode tmp = new VarNode();
        tmp.Location.get_location(ctx.start.getLine(),ctx.start.getCharPositionInLine());
        tmp.ID = ctx.varid().getText();
        return tmp;
    }


    @Override
    public NullNode visitPrimary_null(demoParser.Primary_nullContext ctx){
        NullNode tmp = new NullNode();
        tmp.Location.get_location(ctx.start.getLine(),ctx.start.getCharPositionInLine());
        return tmp;
    }

    @Override
    public NumberNode visitPrimary_int(demoParser.Primary_intContext ctx){
        NumberNode tmp = new NumberNode();
        tmp.Location.get_location(ctx.start.getLine(),ctx.start.getCharPositionInLine());
        tmp.Value = Integer.parseInt(ctx.Int().getText());
        return tmp;
    }

    @Override
    public StrNode visitPrimary_str(demoParser.Primary_strContext ctx){
        StrNode tmp = new StrNode();
        tmp.Location.get_location(ctx.start.getLine(),ctx.start.getCharPositionInLine());
        tmp.Content = ctx.String().getText();
        return tmp;
    }
    @Override
    public BoolNode visitPrimary_bool(demoParser.Primary_boolContext ctx){
        BoolNode tmp = new BoolNode();
        tmp.Location.get_location(ctx.start.getLine(),ctx.start.getCharPositionInLine());
        tmp.S = ctx.Bool().getText();
        return tmp;
    }

    @Override
    public MethodNode visitExpr_meth(demoParser.Expr_methContext ctx){
        MethodNode tmp = (MethodNode) visit(ctx.methodcall());
        return tmp;
    }

    @Override
    public MethodNode visitMethodcall(demoParser.MethodcallContext ctx){
        MethodNode tmp = new MethodNode();
        tmp.Location.get_location(ctx.start.getLine(),ctx.start.getCharPositionInLine());
        tmp.FuncID = ctx.funcid().getText();
        if (ctx.exprlist() == null) tmp.Argument = null;
        else tmp.Argument = (ListExpressionNode) visit(ctx.exprlist());
        return tmp;
    }

    @Override
    public ListExpressionNode visitExprlist(demoParser.ExprlistContext ctx){
        ListExpressionNode tmp = new ListExpressionNode();
        tmp.Location.get_location(ctx.start.getLine(),ctx.start.getCharPositionInLine());
        for (int i = 0; i < ctx.expr().size(); ++i) {
            tmp.list.add((ExpressionNode) visit(ctx.expr(i)));
        }
        return tmp;
    }

    @Override
    public ArrNode visitExpr_arra(demoParser.Expr_arraContext ctx) {
        ArrNode tmp = new ArrNode();
        tmp.Location.get_location(ctx.start.getLine(),ctx.start.getCharPositionInLine());
        tmp.ID = (ExpressionNode) visit(ctx.idname);
        tmp.Index = (ExpressionNode) visit(ctx.index);
        return tmp;
    }

    @Override
    public ClassNode visitExpr_clas(demoParser.Expr_clasContext ctx){
        ClassNode tmp = new ClassNode();
        tmp.Location.get_location(ctx.start.getLine(),ctx.start.getCharPositionInLine());
        tmp.ID = (ExpressionNode) visit(ctx.clname);
        tmp.Varname = (ExpressionNode) visit(ctx.varname);
        return tmp;
    }

    @Override
    public CreateNode visitExpr_crea(demoParser.Expr_creaContext ctx){
        CreateNode tmp = (CreateNode) visit(ctx.creator());
        return tmp;
    }

    @Override
    public CreateNode visitCreator(demoParser.CreatorContext ctx){
        CreateNode tmp = new CreateNode();
        tmp.Location.get_location(ctx.start.getLine(),ctx.start.getCharPositionInLine());
        tmp.VarTYpe = ctx.vartype().getText();
        tmp.dim = ctx.indexlist().size()+ctx.indexem().size();
        for (int i = 0; i < ctx.indexlist().size(); ++i)
            if (ctx.indexlist(i).expr() != null) tmp.Index.add((ExpressionNode) visit(ctx.indexlist(i).expr()));
        return tmp;
    }

    @Override
    public PosNode visitExpr_posd(demoParser.Expr_posdContext ctx){
        PosNode tmp = null;
        if (ctx.postfix.getText() == "++") tmp = new PosIncNode();
        else tmp = new PosDecNode();
        tmp.Location.get_location(ctx.start.getLine(),ctx.start.getCharPositionInLine());
        tmp.InnerNode = (ExpressionNode) visit(ctx.expr());
        return tmp;
    }

    @Override
    public PreNode visitExpr_fixd(demoParser.Expr_fixdContext ctx){
        PreNode tmp = null;
        if (ctx.prefix.getText().equals("++")) tmp = new PreIncNode();
        else tmp = new PreDecNode();
        tmp.Location.get_location(ctx.start.getLine(),ctx.start.getCharPositionInLine());
        tmp.InnerNode = (ExpressionNode) visit(ctx.expr());
        return tmp;
    }

    @Override
    public PreNode visitExpr_fixn(demoParser.Expr_fixnContext ctx){
        PreNode tmp = null;
        if (ctx.prefix.getText().equals("!")) tmp = new LNoNode();
        else if (ctx.prefix.getText().equals("~")) tmp = new ANoNode();
        else tmp = new MinNode();
        tmp.InnerNode = (ExpressionNode) visit(ctx.expr());
        tmp.Location.get_location(ctx.start.getLine(),ctx.start.getCharPositionInLine());
        return tmp;
    }

    @Override
    public InfixExpressionNode visitExpr_divd(demoParser.Expr_divdContext ctx){
        InfixExpressionNode tmp = null;
        if (ctx.bop.getText().equals("*")) tmp = new MulNode();
        else if (ctx.bop.getText().equals("/")) tmp = new DivNode();
        else if (ctx.bop.getText().equals("%")) tmp = new ModNode();
        tmp.Left = (ExpressionNode) visit(ctx.left);
        tmp.Right = (ExpressionNode) visit(ctx.right);
        tmp.Location.get_location(ctx.start.getLine(),ctx.start.getCharPositionInLine());
        return tmp;
    }

    @Override
    public InfixExpressionNode visitExpr_plus(demoParser.Expr_plusContext ctx){
        InfixExpressionNode tmp = null;
        if (ctx.bop.getText().equals("+")) tmp = new AddNode();
        else if (ctx.bop.getText().equals("-")) tmp = new SubNode();
        tmp.Left = (ExpressionNode) visit(ctx.left);
        tmp.Right = (ExpressionNode) visit(ctx.right);
        tmp.Location.get_location(ctx.start.getLine(),ctx.start.getCharPositionInLine());
        return tmp;
    }

    @Override
    public InfixExpressionNode visitExpr_shif(demoParser.Expr_shifContext ctx){
        InfixExpressionNode tmp = null;
        if (ctx.bop.getText().equals("<<")) tmp = new RShNode();
        else if (ctx.bop.getText().equals(">>")) tmp = new LShNode();
        tmp.Left = (ExpressionNode) visit(ctx.left);
        tmp.Right = (ExpressionNode) visit(ctx.right);
        tmp.Location.get_location(ctx.start.getLine(),ctx.start.getCharPositionInLine());
        return tmp;
    }

    @Override
    public InfixExpressionNode visitExpr_than(demoParser.Expr_thanContext ctx){
        InfixExpressionNode tmp = null;
        if (ctx.bop.getText().equals("<")) tmp = new LesNode();
        else if (ctx.bop.getText().equals("<=")) tmp = new LAENode();
        else if (ctx.bop.getText().equals(">")) tmp = new GreNode();
        else if (ctx.bop.getText().equals(">=")) tmp = new GAENode();
        tmp.Left = (ExpressionNode) visit(ctx.left);
        tmp.Right = (ExpressionNode) visit(ctx.right);
        tmp.Location.get_location(ctx.start.getLine(),ctx.start.getCharPositionInLine());
        return tmp;
    }

    @Override
    public InfixExpressionNode visitExpr_equi(demoParser.Expr_equiContext ctx){
        InfixExpressionNode tmp = null;
        if (ctx.bop.getText().equals("==")) tmp = new EquNode();
        else if (ctx.bop.getText().equals("!=")) tmp = new NEqNode();
        tmp.Left = (ExpressionNode) visit(ctx.left);
        tmp.Right = (ExpressionNode) visit(ctx.right);
        tmp.Location.get_location(ctx.start.getLine(),ctx.start.getCharPositionInLine());
        return tmp;
    }

    @Override
    public InfixExpressionNode visitExpr_log(demoParser.Expr_logContext ctx){
        InfixExpressionNode tmp = null;
        if (ctx.bop.getText().equals("&")) tmp = new AAnNode();
        else if (ctx.bop.getText().equals("^")) tmp = new AOrNode();
        else if (ctx.bop.getText().equals("|")) tmp = new AXoNode();
        else if (ctx.bop.getText().equals("&&")) tmp = new LAnNode();
        else if (ctx.bop.getText().equals("||")) tmp = new LOrNode();
        tmp.Left = (ExpressionNode) visit(ctx.left);
        tmp.Right = (ExpressionNode) visit(ctx.right);
        tmp.Location.get_location(ctx.start.getLine(),ctx.start.getCharPositionInLine());
        return tmp;
    }

    @Override
    public AssignNode visitExpr_assi(demoParser.Expr_assiContext ctx){
        AssignNode tmp = new AssignNode();
        tmp.Left = (ExpressionNode) visit(ctx.left);
        tmp.Right = (ExpressionNode) visit(ctx.right);
        tmp.Location.get_location(ctx.start.getLine(),ctx.start.getCharPositionInLine());
        return tmp;
    }


    @Override
    public  ConditionNode visitStat_if(demoParser.Stat_ifContext ctx){
        ConditionNode tmp = (ConditionNode) visit(ctx.sif());
        return tmp;
    }

    @Override
    public ConditionNode visitSif(demoParser.SifContext ctx){
        ConditionNode tmp = new ConditionNode();
        tmp.Condition = (ExpressionNode) visit(ctx.expr());
        if (ctx.then_state == null) tmp.Then = null;
            else tmp.Then = (StateNode) visit(ctx.then_state);
        if (ctx.else_state == null) tmp.Else = null;
            else tmp.Else = (StateNode) visit(ctx.else_state);
        tmp.Location.get_location(ctx.start.getLine(),ctx.start.getCharPositionInLine());
        return tmp;
    }

    @Override
    public WhileNode visitStat_while(demoParser.Stat_whileContext ctx){
        WhileNode tmp = (WhileNode) visit(ctx.swhile());
        return tmp;
    }

    @Override
    public WhileNode visitSwhile(demoParser.SwhileContext ctx){
        WhileNode tmp = new WhileNode();
        tmp.Condition = (ExpressionNode) visit(ctx.expr());
        if (ctx.stat() == null) tmp.Block = null;
            else tmp.Block = (StateNode) visit(ctx.stat());
        tmp.Location.get_location(ctx.start.getLine(),ctx.start.getCharPositionInLine());
        return tmp;
    }

    @Override
    public ForNode visitStat_for(demoParser.Stat_forContext ctx){
        ForNode tmp = (ForNode) visit(ctx.sfor());
        return tmp;
    }

    @Override
    public ForNode visitSfor(demoParser.SforContext ctx){
        ForNode tmp = new ForNode();
        if (ctx.expr1 == null) tmp.Expr1 = null;
            else tmp.Expr1 = (ExpressionNode) visit(ctx.expr1);
        if (ctx.expr2 == null) tmp.Expr2 = null;
            else tmp.Expr2 = (ExpressionNode) visit(ctx.expr2);
        if (ctx.expr3 == null) tmp.Expr3 = null;
            else tmp.Expr3 = (ExpressionNode) visit(ctx.expr3);
        if (ctx.stat() == null) tmp.Block = null;
            else tmp.Block = (StateNode) visit(ctx.stat());
        tmp.Location.get_location(ctx.start.getLine(),ctx.start.getCharPositionInLine());
        return tmp;
    }

    @Override
    public JumpNode visitStat_jump(demoParser.Stat_jumpContext ctx){
        JumpNode tmp = (JumpNode) visit(ctx.jumpstat());
        return tmp;
    }

    @Override
    public JumpNode visitJump_return(demoParser.Jump_returnContext ctx){
        JumpNode tmp = new JumpNode();
        tmp.Label = Jump.Return;
        if (ctx.expr() == null) tmp.Return = null;
        else tmp.Return = (ExpressionNode) visit(ctx.expr());
        tmp.Location.get_location(ctx.start.getLine(),ctx.start.getCharPositionInLine());
        return tmp;
    }

    @Override
    public JumpNode visitJump_break(demoParser.Jump_breakContext ctx){
        JumpNode tmp = new JumpNode();
        tmp.Label = Jump.Break;
        tmp.Return = null;
        tmp.Location.get_location(ctx.start.getLine(),ctx.start.getCharPositionInLine());
        return tmp;
    }

    @Override
    public JumpNode visitJump_continue(demoParser.Jump_continueContext ctx){
        JumpNode tmp = new JumpNode();
        tmp.Label = Jump.Continue;
        tmp.Return = null;
        tmp.Location.get_location(ctx.start.getLine(),ctx.start.getCharPositionInLine());
        return tmp;
    }

    @Override
    public StateNode visitStat_null(demoParser.Stat_nullContext ctx){
        return null;
    }

}


public class TempTestAst{
    void dfs(Node u){
        if (u == null) return;
        u.print();
        for (int i = 0; i < u.size(); ++i)
            dfs(u.sons(i));
    }
}

