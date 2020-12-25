package in.kodecamp.services.student;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Version;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * StudentEntity
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "StudentEntity.findAll", query = "SELECT se FROM StudentEntity se"),
    @NamedQuery(
        name = "StudentEntity.findAllActive",
        query = "SELECT se FROM StudentEntity se WHERE se.active = true"),
    @NamedQuery(
        name = "StudentEntity.findById",
        query = "SELECT se FROM StudentEntity se WHERE se.id = :id and se.active = true"),
    @NamedQuery(
        name = "StudentEntity.findByName",
        query = "SELECT se FROM StudentEntity se WHERE se.name =:name and se.active = true"),
    @NamedQuery(
        name = "StudentEntity.findByNameLike",
        query = "SELECT se FROM StudentEntity se WHERE se.name like concat('%',:name,'%') and se.active = true"),
    @NamedQuery(
        name = "StudentEntity.findByAddressLike",
        query = "SELECT se FROM StudentEntity se WHERE se.address like concat('%',:address,'%') and se.active = true") })
@Table(name = "STUDENTS")
@Data
// no field of this class is marked for equals and hascode so the super class
// version
// will be called
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class StudentEntity {

  @Column(name = "NAME")
  private String name;

  @Column(name = "ADDRESS")
  private String address;

  @EqualsAndHashCode.Include
  @Column(name = "ID")
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  protected long id;

  @Column(name = "VERSION")
  @Version
  protected long version;

  @Column(name = "ACTIVE")
  protected boolean active;

  @Column(name = "CREATED_ON")
  protected LocalDateTime createdOn;

  @Column(name = "MODIFIED_ON")
  protected LocalDateTime modifiedOn;

  public StudentEntity() {
  }

  // this will be used by the api to create new students
  public StudentEntity(final String name, final String address) {
    this.name = name;
    this.address = address;
  }

}
