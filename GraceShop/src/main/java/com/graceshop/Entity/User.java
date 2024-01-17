package com.graceshop.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {
@Id
//@GeneratedValue(strategy=GenerationType.AUTO)
private String userId;
@Column(name="user_name")
private String name;
@Column(name="user_email")
private String email;
@Column(name="user_password")
private String password;
}
