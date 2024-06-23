package com.example.demo.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "tb_empleado")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class EmpleadoEntity {
    
    @Id
    @Column(name="dni_empleado", nullable = false, length = 8, columnDefinition = "CHAR(8)")
    private String dni;
    
    @Column(name = "nombre_empleado", nullable = false, length = 45, columnDefinition = "VARCHAR(45)")
    private String nombre;
    
    @Column(name = "apellido_empleado", nullable = false, length = 45, columnDefinition = "VARCHAR(45)")
    private String apellido;
    
    @Column(name = "fecha_nacimiento", nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecNaci;
    
    @Column(name = "direccion", nullable = false, length = 45,columnDefinition = "VARCHAR(45)")
    private String direc;
    
    @Column(name = "correo", nullable = false, length = 45, columnDefinition = "VARCHAR(45)")
    private String correo;
    
    @ManyToOne
    @JoinColumn(name="areaId", nullable = false)
    private AreaEntity areaEntity;
}
