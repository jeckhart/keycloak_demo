package org.serenity.persistence.pdo

import groovy.transform.Canonical
import groovy.transform.EqualsAndHashCode

import javax.persistence.Basic
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.persistence.NamedQueries
import javax.persistence.NamedQuery
import javax.persistence.Table
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size
import javax.xml.bind.annotation.XmlRootElement

@Entity
@Table(name = 'cargo', catalog = 'serenity', schema = '')
@XmlRootElement
@NamedQueries([
    @NamedQuery(name = 'Cargo.findAll', query = 'SELECT c FROM Cargo c'),
    @NamedQuery(name = 'Cargo.findByOwner', query = 'SELECT c FROM Cargo c WHERE c.owner = :owner')
])
@Canonical
@EqualsAndHashCode(excludes = ['id'])
class Cargo implements Serializable {
    private static final long serialVersionUID = 1L
	
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = 'id', nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id

    @Size(max = 255)
    @Column(name = 'owner', length = 255)
    String owner

    @Size(max = 255)
    @Column(name = 'description', length = 255)
    String description

    @Column(name = 'count')
    Integer count

    @JoinColumn(name = 'location', referencedColumnName = 'id', nullable = false)
    @ManyToOne(optional = false)
    Location location

    @JoinColumn(name = 'job', referencedColumnName = 'id')
    @ManyToOne
    Job job

}
