/*
 * Copyright (c) 2008 Mysema Ltd.
 * All rights reserved.
 * 
 */
package com.mysema.query.grammar;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Ops provides
 *
 * @author tiwe
 * @version $Id$
 */
public class HqlOps extends Ops {
    private static final Map<Op<?>,String> patterns = new HashMap<Op<?>,String>();
    static{            
        // boolean
        patterns.put(OpBoolean.AND, "(%s and %s)");
        patterns.put(OpBoolean.NOT, "not %s");
        patterns.put(OpBoolean.OR, "(%s or %s)");
        patterns.put(OpBoolean.XNOR, "(%s xnor %s)");
        patterns.put(OpBoolean.XOR, "(%s xor %s)");
        
        // comparison
        patterns.put(OpComparable.BETWEEN, "%s between %s and %s");
        patterns.put(OpComparable.GOE, "%s >= %s");
        patterns.put(OpComparable.GT, "%s > %s");
        patterns.put(OpComparable.LOE, "%s <= %s");
        patterns.put(OpComparable.LT, "%s < %s");
           
        patterns.put(OpDate.AFTER, "%s > %s");
        patterns.put(OpDate.BEFORE, "%s < %s");
        
        // arithmetic
        patterns.put(OpNumber.ADD, "%s + %s");        
        patterns.put(OpNumber.DIV, "%s / %s");
        patterns.put(OpNumber.MOD, "%s % %s");
        patterns.put(OpNumber.MULT, "%s * %s");
        patterns.put(OpNumber.SUB, "%s - %s");
        
        // various
        patterns.put(Op.EQ, "%s = %s");
        patterns.put(Op.ISTYPEOF, "%s.class = %s");
        patterns.put(Op.NE, "%s != %s");
        patterns.put(Op.INARRAY, "%s in (%s)");
        patterns.put(Op.INELEMENTS, "%s in elements(%s)");
        patterns.put(Op.ISNULL, "%s is null");
        patterns.put(Op.ISNOTNULL, "%s is not null");
        
        // string
        patterns.put(OpString.CONCAT, "%s || %s");
        patterns.put(OpString.LIKE, "%s like %s");
        patterns.put(OpString.LOWER, "lower(%s)");        
        patterns.put(OpString.SUBSTR1ARG, "substring(%s,%s)");
        patterns.put(OpString.SUBSTR2ARGS, "substring(%s,%s,%s)");
        patterns.put(OpString.TRIM, "trim(%s)");
        patterns.put(OpString.UPPER, "upper(%s)");
        
        
        // HQL specific
        patterns.put(OpHql.DISTINCT, "distinct %s");
        patterns.put(OpHql.SUM, "sum(%s)");
        patterns.put(OpHql.SYSDATE, "sysdate");
        patterns.put(OpHql.CURRENT_DATE, "current_date()");
        patterns.put(OpHql.CURRENT_TIME, "current_time()");
        patterns.put(OpHql.CURRENT_TIMESTAMP, "current_timestamp()");
    }
    
    public static String getPattern(Op<?> op){
        return patterns.get(op);
    }
    
    public interface OpHql<RT>{
        Op<Date> CURRENT_DATE = new OpImpl<Date>();
        Op<Date> CURRENT_TIME = new OpImpl<Date>();
        Op<Date> CURRENT_TIMESTAMP = new OpImpl<Date>();
        Op<Comparable<?>> DISTINCT = new OpImpl<Comparable<?>>();
        Op<Number> SUM = new OpImpl<Number>();
        Op<Date> SYSDATE = new OpImpl<Date>();
    }
    
}
