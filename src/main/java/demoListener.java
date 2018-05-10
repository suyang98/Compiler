// Generated from C:/Users/user/IdeaProjects/compiler/src/main/java\demo.g4 by ANTLR 4.7
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link demoParser}.
 */
public interface demoListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link demoParser#prog}.
	 * @param ctx the parse tree
	 */
	void enterProg(demoParser.ProgContext ctx);
	/**
	 * Exit a parse tree produced by {@link demoParser#prog}.
	 * @param ctx the parse tree
	 */
	void exitProg(demoParser.ProgContext ctx);
	/**
	 * Enter a parse tree produced by the {@code block_funcdef}
	 * labeled alternative in {@link demoParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock_funcdef(demoParser.Block_funcdefContext ctx);
	/**
	 * Exit a parse tree produced by the {@code block_funcdef}
	 * labeled alternative in {@link demoParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock_funcdef(demoParser.Block_funcdefContext ctx);
	/**
	 * Enter a parse tree produced by the {@code block_clasdef}
	 * labeled alternative in {@link demoParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock_clasdef(demoParser.Block_clasdefContext ctx);
	/**
	 * Exit a parse tree produced by the {@code block_clasdef}
	 * labeled alternative in {@link demoParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock_clasdef(demoParser.Block_clasdefContext ctx);
	/**
	 * Enter a parse tree produced by the {@code block_state}
	 * labeled alternative in {@link demoParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock_state(demoParser.Block_stateContext ctx);
	/**
	 * Exit a parse tree produced by the {@code block_state}
	 * labeled alternative in {@link demoParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock_state(demoParser.Block_stateContext ctx);
	/**
	 * Enter a parse tree produced by {@link demoParser#funcdef}.
	 * @param ctx the parse tree
	 */
	void enterFuncdef(demoParser.FuncdefContext ctx);
	/**
	 * Exit a parse tree produced by {@link demoParser#funcdef}.
	 * @param ctx the parse tree
	 */
	void exitFuncdef(demoParser.FuncdefContext ctx);
	/**
	 * Enter a parse tree produced by {@link demoParser#clasdef}.
	 * @param ctx the parse tree
	 */
	void enterClasdef(demoParser.ClasdefContext ctx);
	/**
	 * Exit a parse tree produced by {@link demoParser#clasdef}.
	 * @param ctx the parse tree
	 */
	void exitClasdef(demoParser.ClasdefContext ctx);
	/**
	 * Enter a parse tree produced by {@link demoParser#classbody}.
	 * @param ctx the parse tree
	 */
	void enterClassbody(demoParser.ClassbodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link demoParser#classbody}.
	 * @param ctx the parse tree
	 */
	void exitClassbody(demoParser.ClassbodyContext ctx);
	/**
	 * Enter a parse tree produced by the {@code class_funcdef}
	 * labeled alternative in {@link demoParser#clastat}.
	 * @param ctx the parse tree
	 */
	void enterClass_funcdef(demoParser.Class_funcdefContext ctx);
	/**
	 * Exit a parse tree produced by the {@code class_funcdef}
	 * labeled alternative in {@link demoParser#clastat}.
	 * @param ctx the parse tree
	 */
	void exitClass_funcdef(demoParser.Class_funcdefContext ctx);
	/**
	 * Enter a parse tree produced by the {@code class_stat}
	 * labeled alternative in {@link demoParser#clastat}.
	 * @param ctx the parse tree
	 */
	void enterClass_stat(demoParser.Class_statContext ctx);
	/**
	 * Exit a parse tree produced by the {@code class_stat}
	 * labeled alternative in {@link demoParser#clastat}.
	 * @param ctx the parse tree
	 */
	void exitClass_stat(demoParser.Class_statContext ctx);
	/**
	 * Enter a parse tree produced by the {@code class_clac}
	 * labeled alternative in {@link demoParser#clastat}.
	 * @param ctx the parse tree
	 */
	void enterClass_clac(demoParser.Class_clacContext ctx);
	/**
	 * Exit a parse tree produced by the {@code class_clac}
	 * labeled alternative in {@link demoParser#clastat}.
	 * @param ctx the parse tree
	 */
	void exitClass_clac(demoParser.Class_clacContext ctx);
	/**
	 * Enter a parse tree produced by {@link demoParser#claconstr}.
	 * @param ctx the parse tree
	 */
	void enterClaconstr(demoParser.ClaconstrContext ctx);
	/**
	 * Exit a parse tree produced by {@link demoParser#claconstr}.
	 * @param ctx the parse tree
	 */
	void exitClaconstr(demoParser.ClaconstrContext ctx);
	/**
	 * Enter a parse tree produced by {@link demoParser#paralist}.
	 * @param ctx the parse tree
	 */
	void enterParalist(demoParser.ParalistContext ctx);
	/**
	 * Exit a parse tree produced by {@link demoParser#paralist}.
	 * @param ctx the parse tree
	 */
	void exitParalist(demoParser.ParalistContext ctx);
	/**
	 * Enter a parse tree produced by the {@code para_var}
	 * labeled alternative in {@link demoParser#para}.
	 * @param ctx the parse tree
	 */
	void enterPara_var(demoParser.Para_varContext ctx);
	/**
	 * Exit a parse tree produced by the {@code para_var}
	 * labeled alternative in {@link demoParser#para}.
	 * @param ctx the parse tree
	 */
	void exitPara_var(demoParser.Para_varContext ctx);
	/**
	 * Enter a parse tree produced by the {@code para_arr}
	 * labeled alternative in {@link demoParser#para}.
	 * @param ctx the parse tree
	 */
	void enterPara_arr(demoParser.Para_arrContext ctx);
	/**
	 * Exit a parse tree produced by the {@code para_arr}
	 * labeled alternative in {@link demoParser#para}.
	 * @param ctx the parse tree
	 */
	void exitPara_arr(demoParser.Para_arrContext ctx);
	/**
	 * Enter a parse tree produced by the {@code stat_para}
	 * labeled alternative in {@link demoParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterStat_para(demoParser.Stat_paraContext ctx);
	/**
	 * Exit a parse tree produced by the {@code stat_para}
	 * labeled alternative in {@link demoParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitStat_para(demoParser.Stat_paraContext ctx);
	/**
	 * Enter a parse tree produced by the {@code stat_expr}
	 * labeled alternative in {@link demoParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterStat_expr(demoParser.Stat_exprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code stat_expr}
	 * labeled alternative in {@link demoParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitStat_expr(demoParser.Stat_exprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code stat_if}
	 * labeled alternative in {@link demoParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterStat_if(demoParser.Stat_ifContext ctx);
	/**
	 * Exit a parse tree produced by the {@code stat_if}
	 * labeled alternative in {@link demoParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitStat_if(demoParser.Stat_ifContext ctx);
	/**
	 * Enter a parse tree produced by the {@code stat_while}
	 * labeled alternative in {@link demoParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterStat_while(demoParser.Stat_whileContext ctx);
	/**
	 * Exit a parse tree produced by the {@code stat_while}
	 * labeled alternative in {@link demoParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitStat_while(demoParser.Stat_whileContext ctx);
	/**
	 * Enter a parse tree produced by the {@code stat_for}
	 * labeled alternative in {@link demoParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterStat_for(demoParser.Stat_forContext ctx);
	/**
	 * Exit a parse tree produced by the {@code stat_for}
	 * labeled alternative in {@link demoParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitStat_for(demoParser.Stat_forContext ctx);
	/**
	 * Enter a parse tree produced by the {@code stat_jump}
	 * labeled alternative in {@link demoParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterStat_jump(demoParser.Stat_jumpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code stat_jump}
	 * labeled alternative in {@link demoParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitStat_jump(demoParser.Stat_jumpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code stat_many}
	 * labeled alternative in {@link demoParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterStat_many(demoParser.Stat_manyContext ctx);
	/**
	 * Exit a parse tree produced by the {@code stat_many}
	 * labeled alternative in {@link demoParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitStat_many(demoParser.Stat_manyContext ctx);
	/**
	 * Enter a parse tree produced by the {@code stat_null}
	 * labeled alternative in {@link demoParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterStat_null(demoParser.Stat_nullContext ctx);
	/**
	 * Exit a parse tree produced by the {@code stat_null}
	 * labeled alternative in {@link demoParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitStat_null(demoParser.Stat_nullContext ctx);
	/**
	 * Enter a parse tree produced by {@link demoParser#exprlist}.
	 * @param ctx the parse tree
	 */
	void enterExprlist(demoParser.ExprlistContext ctx);
	/**
	 * Exit a parse tree produced by {@link demoParser#exprlist}.
	 * @param ctx the parse tree
	 */
	void exitExprlist(demoParser.ExprlistContext ctx);
	/**
	 * Enter a parse tree produced by {@link demoParser#methodcall}.
	 * @param ctx the parse tree
	 */
	void enterMethodcall(demoParser.MethodcallContext ctx);
	/**
	 * Exit a parse tree produced by {@link demoParser#methodcall}.
	 * @param ctx the parse tree
	 */
	void exitMethodcall(demoParser.MethodcallContext ctx);
	/**
	 * Enter a parse tree produced by {@link demoParser#creator}.
	 * @param ctx the parse tree
	 */
	void enterCreator(demoParser.CreatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link demoParser#creator}.
	 * @param ctx the parse tree
	 */
	void exitCreator(demoParser.CreatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link demoParser#indexem}.
	 * @param ctx the parse tree
	 */
	void enterIndexem(demoParser.IndexemContext ctx);
	/**
	 * Exit a parse tree produced by {@link demoParser#indexem}.
	 * @param ctx the parse tree
	 */
	void exitIndexem(demoParser.IndexemContext ctx);
	/**
	 * Enter a parse tree produced by {@link demoParser#indexlist}.
	 * @param ctx the parse tree
	 */
	void enterIndexlist(demoParser.IndexlistContext ctx);
	/**
	 * Exit a parse tree produced by {@link demoParser#indexlist}.
	 * @param ctx the parse tree
	 */
	void exitIndexlist(demoParser.IndexlistContext ctx);
	/**
	 * Enter a parse tree produced by the {@code expr_fixd}
	 * labeled alternative in {@link demoParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr_fixd(demoParser.Expr_fixdContext ctx);
	/**
	 * Exit a parse tree produced by the {@code expr_fixd}
	 * labeled alternative in {@link demoParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr_fixd(demoParser.Expr_fixdContext ctx);
	/**
	 * Enter a parse tree produced by the {@code expr_shif}
	 * labeled alternative in {@link demoParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr_shif(demoParser.Expr_shifContext ctx);
	/**
	 * Exit a parse tree produced by the {@code expr_shif}
	 * labeled alternative in {@link demoParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr_shif(demoParser.Expr_shifContext ctx);
	/**
	 * Enter a parse tree produced by the {@code expr_posd}
	 * labeled alternative in {@link demoParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr_posd(demoParser.Expr_posdContext ctx);
	/**
	 * Exit a parse tree produced by the {@code expr_posd}
	 * labeled alternative in {@link demoParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr_posd(demoParser.Expr_posdContext ctx);
	/**
	 * Enter a parse tree produced by the {@code expr_divd}
	 * labeled alternative in {@link demoParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr_divd(demoParser.Expr_divdContext ctx);
	/**
	 * Exit a parse tree produced by the {@code expr_divd}
	 * labeled alternative in {@link demoParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr_divd(demoParser.Expr_divdContext ctx);
	/**
	 * Enter a parse tree produced by the {@code expr_assi}
	 * labeled alternative in {@link demoParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr_assi(demoParser.Expr_assiContext ctx);
	/**
	 * Exit a parse tree produced by the {@code expr_assi}
	 * labeled alternative in {@link demoParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr_assi(demoParser.Expr_assiContext ctx);
	/**
	 * Enter a parse tree produced by the {@code expr_meth}
	 * labeled alternative in {@link demoParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr_meth(demoParser.Expr_methContext ctx);
	/**
	 * Exit a parse tree produced by the {@code expr_meth}
	 * labeled alternative in {@link demoParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr_meth(demoParser.Expr_methContext ctx);
	/**
	 * Enter a parse tree produced by the {@code expr_than}
	 * labeled alternative in {@link demoParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr_than(demoParser.Expr_thanContext ctx);
	/**
	 * Exit a parse tree produced by the {@code expr_than}
	 * labeled alternative in {@link demoParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr_than(demoParser.Expr_thanContext ctx);
	/**
	 * Enter a parse tree produced by the {@code expr_crea}
	 * labeled alternative in {@link demoParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr_crea(demoParser.Expr_creaContext ctx);
	/**
	 * Exit a parse tree produced by the {@code expr_crea}
	 * labeled alternative in {@link demoParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr_crea(demoParser.Expr_creaContext ctx);
	/**
	 * Enter a parse tree produced by the {@code expr_prim}
	 * labeled alternative in {@link demoParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr_prim(demoParser.Expr_primContext ctx);
	/**
	 * Exit a parse tree produced by the {@code expr_prim}
	 * labeled alternative in {@link demoParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr_prim(demoParser.Expr_primContext ctx);
	/**
	 * Enter a parse tree produced by the {@code expr_log}
	 * labeled alternative in {@link demoParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr_log(demoParser.Expr_logContext ctx);
	/**
	 * Exit a parse tree produced by the {@code expr_log}
	 * labeled alternative in {@link demoParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr_log(demoParser.Expr_logContext ctx);
	/**
	 * Enter a parse tree produced by the {@code expr_equi}
	 * labeled alternative in {@link demoParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr_equi(demoParser.Expr_equiContext ctx);
	/**
	 * Exit a parse tree produced by the {@code expr_equi}
	 * labeled alternative in {@link demoParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr_equi(demoParser.Expr_equiContext ctx);
	/**
	 * Enter a parse tree produced by the {@code expr_fixn}
	 * labeled alternative in {@link demoParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr_fixn(demoParser.Expr_fixnContext ctx);
	/**
	 * Exit a parse tree produced by the {@code expr_fixn}
	 * labeled alternative in {@link demoParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr_fixn(demoParser.Expr_fixnContext ctx);
	/**
	 * Enter a parse tree produced by the {@code expr_plus}
	 * labeled alternative in {@link demoParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr_plus(demoParser.Expr_plusContext ctx);
	/**
	 * Exit a parse tree produced by the {@code expr_plus}
	 * labeled alternative in {@link demoParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr_plus(demoParser.Expr_plusContext ctx);
	/**
	 * Enter a parse tree produced by the {@code expr_clas}
	 * labeled alternative in {@link demoParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr_clas(demoParser.Expr_clasContext ctx);
	/**
	 * Exit a parse tree produced by the {@code expr_clas}
	 * labeled alternative in {@link demoParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr_clas(demoParser.Expr_clasContext ctx);
	/**
	 * Enter a parse tree produced by the {@code expr_arra}
	 * labeled alternative in {@link demoParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr_arra(demoParser.Expr_arraContext ctx);
	/**
	 * Exit a parse tree produced by the {@code expr_arra}
	 * labeled alternative in {@link demoParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr_arra(demoParser.Expr_arraContext ctx);
	/**
	 * Enter a parse tree produced by the {@code primary_null}
	 * labeled alternative in {@link demoParser#primary}.
	 * @param ctx the parse tree
	 */
	void enterPrimary_null(demoParser.Primary_nullContext ctx);
	/**
	 * Exit a parse tree produced by the {@code primary_null}
	 * labeled alternative in {@link demoParser#primary}.
	 * @param ctx the parse tree
	 */
	void exitPrimary_null(demoParser.Primary_nullContext ctx);
	/**
	 * Enter a parse tree produced by the {@code primary_int}
	 * labeled alternative in {@link demoParser#primary}.
	 * @param ctx the parse tree
	 */
	void enterPrimary_int(demoParser.Primary_intContext ctx);
	/**
	 * Exit a parse tree produced by the {@code primary_int}
	 * labeled alternative in {@link demoParser#primary}.
	 * @param ctx the parse tree
	 */
	void exitPrimary_int(demoParser.Primary_intContext ctx);
	/**
	 * Enter a parse tree produced by the {@code primary_str}
	 * labeled alternative in {@link demoParser#primary}.
	 * @param ctx the parse tree
	 */
	void enterPrimary_str(demoParser.Primary_strContext ctx);
	/**
	 * Exit a parse tree produced by the {@code primary_str}
	 * labeled alternative in {@link demoParser#primary}.
	 * @param ctx the parse tree
	 */
	void exitPrimary_str(demoParser.Primary_strContext ctx);
	/**
	 * Enter a parse tree produced by the {@code primary_bool}
	 * labeled alternative in {@link demoParser#primary}.
	 * @param ctx the parse tree
	 */
	void enterPrimary_bool(demoParser.Primary_boolContext ctx);
	/**
	 * Exit a parse tree produced by the {@code primary_bool}
	 * labeled alternative in {@link demoParser#primary}.
	 * @param ctx the parse tree
	 */
	void exitPrimary_bool(demoParser.Primary_boolContext ctx);
	/**
	 * Enter a parse tree produced by the {@code primary_parens}
	 * labeled alternative in {@link demoParser#primary}.
	 * @param ctx the parse tree
	 */
	void enterPrimary_parens(demoParser.Primary_parensContext ctx);
	/**
	 * Exit a parse tree produced by the {@code primary_parens}
	 * labeled alternative in {@link demoParser#primary}.
	 * @param ctx the parse tree
	 */
	void exitPrimary_parens(demoParser.Primary_parensContext ctx);
	/**
	 * Enter a parse tree produced by the {@code primary_var}
	 * labeled alternative in {@link demoParser#primary}.
	 * @param ctx the parse tree
	 */
	void enterPrimary_var(demoParser.Primary_varContext ctx);
	/**
	 * Exit a parse tree produced by the {@code primary_var}
	 * labeled alternative in {@link demoParser#primary}.
	 * @param ctx the parse tree
	 */
	void exitPrimary_var(demoParser.Primary_varContext ctx);
	/**
	 * Enter a parse tree produced by {@link demoParser#sif}.
	 * @param ctx the parse tree
	 */
	void enterSif(demoParser.SifContext ctx);
	/**
	 * Exit a parse tree produced by {@link demoParser#sif}.
	 * @param ctx the parse tree
	 */
	void exitSif(demoParser.SifContext ctx);
	/**
	 * Enter a parse tree produced by {@link demoParser#swhile}.
	 * @param ctx the parse tree
	 */
	void enterSwhile(demoParser.SwhileContext ctx);
	/**
	 * Exit a parse tree produced by {@link demoParser#swhile}.
	 * @param ctx the parse tree
	 */
	void exitSwhile(demoParser.SwhileContext ctx);
	/**
	 * Enter a parse tree produced by {@link demoParser#sfor}.
	 * @param ctx the parse tree
	 */
	void enterSfor(demoParser.SforContext ctx);
	/**
	 * Exit a parse tree produced by {@link demoParser#sfor}.
	 * @param ctx the parse tree
	 */
	void exitSfor(demoParser.SforContext ctx);
	/**
	 * Enter a parse tree produced by the {@code jump_return}
	 * labeled alternative in {@link demoParser#jumpstat}.
	 * @param ctx the parse tree
	 */
	void enterJump_return(demoParser.Jump_returnContext ctx);
	/**
	 * Exit a parse tree produced by the {@code jump_return}
	 * labeled alternative in {@link demoParser#jumpstat}.
	 * @param ctx the parse tree
	 */
	void exitJump_return(demoParser.Jump_returnContext ctx);
	/**
	 * Enter a parse tree produced by the {@code jump_break}
	 * labeled alternative in {@link demoParser#jumpstat}.
	 * @param ctx the parse tree
	 */
	void enterJump_break(demoParser.Jump_breakContext ctx);
	/**
	 * Exit a parse tree produced by the {@code jump_break}
	 * labeled alternative in {@link demoParser#jumpstat}.
	 * @param ctx the parse tree
	 */
	void exitJump_break(demoParser.Jump_breakContext ctx);
	/**
	 * Enter a parse tree produced by the {@code jump_continue}
	 * labeled alternative in {@link demoParser#jumpstat}.
	 * @param ctx the parse tree
	 */
	void enterJump_continue(demoParser.Jump_continueContext ctx);
	/**
	 * Exit a parse tree produced by the {@code jump_continue}
	 * labeled alternative in {@link demoParser#jumpstat}.
	 * @param ctx the parse tree
	 */
	void exitJump_continue(demoParser.Jump_continueContext ctx);
	/**
	 * Enter a parse tree produced by {@link demoParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(demoParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link demoParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(demoParser.TypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link demoParser#functype}.
	 * @param ctx the parse tree
	 */
	void enterFunctype(demoParser.FunctypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link demoParser#functype}.
	 * @param ctx the parse tree
	 */
	void exitFunctype(demoParser.FunctypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link demoParser#vartype}.
	 * @param ctx the parse tree
	 */
	void enterVartype(demoParser.VartypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link demoParser#vartype}.
	 * @param ctx the parse tree
	 */
	void exitVartype(demoParser.VartypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link demoParser#arrtype}.
	 * @param ctx the parse tree
	 */
	void enterArrtype(demoParser.ArrtypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link demoParser#arrtype}.
	 * @param ctx the parse tree
	 */
	void exitArrtype(demoParser.ArrtypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link demoParser#varid}.
	 * @param ctx the parse tree
	 */
	void enterVarid(demoParser.VaridContext ctx);
	/**
	 * Exit a parse tree produced by {@link demoParser#varid}.
	 * @param ctx the parse tree
	 */
	void exitVarid(demoParser.VaridContext ctx);
	/**
	 * Enter a parse tree produced by {@link demoParser#funcid}.
	 * @param ctx the parse tree
	 */
	void enterFuncid(demoParser.FuncidContext ctx);
	/**
	 * Exit a parse tree produced by {@link demoParser#funcid}.
	 * @param ctx the parse tree
	 */
	void exitFuncid(demoParser.FuncidContext ctx);
	/**
	 * Enter a parse tree produced by {@link demoParser#clasid}.
	 * @param ctx the parse tree
	 */
	void enterClasid(demoParser.ClasidContext ctx);
	/**
	 * Exit a parse tree produced by {@link demoParser#clasid}.
	 * @param ctx the parse tree
	 */
	void exitClasid(demoParser.ClasidContext ctx);
}