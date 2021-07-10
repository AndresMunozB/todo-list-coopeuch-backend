package cl.coopeuch.backend.models;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.Where;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Calendar;

@Data
@Entity
@Table(name = "todo")
@SQLDelete(sql = "UPDATE todo SET deleted=true WHERE id = ?")
//@Where(clause = "deleted = false")
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; //identificador

    @Column(name = "description", nullable = false, length = 255)
    private String description; //Descripcion

    @Column(name = "done", nullable = false)
    private Boolean done; //Vigente (negado)

    @Column(name = "deleted", nullable = false)
    private Boolean deleted;

    @CreationTimestamp
    @Column(name = "created_date_time", nullable = false)
    private Calendar createdTimestamp; //fechaCreacion

    @UpdateTimestamp
    @Column(name = "updated_date_time", nullable = false)
    private Calendar updatedTimestamp; //fechaActualizacion

}
