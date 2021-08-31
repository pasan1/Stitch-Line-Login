package com.stitchline.api.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.Date;

@Document("user")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @Field(name = "user_id")
    private long user_id;

    @Field(name = "first_name")
    @Indexed(unique = true)
    @NotBlank(message = "First Name is mandatory")
    private String first_name;

    @Field(name = "last_name")
    @Indexed(unique = true)
    @NotBlank(message = "Last Name is mandatory")
    private String last_name;

    @Field(name = "email")
    @Indexed(unique = true)
    @NotBlank(message = "Email is mandatory")
    @Email(message = "Not valid email")
    private String email;

    @Field(name = "avatar")
    private String avatar;

    @Field(name = "register_date")
    @Indexed(unique = true)
    @NotBlank(message = "Register Date is mandatory")
    private Date register_date;

    @Field(name = "active_state")
    @Indexed(unique = true)
    @NotBlank(message = "Active State is mandatory")
    private String active_state;

    @Field(name = "special")
    private ArrayList<Object> special = new ArrayList<>();
}
