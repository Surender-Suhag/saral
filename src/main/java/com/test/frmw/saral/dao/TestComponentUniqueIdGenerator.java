package com.test.frmw.saral.dao;

import org.hibernate.HibernateException;
import org.hibernate.MappingException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.enhanced.SequenceStyleGenerator;
import org.hibernate.internal.util.config.ConfigurationHelper;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.type.LongType;
import org.hibernate.type.Type;

import java.io.Serializable;
import java.util.Properties;

public class TestComponentUniqueIdGenerator extends SequenceStyleGenerator {

    public static final String VALUE_PREFIX_PARAM = "PREFIX_PARAM";
    private static final String VALUE_PREFIX_DEFAULT = "";
    private String prefix;

    private static final String NUMBER_FORMAT = "%05d";

    @Override
    public void configure(Type type, Properties params, ServiceRegistry serviceRegistry) throws MappingException {
        super.configure(LongType.INSTANCE, params, serviceRegistry);

        prefix = ConfigurationHelper.getString(
                TestComponentUniqueIdGenerator.VALUE_PREFIX_PARAM,
                params,
                TestComponentUniqueIdGenerator.VALUE_PREFIX_DEFAULT);

        System.out.println(prefix);
    }

    @Override
    public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
        return prefix + String.format(TestComponentUniqueIdGenerator.NUMBER_FORMAT,
                super.generate(session,object));
    }
}
