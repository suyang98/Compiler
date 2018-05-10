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
		IF=40, ELSE=41, WHILE=42, FOR=43, RETURN=44, BREAK=45, CONTINUE=46, Bool=47, 
		ID=48, Int=49, String=50, COMMENT=51, BLOCK_COMMENT=52, WS=53;
	public static final int
		RULE_prog = 0, RULE_block = 1, RULE_funcdef = 2, RULE_clasdef = 3, RULE_classbody = 4, 
		RULE_clastat = 5, RULE_claconstr = 6, RULE_paralist = 7, RULE_para = 8, 
		RULE_stat = 9, RULE_exprlist = 10, RULE_methodcall = 11, RULE_creator = 12, 
		RULE_indexem = 13, RULE_indexlist = 14, RULE_expr = 15, RULE_primary = 16, 
		RULE_sif = 17, RULE_swhile = 18, RULE_sfor = 19, RULE_jumpstat = 20, RULE_type = 21, 
		RULE_functype = 22, RULE_vartype = 23, RULE_arrtype = 24, RULE_varid = 25, 
		RULE_funcid = 26, RULE_clasid = 27;
	public static final String[] ruleNames = {
		"prog", "block", "funcdef", "clasdef", "classbody", "clastat", "claconstr", 
		"paralist", "para", "stat", "exprlist", "methodcall", "creator", "indexem", 
		"indexlist", "expr", "primary", "sif", "swhile", "sfor", "jumpstat", "type", 
		"functype", "vartype", "arrtype", "varid", "funcid", "clasid"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'('", "')'", "'{'", "'}'", "','", "'='", "';'", "'['", "']'", "'.'", 
		"'++'", "'--'", "'!'", "'~'", "'-'", "'*'", "'/'", "'%'", "'+'", "'<<'", 
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
		"BREAK", "CONTINUE", "Bool", "ID", "Int", "String", "COMMENT", "BLOCK_COMMENT", 
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
			setState(57); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(56);
				block();
				}
				}
				setState(59); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__2) | (1L << T__6) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << BOOL) | (1L << INT) | (1L << STR) | (1L << VOID) | (1L << NULL) | (1L << NEW) | (1L << CLASS) | (1L << IF) | (1L << WHILE) | (1L << FOR) | (1L << RETURN) | (1L << BREAK) | (1L << CONTINUE) | (1L << Bool) | (1L << ID) | (1L << Int) | (1L << String))) != 0) );
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
			setState(64);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				_localctx = new Block_funcdefContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(61);
				funcdef();
				}
				break;
			case 2:
				_localctx = new Block_clasdefContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(62);
				clasdef();
				}
				break;
			case 3:
				_localctx = new Block_stateContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(63);
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
			setState(66);
			functype();
			setState(67);
			funcid();
			setState(68);
			match(T__0);
			setState(70);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOL) | (1L << INT) | (1L << STR) | (1L << ID))) != 0)) {
				{
				setState(69);
				paralist();
				}
			}

			setState(72);
			match(T__1);
			setState(73);
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
			setState(75);
			match(CLASS);
			setState(76);
			clasid();
			setState(77);
			match(T__2);
			setState(78);
			classbody();
			setState(79);
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
			setState(84);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__2) | (1L << T__6) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << BOOL) | (1L << INT) | (1L << STR) | (1L << VOID) | (1L << NULL) | (1L << NEW) | (1L << IF) | (1L << WHILE) | (1L << FOR) | (1L << RETURN) | (1L << BREAK) | (1L << CONTINUE) | (1L << Bool) | (1L << ID) | (1L << Int) | (1L << String))) != 0)) {
				{
				{
				setState(81);
				clastat();
				}
				}
				setState(86);
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
			setState(90);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				_localctx = new Class_funcdefContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(87);
				funcdef();
				}
				break;
			case 2:
				_localctx = new Class_statContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(88);
				stat();
				}
				break;
			case 3:
				_localctx = new Class_clacContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(89);
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
			setState(92);
			clasid();
			setState(93);
			match(T__0);
			setState(94);
			match(T__1);
			setState(95);
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
			setState(97);
			para();
			setState(102);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__4) {
				{
				{
				setState(98);
				match(T__4);
				setState(99);
				para();
				}
				}
				setState(104);
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
			setState(117);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				_localctx = new Para_varContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(105);
				vartype();
				setState(106);
				varid();
				setState(109);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__5) {
					{
					setState(107);
					match(T__5);
					setState(108);
					expr(0);
					}
				}

				}
				break;
			case 2:
				_localctx = new Para_arrContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(111);
				arrtype();
				setState(112);
				varid();
				setState(115);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__5) {
					{
					setState(113);
					match(T__5);
					setState(114);
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
			setState(138);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				_localctx = new Stat_paraContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(119);
				para();
				setState(120);
				match(T__6);
				}
				break;
			case 2:
				_localctx = new Stat_exprContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(122);
				expr(0);
				setState(123);
				match(T__6);
				}
				break;
			case 3:
				_localctx = new Stat_ifContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(125);
				sif();
				}
				break;
			case 4:
				_localctx = new Stat_whileContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(126);
				swhile();
				}
				break;
			case 5:
				_localctx = new Stat_forContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(127);
				sfor();
				}
				break;
			case 6:
				_localctx = new Stat_jumpContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(128);
				jumpstat();
				}
				break;
			case 7:
				_localctx = new Stat_manyContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(129);
				match(T__2);
				setState(133);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__2) | (1L << T__6) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << BOOL) | (1L << INT) | (1L << STR) | (1L << NULL) | (1L << NEW) | (1L << IF) | (1L << WHILE) | (1L << FOR) | (1L << RETURN) | (1L << BREAK) | (1L << CONTINUE) | (1L << Bool) | (1L << ID) | (1L << Int) | (1L << String))) != 0)) {
					{
					{
					setState(130);
					stat();
					}
					}
					setState(135);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(136);
				match(T__3);
				}
				break;
			case 8:
				_localctx = new Stat_nullContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(137);
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
			setState(140);
			expr(0);
			setState(145);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__4) {
				{
				{
				setState(141);
				match(T__4);
				setState(142);
				expr(0);
				}
				}
				setState(147);
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
			setState(148);
			funcid();
			setState(149);
			match(T__0);
			setState(151);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << NULL) | (1L << NEW) | (1L << Bool) | (1L << ID) | (1L << Int) | (1L << String))) != 0)) {
				{
				setState(150);
				exprlist();
				}
			}

			setState(153);
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
		public List<IndexemContext> indexem() {
			return getRuleContexts(IndexemContext.class);
		}
		public IndexemContext indexem(int i) {
			return getRuleContext(IndexemContext.class,i);
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
			setState(155);
			vartype();
			setState(158);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				{
				setState(156);
				match(T__0);
				setState(157);
				match(T__1);
				}
				break;
			}
			setState(163);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(160);
					indexlist();
					}
					} 
				}
				setState(165);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
			}
			setState(169);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(166);
					indexem();
					}
					} 
				}
				setState(171);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
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

	public static class IndexemContext extends ParserRuleContext {
		public IndexemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_indexem; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof demoListener ) ((demoListener)listener).enterIndexem(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof demoListener ) ((demoListener)listener).exitIndexem(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof demoVisitor ) return ((demoVisitor<? extends T>)visitor).visitIndexem(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IndexemContext indexem() throws RecognitionException {
		IndexemContext _localctx = new IndexemContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_indexem);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(172);
			match(T__7);
			setState(173);
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
		enterRule(_localctx, 28, RULE_indexlist);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(175);
			match(T__7);
			setState(176);
			expr(0);
			setState(177);
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
		int _startState = 30;
		enterRecursionRule(_localctx, 30, RULE_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(188);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				{
				_localctx = new Expr_primContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(180);
				primary();
				}
				break;
			case 2:
				{
				_localctx = new Expr_methContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(181);
				methodcall();
				}
				break;
			case 3:
				{
				_localctx = new Expr_creaContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(182);
				match(NEW);
				setState(183);
				creator();
				}
				break;
			case 4:
				{
				_localctx = new Expr_fixdContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(184);
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
				setState(185);
				expr(13);
				}
				break;
			case 5:
				{
				_localctx = new Expr_fixnContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(186);
				((Expr_fixnContext)_localctx).prefix = _input.LT(1);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__12) | (1L << T__13) | (1L << T__14))) != 0)) ) {
					((Expr_fixnContext)_localctx).prefix = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(187);
				expr(12);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(235);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(233);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
					case 1:
						{
						_localctx = new Expr_clasContext(new ExprContext(_parentctx, _parentState));
						((Expr_clasContext)_localctx).clname = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(190);
						if (!(precpred(_ctx, 17))) throw new FailedPredicateException(this, "precpred(_ctx, 17)");
						setState(191);
						match(T__9);
						setState(192);
						((Expr_clasContext)_localctx).varname = expr(18);
						}
						break;
					case 2:
						{
						_localctx = new Expr_divdContext(new ExprContext(_parentctx, _parentState));
						((Expr_divdContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(193);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(194);
						((Expr_divdContext)_localctx).bop = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__15) | (1L << T__16) | (1L << T__17))) != 0)) ) {
							((Expr_divdContext)_localctx).bop = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(195);
						((Expr_divdContext)_localctx).right = expr(12);
						}
						break;
					case 3:
						{
						_localctx = new Expr_plusContext(new ExprContext(_parentctx, _parentState));
						((Expr_plusContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(196);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(197);
						((Expr_plusContext)_localctx).bop = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__14 || _la==T__18) ) {
							((Expr_plusContext)_localctx).bop = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(198);
						((Expr_plusContext)_localctx).right = expr(11);
						}
						break;
					case 4:
						{
						_localctx = new Expr_shifContext(new ExprContext(_parentctx, _parentState));
						((Expr_shifContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(199);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(200);
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
						setState(201);
						((Expr_shifContext)_localctx).right = expr(10);
						}
						break;
					case 5:
						{
						_localctx = new Expr_thanContext(new ExprContext(_parentctx, _parentState));
						((Expr_thanContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(202);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(203);
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
						setState(204);
						((Expr_thanContext)_localctx).right = expr(9);
						}
						break;
					case 6:
						{
						_localctx = new Expr_equiContext(new ExprContext(_parentctx, _parentState));
						((Expr_equiContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(205);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(206);
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
						setState(207);
						((Expr_equiContext)_localctx).right = expr(8);
						}
						break;
					case 7:
						{
						_localctx = new Expr_logContext(new ExprContext(_parentctx, _parentState));
						((Expr_logContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(208);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(209);
						((Expr_logContext)_localctx).bop = match(T__27);
						setState(210);
						((Expr_logContext)_localctx).right = expr(7);
						}
						break;
					case 8:
						{
						_localctx = new Expr_logContext(new ExprContext(_parentctx, _parentState));
						((Expr_logContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(211);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(212);
						((Expr_logContext)_localctx).bop = match(T__28);
						setState(213);
						((Expr_logContext)_localctx).right = expr(6);
						}
						break;
					case 9:
						{
						_localctx = new Expr_logContext(new ExprContext(_parentctx, _parentState));
						((Expr_logContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(214);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(215);
						((Expr_logContext)_localctx).bop = match(T__29);
						setState(216);
						((Expr_logContext)_localctx).right = expr(5);
						}
						break;
					case 10:
						{
						_localctx = new Expr_logContext(new ExprContext(_parentctx, _parentState));
						((Expr_logContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(217);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(218);
						((Expr_logContext)_localctx).bop = match(T__30);
						setState(219);
						((Expr_logContext)_localctx).right = expr(4);
						}
						break;
					case 11:
						{
						_localctx = new Expr_logContext(new ExprContext(_parentctx, _parentState));
						((Expr_logContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(220);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(221);
						((Expr_logContext)_localctx).bop = match(T__31);
						setState(222);
						((Expr_logContext)_localctx).right = expr(3);
						}
						break;
					case 12:
						{
						_localctx = new Expr_assiContext(new ExprContext(_parentctx, _parentState));
						((Expr_assiContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(223);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(224);
						((Expr_assiContext)_localctx).bop = match(T__5);
						setState(225);
						((Expr_assiContext)_localctx).right = expr(2);
						}
						break;
					case 13:
						{
						_localctx = new Expr_arraContext(new ExprContext(_parentctx, _parentState));
						((Expr_arraContext)_localctx).idname = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(226);
						if (!(precpred(_ctx, 16))) throw new FailedPredicateException(this, "precpred(_ctx, 16)");
						setState(227);
						match(T__7);
						setState(228);
						((Expr_arraContext)_localctx).index = expr(0);
						setState(229);
						match(T__8);
						}
						break;
					case 14:
						{
						_localctx = new Expr_posdContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(231);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						setState(232);
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
				setState(237);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
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
	public static class Primary_boolContext extends PrimaryContext {
		public TerminalNode Bool() { return getToken(demoParser.Bool, 0); }
		public Primary_boolContext(PrimaryContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof demoListener ) ((demoListener)listener).enterPrimary_bool(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof demoListener ) ((demoListener)listener).exitPrimary_bool(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof demoVisitor ) return ((demoVisitor<? extends T>)visitor).visitPrimary_bool(this);
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
		enterRule(_localctx, 32, RULE_primary);
		try {
			setState(247);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NULL:
				_localctx = new Primary_nullContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(238);
				match(NULL);
				}
				break;
			case Int:
				_localctx = new Primary_intContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(239);
				match(Int);
				}
				break;
			case String:
				_localctx = new Primary_strContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(240);
				match(String);
				}
				break;
			case Bool:
				_localctx = new Primary_boolContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(241);
				match(Bool);
				}
				break;
			case T__0:
				_localctx = new Primary_parensContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(242);
				match(T__0);
				setState(243);
				expr(0);
				setState(244);
				match(T__1);
				}
				break;
			case ID:
				_localctx = new Primary_varContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(246);
				varid();
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
		enterRule(_localctx, 34, RULE_sif);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(249);
			match(IF);
			setState(250);
			match(T__0);
			setState(251);
			expr(0);
			setState(252);
			match(T__1);
			setState(253);
			((SifContext)_localctx).then_state = stat();
			setState(256);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
			case 1:
				{
				setState(254);
				match(ELSE);
				setState(255);
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
		enterRule(_localctx, 36, RULE_swhile);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(258);
			match(WHILE);
			setState(259);
			match(T__0);
			setState(260);
			expr(0);
			setState(261);
			match(T__1);
			setState(262);
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
		enterRule(_localctx, 38, RULE_sfor);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(264);
			match(FOR);
			setState(265);
			match(T__0);
			setState(267);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << NULL) | (1L << NEW) | (1L << Bool) | (1L << ID) | (1L << Int) | (1L << String))) != 0)) {
				{
				setState(266);
				((SforContext)_localctx).expr1 = expr(0);
				}
			}

			setState(269);
			match(T__6);
			setState(271);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << NULL) | (1L << NEW) | (1L << Bool) | (1L << ID) | (1L << Int) | (1L << String))) != 0)) {
				{
				setState(270);
				((SforContext)_localctx).expr2 = expr(0);
				}
			}

			setState(273);
			match(T__6);
			setState(275);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << NULL) | (1L << NEW) | (1L << Bool) | (1L << ID) | (1L << Int) | (1L << String))) != 0)) {
				{
				setState(274);
				((SforContext)_localctx).expr3 = expr(0);
				}
			}

			setState(277);
			match(T__1);
			setState(278);
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
		enterRule(_localctx, 40, RULE_jumpstat);
		int _la;
		try {
			setState(289);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case RETURN:
				_localctx = new Jump_returnContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(280);
				match(RETURN);
				setState(282);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << NULL) | (1L << NEW) | (1L << Bool) | (1L << ID) | (1L << Int) | (1L << String))) != 0)) {
					{
					setState(281);
					expr(0);
					}
				}

				setState(284);
				match(T__6);
				}
				break;
			case BREAK:
				_localctx = new Jump_breakContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(285);
				match(BREAK);
				setState(286);
				match(T__6);
				}
				break;
			case CONTINUE:
				_localctx = new Jump_continueContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(287);
				match(CONTINUE);
				setState(288);
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
		enterRule(_localctx, 42, RULE_type);
		try {
			setState(296);
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
			case VOID:
				enterOuterAlt(_localctx, 4);
				{
				setState(294);
				match(VOID);
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 5);
				{
				setState(295);
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
		enterRule(_localctx, 44, RULE_functype);
		int _la;
		try {
			setState(307);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,28,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(298);
				type();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(299);
				type();
				setState(304);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__7) {
					{
					{
					setState(300);
					match(T__7);
					setState(301);
					match(T__8);
					}
					}
					setState(306);
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
		enterRule(_localctx, 46, RULE_vartype);
		try {
			setState(313);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case BOOL:
				enterOuterAlt(_localctx, 1);
				{
				setState(309);
				match(BOOL);
				}
				break;
			case INT:
				enterOuterAlt(_localctx, 2);
				{
				setState(310);
				match(INT);
				}
				break;
			case STR:
				enterOuterAlt(_localctx, 3);
				{
				setState(311);
				match(STR);
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 4);
				{
				setState(312);
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
		enterRule(_localctx, 48, RULE_arrtype);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(315);
			vartype();
			setState(320);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__7) {
				{
				{
				setState(316);
				match(T__7);
				setState(317);
				match(T__8);
				}
				}
				setState(322);
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
		enterRule(_localctx, 50, RULE_varid);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(323);
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
		enterRule(_localctx, 52, RULE_funcid);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(325);
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
		enterRule(_localctx, 54, RULE_clasid);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(327);
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
		case 15:
			return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 17);
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
			return precpred(_ctx, 16);
		case 13:
			return precpred(_ctx, 14);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\67\u014c\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\3\2\6\2<\n\2\r\2\16\2=\3\3\3"+
		"\3\3\3\5\3C\n\3\3\4\3\4\3\4\3\4\5\4I\n\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3"+
		"\5\3\5\3\6\7\6U\n\6\f\6\16\6X\13\6\3\7\3\7\3\7\5\7]\n\7\3\b\3\b\3\b\3"+
		"\b\3\b\3\t\3\t\3\t\7\tg\n\t\f\t\16\tj\13\t\3\n\3\n\3\n\3\n\5\np\n\n\3"+
		"\n\3\n\3\n\3\n\5\nv\n\n\5\nx\n\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3"+
		"\13\3\13\3\13\3\13\3\13\7\13\u0086\n\13\f\13\16\13\u0089\13\13\3\13\3"+
		"\13\5\13\u008d\n\13\3\f\3\f\3\f\7\f\u0092\n\f\f\f\16\f\u0095\13\f\3\r"+
		"\3\r\3\r\5\r\u009a\n\r\3\r\3\r\3\16\3\16\3\16\5\16\u00a1\n\16\3\16\7\16"+
		"\u00a4\n\16\f\16\16\16\u00a7\13\16\3\16\7\16\u00aa\n\16\f\16\16\16\u00ad"+
		"\13\16\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\21"+
		"\3\21\3\21\3\21\5\21\u00bf\n\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21"+
		"\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21"+
		"\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21"+
		"\3\21\3\21\3\21\3\21\3\21\3\21\3\21\7\21\u00ec\n\21\f\21\16\21\u00ef\13"+
		"\21\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\5\22\u00fa\n\22\3\23"+
		"\3\23\3\23\3\23\3\23\3\23\3\23\5\23\u0103\n\23\3\24\3\24\3\24\3\24\3\24"+
		"\3\24\3\25\3\25\3\25\5\25\u010e\n\25\3\25\3\25\5\25\u0112\n\25\3\25\3"+
		"\25\5\25\u0116\n\25\3\25\3\25\3\25\3\26\3\26\5\26\u011d\n\26\3\26\3\26"+
		"\3\26\3\26\3\26\5\26\u0124\n\26\3\27\3\27\3\27\3\27\3\27\5\27\u012b\n"+
		"\27\3\30\3\30\3\30\3\30\7\30\u0131\n\30\f\30\16\30\u0134\13\30\5\30\u0136"+
		"\n\30\3\31\3\31\3\31\3\31\5\31\u013c\n\31\3\32\3\32\3\32\7\32\u0141\n"+
		"\32\f\32\16\32\u0144\13\32\3\33\3\33\3\34\3\34\3\35\3\35\3\35\2\3 \36"+
		"\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\668\2\t\3\2"+
		"\r\16\3\2\17\21\3\2\22\24\4\2\21\21\25\25\3\2\26\27\3\2\30\33\3\2\34\35"+
		"\2\u016f\2;\3\2\2\2\4B\3\2\2\2\6D\3\2\2\2\bM\3\2\2\2\nV\3\2\2\2\f\\\3"+
		"\2\2\2\16^\3\2\2\2\20c\3\2\2\2\22w\3\2\2\2\24\u008c\3\2\2\2\26\u008e\3"+
		"\2\2\2\30\u0096\3\2\2\2\32\u009d\3\2\2\2\34\u00ae\3\2\2\2\36\u00b1\3\2"+
		"\2\2 \u00be\3\2\2\2\"\u00f9\3\2\2\2$\u00fb\3\2\2\2&\u0104\3\2\2\2(\u010a"+
		"\3\2\2\2*\u0123\3\2\2\2,\u012a\3\2\2\2.\u0135\3\2\2\2\60\u013b\3\2\2\2"+
		"\62\u013d\3\2\2\2\64\u0145\3\2\2\2\66\u0147\3\2\2\28\u0149\3\2\2\2:<\5"+
		"\4\3\2;:\3\2\2\2<=\3\2\2\2=;\3\2\2\2=>\3\2\2\2>\3\3\2\2\2?C\5\6\4\2@C"+
		"\5\b\5\2AC\5\24\13\2B?\3\2\2\2B@\3\2\2\2BA\3\2\2\2C\5\3\2\2\2DE\5.\30"+
		"\2EF\5\66\34\2FH\7\3\2\2GI\5\20\t\2HG\3\2\2\2HI\3\2\2\2IJ\3\2\2\2JK\7"+
		"\4\2\2KL\5\24\13\2L\7\3\2\2\2MN\7)\2\2NO\58\35\2OP\7\5\2\2PQ\5\n\6\2Q"+
		"R\7\6\2\2R\t\3\2\2\2SU\5\f\7\2TS\3\2\2\2UX\3\2\2\2VT\3\2\2\2VW\3\2\2\2"+
		"W\13\3\2\2\2XV\3\2\2\2Y]\5\6\4\2Z]\5\24\13\2[]\5\16\b\2\\Y\3\2\2\2\\Z"+
		"\3\2\2\2\\[\3\2\2\2]\r\3\2\2\2^_\58\35\2_`\7\3\2\2`a\7\4\2\2ab\5\24\13"+
		"\2b\17\3\2\2\2ch\5\22\n\2de\7\7\2\2eg\5\22\n\2fd\3\2\2\2gj\3\2\2\2hf\3"+
		"\2\2\2hi\3\2\2\2i\21\3\2\2\2jh\3\2\2\2kl\5\60\31\2lo\5\64\33\2mn\7\b\2"+
		"\2np\5 \21\2om\3\2\2\2op\3\2\2\2px\3\2\2\2qr\5\62\32\2ru\5\64\33\2st\7"+
		"\b\2\2tv\5 \21\2us\3\2\2\2uv\3\2\2\2vx\3\2\2\2wk\3\2\2\2wq\3\2\2\2x\23"+
		"\3\2\2\2yz\5\22\n\2z{\7\t\2\2{\u008d\3\2\2\2|}\5 \21\2}~\7\t\2\2~\u008d"+
		"\3\2\2\2\177\u008d\5$\23\2\u0080\u008d\5&\24\2\u0081\u008d\5(\25\2\u0082"+
		"\u008d\5*\26\2\u0083\u0087\7\5\2\2\u0084\u0086\5\24\13\2\u0085\u0084\3"+
		"\2\2\2\u0086\u0089\3\2\2\2\u0087\u0085\3\2\2\2\u0087\u0088\3\2\2\2\u0088"+
		"\u008a\3\2\2\2\u0089\u0087\3\2\2\2\u008a\u008d\7\6\2\2\u008b\u008d\7\t"+
		"\2\2\u008cy\3\2\2\2\u008c|\3\2\2\2\u008c\177\3\2\2\2\u008c\u0080\3\2\2"+
		"\2\u008c\u0081\3\2\2\2\u008c\u0082\3\2\2\2\u008c\u0083\3\2\2\2\u008c\u008b"+
		"\3\2\2\2\u008d\25\3\2\2\2\u008e\u0093\5 \21\2\u008f\u0090\7\7\2\2\u0090"+
		"\u0092\5 \21\2\u0091\u008f\3\2\2\2\u0092\u0095\3\2\2\2\u0093\u0091\3\2"+
		"\2\2\u0093\u0094\3\2\2\2\u0094\27\3\2\2\2\u0095\u0093\3\2\2\2\u0096\u0097"+
		"\5\66\34\2\u0097\u0099\7\3\2\2\u0098\u009a\5\26\f\2\u0099\u0098\3\2\2"+
		"\2\u0099\u009a\3\2\2\2\u009a\u009b\3\2\2\2\u009b\u009c\7\4\2\2\u009c\31"+
		"\3\2\2\2\u009d\u00a0\5\60\31\2\u009e\u009f\7\3\2\2\u009f\u00a1\7\4\2\2"+
		"\u00a0\u009e\3\2\2\2\u00a0\u00a1\3\2\2\2\u00a1\u00a5\3\2\2\2\u00a2\u00a4"+
		"\5\36\20\2\u00a3\u00a2\3\2\2\2\u00a4\u00a7\3\2\2\2\u00a5\u00a3\3\2\2\2"+
		"\u00a5\u00a6\3\2\2\2\u00a6\u00ab\3\2\2\2\u00a7\u00a5\3\2\2\2\u00a8\u00aa"+
		"\5\34\17\2\u00a9\u00a8\3\2\2\2\u00aa\u00ad\3\2\2\2\u00ab\u00a9\3\2\2\2"+
		"\u00ab\u00ac\3\2\2\2\u00ac\33\3\2\2\2\u00ad\u00ab\3\2\2\2\u00ae\u00af"+
		"\7\n\2\2\u00af\u00b0\7\13\2\2\u00b0\35\3\2\2\2\u00b1\u00b2\7\n\2\2\u00b2"+
		"\u00b3\5 \21\2\u00b3\u00b4\7\13\2\2\u00b4\37\3\2\2\2\u00b5\u00b6\b\21"+
		"\1\2\u00b6\u00bf\5\"\22\2\u00b7\u00bf\5\30\r\2\u00b8\u00b9\7(\2\2\u00b9"+
		"\u00bf\5\32\16\2\u00ba\u00bb\t\2\2\2\u00bb\u00bf\5 \21\17\u00bc\u00bd"+
		"\t\3\2\2\u00bd\u00bf\5 \21\16\u00be\u00b5\3\2\2\2\u00be\u00b7\3\2\2\2"+
		"\u00be\u00b8\3\2\2\2\u00be\u00ba\3\2\2\2\u00be\u00bc\3\2\2\2\u00bf\u00ed"+
		"\3\2\2\2\u00c0\u00c1\f\23\2\2\u00c1\u00c2\7\f\2\2\u00c2\u00ec\5 \21\24"+
		"\u00c3\u00c4\f\r\2\2\u00c4\u00c5\t\4\2\2\u00c5\u00ec\5 \21\16\u00c6\u00c7"+
		"\f\f\2\2\u00c7\u00c8\t\5\2\2\u00c8\u00ec\5 \21\r\u00c9\u00ca\f\13\2\2"+
		"\u00ca\u00cb\t\6\2\2\u00cb\u00ec\5 \21\f\u00cc\u00cd\f\n\2\2\u00cd\u00ce"+
		"\t\7\2\2\u00ce\u00ec\5 \21\13\u00cf\u00d0\f\t\2\2\u00d0\u00d1\t\b\2\2"+
		"\u00d1\u00ec\5 \21\n\u00d2\u00d3\f\b\2\2\u00d3\u00d4\7\36\2\2\u00d4\u00ec"+
		"\5 \21\t\u00d5\u00d6\f\7\2\2\u00d6\u00d7\7\37\2\2\u00d7\u00ec\5 \21\b"+
		"\u00d8\u00d9\f\6\2\2\u00d9\u00da\7 \2\2\u00da\u00ec\5 \21\7\u00db\u00dc"+
		"\f\5\2\2\u00dc\u00dd\7!\2\2\u00dd\u00ec\5 \21\6\u00de\u00df\f\4\2\2\u00df"+
		"\u00e0\7\"\2\2\u00e0\u00ec\5 \21\5\u00e1\u00e2\f\3\2\2\u00e2\u00e3\7\b"+
		"\2\2\u00e3\u00ec\5 \21\4\u00e4\u00e5\f\22\2\2\u00e5\u00e6\7\n\2\2\u00e6"+
		"\u00e7\5 \21\2\u00e7\u00e8\7\13\2\2\u00e8\u00ec\3\2\2\2\u00e9\u00ea\f"+
		"\20\2\2\u00ea\u00ec\t\2\2\2\u00eb\u00c0\3\2\2\2\u00eb\u00c3\3\2\2\2\u00eb"+
		"\u00c6\3\2\2\2\u00eb\u00c9\3\2\2\2\u00eb\u00cc\3\2\2\2\u00eb\u00cf\3\2"+
		"\2\2\u00eb\u00d2\3\2\2\2\u00eb\u00d5\3\2\2\2\u00eb\u00d8\3\2\2\2\u00eb"+
		"\u00db\3\2\2\2\u00eb\u00de\3\2\2\2\u00eb\u00e1\3\2\2\2\u00eb\u00e4\3\2"+
		"\2\2\u00eb\u00e9\3\2\2\2\u00ec\u00ef\3\2\2\2\u00ed\u00eb\3\2\2\2\u00ed"+
		"\u00ee\3\2\2\2\u00ee!\3\2\2\2\u00ef\u00ed\3\2\2\2\u00f0\u00fa\7\'\2\2"+
		"\u00f1\u00fa\7\63\2\2\u00f2\u00fa\7\64\2\2\u00f3\u00fa\7\61\2\2\u00f4"+
		"\u00f5\7\3\2\2\u00f5\u00f6\5 \21\2\u00f6\u00f7\7\4\2\2\u00f7\u00fa\3\2"+
		"\2\2\u00f8\u00fa\5\64\33\2\u00f9\u00f0\3\2\2\2\u00f9\u00f1\3\2\2\2\u00f9"+
		"\u00f2\3\2\2\2\u00f9\u00f3\3\2\2\2\u00f9\u00f4\3\2\2\2\u00f9\u00f8\3\2"+
		"\2\2\u00fa#\3\2\2\2\u00fb\u00fc\7*\2\2\u00fc\u00fd\7\3\2\2\u00fd\u00fe"+
		"\5 \21\2\u00fe\u00ff\7\4\2\2\u00ff\u0102\5\24\13\2\u0100\u0101\7+\2\2"+
		"\u0101\u0103\5\24\13\2\u0102\u0100\3\2\2\2\u0102\u0103\3\2\2\2\u0103%"+
		"\3\2\2\2\u0104\u0105\7,\2\2\u0105\u0106\7\3\2\2\u0106\u0107\5 \21\2\u0107"+
		"\u0108\7\4\2\2\u0108\u0109\5\24\13\2\u0109\'\3\2\2\2\u010a\u010b\7-\2"+
		"\2\u010b\u010d\7\3\2\2\u010c\u010e\5 \21\2\u010d\u010c\3\2\2\2\u010d\u010e"+
		"\3\2\2\2\u010e\u010f\3\2\2\2\u010f\u0111\7\t\2\2\u0110\u0112\5 \21\2\u0111"+
		"\u0110\3\2\2\2\u0111\u0112\3\2\2\2\u0112\u0113\3\2\2\2\u0113\u0115\7\t"+
		"\2\2\u0114\u0116\5 \21\2\u0115\u0114\3\2\2\2\u0115\u0116\3\2\2\2\u0116"+
		"\u0117\3\2\2\2\u0117\u0118\7\4\2\2\u0118\u0119\5\24\13\2\u0119)\3\2\2"+
		"\2\u011a\u011c\7.\2\2\u011b\u011d\5 \21\2\u011c\u011b\3\2\2\2\u011c\u011d"+
		"\3\2\2\2\u011d\u011e\3\2\2\2\u011e\u0124\7\t\2\2\u011f\u0120\7/\2\2\u0120"+
		"\u0124\7\t\2\2\u0121\u0122\7\60\2\2\u0122\u0124\7\t\2\2\u0123\u011a\3"+
		"\2\2\2\u0123\u011f\3\2\2\2\u0123\u0121\3\2\2\2\u0124+\3\2\2\2\u0125\u012b"+
		"\7#\2\2\u0126\u012b\7$\2\2\u0127\u012b\7%\2\2\u0128\u012b\7&\2\2\u0129"+
		"\u012b\58\35\2\u012a\u0125\3\2\2\2\u012a\u0126\3\2\2\2\u012a\u0127\3\2"+
		"\2\2\u012a\u0128\3\2\2\2\u012a\u0129\3\2\2\2\u012b-\3\2\2\2\u012c\u0136"+
		"\5,\27\2\u012d\u0132\5,\27\2\u012e\u012f\7\n\2\2\u012f\u0131\7\13\2\2"+
		"\u0130\u012e\3\2\2\2\u0131\u0134\3\2\2\2\u0132\u0130\3\2\2\2\u0132\u0133"+
		"\3\2\2\2\u0133\u0136\3\2\2\2\u0134\u0132\3\2\2\2\u0135\u012c\3\2\2\2\u0135"+
		"\u012d\3\2\2\2\u0136/\3\2\2\2\u0137\u013c\7#\2\2\u0138\u013c\7$\2\2\u0139"+
		"\u013c\7%\2\2\u013a\u013c\58\35\2\u013b\u0137\3\2\2\2\u013b\u0138\3\2"+
		"\2\2\u013b\u0139\3\2\2\2\u013b\u013a\3\2\2\2\u013c\61\3\2\2\2\u013d\u0142"+
		"\5\60\31\2\u013e\u013f\7\n\2\2\u013f\u0141\7\13\2\2\u0140\u013e\3\2\2"+
		"\2\u0141\u0144\3\2\2\2\u0142\u0140\3\2\2\2\u0142\u0143\3\2\2\2\u0143\63"+
		"\3\2\2\2\u0144\u0142\3\2\2\2\u0145\u0146\7\62\2\2\u0146\65\3\2\2\2\u0147"+
		"\u0148\7\62\2\2\u0148\67\3\2\2\2\u0149\u014a\7\62\2\2\u014a9\3\2\2\2!"+
		"=BHV\\houw\u0087\u008c\u0093\u0099\u00a0\u00a5\u00ab\u00be\u00eb\u00ed"+
		"\u00f9\u0102\u010d\u0111\u0115\u011c\u0123\u012a\u0132\u0135\u013b\u0142";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}