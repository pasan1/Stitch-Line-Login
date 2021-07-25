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

@Document("user")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    private String id;

    @Field(name = "name")
    @Indexed(unique = true)
    @NotBlank(message = "Name is mandatory")
    private String name;

    @Field(name = "email")
    @Indexed(unique = true)
    @NotBlank(message = "Email is mandatory")
    @Email(message = "Not valid email")
    private String email;

    @Field(name = "mobile")
    @Indexed(unique = true)
    @NotBlank(message = "Mobile is mandatory")
    private String mobile;

    @Field(name = "userName")
    @Indexed(unique = true)
    @NotBlank(message = "UserName is mandatory")
    private String userName;

    @Field(name = "password")
    @Indexed(unique = true)
    @NotBlank(message = "Password is mandatory")
    private String password;

    @Field(name = "role")
    @Indexed(unique = true)
    @NotBlank(message = "Role is mandatory")
    private String role;

    @Field(name = "data")
    @Indexed(unique = true)
//    @NotBlank(message = "Data is mandatory")
    private ArrayList data = new ArrayList();
}
