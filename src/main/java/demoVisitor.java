// Generated from C:/Users/user/IdeaProjects/compiler/src/main/java\demo.g4 by ANTLR 4.7
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link demoParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface demoVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link demoParser#prog}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProg(demoParser.ProgContext ctx);
	/**
	 * Visit a parse tree produced by the {@code block_funcdef}
	 * labeled alternative in {@link demoParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock_funcdef(demoParser.Block_funcdefContext ctx);
	/**
	 * Visit a parse tree produced by the {@code block_clasdef}
	 * labeled alternative in {@link demoParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock_clasdef(demoParser.Block_clasdefContext ctx);
	/**
	 * Visit a parse tree produced by the {@code block_state}
	 * labeled alternative in {@link demoParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock_state(demoParser.Block_stateContext ctx);
	/**
	 * Visit a parse tree produced by {@link demoParser#funcdef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncdef(demoParser.FuncdefContext ctx);
	/**
	 * Visit a parse tree produced by {@link demoParser#clasdef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClasdef(demoParser.ClasdefContext ctx);
	/**
	 * Visit a parse tree produced by {@link demoParser#classbody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassbody(demoParser.ClassbodyContext ctx);
	/**
	 * Visit a parse tree produced by the {@code class_funcdef}
	 * labeled alternative in {@link demoParser#clastat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClass_funcdef(demoParser.Class_funcdefContext ctx);
	/**
	 * Visit a parse tree produced by the {@code class_stat}
	 * labeled alternative in {@link demoParser#clastat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClass_stat(demoParser.Class_statContext ctx);
	/**
	 * Visit a parse tree produced by the {@code class_clac}
	 * labeled alternative in {@link demoParser#clastat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClass_clac(demoParser.Class_clacContext ctx);
	/**
	 * Visit a parse tree produced by {@link demoParser#claconstr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClaconstr(demoParser.ClaconstrContext ctx);
	/**
	 * Visit a parse tree produced by {@link demoParser#paralist}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParalist(demoParser.ParalistContext ctx);
	/**
	 * Visit a parse tree produced by the {@code para_var}
	 * labeled alternative in {@link demoParser#para}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPara_var(demoParser.Para_varContext ctx);
	/**
	 * Visit a parse tree produced by the {@code para_arr}
	 * labeled alternative in {@link demoParser#para}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPara_arr(demoParser.Para_arrContext ctx);
	/**
	 * Visit a parse tree produced by the {@code stat_para}
	 * labeled alternative in {@link demoParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStat_para(demoParser.Stat_paraContext ctx);
	/**
	 * Visit a parse tree produced by the {@code stat_expr}
	 * labeled alternative in {@link demoParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStat_expr(demoParser.Stat_exprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code stat_if}
	 * labeled alternative in {@link demoParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStat_if(demoParser.Stat_ifContext ctx);
	/**
	 * Visit a parse tree produced by the {@code stat_while}
	 * labeled alternative in {@link demoParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStat_while(demoParser.Stat_whileContext ctx);
	/**
	 * Visit a parse tree produced by the {@code stat_for}
	 * labeled alternative in {@link demoParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStat_for(demoParser.Stat_forContext ctx);
	/**
	 * Visit a parse tree produced by the {@code stat_jump}
	 * labeled alternative in {@link demoParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStat_jump(demoParser.Stat_jumpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code stat_many}
	 * labeled alternative in {@link demoParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStat_many(demoParser.Stat_manyContext ctx);
	/**
	 * Visit a parse tree produced by the {@code stat_null}
	 * labeled alternative in {@link demoParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStat_null(demoParser.Stat_nullContext ctx);
	/**
	 * Visit a parse tree produced by {@link demoParser#exprlist}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprlist(demoParser.ExprlistContext ctx);
	/**
	 * Visit a parse tree produced by {@link demoParser#methodcall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodcall(demoParser.MethodcallContext ctx);
	/**
	 * Visit a parse tree produced by {@link demoParser#creator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreator(demoParser.CreatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link demoParser#indexlist}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIndexlist(demoParser.IndexlistContext ctx);
	/**
	 * Visit a parse tree produced by the {@code expr_fixd}
	 * labeled alternative in {@link demoParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr_fixd(demoParser.Expr_fixdContext ctx);
	/**
	 * Visit a parse tree produced by the {@code expr_shif}
	 * labeled alternative in {@link demoParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr_shif(demoParser.Expr_shifContext ctx);
	/**
	 * Visit a parse tree produced by the {@code expr_posd}
	 * labeled alternative in {@link demoParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr_posd(demoParser.Expr_posdContext ctx);
	/**
	 * Visit a parse tree produced by the {@code expr_divd}
	 * labeled alternative in {@link demoParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr_divd(demoParser.Expr_divdContext ctx);
	/**
	 * Visit a parse tree produced by the {@code expr_assi}
	 * labeled alternative in {@link demoParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr_assi(demoParser.Expr_assiContext ctx);
	/**
	 * Visit a parse tree produced by the {@code expr_meth}
	 * labeled alternative in {@link demoParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr_meth(demoParser.Expr_methContext ctx);
	/**
	 * Visit a parse tree produced by the {@code expr_than}
	 * labeled alternative in {@link demoParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr_than(demoParser.Expr_thanContext ctx);
	/**
	 * Visit a parse tree produced by the {@code expr_crea}
	 * labeled alternative in {@link demoParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr_crea(demoParser.Expr_creaContext ctx);
	/**
	 * Visit a parse tree produced by the {@code expr_prim}
	 * labeled alternative in {@link demoParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr_prim(demoParser.Expr_primContext ctx);
	/**
	 * Visit a parse tree produced by the {@code expr_log}
	 * labeled alternative in {@link demoParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr_log(demoParser.Expr_logContext ctx);
	/**
	 * Visit a parse tree produced by the {@code expr_equi}
	 * labeled alternative in {@link demoParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr_equi(demoParser.Expr_equiContext ctx);
	/**
	 * Visit a parse tree produced by the {@code expr_fixn}
	 * labeled alternative in {@link demoParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr_fixn(demoParser.Expr_fixnContext ctx);
	/**
	 * Visit a parse tree produced by the {@code expr_plus}
	 * labeled alternative in {@link demoParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr_plus(demoParser.Expr_plusContext ctx);
	/**
	 * Visit a parse tree produced by the {@code expr_clas}
	 * labeled alternative in {@link demoParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr_clas(demoParser.Expr_clasContext ctx);
	/**
	 * Visit a parse tree produced by the {@code expr_arra}
	 * labeled alternative in {@link demoParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr_arra(demoParser.Expr_arraContext ctx);
	/**
	 * Visit a parse tree produced by the {@code primary_null}
	 * labeled alternative in {@link demoParser#primary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimary_null(demoParser.Primary_nullContext ctx);
	/**
	 * Visit a parse tree produced by the {@code primary_int}
	 * labeled alternative in {@link demoParser#primary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimary_int(demoParser.Primary_intContext ctx);
	/**
	 * Visit a parse tree produced by the {@code primary_str}
	 * labeled alternative in {@link demoParser#primary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimary_str(demoParser.Primary_strContext ctx);
	/**
	 * Visit a parse tree produced by the {@code primary_bool}
	 * labeled alternative in {@link demoParser#primary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimary_bool(demoParser.Primary_boolContext ctx);
	/**
	 * Visit a parse tree produced by the {@code primary_parens}
	 * labeled alternative in {@link demoParser#primary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimary_parens(demoParser.Primary_parensContext ctx);
	/**
	 * Visit a parse tree produced by the {@code primary_var}
	 * labeled alternative in {@link demoParser#primary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimary_var(demoParser.Primary_varContext ctx);
	/**
	 * Visit a parse tree produced by {@link demoParser#sif}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSif(demoParser.SifContext ctx);
	/**
	 * Visit a parse tree produced by {@link demoParser#swhile}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSwhile(demoParser.SwhileContext ctx);
	/**
	 * Visit a parse tree produced by {@link demoParser#sfor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSfor(demoParser.SforContext ctx);
	/**
	 * Visit a parse tree produced by the {@code jump_return}
	 * labeled alternative in {@link demoParser#jumpstat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJump_return(demoParser.Jump_returnContext ctx);
	/**
	 * Visit a parse tree produced by the {@code jump_break}
	 * labeled alternative in {@link demoParser#jumpstat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJump_break(demoParser.Jump_breakContext ctx);
	/**
	 * Visit a parse tree produced by the {@code jump_continue}
	 * labeled alternative in {@link demoParser#jumpstat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJump_continue(demoParser.Jump_continueContext ctx);
	/**
	 * Visit a parse tree produced by {@link demoParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(demoParser.TypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link demoParser#functype}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctype(demoParser.FunctypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link demoParser#vartype}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVartype(demoParser.VartypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link demoParser#arrtype}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrtype(demoParser.ArrtypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link demoParser#varid}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarid(demoParser.VaridContext ctx);
	/**
	 * Visit a parse tree produced by {@link demoParser#funcid}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncid(demoParser.FuncidContext ctx);
	/**
	 * Visit a parse tree produced by {@link demoParser#clasid}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClasid(demoParser.ClasidContext ctx);
}