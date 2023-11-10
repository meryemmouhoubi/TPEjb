package dao;

import entities.User;
import jakarta.ejb.Local;

@Local
public interface UserIDAO extends IdaoLocal<User> {

}
