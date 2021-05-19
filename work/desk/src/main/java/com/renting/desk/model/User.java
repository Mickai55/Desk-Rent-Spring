package com.renting.desk.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.validation.constraints.Email;
import java.io.File;
import java.util.Collection;

@Document(collection = "users_test")
@Getter @Setter @NoArgsConstructor
public class User implements UserDetails {
    @Id
    private Long _id;
    @Field
    @Indexed(unique = true)
    private String username;
    @Field
    private String password;
    @Field
    @Email(message = "Not a valid e-mail")
    private String email;
    @Field
    private String phone;
    @Field
    private String location;
    @Field
    private String website_link;
    @Field
    private long request_count;
    @Field
    private String photo;
    @Field
    private UserType userType;

    @Transient    //to prevent it from serializing to persist in the table
    public static final String SEQUENCE_NAME = "users_sequence";

    public User(String username, String password, UserType userType) {
        this.username = username;
        this.password = password;
        this.userType = userType;
    }


    @Override
    @JsonIgnore
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    @JsonIgnore
    public boolean isAccountNonExpired() {
        return true;
    }
    @Override
    @JsonIgnore
    public boolean isAccountNonLocked() {
        return true;
    }
    @Override
    @JsonIgnore
    public boolean isCredentialsNonExpired() {
        return true;
    }
    @Override
    @JsonIgnore
    public boolean isEnabled() {
        return true;
    }

}
