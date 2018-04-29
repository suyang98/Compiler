// Generated from C:/Users/user/IdeaProjects/compiler/src/main/java\demo.g4 by ANTLR 4.7
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class demoParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, T__30=31, 
		T__31=32, BOOL=33, INT=34, STR=35, VOID=36, NULL=37, NEW=38, CLASS=39, 
		IF=40, ELSE=41, WHILE=42, FOR=43, RETURN=44, BREAK=45, CONTINUE=46, ID=47, 
		Bool=48, Int=49, String=50, COMMENT=51, BLOCK_COMMENT=52, WS=53;
	public static final int
		RULE_prog = 0, RULE_block = 1, RULE_funcdef = 2, RULE_clasdef = 3, RULE_classbody = 4, 
		RULE_clastat = 5, RULE_claconstr = 6, RULE_paralist = 7, RULE_para = 8, 
		RULE_stat = 9, RULE_exprlist = 10, RULE_methodcall = 11, RULE_creator = 12, 
		RULE_indexlist = 13, RULE_expr = 14, RULE_primary = 15, RULE_sif = 16, 
		RULE_swhile = 17, RULE_sfor = 18, RULE_jumpstat = 19, RULE_type = 20, 
		RULE_functype = 21, RULE_vartype = 22, RULE_arrtype = 23, RULE_varid = 24, 
		RULE_funcid = 25, RULE_clasid = 26;
	public static final String[] ruleNames = {
		"prog", "block", "funcdef", "clasdef", "classbody", "clastat", "claconstr", 
		"paralist", "para", "stat", "exprlist", "methodcall", "creator", "indexlist", 
		"expr", "primary", "sif", "swhile", "sfor", "jumpstat", "type", "functype", 
		"vartype", "arrtype", "varid", "funcid", "clasid"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'('", "')'", "'{'", "'}'", "','", "'='", "';'", "'['", "']'", "'.'", 
		"'++'", "'--'", "'!'", "'~'", "'*'", "'/'", "'%'", "'+'", "'-'", "'<<'", 
		"'>>'", "'<'", "'<='", "'>'", "'>='", "'=='", "'!='", "'&'", "'^'", "'|'", 
		"'&&'", "'||'", "'bool'", "'int'", "'string'", "'void'", "'null'", "'new'", 
		"'class'", "'if'", "'else'", "'while'", "'for'", "'return'", "'break'", 
		"'continue'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, "BOOL", "INT", "STR", 
		"VOID", "NULL", "NEW", "CLASS", "IF", "ELSE", "WHILE", "FOR", "RETURN", 
		"BREAK", "CONTINUE", "ID", "Bool", "Int", "String", "COMMENT", "BLOCK_COMMENT", 
		"WS"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "demo.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public demoParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ProgContext extends ParserRuleContext {
		public List<BlockContext> block() {
			return getRuleContexts(BlockContext.class);
		}
		public BlockContext block(int i) {
			return getRuleContext(BlockContext.class,i);
		}
		public ProgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prog; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof demoListener ) ((demoListener)listener).enterProg(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof demoListener ) ((demoListener)listener).exitProg(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof demoVisitor ) return ((demoVisitor<? extends T>)visitor).visitProg(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgContext prog() throws RecognitionException {
		ProgContext _localctx = new ProgContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_prog);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(55); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(54);
				block();
				}
				}
				setState(57); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__2) | (1L << T__6) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << BOOL) | (1L << INT) | (1L << STR) | (1L << VOID) | (1L << NULL) | (1L << NEW) | (1L << CLASS) | (1L << IF) | (1L << WHILE) | (1L << FOR) | (1L << RETURN) | (1L << BREAK) | (1L << CONTINUE) | (1L << ID) | (1L << Int) | (1L << String))) != 0) );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BlockContext extends ParserRuleContext {
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
	 
		public BlockContext() { }
		public void copyFrom(BlockContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class Block_stateContext extends BlockContext {
		public StatContext stat() {
			return getRuleContext(StatContext.class,0);
		}
		public Block_stateContext(BlockContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof demoListener ) ((demoListener)listener).enterBlock_state(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof demoListener ) ((demoListener)listener).exitBlock_state(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof demoVisitor ) return ((demoVisitor<? extends T>)visitor).visitBlock_state(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Block_funcdefContext extends BlockContext {
		public FuncdefContext funcdef() {
			return getRuleContext(FuncdefContext.class,0);
		}
		public Block_funcdefContext(BlockContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof demoListener ) ((demoListener)listener).enterBlock_funcdef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof demoListener ) ((demoListener)listener).exitBlock_funcdef(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof demoVisitor ) return ((demoVisitor<? extends T>)visitor).visitBlock_funcdef(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Block_clasdefContext extends BlockContext {
		public ClasdefContext clasdef() {
			return getRuleContext(ClasdefContext.class,0);
		}
		public Block_clasdefContext(BlockContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof demoListener ) ((demoListener)listener).enterBlock_clasdef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof demoListener ) ((demoListener)listener).exitBlock_clasdef(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof demoVisitor ) return ((demoVisitor<? extends T>)visitor).visitBlock_clasdef(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_block);
		try {
			setState(62);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				_localctx = new Block_funcdefContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(59);
				funcdef();
				}
				break;
			case 2:
				_localctx = new Block_clasdefContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(60);
				clasdef();
				}
				break;
			case 3:
				_localctx = new Block_stateContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(61);
				stat();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FuncdefContext extends ParserRuleContext {
		public FunctypeContext functype() {
			return getRuleContext(FunctypeContext.class,0);
		}
		public FuncidContext funcid() {
			return getRuleContext(FuncidContext.class,0);
		}
		public StatContext stat() {
			return getRuleContext(StatContext.class,0);
		}
		public ParalistContext paralist() {
			return getRuleContext(ParalistContext.class,0);
		}
		public FuncdefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funcdef; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof demoListener ) ((demoListener)listener).enterFuncdef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof demoListener ) ((demoListener)listener).exitFuncdef(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof demoVisitor ) return ((demoVisitor<? extends T>)visitor).visitFuncdef(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FuncdefContext funcdef() throws RecognitionException {
		FuncdefContext _localctx = new FuncdefContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_funcdef);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(64);
			functype();
			setState(65);
			funcid();
			setState(66);
			match(T__0);
			setState(68);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOL) | (1L << INT) | (1L << STR) | (1L << ID))) != 0)) {
				{
				setState(67);
				paralist();
				}
			}

			setState(70);
			match(T__1);
			setState(71);
			stat();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ClasdefContext extends ParserRuleContext {
		public TerminalNode CLASS() { return getToken(demoParser.CLASS, 0); }
		public ClasidContext clasid() {
			return getRuleContext(ClasidContext.class,0);
		}
		public ClassbodyContext classbody() {
			return getRuleContext(ClassbodyContext.class,0);
		}
		public ClasdefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_clasdef; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof demoListener ) ((demoListener)listener).enterClasdef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof demoListener ) ((demoListener)listener).exitClasdef(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof demoVisitor ) return ((demoVisitor<? extends T>)visitor).visitClasdef(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClasdefContext clasdef() throws RecognitionException {
		ClasdefContext _localctx = new ClasdefContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_clasdef);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(73);
			match(CLASS);
			setState(74);
			clasid();
			setState(75);
			match(T__2);
			setState(76);
			classbody();
			setState(77);
			match(T__3);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ClassbodyContext extends ParserRuleContext {
		public List<ClastatContext> clastat() {
			return getRuleContexts(ClastatContext.class);
		}
		public ClastatContext clastat(int i) {
			return getRuleContext(ClastatContext.class,i);
		}
		public ClassbodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classbody; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof demoListener ) ((demoListener)listener).enterClassbody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof demoListener ) ((demoListener)listener).exitClassbody(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof demoVisitor ) return ((demoVisitor<? extends T>)visitor).visitClassbody(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClassbodyContext classbody() throws RecognitionException {
		ClassbodyContext _localctx = new ClassbodyContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_classbody);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(82);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__2) | (1L << T__6) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << BOOL) | (1L << INT) | (1L << STR) | (1L << VOID) | (1L << NULL) | (1L << NEW) | (1L << IF) | (1L << WHILE) | (1L << FOR) | (1L << RETURN) | (1L << BREAK) | (1L << CONTINUE) | (1L << ID) | (1L << Int) | (1L << String))) != 0)) {
				{
				{
				setState(79);
				clastat();
				}
				}
				setState(84);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ClastatContext extends ParserRuleContext {
		public ClastatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_clastat; }
	 
		public ClastatContext() { }
		public void copyFrom(ClastatContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class Class_funcdefContext extends ClastatContext {
		public FuncdefContext funcdef() {
			return getRuleContext(FuncdefContext.class,0);
		}
		public Class_funcdefContext(ClastatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof demoListener ) ((demoListener)listener).enterClass_funcdef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof demoListener ) ((demoListener)listener).exitClass_funcdef(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof demoVisitor ) return ((demoVisitor<? extends T>)visitor).visitClass_funcdef(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Class_clacContext extends ClastatContext {
		public ClaconstrContext claconstr() {
			return getRuleContext(ClaconstrContext.class,0);
		}
		public Class_clacContext(ClastatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof demoListener ) ((demoListener)listener).enterClass_clac(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof demoListener ) ((demoListener)listener).exitClass_clac(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof demoVisitor ) return ((demoVisitor<? extends T>)visitor).visitClass_clac(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Class_statContext extends ClastatContext {
		public StatContext stat() {
			return getRuleContext(StatContext.class,0);
		}
		public Class_statContext(ClastatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof demoListener ) ((demoListener)listener).enterClass_stat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof demoListener ) ((demoListener)listener).exitClass_stat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof demoVisitor ) return ((demoVisitor<? extends T>)visitor).visitClass_stat(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClastatContext clastat() throws RecognitionException {
		ClastatContext _localctx = new ClastatContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_clastat);
		try {
			setState(88);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				_localctx = new Class_funcdefContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(85);
				funcdef();
				}
				break;
			case 2:
				_localctx = new Class_statContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(86);
				stat();
				}
				break;
			case 3:
				_localctx = new Class_clacContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(87);
				claconstr();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ClaconstrContext extends ParserRuleContext {
		public ClasidContext clasid() {
			return getRuleContext(ClasidContext.class,0);
		}
		public StatContext stat() {
			return getRuleContext(StatContext.class,0);
		}
		public ClaconstrContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_claconstr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof demoListener ) ((demoListener)listener).enterClaconstr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof demoListener ) ((demoListener)listener).exitClaconstr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof demoVisitor ) return ((demoVisitor<? extends T>)visitor).visitClaconstr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClaconstrContext claconstr() throws RecognitionException {
		ClaconstrContext _localctx = new ClaconstrContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_claconstr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(90);
			clasid();
			setState(91);
			match(T__0);
			setState(92);
			match(T__1);
			setState(93);
			stat();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ParalistContext extends ParserRuleContext {
		public List<ParaContext> para() {
			return getRuleContexts(ParaContext.class);
		}
		public ParaContext para(int i) {
			return getRuleContext(ParaContext.class,i);
		}
		public ParalistContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_paralist; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof demoListener ) ((demoListener)listener).enterParalist(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof demoListener ) ((demoListener)listener).exitParalist(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof demoVisitor ) return ((demoVisitor<? extends T>)visitor).visitParalist(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParalistContext paralist() throws RecognitionException {
		ParalistContext _localctx = new ParalistContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_paralist);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(95);
			para();
			setState(100);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__4) {
				{
				{
				setState(96);
				match(T__4);
				setState(97);
				para();
				}
				}
				setState(102);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ParaContext extends ParserRuleContext {
		public ParaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_para; }
	 
		public ParaContext() { }
		public void copyFrom(ParaContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class Para_varContext extends ParaContext {
		public VartypeContext vartype() {
			return getRuleContext(VartypeContext.class,0);
		}
		public VaridContext varid() {
			return getRuleContext(VaridContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Para_varContext(ParaContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof demoListener ) ((demoListener)listener).enterPara_var(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof demoListener ) ((demoListener)listener).exitPara_var(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof demoVisitor ) return ((demoVisitor<? extends T>)visitor).visitPara_var(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Para_arrContext extends ParaContext {
		public ArrtypeContext arrtype() {
			return getRuleContext(ArrtypeContext.class,0);
		}
		public VaridContext varid() {
			return getRuleContext(VaridContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Para_arrContext(ParaContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof demoListener ) ((demoListener)listener).enterPara_arr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof demoListener ) ((demoListener)listener).exitPara_arr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof demoVisitor ) return ((demoVisitor<? extends T>)visitor).visitPara_arr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParaContext para() throws RecognitionException {
		ParaContext _localctx = new ParaContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_para);
		int _la;
		try {
			setState(115);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				_localctx = new Para_varContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(103);
				vartype();
				setState(104);
				varid();
				setState(107);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__5) {
					{
					setState(105);
					match(T__5);
					setState(106);
					expr(0);
					}
				}

				}
				break;
			case 2:
				_localctx = new Para_arrContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(109);
				arrtype();
				setState(110);
				varid();
				setState(113);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__5) {
					{
					setState(111);
					match(T__5);
					setState(112);
					expr(0);
					}
				}

				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StatContext extends ParserRuleContext {
		public StatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stat; }
	 
		public StatContext() { }
		public void copyFrom(StatContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class Stat_forContext extends StatContext {
		public SforContext sfor() {
			return getRuleContext(SforContext.class,0);
		}
		public Stat_forContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof demoListener ) ((demoListener)listener).enterStat_for(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof demoListener ) ((demoListener)listener).exitStat_for(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof demoVisitor ) return ((demoVisitor<? extends T>)visitor).visitStat_for(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Stat_nullContext extends StatContext {
		public Stat_nullContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof demoListener ) ((demoListener)listener).enterStat_null(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof demoListener ) ((demoListener)listener).exitStat_null(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof demoVisitor ) return ((demoVisitor<? extends T>)visitor).visitStat_null(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Stat_ifContext extends StatContext {
		public SifContext sif() {
			return getRuleContext(SifContext.class,0);
		}
		public Stat_ifContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof demoListener ) ((demoListener)listener).enterStat_if(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof demoListener ) ((demoListener)listener).exitStat_if(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof demoVisitor ) return ((demoVisitor<? extends T>)visitor).visitStat_if(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Stat_paraContext extends StatContext {
		public ParaContext para() {
			return getRuleContext(ParaContext.class,0);
		}
		public Stat_paraContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof demoListener ) ((demoListener)listener).enterStat_para(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof demoListener ) ((demoListener)listener).exitStat_para(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof demoVisitor ) return ((demoVisitor<? extends T>)visitor).visitStat_para(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Stat_jumpContext extends StatContext {
		public JumpstatContext jumpstat() {
			return getRuleContext(JumpstatContext.class,0);
		}
		public Stat_jumpContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof demoListener ) ((demoListener)listener).enterStat_jump(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof demoListener ) ((demoListener)listener).exitStat_jump(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof demoVisitor ) return ((demoVisitor<? extends T>)visitor).visitStat_jump(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Stat_manyContext extends StatContext {
		public List<StatContext> stat() {
			return getRuleContexts(StatContext.class);
		}
		public StatContext stat(int i) {
			return getRuleContext(StatContext.class,i);
		}
		public Stat_manyContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof demoListener ) ((demoListener)listener).enterStat_many(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof demoListener ) ((demoListener)listener).exitStat_many(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof demoVisitor ) return ((demoVisitor<? extends T>)visitor).visitStat_many(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Stat_whileContext extends StatContext {
		public SwhileContext swhile() {
			return getRuleContext(SwhileContext.class,0);
		}
		public Stat_whileContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof demoListener ) ((demoListener)listener).enterStat_while(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof demoListener ) ((demoListener)listener).exitStat_while(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof demoVisitor ) return ((demoVisitor<? extends T>)visitor).visitStat_while(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Stat_exprContext extends StatContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Stat_exprContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof demoListener ) ((demoListener)listener).enterStat_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof demoListener ) ((demoListener)listener).exitStat_expr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof demoVisitor ) return ((demoVisitor<? extends T>)visitor).visitStat_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatContext stat() throws RecognitionException {
		StatContext _localctx = new StatContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_stat);
		int _la;
		try {
			setState(136);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				_localctx = new Stat_paraContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(117);
				para();
				setState(118);
				match(T__6);
				}
				break;
			case 2:
				_localctx = new Stat_exprContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(120);
				expr(0);
				setState(121);
				match(T__6);
				}
				break;
			case 3:
				_localctx = new Stat_ifContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(123);
				sif();
				}
				break;
			case 4:
				_localctx = new Stat_whileContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(124);
				swhile();
				}
				break;
			case 5:
				_localctx = new Stat_forContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(125);
				sfor();
				}
				break;
			case 6:
				_localctx = new Stat_jumpContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(126);
				jumpstat();
				}
				break;
			case 7:
				_localctx = new Stat_manyContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(127);
				match(T__2);
				setState(131);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__2) | (1L << T__6) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << BOOL) | (1L << INT) | (1L << STR) | (1L << NULL) | (1L << NEW) | (1L << IF) | (1L << WHILE) | (1L << FOR) | (1L << RETURN) | (1L << BREAK) | (1L << CONTINUE) | (1L << ID) | (1L << Int) | (1L << String))) != 0)) {
					{
					{
					setState(128);
					stat();
					}
					}
					setState(133);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(134);
				match(T__3);
				}
				break;
			case 8:
				_localctx = new Stat_nullContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(135);
				match(T__6);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExprlistContext extends ParserRuleContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public ExprlistContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exprlist; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof demoListener ) ((demoListener)listener).enterExprlist(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof demoListener ) ((demoListener)listener).exitExprlist(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof demoVisitor ) return ((demoVisitor<? extends T>)visitor).visitExprlist(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprlistContext exprlist() throws RecognitionException {
		ExprlistContext _localctx = new ExprlistContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_exprlist);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(138);
			expr(0);
			setState(143);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__4) {
				{
				{
				setState(139);
				match(T__4);
				setState(140);
				expr(0);
				}
				}
				setState(145);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MethodcallContext extends ParserRuleContext {
		public FuncidContext funcid() {
			return getRuleContext(FuncidContext.class,0);
		}
		public ExprlistContext exprlist() {
			return getRuleContext(ExprlistContext.class,0);
		}
		public MethodcallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_methodcall; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof demoListener ) ((demoListener)listener).enterMethodcall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof demoListener ) ((demoListener)listener).exitMethodcall(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof demoVisitor ) return ((demoVisitor<? extends T>)visitor).visitMethodcall(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MethodcallContext methodcall() throws RecognitionException {
		MethodcallContext _localctx = new MethodcallContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_methodcall);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(146);
			funcid();
			setState(147);
			match(T__0);
			setState(149);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << NULL) | (1L << NEW) | (1L << ID) | (1L << Int) | (1L << String))) != 0)) {
				{
				setState(148);
				exprlist();
				}
			}

			setState(151);
			match(T__1);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CreatorContext extends ParserRuleContext {
		public VartypeContext vartype() {
			return getRuleContext(VartypeContext.class,0);
		}
		public List<IndexlistContext> indexlist() {
			return getRuleContexts(IndexlistContext.class);
		}
		public IndexlistContext indexlist(int i) {
			return getRuleContext(IndexlistContext.class,i);
		}
		public CreatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_creator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof demoListener ) ((demoListener)listener).enterCreator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof demoListener ) ((demoListener)listener).exitCreator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof demoVisitor ) return ((demoVisitor<? extends T>)visitor).visitCreator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CreatorContext creator() throws RecognitionException {
		CreatorContext _localctx = new CreatorContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_creator);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(153);
			vartype();
			setState(157);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(154);
					indexlist();
					}
					} 
				}
				setState(159);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IndexlistContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public IndexlistContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_indexlist; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof demoListener ) ((demoListener)listener).enterIndexlist(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof demoListener ) ((demoListener)listener).exitIndexlist(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof demoVisitor ) return ((demoVisitor<? extends T>)visitor).visitIndexlist(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IndexlistContext indexlist() throws RecognitionException {
		IndexlistContext _localctx = new IndexlistContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_indexlist);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(160);
			match(T__7);
			setState(162);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << NULL) | (1L << NEW) | (1L << ID) | (1L << Int) | (1L << String))) != 0)) {
				{
				setState(161);
				expr(0);
				}
			}

			setState(164);
			match(T__8);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExprContext extends ParserRuleContext {
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
	 
		public ExprContext() { }
		public void copyFrom(ExprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class Expr_fixdContext extends ExprContext {
		public Token prefix;
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Expr_fixdContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof demoListener ) ((demoListener)listener).enterExpr_fixd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof demoListener ) ((demoListener)listener).exitExpr_fixd(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof demoVisitor ) return ((demoVisitor<? extends T>)visitor).visitExpr_fixd(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Expr_shifContext extends ExprContext {
		public ExprContext left;
		public Token bop;
		public ExprContext right;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public Expr_shifContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof demoListener ) ((demoListener)listener).enterExpr_shif(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof demoListener ) ((demoListener)listener).exitExpr_shif(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof demoVisitor ) return ((demoVisitor<? extends T>)visitor).visitExpr_shif(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Expr_posdContext extends ExprContext {
		public Token postfix;
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Expr_posdContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof demoListener ) ((demoListener)listener).enterExpr_posd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof demoListener ) ((demoListener)listener).exitExpr_posd(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof demoVisitor ) return ((demoVisitor<? extends T>)visitor).visitExpr_posd(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Expr_divdContext extends ExprContext {
		public ExprContext left;
		public Token bop;
		public ExprContext right;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public Expr_divdContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof demoListener ) ((demoListener)listener).enterExpr_divd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof demoListener ) ((demoListener)listener).exitExpr_divd(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof demoVisitor ) return ((demoVisitor<? extends T>)visitor).visitExpr_divd(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Expr_assiContext extends ExprContext {
		public ExprContext left;
		public Token bop;
		public ExprContext right;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public Expr_assiContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof demoListener ) ((demoListener)listener).enterExpr_assi(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof demoListener ) ((demoListener)listener).exitExpr_assi(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof demoVisitor ) return ((demoVisitor<? extends T>)visitor).visitExpr_assi(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Expr_methContext extends ExprContext {
		public MethodcallContext methodcall() {
			return getRuleContext(MethodcallContext.class,0);
		}
		public Expr_methContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof demoListener ) ((demoListener)listener).enterExpr_meth(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof demoListener ) ((demoListener)listener).exitExpr_meth(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof demoVisitor ) return ((demoVisitor<? extends T>)visitor).visitExpr_meth(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Expr_thanContext extends ExprContext {
		public ExprContext left;
		public Token bop;
		public ExprContext right;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public Expr_thanContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof demoListener ) ((demoListener)listener).enterExpr_than(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof demoListener ) ((demoListener)listener).exitExpr_than(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof demoVisitor ) return ((demoVisitor<? extends T>)visitor).visitExpr_than(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Expr_creaContext extends ExprContext {
		public TerminalNode NEW() { return getToken(demoParser.NEW, 0); }
		public CreatorContext creator() {
			return getRuleContext(CreatorContext.class,0);
		}
		public Expr_creaContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof demoListener ) ((demoListener)listener).enterExpr_crea(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof demoListener ) ((demoListener)listener).exitExpr_crea(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof demoVisitor ) return ((demoVisitor<? extends T>)visitor).visitExpr_crea(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Expr_primContext extends ExprContext {
		public PrimaryContext primary() {
			return getRuleContext(PrimaryContext.class,0);
		}
		public Expr_primContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof demoListener ) ((demoListener)listener).enterExpr_prim(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof demoListener ) ((demoListener)listener).exitExpr_prim(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof demoVisitor ) return ((demoVisitor<? extends T>)visitor).visitExpr_prim(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Expr_logContext extends ExprContext {
		public ExprContext left;
		public Token bop;
		public ExprContext right;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public Expr_logContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof demoListener ) ((demoListener)listener).enterExpr_log(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof demoListener ) ((demoListener)listener).exitExpr_log(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof demoVisitor ) return ((demoVisitor<? extends T>)visitor).visitExpr_log(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Expr_equiContext extends ExprContext {
		public ExprContext left;
		public Token bop;
		public ExprContext right;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public Expr_equiContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof demoListener ) ((demoListener)listener).enterExpr_equi(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof demoListener ) ((demoListener)listener).exitExpr_equi(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof demoVisitor ) return ((demoVisitor<? extends T>)visitor).visitExpr_equi(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Expr_fixnContext extends ExprContext {
		public Token prefix;
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Expr_fixnContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof demoListener ) ((demoListener)listener).enterExpr_fixn(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof demoListener ) ((demoListener)listener).exitExpr_fixn(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof demoVisitor ) return ((demoVisitor<? extends T>)visitor).visitExpr_fixn(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Expr_plusContext extends ExprContext {
		public ExprContext left;
		public Token bop;
		public ExprContext right;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public Expr_plusContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof demoListener ) ((demoListener)listener).enterExpr_plus(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof demoListener ) ((demoListener)listener).exitExpr_plus(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof demoVisitor ) return ((demoVisitor<? extends T>)visitor).visitExpr_plus(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Expr_clasContext extends ExprContext {
		public ExprContext clname;
		public ExprContext varname;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public Expr_clasContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof demoListener ) ((demoListener)listener).enterExpr_clas(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof demoListener ) ((demoListener)listener).exitExpr_clas(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof demoVisitor ) return ((demoVisitor<? extends T>)visitor).visitExpr_clas(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Expr_arraContext extends ExprContext {
		public ExprContext idname;
		public ExprContext index;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public Expr_arraContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof demoListener ) ((demoListener)listener).enterExpr_arra(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof demoListener ) ((demoListener)listener).exitExpr_arra(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof demoVisitor ) return ((demoVisitor<? extends T>)visitor).visitExpr_arra(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		return expr(0);
	}

	private ExprContext expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprContext _localctx = new ExprContext(_ctx, _parentState);
		ExprContext _prevctx = _localctx;
		int _startState = 28;
		enterRecursionRule(_localctx, 28, RULE_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(175);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				{
				_localctx = new Expr_primContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(167);
				primary();
				}
				break;
			case 2:
				{
				_localctx = new Expr_methContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(168);
				methodcall();
				}
				break;
			case 3:
				{
				_localctx = new Expr_creaContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(169);
				match(NEW);
				setState(170);
				creator();
				}
				break;
			case 4:
				{
				_localctx = new Expr_fixdContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(171);
				((Expr_fixdContext)_localctx).prefix = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__10 || _la==T__11) ) {
					((Expr_fixdContext)_localctx).prefix = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(172);
				expr(13);
				}
				break;
			case 5:
				{
				_localctx = new Expr_fixnContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(173);
				((Expr_fixnContext)_localctx).prefix = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__12 || _la==T__13) ) {
					((Expr_fixnContext)_localctx).prefix = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(174);
				expr(12);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(222);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(220);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
					case 1:
						{
						_localctx = new Expr_clasContext(new ExprContext(_parentctx, _parentState));
						((Expr_clasContext)_localctx).clname = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(177);
						if (!(precpred(_ctx, 16))) throw new FailedPredicateException(this, "precpred(_ctx, 16)");
						setState(178);
						match(T__9);
						setState(179);
						((Expr_clasContext)_localctx).varname = expr(17);
						}
						break;
					case 2:
						{
						_localctx = new Expr_divdContext(new ExprContext(_parentctx, _parentState));
						((Expr_divdContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(180);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(181);
						((Expr_divdContext)_localctx).bop = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__14) | (1L << T__15) | (1L << T__16))) != 0)) ) {
							((Expr_divdContext)_localctx).bop = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(182);
						((Expr_divdContext)_localctx).right = expr(12);
						}
						break;
					case 3:
						{
						_localctx = new Expr_plusContext(new ExprContext(_parentctx, _parentState));
						((Expr_plusContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(183);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(184);
						((Expr_plusContext)_localctx).bop = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__17 || _la==T__18) ) {
							((Expr_plusContext)_localctx).bop = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(185);
						((Expr_plusContext)_localctx).right = expr(11);
						}
						break;
					case 4:
						{
						_localctx = new Expr_shifContext(new ExprContext(_parentctx, _parentState));
						((Expr_shifContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(186);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(187);
						((Expr_shifContext)_localctx).bop = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__19 || _la==T__20) ) {
							((Expr_shifContext)_localctx).bop = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(188);
						((Expr_shifContext)_localctx).right = expr(10);
						}
						break;
					case 5:
						{
						_localctx = new Expr_thanContext(new ExprContext(_parentctx, _parentState));
						((Expr_thanContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(189);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(190);
						((Expr_thanContext)_localctx).bop = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__21) | (1L << T__22) | (1L << T__23) | (1L << T__24))) != 0)) ) {
							((Expr_thanContext)_localctx).bop = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(191);
						((Expr_thanContext)_localctx).right = expr(9);
						}
						break;
					case 6:
						{
						_localctx = new Expr_equiContext(new ExprContext(_parentctx, _parentState));
						((Expr_equiContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(192);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(193);
						((Expr_equiContext)_localctx).bop = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__25 || _la==T__26) ) {
							((Expr_equiContext)_localctx).bop = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(194);
						((Expr_equiContext)_localctx).right = expr(8);
						}
						break;
					case 7:
						{
						_localctx = new Expr_logContext(new ExprContext(_parentctx, _parentState));
						((Expr_logContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(195);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(196);
						((Expr_logContext)_localctx).bop = match(T__27);
						setState(197);
						((Expr_logContext)_localctx).right = expr(7);
						}
						break;
					case 8:
						{
						_localctx = new Expr_logContext(new ExprContext(_parentctx, _parentState));
						((Expr_logContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(198);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(199);
						((Expr_logContext)_localctx).bop = match(T__28);
						setState(200);
						((Expr_logContext)_localctx).right = expr(6);
						}
						break;
					case 9:
						{
						_localctx = new Expr_logContext(new ExprContext(_parentctx, _parentState));
						((Expr_logContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(201);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(202);
						((Expr_logContext)_localctx).bop = match(T__29);
						setState(203);
						((Expr_logContext)_localctx).right = expr(5);
						}
						break;
					case 10:
						{
						_localctx = new Expr_logContext(new ExprContext(_parentctx, _parentState));
						((Expr_logContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(204);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(205);
						((Expr_logContext)_localctx).bop = match(T__30);
						setState(206);
						((Expr_logContext)_localctx).right = expr(4);
						}
						break;
					case 11:
						{
						_localctx = new Expr_logContext(new ExprContext(_parentctx, _parentState));
						((Expr_logContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(207);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(208);
						((Expr_logContext)_localctx).bop = match(T__31);
						setState(209);
						((Expr_logContext)_localctx).right = expr(3);
						}
						break;
					case 12:
						{
						_localctx = new Expr_assiContext(new ExprContext(_parentctx, _parentState));
						((Expr_assiContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(210);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(211);
						((Expr_assiContext)_localctx).bop = match(T__5);
						setState(212);
						((Expr_assiContext)_localctx).right = expr(2);
						}
						break;
					case 13:
						{
						_localctx = new Expr_arraContext(new ExprContext(_parentctx, _parentState));
						((Expr_arraContext)_localctx).idname = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(213);
						if (!(precpred(_ctx, 17))) throw new FailedPredicateException(this, "precpred(_ctx, 17)");
						setState(214);
						match(T__7);
						setState(215);
						((Expr_arraContext)_localctx).index = expr(0);
						setState(216);
						match(T__8);
						}
						break;
					case 14:
						{
						_localctx = new Expr_posdContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(218);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						setState(219);
						((Expr_posdContext)_localctx).postfix = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__10 || _la==T__11) ) {
							((Expr_posdContext)_localctx).postfix = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						}
						break;
					}
					} 
				}
				setState(224);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class PrimaryContext extends ParserRuleContext {
		public PrimaryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primary; }
	 
		public PrimaryContext() { }
		public void copyFrom(PrimaryContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class Primary_parensContext extends PrimaryContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Primary_parensContext(PrimaryContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof demoListener ) ((demoListener)listener).enterPrimary_parens(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof demoListener ) ((demoListener)listener).exitPrimary_parens(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof demoVisitor ) return ((demoVisitor<? extends T>)visitor).visitPrimary_parens(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Primary_varContext extends PrimaryContext {
		public VaridContext varid() {
			return getRuleContext(VaridContext.class,0);
		}
		public Primary_varContext(PrimaryContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof demoListener ) ((demoListener)listener).enterPrimary_var(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof demoListener ) ((demoListener)listener).exitPrimary_var(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof demoVisitor ) return ((demoVisitor<? extends T>)visitor).visitPrimary_var(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Primary_nullContext extends PrimaryContext {
		public TerminalNode NULL() { return getToken(demoParser.NULL, 0); }
		public Primary_nullContext(PrimaryContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof demoListener ) ((demoListener)listener).enterPrimary_null(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof demoListener ) ((demoListener)listener).exitPrimary_null(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof demoVisitor ) return ((demoVisitor<? extends T>)visitor).visitPrimary_null(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Primary_strContext extends PrimaryContext {
		public TerminalNode String() { return getToken(demoParser.String, 0); }
		public Primary_strContext(PrimaryContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof demoListener ) ((demoListener)listener).enterPrimary_str(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof demoListener ) ((demoListener)listener).exitPrimary_str(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof demoVisitor ) return ((demoVisitor<? extends T>)visitor).visitPrimary_str(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Primary_intContext extends PrimaryContext {
		public TerminalNode Int() { return getToken(demoParser.Int, 0); }
		public Primary_intContext(PrimaryContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof demoListener ) ((demoListener)listener).enterPrimary_int(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof demoListener ) ((demoListener)listener).exitPrimary_int(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof demoVisitor ) return ((demoVisitor<? extends T>)visitor).visitPrimary_int(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrimaryContext primary() throws RecognitionException {
		PrimaryContext _localctx = new PrimaryContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_primary);
		try {
			setState(233);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__0:
				_localctx = new Primary_parensContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(225);
				match(T__0);
				setState(226);
				expr(0);
				setState(227);
				match(T__1);
				}
				break;
			case ID:
				_localctx = new Primary_varContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(229);
				varid();
				}
				break;
			case NULL:
				_localctx = new Primary_nullContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(230);
				match(NULL);
				}
				break;
			case Int:
				_localctx = new Primary_intContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(231);
				match(Int);
				}
				break;
			case String:
				_localctx = new Primary_strContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(232);
				match(String);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SifContext extends ParserRuleContext {
		public StatContext then_state;
		public StatContext else_state;
		public TerminalNode IF() { return getToken(demoParser.IF, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public List<StatContext> stat() {
			return getRuleContexts(StatContext.class);
		}
		public StatContext stat(int i) {
			return getRuleContext(StatContext.class,i);
		}
		public TerminalNode ELSE() { return getToken(demoParser.ELSE, 0); }
		public SifContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sif; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof demoListener ) ((demoListener)listener).enterSif(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof demoListener ) ((demoListener)listener).exitSif(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof demoVisitor ) return ((demoVisitor<? extends T>)visitor).visitSif(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SifContext sif() throws RecognitionException {
		SifContext _localctx = new SifContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_sif);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(235);
			match(IF);
			setState(236);
			match(T__0);
			setState(237);
			expr(0);
			setState(238);
			match(T__1);
			setState(239);
			((SifContext)_localctx).then_state = stat();
			setState(242);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
			case 1:
				{
				setState(240);
				match(ELSE);
				setState(241);
				((SifContext)_localctx).else_state = stat();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SwhileContext extends ParserRuleContext {
		public TerminalNode WHILE() { return getToken(demoParser.WHILE, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public StatContext stat() {
			return getRuleContext(StatContext.class,0);
		}
		public SwhileContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_swhile; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof demoListener ) ((demoListener)listener).enterSwhile(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof demoListener ) ((demoListener)listener).exitSwhile(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof demoVisitor ) return ((demoVisitor<? extends T>)visitor).visitSwhile(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SwhileContext swhile() throws RecognitionException {
		SwhileContext _localctx = new SwhileContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_swhile);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(244);
			match(WHILE);
			setState(245);
			match(T__0);
			setState(246);
			expr(0);
			setState(247);
			match(T__1);
			setState(248);
			stat();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SforContext extends ParserRuleContext {
		public ExprContext expr1;
		public ExprContext expr2;
		public ExprContext expr3;
		public TerminalNode FOR() { return getToken(demoParser.FOR, 0); }
		public StatContext stat() {
			return getRuleContext(StatContext.class,0);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public SforContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sfor; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof demoListener ) ((demoListener)listener).enterSfor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof demoListener ) ((demoListener)listener).exitSfor(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof demoVisitor ) return ((demoVisitor<? extends T>)visitor).visitSfor(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SforContext sfor() throws RecognitionException {
		SforContext _localctx = new SforContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_sfor);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(250);
			match(FOR);
			setState(251);
			match(T__0);
			setState(252);
			((SforContext)_localctx).expr1 = expr(0);
			setState(253);
			match(T__6);
			setState(255);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << NULL) | (1L << NEW) | (1L << ID) | (1L << Int) | (1L << String))) != 0)) {
				{
				setState(254);
				((SforContext)_localctx).expr2 = expr(0);
				}
			}

			setState(257);
			match(T__6);
			setState(258);
			((SforContext)_localctx).expr3 = expr(0);
			setState(259);
			match(T__1);
			setState(260);
			stat();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class JumpstatContext extends ParserRuleContext {
		public JumpstatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_jumpstat; }
	 
		public JumpstatContext() { }
		public void copyFrom(JumpstatContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class Jump_continueContext extends JumpstatContext {
		public TerminalNode CONTINUE() { return getToken(demoParser.CONTINUE, 0); }
		public Jump_continueContext(JumpstatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof demoListener ) ((demoListener)listener).enterJump_continue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof demoListener ) ((demoListener)listener).exitJump_continue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof demoVisitor ) return ((demoVisitor<? extends T>)visitor).visitJump_continue(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Jump_returnContext extends JumpstatContext {
		public TerminalNode RETURN() { return getToken(demoParser.RETURN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Jump_returnContext(JumpstatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof demoListener ) ((demoListener)listener).enterJump_return(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof demoListener ) ((demoListener)listener).exitJump_return(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof demoVisitor ) return ((demoVisitor<? extends T>)visitor).visitJump_return(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Jump_breakContext extends JumpstatContext {
		public TerminalNode BREAK() { return getToken(demoParser.BREAK, 0); }
		public Jump_breakContext(JumpstatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof demoListener ) ((demoListener)listener).enterJump_break(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof demoListener ) ((demoListener)listener).exitJump_break(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof demoVisitor ) return ((demoVisitor<? extends T>)visitor).visitJump_break(this);
			else return visitor.visitChildren(this);
		}
	}

	public final JumpstatContext jumpstat() throws RecognitionException {
		JumpstatContext _localctx = new JumpstatContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_jumpstat);
		int _la;
		try {
			setState(271);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case RETURN:
				_localctx = new Jump_returnContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(262);
				match(RETURN);
				setState(264);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << NULL) | (1L << NEW) | (1L << ID) | (1L << Int) | (1L << String))) != 0)) {
					{
					setState(263);
					expr(0);
					}
				}

				setState(266);
				match(T__6);
				}
				break;
			case BREAK:
				_localctx = new Jump_breakContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(267);
				match(BREAK);
				setState(268);
				match(T__6);
				}
				break;
			case CONTINUE:
				_localctx = new Jump_continueContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(269);
				match(CONTINUE);
				setState(270);
				match(T__6);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeContext extends ParserRuleContext {
		public TerminalNode BOOL() { return getToken(demoParser.BOOL, 0); }
		public TerminalNode INT() { return getToken(demoParser.INT, 0); }
		public TerminalNode STR() { return getToken(demoParser.STR, 0); }
		public TerminalNode VOID() { return getToken(demoParser.VOID, 0); }
		public ClasidContext clasid() {
			return getRuleContext(ClasidContext.class,0);
		}
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof demoListener ) ((demoListener)listener).enterType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof demoListener ) ((demoListener)listener).exitType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof demoVisitor ) return ((demoVisitor<? extends T>)visitor).visitType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_type);
		try {
			setState(278);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case BOOL:
				enterOuterAlt(_localctx, 1);
				{
				setState(273);
				match(BOOL);
				}
				break;
			case INT:
				enterOuterAlt(_localctx, 2);
				{
				setState(274);
				match(INT);
				}
				break;
			case STR:
				enterOuterAlt(_localctx, 3);
				{
				setState(275);
				match(STR);
				}
				break;
			case VOID:
				enterOuterAlt(_localctx, 4);
				{
				setState(276);
				match(VOID);
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 5);
				{
				setState(277);
				clasid();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FunctypeContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public FunctypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functype; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof demoListener ) ((demoListener)listener).enterFunctype(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof demoListener ) ((demoListener)listener).exitFunctype(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof demoVisitor ) return ((demoVisitor<? extends T>)visitor).visitFunctype(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctypeContext functype() throws RecognitionException {
		FunctypeContext _localctx = new FunctypeContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_functype);
		int _la;
		try {
			setState(289);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,25,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(280);
				type();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(281);
				type();
				setState(286);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__7) {
					{
					{
					setState(282);
					match(T__7);
					setState(283);
					match(T__8);
					}
					}
					setState(288);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VartypeContext extends ParserRuleContext {
		public TerminalNode BOOL() { return getToken(demoParser.BOOL, 0); }
		public TerminalNode INT() { return getToken(demoParser.INT, 0); }
		public TerminalNode STR() { return getToken(demoParser.STR, 0); }
		public ClasidContext clasid() {
			return getRuleContext(ClasidContext.class,0);
		}
		public VartypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_vartype; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof demoListener ) ((demoListener)listener).enterVartype(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof demoListener ) ((demoListener)listener).exitVartype(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof demoVisitor ) return ((demoVisitor<? extends T>)visitor).visitVartype(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VartypeContext vartype() throws RecognitionException {
		VartypeContext _localctx = new VartypeContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_vartype);
		try {
			setState(295);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case BOOL:
				enterOuterAlt(_localctx, 1);
				{
				setState(291);
				match(BOOL);
				}
				break;
			case INT:
				enterOuterAlt(_localctx, 2);
				{
				setState(292);
				match(INT);
				}
				break;
			case STR:
				enterOuterAlt(_localctx, 3);
				{
				setState(293);
				match(STR);
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 4);
				{
				setState(294);
				clasid();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ArrtypeContext extends ParserRuleContext {
		public VartypeContext vartype() {
			return getRuleContext(VartypeContext.class,0);
		}
		public ArrtypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arrtype; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof demoListener ) ((demoListener)listener).enterArrtype(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof demoListener ) ((demoListener)listener).exitArrtype(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof demoVisitor ) return ((demoVisitor<? extends T>)visitor).visitArrtype(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArrtypeContext arrtype() throws RecognitionException {
		ArrtypeContext _localctx = new ArrtypeContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_arrtype);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(297);
			vartype();
			setState(302);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__7) {
				{
				{
				setState(298);
				match(T__7);
				setState(299);
				match(T__8);
				}
				}
				setState(304);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VaridContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(demoParser.ID, 0); }
		public VaridContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varid; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof demoListener ) ((demoListener)listener).enterVarid(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof demoListener ) ((demoListener)listener).exitVarid(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof demoVisitor ) return ((demoVisitor<? extends T>)visitor).visitVarid(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VaridContext varid() throws RecognitionException {
		VaridContext _localctx = new VaridContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_varid);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(305);
			match(ID);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FuncidContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(demoParser.ID, 0); }
		public FuncidContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funcid; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof demoListener ) ((demoListener)listener).enterFuncid(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof demoListener ) ((demoListener)listener).exitFuncid(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof demoVisitor ) return ((demoVisitor<? extends T>)visitor).visitFuncid(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FuncidContext funcid() throws RecognitionException {
		FuncidContext _localctx = new FuncidContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_funcid);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(307);
			match(ID);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ClasidContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(demoParser.ID, 0); }
		public ClasidContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_clasid; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof demoListener ) ((demoListener)listener).enterClasid(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof demoListener ) ((demoListener)listener).exitClasid(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof demoVisitor ) return ((demoVisitor<? extends T>)visitor).visitClasid(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClasidContext clasid() throws RecognitionException {
		ClasidContext _localctx = new ClasidContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_clasid);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(309);
			match(ID);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 14:
			return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 16);
		case 1:
			return precpred(_ctx, 11);
		case 2:
			return precpred(_ctx, 10);
		case 3:
			return precpred(_ctx, 9);
		case 4:
			return precpred(_ctx, 8);
		case 5:
			return precpred(_ctx, 7);
		case 6:
			return precpred(_ctx, 6);
		case 7:
			return precpred(_ctx, 5);
		case 8:
			return precpred(_ctx, 4);
		case 9:
			return precpred(_ctx, 3);
		case 10:
			return precpred(_ctx, 2);
		case 11:
			return precpred(_ctx, 1);
		case 12:
			return precpred(_ctx, 17);
		case 13:
			return precpred(_ctx, 14);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\67\u013a\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\3\2\6\2:\n\2\r\2\16\2;\3\3\3\3\3\3\5\3"+
		"A\n\3\3\4\3\4\3\4\3\4\5\4G\n\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\6"+
		"\7\6S\n\6\f\6\16\6V\13\6\3\7\3\7\3\7\5\7[\n\7\3\b\3\b\3\b\3\b\3\b\3\t"+
		"\3\t\3\t\7\te\n\t\f\t\16\th\13\t\3\n\3\n\3\n\3\n\5\nn\n\n\3\n\3\n\3\n"+
		"\3\n\5\nt\n\n\5\nv\n\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3"+
		"\13\3\13\3\13\7\13\u0084\n\13\f\13\16\13\u0087\13\13\3\13\3\13\5\13\u008b"+
		"\n\13\3\f\3\f\3\f\7\f\u0090\n\f\f\f\16\f\u0093\13\f\3\r\3\r\3\r\5\r\u0098"+
		"\n\r\3\r\3\r\3\16\3\16\7\16\u009e\n\16\f\16\16\16\u00a1\13\16\3\17\3\17"+
		"\5\17\u00a5\n\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20"+
		"\5\20\u00b2\n\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20"+
		"\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20"+
		"\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20"+
		"\3\20\3\20\3\20\3\20\7\20\u00df\n\20\f\20\16\20\u00e2\13\20\3\21\3\21"+
		"\3\21\3\21\3\21\3\21\3\21\3\21\5\21\u00ec\n\21\3\22\3\22\3\22\3\22\3\22"+
		"\3\22\3\22\5\22\u00f5\n\22\3\23\3\23\3\23\3\23\3\23\3\23\3\24\3\24\3\24"+
		"\3\24\3\24\5\24\u0102\n\24\3\24\3\24\3\24\3\24\3\24\3\25\3\25\5\25\u010b"+
		"\n\25\3\25\3\25\3\25\3\25\3\25\5\25\u0112\n\25\3\26\3\26\3\26\3\26\3\26"+
		"\5\26\u0119\n\26\3\27\3\27\3\27\3\27\7\27\u011f\n\27\f\27\16\27\u0122"+
		"\13\27\5\27\u0124\n\27\3\30\3\30\3\30\3\30\5\30\u012a\n\30\3\31\3\31\3"+
		"\31\7\31\u012f\n\31\f\31\16\31\u0132\13\31\3\32\3\32\3\33\3\33\3\34\3"+
		"\34\3\34\2\3\36\35\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60"+
		"\62\64\66\2\t\3\2\r\16\3\2\17\20\3\2\21\23\3\2\24\25\3\2\26\27\3\2\30"+
		"\33\3\2\34\35\2\u015a\29\3\2\2\2\4@\3\2\2\2\6B\3\2\2\2\bK\3\2\2\2\nT\3"+
		"\2\2\2\fZ\3\2\2\2\16\\\3\2\2\2\20a\3\2\2\2\22u\3\2\2\2\24\u008a\3\2\2"+
		"\2\26\u008c\3\2\2\2\30\u0094\3\2\2\2\32\u009b\3\2\2\2\34\u00a2\3\2\2\2"+
		"\36\u00b1\3\2\2\2 \u00eb\3\2\2\2\"\u00ed\3\2\2\2$\u00f6\3\2\2\2&\u00fc"+
		"\3\2\2\2(\u0111\3\2\2\2*\u0118\3\2\2\2,\u0123\3\2\2\2.\u0129\3\2\2\2\60"+
		"\u012b\3\2\2\2\62\u0133\3\2\2\2\64\u0135\3\2\2\2\66\u0137\3\2\2\28:\5"+
		"\4\3\298\3\2\2\2:;\3\2\2\2;9\3\2\2\2;<\3\2\2\2<\3\3\2\2\2=A\5\6\4\2>A"+
		"\5\b\5\2?A\5\24\13\2@=\3\2\2\2@>\3\2\2\2@?\3\2\2\2A\5\3\2\2\2BC\5,\27"+
		"\2CD\5\64\33\2DF\7\3\2\2EG\5\20\t\2FE\3\2\2\2FG\3\2\2\2GH\3\2\2\2HI\7"+
		"\4\2\2IJ\5\24\13\2J\7\3\2\2\2KL\7)\2\2LM\5\66\34\2MN\7\5\2\2NO\5\n\6\2"+
		"OP\7\6\2\2P\t\3\2\2\2QS\5\f\7\2RQ\3\2\2\2SV\3\2\2\2TR\3\2\2\2TU\3\2\2"+
		"\2U\13\3\2\2\2VT\3\2\2\2W[\5\6\4\2X[\5\24\13\2Y[\5\16\b\2ZW\3\2\2\2ZX"+
		"\3\2\2\2ZY\3\2\2\2[\r\3\2\2\2\\]\5\66\34\2]^\7\3\2\2^_\7\4\2\2_`\5\24"+
		"\13\2`\17\3\2\2\2af\5\22\n\2bc\7\7\2\2ce\5\22\n\2db\3\2\2\2eh\3\2\2\2"+
		"fd\3\2\2\2fg\3\2\2\2g\21\3\2\2\2hf\3\2\2\2ij\5.\30\2jm\5\62\32\2kl\7\b"+
		"\2\2ln\5\36\20\2mk\3\2\2\2mn\3\2\2\2nv\3\2\2\2op\5\60\31\2ps\5\62\32\2"+
		"qr\7\b\2\2rt\5\36\20\2sq\3\2\2\2st\3\2\2\2tv\3\2\2\2ui\3\2\2\2uo\3\2\2"+
		"\2v\23\3\2\2\2wx\5\22\n\2xy\7\t\2\2y\u008b\3\2\2\2z{\5\36\20\2{|\7\t\2"+
		"\2|\u008b\3\2\2\2}\u008b\5\"\22\2~\u008b\5$\23\2\177\u008b\5&\24\2\u0080"+
		"\u008b\5(\25\2\u0081\u0085\7\5\2\2\u0082\u0084\5\24\13\2\u0083\u0082\3"+
		"\2\2\2\u0084\u0087\3\2\2\2\u0085\u0083\3\2\2\2\u0085\u0086\3\2\2\2\u0086"+
		"\u0088\3\2\2\2\u0087\u0085\3\2\2\2\u0088\u008b\7\6\2\2\u0089\u008b\7\t"+
		"\2\2\u008aw\3\2\2\2\u008az\3\2\2\2\u008a}\3\2\2\2\u008a~\3\2\2\2\u008a"+
		"\177\3\2\2\2\u008a\u0080\3\2\2\2\u008a\u0081\3\2\2\2\u008a\u0089\3\2\2"+
		"\2\u008b\25\3\2\2\2\u008c\u0091\5\36\20\2\u008d\u008e\7\7\2\2\u008e\u0090"+
		"\5\36\20\2\u008f\u008d\3\2\2\2\u0090\u0093\3\2\2\2\u0091\u008f\3\2\2\2"+
		"\u0091\u0092\3\2\2\2\u0092\27\3\2\2\2\u0093\u0091\3\2\2\2\u0094\u0095"+
		"\5\64\33\2\u0095\u0097\7\3\2\2\u0096\u0098\5\26\f\2\u0097\u0096\3\2\2"+
		"\2\u0097\u0098\3\2\2\2\u0098\u0099\3\2\2\2\u0099\u009a\7\4\2\2\u009a\31"+
		"\3\2\2\2\u009b\u009f\5.\30\2\u009c\u009e\5\34\17\2\u009d\u009c\3\2\2\2"+
		"\u009e\u00a1\3\2\2\2\u009f\u009d\3\2\2\2\u009f\u00a0\3\2\2\2\u00a0\33"+
		"\3\2\2\2\u00a1\u009f\3\2\2\2\u00a2\u00a4\7\n\2\2\u00a3\u00a5\5\36\20\2"+
		"\u00a4\u00a3\3\2\2\2\u00a4\u00a5\3\2\2\2\u00a5\u00a6\3\2\2\2\u00a6\u00a7"+
		"\7\13\2\2\u00a7\35\3\2\2\2\u00a8\u00a9\b\20\1\2\u00a9\u00b2\5 \21\2\u00aa"+
		"\u00b2\5\30\r\2\u00ab\u00ac\7(\2\2\u00ac\u00b2\5\32\16\2\u00ad\u00ae\t"+
		"\2\2\2\u00ae\u00b2\5\36\20\17\u00af\u00b0\t\3\2\2\u00b0\u00b2\5\36\20"+
		"\16\u00b1\u00a8\3\2\2\2\u00b1\u00aa\3\2\2\2\u00b1\u00ab\3\2\2\2\u00b1"+
		"\u00ad\3\2\2\2\u00b1\u00af\3\2\2\2\u00b2\u00e0\3\2\2\2\u00b3\u00b4\f\22"+
		"\2\2\u00b4\u00b5\7\f\2\2\u00b5\u00df\5\36\20\23\u00b6\u00b7\f\r\2\2\u00b7"+
		"\u00b8\t\4\2\2\u00b8\u00df\5\36\20\16\u00b9\u00ba\f\f\2\2\u00ba\u00bb"+
		"\t\5\2\2\u00bb\u00df\5\36\20\r\u00bc\u00bd\f\13\2\2\u00bd\u00be\t\6\2"+
		"\2\u00be\u00df\5\36\20\f\u00bf\u00c0\f\n\2\2\u00c0\u00c1\t\7\2\2\u00c1"+
		"\u00df\5\36\20\13\u00c2\u00c3\f\t\2\2\u00c3\u00c4\t\b\2\2\u00c4\u00df"+
		"\5\36\20\n\u00c5\u00c6\f\b\2\2\u00c6\u00c7\7\36\2\2\u00c7\u00df\5\36\20"+
		"\t\u00c8\u00c9\f\7\2\2\u00c9\u00ca\7\37\2\2\u00ca\u00df\5\36\20\b\u00cb"+
		"\u00cc\f\6\2\2\u00cc\u00cd\7 \2\2\u00cd\u00df\5\36\20\7\u00ce\u00cf\f"+
		"\5\2\2\u00cf\u00d0\7!\2\2\u00d0\u00df\5\36\20\6\u00d1\u00d2\f\4\2\2\u00d2"+
		"\u00d3\7\"\2\2\u00d3\u00df\5\36\20\5\u00d4\u00d5\f\3\2\2\u00d5\u00d6\7"+
		"\b\2\2\u00d6\u00df\5\36\20\4\u00d7\u00d8\f\23\2\2\u00d8\u00d9\7\n\2\2"+
		"\u00d9\u00da\5\36\20\2\u00da\u00db\7\13\2\2\u00db\u00df\3\2\2\2\u00dc"+
		"\u00dd\f\20\2\2\u00dd\u00df\t\2\2\2\u00de\u00b3\3\2\2\2\u00de\u00b6\3"+
		"\2\2\2\u00de\u00b9\3\2\2\2\u00de\u00bc\3\2\2\2\u00de\u00bf\3\2\2\2\u00de"+
		"\u00c2\3\2\2\2\u00de\u00c5\3\2\2\2\u00de\u00c8\3\2\2\2\u00de\u00cb\3\2"+
		"\2\2\u00de\u00ce\3\2\2\2\u00de\u00d1\3\2\2\2\u00de\u00d4\3\2\2\2\u00de"+
		"\u00d7\3\2\2\2\u00de\u00dc\3\2\2\2\u00df\u00e2\3\2\2\2\u00e0\u00de\3\2"+
		"\2\2\u00e0\u00e1\3\2\2\2\u00e1\37\3\2\2\2\u00e2\u00e0\3\2\2\2\u00e3\u00e4"+
		"\7\3\2\2\u00e4\u00e5\5\36\20\2\u00e5\u00e6\7\4\2\2\u00e6\u00ec\3\2\2\2"+
		"\u00e7\u00ec\5\62\32\2\u00e8\u00ec\7\'\2\2\u00e9\u00ec\7\63\2\2\u00ea"+
		"\u00ec\7\64\2\2\u00eb\u00e3\3\2\2\2\u00eb\u00e7\3\2\2\2\u00eb\u00e8\3"+
		"\2\2\2\u00eb\u00e9\3\2\2\2\u00eb\u00ea\3\2\2\2\u00ec!\3\2\2\2\u00ed\u00ee"+
		"\7*\2\2\u00ee\u00ef\7\3\2\2\u00ef\u00f0\5\36\20\2\u00f0\u00f1\7\4\2\2"+
		"\u00f1\u00f4\5\24\13\2\u00f2\u00f3\7+\2\2\u00f3\u00f5\5\24\13\2\u00f4"+
		"\u00f2\3\2\2\2\u00f4\u00f5\3\2\2\2\u00f5#\3\2\2\2\u00f6\u00f7\7,\2\2\u00f7"+
		"\u00f8\7\3\2\2\u00f8\u00f9\5\36\20\2\u00f9\u00fa\7\4\2\2\u00fa\u00fb\5"+
		"\24\13\2\u00fb%\3\2\2\2\u00fc\u00fd\7-\2\2\u00fd\u00fe\7\3\2\2\u00fe\u00ff"+
		"\5\36\20\2\u00ff\u0101\7\t\2\2\u0100\u0102\5\36\20\2\u0101\u0100\3\2\2"+
		"\2\u0101\u0102\3\2\2\2\u0102\u0103\3\2\2\2\u0103\u0104\7\t\2\2\u0104\u0105"+
		"\5\36\20\2\u0105\u0106\7\4\2\2\u0106\u0107\5\24\13\2\u0107\'\3\2\2\2\u0108"+
		"\u010a\7.\2\2\u0109\u010b\5\36\20\2\u010a\u0109\3\2\2\2\u010a\u010b\3"+
		"\2\2\2\u010b\u010c\3\2\2\2\u010c\u0112\7\t\2\2\u010d\u010e\7/\2\2\u010e"+
		"\u0112\7\t\2\2\u010f\u0110\7\60\2\2\u0110\u0112\7\t\2\2\u0111\u0108\3"+
		"\2\2\2\u0111\u010d\3\2\2\2\u0111\u010f\3\2\2\2\u0112)\3\2\2\2\u0113\u0119"+
		"\7#\2\2\u0114\u0119\7$\2\2\u0115\u0119\7%\2\2\u0116\u0119\7&\2\2\u0117"+
		"\u0119\5\66\34\2\u0118\u0113\3\2\2\2\u0118\u0114\3\2\2\2\u0118\u0115\3"+
		"\2\2\2\u0118\u0116\3\2\2\2\u0118\u0117\3\2\2\2\u0119+\3\2\2\2\u011a\u0124"+
		"\5*\26\2\u011b\u0120\5*\26\2\u011c\u011d\7\n\2\2\u011d\u011f\7\13\2\2"+
		"\u011e\u011c\3\2\2\2\u011f\u0122\3\2\2\2\u0120\u011e\3\2\2\2\u0120\u0121"+
		"\3\2\2\2\u0121\u0124\3\2\2\2\u0122\u0120\3\2\2\2\u0123\u011a\3\2\2\2\u0123"+
		"\u011b\3\2\2\2\u0124-\3\2\2\2\u0125\u012a\7#\2\2\u0126\u012a\7$\2\2\u0127"+
		"\u012a\7%\2\2\u0128\u012a\5\66\34\2\u0129\u0125\3\2\2\2\u0129\u0126\3"+
		"\2\2\2\u0129\u0127\3\2\2\2\u0129\u0128\3\2\2\2\u012a/\3\2\2\2\u012b\u0130"+
		"\5.\30\2\u012c\u012d\7\n\2\2\u012d\u012f\7\13\2\2\u012e\u012c\3\2\2\2"+
		"\u012f\u0132\3\2\2\2\u0130\u012e\3\2\2\2\u0130\u0131\3\2\2\2\u0131\61"+
		"\3\2\2\2\u0132\u0130\3\2\2\2\u0133\u0134\7\61\2\2\u0134\63\3\2\2\2\u0135"+
		"\u0136\7\61\2\2\u0136\65\3\2\2\2\u0137\u0138\7\61\2\2\u0138\67\3\2\2\2"+
		"\36;@FTZfmsu\u0085\u008a\u0091\u0097\u009f\u00a4\u00b1\u00de\u00e0\u00eb"+
		"\u00f4\u0101\u010a\u0111\u0118\u0120\u0123\u0129\u0130";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}