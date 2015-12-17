package org.serenity.persistence.pdo

import groovy.transform.Canonical
import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString

import javax.persistence.Basic
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.Id
import javax.persistence.NamedQueries
import javax.persistence.NamedQuery
import javax.persistence.OneToMany
import javax.persistence.Table
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size
import javax.xml.bind.annotation.XmlRootElement


@Entity
@Table(name = 'job', catalog = 'serenity', schema = '')
@XmlRootElement
@NamedQueries([
    @NamedQuery(name = 'Job.findAll', query = 'SELECT j FROM Job j'),
    @NamedQuery(name = 'Job.findByName', query = 'SELECT j FROM Job j WHERE j.name = :name')
])
@Canonical
@EqualsAndHashCode(excludes = ['id','cargo'])
@ToString(excludes = ['cargo'])
class Job implements Serializable {
    private static final long serialVersionUID = 1L

    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = 'id', nullable = false)
    Integer id

    @Size(max = 255)
    @Column(name = 'name', length = 255)
    String name

    @Size(max = 255)
    @Column(name = 'description', length = 255)
    String description

    @OneToMany(mappedBy = 'job', fetch = FetchType.LAZY)
    Set<Cargo> cargo

}
