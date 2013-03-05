package com.wadpam.open.audit.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import net.sf.mardao.core.Filter;
import net.sf.mardao.core.dao.Dao;

import com.wadpam.open.audit.domain.DAudit;

/**
 * Implementation of Business Methods related to entity DAudit.
 * This (empty) class is generated by mardao, but edited by developers.
 * It is not overwritten by the generator once it exists.
 *
 * Generated on 2013-03-05T10:26:06.767+0700.
 * @author mardao DAO generator (net.sf.mardao.plugin.ProcessDomainMojo)
 */
public class DAuditDaoBean 
	extends GeneratedDAuditDaoImpl
		implements DAuditDao 
{

	// TODO: implement your Business Methods here
    @Override
    public Collection<Long> whatsDeleted(Date since, Object parentKey) {
        final Filter sinceFilter = createGreaterThanOrEqualFilter(COLUMN_NAME_UPDATEDDATE, since);
        final Iterable<DAudit> i = queryIterable(true, 0, -1, parentKey, null, COLUMN_NAME_UPDATEDDATE, true, null, false, sinceFilter);
        final ArrayList<Long> ids = new ArrayList<Long>();
        
        for (DAudit d : i) {
            ids.add(d.getId());
        }
        
        return ids;
    }

    public static Object getAuditKey(Dao entityDao) {
        return entityDao.getPrimaryKey(null, AUDIT_PARENT_ID);
    }
}
