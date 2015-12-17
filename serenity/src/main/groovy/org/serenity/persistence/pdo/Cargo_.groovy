package org.serenity.persistence.pdo

import javax.persistence.metamodel.SingularAttribute
import javax.persistence.metamodel.StaticMetamodel

@StaticMetamodel(Cargo)
public class Cargo_ {

    public static volatile SingularAttribute<Cargo, Integer> id

    public static volatile SingularAttribute<Cargo, String> owner
    public static volatile SingularAttribute<Cargo, String> description
    public static volatile SingularAttribute<Cargo, Integer> count
    public static volatile SingularAttribute<Cargo, Location> location
    public static volatile SingularAttribute<Cargo, Job> job

}
