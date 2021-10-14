package org.ismailbenhallam.dao;

import org.ismailbenhallam.models.User;

public interface UserRepository {
    User findById(String id);
}