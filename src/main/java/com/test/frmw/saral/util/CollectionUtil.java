package com.test.frmw.saral.util;

import com.test.frmw.saral.model.EntityWithName;
import java.util.List;

public class CollectionUtil {

    public static boolean ifNamedEntityAlreadyExists(List<? extends EntityWithName> source, EntityWithName target){
       return source.stream().anyMatch(entity -> entity.getName().equalsIgnoreCase(target.getName()));

    }
}
