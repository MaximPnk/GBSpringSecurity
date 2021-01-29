package ru.pankov.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.pankov.entity.Role;

@Repository
public interface RoleRepository extends CrudRepository<Role, Long> {
}
