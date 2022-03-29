package dat.startcode.persistence;

import dat.startcode.entities.User;
import dat.startcode.exceptions.DatabaseException;

public interface IUserMapper
{
    public User login(String email, String kodeord) throws DatabaseException;
    public User createUser(String username, String password, String role) throws DatabaseException;
}
