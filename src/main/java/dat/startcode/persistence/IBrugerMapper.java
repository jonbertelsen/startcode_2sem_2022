package dat.startcode.persistence;

import dat.startcode.entities.Bruger;
import dat.startcode.exceptions.DatabaseException;

public interface IBrugerMapper
{
    public Bruger login(String email, String kodeord) throws DatabaseException;
    public Bruger opretBruger(String email, String kodeord, String rolle) throws DatabaseException;
}
