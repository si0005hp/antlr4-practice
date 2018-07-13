package com.example;

import java.util.Scanner;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

import com.example.calc.CalcBaseVisitor;
import com.example.calc.CalcLexer;
import com.example.calc.CalcParser;
import com.example.calc.CalcParser.ExprContext;
import com.example.calc.CalcParser.PrimaryContext;
import com.example.calc.CalcParser.TermContext;

@SuppressWarnings("deprecation")
public class Calc {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in);) {
            String input = sc.nextLine();
            
            int result = new Calc().calc(input);
            System.out.println(result);
        }
    }
    
    public int calc(String input) {
        CalcLexer lex = new CalcLexer(new ANTLRInputStream(input));
        CalcParser parser = new CalcParser(new CommonTokenStream(lex));

        ParseTree tree = parser.expr();
         
        ParseTreeVisitor<Integer> visitor = new Visitor();
        return visitor.visit(tree);
    }

    static class Visitor extends CalcBaseVisitor<Integer> {
        
        @Override
        public Integer visitPrimary(PrimaryContext ctx) {
            return Integer.parseInt(ctx.INT().getText());
        }

        @Override
        public Integer visitTerm(TermContext ctx) {
            if (ctx.MUL() != null) {
                return visitTerm(ctx.term()) * visitPrimary(ctx.primary());
            } else if (ctx.DIV() != null) {
                return visitTerm(ctx.term()) / visitPrimary(ctx.primary());
            } else {
                return visitPrimary(ctx.primary());
            }
        }

        @Override
        public Integer visitExpr(ExprContext ctx) {
            if (ctx.ADD() != null) {
                return visitExpr(ctx.expr()) + visitTerm(ctx.term());
            } else if (ctx.SUB() != null) {
                return visitExpr(ctx.expr()) - visitTerm(ctx.term());
            } else {
                return visitTerm(ctx.term());
            }
        }
    }
}
