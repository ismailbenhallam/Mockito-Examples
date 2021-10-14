package org.ismailbenhallam.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class User {
    private String id;
    private String passwordHash;
    private boolean enabled;
}