package org.serenity.persistence.pdo

import javax.persistence.metamodel.SingularAttribute
import javax.persistence.metamodel.StaticMetamodel
import javax.persistence.metamodel.SetAttribute

@StaticMetamodel(Job)
public class Job_ {

    public static volatile SingularAttribute<Job, Integer> id

    public static volatile SingularAttribute<Job, String> name
    public static volatile SingularAttribute<Job, String> description

    public static volatile SetAttribute<Job, Cargo> cargo


}
