/*
 * Written by Jeff Dyer
 * Copyright (c) 1998-2003 Mountain View Compiler Company
 * All rights reserved.
 */

package macromedia.asc.parser;

import macromedia.asc.util.*;
import macromedia.asc.semantics.*;

/**
 * Node
 *
 * @author Jeff Dyer
 */
public class ParenListExpressionNode extends Node
{
	public Node expr;

	public ParenListExpressionNode(Node expr)
	{
		this.expr = expr;
	}

	public Value evaluate(Context cx, Evaluator evaluator)
	{
		if (evaluator.checkFeature(cx, this))
		{
			return evaluator.evaluate(cx, this);
		}
		else
		{
			return null;
		}
	}

	public void voidResult()
	{
		expr.voidResult();
	}

	public boolean isListExpression()
	{
		return (expr instanceof ListNode);
	}

	public String toString()
	{
		return "ParenListExpression";
	}
}