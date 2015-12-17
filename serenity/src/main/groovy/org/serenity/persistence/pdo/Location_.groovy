package org.serenity.persistence.pdo

import javax.persistence.metamodel.SingularAttribute
import javax.persistence.metamodel.StaticMetamodel
import javax.persistence.metamodel.SetAttribute


@StaticMetamodel(Location)
public class Location_ {

    public static volatile SingularAttribute<Location, Integer> id

    public static volatile SingularAttribute<Location, String> name

    public static volatile SetAttribute<Location, Cargo> cargo


}
