package com.microservice.CitizenService.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Citizen {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column
    private String name;
    @Column
    private int vaccinationCenterId;
}


/* @Entity: - This annotation make Citizen class as entity and will persist into database.
 * @Data: As we have added Lombok dependency and By using this @Data we don't need to put getters and setters.
 * @AllArgsConstructor and @NoArgsConstructor because if we put @AllArgsConstructor then @NoArgsConstructor will be there.
 * Remember that we are going to use a separate database as design pattern. So, what we need to do is we need to have
 * some variable into this particular entity "Citizen" which decides which particular vaccination center this citizen has
 * register to, e.g. private int vaccinationCenterId; which is going to tell me at which particular vaccination center
 * this particular citizen has register.
 *
 * Now we want this id to be unique and not null and auto generated so for unique and not null - @Id which is basically a primary key and for auto-generated - @GeneratedValue(strategy = GenerationType.AUTO.
 * If you want to "hibernate" to decide the generation type then choose "AUTO" if not then select among IDENTITY,SEQUENCE,TABLE.
 * Now "name" and "vaccinationCenterId" would be annotated with @Column to denote that these are column in a table.
 *
 * So after all this is how we create an entity into database where this class name "Citizen" is going to be our table name
 * and it's fields are id, then column name and vaccinationCenterId. So once we run this application then we should have
 * table with this "Citizen" name in our database which is nothing but an entity of database and its properties like id, name and vaccinationCenterId.
 *
 * Once we run application there will be two table the one which is "citizen" and another "citizen_seq"
 * But we created just one entity/table for citizen then how come this "citizen_seq" table created? So,
 * The answer is this table is internally automatically created table created by hibernate. So, whenever
 * hibernate generate id in citizen table /entity then hibernate should know which particular id should be
 * assigned to the next entity whenever you create.
 * Example: If I am a first citizen getting into it. So, I should be given 1 as id which is automatically
 * generated. So, value will be got from "next_value" colum of citizen_seq table
 * Conclusion: Hibernate decides what value it should generate for id column from the value which is in "next_value" column onwards
 * Like if next_val column in citizen_seq table is having 1 as id value then the next value will be 1 onward like 2.
 * */