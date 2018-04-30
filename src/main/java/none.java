public class none {
    abstract class AstVisitor<T> {
        public abstract T visit(ProgNode node);
        public abstract T visit(ClassDefNode node);
        public abstract T visit(ClassStateNode node);
        public abstract T visit(ClassConstNode node);
        public abstract T visit(FuncDefNode node);
        public abstract T visit(ParaNode node);
        public abstract T visit(ListParaNode node);
        public abstract T visit(AddNode node);
        public abstract T visit(SubNode node);
        public abstract T visit(MulNode node);
        public abstract T visit(DivNode node);
        public abstract T visit(ModNode node);
        public abstract T visit(LShNode node);
        public abstract T visit(RShNode node);
        public abstract T visit(GreNode node);
        public abstract T visit(GAENode node);
        public abstract T visit(LesNode node);
        public abstract T visit(LAENode node);
        public abstract T visit(EquNode node);
        public abstract T visit(NEqNode node);
        public abstract T visit(AAnNode node);
        public abstract T visit(AXoNode node);
        public abstract T visit(AOrNode node);
        public abstract T visit(LAnNode node);
        public abstract T visit(LOrNode node);
        public abstract T visit(AssignNode node);
        public abstract T visit(PreIncNode node);
        public abstract T visit(PreDecNode node);
        public abstract T visit(ANoNode node);
        public abstract T visit(LNoNode node);
        public abstract T visit(PosIncNode node);
        public abstract T visit(PosDecNode node);
        public abstract T visit(NumberNode node);
        public abstract T visit(BoolNode node);
        public abstract T visit(StrNode node);
        public abstract T visit(NullNode node);
        public abstract T visit(VarNode node);
        public abstract T visit(ArrNode node);
        public abstract T visit(CreateNode node);
        public abstract T visit(MethodNode node);
        public abstract T visit(ConditionNode node);
        public abstract T visit(WhileNode node);
        public abstract T visit(ForNode node);
        public abstract T visit(JumpNode node);

        public T visit(Node node){
            if (node instanceof ProgNode) return visit((ProgNode)node);
            return null;
        }

    }

}
