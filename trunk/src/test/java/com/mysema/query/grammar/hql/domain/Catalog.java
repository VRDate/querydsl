package com.mysema.query.grammar.hql.domain;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;

/**
 * Catalog provides
 *
 * @author tiwe
 * @version $Id$
 */
@Entity
public class Catalog {
    protected Collection<Price> prices;
    protected Date effectiveDate;
}
